package com.example.scheduleparser;


import com.example.scheduleparser.enums.*;
import com.example.scheduleparser.enums.ScheduleDocument;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;




@Data
public class ScheduleDownloader {

    static String SCHEDULE_URL = "https://www.mirea.ru/schedule/";

    public static Map<Institute, Element> parseInstituteCards(Element element) {
        Map<Institute, Element> res = new HashMap<>();

        String[] institutesNames = Arrays.stream(Institute.values())
                .map(Institute::getName)
                .toArray(String[]::new);

        Elements institutesCards = element.select("li > div > div > .uk-card.slider_ads.uk-card-body.uk-card-small > .uk-grid-small");

        for (Element card : institutesCards) {
            for (String instituteName : institutesNames) {
                if (card.text().contains(instituteName)) {
                    Institute institute = Institute.getByName(instituteName);
                    res.put(institute, card);
                    break;
                }
            }
        }
        return res;
    }

    public static List<String> getDocumentLinks(Element element, Course course) {
        List<String> documentLinks = new ArrayList<>();
        Elements scheduleTitles = element.select("b.uk-h3");
        for (Element title : scheduleTitles) {
            Elements allDivs = title.parent().parent().select("div");

            for (int i = 0; i < allDivs.size(); i++) {
                Element div = allDivs.get(i);


                for (int j = i + 1; j < allDivs.size(); j++) {
                    Element nextDiv = allDivs.get(j);

                    if (nextDiv.hasClass("uk-h3")) {
                        break;
                    }

                    Element document = nextDiv.select("a.uk-link-toggle").first();

                    if (document != null && !documentLinks.contains(document.attr("href"))) {
                        documentLinks.add(document.attr("href"));
                        System.out.println(document.attr("href"));
                    }
                }
            }
        }

        return documentLinks;
    }




    public static List<ScheduleDocument> getLinks(Degree degree, Institute institute, Course course) throws IOException {


        Document doc = Jsoup.connect(SCHEDULE_URL).get();
        Element scheduleTabs = doc.select("div#tabs").first();
        Element tabsContent = scheduleTabs.select("ul#tab-content").first();

        List<ScheduleDocument> scheduleDocuments = new ArrayList<>();
        ScheduleDocument scheduleDocument = new ScheduleDocument();
        scheduleDocument.setCourse(course);
        scheduleDocument.setInstitute(institute);
        scheduleDocument.setDegree(degree);
        
        List<Element> tabs = selectTabs(degree, tabsContent);

        Map<Institute, Element> allInstituteCards = parseAllInstituteCards(tabs);

        filterInstituteCards(allInstituteCards, institute);
        List<String> documentLinks = new ArrayList<>();

        for (Map.Entry<Institute, Element> entry : allInstituteCards.entrySet()) {
            Element instituteCard = entry.getValue();
            List<String> links = getDocumentLinks(instituteCard, course);
            documentLinks.addAll(links);
        }




        return scheduleDocuments;
    }


    private static List<Element> selectTabs(Degree degree, Element tabsContent) {
        if (degree != null) {
            return tabsContent.select("li").subList(degree.getValue() - 1, degree.getValue());
        } else {
            return tabsContent.select("li").subList(0, 4);
        }
    }

    private static Map<Institute, Element> parseAllInstituteCards(List<Element> tabs) {
        Map<Institute, Element> allInstituteCards = new HashMap<>();
        for (Element tab : tabs) {
            Map<Institute, Element> instituteCards = parseInstituteCards(tab);
            allInstituteCards.putAll(instituteCards);
        }
        return allInstituteCards;
    }

    private static void filterInstituteCards(Map<Institute, Element> allInstituteCards, Institute institute) {
        if (institute != null) {
            allInstituteCards.entrySet().removeIf(entry -> !entry.getKey().equals(institute));
        }
    }


    public static void main(String[] args) throws IOException {
        List<ScheduleDocument> liContents = getLinks(Degree.BACHELOR, Institute.IIT, Course.COURSE_1);
    }

}



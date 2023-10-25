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



/*
    private final Institute institute;
    private final ScheduleType scheduleType;
    private final Degree degree;
    private final Period period;
    private final String url;
 */


@Data
public class ScheduleDownloader {

    static String SCHEDULE_URL = "https://www.mirea.ru/schedule/";

    public static Map<Institute, Element> parseInstituteCards(Element element, Degree degree) {
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

    public static Set<ScheduleDocument> getAllLinks() throws IOException {
        Set<ScheduleDocument> links = new HashSet<>();


        Document doc = Jsoup.connect(SCHEDULE_URL).get();

        Element scheduleTabs = doc.select("div#tabs").first();
        Element tabsContent = scheduleTabs.select("ul#tab-content").first();

        List<Element> tabs = tabsContent.select("li").subList(0, 4);

        for (Element tab : tabs) {
            String tabText = tab.text();
            Degree degree=Degree.BACHELOR;
            Map<Institute, Element> instituteCards = parseInstituteCards(tab, degree);
        }

        return links;
    }

    public static void main(String[] args) throws IOException {
        Set<ScheduleDocument> liContents = getAllLinks();

    }

}



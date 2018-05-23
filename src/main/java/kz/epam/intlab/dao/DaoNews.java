package kz.epam.intlab.dao;

import kz.epam.intlab.instance.News;

import java.util.Date;

public class DaoNews implements DaoService {

    private static News news;

    static {
        news = new News();
        news.setTitle("Hawaii emergency declared over volcano eruption");
        news.setDate(news.getDate());
        news.setBrief("Mount Kilauea volcano has erupted near a residential area on Hawaii's largest island, prompting a local state of emergency and the mandatory evacuation of 1,700 residents.");
        news.setContent("Extremely high levels of dangerous sulphur dioxide gas have been detected in the evacuation area, the Civil Defense Agency tweeted.\n" +
                "\n" +
                "Community centres have been opened to provide shelter.\n" +
                "\n" +
                "The eruption follows a series of strong earthquakes over recent days.\n" +
                "\n" +
                "A volcanic crater vent - known as Puu Oo - collapsed earlier this week, sending lava down the mountain's slopes towards populated areas.\n" +
                "\n" +
                "Officials had been warning residents all week they should be prepared to evacuate as an eruption would give little warning.We were evacuated a couple of hours ago and we are now with friends. It's me, my daughter, her boyfriend, and their two children, who are six years old and 20 months old. We all got shoved in a car and off we went.\n" +
                "\n" +
                "Within about half an hour of the eruption, it went on social media, so me and my daughter went down to look at it. You could hear and feel the eruption a good half a mile away, and the closer you got, the more you could feel it.\n" +
                "\n" +
                "It was like when someone plays the bass really heavy, and you can feel the bass - you could really feel the power and the lava - the colour of the lava was unbelievable, and the sound was unbelievable. It sounds very explosive, like something really explosive is coming out of a little hole, it's spitting out as hard as it can. It's not so much what you hear, it's what you feel.");
    }

    @Override
    public News getNews() {
        return DaoNews.news;
    }

    @Override
    public void editNews(News newsBean) {
    }
}

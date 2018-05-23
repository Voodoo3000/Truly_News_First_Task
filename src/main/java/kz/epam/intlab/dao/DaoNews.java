package kz.epam.intlab.dao;

import kz.epam.intlab.instance.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoNews implements DaoService {

    private static Map<Integer, News> newsTitle = new HashMap<>();
    private static Map<Integer, Boolean> checkedBoxesMap = new HashMap<>();
    private static List<Integer> checkedBoxesList = new ArrayList<>();
    private static News newsOne, newsTwo, newsThree;

    static {
        newsOne = new News();
        newsOne.setId(0);
        newsOne.setTitle("Israel and Iran trade fire in most direct confrontation yet");
        newsOne.setBrief("In the most direct confrontation between Israel and Iran to date, the two regional enemies exchanged fire for hours during a volatile night in the Golan Heights.");
        newsOne.setContent("In the most direct confrontation between Israel and Iran to date, the two regional enemies exchanged fire for hours during a volatile night in the Golan Heights.\n" +
                "\n" +
                "The extended barrage of fire comes amid soaring tensions between Israel and Iran, two rivals battling for regional influence, and less than two days after the United States withdrew from the deal to curb Iran's nuclear program.\n" +
                "Israel said more than 20 rockets were launched by Iranian forces in Syria towards Israeli-claimed territory late Wednesday, often criss-crossing across the clear night skies. A number of those rockets were intercepted by Israel's Iron Dome aerial defense system, resulting in bright and sudden explosions.");
        newsTwo = new News();
        newsTwo.setId(1);
        newsTwo.setTitle("Malaysia's Mahathir set to become world's oldest leader");
        newsTwo.setBrief("Veteran Malaysian politician Mahathir Mohamad is set to become the world's oldest leader after a shock victory in the country's election, when he upended six decades of control by the ruling coalition.");
        newsTwo.setContent("Veteran Malaysian politician Mahathir Mohamad is set to become the world's oldest leader after a shock victory in the country's election, when he upended six decades of control by the ruling coalition.\n" +
                "\n" +
                "In his triumphant return to front line Malaysian politics, Prime Minister-elect Mahathir -- who also ruled the country from 1981 to 2003 -- pledged to form a new government quickly, following a momentous night in which scandal-plagued incumbent Najib Razak was soundly beaten at the polls by his former mentor.\n" +
                "Mahathir, who will become the world's oldest leader aged 92, set a challenge to Malaysia's constitutional ruler, King Muhammad V, who needs to rubber-stamp his appointment, to install him as the new leader by 5 p.m. (5 a.m. ET).\n" +
                "\"We hope that by 5 o'clock today, we will have a prime minister,\" he said at a press conference to mark his electoral victory.\n" +
                "Shortly before that deadline, his car, along with those of the leaders of his coalition partners, were seen entering the palace gates. However, it wasn't clear whether Mahathir was being sworn in.\n");
        newsThree = new News();
        newsThree.setId(2);
        newsThree.setTitle("President Trump welcomes 3 Americans freed by North Korea");
        newsThree.setBrief("Under an American flag and dark night sky, US President Donald Trump personally welcomed home three American detainees Thursday morning after they were released from North Korea.");
        newsThree.setContent("Under an American flag and dark night sky, US President Donald Trump personally welcomed home three American detainees Thursday morning after they were released from North Korea.\n" +
                "\n" +
                "The Americans -- Kim Dong Chul, Kim Hak-song and Kim Sang Duk, also known as Tony Kim -- were freed Wednesday while Secretary of State Mike Pompeo was on a visit to the North Korean capital of Pyongyang to discuss President Trump's upcoming summit with North Korean leader Kim Jong Un.\n" +
                "No family members or friends of the three freed Americans were on hand for their arrival in the early hours of Thursday due to protocol reasons, an official told CNN, adding the men had to first debrief intelligence officials before heading to their homes.\n" +
                "Speaking to the media on the tarmac at Joint Base Andrews Air Force Base, Kim Dong Chul said his release felt \"like a dream.\"\n" +
                "\"We are very, very happy,\" said Kim.");
    }

    @Override
    public Map<Integer, News> getAllNews() {
        newsTitle.put(newsOne.getId(), newsOne);
        newsTitle.put(newsTwo.getId(), newsTwo);
        newsTitle.put(newsThree.getId(), newsThree);
        return newsTitle;
    }

    @Override
    public News getNewsById(Integer id) {
        return newsTitle.get(id);
    }

    @Override
    public void addNews(News newsBean) {
        newsTitle.put(newsBean.getId(), newsBean);
    }

    @Override
    public void updateNews(News newsBean) {
        newsTitle.put(newsBean.getId() , newsBean);
    }

    @Override
    public void deleteNews(News newsBean) {
        newsTitle.remove(newsBean.getId(), newsBean);
    }

    public static Map<Integer, News> getNewsTitle() {
        return newsTitle;
    }

    public static void setNewsTitle(Map<Integer, News> newsTitle) {
        DaoNews.newsTitle = newsTitle;
    }

    public static Map<Integer, Boolean> getCheckedBoxesMap() {
        return checkedBoxesMap;
    }

    public static void setCheckedBoxesMap(Map<Integer, Boolean> checkedBoxesMap) {
        DaoNews.checkedBoxesMap = checkedBoxesMap;
    }

    public static List<Integer> getCheckedBoxesList() {
        return checkedBoxesList;
    }

    public static void setCheckedBoxesList(List<Integer> checkedBoxesList) {
        DaoNews.checkedBoxesList = checkedBoxesList;
    }
}

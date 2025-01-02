package wiseSaying;

import java.util.ArrayList;

public class WiseSayingRepository {
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>(); //창고
    private int lastId = 0;

    public WiseSaying findById(int targetId) {
        for(WiseSaying wiseSaying : wiseSayingList) {
            if(wiseSaying.getId() == targetid){
                return wiseSaying;
            }
        }

        return null; // 자바에서 null은 객체가 없음 의미
    }

    public WiseSaying add(String content, String author) {
        int id = ++lastId;
        WiseSaying wiseSaying = new WiseSaying(id,content,author);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }
    public ArrayList<WiseSaying> findAll() {
        return wiseSayingList;
    }
    public void remove(WiseSaying wiseSaying){
        wiseSayingList.remove(wiseSaying);
    }

    public void update(WiseSaying wiseSaying) {
        // 저장. -> ArrayList 사용 -> 메모리 저장
    }
}

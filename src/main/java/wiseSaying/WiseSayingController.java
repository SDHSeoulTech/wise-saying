package wiseSaying;

import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;
    private final Scanner scanner;

    public WiseSayingController(Scanner scanner){
        this.scanner = scanner;
        this.wiseSayingService = new WiseSayingService(new WiseSayingFileRepository());
    }

    // 자바 대전제 -> 같은 타입만 저장 가능.


    public void updateWiseSaying(int targetId) {

        WiseSaying wiseSaying = wiseSayingService.getItem(targetId);
        if(wiseSaying == null){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
            return;
        }
        System.out.println("명언(기존) : %s".formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String newContent = scanner.nextLine();
        System.out.println("명언(작가) : %s".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String newAuthor = scanner.nextLine();

        wiseSayingService.modify(wiseSaying, newContent, newAuthor);

        System.out.println("%d번 명언이 수정되었습니다".formatted(targetId));

    }

    public void deleteWiseSaying(int targetId) {

        WiseSaying wiseSaying = wiseSayingService.getItem(targetId);
        if(wiseSaying == null){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
            return;
        }
        wiseSayingService.remove(wiseSaying);
        System.out.println("%d번 명언이 삭제되었습니다.".formatted(targetId));
    }
//
    public void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        ArrayList<WiseSaying> wiseSayings = wiseSayingService.getItems();
        for(WiseSaying wiseSaying : wiseSayings.reversed()){
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getContent()));
        }
    }

    public void writeWiseSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어감

        System.out.print("작가 : ");
        String author = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다.

        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

//    // 함수 이름 지을 땐 동사
    public void makeTestData(String content, String author) {
        wiseSayingService.write("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니" );
        wiseSayingService.write("현재를 사랑하라", "작자미상");
    }
}

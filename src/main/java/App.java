import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private int lastId = 0;
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {

        add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니" );
        add("현재를 사랑하라", "작자미상");

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")){
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if(command.equals("등록")){
                writeWiseSaying();

            } else if(command.equals("목록")){
                printWiseSayingList();
            } else if(command.startsWith("삭제?id=")){
                // 삭제?id=1
                String strId = command.substring(6);
                int id = Integer.parseInt(strId);
                deleteWiseSaying(id);
                System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
            }
        }
    }

    private void deleteWiseSaying(int targetId) {

        for(WiseSaying wiseSaying : wiseSayingList) {
            if(wiseSaying.getId() == targetId){
                wiseSayingList.remove(wiseSaying);
                break;
            }
        }

    }

    private void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        for(WiseSaying wiseSaying : wiseSayingList.reversed()){
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getContent()));
        }
    }

    private void writeWiseSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어감

        System.out.print("작가 : ");
        String author = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다.

        add(content, author); // 1. 함수로 분리 -> 코드가 줄어든다. 가독성이 올라간다. 2. 재활용성(중복 제거)


        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
    }

    // 함수 이름 지을 땐 동사
    public void add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId,content,author);
        wiseSayingList.add(wiseSaying);
    }

}

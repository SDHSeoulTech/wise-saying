import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    // 클래스에서 함수들이 공유해야 하는 함수 -> 인스턴스 변수
    private int lastId = 0;
    private int wiseSayingSize = 0;
    private WiseSaying[] wiseSayingList = new WiseSaying[3];

    public void run() {

        Scanner scanner = new Scanner(System.in);

        add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니" );

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")){
                System.out.println("명언 앱을 종료합니다.");
                break;
            } else if(command.equals("등록")){

                System.out.print("명언 : ");
                String content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어감

                System.out.print("작가 : ");
                String author = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다.

                add(content, author); // 1. 함수로 분리 -> 코드가 줄어든다. 가독성이 올라간다. 2. 재활용성(중복 제거)


                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
            } else if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------------");

                for(int i = 0; i < wiseSayingSize; i++){
                    WiseSaying wiseSaying = wiseSayingList[i];
                    System.out.println("%d / %s / %s".formatted(wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getContent()));
                }

//                for(WiseSaying wiseSaying : wiseSayingList){
//                    System.out.println("%d / %s / %s".formatted(wiseSaying.id,wiseSaying.author,wiseSaying.content));
//                }


//                System.out.println("%d / %s / %s".formatted(wiseSaying.id,wiseSaying.author,wiseSaying.content));
//                for(int i = 2; i >= 0; i--){
//                    System.out.println("%d / %s / %s".formatted(i,authorList[i],contentList[i]));
//                }

            }
        }
    }

    // 함수 이름 지을 땐 동사
    public void add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId,content,author);
        wiseSayingList[wiseSayingSize++] = wiseSaying;
    }

}

class WiseSaying {
    private int id;
    private String content;
    private String author;

    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
}

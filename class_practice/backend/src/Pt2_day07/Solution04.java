package Pt2_day07;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Scanner;

public class Solution04 {
    public static void main(String[] args) {
        // 1. 파일 객체를 만든다
        File file = new File("actor.txt");
        // 1-1. 존재 여부를 검증해야한다
        // 1-2. 메서드를 쓴다
        // 1-3. 예외처리에 위탁한다
        try {
            if (file.createNewFile()) { // 파일이 있는데 다시 시도했을 경우
                System.out.println("파일 생성되었습니다");
            } else {
                System.out.println("이미 있는 파일");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 파일에 내용 기록하기
        String name = null;
        try (FileWriter fw = new FileWriter(file)) {
            // write를 할 때 '추가'가 아니라 덮어씌우기다
            try (Scanner sc = new Scanner(System.in)) {
                name = sc.nextLine();
            }
//            fw.write("김지원 배우");
//            fw.write('\n');
//            fw.write("박은빈 배우");
            fw.write("%s 배우".formatted(name));
            System.out.println("내용 기록 성공");
        } catch (IOException e) {
            e.printStackTrace();
        }



        // 3. 파일 다운로드
        String url = "https://openapi.naver.com/v1/search/image?query=%s&display=10&start=1&sort=sim".formatted(name);
        Path path = Path.of("%s.jpg".formatted(name));
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "plain/text")
                .header("X-Naver-Client-Id", "PtzglFQ2QQloQoYiuG_0")
                .header("X-Naver-Client-Secret", "bF1JjUlAQA")
                .build();
        String imageUrl = "";
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());;
            String body = response.body();
            System.out.println(body);
            imageUrl = body.split("link\":\"")[1].split("\",")[0].replace("\\", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpRequest imageRequest = HttpRequest.newBuilder().uri(URI.create(imageUrl)).build();
        try {
            HttpResponse<Path> response = client.send(imageRequest, HttpResponse.BodyHandlers.ofFile(path));
            System.out.println("저장 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

class Pager{
//  초기에 결정되는 값들은
//  전체 게시글 수
    long totalCount;
//  한 페이지당 보여지는 블럭수
    long blocksPerPage = 10;
//  페이지네비게이션에서 보여주는 블럭수
    long blocksNavigation;
//  현재 페이지 수
    long pageIndex;
//  예시에 나온 생성자 구현
    Pager(long totalCount){
        this.totalCount = totalCount;
    }
//  예시에 나오는 함수 구현 - 현재 페이지를 넣으면 화면이 표시된다.
    public String html(long pageIndex){
        this.pageIndex = pageIndex;
        StringBuilder sb = new StringBuilder();
        sb.append("<a href='#'>[처음]</a>");
        sb.append("<a href='#'>[이전]</a>\n");

//      현재 페이지를 기준으로 표시하기 시작할 페이지 수를 startP에 저장한다.
//      현재 페이지를 10으로 나눠 1이면 현재 페이지가 바로 처음 페이지가 된다. 예) 11, 21 -> 11, 21
//      10의 배수이면 자신의 10으로 나눈 몫보다 1 작은 값을 10에 곱하고 1을 더한다. 예) 10, 20 -> 1, 11
//      그외의 경우에는 현재 페이지를 10으로 나눈 몫에 10을 곱하고 1을 더한다. 예) 13, 28 -> 11, 21
        int startP = 0;
        if(pageIndex % 10 == 1){
            startP = (int) pageIndex;
        }else if(pageIndex % 10 == 0){
            startP = (10 * (int) (pageIndex / blocksPerPage)- 1) + 1;
        }else{
            startP = (10 * ((int) (pageIndex / blocksPerPage))) + 1;
        }
//      현재 페이지 수에 따라 10개가 표시되지 않을 수 있으니 totalCount 변수로 체크해준다.
        int max = (int) (totalCount / blocksPerPage) + 1;
        if(startP >= (10 * ((int) max / 10))+1){
            blocksNavigation = max - startP + 1;
        } else{
            blocksNavigation = 10;
        }
//      startP부터 blocksNavigation만큼 더해진 값까지 돌면서 페이지 수 추가
        for (int i = startP; i < startP + blocksNavigation; i++) {
//          현재 페이지인 경우 색깔을 다르게 표시한다.
            if(i == pageIndex){
                sb.append("<a href='#' class='on' style=color:#FF0000;>").append(i).append("</a>\n");
//          그외의 경우에는 번호만 표시한다.
            }else{
                sb.append("<a href='#'>").append(i).append("</a>\n");
            }
        }
        sb.append("<a href='#'>[다음]</a>\n");
        sb.append("<a href='#'>[마지막]</a>\n");

        return sb.toString();
    }

}

public class W6_Mission03 {
    public static void main(String[] args) throws IOException {
//      전체 게시글 totalCount로 설정, 현재 페이지 pageIndex로 설정
        long totalCount = 127;
        long pageIndex = 11;
//      클래스 사용해서 totalCount 넣고 생성
        Pager pager = new Pager(totalCount);
//      html 파일 만들어서 pager.html 메서드 결과를 가지고 파일에 추가한다.
        try{
            File file = new File("pageNavigation.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            String str = pager.html(pageIndex);
            writer.write(str);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

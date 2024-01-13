import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class W6_Mission01 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\Programming\\Java\\OwnHashSet\\property.html");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\"/>");
        writer.write("<style>");
        writer.write("table { border-collapse: collapse; width: 100%; }");
        writer.write("th, td {border:solid 1px #000;}");
        writer.write("</style>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h2>자바 환경정보</h2>");
        writer.write("<table>");
        writer.write("<th>키</th>");
        writer.write("<th/>");
//      자바 시스템 속성값
        for (Object k : System.getProperties().keySet()){
            String key = k.toString();
            String value = System.getProperty(key);
            try {
                writer.write("<tr><th>" + key + "</th>");
                writer.write("<td>" + value + "</td></tr>");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        writer.write("</table>");
        writer.write("</body>");
        writer.close();
    }
}

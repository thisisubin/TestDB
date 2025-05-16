import java.sql.*;
import java.util.Scanner;

public class TELDB {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        SQLConnection sqlConnection = new SQLConnection();
        while (true) {
            // mysql 연동된 상태에서
            // 사용자가 추가/삭제/전체출력/이름검색을 실행
            System.out.print("1. 추가 2. 삭제 3. 전체출력 4. 이름검색 : ");
            int num = sc.nextInt();
            if (num == 1) {
                //추가
                System.out.print("이름 : ");
                String name = sc.next();
                System.out.print("전화번호 : ");
                String telnumber = sc.next();
                sc.nextLine(); //이렇게 한줄 더 입력시켜줘야 숫자만 넣었을 telnumber후 주소입력이 올바르게 입력 된다.
                System.out.print("주소 : ");
                String address = sc.nextLine();
                //PreparedStatement는 sql을 실행하는 객체
                PreparedStatement ps = sqlConnection.getConnection().prepareStatement("insert into teltbl values(?,?,?);");
                ps.setString(1, name);
                ps.setString(2, telnumber);
                ps.setString(3, address);
                ps.executeUpdate();
            }
            else if (num == 2) {
                //삭제
                System.out.print("이름 : ");
                String name = sc.next();

                PreparedStatement ps = sqlConnection.getConnection().prepareStatement("delete from teltbl where name = ?;");
                ps.setString(1, name);
                int result = ps.executeUpdate(); //실행 결과를 result 변수에 넣어줘야 함
                if (result == 0) {
                    System.out.println("삭제할 이름이 없습니다.");
                } else {
                    System.out.println(name +"이 삭제 되었습니다.");
                }
            }
            else if (num == 3) {
                //전체 출력
                Statement stmt = sqlConnection.getConnection().createStatement();
                //resultset은 select 쿼리의 결과를 받아오는 객체
                ResultSet resultSet=stmt.executeQuery("select * from teltbl;");
                System.out.println("\t전화번호부");
                System.out.println("이름" + " " + "전화번호" + " " + "주소");
                boolean check = true;
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String tel = resultSet.getString("telnumber");
                    String address = resultSet.getString("address");
                    System.out.println(name + " " + tel + " " + address);
                    check = false;
                }
                if(check){
                    System.out.println("전화번호가 없습니다.");
                }
            }
            else if (num == 4) {
                //이름 검색
                System.out.print("이름 : ");
                String name = sc.next();

                PreparedStatement ps = sqlConnection.getConnection().prepareStatement("select * from teltbl where name = ?;");
                ps.setString(1, name);
                ResultSet resultSet= ps.executeQuery();

                boolean check = true;
                while (resultSet.next()) {
                    String name1 = resultSet.getString("name");
                    String tel = resultSet.getString("telnumber");
                    String address = resultSet.getString("address");
                    System.out.println(name1 + " " + tel + " " + address);
                    check = false;
                }
                if(check){
                    System.out.println("전화번호가 없습니다.");
                }

            }
            else if (num == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

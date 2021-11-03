import java.sql.*;

public class Main {
    public static void main(String[] args){
        Connection conn=null;
        String url="jdbc:sqlite:C:/Users/mille/IdeaProjects/sqlframads/TrainDb.sqlite";
        Statement stmt=null;
        ResultSet rs=null;
        String sql = "Select name from Station;";
        try {
            conn=DriverManager.getConnection(url);
            stmt=conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs!=null && rs.next()){
                String name = rs.getString(1);
                System.out.println(name);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e2){
                    System.out.println(e2.getMessage());
                }
            }
        }
    }
}

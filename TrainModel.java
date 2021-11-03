import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class TrainModel {
    Connection conn = null;
    String url = null;
    Statement stmt = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;

    TrainModel(String url){
        this.url=url;
    }

    public void connectToTrainData() throws SQLException{
        conn= DriverManager.getConnection(url);
    }

    public void closeTrainDataConnection() throws SQLException{
        if(conn!=null) {
            conn.close();
        }
    }

    public void createStatement() throws SQLException{
        this.stmt=conn.createStatement();
    }

    public ArrayList<String> SQLQueryStation() throws SQLException{
        ArrayList<String> stations=new ArrayList<>();
        String sql = "Select name from Station;";
        rs = stmt.executeQuery(sql);
        while(rs!=null && rs.next()){
            String name = rs.getString(1);
            System.out.println(name);
            stations.add(name);
        }
        return stations;
    }
    public void PstmtRetrieveDeparturesforStation() throws SQLException{
        System.out.println("which station do you wish to find depapartures for?");
        Scanner scanner = new Scanner(System.in);
        String departureStation = scanner.nextLine();
        System.out.println("What time do you wish to depart:");
        Float ft = scanner.nextFloat();
        String sql= "SELECT stationname, time FROM departure WHERE stationname = ? and time > ?;";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, departureStation);
        pstmt.setFloat(2, ft);
        rs=pstmt.executeQuery();
        while (rs!=null && rs.next()){
            System.out.println(rs.getString(1)+ " time:" + rs.getFloat(2));
        }
    }

}

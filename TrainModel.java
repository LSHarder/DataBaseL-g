import java.sql.*;
import java.util.ArrayList;

public class TrainModel {
    Connection conn = null;
    String url = null;
    Statement stmt = null;
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
}

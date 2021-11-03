import java.sql.*;

public class Main {
    public static void main(String[] args){

        String url="jdbc:sqlite:C:/Users/mille/IdeaProjects/sqlframads/TrainDb.sqlite";
        TrainModel TDB=new TrainModel(url);
        try {
            //conn=DriverManager.getConnection(url);
            TDB.connectToTrainData();
            //stmt=conn.createStatement();
            TDB.createStatement();
            //rs = stmt.executeQuery(sql);
            TDB.SQLQueryStation();
            //while(rs!=null && rs.next()){
            //    String name = rs.getString(1);
            //    System.out.println(name);
            //}
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            //if(conn!=null){
                try{
                    TDB.closeTrainDataConnection();
                }catch (SQLException e2){
                    System.out.println(e2.getMessage());
                }

        }
    }
}

import java.sql.*;
import java.sql.DriverManager;
public class NewClass {
    public class void main(String args[])
    {
        Connection conn=null;
        Statement stmt=null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to the database");
            conn=DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/My_movies","password");
            System.out.println("You're now connected to the database");
            
            System.out.println("Inserting data");
            stmt=conn.createStatement();
            
            String sql="INSERT INTO Movies " + 
                    "VALUES(\"MULAN\",\"Jet Li\",\"Liu Yifie\",2020,\"Niki Caro\"),(\"CINDERELLA\",\"Richard Madden\",\"Lily James\",2015,\"Kenneth Branagh\"),(\"BEAUTY AND THE BEAST\",\"Dan Stevens\",\"Emma Watson\",2017,\"Bill Condon\"),(\"ALADDIN\",\"Mena Massoud\",\"Naomi Scott\",2019,\"Guy Ritchie\"),(\"SHERLOCK HOLMES\",\"Robert Downey\",\"Rachel McAdams\",2009,\"Guy Ritchie\");";
            stmt.executeUpdate(sql);
            System.out.println("Data inserted");
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
                
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            } 
        }
    }
    
}

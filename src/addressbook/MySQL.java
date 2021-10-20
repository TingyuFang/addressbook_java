package addressbook;
import java.sql.*;

public class MySQL {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/addressbook?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    //set database user name and password
    static final String USER = "root";
    static final String PASSWORD = "123456";

    //regist JDBC driver or implements the java.sql.Driver interface
    public void loadDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception ex) {
            //handle the error
        }
    }
    //connect to addressbook datasbase
    public void connectDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to addressbook database successfully!");
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        }
    }

    //执行INSERT sql语句
    public int excuteInsertStmt(String statement) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to addressbook database successfully!");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        }

        // Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sqlStmt = new String();

        sqlStmt = "SELECT * FROM contacts;";
        sqlStmt = "INSERT INTO contacts (NAME, TELNUM, ADDRESS) VALUES ('" ;
        sqlStmt = sqlStmt + statement;
        try {
            stmt = conn.createStatement();
            stmt.execute(sqlStmt);
            // 展开结果集数据库
            // while(rs.next()){
            //     // 通过字段检索
            //     int id  = rs.getInt("id");
            //     String name = rs.getString("name");
            //     String telnum = rs.getString("telnum");
            //     String address = rs.getString("address");
    
            //     // 输出数据
            //     System.out.print("ID: " + id);
            //     System.out.print(", 姓名: " + name);
            //     System.out.print(", 电话: " + telnum);
            //     System.out.print(", 地址: " + address);
            //     System.out.print("\n");
            // }
        } catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        }
        finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {}

                rs = null;
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {}

                stmt = null;
            }
        }
        return 0;
    }
}


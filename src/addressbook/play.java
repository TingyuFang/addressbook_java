package addressbook;
public class play {
    public static void main(String[] args) {
        // display();
        MySQL mysql = new MySQL();
        Execute excute = new Execute();
        mysql.loadDriver();
        // mysql.connectDB();
        excute.executeLogic();
        // mysql.excuteInsertStmt("");
    }
}


import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.sql.*;
import java.util.ArrayList;

public class SQLQuerries {

    public void SQLRegister(Batadase b, String firstName, String lastName, String birthday, String email, String psw )
    {


        try
        {
            b.OpenConn();


        }
        catch( Exception e )
        {
            System.err.println("Some exception when trying to register user with email:" +email +"\n"+ e.getMessage());
        }
        finally
        {
            b.CloseConn();
        }
    }

    public Boolean SQLogin(Batadase b, String email, String Password)
    {
        String sql = "SELECT COUNT(*) FROM IB_DB.Persons WHERE email = ?;";
        Boolean result = false;
        try
        {
            b.OpenConn();
            PreparedStatement pstmt = b.conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                if (rs.getInt(1) == 1)
                {
                    result = true;
                }
                else
                {
                    return false;
                }

            }
        }
        catch( Exception e )
        {
            System.err.println("Some exception when trying to login user:" +p.getFirst_Name() +"\n"+ e.getMessage());
        }
        finally
        {
            b.CloseConn();
        }
// ------------------------------------------------------------------------------------------------------------------
      if(result)
      {
          Person p;
          String sql2 = "SELECT * FROM IB_DB.Person WHERE email = ?";
          int i = 0;
          try
          {
              b.OpenConn();
              PreparedStatement pstmt = b.conn.prepareStatement(sql);
              pstmt.setString(1, email);
              ResultSet rs = pstmt.executeQuery();

              while(rs.next())
              {
                p = new Person(rs.getInt("id_account"), rs.getString("user_type"),
                        rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("birth_date"), rs.getString("email"), rs.getString("password"),
                        rs.getInt("account_number"), rs.getDouble("balance"), rs.getString("start_date"),
                        rs.getString("status"));
              }
              if(p.getPsw().equals(Password))
              {
                  return true;
              }
          }
          catch( Exception e )
          {
              System.err.println("Some exception when trying to login user:" +p.getFirst_Name() +"\n"+ e.getMessage());
          }
          finally
          {
              b.CloseConn();
          }
      }

    }


    public void SQLTransfer(Person p, Batadase b)
    {
        try
        {
            b.OpenConn();
        }
        catch( Exception e )
        {
            System.err.println("Some exception when " +p.getFirst_Name() +" was trying to make a transfer:\n"+ e.getMessage());
        }
        finally
        {
            b.CloseConn();
        }
    }

    public void SQLTakeLoan(Person p, Batadase b)
    {
        try
        {
            b.OpenConn();
        }
        catch( Exception e )
        {
            System.err.println("Some exception when user " +p.getFirst_Name() +" was trying to take a loan:\n"+ e.getMessage());
        }
        finally
        {
            b.CloseConn();
        }
    }

    public void SQLPayLoan(Person p, Batadase b, Loan l)
    {
        try
        {
            b.OpenConn();
        }
        catch( Exception e )
        {
            System.err.println("Some exception when user: " +p.getFirst_Name() +" was trying to pay the loan with" +
                    " ID: "+l.getIDTransaction()+"\n"+ e.getMessage());
        }
        finally
        {
            b.CloseConn();
        }
    }

    public void SQLExtract(Person p, Batadase b)
    {
        try
        {
            b.OpenConn();
        }
        catch( Exception e )
        {
            System.err.println("Some exception when trying to extract transfers of user: " +p.getFirst_Name() +"\n"+ e.getMessage());
        }
        finally
        {
            b.CloseConn();
        }
    }
}

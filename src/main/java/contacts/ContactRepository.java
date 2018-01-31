package contacts;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 *demo
 *
 *@author w24164
 *@create 2018-01-31 15:25
 */
@Repository
public class ContactRepository {
    private JdbcTemplate jdbc;
    @Autowired
    public ContactRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    public List<Contact> findAll(){
        return jdbc.query(
                "select id,firstname,lastname,phoneNumber,emailAddress" +
                        "form contacts order by lastname",
                new RowMapper<Contact>() {
                    @Override
                    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Contact contact =  new Contact();
                        contact.setId(rs.getLong(1));
                        contact.setFirstname(rs.getString(2));
                        contact.setLastname(rs.getString(3));
                        contact.setPhoneNumber(rs.getString(4));
                        contact.setEmailAddress(rs.getString(5));
                        return contact;
                    }
                });
    }

    public void save(Contact contact){
        jdbc.update(
                "insert into contacts"+
                        "(fistname,lastname,phoneNumber,emailAddress)"+
                        "values(?,?,?,?)",
                contact.getFirstname(),contact.getLastname(),
                contact.getPhoneNumber(),contact.getEmailAddress());
    }
}

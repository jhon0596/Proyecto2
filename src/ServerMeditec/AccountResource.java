package ServerMeditec;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;


@Path("/accounts")
public class AccountResource {
      Parser dao = new Parser();
      public AccountResource() {
      }
      @GET
      @Produces(MediaType.APPLICATION_XML)
      public List<Account> getAccounts() {
            return dao.getAccounts();
      }
      @GET
      @Path("{id}")
      @Produces(MediaType.APPLICATION_XML)
      public Account getAccount(@PathParam(value="id")  int id){
            return dao.get(id);
      }
      @Path("{account}/transaction")
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      @POST
      public int putTransaction(@PathParam(value="account") int account,
                                BankingTransaction aTrans){
    	  BankingTransactionDao txnDao = BankingTransactionDao.getInstance();
          return txnDao.putTransaction(account, aTrans);
      }
 
}

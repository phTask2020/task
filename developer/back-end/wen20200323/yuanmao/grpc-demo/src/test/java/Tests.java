import com.reuben.rpc.client.AccountClient;
import com.reuben.rpc.client.BaseClient;
import com.reuben.rpc.client.GreeterClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;

@Slf4j
public class Tests {
    private BaseClient client = new BaseClient("localhost", 50051);

    private GreeterClient greeterClient = new GreeterClient(client);

    private AccountClient accountClient = new AccountClient(client);

    @After
    public void after() {
        try {
            client.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void test_Greet() {
        log.info("===============GreeterClient============");
        // GreeterClient greeterClient = new GreeterClient(client);
        greeterClient.greet("Hello");
    }

    @Test
    public void test_addAccount() {
        log.info("===============AccountClient============");
        //AccountClient accountClient = new AccountClient(client);

        log.info("===============新增============");
        accountClient.addAccount("reuben", "男", 22);
    }

    @Test
    public void test_queryAccount() {
        log.info("===============AccountClient============");
        //AccountClient accountClient = new AccountClient(client);

        log.info("===============查找============");
        accountClient.queryAccount("张三");
    }

}

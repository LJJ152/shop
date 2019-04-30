package top.ljjapp.shoporder;

import com.yiqiniu.easytrans.EnableEasyTransaction;
import com.yiqiniu.easytrans.util.CallWrapUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import top.ljjapp.api.WalletPayMoneyService;
import top.ljjapp.api.WalletPayRequestCfg;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableEasyTransaction
@EnableTransactionManagement
public class ShopOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopOrderApplication.class, args);
    }

    @Bean
    public WalletPayMoneyService payService(CallWrapUtil util) {
        return util.createTransactionCallInstance(WalletPayMoneyService.class, WalletPayRequestCfg.class);
    }
}

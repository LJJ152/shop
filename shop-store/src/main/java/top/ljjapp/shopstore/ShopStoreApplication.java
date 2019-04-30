package top.ljjapp.shopstore;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(SpringCloudSecondaryConfiguration.class)
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class }) // 使用文件存储时, 不需要配置mongodb
public class ShopStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopStoreApplication.class, args);
    }

}

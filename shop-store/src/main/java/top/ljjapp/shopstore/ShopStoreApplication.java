package top.ljjapp.shopstore;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@Import(SpringCloudSecondaryConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class}) // 使用文件存储时, 不需要配置mongodb
public class ShopStoreApplication {

    private static BeanFactory beanFactory;
    public static void main(String[] args) {
        SpringApplication.run(ShopStoreApplication.class, args);
    }
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory = factory;
    }
}

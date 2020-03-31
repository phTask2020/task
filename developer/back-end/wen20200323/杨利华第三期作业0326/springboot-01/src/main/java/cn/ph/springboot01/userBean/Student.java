package cn.ph.springboot01.userBean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author 22356
 * @Date 2020/3/18 14:14
 */

/**
 *
 *第一种赋值方式@ConfigurationProperties（默认从全局配置文件中获取值）:告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "Person"：配置文件中对应的所有属性一一映射
 *
 * 只有这个组件是容器中的组件，容器才能提供@ConfigurationProperties功能
 *@Component 把当前组件添加到容器中
 *
 * 第二种赋值方式@Value 赋值需要一个一个赋值  支持#{SpEl}spring表达式语言 不支持复杂类型封装（map，list等）
 *
 * 第三种赋值方式@PropertySource(value={"classpath:person.properties"})加载指定配置文件内容
 *要与@ConfigurationProperties配合使用
 * prefix = "person"要与对象名一致
 */
@Component
@PropertySource(value={"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")//第一种赋值方式批量注入（推介使用）
@Entity
@Table(name="student")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Student {
    /**
     * spring容器赋值方式
     * <bean class="Person">
     *     <property name="name" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEl}spring表达式语言"></property>
     * </bean>
     */
//    @Value("${Person.id}") //需要和application.yml配置文件内一致
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private int id;
//    @Value("${Person.name}")
    private String name;
//    @Value("${Person.sex}")
    private String gender;
//    @Value("${Person.birth}")
//    private Date birth;
//    //@Value("${Person.maps.ke}")//不支持复杂类型封装
//    private Map<String,Object> maps;
//    //@Value("${Person.lists}")
//    private List<Object> lists;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

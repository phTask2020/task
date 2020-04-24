package com.reuben.springboot_demo.util;

import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import com.reuben.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @program: springboot_demo
 * @description:
 * @author: reuben
 * @create: 2020-03-31 10:02
 **/
@Slf4j
/**@Transactional
 * redis不支持回滚*/
public class RedisUtilTests extends SpringbootDemoApplicationTests {
    @Autowired
    private RedisUtil redisUtil = new RedisUtil();

    static String test = "test";
    static long expire = 10000;

    @Test
    public void expire() {
        boolean expire = redisUtil.expire(test, RedisUtilTests.expire);
        Assert.assertTrue(expire);
    }

    @Test
    public void getExpire() {
        long expire = redisUtil.getExpire(test);
        log.info(String.valueOf(expire));
    }

    @Test
    public void existHashKey() {
        boolean hash = redisUtil.existHashKey("hash2");
        Assert.assertTrue(hash);

    }

    @Test
    public void del() {
        redisUtil.del(test);
    }

    @Test
    public void get() {
        Object o = redisUtil.get("a");
        log.info(o.toString());
    }

    @Test
    public void set() {
        boolean set = redisUtil.set(test, test);
        Assert.assertTrue(set);

    }

    @Test
    public void setWithTime() {
        boolean set = redisUtil.set(test, test, expire);
        Assert.assertTrue(set);
    }

/*    @Test
    public void increase() {
        Integer delta = 2;
        long increase = redisUtil.increase("list", delta);
        log.info(String.valueOf(increase));

    }*/

/*    @Test
    public void decrease() {
        Integer delta = 2;
        long decrease = redisUtil.decrease("list", delta);
        log.info(String.valueOf(decrease));
    }*/

    @Test
    public void getHash() {
        Object hash2 = redisUtil.getHash("hash2", "d");
        log.info(hash2.toString());
    }

    @Test
    public void getAllHashKey() {
        Map<Object, Object> hash2 = redisUtil.getAllHashKey("hash2");
        Set<Map.Entry<Object, Object>> entries = hash2.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            log.info(entry.getKey().toString() + ":" + entry.getValue().toString());
        }
    }

    @Test
    public void setHash() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "reuben");
        map.put("password", "123456");
        map.put("gender", "男");
        boolean hash = redisUtil.set("hash", map);
        Assert.assertTrue(hash);
    }

    @Test
    public void setHashWithTime() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "reuben");
        map.put("password", "123456");
        map.put("gender", "男");
        boolean hash = redisUtil.set("hash", map, expire);
        Assert.assertTrue(hash);
    }

    @Test
    public void setHashValue() {
        boolean b = redisUtil.setHashValue("hash2", "Hobby", "none");
        Assert.assertTrue(b);
    }

    @Test
    public void setHashValueWithTime() {
        boolean b = redisUtil.setHashValue("hash2", "Hobby2", "none2", expire);
        Assert.assertTrue(b);
    }

    @Test
    public void delHashItem() {
        redisUtil.delHashItem("hash2", "a", "b");
    }

    @Test
    public void existHashItem() {
        boolean flag = redisUtil.existHashItem("hash2", "Hobby");
        Assert.assertTrue(flag);
    }

    @Test
    public void hashIncrease() {
        double v = redisUtil.hashIncrease("hash2", "c", 2);
        log.info(String.valueOf(v));
    }

    @Test
    public void hashDecrease() {
        double v = redisUtil.hashDecrease("hash2", "d", 2);
        log.info(String.valueOf(v));
    }

    @Test
    public void getSet() {
        Set<Object> set = redisUtil.getSet("set");
        for (Object o : set) {
            log.info(o.toString());
        }
    }

    @Test
    public void existSetValue() {
        boolean b = redisUtil.existSetValue("set", "a");
        Assert.assertTrue(b);
    }

    @Test
    public void setSet() {
        long set = redisUtil.setSet("set", "a", "b", "c");
        log.info(String.valueOf(set));
    }

    @Test
    public void setSetWithTime() {
        long set = redisUtil.setSetWithTime("set", 10000, "a", "b", "c");
        log.info(String.valueOf(set));
    }

    @Test
    public void getSetSize() {
        long setSize = redisUtil.getSetSize("set");
        log.info(String.valueOf(setSize));
    }

    @Test
    public void removeSetValues() {
        long removeSetValues = redisUtil.removeSetValues("set", "a");
        log.info(String.valueOf(removeSetValues));
    }

    @Test
    public void getList() {
        List<Object> list = redisUtil.getList("list", 1, 4);
        log.info(list.toString());
    }

    @Test
    public void getListSize() {
        long listSize = redisUtil.getListSize("list");
        log.info(String.valueOf(listSize));

    }

    @Test
    public void getListByIndex() {
        Object list = redisUtil.getListByIndex("list", 2);
        log.info(list.toString());
    }

    @Test
    public void setList() {
        boolean flag = redisUtil.setList("list", "a");
        Assert.assertTrue(flag);
    }

    @Test
    public void setListWithTime() {
        boolean flag = redisUtil.setList("list", "a", expire);
        Assert.assertTrue(flag);
    }

    @Test
    public void setListByList() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        boolean list2 = redisUtil.setList("list2", strings);
        Assert.assertTrue(list2);
    }

    @Test
    public void setListByListWithTime() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        boolean list2 = redisUtil.setList("list2", strings, expire);
        Assert.assertTrue(list2);
    }

    @Test
    public void updateListByIndex() {
        boolean list = redisUtil.updateListByIndex("list", 6, "66");
        Assert.assertTrue(list);
    }

    @Test
    public void removeListValues() {
        long l = redisUtil.removeListValues("list", 2, "e");
        log.info(String.valueOf(l));
    }
}

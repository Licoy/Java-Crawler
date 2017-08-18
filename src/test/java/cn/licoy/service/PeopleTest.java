package cn.licoy.service;

import org.junit.Test;

/**
 * @author licoy.cn
 * @version 1.0 /
 */
public class PeopleTest {
    @Test
    public void run() throws Exception {
        new People("C:\\Users\\Administrator\\Desktop\\name2.txt",
                "C:\\Users\\Administrator\\Desktop\\poi.xlsx").run();
    }

}
package cn.licoy.thread;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

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
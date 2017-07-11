package main.test;

import main.dao.FilmDao;
import main.service.FilmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Tony on 2017/7/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FilmTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private FilmService filmService;
    @Test
    public void getAllTypeTest(){
        FilmService filmService=new FilmService();
        Set<String> types=filmService.getAllTypes();
        for (String s:types){
            System.out.println(s);
        }
    }
}

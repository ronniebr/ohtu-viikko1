/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ronniebr
 */
public class StatisticsTest {
     Statistics stats;
     Reader readerStub = new Reader() {
 
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
        
        
        @Override
        public int extractInt(String str) {
        return Integer.parseInt(str.trim());
    }
    };
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void hakutesti() {
     stats = new Statistics(readerStub);
     assertEquals("Kurri", stats.search("Kurri").getName());
     
     }
     @Test
     public void teamtesti(){
     stats = new Statistics(readerStub);
     assertEquals("Semenko",stats.team("EDM").get(0).getName());
     assertEquals("Kurri",stats.team("EDM").get(1).getName());
     assertEquals("Gretzky",stats.team("EDM").get(2).getName());
     }
          @Test
     public void topScoretesti(){
     stats = new Statistics(readerStub);
     assertEquals("Gretzky",stats.topScorers(3).get(0).getName());
     assertEquals("Lemieux",stats.topScorers(3).get(1).getName());
     assertEquals("Yzerman",stats.topScorers(3).get(2).getName());
     }
          @Test
          public void etsiOlematonta(){
              stats = new Statistics(readerStub);
              assertEquals(null,stats.search("eioo"));
          }
}
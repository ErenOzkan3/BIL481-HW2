import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { 
    c = new Util(); 
  }

  @Test
  public void example() { 
    assertTrue(true); 
  }

  @Test
  public void testForParameterWithOneElement(){
    assertEquals(false, c.compute(-1));
  }

  @Test
  public void testForParametersWithMultiplesOfTwo(){
    assertEquals(false, c.compute(1, 2));
    assertEquals(false, c.compute(1, 2, 3, 4));
    assertEquals(false, c.compute(1, 2, -2, -1));
    assertEquals(false, c.compute(1, 2, -2, -1, 17, 84, 369, 440));
  }

  @Test
  public void testForValidParameters(){
    assertEquals(true, c.compute(1, 2, -4));
  }

  @Test(expected = RuntimeException.class)
  public void testForThrowedException(){
    c.compute(0,1,2);
  }

  @Test
  public void testForComputation(){
    assertEquals(false, c.compute(3, 5, 9));
  }
}
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testForEmptyMq() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    
    when(mq.size()).thenReturn(0);

    assertEquals(-1 ,c.countNumberOfOccurrences("SLKDGHSLKJGHSDLJKGH"));
    assertEquals(-1 ,c.countNumberOfOccurrences("Test"));
    assertEquals(-1 ,c.countNumberOfOccurrences(""));
  }

  @Test
  public void testForMqDoesntContainGivenString(){
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    
    when(mq.size()).thenReturn(2);
    when(mq.contains(anyString())).thenReturn(false);

    assertEquals(0 ,c.countNumberOfOccurrences("SLKDGHSLKJGHSDLJKGH"));
    assertEquals(0 ,c.countNumberOfOccurrences("Test"));
    assertEquals(0 ,c.countNumberOfOccurrences(""));
  }

  @Test
  public void testForMqContainGivenString(){
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    
    when(mq.size()).thenReturn(2);


    when(mq.contains("SLKDGHSLKJGHSDLJKGH")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("SLKDGHSLKJGHSDLJKGH");

    when(mq.contains("Test")).thenReturn(true);
    when(mq.getAt(1)).thenReturn("Test");

    assertEquals(1 ,c.countNumberOfOccurrences("SLKDGHSLKJGHSDLJKGH"));
    assertEquals(1 ,c.countNumberOfOccurrences("Test"));
  }

  @Test
  public void testForMultipleContainsInMq(){
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    
    when(mq.size()).thenReturn(4);

    when(mq.contains("SLKDGHSLKJGHSDLJKGH")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("SLKDGHSLKJGHSDLJKGH");
    when(mq.getAt(1)).thenReturn("SLKDGHSLKJGHSDLJKGH");
    when(mq.getAt(2)).thenReturn("SLKDGHSLKJGHSDLJKGH");

    when(mq.contains("Test")).thenReturn(true);
    when(mq.getAt(3)).thenReturn("Test");

    
    when(mq.contains("aksjfasklfj")).thenReturn(false);

    assertEquals(3, c.countNumberOfOccurrences("SLKDGHSLKJGHSDLJKGH"));
    assertEquals(1, c.countNumberOfOccurrences("Test"));
    assertEquals(0, c.countNumberOfOccurrences("aksjfasklfj"));
  }
}
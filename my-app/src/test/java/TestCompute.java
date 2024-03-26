import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
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
    
    verify(mq, times(3)).size();
  }

}
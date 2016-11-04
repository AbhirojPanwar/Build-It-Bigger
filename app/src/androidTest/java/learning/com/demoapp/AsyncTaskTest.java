package learning.com.demoapp;

import android.test.AndroidTestCase;
import android.test.mock.MockContext;

import org.mockito.Mock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AsyncTaskTest extends AndroidTestCase {

    EndpointsAsyncTask task;
    String result;
    CountDownLatch signal=null;
    @Mock
    MockContext mockContext=new MockContext();


    @Override
    protected void setUp() throws Exception {
        signal=new CountDownLatch(1);
    }

    @Override
    public void tearDown() throws Exception{
        signal.countDown();
    }

    public void testAsyncReturnType() throws InterruptedException {

        try {

            //Default timeout for the GCM server is 20 seconds
            //If the .get can't get the result in 10 seconds, something is wrong anyway
            //Greater than 20 seconds results in an error string returned and requires further interpretation
            task=new EndpointsAsyncTask(){

                @Override
                protected void onPostExecute(String result) {
                  //Leave Empty
                }
            };
            task.execute((Runnable) mockContext);
            signal.await();
            result = task.get(30, TimeUnit.SECONDS);
            assertFalse(result==null);
            assertNotNull(result);

        } catch (Exception e) {
            fail("Timed out");
        }
    }
}
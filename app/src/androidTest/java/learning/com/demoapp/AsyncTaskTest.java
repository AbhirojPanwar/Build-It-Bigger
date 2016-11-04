package learning.com.demoapp;

import android.test.AndroidTestCase;
import android.util.Log;

public class AsyncTaskTest extends AndroidTestCase {

    EndpointsAsyncTask task=null;
    String result=null;

    public void setUp()
    {
        task=new EndpointsAsyncTask(getContext()){
            @Override
            protected void onPostExecute(String result) {
                // Leave Empty
            }
        };

    }


    public void testAsyncReturnType(){
        task.execute();
        try{
            result=task.get();
            Log.d("Non-Empty String Test","String = "+result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
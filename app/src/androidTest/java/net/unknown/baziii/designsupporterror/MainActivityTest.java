package net.unknown.baziii.designsupporterror;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by baziii on 15/6/18.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
  MainActivity activity;
  public MainActivityTest() {
    super(MainActivity.class);
  }
  public MainActivityTest(Class<MainActivity> activityClass) {
    super(activityClass);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    activity=getActivity();
  }
  @SmallTest


  public void testInput() throws Throwable{

    final String tmp = "1234567890";

    CountDownLatch countDownLatch = new CountDownLatch(2);
    try {
      for (int x=1;x<tmp.length();x++) {
        final int index=x;
        runTestOnUiThread(new Runnable() {
          @Override public void run() {
            activity.editText.setText(tmp.substring(0,index));
          }
        });
        countDownLatch.await(1, TimeUnit.SECONDS);
      }
    } catch (Throwable throwable) {

    }
  }
}

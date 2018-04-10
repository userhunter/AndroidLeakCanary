package example.pacewear.com.appname;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private  static final String TAG = "MainActivity";
    public final static int DO_WORK = 1;

    private Button mClick;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == DO_WORK) {
                //do something
            }
            return false;
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClick = (Button)findViewById(R.id.button_test);
        mClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
                mHandler.sendEmptyMessage(DO_WORK);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "btnHandler", Toast.LENGTH_SHORT).show();
                    }
                }, 15 * 1000);
            }
        });

        Log.d(TAG,"get the main Activity");
    }
}

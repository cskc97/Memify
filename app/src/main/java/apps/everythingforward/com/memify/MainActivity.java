package apps.everythingforward.com.memify;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<String>> {
    private ArrayList<String> mImageUri;
    private TextView dispImageUrl;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, MyIntentService.class);
//        startService(intent);
//        BroadcastReceiver receiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String imageUrl = intent.getStringExtra("ImageUrl");
//                Log.i(TAG,"Image URL = "+ imageUrl);
//                dispImageUrl = (TextView)findViewById(R.id.image_url);
//                dispImageUrl.setText(imageUrl);
//                Toast.makeText(context,"Broadcast Intent detected", Toast.LENGTH_SHORT).show();
//            }
//        };
//        LocalBroadcastManager.getInstance(this)
//                .registerReceiver(receiver, new IntentFilter("myBroadcastIntent"));

                    dispImageUrl = (TextView)findViewById(R.id.image_url);
        getLoaderManager().initLoader(0, null, this);


    }


    @Override
    public Loader<ArrayList<String>> onCreateLoader(int i, Bundle bundle) {
        return new MemesLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<String>> loader, ArrayList<String> strings) {
        mImageUri = strings;
        dispImageUrl.setText(mImageUri.get(0));

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<String>> loader) {
        dispImageUrl.setText("");
    }
}


package apps.everythingforward.com.memify;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by admin on 3/14/2017.
 */

public class MyIntentService extends IntentService {
    public ArrayList<String> mMemes;
    public static final String TAG = MyIntentService.class.getSimpleName();
    public MyIntentService(){
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        String response = HttpRequest.get("https://api.imgflip.com/get_memes").body();
        Log.i(TAG," Response: "+ response);
        mMemes = Utils.extractUrls(response);
    }
    private void sendBroadcast(){
        Intent intent = new Intent("MyBroadcastIntent");
        intent.setAction(" apps.everythingforward.com.memify");
        intent.putExtra("ImageUrl", mMemes.get(0));
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }


    @Override
    public String toString() {
        return "MyIntentService{" +
                "mMemes=" + mMemes +
                '}';
    }
}

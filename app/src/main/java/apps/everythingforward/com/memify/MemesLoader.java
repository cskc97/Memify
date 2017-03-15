package apps.everythingforward.com.memify;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by admin on 3/15/2017.
 */

public class MemesLoader extends android.content.AsyncTaskLoader {
    public static final String TAG = MemesLoader.class.getSimpleName();
    private ArrayList<String> mMemes;
    public MemesLoader(Context context){
        super(context);
    }
    @Override
    public ArrayList<String> loadInBackground() {
        try {
            String response = HttpRequest.get("https://api.imgflip.com/get_memes").body();
            Log.i(TAG, " Response: " + response);
            mMemes = new ArrayList<>();
            mMemes = Utils.extractUrls(response);
            return mMemes;
        }catch (HttpRequest.HttpRequestException e){
            e.printStackTrace();
            return null;
        }
    }
}

package apps.everythingforward.com.memify;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by admin on 3/15/2017.
 */

public final class Utils {
    static String response;
    public static ArrayList<String> extractUrls(String response){
        ArrayList<String> imageUrls = new ArrayList<>();
        try {
            JSONObject rootObject = new JSONObject(response);
            JSONObject jsonData = rootObject.getJSONObject("data");
            JSONArray memesArray = jsonData.getJSONArray("memes");
            for (int i=0; i<memesArray.length(); i++){
                JSONObject jsonObject = memesArray.getJSONObject(i);
                String url = jsonObject.optString("url");
                imageUrls.add(i,url);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return imageUrls;
    }
}

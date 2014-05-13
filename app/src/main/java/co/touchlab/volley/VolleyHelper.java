package co.touchlab.volley;

import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;

import org.json.JSONObject;

/**
 * Created by Nakhimovich on 5/12/14.
 */
public class VolleyHelper {
    private static VolleyHelper ourInstance = new VolleyHelper();
    private static final String TAG = "volley.VolleyHelper";
    private String limit="1";

    public static VolleyHelper getInstance() {
        return ourInstance;
    }

    private VolleyHelper() {
    }

    public RequestFuture<JSONObject> makeRequest() {

        Log.d(TAG, "Making Future Network Call");
        RequestFuture<JSONObject> future = RequestFuture.newFuture();

        JSONObject params = new JSONObject();
//        try {
//         //   params.put("limit","1");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        String URL = "";
        URL = "http://www.reddit.com/.json?limit="+limit;
        if(limit.equals("1")) limit="2";else limit="1";
        //Disable caching
        MyVolley.getRequestQueue().getCache().clear();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, params, future, future);


        jsObjRequest.setShouldCache(false);
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(15000, 1, 1));

        MyVolley.getRequestQueue().add(jsObjRequest);
        try {
            Log.d(TAG, "Done Queuing Network Call");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return future;
    }
}

package co.touchlab.volley;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created with IntelliJ IDEA.
 * User: miken
 * Date: 5/24/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class JSONCache {
    private static Context context = null;

    public static void init(Context context) {
        if (JSONCache.context == null) {
            JSONCache.context = context;
        }
    }
    public static String loadData(String prefName, String key) {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return prefs.getString(key, null);
    }
    public static void saveData(String prefName, String key, String json ) {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(prefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString(key, json);
        ed.commit();
    }
    public static void deleteAllData(String prefName) {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(prefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.clear();
        ed.commit();
    }
    public static void deleteDataByKey(String prefName, String key) {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(prefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.remove(key);
        ed.commit();
    }
    public static boolean dataExists(String prefName, String key) {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return prefs.getAll().containsKey(key);
    }
}

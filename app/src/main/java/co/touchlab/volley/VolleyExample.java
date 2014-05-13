package co.touchlab.volley;

import android.app.Application;

/**
 * Created with IntelliJ IDEA.
 * User: miken
 * Date: 12/12/13
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class VolleyExample extends Application {
    public static String preferenceName = "DriverMobile";

    @Override
    public void onCreate() {
    super.onCreate();

    init();
}


    private void init() {
        MyVolley.init(this);
    }
}
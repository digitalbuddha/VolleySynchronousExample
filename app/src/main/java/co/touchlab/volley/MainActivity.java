package co.touchlab.volley;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    private VolleyHelper helper;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = VolleyHelper.getInstance();
        textView = (TextView) findViewById(R.id.label);
        new HttpRequestTask().execute();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            new HttpRequestTask().execute();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class HttpRequestTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                //every time request gets made, the number of results alternates between 1 & 2
                //calling get() on the future blocks the thread until volley puts a response into the future.
                //alternatively we can have 3 response objects, make all 3 calls  and only AFTER
                // makeRequest is called 3 times, call get() on each of the future objects, .
                 JSONObject response = helper.makeRequest().get();
                 response = helper.makeRequest().get();
                 response = helper.makeRequest().get();
                Log.d("MainActivity", "Done making Network Call(s)");
                return response.getString("data");


            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }


            protected void onPostExecute (String response){
                textView.setText(response);
            }
        }
    }

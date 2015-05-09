package photofall.wanderlust.buckbeak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Login extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.loginButton).setOnClickListener(this);
    }


    @Override
    public void onClick(View arg0) {
        Button b = (Button) findViewById(R.id.loginButton);
        login();
    }

    private void login(){
        EditText nameBox = (EditText)findViewById(R.id.login);
        EditText passBox = (EditText)findViewById(R.id.password);
        String name = nameBox.getText().toString();
        String pass = passBox.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("pass",pass);
        startActivity(intent);
    }
}
    /*

##########code below is being used to test restful api requests.##############

    private class LongRunningGetIO extends AsyncTask<Void, Void, String> {

        protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
            InputStream in = entity.getContent();
            StringBuffer out = new StringBuffer();
            int n = 1;
            while (n>0) {
                byte[] b = new byte[4096];
                n =  in.read(b);
                if (n>0) out.append(new String(b, 0, n));
            }
            return out.toString();
        }


        @Override
        protected String doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpGet httpGet = new HttpGet("http://www.cheesejedi.com/rest_services/get_big_cheese.php?puzzle=1");
            String text = null;
            try {
                HttpResponse response = httpClient.execute(httpGet, localContext);
                HttpEntity entity = response.getEntity();
                text = getASCIIContentFromEntity(entity);
            } catch (Exception e) {
                return e.getLocalizedMessage();
            }
            return text;
        }


        protected void onPostExecute(String results) {
            if (results!=null) {
                EditText et = (EditText)findViewById(R.id.editTextTest);
                et.setText(results);
            }
            Button b = (Button)findViewById(R.id.loginButton);
            b.setClickable(true);
        }
    }
}
    */
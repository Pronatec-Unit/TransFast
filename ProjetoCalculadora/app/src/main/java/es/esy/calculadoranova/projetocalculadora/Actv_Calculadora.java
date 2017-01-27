package es.esy.calculadoranova.projetocalculadora;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class Actv_Calculadora extends AppCompatActivity {


    TextView textView;
    String currentString = "0", previusString = null;
    boolean isTempStringShown = false;
    int currentopperand = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actv__calculadora);
        textView = (TextView) findViewById(R.id.textView);
        int numberButtons[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        NumberButtonClickListener numberClickListener = new NumberButtonClickListener();
        for (int id : numberButtons) {
            View v = findViewById(id);
            v.setOnClickListener(numberClickListener);
        }
        int opperandButtons[] = {R.id.buttonPlus, R.id.buttonMinus, R.id.buttonDivide, R.id.buttonTimes, R.id.buttonDecimal, R.id.buttonClear, R.id.buttonEquals};
        OpperandButtonClickListener oppClickListener = new OpperandButtonClickListener();
        for (int id : opperandButtons) {
            View v = findViewById(id);
            v.setOnClickListener(oppClickListener);
        }
        setCurrentString("0");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    void setCurrentString(String s) {
        currentString = s;
        textView.setText(s);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Actv_Calculadora Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://es.esy.calculadoranova.projetocalculadora/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Actv_Calculadora Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://es.esy.calculadoranova.projetocalculadora/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    class NumberButtonClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            if (isTempStringShown) {
                previusString = currentString;
                currentString = "0";
                isTempStringShown = false;
            }
            String text = (String) ((Button) v).getText();
            if (currentString.equals("0")) setCurrentString(text);
            else setCurrentString(currentString + text);
        }
    }

    class OpperandButtonClickListener implements OnClickListener {
        @Override


        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.buttonClear) {
                isTempStringShown = false;
                setCurrentString("0");
                previusString = null;
            }
            if (id == R.id.buttonDecimal)
                if (!currentString.contains(".")) setCurrentString(currentString + ".");
            if (id == R.id.buttonPlus || id == R.id.buttonMinus || id == R.id.buttonTimes || id == R.id.buttonDivide) {
                currentopperand = id;
                previusString = currentString;
                isTempStringShown = true;
            }
            if (id == R.id.buttonEquals) {
                double curr = Double.parseDouble(currentString);
                double result = 0;
                if (previusString != null) {
                    double prev = Double.parseDouble(previusString);
                    switch (currentopperand) {
                        case R.id.buttonPlus:
                            result = prev + curr;
                            break;
                        case R.id.buttonMinus:
                            result = prev - curr;
                            break;
                        case R.id.buttonTimes:
                            result = prev * curr;
                            break;
                        case R.id.buttonDivide:
                            result = prev / curr;
                            break;
                    }
                }
                setCurrentString(Double.toString(result));
            }
        }
    }
}

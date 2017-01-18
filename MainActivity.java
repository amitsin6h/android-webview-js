package com.amitsin6h.javascript;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    WebView webView;
   // EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        webView = (WebView) findViewById(R.id.webView);


        class WebAppInterface {
           public  Context webtext;

            /** Instantiate the interface and set the context */
            WebAppInterface(Context c) {
                webtext = c;
            }

            /** Show a toast from the web page */
            @JavascriptInterface
            public void showToast(String toast) {
            
            
                Toast.makeText(webtext, toast, Toast.LENGTH_SHORT).show();
            }
        }


        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://amitsin6h.github.io/android-webview-js/");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // String msgToSend = editText.getText().toString();
                Toast.makeText(, "webtext", Toast.LENGTH_SHORT).show(); //want to load webtext data here

            }
        });






    }
}

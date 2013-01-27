package com.mrcaps.mremm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebSettings.ZoomDensity;
import android.widget.EditText;

public class MainView extends Activity {
    private Handler handl = new Handler();
    private WebView webview;
    
    //http://code.google.com/p/apps-for-android/source/browse/trunk/Samples/WebViewDemo/src/com/google/android/webviewdemo/WebViewDemo.java?r=171
    
    private static final String HOME_URL = "file:///android_asset/mremm/index.html";
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        webview = (WebView) findViewById(R.id.webview);
        
        WebSettings settings = webview.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDefaultZoom(ZoomDensity.CLOSE);
        
        //font size changing
        settings.setDefaultFontSize(18);

        //webview.setWebChromeClient(new MyWebChromeClient());

        //webview.addJavascriptInterface(new DemoJavaScriptInterface(), "demo");

        webview.loadUrl(HOME_URL);
    }
    
    public static final int MNU_BACK = 1;
    public static final int MNU_HOME = 2;
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MNU_BACK:
			webview.goBack();
			return true;
		case MNU_HOME:
			webview.loadUrl(HOME_URL);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MNU_BACK, 0, "Back")
			.setIcon(R.drawable.ic_menu_back);
		menu.add(0, MNU_HOME, 1, "Home")
			.setIcon(R.drawable.ic_menu_home);		
		return super.onCreateOptionsMenu(menu);
	}
}
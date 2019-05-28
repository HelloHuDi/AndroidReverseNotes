package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.internal.CustomTab;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomTabMainActivity extends Activity {
    public static final String EXTRA_CHROME_PACKAGE = (CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage");
    public static final String EXTRA_PARAMS = (CustomTabMainActivity.class.getSimpleName() + ".extra_params");
    public static final String EXTRA_URL = (CustomTabMainActivity.class.getSimpleName() + ".extra_url");
    private static final String OAUTH_DIALOG = "oauth";
    public static final String REFRESH_ACTION = (CustomTabMainActivity.class.getSimpleName() + ".action_refresh");
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(96587);
        AppMethodBeat.o(96587);
    }

    public static final String getRedirectUrl() {
        AppMethodBeat.i(96582);
        String str = "fb" + FacebookSdk.getApplicationId() + "://authorize";
        AppMethodBeat.o(96582);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(96583);
        super.onCreate(bundle);
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            AppMethodBeat.o(96583);
            return;
        }
        if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            new CustomTab(OAUTH_DIALOG, bundleExtra).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.shouldCloseCustomTab = false;
            this.redirectReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(96581);
                    Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                    intent2.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity.this.startActivity(intent2);
                    AppMethodBeat.o(96581);
                }
            };
            d.S(this).a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
        AppMethodBeat.o(96583);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(96584);
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            d.S(this).c(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
            AppMethodBeat.o(96584);
            return;
        }
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
        AppMethodBeat.o(96584);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.i(96585);
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
        AppMethodBeat.o(96585);
    }

    private void sendResult(int i, Intent intent) {
        AppMethodBeat.i(96586);
        d.S(this).unregisterReceiver(this.redirectReceiver);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
        AppMethodBeat.o(96586);
    }
}

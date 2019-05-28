package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p057v4.content.C37116d;
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

    /* renamed from: com.facebook.CustomTabMainActivity$1 */
    class C319931 extends BroadcastReceiver {
        C319931() {
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(96581);
            Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
            intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
            intent2.addFlags(603979776);
            CustomTabMainActivity.this.startActivity(intent2);
            AppMethodBeat.m2505o(96581);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(96587);
        AppMethodBeat.m2505o(96587);
    }

    public static final String getRedirectUrl() {
        AppMethodBeat.m2504i(96582);
        String str = "fb" + FacebookSdk.getApplicationId() + "://authorize";
        AppMethodBeat.m2505o(96582);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(96583);
        super.onCreate(bundle);
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(96583);
            return;
        }
        if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            new CustomTab(OAUTH_DIALOG, bundleExtra).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.shouldCloseCustomTab = false;
            this.redirectReceiver = new C319931();
            C37116d.m62125S(this).mo59171a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
        AppMethodBeat.m2505o(96583);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(96584);
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            C37116d.m62125S(this).mo59172c(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
            AppMethodBeat.m2505o(96584);
            return;
        }
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
        AppMethodBeat.m2505o(96584);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.m2504i(96585);
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
        AppMethodBeat.m2505o(96585);
    }

    private void sendResult(int i, Intent intent) {
        AppMethodBeat.m2504i(96586);
        C37116d.m62125S(this).unregisterReceiver(this.redirectReceiver);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
        AppMethodBeat.m2505o(96586);
    }
}

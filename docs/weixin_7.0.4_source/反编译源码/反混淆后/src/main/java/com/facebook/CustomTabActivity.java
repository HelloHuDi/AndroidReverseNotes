package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p057v4.content.C37116d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION = (CustomTabActivity.class.getSimpleName() + ".action_customTabRedirect");
    private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    public static final String DESTROY_ACTION = (CustomTabActivity.class.getSimpleName() + ".action_destroy");
    private BroadcastReceiver closeReceiver;

    /* renamed from: com.facebook.CustomTabActivity$1 */
    class C319921 extends BroadcastReceiver {
        C319921() {
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(96576);
            CustomTabActivity.this.finish();
            AppMethodBeat.m2505o(96576);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(96580);
        AppMethodBeat.m2505o(96580);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(96577);
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
        AppMethodBeat.m2505o(96577);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(96578);
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            C37116d.m62125S(this).mo59172c(intent2);
            this.closeReceiver = new C319921();
            C37116d.m62125S(this).mo59171a(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
        }
        AppMethodBeat.m2505o(96578);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(96579);
        C37116d.m62125S(this).unregisterReceiver(this.closeReceiver);
        super.onDestroy();
        AppMethodBeat.m2505o(96579);
    }
}

package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI */
public final class AppBrand404PageUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI$2 */
    class C197482 implements OnMenuItemClickListener {
        C197482() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(132883);
            AppBrand404PageUI.this.finish();
            AppMethodBeat.m2505o(132883);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    private static void m65226a(String str, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.m2504i(132884);
        final Intent putExtra = new Intent(C4996ah.getContext(), AppBrand404PageUI.class).putExtra("key_wording", str).putExtra("key_icon_url", null);
        if (activityStarterIpcDelegate != null) {
            if (putExtra != null) {
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("intent", putExtra);
                activityStarterIpcDelegate.bRc.send(4660, bundle);
            }
            AppMethodBeat.m2505o(132884);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132882);
                putExtra.addFlags(268435456);
                C4996ah.getContext().startActivity(putExtra);
                AppMethodBeat.m2505o(132882);
            }
        });
        AppMethodBeat.m2505o(132884);
    }

    public static void show(int i) {
        AppMethodBeat.m2504i(132885);
        AppBrand404PageUI.m65226a(C4996ah.getContext().getString(i), null);
        AppMethodBeat.m2505o(132885);
    }

    /* renamed from: a */
    public static void m65225a(ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.m2504i(132886);
        AppBrand404PageUI.m65226a(C4996ah.getContext().getString(C25738R.string.f8957kq), activityStarterIpcDelegate);
        AppMethodBeat.m2505o(132886);
    }

    public final int getLayoutId() {
        return 2130968653;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(132887);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f8888i_);
        setBackBtn(new C197482());
        TextView textView = (TextView) findViewById(2131821110);
        String stringExtra = getIntent().getStringExtra("key_wording");
        C5046bo.isNullOrNil(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
        AppMethodBeat.m2505o(132887);
    }

    public final void finish() {
        AppMethodBeat.m2504i(132888);
        super.finish();
        AppMethodBeat.m2505o(132888);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(132889);
        super.onDestroy();
        AppMethodBeat.m2505o(132889);
    }
}

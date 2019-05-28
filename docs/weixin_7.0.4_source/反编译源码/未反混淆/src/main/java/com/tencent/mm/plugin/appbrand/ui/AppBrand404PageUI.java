package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public final class AppBrand404PageUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    private static void a(String str, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(132884);
        final Intent putExtra = new Intent(ah.getContext(), AppBrand404PageUI.class).putExtra("key_wording", str).putExtra("key_icon_url", null);
        if (activityStarterIpcDelegate != null) {
            if (putExtra != null) {
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("intent", putExtra);
                activityStarterIpcDelegate.bRc.send(4660, bundle);
            }
            AppMethodBeat.o(132884);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132882);
                putExtra.addFlags(268435456);
                ah.getContext().startActivity(putExtra);
                AppMethodBeat.o(132882);
            }
        });
        AppMethodBeat.o(132884);
    }

    public static void show(int i) {
        AppMethodBeat.i(132885);
        a(ah.getContext().getString(i), null);
        AppMethodBeat.o(132885);
    }

    public static void a(ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(132886);
        a(ah.getContext().getString(R.string.kq), activityStarterIpcDelegate);
        AppMethodBeat.o(132886);
    }

    public final int getLayoutId() {
        return R.layout.bd;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(132887);
        super.onCreate(bundle);
        setMMTitle((int) R.string.i_);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(132883);
                AppBrand404PageUI.this.finish();
                AppMethodBeat.o(132883);
                return true;
            }
        });
        TextView textView = (TextView) findViewById(R.id.ol);
        String stringExtra = getIntent().getStringExtra("key_wording");
        bo.isNullOrNil(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
        AppMethodBeat.o(132887);
    }

    public final void finish() {
        AppMethodBeat.i(132888);
        super.finish();
        AppMethodBeat.o(132888);
    }

    public final void onDestroy() {
        AppMethodBeat.i(132889);
        super.onDestroy();
        AppMethodBeat.o(132889);
    }
}

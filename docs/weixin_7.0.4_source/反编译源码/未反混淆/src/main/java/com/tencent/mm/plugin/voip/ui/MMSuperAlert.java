package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class MMSuperAlert extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(4783);
        super.onCreate(bundle);
        setContentView(R.layout.ago);
        final int intExtra = getIntent().getIntExtra("MMSuperAlert_msg", 0);
        final int intExtra2 = getIntent().getIntExtra("MMSuperAlert_title", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4782);
                h.a(MMSuperAlert.this, intExtra == 0 ? "" : MMSuperAlert.this.getString(intExtra), intExtra2 == 0 ? "" : MMSuperAlert.this.getString(intExtra2), booleanExtra, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(4780);
                        MMSuperAlert.this.finish();
                        AppMethodBeat.o(4780);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(4781);
                        MMSuperAlert.this.finish();
                        AppMethodBeat.o(4781);
                    }
                });
                AppMethodBeat.o(4782);
            }
        }, 50);
        AppMethodBeat.o(4783);
    }

    public static void X(Context context, int i) {
        AppMethodBeat.i(4784);
        Intent intent = new Intent(context, MMSuperAlert.class);
        intent.putExtra("MMSuperAlert_title", R.string.tz);
        intent.putExtra("MMSuperAlert_msg", i);
        intent.putExtra("MMSuperAlert_cancelable", false);
        context.startActivity(intent);
        AppMethodBeat.o(4784);
    }

    public Resources getResources() {
        AppMethodBeat.i(4785);
        Resources resources;
        if (getAssets() == null || ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.o(4785);
            return resources;
        }
        resources = ah.getResources();
        AppMethodBeat.o(4785);
        return resources;
    }
}

package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.ttpic.util.ActUtil;

public class AlertActivity extends AppCompatActivity {
    private static a vkm;
    private OnDismissListener cMR;
    private OnCancelListener yes;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112442);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(17170445));
        }
        if (vkm != null) {
            vkm.mContext = this;
            this.cMR = vkm.zQe.Uf;
            this.yes = vkm.zQe.Ue;
            vkm.a(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(112440);
                    if (AlertActivity.this.cMR != null) {
                        AlertActivity.this.cMR.onDismiss(dialogInterface);
                    }
                    AlertActivity.this.finish();
                    AppMethodBeat.o(112440);
                }
            });
            vkm.f(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(112441);
                    if (AlertActivity.this.yes != null) {
                        AlertActivity.this.yes.onCancel(dialogInterface);
                    }
                    AlertActivity.this.finish();
                    AppMethodBeat.o(112441);
                }
            });
            vkm.aMb().show();
        }
        AppMethodBeat.o(112442);
    }

    public static void a(a aVar) {
        vkm = aVar;
    }

    public void onPause() {
        AppMethodBeat.i(112443);
        overridePendingTransition(0, 0);
        super.onPause();
        AppMethodBeat.o(112443);
    }

    public void onDestroy() {
        AppMethodBeat.i(112444);
        super.onDestroy();
        vkm = null;
        AppMethodBeat.o(112444);
    }
}

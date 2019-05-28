package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

public class NoRomSpaceDexUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29832);
        super.onCreate(bundle);
        aa.initLanguage(ah.getContext());
        setContentView(R.layout.aiy);
        String string = getString(R.string.ap_);
        o oVar = new o(this);
        oVar.setTitle((int) R.string.apa);
        oVar.ykW.setVisibility(0);
        oVar.ykU.setVisibility(0);
        oVar.ykU.setText(string);
        string = getString(R.string.ap8);
        AnonymousClass1 anonymousClass1 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29831);
                Process.killProcess(Process.myPid());
                AppMethodBeat.o(29831);
            }
        };
        if (oVar.tJz != null) {
            oVar.tJz.setVisibility(0);
            oVar.tJz.setText(string);
            oVar.tJz.setOnClickListener(new com.tencent.mm.ui.o.AnonymousClass1(anonymousClass1));
        }
        oVar.setCancelable(false);
        oVar.dxP();
        oVar.show();
        AppMethodBeat.o(29832);
    }
}

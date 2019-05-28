package com.tencent.p177mm.p612ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5519o.C55171;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.ui.NoRomSpaceDexUI */
public class NoRomSpaceDexUI extends Activity {

    /* renamed from: com.tencent.mm.ui.NoRomSpaceDexUI$1 */
    class C52091 implements OnClickListener {
        C52091() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29831);
            Process.killProcess(Process.myPid());
            AppMethodBeat.m2505o(29831);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29832);
        super.onCreate(bundle);
        C4988aa.initLanguage(C4996ah.getContext());
        setContentView(2130970306);
        String string = getString(C25738R.string.ap_);
        C5519o c5519o = new C5519o(this);
        c5519o.setTitle((int) C25738R.string.apa);
        c5519o.ykW.setVisibility(0);
        c5519o.ykU.setVisibility(0);
        c5519o.ykU.setText(string);
        string = getString(C25738R.string.ap8);
        C52091 c52091 = new C52091();
        if (c5519o.tJz != null) {
            c5519o.tJz.setVisibility(0);
            c5519o.tJz.setText(string);
            c5519o.tJz.setOnClickListener(new C55171(c52091));
        }
        c5519o.setCancelable(false);
        c5519o.dxP();
        c5519o.show();
        AppMethodBeat.m2505o(29832);
    }
}

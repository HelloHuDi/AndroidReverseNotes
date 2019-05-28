package com.tencent.p177mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.model.app.w */
public final class C46495w implements C14887t {
    C1207m cwn;
    public Context mContext;
    public C44275p tipDialog;
    public C23248a vcm;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.w$a */
    public interface C23248a {
        void arL();
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.app.w$1 */
    public class C440601 implements OnCancelListener {
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(79364);
            C4990ab.m7420w("MicroMsg.LoadAppInfoAfterLogin", "do init canceled");
            C1720g.m3540Rg().mo14547c(C46495w.this.cwn);
            C34832a.bYM().mo27203b(7, C46495w.this);
            if (C46495w.this.vcm != null) {
                C46495w.this.vcm.arL();
            }
            AppMethodBeat.m2505o(79364);
        }
    }

    public C46495w(Context context, C23248a c23248a) {
        this.mContext = context;
        this.vcm = c23248a;
    }

    /* renamed from: a */
    public final void mo9876a(int i, int i2, String str, C40442x c40442x) {
        AppMethodBeat.m2504i(79365);
        C4990ab.m7417i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        C34832a.bYM().mo27203b(7, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.vcm != null) {
            this.vcm.arL();
        }
        C35799p.dhI();
        AppMethodBeat.m2505o(79365);
    }
}

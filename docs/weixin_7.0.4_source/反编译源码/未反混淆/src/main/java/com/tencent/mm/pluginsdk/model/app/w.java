package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

public final class w implements t {
    m cwn;
    public Context mContext;
    public p tipDialog;
    public a vcm;

    public interface a {
        void arL();
    }

    public w(Context context, a aVar) {
        this.mContext = context;
        this.vcm = aVar;
    }

    public final void a(int i, int i2, String str, x xVar) {
        AppMethodBeat.i(79365);
        ab.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        com.tencent.mm.plugin.s.a.bYM().b(7, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.vcm != null) {
            this.vcm.arL();
        }
        p.dhI();
        AppMethodBeat.o(79365);
    }
}

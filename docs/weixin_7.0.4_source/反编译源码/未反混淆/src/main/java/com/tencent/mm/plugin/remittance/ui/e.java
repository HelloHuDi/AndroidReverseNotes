package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.lang.ref.WeakReference;

public final class e {
    WeakReference<Context> bSI;

    static class a {
        static e pSh = new e();

        static {
            AppMethodBeat.i(44864);
            AppMethodBeat.o(44864);
        }
    }

    public static synchronized e cfP() {
        e eVar;
        synchronized (e.class) {
            eVar = a.pSh;
        }
        return eVar;
    }

    public final void eL(Context context) {
        AppMethodBeat.i(44865);
        this.bSI = new WeakReference(context);
        AppMethodBeat.o(44865);
    }

    public final c a(String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(44866);
        ab.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert1() msg:%s, title:%s, yes:%s, no:%s", bo.nullAsNil(str), bo.nullAsNil(str2), bo.nullAsNil(str3), bo.nullAsNil(str4));
        Context context = (Context) this.bSI.get();
        if (context == null) {
            ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(44866);
            return null;
        }
        c d = h.d(context, str, str2, str3, str4, onClickListener, onClickListener2);
        AppMethodBeat.o(44866);
        return d;
    }

    public final c a(String str, OnClickListener onClickListener) {
        AppMethodBeat.i(44867);
        ab.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert2() msg:%s, title:%s", bo.nullAsNil(str), bo.nullAsNil(null));
        Context context = (Context) this.bSI.get();
        if (context == null) {
            ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(44867);
            return null;
        }
        c a = h.a(context, str, null, false, onClickListener);
        AppMethodBeat.o(44867);
        return a;
    }
}

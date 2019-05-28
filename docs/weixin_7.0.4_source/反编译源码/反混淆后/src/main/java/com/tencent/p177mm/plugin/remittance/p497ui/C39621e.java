package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.remittance.ui.e */
public final class C39621e {
    WeakReference<Context> bSI;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.e$a */
    static class C34825a {
        static C39621e pSh = new C39621e();

        static {
            AppMethodBeat.m2504i(44864);
            AppMethodBeat.m2505o(44864);
        }
    }

    public static synchronized C39621e cfP() {
        C39621e c39621e;
        synchronized (C39621e.class) {
            c39621e = C34825a.pSh;
        }
        return c39621e;
    }

    /* renamed from: eL */
    public final void mo62576eL(Context context) {
        AppMethodBeat.m2504i(44865);
        this.bSI = new WeakReference(context);
        AppMethodBeat.m2505o(44865);
    }

    /* renamed from: a */
    public final C5653c mo62575a(String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(44866);
        C4990ab.m7421w("MicroMsg.RemittanceBusiDialogMgr", "showAlert1() msg:%s, title:%s, yes:%s, no:%s", C5046bo.nullAsNil(str), C5046bo.nullAsNil(str2), C5046bo.nullAsNil(str3), C5046bo.nullAsNil(str4));
        Context context = (Context) this.bSI.get();
        if (context == null) {
            C4990ab.m7416i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.m2505o(44866);
            return null;
        }
        C5653c d = C30379h.m48466d(context, str, str2, str3, str4, onClickListener, onClickListener2);
        AppMethodBeat.m2505o(44866);
        return d;
    }

    /* renamed from: a */
    public final C5653c mo62574a(String str, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(44867);
        C4990ab.m7421w("MicroMsg.RemittanceBusiDialogMgr", "showAlert2() msg:%s, title:%s", C5046bo.nullAsNil(str), C5046bo.nullAsNil(null));
        Context context = (Context) this.bSI.get();
        if (context == null) {
            C4990ab.m7416i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.m2505o(44867);
            return null;
        }
        C5653c a = C30379h.m48448a(context, str, null, false, onClickListener);
        AppMethodBeat.m2505o(44867);
        return a;
    }
}

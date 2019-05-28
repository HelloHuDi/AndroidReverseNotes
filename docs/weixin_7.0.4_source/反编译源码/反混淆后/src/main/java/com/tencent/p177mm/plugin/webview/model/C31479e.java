package com.tencent.p177mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p711c.C45392co;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C15422bb;
import com.tencent.p177mm.sdk.platformtools.C15422bb.C15421b;
import com.tencent.p177mm.sdk.platformtools.C15422bb.C15424c;

/* renamed from: com.tencent.mm.plugin.webview.model.e */
public final class C31479e implements C15424c<Integer, Long> {
    public static final String[] fnj = new String[]{C7563j.m13217a(gSs, "JsLogBlockList")};
    private static final C4924a gSs = C45392co.m83577Hm();
    public final C7480h fni;
    public final C15422bb<Integer, Long> ulM = new C15422bb(this, C1720g.m3539RS().oAl.getLooper(), 100, 20);
    private long ulN;

    static {
        AppMethodBeat.m2504i(6578);
        Class cls = C45392co.class;
        AppMethodBeat.m2505o(6578);
    }

    public C31479e(C7480h c7480h) {
        AppMethodBeat.m2504i(6573);
        this.fni = c7480h;
        AppMethodBeat.m2505o(6573);
    }

    public final void cXu() {
        AppMethodBeat.m2504i(6574);
        this.ulM.mo27468pl(true);
        AppMethodBeat.m2505o(6574);
    }

    public final boolean akm() {
        AppMethodBeat.m2504i(6575);
        if (this.fni.inTransaction()) {
            AppMethodBeat.m2505o(6575);
            return false;
        }
        this.ulN = this.fni.mo15639iV(Thread.currentThread().getId());
        if (this.ulN > 0) {
            AppMethodBeat.m2505o(6575);
            return true;
        }
        AppMethodBeat.m2505o(6575);
        return false;
    }

    /* renamed from: a */
    public final void mo27469a(C15421b<Integer, Long> c15421b) {
        AppMethodBeat.m2504i(6576);
        switch (c15421b.xBj) {
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) c15421b.aCx);
                contentValues.put("liftTime", (Long) c15421b.values);
                this.fni.replace("JsLogBlockList", "logId", contentValues);
                break;
            case 2:
                this.fni.delete("JsLogBlockList", "logId=" + c15421b.aCx, null);
                AppMethodBeat.m2505o(6576);
                return;
        }
        AppMethodBeat.m2505o(6576);
    }

    public final void akn() {
        AppMethodBeat.m2504i(6577);
        if (this.ulN > 0) {
            this.fni.mo15640mB(this.ulN);
        }
        AppMethodBeat.m2505o(6577);
    }
}

package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.c.co;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.b;
import com.tencent.mm.sdk.platformtools.bb.c;

public final class e implements c<Integer, Long> {
    public static final String[] fnj = new String[]{j.a(gSs, "JsLogBlockList")};
    private static final a gSs = co.Hm();
    public final h fni;
    public final bb<Integer, Long> ulM = new bb(this, g.RS().oAl.getLooper(), 100, 20);
    private long ulN;

    static {
        AppMethodBeat.i(6578);
        Class cls = co.class;
        AppMethodBeat.o(6578);
    }

    public e(h hVar) {
        AppMethodBeat.i(6573);
        this.fni = hVar;
        AppMethodBeat.o(6573);
    }

    public final void cXu() {
        AppMethodBeat.i(6574);
        this.ulM.pl(true);
        AppMethodBeat.o(6574);
    }

    public final boolean akm() {
        AppMethodBeat.i(6575);
        if (this.fni.inTransaction()) {
            AppMethodBeat.o(6575);
            return false;
        }
        this.ulN = this.fni.iV(Thread.currentThread().getId());
        if (this.ulN > 0) {
            AppMethodBeat.o(6575);
            return true;
        }
        AppMethodBeat.o(6575);
        return false;
    }

    public final void a(b<Integer, Long> bVar) {
        AppMethodBeat.i(6576);
        switch (bVar.xBj) {
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) bVar.aCx);
                contentValues.put("liftTime", (Long) bVar.values);
                this.fni.replace("JsLogBlockList", "logId", contentValues);
                break;
            case 2:
                this.fni.delete("JsLogBlockList", "logId=" + bVar.aCx, null);
                AppMethodBeat.o(6576);
                return;
        }
        AppMethodBeat.o(6576);
    }

    public final void akn() {
        AppMethodBeat.i(6577);
        if (this.ulN > 0) {
            this.fni.mB(this.ulN);
        }
        AppMethodBeat.o(6577);
    }
}

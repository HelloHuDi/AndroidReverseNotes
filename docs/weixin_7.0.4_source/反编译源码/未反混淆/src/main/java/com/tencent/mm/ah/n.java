package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.List;

public final class n {
    private static List<String> fsk = null;
    private static int fsl = 0;
    private static a fsm = new a(new b());

    static class a extends ap {
        final b fsn;

        public a(b bVar) {
            super(bVar, true);
            this.fsn = bVar;
        }
    }

    static class b implements com.tencent.mm.sdk.platformtools.ap.a {
        Runnable fso;

        b() {
        }

        public final boolean BI() {
            AppMethodBeat.i(77950);
            int size = n.fsk.size();
            ab.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(size)));
            if (size <= 2000 || n.fsl >= 300) {
                if (this.fso != null) {
                    this.fso.run();
                }
                n.fsl = 0;
                AppMethodBeat.o(77950);
                return false;
            }
            long iV = g.RP().eJN.iV(Thread.currentThread().getId());
            int i = size - 1;
            while (true) {
                int i2 = i;
                if (i2 >= size - 30) {
                    n.acr();
                    String str = (String) n.fsk.get(i2);
                    n.fsk.remove(i2);
                    o.acd();
                    d.E(str, false);
                    o.acd();
                    d.E(str, true);
                    o.act().qp(str);
                    i = i2 - 1;
                } else {
                    g.RP().eJN.mB(iV);
                    AppMethodBeat.o(77950);
                    return true;
                }
            }
        }
    }

    static /* synthetic */ int acr() {
        int i = fsl;
        fsl = i + 1;
        return i;
    }

    static {
        AppMethodBeat.i(77953);
        AppMethodBeat.o(77953);
    }

    public static void x(Runnable runnable) {
        AppMethodBeat.i(77951);
        if (g.RN().QY()) {
            i act = o.act();
            ArrayList arrayList = new ArrayList();
            Cursor a = act.fni.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            fsk = arrayList;
            if (arrayList.size() <= 0) {
                AppMethodBeat.o(77951);
                return;
            }
            fsm.fsn.fso = runnable;
            fsm.ae(10, 10);
            AppMethodBeat.o(77951);
            return;
        }
        AppMethodBeat.o(77951);
    }

    public static void acp() {
        AppMethodBeat.i(77952);
        fsl = 0;
        fsm.stopTimer();
        AppMethodBeat.o(77952);
    }
}

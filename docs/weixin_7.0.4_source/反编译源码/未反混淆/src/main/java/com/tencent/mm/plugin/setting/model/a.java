package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class a {
    public static a qjB;
    private static a qjC;
    public boolean fPO = false;

    public interface a {
        void Ci(int i);
    }

    /* renamed from: com.tencent.mm.plugin.setting.model.a$1 */
    public class AnonymousClass1 implements com.tencent.mm.model.bk.a {
        final /* synthetic */ String ewe;
        final /* synthetic */ int gdi;

        public AnonymousClass1(String str, int i) {
            this.ewe = str;
            this.gdi = i;
        }

        public final void a(e eVar) {
            AppMethodBeat.i(126836);
            g.Rg().a(1, "", 0, false);
            ab.dot();
            g.Rg().a(2, this.ewe, this.gdi, g.RK());
            AppMethodBeat.o(126836);
        }
    }

    public static a cir() {
        AppMethodBeat.i(126838);
        if (qjC == null) {
            qjC = new a();
        }
        a aVar = qjC;
        AppMethodBeat.o(126838);
        return aVar;
    }

    public static long Ff(String str) {
        AppMethodBeat.i(126839);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long anU = bo.anU();
        try {
            anU = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            ab.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", str, bo.dpG());
        }
        AppMethodBeat.o(126839);
        return anU;
    }
}

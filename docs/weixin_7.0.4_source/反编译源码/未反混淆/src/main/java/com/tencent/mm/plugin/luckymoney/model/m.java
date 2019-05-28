package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;

public final class m extends c<bf> {
    public static final String nXE = (b.eSj + "/luckymoney/");

    public m() {
        AppMethodBeat.i(42327);
        this.xxI = bf.class.getName().hashCode();
        AppMethodBeat.o(42327);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(42330);
        final bf bfVar = (bf) bVar;
        if (bfVar.cus.cut == 58) {
            ab.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "luckyMoney resource file update, type: %s, subType: %s, filePath: %s", Integer.valueOf(bfVar.cus.cut), Integer.valueOf(bfVar.cus.cuu), bfVar.cus.filePath);
            h.pYm.k(991, 0, 1);
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(42326);
                    if (!bo.isNullOrNil(bfVar.cus.filePath)) {
                        boolean z = true;
                        if (!m.aN(bfVar.cus.cuu, bfVar.cus.filePath)) {
                            h.pYm.k(991, 2, 1);
                            z = false;
                        } else if (m.et(bfVar.cus.cuu, bfVar.cus.cuv)) {
                            ab.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "not retry");
                        } else {
                            h.pYm.k(991, 1, 1);
                            z = false;
                        }
                        com.tencent.mm.pluginsdk.g.a.a.b.c.veg.f(bfVar.cus.cut, bfVar.cus.cuu, bfVar.cus.cuv, z);
                    }
                    AppMethodBeat.o(42326);
                }
            }, "lucky_money_envelope_resource_checker");
        }
        AppMethodBeat.o(42330);
        return false;
    }

    static {
        AppMethodBeat.i(42333);
        AppMethodBeat.o(42333);
    }

    public static String xR(int i) {
        AppMethodBeat.i(42329);
        String str = nXE + i + "/";
        AppMethodBeat.o(42329);
        return str;
    }

    public static void bLy() {
        AppMethodBeat.i(42328);
        com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
        com.tencent.mm.pluginsdk.g.a.a.b.Ky(58);
        AppMethodBeat.o(42328);
    }

    static /* synthetic */ boolean aN(int i, String str) {
        AppMethodBeat.i(42331);
        String str2 = nXE + i;
        if (e.ct(str2)) {
            e.N(str2, true);
        }
        new com.tencent.mm.vfs.b(str2).mkdirs();
        int iu = e.iu(str, str2);
        ab.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "unzip ret: %s", Integer.valueOf(0));
        if (iu == 0) {
            AppMethodBeat.o(42331);
            return true;
        }
        AppMethodBeat.o(42331);
        return false;
    }

    static /* synthetic */ boolean et(int i, int i2) {
        AppMethodBeat.i(42332);
        String str = nXE + i + "/";
        if (e.ct(str)) {
            boolean z;
            n nVar = new n();
            nVar.field_subtype = i;
            boolean b = a.bKN().bKM().b((com.tencent.mm.sdk.e.c) nVar, new String[0]);
            com.tencent.mm.vfs.b[] dMF = new com.tencent.mm.vfs.b(str).dMF();
            if (dMF == null || dMF.length <= 0) {
                z = false;
            } else {
                z = false;
                for (com.tencent.mm.vfs.b bVar : dMF) {
                    if (bVar.isFile()) {
                        String v = g.v(new File(j.w(bVar.dMD())));
                        if (bVar.getName().equals("bubble.png")) {
                            nVar.field_bubbleMd5 = v;
                            z = true;
                        } else if (bVar.getName().equals("cover.png")) {
                            nVar.field_coverMd5 = v;
                            z = true;
                        } else if (bVar.getName().equals("minilogo.png")) {
                            nVar.field_minilogoMd5 = v;
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                nVar.field_version = i2;
                ab.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "insert or update resource: %s, %s, %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(b));
                boolean c;
                if (b) {
                    c = a.bKN().bKM().c(nVar, new String[0]);
                    AppMethodBeat.o(42332);
                    return c;
                }
                c = a.bKN().bKM().b((com.tencent.mm.sdk.e.c) nVar);
                AppMethodBeat.o(42332);
                return c;
            }
            ab.w("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "error file dir");
            AppMethodBeat.o(42332);
            return false;
        }
        AppMethodBeat.o(42332);
        return false;
    }
}

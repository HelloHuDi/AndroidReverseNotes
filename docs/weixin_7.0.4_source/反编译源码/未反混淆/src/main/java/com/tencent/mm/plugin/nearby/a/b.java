package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public enum b {
    ;

    private b(String str) {
    }

    static {
        AppMethodBeat.o(55362);
    }

    public static boolean fr(String str, String str2) {
        AppMethodBeat.i(55355);
        ad adVar = new ad();
        adVar.iB(str2);
        adVar.setUsername(str);
        bd XM = ((j) g.K(j.class)).XM();
        ab.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + adVar.field_username);
        if (!XM.aoQ(adVar.field_username)) {
            XM.Z(adVar);
        }
        g.RP().Ry().set(143873, (Object) str);
        g.RP().Ry().set(143874, Long.valueOf(bo.anT()));
        AppMethodBeat.o(55355);
        return true;
    }

    public static void cK(String str, int i) {
        AppMethodBeat.i(55356);
        g.Rg().a(new d(str, (int) bo.fp(bo.c((Long) g.RP().Ry().get(143874, Long.valueOf(0)))), i), 0);
        AppMethodBeat.o(55356);
    }

    public static void zY(int i) {
        AppMethodBeat.i(55357);
        String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(143873, (Object) ""));
        if (!nullAsNil.equals("")) {
            if (bo.fp(bo.c((Long) g.RP().Ry().get(143874, Long.valueOf(0)))) < 7200) {
                cK(nullAsNil, i);
                AppMethodBeat.o(55357);
                return;
            }
            TA(nullAsNil);
        }
        AppMethodBeat.o(55357);
    }

    public static boolean bUU() {
        AppMethodBeat.i(55358);
        if (bo.h((Integer) g.RP().Ry().get(143875, Integer.valueOf(0))) == 1) {
            AppMethodBeat.o(55358);
            return true;
        }
        AppMethodBeat.o(55358);
        return false;
    }

    public static void bUV() {
        AppMethodBeat.i(55359);
        g.RP().Ry().set(143875, Integer.valueOf(1));
        AppMethodBeat.o(55359);
    }

    public static void bUW() {
        AppMethodBeat.i(55360);
        g.RP().Ry().set(143875, Integer.valueOf(0));
        AppMethodBeat.o(55360);
    }

    public static void TA(String str) {
        AppMethodBeat.i(55361);
        bd XM = ((j) g.K(j.class)).XM();
        if (XM.aoQ(str)) {
            XM.aoU(str);
        }
        bf.a(str, new a() {
            public final boolean JU() {
                return false;
            }

            public final void JV() {
            }
        });
        g.RP().Ry().set(143873, (Object) "");
        g.RP().Ry().set(143874, Long.valueOf(0));
        bUW();
        AppMethodBeat.o(55361);
    }
}

package com.tencent.mm.plugin.subapp.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class b implements c {

    static class a implements f {
        public a() {
            AppMethodBeat.i(25225);
            aw.Rg().a((int) ErrorCode.STARTDOWNLOAD_8, (f) this);
            aw.Rg().a(new a(), 0);
            AppMethodBeat.o(25225);
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(25226);
            aw.Rg().b((int) ErrorCode.STARTDOWNLOAD_8, (f) this);
            AppMethodBeat.o(25226);
        }
    }

    public final String ky(int i) {
        AppMethodBeat.i(25227);
        String aj = aj(i, true);
        AppMethodBeat.o(25227);
        return aj;
    }

    public final String kz(int i) {
        AppMethodBeat.i(25228);
        String aj = aj(i, false);
        AppMethodBeat.o(25228);
        return aj;
    }

    private String aj(int i, boolean z) {
        AppMethodBeat.i(25229);
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            String ak = ak(i, z);
            if (e.ct(ak)) {
                AppMethodBeat.o(25229);
                return ak;
            }
            Zv();
            AppMethodBeat.o(25229);
            return null;
        }
        AppMethodBeat.o(25229);
        return null;
    }

    public final void Zv() {
        AppMethodBeat.i(25230);
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            aw.ZK();
            long a = bo.a((Long) com.tencent.mm.model.c.Ry().get(66051, null), 0);
            long anU = bo.anU();
            if (432000000 > anU - a) {
                AppMethodBeat.o(25230);
                return;
            }
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(66051, Long.valueOf(anU));
            a aVar = new a();
            AppMethodBeat.o(25230);
            return;
        }
        AppMethodBeat.o(25230);
    }

    public final boolean kA(int i) {
        AppMethodBeat.i(25231);
        if (i == 0) {
            AppMethodBeat.o(25231);
            return false;
        }
        int i2 = 0;
        while (i2 < 32) {
            if (e.ct(B((1 << i2) & i, false)) && e.ct(B((1 << i2) & i, true))) {
                i2++;
            } else {
                AppMethodBeat.o(25231);
                return false;
            }
        }
        AppMethodBeat.o(25231);
        return true;
    }

    private String ak(int i, boolean z) {
        AppMethodBeat.i(25232);
        int Fn = Fn(i);
        if (Fn == 0) {
            AppMethodBeat.o(25232);
            return null;
        }
        String B = B(Fn, z);
        AppMethodBeat.o(25232);
        return B;
    }

    public final String B(int i, boolean z) {
        AppMethodBeat.i(25233);
        if (i == 0) {
            AppMethodBeat.o(25233);
            return null;
        }
        String str = com.tencent.mm.compatible.util.e.euS + "vuserpic_" + Integer.toHexString(i) + (z ? "_HD" : "") + ".png";
        AppMethodBeat.o(25233);
        return str;
    }

    private static int Fm(int i) {
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        while (i2 < 32) {
            i = (i >> 1) & BaseClientBuilder.API_PRIORITY_OTHER;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    private static int Fn(int i) {
        AppMethodBeat.i(25234);
        int Fm = Fm(i);
        if (Fm == -1) {
            AppMethodBeat.o(25234);
            return 0;
        }
        Fm = 1 << Fm;
        AppMethodBeat.o(25234);
        return Fm;
    }
}

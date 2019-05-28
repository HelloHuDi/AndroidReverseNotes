package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends j<d> {
    public static final String[] fjY = new String[]{j.a(d.fjX, "ProfileInfo")};
    public static final String[] fjZ = new String[0];

    static {
        AppMethodBeat.i(23959);
        AppMethodBeat.o(23959);
    }

    public a(e eVar) {
        super(eVar, d.fjX, "ProfileInfo", fjZ);
    }

    public final d Va(String str) {
        AppMethodBeat.i(23958);
        d dVar = new d();
        dVar.field_username = str;
        if (b((c) dVar, "username")) {
            ab.i("MicroMsg.ProfileInfoStorage", "get username:%s", dVar.field_username);
            AppMethodBeat.o(23958);
            return dVar;
        }
        ab.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
        AppMethodBeat.o(23958);
        return null;
    }
}

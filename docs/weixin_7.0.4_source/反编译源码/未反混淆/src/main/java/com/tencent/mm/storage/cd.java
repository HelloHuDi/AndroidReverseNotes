package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class cd extends j<cc> implements a {
    public static final String[] fnj = new String[]{j.a(cc.ccO, "VoiceTransText")};
    public e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(116826);
        boolean a = a((cc) cVar);
        AppMethodBeat.o(116826);
        return a;
    }

    static {
        AppMethodBeat.i(116827);
        AppMethodBeat.o(116827);
    }

    public cd(e eVar) {
        this(eVar, cc.ccO, "VoiceTransText");
    }

    private cd(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final boolean a(cc ccVar) {
        AppMethodBeat.i(116824);
        if (ccVar == null) {
            AppMethodBeat.o(116824);
            return false;
        }
        if (this.bSd.replace("VoiceTransText", "msgId", ccVar.Hl()) >= 0) {
            AppMethodBeat.o(116824);
            return true;
        }
        AppMethodBeat.o(116824);
        return false;
    }

    public final cc aqb(String str) {
        AppMethodBeat.i(116825);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116825);
            return null;
        }
        cc ccVar = new cc();
        Cursor a = this.bSd.a("VoiceTransText", null, "cmsgId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            ccVar.d(a);
        }
        a.close();
        AppMethodBeat.o(116825);
        return ccVar;
    }
}

package com.tencent.mm.aj.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ab;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends j<ab> {
    public static final String[] fnj = new String[]{j.a(f.ccO, "BizChatMyUserInfo")};
    private e bSd;
    private final l<a, b> fuL = new l<a, b>() {
        public final /* bridge */ /* synthetic */ void w(Object obj, Object obj2) {
        }
    };

    public interface a {

        public enum a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.o(11559);
            }
        }

        public static class b {
            public String cwz;
            public a fxN;
            public f fxO;
        }
    }

    static {
        AppMethodBeat.i(11566);
        AppMethodBeat.o(11566);
    }

    public g(e eVar) {
        super(eVar, f.ccO, "BizChatMyUserInfo", null);
        AppMethodBeat.i(11560);
        this.bSd = eVar;
        eVar.hY("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
        AppMethodBeat.o(11560);
    }

    public final f rA(String str) {
        AppMethodBeat.i(11561);
        if (bo.isNullOrNil(str)) {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            AppMethodBeat.o(11561);
            return null;
        }
        c fVar = new f();
        fVar.field_brandUserName = str;
        super.b(fVar, new String[0]);
        AppMethodBeat.o(11561);
        return fVar;
    }

    public final boolean rB(String str) {
        boolean z = false;
        AppMethodBeat.i(11562);
        if (bo.isNullOrNil(str)) {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
            AppMethodBeat.o(11562);
        } else {
            c fVar = new f();
            fVar.field_brandUserName = str;
            z = super.a(fVar, "brandUserName");
            if (z) {
                b bVar = new b();
                bVar.cwz = fVar.field_brandUserName;
                bVar.fxN = a.DELETE;
                bVar.fxO = fVar;
                this.fuL.cF(bVar);
                this.fuL.doNotify();
            }
            AppMethodBeat.o(11562);
        }
        return z;
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(11563);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean b = super.b((c) fVar);
        if (b) {
            b bVar = new b();
            bVar.cwz = fVar.field_brandUserName;
            bVar.fxN = a.INSTERT;
            bVar.fxO = fVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        } else {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        AppMethodBeat.o(11563);
        return b;
    }

    public final boolean b(f fVar) {
        AppMethodBeat.i(11564);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (fVar == null) {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            AppMethodBeat.o(11564);
            return false;
        }
        boolean a = super.a(fVar);
        if (a) {
            b bVar = new b();
            bVar.cwz = fVar.field_brandUserName;
            bVar.fxN = a.UPDATE;
            bVar.fxO = fVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        } else {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        }
        AppMethodBeat.o(11564);
        return a;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.i(11565);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor a = this.bSd.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(11565);
        return i;
    }
}

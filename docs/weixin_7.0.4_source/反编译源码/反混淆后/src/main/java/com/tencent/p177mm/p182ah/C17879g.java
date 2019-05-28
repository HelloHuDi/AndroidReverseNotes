package com.tencent.p177mm.p182ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ah.g */
public final class C17879g extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    C7480h fni;

    public C17879g(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: a */
    public final int mo33379a(String str, C37438f c37438f) {
        AppMethodBeat.m2504i(77917);
        int update = this.fni.update("hdheadimginfo", c37438f.mo60326Hl(), "username=?", new String[]{str});
        AppMethodBeat.m2505o(77917);
        return update;
    }

    /* renamed from: qm */
    public final C37438f mo33380qm(String str) {
        C37438f c37438f = null;
        AppMethodBeat.m2504i(77918);
        Cursor a = this.fni.mo10104a("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(77918);
        } else {
            if (a.moveToFirst()) {
                c37438f = new C37438f();
                c37438f.username = a.getString(0);
                c37438f.frL = a.getInt(1);
                c37438f.frM = a.getInt(2);
                c37438f.frN = a.getString(3);
                c37438f.frO = a.getInt(4);
                c37438f.coc = a.getInt(5);
                c37438f.frP = a.getInt(6);
                c37438f.frQ = a.getString(7);
                c37438f.frR = a.getString(8);
                c37438f.frS = a.getInt(9);
                c37438f.frT = a.getInt(10);
            }
            a.close();
            AppMethodBeat.m2505o(77918);
        }
        return c37438f;
    }
}

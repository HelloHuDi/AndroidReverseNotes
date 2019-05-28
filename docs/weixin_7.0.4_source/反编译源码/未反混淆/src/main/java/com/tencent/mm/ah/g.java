package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    h fni;

    public g(h hVar) {
        this.fni = hVar;
    }

    public final int a(String str, f fVar) {
        AppMethodBeat.i(77917);
        int update = this.fni.update("hdheadimginfo", fVar.Hl(), "username=?", new String[]{str});
        AppMethodBeat.o(77917);
        return update;
    }

    public final f qm(String str) {
        f fVar = null;
        AppMethodBeat.i(77918);
        Cursor a = this.fni.a("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(77918);
        } else {
            if (a.moveToFirst()) {
                fVar = new f();
                fVar.username = a.getString(0);
                fVar.frL = a.getInt(1);
                fVar.frM = a.getInt(2);
                fVar.frN = a.getString(3);
                fVar.frO = a.getInt(4);
                fVar.coc = a.getInt(5);
                fVar.frP = a.getInt(6);
                fVar.frQ = a.getString(7);
                fVar.frR = a.getString(8);
                fVar.frS = a.getInt(9);
                fVar.frT = a.getInt(10);
            }
            a.close();
            AppMethodBeat.o(77918);
        }
        return fVar;
    }
}

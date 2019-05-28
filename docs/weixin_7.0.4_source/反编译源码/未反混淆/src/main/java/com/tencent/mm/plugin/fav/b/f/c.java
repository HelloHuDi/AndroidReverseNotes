package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class c extends j<f> implements t {
    private e bSd;

    public final /* synthetic */ boolean a(f fVar) {
        AppMethodBeat.i(5430);
        boolean b = super.b((com.tencent.mm.sdk.e.c) fVar);
        AppMethodBeat.o(5430);
        return b;
    }

    public final /* synthetic */ boolean a(f fVar, String[] strArr) {
        AppMethodBeat.i(5429);
        boolean c = super.c(fVar, strArr);
        AppMethodBeat.o(5429);
        return c;
    }

    public c(e eVar) {
        super(eVar, f.ccO, "FavEditInfo", null);
        AppMethodBeat.i(5425);
        this.bSd = eVar;
        this.bSd.hY("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
        AppMethodBeat.o(5425);
    }

    public final f iD(long j) {
        f fVar = null;
        AppMethodBeat.i(5426);
        Cursor a = this.bSd.a("select * from FavEditInfo where localId =  ? and type =  ?", new String[]{String.valueOf(j), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
        if (a == null) {
            AppMethodBeat.o(5426);
        } else {
            if (a.moveToFirst()) {
                fVar = new f();
                fVar.d(a);
            }
            a.close();
            AppMethodBeat.o(5426);
        }
        return fVar;
    }

    public final void s(long j, int i) {
        AppMethodBeat.i(5427);
        this.bSd.delete("FavEditInfo", "localId=? and type=?", new String[]{String.valueOf(j), String.valueOf(i)});
        AppMethodBeat.o(5427);
    }

    public final List<f> buQ() {
        AppMethodBeat.i(5428);
        Cursor a = this.bSd.a("select count(*) from FavEditInfo", null, 2);
        if (a == null) {
            ab.e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
            AppMethodBeat.o(5428);
            return null;
        }
        try {
            if (a.moveToFirst()) {
                ab.i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", Integer.valueOf(a.getInt(0)));
            }
            a.close();
            a = this.bSd.a("select * from FavEditInfo", null, 2);
            if (a == null) {
                AppMethodBeat.o(5428);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                if (a.moveToFirst()) {
                    do {
                        f fVar = new f();
                        fVar.d(a);
                        arrayList.add(fVar);
                    } while (a.moveToNext());
                }
                a.close();
                AppMethodBeat.o(5428);
                return arrayList;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e, "", new Object[0]);
                a.close();
                AppMethodBeat.o(5428);
                return null;
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e2, "", new Object[0]);
            a.close();
            AppMethodBeat.o(5428);
            return null;
        }
    }
}

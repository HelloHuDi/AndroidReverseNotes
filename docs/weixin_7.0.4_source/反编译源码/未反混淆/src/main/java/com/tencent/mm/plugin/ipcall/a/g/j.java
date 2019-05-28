package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class j extends com.tencent.mm.sdk.e.j<i> implements a {
    public static final String[] fnj = new String[]{com.tencent.mm.sdk.e.j.a(i.ccO, "IPCallPopularCountry")};
    private e bSd;
    public n gvC = new n() {
        public final boolean apK() {
            AppMethodBeat.i(21937);
            if (j.this.bSd == null || j.this.bSd.dpU()) {
                String str = "MicroMsg.IPCallPopularCountryStorage";
                String str2 = "shouldProcessEvent db is close :%s";
                Object[] objArr = new Object[1];
                objArr[0] = j.this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(j.this.bSd.dpU());
                ab.w(str, str2, objArr);
                AppMethodBeat.o(21937);
                return false;
            }
            AppMethodBeat.o(21937);
            return true;
        }
    };

    static {
        AppMethodBeat.i(21941);
        AppMethodBeat.o(21941);
    }

    public j(e eVar) {
        super(eVar, i.ccO, "IPCallPopularCountry", null);
        AppMethodBeat.i(21938);
        this.bSd = eVar;
        AppMethodBeat.o(21938);
    }

    public final String getTableName() {
        return "IPCallPopularCountry";
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final void O(int i, long j) {
        boolean a;
        AppMethodBeat.i(21939);
        i iVar = new i();
        Cursor a2 = this.bSd.a("IPCallPopularCountry", null, "countryCode=?", new String[]{Integer.toString(i)}, null, null, null, 2);
        if (a2.moveToFirst()) {
            iVar.d(a2);
            iVar.field_callTimeCount++;
            iVar.field_lastCallTime = j;
            a = super.a(iVar);
            a2.close();
        } else {
            ab.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:".concat(String.valueOf(i)));
            a2.close();
            iVar.field_countryCode = i;
            iVar.field_lastCallTime = j;
            iVar.field_callTimeCount = 1;
            a = b((c) iVar);
        }
        ab.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:".concat(String.valueOf(a)));
        AppMethodBeat.o(21939);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<Integer> bIa() {
        AppMethodBeat.i(21940);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC");
        Cursor a = this.bSd.a("SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  " + stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(21940);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        do {
            i iVar = new i();
            iVar.d(a);
            arrayList.add(Integer.valueOf(iVar.field_countryCode));
        } while (a.moveToNext());
        if (a != null) {
        }
        AppMethodBeat.o(21940);
        return arrayList;
    }
}

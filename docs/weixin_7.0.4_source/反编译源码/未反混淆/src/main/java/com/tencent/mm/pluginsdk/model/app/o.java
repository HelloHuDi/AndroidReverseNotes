package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.u;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class o extends j<u> {
    public static final String[] fnj = new String[]{j.a(n.ccO, "AppSort")};
    public e bSd;

    static {
        AppMethodBeat.i(27354);
        AppMethodBeat.o(27354);
    }

    public o(e eVar) {
        super(eVar, n.ccO, "AppSort", null);
        AppMethodBeat.i(27351);
        this.bSd = eVar;
        eVar.hY("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
        eVar.hY("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
        AppMethodBeat.o(27351);
    }

    public final List<String> mb(long j) {
        AppMethodBeat.i(27352);
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppSort");
        stringBuilder.append(" where ");
        stringBuilder.append("flag = ").append(j);
        stringBuilder.append(" order by sortId desc ");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
            AppMethodBeat.o(27352);
            return null;
        }
        ab.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        int columnIndex = rawQuery.getColumnIndex("appId");
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        AppMethodBeat.o(27352);
        return arrayList;
    }

    public final boolean a(n nVar) {
        AppMethodBeat.i(27353);
        boolean b = super.b((c) nVar);
        AppMethodBeat.o(27353);
        return b;
    }
}

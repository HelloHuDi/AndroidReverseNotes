package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public class b extends j<a> {
    public static final String[] fjY = new String[]{j.a(a.fjX, "PredownloadBlockCgiRequest")};
    private final e gTC;

    static {
        AppMethodBeat.i(129509);
        AppMethodBeat.o(129509);
    }

    public b(e eVar) {
        super(eVar, a.fjX, "PredownloadBlockCgiRequest", a.diI);
        this.gTC = eVar;
    }

    public final Pair<Boolean, Integer> x(String str, int i, int i2) {
        AppMethodBeat.i(129506);
        Pair c = c("username", str, i, i2);
        AppMethodBeat.o(129506);
        return c;
    }

    public final Pair<Boolean, Integer> y(String str, int i, int i2) {
        AppMethodBeat.i(129507);
        Pair c = c("appId", str, i, i2);
        AppMethodBeat.o(129507);
        return c;
    }

    private Pair<Boolean, Integer> c(String str, String str2, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.i(129508);
        long anT = bo.anT();
        String str3 = "select reportId from PredownloadBlockCgiRequest where " + str + "=? and startTime<" + anT + " and " + anT + "<endTime and cgiList like '%;" + i + ";%' and sceneList like '%;" + i2 + ";%'";
        Cursor rawQuery = this.gTC.rawQuery(str3, new String[]{str2});
        if (rawQuery == null || rawQuery.isClosed()) {
            Pair create = Pair.create(Boolean.FALSE, Integer.valueOf(-1));
            AppMethodBeat.o(129508);
            return create;
        }
        boolean moveToFirst = rawQuery.moveToFirst();
        if (moveToFirst) {
            i3 = rawQuery.getInt(0);
        }
        rawQuery.close();
        Pair<Boolean, Integer> create2 = Pair.create(Boolean.valueOf(moveToFirst), Integer.valueOf(i3));
        AppMethodBeat.o(129508);
        return create2;
    }
}

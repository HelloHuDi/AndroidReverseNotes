package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e.b */
public class C45513b extends C7563j<C38112a> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C38112a.fjX, "PredownloadBlockCgiRequest")};
    private final C4927e gTC;

    static {
        AppMethodBeat.m2504i(129509);
        AppMethodBeat.m2505o(129509);
    }

    public C45513b(C4927e c4927e) {
        super(c4927e, C38112a.fjX, "PredownloadBlockCgiRequest", C38112a.diI);
        this.gTC = c4927e;
    }

    /* renamed from: x */
    public final Pair<Boolean, Integer> mo73325x(String str, int i, int i2) {
        AppMethodBeat.m2504i(129506);
        Pair c = m83912c("username", str, i, i2);
        AppMethodBeat.m2505o(129506);
        return c;
    }

    /* renamed from: y */
    public final Pair<Boolean, Integer> mo73326y(String str, int i, int i2) {
        AppMethodBeat.m2504i(129507);
        Pair c = m83912c("appId", str, i, i2);
        AppMethodBeat.m2505o(129507);
        return c;
    }

    /* renamed from: c */
    private Pair<Boolean, Integer> m83912c(String str, String str2, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(129508);
        long anT = C5046bo.anT();
        String str3 = "select reportId from PredownloadBlockCgiRequest where " + str + "=? and startTime<" + anT + " and " + anT + "<endTime and cgiList like '%;" + i + ";%' and sceneList like '%;" + i2 + ";%'";
        Cursor rawQuery = this.gTC.rawQuery(str3, new String[]{str2});
        if (rawQuery == null || rawQuery.isClosed()) {
            Pair create = Pair.create(Boolean.FALSE, Integer.valueOf(-1));
            AppMethodBeat.m2505o(129508);
            return create;
        }
        boolean moveToFirst = rawQuery.moveToFirst();
        if (moveToFirst) {
            i3 = rawQuery.getInt(0);
        }
        rawQuery.close();
        Pair<Boolean, Integer> create2 = Pair.create(Boolean.valueOf(moveToFirst), Integer.valueOf(i3));
        AppMethodBeat.m2505o(129508);
        return create2;
    }
}

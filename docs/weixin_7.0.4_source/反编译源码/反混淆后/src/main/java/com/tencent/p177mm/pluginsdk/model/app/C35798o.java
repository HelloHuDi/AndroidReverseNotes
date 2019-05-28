package com.tencent.p177mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9539u;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.app.o */
public final class C35798o extends C7563j<C9539u> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C35797n.ccO, "AppSort")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(27354);
        AppMethodBeat.m2505o(27354);
    }

    public C35798o(C4927e c4927e) {
        super(c4927e, C35797n.ccO, "AppSort", null);
        AppMethodBeat.m2504i(27351);
        this.bSd = c4927e;
        c4927e.mo10108hY("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
        c4927e.mo10108hY("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
        AppMethodBeat.m2505o(27351);
    }

    /* renamed from: mb */
    public final List<String> mo56576mb(long j) {
        AppMethodBeat.m2504i(27352);
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppSort");
        stringBuilder.append(" where ");
        stringBuilder.append("flag = ").append(j);
        stringBuilder.append(" order by sortId desc ");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
            AppMethodBeat.m2505o(27352);
            return null;
        }
        C4990ab.m7411d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        int columnIndex = rawQuery.getColumnIndex("appId");
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        AppMethodBeat.m2505o(27352);
        return arrayList;
    }

    /* renamed from: a */
    public final boolean mo56575a(C35797n c35797n) {
        AppMethodBeat.m2504i(27353);
        boolean b = super.mo10101b((C4925c) c35797n);
        AppMethodBeat.m2505o(27353);
        return b;
    }
}

package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42116en;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.t */
public final class C13479t extends C42116en {
    protected static C4924a ccO;
    public int rfJ;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: do */
    public final void mo25636do(List<bts> list) {
        AppMethodBeat.m2504i(38002);
        this.field_memberList = "";
        for (bts bts : list) {
            this.field_memberList += bts.wVI + ",";
        }
        AppMethodBeat.m2505o(38002);
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(38003);
        super.mo8995d(cursor);
        this.rfJ = (int) this.xDa;
        AppMethodBeat.m2505o(38003);
    }

    static {
        AppMethodBeat.m2504i(38004);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "tagId";
        c4924a.xDd.put("tagId", "LONG default '0' ");
        stringBuilder.append(" tagId LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[1] = "tagName";
        c4924a.xDd.put("tagName", "TEXT default '' ");
        stringBuilder.append(" tagName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "count";
        c4924a.xDd.put("count", "INTEGER default '0' ");
        stringBuilder.append(" count INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "memberList";
        c4924a.xDd.put("memberList", "TEXT default '' ");
        stringBuilder.append(" memberList TEXT default '' ");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(38004);
    }
}

package com.tencent.p177mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37836bb;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.b */
public final class C41339b extends C37836bb {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    /* renamed from: Aq */
    public final String mo65994Aq() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    static {
        AppMethodBeat.m2504i(62793);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "md5_lang";
        c4924a.xDd.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        c4924a.xDc = "md5_lang";
        c4924a.columns[1] = "md5";
        c4924a.xDd.put("md5", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "lang";
        c4924a.xDd.put("lang", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" lang TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "desc";
        c4924a.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "groupId";
        c4924a.xDd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "click_flag";
        c4924a.xDd.put("click_flag", "INTEGER");
        stringBuilder.append(" click_flag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "download_flag";
        c4924a.xDd.put("download_flag", "INTEGER");
        stringBuilder.append(" download_flag INTEGER");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62793);
    }
}

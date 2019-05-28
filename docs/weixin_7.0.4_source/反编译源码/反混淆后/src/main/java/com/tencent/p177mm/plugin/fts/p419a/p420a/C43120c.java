package com.tencent.p177mm.plugin.fts.p419a.p420a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9520bq;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.fts.a.a.c */
public final class C43120c extends C9520bq {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C43120c() {
        this.field_featureId = 0;
        this.field_title = "";
        this.field_titlePY = "";
        this.field_titleShortPY = "";
        this.field_tag = "";
        this.field_actionType = 0;
        this.field_url = "";
        this.field_helpUrl = "";
        this.field_updateUrl = "";
        this.field_androidUrl = "";
        this.field_iconPath = "";
    }

    public final String toString() {
        AppMethodBeat.m2504i(114236);
        String str = "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
        AppMethodBeat.m2505o(114236);
        return str;
    }

    static {
        AppMethodBeat.m2504i(114237);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[12];
        c4924a.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "featureId";
        c4924a.xDd.put("featureId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" featureId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "featureId";
        c4924a.columns[1] = "title";
        c4924a.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "titlePY";
        c4924a.xDd.put("titlePY", "TEXT");
        stringBuilder.append(" titlePY TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "titleShortPY";
        c4924a.xDd.put("titleShortPY", "TEXT");
        stringBuilder.append(" titleShortPY TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "tag";
        c4924a.xDd.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "actionType";
        c4924a.xDd.put("actionType", "INTEGER default '0' ");
        stringBuilder.append(" actionType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "url";
        c4924a.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "helpUrl";
        c4924a.xDd.put("helpUrl", "TEXT");
        stringBuilder.append(" helpUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "updateUrl";
        c4924a.xDd.put("updateUrl", "TEXT");
        stringBuilder.append(" updateUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "androidUrl";
        c4924a.xDd.put("androidUrl", "TEXT");
        stringBuilder.append(" androidUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "iconPath";
        c4924a.xDd.put("iconPath", "TEXT");
        stringBuilder.append(" iconPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = Param.TIMESTAMP;
        c4924a.xDd.put(Param.TIMESTAMP, "LONG default '0' ");
        stringBuilder.append(" timestamp LONG default '0' ");
        c4924a.columns[12] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(114237);
    }
}

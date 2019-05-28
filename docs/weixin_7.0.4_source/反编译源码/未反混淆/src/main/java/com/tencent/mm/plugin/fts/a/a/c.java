package com.tencent.mm.plugin.fts.a.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bq {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public c() {
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
        AppMethodBeat.i(114236);
        String str = "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
        AppMethodBeat.o(114236);
        return str;
    }

    static {
        AppMethodBeat.i(114237);
        a aVar = new a();
        aVar.xDb = new Field[12];
        aVar.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "featureId";
        aVar.xDd.put("featureId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" featureId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "featureId";
        aVar.columns[1] = "title";
        aVar.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "titlePY";
        aVar.xDd.put("titlePY", "TEXT");
        stringBuilder.append(" titlePY TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "titleShortPY";
        aVar.xDd.put("titleShortPY", "TEXT");
        stringBuilder.append(" titleShortPY TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "tag";
        aVar.xDd.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "actionType";
        aVar.xDd.put("actionType", "INTEGER default '0' ");
        stringBuilder.append(" actionType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "helpUrl";
        aVar.xDd.put("helpUrl", "TEXT");
        stringBuilder.append(" helpUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "updateUrl";
        aVar.xDd.put("updateUrl", "TEXT");
        stringBuilder.append(" updateUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "androidUrl";
        aVar.xDd.put("androidUrl", "TEXT");
        stringBuilder.append(" androidUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "iconPath";
        aVar.xDd.put("iconPath", "TEXT");
        stringBuilder.append(" iconPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = Param.TIMESTAMP;
        aVar.xDd.put(Param.TIMESTAMP, "LONG default '0' ");
        stringBuilder.append(" timestamp LONG default '0' ");
        aVar.columns[12] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(114237);
    }
}

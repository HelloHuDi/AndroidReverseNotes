package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37845dq;
import com.tencent.p177mm.plugin.appbrand.p911q.C19677b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ae */
public final class C41220ae extends C37845dq implements C19677b {
    static final C4924a fjX;
    static final String[] gSr = new String[]{"appId", "type", "version"};

    public final String[] getKeys() {
        return gSr;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(59446);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "version";
        c4924a.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "pkgMd5";
        c4924a.xDd.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "pkgPath";
        c4924a.xDd.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        String str = " PRIMARY KEY ( ";
        String[] strArr = gSr;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        C4924a c4924a2 = fjX;
        c4924a2.sql = stringBuilder2.append(c4924a2.sql).append(",").append(str2).toString();
        AppMethodBeat.m2505o(59446);
    }

    public final String toShortString() {
        AppMethodBeat.m2504i(59445);
        String format = String.format(Locale.US, "EncryptPkgInfo[%s %d %d]", new Object[]{this.field_appId, Integer.valueOf(this.field_type), Integer.valueOf(this.field_version)});
        AppMethodBeat.m2505o(59445);
        return format;
    }
}

package com.tencent.p177mm.plugin.wepkg.p1076b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37851fj;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wepkg.b.a */
public final class C23198a extends C37851fj {
    public static final C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(63386);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[8];
        c4924a.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "pkgId";
        c4924a.xDd.put("pkgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pkgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "pkgId";
        c4924a.columns[1] = "version";
        c4924a.xDd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "oldVersion";
        c4924a.xDd.put("oldVersion", "TEXT");
        stringBuilder.append(" oldVersion TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "oldPath";
        c4924a.xDd.put("oldPath", "TEXT");
        stringBuilder.append(" oldPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "md5";
        c4924a.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "downloadUrl";
        c4924a.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "pkgSize";
        c4924a.xDd.put("pkgSize", "INTEGER");
        stringBuilder.append(" pkgSize INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "downloadNetType";
        c4924a.xDd.put("downloadNetType", "INTEGER");
        stringBuilder.append(" downloadNetType INTEGER");
        c4924a.columns[8] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(63386);
    }
}

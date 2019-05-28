package com.tencent.p177mm.plugin.exdevice.p956h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37841ce;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.exdevice.h.b */
public final class C11648b extends C37841ce {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(19711);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[14];
        c4924a.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "deviceID";
        c4924a.xDd.put("deviceID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" deviceID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "deviceID";
        c4924a.columns[1] = "brandName";
        c4924a.xDd.put("brandName", "TEXT");
        stringBuilder.append(" brandName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "mac";
        c4924a.xDd.put("mac", "LONG");
        stringBuilder.append(" mac LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "deviceType";
        c4924a.xDd.put("deviceType", "TEXT");
        stringBuilder.append(" deviceType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "connProto";
        c4924a.xDd.put("connProto", "TEXT");
        stringBuilder.append(" connProto TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "connStrategy";
        c4924a.xDd.put("connStrategy", "INTEGER");
        stringBuilder.append(" connStrategy INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "closeStrategy";
        c4924a.xDd.put("closeStrategy", "INTEGER");
        stringBuilder.append(" closeStrategy INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "md5Str";
        c4924a.xDd.put("md5Str", "TEXT");
        stringBuilder.append(" md5Str TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "authKey";
        c4924a.xDd.put("authKey", "TEXT");
        stringBuilder.append(" authKey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "url";
        c4924a.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "sessionKey";
        c4924a.xDd.put("sessionKey", "BLOB");
        stringBuilder.append(" sessionKey BLOB");
        stringBuilder.append(", ");
        c4924a.columns[11] = "sessionBuf";
        c4924a.xDd.put("sessionBuf", "BLOB");
        stringBuilder.append(" sessionBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[12] = "authBuf";
        c4924a.xDd.put("authBuf", "BLOB");
        stringBuilder.append(" authBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[13] = "lvbuffer";
        c4924a.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        c4924a.columns[14] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(19711);
    }
}

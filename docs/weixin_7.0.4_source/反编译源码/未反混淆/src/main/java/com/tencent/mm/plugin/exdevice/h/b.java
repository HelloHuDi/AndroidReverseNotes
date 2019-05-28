package com.tencent.mm.plugin.exdevice.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends ce {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(19711);
        a aVar = new a();
        aVar.xDb = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceID";
        aVar.xDd.put("deviceID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" deviceID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "deviceID";
        aVar.columns[1] = "brandName";
        aVar.xDd.put("brandName", "TEXT");
        stringBuilder.append(" brandName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mac";
        aVar.xDd.put("mac", "LONG");
        stringBuilder.append(" mac LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "deviceType";
        aVar.xDd.put("deviceType", "TEXT");
        stringBuilder.append(" deviceType TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connProto";
        aVar.xDd.put("connProto", "TEXT");
        stringBuilder.append(" connProto TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "connStrategy";
        aVar.xDd.put("connStrategy", "INTEGER");
        stringBuilder.append(" connStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "closeStrategy";
        aVar.xDd.put("closeStrategy", "INTEGER");
        stringBuilder.append(" closeStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "md5Str";
        aVar.xDd.put("md5Str", "TEXT");
        stringBuilder.append(" md5Str TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "authKey";
        aVar.xDd.put("authKey", "TEXT");
        stringBuilder.append(" authKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "sessionKey";
        aVar.xDd.put("sessionKey", "BLOB");
        stringBuilder.append(" sessionKey BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "sessionBuf";
        aVar.xDd.put("sessionBuf", "BLOB");
        stringBuilder.append(" sessionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "authBuf";
        aVar.xDd.put("authBuf", "BLOB");
        stringBuilder.append(" authBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuffer";
        aVar.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(19711);
    }
}

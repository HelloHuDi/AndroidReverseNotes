package com.tencent.mm.plugin.freewifi.g;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bu {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(20879);
        a aVar = new a();
        aVar.xDb = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "ssidmd5";
        aVar.xDd.put("ssidmd5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "ssidmd5";
        aVar.columns[1] = "ssid";
        aVar.xDd.put("ssid", "TEXT");
        stringBuilder.append(" ssid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mid";
        aVar.xDd.put("mid", "TEXT");
        stringBuilder.append(" mid TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connectState";
        aVar.xDd.put("connectState", "INTEGER default '-1' ");
        stringBuilder.append(" connectState INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expiredTime";
        aVar.xDd.put("expiredTime", "LONG");
        stringBuilder.append(" expiredTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiType";
        aVar.xDd.put("wifiType", "INTEGER default '1' ");
        stringBuilder.append(" wifiType INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[7] = NativeProtocol.WEB_DIALOG_ACTION;
        aVar.xDd.put(NativeProtocol.WEB_DIALOG_ACTION, "INTEGER default '0' ");
        stringBuilder.append(" action INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "showUrl";
        aVar.xDd.put("showUrl", "TEXT");
        stringBuilder.append(" showUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "showWordEn";
        aVar.xDd.put("showWordEn", "TEXT");
        stringBuilder.append(" showWordEn TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "showWordCn";
        aVar.xDd.put("showWordCn", "TEXT");
        stringBuilder.append(" showWordCn TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "showWordTw";
        aVar.xDd.put("showWordTw", "TEXT");
        stringBuilder.append(" showWordTw TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "mac";
        aVar.xDd.put("mac", "TEXT");
        stringBuilder.append(" mac TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "verifyResult";
        aVar.xDd.put("verifyResult", "INTEGER default '1' ");
        stringBuilder.append(" verifyResult INTEGER default '1' ");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(20879);
    }
}

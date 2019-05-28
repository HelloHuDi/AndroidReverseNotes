package com.tencent.p177mm.plugin.freewifi.p417g;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45389bu;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.freewifi.g.c */
public final class C3137c extends C45389bu {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(20879);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[14];
        c4924a.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "ssidmd5";
        c4924a.xDd.put("ssidmd5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "ssidmd5";
        c4924a.columns[1] = "ssid";
        c4924a.xDd.put("ssid", "TEXT");
        stringBuilder.append(" ssid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "mid";
        c4924a.xDd.put("mid", "TEXT");
        stringBuilder.append(" mid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "url";
        c4924a.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "connectState";
        c4924a.xDd.put("connectState", "INTEGER default '-1' ");
        stringBuilder.append(" connectState INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "expiredTime";
        c4924a.xDd.put("expiredTime", "LONG");
        stringBuilder.append(" expiredTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "wifiType";
        c4924a.xDd.put("wifiType", "INTEGER default '1' ");
        stringBuilder.append(" wifiType INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = NativeProtocol.WEB_DIALOG_ACTION;
        c4924a.xDd.put(NativeProtocol.WEB_DIALOG_ACTION, "INTEGER default '0' ");
        stringBuilder.append(" action INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "showUrl";
        c4924a.xDd.put("showUrl", "TEXT");
        stringBuilder.append(" showUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "showWordEn";
        c4924a.xDd.put("showWordEn", "TEXT");
        stringBuilder.append(" showWordEn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "showWordCn";
        c4924a.xDd.put("showWordCn", "TEXT");
        stringBuilder.append(" showWordCn TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "showWordTw";
        c4924a.xDd.put("showWordTw", "TEXT");
        stringBuilder.append(" showWordTw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "mac";
        c4924a.xDd.put("mac", "TEXT");
        stringBuilder.append(" mac TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "verifyResult";
        c4924a.xDd.put("verifyResult", "INTEGER default '1' ");
        stringBuilder.append(" verifyResult INTEGER default '1' ");
        c4924a.columns[14] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(20879);
    }
}

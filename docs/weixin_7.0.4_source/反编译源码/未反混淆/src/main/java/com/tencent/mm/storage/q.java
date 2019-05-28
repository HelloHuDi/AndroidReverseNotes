package com.tencent.mm.storage;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ag;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class q extends ag {
    protected static a ccO;
    public boolean xHT = false;
    public boolean xHU = false;

    public final a Ag() {
        return ccO;
    }

    public final long drB() {
        return (this.field_orderFlag & -4294967296L) >> 32;
    }

    public final boolean drC() {
        return this.field_type == 285212721;
    }

    public final boolean drD() {
        return this.field_type == 34;
    }

    public final boolean drE() {
        switch (this.field_type) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public final boolean isText() {
        switch (this.field_type) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public final boolean drF() {
        AppMethodBeat.i(11852);
        if (drB() == 1) {
            AppMethodBeat.o(11852);
            return true;
        }
        AppMethodBeat.o(11852);
        return false;
    }

    public final void drG() {
        this.field_bitFlag |= 1;
    }

    static {
        AppMethodBeat.i(11853);
        a aVar = new a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msgId";
        aVar.columns[1] = "msgSvrId";
        aVar.xDd.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "talker";
        aVar.xDd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "imgPath";
        aVar.xDd.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "lvbuffer";
        aVar.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[9] = "talkerId";
        aVar.xDd.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "isExpand";
        aVar.xDd.put("isExpand", "INTEGER");
        stringBuilder.append(" isExpand INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "orderFlag";
        aVar.xDd.put("orderFlag", "LONG default '0' ");
        stringBuilder.append(" orderFlag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "hasShow";
        aVar.xDd.put("hasShow", "INTEGER default '1' ");
        stringBuilder.append(" hasShow INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "placeTop";
        aVar.xDd.put("placeTop", "INTEGER default '1' ");
        stringBuilder.append(" placeTop INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "appMsgStatInfoProto";
        aVar.xDd.put("appMsgStatInfoProto", "BLOB");
        stringBuilder.append(" appMsgStatInfoProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "isRead";
        aVar.xDd.put("isRead", "INTEGER default '0' ");
        stringBuilder.append(" isRead INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "bitFlag";
        aVar.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(11853);
    }
}

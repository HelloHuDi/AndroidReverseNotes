package com.tencent.p177mm.storage;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32682ag;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.q */
public final class C46627q extends C32682ag {
    protected static C4924a ccO;
    public boolean xHT = false;
    public boolean xHU = false;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
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
        AppMethodBeat.m2504i(11852);
        if (drB() == 1) {
            AppMethodBeat.m2505o(11852);
            return true;
        }
        AppMethodBeat.m2505o(11852);
        return false;
    }

    public final void drG() {
        this.field_bitFlag |= 1;
    }

    static {
        AppMethodBeat.m2504i(11853);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgId";
        c4924a.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "msgId";
        c4924a.columns[1] = "msgSvrId";
        c4924a.xDd.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "talker";
        c4924a.xDd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "imgPath";
        c4924a.xDd.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "lvbuffer";
        c4924a.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        c4924a.columns[9] = "talkerId";
        c4924a.xDd.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "isExpand";
        c4924a.xDd.put("isExpand", "INTEGER");
        stringBuilder.append(" isExpand INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[11] = "orderFlag";
        c4924a.xDd.put("orderFlag", "LONG default '0' ");
        stringBuilder.append(" orderFlag LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "hasShow";
        c4924a.xDd.put("hasShow", "INTEGER default '1' ");
        stringBuilder.append(" hasShow INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "placeTop";
        c4924a.xDd.put("placeTop", "INTEGER default '1' ");
        stringBuilder.append(" placeTop INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "appMsgStatInfoProto";
        c4924a.xDd.put("appMsgStatInfoProto", "BLOB");
        stringBuilder.append(" appMsgStatInfoProto BLOB");
        stringBuilder.append(", ");
        c4924a.columns[15] = "isRead";
        c4924a.xDd.put("isRead", "INTEGER default '0' ");
        stringBuilder.append(" isRead INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "bitFlag";
        c4924a.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(11853);
    }
}

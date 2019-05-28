package com.tencent.p177mm.storage;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18465cb;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.bb */
public final class C35996bb extends C18465cb {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(60138);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[13];
        c4924a.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "originSvrId";
        c4924a.xDd.put("originSvrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" originSvrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "originSvrId";
        c4924a.columns[1] = "newMsgId";
        c4924a.xDd.put("newMsgId", "LONG");
        stringBuilder.append(" newMsgId LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "fromUserName";
        c4924a.xDd.put("fromUserName", "TEXT default '' ");
        stringBuilder.append(" fromUserName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "toUserName";
        c4924a.xDd.put("toUserName", "TEXT default '' ");
        stringBuilder.append(" toUserName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "createTime";
        c4924a.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "msgSource";
        c4924a.xDd.put("msgSource", "TEXT default '' ");
        stringBuilder.append(" msgSource TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "msgSeq";
        c4924a.xDd.put("msgSeq", "INTEGER");
        stringBuilder.append(" msgSeq INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "flag";
        c4924a.xDd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "reserved1";
        c4924a.xDd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "reserved2";
        c4924a.xDd.put("reserved2", "LONG");
        stringBuilder.append(" reserved2 LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "reserved3";
        c4924a.xDd.put("reserved3", "TEXT default '' ");
        stringBuilder.append(" reserved3 TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "reserved4";
        c4924a.xDd.put("reserved4", "TEXT default '' ");
        stringBuilder.append(" reserved4 TEXT default '' ");
        c4924a.columns[13] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(60138);
    }
}

package com.tencent.p177mm.storage;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37847ed;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.bt */
public class C41338bt extends C37847ed {
    public static C4924a ccO;
    protected static Field[] xDb = C4925c.m7296ax(C41338bt.class).xDb;

    static {
        AppMethodBeat.m2504i(60234);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[11];
        c4924a.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "svrid";
        c4924a.xDd.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "svrid";
        c4924a.columns[1] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "scene";
        c4924a.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "createtime";
        c4924a.xDd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "talker";
        c4924a.xDd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "sayhiuser";
        c4924a.xDd.put("sayhiuser", "TEXT");
        stringBuilder.append(" sayhiuser TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "sayhicontent";
        c4924a.xDd.put("sayhicontent", "TEXT");
        stringBuilder.append(" sayhicontent TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "imgpath";
        c4924a.xDd.put("imgpath", "TEXT");
        stringBuilder.append(" imgpath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "isSend";
        c4924a.xDd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        c4924a.columns[11] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(60234);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }
}

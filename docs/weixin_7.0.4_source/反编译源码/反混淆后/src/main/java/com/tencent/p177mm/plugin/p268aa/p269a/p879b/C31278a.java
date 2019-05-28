package com.tencent.p177mm.plugin.p268aa.p269a.p879b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26297a;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.aa.a.b.a */
public final class C31278a extends C26297a {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(40663);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "payMsgId";
        c4924a.xDd.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "payMsgId";
        c4924a.columns[1] = "insertmsg";
        c4924a.xDd.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "chatroom";
        c4924a.xDd.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "msgId";
        c4924a.xDd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(40663);
    }
}

package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32681ad;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.aj.b */
public final class C36692b extends C32681ad {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(11249);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[13];
        c4924a.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "userName";
        c4924a.xDd.put("userName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "userName";
        c4924a.columns[1] = "qyUin";
        c4924a.xDd.put("qyUin", "INTEGER");
        stringBuilder.append(" qyUin INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "userUin";
        c4924a.xDd.put("userUin", "INTEGER");
        stringBuilder.append(" userUin INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "userFlag";
        c4924a.xDd.put("userFlag", "INTEGER");
        stringBuilder.append(" userFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "wwExposeTimes";
        c4924a.xDd.put("wwExposeTimes", "INTEGER");
        stringBuilder.append(" wwExposeTimes INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "wwMaxExposeTimes";
        c4924a.xDd.put("wwMaxExposeTimes", "INTEGER");
        stringBuilder.append(" wwMaxExposeTimes INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "wwCorpId";
        c4924a.xDd.put("wwCorpId", "LONG");
        stringBuilder.append(" wwCorpId LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "wwUserVid";
        c4924a.xDd.put("wwUserVid", "LONG");
        stringBuilder.append(" wwUserVid LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "userType";
        c4924a.xDd.put("userType", "INTEGER");
        stringBuilder.append(" userType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "chatOpen";
        c4924a.xDd.put("chatOpen", "INTEGER");
        stringBuilder.append(" chatOpen INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "wwUnreadCnt";
        c4924a.xDd.put("wwUnreadCnt", "INTEGER default '0' ");
        stringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "show_confirm";
        c4924a.xDd.put("show_confirm", "INTEGER");
        stringBuilder.append(" show_confirm INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "use_preset_banner_tips";
        c4924a.xDd.put("use_preset_banner_tips", "INTEGER");
        stringBuilder.append(" use_preset_banner_tips INTEGER");
        c4924a.columns[13] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(11249);
    }
}

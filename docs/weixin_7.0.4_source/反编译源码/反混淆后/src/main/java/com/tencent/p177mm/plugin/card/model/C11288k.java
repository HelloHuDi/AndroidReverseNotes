package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26298ak;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.card.model.k */
public final class C11288k extends C26298ak {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(87842);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "code_id";
        c4924a.xDd.put("code_id", "TEXT");
        stringBuilder.append(" code_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "card_id";
        c4924a.xDd.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = TMQQDownloaderOpenSDKConst.UINTYPE_CODE;
        c4924a.xDd.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "TEXT");
        stringBuilder.append(" code TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(87842);
    }
}

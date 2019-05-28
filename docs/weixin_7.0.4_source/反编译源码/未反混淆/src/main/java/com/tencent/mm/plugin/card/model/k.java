package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ak;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.reflect.Field;

public final class k extends ak {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(87842);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "code_id";
        aVar.xDd.put("code_id", "TEXT");
        stringBuilder.append(" code_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "card_id";
        aVar.xDd.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = TMQQDownloaderOpenSDKConst.UINTYPE_CODE;
        aVar.xDd.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "TEXT");
        stringBuilder.append(" code TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(87842);
    }
}

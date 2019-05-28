package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class j extends com.tencent.mm.sdk.e.j<i> implements a {
    public static final String[] fnj = new String[]{com.tencent.mm.sdk.e.j.a(i.ccO, "EmotionDetailInfo")};
    public e bSd;

    static {
        AppMethodBeat.i(62858);
        AppMethodBeat.o(62858);
    }

    public j(e eVar) {
        super(eVar, i.ccO, "EmotionDetailInfo", null);
        this.bSd = eVar;
    }

    public final String getTableName() {
        return "EmotionDetailInfo";
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final i aqp(String str) {
        i iVar = null;
        AppMethodBeat.i(62857);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
            AppMethodBeat.o(62857);
        } else {
            String[] strArr = new String[]{b.CONTENT, "lan"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.bSd.a("EmotionDetailInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                iVar = new i();
                iVar.field_content = a.getBlob(0);
                iVar.field_lan = a.getString(1);
                iVar.field_productID = str;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(62857);
        }
        return iVar;
    }
}

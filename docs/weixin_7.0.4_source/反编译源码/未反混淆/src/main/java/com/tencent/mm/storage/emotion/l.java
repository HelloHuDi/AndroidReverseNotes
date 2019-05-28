package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class l extends j<k> implements a {
    public static final String[] fnj = new String[]{j.a(k.ccO, "EmotionRewardInfo")};
    public e bSd;

    static {
        AppMethodBeat.i(62861);
        AppMethodBeat.o(62861);
    }

    public l(e eVar) {
        super(eVar, k.ccO, "EmotionRewardInfo", null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final GetEmotionRewardResponse aqq(String str) {
        GetEmotionRewardResponse getEmotionRewardResponse = null;
        AppMethodBeat.i(62860);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
            AppMethodBeat.o(62860);
        } else {
            String[] strArr = new String[]{b.CONTENT};
            String[] strArr2 = new String[]{str};
            Cursor a = this.bSd.a("EmotionRewardInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                try {
                    GetEmotionRewardResponse getEmotionRewardResponse2 = new GetEmotionRewardResponse();
                    getEmotionRewardResponse2.parseFrom(a.getBlob(0));
                    getEmotionRewardResponse = getEmotionRewardResponse2;
                } catch (IOException e) {
                    ab.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", bo.l(e));
                }
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(62860);
        }
        return getEmotionRewardResponse;
    }
}

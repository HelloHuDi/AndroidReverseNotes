package com.tencent.p177mm.storage.emotion;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.storage.emotion.l */
public final class C23519l extends C7563j<C44226k> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C44226k.ccO, "EmotionRewardInfo")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(62861);
        AppMethodBeat.m2505o(62861);
    }

    public C23519l(C4927e c4927e) {
        super(c4927e, C44226k.ccO, "EmotionRewardInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    public final GetEmotionRewardResponse aqq(String str) {
        GetEmotionRewardResponse getEmotionRewardResponse = null;
        AppMethodBeat.m2504i(62860);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
            AppMethodBeat.m2505o(62860);
        } else {
            String[] strArr = new String[]{C8741b.CONTENT};
            String[] strArr2 = new String[]{str};
            Cursor a = this.bSd.mo10105a("EmotionRewardInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                try {
                    GetEmotionRewardResponse getEmotionRewardResponse2 = new GetEmotionRewardResponse();
                    getEmotionRewardResponse2.parseFrom(a.getBlob(0));
                    getEmotionRewardResponse = getEmotionRewardResponse2;
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", C5046bo.m7574l(e));
                }
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(62860);
        }
        return getEmotionRewardResponse;
    }
}

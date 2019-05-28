package com.tencent.p177mm.storage.emotion;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.storage.emotion.j */
public final class C44225j extends C7563j<C44224i> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C44224i.ccO, "EmotionDetailInfo")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(62858);
        AppMethodBeat.m2505o(62858);
    }

    public C44225j(C4927e c4927e) {
        super(c4927e, C44224i.ccO, "EmotionDetailInfo", null);
        this.bSd = c4927e;
    }

    public final String getTableName() {
        return "EmotionDetailInfo";
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    public final C44224i aqp(String str) {
        C44224i c44224i = null;
        AppMethodBeat.m2504i(62857);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
            AppMethodBeat.m2505o(62857);
        } else {
            String[] strArr = new String[]{C8741b.CONTENT, "lan"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.bSd.mo10105a("EmotionDetailInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                c44224i = new C44224i();
                c44224i.field_content = a.getBlob(0);
                c44224i.field_lan = a.getString(1);
                c44224i.field_productID = str;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(62857);
        }
        return c44224i;
    }
}

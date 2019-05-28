package com.tencent.p177mm.plugin.sns.p514a.p515b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelstat.C26485p;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.sns.a.b.f */
public final class C13341f {
    /* renamed from: a */
    public static void m21441a(String str, C32831d c32831d) {
        AppMethodBeat.m2504i(35711);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        if (YS != null) {
            TimeLineObject cqu = YS.cqu();
            if (cqu != null) {
                C26485p.m42202a(cqu.rjC, c32831d);
                AppMethodBeat.m2505o(35711);
                return;
            }
            C4990ab.m7419v("SnsAdExtUtil", "timeLineObject null, snsId %s", str);
            AppMethodBeat.m2505o(35711);
            return;
        }
        C4990ab.m7419v("SnsAdExtUtil", "snsInfo null, snsId %s", str);
        AppMethodBeat.m2505o(35711);
    }

    /* renamed from: a */
    public static String m21438a(long j, Object... objArr) {
        AppMethodBeat.m2504i(35712);
        C13373af.cnz();
        StringBuilder stringBuilder = new StringBuilder(C13348i.m21468s(objArr));
        C13341f.m21440a(j, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(35712);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static void m21440a(long j, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(35713);
        C43570e ku = C13373af.cnI().mo69174ku(j);
        if (ku != null) {
            TimeLineObject cqu = ku.cqu();
            if (cqu != null) {
                C26485p.m42203a(cqu.rjC, stringBuilder);
                AppMethodBeat.m2505o(35713);
                return;
            }
            C4990ab.m7419v("SnsAdExtUtil", "l timeLineObject null, snsId %d", Long.valueOf(j));
            stringBuilder.append(",,");
            AppMethodBeat.m2505o(35713);
            return;
        }
        C4990ab.m7419v("SnsAdExtUtil", "l snsInfo null, snsId %d", Long.valueOf(j));
        stringBuilder.append(",,");
        AppMethodBeat.m2505o(35713);
    }

    /* renamed from: a */
    public static String m21439a(TimeLineObject timeLineObject) {
        AppMethodBeat.m2504i(35714);
        if (timeLineObject != null) {
            String WW = C13341f.m21437WW(timeLineObject.rjC);
            AppMethodBeat.m2505o(35714);
            return WW;
        }
        C4990ab.m7418v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
        AppMethodBeat.m2505o(35714);
        return null;
    }

    /* renamed from: WW */
    private static String m21437WW(String str) {
        AppMethodBeat.m2504i(35715);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(35715);
            return str2;
        }
        byte[] decode = Base64.decode(str, 0);
        cdg cdg = new cdg();
        try {
            cdg.parseFrom(decode);
            str2 = C26485p.m42200a(cdg.xcS);
            AppMethodBeat.m2505o(35715);
            return str2;
        } catch (IOException e) {
            C4990ab.m7413e("SnsAdExtUtil", "", e);
            str2 = "";
            AppMethodBeat.m2505o(35715);
            return str2;
        }
    }
}

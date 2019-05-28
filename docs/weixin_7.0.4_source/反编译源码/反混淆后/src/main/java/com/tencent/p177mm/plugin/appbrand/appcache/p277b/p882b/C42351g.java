package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C2060e;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.protocal.protobuf.axr;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.protocal.protobuf.cxw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.g */
public class C42351g extends C38108a<Boolean, cxw> {
    /* renamed from: b */
    public final /* synthetic */ Object mo21442b(String str, String str2, Object obj) {
        AppMethodBeat.m2504i(129475);
        Boolean a = C42351g.m74902a(str, str2, (cxw) obj);
        AppMethodBeat.m2505o(129475);
        return a;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    /* renamed from: bm */
    public final /* bridge */ /* synthetic */ cxp mo21443bm(Object obj) {
        return ((cxw) obj).xsZ;
    }

    /* renamed from: a */
    private static Boolean m74902a(String str, String str2, cxw cxw) {
        AppMethodBeat.m2504i(129474);
        String str3 = cxw.xto;
        Boolean bool;
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129474);
            return bool;
        } else if (C5046bo.m7548ek(cxw.xkP)) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129474);
            return bool;
        } else {
            try {
                byte[] decode = Base64.decode(str3, 0);
                axr axr = new axr();
                axr.parseFrom(decode);
                C19050a c19050a;
                if (axr.wBJ.vYw.f1226wR.length == 0) {
                    C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", str, str2);
                    c19050a = C19050a.gWl;
                    C19050a.m29623z((long) cxw.xsZ.xsX, 105);
                    bool = Boolean.FALSE;
                    AppMethodBeat.m2505o(129474);
                    return bool;
                }
                int i;
                c19050a = C19050a.gWl;
                C19050a.m29623z((long) cxw.xsZ.xsX, 104);
                LinkedList<Object> linkedList = cxw.xkP;
                long j = ((long) cxw.xtp) & 4294967295L;
                long j2 = ((long) cxw.xtq) & 4294967295L;
                String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueLaunch";
                String str5 = "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                if (linkedList == null) {
                    str3 = BuildConfig.COMMAND;
                } else if (C5046bo.m7548ek(linkedList)) {
                    str3 = "{}";
                } else {
                    StringBuilder stringBuilder = new StringBuilder("{");
                    for (Object obj : linkedList) {
                        stringBuilder.append(obj.toString()).append(',');
                    }
                    stringBuilder.append("}");
                    str3 = stringBuilder.toString();
                }
                objArr[2] = str3;
                objArr[3] = Long.valueOf(j);
                objArr[4] = Long.valueOf(j2);
                C4990ab.m7417i(str4, str5, objArr);
                boolean a = ((C2060e) C42340f.m74878E(C2060e.class)).mo5825a(decode, str2, linkedList, j, j2);
                c19050a = C19050a.gWl;
                int i2 = cxw.xsZ.xsX;
                if (a) {
                    i = 107;
                } else {
                    i = 108;
                }
                C19050a.m29623z((long) i2, (long) i);
                bool = Boolean.valueOf(a);
                AppMethodBeat.m2505o(129474);
                return bool;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", e, "call[%s | %s], decode base64", str, str2);
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(129474);
                return bool;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdIssueLaunch";
    }
}

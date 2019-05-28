package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C38112a;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45513b;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.protocal.protobuf.cxq;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.b */
public class C33085b extends C38108a<Boolean, cxq> {
    /* Access modifiers changed, original: final|synthetic */
    /* renamed from: b */
    public final /* synthetic */ Object mo21442b(String str, String str2, Object obj) {
        boolean z;
        int i = -1;
        AppMethodBeat.m2504i(129460);
        cxq cxq = (cxq) obj;
        C45513b c45513b = (C45513b) C42340f.m74878E(C45513b.class);
        if (C5046bo.m7548ek(cxq.xkP) || C5046bo.m7548ek(cxq.xta)) {
            int i2;
            String str3 = "MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage";
            String str4 = "saveBlockList with username(%s) appId(%s) sceneList.size(%d), blockCgi.size(%d), skip";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            if (cxq.xkP == null) {
                i2 = -1;
            } else {
                i2 = cxq.xkP.size();
            }
            objArr[2] = Integer.valueOf(i2);
            if (cxq.xta != null) {
                i = cxq.xta.size();
            }
            objArr[3] = Integer.valueOf(i);
            C4990ab.m7413e(str3, str4, objArr);
            z = false;
        } else {
            C38112a c38112a = new C38112a();
            c38112a.field_username = str;
            boolean b = c45513b.mo10102b((C4925c) c38112a, new String[0]);
            c38112a.field_appId = str2;
            c38112a.field_startTime = (long) cxq.xtb;
            c38112a.field_endTime = (long) cxq.xtc;
            StringBuilder stringBuilder = new StringBuilder(";");
            Iterator it = cxq.xkP.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Integer) it.next()).intValue()).append(";");
            }
            c38112a.field_sceneList = stringBuilder.toString();
            stringBuilder = new StringBuilder(";");
            it = cxq.xta.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Integer) it.next()).intValue()).append(";");
            }
            c38112a.field_cgiList = stringBuilder.toString();
            c38112a.field_reportId = cxq.xsZ.xsX;
            C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage", "saveBlockList, record( %s ), doUpdate %b", c38112a, Boolean.valueOf(b));
            z = b ? c45513b.mo10103c(c38112a, new String[0]) : c45513b.mo10101b((C4925c) c38112a);
        }
        C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdBlockCgiRequest", "saveBlockList with username(%s) appId(%s), ret %b", str, str2, Boolean.valueOf(z));
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.m2505o(129460);
        return valueOf;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    /* renamed from: bm */
    public final /* bridge */ /* synthetic */ cxp mo21443bm(Object obj) {
        return ((cxq) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdBlockCgiRequest";
    }
}

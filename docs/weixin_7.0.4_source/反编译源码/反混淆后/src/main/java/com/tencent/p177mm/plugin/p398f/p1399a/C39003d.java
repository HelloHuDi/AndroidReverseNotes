package com.tencent.p177mm.plugin.p398f.p1399a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.f.a.d */
public final class C39003d extends C45911a {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: Q */
    public final List<C34092a> mo45810Q(C7620bi c7620bi) {
        AppMethodBeat.m2504i(18621);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(18621);
            return null;
        }
        C25822e w = C32291o.ahl().mo73124w(c7620bi);
        if (w == null || w.fDy == 0) {
            C4990ab.m7421w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", aZm());
            AppMethodBeat.m2505o(18621);
            return null;
        }
        String q = C32291o.ahl().mo73118q(w.fDz, "", "");
        long asZ = C5730e.asZ(q);
        String q2 = C32291o.ahl().mo73118q(w.fDB, "", "");
        long asZ2 = C5730e.asZ(q2);
        String str = C32291o.ahl().mo73118q(w.fDB, "", "") + "hd";
        long asZ3 = C5730e.asZ(str);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        if (w.agQ()) {
            w = C32291o.ahl().mo73116ly(w.fDJ);
            if (w != null) {
                str2 = C32291o.ahl().mo73118q(w.fDz, "", "");
                if (!C5046bo.isEqual(str2, q)) {
                    j = C5730e.asZ(str2);
                }
                str3 = C32291o.ahl().mo73118q(w.fDB, "", "");
                if (!C5046bo.isEqual(str3, q2)) {
                    j2 = C5730e.asZ(str3);
                }
                str4 = C32291o.ahl().mo73118q(w.fDB, "", "") + "hd";
                if (!C5046bo.isEqual(str4, str)) {
                    j3 = C5730e.asZ(str4);
                }
            }
        }
        C34092a R = C45911a.m85147R(c7620bi);
        R.field_msgSubType = 20;
        R.field_path = mo73746Gh(q);
        R.field_size = asZ;
        C34092a R2 = C45911a.m85147R(c7620bi);
        R2.field_msgSubType = 21;
        R2.field_path = mo73746Gh(q2);
        R2.field_size = asZ2;
        C34092a R3 = C45911a.m85147R(c7620bi);
        R3.field_msgSubType = 22;
        R3.field_path = mo73746Gh(str);
        R3.field_size = asZ3;
        C34092a R4 = C45911a.m85147R(c7620bi);
        R4.field_msgSubType = 23;
        R4.field_path = mo73746Gh(str2);
        R4.field_size = j;
        C34092a R5 = C45911a.m85147R(c7620bi);
        R5.field_msgSubType = 24;
        R5.field_path = mo73746Gh(str3);
        R5.field_size = j2;
        C34092a R6 = C45911a.m85147R(c7620bi);
        R6.field_msgSubType = 25;
        R6.field_path = mo73746Gh(str4);
        R6.field_size = j3;
        C4990ab.m7417i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", aZm(), R, R2, R3, R4, R5, R6);
        List<C34092a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        arrayList.add(R3);
        arrayList.add(R4);
        arrayList.add(R5);
        arrayList.add(R6);
        AppMethodBeat.m2505o(18621);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.m2504i(18622);
        String str = "image_" + hashCode();
        AppMethodBeat.m2505o(18622);
        return str;
    }
}

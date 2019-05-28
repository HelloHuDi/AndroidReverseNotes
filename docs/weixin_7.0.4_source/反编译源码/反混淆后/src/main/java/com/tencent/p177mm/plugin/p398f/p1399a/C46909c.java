package com.tencent.p177mm.plugin.p398f.p1399a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.f.a.c */
public final class C46909c extends C45911a {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: Q */
    public final List<C34092a> mo45810Q(C7620bi c7620bi) {
        long j = 0;
        String str = null;
        AppMethodBeat.m2504i(18619);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(18619);
            return null;
        }
        C8910b me;
        String anj = C5046bo.anj(c7620bi.field_content);
        if (anj != null) {
            me = C8910b.m16064me(anj);
        } else {
            me = null;
        }
        if (me == null) {
            C4990ab.m7412e("MicroMsg.AppMsgMsgHandler", "content is null");
            AppMethodBeat.m2505o(18619);
            return null;
        }
        int i;
        C34092a R = C45911a.m85147R(c7620bi);
        C30065b aiE;
        switch (me.type) {
            case 2:
                aiE = C14877am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                    j = C5730e.asZ(str);
                }
                R.field_msgSubType = 30;
                R.field_path = mo73746Gh(str);
                R.field_size = j;
                i = 31;
                break;
            case 6:
                aiE = C14877am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                    j = C5730e.asZ(str);
                }
                R.field_msgSubType = 34;
                R.field_path = mo73746Gh(str);
                R.field_size = j;
                i = 35;
                break;
            case 7:
                aiE = C14877am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                    j = C5730e.asZ(str);
                }
                R.field_msgSubType = 32;
                R.field_path = mo73746Gh(str);
                R.field_size = j;
                i = 33;
                break;
            default:
                AppMethodBeat.m2505o(18619);
                return null;
        }
        String I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
        long asZ = C5730e.asZ(I);
        C34092a R2 = C45911a.m85147R(c7620bi);
        R2.field_msgSubType = i;
        R2.field_path = mo73746Gh(I);
        R2.field_size = asZ;
        C4990ab.m7417i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", aZm(), R, R2);
        List<C34092a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        AppMethodBeat.m2505o(18619);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.m2504i(18620);
        String str = "AppMsg_" + hashCode();
        AppMethodBeat.m2505o(18620);
        return str;
    }
}

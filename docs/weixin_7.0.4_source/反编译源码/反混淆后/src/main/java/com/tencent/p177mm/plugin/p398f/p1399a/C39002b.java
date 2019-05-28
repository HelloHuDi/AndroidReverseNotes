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

/* renamed from: com.tencent.mm.plugin.f.a.b */
public final class C39002b extends C45911a {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: Q */
    public final List<C34092a> mo45810Q(C7620bi c7620bi) {
        String str = null;
        AppMethodBeat.m2504i(18617);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(18617);
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
            C4990ab.m7412e("MicroMsg.AppMsgImgMsgHandler", "content is null");
            AppMethodBeat.m2505o(18617);
            return null;
        }
        C34092a R = C45911a.m85147R(c7620bi);
        C30065b aiE = C14877am.aUq().aiE(me.csD);
        long j = 0;
        if (aiE != null) {
            str = aiE.field_fileFullPath;
            j = C5730e.asZ(str);
        }
        R.field_msgSubType = 30;
        R.field_path = mo73746Gh(str);
        R.field_size = j;
        anj = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
        long asZ = C5730e.asZ(anj);
        C34092a R2 = C45911a.m85147R(c7620bi);
        R2.field_msgSubType = 31;
        R2.field_path = mo73746Gh(anj);
        R2.field_size = asZ;
        C4990ab.m7417i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", aZm(), R, R2);
        List<C34092a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        AppMethodBeat.m2505o(18617);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.m2504i(18618);
        String str = "AppMsgImg_" + hashCode();
        AppMethodBeat.m2505o(18618);
        return str;
    }
}

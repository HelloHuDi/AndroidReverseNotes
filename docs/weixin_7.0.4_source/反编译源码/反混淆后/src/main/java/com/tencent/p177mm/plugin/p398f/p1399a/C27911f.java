package com.tencent.p177mm.plugin.p398f.p1399a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.f.a.f */
public final class C27911f extends C45911a {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: Q */
    public final List<C34092a> mo45810Q(C7620bi c7620bi) {
        AppMethodBeat.m2504i(18625);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(18625);
            return null;
        }
        C34092a R = C45911a.m85147R(c7620bi);
        String fullPath = C32850q.getFullPath(c7620bi.field_imgPath);
        long cs = (long) C1173e.m2560cs(fullPath);
        R.field_msgSubType = 10;
        R.field_path = mo73746Gh(fullPath);
        R.field_size = cs;
        C4990ab.m7417i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", aZm(), R);
        List<C34092a> arrayList = new ArrayList();
        arrayList.add(R);
        AppMethodBeat.m2505o(18625);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.m2504i(18626);
        String str = "voice_" + hashCode();
        AppMethodBeat.m2505o(18626);
        return str;
    }
}

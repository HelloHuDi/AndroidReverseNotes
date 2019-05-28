package com.tencent.p177mm.plugin.p398f.p1399a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.f.a.e */
public final class C27910e extends C45911a {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: Q */
    public final List<C34092a> mo45810Q(C7620bi c7620bi) {
        AppMethodBeat.m2504i(18623);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(18623);
            return null;
        }
        C37961o.all();
        String uh = C9720t.m17303uh(c7620bi.field_imgPath);
        long asZ = C5730e.asZ(uh);
        C34092a R = C45911a.m85147R(c7620bi);
        R.field_msgSubType = 1;
        R.field_path = mo73746Gh(uh);
        R.field_size = asZ;
        C37961o.all();
        uh = C9720t.m17304ui(c7620bi.field_imgPath);
        asZ = C5730e.asZ(uh);
        C34092a R2 = C45911a.m85147R(c7620bi);
        R2.field_msgSubType = 2;
        R2.field_path = mo73746Gh(uh);
        R2.field_size = asZ;
        C4990ab.m7417i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", aZm(), R, R2);
        List<C34092a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        AppMethodBeat.m2505o(18623);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.m2504i(18624);
        String str = "video_" + hashCode();
        AppMethodBeat.m2505o(18624);
        return str;
    }
}

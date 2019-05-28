package com.tencent.p177mm.plugin.websearch.p1064c.p1065a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.websearch.c.a.e */
public final class C35579e extends C29745a<C29746a> {
    public List<C29746a> mFf = Collections.emptyList();

    /* renamed from: com.tencent.mm.plugin.websearch.c.a.e$a */
    public static class C29746a {
        public String bCu;
        public String dFl;
        public String desc;
        public String hHV;
        public String ucj;
        public String userName;
    }

    public C35579e(String str) {
        super(str);
        AppMethodBeat.m2504i(91376);
        AppMethodBeat.m2505o(91376);
    }

    /* renamed from: dZ */
    public final void mo47990dZ(List<C45966l> list) {
        AppMethodBeat.m2504i(91377);
        this.mFf = new ArrayList(list.size());
        for (C45966l c45966l : list) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c45966l.mDx);
            C29746a c29746a = new C29746a();
            c29746a.userName = aoO.field_username;
            c29746a.ucj = c45966l.content;
            c29746a.bCu = aoO.field_nickname;
            c29746a.hHV = aoO.field_conRemark;
            c29746a.dFl = aoO.mo14673Hq();
            c29746a.desc = aoO.dul;
            this.mFf.add(c29746a);
        }
        AppMethodBeat.m2505o(91377);
    }
}

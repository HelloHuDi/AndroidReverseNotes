package com.tencent.p177mm.pluginsdk.p597ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.d */
public final class C4739d implements C46502p {
    public final boolean ajy(String str) {
        AppMethodBeat.m2504i(11682);
        boolean kq = C17903f.m28103kq(str);
        AppMethodBeat.m2505o(11682);
        return kq;
    }

    public final Object ajz(String str) {
        AppMethodBeat.m2504i(11683);
        Object cH = C41747z.aeV().mo60356cH(str);
        if (cH == null || C5046bo.isNullOrNil(cH.field_userId) || !cH.field_userId.equals(str)) {
            cH = new C45143j();
            cH.field_userId = str;
        }
        AppMethodBeat.m2505o(11683);
        return cH;
    }

    public final C25814c ajA(String str) {
        AppMethodBeat.m2504i(11684);
        C17927a c17927a = new C17927a();
        c17927a.ePK = C25754e.m40912rz(str);
        c17927a.ePH = true;
        c17927a.ePZ = true;
        c17927a.ePT = C1318a.default_avatar;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(11684);
        return ahG;
    }

    /* renamed from: cu */
    public final String mo9886cu(Object obj) {
        return ((C45143j) obj).field_userName;
    }

    /* renamed from: cv */
    public final String mo9887cv(Object obj) {
        return ((C45143j) obj).field_headImageUrl;
    }

    /* renamed from: cw */
    public final String mo9888cw(Object obj) {
        return ((C45143j) obj).field_userId;
    }
}

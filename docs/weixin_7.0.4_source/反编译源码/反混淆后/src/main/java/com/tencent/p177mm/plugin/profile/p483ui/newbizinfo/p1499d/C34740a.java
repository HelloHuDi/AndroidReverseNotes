package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1499d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.d.a */
public final class C34740a extends C7563j<C46140d> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C46140d.fjX, "ProfileInfo")};
    public static final String[] fjZ = new String[0];

    static {
        AppMethodBeat.m2504i(23959);
        AppMethodBeat.m2505o(23959);
    }

    public C34740a(C4927e c4927e) {
        super(c4927e, C46140d.fjX, "ProfileInfo", fjZ);
    }

    /* renamed from: Va */
    public final C46140d mo55342Va(String str) {
        AppMethodBeat.m2504i(23958);
        C46140d c46140d = new C46140d();
        c46140d.field_username = str;
        if (mo10102b((C4925c) c46140d, "username")) {
            C4990ab.m7417i("MicroMsg.ProfileInfoStorage", "get username:%s", c46140d.field_username);
            AppMethodBeat.m2505o(23958);
            return c46140d;
        }
        C4990ab.m7412e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
        AppMethodBeat.m2505o(23958);
        return null;
    }
}

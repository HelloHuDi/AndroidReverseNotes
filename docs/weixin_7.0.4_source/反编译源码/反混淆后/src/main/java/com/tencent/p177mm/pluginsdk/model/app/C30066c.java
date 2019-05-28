package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.model.app.c */
public final class C30066c extends C7563j<C30065b> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C30065b.ccO, "appattach")};
    C4927e bSd;

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(79235);
        boolean a = mo48326a((C30065b) c4925c, strArr);
        AppMethodBeat.m2505o(79235);
        return a;
    }

    static {
        AppMethodBeat.m2504i(79236);
        AppMethodBeat.m2505o(79236);
    }

    public C30066c(C4927e c4927e) {
        super(c4927e, C30065b.ccO, "appattach", null);
        this.bSd = c4927e;
    }

    /* renamed from: lY */
    public final void mo48328lY(long j) {
        AppMethodBeat.m2504i(79231);
        this.bSd.mo10108hY("appattach", " update appattach set status = 198 , lastModifyTime = " + C5046bo.anT() + " where rowid = " + j);
        doNotify();
        AppMethodBeat.m2505o(79231);
    }

    public final C30065b aiE(String str) {
        AppMethodBeat.m2504i(79232);
        C30065b c30065b = new C30065b();
        c30065b.field_mediaSvrId = str;
        if (mo10102b((C4925c) c30065b, "mediaSvrId")) {
            AppMethodBeat.m2505o(79232);
            return c30065b;
        }
        if (mo10102b((C4925c) c30065b, "mediaId")) {
            AppMethodBeat.m2505o(79232);
            return c30065b;
        }
        AppMethodBeat.m2505o(79232);
        return null;
    }

    /* renamed from: a */
    public final boolean mo48326a(C30065b c30065b, String... strArr) {
        AppMethodBeat.m2504i(79233);
        C4990ab.m7411d("MicroMsg.AppAttachInfoStorage", "update AppAttachInfo field_mediaId %s field_mediaSvrId %s ret %s %s", c30065b.field_mediaId, c30065b.field_mediaSvrId, Boolean.valueOf(super.mo10103c(c30065b, strArr)), "");
        AppMethodBeat.m2505o(79233);
        return super.mo10103c(c30065b, strArr);
    }

    /* renamed from: lZ */
    public final C30065b mo48329lZ(long j) {
        AppMethodBeat.m2504i(79234);
        C30065b c30065b = new C30065b();
        c30065b.field_msgInfoId = j;
        if (mo10102b((C4925c) c30065b, "msgInfoId")) {
            AppMethodBeat.m2505o(79234);
            return c30065b;
        }
        AppMethodBeat.m2505o(79234);
        return null;
    }
}

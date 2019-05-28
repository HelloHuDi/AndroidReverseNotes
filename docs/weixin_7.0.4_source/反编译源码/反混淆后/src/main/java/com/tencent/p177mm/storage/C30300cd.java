package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.storage.cd */
public final class C30300cd extends C7563j<C23514cc> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C23514cc.ccO, "VoiceTransText")};
    public C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(116826);
        boolean a = mo48507a((C23514cc) c4925c);
        AppMethodBeat.m2505o(116826);
        return a;
    }

    static {
        AppMethodBeat.m2504i(116827);
        AppMethodBeat.m2505o(116827);
    }

    public C30300cd(C4927e c4927e) {
        this(c4927e, C23514cc.ccO, "VoiceTransText");
    }

    private C30300cd(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* renamed from: a */
    public final boolean mo48507a(C23514cc c23514cc) {
        AppMethodBeat.m2504i(116824);
        if (c23514cc == null) {
            AppMethodBeat.m2505o(116824);
            return false;
        }
        if (this.bSd.replace("VoiceTransText", "msgId", c23514cc.mo10098Hl()) >= 0) {
            AppMethodBeat.m2505o(116824);
            return true;
        }
        AppMethodBeat.m2505o(116824);
        return false;
    }

    public final C23514cc aqb(String str) {
        AppMethodBeat.m2504i(116825);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116825);
            return null;
        }
        C23514cc c23514cc = new C23514cc();
        Cursor a = this.bSd.mo10105a("VoiceTransText", null, "cmsgId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c23514cc.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(116825);
        return c23514cc;
    }
}

package com.tencent.p177mm.plugin.order.p767b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.order.b.b */
public final class C7607b extends C7563j<C34658a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C34658a.ccO, "OrderCommonMsgXml")};
    private C4927e bSd;

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(43796);
        boolean b = super.mo10101b((C34658a) c4925c);
        AppMethodBeat.m2505o(43796);
        return b;
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(43795);
        boolean c = super.mo10103c((C34658a) c4925c, strArr);
        AppMethodBeat.m2505o(43795);
        return c;
    }

    static {
        AppMethodBeat.m2504i(43797);
        AppMethodBeat.m2505o(43797);
    }

    public C7607b(C4927e c4927e) {
        super(c4927e, C34658a.ccO, "OrderCommonMsgXml", null);
        this.bSd = c4927e;
    }

    public final Cursor baR() {
        AppMethodBeat.m2504i(43793);
        Cursor rawQuery = this.bSd.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
        AppMethodBeat.m2505o(43793);
        return rawQuery;
    }

    /* renamed from: a */
    public final boolean mo17048a(C34658a c34658a) {
        AppMethodBeat.m2504i(43794);
        boolean b = super.mo10101b((C4925c) c34658a);
        AppMethodBeat.m2505o(43794);
        return b;
    }
}

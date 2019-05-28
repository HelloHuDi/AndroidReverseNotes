package com.tencent.p177mm.plugin.account.security.p880a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.security.a.e */
public final class C18849e extends C7563j<C18848d> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C18848d.ccO, "SafeDeviceInfo")};
    C7480h gzi = null;

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(69840);
        boolean b = super.mo10101b((C18848d) c4925c);
        AppMethodBeat.m2505o(69840);
        return b;
    }

    static {
        AppMethodBeat.m2504i(69841);
        AppMethodBeat.m2505o(69841);
    }

    public C18849e(C4927e c4927e) {
        super(c4927e, C18848d.ccO, "SafeDeviceInfo", null);
        AppMethodBeat.m2504i(69836);
        if (c4927e instanceof C7480h) {
            this.gzi = (C7480h) c4927e;
        }
        AppMethodBeat.m2505o(69836);
    }

    /* renamed from: a */
    public final boolean mo34121a(C18848d c18848d) {
        AppMethodBeat.m2504i(69837);
        boolean b = super.mo10101b((C4925c) c18848d);
        AppMethodBeat.m2505o(69837);
        return b;
    }

    public final List<C18848d> aqD() {
        AppMethodBeat.m2504i(69838);
        LinkedList linkedList = new LinkedList();
        if (getCount() > 0) {
            Cursor baR = super.baR();
            while (baR.moveToNext()) {
                C18848d c18848d = new C18848d();
                c18848d.mo8995d(baR);
                linkedList.add(c18848d);
            }
            baR.close();
        }
        AppMethodBeat.m2505o(69838);
        return linkedList;
    }
}

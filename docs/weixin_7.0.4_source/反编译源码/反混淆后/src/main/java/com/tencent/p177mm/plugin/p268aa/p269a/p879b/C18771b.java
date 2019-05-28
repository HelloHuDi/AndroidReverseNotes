package com.tencent.p177mm.plugin.p268aa.p269a.p879b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.aa.a.b.b */
public final class C18771b extends C7563j<C31278a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C31278a.ccO, "AAPayRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(40665);
        AppMethodBeat.m2505o(40665);
    }

    public C18771b(C4927e c4927e) {
        super(c4927e, C31278a.ccO, "AAPayRecord", null);
        this.bSd = c4927e;
    }

    /* renamed from: vG */
    public final C31278a mo34041vG(String str) {
        AppMethodBeat.m2504i(40664);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(40664);
            return null;
        }
        Cursor a = this.bSd.mo10105a("AAPayRecord", gmr, "payMsgId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                C31278a c31278a = new C31278a();
                c31278a.mo8995d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(40664);
                return c31278a;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(40664);
            return null;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AAPayRecordStorage", "getByPayMsgId error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(40664);
        }
    }
}

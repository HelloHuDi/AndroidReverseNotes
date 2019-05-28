package com.tencent.p177mm.plugin.p268aa.p269a.p879b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.a.b.d */
public final class C9795d extends C7563j<C26535c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C26535c.ccO, "AARecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    public static Map<String, C26535c> gms = new HashMap();
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(40674);
        AppMethodBeat.m2505o(40674);
    }

    public C9795d(C4927e c4927e) {
        super(c4927e, C26535c.ccO, "AARecord", null);
        this.bSd = c4927e;
    }

    /* renamed from: vH */
    public final C26535c mo21152vH(String str) {
        AppMethodBeat.m2504i(40667);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(40667);
            return null;
        }
        Cursor a = this.bSd.mo10105a("AARecord", gmr, "billNo=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                C26535c c26535c = new C26535c();
                c26535c.mo8995d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(40667);
                return c26535c;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(40667);
            return null;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AARecordStorage", "getRecordByBillno error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(40667);
        }
    }

    /* renamed from: a */
    public final boolean mo21149a(C26535c c26535c) {
        AppMethodBeat.m2504i(40668);
        if (c26535c != null && gms.containsKey(c26535c.field_billNo)) {
            gms.put(c26535c.field_billNo, c26535c);
        }
        boolean b = super.mo10101b((C4925c) c26535c);
        AppMethodBeat.m2505o(40668);
        return b;
    }

    /* renamed from: a */
    public final boolean mo21150a(C26535c c26535c, String... strArr) {
        AppMethodBeat.m2504i(40669);
        if (c26535c != null && gms.containsKey(c26535c.field_billNo)) {
            gms.remove(c26535c.field_billNo);
        }
        boolean a = super.mo16760a((C4925c) c26535c, strArr);
        AppMethodBeat.m2505o(40669);
        return a;
    }

    /* renamed from: b */
    public final boolean mo21151b(C26535c c26535c) {
        AppMethodBeat.m2504i(40670);
        if (c26535c != null && gms.containsKey(c26535c.field_billNo)) {
            gms.put(c26535c.field_billNo, c26535c);
        }
        boolean a = super.mo10099a(c26535c);
        AppMethodBeat.m2505o(40670);
        return a;
    }
}

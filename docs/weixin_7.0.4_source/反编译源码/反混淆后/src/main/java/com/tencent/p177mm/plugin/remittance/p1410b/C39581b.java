package com.tencent.p177mm.plugin.remittance.p1410b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.remittance.b.b */
public final class C39581b extends C7563j<C28857a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C28857a.ccO, "DelayTransferRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(44705);
        AppMethodBeat.m2505o(44705);
    }

    public C39581b(C4927e c4927e) {
        super(c4927e, C28857a.ccO, "DelayTransferRecord", null);
        this.bSd = c4927e;
    }

    /* renamed from: VM */
    public final C28857a mo62547VM(String str) {
        AppMethodBeat.m2504i(44704);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.AARecordStorage", "empty transferId");
            AppMethodBeat.m2505o(44704);
            return null;
        }
        Cursor a = this.bSd.mo10105a("DelayTransferRecord", gmr, "transferId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                C28857a c28857a = new C28857a();
                c28857a.mo8995d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(44704);
                return c28857a;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(44704);
            return null;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AARecordStorage", e, "", new Object[0]);
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(44704);
        }
    }
}

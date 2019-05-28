package com.tencent.p177mm.plugin.remittance.p1410b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.remittance.b.d */
public final class C39582d extends C7563j<C46168c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46168c.ccO, "RemittanceRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    public static Map<String, C46168c> gms = new HashMap();
    private C4927e bSd;

    /* renamed from: a */
    public final /* synthetic */ boolean mo16760a(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(44710);
        c4925c = (C46168c) c4925c;
        if (c4925c != null && gms.containsKey(c4925c.field_transferId)) {
            gms.remove(c4925c.field_transferId);
        }
        boolean a = super.mo16760a(c4925c, strArr);
        AppMethodBeat.m2505o(44710);
        return a;
    }

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(44711);
        c4925c = (C46168c) c4925c;
        if (c4925c != null && gms.containsKey(c4925c.field_transferId)) {
            gms.put(c4925c.field_transferId, c4925c);
        }
        boolean b = super.mo10101b(c4925c);
        AppMethodBeat.m2505o(44711);
        return b;
    }

    static {
        AppMethodBeat.m2504i(44712);
        AppMethodBeat.m2505o(44712);
    }

    public C39582d(C4927e c4927e) {
        super(c4927e, C46168c.ccO, "RemittanceRecord", null);
        this.bSd = c4927e;
    }

    /* renamed from: VN */
    public final C46168c mo62548VN(String str) {
        AppMethodBeat.m2504i(44707);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(44707);
            return null;
        }
        Cursor a = this.bSd.mo10105a("RemittanceRecord", gmr, "transferId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                C46168c c46168c = new C46168c();
                c46168c.mo8995d(a);
                a.close();
                AppMethodBeat.m2505o(44707);
                return c46168c;
            }
            a.close();
            AppMethodBeat.m2505o(44707);
            return null;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", e, "getRecordByTransferId error: %s", e.getMessage());
            a.close();
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.m2505o(44707);
        }
    }

    /* renamed from: a */
    public final boolean mo62549a(C46168c c46168c) {
        AppMethodBeat.m2504i(44708);
        if (c46168c != null && gms.containsKey(c46168c.field_transferId)) {
            gms.put(c46168c.field_transferId, c46168c);
        }
        boolean a = super.mo10099a(c46168c);
        AppMethodBeat.m2505o(44708);
        return a;
    }
}

package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "DelayTransferRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    private e bSd;

    static {
        AppMethodBeat.i(44705);
        AppMethodBeat.o(44705);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "DelayTransferRecord", null);
        this.bSd = eVar;
    }

    public final a VM(String str) {
        AppMethodBeat.i(44704);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.AARecordStorage", "empty transferId");
            AppMethodBeat.o(44704);
            return null;
        }
        Cursor a = this.bSd.a("DelayTransferRecord", gmr, "transferId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                a aVar = new a();
                aVar.d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(44704);
                return aVar;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(44704);
            return null;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AARecordStorage", e, "", new Object[0]);
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(44704);
        }
    }
}

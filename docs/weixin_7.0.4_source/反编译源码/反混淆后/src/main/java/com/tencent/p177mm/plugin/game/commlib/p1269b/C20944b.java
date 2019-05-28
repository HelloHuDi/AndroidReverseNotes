package com.tencent.p177mm.plugin.game.commlib.p1269b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.game.commlib.b.b */
public final class C20944b extends C7563j<C28178a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C28178a.ccO, "PBCache")};

    static {
        AppMethodBeat.m2504i(59420);
        AppMethodBeat.m2505o(59420);
    }

    public C20944b(C4927e c4927e) {
        super(c4927e, C28178a.ccO, "PBCache", null);
    }

    /* renamed from: NK */
    public final byte[] mo36285NK(String str) {
        AppMethodBeat.m2504i(59418);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59418);
            return null;
        }
        C4925c c28178a = new C28178a();
        c28178a.field_key = str;
        if (super.mo10102b(c28178a, new String[0])) {
            byte[] bArr = c28178a.field_value;
            AppMethodBeat.m2505o(59418);
            return bArr;
        }
        AppMethodBeat.m2505o(59418);
        return null;
    }

    /* renamed from: b */
    public final boolean mo36286b(String str, C1331a c1331a) {
        boolean z = false;
        AppMethodBeat.m2504i(59419);
        if (C5046bo.isNullOrNil(str) || c1331a == null) {
            AppMethodBeat.m2505o(59419);
        } else {
            try {
                byte[] toByteArray = c1331a.toByteArray();
                if (toByteArray == null || toByteArray.length == 0) {
                    AppMethodBeat.m2505o(59419);
                } else {
                    C4925c c28178a = new C28178a();
                    c28178a.field_key = str;
                    if (super.mo10102b(c28178a, new String[0])) {
                        c28178a.field_value = toByteArray;
                        z = super.mo10103c(c28178a, new String[0]);
                    } else {
                        c28178a.field_value = toByteArray;
                        z = super.mo10101b(c28178a);
                    }
                    if (!z) {
                        C4990ab.m7412e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
                    }
                    AppMethodBeat.m2505o(59419);
                }
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.PBCacheStorage", "Saving Failed: %s", e.getMessage());
                AppMethodBeat.m2505o(59419);
            }
        }
        return z;
    }
}

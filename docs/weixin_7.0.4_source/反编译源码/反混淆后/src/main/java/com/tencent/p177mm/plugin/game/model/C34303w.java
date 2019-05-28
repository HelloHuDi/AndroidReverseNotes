package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.game.model.w */
public final class C34303w extends C7563j<C16774v> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C16774v.ccO, "GamePBCache")};

    static {
        AppMethodBeat.m2504i(111357);
        AppMethodBeat.m2505o(111357);
    }

    public C34303w(C4927e c4927e) {
        super(c4927e, C16774v.ccO, "GamePBCache", null);
    }

    /* renamed from: NK */
    public final byte[] mo54825NK(String str) {
        AppMethodBeat.m2504i(111354);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111354);
            return null;
        } else if (C4988aa.dor().equals(C20993e.bDX())) {
            C4925c c16774v = new C16774v();
            c16774v.field_key = str;
            if (super.mo10102b(c16774v, new String[0])) {
                byte[] bArr = c16774v.field_value;
                AppMethodBeat.m2505o(111354);
                return bArr;
            }
            AppMethodBeat.m2505o(111354);
            return null;
        } else {
            AppMethodBeat.m2505o(111354);
            return null;
        }
    }

    /* renamed from: b */
    public final boolean mo54826b(String str, C1331a c1331a) {
        boolean z = false;
        AppMethodBeat.m2504i(111355);
        if (C5046bo.isNullOrNil(str) || c1331a == null) {
            AppMethodBeat.m2505o(111355);
            return z;
        }
        try {
            z = mo54827w(str, c1331a.toByteArray());
            AppMethodBeat.m2505o(111355);
            return z;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", e.getMessage());
            AppMethodBeat.m2505o(111355);
            return z;
        }
    }

    /* renamed from: w */
    public final boolean mo54827w(String str, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.m2504i(111356);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(111356);
        } else {
            C4925c c16774v = new C16774v();
            c16774v.field_key = str;
            if (super.mo10102b(c16774v, new String[0])) {
                c16774v.field_value = bArr;
                z = super.mo10103c(c16774v, new String[0]);
            } else {
                c16774v.field_value = bArr;
                z = super.mo10101b(c16774v);
            }
            if (!z) {
                C4990ab.m7412e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
            }
            AppMethodBeat.m2505o(111356);
        }
        return z;
    }
}

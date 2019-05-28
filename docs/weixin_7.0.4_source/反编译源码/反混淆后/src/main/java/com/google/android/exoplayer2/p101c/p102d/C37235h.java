package com.google.android.exoplayer2.p101c.p102d;

import android.util.Pair;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.c.d.h */
public final class C37235h {
    /* renamed from: n */
    public static UUID m62446n(byte[] bArr) {
        AppMethodBeat.m2504i(95006);
        Pair o = C37235h.m62447o(bArr);
        if (o == null) {
            AppMethodBeat.m2505o(95006);
            return null;
        }
        UUID uuid = (UUID) o.first;
        AppMethodBeat.m2505o(95006);
        return uuid;
    }

    /* renamed from: o */
    private static Pair<UUID, byte[]> m62447o(byte[] bArr) {
        AppMethodBeat.m2504i(95007);
        C32065l c32065l = new C32065l(bArr);
        if (c32065l.limit < 32) {
            AppMethodBeat.m2505o(95007);
            return null;
        }
        c32065l.setPosition(0);
        if (c32065l.readInt() != c32065l.mo52382tB() + 4) {
            AppMethodBeat.m2505o(95007);
            return null;
        } else if (c32065l.readInt() != C32025a.aWB) {
            AppMethodBeat.m2505o(95007);
            return null;
        } else {
            int dT = C32025a.m52017dT(c32065l.readInt());
            if (dT > 1) {
                AppMethodBeat.m2505o(95007);
                return null;
            }
            UUID uuid = new UUID(c32065l.readLong(), c32065l.readLong());
            if (dT == 1) {
                c32065l.mo52369eM(c32065l.mo52389tI() * 16);
            }
            dT = c32065l.mo52389tI();
            if (dT != c32065l.mo52382tB()) {
                AppMethodBeat.m2505o(95007);
                return null;
            }
            byte[] bArr2 = new byte[dT];
            c32065l.readBytes(bArr2, 0, dT);
            Pair<UUID, byte[]> create = Pair.create(uuid, bArr2);
            AppMethodBeat.m2505o(95007);
            return create;
        }
    }
}

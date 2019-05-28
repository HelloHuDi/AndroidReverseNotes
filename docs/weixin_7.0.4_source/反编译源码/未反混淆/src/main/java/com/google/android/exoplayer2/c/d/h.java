package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class h {
    public static UUID n(byte[] bArr) {
        AppMethodBeat.i(95006);
        Pair o = o(bArr);
        if (o == null) {
            AppMethodBeat.o(95006);
            return null;
        }
        UUID uuid = (UUID) o.first;
        AppMethodBeat.o(95006);
        return uuid;
    }

    private static Pair<UUID, byte[]> o(byte[] bArr) {
        AppMethodBeat.i(95007);
        l lVar = new l(bArr);
        if (lVar.limit < 32) {
            AppMethodBeat.o(95007);
            return null;
        }
        lVar.setPosition(0);
        if (lVar.readInt() != lVar.tB() + 4) {
            AppMethodBeat.o(95007);
            return null;
        } else if (lVar.readInt() != a.aWB) {
            AppMethodBeat.o(95007);
            return null;
        } else {
            int dT = a.dT(lVar.readInt());
            if (dT > 1) {
                AppMethodBeat.o(95007);
                return null;
            }
            UUID uuid = new UUID(lVar.readLong(), lVar.readLong());
            if (dT == 1) {
                lVar.eM(lVar.tI() * 16);
            }
            dT = lVar.tI();
            if (dT != lVar.tB()) {
                AppMethodBeat.o(95007);
                return null;
            }
            byte[] bArr2 = new byte[dT];
            lVar.readBytes(bArr2, 0, dT);
            Pair<UUID, byte[]> create = Pair.create(uuid, bArr2);
            AppMethodBeat.o(95007);
            return create;
        }
    }
}

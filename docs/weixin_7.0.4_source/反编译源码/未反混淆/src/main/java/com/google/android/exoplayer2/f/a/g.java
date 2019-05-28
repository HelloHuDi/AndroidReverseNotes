package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    public static void a(long j, l lVar, m[] mVarArr) {
        AppMethodBeat.i(95619);
        while (lVar.tB() > 1) {
            int A = A(lVar);
            int A2 = A(lVar);
            if (A2 == -1 || A2 > lVar.tB()) {
                lVar.setPosition(lVar.limit);
            } else if (a(A, A2, lVar)) {
                lVar.eM(8);
                int readUnsignedByte = lVar.readUnsignedByte() & 31;
                lVar.eM(1);
                int i = readUnsignedByte * 3;
                int i2 = lVar.position;
                for (m mVar : mVarArr) {
                    lVar.setPosition(i2);
                    mVar.a(lVar, i);
                    mVar.a(j, 1, i, 0, null);
                }
                lVar.eM(A2 - ((readUnsignedByte * 3) + 10));
            } else {
                lVar.eM(A2);
            }
        }
        AppMethodBeat.o(95619);
    }

    private static int A(l lVar) {
        AppMethodBeat.i(95620);
        int i = 0;
        while (lVar.tB() != 0) {
            int readUnsignedByte = lVar.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                AppMethodBeat.o(95620);
                return i;
            }
        }
        AppMethodBeat.o(95620);
        return -1;
    }

    private static boolean a(int i, int i2, l lVar) {
        AppMethodBeat.i(95621);
        if (i != 4 || i2 < 8) {
            AppMethodBeat.o(95621);
            return false;
        }
        int i3 = lVar.position;
        int readUnsignedByte = lVar.readUnsignedByte();
        int readUnsignedShort = lVar.readUnsignedShort();
        int readInt = lVar.readInt();
        int readUnsignedByte2 = lVar.readUnsignedByte();
        lVar.setPosition(i3);
        if (readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3) {
            AppMethodBeat.o(95621);
            return true;
        }
        AppMethodBeat.o(95621);
        return false;
    }
}

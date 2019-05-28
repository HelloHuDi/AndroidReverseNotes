package com.google.android.exoplayer2.p105f.p798a;

import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.f.a.g */
public final class C45031g {
    /* renamed from: a */
    public static void m82526a(long j, C32065l c32065l, C32041m[] c32041mArr) {
        AppMethodBeat.m2504i(95619);
        while (c32065l.mo52382tB() > 1) {
            int A = C45031g.m82525A(c32065l);
            int A2 = C45031g.m82525A(c32065l);
            if (A2 == -1 || A2 > c32065l.mo52382tB()) {
                c32065l.setPosition(c32065l.limit);
            } else if (C45031g.m82527a(A, A2, c32065l)) {
                c32065l.mo52369eM(8);
                int readUnsignedByte = c32065l.readUnsignedByte() & 31;
                c32065l.mo52369eM(1);
                int i = readUnsignedByte * 3;
                int i2 = c32065l.position;
                for (C32041m c32041m : c32041mArr) {
                    c32065l.setPosition(i2);
                    c32041m.mo42835a(c32065l, i);
                    c32041m.mo42834a(j, 1, i, 0, null);
                }
                c32065l.mo52369eM(A2 - ((readUnsignedByte * 3) + 10));
            } else {
                c32065l.mo52369eM(A2);
            }
        }
        AppMethodBeat.m2505o(95619);
    }

    /* renamed from: A */
    private static int m82525A(C32065l c32065l) {
        AppMethodBeat.m2504i(95620);
        int i = 0;
        while (c32065l.mo52382tB() != 0) {
            int readUnsignedByte = c32065l.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                AppMethodBeat.m2505o(95620);
                return i;
            }
        }
        AppMethodBeat.m2505o(95620);
        return -1;
    }

    /* renamed from: a */
    private static boolean m82527a(int i, int i2, C32065l c32065l) {
        AppMethodBeat.m2504i(95621);
        if (i != 4 || i2 < 8) {
            AppMethodBeat.m2505o(95621);
            return false;
        }
        int i3 = c32065l.position;
        int readUnsignedByte = c32065l.readUnsignedByte();
        int readUnsignedShort = c32065l.readUnsignedShort();
        int readInt = c32065l.readInt();
        int readUnsignedByte2 = c32065l.readUnsignedByte();
        c32065l.setPosition(i3);
        if (readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3) {
            AppMethodBeat.m2505o(95621);
            return true;
        }
        AppMethodBeat.m2505o(95621);
        return false;
    }
}

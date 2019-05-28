package com.google.android.exoplayer2.c.f;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements e {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(95068);
            e[] eVarArr = new e[]{new a()};
            AppMethodBeat.o(95068);
            return eVarArr;
        }
    };
    private static final int bbg = v.aT("ID3");
    private final long bbh;
    private final b bbi;
    private final l bbj;
    private boolean bbk;

    static {
        AppMethodBeat.i(95074);
        AppMethodBeat.o(95074);
    }

    public a() {
        this(0);
    }

    public a(long j) {
        AppMethodBeat.i(95069);
        this.bbh = j;
        this.bbi = new b();
        this.bbj = new l(2786);
        AppMethodBeat.o(95069);
    }

    public final boolean a(f fVar) {
        int tH;
        AppMethodBeat.i(95070);
        l lVar = new l(10);
        int i = 0;
        while (true) {
            fVar.b(lVar.data, 0, 10);
            lVar.setPosition(0);
            if (lVar.tD() != bbg) {
                break;
            }
            lVar.eM(3);
            tH = lVar.tH();
            i += tH + 10;
            fVar.dH(tH);
        }
        fVar.qY();
        fVar.dH(i);
        tH = 0;
        int i2 = i;
        while (true) {
            fVar.b(lVar.data, 0, 5);
            lVar.setPosition(0);
            if (lVar.readUnsignedShort() != 2935) {
                fVar.qY();
                i2++;
                if (i2 - i >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    AppMethodBeat.o(95070);
                    return false;
                }
                fVar.dH(i2);
                tH = 0;
            } else {
                tH++;
                if (tH >= 4) {
                    AppMethodBeat.o(95070);
                    return true;
                }
                int j = com.google.android.exoplayer2.a.a.j(lVar.data);
                if (j == -1) {
                    AppMethodBeat.o(95070);
                    return false;
                }
                fVar.dH(j - 5);
            }
        }
    }

    public final void a(g gVar) {
        AppMethodBeat.i(95071);
        this.bbi.a(gVar, new d(0, 1));
        gVar.rb();
        gVar.a(new com.google.android.exoplayer2.c.l.a(-9223372036854775807L));
        AppMethodBeat.o(95071);
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(95072);
        this.bbk = false;
        this.bbi.rn();
        AppMethodBeat.o(95072);
    }

    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(95073);
        int read = fVar.read(this.bbj.data, 0, 2786);
        if (read == -1) {
            AppMethodBeat.o(95073);
            return -1;
        }
        this.bbj.setPosition(0);
        this.bbj.eL(read);
        if (!this.bbk) {
            this.bbi.aSk = this.bbh;
            this.bbk = true;
        }
        this.bbi.t(this.bbj);
        AppMethodBeat.o(95073);
        return 0;
    }
}

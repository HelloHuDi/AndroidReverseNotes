package com.google.android.exoplayer2.c.f;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements e {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(95081);
            e[] eVarArr = new e[]{new c()};
            AppMethodBeat.o(95081);
            return eVarArr;
        }
    };
    private static final int bbg = v.aT("ID3");
    private final long bbh;
    private boolean bbk;
    private final d bbr;
    private final l bbs;

    static {
        AppMethodBeat.i(95087);
        AppMethodBeat.o(95087);
    }

    public c() {
        this(0);
    }

    public c(long j) {
        AppMethodBeat.i(95082);
        this.bbh = j;
        this.bbr = new d();
        this.bbs = new l(200);
        AppMethodBeat.o(95082);
    }

    public final boolean a(f fVar) {
        int tH;
        AppMethodBeat.i(95083);
        l lVar = new l(10);
        k kVar = new k(lVar.data);
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
        int i2 = 0;
        int i3 = i;
        while (true) {
            fVar.b(lVar.data, 0, 2);
            lVar.setPosition(0);
            if ((lVar.readUnsignedShort() & 65526) != 65520) {
                fVar.qY();
                i3++;
                if (i3 - i >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    AppMethodBeat.o(95083);
                    return false;
                }
                fVar.dH(i3);
                tH = 0;
                i2 = 0;
            } else {
                tH++;
                if (tH < 4 || i2 <= 188) {
                    fVar.b(lVar.data, 0, 4);
                    kVar.setPosition(14);
                    int ed = kVar.ed(13);
                    if (ed <= 6) {
                        AppMethodBeat.o(95083);
                        return false;
                    }
                    fVar.dH(ed - 6);
                    i2 += ed;
                } else {
                    AppMethodBeat.o(95083);
                    return true;
                }
            }
        }
    }

    public final void a(g gVar) {
        AppMethodBeat.i(95084);
        this.bbr.a(gVar, new d(0, 1));
        gVar.rb();
        gVar.a(new a(-9223372036854775807L));
        AppMethodBeat.o(95084);
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(95085);
        this.bbk = false;
        this.bbr.rq();
        AppMethodBeat.o(95085);
    }

    public final int a(f fVar, com.google.android.exoplayer2.c.k kVar) {
        AppMethodBeat.i(95086);
        int read = fVar.read(this.bbs.data, 0, 200);
        if (read == -1) {
            AppMethodBeat.o(95086);
            return -1;
        }
        this.bbs.setPosition(0);
        this.bbs.eL(read);
        if (!this.bbk) {
            this.bbr.aSk = this.bbh;
            this.bbk = true;
        }
        this.bbr.t(this.bbs);
        AppMethodBeat.o(95086);
        return 0;
    }
}

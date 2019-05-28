package com.google.android.exoplayer2.p101c.p104f;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p099a.C32018a;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.a */
public final class C8656a implements C32034e {
    public static final C32039h aTh = new C86571();
    private static final int bbg = C17675v.m27562aT("ID3");
    private final long bbh;
    private final C32035b bbi;
    private final C32065l bbj;
    private boolean bbk;

    /* renamed from: com.google.android.exoplayer2.c.f.a$1 */
    static class C86571 implements C32039h {
        C86571() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(95068);
            C32034e[] c32034eArr = new C32034e[]{new C8656a()};
            AppMethodBeat.m2505o(95068);
            return c32034eArr;
        }
    }

    static {
        AppMethodBeat.m2504i(95074);
        AppMethodBeat.m2505o(95074);
    }

    public C8656a() {
        this(0);
    }

    public C8656a(long j) {
        AppMethodBeat.m2504i(95069);
        this.bbh = j;
        this.bbi = new C32035b();
        this.bbj = new C32065l(2786);
        AppMethodBeat.m2505o(95069);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        int tH;
        AppMethodBeat.m2504i(95070);
        C32065l c32065l = new C32065l(10);
        int i = 0;
        while (true) {
            c45026f.mo59479b(c32065l.data, 0, 10);
            c32065l.setPosition(0);
            if (c32065l.mo52384tD() != bbg) {
                break;
            }
            c32065l.mo52369eM(3);
            tH = c32065l.mo52388tH();
            i += tH + 10;
            c45026f.mo59483dH(tH);
        }
        c45026f.mo59486qY();
        c45026f.mo59483dH(i);
        tH = 0;
        int i2 = i;
        while (true) {
            c45026f.mo59479b(c32065l.data, 0, 5);
            c32065l.setPosition(0);
            if (c32065l.readUnsignedShort() != 2935) {
                c45026f.mo59486qY();
                i2++;
                if (i2 - i >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    AppMethodBeat.m2505o(95070);
                    return false;
                }
                c45026f.mo59483dH(i2);
                tH = 0;
            } else {
                tH++;
                if (tH >= 4) {
                    AppMethodBeat.m2505o(95070);
                    return true;
                }
                int j = C32018a.m51994j(c32065l.data);
                if (j == -1) {
                    AppMethodBeat.m2505o(95070);
                    return false;
                }
                c45026f.mo59483dH(j - 5);
            }
        }
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(95071);
        this.bbi.mo2555a(c8662g, new C8661d(0, 1));
        c8662g.mo19158rb();
        c8662g.mo19156a(new C17646a(-9223372036854775807L));
        AppMethodBeat.m2505o(95071);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(95072);
        this.bbk = false;
        this.bbi.mo2557rn();
        AppMethodBeat.m2505o(95072);
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(95073);
        int read = c45026f.read(this.bbj.data, 0, 2786);
        if (read == -1) {
            AppMethodBeat.m2505o(95073);
            return -1;
        }
        this.bbj.setPosition(0);
        this.bbj.mo52368eL(read);
        if (!this.bbk) {
            this.bbi.aSk = this.bbh;
            this.bbk = true;
        }
        this.bbi.mo2559t(this.bbj);
        AppMethodBeat.m2505o(95073);
        return 0;
    }
}

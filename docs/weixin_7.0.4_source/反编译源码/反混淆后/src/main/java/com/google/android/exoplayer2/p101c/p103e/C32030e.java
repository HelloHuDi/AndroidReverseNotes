package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

/* renamed from: com.google.android.exoplayer2.c.e.e */
final class C32030e {
    private static final int bak = C17675v.m27562aT("OggS");
    private final C32065l aTj = new C32065l(255);
    public int aVG;
    public int bal;
    public long bam;
    public long ban;
    public long bao;
    public long bap;
    public int baq;
    public int bar;
    public final int[] bas = new int[255];
    public int type;

    C32030e() {
        AppMethodBeat.m2504i(95041);
        AppMethodBeat.m2505o(95041);
    }

    static {
        AppMethodBeat.m2504i(95043);
        AppMethodBeat.m2505o(95043);
    }

    public final void reset() {
        this.bal = 0;
        this.type = 0;
        this.bam = 0;
        this.ban = 0;
        this.bao = 0;
        this.bap = 0;
        this.baq = 0;
        this.aVG = 0;
        this.bar = 0;
    }

    /* renamed from: c */
    public final boolean mo52324c(C45026f c45026f, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(95042);
        this.aTj.reset();
        reset();
        int i2 = (c45026f.getLength() == -1 || c45026f.getLength() - c45026f.mo59487qZ() >= 27) ? true : 0;
        C37269o c37269o;
        if (i2 == 0 || !c45026f.mo59480b(this.aTj.data, 0, 27, true)) {
            if (z) {
                AppMethodBeat.m2505o(95042);
                return false;
            }
            EOFException eOFException = new EOFException();
            AppMethodBeat.m2505o(95042);
            throw eOFException;
        } else if (this.aTj.mo52366cM() == ((long) bak)) {
            this.bal = this.aTj.readUnsignedByte();
            if (this.bal == 0) {
                this.type = this.aTj.readUnsignedByte();
                this.bam = this.aTj.mo52387tG();
                this.ban = this.aTj.mo52385tE();
                this.bao = this.aTj.mo52385tE();
                this.bap = this.aTj.mo52385tE();
                this.baq = this.aTj.readUnsignedByte();
                this.aVG = this.baq + 27;
                this.aTj.reset();
                c45026f.mo59479b(this.aTj.data, 0, this.baq);
                while (i < this.baq) {
                    this.bas[i] = this.aTj.readUnsignedByte();
                    this.bar += this.bas[i];
                    i++;
                }
                AppMethodBeat.m2505o(95042);
                return true;
            } else if (z) {
                AppMethodBeat.m2505o(95042);
                return false;
            } else {
                c37269o = new C37269o("unsupported bit stream revision");
                AppMethodBeat.m2505o(95042);
                throw c37269o;
            }
        } else if (z) {
            AppMethodBeat.m2505o(95042);
            return false;
        } else {
            c37269o = new C37269o("expected OggS capture pattern at begin of page");
            AppMethodBeat.m2505o(95042);
            throw c37269o;
        }
    }
}

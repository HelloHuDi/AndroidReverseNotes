package com.google.android.exoplayer2.source.p112b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.C37253f;
import com.google.android.exoplayer2.C45054w;
import com.google.android.exoplayer2.C8691j;
import com.google.android.exoplayer2.p110h.C0867f.C0868a;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p110h.C41614t;
import com.google.android.exoplayer2.p110h.C41614t.C37263a;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C25560k;
import com.google.android.exoplayer2.source.C25561n;
import com.google.android.exoplayer2.source.C37271a;
import com.google.android.exoplayer2.source.C37271a.C8705a;
import com.google.android.exoplayer2.source.C37279h;
import com.google.android.exoplayer2.source.C45052i;
import com.google.android.exoplayer2.source.C45052i.C37281a;
import com.google.android.exoplayer2.source.C45052i.C45051b;
import com.google.android.exoplayer2.source.p112b.p113a.C37272b;
import com.google.android.exoplayer2.source.p112b.p113a.C37272b.C37273a;
import com.google.android.exoplayer2.source.p112b.p113a.C41202d;
import com.google.android.exoplayer2.source.p112b.p113a.C45047c;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e.C0878a;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e.C32071e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.b.h */
public final class C41624h implements C32071e, C45052i {
    private final int bgC;
    private C37281a bgz;
    private C45049e bir;
    private final C25555d bjb;
    private final C8705a bjc;
    private final Uri bjj;
    private final C37263a<C45047c> bjk;

    static {
        AppMethodBeat.m2504i(125936);
        C8691j.m15428ar("goog.exo.hls");
        AppMethodBeat.m2505o(125936);
    }

    public C41624h(Uri uri, C0868a c0868a, Handler handler, C37271a c37271a) {
        this(uri, c0868a, handler, c37271a, (byte) 0);
    }

    private C41624h(Uri uri, C0868a c0868a, Handler handler, C37271a c37271a, byte b) {
        this(uri, new C45050b(c0868a), handler, c37271a);
        AppMethodBeat.m2504i(125927);
        AppMethodBeat.m2505o(125927);
    }

    private C41624h(Uri uri, C25555d c25555d, Handler handler, C37271a c37271a) {
        this(uri, c25555d, handler, c37271a, new C41202d());
        AppMethodBeat.m2504i(125928);
        AppMethodBeat.m2505o(125928);
    }

    private C41624h(Uri uri, C25555d c25555d, Handler handler, C37271a c37271a, C37263a<C45047c> c37263a) {
        AppMethodBeat.m2504i(125929);
        this.bjj = uri;
        this.bjb = c25555d;
        this.bgC = 3;
        this.bjk = c37263a;
        this.bjc = new C8705a(handler, c37271a);
        AppMethodBeat.m2505o(125929);
    }

    /* renamed from: a */
    public final void mo42821a(C37253f c37253f, C37281a c37281a) {
        AppMethodBeat.m2504i(125930);
        C45039a.checkState(this.bir == null);
        this.bir = new C45049e(this.bjj, this.bjb, this.bjc, this.bgC, this, this.bjk);
        this.bgz = c37281a;
        C45049e c45049e = this.bir;
        c45049e.bkG.mo66741a(new C41614t(c45049e.bjb.mo42816st(), c45049e.bkA, c45049e.bjk), c45049e, c45049e.bkB);
        AppMethodBeat.m2505o(125930);
    }

    /* renamed from: rX */
    public final void mo42824rX() {
        AppMethodBeat.m2504i(125931);
        C45049e c45049e = this.bir;
        if (c45049e.bkH != null) {
            c45049e.mo72566d(c45049e.bkH);
        }
        AppMethodBeat.m2505o(125931);
    }

    /* renamed from: a */
    public final C37279h mo42820a(C45051b c45051b, C32053b c32053b) {
        AppMethodBeat.m2504i(125932);
        C45039a.checkArgument(c45051b.bhq == 0);
        C8711g c8711g = new C8711g(this.bir, this.bjb, this.bgC, this.bjc, c32053b);
        AppMethodBeat.m2505o(125932);
        return c8711g;
    }

    /* renamed from: b */
    public final void mo42823b(C37279h c37279h) {
        AppMethodBeat.m2504i(125933);
        C8711g c8711g = (C8711g) c37279h;
        c8711g.bir.bkF.remove(c8711g);
        c8711g.bje.removeCallbacksAndMessages(null);
        for (C41626j c41626j : c8711g.bjg) {
            boolean a = c41626j.bgI.mo66742a(c41626j);
            if (c41626j.prepared && !a) {
                for (C25560k sq : c41626j.bgO) {
                    sq.mo42842sq();
                }
            }
            c41626j.handler.removeCallbacksAndMessages(null);
            c41626j.released = true;
        }
        AppMethodBeat.m2505o(125933);
    }

    /* renamed from: rY */
    public final void mo42825rY() {
        AppMethodBeat.m2504i(125934);
        if (this.bir != null) {
            C45049e c45049e = this.bir;
            c45049e.bkG.mo66742a(null);
            for (C0878a c0878a : c45049e.bkC.values()) {
                c0878a.bkL.mo66742a(null);
            }
            c45049e.bkD.removeCallbacksAndMessages(null);
            c45049e.bkC.clear();
            this.bir = null;
        }
        this.bgz = null;
        AppMethodBeat.m2505o(125934);
    }

    /* renamed from: a */
    public final void mo52415a(C37272b c37272b) {
        C45054w c25561n;
        AppMethodBeat.m2504i(125935);
        long j = c37272b.bjQ ? 0 : -9223372036854775807L;
        long w = c37272b.bjQ ? C17628b.m27433w(c37272b.bif) : -9223372036854775807L;
        long j2 = c37272b.bjJ;
        if (this.bir.bkJ) {
            boolean z;
            long j3 = c37272b.bjP ? c37272b.aOz + c37272b.bif : -9223372036854775807L;
            List list = c37272b.bjS;
            if (j2 == -9223372036854775807L) {
                long j4;
                if (list.isEmpty()) {
                    j4 = 0;
                } else {
                    j4 = ((C37273a) list.get(Math.max(0, list.size() - 3))).bjU;
                }
                j2 = j4;
            }
            long j5 = c37272b.aOz;
            long j6 = c37272b.bif;
            if (c37272b.bjP) {
                z = false;
            } else {
                z = true;
            }
            c25561n = new C25561n(j, w, j3, j5, j6, j2, true, z);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            c25561n = new C25561n(j, w, c37272b.bif + c37272b.aOz, c37272b.aOz, c37272b.bif, j2, true, false);
        }
        this.bgz.mo42822a(c25561n, new C17684e(this.bir.biH, c37272b));
        AppMethodBeat.m2505o(125935);
    }
}

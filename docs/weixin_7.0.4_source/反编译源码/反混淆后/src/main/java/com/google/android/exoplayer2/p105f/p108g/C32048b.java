package com.google.android.exoplayer2.p105f.p108g;

import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p105f.C41607f;
import com.google.android.exoplayer2.p105f.C8672b;
import com.google.android.exoplayer2.p105f.p108g.C0858e.C0859a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.f.g.b */
public final class C32048b extends C8672b {
    private static final int bou = C17675v.m27562aT("payl");
    private static final int bov = C17675v.m27562aT("sttg");
    private static final int bow = C17675v.m27562aT("vttc");
    private final C32065l bbj = new C32065l();
    private final C0859a box = new C0859a();

    static {
        AppMethodBeat.m2504i(95719);
        AppMethodBeat.m2505o(95719);
    }

    public C32048b() {
        super("Mp4WebvttDecoder");
        AppMethodBeat.m2504i(95716);
        AppMethodBeat.m2505o(95716);
    }

    /* renamed from: a */
    private static C32044a m52095a(C32065l c32065l, C0859a c0859a, int i) {
        AppMethodBeat.m2504i(95717);
        c0859a.reset();
        while (i > 0) {
            if (i < 8) {
                C41607f c41607f = new C41607f("Incomplete vtt cue box header found.");
                AppMethodBeat.m2505o(95717);
                throw c41607f;
            }
            int readInt = c32065l.readInt();
            int readInt2 = c32065l.readInt();
            int i2 = i - 8;
            readInt -= 8;
            String str = new String(c32065l.data, c32065l.position, readInt);
            c32065l.mo52369eM(readInt);
            i = i2 - readInt;
            if (readInt2 == bov) {
                C0861f.m1964a(str, c0859a);
            } else if (readInt2 == bou) {
                C0861f.m1966a(null, str.trim(), c0859a, Collections.emptyList());
            }
        }
        C0858e tc = c0859a.mo2580tc();
        AppMethodBeat.m2505o(95717);
        return tc;
    }

    /* renamed from: c */
    public final /* synthetic */ C17659d mo2574c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(95718);
        this.bbj.mo52371n(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.bbj.mo52382tB() > 0) {
            if (this.bbj.mo52382tB() < 8) {
                C41607f c41607f = new C41607f("Incomplete Mp4Webvtt Top Level box header found.");
                AppMethodBeat.m2505o(95718);
                throw c41607f;
            }
            int readInt = this.bbj.readInt();
            if (this.bbj.readInt() == bow) {
                arrayList.add(C32048b.m52095a(this.bbj, this.box, readInt - 8));
            } else {
                this.bbj.mo52369eM(readInt - 8);
            }
        }
        C32049c c32049c = new C32049c(arrayList);
        AppMethodBeat.m2505o(95718);
        return c32049c;
    }
}

package com.google.android.exoplayer2.p105f.p108g;

import android.text.TextUtils;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C41607f;
import com.google.android.exoplayer2.p105f.C8672b;
import com.google.android.exoplayer2.p105f.p108g.C0858e.C0859a;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.g.g */
public final class C25536g extends C8672b {
    private final C0861f boK = new C0861f();
    private final C32065l boL = new C32065l();
    private final C0859a boM = new C0859a();
    private final C32047a boN = new C32047a();
    private final List<C32050d> boO = new ArrayList();

    public C25536g() {
        super("WebvttDecoder");
        AppMethodBeat.m2504i(95740);
        AppMethodBeat.m2505o(95740);
    }

    /* renamed from: G */
    private static int m40371G(C32065l c32065l) {
        AppMethodBeat.m2504i(95741);
        int i = 0;
        int i2 = -1;
        while (i2 == -1) {
            i = c32065l.position;
            String readLine = c32065l.readLine();
            if (readLine == null) {
                i2 = 0;
            } else if ("STYLE".equals(readLine)) {
                i2 = 2;
            } else if ("NOTE".startsWith(readLine)) {
                i2 = 1;
            } else {
                i2 = 3;
            }
        }
        c32065l.setPosition(i);
        AppMethodBeat.m2505o(95741);
        return i2;
    }

    /* renamed from: H */
    private static void m40372H(C32065l c32065l) {
        AppMethodBeat.m2504i(95742);
        do {
        } while (!TextUtils.isEmpty(c32065l.readLine()));
        AppMethodBeat.m2505o(95742);
    }

    /* renamed from: c */
    public final /* synthetic */ C17659d mo2574c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(95743);
        this.boL.mo52371n(bArr, i);
        this.boM.reset();
        this.boO.clear();
        C17660h.m27520I(this.boL);
        do {
        } while (!TextUtils.isEmpty(this.boL.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int G = C25536g.m40371G(this.boL);
            if (G == 0) {
                C45033i c45033i = new C45033i(arrayList);
                AppMethodBeat.m2505o(95743);
                return c45033i;
            } else if (G == 1) {
                C25536g.m40372H(this.boL);
            } else if (G == 2) {
                if (arrayList.isEmpty()) {
                    this.boL.readLine();
                    C32050d C = this.boN.mo52332C(this.boL);
                    if (C != null) {
                        this.boO.add(C);
                    }
                } else {
                    C41607f c41607f = new C41607f("A style block was found after the first cue.");
                    AppMethodBeat.m2505o(95743);
                    throw c41607f;
                }
            } else if (G == 3 && this.boK.mo2581a(this.boL, this.boM, this.boO)) {
                arrayList.add(this.boM.mo2580tc());
                this.boM.reset();
            }
        }
    }
}

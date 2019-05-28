package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.f.g.e.a;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g extends b {
    private final f boK = new f();
    private final l boL = new l();
    private final a boM = new a();
    private final a boN = new a();
    private final List<d> boO = new ArrayList();

    public g() {
        super("WebvttDecoder");
        AppMethodBeat.i(95740);
        AppMethodBeat.o(95740);
    }

    private static int G(l lVar) {
        AppMethodBeat.i(95741);
        int i = 0;
        int i2 = -1;
        while (i2 == -1) {
            i = lVar.position;
            String readLine = lVar.readLine();
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
        lVar.setPosition(i);
        AppMethodBeat.o(95741);
        return i2;
    }

    private static void H(l lVar) {
        AppMethodBeat.i(95742);
        do {
        } while (!TextUtils.isEmpty(lVar.readLine()));
        AppMethodBeat.o(95742);
    }

    public final /* synthetic */ d c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(95743);
        this.boL.n(bArr, i);
        this.boM.reset();
        this.boO.clear();
        h.I(this.boL);
        do {
        } while (!TextUtils.isEmpty(this.boL.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int G = G(this.boL);
            if (G == 0) {
                i iVar = new i(arrayList);
                AppMethodBeat.o(95743);
                return iVar;
            } else if (G == 1) {
                H(this.boL);
            } else if (G == 2) {
                if (arrayList.isEmpty()) {
                    this.boL.readLine();
                    d C = this.boN.C(this.boL);
                    if (C != null) {
                        this.boO.add(C);
                    }
                } else {
                    f fVar = new f("A style block was found after the first cue.");
                    AppMethodBeat.o(95743);
                    throw fVar;
                }
            } else if (G == 3 && this.boK.a(this.boL, this.boM, this.boO)) {
                arrayList.add(this.boM.tc());
                this.boM.reset();
            }
        }
    }
}

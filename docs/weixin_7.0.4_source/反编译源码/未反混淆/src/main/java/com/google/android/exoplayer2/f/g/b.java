package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.f.g.e.a;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class b extends com.google.android.exoplayer2.f.b {
    private static final int bou = v.aT("payl");
    private static final int bov = v.aT("sttg");
    private static final int bow = v.aT("vttc");
    private final l bbj = new l();
    private final a box = new a();

    static {
        AppMethodBeat.i(95719);
        AppMethodBeat.o(95719);
    }

    public b() {
        super("Mp4WebvttDecoder");
        AppMethodBeat.i(95716);
        AppMethodBeat.o(95716);
    }

    private static com.google.android.exoplayer2.f.a a(l lVar, a aVar, int i) {
        AppMethodBeat.i(95717);
        aVar.reset();
        while (i > 0) {
            if (i < 8) {
                f fVar = new f("Incomplete vtt cue box header found.");
                AppMethodBeat.o(95717);
                throw fVar;
            }
            int readInt = lVar.readInt();
            int readInt2 = lVar.readInt();
            int i2 = i - 8;
            readInt -= 8;
            String str = new String(lVar.data, lVar.position, readInt);
            lVar.eM(readInt);
            i = i2 - readInt;
            if (readInt2 == bov) {
                f.a(str, aVar);
            } else if (readInt2 == bou) {
                f.a(null, str.trim(), aVar, Collections.emptyList());
            }
        }
        e tc = aVar.tc();
        AppMethodBeat.o(95717);
        return tc;
    }

    public final /* synthetic */ d c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(95718);
        this.bbj.n(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.bbj.tB() > 0) {
            if (this.bbj.tB() < 8) {
                f fVar = new f("Incomplete Mp4Webvtt Top Level box header found.");
                AppMethodBeat.o(95718);
                throw fVar;
            }
            int readInt = this.bbj.readInt();
            if (this.bbj.readInt() == bow) {
                arrayList.add(a(this.bbj, this.box, readInt - 8));
            } else {
                this.bbj.eM(readInt - 8);
            }
        }
        c cVar = new c(arrayList);
        AppMethodBeat.o(95718);
        return cVar;
    }
}

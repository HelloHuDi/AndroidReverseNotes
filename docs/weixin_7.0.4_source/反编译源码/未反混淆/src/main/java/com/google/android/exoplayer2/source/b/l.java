package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.f.g.h;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class l implements e {
    private static final Pattern bjB = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern bjC = Pattern.compile("MPEGTS:(\\d+)");
    private final String aOt;
    private final s aYf;
    private g baf;
    private final com.google.android.exoplayer2.i.l bjD = new com.google.android.exoplayer2.i.l();
    private byte[] bjE = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
    private int sampleSize;

    static {
        AppMethodBeat.i(126008);
        AppMethodBeat.o(126008);
    }

    public l(String str, s sVar) {
        AppMethodBeat.i(126002);
        this.aOt = str;
        this.aYf = sVar;
        AppMethodBeat.o(126002);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(126003);
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.o(126003);
        throw illegalStateException;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(126004);
        this.baf = gVar;
        gVar.a(new a(-9223372036854775807L));
        AppMethodBeat.o(126004);
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(126005);
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.o(126005);
        throw illegalStateException;
    }

    public final int a(f fVar, k kVar) {
        int i;
        AppMethodBeat.i(126006);
        int length = (int) fVar.getLength();
        if (this.sampleSize == this.bjE.length) {
            byte[] bArr = this.bjE;
            if (length != -1) {
                i = length;
            } else {
                i = this.bjE.length;
            }
            this.bjE = Arrays.copyOf(bArr, (i * 3) / 2);
        }
        i = fVar.read(this.bjE, this.sampleSize, this.bjE.length - this.sampleSize);
        if (i != -1) {
            this.sampleSize = i + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                AppMethodBeat.o(126006);
                return 0;
            }
        }
        com.google.android.exoplayer2.i.l lVar = new com.google.android.exoplayer2.i.l(this.bjE);
        try {
            h.I(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = lVar.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    Matcher J = h.J(lVar);
                    if (J == null) {
                        ah(0);
                    } else {
                        long aD = h.aD(J.group(1));
                        j = this.aYf.ao(s.ar((j2 + aD) - j));
                        m ah = ah(j - aD);
                        this.bjD.n(this.bjE, this.sampleSize);
                        ah.a(this.bjD, this.sampleSize);
                        ah.a(j, 1, this.sampleSize, 0, null);
                    }
                    AppMethodBeat.o(126006);
                    return -1;
                } else if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = bjB.matcher(readLine);
                    o oVar;
                    if (matcher.find()) {
                        Matcher matcher2 = bjC.matcher(readLine);
                        if (matcher2.find()) {
                            j = h.aD(matcher.group(1));
                            j2 = s.aq(Long.parseLong(matcher2.group(1)));
                        } else {
                            oVar = new o("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(String.valueOf(readLine)));
                            AppMethodBeat.o(126006);
                            throw oVar;
                        }
                    }
                    oVar = new o("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(String.valueOf(readLine)));
                    AppMethodBeat.o(126006);
                    throw oVar;
                }
            }
        } catch (com.google.android.exoplayer2.f.f e) {
            o oVar2 = new o(e);
            AppMethodBeat.o(126006);
            throw oVar2;
        }
    }

    private m ah(long j) {
        AppMethodBeat.i(126007);
        m dM = this.baf.dM(0);
        dM.f(Format.a("text/vtt", this.aOt, j));
        this.baf.rb();
        AppMethodBeat.o(126007);
        return dM;
    }
}

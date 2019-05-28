package com.google.android.exoplayer2.source.p112b;

import android.text.TextUtils;
import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p105f.C41607f;
import com.google.android.exoplayer2.p105f.p108g.C17660h;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.source.b.l */
final class C37276l implements C32034e {
    private static final Pattern bjB = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern bjC = Pattern.compile("MPEGTS:(\\d+)");
    private final String aOt;
    private final C45042s aYf;
    private C8662g baf;
    private final C32065l bjD = new C32065l();
    private byte[] bjE = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
    private int sampleSize;

    static {
        AppMethodBeat.m2504i(126008);
        AppMethodBeat.m2505o(126008);
    }

    public C37276l(String str, C45042s c45042s) {
        AppMethodBeat.m2504i(126002);
        this.aOt = str;
        this.aYf = c45042s;
        AppMethodBeat.m2505o(126002);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(126003);
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.m2505o(126003);
        throw illegalStateException;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(126004);
        this.baf = c8662g;
        c8662g.mo19156a(new C17646a(-9223372036854775807L));
        AppMethodBeat.m2505o(126004);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(126005);
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.m2505o(126005);
        throw illegalStateException;
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        int i;
        AppMethodBeat.m2504i(126006);
        int length = (int) c45026f.getLength();
        if (this.sampleSize == this.bjE.length) {
            byte[] bArr = this.bjE;
            if (length != -1) {
                i = length;
            } else {
                i = this.bjE.length;
            }
            this.bjE = Arrays.copyOf(bArr, (i * 3) / 2);
        }
        i = c45026f.read(this.bjE, this.sampleSize, this.bjE.length - this.sampleSize);
        if (i != -1) {
            this.sampleSize = i + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                AppMethodBeat.m2505o(126006);
                return 0;
            }
        }
        C32065l c32065l = new C32065l(this.bjE);
        try {
            C17660h.m27520I(c32065l);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = c32065l.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    Matcher J = C17660h.m27521J(c32065l);
                    if (J == null) {
                        m62552ah(0);
                    } else {
                        long aD = C17660h.m27522aD(J.group(1));
                        j = this.aYf.mo72551ao(C45042s.m82584ar((j2 + aD) - j));
                        C32041m ah = m62552ah(j - aD);
                        this.bjD.mo52371n(this.bjE, this.sampleSize);
                        ah.mo42835a(this.bjD, this.sampleSize);
                        ah.mo42834a(j, 1, this.sampleSize, 0, null);
                    }
                    AppMethodBeat.m2505o(126006);
                    return -1;
                } else if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = bjB.matcher(readLine);
                    C37269o c37269o;
                    if (matcher.find()) {
                        Matcher matcher2 = bjC.matcher(readLine);
                        if (matcher2.find()) {
                            j = C17660h.m27522aD(matcher.group(1));
                            j2 = C45042s.m82583aq(Long.parseLong(matcher2.group(1)));
                        } else {
                            c37269o = new C37269o("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(String.valueOf(readLine)));
                            AppMethodBeat.m2505o(126006);
                            throw c37269o;
                        }
                    }
                    c37269o = new C37269o("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(String.valueOf(readLine)));
                    AppMethodBeat.m2505o(126006);
                    throw c37269o;
                }
            }
        } catch (C41607f e) {
            C37269o c37269o2 = new C37269o(e);
            AppMethodBeat.m2505o(126006);
            throw c37269o2;
        }
    }

    /* renamed from: ah */
    private C32041m m62552ah(long j) {
        AppMethodBeat.m2504i(126007);
        C32041m dM = this.baf.mo19157dM(0);
        dM.mo42836f(Format.m15278a("text/vtt", this.aOt, j));
        this.baf.mo19158rb();
        AppMethodBeat.m2505o(126007);
        return dM;
    }
}

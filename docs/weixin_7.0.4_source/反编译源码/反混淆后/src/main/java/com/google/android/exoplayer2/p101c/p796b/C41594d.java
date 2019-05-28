package com.google.android.exoplayer2.p101c.p796b;

import android.support.p057v4.widget.C8415j;
import android.util.SparseArray;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.p101c.C25515a;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C32041m.C8663a;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p111i.C0873g;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C45041j;
import com.google.android.exoplayer2.video.C37284a;
import com.google.android.exoplayer2.video.C45053b;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.c.b.d */
public final class C41594d implements C32034e {
    private static final byte[] aTI = new byte[]{(byte) 49, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, (byte) 45, (byte) 45, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
    private static final byte[] aTJ = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static long aTK = 1000;
    static final byte[] aTL = C17675v.m27559aQ("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] aTM = new byte[]{(byte) 68, (byte) 105, (byte) 97, (byte) 108, (byte) 111, (byte) 103, (byte) 117, (byte) 101, (byte) 58, (byte) 32, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44};
    private static long aTN = 10000;
    private static final byte[] aTO = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static final UUID aTP = new UUID(72057594037932032L, -9223371306706625679L);
    public static final C32039h aTh = new C86461();
    long aOz;
    final C17634f aTC;
    private final C45020b aTQ;
    final SparseArray<C41595b> aTR;
    final boolean aTS;
    private final C32065l aTT;
    final C32065l aTU;
    private final C32065l aTV;
    private final C32065l aTW;
    private final C32065l aTX;
    private final C32065l aTY;
    private ByteBuffer aTZ;
    final C32065l aTj;
    C8662g aTn;
    private final C32065l aTx;
    private final C32065l aTy;
    private boolean aUA;
    private boolean aUB;
    private boolean aUC;
    private byte aUD;
    private int aUE;
    private int aUF;
    private int aUG;
    private boolean aUH;
    boolean aUI;
    long aUa;
    long aUb;
    long aUc;
    long aUd;
    C41595b aUe;
    boolean aUf;
    int aUg;
    long aUh;
    boolean aUi;
    long aUj;
    private long aUk;
    long aUl;
    C0873g aUm;
    C0873g aUn;
    boolean aUo;
    int aUp;
    long aUq;
    long aUr;
    int aUs;
    int aUt;
    int[] aUu;
    int aUv;
    int aUw;
    int aUx;
    private int aUy;
    private boolean aUz;

    /* renamed from: com.google.android.exoplayer2.c.b.d$1 */
    static class C86461 implements C32039h {
        C86461() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(94888);
            C32034e[] c32034eArr = new C32034e[]{new C41594d()};
            AppMethodBeat.m2505o(94888);
            return c32034eArr;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.b.d$a */
    final class C41593a implements C37231c {
        private C41593a() {
        }

        /* synthetic */ C41593a(C41594d c41594d, byte b) {
            this();
        }

        /* renamed from: dO */
        public final int mo59473dO(int i) {
            AppMethodBeat.m2504i(94889);
            int dO = C41594d.m72839dO(i);
            AppMethodBeat.m2505o(94889);
            return dO;
        }

        /* renamed from: dP */
        public final boolean mo59474dP(int i) {
            AppMethodBeat.m2504i(94890);
            boolean dP = C41594d.m72840dP(i);
            AppMethodBeat.m2505o(94890);
            return dP;
        }

        /* renamed from: f */
        public final void mo59476f(int i, long j, long j2) {
            AppMethodBeat.m2504i(94891);
            C41594d c41594d = C41594d.this;
            switch (i) {
                case 160:
                    c41594d.aUI = false;
                    AppMethodBeat.m2505o(94891);
                    return;
                case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
                    c41594d.aUe = new C41595b();
                    AppMethodBeat.m2505o(94891);
                    return;
                case 187:
                    c41594d.aUo = false;
                    AppMethodBeat.m2505o(94891);
                    return;
                case 19899:
                    c41594d.aUg = -1;
                    c41594d.aUh = -1;
                    AppMethodBeat.m2505o(94891);
                    return;
                case 20533:
                    c41594d.aUe.aUM = true;
                    AppMethodBeat.m2505o(94891);
                    return;
                case 21968:
                    c41594d.aUe.aUT = true;
                    break;
                case 25152:
                    AppMethodBeat.m2505o(94891);
                    return;
                case 408125543:
                    if (c41594d.aUb == -1 || c41594d.aUb == j) {
                        c41594d.aUb = j;
                        c41594d.aUa = j2;
                        AppMethodBeat.m2505o(94891);
                        return;
                    }
                    C37269o c37269o = new C37269o("Multiple Segment elements not supported");
                    AppMethodBeat.m2505o(94891);
                    throw c37269o;
                case 475249515:
                    c41594d.aUm = new C0873g();
                    c41594d.aUn = new C0873g();
                    AppMethodBeat.m2505o(94891);
                    return;
                case 524531317:
                    if (!c41594d.aUf) {
                        if (!c41594d.aTS || c41594d.aUj == -1) {
                            c41594d.aTn.mo19156a(new C17646a(c41594d.aOz));
                            c41594d.aUf = true;
                            AppMethodBeat.m2505o(94891);
                            return;
                        }
                        c41594d.aUi = true;
                        AppMethodBeat.m2505o(94891);
                        return;
                    }
                    break;
            }
            AppMethodBeat.m2505o(94891);
        }

        /* renamed from: dQ */
        public final void mo59475dQ(int i) {
            AppMethodBeat.m2504i(94892);
            C41594d c41594d = C41594d.this;
            int i2;
            C37269o c37269o;
            int i3;
            switch (i) {
                case 160:
                    if (c41594d.aUp == 2) {
                        if (!c41594d.aUI) {
                            c41594d.aUx |= 1;
                        }
                        c41594d.mo66730a((C41595b) c41594d.aTR.get(c41594d.aUv), c41594d.aUq);
                        c41594d.aUp = 0;
                        AppMethodBeat.m2505o(94892);
                        return;
                    }
                    break;
                case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
                    Object obj;
                    String str = c41594d.aUe.aUK;
                    if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        Format a;
                        C41595b c41595b = c41594d.aUe;
                        C8662g c8662g = c41594d.aTn;
                        i2 = c41594d.aUe.number;
                        int i4 = -1;
                        int i5 = -1;
                        List list = null;
                        String str2 = c41595b.aUK;
                        obj = -1;
                        switch (str2.hashCode()) {
                            case -2095576542:
                                if (str2.equals("V_MPEG4/ISO/AP")) {
                                    obj = 5;
                                    break;
                                }
                                break;
                            case -2095575984:
                                if (str2.equals("V_MPEG4/ISO/SP")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case -1985379776:
                                if (str2.equals("A_MS/ACM")) {
                                    obj = 22;
                                    break;
                                }
                                break;
                            case -1784763192:
                                if (str2.equals("A_TRUEHD")) {
                                    obj = 17;
                                    break;
                                }
                                break;
                            case -1730367663:
                                if (str2.equals("A_VORBIS")) {
                                    obj = 10;
                                    break;
                                }
                                break;
                            case -1482641358:
                                if (str2.equals("A_MPEG/L2")) {
                                    obj = 13;
                                    break;
                                }
                                break;
                            case -1482641357:
                                if (str2.equals("A_MPEG/L3")) {
                                    obj = 14;
                                    break;
                                }
                                break;
                            case -1373388978:
                                if (str2.equals("V_MS/VFW/FOURCC")) {
                                    obj = 8;
                                    break;
                                }
                                break;
                            case -933872740:
                                if (str2.equals("S_DVBSUB")) {
                                    obj = 28;
                                    break;
                                }
                                break;
                            case -538363189:
                                if (str2.equals("V_MPEG4/ISO/ASP")) {
                                    obj = 4;
                                    break;
                                }
                                break;
                            case -538363109:
                                if (str2.equals("V_MPEG4/ISO/AVC")) {
                                    obj = 6;
                                    break;
                                }
                                break;
                            case -425012669:
                                if (str2.equals("S_VOBSUB")) {
                                    obj = 26;
                                    break;
                                }
                                break;
                            case -356037306:
                                if (str2.equals("A_DTS/LOSSLESS")) {
                                    obj = 20;
                                    break;
                                }
                                break;
                            case 62923557:
                                if (str2.equals("A_AAC")) {
                                    obj = 12;
                                    break;
                                }
                                break;
                            case 62923603:
                                if (str2.equals("A_AC3")) {
                                    obj = 15;
                                    break;
                                }
                                break;
                            case 62927045:
                                if (str2.equals("A_DTS")) {
                                    obj = 18;
                                    break;
                                }
                                break;
                            case 82338133:
                                if (str2.equals("V_VP8")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 82338134:
                                if (str2.equals("V_VP9")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 99146302:
                                if (str2.equals("S_HDMV/PGS")) {
                                    obj = 27;
                                    break;
                                }
                                break;
                            case 444813526:
                                if (str2.equals("V_THEORA")) {
                                    obj = 9;
                                    break;
                                }
                                break;
                            case 542569478:
                                if (str2.equals("A_DTS/EXPRESS")) {
                                    obj = 19;
                                    break;
                                }
                                break;
                            case 725957860:
                                if (str2.equals("A_PCM/INT/LIT")) {
                                    obj = 23;
                                    break;
                                }
                                break;
                            case 738597099:
                                if (str2.equals("S_TEXT/ASS")) {
                                    obj = 25;
                                    break;
                                }
                                break;
                            case 855502857:
                                if (str2.equals("V_MPEGH/ISO/HEVC")) {
                                    obj = 7;
                                    break;
                                }
                                break;
                            case 1422270023:
                                if (str2.equals("S_TEXT/UTF8")) {
                                    obj = 24;
                                    break;
                                }
                                break;
                            case 1809237540:
                                if (str2.equals("V_MPEG2")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                            case 1950749482:
                                if (str2.equals("A_EAC3")) {
                                    obj = 16;
                                    break;
                                }
                                break;
                            case 1950789798:
                                if (str2.equals("A_FLAC")) {
                                    obj = 21;
                                    break;
                                }
                                break;
                            case 1951062397:
                                if (str2.equals("A_OPUS")) {
                                    obj = 11;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                str2 = "video/x-vnd.on2.vp8";
                                break;
                            case 1:
                                str2 = "video/x-vnd.on2.vp9";
                                break;
                            case 2:
                                str2 = "video/mpeg2";
                                break;
                            case 3:
                            case 4:
                            case 5:
                                List list2;
                                str2 = "video/mp4v-es";
                                if (c41595b.aUP == null) {
                                    list2 = null;
                                } else {
                                    list2 = Collections.singletonList(c41595b.aUP);
                                }
                                list = list2;
                                break;
                            case 6:
                                str2 = "video/avc";
                                C37284a K = C37284a.m62588K(new C32065l(c41595b.aUP));
                                list = K.aOf;
                                c41595b.aTz = K.aTz;
                                break;
                            case 7:
                                str2 = "video/hevc";
                                C45053b M = C45053b.m82638M(new C32065l(c41595b.aUP));
                                list = M.aOf;
                                c41595b.aTz = M.aTz;
                                break;
                            case 8:
                                list = C41595b.m72851i(new C32065l(c41595b.aUP));
                                if (list == null) {
                                    str2 = "video/x-unknown";
                                    break;
                                } else {
                                    str2 = "video/wvc1";
                                    break;
                                }
                            case 9:
                                str2 = "video/x-unknown";
                                break;
                            case 10:
                                str2 = "audio/vorbis";
                                i4 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
                                list = C41595b.m72853m(c41595b.aUP);
                                break;
                            case 11:
                                str2 = "audio/opus";
                                i4 = 5760;
                                list = new ArrayList(3);
                                list.add(c41595b.aUP);
                                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(c41595b.aVk).array());
                                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(c41595b.aVl).array());
                                break;
                            case 12:
                                str2 = "audio/mp4a-latm";
                                list = Collections.singletonList(c41595b.aUP);
                                break;
                            case 13:
                                str2 = "audio/mpeg-L2";
                                i4 = 4096;
                                break;
                            case 14:
                                str2 = "audio/mpeg";
                                i4 = 4096;
                                break;
                            case 15:
                                str2 = "audio/ac3";
                                break;
                            case 16:
                                str2 = "audio/eac3";
                                break;
                            case 17:
                                str2 = "audio/true-hd";
                                break;
                            case 18:
                            case 19:
                                str2 = "audio/vnd.dts";
                                break;
                            case 20:
                                str2 = "audio/vnd.dts.hd";
                                break;
                            case 21:
                                str2 = "audio/flac";
                                list = Collections.singletonList(c41595b.aUP);
                                break;
                            case 22:
                                str2 = "audio/raw";
                                if (!C41595b.m72852j(new C32065l(c41595b.aUP))) {
                                    str2 = "audio/x-unknown";
                                    break;
                                }
                                i5 = C17675v.m27569eR(c41595b.aVj);
                                if (i5 == 0) {
                                    i5 = -1;
                                    str2 = "audio/x-unknown";
                                    new StringBuilder("Unsupported PCM bit depth: ").append(c41595b.aVj).append(". Setting mimeType to ").append(str2);
                                    break;
                                }
                                break;
                            case 23:
                                str2 = "audio/raw";
                                i5 = C17675v.m27569eR(c41595b.aVj);
                                if (i5 == 0) {
                                    i5 = -1;
                                    str2 = "audio/x-unknown";
                                    new StringBuilder("Unsupported PCM bit depth: ").append(c41595b.aVj).append(". Setting mimeType to ").append(str2);
                                    break;
                                }
                                break;
                            case 24:
                                str2 = "application/x-subrip";
                                break;
                            case 25:
                                str2 = "text/x-ssa";
                                break;
                            case 26:
                                str2 = "application/vobsub";
                                list = Collections.singletonList(c41595b.aUP);
                                break;
                            case 27:
                                str2 = "application/pgs";
                                break;
                            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                str2 = "application/dvbsubs";
                                list = Collections.singletonList(new byte[]{c41595b.aUP[0], c41595b.aUP[1], c41595b.aUP[2], c41595b.aUP[3]});
                                break;
                            default:
                                c37269o = new C37269o("Unrecognized codec identifier.");
                                AppMethodBeat.m2505o(94892);
                                throw c37269o;
                        }
                        int i6 = ((c41595b.aVn ? 1 : 0) | 0) | (c41595b.aVm ? 2 : 0);
                        if (C37265i.m62522aH(str2)) {
                            a = Format.m15270a(Integer.toString(i2), str2, -1, i4, c41595b.aOn, c41595b.sampleRate, i5, list, c41595b.aOg, i6, c41595b.aOt);
                        } else if (C37265i.m62523aI(str2)) {
                            if (c41595b.aUS == 0) {
                                c41595b.aUQ = c41595b.aUQ == -1 ? c41595b.width : c41595b.aUQ;
                                if (c41595b.aUR == -1) {
                                    i3 = c41595b.height;
                                } else {
                                    i3 = c41595b.aUR;
                                }
                                c41595b.aUR = i3;
                            }
                            float f = -1.0f;
                            if (!(c41595b.aUQ == -1 || c41595b.aUR == -1)) {
                                f = ((float) (c41595b.height * c41595b.aUQ)) / ((float) (c41595b.width * c41595b.aUR));
                            }
                            ColorInfo colorInfo = null;
                            if (c41595b.aUT) {
                                byte[] bArr;
                                if (c41595b.aUZ == -1.0f || c41595b.aVa == -1.0f || c41595b.aVb == -1.0f || c41595b.aVc == -1.0f || c41595b.aVd == -1.0f || c41595b.aVe == -1.0f || c41595b.aVf == -1.0f || c41595b.aVg == -1.0f || c41595b.aVh == -1.0f || c41595b.aVi == -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = new byte[25];
                                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                    wrap.put((byte) 0);
                                    wrap.putShort((short) ((int) ((c41595b.aUZ * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((c41595b.aVa * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((c41595b.aVb * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((c41595b.aVc * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((c41595b.aVd * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((c41595b.aVe * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((c41595b.aVf * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((c41595b.aVg * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) (c41595b.aVh + 0.5f)));
                                    wrap.putShort((short) ((int) (c41595b.aVi + 0.5f)));
                                    wrap.putShort((short) c41595b.aUX);
                                    wrap.putShort((short) c41595b.aUY);
                                }
                                ColorInfo colorInfo2 = new ColorInfo(c41595b.aUU, c41595b.aUW, c41595b.aUV, bArr);
                            }
                            a = Format.m15272a(Integer.toString(i2), str2, i4, c41595b.width, c41595b.height, list, -1, f, c41595b.aOl, c41595b.aOk, colorInfo, c41595b.aOg);
                        } else if ("application/x-subrip".equals(str2)) {
                            a = Format.m15277a(Integer.toString(i2), str2, i6, c41595b.aOt, c41595b.aOg);
                        } else if ("text/x-ssa".equals(str2)) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(C41594d.aTL);
                            arrayList.add(c41595b.aUP);
                            a = Format.m15276a(Integer.toString(i2), str2, i6, c41595b.aOt, -1, c41595b.aOg, Long.MAX_VALUE, arrayList);
                        } else if ("application/vobsub".equals(str2) || "application/pgs".equals(str2) || "application/dvbsubs".equals(str2)) {
                            a = Format.m15282a(Integer.toString(i2), str2, list, c41595b.aOt, c41595b.aOg);
                        } else {
                            c37269o = new C37269o("Unexpected MIME type.");
                            AppMethodBeat.m2505o(94892);
                            throw c37269o;
                        }
                        c41595b.aTw = c8662g.mo19157dM(c41595b.number);
                        c41595b.aTw.mo42836f(a);
                        c41594d.aTR.put(c41594d.aUe.number, c41594d.aUe);
                    }
                    c41594d.aUe = null;
                    AppMethodBeat.m2505o(94892);
                    return;
                case 19899:
                    if (c41594d.aUg == -1 || c41594d.aUh == -1) {
                        c37269o = new C37269o("Mandatory element SeekID or SeekPosition not found");
                        AppMethodBeat.m2505o(94892);
                        throw c37269o;
                    } else if (c41594d.aUg == 475249515) {
                        c41594d.aUj = c41594d.aUh;
                        AppMethodBeat.m2505o(94892);
                        return;
                    }
                    break;
                case 25152:
                    if (c41594d.aUe.aUM) {
                        if (c41594d.aUe.aUO == null) {
                            c37269o = new C37269o("Encrypted Track found but ContentEncKeyID was not found");
                            AppMethodBeat.m2505o(94892);
                            throw c37269o;
                        }
                        c41594d.aUe.aOg = new DrmInitData(new SchemeData(C17628b.aMx, "video/webm", c41594d.aUe.aUO.aTc));
                        AppMethodBeat.m2505o(94892);
                        return;
                    }
                    break;
                case 28032:
                    if (c41594d.aUe.aUM && c41594d.aUe.aUN != null) {
                        c37269o = new C37269o("Combining encryption and compression is not supported");
                        AppMethodBeat.m2505o(94892);
                        throw c37269o;
                    }
                case 357149030:
                    if (c41594d.aUc == -9223372036854775807L) {
                        c41594d.aUc = 1000000;
                    }
                    if (c41594d.aUd != -9223372036854775807L) {
                        c41594d.aOz = c41594d.mo66729N(c41594d.aUd);
                        AppMethodBeat.m2505o(94892);
                        return;
                    }
                    break;
                case 374648427:
                    if (c41594d.aTR.size() != 0) {
                        c41594d.aTn.mo19158rb();
                        break;
                    }
                    c37269o = new C37269o("No valid tracks were found");
                    AppMethodBeat.m2505o(94892);
                    throw c37269o;
                case 475249515:
                    if (!c41594d.aUf) {
                        C37247l c17646a;
                        C8662g c8662g2 = c41594d.aTn;
                        if (c41594d.aUb == -1 || c41594d.aOz == -9223372036854775807L || c41594d.aUm == null || c41594d.aUm.size == 0 || c41594d.aUn == null || c41594d.aUn.size != c41594d.aUm.size) {
                            c41594d.aUm = null;
                            c41594d.aUn = null;
                            c17646a = new C17646a(c41594d.aOz);
                        } else {
                            i2 = c41594d.aUm.size;
                            int[] iArr = new int[i2];
                            long[] jArr = new long[i2];
                            long[] jArr2 = new long[i2];
                            long[] jArr3 = new long[i2];
                            for (i3 = 0; i3 < i2; i3++) {
                                jArr3[i3] = c41594d.aUm.get(i3);
                                jArr[i3] = c41594d.aUb + c41594d.aUn.get(i3);
                            }
                            for (i3 = 0; i3 < i2 - 1; i3++) {
                                iArr[i3] = (int) (jArr[i3 + 1] - jArr[i3]);
                                jArr2[i3] = jArr3[i3 + 1] - jArr3[i3];
                            }
                            iArr[i2 - 1] = (int) ((c41594d.aUb + c41594d.aUa) - jArr[i2 - 1]);
                            jArr2[i2 - 1] = c41594d.aOz - jArr3[i2 - 1];
                            c41594d.aUm = null;
                            c41594d.aUn = null;
                            c17646a = new C25515a(iArr, jArr, jArr2, jArr3);
                        }
                        c8662g2.mo19156a(c17646a);
                        c41594d.aUf = true;
                        AppMethodBeat.m2505o(94892);
                        return;
                    }
                    break;
            }
            AppMethodBeat.m2505o(94892);
        }

        /* renamed from: h */
        public final void mo59477h(int i, long j) {
            boolean z = true;
            AppMethodBeat.m2504i(94893);
            C41594d c41594d = C41594d.this;
            C41595b c41595b;
            C37269o c37269o;
            switch (i) {
                case 131:
                    c41594d.aUe.type = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case C19395n.CTRL_INDEX /*136*/:
                    c41595b = c41594d.aUe;
                    if (j != 1) {
                        z = false;
                    }
                    c41595b.aVm = z;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 155:
                    c41594d.aUr = c41594d.mo66729N(j);
                    AppMethodBeat.m2505o(94893);
                    return;
                case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                    c41594d.aUe.aOn = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case ErrorCode.NEEDDOWNLOAD_FALSE_6 /*176*/:
                    c41594d.aUe.width = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 179:
                    c41594d.aUm.add(c41594d.mo66729N(j));
                    AppMethodBeat.m2505o(94893);
                    return;
                case 186:
                    c41594d.aUe.height = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 215:
                    c41594d.aUe.number = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 231:
                    c41594d.aUl = c41594d.mo66729N(j);
                    AppMethodBeat.m2505o(94893);
                    return;
                case C31128d.MIC_PTU_QINGCONG /*241*/:
                    if (!c41594d.aUo) {
                        c41594d.aUn.add(j);
                        c41594d.aUo = true;
                        AppMethodBeat.m2505o(94893);
                        return;
                    }
                    break;
                case 251:
                    c41594d.aUI = true;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 16980:
                    if (j != 3) {
                        c37269o = new C37269o("ContentCompAlgo " + j + " not supported");
                        AppMethodBeat.m2505o(94893);
                        throw c37269o;
                    }
                    break;
                case 17029:
                    if (j < 1 || j > 2) {
                        c37269o = new C37269o("DocTypeReadVersion " + j + " not supported");
                        AppMethodBeat.m2505o(94893);
                        throw c37269o;
                    }
                case 17143:
                    if (j != 1) {
                        c37269o = new C37269o("EBMLReadVersion " + j + " not supported");
                        AppMethodBeat.m2505o(94893);
                        throw c37269o;
                    }
                    break;
                case 18401:
                    if (j != 5) {
                        c37269o = new C37269o("ContentEncAlgo " + j + " not supported");
                        AppMethodBeat.m2505o(94893);
                        throw c37269o;
                    }
                    break;
                case 18408:
                    if (j != 1) {
                        c37269o = new C37269o("AESSettingsCipherMode " + j + " not supported");
                        AppMethodBeat.m2505o(94893);
                        throw c37269o;
                    }
                    break;
                case 20529:
                    if (j != 0) {
                        c37269o = new C37269o("ContentEncodingOrder " + j + " not supported");
                        AppMethodBeat.m2505o(94893);
                        throw c37269o;
                    }
                    break;
                case 20530:
                    if (j != 1) {
                        c37269o = new C37269o("ContentEncodingScope " + j + " not supported");
                        AppMethodBeat.m2505o(94893);
                        throw c37269o;
                    }
                    break;
                case 21420:
                    c41594d.aUh = c41594d.aUb + j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 21432:
                    switch ((int) j) {
                        case 0:
                            c41594d.aUe.aOk = 0;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 1:
                            c41594d.aUe.aOk = 2;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 3:
                            c41594d.aUe.aOk = 1;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 15:
                            c41594d.aUe.aOk = 3;
                            AppMethodBeat.m2505o(94893);
                            return;
                        default:
                            AppMethodBeat.m2505o(94893);
                            return;
                    }
                case 21680:
                    c41594d.aUe.aUQ = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 21682:
                    c41594d.aUe.aUS = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 21690:
                    c41594d.aUe.aUR = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 21930:
                    c41595b = c41594d.aUe;
                    if (j != 1) {
                        z = false;
                    }
                    c41595b.aVn = z;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 21945:
                    switch ((int) j) {
                        case 1:
                            c41594d.aUe.aUW = 2;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 2:
                            c41594d.aUe.aUW = 1;
                            AppMethodBeat.m2505o(94893);
                            return;
                        default:
                            AppMethodBeat.m2505o(94893);
                            return;
                    }
                case 21946:
                    switch ((int) j) {
                        case 1:
                        case 6:
                        case 7:
                            c41594d.aUe.aUV = 3;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 16:
                            c41594d.aUe.aUV = 6;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 18:
                            c41594d.aUe.aUV = 7;
                            AppMethodBeat.m2505o(94893);
                            return;
                        default:
                            AppMethodBeat.m2505o(94893);
                            return;
                    }
                case 21947:
                    c41594d.aUe.aUT = true;
                    switch ((int) j) {
                        case 1:
                            c41594d.aUe.aUU = 1;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            c41594d.aUe.aUU = 2;
                            AppMethodBeat.m2505o(94893);
                            return;
                        case 9:
                            c41594d.aUe.aUU = 6;
                            AppMethodBeat.m2505o(94893);
                            return;
                        default:
                            AppMethodBeat.m2505o(94893);
                            return;
                    }
                case 21948:
                    c41594d.aUe.aUX = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 21949:
                    c41594d.aUe.aUY = (int) j;
                    break;
                case 22186:
                    c41594d.aUe.aVk = j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 22203:
                    c41594d.aUe.aVl = j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 25188:
                    c41594d.aUe.aVj = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 2352003:
                    c41594d.aUe.aUL = (int) j;
                    AppMethodBeat.m2505o(94893);
                    return;
                case 2807729:
                    c41594d.aUc = j;
                    AppMethodBeat.m2505o(94893);
                    return;
            }
            AppMethodBeat.m2505o(94893);
        }

        /* renamed from: c */
        public final void mo59471c(int i, double d) {
            C41594d c41594d = C41594d.this;
            switch (i) {
                case 181:
                    c41594d.aUe.sampleRate = (int) d;
                    return;
                case 17545:
                    c41594d.aUd = (long) d;
                    return;
                case 21969:
                    c41594d.aUe.aUZ = (float) d;
                    return;
                case 21970:
                    c41594d.aUe.aVa = (float) d;
                    return;
                case 21971:
                    c41594d.aUe.aVb = (float) d;
                    return;
                case 21972:
                    c41594d.aUe.aVc = (float) d;
                    return;
                case 21973:
                    c41594d.aUe.aVd = (float) d;
                    return;
                case 21974:
                    c41594d.aUe.aVe = (float) d;
                    return;
                case 21975:
                    c41594d.aUe.aVf = (float) d;
                    return;
                case 21976:
                    c41594d.aUe.aVg = (float) d;
                    return;
                case 21977:
                    c41594d.aUe.aVh = (float) d;
                    return;
                case 21978:
                    c41594d.aUe.aVi = (float) d;
                    return;
                default:
                    return;
            }
        }

        /* renamed from: d */
        public final void mo59472d(int i, String str) {
            AppMethodBeat.m2504i(94894);
            C41594d c41594d = C41594d.this;
            switch (i) {
                case C19392d.CTRL_INDEX /*134*/:
                    c41594d.aUe.aUK = str;
                    AppMethodBeat.m2505o(94894);
                    return;
                case 17026:
                    if (!("webm".equals(str) || "matroska".equals(str))) {
                        C37269o c37269o = new C37269o("DocType " + str + " not supported");
                        AppMethodBeat.m2505o(94894);
                        throw c37269o;
                    }
                case 2274716:
                    c41594d.aUe.aOt = str;
                    break;
            }
            AppMethodBeat.m2505o(94894);
        }

        /* renamed from: a */
        public final void mo59470a(int i, int i2, C45026f c45026f) {
            AppMethodBeat.m2504i(94895);
            C41594d c41594d = C41594d.this;
            C37269o c37269o;
            switch (i) {
                case 161:
                case ErrorCode.STARTDOWNLOAD_4 /*163*/:
                    if (c41594d.aUp == 0) {
                        c41594d.aUv = (int) c41594d.aTC.mo32318a(c45026f, false, true, 8);
                        c41594d.aUw = c41594d.aTC.length;
                        c41594d.aUr = -9223372036854775807L;
                        c41594d.aUp = 1;
                        c41594d.aTj.reset();
                    }
                    C41595b c41595b = (C41595b) c41594d.aTR.get(c41594d.aUv);
                    if (c41595b == null) {
                        c45026f.mo59482dG(i2 - c41594d.aUw);
                        c41594d.aUp = 0;
                        AppMethodBeat.m2505o(94895);
                        return;
                    }
                    if (c41594d.aUp == 1) {
                        int i3;
                        c41594d.mo66732b(c45026f, 3);
                        int i4 = (c41594d.aTj.data[2] & 6) >> 1;
                        if (i4 == 0) {
                            c41594d.aUt = 1;
                            c41594d.aUu = C41594d.m72838d(c41594d.aUu, 1);
                            c41594d.aUu[0] = (i2 - c41594d.aUw) - 3;
                        } else if (i != ErrorCode.STARTDOWNLOAD_4) {
                            c37269o = new C37269o("Lacing only supported in SimpleBlocks.");
                            AppMethodBeat.m2505o(94895);
                            throw c37269o;
                        } else {
                            c41594d.mo66732b(c45026f, 4);
                            c41594d.aUt = (c41594d.aTj.data[3] & 255) + 1;
                            c41594d.aUu = C41594d.m72838d(c41594d.aUu, c41594d.aUt);
                            int i5;
                            int i6;
                            int[] iArr;
                            if (i4 == 2) {
                                Arrays.fill(c41594d.aUu, 0, c41594d.aUt, ((i2 - c41594d.aUw) - 4) / c41594d.aUt);
                            } else if (i4 == 1) {
                                i5 = 0;
                                i3 = 4;
                                for (i4 = 0; i4 < c41594d.aUt - 1; i4++) {
                                    c41594d.aUu[i4] = 0;
                                    do {
                                        i3++;
                                        c41594d.mo66732b(c45026f, i3);
                                        i6 = c41594d.aTj.data[i3 - 1] & 255;
                                        iArr = c41594d.aUu;
                                        iArr[i4] = iArr[i4] + i6;
                                    } while (i6 == 255);
                                    i5 += c41594d.aUu[i4];
                                }
                                c41594d.aUu[c41594d.aUt - 1] = ((i2 - c41594d.aUw) - i3) - i5;
                            } else if (i4 == 3) {
                                i5 = 0;
                                i3 = 4;
                                for (i4 = 0; i4 < c41594d.aUt - 1; i4++) {
                                    c41594d.aUu[i4] = 0;
                                    i3++;
                                    c41594d.mo66732b(c45026f, i3);
                                    if (c41594d.aTj.data[i3 - 1] == (byte) 0) {
                                        c37269o = new C37269o("No valid varint length mask found");
                                        AppMethodBeat.m2505o(94895);
                                        throw c37269o;
                                    }
                                    long j = 0;
                                    int i7 = 0;
                                    while (true) {
                                        int i8 = i7;
                                        if (i8 < 8) {
                                            int i9 = 1 << (7 - i8);
                                            if ((c41594d.aTj.data[i3 - 1] & i9) != 0) {
                                                i6 = i3 - 1;
                                                i3 += i8;
                                                c41594d.mo66732b(c45026f, i3);
                                                j = (long) ((c41594d.aTj.data[i6] & 255) & (i9 ^ -1));
                                                for (i7 = i6 + 1; i7 < i3; i7++) {
                                                    j = (j << 8) | ((long) (c41594d.aTj.data[i7] & 255));
                                                }
                                                if (i4 > 0) {
                                                    j -= (1 << ((i8 * 7) + 6)) - 1;
                                                }
                                            } else {
                                                i7 = i8 + 1;
                                            }
                                        }
                                    }
                                    if (j < -2147483648L || j > 2147483647L) {
                                        c37269o = new C37269o("EBML lacing sample size out of range.");
                                        AppMethodBeat.m2505o(94895);
                                        throw c37269o;
                                    }
                                    i6 = (int) j;
                                    iArr = c41594d.aUu;
                                    if (i4 != 0) {
                                        i6 += c41594d.aUu[i4 - 1];
                                    }
                                    iArr[i4] = i6;
                                    i5 += c41594d.aUu[i4];
                                }
                                c41594d.aUu[c41594d.aUt - 1] = ((i2 - c41594d.aUw) - i3) - i5;
                            } else {
                                c37269o = new C37269o("Unexpected lacing value: ".concat(String.valueOf(i4)));
                                AppMethodBeat.m2505o(94895);
                                throw c37269o;
                            }
                        }
                        c41594d.aUq = c41594d.aUl + c41594d.mo66729N((long) ((c41594d.aTj.data[0] << 8) | (c41594d.aTj.data[1] & 255)));
                        Object obj = (c41594d.aTj.data[2] & 8) == 8 ? 1 : null;
                        Object obj2 = (c41595b.type == 2 || (i == ErrorCode.STARTDOWNLOAD_4 && (c41594d.aTj.data[2] & 128) == 128)) ? 1 : null;
                        i3 = obj2 != null ? 1 : 0;
                        if (obj != null) {
                            i4 = C8415j.INVALID_ID;
                        } else {
                            i4 = 0;
                        }
                        c41594d.aUx = i4 | i3;
                        c41594d.aUp = 2;
                        c41594d.aUs = 0;
                    }
                    if (i == ErrorCode.STARTDOWNLOAD_4) {
                        while (c41594d.aUs < c41594d.aUt) {
                            c41594d.mo66731a(c45026f, c41595b, c41594d.aUu[c41594d.aUs]);
                            c41594d.mo66730a(c41595b, c41594d.aUq + ((long) ((c41594d.aUs * c41595b.aUL) / 1000)));
                            c41594d.aUs++;
                        }
                        c41594d.aUp = 0;
                        AppMethodBeat.m2505o(94895);
                        return;
                    }
                    c41594d.mo66731a(c45026f, c41595b, c41594d.aUu[0]);
                    AppMethodBeat.m2505o(94895);
                    return;
                case 16981:
                    c41594d.aUe.aUN = new byte[i2];
                    c45026f.readFully(c41594d.aUe.aUN, 0, i2);
                    AppMethodBeat.m2505o(94895);
                    return;
                case 18402:
                    byte[] bArr = new byte[i2];
                    c45026f.readFully(bArr, 0, i2);
                    c41594d.aUe.aUO = new C8663a(1, bArr, 0, 0);
                    AppMethodBeat.m2505o(94895);
                    return;
                case 21419:
                    Arrays.fill(c41594d.aTU.data, (byte) 0);
                    c45026f.readFully(c41594d.aTU.data, 4 - i2, i2);
                    c41594d.aTU.setPosition(0);
                    c41594d.aUg = (int) c41594d.aTU.mo52366cM();
                    AppMethodBeat.m2505o(94895);
                    return;
                case 25506:
                    c41594d.aUe.aUP = new byte[i2];
                    c45026f.readFully(c41594d.aUe.aUP, 0, i2);
                    AppMethodBeat.m2505o(94895);
                    return;
                case 30322:
                    c41594d.aUe.aOl = new byte[i2];
                    c45026f.readFully(c41594d.aUe.aOl, 0, i2);
                    AppMethodBeat.m2505o(94895);
                    return;
                default:
                    c37269o = new C37269o("Unexpected id: ".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(94895);
                    throw c37269o;
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.b.d$b */
    static final class C41595b {
        public DrmInitData aOg;
        public int aOk;
        public byte[] aOl;
        public int aOn;
        String aOt;
        public C32041m aTw;
        public int aTz;
        public String aUK;
        public int aUL;
        public boolean aUM;
        public byte[] aUN;
        public C8663a aUO;
        public byte[] aUP;
        public int aUQ;
        public int aUR;
        public int aUS;
        public boolean aUT;
        public int aUU;
        public int aUV;
        public int aUW;
        public int aUX;
        public int aUY;
        public float aUZ;
        public float aVa;
        public float aVb;
        public float aVc;
        public float aVd;
        public float aVe;
        public float aVf;
        public float aVg;
        public float aVh;
        public float aVi;
        public int aVj;
        public long aVk;
        public long aVl;
        public boolean aVm;
        public boolean aVn;
        public int height;
        public int number;
        public int sampleRate;
        public int type;
        public int width;

        private C41595b() {
            this.width = -1;
            this.height = -1;
            this.aUQ = -1;
            this.aUR = -1;
            this.aUS = 0;
            this.aOl = null;
            this.aOk = -1;
            this.aUT = false;
            this.aUU = -1;
            this.aUV = -1;
            this.aUW = -1;
            this.aUX = 1000;
            this.aUY = 200;
            this.aUZ = -1.0f;
            this.aVa = -1.0f;
            this.aVb = -1.0f;
            this.aVc = -1.0f;
            this.aVd = -1.0f;
            this.aVe = -1.0f;
            this.aVf = -1.0f;
            this.aVg = -1.0f;
            this.aVh = -1.0f;
            this.aVi = -1.0f;
            this.aOn = 1;
            this.aVj = -1;
            this.sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            this.aVk = 0;
            this.aVl = 0;
            this.aVn = true;
            this.aOt = "eng";
        }

        /* synthetic */ C41595b(byte b) {
            this();
        }

        /* renamed from: i */
        static List<byte[]> m72851i(C32065l c32065l) {
            AppMethodBeat.m2504i(94896);
            C37269o c37269o;
            try {
                c32065l.mo52369eM(16);
                if (c32065l.mo52385tE() != 826496599) {
                    AppMethodBeat.m2505o(94896);
                    return null;
                }
                int i = c32065l.position + 20;
                byte[] bArr = c32065l.data;
                while (i < bArr.length - 4) {
                    if (bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 1 && bArr[i + 3] == (byte) 15) {
                        List<byte[]> singletonList = Collections.singletonList(Arrays.copyOfRange(bArr, i, bArr.length));
                        AppMethodBeat.m2505o(94896);
                        return singletonList;
                    }
                    i++;
                }
                c37269o = new C37269o("Failed to find FourCC VC1 initialization data");
                AppMethodBeat.m2505o(94896);
                throw c37269o;
            } catch (ArrayIndexOutOfBoundsException e) {
                c37269o = new C37269o("Error parsing FourCC VC1 codec private");
                AppMethodBeat.m2505o(94896);
                throw c37269o;
            }
        }

        /* renamed from: m */
        static List<byte[]> m72853m(byte[] bArr) {
            int i = 0;
            AppMethodBeat.m2504i(94897);
            C37269o c37269o;
            try {
                if (bArr[0] != (byte) 2) {
                    c37269o = new C37269o("Error parsing vorbis codec private");
                    AppMethodBeat.m2505o(94897);
                    throw c37269o;
                }
                int i2 = 0;
                int i3 = 1;
                while (bArr[i3] == (byte) -1) {
                    i3++;
                    i2 += 255;
                }
                int i4 = i3 + 1;
                i2 += bArr[i3];
                while (bArr[i4] == (byte) -1) {
                    i += 255;
                    i4++;
                }
                i3 = i4 + 1;
                i += bArr[i4];
                if (bArr[i3] != (byte) 1) {
                    c37269o = new C37269o("Error parsing vorbis codec private");
                    AppMethodBeat.m2505o(94897);
                    throw c37269o;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i3, bArr2, 0, i2);
                i2 += i3;
                if (bArr[i2] != (byte) 3) {
                    c37269o = new C37269o("Error parsing vorbis codec private");
                    AppMethodBeat.m2505o(94897);
                    throw c37269o;
                }
                i += i2;
                if (bArr[i] != (byte) 5) {
                    c37269o = new C37269o("Error parsing vorbis codec private");
                    AppMethodBeat.m2505o(94897);
                    throw c37269o;
                }
                byte[] bArr3 = new byte[(bArr.length - i)];
                System.arraycopy(bArr, i, bArr3, 0, bArr.length - i);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                AppMethodBeat.m2505o(94897);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e) {
                c37269o = new C37269o("Error parsing vorbis codec private");
                AppMethodBeat.m2505o(94897);
                throw c37269o;
            }
        }

        /* renamed from: j */
        static boolean m72852j(C32065l c32065l) {
            AppMethodBeat.m2504i(94898);
            try {
                int tC = c32065l.mo52383tC();
                if (tC == 1) {
                    AppMethodBeat.m2505o(94898);
                    return true;
                } else if (tC == BitUtils.BIT_TURN_ZERO_1) {
                    c32065l.setPosition(24);
                    if (c32065l.readLong() == C41594d.aTP.getMostSignificantBits() && c32065l.readLong() == C41594d.aTP.getLeastSignificantBits()) {
                        AppMethodBeat.m2505o(94898);
                        return true;
                    }
                    AppMethodBeat.m2505o(94898);
                    return false;
                } else {
                    AppMethodBeat.m2505o(94898);
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                C37269o c37269o = new C37269o("Error parsing MS/ACM codec private");
                AppMethodBeat.m2505o(94898);
                throw c37269o;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(94914);
        AppMethodBeat.m2505o(94914);
    }

    public C41594d() {
        this(0);
    }

    public C41594d(int i) {
        this(new C17633a(), i);
        AppMethodBeat.m2504i(94899);
        AppMethodBeat.m2505o(94899);
    }

    private C41594d(C45020b c45020b, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(94900);
        this.aUb = -1;
        this.aUc = -9223372036854775807L;
        this.aUd = -9223372036854775807L;
        this.aOz = -9223372036854775807L;
        this.aUj = -1;
        this.aUk = -1;
        this.aUl = -9223372036854775807L;
        this.aTQ = c45020b;
        this.aTQ.mo32315a(new C41593a(this, (byte) 0));
        if ((i & 1) == 0) {
            z = true;
        }
        this.aTS = z;
        this.aTC = new C17634f();
        this.aTR = new SparseArray();
        this.aTj = new C32065l(4);
        this.aTT = new C32065l(ByteBuffer.allocate(4).putInt(-1).array());
        this.aTU = new C32065l(4);
        this.aTx = new C32065l(C45041j.bqY);
        this.aTy = new C32065l(4);
        this.aTV = new C32065l();
        this.aTW = new C32065l();
        this.aTX = new C32065l(8);
        this.aTY = new C32065l();
        AppMethodBeat.m2505o(94900);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(94901);
        C41596e c41596e = new C41596e();
        long length = c45026f.getLength();
        long j = (length == -1 || length > 1024) ? 1024 : length;
        int i = (int) j;
        c45026f.mo59479b(c41596e.aTj.data, 0, 4);
        c41596e.aVo = 4;
        for (j = c41596e.aTj.mo52366cM(); j != 440786851; j = ((j << 8) & -256) | ((long) (c41596e.aTj.data[0] & 255))) {
            int i2 = c41596e.aVo + 1;
            c41596e.aVo = i2;
            if (i2 == i) {
                break;
            }
            c45026f.mo59479b(c41596e.aTj.data, 0, 1);
        }
        j = c41596e.mo66733d(c45026f);
        long j2 = (long) c41596e.aVo;
        if (j == Long.MIN_VALUE || (length != -1 && j2 + j >= length)) {
            AppMethodBeat.m2505o(94901);
            return false;
        }
        while (((long) c41596e.aVo) < j2 + j) {
            if (c41596e.mo66733d(c45026f) == Long.MIN_VALUE) {
                break;
            }
            length = c41596e.mo66733d(c45026f);
            if (length < 0 || length > 2147483647L) {
                AppMethodBeat.m2505o(94901);
                return false;
            } else if (length != 0) {
                c45026f.mo59483dH((int) length);
                c41596e.aVo = (int) (length + ((long) c41596e.aVo));
            }
        }
        if (((long) c41596e.aVo) == j + j2) {
            AppMethodBeat.m2505o(94901);
            return true;
        }
        AppMethodBeat.m2505o(94901);
        return false;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        this.aTn = c8662g;
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(94902);
        this.aUl = -9223372036854775807L;
        this.aUp = 0;
        this.aTQ.reset();
        this.aTC.reset();
        m72841rd();
        AppMethodBeat.m2505o(94902);
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(94903);
        this.aUH = false;
        int i = 1;
        while (i != 0 && !this.aUH) {
            boolean z;
            boolean c = this.aTQ.mo32316c(c45026f);
            if (c) {
                long position = c45026f.getPosition();
                if (this.aUi) {
                    this.aUk = position;
                    c32040k.position = this.aUj;
                    this.aUi = false;
                    i = 1;
                } else if (!this.aUf || this.aUk == -1) {
                    z = false;
                } else {
                    c32040k.position = this.aUk;
                    this.aUk = -1;
                    i = 1;
                }
                if (i != 0) {
                    AppMethodBeat.m2505o(94903);
                    return 1;
                }
            }
            z = c;
        }
        if (i != 0) {
            AppMethodBeat.m2505o(94903);
            return 0;
        }
        AppMethodBeat.m2505o(94903);
        return -1;
    }

    /* renamed from: dO */
    static int m72839dO(int i) {
        switch (i) {
            case 131:
            case C19395n.CTRL_INDEX /*136*/:
            case 155:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_6 /*176*/:
            case 179:
            case 186:
            case 215:
            case 231:
            case C31128d.MIC_PTU_QINGCONG /*241*/:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case C19392d.CTRL_INDEX /*134*/:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case ErrorCode.STARTDOWNLOAD_4 /*163*/:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* renamed from: dP */
    static boolean m72840dP(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo66730a(C41595b c41595b, long j) {
        AppMethodBeat.m2504i(94904);
        if ("S_TEXT/UTF8".equals(c41595b.aUK)) {
            m72835a(c41595b, "%02d:%02d:%02d,%03d", 19, aTK, aTJ);
        } else if ("S_TEXT/ASS".equals(c41595b.aUK)) {
            m72835a(c41595b, "%01d:%02d:%02d:%02d", 21, aTN, aTO);
        }
        c41595b.aTw.mo42834a(j, this.aUx, this.aUG, 0, c41595b.aUO);
        this.aUH = true;
        m72841rd();
        AppMethodBeat.m2505o(94904);
    }

    /* renamed from: rd */
    private void m72841rd() {
        AppMethodBeat.m2504i(94905);
        this.aUy = 0;
        this.aUG = 0;
        this.aUF = 0;
        this.aUz = false;
        this.aUA = false;
        this.aUC = false;
        this.aUE = 0;
        this.aUD = (byte) 0;
        this.aUB = false;
        this.aTV.reset();
        AppMethodBeat.m2505o(94905);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo66732b(C45026f c45026f, int i) {
        AppMethodBeat.m2504i(94906);
        if (this.aTj.limit >= i) {
            AppMethodBeat.m2505o(94906);
            return;
        }
        if (this.aTj.capacity() < i) {
            this.aTj.mo52371n(Arrays.copyOf(this.aTj.data, Math.max(this.aTj.data.length * 2, i)), this.aTj.limit);
        }
        c45026f.readFully(this.aTj.data, this.aTj.limit, i - this.aTj.limit);
        this.aTj.mo52368eL(i);
        AppMethodBeat.m2505o(94906);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo66731a(C45026f c45026f, C41595b c41595b, int i) {
        AppMethodBeat.m2504i(94907);
        if ("S_TEXT/UTF8".equals(c41595b.aUK)) {
            m72836a(c45026f, aTI, i);
            AppMethodBeat.m2505o(94907);
        } else if ("S_TEXT/ASS".equals(c41595b.aUK)) {
            m72836a(c45026f, aTM, i);
            AppMethodBeat.m2505o(94907);
        } else {
            int i2;
            int i3;
            int i4;
            C32041m c32041m = c41595b.aTw;
            if (!this.aUz) {
                if (c41595b.aUM) {
                    this.aUx &= -1073741825;
                    if (!this.aUA) {
                        c45026f.readFully(this.aTj.data, 0, 1);
                        this.aUy++;
                        if ((this.aTj.data[0] & 128) == 128) {
                            C37269o c37269o = new C37269o("Extension bit is set in signal byte");
                            AppMethodBeat.m2505o(94907);
                            throw c37269o;
                        }
                        this.aUD = this.aTj.data[0];
                        this.aUA = true;
                    }
                    if (((this.aUD & 1) == 1 ? 1 : 0) != 0) {
                        int i5;
                        if ((this.aUD & 2) == 2) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        this.aUx |= ErrorDialogData.SUPPRESSED;
                        if (!this.aUB) {
                            c45026f.readFully(this.aTX.data, 0, 8);
                            this.aUy += 8;
                            this.aUB = true;
                            byte[] bArr = this.aTj.data;
                            if (i2 != 0) {
                                i5 = 128;
                            } else {
                                i5 = 0;
                            }
                            bArr[0] = (byte) (i5 | 8);
                            this.aTj.setPosition(0);
                            c32041m.mo42835a(this.aTj, 1);
                            this.aUG++;
                            this.aTX.setPosition(0);
                            c32041m.mo42835a(this.aTX, 8);
                            this.aUG += 8;
                        }
                        if (i2 != 0) {
                            if (!this.aUC) {
                                c45026f.readFully(this.aTj.data, 0, 1);
                                this.aUy++;
                                this.aTj.setPosition(0);
                                this.aUE = this.aTj.readUnsignedByte();
                                this.aUC = true;
                            }
                            i2 = this.aUE * 4;
                            this.aTj.reset(i2);
                            c45026f.readFully(this.aTj.data, 0, i2);
                            this.aUy = i2 + this.aUy;
                            short s = (short) ((this.aUE / 2) + 1);
                            i3 = (s * 6) + 2;
                            if (this.aTZ == null || this.aTZ.capacity() < i3) {
                                this.aTZ = ByteBuffer.allocate(i3);
                            }
                            this.aTZ.position(0);
                            this.aTZ.putShort(s);
                            i2 = 0;
                            i4 = 0;
                            while (i4 < this.aUE) {
                                i5 = this.aTj.mo52389tI();
                                if (i4 % 2 == 0) {
                                    this.aTZ.putShort((short) (i5 - i2));
                                } else {
                                    this.aTZ.putInt(i5 - i2);
                                }
                                i4++;
                                i2 = i5;
                            }
                            i2 = (i - this.aUy) - i2;
                            if (this.aUE % 2 == 1) {
                                this.aTZ.putInt(i2);
                            } else {
                                this.aTZ.putShort((short) i2);
                                this.aTZ.putInt(0);
                            }
                            this.aTY.mo52371n(this.aTZ.array(), i3);
                            c32041m.mo42835a(this.aTY, i3);
                            this.aUG += i3;
                        }
                    }
                } else if (c41595b.aUN != null) {
                    this.aTV.mo52371n(c41595b.aUN, c41595b.aUN.length);
                }
                this.aUz = true;
            }
            i2 = this.aTV.limit + i;
            if ("V_MPEG4/ISO/AVC".equals(c41595b.aUK) || "V_MPEGH/ISO/HEVC".equals(c41595b.aUK)) {
                byte[] bArr2 = this.aTy.data;
                bArr2[0] = (byte) 0;
                bArr2[1] = (byte) 0;
                bArr2[2] = (byte) 0;
                int i6 = c41595b.aTz;
                i4 = 4 - c41595b.aTz;
                while (this.aUy < i2) {
                    if (this.aUF == 0) {
                        i3 = Math.min(i6, this.aTV.mo52382tB());
                        c45026f.readFully(bArr2, i4 + i3, i6 - i3);
                        if (i3 > 0) {
                            this.aTV.readBytes(bArr2, i4, i3);
                        }
                        this.aUy += i6;
                        this.aTy.setPosition(0);
                        this.aUF = this.aTy.mo52389tI();
                        this.aTx.setPosition(0);
                        c32041m.mo42835a(this.aTx, 4);
                        this.aUG += 4;
                    } else {
                        this.aUF -= m72834a(c45026f, c32041m, this.aUF);
                    }
                }
            } else {
                while (this.aUy < i2) {
                    m72834a(c45026f, c32041m, i2 - this.aUy);
                }
            }
            if ("A_VORBIS".equals(c41595b.aUK)) {
                this.aTT.setPosition(0);
                c32041m.mo42835a(this.aTT, 4);
                this.aUG += 4;
            }
            AppMethodBeat.m2505o(94907);
        }
    }

    /* renamed from: a */
    private void m72836a(C45026f c45026f, byte[] bArr, int i) {
        AppMethodBeat.m2504i(94908);
        int length = bArr.length + i;
        if (this.aTW.capacity() < length) {
            this.aTW.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.aTW.data, 0, bArr.length);
        }
        c45026f.readFully(this.aTW.data, bArr.length, i);
        this.aTW.reset(length);
        AppMethodBeat.m2505o(94908);
    }

    /* renamed from: a */
    private void m72835a(C41595b c41595b, String str, int i, long j, byte[] bArr) {
        AppMethodBeat.m2504i(94909);
        C41594d.m72837a(this.aTW.data, this.aUr, str, i, j, bArr);
        c41595b.aTw.mo42835a(this.aTW, this.aTW.limit);
        this.aUG += this.aTW.limit;
        AppMethodBeat.m2505o(94909);
    }

    /* renamed from: a */
    private static void m72837a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        Object obj;
        AppMethodBeat.m2504i(94910);
        if (j == -9223372036854775807L) {
            obj = bArr2;
        } else {
            long j3 = j - (((long) (((int) (j / 3600000000L)) * 3600)) * 1000000);
            j3 -= ((long) (((int) (j3 / 60000000)) * 60)) * 1000000;
            int i2 = (int) ((j3 - (((long) ((int) (j3 / 1000000))) * 1000000)) / j2);
            obj = C17675v.m27559aQ(String.format(Locale.US, str, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r6), Integer.valueOf(i2)}));
        }
        System.arraycopy(obj, 0, bArr, i, bArr2.length);
        AppMethodBeat.m2505o(94910);
    }

    /* renamed from: a */
    private int m72834a(C45026f c45026f, C32041m c32041m, int i) {
        AppMethodBeat.m2504i(94911);
        int tB = this.aTV.mo52382tB();
        if (tB > 0) {
            tB = Math.min(i, tB);
            c32041m.mo42835a(this.aTV, tB);
        } else {
            tB = c32041m.mo42832a(c45026f, i, false);
        }
        this.aUy += tB;
        this.aUG += tB;
        AppMethodBeat.m2505o(94911);
        return tB;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: N */
    public final long mo66729N(long j) {
        AppMethodBeat.m2504i(94912);
        if (this.aUc == -9223372036854775807L) {
            C37269o c37269o = new C37269o("Can't scale timecode prior to timecodeScale being set.");
            AppMethodBeat.m2505o(94912);
            throw c37269o;
        }
        long b = C17675v.m27564b(j, this.aUc, 1000);
        AppMethodBeat.m2505o(94912);
        return b;
    }

    /* renamed from: d */
    static int[] m72838d(int[] iArr, int i) {
        AppMethodBeat.m2504i(94913);
        if (iArr == null) {
            iArr = new int[i];
            AppMethodBeat.m2505o(94913);
            return iArr;
        } else if (iArr.length >= i) {
            AppMethodBeat.m2505o(94913);
            return iArr;
        } else {
            iArr = new int[Math.max(iArr.length * 2, i)];
            AppMethodBeat.m2505o(94913);
            return iArr;
        }
    }
}

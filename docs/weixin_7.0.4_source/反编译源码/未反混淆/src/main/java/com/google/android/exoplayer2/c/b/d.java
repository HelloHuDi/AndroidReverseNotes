package com.google.android.exoplayer2.c.b;

import android.support.v4.widget.j;
import android.util.SparseArray;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class d implements e {
    private static final byte[] aTI = new byte[]{(byte) 49, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, (byte) 45, (byte) 45, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
    private static final byte[] aTJ = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static long aTK = 1000;
    static final byte[] aTL = v.aQ("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] aTM = new byte[]{(byte) 68, (byte) 105, (byte) 97, (byte) 108, (byte) 111, (byte) 103, (byte) 117, (byte) 101, (byte) 58, (byte) 32, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44};
    private static long aTN = 10000;
    private static final byte[] aTO = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static final UUID aTP = new UUID(72057594037932032L, -9223371306706625679L);
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(94888);
            e[] eVarArr = new e[]{new d()};
            AppMethodBeat.o(94888);
            return eVarArr;
        }
    };
    long aOz;
    final f aTC;
    private final b aTQ;
    final SparseArray<b> aTR;
    final boolean aTS;
    private final l aTT;
    final l aTU;
    private final l aTV;
    private final l aTW;
    private final l aTX;
    private final l aTY;
    private ByteBuffer aTZ;
    final l aTj;
    g aTn;
    private final l aTx;
    private final l aTy;
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
    b aUe;
    boolean aUf;
    int aUg;
    long aUh;
    boolean aUi;
    long aUj;
    private long aUk;
    long aUl;
    com.google.android.exoplayer2.i.g aUm;
    com.google.android.exoplayer2.i.g aUn;
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

    final class a implements c {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final int dO(int i) {
            AppMethodBeat.i(94889);
            int dO = d.dO(i);
            AppMethodBeat.o(94889);
            return dO;
        }

        public final boolean dP(int i) {
            AppMethodBeat.i(94890);
            boolean dP = d.dP(i);
            AppMethodBeat.o(94890);
            return dP;
        }

        public final void f(int i, long j, long j2) {
            AppMethodBeat.i(94891);
            d dVar = d.this;
            switch (i) {
                case 160:
                    dVar.aUI = false;
                    AppMethodBeat.o(94891);
                    return;
                case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
                    dVar.aUe = new b();
                    AppMethodBeat.o(94891);
                    return;
                case 187:
                    dVar.aUo = false;
                    AppMethodBeat.o(94891);
                    return;
                case 19899:
                    dVar.aUg = -1;
                    dVar.aUh = -1;
                    AppMethodBeat.o(94891);
                    return;
                case 20533:
                    dVar.aUe.aUM = true;
                    AppMethodBeat.o(94891);
                    return;
                case 21968:
                    dVar.aUe.aUT = true;
                    break;
                case 25152:
                    AppMethodBeat.o(94891);
                    return;
                case 408125543:
                    if (dVar.aUb == -1 || dVar.aUb == j) {
                        dVar.aUb = j;
                        dVar.aUa = j2;
                        AppMethodBeat.o(94891);
                        return;
                    }
                    o oVar = new o("Multiple Segment elements not supported");
                    AppMethodBeat.o(94891);
                    throw oVar;
                case 475249515:
                    dVar.aUm = new com.google.android.exoplayer2.i.g();
                    dVar.aUn = new com.google.android.exoplayer2.i.g();
                    AppMethodBeat.o(94891);
                    return;
                case 524531317:
                    if (!dVar.aUf) {
                        if (!dVar.aTS || dVar.aUj == -1) {
                            dVar.aTn.a(new com.google.android.exoplayer2.c.l.a(dVar.aOz));
                            dVar.aUf = true;
                            AppMethodBeat.o(94891);
                            return;
                        }
                        dVar.aUi = true;
                        AppMethodBeat.o(94891);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(94891);
        }

        public final void dQ(int i) {
            AppMethodBeat.i(94892);
            d dVar = d.this;
            int i2;
            o oVar;
            int i3;
            switch (i) {
                case 160:
                    if (dVar.aUp == 2) {
                        if (!dVar.aUI) {
                            dVar.aUx |= 1;
                        }
                        dVar.a((b) dVar.aTR.get(dVar.aUv), dVar.aUq);
                        dVar.aUp = 0;
                        AppMethodBeat.o(94892);
                        return;
                    }
                    break;
                case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
                    Object obj;
                    String str = dVar.aUe.aUK;
                    if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        Format a;
                        b bVar = dVar.aUe;
                        g gVar = dVar.aTn;
                        i2 = dVar.aUe.number;
                        int i4 = -1;
                        int i5 = -1;
                        List list = null;
                        String str2 = bVar.aUK;
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
                                if (bVar.aUP == null) {
                                    list2 = null;
                                } else {
                                    list2 = Collections.singletonList(bVar.aUP);
                                }
                                list = list2;
                                break;
                            case 6:
                                str2 = "video/avc";
                                com.google.android.exoplayer2.video.a K = com.google.android.exoplayer2.video.a.K(new l(bVar.aUP));
                                list = K.aOf;
                                bVar.aTz = K.aTz;
                                break;
                            case 7:
                                str2 = "video/hevc";
                                com.google.android.exoplayer2.video.b M = com.google.android.exoplayer2.video.b.M(new l(bVar.aUP));
                                list = M.aOf;
                                bVar.aTz = M.aTz;
                                break;
                            case 8:
                                list = b.i(new l(bVar.aUP));
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
                                list = b.m(bVar.aUP);
                                break;
                            case 11:
                                str2 = "audio/opus";
                                i4 = 5760;
                                list = new ArrayList(3);
                                list.add(bVar.aUP);
                                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(bVar.aVk).array());
                                list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(bVar.aVl).array());
                                break;
                            case 12:
                                str2 = "audio/mp4a-latm";
                                list = Collections.singletonList(bVar.aUP);
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
                                list = Collections.singletonList(bVar.aUP);
                                break;
                            case 22:
                                str2 = "audio/raw";
                                if (!b.j(new l(bVar.aUP))) {
                                    str2 = "audio/x-unknown";
                                    break;
                                }
                                i5 = v.eR(bVar.aVj);
                                if (i5 == 0) {
                                    i5 = -1;
                                    str2 = "audio/x-unknown";
                                    new StringBuilder("Unsupported PCM bit depth: ").append(bVar.aVj).append(". Setting mimeType to ").append(str2);
                                    break;
                                }
                                break;
                            case 23:
                                str2 = "audio/raw";
                                i5 = v.eR(bVar.aVj);
                                if (i5 == 0) {
                                    i5 = -1;
                                    str2 = "audio/x-unknown";
                                    new StringBuilder("Unsupported PCM bit depth: ").append(bVar.aVj).append(". Setting mimeType to ").append(str2);
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
                                list = Collections.singletonList(bVar.aUP);
                                break;
                            case 27:
                                str2 = "application/pgs";
                                break;
                            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                str2 = "application/dvbsubs";
                                list = Collections.singletonList(new byte[]{bVar.aUP[0], bVar.aUP[1], bVar.aUP[2], bVar.aUP[3]});
                                break;
                            default:
                                oVar = new o("Unrecognized codec identifier.");
                                AppMethodBeat.o(94892);
                                throw oVar;
                        }
                        int i6 = ((bVar.aVn ? 1 : 0) | 0) | (bVar.aVm ? 2 : 0);
                        if (i.aH(str2)) {
                            a = Format.a(Integer.toString(i2), str2, -1, i4, bVar.aOn, bVar.sampleRate, i5, list, bVar.aOg, i6, bVar.aOt);
                        } else if (i.aI(str2)) {
                            if (bVar.aUS == 0) {
                                bVar.aUQ = bVar.aUQ == -1 ? bVar.width : bVar.aUQ;
                                if (bVar.aUR == -1) {
                                    i3 = bVar.height;
                                } else {
                                    i3 = bVar.aUR;
                                }
                                bVar.aUR = i3;
                            }
                            float f = -1.0f;
                            if (!(bVar.aUQ == -1 || bVar.aUR == -1)) {
                                f = ((float) (bVar.height * bVar.aUQ)) / ((float) (bVar.width * bVar.aUR));
                            }
                            ColorInfo colorInfo = null;
                            if (bVar.aUT) {
                                byte[] bArr;
                                if (bVar.aUZ == -1.0f || bVar.aVa == -1.0f || bVar.aVb == -1.0f || bVar.aVc == -1.0f || bVar.aVd == -1.0f || bVar.aVe == -1.0f || bVar.aVf == -1.0f || bVar.aVg == -1.0f || bVar.aVh == -1.0f || bVar.aVi == -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = new byte[25];
                                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                    wrap.put((byte) 0);
                                    wrap.putShort((short) ((int) ((bVar.aUZ * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.aVa * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.aVb * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.aVc * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.aVd * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.aVe * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.aVf * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) ((bVar.aVg * 50000.0f) + 0.5f)));
                                    wrap.putShort((short) ((int) (bVar.aVh + 0.5f)));
                                    wrap.putShort((short) ((int) (bVar.aVi + 0.5f)));
                                    wrap.putShort((short) bVar.aUX);
                                    wrap.putShort((short) bVar.aUY);
                                }
                                ColorInfo colorInfo2 = new ColorInfo(bVar.aUU, bVar.aUW, bVar.aUV, bArr);
                            }
                            a = Format.a(Integer.toString(i2), str2, i4, bVar.width, bVar.height, list, -1, f, bVar.aOl, bVar.aOk, colorInfo, bVar.aOg);
                        } else if ("application/x-subrip".equals(str2)) {
                            a = Format.a(Integer.toString(i2), str2, i6, bVar.aOt, bVar.aOg);
                        } else if ("text/x-ssa".equals(str2)) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(d.aTL);
                            arrayList.add(bVar.aUP);
                            a = Format.a(Integer.toString(i2), str2, i6, bVar.aOt, -1, bVar.aOg, Long.MAX_VALUE, arrayList);
                        } else if ("application/vobsub".equals(str2) || "application/pgs".equals(str2) || "application/dvbsubs".equals(str2)) {
                            a = Format.a(Integer.toString(i2), str2, list, bVar.aOt, bVar.aOg);
                        } else {
                            oVar = new o("Unexpected MIME type.");
                            AppMethodBeat.o(94892);
                            throw oVar;
                        }
                        bVar.aTw = gVar.dM(bVar.number);
                        bVar.aTw.f(a);
                        dVar.aTR.put(dVar.aUe.number, dVar.aUe);
                    }
                    dVar.aUe = null;
                    AppMethodBeat.o(94892);
                    return;
                case 19899:
                    if (dVar.aUg == -1 || dVar.aUh == -1) {
                        oVar = new o("Mandatory element SeekID or SeekPosition not found");
                        AppMethodBeat.o(94892);
                        throw oVar;
                    } else if (dVar.aUg == 475249515) {
                        dVar.aUj = dVar.aUh;
                        AppMethodBeat.o(94892);
                        return;
                    }
                    break;
                case 25152:
                    if (dVar.aUe.aUM) {
                        if (dVar.aUe.aUO == null) {
                            oVar = new o("Encrypted Track found but ContentEncKeyID was not found");
                            AppMethodBeat.o(94892);
                            throw oVar;
                        }
                        dVar.aUe.aOg = new DrmInitData(new SchemeData(com.google.android.exoplayer2.b.aMx, "video/webm", dVar.aUe.aUO.aTc));
                        AppMethodBeat.o(94892);
                        return;
                    }
                    break;
                case 28032:
                    if (dVar.aUe.aUM && dVar.aUe.aUN != null) {
                        oVar = new o("Combining encryption and compression is not supported");
                        AppMethodBeat.o(94892);
                        throw oVar;
                    }
                case 357149030:
                    if (dVar.aUc == -9223372036854775807L) {
                        dVar.aUc = 1000000;
                    }
                    if (dVar.aUd != -9223372036854775807L) {
                        dVar.aOz = dVar.N(dVar.aUd);
                        AppMethodBeat.o(94892);
                        return;
                    }
                    break;
                case 374648427:
                    if (dVar.aTR.size() != 0) {
                        dVar.aTn.rb();
                        break;
                    }
                    oVar = new o("No valid tracks were found");
                    AppMethodBeat.o(94892);
                    throw oVar;
                case 475249515:
                    if (!dVar.aUf) {
                        com.google.android.exoplayer2.c.l aVar;
                        g gVar2 = dVar.aTn;
                        if (dVar.aUb == -1 || dVar.aOz == -9223372036854775807L || dVar.aUm == null || dVar.aUm.size == 0 || dVar.aUn == null || dVar.aUn.size != dVar.aUm.size) {
                            dVar.aUm = null;
                            dVar.aUn = null;
                            aVar = new com.google.android.exoplayer2.c.l.a(dVar.aOz);
                        } else {
                            i2 = dVar.aUm.size;
                            int[] iArr = new int[i2];
                            long[] jArr = new long[i2];
                            long[] jArr2 = new long[i2];
                            long[] jArr3 = new long[i2];
                            for (i3 = 0; i3 < i2; i3++) {
                                jArr3[i3] = dVar.aUm.get(i3);
                                jArr[i3] = dVar.aUb + dVar.aUn.get(i3);
                            }
                            for (i3 = 0; i3 < i2 - 1; i3++) {
                                iArr[i3] = (int) (jArr[i3 + 1] - jArr[i3]);
                                jArr2[i3] = jArr3[i3 + 1] - jArr3[i3];
                            }
                            iArr[i2 - 1] = (int) ((dVar.aUb + dVar.aUa) - jArr[i2 - 1]);
                            jArr2[i2 - 1] = dVar.aOz - jArr3[i2 - 1];
                            dVar.aUm = null;
                            dVar.aUn = null;
                            aVar = new com.google.android.exoplayer2.c.a(iArr, jArr, jArr2, jArr3);
                        }
                        gVar2.a(aVar);
                        dVar.aUf = true;
                        AppMethodBeat.o(94892);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(94892);
        }

        public final void h(int i, long j) {
            boolean z = true;
            AppMethodBeat.i(94893);
            d dVar = d.this;
            b bVar;
            o oVar;
            switch (i) {
                case 131:
                    dVar.aUe.type = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case n.CTRL_INDEX /*136*/:
                    bVar = dVar.aUe;
                    if (j != 1) {
                        z = false;
                    }
                    bVar.aVm = z;
                    AppMethodBeat.o(94893);
                    return;
                case 155:
                    dVar.aUr = dVar.N(j);
                    AppMethodBeat.o(94893);
                    return;
                case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                    dVar.aUe.aOn = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case ErrorCode.NEEDDOWNLOAD_FALSE_6 /*176*/:
                    dVar.aUe.width = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 179:
                    dVar.aUm.add(dVar.N(j));
                    AppMethodBeat.o(94893);
                    return;
                case 186:
                    dVar.aUe.height = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 215:
                    dVar.aUe.number = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 231:
                    dVar.aUl = dVar.N(j);
                    AppMethodBeat.o(94893);
                    return;
                case com.tencent.view.d.MIC_PTU_QINGCONG /*241*/:
                    if (!dVar.aUo) {
                        dVar.aUn.add(j);
                        dVar.aUo = true;
                        AppMethodBeat.o(94893);
                        return;
                    }
                    break;
                case 251:
                    dVar.aUI = true;
                    AppMethodBeat.o(94893);
                    return;
                case 16980:
                    if (j != 3) {
                        oVar = new o("ContentCompAlgo " + j + " not supported");
                        AppMethodBeat.o(94893);
                        throw oVar;
                    }
                    break;
                case 17029:
                    if (j < 1 || j > 2) {
                        oVar = new o("DocTypeReadVersion " + j + " not supported");
                        AppMethodBeat.o(94893);
                        throw oVar;
                    }
                case 17143:
                    if (j != 1) {
                        oVar = new o("EBMLReadVersion " + j + " not supported");
                        AppMethodBeat.o(94893);
                        throw oVar;
                    }
                    break;
                case 18401:
                    if (j != 5) {
                        oVar = new o("ContentEncAlgo " + j + " not supported");
                        AppMethodBeat.o(94893);
                        throw oVar;
                    }
                    break;
                case 18408:
                    if (j != 1) {
                        oVar = new o("AESSettingsCipherMode " + j + " not supported");
                        AppMethodBeat.o(94893);
                        throw oVar;
                    }
                    break;
                case 20529:
                    if (j != 0) {
                        oVar = new o("ContentEncodingOrder " + j + " not supported");
                        AppMethodBeat.o(94893);
                        throw oVar;
                    }
                    break;
                case 20530:
                    if (j != 1) {
                        oVar = new o("ContentEncodingScope " + j + " not supported");
                        AppMethodBeat.o(94893);
                        throw oVar;
                    }
                    break;
                case 21420:
                    dVar.aUh = dVar.aUb + j;
                    AppMethodBeat.o(94893);
                    return;
                case 21432:
                    switch ((int) j) {
                        case 0:
                            dVar.aUe.aOk = 0;
                            AppMethodBeat.o(94893);
                            return;
                        case 1:
                            dVar.aUe.aOk = 2;
                            AppMethodBeat.o(94893);
                            return;
                        case 3:
                            dVar.aUe.aOk = 1;
                            AppMethodBeat.o(94893);
                            return;
                        case 15:
                            dVar.aUe.aOk = 3;
                            AppMethodBeat.o(94893);
                            return;
                        default:
                            AppMethodBeat.o(94893);
                            return;
                    }
                case 21680:
                    dVar.aUe.aUQ = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 21682:
                    dVar.aUe.aUS = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 21690:
                    dVar.aUe.aUR = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 21930:
                    bVar = dVar.aUe;
                    if (j != 1) {
                        z = false;
                    }
                    bVar.aVn = z;
                    AppMethodBeat.o(94893);
                    return;
                case 21945:
                    switch ((int) j) {
                        case 1:
                            dVar.aUe.aUW = 2;
                            AppMethodBeat.o(94893);
                            return;
                        case 2:
                            dVar.aUe.aUW = 1;
                            AppMethodBeat.o(94893);
                            return;
                        default:
                            AppMethodBeat.o(94893);
                            return;
                    }
                case 21946:
                    switch ((int) j) {
                        case 1:
                        case 6:
                        case 7:
                            dVar.aUe.aUV = 3;
                            AppMethodBeat.o(94893);
                            return;
                        case 16:
                            dVar.aUe.aUV = 6;
                            AppMethodBeat.o(94893);
                            return;
                        case 18:
                            dVar.aUe.aUV = 7;
                            AppMethodBeat.o(94893);
                            return;
                        default:
                            AppMethodBeat.o(94893);
                            return;
                    }
                case 21947:
                    dVar.aUe.aUT = true;
                    switch ((int) j) {
                        case 1:
                            dVar.aUe.aUU = 1;
                            AppMethodBeat.o(94893);
                            return;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            dVar.aUe.aUU = 2;
                            AppMethodBeat.o(94893);
                            return;
                        case 9:
                            dVar.aUe.aUU = 6;
                            AppMethodBeat.o(94893);
                            return;
                        default:
                            AppMethodBeat.o(94893);
                            return;
                    }
                case 21948:
                    dVar.aUe.aUX = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 21949:
                    dVar.aUe.aUY = (int) j;
                    break;
                case 22186:
                    dVar.aUe.aVk = j;
                    AppMethodBeat.o(94893);
                    return;
                case 22203:
                    dVar.aUe.aVl = j;
                    AppMethodBeat.o(94893);
                    return;
                case 25188:
                    dVar.aUe.aVj = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 2352003:
                    dVar.aUe.aUL = (int) j;
                    AppMethodBeat.o(94893);
                    return;
                case 2807729:
                    dVar.aUc = j;
                    AppMethodBeat.o(94893);
                    return;
            }
            AppMethodBeat.o(94893);
        }

        public final void c(int i, double d) {
            d dVar = d.this;
            switch (i) {
                case 181:
                    dVar.aUe.sampleRate = (int) d;
                    return;
                case 17545:
                    dVar.aUd = (long) d;
                    return;
                case 21969:
                    dVar.aUe.aUZ = (float) d;
                    return;
                case 21970:
                    dVar.aUe.aVa = (float) d;
                    return;
                case 21971:
                    dVar.aUe.aVb = (float) d;
                    return;
                case 21972:
                    dVar.aUe.aVc = (float) d;
                    return;
                case 21973:
                    dVar.aUe.aVd = (float) d;
                    return;
                case 21974:
                    dVar.aUe.aVe = (float) d;
                    return;
                case 21975:
                    dVar.aUe.aVf = (float) d;
                    return;
                case 21976:
                    dVar.aUe.aVg = (float) d;
                    return;
                case 21977:
                    dVar.aUe.aVh = (float) d;
                    return;
                case 21978:
                    dVar.aUe.aVi = (float) d;
                    return;
                default:
                    return;
            }
        }

        public final void d(int i, String str) {
            AppMethodBeat.i(94894);
            d dVar = d.this;
            switch (i) {
                case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
                    dVar.aUe.aUK = str;
                    AppMethodBeat.o(94894);
                    return;
                case 17026:
                    if (!("webm".equals(str) || "matroska".equals(str))) {
                        o oVar = new o("DocType " + str + " not supported");
                        AppMethodBeat.o(94894);
                        throw oVar;
                    }
                case 2274716:
                    dVar.aUe.aOt = str;
                    break;
            }
            AppMethodBeat.o(94894);
        }

        public final void a(int i, int i2, f fVar) {
            AppMethodBeat.i(94895);
            d dVar = d.this;
            o oVar;
            switch (i) {
                case 161:
                case ErrorCode.STARTDOWNLOAD_4 /*163*/:
                    if (dVar.aUp == 0) {
                        dVar.aUv = (int) dVar.aTC.a(fVar, false, true, 8);
                        dVar.aUw = dVar.aTC.length;
                        dVar.aUr = -9223372036854775807L;
                        dVar.aUp = 1;
                        dVar.aTj.reset();
                    }
                    b bVar = (b) dVar.aTR.get(dVar.aUv);
                    if (bVar == null) {
                        fVar.dG(i2 - dVar.aUw);
                        dVar.aUp = 0;
                        AppMethodBeat.o(94895);
                        return;
                    }
                    if (dVar.aUp == 1) {
                        int i3;
                        dVar.b(fVar, 3);
                        int i4 = (dVar.aTj.data[2] & 6) >> 1;
                        if (i4 == 0) {
                            dVar.aUt = 1;
                            dVar.aUu = d.d(dVar.aUu, 1);
                            dVar.aUu[0] = (i2 - dVar.aUw) - 3;
                        } else if (i != ErrorCode.STARTDOWNLOAD_4) {
                            oVar = new o("Lacing only supported in SimpleBlocks.");
                            AppMethodBeat.o(94895);
                            throw oVar;
                        } else {
                            dVar.b(fVar, 4);
                            dVar.aUt = (dVar.aTj.data[3] & 255) + 1;
                            dVar.aUu = d.d(dVar.aUu, dVar.aUt);
                            int i5;
                            int i6;
                            int[] iArr;
                            if (i4 == 2) {
                                Arrays.fill(dVar.aUu, 0, dVar.aUt, ((i2 - dVar.aUw) - 4) / dVar.aUt);
                            } else if (i4 == 1) {
                                i5 = 0;
                                i3 = 4;
                                for (i4 = 0; i4 < dVar.aUt - 1; i4++) {
                                    dVar.aUu[i4] = 0;
                                    do {
                                        i3++;
                                        dVar.b(fVar, i3);
                                        i6 = dVar.aTj.data[i3 - 1] & 255;
                                        iArr = dVar.aUu;
                                        iArr[i4] = iArr[i4] + i6;
                                    } while (i6 == 255);
                                    i5 += dVar.aUu[i4];
                                }
                                dVar.aUu[dVar.aUt - 1] = ((i2 - dVar.aUw) - i3) - i5;
                            } else if (i4 == 3) {
                                i5 = 0;
                                i3 = 4;
                                for (i4 = 0; i4 < dVar.aUt - 1; i4++) {
                                    dVar.aUu[i4] = 0;
                                    i3++;
                                    dVar.b(fVar, i3);
                                    if (dVar.aTj.data[i3 - 1] == (byte) 0) {
                                        oVar = new o("No valid varint length mask found");
                                        AppMethodBeat.o(94895);
                                        throw oVar;
                                    }
                                    long j = 0;
                                    int i7 = 0;
                                    while (true) {
                                        int i8 = i7;
                                        if (i8 < 8) {
                                            int i9 = 1 << (7 - i8);
                                            if ((dVar.aTj.data[i3 - 1] & i9) != 0) {
                                                i6 = i3 - 1;
                                                i3 += i8;
                                                dVar.b(fVar, i3);
                                                j = (long) ((dVar.aTj.data[i6] & 255) & (i9 ^ -1));
                                                for (i7 = i6 + 1; i7 < i3; i7++) {
                                                    j = (j << 8) | ((long) (dVar.aTj.data[i7] & 255));
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
                                        oVar = new o("EBML lacing sample size out of range.");
                                        AppMethodBeat.o(94895);
                                        throw oVar;
                                    }
                                    i6 = (int) j;
                                    iArr = dVar.aUu;
                                    if (i4 != 0) {
                                        i6 += dVar.aUu[i4 - 1];
                                    }
                                    iArr[i4] = i6;
                                    i5 += dVar.aUu[i4];
                                }
                                dVar.aUu[dVar.aUt - 1] = ((i2 - dVar.aUw) - i3) - i5;
                            } else {
                                oVar = new o("Unexpected lacing value: ".concat(String.valueOf(i4)));
                                AppMethodBeat.o(94895);
                                throw oVar;
                            }
                        }
                        dVar.aUq = dVar.aUl + dVar.N((long) ((dVar.aTj.data[0] << 8) | (dVar.aTj.data[1] & 255)));
                        Object obj = (dVar.aTj.data[2] & 8) == 8 ? 1 : null;
                        Object obj2 = (bVar.type == 2 || (i == ErrorCode.STARTDOWNLOAD_4 && (dVar.aTj.data[2] & 128) == 128)) ? 1 : null;
                        i3 = obj2 != null ? 1 : 0;
                        if (obj != null) {
                            i4 = j.INVALID_ID;
                        } else {
                            i4 = 0;
                        }
                        dVar.aUx = i4 | i3;
                        dVar.aUp = 2;
                        dVar.aUs = 0;
                    }
                    if (i == ErrorCode.STARTDOWNLOAD_4) {
                        while (dVar.aUs < dVar.aUt) {
                            dVar.a(fVar, bVar, dVar.aUu[dVar.aUs]);
                            dVar.a(bVar, dVar.aUq + ((long) ((dVar.aUs * bVar.aUL) / 1000)));
                            dVar.aUs++;
                        }
                        dVar.aUp = 0;
                        AppMethodBeat.o(94895);
                        return;
                    }
                    dVar.a(fVar, bVar, dVar.aUu[0]);
                    AppMethodBeat.o(94895);
                    return;
                case 16981:
                    dVar.aUe.aUN = new byte[i2];
                    fVar.readFully(dVar.aUe.aUN, 0, i2);
                    AppMethodBeat.o(94895);
                    return;
                case 18402:
                    byte[] bArr = new byte[i2];
                    fVar.readFully(bArr, 0, i2);
                    dVar.aUe.aUO = new com.google.android.exoplayer2.c.m.a(1, bArr, 0, 0);
                    AppMethodBeat.o(94895);
                    return;
                case 21419:
                    Arrays.fill(dVar.aTU.data, (byte) 0);
                    fVar.readFully(dVar.aTU.data, 4 - i2, i2);
                    dVar.aTU.setPosition(0);
                    dVar.aUg = (int) dVar.aTU.cM();
                    AppMethodBeat.o(94895);
                    return;
                case 25506:
                    dVar.aUe.aUP = new byte[i2];
                    fVar.readFully(dVar.aUe.aUP, 0, i2);
                    AppMethodBeat.o(94895);
                    return;
                case 30322:
                    dVar.aUe.aOl = new byte[i2];
                    fVar.readFully(dVar.aUe.aOl, 0, i2);
                    AppMethodBeat.o(94895);
                    return;
                default:
                    oVar = new o("Unexpected id: ".concat(String.valueOf(i)));
                    AppMethodBeat.o(94895);
                    throw oVar;
            }
        }
    }

    static final class b {
        public DrmInitData aOg;
        public int aOk;
        public byte[] aOl;
        public int aOn;
        String aOt;
        public m aTw;
        public int aTz;
        public String aUK;
        public int aUL;
        public boolean aUM;
        public byte[] aUN;
        public com.google.android.exoplayer2.c.m.a aUO;
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

        private b() {
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

        /* synthetic */ b(byte b) {
            this();
        }

        static List<byte[]> i(l lVar) {
            AppMethodBeat.i(94896);
            o oVar;
            try {
                lVar.eM(16);
                if (lVar.tE() != 826496599) {
                    AppMethodBeat.o(94896);
                    return null;
                }
                int i = lVar.position + 20;
                byte[] bArr = lVar.data;
                while (i < bArr.length - 4) {
                    if (bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 1 && bArr[i + 3] == (byte) 15) {
                        List<byte[]> singletonList = Collections.singletonList(Arrays.copyOfRange(bArr, i, bArr.length));
                        AppMethodBeat.o(94896);
                        return singletonList;
                    }
                    i++;
                }
                oVar = new o("Failed to find FourCC VC1 initialization data");
                AppMethodBeat.o(94896);
                throw oVar;
            } catch (ArrayIndexOutOfBoundsException e) {
                oVar = new o("Error parsing FourCC VC1 codec private");
                AppMethodBeat.o(94896);
                throw oVar;
            }
        }

        static List<byte[]> m(byte[] bArr) {
            int i = 0;
            AppMethodBeat.i(94897);
            o oVar;
            try {
                if (bArr[0] != (byte) 2) {
                    oVar = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(94897);
                    throw oVar;
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
                    oVar = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(94897);
                    throw oVar;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i3, bArr2, 0, i2);
                i2 += i3;
                if (bArr[i2] != (byte) 3) {
                    oVar = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(94897);
                    throw oVar;
                }
                i += i2;
                if (bArr[i] != (byte) 5) {
                    oVar = new o("Error parsing vorbis codec private");
                    AppMethodBeat.o(94897);
                    throw oVar;
                }
                byte[] bArr3 = new byte[(bArr.length - i)];
                System.arraycopy(bArr, i, bArr3, 0, bArr.length - i);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                AppMethodBeat.o(94897);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e) {
                oVar = new o("Error parsing vorbis codec private");
                AppMethodBeat.o(94897);
                throw oVar;
            }
        }

        static boolean j(l lVar) {
            AppMethodBeat.i(94898);
            try {
                int tC = lVar.tC();
                if (tC == 1) {
                    AppMethodBeat.o(94898);
                    return true;
                } else if (tC == BitUtils.BIT_TURN_ZERO_1) {
                    lVar.setPosition(24);
                    if (lVar.readLong() == d.aTP.getMostSignificantBits() && lVar.readLong() == d.aTP.getLeastSignificantBits()) {
                        AppMethodBeat.o(94898);
                        return true;
                    }
                    AppMethodBeat.o(94898);
                    return false;
                } else {
                    AppMethodBeat.o(94898);
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                o oVar = new o("Error parsing MS/ACM codec private");
                AppMethodBeat.o(94898);
                throw oVar;
            }
        }
    }

    static {
        AppMethodBeat.i(94914);
        AppMethodBeat.o(94914);
    }

    public d() {
        this(0);
    }

    public d(int i) {
        this(new a(), i);
        AppMethodBeat.i(94899);
        AppMethodBeat.o(94899);
    }

    private d(b bVar, int i) {
        boolean z = false;
        AppMethodBeat.i(94900);
        this.aUb = -1;
        this.aUc = -9223372036854775807L;
        this.aUd = -9223372036854775807L;
        this.aOz = -9223372036854775807L;
        this.aUj = -1;
        this.aUk = -1;
        this.aUl = -9223372036854775807L;
        this.aTQ = bVar;
        this.aTQ.a(new a(this, (byte) 0));
        if ((i & 1) == 0) {
            z = true;
        }
        this.aTS = z;
        this.aTC = new f();
        this.aTR = new SparseArray();
        this.aTj = new l(4);
        this.aTT = new l(ByteBuffer.allocate(4).putInt(-1).array());
        this.aTU = new l(4);
        this.aTx = new l(com.google.android.exoplayer2.i.j.bqY);
        this.aTy = new l(4);
        this.aTV = new l();
        this.aTW = new l();
        this.aTX = new l(8);
        this.aTY = new l();
        AppMethodBeat.o(94900);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(94901);
        e eVar = new e();
        long length = fVar.getLength();
        long j = (length == -1 || length > 1024) ? 1024 : length;
        int i = (int) j;
        fVar.b(eVar.aTj.data, 0, 4);
        eVar.aVo = 4;
        for (j = eVar.aTj.cM(); j != 440786851; j = ((j << 8) & -256) | ((long) (eVar.aTj.data[0] & 255))) {
            int i2 = eVar.aVo + 1;
            eVar.aVo = i2;
            if (i2 == i) {
                break;
            }
            fVar.b(eVar.aTj.data, 0, 1);
        }
        j = eVar.d(fVar);
        long j2 = (long) eVar.aVo;
        if (j == Long.MIN_VALUE || (length != -1 && j2 + j >= length)) {
            AppMethodBeat.o(94901);
            return false;
        }
        while (((long) eVar.aVo) < j2 + j) {
            if (eVar.d(fVar) == Long.MIN_VALUE) {
                break;
            }
            length = eVar.d(fVar);
            if (length < 0 || length > 2147483647L) {
                AppMethodBeat.o(94901);
                return false;
            } else if (length != 0) {
                fVar.dH((int) length);
                eVar.aVo = (int) (length + ((long) eVar.aVo));
            }
        }
        if (((long) eVar.aVo) == j + j2) {
            AppMethodBeat.o(94901);
            return true;
        }
        AppMethodBeat.o(94901);
        return false;
    }

    public final void a(g gVar) {
        this.aTn = gVar;
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(94902);
        this.aUl = -9223372036854775807L;
        this.aUp = 0;
        this.aTQ.reset();
        this.aTC.reset();
        rd();
        AppMethodBeat.o(94902);
    }

    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(94903);
        this.aUH = false;
        int i = 1;
        while (i != 0 && !this.aUH) {
            boolean z;
            boolean c = this.aTQ.c(fVar);
            if (c) {
                long position = fVar.getPosition();
                if (this.aUi) {
                    this.aUk = position;
                    kVar.position = this.aUj;
                    this.aUi = false;
                    i = 1;
                } else if (!this.aUf || this.aUk == -1) {
                    z = false;
                } else {
                    kVar.position = this.aUk;
                    this.aUk = -1;
                    i = 1;
                }
                if (i != 0) {
                    AppMethodBeat.o(94903);
                    return 1;
                }
            }
            z = c;
        }
        if (i != 0) {
            AppMethodBeat.o(94903);
            return 0;
        }
        AppMethodBeat.o(94903);
        return -1;
    }

    static int dO(int i) {
        switch (i) {
            case 131:
            case n.CTRL_INDEX /*136*/:
            case 155:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_6 /*176*/:
            case 179:
            case 186:
            case 215:
            case 231:
            case com.tencent.view.d.MIC_PTU_QINGCONG /*241*/:
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
            case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
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

    static boolean dP(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar, long j) {
        AppMethodBeat.i(94904);
        if ("S_TEXT/UTF8".equals(bVar.aUK)) {
            a(bVar, "%02d:%02d:%02d,%03d", 19, aTK, aTJ);
        } else if ("S_TEXT/ASS".equals(bVar.aUK)) {
            a(bVar, "%01d:%02d:%02d:%02d", 21, aTN, aTO);
        }
        bVar.aTw.a(j, this.aUx, this.aUG, 0, bVar.aUO);
        this.aUH = true;
        rd();
        AppMethodBeat.o(94904);
    }

    private void rd() {
        AppMethodBeat.i(94905);
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
        AppMethodBeat.o(94905);
    }

    /* Access modifiers changed, original: final */
    public final void b(f fVar, int i) {
        AppMethodBeat.i(94906);
        if (this.aTj.limit >= i) {
            AppMethodBeat.o(94906);
            return;
        }
        if (this.aTj.capacity() < i) {
            this.aTj.n(Arrays.copyOf(this.aTj.data, Math.max(this.aTj.data.length * 2, i)), this.aTj.limit);
        }
        fVar.readFully(this.aTj.data, this.aTj.limit, i - this.aTj.limit);
        this.aTj.eL(i);
        AppMethodBeat.o(94906);
    }

    /* Access modifiers changed, original: final */
    public final void a(f fVar, b bVar, int i) {
        AppMethodBeat.i(94907);
        if ("S_TEXT/UTF8".equals(bVar.aUK)) {
            a(fVar, aTI, i);
            AppMethodBeat.o(94907);
        } else if ("S_TEXT/ASS".equals(bVar.aUK)) {
            a(fVar, aTM, i);
            AppMethodBeat.o(94907);
        } else {
            int i2;
            int i3;
            int i4;
            m mVar = bVar.aTw;
            if (!this.aUz) {
                if (bVar.aUM) {
                    this.aUx &= -1073741825;
                    if (!this.aUA) {
                        fVar.readFully(this.aTj.data, 0, 1);
                        this.aUy++;
                        if ((this.aTj.data[0] & 128) == 128) {
                            o oVar = new o("Extension bit is set in signal byte");
                            AppMethodBeat.o(94907);
                            throw oVar;
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
                            fVar.readFully(this.aTX.data, 0, 8);
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
                            mVar.a(this.aTj, 1);
                            this.aUG++;
                            this.aTX.setPosition(0);
                            mVar.a(this.aTX, 8);
                            this.aUG += 8;
                        }
                        if (i2 != 0) {
                            if (!this.aUC) {
                                fVar.readFully(this.aTj.data, 0, 1);
                                this.aUy++;
                                this.aTj.setPosition(0);
                                this.aUE = this.aTj.readUnsignedByte();
                                this.aUC = true;
                            }
                            i2 = this.aUE * 4;
                            this.aTj.reset(i2);
                            fVar.readFully(this.aTj.data, 0, i2);
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
                                i5 = this.aTj.tI();
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
                            this.aTY.n(this.aTZ.array(), i3);
                            mVar.a(this.aTY, i3);
                            this.aUG += i3;
                        }
                    }
                } else if (bVar.aUN != null) {
                    this.aTV.n(bVar.aUN, bVar.aUN.length);
                }
                this.aUz = true;
            }
            i2 = this.aTV.limit + i;
            if ("V_MPEG4/ISO/AVC".equals(bVar.aUK) || "V_MPEGH/ISO/HEVC".equals(bVar.aUK)) {
                byte[] bArr2 = this.aTy.data;
                bArr2[0] = (byte) 0;
                bArr2[1] = (byte) 0;
                bArr2[2] = (byte) 0;
                int i6 = bVar.aTz;
                i4 = 4 - bVar.aTz;
                while (this.aUy < i2) {
                    if (this.aUF == 0) {
                        i3 = Math.min(i6, this.aTV.tB());
                        fVar.readFully(bArr2, i4 + i3, i6 - i3);
                        if (i3 > 0) {
                            this.aTV.readBytes(bArr2, i4, i3);
                        }
                        this.aUy += i6;
                        this.aTy.setPosition(0);
                        this.aUF = this.aTy.tI();
                        this.aTx.setPosition(0);
                        mVar.a(this.aTx, 4);
                        this.aUG += 4;
                    } else {
                        this.aUF -= a(fVar, mVar, this.aUF);
                    }
                }
            } else {
                while (this.aUy < i2) {
                    a(fVar, mVar, i2 - this.aUy);
                }
            }
            if ("A_VORBIS".equals(bVar.aUK)) {
                this.aTT.setPosition(0);
                mVar.a(this.aTT, 4);
                this.aUG += 4;
            }
            AppMethodBeat.o(94907);
        }
    }

    private void a(f fVar, byte[] bArr, int i) {
        AppMethodBeat.i(94908);
        int length = bArr.length + i;
        if (this.aTW.capacity() < length) {
            this.aTW.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.aTW.data, 0, bArr.length);
        }
        fVar.readFully(this.aTW.data, bArr.length, i);
        this.aTW.reset(length);
        AppMethodBeat.o(94908);
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        AppMethodBeat.i(94909);
        a(this.aTW.data, this.aUr, str, i, j, bArr);
        bVar.aTw.a(this.aTW, this.aTW.limit);
        this.aUG += this.aTW.limit;
        AppMethodBeat.o(94909);
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        Object obj;
        AppMethodBeat.i(94910);
        if (j == -9223372036854775807L) {
            obj = bArr2;
        } else {
            long j3 = j - (((long) (((int) (j / 3600000000L)) * 3600)) * 1000000);
            j3 -= ((long) (((int) (j3 / 60000000)) * 60)) * 1000000;
            int i2 = (int) ((j3 - (((long) ((int) (j3 / 1000000))) * 1000000)) / j2);
            obj = v.aQ(String.format(Locale.US, str, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r6), Integer.valueOf(i2)}));
        }
        System.arraycopy(obj, 0, bArr, i, bArr2.length);
        AppMethodBeat.o(94910);
    }

    private int a(f fVar, m mVar, int i) {
        AppMethodBeat.i(94911);
        int tB = this.aTV.tB();
        if (tB > 0) {
            tB = Math.min(i, tB);
            mVar.a(this.aTV, tB);
        } else {
            tB = mVar.a(fVar, i, false);
        }
        this.aUy += tB;
        this.aUG += tB;
        AppMethodBeat.o(94911);
        return tB;
    }

    /* Access modifiers changed, original: final */
    public final long N(long j) {
        AppMethodBeat.i(94912);
        if (this.aUc == -9223372036854775807L) {
            o oVar = new o("Can't scale timecode prior to timecodeScale being set.");
            AppMethodBeat.o(94912);
            throw oVar;
        }
        long b = v.b(j, this.aUc, 1000);
        AppMethodBeat.o(94912);
        return b;
    }

    static int[] d(int[] iArr, int i) {
        AppMethodBeat.i(94913);
        if (iArr == null) {
            iArr = new int[i];
            AppMethodBeat.o(94913);
            return iArr;
        } else if (iArr.length >= i) {
            AppMethodBeat.o(94913);
            return iArr;
        } else {
            iArr = new int[Math.max(iArr.length * 2, i)];
            AppMethodBeat.o(94913);
            return iArr;
        }
    }
}

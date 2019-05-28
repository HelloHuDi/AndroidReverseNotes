package com.google.android.exoplayer2.f.a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class c extends d {
    private List<com.google.android.exoplayer2.f.a> blA;
    private final k blO = new k();
    private final int blP;
    private final a[] blQ;
    private a blR;
    private b blS;
    private int blT;
    private final l blu = new l();
    private List<com.google.android.exoplayer2.f.a> blz;

    static final class b {
        public final int bms;
        public final int bmt;
        public final byte[] bmu;
        int currentIndex = 0;

        public b(int i, int i2) {
            AppMethodBeat.i(95594);
            this.bms = i;
            this.bmt = i2;
            this.bmu = new byte[((i2 * 2) - 1)];
            AppMethodBeat.o(95594);
        }
    }

    static final class a {
        public static final int blU = m(2, 2, 2, 0);
        public static final int blV = m(0, 0, 0, 0);
        public static final int blW = m(0, 0, 0, 3);
        static final int[] blX = new int[]{0, 0, 0, 0, 0, 2, 0};
        private static final int[] blY = new int[]{0, 0, 0, 0, 0, 0, 2};
        private static final int[] blZ = new int[]{3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] bma = new boolean[]{false, false, false, true, true, true, false};
        static final int[] bmb = new int[]{blV, blW, blV, blV, blW, blV, blV};
        private static final int[] bmc = new int[]{0, 1, 2, 3, 4, 3, 4};
        private static final int[] bmd = new int[]{0, 0, 0, 0, 0, 3, 3};
        static final int[] bme = new int[]{blV, blV, blV, blV, blV, blW, blW};
        boolean aIB;
        private int backgroundColor;
        final List<SpannableString> blI = new LinkedList();
        private final SpannableStringBuilder blJ = new SpannableStringBuilder();
        private int blL;
        boolean bmf;
        boolean bmg;
        int bmh;
        int bmi;
        int bmj;
        boolean bmk;
        private int bml;
        int bmm;
        int bmn;
        private int bmo;
        private int bmp;
        private int bmq;
        private int bmr;
        private int foregroundColor;
        int priority;
        int row;
        int rowCount;

        static {
            AppMethodBeat.i(95593);
            AppMethodBeat.o(95593);
        }

        public a() {
            AppMethodBeat.i(95581);
            reset();
            AppMethodBeat.o(95581);
        }

        public final void reset() {
            AppMethodBeat.i(95583);
            clear();
            this.bmf = false;
            this.aIB = false;
            this.priority = 4;
            this.bmg = false;
            this.bmh = 0;
            this.bmi = 0;
            this.bmj = 0;
            this.rowCount = 15;
            this.bmk = true;
            this.bml = 0;
            this.bmm = 0;
            this.bmn = 0;
            this.bmo = blV;
            this.foregroundColor = blU;
            this.backgroundColor = blV;
            AppMethodBeat.o(95583);
        }

        public final void clear() {
            AppMethodBeat.i(95584);
            this.blI.clear();
            this.blJ.clear();
            this.bmp = -1;
            this.blL = -1;
            this.bmq = -1;
            this.bmr = -1;
            this.row = 0;
            AppMethodBeat.o(95584);
        }

        public final void be(int i, int i2) {
            this.bmo = i;
            this.bml = i2;
        }

        public final void h(boolean z, boolean z2) {
            AppMethodBeat.i(95585);
            if (this.bmp != -1) {
                if (!z) {
                    this.blJ.setSpan(new StyleSpan(2), this.bmp, this.blJ.length(), 33);
                    this.bmp = -1;
                }
            } else if (z) {
                this.bmp = this.blJ.length();
            }
            if (this.blL != -1) {
                if (!z2) {
                    this.blJ.setSpan(new UnderlineSpan(), this.blL, this.blJ.length(), 33);
                    this.blL = -1;
                    AppMethodBeat.o(95585);
                    return;
                }
            } else if (z2) {
                this.blL = this.blJ.length();
            }
            AppMethodBeat.o(95585);
        }

        public final void bf(int i, int i2) {
            AppMethodBeat.i(95586);
            if (!(this.bmq == -1 || this.foregroundColor == i)) {
                this.blJ.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bmq, this.blJ.length(), 33);
            }
            if (i != blU) {
                this.bmq = this.blJ.length();
                this.foregroundColor = i;
            }
            if (!(this.bmr == -1 || this.backgroundColor == i2)) {
                this.blJ.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bmr, this.blJ.length(), 33);
            }
            if (i2 != blV) {
                this.bmr = this.blJ.length();
                this.backgroundColor = i2;
            }
            AppMethodBeat.o(95586);
        }

        public final void sR() {
            AppMethodBeat.i(95587);
            int length = this.blJ.length();
            if (length > 0) {
                this.blJ.delete(length - 1, length);
            }
            AppMethodBeat.o(95587);
        }

        public final void append(char c) {
            AppMethodBeat.i(95588);
            if (c == 10) {
                this.blI.add(sT());
                this.blJ.clear();
                if (this.bmp != -1) {
                    this.bmp = 0;
                }
                if (this.blL != -1) {
                    this.blL = 0;
                }
                if (this.bmq != -1) {
                    this.bmq = 0;
                }
                if (this.bmr != -1) {
                    this.bmr = 0;
                }
                while (true) {
                    if ((!this.bmk || this.blI.size() < this.rowCount) && this.blI.size() < 15) {
                        break;
                    }
                    this.blI.remove(0);
                }
            } else {
                this.blJ.append(c);
            }
            AppMethodBeat.o(95588);
        }

        private SpannableString sT() {
            AppMethodBeat.i(95589);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.blJ);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.bmp != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.bmp, length, 33);
                }
                if (this.blL != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.blL, length, 33);
                }
                if (this.bmq != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bmq, length, 33);
                }
                if (this.bmr != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bmr, length, 33);
                }
            }
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            AppMethodBeat.o(95589);
            return spannableString;
        }

        public final b sX() {
            boolean z = false;
            AppMethodBeat.i(95590);
            if (isEmpty()) {
                AppMethodBeat.o(95590);
                return null;
            }
            Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.blI.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.blI.get(i3));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(sT());
            switch (this.bml) {
                case 0:
                case 3:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
                case 1:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                case 2:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected justification value: " + this.bml);
                    AppMethodBeat.o(95590);
                    throw illegalArgumentException;
            }
            if (this.bmg) {
                f = ((float) this.bmi) / 99.0f;
                f2 = ((float) this.bmh) / 99.0f;
            } else {
                f = ((float) this.bmi) / 209.0f;
                f2 = ((float) this.bmh) / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            f = (f2 * 0.9f) + 0.05f;
            if (this.bmj % 3 == 0) {
                i = 0;
            } else if (this.bmj % 3 == 1) {
                i = 1;
            } else {
                i = 2;
            }
            if (this.bmj / 3 == 0) {
                i2 = 0;
            } else if (this.bmj / 3 == 1) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (this.bmo != blV) {
                z = true;
            }
            b bVar = new b(spannableStringBuilder, alignment, f, i, f3, i2, z, this.bmo, this.priority);
            AppMethodBeat.o(95590);
            return bVar;
        }

        public static int s(int i, int i2, int i3) {
            AppMethodBeat.i(95591);
            int m = m(i, i2, i3, 0);
            AppMethodBeat.o(95591);
            return m;
        }

        public static int m(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8 = 255;
            AppMethodBeat.i(95592);
            com.google.android.exoplayer2.i.a.bh(i, 4);
            com.google.android.exoplayer2.i.a.bh(i2, 4);
            com.google.android.exoplayer2.i.a.bh(i3, 4);
            com.google.android.exoplayer2.i.a.bh(i4, 4);
            switch (i4) {
                case 0:
                case 1:
                    i5 = 255;
                    break;
                case 2:
                    i5 = d.MIC_SketchMark;
                    break;
                case 3:
                    i5 = 0;
                    break;
                default:
                    i5 = 255;
                    break;
            }
            if (i > 1) {
                i6 = 255;
            } else {
                i6 = 0;
            }
            if (i2 > 1) {
                i7 = 255;
            } else {
                i7 = 0;
            }
            if (i3 <= 1) {
                i8 = 0;
            }
            i8 = Color.argb(i5, i6, i7, i8);
            AppMethodBeat.o(95592);
            return i8;
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(95582);
            if (!this.bmf || (this.blI.isEmpty() && this.blJ.length() == 0)) {
                AppMethodBeat.o(95582);
                return true;
            }
            AppMethodBeat.o(95582);
            return false;
        }
    }

    public final /* bridge */ /* synthetic */ void ai(long j) {
        AppMethodBeat.i(95615);
        super.ai(j);
        AppMethodBeat.o(95615);
    }

    public final /* bridge */ /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(95613);
        super.ad(hVar);
        AppMethodBeat.o(95613);
    }

    public final /* bridge */ /* synthetic */ void release() {
        AppMethodBeat.i(95611);
        super.release();
        AppMethodBeat.o(95611);
    }

    public final /* bridge */ /* synthetic */ i sP() {
        AppMethodBeat.i(95612);
        i sP = super.qJ();
        AppMethodBeat.o(95612);
        return sP;
    }

    public final /* bridge */ /* synthetic */ h sQ() {
        AppMethodBeat.i(95614);
        h sQ = super.qI();
        AppMethodBeat.o(95614);
        return sQ;
    }

    public c(int i) {
        AppMethodBeat.i(95595);
        if (i == -1) {
            i = 1;
        }
        this.blP = i;
        this.blQ = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.blQ[i2] = new a();
        }
        this.blR = this.blQ[0];
        sO();
        AppMethodBeat.o(95595);
    }

    public final void flush() {
        AppMethodBeat.i(95596);
        super.flush();
        this.blz = null;
        this.blA = null;
        this.blT = 0;
        this.blR = this.blQ[this.blT];
        sO();
        this.blS = null;
        AppMethodBeat.o(95596);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean sL() {
        return this.blz != this.blA;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.google.android.exoplayer2.f.d sM() {
        AppMethodBeat.i(95597);
        this.blA = this.blz;
        f fVar = new f(this.blz);
        AppMethodBeat.o(95597);
        return fVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(h hVar) {
        AppMethodBeat.i(95598);
        this.blu.n(hVar.aEY.array(), hVar.aEY.limit());
        while (this.blu.tB() >= 3) {
            int readUnsignedByte = this.blu.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            Object obj = (readUnsignedByte & 4) == 4 ? 1 : null;
            byte readUnsignedByte2 = (byte) this.blu.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.blu.readUnsignedByte();
            if ((i == 2 || i == 3) && obj != null) {
                byte[] bArr;
                b bVar;
                int i2;
                if (i == 3) {
                    sV();
                    i = (readUnsignedByte2 & az.CTRL_INDEX) >> 6;
                    readUnsignedByte = readUnsignedByte2 & 63;
                    if (readUnsignedByte == 0) {
                        readUnsignedByte = 64;
                    }
                    this.blS = new b(i, readUnsignedByte);
                    bArr = this.blS.bmu;
                    bVar = this.blS;
                    i2 = bVar.currentIndex;
                    bVar.currentIndex = i2 + 1;
                    bArr[i2] = readUnsignedByte3;
                } else {
                    com.google.android.exoplayer2.i.a.checkArgument(i == 2);
                    if (this.blS != null) {
                        bArr = this.blS.bmu;
                        bVar = this.blS;
                        int i3 = bVar.currentIndex;
                        bVar.currentIndex = i3 + 1;
                        bArr[i3] = readUnsignedByte2;
                        bArr = this.blS.bmu;
                        bVar = this.blS;
                        i2 = bVar.currentIndex;
                        bVar.currentIndex = i2 + 1;
                        bArr[i2] = readUnsignedByte3;
                    }
                }
                if (this.blS.currentIndex == (this.blS.bmt * 2) - 1) {
                    sV();
                }
            }
        }
        AppMethodBeat.o(95598);
    }

    private void sV() {
        AppMethodBeat.i(95599);
        if (this.blS == null) {
            AppMethodBeat.o(95599);
            return;
        }
        sW();
        this.blS = null;
        AppMethodBeat.o(95599);
    }

    private void sW() {
        AppMethodBeat.i(95600);
        if (this.blS.currentIndex != (this.blS.bmt * 2) - 1) {
            new StringBuilder("DtvCcPacket ended prematurely; size is ").append((this.blS.bmt * 2) - 1).append(", but current index is ").append(this.blS.currentIndex).append(" (sequence number ").append(this.blS.bms).append("); ignoring packet");
            AppMethodBeat.o(95600);
            return;
        }
        this.blO.n(this.blS.bmu, this.blS.currentIndex);
        int ed = this.blO.ed(3);
        int ed2 = this.blO.ed(5);
        if (ed == 7) {
            this.blO.ee(2);
            ed += this.blO.ed(6);
        }
        if (ed2 == 0) {
            if (ed != 0) {
                new StringBuilder("serviceNumber is non-zero (").append(ed).append(") when blockSize is 0");
            }
            AppMethodBeat.o(95600);
        } else if (ed != this.blP) {
            AppMethodBeat.o(95600);
        } else {
            Object obj = null;
            while (this.blO.tx() > 0) {
                ed2 = this.blO.ed(8);
                if (ed2 == 16) {
                    ed2 = this.blO.ed(8);
                    if (ed2 <= 31) {
                        ex(ed2);
                    } else if (ed2 <= d.MIC_SketchMark) {
                        eB(ed2);
                        obj = 1;
                    } else if (ed2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                        ey(ed2);
                    } else if (ed2 <= 255) {
                        eC(ed2);
                        obj = 1;
                    }
                } else if (ed2 <= 31) {
                    ev(ed2);
                } else if (ed2 <= d.MIC_SketchMark) {
                    ez(ed2);
                    obj = 1;
                } else if (ed2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                    ew(ed2);
                    obj = 1;
                } else if (ed2 <= 255) {
                    eA(ed2);
                    obj = 1;
                }
            }
            if (obj != null) {
                this.blz = sN();
            }
            AppMethodBeat.o(95600);
        }
    }

    private void ev(int i) {
        AppMethodBeat.i(95601);
        switch (i) {
            case 0:
                AppMethodBeat.o(95601);
                return;
            case 3:
                this.blz = sN();
                AppMethodBeat.o(95601);
                return;
            case 8:
                this.blR.sR();
                AppMethodBeat.o(95601);
                return;
            case 12:
                sO();
                AppMethodBeat.o(95601);
                return;
            case 13:
                this.blR.append(10);
                AppMethodBeat.o(95601);
                return;
            case 14:
                AppMethodBeat.o(95601);
                return;
            default:
                if (i >= 17 && i <= 23) {
                    this.blO.ee(8);
                    AppMethodBeat.o(95601);
                    return;
                } else if (i < 24 || i > 31) {
                    AppMethodBeat.o(95601);
                    return;
                } else {
                    this.blO.ee(16);
                    AppMethodBeat.o(95601);
                    return;
                }
        }
    }

    private void ew(int i) {
        AppMethodBeat.i(95602);
        int i2;
        int i3;
        boolean z;
        a aVar;
        switch (i) {
            case 128:
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
            case 130:
            case 131:
            case 132:
            case e.CTRL_INDEX /*133*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*135*/:
                i2 = i - 128;
                if (this.blT != i2) {
                    this.blT = i2;
                    this.blR = this.blQ[i2];
                    AppMethodBeat.o(95602);
                    return;
                }
                break;
            case n.CTRL_INDEX /*136*/:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.rl()) {
                        this.blQ[8 - i2].clear();
                    }
                }
                AppMethodBeat.o(95602);
                return;
            case 137:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.rl()) {
                        this.blQ[8 - i2].aIB = true;
                    }
                }
                AppMethodBeat.o(95602);
                return;
            case 138:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.rl()) {
                        this.blQ[8 - i2].aIB = false;
                    }
                }
                AppMethodBeat.o(95602);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX /*139*/:
                i2 = 1;
                while (true) {
                    i3 = i2;
                    if (i3 <= 8) {
                        if (this.blO.rl()) {
                            a aVar2 = this.blQ[8 - i3];
                            if (aVar2.aIB) {
                                z = false;
                            } else {
                                z = true;
                            }
                            aVar2.aIB = z;
                        }
                        i2 = i3 + 1;
                    } else {
                        AppMethodBeat.o(95602);
                        return;
                    }
                }
            case 140:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.rl()) {
                        this.blQ[8 - i2].reset();
                    }
                }
                AppMethodBeat.o(95602);
                return;
            case 141:
                this.blO.ee(8);
                AppMethodBeat.o(95602);
                return;
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                AppMethodBeat.o(95602);
                return;
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                sO();
                AppMethodBeat.o(95602);
                return;
            case 144:
                if (this.blR.bmf) {
                    this.blO.ed(4);
                    this.blO.ed(2);
                    this.blO.ed(2);
                    z = this.blO.rl();
                    boolean rl = this.blO.rl();
                    this.blO.ed(3);
                    this.blO.ed(3);
                    this.blR.h(z, rl);
                    AppMethodBeat.o(95602);
                    return;
                }
                this.blO.ee(16);
                AppMethodBeat.o(95602);
                return;
            case 145:
                if (this.blR.bmf) {
                    i2 = a.m(this.blO.ed(2), this.blO.ed(2), this.blO.ed(2), this.blO.ed(2));
                    i3 = a.m(this.blO.ed(2), this.blO.ed(2), this.blO.ed(2), this.blO.ed(2));
                    this.blO.ee(2);
                    a.s(this.blO.ed(2), this.blO.ed(2), this.blO.ed(2));
                    this.blR.bf(i2, i3);
                    AppMethodBeat.o(95602);
                    return;
                }
                this.blO.ee(24);
                AppMethodBeat.o(95602);
                return;
            case 146:
                if (this.blR.bmf) {
                    this.blO.ee(4);
                    i2 = this.blO.ed(4);
                    this.blO.ee(2);
                    this.blO.ed(6);
                    aVar = this.blR;
                    if (aVar.row != i2) {
                        aVar.append(10);
                    }
                    aVar.row = i2;
                    AppMethodBeat.o(95602);
                    return;
                }
                this.blO.ee(16);
                AppMethodBeat.o(95602);
                return;
            case 151:
                if (this.blR.bmf) {
                    i2 = a.m(this.blO.ed(2), this.blO.ed(2), this.blO.ed(2), this.blO.ed(2));
                    this.blO.ed(2);
                    a.s(this.blO.ed(2), this.blO.ed(2), this.blO.ed(2));
                    this.blO.rl();
                    this.blO.rl();
                    this.blO.ed(2);
                    this.blO.ed(2);
                    i3 = this.blO.ed(2);
                    this.blO.ee(8);
                    this.blR.be(i2, i3);
                    AppMethodBeat.o(95602);
                    return;
                }
                this.blO.ee(32);
                AppMethodBeat.o(95602);
                return;
            case 152:
            case XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION /*153*/:
            case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                int i4;
                i2 = i - 152;
                aVar = this.blQ[i2];
                this.blO.ee(2);
                boolean rl2 = this.blO.rl();
                boolean rl3 = this.blO.rl();
                this.blO.rl();
                int ed = this.blO.ed(3);
                boolean rl4 = this.blO.rl();
                int ed2 = this.blO.ed(7);
                int ed3 = this.blO.ed(8);
                int ed4 = this.blO.ed(4);
                int ed5 = this.blO.ed(4);
                this.blO.ee(2);
                this.blO.ed(6);
                this.blO.ee(2);
                int ed6 = this.blO.ed(3);
                int ed7 = this.blO.ed(3);
                aVar.bmf = true;
                aVar.aIB = rl2;
                aVar.bmk = rl3;
                aVar.priority = ed;
                aVar.bmg = rl4;
                aVar.bmh = ed2;
                aVar.bmi = ed3;
                aVar.bmj = ed4;
                if (aVar.rowCount != ed5 + 1) {
                    aVar.rowCount = ed5 + 1;
                    while (true) {
                        if ((rl3 && aVar.blI.size() >= aVar.rowCount) || aVar.blI.size() >= 15) {
                            aVar.blI.remove(0);
                        }
                    }
                }
                if (!(ed6 == 0 || aVar.bmm == ed6)) {
                    aVar.bmm = ed6;
                    i4 = ed6 - 1;
                    aVar.be(a.bmb[i4], a.blX[i4]);
                }
                if (!(ed7 == 0 || aVar.bmn == ed7)) {
                    aVar.bmn = ed7;
                    i4 = ed7 - 1;
                    aVar.h(false, false);
                    aVar.bf(a.blU, a.bme[i4]);
                }
                if (this.blT != i2) {
                    this.blT = i2;
                    this.blR = this.blQ[i2];
                    AppMethodBeat.o(95602);
                    return;
                }
                break;
        }
        AppMethodBeat.o(95602);
    }

    private void ex(int i) {
        AppMethodBeat.i(95603);
        if (i > 7) {
            if (i <= 15) {
                this.blO.ee(8);
                AppMethodBeat.o(95603);
                return;
            } else if (i <= 23) {
                this.blO.ee(16);
                AppMethodBeat.o(95603);
                return;
            } else if (i <= 31) {
                this.blO.ee(24);
            }
        }
        AppMethodBeat.o(95603);
    }

    private void ey(int i) {
        AppMethodBeat.i(95604);
        if (i <= com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX) {
            this.blO.ee(32);
            AppMethodBeat.o(95604);
        } else if (i <= ErrorCode.NEEDDOWNLOAD_4) {
            this.blO.ee(40);
            AppMethodBeat.o(95604);
        } else {
            if (i <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                this.blO.ee(2);
                this.blO.ee(this.blO.ed(6) * 8);
            }
            AppMethodBeat.o(95604);
        }
    }

    private void ez(int i) {
        AppMethodBeat.i(95605);
        if (i == d.MIC_SketchMark) {
            this.blR.append(9835);
            AppMethodBeat.o(95605);
            return;
        }
        this.blR.append((char) (i & 255));
        AppMethodBeat.o(95605);
    }

    private void eA(int i) {
        AppMethodBeat.i(95606);
        this.blR.append((char) (i & 255));
        AppMethodBeat.o(95606);
    }

    private void eB(int i) {
        AppMethodBeat.i(95607);
        switch (i) {
            case 32:
                this.blR.append(' ');
                AppMethodBeat.o(95607);
                return;
            case 33:
                this.blR.append(160);
                AppMethodBeat.o(95607);
                return;
            case g.CTRL_INDEX /*37*/:
                this.blR.append(8230);
                AppMethodBeat.o(95607);
                return;
            case 42:
                this.blR.append(352);
                AppMethodBeat.o(95607);
                return;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                this.blR.append(338);
                AppMethodBeat.o(95607);
                return;
            case 48:
                this.blR.append(9608);
                AppMethodBeat.o(95607);
                return;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                this.blR.append(8216);
                AppMethodBeat.o(95607);
                return;
            case 50:
                this.blR.append(8217);
                AppMethodBeat.o(95607);
                return;
            case 51:
                this.blR.append(8220);
                AppMethodBeat.o(95607);
                return;
            case 52:
                this.blR.append(8221);
                AppMethodBeat.o(95607);
                return;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                this.blR.append(8226);
                AppMethodBeat.o(95607);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX /*57*/:
                this.blR.append(8482);
                AppMethodBeat.o(95607);
                return;
            case aa.CTRL_INDEX /*58*/:
                this.blR.append(353);
                AppMethodBeat.o(95607);
                return;
            case 60:
                this.blR.append(339);
                AppMethodBeat.o(95607);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.blR.append(8480);
                AppMethodBeat.o(95607);
                return;
            case 63:
                this.blR.append(376);
                AppMethodBeat.o(95607);
                return;
            case 118:
                this.blR.append(8539);
                AppMethodBeat.o(95607);
                return;
            case d.MIC_AVROUND_BLUR /*119*/:
                this.blR.append(8540);
                AppMethodBeat.o(95607);
                return;
            case 120:
                this.blR.append(8541);
                AppMethodBeat.o(95607);
                return;
            case 121:
                this.blR.append(8542);
                AppMethodBeat.o(95607);
                return;
            case 122:
                this.blR.append(9474);
                AppMethodBeat.o(95607);
                return;
            case 123:
                this.blR.append(9488);
                AppMethodBeat.o(95607);
                return;
            case 124:
                this.blR.append(9492);
                AppMethodBeat.o(95607);
                return;
            case 125:
                this.blR.append(9472);
                AppMethodBeat.o(95607);
                return;
            case 126:
                this.blR.append(9496);
                AppMethodBeat.o(95607);
                return;
            case d.MIC_SketchMark /*127*/:
                this.blR.append(9484);
                AppMethodBeat.o(95607);
                return;
            default:
                AppMethodBeat.o(95607);
                return;
        }
    }

    private void eC(int i) {
        AppMethodBeat.i(95608);
        if (i == 160) {
            this.blR.append(13252);
            AppMethodBeat.o(95608);
            return;
        }
        this.blR.append('_');
        AppMethodBeat.o(95608);
    }

    private List<com.google.android.exoplayer2.f.a> sN() {
        AppMethodBeat.i(95609);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            if (!this.blQ[i].isEmpty() && this.blQ[i].aIB) {
                arrayList.add(this.blQ[i].sX());
            }
            i++;
        }
        Collections.sort(arrayList);
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(95609);
        return unmodifiableList;
    }

    private void sO() {
        AppMethodBeat.i(95610);
        for (int i = 0; i < 8; i++) {
            this.blQ[i].reset();
        }
        AppMethodBeat.o(95610);
    }
}

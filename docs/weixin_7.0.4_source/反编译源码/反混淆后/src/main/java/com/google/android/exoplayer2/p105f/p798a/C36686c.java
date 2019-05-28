package com.google.android.exoplayer2.p105f.p798a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p105f.C41610h;
import com.google.android.exoplayer2.p105f.C41611i;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.google.android.exoplayer2.f.a.c */
public final class C36686c extends C32043d {
    private List<C32044a> blA;
    private final C32064k blO = new C32064k();
    private final int blP;
    private final C36688a[] blQ;
    private C36688a blR;
    private C36687b blS;
    private int blT;
    private final C32065l blu = new C32065l();
    private List<C32044a> blz;

    /* renamed from: com.google.android.exoplayer2.f.a.c$b */
    static final class C36687b {
        public final int bms;
        public final int bmt;
        public final byte[] bmu;
        int currentIndex = 0;

        public C36687b(int i, int i2) {
            AppMethodBeat.m2504i(95594);
            this.bms = i;
            this.bmt = i2;
            this.bmu = new byte[((i2 * 2) - 1)];
            AppMethodBeat.m2505o(95594);
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.a.c$a */
    static final class C36688a {
        public static final int blU = C36688a.m60867m(2, 2, 2, 0);
        public static final int blV = C36688a.m60867m(0, 0, 0, 0);
        public static final int blW = C36688a.m60867m(0, 0, 0, 3);
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
            AppMethodBeat.m2504i(95593);
            AppMethodBeat.m2505o(95593);
        }

        public C36688a() {
            AppMethodBeat.m2504i(95581);
            reset();
            AppMethodBeat.m2505o(95581);
        }

        public final void reset() {
            AppMethodBeat.m2504i(95583);
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
            AppMethodBeat.m2505o(95583);
        }

        public final void clear() {
            AppMethodBeat.m2504i(95584);
            this.blI.clear();
            this.blJ.clear();
            this.bmp = -1;
            this.blL = -1;
            this.bmq = -1;
            this.bmr = -1;
            this.row = 0;
            AppMethodBeat.m2505o(95584);
        }

        /* renamed from: be */
        public final void mo58544be(int i, int i2) {
            this.bmo = i;
            this.bml = i2;
        }

        /* renamed from: h */
        public final void mo58547h(boolean z, boolean z2) {
            AppMethodBeat.m2504i(95585);
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
                    AppMethodBeat.m2505o(95585);
                    return;
                }
            } else if (z2) {
                this.blL = this.blJ.length();
            }
            AppMethodBeat.m2505o(95585);
        }

        /* renamed from: bf */
        public final void mo58545bf(int i, int i2) {
            AppMethodBeat.m2504i(95586);
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
            AppMethodBeat.m2505o(95586);
        }

        /* renamed from: sR */
        public final void mo58550sR() {
            AppMethodBeat.m2504i(95587);
            int length = this.blJ.length();
            if (length > 0) {
                this.blJ.delete(length - 1, length);
            }
            AppMethodBeat.m2505o(95587);
        }

        public final void append(char c) {
            AppMethodBeat.m2504i(95588);
            if (c == 10) {
                this.blI.add(m60869sT());
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
            AppMethodBeat.m2505o(95588);
        }

        /* renamed from: sT */
        private SpannableString m60869sT() {
            AppMethodBeat.m2504i(95589);
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
            AppMethodBeat.m2505o(95589);
            return spannableString;
        }

        /* renamed from: sX */
        public final C8670b mo58551sX() {
            boolean z = false;
            AppMethodBeat.m2504i(95590);
            if (isEmpty()) {
                AppMethodBeat.m2505o(95590);
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
            spannableStringBuilder.append(m60869sT());
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
                    AppMethodBeat.m2505o(95590);
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
            C8670b c8670b = new C8670b(spannableStringBuilder, alignment, f, i, f3, i2, z, this.bmo, this.priority);
            AppMethodBeat.m2505o(95590);
            return c8670b;
        }

        /* renamed from: s */
        public static int m60868s(int i, int i2, int i3) {
            AppMethodBeat.m2504i(95591);
            int m = C36688a.m60867m(i, i2, i3, 0);
            AppMethodBeat.m2505o(95591);
            return m;
        }

        /* renamed from: m */
        public static int m60867m(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8 = 255;
            AppMethodBeat.m2504i(95592);
            C45039a.m82573bh(i, 4);
            C45039a.m82573bh(i2, 4);
            C45039a.m82573bh(i3, 4);
            C45039a.m82573bh(i4, 4);
            switch (i4) {
                case 0:
                case 1:
                    i5 = 255;
                    break;
                case 2:
                    i5 = C31128d.MIC_SketchMark;
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
            AppMethodBeat.m2505o(95592);
            return i8;
        }

        public final boolean isEmpty() {
            AppMethodBeat.m2504i(95582);
            if (!this.bmf || (this.blI.isEmpty() && this.blJ.length() == 0)) {
                AppMethodBeat.m2505o(95582);
                return true;
            }
            AppMethodBeat.m2505o(95582);
            return false;
        }
    }

    /* renamed from: ai */
    public final /* bridge */ /* synthetic */ void mo19179ai(long j) {
        AppMethodBeat.m2504i(95615);
        super.mo19179ai(j);
        AppMethodBeat.m2505o(95615);
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo19180b(C41610h c41610h) {
        AppMethodBeat.m2504i(95613);
        super.mo19140ad(c41610h);
        AppMethodBeat.m2505o(95613);
    }

    public final /* bridge */ /* synthetic */ void release() {
        AppMethodBeat.m2504i(95611);
        super.release();
        AppMethodBeat.m2505o(95611);
    }

    /* renamed from: sP */
    public final /* bridge */ /* synthetic */ C41611i mo19183sP() {
        AppMethodBeat.m2504i(95612);
        C41611i sP = super.mo19143qJ();
        AppMethodBeat.m2505o(95612);
        return sP;
    }

    /* renamed from: sQ */
    public final /* bridge */ /* synthetic */ C41610h mo19184sQ() {
        AppMethodBeat.m2504i(95614);
        C41610h sQ = super.mo19142qI();
        AppMethodBeat.m2505o(95614);
        return sQ;
    }

    public C36686c(int i) {
        AppMethodBeat.m2504i(95595);
        if (i == -1) {
            i = 1;
        }
        this.blP = i;
        this.blQ = new C36688a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.blQ[i2] = new C36688a();
        }
        this.blR = this.blQ[0];
        m60857sO();
        AppMethodBeat.m2505o(95595);
    }

    public final void flush() {
        AppMethodBeat.m2504i(95596);
        super.flush();
        this.blz = null;
        this.blA = null;
        this.blT = 0;
        this.blR = this.blQ[this.blT];
        m60857sO();
        this.blS = null;
        AppMethodBeat.m2505o(95596);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: sL */
    public final boolean mo19181sL() {
        return this.blz != this.blA;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: sM */
    public final C17659d mo19182sM() {
        AppMethodBeat.m2504i(95597);
        this.blA = this.blz;
        C37249f c37249f = new C37249f(this.blz);
        AppMethodBeat.m2505o(95597);
        return c37249f;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo19178a(C41610h c41610h) {
        AppMethodBeat.m2504i(95598);
        this.blu.mo52371n(c41610h.aEY.array(), c41610h.aEY.limit());
        while (this.blu.mo52382tB() >= 3) {
            int readUnsignedByte = this.blu.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            Object obj = (readUnsignedByte & 4) == 4 ? 1 : null;
            byte readUnsignedByte2 = (byte) this.blu.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.blu.readUnsignedByte();
            if ((i == 2 || i == 3) && obj != null) {
                byte[] bArr;
                C36687b c36687b;
                int i2;
                if (i == 3) {
                    m60858sV();
                    i = (readUnsignedByte2 & C33250az.CTRL_INDEX) >> 6;
                    readUnsignedByte = readUnsignedByte2 & 63;
                    if (readUnsignedByte == 0) {
                        readUnsignedByte = 64;
                    }
                    this.blS = new C36687b(i, readUnsignedByte);
                    bArr = this.blS.bmu;
                    c36687b = this.blS;
                    i2 = c36687b.currentIndex;
                    c36687b.currentIndex = i2 + 1;
                    bArr[i2] = readUnsignedByte3;
                } else {
                    C45039a.checkArgument(i == 2);
                    if (this.blS != null) {
                        bArr = this.blS.bmu;
                        c36687b = this.blS;
                        int i3 = c36687b.currentIndex;
                        c36687b.currentIndex = i3 + 1;
                        bArr[i3] = readUnsignedByte2;
                        bArr = this.blS.bmu;
                        c36687b = this.blS;
                        i2 = c36687b.currentIndex;
                        c36687b.currentIndex = i2 + 1;
                        bArr[i2] = readUnsignedByte3;
                    }
                }
                if (this.blS.currentIndex == (this.blS.bmt * 2) - 1) {
                    m60858sV();
                }
            }
        }
        AppMethodBeat.m2505o(95598);
    }

    /* renamed from: sV */
    private void m60858sV() {
        AppMethodBeat.m2504i(95599);
        if (this.blS == null) {
            AppMethodBeat.m2505o(95599);
            return;
        }
        m60859sW();
        this.blS = null;
        AppMethodBeat.m2505o(95599);
    }

    /* renamed from: sW */
    private void m60859sW() {
        AppMethodBeat.m2504i(95600);
        if (this.blS.currentIndex != (this.blS.bmt * 2) - 1) {
            new StringBuilder("DtvCcPacket ended prematurely; size is ").append((this.blS.bmt * 2) - 1).append(", but current index is ").append(this.blS.currentIndex).append(" (sequence number ").append(this.blS.bms).append("); ignoring packet");
            AppMethodBeat.m2505o(95600);
            return;
        }
        this.blO.mo52356n(this.blS.bmu, this.blS.currentIndex);
        int ed = this.blO.mo52354ed(3);
        int ed2 = this.blO.mo52354ed(5);
        if (ed == 7) {
            this.blO.mo52355ee(2);
            ed += this.blO.mo52354ed(6);
        }
        if (ed2 == 0) {
            if (ed != 0) {
                new StringBuilder("serviceNumber is non-zero (").append(ed).append(") when blockSize is 0");
            }
            AppMethodBeat.m2505o(95600);
        } else if (ed != this.blP) {
            AppMethodBeat.m2505o(95600);
        } else {
            Object obj = null;
            while (this.blO.mo52362tx() > 0) {
                ed2 = this.blO.mo52354ed(8);
                if (ed2 == 16) {
                    ed2 = this.blO.mo52354ed(8);
                    if (ed2 <= 31) {
                        m60853ex(ed2);
                    } else if (ed2 <= C31128d.MIC_SketchMark) {
                        m60849eB(ed2);
                        obj = 1;
                    } else if (ed2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                        m60854ey(ed2);
                    } else if (ed2 <= 255) {
                        m60850eC(ed2);
                        obj = 1;
                    }
                } else if (ed2 <= 31) {
                    m60851ev(ed2);
                } else if (ed2 <= C31128d.MIC_SketchMark) {
                    m60855ez(ed2);
                    obj = 1;
                } else if (ed2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                    m60852ew(ed2);
                    obj = 1;
                } else if (ed2 <= 255) {
                    m60848eA(ed2);
                    obj = 1;
                }
            }
            if (obj != null) {
                this.blz = m60856sN();
            }
            AppMethodBeat.m2505o(95600);
        }
    }

    /* renamed from: ev */
    private void m60851ev(int i) {
        AppMethodBeat.m2504i(95601);
        switch (i) {
            case 0:
                AppMethodBeat.m2505o(95601);
                return;
            case 3:
                this.blz = m60856sN();
                AppMethodBeat.m2505o(95601);
                return;
            case 8:
                this.blR.mo58550sR();
                AppMethodBeat.m2505o(95601);
                return;
            case 12:
                m60857sO();
                AppMethodBeat.m2505o(95601);
                return;
            case 13:
                this.blR.append(10);
                AppMethodBeat.m2505o(95601);
                return;
            case 14:
                AppMethodBeat.m2505o(95601);
                return;
            default:
                if (i >= 17 && i <= 23) {
                    this.blO.mo52355ee(8);
                    AppMethodBeat.m2505o(95601);
                    return;
                } else if (i < 24 || i > 31) {
                    AppMethodBeat.m2505o(95601);
                    return;
                } else {
                    this.blO.mo52355ee(16);
                    AppMethodBeat.m2505o(95601);
                    return;
                }
        }
    }

    /* renamed from: ew */
    private void m60852ew(int i) {
        AppMethodBeat.m2504i(95602);
        int i2;
        int i3;
        boolean z;
        C36688a c36688a;
        switch (i) {
            case 128:
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
            case 130:
            case 131:
            case 132:
            case C19394e.CTRL_INDEX /*133*/:
            case C19392d.CTRL_INDEX /*134*/:
            case C44697b.CTRL_INDEX /*135*/:
                i2 = i - 128;
                if (this.blT != i2) {
                    this.blT = i2;
                    this.blR = this.blQ[i2];
                    AppMethodBeat.m2505o(95602);
                    return;
                }
                break;
            case C19395n.CTRL_INDEX /*136*/:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.mo52358rl()) {
                        this.blQ[8 - i2].clear();
                    }
                }
                AppMethodBeat.m2505o(95602);
                return;
            case 137:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.mo52358rl()) {
                        this.blQ[8 - i2].aIB = true;
                    }
                }
                AppMethodBeat.m2505o(95602);
                return;
            case 138:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.mo52358rl()) {
                        this.blQ[8 - i2].aIB = false;
                    }
                }
                AppMethodBeat.m2505o(95602);
                return;
            case C33333a.CTRL_INDEX /*139*/:
                i2 = 1;
                while (true) {
                    i3 = i2;
                    if (i3 <= 8) {
                        if (this.blO.mo52358rl()) {
                            C36688a c36688a2 = this.blQ[8 - i3];
                            if (c36688a2.aIB) {
                                z = false;
                            } else {
                                z = true;
                            }
                            c36688a2.aIB = z;
                        }
                        i2 = i3 + 1;
                    } else {
                        AppMethodBeat.m2505o(95602);
                        return;
                    }
                }
            case 140:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.blO.mo52358rl()) {
                        this.blQ[8 - i2].reset();
                    }
                }
                AppMethodBeat.m2505o(95602);
                return;
            case 141:
                this.blO.mo52355ee(8);
                AppMethodBeat.m2505o(95602);
                return;
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                AppMethodBeat.m2505o(95602);
                return;
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                m60857sO();
                AppMethodBeat.m2505o(95602);
                return;
            case 144:
                if (this.blR.bmf) {
                    this.blO.mo52354ed(4);
                    this.blO.mo52354ed(2);
                    this.blO.mo52354ed(2);
                    z = this.blO.mo52358rl();
                    boolean rl = this.blO.mo52358rl();
                    this.blO.mo52354ed(3);
                    this.blO.mo52354ed(3);
                    this.blR.mo58547h(z, rl);
                    AppMethodBeat.m2505o(95602);
                    return;
                }
                this.blO.mo52355ee(16);
                AppMethodBeat.m2505o(95602);
                return;
            case 145:
                if (this.blR.bmf) {
                    i2 = C36688a.m60867m(this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2));
                    i3 = C36688a.m60867m(this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2));
                    this.blO.mo52355ee(2);
                    C36688a.m60868s(this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2));
                    this.blR.mo58545bf(i2, i3);
                    AppMethodBeat.m2505o(95602);
                    return;
                }
                this.blO.mo52355ee(24);
                AppMethodBeat.m2505o(95602);
                return;
            case 146:
                if (this.blR.bmf) {
                    this.blO.mo52355ee(4);
                    i2 = this.blO.mo52354ed(4);
                    this.blO.mo52355ee(2);
                    this.blO.mo52354ed(6);
                    c36688a = this.blR;
                    if (c36688a.row != i2) {
                        c36688a.append(10);
                    }
                    c36688a.row = i2;
                    AppMethodBeat.m2505o(95602);
                    return;
                }
                this.blO.mo52355ee(16);
                AppMethodBeat.m2505o(95602);
                return;
            case 151:
                if (this.blR.bmf) {
                    i2 = C36688a.m60867m(this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2));
                    this.blO.mo52354ed(2);
                    C36688a.m60868s(this.blO.mo52354ed(2), this.blO.mo52354ed(2), this.blO.mo52354ed(2));
                    this.blO.mo52358rl();
                    this.blO.mo52358rl();
                    this.blO.mo52354ed(2);
                    this.blO.mo52354ed(2);
                    i3 = this.blO.mo52354ed(2);
                    this.blO.mo52355ee(8);
                    this.blR.mo58544be(i2, i3);
                    AppMethodBeat.m2505o(95602);
                    return;
                }
                this.blO.mo52355ee(32);
                AppMethodBeat.m2505o(95602);
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
                c36688a = this.blQ[i2];
                this.blO.mo52355ee(2);
                boolean rl2 = this.blO.mo52358rl();
                boolean rl3 = this.blO.mo52358rl();
                this.blO.mo52358rl();
                int ed = this.blO.mo52354ed(3);
                boolean rl4 = this.blO.mo52358rl();
                int ed2 = this.blO.mo52354ed(7);
                int ed3 = this.blO.mo52354ed(8);
                int ed4 = this.blO.mo52354ed(4);
                int ed5 = this.blO.mo52354ed(4);
                this.blO.mo52355ee(2);
                this.blO.mo52354ed(6);
                this.blO.mo52355ee(2);
                int ed6 = this.blO.mo52354ed(3);
                int ed7 = this.blO.mo52354ed(3);
                c36688a.bmf = true;
                c36688a.aIB = rl2;
                c36688a.bmk = rl3;
                c36688a.priority = ed;
                c36688a.bmg = rl4;
                c36688a.bmh = ed2;
                c36688a.bmi = ed3;
                c36688a.bmj = ed4;
                if (c36688a.rowCount != ed5 + 1) {
                    c36688a.rowCount = ed5 + 1;
                    while (true) {
                        if ((rl3 && c36688a.blI.size() >= c36688a.rowCount) || c36688a.blI.size() >= 15) {
                            c36688a.blI.remove(0);
                        }
                    }
                }
                if (!(ed6 == 0 || c36688a.bmm == ed6)) {
                    c36688a.bmm = ed6;
                    i4 = ed6 - 1;
                    c36688a.mo58544be(C36688a.bmb[i4], C36688a.blX[i4]);
                }
                if (!(ed7 == 0 || c36688a.bmn == ed7)) {
                    c36688a.bmn = ed7;
                    i4 = ed7 - 1;
                    c36688a.mo58547h(false, false);
                    c36688a.mo58545bf(C36688a.blU, C36688a.bme[i4]);
                }
                if (this.blT != i2) {
                    this.blT = i2;
                    this.blR = this.blQ[i2];
                    AppMethodBeat.m2505o(95602);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(95602);
    }

    /* renamed from: ex */
    private void m60853ex(int i) {
        AppMethodBeat.m2504i(95603);
        if (i > 7) {
            if (i <= 15) {
                this.blO.mo52355ee(8);
                AppMethodBeat.m2505o(95603);
                return;
            } else if (i <= 23) {
                this.blO.mo52355ee(16);
                AppMethodBeat.m2505o(95603);
                return;
            } else if (i <= 31) {
                this.blO.mo52355ee(24);
            }
        }
        AppMethodBeat.m2505o(95603);
    }

    /* renamed from: ey */
    private void m60854ey(int i) {
        AppMethodBeat.m2504i(95604);
        if (i <= C44697b.CTRL_INDEX) {
            this.blO.mo52355ee(32);
            AppMethodBeat.m2505o(95604);
        } else if (i <= ErrorCode.NEEDDOWNLOAD_4) {
            this.blO.mo52355ee(40);
            AppMethodBeat.m2505o(95604);
        } else {
            if (i <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                this.blO.mo52355ee(2);
                this.blO.mo52355ee(this.blO.mo52354ed(6) * 8);
            }
            AppMethodBeat.m2505o(95604);
        }
    }

    /* renamed from: ez */
    private void m60855ez(int i) {
        AppMethodBeat.m2504i(95605);
        if (i == C31128d.MIC_SketchMark) {
            this.blR.append(9835);
            AppMethodBeat.m2505o(95605);
            return;
        }
        this.blR.append((char) (i & 255));
        AppMethodBeat.m2505o(95605);
    }

    /* renamed from: eA */
    private void m60848eA(int i) {
        AppMethodBeat.m2504i(95606);
        this.blR.append((char) (i & 255));
        AppMethodBeat.m2505o(95606);
    }

    /* renamed from: eB */
    private void m60849eB(int i) {
        AppMethodBeat.m2504i(95607);
        switch (i) {
            case 32:
                this.blR.append(' ');
                AppMethodBeat.m2505o(95607);
                return;
            case 33:
                this.blR.append(160);
                AppMethodBeat.m2505o(95607);
                return;
            case C2275g.CTRL_INDEX /*37*/:
                this.blR.append(8230);
                AppMethodBeat.m2505o(95607);
                return;
            case 42:
                this.blR.append(352);
                AppMethodBeat.m2505o(95607);
                return;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                this.blR.append(338);
                AppMethodBeat.m2505o(95607);
                return;
            case 48:
                this.blR.append(9608);
                AppMethodBeat.m2505o(95607);
                return;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                this.blR.append(8216);
                AppMethodBeat.m2505o(95607);
                return;
            case 50:
                this.blR.append(8217);
                AppMethodBeat.m2505o(95607);
                return;
            case 51:
                this.blR.append(8220);
                AppMethodBeat.m2505o(95607);
                return;
            case 52:
                this.blR.append(8221);
                AppMethodBeat.m2505o(95607);
                return;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                this.blR.append(8226);
                AppMethodBeat.m2505o(95607);
                return;
            case C19410e.CTRL_INDEX /*57*/:
                this.blR.append(8482);
                AppMethodBeat.m2505o(95607);
                return;
            case C42464aa.CTRL_INDEX /*58*/:
                this.blR.append(353);
                AppMethodBeat.m2505o(95607);
                return;
            case 60:
                this.blR.append(339);
                AppMethodBeat.m2505o(95607);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.blR.append(8480);
                AppMethodBeat.m2505o(95607);
                return;
            case 63:
                this.blR.append(376);
                AppMethodBeat.m2505o(95607);
                return;
            case 118:
                this.blR.append(8539);
                AppMethodBeat.m2505o(95607);
                return;
            case C31128d.MIC_AVROUND_BLUR /*119*/:
                this.blR.append(8540);
                AppMethodBeat.m2505o(95607);
                return;
            case 120:
                this.blR.append(8541);
                AppMethodBeat.m2505o(95607);
                return;
            case 121:
                this.blR.append(8542);
                AppMethodBeat.m2505o(95607);
                return;
            case 122:
                this.blR.append(9474);
                AppMethodBeat.m2505o(95607);
                return;
            case 123:
                this.blR.append(9488);
                AppMethodBeat.m2505o(95607);
                return;
            case 124:
                this.blR.append(9492);
                AppMethodBeat.m2505o(95607);
                return;
            case 125:
                this.blR.append(9472);
                AppMethodBeat.m2505o(95607);
                return;
            case 126:
                this.blR.append(9496);
                AppMethodBeat.m2505o(95607);
                return;
            case C31128d.MIC_SketchMark /*127*/:
                this.blR.append(9484);
                AppMethodBeat.m2505o(95607);
                return;
            default:
                AppMethodBeat.m2505o(95607);
                return;
        }
    }

    /* renamed from: eC */
    private void m60850eC(int i) {
        AppMethodBeat.m2504i(95608);
        if (i == 160) {
            this.blR.append(13252);
            AppMethodBeat.m2505o(95608);
            return;
        }
        this.blR.append('_');
        AppMethodBeat.m2505o(95608);
    }

    /* renamed from: sN */
    private List<C32044a> m60856sN() {
        AppMethodBeat.m2504i(95609);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            if (!this.blQ[i].isEmpty() && this.blQ[i].aIB) {
                arrayList.add(this.blQ[i].mo58551sX());
            }
            i++;
        }
        Collections.sort(arrayList);
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        AppMethodBeat.m2505o(95609);
        return unmodifiableList;
    }

    /* renamed from: sO */
    private void m60857sO() {
        AppMethodBeat.m2504i(95610);
        for (int i = 0; i < 8; i++) {
            this.blQ[i].reset();
        }
        AppMethodBeat.m2505o(95610);
    }
}

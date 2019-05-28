package com.google.android.exoplayer2.p105f.p798a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p105f.C41610h;
import com.google.android.exoplayer2.p105f.C41611i;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.a.a */
public final class C8669a extends C32043d {
    /* renamed from: Pc */
    private static final int[] f2432Pc = new int[]{-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] blo = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] blp = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] blq = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, C31128d.MIC_PTU_MEISHI, 93, C31128d.MIC_PTU_LENGMEIREN, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, C31128d.MIC_ALPHA_ADJUST_REAL, 118, C31128d.MIC_AVROUND_BLUR, 120, 121, 122, 231, 247, 209, C31128d.MIC_PTU_QINGCONG, 9632};
    private static final int[] blr = new int[]{ErrorCode.NEEDDOWNLOAD_FALSE_4, ErrorCode.NEEDDOWNLOAD_FALSE_6, 189, 191, 8482, ErrorCode.STARTDOWNLOAD_3, ErrorCode.STARTDOWNLOAD_4, 9834, 224, 32, 232, 226, C31128d.MIC_PTU_FENGJING, C31128d.MIC_PTU_SHIGUANG, 244, 251};
    private static final int[] bls = new int[]{JsApiChooseMedia.CTRL_INDEX, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, C33250az.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, 199, 200, 202, 203, C31128d.MIC_PTU_AUTOLEVEL, 206, 207, C31128d.MIC_PTU_SHISHANG2, 212, 217, 249, 219, ErrorCode.NEEDDOWNLOAD_FALSE_1, 187};
    private static final int[] blt = new int[]{JsApiChooseWeChatContact.CTRL_INDEX, 227, 205, 204, 236, 210, 242, 213, C31128d.MIC_PTU_ZIPAI_LIGHTWHITE, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, C31128d.MIC_PTU_ZIPAI_FAIRYTALE, 223, ErrorCode.STARTDOWNLOAD_6, ErrorCode.STARTDOWNLOAD_5, 9474, 197, 229, 216, C31128d.MIC_PTU_ZIPAI_THURSDAY, 9484, 9488, 9492, 9496};
    private List<C32044a> blA;
    private int blB;
    private int blC;
    private boolean blD;
    private byte blE;
    private byte blF;
    private final C32065l blu = new C32065l();
    private final int blv;
    private final int blw;
    private final LinkedList<C8667a> blx = new LinkedList();
    private C8667a bly = new C8667a(0, 4);
    private List<C32044a> blz;

    /* renamed from: com.google.android.exoplayer2.f.a.a$a */
    static class C8667a {
        int aLM;
        private int blB;
        private int blC;
        private final List<CharacterStyle> blG = new ArrayList();
        private final List<C8668a> blH = new ArrayList();
        private final List<SpannableString> blI = new LinkedList();
        final SpannableStringBuilder blJ = new SpannableStringBuilder();
        int blK;
        int blL;
        int row;

        /* renamed from: com.google.android.exoplayer2.f.a.a$a$a */
        static class C8668a {
            public final CharacterStyle blM;
            public final int blN;
            public final int start;

            public C8668a(CharacterStyle characterStyle, int i, int i2) {
                this.blM = characterStyle;
                this.start = i;
                this.blN = i2;
            }
        }

        public C8667a(int i, int i2) {
            AppMethodBeat.m2504i(95559);
            reset(i, i2);
            AppMethodBeat.m2505o(95559);
        }

        public final void reset(int i, int i2) {
            AppMethodBeat.m2504i(95560);
            this.blG.clear();
            this.blH.clear();
            this.blI.clear();
            this.blJ.clear();
            this.row = 15;
            this.aLM = 0;
            this.blK = 0;
            this.blB = i;
            this.blC = i2;
            this.blL = -1;
            AppMethodBeat.m2505o(95560);
        }

        public final boolean isEmpty() {
            AppMethodBeat.m2504i(95561);
            if (this.blG.isEmpty() && this.blH.isEmpty() && this.blI.isEmpty() && this.blJ.length() == 0) {
                AppMethodBeat.m2505o(95561);
                return true;
            }
            AppMethodBeat.m2505o(95561);
            return false;
        }

        /* renamed from: sR */
        public final void mo19174sR() {
            AppMethodBeat.m2504i(95562);
            int length = this.blJ.length();
            if (length > 0) {
                this.blJ.delete(length - 1, length);
            }
            AppMethodBeat.m2505o(95562);
        }

        /* renamed from: sS */
        public final void mo19175sS() {
            AppMethodBeat.m2504i(95563);
            this.blI.add(m15371sT());
            this.blJ.clear();
            this.blG.clear();
            this.blH.clear();
            this.blL = -1;
            int min = Math.min(this.blC, this.row);
            while (this.blI.size() >= min) {
                this.blI.remove(0);
            }
            AppMethodBeat.m2505o(95563);
        }

        /* renamed from: a */
        public final void mo19169a(CharacterStyle characterStyle) {
            AppMethodBeat.m2504i(95564);
            this.blG.add(characterStyle);
            AppMethodBeat.m2505o(95564);
        }

        /* renamed from: a */
        public final void mo19170a(CharacterStyle characterStyle, int i) {
            AppMethodBeat.m2504i(95565);
            this.blH.add(new C8668a(characterStyle, this.blJ.length(), i));
            AppMethodBeat.m2505o(95565);
        }

        public final void append(char c) {
            AppMethodBeat.m2504i(95566);
            this.blJ.append(c);
            AppMethodBeat.m2505o(95566);
        }

        /* renamed from: sT */
        private SpannableString m15371sT() {
            int i = 0;
            AppMethodBeat.m2504i(95567);
            int length = this.blJ.length();
            for (int i2 = 0; i2 < this.blG.size(); i2++) {
                this.blJ.setSpan(this.blG.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.blH.size()) {
                    break;
                }
                C8668a c8668a = (C8668a) this.blH.get(i3);
                if (i3 < this.blH.size() - c8668a.blN) {
                    i = ((C8668a) this.blH.get(c8668a.blN + i3)).start;
                } else {
                    i = length;
                }
                this.blJ.setSpan(c8668a.blM, c8668a.start, i, 33);
                i = i3 + 1;
            }
            if (this.blL != -1) {
                this.blJ.setSpan(new UnderlineSpan(), this.blL, length, 33);
            }
            SpannableString spannableString = new SpannableString(this.blJ);
            AppMethodBeat.m2505o(95567);
            return spannableString;
        }

        /* renamed from: sU */
        public final C32044a mo19176sU() {
            int i;
            int i2 = 2;
            AppMethodBeat.m2504i(95568);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (i = 0; i < this.blI.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.blI.get(i));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(m15371sT());
            if (spannableStringBuilder.length() == 0) {
                AppMethodBeat.m2505o(95568);
                return null;
            }
            float f;
            int i3;
            int i4;
            int i5 = this.aLM + this.blK;
            i = (32 - i5) - spannableStringBuilder.length();
            int i6 = i5 - i;
            if (this.blB == 2 && Math.abs(i6) < 3) {
                f = 0.5f;
                i3 = 1;
            } else if (this.blB != 2 || i6 <= 0) {
                f = ((((float) i5) / 32.0f) * 0.8f) + 0.1f;
                i3 = 0;
            } else {
                f = ((((float) (32 - i)) / 32.0f) * 0.8f) + 0.1f;
                i3 = 2;
            }
            if (this.blB == 1 || this.row > 7) {
                i4 = (this.row - 15) - 2;
            } else {
                i4 = this.row;
                i2 = 0;
            }
            C32044a c32044a = new C32044a(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i4, 1, i2, f, i3, Float.MIN_VALUE);
            AppMethodBeat.m2505o(95568);
            return c32044a;
        }

        public final String toString() {
            AppMethodBeat.m2504i(95569);
            String spannableStringBuilder = this.blJ.toString();
            AppMethodBeat.m2505o(95569);
            return spannableStringBuilder;
        }
    }

    /* renamed from: ai */
    public final /* bridge */ /* synthetic */ void mo19179ai(long j) {
        AppMethodBeat.m2504i(95580);
        super.mo19179ai(j);
        AppMethodBeat.m2505o(95580);
    }

    /* renamed from: sP */
    public final /* bridge */ /* synthetic */ C41611i mo19183sP() {
        AppMethodBeat.m2504i(95577);
        C41611i sP = super.mo19143qJ();
        AppMethodBeat.m2505o(95577);
        return sP;
    }

    /* renamed from: sQ */
    public final /* bridge */ /* synthetic */ C41610h mo19184sQ() {
        AppMethodBeat.m2504i(95579);
        C41610h sQ = super.mo19142qI();
        AppMethodBeat.m2505o(95579);
        return sQ;
    }

    public C8669a(String str, int i) {
        AppMethodBeat.m2504i(95570);
        this.blv = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.blw = 2;
                break;
            default:
                this.blw = 1;
                break;
        }
        m15378eu(0);
        m15380sO();
        AppMethodBeat.m2505o(95570);
    }

    public final void flush() {
        AppMethodBeat.m2504i(95571);
        super.flush();
        this.blz = null;
        this.blA = null;
        m15378eu(0);
        m15380sO();
        this.blC = 4;
        this.blD = false;
        this.blE = (byte) 0;
        this.blF = (byte) 0;
        AppMethodBeat.m2505o(95571);
    }

    public final void release() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: sL */
    public final boolean mo19181sL() {
        return this.blz != this.blA;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: sM */
    public final C17659d mo19182sM() {
        AppMethodBeat.m2504i(95572);
        this.blA = this.blz;
        C37249f c37249f = new C37249f(this.blz);
        AppMethodBeat.m2505o(95572);
        return c37249f;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo19178a(C41610h c41610h) {
        AppMethodBeat.m2504i(95573);
        this.blu.mo52371n(c41610h.aEY.array(), c41610h.aEY.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.blu.mo52382tB() >= this.blv) {
            int i;
            if (this.blv == 2) {
                i = -4;
            } else {
                i = (byte) this.blu.readUnsignedByte();
            }
            byte readUnsignedByte = (byte) (this.blu.readUnsignedByte() & C31128d.MIC_SketchMark);
            byte readUnsignedByte2 = (byte) (this.blu.readUnsignedByte() & C31128d.MIC_SketchMark);
            if ((i & 6) == 4 && ((this.blw != 1 || (i & 1) == 0) && ((this.blw != 2 || (i & 1) == 1) && !(readUnsignedByte == (byte) 0 && readUnsignedByte2 == (byte) 0)))) {
                if ((readUnsignedByte & 247) == 17 && (readUnsignedByte2 & 240) == 48) {
                    this.bly.append((char) blr[readUnsignedByte2 & 15]);
                    z2 = true;
                } else if ((readUnsignedByte & C31128d.MIC_PTU_ZIPAI_FAIRYTALE) == 18 && (readUnsignedByte2 & 224) == 32) {
                    this.bly.mo19174sR();
                    if ((readUnsignedByte & 1) == 0) {
                        this.bly.append((char) bls[readUnsignedByte2 & 31]);
                        z2 = true;
                    } else {
                        this.bly.append((char) blt[readUnsignedByte2 & 31]);
                        z2 = true;
                    }
                } else if ((readUnsignedByte & 224) == 0) {
                    if ((readUnsignedByte & 240) == 16) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.blD && this.blE == readUnsignedByte && this.blF == readUnsignedByte2) {
                            this.blD = false;
                            z = true;
                            z2 = true;
                        } else {
                            this.blD = true;
                            this.blE = readUnsignedByte;
                            this.blF = readUnsignedByte2;
                        }
                    }
                    if ((readUnsignedByte & 247) == 17 && (readUnsignedByte2 & 240) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i2;
                    if (!z) {
                        if ((readUnsignedByte & 240) == 16 && (readUnsignedByte2 & C33250az.CTRL_INDEX) == 64) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            if ((readUnsignedByte & 247) != 23 || readUnsignedByte2 < (byte) 33 || readUnsignedByte2 > (byte) 35) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                if ((readUnsignedByte & 247) == 20 && (readUnsignedByte2 & 240) == 32) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    switch (readUnsignedByte2) {
                                        case (byte) 32:
                                            m15378eu(2);
                                            break;
                                        case C2275g.CTRL_INDEX /*37*/:
                                            this.blC = 2;
                                            m15378eu(1);
                                            break;
                                        case (byte) 38:
                                            this.blC = 3;
                                            m15378eu(1);
                                            break;
                                        case (byte) 39:
                                            this.blC = 4;
                                            m15378eu(1);
                                            break;
                                        case (byte) 41:
                                            m15378eu(3);
                                            break;
                                        default:
                                            if (this.blB != 0) {
                                                switch (readUnsignedByte2) {
                                                    case (byte) 33:
                                                        this.bly.mo19174sR();
                                                        break;
                                                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                                        this.blz = null;
                                                        if (this.blB == 1 || this.blB == 3) {
                                                            m15380sO();
                                                            break;
                                                        }
                                                    case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                                                        if (this.blB == 1 && !this.bly.isEmpty()) {
                                                            this.bly.mo19175sS();
                                                            break;
                                                        }
                                                    case (byte) 46:
                                                        m15380sO();
                                                        break;
                                                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                                                        this.blz = m15379sN();
                                                        m15380sO();
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                            }
                            this.bly.blK = readUnsignedByte2 - 32;
                        } else {
                            i2 = blo[readUnsignedByte & 7];
                            if ((readUnsignedByte2 & 32) != 0) {
                                i2++;
                            }
                            if (i2 != this.bly.row) {
                                if (!(this.blB == 1 || this.bly.isEmpty())) {
                                    this.bly = new C8667a(this.blB, this.blC);
                                    this.blx.add(this.bly);
                                }
                                this.bly.row = i2;
                            }
                            if ((readUnsignedByte2 & 1) == 1) {
                                this.bly.mo19169a(new UnderlineSpan());
                            }
                            i2 = (readUnsignedByte2 >> 1) & 15;
                            if (i2 > 7) {
                                this.bly.aLM = blp[i2 & 7];
                            } else if (i2 == 7) {
                                this.bly.mo19169a(new StyleSpan(2));
                                this.bly.mo19169a(new ForegroundColorSpan(-1));
                            } else {
                                this.bly.mo19169a(new ForegroundColorSpan(f2432Pc[i2]));
                            }
                        }
                    } else {
                        z = (readUnsignedByte2 & 1) == 1;
                        C8667a c8667a = this.bly;
                        if (z) {
                            c8667a.blL = c8667a.blJ.length();
                        } else if (c8667a.blL != -1) {
                            c8667a.blJ.setSpan(new UnderlineSpan(), c8667a.blL, c8667a.blJ.length(), 33);
                            c8667a.blL = -1;
                        }
                        i2 = (readUnsignedByte2 >> 1) & 15;
                        if (i2 == 7) {
                            this.bly.mo19170a(new StyleSpan(2), 2);
                            this.bly.mo19170a(new ForegroundColorSpan(-1), 1);
                        } else {
                            this.bly.mo19170a(new ForegroundColorSpan(f2432Pc[i2]), 1);
                        }
                    }
                    z = z2;
                    z2 = true;
                } else {
                    this.bly.append(C8669a.m15377b(readUnsignedByte));
                    if ((readUnsignedByte2 & 224) != 0) {
                        this.bly.append(C8669a.m15377b(readUnsignedByte2));
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            if (!z) {
                this.blD = false;
            }
            if (this.blB == 1 || this.blB == 3) {
                this.blz = m15379sN();
            }
        }
        AppMethodBeat.m2505o(95573);
    }

    /* renamed from: sN */
    private List<C32044a> m15379sN() {
        AppMethodBeat.m2504i(95574);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.blx.size()) {
                C32044a sU = ((C8667a) this.blx.get(i2)).mo19176sU();
                if (sU != null) {
                    arrayList.add(sU);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(95574);
                return arrayList;
            }
        }
    }

    /* renamed from: eu */
    private void m15378eu(int i) {
        AppMethodBeat.m2504i(95575);
        if (this.blB == i) {
            AppMethodBeat.m2505o(95575);
            return;
        }
        int i2 = this.blB;
        this.blB = i;
        m15380sO();
        if (i2 == 3 || i == 1 || i == 0) {
            this.blz = null;
        }
        AppMethodBeat.m2505o(95575);
    }

    /* renamed from: sO */
    private void m15380sO() {
        AppMethodBeat.m2504i(95576);
        this.bly.reset(this.blB, this.blC);
        this.blx.clear();
        this.blx.add(this.bly);
        AppMethodBeat.m2505o(95576);
    }

    /* renamed from: b */
    private static char m15377b(byte b) {
        return (char) blq[(b & C31128d.MIC_SketchMark) - 32];
    }
}

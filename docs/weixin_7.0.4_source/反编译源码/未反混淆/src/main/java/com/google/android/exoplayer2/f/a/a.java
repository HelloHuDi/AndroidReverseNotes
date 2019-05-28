package com.google.android.exoplayer2.f.a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends d {
    private static final int[] Pc = new int[]{-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] blo = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] blp = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] blq = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, d.MIC_PTU_MEISHI, 93, d.MIC_PTU_LENGMEIREN, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, d.MIC_ALPHA_ADJUST_REAL, 118, d.MIC_AVROUND_BLUR, 120, 121, 122, 231, 247, 209, d.MIC_PTU_QINGCONG, 9632};
    private static final int[] blr = new int[]{ErrorCode.NEEDDOWNLOAD_FALSE_4, ErrorCode.NEEDDOWNLOAD_FALSE_6, 189, 191, 8482, ErrorCode.STARTDOWNLOAD_3, ErrorCode.STARTDOWNLOAD_4, 9834, 224, 32, 232, 226, d.MIC_PTU_FENGJING, d.MIC_PTU_SHIGUANG, 244, 251};
    private static final int[] bls = new int[]{JsApiChooseMedia.CTRL_INDEX, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, az.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, 199, 200, 202, 203, d.MIC_PTU_AUTOLEVEL, 206, 207, d.MIC_PTU_SHISHANG2, 212, 217, 249, 219, ErrorCode.NEEDDOWNLOAD_FALSE_1, 187};
    private static final int[] blt = new int[]{JsApiChooseWeChatContact.CTRL_INDEX, 227, 205, 204, 236, 210, 242, 213, d.MIC_PTU_ZIPAI_LIGHTWHITE, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, d.MIC_PTU_ZIPAI_FAIRYTALE, 223, ErrorCode.STARTDOWNLOAD_6, ErrorCode.STARTDOWNLOAD_5, 9474, 197, 229, 216, d.MIC_PTU_ZIPAI_THURSDAY, 9484, 9488, 9492, 9496};
    private List<com.google.android.exoplayer2.f.a> blA;
    private int blB;
    private int blC;
    private boolean blD;
    private byte blE;
    private byte blF;
    private final l blu = new l();
    private final int blv;
    private final int blw;
    private final LinkedList<a> blx = new LinkedList();
    private a bly = new a(0, 4);
    private List<com.google.android.exoplayer2.f.a> blz;

    static class a {
        int aLM;
        private int blB;
        private int blC;
        private final List<CharacterStyle> blG = new ArrayList();
        private final List<a> blH = new ArrayList();
        private final List<SpannableString> blI = new LinkedList();
        final SpannableStringBuilder blJ = new SpannableStringBuilder();
        int blK;
        int blL;
        int row;

        static class a {
            public final CharacterStyle blM;
            public final int blN;
            public final int start;

            public a(CharacterStyle characterStyle, int i, int i2) {
                this.blM = characterStyle;
                this.start = i;
                this.blN = i2;
            }
        }

        public a(int i, int i2) {
            AppMethodBeat.i(95559);
            reset(i, i2);
            AppMethodBeat.o(95559);
        }

        public final void reset(int i, int i2) {
            AppMethodBeat.i(95560);
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
            AppMethodBeat.o(95560);
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(95561);
            if (this.blG.isEmpty() && this.blH.isEmpty() && this.blI.isEmpty() && this.blJ.length() == 0) {
                AppMethodBeat.o(95561);
                return true;
            }
            AppMethodBeat.o(95561);
            return false;
        }

        public final void sR() {
            AppMethodBeat.i(95562);
            int length = this.blJ.length();
            if (length > 0) {
                this.blJ.delete(length - 1, length);
            }
            AppMethodBeat.o(95562);
        }

        public final void sS() {
            AppMethodBeat.i(95563);
            this.blI.add(sT());
            this.blJ.clear();
            this.blG.clear();
            this.blH.clear();
            this.blL = -1;
            int min = Math.min(this.blC, this.row);
            while (this.blI.size() >= min) {
                this.blI.remove(0);
            }
            AppMethodBeat.o(95563);
        }

        public final void a(CharacterStyle characterStyle) {
            AppMethodBeat.i(95564);
            this.blG.add(characterStyle);
            AppMethodBeat.o(95564);
        }

        public final void a(CharacterStyle characterStyle, int i) {
            AppMethodBeat.i(95565);
            this.blH.add(new a(characterStyle, this.blJ.length(), i));
            AppMethodBeat.o(95565);
        }

        public final void append(char c) {
            AppMethodBeat.i(95566);
            this.blJ.append(c);
            AppMethodBeat.o(95566);
        }

        private SpannableString sT() {
            int i = 0;
            AppMethodBeat.i(95567);
            int length = this.blJ.length();
            for (int i2 = 0; i2 < this.blG.size(); i2++) {
                this.blJ.setSpan(this.blG.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.blH.size()) {
                    break;
                }
                a aVar = (a) this.blH.get(i3);
                if (i3 < this.blH.size() - aVar.blN) {
                    i = ((a) this.blH.get(aVar.blN + i3)).start;
                } else {
                    i = length;
                }
                this.blJ.setSpan(aVar.blM, aVar.start, i, 33);
                i = i3 + 1;
            }
            if (this.blL != -1) {
                this.blJ.setSpan(new UnderlineSpan(), this.blL, length, 33);
            }
            SpannableString spannableString = new SpannableString(this.blJ);
            AppMethodBeat.o(95567);
            return spannableString;
        }

        public final com.google.android.exoplayer2.f.a sU() {
            int i;
            int i2 = 2;
            AppMethodBeat.i(95568);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (i = 0; i < this.blI.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.blI.get(i));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(sT());
            if (spannableStringBuilder.length() == 0) {
                AppMethodBeat.o(95568);
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
            com.google.android.exoplayer2.f.a aVar = new com.google.android.exoplayer2.f.a(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i4, 1, i2, f, i3, Float.MIN_VALUE);
            AppMethodBeat.o(95568);
            return aVar;
        }

        public final String toString() {
            AppMethodBeat.i(95569);
            String spannableStringBuilder = this.blJ.toString();
            AppMethodBeat.o(95569);
            return spannableStringBuilder;
        }
    }

    public final /* bridge */ /* synthetic */ void ai(long j) {
        AppMethodBeat.i(95580);
        super.ai(j);
        AppMethodBeat.o(95580);
    }

    public final /* bridge */ /* synthetic */ i sP() {
        AppMethodBeat.i(95577);
        i sP = super.qJ();
        AppMethodBeat.o(95577);
        return sP;
    }

    public final /* bridge */ /* synthetic */ h sQ() {
        AppMethodBeat.i(95579);
        h sQ = super.qI();
        AppMethodBeat.o(95579);
        return sQ;
    }

    public a(String str, int i) {
        AppMethodBeat.i(95570);
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
        eu(0);
        sO();
        AppMethodBeat.o(95570);
    }

    public final void flush() {
        AppMethodBeat.i(95571);
        super.flush();
        this.blz = null;
        this.blA = null;
        eu(0);
        sO();
        this.blC = 4;
        this.blD = false;
        this.blE = (byte) 0;
        this.blF = (byte) 0;
        AppMethodBeat.o(95571);
    }

    public final void release() {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean sL() {
        return this.blz != this.blA;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.google.android.exoplayer2.f.d sM() {
        AppMethodBeat.i(95572);
        this.blA = this.blz;
        f fVar = new f(this.blz);
        AppMethodBeat.o(95572);
        return fVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(h hVar) {
        AppMethodBeat.i(95573);
        this.blu.n(hVar.aEY.array(), hVar.aEY.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.blu.tB() >= this.blv) {
            int i;
            if (this.blv == 2) {
                i = -4;
            } else {
                i = (byte) this.blu.readUnsignedByte();
            }
            byte readUnsignedByte = (byte) (this.blu.readUnsignedByte() & d.MIC_SketchMark);
            byte readUnsignedByte2 = (byte) (this.blu.readUnsignedByte() & d.MIC_SketchMark);
            if ((i & 6) == 4 && ((this.blw != 1 || (i & 1) == 0) && ((this.blw != 2 || (i & 1) == 1) && !(readUnsignedByte == (byte) 0 && readUnsignedByte2 == (byte) 0)))) {
                if ((readUnsignedByte & 247) == 17 && (readUnsignedByte2 & 240) == 48) {
                    this.bly.append((char) blr[readUnsignedByte2 & 15]);
                    z2 = true;
                } else if ((readUnsignedByte & d.MIC_PTU_ZIPAI_FAIRYTALE) == 18 && (readUnsignedByte2 & 224) == 32) {
                    this.bly.sR();
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
                        if ((readUnsignedByte & 240) == 16 && (readUnsignedByte2 & az.CTRL_INDEX) == 64) {
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
                                            eu(2);
                                            break;
                                        case g.CTRL_INDEX /*37*/:
                                            this.blC = 2;
                                            eu(1);
                                            break;
                                        case (byte) 38:
                                            this.blC = 3;
                                            eu(1);
                                            break;
                                        case (byte) 39:
                                            this.blC = 4;
                                            eu(1);
                                            break;
                                        case (byte) 41:
                                            eu(3);
                                            break;
                                        default:
                                            if (this.blB != 0) {
                                                switch (readUnsignedByte2) {
                                                    case (byte) 33:
                                                        this.bly.sR();
                                                        break;
                                                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                                        this.blz = null;
                                                        if (this.blB == 1 || this.blB == 3) {
                                                            sO();
                                                            break;
                                                        }
                                                    case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                                                        if (this.blB == 1 && !this.bly.isEmpty()) {
                                                            this.bly.sS();
                                                            break;
                                                        }
                                                    case (byte) 46:
                                                        sO();
                                                        break;
                                                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                                                        this.blz = sN();
                                                        sO();
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
                                    this.bly = new a(this.blB, this.blC);
                                    this.blx.add(this.bly);
                                }
                                this.bly.row = i2;
                            }
                            if ((readUnsignedByte2 & 1) == 1) {
                                this.bly.a(new UnderlineSpan());
                            }
                            i2 = (readUnsignedByte2 >> 1) & 15;
                            if (i2 > 7) {
                                this.bly.aLM = blp[i2 & 7];
                            } else if (i2 == 7) {
                                this.bly.a(new StyleSpan(2));
                                this.bly.a(new ForegroundColorSpan(-1));
                            } else {
                                this.bly.a(new ForegroundColorSpan(Pc[i2]));
                            }
                        }
                    } else {
                        z = (readUnsignedByte2 & 1) == 1;
                        a aVar = this.bly;
                        if (z) {
                            aVar.blL = aVar.blJ.length();
                        } else if (aVar.blL != -1) {
                            aVar.blJ.setSpan(new UnderlineSpan(), aVar.blL, aVar.blJ.length(), 33);
                            aVar.blL = -1;
                        }
                        i2 = (readUnsignedByte2 >> 1) & 15;
                        if (i2 == 7) {
                            this.bly.a(new StyleSpan(2), 2);
                            this.bly.a(new ForegroundColorSpan(-1), 1);
                        } else {
                            this.bly.a(new ForegroundColorSpan(Pc[i2]), 1);
                        }
                    }
                    z = z2;
                    z2 = true;
                } else {
                    this.bly.append(b(readUnsignedByte));
                    if ((readUnsignedByte2 & 224) != 0) {
                        this.bly.append(b(readUnsignedByte2));
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
                this.blz = sN();
            }
        }
        AppMethodBeat.o(95573);
    }

    private List<com.google.android.exoplayer2.f.a> sN() {
        AppMethodBeat.i(95574);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.blx.size()) {
                com.google.android.exoplayer2.f.a sU = ((a) this.blx.get(i2)).sU();
                if (sU != null) {
                    arrayList.add(sU);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(95574);
                return arrayList;
            }
        }
    }

    private void eu(int i) {
        AppMethodBeat.i(95575);
        if (this.blB == i) {
            AppMethodBeat.o(95575);
            return;
        }
        int i2 = this.blB;
        this.blB = i;
        sO();
        if (i2 == 3 || i == 1 || i == 0) {
            this.blz = null;
        }
        AppMethodBeat.o(95575);
    }

    private void sO() {
        AppMethodBeat.i(95576);
        this.bly.reset(this.blB, this.blC);
        this.blx.clear();
        this.blx.add(this.bly);
        AppMethodBeat.o(95576);
    }

    private static char b(byte b) {
        return (char) blq[(b & d.MIC_SketchMark) - 32];
    }
}

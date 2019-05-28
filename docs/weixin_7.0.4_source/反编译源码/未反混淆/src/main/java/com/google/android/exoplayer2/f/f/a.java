package com.google.android.exoplayer2.f.f;

import android.support.v4.widget.j;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.List;

public final class a extends b {
    private static final int boh = v.aT("styl");
    private static final int boi = v.aT("tbox");
    private final l boj = new l();
    private boolean bok;
    private int bol;
    private int bom;
    private String bon;
    private float boo;
    private int bop;

    static {
        AppMethodBeat.i(95702);
        AppMethodBeat.o(95702);
    }

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        AppMethodBeat.i(95697);
        if (list != null && list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            boolean z;
            byte[] bArr = (byte[]) list.get(0);
            this.bol = bArr[24];
            this.bom = ((((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16)) | ((bArr[28] & 255) << 8)) | (bArr[29] & 255);
            this.bon = "Serif".equals(new String(bArr, 43, bArr.length + -43)) ? "serif" : "sans-serif";
            this.bop = bArr[25] * 20;
            if ((bArr[0] & 32) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.bok = z;
            if (this.bok) {
                this.boo = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) this.bop);
                this.boo = v.h(this.boo, 0.0f, 0.95f);
                AppMethodBeat.o(95697);
                return;
            }
            this.boo = 0.85f;
            AppMethodBeat.o(95697);
            return;
        }
        this.bol = 0;
        this.bom = -1;
        this.bon = "sans-serif";
        this.bok = false;
        this.boo = 0.85f;
        AppMethodBeat.o(95697);
    }

    public final d c(byte[] bArr, int i, boolean z) {
        String str;
        AppMethodBeat.i(95698);
        this.boj.n(bArr, i);
        l lVar = this.boj;
        assertTrue(lVar.tB() >= 2);
        int readUnsignedShort = lVar.readUnsignedShort();
        if (readUnsignedShort == 0) {
            str = "";
        } else {
            if (lVar.tB() >= 2) {
                char c = (char) (((lVar.data[lVar.position] & 255) << 8) | (lVar.data[lVar.position + 1] & 255));
                if (c == 65279 || c == 65534) {
                    str = lVar.a(readUnsignedShort, Charset.forName("UTF-16"));
                }
            }
            str = lVar.a(readUnsignedShort, Charset.forName("UTF-8"));
        }
        if (str.isEmpty()) {
            b bVar = b.boq;
            AppMethodBeat.o(95698);
            return bVar;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        a(spannableStringBuilder, this.bol, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder, this.bom, -1, 0, spannableStringBuilder.length(), 16711680);
        str = this.bon;
        String str2 = "sans-serif";
        int length = spannableStringBuilder.length();
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f = this.boo;
        while (this.boj.tB() >= 8) {
            float f2;
            int i2 = this.boj.position;
            int readInt = this.boj.readInt();
            int readInt2 = this.boj.readInt();
            if (readInt2 == boh) {
                assertTrue(this.boj.tB() >= 2);
                int readUnsignedShort2 = this.boj.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort2; i3++) {
                    l lVar2 = this.boj;
                    assertTrue(lVar2.tB() >= 12);
                    length = lVar2.readUnsignedShort();
                    int readUnsignedShort3 = lVar2.readUnsignedShort();
                    lVar2.eM(2);
                    readInt2 = lVar2.readUnsignedByte();
                    lVar2.eM(1);
                    int readInt3 = lVar2.readInt();
                    a(spannableStringBuilder, readInt2, this.bol, length, readUnsignedShort3, 0);
                    b(spannableStringBuilder, readInt3, this.bom, length, readUnsignedShort3, 0);
                }
                f2 = f;
            } else if (readInt2 == boi && this.bok) {
                assertTrue(this.boj.tB() >= 2);
                f2 = v.h(((float) this.boj.readUnsignedShort()) / ((float) this.bop), 0.0f, 0.95f);
            } else {
                f2 = f;
            }
            this.boj.setPosition(i2 + readInt);
            f = f2;
        }
        b bVar2 = new b(new com.google.android.exoplayer2.f.a(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, j.INVALID_ID, Float.MIN_VALUE));
        AppMethodBeat.o(95698);
        return bVar2;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        int i6 = 1;
        AppMethodBeat.i(95699);
        if (i != i2) {
            int i7;
            int i8 = i5 | 33;
            int i9 = (i & 1) != 0 ? 1 : 0;
            if ((i & 2) != 0) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            if (i9 != 0) {
                if (i7 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i8);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i8);
                }
            } else if (i7 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i8);
            }
            if ((i & 4) == 0) {
                i6 = 0;
            }
            if (i6 != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i8);
            }
            if (i6 == 0 && i9 == 0 && i7 == 0) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i8);
            }
        }
        AppMethodBeat.o(95699);
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(95700);
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i & 255) << 24) | (i >>> 8)), i3, i4, i5 | 33);
        }
        AppMethodBeat.o(95700);
    }

    private static void assertTrue(boolean z) {
        AppMethodBeat.i(95701);
        if (z) {
            AppMethodBeat.o(95701);
            return;
        }
        f fVar = new f("Unexpected subtitle format.");
        AppMethodBeat.o(95701);
        throw fVar;
    }
}

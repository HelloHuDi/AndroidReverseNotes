package com.google.android.exoplayer2.p105f.p107f;

import android.support.p057v4.widget.C8415j;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p105f.C41607f;
import com.google.android.exoplayer2.p105f.C8672b;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.f.a */
public final class C0856a extends C8672b {
    private static final int boh = C17675v.m27562aT("styl");
    private static final int boi = C17675v.m27562aT("tbox");
    private final C32065l boj = new C32065l();
    private boolean bok;
    private int bol;
    private int bom;
    private String bon;
    private float boo;
    private int bop;

    static {
        AppMethodBeat.m2504i(95702);
        AppMethodBeat.m2505o(95702);
    }

    public C0856a(List<byte[]> list) {
        super("Tx3gDecoder");
        AppMethodBeat.m2504i(95697);
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
                this.boo = C17675v.m27572h(this.boo, 0.0f, 0.95f);
                AppMethodBeat.m2505o(95697);
                return;
            }
            this.boo = 0.85f;
            AppMethodBeat.m2505o(95697);
            return;
        }
        this.bol = 0;
        this.bom = -1;
        this.bon = "sans-serif";
        this.bok = false;
        this.boo = 0.85f;
        AppMethodBeat.m2505o(95697);
    }

    /* renamed from: c */
    public final C17659d mo2574c(byte[] bArr, int i, boolean z) {
        String str;
        AppMethodBeat.m2504i(95698);
        this.boj.mo52371n(bArr, i);
        C32065l c32065l = this.boj;
        C0856a.assertTrue(c32065l.mo52382tB() >= 2);
        int readUnsignedShort = c32065l.readUnsignedShort();
        if (readUnsignedShort == 0) {
            str = "";
        } else {
            if (c32065l.mo52382tB() >= 2) {
                char c = (char) (((c32065l.data[c32065l.position] & 255) << 8) | (c32065l.data[c32065l.position + 1] & 255));
                if (c == 65279 || c == 65534) {
                    str = c32065l.mo52364a(readUnsignedShort, Charset.forName("UTF-16"));
                }
            }
            str = c32065l.mo52364a(readUnsignedShort, Charset.forName("UTF-8"));
        }
        if (str.isEmpty()) {
            C0857b c0857b = C0857b.boq;
            AppMethodBeat.m2505o(95698);
            return c0857b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        C0856a.m1955a(spannableStringBuilder, this.bol, 0, 0, spannableStringBuilder.length(), 16711680);
        C0856a.m1956b(spannableStringBuilder, this.bom, -1, 0, spannableStringBuilder.length(), 16711680);
        str = this.bon;
        String str2 = "sans-serif";
        int length = spannableStringBuilder.length();
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f = this.boo;
        while (this.boj.mo52382tB() >= 8) {
            float f2;
            int i2 = this.boj.position;
            int readInt = this.boj.readInt();
            int readInt2 = this.boj.readInt();
            if (readInt2 == boh) {
                C0856a.assertTrue(this.boj.mo52382tB() >= 2);
                int readUnsignedShort2 = this.boj.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort2; i3++) {
                    C32065l c32065l2 = this.boj;
                    C0856a.assertTrue(c32065l2.mo52382tB() >= 12);
                    length = c32065l2.readUnsignedShort();
                    int readUnsignedShort3 = c32065l2.readUnsignedShort();
                    c32065l2.mo52369eM(2);
                    readInt2 = c32065l2.readUnsignedByte();
                    c32065l2.mo52369eM(1);
                    int readInt3 = c32065l2.readInt();
                    C0856a.m1955a(spannableStringBuilder, readInt2, this.bol, length, readUnsignedShort3, 0);
                    C0856a.m1956b(spannableStringBuilder, readInt3, this.bom, length, readUnsignedShort3, 0);
                }
                f2 = f;
            } else if (readInt2 == boi && this.bok) {
                C0856a.assertTrue(this.boj.mo52382tB() >= 2);
                f2 = C17675v.m27572h(((float) this.boj.readUnsignedShort()) / ((float) this.bop), 0.0f, 0.95f);
            } else {
                f2 = f;
            }
            this.boj.setPosition(i2 + readInt);
            f = f2;
        }
        C0857b c0857b2 = new C0857b(new C32044a(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, C8415j.INVALID_ID, Float.MIN_VALUE));
        AppMethodBeat.m2505o(95698);
        return c0857b2;
    }

    /* renamed from: a */
    private static void m1955a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        int i6 = 1;
        AppMethodBeat.m2504i(95699);
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
        AppMethodBeat.m2505o(95699);
    }

    /* renamed from: b */
    private static void m1956b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(95700);
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i & 255) << 24) | (i >>> 8)), i3, i4, i5 | 33);
        }
        AppMethodBeat.m2505o(95700);
    }

    private static void assertTrue(boolean z) {
        AppMethodBeat.m2504i(95701);
        if (z) {
            AppMethodBeat.m2505o(95701);
            return;
        }
        C41607f c41607f = new C41607f("Unexpected subtitle format.");
        AppMethodBeat.m2505o(95701);
        throw c41607f;
    }
}

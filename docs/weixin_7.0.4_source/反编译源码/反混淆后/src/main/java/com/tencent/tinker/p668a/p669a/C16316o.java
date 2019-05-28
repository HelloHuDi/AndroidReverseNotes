package com.tencent.tinker.p668a.p669a;

import android.support.p057v4.widget.C8415j;
import com.tencent.tinker.p668a.p669a.p670b.C24423b;
import com.tencent.tinker.p668a.p669a.p670b.C46809a;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.tinker.a.a.o */
public final class C16316o {
    /* renamed from: a */
    public static int m25139a(C46809a c46809a) {
        int readByte;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            readByte = c46809a.readByte() & 255;
            i = ((readByte & C31128d.MIC_SketchMark) << (i3 * 7)) | i;
            i2 <<= 7;
            i3++;
            if ((readByte & 128) != 128 || i3 >= 5) {
            }
        }
        if ((readByte & 128) == 128) {
            throw new C36548j("invalid LEB128 sequence");
        } else if (((i2 >> 1) & i) != 0) {
            return i | i2;
        } else {
            return i;
        }
    }

    /* renamed from: b */
    public static int m25141b(C46809a c46809a) {
        int readByte;
        int i = 0;
        int i2 = 0;
        while (true) {
            readByte = c46809a.readByte() & 255;
            i = ((readByte & C31128d.MIC_SketchMark) << (i2 * 7)) | i;
            i2++;
            if ((readByte & 128) != 128 || i2 >= 5) {
            }
        }
        if ((readByte & 128) != 128) {
            return i;
        }
        throw new C36548j("invalid LEB128 sequence");
    }

    /* renamed from: c */
    public static int m25143c(C46809a c46809a) {
        return C16316o.m25141b(c46809a) - 1;
    }

    /* renamed from: a */
    public static int m25140a(C24423b c24423b, int i) {
        int i2 = 0;
        for (int i3 = i >>> 7; i3 != 0; i3 >>>= 7) {
            c24423b.writeByte((byte) ((i & C31128d.MIC_SketchMark) | 128));
            i2++;
            i = i3;
        }
        c24423b.writeByte((byte) (i & C31128d.MIC_SketchMark));
        return i2 + 1;
    }

    /* renamed from: b */
    public static int m25142b(C24423b c24423b, int i) {
        return C16316o.m25140a(c24423b, i + 1);
    }

    /* renamed from: c */
    public static int m25144c(C24423b c24423b, int i) {
        int i2 = i >> 7;
        int i3 = (C8415j.INVALID_ID & i) == 0 ? 0 : -1;
        int i4 = 0;
        Object obj = 1;
        int i5 = i2;
        while (obj != null) {
            if (i5 == i3 && (i5 & 1) == ((i >> 6) & 1)) {
                obj = null;
            } else {
                obj = 1;
            }
            int i6 = i & C31128d.MIC_SketchMark;
            if (obj != null) {
                i2 = 128;
            } else {
                i2 = 0;
            }
            c24423b.writeByte((byte) (i2 | i6));
            i4++;
            i = i5;
            i5 >>= 7;
        }
        return i4;
    }
}

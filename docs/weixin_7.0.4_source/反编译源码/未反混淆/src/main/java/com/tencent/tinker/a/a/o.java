package com.tencent.tinker.a.a;

import android.support.v4.widget.j;
import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.b.b;
import com.tencent.view.d;

public final class o {
    public static int a(a aVar) {
        int readByte;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            readByte = aVar.readByte() & 255;
            i = ((readByte & d.MIC_SketchMark) << (i3 * 7)) | i;
            i2 <<= 7;
            i3++;
            if ((readByte & 128) != 128 || i3 >= 5) {
            }
        }
        if ((readByte & 128) == 128) {
            throw new j("invalid LEB128 sequence");
        } else if (((i2 >> 1) & i) != 0) {
            return i | i2;
        } else {
            return i;
        }
    }

    public static int b(a aVar) {
        int readByte;
        int i = 0;
        int i2 = 0;
        while (true) {
            readByte = aVar.readByte() & 255;
            i = ((readByte & d.MIC_SketchMark) << (i2 * 7)) | i;
            i2++;
            if ((readByte & 128) != 128 || i2 >= 5) {
            }
        }
        if ((readByte & 128) != 128) {
            return i;
        }
        throw new j("invalid LEB128 sequence");
    }

    public static int c(a aVar) {
        return b(aVar) - 1;
    }

    public static int a(b bVar, int i) {
        int i2 = 0;
        for (int i3 = i >>> 7; i3 != 0; i3 >>>= 7) {
            bVar.writeByte((byte) ((i & d.MIC_SketchMark) | 128));
            i2++;
            i = i3;
        }
        bVar.writeByte((byte) (i & d.MIC_SketchMark));
        return i2 + 1;
    }

    public static int b(b bVar, int i) {
        return a(bVar, i + 1);
    }

    public static int c(b bVar, int i) {
        int i2 = i >> 7;
        int i3 = (j.INVALID_ID & i) == 0 ? 0 : -1;
        int i4 = 0;
        Object obj = 1;
        int i5 = i2;
        while (obj != null) {
            if (i5 == i3 && (i5 & 1) == ((i >> 6) & 1)) {
                obj = null;
            } else {
                obj = 1;
            }
            int i6 = i & d.MIC_SketchMark;
            if (obj != null) {
                i2 = 128;
            } else {
                i2 = 0;
            }
            bVar.writeByte((byte) (i2 | i6));
            i4++;
            i = i5;
            i5 >>= 7;
        }
        return i4;
    }
}

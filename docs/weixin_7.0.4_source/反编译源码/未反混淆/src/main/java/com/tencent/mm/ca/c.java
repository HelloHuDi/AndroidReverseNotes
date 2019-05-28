package com.tencent.mm.ca;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;

public final class c {
    public byte[] mData;
    public SparseArray<a> xuC;

    static class a {
        public final int xuD;
        public final int[] xuE;
        public final int[] xuF;

        public a(int i, int[] iArr, int[] iArr2) {
            this.xuD = i;
            this.xuE = iArr;
            this.xuF = iArr2;
        }
    }

    private c(SparseArray<a> sparseArray, byte[] bArr) {
        this.xuC = sparseArray;
        this.mData = bArr;
    }

    public static c a(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        AppMethodBeat.i(105910);
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                ab.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            c cVar = new c(sparseArray, bArr);
            AppMethodBeat.o(105910);
            return cVar;
        } catch (IOException e) {
            ab.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", bo.l(e));
            AppMethodBeat.o(105910);
            return null;
        }
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        Throwable e;
        AppMethodBeat.i(105911);
        String str;
        try {
            int indexOfKey = this.xuC.indexOfKey(i);
            if (indexOfKey < 0) {
                AppMethodBeat.o(105911);
                return null;
            }
            a aVar = (a) this.xuC.valueAt(indexOfKey);
            int length = aVar.xuE.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5;
                if (aVar.xuE[i3] == i2) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
            }
            if (indexOfKey <= this.xuC.size() - 1) {
                if (i4 >= length - 1) {
                    str = new String(this.mData, aVar.xuF[i4], ((a) this.xuC.valueAt(indexOfKey + 1)).xuF[0] - aVar.xuF[i4]);
                } else {
                    str = new String(this.mData, aVar.xuF[i4], aVar.xuF[i4 + 1] - aVar.xuF[i4]);
                }
            } else if (i4 >= length - 1) {
                str = new String(this.mData, aVar.xuF[i4], this.mData.length - aVar.xuF[i4]);
            } else {
                str = new String(this.mData, aVar.xuF[i4], aVar.xuF[i4 + 1] - aVar.xuF[i4]);
            }
            try {
                if (bo.isNullOrNil(str) || objArr != null) {
                    str = String.format(str, objArr);
                }
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", bo.l(e));
                AppMethodBeat.o(105911);
                return str;
            }
            AppMethodBeat.o(105911);
            return str;
        } catch (Exception e3) {
            e = e3;
            str = null;
        }
    }
}

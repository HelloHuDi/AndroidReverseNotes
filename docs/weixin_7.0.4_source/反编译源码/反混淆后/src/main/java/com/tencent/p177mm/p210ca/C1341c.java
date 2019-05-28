package com.tencent.p177mm.p210ca;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.ca.c */
public final class C1341c {
    public byte[] mData;
    public SparseArray<C1340a> xuC;

    /* renamed from: com.tencent.mm.ca.c$a */
    static class C1340a {
        public final int xuD;
        public final int[] xuE;
        public final int[] xuF;

        public C1340a(int i, int[] iArr, int[] iArr2) {
            this.xuD = i;
            this.xuE = iArr;
            this.xuF = iArr2;
        }
    }

    private C1341c(SparseArray<C1340a> sparseArray, byte[] bArr) {
        this.xuC = sparseArray;
        this.mData = bArr;
    }

    /* renamed from: a */
    public static C1341c m2875a(SparseArray<C1340a> sparseArray, InputStream inputStream, int i) {
        AppMethodBeat.m2504i(105910);
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                C4990ab.m7412e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            C1341c c1341c = new C1341c(sparseArray, bArr);
            AppMethodBeat.m2505o(105910);
            return c1341c;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(105910);
            return null;
        }
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        Throwable e;
        AppMethodBeat.m2504i(105911);
        String str;
        try {
            int indexOfKey = this.xuC.indexOfKey(i);
            if (indexOfKey < 0) {
                AppMethodBeat.m2505o(105911);
                return null;
            }
            C1340a c1340a = (C1340a) this.xuC.valueAt(indexOfKey);
            int length = c1340a.xuE.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5;
                if (c1340a.xuE[i3] == i2) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
            }
            if (indexOfKey <= this.xuC.size() - 1) {
                if (i4 >= length - 1) {
                    str = new String(this.mData, c1340a.xuF[i4], ((C1340a) this.xuC.valueAt(indexOfKey + 1)).xuF[0] - c1340a.xuF[i4]);
                } else {
                    str = new String(this.mData, c1340a.xuF[i4], c1340a.xuF[i4 + 1] - c1340a.xuF[i4]);
                }
            } else if (i4 >= length - 1) {
                str = new String(this.mData, c1340a.xuF[i4], this.mData.length - c1340a.xuF[i4]);
            } else {
                str = new String(this.mData, c1340a.xuF[i4], c1340a.xuF[i4 + 1] - c1340a.xuF[i4]);
            }
            try {
                if (C5046bo.isNullOrNil(str) || objArr != null) {
                    str = String.format(str, objArr);
                }
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(105911);
                return str;
            }
            AppMethodBeat.m2505o(105911);
            return str;
        } catch (Exception e3) {
            e = e3;
            str = null;
        }
    }
}

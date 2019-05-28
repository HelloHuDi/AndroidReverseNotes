package com.tencent.p177mm.p210ca;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.ca.e */
public final class C1343e {
    public byte[] mData;
    public SparseArray<C1342a> xuH;

    /* renamed from: com.tencent.mm.ca.e$a */
    static class C1342a {
        public final int resId;
        public final int[] xuI;

        public C1342a(int i, int[] iArr) {
            this.resId = i;
            this.xuI = iArr;
        }
    }

    private C1343e(SparseArray<C1342a> sparseArray, byte[] bArr) {
        this.xuH = sparseArray;
        this.mData = bArr;
    }

    /* renamed from: b */
    public static C1343e m2876b(SparseArray<C1342a> sparseArray, InputStream inputStream, int i) {
        AppMethodBeat.m2504i(105918);
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                C4990ab.m7412e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            C1343e c1343e = new C1343e(sparseArray, bArr);
            AppMethodBeat.m2505o(105918);
            return c1343e;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(105918);
            return null;
        }
    }
}

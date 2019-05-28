package com.tencent.mm.ca;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    public byte[] mData;
    public SparseArray<a> xuH;

    static class a {
        public final int resId;
        public final int[] xuI;

        public a(int i, int[] iArr) {
            this.resId = i;
            this.xuI = iArr;
        }
    }

    private e(SparseArray<a> sparseArray, byte[] bArr) {
        this.xuH = sparseArray;
        this.mData = bArr;
    }

    public static e b(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        AppMethodBeat.i(105918);
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                ab.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            e eVar = new e(sparseArray, bArr);
            AppMethodBeat.o(105918);
            return eVar;
        } catch (IOException e) {
            ab.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", bo.l(e));
            AppMethodBeat.o(105918);
            return null;
        }
    }
}

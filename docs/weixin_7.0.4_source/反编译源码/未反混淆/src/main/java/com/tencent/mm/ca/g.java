package com.tencent.mm.ca;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class g {
    SparseIntArray xuS;
    byte[] xuT;

    private g(SparseIntArray sparseIntArray, byte[] bArr) {
        this.xuS = sparseIntArray;
        this.xuT = bArr;
    }

    public static g a(SparseIntArray sparseIntArray, InputStream inputStream, int i) {
        AppMethodBeat.i(105934);
        byte[] bArr = new byte[i];
        try {
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                ab.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
            }
            g gVar = new g(sparseIntArray, bArr);
            AppMethodBeat.o(105934);
            return gVar;
        } catch (IOException e) {
            ab.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", bo.l(e));
            AppMethodBeat.o(105934);
            return null;
        }
    }

    public final String getString(int i) {
        AppMethodBeat.i(105935);
        String str;
        try {
            int indexOfKey = this.xuS.indexOfKey(i);
            if (indexOfKey < 0) {
                AppMethodBeat.o(105935);
                return null;
            }
            int valueAt;
            int valueAt2 = this.xuS.valueAt(indexOfKey);
            if (indexOfKey < this.xuS.size() - 1) {
                valueAt = this.xuS.valueAt(indexOfKey + 1) - valueAt2;
            } else {
                valueAt = this.xuT.length - valueAt2;
            }
            str = new String(this.xuT, valueAt2, valueAt, "UTF-8");
            AppMethodBeat.o(105935);
            return str;
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bo.l(e));
            str = null;
        } catch (Exception e2) {
            ab.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bo.l(e2));
            str = null;
        }
    }
}

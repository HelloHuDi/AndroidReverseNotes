package com.tencent.p177mm.p210ca;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.mm.ca.g */
public final class C1345g {
    SparseIntArray xuS;
    byte[] xuT;

    private C1345g(SparseIntArray sparseIntArray, byte[] bArr) {
        this.xuS = sparseIntArray;
        this.xuT = bArr;
    }

    /* renamed from: a */
    public static C1345g m2883a(SparseIntArray sparseIntArray, InputStream inputStream, int i) {
        AppMethodBeat.m2504i(105934);
        byte[] bArr = new byte[i];
        try {
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                C4990ab.m7412e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
            }
            C1345g c1345g = new C1345g(sparseIntArray, bArr);
            AppMethodBeat.m2505o(105934);
            return c1345g;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(105934);
            return null;
        }
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(105935);
        String str;
        try {
            int indexOfKey = this.xuS.indexOfKey(i);
            if (indexOfKey < 0) {
                AppMethodBeat.m2505o(105935);
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
            AppMethodBeat.m2505o(105935);
            return str;
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7413e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", C5046bo.m7574l(e));
            str = null;
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", C5046bo.m7574l(e2));
            str = null;
        }
    }
}

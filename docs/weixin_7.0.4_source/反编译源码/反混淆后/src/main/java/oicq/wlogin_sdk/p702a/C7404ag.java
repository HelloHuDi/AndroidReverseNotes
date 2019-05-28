package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19281ab;
import oicq.wlogin_sdk.tools.C6119d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.ag */
public final class C7404ag extends C6106a {
    public int BVO;

    public C7404ag() {
        this.BVO = 0;
        this.BUz = C19281ab.CTRL_INDEX;
    }

    /* renamed from: a */
    public final byte[] mo16218a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int length;
        int i;
        AppMethodBeat.m2504i(96474);
        if (bArr != null) {
            length = bArr.length + 0;
            i = 1;
        } else {
            i = 0;
            length = 0;
        }
        if (bArr2 != null) {
            length += bArr2.length;
            i++;
        }
        if (bArr3 != null) {
            length += bArr3.length;
            i++;
        }
        if (bArr4 != null) {
            length += bArr4.length;
            i++;
        }
        byte[] bArr6 = new byte[(length + 2)];
        C6120util.m9654N(bArr6, 0, i);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr6, 2, bArr.length);
            i = bArr.length + 2;
        } else {
            i = 2;
        }
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr6, i, bArr2.length);
            i += bArr2.length;
        }
        if (bArr3 != null) {
            System.arraycopy(bArr3, 0, bArr6, i, bArr3.length);
            i += bArr3.length;
        }
        if (bArr4 != null) {
            System.arraycopy(bArr4, 0, bArr6, i, bArr4.length);
        }
        byte[] a = C6119d.m9652a(bArr6, bArr6.length, bArr5);
        this.BVO = a.length;
        super.mo13502Vj(this.BUz);
        super.mo13503ac(a, a.length);
        super.emG();
        a = super.emC();
        AppMethodBeat.m2505o(96474);
        return a;
    }
}

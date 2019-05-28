package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.p702a.C7412ao;
import oicq.wlogin_sdk.p702a.C7418f;
import oicq.wlogin_sdk.p702a.C7419g;

/* renamed from: oicq.wlogin_sdk.request.g */
public final class C7441g extends C6111d {
    public C7441g(C6112i c6112i) {
        this.BUz = 2064;
        this.BUA = 2;
        this.BUC = c6112i;
    }

    /* renamed from: cF */
    public final byte[] mo16232cF(byte[] bArr) {
        int length;
        int i;
        AppMethodBeat.m2504i(96426);
        int i2 = this.BUC.BUM;
        byte[] emF = this.BUC.BUH.emF();
        C7419g c7419g = this.BUC.BUI;
        byte[] bArr2 = new byte[c7419g.BVu];
        if (c7419g.BVu > 0) {
            System.arraycopy(c7419g.BUt, c7419g.BVw, bArr2, 0, c7419g.BVu);
        }
        C7418f c7418f = new C7418f();
        C7412ao c7412ao = new C7412ao();
        byte[] cG = c7418f.mo16225cG(emF);
        byte[] q = c7412ao.mo16222q(bArr, bArr2);
        byte[] bArr3 = new byte[(cG.length + q.length)];
        if (emF.length > 0) {
            System.arraycopy(cG, 0, bArr3, 0, cG.length);
            length = cG.length + 0;
            i = 1;
        } else {
            length = 0;
            i = 0;
        }
        System.arraycopy(q, 0, bArr3, length, q.length);
        mo13524a(this.BUu, this.BUz, this.BUC._uin, this.BUw, this.BUx, i2, this.BUy, super.mo13521G(bArr3, this.BUA, i + 1));
        bArr2 = super.emC();
        AppMethodBeat.m2505o(96426);
        return bArr2;
    }
}

package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g extends d {
    public g(i iVar) {
        this.BUz = 2064;
        this.BUA = 2;
        this.BUC = iVar;
    }

    public final byte[] cF(byte[] bArr) {
        int length;
        int i;
        AppMethodBeat.i(96426);
        int i2 = this.BUC.BUM;
        byte[] emF = this.BUC.BUH.emF();
        oicq.wlogin_sdk.a.g gVar = this.BUC.BUI;
        byte[] bArr2 = new byte[gVar.BVu];
        if (gVar.BVu > 0) {
            System.arraycopy(gVar.BUt, gVar.BVw, bArr2, 0, gVar.BVu);
        }
        f fVar = new f();
        ao aoVar = new ao();
        byte[] cG = fVar.cG(emF);
        byte[] q = aoVar.q(bArr, bArr2);
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
        a(this.BUu, this.BUz, this.BUC._uin, this.BUw, this.BUx, i2, this.BUy, super.G(bArr3, this.BUA, i + 1));
        bArr2 = super.emC();
        AppMethodBeat.o(96426);
        return bArr2;
    }
}

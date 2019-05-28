package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h extends d {
    public h(i iVar) {
        this.BUz = 2064;
        this.BUA = 3;
        this.BUC = iVar;
    }

    public final int I(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(96437);
        f fVar = new f();
        g gVar = new g();
        int ab = super.ab(bArr, i + 2);
        super.emD();
        int i3 = i + 5;
        switch (ab) {
            case 2:
                int L = fVar.L(bArr, i3, this.BUo - i3);
                if (L >= 0) {
                    this.BUC.BUH = fVar;
                    L = gVar.L(bArr, i3, this.BUo - i3);
                    if (L >= 0) {
                        this.BUC.BUI = gVar;
                        break;
                    }
                }
                ab = L;
                break;
            case 5:
                super.H(bArr, i3, (this.BUo - i3) - 1);
                break;
            default:
                H(bArr, i3, (this.BUo - i3) - 1);
                break;
        }
        AppMethodBeat.o(96437);
        return ab;
    }
}

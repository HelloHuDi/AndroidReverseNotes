package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.p702a.C7418f;
import oicq.wlogin_sdk.p702a.C7419g;

/* renamed from: oicq.wlogin_sdk.request.h */
public final class C7442h extends C6111d {
    public C7442h(C6112i c6112i) {
        this.BUz = 2064;
        this.BUA = 3;
        this.BUC = c6112i;
    }

    /* renamed from: I */
    public final int mo13523I(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(96437);
        C7418f c7418f = new C7418f();
        C7419g c7419g = new C7419g();
        int ab = super.mo13526ab(bArr, i + 2);
        super.emD();
        int i3 = i + 5;
        switch (ab) {
            case 2:
                int L = c7418f.mo13501L(bArr, i3, this.BUo - i3);
                if (L >= 0) {
                    this.BUC.BUH = c7418f;
                    L = c7419g.mo13501L(bArr, i3, this.BUo - i3);
                    if (L >= 0) {
                        this.BUC.BUI = c7419g;
                        break;
                    }
                }
                ab = L;
                break;
            case 5:
                super.mo13522H(bArr, i3, (this.BUo - i3) - 1);
                break;
            default:
                mo13522H(bArr, i3, (this.BUo - i3) - 1);
                break;
        }
        AppMethodBeat.m2505o(96437);
        return ab;
    }
}

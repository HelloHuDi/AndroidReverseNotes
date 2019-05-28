package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a {
    public int BUn = 128;
    public int BUo = 0;
    public byte[] BUt = new byte[this.BUn];
    public int BUz = 0;
    int BVh = 0;
    public int BVi = 4;
    public int BVj = 0;

    public a() {
        AppMethodBeat.i(96481);
        AppMethodBeat.o(96481);
    }

    public final byte[] emC() {
        AppMethodBeat.i(96482);
        byte[] bArr = new byte[this.BUo];
        System.arraycopy(this.BUt, 0, bArr, 0, this.BUo);
        AppMethodBeat.o(96482);
        return bArr;
    }

    public final byte[] emF() {
        AppMethodBeat.i(96483);
        byte[] bArr = new byte[this.BVj];
        System.arraycopy(this.BUt, this.BVi, bArr, 0, this.BVj);
        AppMethodBeat.o(96483);
        return bArr;
    }

    private void J(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(96484);
        if (i2 > this.BUn) {
            this.BUn = i2 + 128;
            this.BUt = new byte[this.BUn];
        }
        this.BUo = i2;
        System.arraycopy(bArr, i, this.BUt, 0, i2);
        this.BUz = util.af(bArr, i);
        this.BVj = i2 - this.BVi;
        AppMethodBeat.o(96484);
    }

    public final void Vj(int i) {
        AppMethodBeat.i(96485);
        util.N(this.BUt, this.BUo, i);
        this.BUo += 2;
        util.N(this.BUt, this.BUo, 0);
        this.BUo += 2;
        AppMethodBeat.o(96485);
    }

    public final void emG() {
        AppMethodBeat.i(96486);
        util.N(this.BUt, 2, this.BUo - this.BVi);
        AppMethodBeat.o(96486);
    }

    public final void ac(byte[] bArr, int i) {
        AppMethodBeat.i(96487);
        if (i > this.BUn - this.BVi) {
            this.BUn = (this.BVi + i) + 64;
            byte[] bArr2 = new byte[this.BUn];
            System.arraycopy(this.BUt, 0, bArr2, 0, this.BUo);
            this.BUt = bArr2;
        }
        this.BVj = i;
        System.arraycopy(bArr, 0, this.BUt, this.BUo, i);
        this.BUo += i;
        AppMethodBeat.o(96487);
    }

    private static int K(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(96488);
        int length = bArr.length;
        int i3 = i;
        while (i3 < length && i3 + 2 <= length) {
            if (util.af(bArr, i3) == i2) {
                break;
            }
            i3 += 2;
            if (i3 + 2 > length) {
                break;
            }
            i3 += util.af(bArr, i3) + 2;
        }
        i3 = -1;
        AppMethodBeat.o(96488);
        return i3;
    }

    public final int L(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(96489);
        int K = K(bArr, i, this.BUz);
        if (K < 0) {
            AppMethodBeat.o(96489);
            return -1;
        }
        int i3 = i2 - (K - i);
        if (this.BVi >= i3) {
            AppMethodBeat.o(96489);
            return -1;
        }
        this.BVj = util.af(bArr, K + 2);
        if (this.BVi + this.BVj > i3) {
            AppMethodBeat.o(96489);
            return -1;
        }
        J(bArr, K, this.BVi + this.BVj);
        if (emH().booleanValue()) {
            int i4 = (this.BVi + K) + this.BVj;
            AppMethodBeat.o(96489);
            return i4;
        }
        AppMethodBeat.o(96489);
        return -1005;
    }

    private int d(byte[] bArr, int i, byte[] bArr2) {
        AppMethodBeat.i(96490);
        if (this.BVi >= i) {
            AppMethodBeat.o(96490);
            return -1;
        }
        this.BVj = util.af(bArr, 2);
        if (this.BVi + this.BVj > i) {
            AppMethodBeat.o(96490);
            return -1;
        }
        byte[] decrypt = d.decrypt(bArr, this.BVi, this.BVj, bArr2);
        if (decrypt == null) {
            AppMethodBeat.o(96490);
            return -1015;
        }
        if (this.BVi + decrypt.length > this.BUn) {
            this.BUn = this.BVi + decrypt.length;
            this.BUt = new byte[this.BUn];
        }
        this.BUo = 0;
        System.arraycopy(bArr, 0, this.BUt, 0, this.BVi);
        this.BUo += this.BVi;
        System.arraycopy(decrypt, 0, this.BUt, this.BUo, decrypt.length);
        this.BUo += decrypt.length;
        this.BVj = decrypt.length;
        if (emH().booleanValue()) {
            AppMethodBeat.o(96490);
            return 0;
        }
        AppMethodBeat.o(96490);
        return -1005;
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2) {
        AppMethodBeat.i(96491);
        int K = K(bArr, i, this.BUz);
        if (K < 0) {
            AppMethodBeat.o(96491);
            return -1;
        }
        int i3 = i2 - (K - i);
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, K, bArr3, 0, i3);
        K = d(bArr3, i3, bArr2);
        AppMethodBeat.o(96491);
        return K;
    }

    public Boolean emH() {
        return Boolean.TRUE;
    }
}

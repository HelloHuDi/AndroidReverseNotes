package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6119d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.a */
public class C6106a {
    public int BUn = 128;
    public int BUo = 0;
    public byte[] BUt = new byte[this.BUn];
    public int BUz = 0;
    int BVh = 0;
    public int BVi = 4;
    public int BVj = 0;

    public C6106a() {
        AppMethodBeat.m2504i(96481);
        AppMethodBeat.m2505o(96481);
    }

    public final byte[] emC() {
        AppMethodBeat.m2504i(96482);
        byte[] bArr = new byte[this.BUo];
        System.arraycopy(this.BUt, 0, bArr, 0, this.BUo);
        AppMethodBeat.m2505o(96482);
        return bArr;
    }

    public final byte[] emF() {
        AppMethodBeat.m2504i(96483);
        byte[] bArr = new byte[this.BVj];
        System.arraycopy(this.BUt, this.BVi, bArr, 0, this.BVj);
        AppMethodBeat.m2505o(96483);
        return bArr;
    }

    /* renamed from: J */
    private void m9611J(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(96484);
        if (i2 > this.BUn) {
            this.BUn = i2 + 128;
            this.BUt = new byte[this.BUn];
        }
        this.BUo = i2;
        System.arraycopy(bArr, i, this.BUt, 0, i2);
        this.BUz = C6120util.m9659af(bArr, i);
        this.BVj = i2 - this.BVi;
        AppMethodBeat.m2505o(96484);
    }

    /* renamed from: Vj */
    public final void mo13502Vj(int i) {
        AppMethodBeat.m2504i(96485);
        C6120util.m9654N(this.BUt, this.BUo, i);
        this.BUo += 2;
        C6120util.m9654N(this.BUt, this.BUo, 0);
        this.BUo += 2;
        AppMethodBeat.m2505o(96485);
    }

    public final void emG() {
        AppMethodBeat.m2504i(96486);
        C6120util.m9654N(this.BUt, 2, this.BUo - this.BVi);
        AppMethodBeat.m2505o(96486);
    }

    /* renamed from: ac */
    public final void mo13503ac(byte[] bArr, int i) {
        AppMethodBeat.m2504i(96487);
        if (i > this.BUn - this.BVi) {
            this.BUn = (this.BVi + i) + 64;
            byte[] bArr2 = new byte[this.BUn];
            System.arraycopy(this.BUt, 0, bArr2, 0, this.BUo);
            this.BUt = bArr2;
        }
        this.BVj = i;
        System.arraycopy(bArr, 0, this.BUt, this.BUo, i);
        this.BUo += i;
        AppMethodBeat.m2505o(96487);
    }

    /* renamed from: K */
    private static int m9612K(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(96488);
        int length = bArr.length;
        int i3 = i;
        while (i3 < length && i3 + 2 <= length) {
            if (C6120util.m9659af(bArr, i3) == i2) {
                break;
            }
            i3 += 2;
            if (i3 + 2 > length) {
                break;
            }
            i3 += C6120util.m9659af(bArr, i3) + 2;
        }
        i3 = -1;
        AppMethodBeat.m2505o(96488);
        return i3;
    }

    /* renamed from: L */
    public final int mo13501L(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(96489);
        int K = C6106a.m9612K(bArr, i, this.BUz);
        if (K < 0) {
            AppMethodBeat.m2505o(96489);
            return -1;
        }
        int i3 = i2 - (K - i);
        if (this.BVi >= i3) {
            AppMethodBeat.m2505o(96489);
            return -1;
        }
        this.BVj = C6120util.m9659af(bArr, K + 2);
        if (this.BVi + this.BVj > i3) {
            AppMethodBeat.m2505o(96489);
            return -1;
        }
        m9611J(bArr, K, this.BVi + this.BVj);
        if (emH().booleanValue()) {
            int i4 = (this.BVi + K) + this.BVj;
            AppMethodBeat.m2505o(96489);
            return i4;
        }
        AppMethodBeat.m2505o(96489);
        return -1005;
    }

    /* renamed from: d */
    private int m9613d(byte[] bArr, int i, byte[] bArr2) {
        AppMethodBeat.m2504i(96490);
        if (this.BVi >= i) {
            AppMethodBeat.m2505o(96490);
            return -1;
        }
        this.BVj = C6120util.m9659af(bArr, 2);
        if (this.BVi + this.BVj > i) {
            AppMethodBeat.m2505o(96490);
            return -1;
        }
        byte[] decrypt = C6119d.decrypt(bArr, this.BVi, this.BVj, bArr2);
        if (decrypt == null) {
            AppMethodBeat.m2505o(96490);
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
            AppMethodBeat.m2505o(96490);
            return 0;
        }
        AppMethodBeat.m2505o(96490);
        return -1005;
    }

    /* renamed from: b */
    public final int mo13504b(byte[] bArr, int i, int i2, byte[] bArr2) {
        AppMethodBeat.m2504i(96491);
        int K = C6106a.m9612K(bArr, i, this.BUz);
        if (K < 0) {
            AppMethodBeat.m2505o(96491);
            return -1;
        }
        int i3 = i2 - (K - i);
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, K, bArr3, 0, i3);
        K = m9613d(bArr3, i3, bArr2);
        AppMethodBeat.m2505o(96491);
        return K;
    }

    public Boolean emH() {
        return Boolean.TRUE;
    }
}

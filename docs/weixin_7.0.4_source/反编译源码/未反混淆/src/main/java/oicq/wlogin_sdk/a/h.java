package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.util;

public final class h extends a {
    int BVx;
    int BVy;
    int BVz;

    public h() {
        AppMethodBeat.i(96496);
        this.BVx = 1;
        this.BVy = 1;
        this.BVz = 69;
        this.BUz = d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM;
        this.BVy = util.BWu;
        if (util.BWu <= 2) {
            this.BVx = 1;
            this.BVz = 69;
            AppMethodBeat.o(96496);
            return;
        }
        this.BVx = 2;
        this.BVz = 90;
        AppMethodBeat.o(96496);
    }

    public final byte[] a(int i, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i2, byte[] bArr5) {
        AppMethodBeat.i(96497);
        byte[] bArr6;
        int length;
        byte[] bArr7;
        if (util.BWu <= 2) {
            bArr6 = new byte[this.BVz];
            util.N(bArr6, 0, this.BVx);
            util.O(bArr6, 2, util.emN());
            util.O(bArr6, 6, this.BVy);
            util.O(bArr6, 10, 522017402);
            util.O(bArr6, 14, i);
            util.c(bArr6, 18, j);
            System.arraycopy(bArr, 0, bArr6, 26, bArr.length);
            length = bArr.length + 26;
            System.arraycopy(bArr2, 0, bArr6, length, bArr2.length);
            length += bArr2.length;
            util.M(bArr6, length, 1);
            length++;
            System.arraycopy(bArr3, 0, bArr6, length, bArr3.length);
            System.arraycopy(bArr4, 0, bArr6, length + bArr3.length, bArr4.length);
            bArr7 = new byte[24];
            System.arraycopy(bArr3, 0, bArr7, 0, bArr3.length);
            util.c(bArr7, 16, j);
            bArr6 = oicq.wlogin_sdk.tools.d.a(bArr6, bArr6.length, c.cM(bArr7));
            this.BVz = bArr6.length;
            super.Vj(this.BUz);
            super.ac(bArr6, this.BVz);
            super.emG();
            bArr6 = super.emC();
            AppMethodBeat.o(96497);
            return bArr6;
        }
        bArr6 = new byte[this.BVz];
        util.N(bArr6, 0, this.BVx);
        util.O(bArr6, 2, util.emN());
        util.O(bArr6, 6, this.BVy);
        util.O(bArr6, 10, 522017402);
        util.O(bArr6, 14, i);
        util.c(bArr6, 18, j);
        System.arraycopy(bArr, 0, bArr6, 26, bArr.length);
        length = bArr.length + 26;
        System.arraycopy(bArr2, 0, bArr6, length, bArr2.length);
        length += bArr2.length;
        util.M(bArr6, length, 1);
        length++;
        System.arraycopy(bArr3, 0, bArr6, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr4, 0, bArr6, length, bArr4.length);
        length += bArr4.length;
        util.O(bArr6, length, 0);
        length += 4;
        util.M(bArr6, length, i2);
        length++;
        if (bArr5 == null || bArr5.length <= 0) {
            bArr7 = new byte[16];
            util.O(bArr7, 0, util.emN());
            util.O(bArr7, 4, util.emN());
            util.O(bArr7, 8, util.emN());
            util.O(bArr7, 12, util.emN());
        } else {
            System.arraycopy(bArr5, 0, bArr6, length, bArr5.length);
        }
        bArr7 = new byte[24];
        System.arraycopy(bArr3, 0, bArr7, 0, bArr3.length);
        util.c(bArr7, 16, j);
        bArr6 = oicq.wlogin_sdk.tools.d.a(bArr6, bArr6.length, c.cM(bArr7));
        this.BVz = bArr6.length;
        super.Vj(this.BUz);
        super.ac(bArr6, this.BVz);
        super.emG();
        bArr6 = emC();
        AppMethodBeat.o(96497);
        return bArr6;
    }
}

package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import oicq.wlogin_sdk.tools.C6118c;
import oicq.wlogin_sdk.tools.C6119d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.h */
public final class C7420h extends C6106a {
    int BVx;
    int BVy;
    int BVz;

    public C7420h() {
        AppMethodBeat.m2504i(96496);
        this.BVx = 1;
        this.BVy = 1;
        this.BVz = 69;
        this.BUz = C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM;
        this.BVy = C6120util.BWu;
        if (C6120util.BWu <= 2) {
            this.BVx = 1;
            this.BVz = 69;
            AppMethodBeat.m2505o(96496);
            return;
        }
        this.BVx = 2;
        this.BVz = 90;
        AppMethodBeat.m2505o(96496);
    }

    /* renamed from: a */
    public final byte[] mo16226a(int i, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i2, byte[] bArr5) {
        AppMethodBeat.m2504i(96497);
        byte[] bArr6;
        int length;
        byte[] bArr7;
        if (C6120util.BWu <= 2) {
            bArr6 = new byte[this.BVz];
            C6120util.m9654N(bArr6, 0, this.BVx);
            C6120util.m9655O(bArr6, 2, C6120util.emN());
            C6120util.m9655O(bArr6, 6, this.BVy);
            C6120util.m9655O(bArr6, 10, 522017402);
            C6120util.m9655O(bArr6, 14, i);
            C6120util.m9662c(bArr6, 18, j);
            System.arraycopy(bArr, 0, bArr6, 26, bArr.length);
            length = bArr.length + 26;
            System.arraycopy(bArr2, 0, bArr6, length, bArr2.length);
            length += bArr2.length;
            C6120util.m9653M(bArr6, length, 1);
            length++;
            System.arraycopy(bArr3, 0, bArr6, length, bArr3.length);
            System.arraycopy(bArr4, 0, bArr6, length + bArr3.length, bArr4.length);
            bArr7 = new byte[24];
            System.arraycopy(bArr3, 0, bArr7, 0, bArr3.length);
            C6120util.m9662c(bArr7, 16, j);
            bArr6 = C6119d.m9652a(bArr6, bArr6.length, C6118c.m9651cM(bArr7));
            this.BVz = bArr6.length;
            super.mo13502Vj(this.BUz);
            super.mo13503ac(bArr6, this.BVz);
            super.emG();
            bArr6 = super.emC();
            AppMethodBeat.m2505o(96497);
            return bArr6;
        }
        bArr6 = new byte[this.BVz];
        C6120util.m9654N(bArr6, 0, this.BVx);
        C6120util.m9655O(bArr6, 2, C6120util.emN());
        C6120util.m9655O(bArr6, 6, this.BVy);
        C6120util.m9655O(bArr6, 10, 522017402);
        C6120util.m9655O(bArr6, 14, i);
        C6120util.m9662c(bArr6, 18, j);
        System.arraycopy(bArr, 0, bArr6, 26, bArr.length);
        length = bArr.length + 26;
        System.arraycopy(bArr2, 0, bArr6, length, bArr2.length);
        length += bArr2.length;
        C6120util.m9653M(bArr6, length, 1);
        length++;
        System.arraycopy(bArr3, 0, bArr6, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr4, 0, bArr6, length, bArr4.length);
        length += bArr4.length;
        C6120util.m9655O(bArr6, length, 0);
        length += 4;
        C6120util.m9653M(bArr6, length, i2);
        length++;
        if (bArr5 == null || bArr5.length <= 0) {
            bArr7 = new byte[16];
            C6120util.m9655O(bArr7, 0, C6120util.emN());
            C6120util.m9655O(bArr7, 4, C6120util.emN());
            C6120util.m9655O(bArr7, 8, C6120util.emN());
            C6120util.m9655O(bArr7, 12, C6120util.emN());
        } else {
            System.arraycopy(bArr5, 0, bArr6, length, bArr5.length);
        }
        bArr7 = new byte[24];
        System.arraycopy(bArr3, 0, bArr7, 0, bArr3.length);
        C6120util.m9662c(bArr7, 16, j);
        bArr6 = C6119d.m9652a(bArr6, bArr6.length, C6118c.m9651cM(bArr7));
        this.BVz = bArr6.length;
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr6, this.BVz);
        super.emG();
        bArr6 = emC();
        AppMethodBeat.m2505o(96497);
        return bArr6;
    }
}

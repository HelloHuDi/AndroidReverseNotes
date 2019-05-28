package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C2971d;
import com.tencent.p177mm.plugin.exdevice.model.C38950ae;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1255e.C20470f;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p952b.C27829e;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.i.f */
public final class C11649f extends C38950ae {
    private C27829e lxA;
    private C27838a lxB;
    private int mErrorCode;

    public C11649f(int i, long j, int i2, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(19734);
        this.lxA = new C27829e(j, i2, i3, bArr);
        this.mErrorCode = i;
        AppMethodBeat.m2505o(19734);
    }

    /* renamed from: a */
    public final boolean mo23404a(C27865m c27865m, C42990d c42990d) {
        AppMethodBeat.m2504i(19735);
        if (!C20548u.bpx().mo45725hX(this.lxA.jJa)) {
            C4990ab.m7413e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", Long.valueOf(this.lxA.jJa));
            this.lxA.mo45699a(-2, "", new byte[0], new byte[0], 0, 0);
            this.lxB = new C27838a(this.lxA, c42990d);
            C4990ab.m7417i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lxB.mo45713b(c27865m)));
            AppMethodBeat.m2505o(19735);
            return this.lxB.mo45713b(c27865m);
        } else if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            C4990ab.m7413e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(this.mErrorCode));
            this.lxA.mo45699a(-1, "", new byte[0], new byte[0], 0, 0);
            this.lxB = new C27838a(this.lxA, c42990d);
            C4990ab.m7417i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lxB.mo45713b(c27865m)));
            AppMethodBeat.m2505o(19735);
            return this.lxB.mo45713b(c27865m);
        } else {
            C20470f c20470f = (C20470f) this.lxA.bou();
            if (c20470f == null) {
                C4990ab.m7412e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.lxA.mo45699a(-4, "", new byte[0], new byte[0], 0, 0);
                this.lxB = new C27838a(this.lxA, c42990d);
                C4990ab.m7417i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lxB.mo45713b(c27865m)));
                AppMethodBeat.m2505o(19735);
                return this.lxB.mo45713b(c27865m);
            }
            byte[] toByteArray;
            byte[] toByteArray2;
            if (c20470f.luW != null) {
                toByteArray = c20470f.luW.toByteArray();
            } else {
                toByteArray = null;
            }
            if (c20470f.luV != null) {
                toByteArray2 = c20470f.luV.toByteArray();
            } else {
                toByteArray2 = null;
            }
            C45891ad.bpd();
            int boE = C2971d.boE();
            switch (boE) {
                case 1:
                case 2:
                    break;
                default:
                    C4990ab.m7413e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", Integer.valueOf(boE));
                    break;
            }
            this.lxA.mo45699a(0, null, toByteArray2, toByteArray, boE, (int) (C42992b.bqi() / 1000));
            this.lxB = new C27838a(this.lxA, c42990d);
            boolean b = this.lxB.mo45713b(c27865m);
            AppMethodBeat.m2505o(19735);
            return b;
        }
    }
}

package com.tencent.p177mm.plugin.mmsight.model.p456a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.b */
public final class C43302b {
    int eTi;
    int eTj;
    int eTl;
    int fYx;
    int fYy;
    byte[] ovq;
    byte[] ovr;
    int ovs = 0;
    int ovt = 0;
    long ovu = C5046bo.m7588yz();
    int ovv;
    boolean ovw;
    boolean ovx;
    int rotate;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.b$1 */
    class C125411 implements Runnable {
        final /* synthetic */ C28498a ovy;

        C125411(C28498a c28498a) {
            this.ovy = c28498a;
        }

        public final void run() {
            AppMethodBeat.m2504i(76569);
            C43302b c43302b = C43302b.this;
            C4990ab.m7417i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", Integer.valueOf(c43302b.fYx), Integer.valueOf(c43302b.fYy), Integer.valueOf(c43302b.eTi), Integer.valueOf(c43302b.eTj), Integer.valueOf(c43302b.ovt));
            if (c43302b.eTl == 21 || c43302b.eTl == 2130706688) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(c43302b.ovq, c43302b.ovr, c43302b.fYx, c43302b.fYy, c43302b.eTi, c43302b.eTj, 1, c43302b.rotate, c43302b.ovv, c43302b.ovx, c43302b.ovw);
            } else if (c43302b.eTl == 19) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(c43302b.ovq, c43302b.ovr, c43302b.fYx, c43302b.fYy, c43302b.eTi, c43302b.eTj, 2, c43302b.rotate, c43302b.ovv, c43302b.ovx, c43302b.ovw);
            }
            C4990ab.m7419v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", Long.valueOf(C5046bo.m7525az(c43302b.ovu)), Integer.valueOf(c43302b.ovq.length), Integer.valueOf(c43302b.ovr.length), Integer.valueOf(c43302b.ovt));
            this.ovy.mo24465a(C43302b.this);
            C43305j.owk.mo68845g(C43302b.this.ovq);
            AppMethodBeat.m2505o(76569);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.b$a */
    public interface C28498a {
        /* renamed from: a */
        void mo24465a(C43302b c43302b);
    }

    public C43302b(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) {
        AppMethodBeat.m2504i(76570);
        this.eTl = i3;
        this.eTi = i4;
        this.eTj = i5;
        this.fYx = i;
        this.fYy = i2;
        this.ovx = z2;
        this.ovw = z;
        this.rotate = i6;
        this.ovq = bArr;
        this.ovs = bArr.length;
        this.ovr = C43305j.owk.mo68846g(Integer.valueOf(((i4 * i5) * 3) / 2));
        AppMethodBeat.m2505o(76570);
    }
}

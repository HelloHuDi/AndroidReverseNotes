package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    int eTi;
    int eTj;
    int eTl;
    int fYx;
    int fYy;
    byte[] ovq;
    byte[] ovr;
    int ovs = 0;
    int ovt = 0;
    long ovu = bo.yz();
    int ovv;
    boolean ovw;
    boolean ovx;
    int rotate;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a ovy;

        AnonymousClass1(a aVar) {
            this.ovy = aVar;
        }

        public final void run() {
            AppMethodBeat.i(76569);
            b bVar = b.this;
            ab.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", Integer.valueOf(bVar.fYx), Integer.valueOf(bVar.fYy), Integer.valueOf(bVar.eTi), Integer.valueOf(bVar.eTj), Integer.valueOf(bVar.ovt));
            if (bVar.eTl == 21 || bVar.eTl == 2130706688) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.ovq, bVar.ovr, bVar.fYx, bVar.fYy, bVar.eTi, bVar.eTj, 1, bVar.rotate, bVar.ovv, bVar.ovx, bVar.ovw);
            } else if (bVar.eTl == 19) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.ovq, bVar.ovr, bVar.fYx, bVar.fYy, bVar.eTi, bVar.eTj, 2, bVar.rotate, bVar.ovv, bVar.ovx, bVar.ovw);
            }
            ab.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", Long.valueOf(bo.az(bVar.ovu)), Integer.valueOf(bVar.ovq.length), Integer.valueOf(bVar.ovr.length), Integer.valueOf(bVar.ovt));
            this.ovy.a(b.this);
            j.owk.g(b.this.ovq);
            AppMethodBeat.o(76569);
        }
    }

    public interface a {
        void a(b bVar);
    }

    public b(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) {
        AppMethodBeat.i(76570);
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
        this.ovr = j.owk.g(Integer.valueOf(((i4 * i5) * 3) / 2));
        AppMethodBeat.o(76570);
    }
}

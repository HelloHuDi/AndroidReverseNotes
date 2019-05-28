package com.tencent.p177mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.qbar.QbarNative;

/* renamed from: com.tencent.mm.plugin.scanner.util.b */
public abstract class C3771b {
    protected static int qhm = 0;
    protected int cvn;
    protected int cvo;
    protected C3772a qhj = null;
    protected byte[] qhk = null;
    public String qhl;
    protected long qhn;
    public boolean[] qho = null;
    protected byte[] rawData = null;

    /* renamed from: com.tencent.mm.plugin.scanner.util.b$a */
    public interface C3772a {
        /* renamed from: K */
        void mo8420K(Bundle bundle);

        /* renamed from: b */
        void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3);

        /* renamed from: jJ */
        void mo8430jJ(long j);
    }

    /* renamed from: a */
    public abstract boolean mo8442a(byte[] bArr, Point point, Rect rect);

    public abstract void chP();

    /* renamed from: sI */
    public abstract void mo8444sI();

    public C3771b(C3772a c3772a) {
        this.qhj = c3772a;
    }

    /* renamed from: a */
    public final void mo8441a(byte[] bArr, Point point, int i, Rect rect) {
        C4990ab.m7410d("MicroMsg.scanner.BaseDecoder", "decode task reach");
        final byte[] bArr2 = bArr;
        final int i2 = i;
        final Point point2 = point;
        final Rect rect2 = rect;
        C7305d.m12298f(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.scanner.util.b$1$1 */
            class C37681 implements Runnable {
                C37681() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(81370);
                    if (C3771b.this.qhj != null) {
                        C3771b.this.qhj.mo8421b(C3771b.qhm, C3771b.this.qhl, C3771b.this.rawData, C3771b.this.qhk, C3771b.this.cvn, C3771b.this.cvo);
                    }
                    AppMethodBeat.m2505o(81370);
                }
            }

            /* renamed from: com.tencent.mm.plugin.scanner.util.b$1$2 */
            class C37692 implements Runnable {
                C37692() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(81371);
                    if (C3771b.this.qhj != null) {
                        C4990ab.m7411d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                        C3771b.this.qhj.mo8430jJ(C3771b.this.qhn);
                    }
                    AppMethodBeat.m2505o(81371);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(81372);
                byte[] bArr = bArr2;
                if (270 == i2) {
                    byte[] bArr2 = new byte[bArr2.length];
                    QbarNative.m49361a(bArr2, bArr2, point2.x, point2.y);
                    bArr = new byte[bArr2.length];
                    QbarNative.m49361a(bArr, bArr2, point2.y, point2.x);
                    QbarNative.nativeRelease();
                }
                C4990ab.m7411d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                if (bArr == null || !C3771b.this.mo8442a(bArr, point2, rect2)) {
                    C5004al.m7441d(new C37692());
                    AppMethodBeat.m2505o(81372);
                    return;
                }
                C5004al.m7441d(new C37681());
                AppMethodBeat.m2505o(81372);
            }
        }, "scan_decode");
    }
}

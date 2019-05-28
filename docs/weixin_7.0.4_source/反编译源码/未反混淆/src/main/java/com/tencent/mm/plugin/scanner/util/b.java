package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.qbar.QbarNative;

public abstract class b {
    protected static int qhm = 0;
    protected int cvn;
    protected int cvo;
    protected a qhj = null;
    protected byte[] qhk = null;
    public String qhl;
    protected long qhn;
    public boolean[] qho = null;
    protected byte[] rawData = null;

    public interface a {
        void K(Bundle bundle);

        void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3);

        void jJ(long j);
    }

    public abstract boolean a(byte[] bArr, Point point, Rect rect);

    public abstract void chP();

    public abstract void sI();

    public b(a aVar) {
        this.qhj = aVar;
    }

    public final void a(byte[] bArr, Point point, int i, Rect rect) {
        ab.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
        final byte[] bArr2 = bArr;
        final int i2 = i;
        final Point point2 = point;
        final Rect rect2 = rect;
        d.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(81372);
                byte[] bArr = bArr2;
                if (270 == i2) {
                    byte[] bArr2 = new byte[bArr2.length];
                    QbarNative.a(bArr2, bArr2, point2.x, point2.y);
                    bArr = new byte[bArr2.length];
                    QbarNative.a(bArr, bArr2, point2.y, point2.x);
                    QbarNative.nativeRelease();
                }
                ab.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                if (bArr == null || !b.this.a(bArr, point2, rect2)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81371);
                            if (b.this.qhj != null) {
                                ab.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                                b.this.qhj.jJ(b.this.qhn);
                            }
                            AppMethodBeat.o(81371);
                        }
                    });
                    AppMethodBeat.o(81372);
                    return;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(81370);
                        if (b.this.qhj != null) {
                            b.this.qhj.b(b.qhm, b.this.qhl, b.this.rawData, b.this.qhk, b.this.cvn, b.this.cvo);
                        }
                        AppMethodBeat.o(81370);
                    }
                });
                AppMethodBeat.o(81372);
            }
        }, "scan_decode");
    }
}

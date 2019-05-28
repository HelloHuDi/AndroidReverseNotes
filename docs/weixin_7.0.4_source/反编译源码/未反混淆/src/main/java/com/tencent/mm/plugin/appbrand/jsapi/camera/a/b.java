package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.qbar.QbarNative;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b {
    AtomicBoolean hHj = new AtomicBoolean(false);
    a hHk;
    al hHl = new al("MicroMsg.appbrand.ScanDecoder");

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] hHm;
        final /* synthetic */ int hHn;
        final /* synthetic */ int hHo;
        final /* synthetic */ int hHp;
        final /* synthetic */ Rect hHq;

        AnonymousClass1(byte[] bArr, int i, int i2, int i3, Rect rect) {
            this.hHm = bArr;
            this.hHn = i;
            this.hHo = i2;
            this.hHp = i3;
            this.hHq = rect;
        }

        public final void run() {
            AppMethodBeat.i(130978);
            if (b.this.hHj.compareAndSet(false, true)) {
                byte[] bArr = this.hHm;
                if (270 == this.hHn || 90 == this.hHn) {
                    byte[] bArr2 = new byte[this.hHm.length];
                    QbarNative.a(bArr2, this.hHm, this.hHo, this.hHp);
                    bArr = new byte[this.hHm.length];
                    QbarNative.a(bArr, bArr2, this.hHp, this.hHo);
                    QbarNative.nativeRelease();
                }
                b.this.b(bArr, this.hHo, this.hHp, this.hHn);
                b.this.hHj.set(false);
                AppMethodBeat.o(130978);
                return;
            }
            ab.d("MicroMsg.appbrand.ScanDecoder", "decode isDecoding");
            AppMethodBeat.o(130978);
        }
    }

    public interface a {
        void c(int i, String str, byte[] bArr);
    }

    public abstract boolean b(byte[] bArr, int i, int i2, int i3);

    public abstract void init();

    public abstract void release();

    public b(a aVar) {
        this.hHk = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(final String str, final int i, final byte[] bArr) {
        ab.d("MicroMsg.appbrand.ScanDecoder", "result:%b, resultText:%s, resultType:%d, codeType:%d, codeVersion:%d", Boolean.TRUE, str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        al.d(new Runnable() {
            final /* synthetic */ int hHu = 0;
            final /* synthetic */ int hHv = 0;

            public final void run() {
                AppMethodBeat.i(130979);
                if (b.this.hHk != null) {
                    b.this.hHk.c(i, str, bArr);
                }
                AppMethodBeat.o(130979);
            }
        });
    }
}

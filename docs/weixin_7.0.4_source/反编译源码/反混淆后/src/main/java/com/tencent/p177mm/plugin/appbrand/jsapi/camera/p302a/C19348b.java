package com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.qbar.QbarNative;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b */
public abstract class C19348b {
    AtomicBoolean hHj = new AtomicBoolean(false);
    C19349a hHk;
    C5004al hHl = new C5004al("MicroMsg.appbrand.ScanDecoder");

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$1 */
    class C22441 implements Runnable {
        final /* synthetic */ byte[] hHm;
        final /* synthetic */ int hHn;
        final /* synthetic */ int hHo;
        final /* synthetic */ int hHp;
        final /* synthetic */ Rect hHq;

        C22441(byte[] bArr, int i, int i2, int i3, Rect rect) {
            this.hHm = bArr;
            this.hHn = i;
            this.hHo = i2;
            this.hHp = i3;
            this.hHq = rect;
        }

        public final void run() {
            AppMethodBeat.m2504i(130978);
            if (C19348b.this.hHj.compareAndSet(false, true)) {
                byte[] bArr = this.hHm;
                if (270 == this.hHn || 90 == this.hHn) {
                    byte[] bArr2 = new byte[this.hHm.length];
                    QbarNative.m49361a(bArr2, this.hHm, this.hHo, this.hHp);
                    bArr = new byte[this.hHm.length];
                    QbarNative.m49361a(bArr, bArr2, this.hHp, this.hHo);
                    QbarNative.nativeRelease();
                }
                C19348b.this.mo34510b(bArr, this.hHo, this.hHp, this.hHn);
                C19348b.this.hHj.set(false);
                AppMethodBeat.m2505o(130978);
                return;
            }
            C4990ab.m7410d("MicroMsg.appbrand.ScanDecoder", "decode isDecoding");
            AppMethodBeat.m2505o(130978);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$a */
    public interface C19349a {
        /* renamed from: c */
        void mo34513c(int i, String str, byte[] bArr);
    }

    /* renamed from: b */
    public abstract boolean mo34510b(byte[] bArr, int i, int i2, int i3);

    public abstract void init();

    public abstract void release();

    public C19348b(C19349a c19349a) {
        this.hHk = c19349a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo34509b(final String str, final int i, final byte[] bArr) {
        C4990ab.m7411d("MicroMsg.appbrand.ScanDecoder", "result:%b, resultText:%s, resultType:%d, codeType:%d, codeVersion:%d", Boolean.TRUE, str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        C5004al.m7441d(new Runnable() {
            final /* synthetic */ int hHu = 0;
            final /* synthetic */ int hHv = 0;

            public final void run() {
                AppMethodBeat.m2504i(130979);
                if (C19348b.this.hHk != null) {
                    C19348b.this.hHk.mo34513c(i, str, bArr);
                }
                AppMethodBeat.m2505o(130979);
            }
        });
    }
}

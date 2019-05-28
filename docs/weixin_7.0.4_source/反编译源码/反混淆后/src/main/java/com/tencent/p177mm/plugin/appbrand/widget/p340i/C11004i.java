package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.sdk.p604g.C7305d;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.i */
public final class C11004i extends C33612d {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.i$1 */
    class C110051 implements Runnable {
        C110051() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87570);
            File yg = C11004i.this.hwf.asE().mo34314yg(C11004i.this.jpu);
            if (yg == null) {
                C11004i.this.jpv.mo6339a("Failed to load icon via temp file", C11004i.this);
                AppMethodBeat.m2505o(87570);
                return;
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(yg.getPath());
            if (decodeFile != null) {
                C11004i.this.mo54183I(decodeFile);
                AppMethodBeat.m2505o(87570);
                return;
            }
            C11004i.this.jpv.mo6339a("Failed to load icon via temp file", C11004i.this);
            AppMethodBeat.m2505o(87570);
        }
    }

    public C11004i(String str, C33611c c33611c, C38492q c38492q) {
        super(str, c33611c, c38492q);
    }

    public final void aSg() {
        AppMethodBeat.m2504i(87571);
        if (this.hwf.asE() == null || this.jpu == null) {
            this.jpv.mo6339a("Failed to load icon via temp file", this);
            AppMethodBeat.m2505o(87571);
            return;
        }
        C7305d.m12301h(new C110051(), "TempFileIconLoader").start();
        AppMethodBeat.m2505o(87571);
    }
}

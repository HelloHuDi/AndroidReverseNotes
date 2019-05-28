package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.h */
public final class C11002h extends C33612d {
    public C11002h(String str, C33611c c33611c, C38492q c38492q) {
        super(str, c33611c, c38492q);
    }

    public final void aSg() {
        AppMethodBeat.m2504i(87569);
        final C6750i runtime = this.hwf.getRuntime();
        if (!(runtime == null || this.jpu == null)) {
            C7305d.m12301h(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87568);
                    InputStream d = C33082aw.m54073d(runtime, C11002h.this.jpu);
                    Bitmap decodeStream = BitmapFactory.decodeStream(d);
                    if (decodeStream == null) {
                        C11002h.this.jpv.mo6339a("Failed to load icon via package path", C11002h.this);
                    } else {
                        C11002h.this.mo54183I(decodeStream);
                    }
                    if (d != null) {
                        C5046bo.m7527b(d);
                    }
                    AppMethodBeat.m2505o(87568);
                }
            }, "PackageIconLoader ").start();
        }
        AppMethodBeat.m2505o(87569);
    }
}

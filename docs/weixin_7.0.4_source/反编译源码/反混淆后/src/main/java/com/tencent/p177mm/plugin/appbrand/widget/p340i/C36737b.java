package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.b */
public final class C36737b extends C33612d {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.b$1 */
    class C367381 implements Runnable {
        C367381() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87561);
            try {
                C36737b c36737b = C36737b.this;
                byte[] decode = Base64.decode(C36737b.this.jpu, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                if (decodeByteArray == null) {
                    c36737b.jpv.mo6339a("Failed to load icon via base64 icon", c36737b);
                }
                C36737b.this.mo54183I(decodeByteArray);
                AppMethodBeat.m2505o(87561);
            } catch (Exception e) {
                C36737b.this.jpv.mo6339a("Failed to load icon via base64 icon", C36737b.this);
                AppMethodBeat.m2505o(87561);
            }
        }
    }

    public C36737b(String str, C33611c c33611c) {
        super(str, c33611c);
    }

    public final void aSg() {
        AppMethodBeat.m2504i(87562);
        if (this.jpu != null) {
            C7305d.m12301h(new C367381(), "Base64IconLoader").start();
            AppMethodBeat.m2505o(87562);
            return;
        }
        this.jpv.mo6339a("Failed to load icon via base64 icon", this);
        AppMethodBeat.m2505o(87562);
    }
}

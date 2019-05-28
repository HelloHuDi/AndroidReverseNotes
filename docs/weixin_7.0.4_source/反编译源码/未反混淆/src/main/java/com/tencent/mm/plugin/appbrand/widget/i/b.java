package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;

public final class b extends d {
    public b(String str, c cVar) {
        super(str, cVar);
    }

    public final void aSg() {
        AppMethodBeat.i(87562);
        if (this.jpu != null) {
            d.h(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87561);
                    try {
                        b bVar = b.this;
                        byte[] decode = Base64.decode(b.this.jpu, 0);
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                        if (decodeByteArray == null) {
                            bVar.jpv.a("Failed to load icon via base64 icon", bVar);
                        }
                        b.this.I(decodeByteArray);
                        AppMethodBeat.o(87561);
                    } catch (Exception e) {
                        b.this.jpv.a("Failed to load icon via base64 icon", b.this);
                        AppMethodBeat.o(87561);
                    }
                }
            }, "Base64IconLoader").start();
            AppMethodBeat.o(87562);
            return;
        }
        this.jpv.a("Failed to load icon via base64 icon", this);
        AppMethodBeat.o(87562);
    }
}

package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class a {
    public static n fV(String str, String str2) {
        AppMethodBeat.i(35877);
        int argb = Color.argb(51, 255, 255, 255);
        n Xi = i.Xi(str);
        if (Xi == null) {
            ab.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
            AppMethodBeat.o(35877);
            return null;
        }
        n a = a(Xi.Xh(), str2, argb, 55);
        AppMethodBeat.o(35877);
        return a;
    }

    public static n a(Bitmap bitmap, String str, int i, int i2) {
        AppMethodBeat.i(35878);
        n w = n.w(d.e(bitmap, i2));
        if (w == null) {
            ab.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
        }
        if (w != null) {
            new Canvas(w.Xh()).drawColor(i);
        }
        try {
            d.a(w.Xh(), 70, CompressFormat.JPEG, str, false);
        } catch (IOException e) {
            ab.e("MicroMsg.BlurHelper", "error for exception " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.BlurHelper", e, "", new Object[0]);
        }
        ab.i("MicroMsg.BlurHelper", "blur done bitmap  ".concat(String.valueOf(w)));
        AppMethodBeat.o(35878);
        return w;
    }
}

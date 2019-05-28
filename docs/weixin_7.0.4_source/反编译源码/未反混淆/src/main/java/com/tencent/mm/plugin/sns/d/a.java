package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static n c(String str, Options options) {
        AppMethodBeat.i(35785);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.Xf().a(str, options);
            if (a != null) {
                a = i.s(str, a);
            }
            ab.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a);
            n w = n.w(a);
            AppMethodBeat.o(35785);
            return w;
        } catch (OutOfMemoryError e) {
            b.dvU();
            ab.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            AppMethodBeat.o(35785);
            return null;
        }
    }

    public static Bitmap b(String str, Options options) {
        AppMethodBeat.i(35786);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.Xf().a(str, options);
            if (a != null) {
                a = i.s(str, a);
            }
            ab.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a);
            AppMethodBeat.o(35786);
            return a;
        } catch (OutOfMemoryError e) {
            b.dvU();
            ab.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            AppMethodBeat.o(35786);
            return null;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SnsBitmapUtil", e2, "", new Object[0]);
            AppMethodBeat.o(35786);
            return null;
        }
    }
}

package com.bumptech.glide.c.d.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.b.b;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public final class a implements e<Bitmap, byte[]> {
    private final CompressFormat aGp;
    private final int quality;

    public a() {
        this(CompressFormat.JPEG);
    }

    private a(CompressFormat compressFormat) {
        this.aGp = compressFormat;
        this.quality = 100;
    }

    public final u<byte[]> a(u<Bitmap> uVar, j jVar) {
        AppMethodBeat.i(92360);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) uVar.get()).compress(this.aGp, this.quality, byteArrayOutputStream);
        uVar.recycle();
        b bVar = new b(byteArrayOutputStream.toByteArray());
        AppMethodBeat.o(92360);
        return bVar;
    }
}

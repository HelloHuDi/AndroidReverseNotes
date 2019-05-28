package com.bumptech.glide.p086c.p092d.p094f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p092d.p1135b.C31964b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

/* renamed from: com.bumptech.glide.c.d.f.a */
public final class C37188a implements C8553e<Bitmap, byte[]> {
    private final CompressFormat aGp;
    private final int quality;

    public C37188a() {
        this(CompressFormat.JPEG);
    }

    private C37188a(CompressFormat compressFormat) {
        this.aGp = compressFormat;
        this.quality = 100;
    }

    /* renamed from: a */
    public final C17526u<byte[]> mo18654a(C17526u<Bitmap> c17526u, C31967j c31967j) {
        AppMethodBeat.m2504i(92360);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) c17526u.get()).compress(this.aGp, this.quality, byteArrayOutputStream);
        c17526u.recycle();
        C31964b c31964b = new C31964b(byteArrayOutputStream.toByteArray());
        AppMethodBeat.m2505o(92360);
        return c31964b;
    }
}

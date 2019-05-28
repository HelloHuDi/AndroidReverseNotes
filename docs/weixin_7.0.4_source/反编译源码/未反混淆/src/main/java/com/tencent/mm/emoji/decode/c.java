package com.tencent.mm.emoji.decode;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameHeight", "", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
public final class c implements b {
    private Bitmap exl;

    public c(Bitmap bitmap) {
        AppMethodBeat.i(63139);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
            j.o(bitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        }
        this.exl = bitmap;
        this.exl.setDensity(320);
        AppMethodBeat.o(63139);
    }

    public c(byte[] bArr) {
        j.p(bArr, "bytes");
        this(d.bQ(bArr));
        AppMethodBeat.i(63140);
        AppMethodBeat.o(63140);
    }

    public final void Or() {
    }

    public final Bitmap Os() {
        return this.exl;
    }

    public final int Ot() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int Ou() {
        AppMethodBeat.i(63137);
        int width = this.exl.getWidth();
        AppMethodBeat.o(63137);
        return width;
    }

    public final int Ov() {
        AppMethodBeat.i(63138);
        int height = this.exl.getHeight();
        AppMethodBeat.o(63138);
        return height;
    }

    public final void destroy() {
    }
}

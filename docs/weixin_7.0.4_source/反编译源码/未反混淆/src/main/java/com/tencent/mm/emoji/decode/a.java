package com.tencent.mm.emoji.decode;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameHeight", "", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
public final class a implements b {
    private final String TAG = "MicroMsg.EmptyDecoder";
    private Bitmap exk;

    public a() {
        AppMethodBeat.i(63136);
        ab.w(this.TAG, "init: should not call this, something error");
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        j.o(createBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.exk = createBitmap;
        AppMethodBeat.o(63136);
    }

    public final void Or() {
    }

    public final Bitmap Os() {
        return this.exk;
    }

    public final int Ot() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int Ou() {
        AppMethodBeat.i(63134);
        int width = this.exk.getWidth();
        AppMethodBeat.o(63134);
        return width;
    }

    public final int Ov() {
        AppMethodBeat.i(63135);
        int height = this.exk.getHeight();
        AppMethodBeat.o(63135);
        return height;
    }

    public final void destroy() {
    }
}

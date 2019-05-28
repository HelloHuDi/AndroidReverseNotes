package com.tencent.p177mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameHeight", "", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.decode.c */
public final class C18196c implements C26076b {
    private Bitmap exl;

    public C18196c(Bitmap bitmap) {
        AppMethodBeat.m2504i(63139);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
            C25052j.m39375o(bitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        }
        this.exl = bitmap;
        this.exl.setDensity(320);
        AppMethodBeat.m2505o(63139);
    }

    public C18196c(byte[] bArr) {
        C25052j.m39376p(bArr, "bytes");
        this(C5056d.m7652bQ(bArr));
        AppMethodBeat.m2504i(63140);
        AppMethodBeat.m2505o(63140);
    }

    /* renamed from: Or */
    public final void mo33669Or() {
    }

    /* renamed from: Os */
    public final Bitmap mo33670Os() {
        return this.exl;
    }

    /* renamed from: Ot */
    public final int mo33671Ot() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* renamed from: Ou */
    public final int mo33672Ou() {
        AppMethodBeat.m2504i(63137);
        int width = this.exl.getWidth();
        AppMethodBeat.m2505o(63137);
        return width;
    }

    /* renamed from: Ov */
    public final int mo33673Ov() {
        AppMethodBeat.m2504i(63138);
        int height = this.exl.getHeight();
        AppMethodBeat.m2505o(63138);
        return height;
    }

    public final void destroy() {
    }
}

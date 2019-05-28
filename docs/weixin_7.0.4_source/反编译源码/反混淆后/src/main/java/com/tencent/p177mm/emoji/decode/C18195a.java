package com.tencent.p177mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameHeight", "", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.decode.a */
public final class C18195a implements C26076b {
    private final String TAG = "MicroMsg.EmptyDecoder";
    private Bitmap exk;

    public C18195a() {
        AppMethodBeat.m2504i(63136);
        C4990ab.m7420w(this.TAG, "init: should not call this, something error");
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        C25052j.m39375o(createBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.exk = createBitmap;
        AppMethodBeat.m2505o(63136);
    }

    /* renamed from: Or */
    public final void mo33669Or() {
    }

    /* renamed from: Os */
    public final Bitmap mo33670Os() {
        return this.exk;
    }

    /* renamed from: Ot */
    public final int mo33671Ot() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* renamed from: Ou */
    public final int mo33672Ou() {
        AppMethodBeat.m2504i(63134);
        int width = this.exk.getWidth();
        AppMethodBeat.m2505o(63134);
        return width;
    }

    /* renamed from: Ov */
    public final int mo33673Ov() {
        AppMethodBeat.m2504i(63135);
        int height = this.exk.getHeight();
        AppMethodBeat.m2505o(63135);
        return height;
    }

    public final void destroy() {
    }
}

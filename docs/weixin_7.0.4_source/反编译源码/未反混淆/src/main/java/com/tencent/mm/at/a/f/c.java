package com.tencent.mm.at.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c implements Runnable {
    private Bitmap bitmap;
    private b fHp;
    private com.tencent.mm.at.a.c fHr;
    private String key;
    private String url;

    public c(String str, com.tencent.mm.at.a.c cVar, Bitmap bitmap, b bVar, String str2) {
        this.url = str;
        this.fHr = cVar;
        this.bitmap = bitmap;
        this.fHp = bVar;
        this.key = str2;
    }

    public final void run() {
        AppMethodBeat.i(116112);
        if (bo.isNullOrNil(this.url) || this.fHr == null || this.bitmap == null || this.bitmap.isRecycled() || this.fHp == null) {
            ab.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            AppMethodBeat.o(116112);
            return;
        }
        if (this.url.equals((String) this.fHp.fGN.get(Integer.valueOf(this.fHr.eQF)))) {
            com.tencent.mm.at.a.c cVar = this.fHr;
            Bitmap bitmap = this.bitmap;
            if (Looper.myLooper() == Looper.getMainLooper() && cVar.eQD != null) {
                ImageView imageView = (ImageView) cVar.eQD.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
            this.fHp.a(this.fHr);
            AppMethodBeat.o(116112);
            return;
        }
        ab.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
        AppMethodBeat.o(116112);
    }
}

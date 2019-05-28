package com.tencent.p177mm.p190at.p191a.p828f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.C25817c;
import com.tencent.p177mm.p190at.p191a.C9012b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.at.a.f.c */
public final class C32284c implements Runnable {
    private Bitmap bitmap;
    private C9012b fHp;
    private C25817c fHr;
    private String key;
    private String url;

    public C32284c(String str, C25817c c25817c, Bitmap bitmap, C9012b c9012b, String str2) {
        this.url = str;
        this.fHr = c25817c;
        this.bitmap = bitmap;
        this.fHp = c9012b;
        this.key = str2;
    }

    public final void run() {
        AppMethodBeat.m2504i(116112);
        if (C5046bo.isNullOrNil(this.url) || this.fHr == null || this.bitmap == null || this.bitmap.isRecycled() || this.fHp == null) {
            C4990ab.m7420w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            AppMethodBeat.m2505o(116112);
            return;
        }
        if (this.url.equals((String) this.fHp.fGN.get(Integer.valueOf(this.fHr.eQF)))) {
            C25817c c25817c = this.fHr;
            Bitmap bitmap = this.bitmap;
            if (Looper.myLooper() == Looper.getMainLooper() && c25817c.eQD != null) {
                ImageView imageView = (ImageView) c25817c.eQD.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
            this.fHp.mo20439a(this.fHr);
            AppMethodBeat.m2505o(116112);
            return;
        }
        C4990ab.m7420w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
        AppMethodBeat.m2505o(116112);
    }
}

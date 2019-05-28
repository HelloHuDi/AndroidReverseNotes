package com.tencent.p177mm.p190at.p191a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.at.a.c */
public final class C25817c {
    public WeakReference<ImageView> eQD;
    public final int eQF;
    public int height = 0;
    private String url = "";
    public int width = 0;

    public C25817c(ImageView imageView, String str) {
        AppMethodBeat.m2504i(116046);
        this.eQD = new WeakReference(imageView);
        this.url = str;
        if (imageView != null) {
            this.eQF = imageView.hashCode();
            AppMethodBeat.m2505o(116046);
            return;
        }
        this.eQF = hashCode();
        AppMethodBeat.m2505o(116046);
    }

    public final ImageView getImageView() {
        AppMethodBeat.m2504i(116047);
        if (this.eQD != null) {
            ImageView imageView = (ImageView) this.eQD.get();
            if (imageView != null) {
                AppMethodBeat.m2505o(116047);
                return imageView;
            }
        }
        AppMethodBeat.m2505o(116047);
        return null;
    }
}

package com.tencent.mm.at.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class c {
    public WeakReference<ImageView> eQD;
    public final int eQF;
    public int height = 0;
    private String url = "";
    public int width = 0;

    public c(ImageView imageView, String str) {
        AppMethodBeat.i(116046);
        this.eQD = new WeakReference(imageView);
        this.url = str;
        if (imageView != null) {
            this.eQF = imageView.hashCode();
            AppMethodBeat.o(116046);
            return;
        }
        this.eQF = hashCode();
        AppMethodBeat.o(116046);
    }

    public final ImageView getImageView() {
        AppMethodBeat.i(116047);
        if (this.eQD != null) {
            ImageView imageView = (ImageView) this.eQD.get();
            if (imageView != null) {
                AppMethodBeat.o(116047);
                return imageView;
            }
        }
        AppMethodBeat.o(116047);
        return null;
    }
}

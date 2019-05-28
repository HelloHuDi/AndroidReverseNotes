package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;

public final class e {
    Bitmap bitmap = null;
    int resId = -1;

    public final void l(ImageView imageView) {
        AppMethodBeat.i(107159);
        if (imageView == null) {
            AppMethodBeat.o(107159);
            return;
        }
        if (this.resId != -1) {
            imageView.setImageDrawable(a.g(imageView.getContext(), this.resId));
        }
        if (this.bitmap != null) {
            imageView.setImageBitmap(this.bitmap);
        }
        AppMethodBeat.o(107159);
    }
}

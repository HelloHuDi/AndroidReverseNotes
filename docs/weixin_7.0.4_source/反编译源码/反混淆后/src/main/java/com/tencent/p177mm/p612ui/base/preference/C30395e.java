package com.tencent.p177mm.p612ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.ui.base.preference.e */
public final class C30395e {
    Bitmap bitmap = null;
    int resId = -1;

    /* renamed from: l */
    public final void mo48781l(ImageView imageView) {
        AppMethodBeat.m2504i(107159);
        if (imageView == null) {
            AppMethodBeat.m2505o(107159);
            return;
        }
        if (this.resId != -1) {
            imageView.setImageDrawable(C1338a.m2864g(imageView.getContext(), this.resId));
        }
        if (this.bitmap != null) {
            imageView.setImageBitmap(this.bitmap);
        }
        AppMethodBeat.m2505o(107159);
    }
}

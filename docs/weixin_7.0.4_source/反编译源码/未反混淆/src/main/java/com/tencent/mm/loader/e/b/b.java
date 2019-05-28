package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.e.b.d.a;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends e<ImageView> {
    public b(f<ImageView> fVar) {
        super(fVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Bitmap bitmap, f<?> fVar) {
        ImageView imageView = (ImageView) fVar.getView();
        ab.i("MicroMsg.Loader.ImageViewShowTarget", "onResourceReadyUI %s imageView %s", bitmap, imageView);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        a aVar = d.eQA;
        a.TN().a(this);
    }

    public final void a(f<?> fVar, f<?, ?> fVar2) {
        if (fVar == null) {
            ab.w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
            return;
        }
        ImageView imageView = (ImageView) fVar.getView();
        if (imageView != null) {
            Object obj;
            if (fVar2.eOW > 0 || fVar2.eOX != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                imageView.setImageBitmap(null);
            } else if (fVar2.eOW == 0) {
                imageView.setImageDrawable(fVar2.eOX);
            } else {
                imageView.setImageResource(fVar2.eOW);
            }
        }
    }
}

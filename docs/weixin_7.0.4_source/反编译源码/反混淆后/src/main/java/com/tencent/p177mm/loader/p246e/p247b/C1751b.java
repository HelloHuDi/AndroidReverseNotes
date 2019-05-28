package com.tencent.p177mm.loader.p246e.p247b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p246e.p247b.C1754d.C1755a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.loader.e.b.b */
public final class C1751b extends C32730e<ImageView> {
    public C1751b(C32731f<ImageView> c32731f) {
        super(c32731f);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo5286a(Bitmap bitmap, C32731f<?> c32731f) {
        ImageView imageView = (ImageView) c32731f.getView();
        C4990ab.m7417i("MicroMsg.Loader.ImageViewShowTarget", "onResourceReadyUI %s imageView %s", bitmap, imageView);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        C1755a c1755a = C1754d.eQA;
        C1755a.m3619TN().mo5289a(this);
    }

    /* renamed from: a */
    public final void mo5285a(C32731f<?> c32731f, C45421f<?, ?> c45421f) {
        if (c32731f == null) {
            C4990ab.m7420w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
            return;
        }
        ImageView imageView = (ImageView) c32731f.getView();
        if (imageView != null) {
            Object obj;
            if (c45421f.eOW > 0 || c45421f.eOX != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                imageView.setImageBitmap(null);
            } else if (c45421f.eOW == 0) {
                imageView.setImageDrawable(c45421f.eOX);
            } else {
                imageView.setImageResource(c45421f.eOW);
            }
        }
    }
}

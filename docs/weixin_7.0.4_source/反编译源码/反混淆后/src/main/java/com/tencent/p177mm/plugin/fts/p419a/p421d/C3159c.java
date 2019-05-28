package com.tencent.p177mm.plugin.fts.p419a.p421d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.fts.a.d.c */
public interface C3159c {

    /* renamed from: com.tencent.mm.plugin.fts.a.d.c$a */
    public static class C3160a extends BitmapDrawable {
        /* renamed from: a */
        public static void m5397a(Resources resources, Bitmap bitmap, ImageView imageView) {
            AppMethodBeat.m2504i(114296);
            imageView.setImageDrawable(new C3160a(resources, bitmap));
            imageView.postInvalidate();
            AppMethodBeat.m2505o(114296);
        }

        private C3160a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.m2504i(114297);
            if (!(getBitmap() == null || getBitmap().isRecycled())) {
                super.draw(canvas);
            }
            AppMethodBeat.m2505o(114297);
        }
    }

    /* renamed from: a */
    Bitmap mo7425a(String str, String str2, boolean z, int i, int i2);

    /* renamed from: a */
    String mo7426a(ImageView imageView, String str, String str2, boolean z, int i, int i2);

    /* renamed from: a */
    void mo7427a(Context context, ImageView imageView, String str, String str2, boolean z, int i, int i2);

    void bAa();

    void bzV();

    void bzW();

    boolean bzX();

    void bzY();

    void bzZ();
}

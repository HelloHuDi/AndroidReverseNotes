package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {

    public static class a extends BitmapDrawable {
        public static void a(Resources resources, Bitmap bitmap, ImageView imageView) {
            AppMethodBeat.i(114296);
            imageView.setImageDrawable(new a(resources, bitmap));
            imageView.postInvalidate();
            AppMethodBeat.o(114296);
        }

        private a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(114297);
            if (!(getBitmap() == null || getBitmap().isRecycled())) {
                super.draw(canvas);
            }
            AppMethodBeat.o(114297);
        }
    }

    Bitmap a(String str, String str2, boolean z, int i, int i2);

    String a(ImageView imageView, String str, String str2, boolean z, int i, int i2);

    void a(Context context, ImageView imageView, String str, String str2, boolean z, int i, int i2);

    void bAa();

    void bzV();

    void bzW();

    boolean bzX();

    void bzY();

    void bzZ();
}

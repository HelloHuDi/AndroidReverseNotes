package com.davemorrissey.labs.subscaleview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

public interface d {
    Bitmap b(Rect rect, int i);

    Point c(Context context, Uri uri);

    boolean isReady();

    void recycle();
}

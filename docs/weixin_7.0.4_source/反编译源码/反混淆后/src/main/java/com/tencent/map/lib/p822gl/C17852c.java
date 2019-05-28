package com.tencent.map.lib.p822gl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.map.lib.gl.c */
public class C17852c {
    /* renamed from: a */
    public static Bitmap m27945a(Bitmap bitmap) {
        int i = 2;
        AppMethodBeat.m2504i(98053);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = 2;
        while (i2 < width) {
            i2 <<= 1;
        }
        while (i < height) {
            i <<= 1;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
            createBitmap.setDensity(0);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setDensity(0);
            createBitmap.eraseColor(0);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            AppMethodBeat.m2505o(98053);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            AppMethodBeat.m2505o(98053);
            return null;
        }
    }

    /* renamed from: a */
    public static int m27944a(GL10 gl10, Bitmap bitmap) {
        AppMethodBeat.m2504i(98054);
        int b = C17852c.m27946b(gl10);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        AppMethodBeat.m2505o(98054);
        return b;
    }

    /* renamed from: a */
    private static int m27943a(GL10 gl10) {
        AppMethodBeat.m2504i(98055);
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        AppMethodBeat.m2505o(98055);
        return i;
    }

    /* renamed from: b */
    private static int m27946b(GL10 gl10) {
        AppMethodBeat.m2504i(98056);
        int a = C17852c.m27943a(gl10);
        gl10.glBindTexture(3553, a);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
        gl10.glTexParameterf(3553, 10242, 33071.0f);
        gl10.glTexParameterf(3553, 10243, 33071.0f);
        AppMethodBeat.m2505o(98056);
        return a;
    }
}

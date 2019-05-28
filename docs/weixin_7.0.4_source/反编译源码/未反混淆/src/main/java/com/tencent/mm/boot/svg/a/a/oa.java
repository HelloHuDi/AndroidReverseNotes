package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import org.xwalk.core.XWalkEnvironment;

public final class oa extends c {
    private final int height = 50;
    private final int width = 50;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 50;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-8618884);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(23.26f, 0.0f);
                l.lineTo(26.42f, 0.0f);
                l.cubicTo(38.63f, 0.57f, 49.24f, 11.0f, 50.0f, 23.21f);
                l.lineTo(50.0f, 26.5f);
                l.cubicTo(49.44f, 38.71f, 38.94f, 49.21f, 26.78f, 50.0f);
                l.lineTo(23.52f, 50.0f);
                l.cubicTo(11.33f, 49.41f, 0.78f, 38.99f, 0.0f, 26.81f);
                l.lineTo(0.0f, 23.43f);
                l.cubicTo(0.62f, 11.24f, 11.09f, 0.77f, 23.26f, 0.0f);
                l.lineTo(23.26f, 0.0f);
                l.close();
                l.moveTo(35.370926f, 15.0f);
                l.cubicTo(30.458647f, 20.306633f, 25.646616f, 25.703379f, 20.70426f, 30.989988f);
                l.cubicTo(18.659147f, 28.787233f, 16.654135f, 26.554443f, 14.609022f, 24.341677f);
                l.cubicTo(13.39599f, 25.673342f, 12.192983f, 27.005007f, 11.0f, 28.346684f);
                l.cubicTo(14.197995f, 31.931164f, 17.47619f, 35.435543f, 20.70426f, 39.0f);
                l.cubicTo(26.8396f, 32.371716f, 32.914787f, 25.683353f, 39.0f, 19.005007f);
                l.cubicTo(37.80702f, 17.653316f, 36.60401f, 16.321651f, 35.370926f, 15.0f);
                l.lineTo(35.370926f, 15.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-394759);
                float[] a2 = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 15.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(24.370928f, -1.7763568E-15f);
                l.cubicTo(25.60401f, 1.321652f, 26.807018f, 2.6533167f, 28.0f, 4.0050063f);
                l.cubicTo(21.914787f, 10.683354f, 15.839599f, 17.371716f, 9.704261f, 24.0f);
                l.cubicTo(6.4761906f, 20.435545f, 3.197995f, 16.931164f, 0.0f, 13.3466835f);
                l.cubicTo(1.1929824f, 12.005006f, 2.39599f, 10.673342f, 3.6090226f, 9.341677f);
                l.cubicTo(5.654135f, 11.554443f, 7.6591477f, 13.787234f, 9.704261f, 15.989987f);
                l.cubicTo(14.646617f, 10.70338f, 19.458647f, 5.3066335f, 24.370928f, -1.7763568E-15f);
                l.lineTo(24.370928f, -1.7763568E-15f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

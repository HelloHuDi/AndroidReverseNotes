package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class in extends c {
    private final int height = 51;
    private final int width = 46;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 51;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k = c.a(k, looper);
                k.setColor(-3881788);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(24.0f, 3.0f);
                l.cubicTo(24.89f, 0.3245459f, 29.14f, 0.33455303f, 30.0f, 3.0f);
                l.cubicTo(30.22f, 5.9885883f, 29.98f, 8.990731f, 30.0f, 12.0f);
                l.cubicTo(30.48f, 11.972859f, 31.48f, 11.972859f, 32.0f, 12.0f);
                l.cubicTo(31.99f, 9.981439f, 31.82f, 7.9700027f, 32.0f, 6.0f);
                l.cubicTo(32.82f, 3.63691f, 36.41f, 3.2466314f, 38.0f, 5.0f);
                l.cubicTo(38.37f, 7.48966f, 37.93f, 9.80131f, 38.0f, 12.0f);
                l.cubicTo(40.68f, 11.972859f, 43.34f, 11.972859f, 46.0f, 12.0f);
                l.lineTo(46.0f, 39.0f);
                l.cubicTo(43.6f, 38.982136f, 41.2f, 38.99214f, 39.0f, 39.0f);
                l.cubicTo(37.14f, 44.706223f, 32.34f, 49.389565f, 26.0f, 50.0f);
                l.lineTo(21.0f, 50.0f);
                l.cubicTo(14.81f, 49.539673f, 9.88f, 44.786278f, 8.0f, 39.0f);
                l.cubicTo(5.46f, 38.99214f, 2.73f, 38.99214f, 0.0f, 39.0f);
                l.lineTo(0.0f, 12.0f);
                l.cubicTo(2.63f, 11.972859f, 5.25f, 11.972859f, 8.0f, 12.0f);
                l.cubicTo(7.87f, 9.691231f, 7.81f, 5.8584957f, 11.0f, 6.0f);
                l.cubicTo(14.22f, 5.968574f, 14.09f, 9.731259f, 14.0f, 12.0f);
                l.cubicTo(14.6f, 11.972859f, 15.54f, 11.972859f, 16.0f, 12.0f);
                l.cubicTo(16.0f, 9.320967f, 15.79f, 6.639053f, 16.0f, 4.0f);
                l.cubicTo(16.88f, 1.3352673f, 21.13f, 1.3352673f, 22.0f, 4.0f);
                l.cubicTo(22.21f, 6.64906f, 22.0f, 9.320967f, 22.0f, 12.0f);
                l.cubicTo(22.5f, 11.972859f, 23.51f, 11.972859f, 24.0f, 12.0f);
                l.cubicTo(24.02f, 8.980724f, 23.77f, 5.968574f, 24.0f, 3.0f);
                l.lineTo(24.0f, 3.0f);
                l.close();
                l.moveTo(5.0f, 34.0f);
                l.cubicTo(12.38f, 33.93302f, 19.77f, 34.072884f, 27.0f, 34.0f);
                l.cubicTo(33.0f, 34.0f, 32.56548f, 25.699202f, 32.99548f, 22.046875f);
                l.cubicTo(33.340767f, 19.0f, 36.95f, 18.938057f, 39.0f, 19.0f);
                l.cubicTo(39.01f, 23.75323f, 39.0f, 28.868101f, 39.0f, 34.0f);
                l.cubicTo(39.75f, 33.98297f, 41.25f, 33.98297f, 42.0f, 34.0f);
                l.lineTo(42.0f, 17.0f);
                l.lineTo(5.0f, 17.0f);
                l.lineTo(5.0f, 34.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

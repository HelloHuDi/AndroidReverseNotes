package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.wd */
public final class C9162wd extends C5163c {
    private final int height = 72;
    private final int width = 80;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                g = C5163c.m7878a(g, 1.3333334f, 0.0f, 0.0f, 0.0f, 1.3333334f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-2171170);
                Path l = C5163c.m7884l(looper);
                l.moveTo(10.02f, 4.03f);
                l.cubicTo(16.37f, -0.03f, 25.25f, 2.32f, 30.0f, 7.82f);
                l.cubicTo(34.75f, 2.31f, 43.65f, -0.03f, 50.0f, 4.04f);
                l.cubicTo(56.64f, 8.75f, 57.4f, 18.37f, 54.62f, 25.46f);
                l.cubicTo(49.99f, 36.69f, 40.55f, 45.38f, 30.0f, 51.04f);
                l.cubicTo(19.44f, 45.38f, 10.0f, 36.68f, 5.38f, 25.44f);
                l.cubicTo(2.59f, 18.35f, 3.37f, 8.73f, 10.02f, 4.03f);
                l.moveTo(10.78f, 12.53f);
                l.cubicTo(9.05f, 17.39f, 9.87f, 23.01f, 12.63f, 27.35f);
                l.cubicTo(16.91f, 34.26f, 23.39f, 39.46f, 30.0f, 44.02f);
                l.cubicTo(35.84f, 40.01f, 41.47f, 35.49f, 45.75f, 29.79f);
                l.cubicTo(48.53f, 26.15f, 50.43f, 21.67f, 50.08f, 17.01f);
                l.cubicTo(50.12f, 13.43f, 48.4f, 9.15f, 44.52f, 8.35f);
                l.cubicTo(38.67f, 6.6f, 34.27f, 11.91f, 30.0f, 14.96f);
                l.cubicTo(26.8f, 12.47f, 23.72f, 9.6f, 19.86f, 8.15f);
                l.cubicTo(16.34f, 7.44f, 12.05f, 8.89f, 10.78f, 12.53f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

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

public final class ali extends c {
    private final int height = 144;
    private final int width = 144;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                k.setColor(-12864012);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(61.0f, 28.0f);
                l.cubicTo(69.75619f, 24.513273f, 80.44056f, 25.540365f, 88.0f, 31.0f);
                l.cubicTo(99.49052f, 38.12475f, 105.527336f, 51.995487f, 104.0f, 65.0f);
                l.cubicTo(110.17489f, 71.84929f, 114.192764f, 81.232735f, 114.0f, 91.0f);
                l.cubicTo(113.86294f, 93.936775f, 113.43317f, 97.58644f, 111.0f, 100.0f);
                l.cubicTo(107.31639f, 98.0252f, 105.30745f, 95.013725f, 103.0f, 92.0f);
                l.cubicTo(102.95869f, 95.35277f, 101.62939f, 98.33433f, 100.0f, 101.0f);
                l.cubicTo(103.068634f, 102.62219f, 106.66673f, 105.61372f, 106.0f, 110.0f);
                l.cubicTo(105.547325f, 114.269226f, 101.06969f, 116.8918f, 97.0f, 118.0f);
                l.cubicTo(89.645706f, 120.112686f, 80.430565f, 118.98587f, 75.0f, 113.0f);
                l.cubicTo(73.86403f, 112.59396f, 72.29485f, 112.59396f, 71.0f, 113.0f);
                l.cubicTo(65.968185f, 118.73658f, 57.23279f, 119.93319f, 50.0f, 118.0f);
                l.cubicTo(45.678883f, 117.26076f, 40.611553f, 114.58832f, 40.0f, 110.0f);
                l.cubicTo(39.50214f, 106.132256f, 42.310658f, 103.459816f, 45.0f, 102.0f);
                l.cubicTo(42.580517f, 98.952576f, 41.071312f, 95.65192f, 41.0f, 92.0f);
                l.cubicTo(38.672577f, 95.00375f, 36.67363f, 98.055115f, 33.0f, 100.0f);
                l.cubicTo(30.556854f, 97.556526f, 30.12708f, 93.91683f, 30.0f, 91.0f);
                l.cubicTo(29.80725f, 81.22276f, 33.815136f, 71.84929f, 40.0f, 65.0f);
                l.cubicTo(37.763058f, 50.021076f, 46.53843f, 33.687305f, 61.0f, 28.0f);
                l.lineTo(61.0f, 28.0f);
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

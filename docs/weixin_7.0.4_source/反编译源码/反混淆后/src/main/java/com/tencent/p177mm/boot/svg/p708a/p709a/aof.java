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

/* renamed from: com.tencent.mm.boot.svg.a.a.aof */
public final class aof extends C5163c {
    private final int height = 168;
    private final int width = 168;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-8617594);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 46.0f, 0.0f, 1.0f, 41.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(58.04338f, 85.02192f);
                l.cubicTo(68.83248f, 74.17345f, 75.5f, 59.221767f, 75.5f, 42.712807f);
                l.cubicTo(75.5f, 25.998095f, 68.66525f, 10.879722f, 57.638073f, 5.1184834E-11f);
                l.lineTo(50.21325f, 7.424826f);
                l.cubicTo(59.340397f, 16.404242f, 65.0f, 28.897589f, 65.0f, 42.712807f);
                l.cubicTo(65.0f, 56.322273f, 59.507717f, 68.64895f, 50.618725f, 77.59726f);
                l.lineTo(58.04338f, 85.02192f);
                l.close();
                l.moveTo(40.01204f, 66.99058f);
                l.cubicTo(46.186604f, 60.7568f, 50.0f, 52.180138f, 50.0f, 42.712807f);
                l.cubicTo(50.0f, 33.039722f, 46.01905f, 24.29644f, 39.606136f, 18.031939f);
                l.lineTo(32.18078f, 25.457294f);
                l.cubicTo(36.693905f, 29.821022f, 39.5f, 35.939213f, 39.5f, 42.712807f);
                l.cubicTo(39.5f, 49.280643f, 36.86179f, 55.232292f, 32.587296f, 59.565834f);
                l.lineTo(40.01204f, 66.99058f);
                l.close();
                l.moveTo(13.0f, 55.5f);
                l.cubicTo(20.1797f, 55.5f, 26.0f, 49.679703f, 26.0f, 42.5f);
                l.cubicTo(26.0f, 35.320297f, 20.1797f, 29.5f, 13.0f, 29.5f);
                l.cubicTo(5.820298f, 29.5f, 0.0f, 35.320297f, 0.0f, 42.5f);
                l.cubicTo(0.0f, 49.679703f, 5.820298f, 55.5f, 13.0f, 55.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

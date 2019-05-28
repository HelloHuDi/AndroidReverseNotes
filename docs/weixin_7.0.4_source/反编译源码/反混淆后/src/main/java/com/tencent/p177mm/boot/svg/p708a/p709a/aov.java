package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aov */
public final class aov extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                a.setColor(-9276814);
                canvas.saveLayerAlpha(null, 128, 4);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.9f, 0.0f);
                l.lineTo(38.04f, 0.0f);
                l.cubicTo(46.52f, 0.64f, 54.84f, 4.06f, 60.93f, 10.05f);
                l.cubicTo(67.46f, 16.26f, 71.4f, 24.96f, 72.0f, 33.92f);
                l.lineTo(72.0f, 38.04f);
                l.cubicTo(71.41f, 47.03f, 67.47f, 55.74f, 60.93f, 61.95f);
                l.cubicTo(54.9f, 67.87f, 46.7f, 71.29f, 38.32f, 72.0f);
                l.lineTo(33.95f, 72.0f);
                l.cubicTo(25.01f, 71.39f, 16.3f, 67.52f, 10.12f, 61.0f);
                l.cubicTo(4.16f, 54.92f, 0.64f, 46.69f, 0.0f, 38.23f);
                l.lineTo(0.0f, 33.93f);
                l.cubicTo(0.66f, 23.3f, 6.2f, 13.1f, 14.85f, 6.87f);
                l.cubicTo(20.36f, 2.78f, 27.09f, 0.58f, 33.9f, 0.0f);
                l.lineTo(33.9f, 0.0f);
                l.close();
                l.moveTo(29.45f, 3.65f);
                l.cubicTo(21.99f, 5.18f, 15.07f, 9.34f, 10.31f, 15.3f);
                l.cubicTo(1.3f, 26.14f, 0.57f, 42.84f, 8.63f, 54.42f);
                l.cubicTo(17.32f, 67.89f, 36.42f, 73.03f, 50.65f, 65.55f);
                l.cubicTo(65.31f, 58.67f, 72.85f, 40.15f, 67.11f, 24.99f);
                l.cubicTo(62.07f, 9.86f, 45.05f, 0.15f, 29.45f, 3.65f);
                l.lineTo(29.45f, 3.65f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(26.01f, 19.02f);
                l.cubicTo(35.34f, 24.67f, 44.66f, 30.33f, 53.98f, 36.0f);
                l.cubicTo(44.68f, 41.69f, 35.33f, 47.31f, 26.03f, 53.0f);
                l.cubicTo(25.97f, 41.67f, 26.01f, 30.34f, 26.01f, 19.02f);
                l.lineTo(26.01f, 19.02f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

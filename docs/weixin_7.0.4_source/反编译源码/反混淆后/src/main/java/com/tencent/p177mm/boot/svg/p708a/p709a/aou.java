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

/* renamed from: com.tencent.mm.boot.svg.a.a.aou */
public final class aou extends C5163c {
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
                a.setColor(-6710887);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.88f, 0.0f);
                l.lineTo(37.99f, 0.0f);
                l.cubicTo(46.5f, 0.63f, 54.85f, 4.06f, 60.96f, 10.08f);
                l.cubicTo(67.43f, 16.24f, 71.33f, 24.85f, 72.0f, 33.73f);
                l.lineTo(72.0f, 37.97f);
                l.cubicTo(71.44f, 46.97f, 67.49f, 55.71f, 60.95f, 61.93f);
                l.cubicTo(54.91f, 67.87f, 46.69f, 71.3f, 38.29f, 72.0f);
                l.lineTo(34.16f, 72.0f);
                l.cubicTo(25.58f, 71.47f, 17.17f, 67.95f, 11.02f, 61.9f);
                l.cubicTo(4.53f, 55.72f, 0.62f, 47.06f, 0.0f, 38.14f);
                l.lineTo(0.0f, 34.2f);
                l.cubicTo(0.52f, 24.67f, 4.91f, 15.44f, 12.08f, 9.12f);
                l.cubicTo(18.04f, 3.69f, 25.89f, 0.64f, 33.88f, 0.0f);
                l.lineTo(33.88f, 0.0f);
                l.close();
                l.moveTo(29.41f, 3.66f);
                l.cubicTo(22.9f, 5.01f, 16.79f, 8.34f, 12.2f, 13.16f);
                l.cubicTo(1.73f, 23.69f, -0.01f, 41.47f, 8.24f, 53.82f);
                l.cubicTo(16.74f, 67.7f, 36.16f, 73.15f, 50.6f, 65.58f);
                l.cubicTo(65.28f, 58.72f, 72.84f, 40.21f, 67.13f, 25.04f);
                l.cubicTo(62.1f, 9.87f, 45.03f, 0.13f, 29.41f, 3.66f);
                l.lineTo(29.41f, 3.66f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(26.0f, 19.01f);
                l.cubicTo(35.33f, 24.67f, 44.66f, 30.33f, 53.99f, 36.0f);
                l.cubicTo(44.67f, 41.67f, 35.34f, 47.33f, 26.0f, 52.99f);
                l.lineTo(26.0f, 19.01f);
                l.lineTo(26.0f, 19.01f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

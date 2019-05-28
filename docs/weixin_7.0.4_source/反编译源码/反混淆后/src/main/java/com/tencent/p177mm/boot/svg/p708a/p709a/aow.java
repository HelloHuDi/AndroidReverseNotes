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

/* renamed from: com.tencent.mm.boot.svg.a.a.aow */
public final class aow extends C5163c {
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
                l.moveTo(34.0f, 0.0f);
                l.lineTo(37.77f, 0.0f);
                l.cubicTo(46.83f, 0.56f, 55.72f, 4.44f, 61.96f, 11.09f);
                l.cubicTo(67.89f, 17.18f, 71.41f, 25.42f, 72.0f, 33.88f);
                l.lineTo(72.0f, 37.76f);
                l.cubicTo(71.52f, 46.61f, 67.74f, 55.23f, 61.42f, 61.47f);
                l.cubicTo(55.3f, 67.71f, 46.82f, 71.34f, 38.15f, 72.0f);
                l.lineTo(34.35f, 72.0f);
                l.cubicTo(25.49f, 71.52f, 16.81f, 67.81f, 10.58f, 61.46f);
                l.cubicTo(4.3f, 55.27f, 0.55f, 46.73f, 0.0f, 37.95f);
                l.lineTo(0.0f, 34.45f);
                l.cubicTo(0.43f, 24.82f, 4.87f, 15.48f, 12.1f, 9.1f);
                l.cubicTo(18.08f, 3.66f, 25.97f, 0.6f, 34.0f, 0.0f);
                l.lineTo(34.0f, 0.0f);
                l.close();
                l.moveTo(29.41f, 3.66f);
                l.cubicTo(18.26f, 5.87f, 8.62f, 14.23f, 4.9f, 24.97f);
                l.cubicTo(0.62f, 36.67f, 3.76f, 50.63f, 12.68f, 59.33f);
                l.cubicTo(22.99f, 69.98f, 40.66f, 72.12f, 53.18f, 64.16f);
                l.cubicTo(66.79f, 56.23f, 72.81f, 37.9f, 66.52f, 23.45f);
                l.cubicTo(60.91f, 9.13f, 44.44f, 0.29f, 29.41f, 3.66f);
                l.lineTo(29.41f, 3.66f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(24.0f, 24.0f);
                l2.lineTo(48.0f, 24.0f);
                l2.lineTo(48.0f, 48.0f);
                l2.lineTo(24.0f, 48.0f);
                l2.lineTo(24.0f, 24.0f);
                l2.lineTo(24.0f, 24.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

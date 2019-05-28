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

/* renamed from: com.tencent.mm.boot.svg.a.a.gj */
public final class C25888gj extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-3194563);
                Path l = C5163c.m7884l(looper);
                l.moveTo(28.0f, 0.0f);
                l.lineTo(31.91f, 0.0f);
                l.cubicTo(46.53f, 0.77f, 59.15f, 13.36f, 60.0f, 27.97f);
                l.lineTo(60.0f, 31.8f);
                l.cubicTo(59.3f, 46.69f, 46.27f, 59.57f, 31.35f, 60.0f);
                l.lineTo(28.48f, 60.0f);
                l.cubicTo(13.76f, 59.47f, 0.96f, 46.87f, 0.0f, 32.2f);
                l.lineTo(0.0f, 28.26f);
                l.cubicTo(0.67f, 13.56f, 13.33f, 0.84f, 28.0f, 0.0f);
                l.moveTo(13.35f, 25.51f);
                l.cubicTo(11.47f, 26.71f, 12.06f, 29.22f, 11.97f, 31.09f);
                l.cubicTo(11.7f, 32.88f, 12.89f, 35.05f, 14.89f, 34.94f);
                l.cubicTo(24.63f, 35.08f, 34.38f, 34.97f, 44.13f, 34.99f);
                l.cubicTo(45.92f, 35.31f, 47.97f, 34.09f, 47.96f, 32.14f);
                l.cubicTo(47.98f, 29.78f, 48.76f, 26.29f, 45.99f, 25.15f);
                l.cubicTo(36.69f, 24.77f, 27.35f, 25.14f, 18.04f, 24.98f);
                l.cubicTo(16.5f, 25.15f, 14.73f, 24.65f, 13.35f, 25.51f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-665128);
                l = C5163c.m7884l(looper);
                l.moveTo(13.35f, 25.51f);
                l.cubicTo(14.73f, 24.65f, 16.5f, 25.15f, 18.04f, 24.98f);
                l.cubicTo(27.35f, 25.14f, 36.69f, 24.77f, 45.99f, 25.15f);
                l.cubicTo(48.76f, 26.29f, 47.98f, 29.78f, 47.96f, 32.14f);
                l.cubicTo(47.97f, 34.09f, 45.92f, 35.31f, 44.13f, 34.99f);
                l.cubicTo(34.38f, 34.97f, 24.63f, 35.08f, 14.89f, 34.94f);
                l.cubicTo(12.89f, 35.05f, 11.7f, 32.88f, 11.97f, 31.09f);
                l.cubicTo(12.06f, 29.22f, 11.47f, 26.71f, 13.35f, 25.51f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

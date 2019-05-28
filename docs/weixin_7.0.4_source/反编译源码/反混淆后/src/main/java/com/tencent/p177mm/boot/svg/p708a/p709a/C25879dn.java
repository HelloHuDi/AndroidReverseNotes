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

/* renamed from: com.tencent.mm.boot.svg.a.a.dn */
public final class C25879dn extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-9473160);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 15.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.0f, 66.0f);
                l.cubicTo(51.225395f, 66.0f, 66.0f, 51.225395f, 66.0f, 33.0f);
                l.cubicTo(66.0f, 14.774603f, 51.225395f, 0.0f, 33.0f, 0.0f);
                l.cubicTo(14.774603f, 0.0f, 0.0f, 14.774603f, 0.0f, 33.0f);
                l.cubicTo(0.0f, 51.225395f, 14.774603f, 66.0f, 33.0f, 66.0f);
                l.close();
                l.moveTo(33.0f, 63.0f);
                l.cubicTo(49.568542f, 63.0f, 63.0f, 49.568542f, 63.0f, 33.0f);
                l.cubicTo(63.0f, 16.431458f, 49.568542f, 3.0f, 33.0f, 3.0f);
                l.cubicTo(16.431458f, 3.0f, 3.0f, 16.431458f, 3.0f, 33.0f);
                l.cubicTo(3.0f, 49.568542f, 16.431458f, 63.0f, 33.0f, 63.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(25.401f, 47.627f);
                l.cubicTo(20.217f, 47.627f, 16.0f, 44.08f, 16.0f, 39.72f);
                l.cubicTo(16.0f, 35.36f, 20.217f, 31.814f, 25.401f, 31.814f);
                l.cubicTo(26.23f, 31.814f, 26.901f, 32.485f, 26.901f, 33.314f);
                l.cubicTo(26.901f, 34.142f, 26.23f, 34.814f, 25.401f, 34.814f);
                l.cubicTo(21.871f, 34.814f, 19.0f, 37.015f, 19.0f, 39.72f);
                l.cubicTo(19.0f, 42.426f, 21.871f, 44.627f, 25.401f, 44.627f);
                l.cubicTo(28.931f, 44.627f, 31.802f, 42.426f, 31.802f, 39.72f);
                l.lineTo(31.802f, 26.907f);
                l.cubicTo(31.802f, 22.547f, 36.02f, 19.0f, 41.204f, 19.0f);
                l.cubicTo(46.388f, 19.0f, 50.605f, 22.547f, 50.605f, 26.907f);
                l.cubicTo(50.605f, 31.267f, 46.388f, 34.814f, 41.204f, 34.814f);
                l.cubicTo(40.375f, 34.814f, 39.704f, 34.142f, 39.704f, 33.314f);
                l.cubicTo(39.704f, 32.485f, 40.375f, 31.814f, 41.204f, 31.814f);
                l.cubicTo(44.734f, 31.814f, 47.605f, 29.612f, 47.605f, 26.907f);
                l.cubicTo(47.605f, 24.201f, 44.734f, 22.0f, 41.204f, 22.0f);
                l.cubicTo(37.674f, 22.0f, 34.802f, 24.201f, 34.802f, 26.907f);
                l.lineTo(34.802f, 39.72f);
                l.cubicTo(34.802f, 44.08f, 30.585f, 47.627f, 25.401f, 47.627f);
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

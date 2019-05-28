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

/* renamed from: com.tencent.mm.boot.svg.a.a.awu */
public final class awu extends C5163c {
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
                a.setColor(-15028967);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.74746f, 32.321507f);
                l.cubicTo(26.264082f, 37.838127f, 31.491142f, 40.425617f, 33.424133f, 40.274094f);
                l.cubicTo(35.35712f, 40.12257f, 40.170807f, 36.81219f, 42.443256f, 36.856255f);
                l.cubicTo(43.535416f, 36.87743f, 50.672344f, 41.704136f, 51.53627f, 42.26218f);
                l.cubicTo(52.400192f, 42.820225f, 53.201244f, 43.47209f, 53.050617f, 44.296967f);
                l.cubicTo(52.899994f, 45.12184f, 49.763397f, 54.207813f, 41.755672f, 52.949615f);
                l.cubicTo(33.747948f, 51.691418f, 22.584057f, 43.058952f, 16.222599f, 36.846367f);
                l.lineTo(20.74746f, 32.321507f);
                l.lineTo(20.74746f, 32.321507f);
                l.close();
                l.moveTo(20.74746f, 32.321507f);
                l.cubicTo(15.230838f, 26.804884f, 12.643348f, 21.577822f, 12.794871f, 19.644833f);
                l.cubicTo(12.946394f, 17.711843f, 16.256773f, 12.89816f, 16.212711f, 10.625708f);
                l.cubicTo(16.191534f, 9.533548f, 11.364832f, 2.3966224f, 10.806786f, 1.5326972f);
                l.cubicTo(10.248739f, 0.6687721f, 9.596872f, -0.13227762f, 8.771998f, 0.01834671f);
                l.cubicTo(7.947124f, 0.16897105f, -1.1388476f, 3.3055677f, 0.11935101f, 11.313293f);
                l.cubicTo(1.3775496f, 19.32102f, 10.010014f, 30.48491f, 16.222599f, 36.846367f);
                l.lineTo(20.74746f, 32.321507f);
                l.close();
                l.moveTo(28.0f, 3.8234966f);
                l.cubicTo(28.0f, 3.368692f, 28.384283f, 3.0f, 28.856068f, 3.0f);
                l.lineTo(45.143932f, 3.0f);
                l.cubicTo(45.616726f, 3.0f, 46.0f, 3.36727f, 46.0f, 3.8234966f);
                l.lineTo(46.0f, 16.176504f);
                l.cubicTo(46.0f, 16.631308f, 45.61572f, 17.0f, 45.143932f, 17.0f);
                l.lineTo(28.856068f, 17.0f);
                l.cubicTo(28.383274f, 17.0f, 28.0f, 16.63273f, 28.0f, 16.176504f);
                l.lineTo(28.0f, 3.8234966f);
                l.close();
                l.moveTo(54.6875f, 17.939888f);
                l.cubicTo(55.392006f, 18.168455f, 56.0f, 17.719242f, 56.0f, 17.031927f);
                l.lineTo(56.0f, 2.9585342f);
                l.cubicTo(56.0f, 2.189203f, 55.327656f, 1.8663305f, 54.6875f, 2.0505733f);
                l.cubicTo(54.307777f, 2.3871007f, 51.20473f, 5.3116455f, 49.0f, 7.3502574f);
                l.lineTo(49.0f, 12.586108f);
                l.cubicTo(51.2585f, 14.652606f, 54.430782f, 17.66358f, 54.6875f, 17.939888f);
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

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

/* renamed from: com.tencent.mm.boot.svg.a.a.pz */
public final class C6369pz extends C5163c {
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
                a.setColor(-9538696);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.0f, 55.0f);
                l.lineTo(46.0f, 55.578f);
                l.lineTo(46.215f, 56.114f);
                l.lineTo(47.769f, 60.0f);
                l.lineTo(33.231f, 60.0f);
                l.lineTo(34.785f, 56.114f);
                l.lineTo(35.0f, 55.578f);
                l.lineTo(35.0f, 55.0f);
                l.lineTo(46.0f, 55.0f);
                l.lineTo(46.0f, 55.0f);
                l.close();
                l.moveTo(3.0f, 4.44f);
                l.cubicTo(3.0f, 3.645f, 3.64f, 3.0f, 4.445f, 3.0f);
                l.lineTo(75.555f, 3.0f);
                l.cubicTo(76.353f, 3.0f, 77.0f, 3.637f, 77.0f, 4.44f);
                l.lineTo(77.0f, 29.0f);
                l.lineTo(80.0f, 29.0f);
                l.lineTo(80.0f, 4.316f);
                l.cubicTo(80.0f, 1.925f, 78.068f, 0.0f, 75.685f, 0.0f);
                l.lineTo(4.315f, 0.0f);
                l.cubicTo(1.938f, 0.0f, 0.0f, 1.932f, 0.0f, 4.316f);
                l.lineTo(0.0f, 50.684f);
                l.cubicTo(0.0f, 53.075f, 1.932f, 55.0f, 4.315f, 55.0f);
                l.lineTo(32.0f, 55.0f);
                l.lineTo(30.0f, 60.0f);
                l.lineTo(26.0f, 62.0f);
                l.lineTo(26.0f, 63.0f);
                l.lineTo(55.0f, 63.0f);
                l.lineTo(55.0f, 62.0f);
                l.lineTo(51.0f, 60.0f);
                l.lineTo(49.0f, 55.0f);
                l.lineTo(59.0f, 55.0f);
                l.lineTo(59.0f, 52.0f);
                l.lineTo(49.0f, 52.0f);
                l.lineTo(32.0f, 52.0f);
                l.lineTo(4.445f, 52.0f);
                l.cubicTo(3.647f, 52.0f, 3.0f, 51.363f, 3.0f, 50.56f);
                l.lineTo(3.0f, 43.0f);
                l.lineTo(59.0f, 43.0f);
                l.lineTo(59.0f, 40.0f);
                l.lineTo(3.0f, 40.0f);
                l.lineTo(3.0f, 4.44f);
                l.lineTo(3.0f, 4.44f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(65.0f, 60.0f);
                l.lineTo(84.0f, 60.0f);
                l.lineTo(84.0f, 46.0f);
                l.lineTo(65.0f, 46.0f);
                l.lineTo(65.0f, 60.0f);
                l.close();
                l.moveTo(69.0f, 37.0f);
                l.cubicTo(69.0f, 35.895f, 69.9f, 35.0f, 70.992f, 35.0f);
                l.lineTo(78.008f, 35.0f);
                l.cubicTo(79.108f, 35.0f, 80.0f, 35.887f, 80.0f, 37.0f);
                l.lineTo(80.0f, 43.0f);
                l.lineTo(69.0f, 43.0f);
                l.lineTo(69.0f, 37.0f);
                l.close();
                l.moveTo(84.132f, 43.0f);
                l.lineTo(83.0f, 43.0f);
                l.lineTo(83.0f, 37.754f);
                l.cubicTo(83.0f, 34.574f, 80.423f, 32.0f, 77.245f, 32.0f);
                l.lineTo(71.755f, 32.0f);
                l.cubicTo(68.582f, 32.0f, 66.0f, 34.576f, 66.0f, 37.754f);
                l.lineTo(66.0f, 43.0f);
                l.lineTo(64.868f, 43.0f);
                l.cubicTo(63.291f, 43.0f, 62.0f, 44.292f, 62.0f, 45.887f);
                l.lineTo(62.0f, 60.113f);
                l.cubicTo(62.0f, 61.718f, 63.284f, 63.0f, 64.868f, 63.0f);
                l.lineTo(84.132f, 63.0f);
                l.cubicTo(85.709f, 63.0f, 87.0f, 61.708f, 87.0f, 60.113f);
                l.lineTo(87.0f, 45.887f);
                l.cubicTo(87.0f, 44.281f, 85.716f, 43.0f, 84.132f, 43.0f);
                l.lineTo(84.132f, 43.0f);
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

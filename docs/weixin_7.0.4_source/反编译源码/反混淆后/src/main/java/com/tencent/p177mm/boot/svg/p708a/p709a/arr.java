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

/* renamed from: com.tencent.mm.boot.svg.a.a.arr */
public final class arr extends C5163c {
    private final int height = 78;
    private final int width = 78;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, -326.0f, 0.0f, 1.0f, -362.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 362.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 228.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-11184811);
                a2.setStrokeWidth(3.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(28.72093f, 39.7907f);
                l.cubicTo(33.18872f, 47.180103f, 26.14078f, 50.233418f, 22.39535f, 52.44186f);
                l.cubicTo(10.53354f, 59.134026f, 5.0f, 61.832302f, 5.0f, 65.093025f);
                l.lineTo(5.0f, 69.83721f);
                l.cubicTo(5.0f, 71.6663f, 6.1515117f, 73.0f, 8.16279f, 73.0f);
                l.lineTo(69.83721f, 73.0f);
                l.cubicTo(71.84849f, 73.0f, 73.0f, 71.6663f, 73.0f, 69.83721f);
                l.lineTo(73.0f, 65.093025f);
                l.cubicTo(73.0f, 61.832302f, 67.46646f, 59.134026f, 55.604652f, 52.44186f);
                l.cubicTo(51.859222f, 50.233418f, 44.81128f, 47.180103f, 49.279068f, 39.7907f);
                l.cubicTo(52.82625f, 34.83821f, 55.76787f, 32.557747f, 55.604652f, 23.976744f);
                l.cubicTo(55.76787f, 14.310931f, 49.19635f, 5.0f, 39.7907f, 5.0f);
                l.cubicTo(28.803648f, 5.0f, 22.232128f, 14.310931f, 22.39535f, 23.976744f);
                l.cubicTo(22.232128f, 32.557747f, 25.173754f, 34.83821f, 28.72093f, 39.7907f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-11184811);
                l = C5163c.m7884l(looper);
                l.moveTo(33.032784f, 62.02452f);
                l.cubicTo(32.495216f, 63.592533f, 33.032784f, 65.79082f, 34.231796f, 66.93293f);
                l.lineTo(37.862457f, 70.39129f);
                l.cubicTo(38.465904f, 70.9661f, 39.44163f, 70.9806f, 40.061115f, 70.40576f);
                l.lineTo(43.83273f, 66.90594f);
                l.cubicTo(45.048244f, 65.778015f, 45.590824f, 63.605457f, 45.03445f, 62.02452f);
                l.lineTo(38.955097f, 44.75f);
                l.lineTo(33.032784f, 62.02452f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

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

/* renamed from: com.tencent.mm.boot.svg.a.a.bao */
public final class bao extends C5163c {
    private final int height = 36;
    private final int width = 45;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 36;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-9205837);
                a2.setStrokeWidth(3.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 19.0f);
                l.lineTo(0.0f, 10.0f);
                l.lineTo(4.0f, 10.0f);
                l.cubicTo(4.0f, 10.0f, 6.2209473f, 10.146362f, 7.607544f, 9.330322f);
                l.cubicTo(10.395386f, 7.628418f, 23.0f, 0.0f, 23.0f, 0.0f);
                l.lineTo(23.0f, 19.0f);
                l.lineTo(23.0f, 36.0f);
                l.cubicTo(23.0f, 36.0f, 10.395386f, 28.371582f, 7.607544f, 26.669678f);
                l.cubicTo(6.2209473f, 25.853638f, 4.0f, 26.0f, 4.0f, 26.0f);
                l.lineTo(0.0f, 26.0f);
                l.lineTo(0.0f, 19.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-9205837);
                l = C5163c.m7884l(looper);
                l.moveTo(28.0f, 8.608248f);
                l.cubicTo(31.119555f, 6.412371f, 34.228916f, 4.195876f, 37.338276f, 2.0f);
                l.cubicTo(37.888786f, 2.7938144f, 38.44949f, 3.5876288f, 39.0f, 4.371134f);
                l.cubicTo(35.880444f, 6.587629f, 32.76089f, 8.804124f, 29.641335f, 11.0f);
                l.cubicTo(29.223354f, 10.402061f, 28.407785f, 9.206185f, 28.0f, 8.608248f);
                l.lineTo(28.0f, 8.608248f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-9205837);
                l = C5163c.m7884l(looper);
                l.moveTo(29.0f, 17.007513f);
                l.cubicTo(32.666668f, 16.997496f, 36.333332f, 16.997496f, 40.0f, 17.007513f);
                l.lineTo(40.0f, 19.992487f);
                l.cubicTo(36.333332f, 20.002504f, 32.666668f, 20.002504f, 29.0f, 19.992487f);
                l.lineTo(29.0f, 17.007513f);
                l.lineTo(29.0f, 17.007513f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-9205837);
                l = C5163c.m7884l(looper);
                l.moveTo(29.381166f, 26.0f);
                l.cubicTo(32.587444f, 27.870647f, 35.79372f, 29.731344f, 39.0f, 31.61194f);
                l.cubicTo(38.63498f, 32.208954f, 37.9148f, 33.402985f, 37.549774f, 34.0f);
                l.cubicTo(34.363228f, 32.159203f, 31.186546f, 30.298508f, 28.0f, 28.447762f);
                l.cubicTo(28.463676f, 27.631842f, 28.927355f, 26.81592f, 29.381166f, 26.0f);
                l.lineTo(29.381166f, 26.0f);
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

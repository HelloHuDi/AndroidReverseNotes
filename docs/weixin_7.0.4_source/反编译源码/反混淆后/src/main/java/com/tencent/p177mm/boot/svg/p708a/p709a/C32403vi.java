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

/* renamed from: com.tencent.mm.boot.svg.a.a.vi */
public final class C32403vi extends C5163c {
    private final int height = 68;
    private final int width = 68;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 68;
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
                g = C5163c.m7878a(g, 1.1333333f, 0.0f, 0.0f, 0.0f, 1.1333333f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = C5163c.m7884l(looper);
                l.moveTo(24.0f, 6.0f);
                l.lineTo(24.0f, 13.582962f);
                l.cubicTo(24.0f, 16.068243f, 26.014719f, 18.082962f, 28.5f, 18.082962f);
                l.cubicTo(30.985281f, 18.082962f, 33.0f, 16.068243f, 33.0f, 13.582962f);
                l.lineTo(33.0f, 6.0f);
                l.cubicTo(36.54742f, 7.710701f, 39.0f, 11.381189f, 39.0f, 15.633177f);
                l.cubicTo(39.0f, 19.693186f, 36.763893f, 23.223017f, 33.473682f, 25.022778f);
                l.lineTo(33.473682f, 49.026318f);
                l.cubicTo(33.473682f, 51.773205f, 31.24689f, 54.0f, 28.5f, 54.0f);
                l.cubicTo(25.75311f, 54.0f, 23.526316f, 51.773205f, 23.526316f, 49.026318f);
                l.lineTo(23.526316f, 25.022778f);
                l.cubicTo(20.236107f, 23.223017f, 18.0f, 19.693186f, 18.0f, 15.633177f);
                l.cubicTo(18.0f, 11.381189f, 20.45258f, 7.710701f, 24.0f, 6.0f);
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

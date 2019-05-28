package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aer extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-2500135);
                g = c.a(g, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 21.0f);
                l.cubicTo(6.541142f, 9.067516f, 19.195314f, 0.2773516f, 33.0f, -3.5527137E-15f);
                l.cubicTo(47.47057f, -0.56266415f, 61.090485f, 8.457505f, 68.0f, 21.0f);
                l.cubicTo(61.279648f, 33.217968f, 48.147583f, 42.128136f, 34.0f, 42.0f);
                l.cubicTo(19.862371f, 42.148136f, 6.7402635f, 33.23797f, 0.0f, 21.0f);
                l.lineTo(0.0f, 21.0f);
                l.close();
                l.moveTo(30.0f, 10.0f);
                l.cubicTo(26.510271f, 10.850008f, 23.349888f, 14.148959f, 22.0f, 18.0f);
                l.cubicTo(20.448715f, 24.932842f, 25.872211f, 32.447674f, 33.0f, 33.0f);
                l.cubicTo(40.05904f, 33.833035f, 46.808502f, 27.08563f, 46.0f, 20.0f);
                l.cubicTo(45.492508f, 12.574233f, 37.337322f, 7.1324587f, 30.0f, 10.0f);
                l.lineTo(30.0f, 10.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

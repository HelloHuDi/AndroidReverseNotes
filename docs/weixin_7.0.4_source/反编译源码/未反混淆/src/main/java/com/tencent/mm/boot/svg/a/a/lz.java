package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class lz extends c {
    private final int height = 48;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 48;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k2 = c.a(k, looper);
                k2.setColor(-16896);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(1.492238E-12f, 4.7575727f);
                l.lineTo(1.4921397E-12f, 1.44f);
                l.lineTo(1.4923618E-12f, 1.44f);
                l.cubicTo(1.4922644E-12f, 0.64470994f, 0.64470994f, 5.0310737E-15f, 1.44f, 4.8849813E-15f);
                l.lineTo(1.44f, 7.1054274E-15f);
                l.lineTo(64.185f, 7.1054274E-15f);
                l.lineTo(64.185f, 7.327472E-15f);
                l.cubicTo(64.98029f, 7.18138E-15f, 65.625f, 0.64470994f, 65.625f, 1.44f);
                l.lineTo(65.625f, 4.7563457f);
                l.cubicTo(63.938255f, 4.842435f, 62.5987f, 6.156979f, 62.5987f, 7.7659883f);
                l.cubicTo(62.5987f, 9.374997f, 63.938255f, 10.689542f, 65.625f, 10.775631f);
                l.lineTo(65.625f, 15.712849f);
                l.cubicTo(63.938255f, 15.798938f, 62.5987f, 17.113482f, 62.5987f, 18.72249f);
                l.cubicTo(62.5987f, 20.331501f, 63.938255f, 21.646044f, 65.625f, 21.732134f);
                l.lineTo(65.625f, 26.669352f);
                l.cubicTo(63.938255f, 26.75544f, 62.5987f, 28.069984f, 62.5987f, 29.678993f);
                l.cubicTo(62.5987f, 31.288002f, 63.938255f, 32.602547f, 65.625f, 32.688637f);
                l.lineTo(65.625f, 37.625854f);
                l.cubicTo(63.938255f, 37.71194f, 62.5987f, 39.026485f, 62.5987f, 40.635494f);
                l.cubicTo(62.5987f, 42.244507f, 63.938255f, 43.559048f, 65.625f, 43.645138f);
                l.lineTo(65.625f, 46.442352f);
                l.cubicTo(65.625f, 47.237644f, 64.98029f, 47.882355f, 64.185f, 47.882355f);
                l.lineTo(1.44f, 47.882355f);
                l.lineTo(1.44f, 47.882355f);
                l.cubicTo(0.64470994f, 47.882355f, 1.4935694E-12f, 47.237644f, 1.493472E-12f, 46.442352f);
                l.lineTo(1.4933892E-12f, 43.643913f);
                l.cubicTo(1.6761057f, 43.547302f, 3.0037231f, 42.23732f, 3.0037231f, 40.635494f);
                l.cubicTo(3.0037231f, 39.033672f, 1.6761057f, 37.72369f, 1.5209084E-12f, 37.62708f);
                l.lineTo(1.4930648E-12f, 32.68741f);
                l.cubicTo(1.6761057f, 32.5908f, 3.0037231f, 31.280817f, 3.0037231f, 29.678993f);
                l.cubicTo(3.0037231f, 28.07717f, 1.6761057f, 26.767185f, 1.5221574E-12f, 26.670578f);
                l.lineTo(1.4927405E-12f, 21.730906f);
                l.cubicTo(1.6761057f, 21.634298f, 3.0037231f, 20.324316f, 3.0037231f, 18.72249f);
                l.cubicTo(3.0037231f, 17.120667f, 1.6761057f, 15.810683f, 1.5217966E-12f, 15.714075f);
                l.lineTo(1.4924161E-12f, 10.774404f);
                l.cubicTo(1.6761057f, 10.677795f, 3.0037231f, 9.367813f, 3.0037231f, 7.7659883f);
                l.cubicTo(3.0037231f, 6.1641636f, 1.6761057f, 4.854181f, 1.5213941E-12f, 4.7575727f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(28.410238f, 24.652752f);
                l.cubicTo(30.052023f, 27.348827f, 27.201754f, 28.510988f, 25.74895f, 29.66224f);
                l.cubicTo(20.890003f, 31.898764f, 18.652174f, 32.92579f, 18.652174f, 33.83681f);
                l.lineTo(18.652174f, 36.25749f);
                l.lineTo(18.652174f, 36.25749f);
                l.cubicTo(18.652174f, 36.76503f, 19.063616f, 37.17647f, 19.571156f, 37.17647f);
                l.lineTo(45.233192f, 37.17647f);
                l.lineTo(45.233192f, 37.17647f);
                l.cubicTo(45.74073f, 37.17647f, 46.152172f, 36.76503f, 46.152172f, 36.25749f);
                l.lineTo(46.152172f, 33.83681f);
                l.cubicTo(46.152172f, 32.92579f, 43.914345f, 31.898764f, 39.0554f, 29.66224f);
                l.cubicTo(37.602592f, 28.510988f, 34.752323f, 27.348827f, 36.394108f, 24.652752f);
                l.cubicTo(37.99367f, 22.651222f, 39.1833f, 21.783226f, 39.0554f, 17.973434f);
                l.cubicTo(39.1833f, 14.838071f, 36.5257f, 11.294118f, 32.845722f, 11.294118f);
                l.cubicTo(28.27865f, 11.294118f, 25.62105f, 14.838071f, 25.74895f, 17.973434f);
                l.cubicTo(25.62105f, 21.783226f, 26.810677f, 22.651222f, 28.410238f, 24.652752f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

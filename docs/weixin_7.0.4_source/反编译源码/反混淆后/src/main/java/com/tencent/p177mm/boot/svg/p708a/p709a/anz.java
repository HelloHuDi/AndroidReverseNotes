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

/* renamed from: com.tencent.mm.boot.svg.a.a.anz */
public final class anz extends C5163c {
    private final int height = 168;
    private final int width = 168;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                a.setColor(-8617594);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 50.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(53.458427f, 68.67285f);
                l.cubicTo(83.84122f, 68.67285f, 105.827965f, 35.957947f, 105.827965f, 35.957947f);
                l.cubicTo(106.46974f, 35.062405f, 106.47585f, 33.603374f, 105.81945f, 32.703407f);
                l.cubicTo(105.81945f, 32.703407f, 83.84122f, 2.4963452E-15f, 53.458427f, 0.0f);
                l.cubicTo(23.075638f, -2.4963452E-15f, 1.0888885f, 32.714905f, 1.0888885f, 32.714905f);
                l.cubicTo(0.4471118f, 33.610447f, 0.44100174f, 35.069477f, 1.0974094f, 35.969444f);
                l.cubicTo(1.0974094f, 35.969444f, 23.075642f, 68.67285f, 53.458427f, 68.67285f);
                l.close();
                l.moveTo(53.458427f, 54.626133f);
                l.cubicTo(64.858315f, 54.626133f, 74.09975f, 45.54212f, 74.09975f, 34.336426f);
                l.cubicTo(74.09975f, 23.13073f, 64.858315f, 14.04672f, 53.458427f, 14.04672f);
                l.cubicTo(42.058544f, 14.04672f, 32.817112f, 23.13073f, 32.817112f, 34.336426f);
                l.cubicTo(32.817112f, 45.54212f, 42.058544f, 54.626133f, 53.458427f, 54.626133f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(41.175587f, 25.24117f);
                l.cubicTo(39.181583f, 27.849945f, 38.0f, 31.093002f, 38.0f, 34.607468f);
                l.cubicTo(38.0f, 43.22759f, 45.10843f, 50.21493f, 53.877937f, 50.21493f);
                l.cubicTo(62.64744f, 50.21493f, 69.755875f, 43.22759f, 69.755875f, 34.607468f);
                l.cubicTo(69.755875f, 25.987343f, 62.64744f, 19.0f, 53.877937f, 19.0f);
                l.cubicTo(51.33193f, 19.0f, 48.92593f, 19.588953f, 46.793247f, 20.635828f);
                l.cubicTo(49.016388f, 21.031485f, 50.702347f, 22.943605f, 50.702347f, 25.242987f);
                l.cubicTo(50.702347f, 27.829023f, 48.56982f, 29.925226f, 45.93897f, 29.925226f);
                l.cubicTo(43.308117f, 29.925226f, 41.175587f, 27.829023f, 41.175587f, 25.242987f);
                l.cubicTo(41.175587f, 25.24238f, 41.175587f, 25.241776f, 41.175587f, 25.24117f);
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

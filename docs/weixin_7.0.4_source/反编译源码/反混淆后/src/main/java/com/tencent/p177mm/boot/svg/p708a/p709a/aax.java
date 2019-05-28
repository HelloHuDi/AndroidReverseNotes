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

/* renamed from: com.tencent.mm.boot.svg.a.a.aax */
public final class aax extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.6f, 12.6f);
                l.lineTo(3.6f, 59.4f);
                l.lineTo(32.4f, 59.4f);
                l.lineTo(32.4f, 39.0f);
                l.lineTo(36.0f, 39.0f);
                l.lineTo(36.0f, 60.0f);
                l.cubicTo(36.0f, 61.656853f, 34.656853f, 63.0f, 33.0f, 63.0f);
                l.lineTo(3.0f, 63.0f);
                l.cubicTo(1.3431457f, 63.0f, 2.0290612E-16f, 61.656853f, 0.0f, 60.0f);
                l.lineTo(0.0f, 12.0f);
                l.cubicTo(-2.0290612E-16f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                l.lineTo(9.0f, 9.0f);
                l.lineTo(9.0f, 12.6f);
                l.lineTo(3.6f, 12.6f);
                l.close();
                l.moveTo(16.11055f, 1.2103083f);
                l.lineTo(19.060284f, 1.2103083f);
                l.cubicTo(19.474497f, 1.2103083f, 19.810284f, 1.5460948f, 19.810284f, 1.9603083f);
                l.cubicTo(19.810284f, 1.9685472f, 19.810148f, 1.9767857f, 19.809877f, 1.9850202f);
                l.lineTo(19.409327f, 14.13502f);
                l.cubicTo(19.395996f, 14.539394f, 19.06433f, 14.860309f, 18.659735f, 14.860309f);
                l.lineTo(16.511099f, 14.860309f);
                l.cubicTo(16.106504f, 14.860309f, 15.774837f, 14.539394f, 15.761506f, 14.13502f);
                l.lineTo(15.360956f, 1.9850202f);
                l.cubicTo(15.347308f, 1.5710315f, 15.671849f, 1.2243634f, 16.085838f, 1.2107155f);
                l.cubicTo(16.094072f, 1.2104441f, 16.10231f, 1.2103083f, 16.11055f, 1.2103083f);
                l.close();
                l.moveTo(35.839252f, 8.160385f);
                l.lineTo(37.92503f, 10.246162f);
                l.cubicTo(38.217926f, 10.539056f, 38.217926f, 11.013929f, 37.92503f, 11.306823f);
                l.cubicTo(37.919205f, 11.312649f, 37.913284f, 11.318378f, 37.90727f, 11.324009f);
                l.lineTo(29.03269f, 19.632124f);
                l.cubicTo(28.73733f, 19.908634f, 28.275883f, 19.90103f, 27.989792f, 19.614939f);
                l.lineTo(26.470478f, 18.095625f);
                l.cubicTo(26.184387f, 17.809532f, 26.176783f, 17.348087f, 26.45329f, 17.052727f);
                l.lineTo(34.76141f, 8.178147f);
                l.cubicTo(35.04449f, 7.8757625f, 35.519108f, 7.8601155f, 35.82149f, 8.143199f);
                l.cubicTo(35.827507f, 8.14883f, 35.833427f, 8.154559f, 35.839252f, 8.160385f);
                l.close();
                l.moveTo(44.875107f, 27.025133f);
                l.lineTo(44.875107f, 29.974867f);
                l.cubicTo(44.875107f, 30.38908f, 44.53932f, 30.724867f, 44.125107f, 30.724867f);
                l.cubicTo(44.11687f, 30.724867f, 44.10863f, 30.724731f, 44.100395f, 30.72446f);
                l.lineTo(31.950396f, 30.32391f);
                l.cubicTo(31.546022f, 30.31058f, 31.22511f, 29.978912f, 31.22511f, 29.574318f);
                l.lineTo(31.22511f, 27.425682f);
                l.cubicTo(31.22511f, 27.021088f, 31.546022f, 26.68942f, 31.950396f, 26.67609f);
                l.lineTo(44.100395f, 26.27554f);
                l.cubicTo(44.514385f, 26.261892f, 44.861053f, 26.586432f, 44.874702f, 27.000422f);
                l.cubicTo(44.874973f, 27.008656f, 44.875107f, 27.016893f, 44.875107f, 27.025133f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

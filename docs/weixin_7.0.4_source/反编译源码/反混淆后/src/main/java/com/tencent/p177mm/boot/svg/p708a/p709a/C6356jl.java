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

/* renamed from: com.tencent.mm.boot.svg.a.a.jl */
public final class C6356jl extends C5163c {
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
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 10.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-8617851);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(32.9052f, 39.8588f);
                l.cubicTo(33.5872f, 40.15305f, 34.10695f, 39.579674f, 34.364075f, 39.163048f);
                l.lineTo(35.824326f, 37.07992f);
                l.cubicTo(36.377075f, 36.140797f, 36.22995f, 35.869923f, 35.824326f, 35.689796f);
                l.cubicTo(35.252327f, 35.435425f, 35.054325f, 35.578423f, 34.364075f, 36.384174f);
                l.lineTo(32.9052f, 38.470047f);
                l.cubicTo(32.64945f, 38.88255f, 32.496826f, 39.681423f, 32.9052f, 39.8588f);
                l.lineTo(32.9052f, 39.8588f);
                l.close();
                l.moveTo(46.6607f, 39.015923f);
                l.cubicTo(48.523827f, 42.02305f, 46.255074f, 46.432674f, 42.10395f, 46.478046f);
                l.cubicTo(37.88545f, 46.52205f, 30.714825f, 39.8588f, 30.714825f, 39.8588f);
                l.lineTo(34.364075f, 32.910923f);
                l.cubicTo(34.364075f, 32.910923f, 44.772823f, 35.96755f, 46.6607f, 39.015923f);
                l.lineTo(46.6607f, 39.015923f);
                l.close();
                l.moveTo(42.3927f, 19.708174f);
                l.cubicTo(45.130325f, 24.813547f, 44.440075f, 29.763548f, 43.12145f, 34.30105f);
                l.cubicTo(41.1882f, 33.16392f, 40.485577f, 32.631798f, 39.4722f, 32.21517f);
                l.cubicTo(39.855824f, 30.103172f, 39.43645f, 29.568298f, 38.74345f, 26.656048f);
                l.cubicTo(37.273575f, 20.468548f, 29.613451f, 16.426048f, 21.958826f, 17.623672f);
                l.cubicTo(14.11445f, 18.851547f, 10.813075f, 27.984299f, 12.6707f, 35.219547f);
                l.cubicTo(14.39495f, 41.929546f, 17.600075f, 45.61592f, 24.147825f, 48.196796f);
                l.cubicTo(24.147825f, 48.196796f, 25.239574f, 50.98392f, 26.3382f, 53.060173f);
                l.cubicTo(27.425825f, 55.11855f, 29.257326f, 57.22917f, 29.257326f, 57.22917f);
                l.cubicTo(24.16295f, 56.82905f, 9.15895f, 50.127296f, 3.4307003f, 40.51605f);
                l.cubicTo(-2.2947998f, 30.904799f, -1.2442998f, 18.309797f, 9.5535755f, 11.368798f);
                l.cubicTo(20.42295f, 4.386548f, 36.872074f, 9.410798f, 42.3927f, 19.708174f);
                l.lineTo(42.3927f, 19.708174f);
                l.close();
                l.moveTo(52.61995f, 11.374298f);
                l.cubicTo(48.23095f, 14.465298f, 45.361324f, 18.084297f, 43.851574f, 21.794048f);
                l.cubicTo(42.831326f, 17.757048f, 40.25045f, 14.191673f, 36.553074f, 12.065923f);
                l.cubicTo(41.01495f, 4.9489226f, 46.541077f, 2.116423f, 53.3377f, 0.94904786f);
                l.cubicTo(58.10345f, 1.7960478f, 64.21258f, 2.900173f, 67.93195f, 5.8124228f);
                l.cubicTo(63.604824f, 5.919673f, 58.500824f, 7.235548f, 52.61995f, 11.374298f);
                l.lineTo(52.61995f, 11.374298f);
                l.close();
                l.moveTo(76.68932f, 47.502422f);
                l.cubicTo(63.8042f, 59.665672f, 57.090076f, 65.93705f, 50.418575f, 75.29668f);
                l.cubicTo(49.258076f, 72.3143f, 46.9852f, 71.4453f, 46.0392f, 69.04455f);
                l.cubicTo(45.0987f, 66.64517f, 46.329327f, 64.92642f, 46.0392f, 63.485424f);
                l.cubicTo(45.75045f, 62.0458f, 44.3892f, 60.316048f, 43.120075f, 60.0108f);
                l.cubicTo(53.559074f, 46.02155f, 73.63957f, 39.956425f, 75.96058f, 22.488422f);
                l.cubicTo(78.080826f, 6.521923f, 65.39507f, 1.9184228f, 54.796574f, 0.25329787f);
                l.cubicTo(68.315575f, -1.1657021f, 79.49158f, 3.3965478f, 84.71795f, 13.456048f);
                l.cubicTo(89.19357f, 22.080048f, 89.458954f, 35.451923f, 76.68932f, 47.502422f);
                l.lineTo(76.68932f, 47.502422f);
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

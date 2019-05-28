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

/* renamed from: com.tencent.mm.boot.svg.a.a.abn */
public final class abn extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.6f, 33.0f);
                l.lineTo(42.0f, 33.0f);
                l.lineTo(42.0f, 32.1f);
                l.cubicTo(42.0f, 26.798067f, 46.029438f, 22.5f, 51.0f, 22.5f);
                l.cubicTo(53.026093f, 22.5f, 54.89581f, 23.214134f, 56.4f, 24.419296f);
                l.lineTo(56.4f, 3.6f);
                l.lineTo(3.6f, 3.6f);
                l.lineTo(3.6f, 33.0f);
                l.close();
                l.moveTo(3.6f, 36.6f);
                l.lineTo(3.6f, 41.4f);
                l.lineTo(36.0f, 41.4f);
                l.lineTo(36.0f, 36.6f);
                l.lineTo(3.6f, 36.6f);
                l.close();
                l.moveTo(56.4f, 33.0f);
                l.lineTo(56.4f, 32.1f);
                l.cubicTo(56.4f, 28.736214f, 53.92855f, 26.1f, 51.0f, 26.1f);
                l.cubicTo(48.07145f, 26.1f, 45.6f, 28.736214f, 45.6f, 32.1f);
                l.lineTo(45.6f, 33.0f);
                l.lineTo(56.4f, 33.0f);
                l.close();
                l.moveTo(36.0f, 52.5f);
                l.lineTo(20.090042f, 52.5f);
                l.cubicTo(19.926783f, 52.5f, 19.764618f, 52.473347f, 19.609945f, 52.421093f);
                l.cubicTo(18.825098f, 52.15594f, 18.4038f, 51.304752f, 18.66895f, 50.5199f);
                l.lineTo(20.533775f, 45.0f);
                l.lineTo(3.0f, 45.0f);
                l.cubicTo(1.3431457f, 45.0f, -2.962303E-15f, 43.656853f, -2.220446E-16f, 42.0f);
                l.lineTo(4.440892E-16f, 3.0f);
                l.cubicTo(2.4118308E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.lineTo(57.0f, 0.0f);
                l.cubicTo(58.656853f, -3.043592E-16f, 60.0f, 1.3431457f, 60.0f, 3.0f);
                l.lineTo(60.0f, 33.0f);
                l.lineTo(63.01381f, 33.0f);
                l.cubicTo(64.66303f, 33.0f, 66.0f, 34.340096f, 66.0f, 35.987827f);
                l.lineTo(66.0f, 52.512173f);
                l.cubicTo(66.0f, 54.162304f, 64.633f, 55.5f, 63.01381f, 55.5f);
                l.lineTo(38.98619f, 55.5f);
                l.cubicTo(37.336964f, 55.5f, 36.0f, 54.159904f, 36.0f, 52.512173f);
                l.lineTo(36.0f, 52.5f);
                l.close();
                l.moveTo(36.0f, 44.99996f);
                l.lineTo(24.33368f, 44.99996f);
                l.lineTo(23.016104f, 48.9f);
                l.lineTo(36.0f, 48.9f);
                l.lineTo(36.0f, 44.99996f);
                l.close();
                l.moveTo(39.6f, 51.9f);
                l.lineTo(62.4f, 51.9f);
                l.lineTo(62.4f, 36.6f);
                l.lineTo(39.6f, 36.6f);
                l.lineTo(39.6f, 51.9f);
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

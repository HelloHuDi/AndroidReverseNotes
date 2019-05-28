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

/* renamed from: com.tencent.mm.boot.svg.a.a.jj */
public final class C6354jj extends C5163c {
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
                a.setColor(-8617851);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(53.00009f, 8.0f);
                l.lineTo(45.00009f, 0.0f);
                l.lineTo(20.00009f, 0.0f);
                l.lineTo(12.000091f, 8.0f);
                l.lineTo(9.0277776E-5f, 8.0f);
                l.lineTo(9.0277776E-5f, 16.0f);
                l.lineTo(65.00009f, 16.0f);
                l.lineTo(65.00009f, 8.0f);
                l.lineTo(53.00009f, 8.0f);
                l.close();
                l.moveTo(12.000091f, 67.0f);
                l.lineTo(20.00009f, 67.0f);
                l.lineTo(20.00009f, 31.0f);
                l.lineTo(12.000091f, 31.0f);
                l.lineTo(12.000091f, 67.0f);
                l.close();
                l.moveTo(28.00009f, 67.0f);
                l.lineTo(36.00009f, 67.0f);
                l.lineTo(36.00009f, 31.0f);
                l.lineTo(28.00009f, 31.0f);
                l.lineTo(28.00009f, 67.0f);
                l.close();
                l.moveTo(45.00009f, 67.0f);
                l.lineTo(53.00009f, 67.0f);
                l.lineTo(53.00009f, 31.0f);
                l.lineTo(45.00009f, 31.0f);
                l.lineTo(45.00009f, 67.0f);
                l.close();
                l.moveTo(4.00009f, 68.0f);
                l.cubicTo(4.00009f, 74.53162f, 9.468924f, 80.0f, 16.00009f, 80.0f);
                l.lineTo(49.00009f, 80.0f);
                l.cubicTo(55.531708f, 80.0f, 61.00009f, 74.53162f, 61.00009f, 68.0f);
                l.lineTo(61.00009f, 23.0f);
                l.lineTo(4.00009f, 23.0f);
                l.lineTo(4.00009f, 68.0f);
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

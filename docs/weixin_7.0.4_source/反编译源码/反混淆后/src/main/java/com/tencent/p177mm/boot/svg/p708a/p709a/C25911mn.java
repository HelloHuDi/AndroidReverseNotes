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
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.mn */
public final class C25911mn extends C5163c {
    private final int height = C31128d.MIC_PTU_WU;
    private final int width = 300;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 300;
            case 1:
                return C31128d.MIC_PTU_WU;
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
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-657931);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 15.00912f);
                l.cubicTo(0.0f, 6.719812f, 6.722175f, 0.0f, 15.005396f, 0.0f);
                l.lineTo(284.9946f, 0.0f);
                l.cubicTo(293.28186f, 0.0f, 300.0f, 6.710611f, 300.0f, 15.00912f);
                l.lineTo(300.0f, 278.99088f);
                l.cubicTo(300.0f, 287.28018f, 293.27783f, 294.0f, 284.9946f, 294.0f);
                l.lineTo(15.005396f, 294.0f);
                l.cubicTo(6.718145f, 294.0f, 0.0f, 287.2894f, 0.0f, 278.99088f);
                l.lineTo(0.0f, 15.00912f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 64.0f, 0.0f, 1.0f, 83.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a4.setColor(-3552823);
                a4.setStrokeWidth(20.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 2.0f);
                l.cubicTo(0.0f, 0.89543045f, 0.89543045f, 0.0f, 2.0f, 0.0f);
                l.lineTo(163.0f, 0.0f);
                l.cubicTo(164.10457f, 0.0f, 165.0f, 0.89543045f, 165.0f, 2.0f);
                l.lineTo(165.0f, 118.0f);
                l.cubicTo(165.0f, 119.10457f, 164.10457f, 120.0f, 163.0f, 120.0f);
                l.lineTo(2.0f, 120.0f);
                l.cubicTo(0.89543045f, 120.0f, 0.0f, 119.10457f, 0.0f, 118.0f);
                l.lineTo(0.0f, 2.0f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-3552823);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(126.73595f, 64.14897f);
                l2.lineTo(103.837265f, 81.98572f);
                l2.lineTo(111.876335f, 98.63208f);
                l2.lineTo(55.73088f, 46.75f);
                l2.lineTo(2.75f, 96.57307f);
                l2.lineTo(2.75f, 119.245766f);
                l2.lineTo(162.59375f, 119.245766f);
                l2.lineTo(162.59375f, 96.57307f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

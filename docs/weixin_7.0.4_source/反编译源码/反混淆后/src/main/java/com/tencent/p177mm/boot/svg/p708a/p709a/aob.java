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

/* renamed from: com.tencent.mm.boot.svg.a.a.aob */
public final class aob extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 50.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.7979208f, 0.0f);
                l.cubicTo(0.8049566f, 0.0f, 0.0f, 0.8110437f, 0.0f, 1.8013198f);
                l.lineTo(0.0f, 66.19868f);
                l.cubicTo(0.0f, 67.19352f, 0.8120969f, 68.0f, 1.8074489f, 68.0f);
                l.lineTo(75.140465f, 68.0f);
                l.cubicTo(76.138695f, 68.0f, 76.947914f, 67.19573f, 76.947914f, 66.19761f);
                l.cubicTo(76.947914f, 66.19761f, 76.947914f, 56.10486f, 76.947914f, 49.86667f);
                l.cubicTo(76.94792f, 40.74555f, 89.0f, 34.377186f, 89.0f, 29.013332f);
                l.cubicTo(89.0f, 23.696405f, 89.0f, 1.8062787f, 89.0f, 1.8062787f);
                l.cubicTo(89.0f, 0.8086985f, 88.20341f, 0.0f, 87.20208f, 0.0f);
                l.lineTo(1.7979208f, 0.0f);
                l.lineTo(1.7979208f, 0.0f);
                l.close();
                l.moveTo(6.0f, 6.0f);
                l.lineTo(6.0f, 12.0f);
                l.lineTo(16.0f, 12.0f);
                l.lineTo(16.0f, 6.0f);
                l.lineTo(6.0f, 6.0f);
                l.lineTo(6.0f, 6.0f);
                l.close();
                l.moveTo(6.0f, 56.0f);
                l.lineTo(6.0f, 62.0f);
                l.lineTo(16.0f, 62.0f);
                l.lineTo(16.0f, 56.0f);
                l.lineTo(6.0f, 56.0f);
                l.lineTo(6.0f, 56.0f);
                l.close();
                l.moveTo(22.0f, 6.0f);
                l.lineTo(22.0f, 12.0f);
                l.lineTo(32.0f, 12.0f);
                l.lineTo(32.0f, 6.0f);
                l.lineTo(22.0f, 6.0f);
                l.lineTo(22.0f, 6.0f);
                l.close();
                l.moveTo(22.0f, 56.0f);
                l.lineTo(22.0f, 62.0f);
                l.lineTo(32.0f, 62.0f);
                l.lineTo(32.0f, 56.0f);
                l.lineTo(22.0f, 56.0f);
                l.lineTo(22.0f, 56.0f);
                l.close();
                l.moveTo(38.0f, 6.0f);
                l.lineTo(38.0f, 12.0f);
                l.lineTo(48.0f, 12.0f);
                l.lineTo(48.0f, 6.0f);
                l.lineTo(38.0f, 6.0f);
                l.lineTo(38.0f, 6.0f);
                l.close();
                l.moveTo(38.0f, 56.0f);
                l.lineTo(38.0f, 62.0f);
                l.lineTo(48.0f, 62.0f);
                l.lineTo(48.0f, 56.0f);
                l.lineTo(38.0f, 56.0f);
                l.lineTo(38.0f, 56.0f);
                l.close();
                l.moveTo(54.0f, 6.0f);
                l.lineTo(54.0f, 12.0f);
                l.lineTo(64.0f, 12.0f);
                l.lineTo(64.0f, 6.0f);
                l.lineTo(54.0f, 6.0f);
                l.lineTo(54.0f, 6.0f);
                l.close();
                l.moveTo(54.0f, 56.0f);
                l.lineTo(54.0f, 62.0f);
                l.lineTo(64.0f, 62.0f);
                l.lineTo(64.0f, 56.0f);
                l.lineTo(54.0f, 56.0f);
                l.lineTo(54.0f, 56.0f);
                l.close();
                l.moveTo(70.0f, 6.0f);
                l.lineTo(70.0f, 12.0f);
                l.lineTo(80.0f, 12.0f);
                l.lineTo(80.0f, 6.0f);
                l.lineTo(70.0f, 6.0f);
                l.lineTo(70.0f, 6.0f);
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

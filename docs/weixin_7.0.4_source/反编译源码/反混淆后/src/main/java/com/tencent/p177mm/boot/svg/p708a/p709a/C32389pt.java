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
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.pt */
public final class C32389pt extends C5163c {
    private final int height = C31128d.MIC_PTU_ZIPAI_LIGHTWHITE;
    private final int width = 357;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 357;
            case 1:
                return C31128d.MIC_PTU_ZIPAI_LIGHTWHITE;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.0f, 0.0f);
                l.lineTo(21.0f, 0.0f);
                l.lineTo(21.0f, 245.0f);
                l.lineTo(20.0f, 245.0f);
                l.lineTo(20.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(335.0f, 0.0f);
                l2.lineTo(336.0f, 0.0f);
                l2.lineTo(336.0f, 245.0f);
                l2.lineTo(335.0f, 245.0f);
                l2.lineTo(335.0f, 0.0f);
                l2.close();
                canvas.drawPath(l2, k);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(a, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k.setStrokeWidth(3.0f);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(8.790844f, 1.5f);
                l2.lineTo(1.506977f, 243.5f);
                l2.lineTo(355.493f, 243.5f);
                l2.lineTo(348.20917f, 1.5f);
                l2.lineTo(8.790844f, 1.5f);
                l2.close();
                canvas.drawPath(l2, k);
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 25.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = C5163c.m7876a(a2, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(-0.5f, -0.5f);
                l2.lineTo(285.5f, -0.5f);
                l2.lineTo(285.5f, 192.5f);
                l2.lineTo(-0.5f, 192.5f);
                l2.lineTo(-0.5f, -0.5f);
                l2.close();
                canvas.drawPath(l2, k);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                a.setStrokeWidth(2.0f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 134.0f, 0.0f, 1.0f, 97.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(1.0f, 3.0f);
                l3.cubicTo(1.0f, 1.8954304f, 1.8954304f, 1.0f, 3.0f, 1.0f);
                l3.lineTo(66.0f, 1.0f);
                l3.cubicTo(67.10457f, 1.0f, 68.0f, 1.8954304f, 68.0f, 3.0f);
                l3.lineTo(68.0f, 49.0f);
                l3.cubicTo(68.0f, 50.10457f, 67.10457f, 51.0f, 66.0f, 51.0f);
                l3.lineTo(3.0f, 51.0f);
                l3.cubicTo(1.8954304f, 51.0f, 1.0f, 50.10457f, 1.0f, 49.0f);
                l3.lineTo(1.0f, 3.0f);
                l3.close();
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l3 = C5163c.m7884l(looper);
                l3.moveTo(99.0f, 50.07509f);
                l3.lineTo(99.0f, 2.0108225f);
                l3.lineTo(75.39577f, 19.873486f);
                l3.cubicTo(75.21011f, 20.013983f, 75.0f, 20.437353f, 75.0f, 20.675142f);
                l3.lineTo(75.0f, 32.730263f);
                l3.cubicTo(75.0f, 32.953712f, 75.21011f, 33.357872f, 75.39602f, 33.488506f);
                l3.lineTo(99.0f, 50.07509f);
                l3.close();
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

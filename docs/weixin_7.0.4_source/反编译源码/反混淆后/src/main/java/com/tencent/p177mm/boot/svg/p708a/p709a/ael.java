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

/* renamed from: com.tencent.mm.boot.svg.a.a.ael */
public final class ael extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-15028967);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -69.0f, 0.0f, 1.0f, -98.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 69.0f, 0.0f, 1.0f, 98.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 6.0063868f);
                l.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0063868f, 0.0f);
                l.lineTo(41.993614f, 0.0f);
                l.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0063868f);
                l.lineTo(48.0f, 41.993614f);
                l.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 41.993614f, 48.0f);
                l.lineTo(6.0063868f, 48.0f);
                l.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 41.993614f);
                l.lineTo(0.0f, 6.0063868f);
                l.lineTo(0.0f, 6.0063868f);
                l.close();
                l.moveTo(6.0f, 26.576923f);
                l.lineTo(10.2f, 22.538462f);
                l.lineTo(19.0f, 30.923077f);
                l.lineTo(37.8f, 13.0f);
                l.lineTo(42.0f, 17.038462f);
                l.lineTo(19.0f, 39.0f);
                l.lineTo(6.0f, 26.576923f);
                l.lineTo(6.0f, 26.576923f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

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

/* renamed from: com.tencent.mm.boot.svg.a.a.axh */
public final class axh extends C5163c {
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(0);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                float[] a = C5163c.m7878a(g, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-499359);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(27.0f, 0.0f);
                l2.cubicTo(41.91169f, 0.0f, 54.0f, 12.088311f, 54.0f, 27.0f);
                l2.cubicTo(54.0f, 41.91169f, 41.91169f, 54.0f, 27.0f, 54.0f);
                l2.cubicTo(12.088311f, 54.0f, 0.0f, 41.91169f, 0.0f, 27.0f);
                l2.cubicTo(0.0f, 12.088311f, 12.088311f, 0.0f, 27.0f, 0.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                g = C5163c.m7878a(a, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(3.0f, 24.0f);
                l2.cubicTo(4.6568546f, 24.0f, 6.0f, 25.343145f, 6.0f, 27.0f);
                l2.cubicTo(6.0f, 28.656855f, 4.6568546f, 30.0f, 3.0f, 30.0f);
                l2.cubicTo(1.3431456f, 30.0f, 0.0f, 28.656855f, 0.0f, 27.0f);
                l2.cubicTo(0.0f, 25.343145f, 1.3431456f, 24.0f, 3.0f, 24.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(0.49475262f, 0.0f);
                l3.lineTo(5.4947524f, 0.0f);
                l3.lineTo(4.7095985f, 20.212122f);
                l3.lineTo(1.3290199f, 20.212122f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

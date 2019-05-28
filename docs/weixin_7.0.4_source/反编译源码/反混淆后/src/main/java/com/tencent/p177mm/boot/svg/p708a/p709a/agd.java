package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.agd */
public final class agd extends C5163c {
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(C8415j.INVALID_ID);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 9.6f);
                l.cubicTo(0.0f, 4.298066f, 4.298066f, 0.0f, 9.6f, 0.0f);
                l.lineTo(86.4f, 0.0f);
                l.cubicTo(91.701935f, 0.0f, 96.0f, 4.298066f, 96.0f, 9.6f);
                l.lineTo(96.0f, 86.4f);
                l.cubicTo(96.0f, 91.701935f, 91.701935f, 96.0f, 86.4f, 96.0f);
                l.lineTo(9.6f, 96.0f);
                l.cubicTo(4.298066f, 96.0f, 0.0f, 91.701935f, 0.0f, 86.4f);
                l.lineTo(0.0f, 9.6f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 20.571428f, 0.0f, 1.0f, 25.714287f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                a4.setColor(-1);
                a3 = C5163c.m7878a(a3, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 33.428574f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(43.885715f, 0.0f);
                l.lineTo(52.114285f, 0.0f);
                l.cubicTo(53.629124f, -2.4742114E-15f, 54.857143f, 1.2472068f, 54.857143f, 2.7857144f);
                l.lineTo(54.857143f, 30.642857f);
                l.cubicTo(54.857143f, 32.181366f, 53.629124f, 33.42857f, 52.114285f, 33.42857f);
                l.lineTo(13.714286f, 33.42857f);
                l.cubicTo(12.199448f, 33.42857f, 10.971429f, 32.181366f, 10.971429f, 30.642857f);
                l.lineTo(10.971429f, 22.285715f);
                l.lineTo(14.262857f, 22.285715f);
                l.lineTo(14.262857f, 30.085714f);
                l.lineTo(51.565716f, 30.085714f);
                l.lineTo(51.565716f, 3.3428571f);
                l.lineTo(43.885715f, 3.3428571f);
                l.lineTo(43.885715f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                Paint a5 = C5163c.m7876a(a, looper);
                a5.setColor(-1);
                a5.setStrokeWidth(2.88f);
                l = C5163c.m7884l(looper);
                l.moveTo(1.44f, 14.982857f);
                l.cubicTo(1.44f, 13.657373f, 2.5145166f, 12.582857f, 3.8400002f, 12.582857f);
                l.lineTo(40.04571f, 12.582857f);
                l.cubicTo(41.371197f, 12.582857f, 42.445713f, 13.657373f, 42.445713f, 14.982857f);
                l.lineTo(42.445713f, 40.731426f);
                l.cubicTo(42.445713f, 42.05691f, 41.371197f, 43.131428f, 40.04571f, 43.131428f);
                l.lineTo(3.8400002f, 43.131428f);
                l.cubicTo(2.5145166f, 43.131428f, 1.44f, 42.05691f, 1.44f, 40.731426f);
                l.lineTo(1.44f, 14.982857f);
                l.close();
                canvas.drawPath(l, a5);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

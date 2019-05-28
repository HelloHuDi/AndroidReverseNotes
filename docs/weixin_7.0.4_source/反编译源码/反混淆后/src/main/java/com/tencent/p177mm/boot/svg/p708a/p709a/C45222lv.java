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

/* renamed from: com.tencent.mm.boot.svg.a.a.lv */
public final class C45222lv extends C5163c {
    private final int height = 40;
    private final int width = 40;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 12, 4);
                canvas.save();
                Paint a2 = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.0f, 0.0f);
                l.cubicTo(31.045696f, 0.0f, 40.0f, 8.954305f, 40.0f, 20.0f);
                l.cubicTo(40.0f, 31.045696f, 31.045696f, 40.0f, 20.0f, 40.0f);
                l.cubicTo(8.954305f, 40.0f, 0.0f, 31.045696f, 0.0f, 20.0f);
                l.cubicTo(0.0f, 8.954305f, 8.954305f, 0.0f, 20.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                a4.setStrokeWidth(1.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(4.5f, 10.5f);
                l.lineTo(4.5f, 24.0f);
                l.cubicTo(4.5f, 24.276142f, 4.7238574f, 24.5f, 5.0f, 24.5f);
                l.lineTo(23.0f, 24.5f);
                l.cubicTo(23.276142f, 24.5f, 23.5f, 24.276142f, 23.5f, 24.0f);
                l.lineTo(23.5f, 10.5f);
                l.lineTo(4.5f, 10.5f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                Paint a5 = C5163c.m7876a(a, looper);
                a4.setColor(-2565928);
                a5.setColor(WebView.NIGHT_MODE_COLOR);
                a5.setStrokeWidth(1.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(25.499073f, 10.472813f);
                l.lineTo(23.211826f, 4.3734875f);
                l.cubicTo(23.0148f, 3.8480787f, 22.51252f, 3.5f, 21.951384f, 3.5f);
                l.lineTo(6.0486164f, 3.5f);
                l.cubicTo(5.487479f, 3.5f, 4.9852014f, 3.8480787f, 4.788173f, 4.3734875f);
                l.lineTo(2.5009263f, 10.472813f);
                l.cubicTo(2.5478566f, 12.704954f, 4.371993f, 14.5f, 6.6153846f, 14.5f);
                l.cubicTo(7.9268394f, 14.5f, 9.134812f, 13.882993f, 9.907946f, 12.853959f);
                l.lineTo(10.307693f, 12.321898f);
                l.lineTo(10.707439f, 12.853959f);
                l.cubicTo(11.480572f, 13.882993f, 12.688545f, 14.5f, 14.0f, 14.5f);
                l.cubicTo(15.311455f, 14.5f, 16.519428f, 13.882993f, 17.29256f, 12.853959f);
                l.lineTo(17.692308f, 12.321898f);
                l.lineTo(18.092054f, 12.853959f);
                l.cubicTo(18.865187f, 13.882993f, 20.07316f, 14.5f, 21.384615f, 14.5f);
                l.cubicTo(23.628008f, 14.5f, 25.452143f, 12.704954f, 25.499073f, 10.472813f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.drawPath(l, a5);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                l = C5163c.m7884l(looper);
                l.moveTo(5.0f, 10.0f);
                l.cubicTo(5.0f, 9.723858f, 5.2238574f, 9.5f, 5.5f, 9.5f);
                l.lineTo(22.5f, 9.5f);
                l.cubicTo(22.776142f, 9.5f, 23.0f, 9.723858f, 23.0f, 10.0f);
                l.lineTo(23.0f, 10.0f);
                l.cubicTo(23.0f, 10.276142f, 22.776142f, 10.5f, 22.5f, 10.5f);
                l.lineTo(5.5f, 10.5f);
                l.cubicTo(5.2238574f, 10.5f, 5.0f, 10.276142f, 5.0f, 10.0f);
                l.lineTo(5.0f, 10.0f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

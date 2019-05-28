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

/* renamed from: com.tencent.mm.boot.svg.a.a.nj */
public final class C9136nj extends C5163c {
    private final int height = 115;
    private final int width = 115;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -91.0f, 0.0f, 1.0f, -386.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 91.0f, 0.0f, 1.0f, 386.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(1275068416);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(57.391304f, 0.0f);
                l.cubicTo(89.08765f, 0.0f, 114.78261f, 25.69496f, 114.78261f, 57.391304f);
                l.cubicTo(114.78261f, 89.08765f, 89.08765f, 114.78261f, 57.391304f, 114.78261f);
                l.cubicTo(25.69496f, 114.78261f, 0.0f, 89.08765f, 0.0f, 57.391304f);
                l.cubicTo(0.0f, 25.69496f, 25.69496f, 0.0f, 57.391304f, 0.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a3.setColor(-1);
                a3.setStrokeWidth(6.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(57.391304f, 3.0f);
                l.cubicTo(87.43079f, 3.0f, 111.78261f, 27.351814f, 111.78261f, 57.391304f);
                l.cubicTo(111.78261f, 87.43079f, 87.43079f, 111.78261f, 57.391304f, 111.78261f);
                l.cubicTo(27.351814f, 111.78261f, 3.0f, 87.43079f, 3.0f, 57.391304f);
                l.cubicTo(3.0f, 27.351814f, 27.351814f, 3.0f, 57.391304f, 3.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(75.87335f, 59.57144f);
                l.lineTo(50.798225f, 76.7102f);
                l.lineTo(50.798225f, 76.7102f);
                l.cubicTo(49.69112f, 77.4669f, 48.180206f, 77.182846f, 47.423504f, 76.07574f);
                l.cubicTo(47.147606f, 75.67209f, 47.0f, 75.19454f, 47.0f, 74.70561f);
                l.lineTo(47.0f, 40.428093f);
                l.lineTo(47.0f, 40.428093f);
                l.cubicTo(47.0f, 39.087093f, 48.087093f, 38.0f, 49.428093f, 38.0f);
                l.cubicTo(49.917027f, 38.0f, 50.39457f, 38.147606f, 50.798225f, 38.423504f);
                l.lineTo(75.87335f, 55.562263f);
                l.lineTo(75.87335f, 55.562263f);
                l.cubicTo(76.98046f, 56.318962f, 77.26452f, 57.829876f, 76.50781f, 58.93698f);
                l.cubicTo(76.33758f, 59.186047f, 76.12242f, 59.401207f, 75.87335f, 59.57144f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

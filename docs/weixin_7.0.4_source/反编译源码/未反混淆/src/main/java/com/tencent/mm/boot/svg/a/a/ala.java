package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ala extends c {
    private final int height = 48;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -120.0f, 0.0f, 1.0f, -426.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 120.0f, 0.0f, 1.0f, 426.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = c.a(k, looper);
                a2.setColor(-70474);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(44.0f, 22.271605f);
                l.cubicTo(44.0f, 9.849482f, 34.15052f, 0.0f, 21.728395f, 0.0f);
                l.cubicTo(9.849482f, 0.0f, 0.0f, 9.849482f, 0.0f, 22.271605f);
                l.cubicTo(0.0f, 34.15052f, 9.849482f, 44.0f, 21.728395f, 44.0f);
                l.cubicTo(34.15052f, 44.0f, 44.0f, 34.15052f, 44.0f, 22.271605f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-36352);
                a3.setStrokeWidth(3.0f);
                l = c.l(looper);
                l.moveTo(42.5f, 22.271605f);
                l.cubicTo(42.5f, 10.677909f, 33.32209f, 1.5f, 21.728395f, 1.5f);
                l.cubicTo(10.600406f, 1.5f, 1.5f, 10.756952f, 1.5f, 22.271605f);
                l.cubicTo(1.5f, 33.32209f, 10.677909f, 42.5f, 21.728395f, 42.5f);
                l.cubicTo(33.243046f, 42.5f, 42.5f, 33.399593f, 42.5f, 22.271605f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-36352);
                l = c.l(looper);
                l.moveTo(8.37882f, 23.270937f);
                l.cubicTo(8.197487f, 23.075033f, 8.176818f, 22.736786f, 8.330922f, 22.517902f);
                l.lineTo(9.380023f, 21.027798f);
                l.cubicTo(9.534904f, 20.80781f, 9.826069f, 20.761974f, 10.042893f, 20.935448f);
                l.lineTo(17.207075f, 26.667225f);
                l.cubicTo(17.418287f, 26.836208f, 17.750328f, 26.833344f, 17.961102f, 26.650051f);
                l.lineTo(35.820465f, 11.119163f);
                l.cubicTo(36.02569f, 10.940694f, 36.340633f, 10.949186f, 36.53349f, 11.148006f);
                l.lineTo(37.460594f, 12.103773f);
                l.cubicTo(37.649166f, 12.298171f, 37.65095f, 12.610968f, 37.46806f, 12.798857f);
                l.lineTo(17.922888f, 32.87793f);
                l.cubicTo(17.738441f, 33.067417f, 17.43909f, 33.059162f, 17.260582f, 32.86631f);
                l.lineTo(8.37882f, 23.270937f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

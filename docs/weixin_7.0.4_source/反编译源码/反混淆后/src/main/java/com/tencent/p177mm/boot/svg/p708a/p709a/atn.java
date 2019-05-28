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

/* renamed from: com.tencent.mm.boot.svg.a.a.atn */
public final class atn extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                a.setColor(-27648);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(26.4f, 1.66f);
                l.cubicTo(42.28f, -1.94f, 59.61f, 8.21f, 64.37f, 23.75f);
                l.cubicTo(69.73f, 39.03f, 61.77f, 57.35f, 46.96f, 63.88f);
                l.cubicTo(32.58f, 71.02f, 13.62f, 65.47f, 5.24f, 51.82f);
                l.cubicTo(-2.86f, 39.68f, -1.34f, 22.27f, 8.7f, 11.7f);
                l.cubicTo(13.34f, 6.59f, 19.66f, 3.07f, 26.4f, 1.66f);
                l.lineTo(26.4f, 1.66f);
                l.close();
                l.moveTo(26.42f, 4.73f);
                l.cubicTo(22.56f, 5.59f, 18.89f, 7.26f, 15.66f, 9.55f);
                l.cubicTo(3.91f, 17.54f, -0.47f, 34.34f, 5.99f, 47.02f);
                l.cubicTo(12.27f, 60.81f, 29.81f, 67.79f, 43.84f, 61.97f);
                l.cubicTo(58.14f, 56.76f, 66.51f, 39.71f, 61.68f, 25.23f);
                l.cubicTo(57.54f, 10.62f, 41.2f, 1.03f, 26.42f, 4.73f);
                l.lineTo(26.42f, 4.73f);
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

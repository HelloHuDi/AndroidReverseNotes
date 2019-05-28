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

/* renamed from: com.tencent.mm.boot.svg.a.a.xs */
public final class C18085xs extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-12206054);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(25.094501f, 1.2469155f);
                l.cubicTo(32.743237f, 3.0203025f, 39.219376f, 8.896839f, 41.072548f, 16.177034f);
                l.cubicTo(43.13704f, 22.67836f, 41.587963f, 29.62878f, 38.076664f, 35.088516f);
                l.cubicTo(34.412243f, 42.962852f, 28.066027f, 49.068085f, 21.099989f, 54.0f);
                l.cubicTo(12.755159f, 48.05386f, 5.0597496f, 40.37757f, 1.127431f, 30.11181f);
                l.cubicTo(-0.9466681f, 23.652811f, -0.27706745f, 15.399808f, 4.123315f, 9.209645f);
                l.cubicTo(9.027383f, 3.1793966f, 17.492334f, 0.06711942f, 25.094501f, 1.2469155f);
                l.close();
                l.moveTo(16.216259f, 28.788422f);
                l.cubicTo(21.350666f, 32.136604f, 29.266953f, 28.065493f, 28.989613f, 22.434635f);
                l.cubicTo(29.309687f, 16.169382f, 22.162594f, 11.960802f, 17.280704f, 15.021884f);
                l.cubicTo(11.992141f, 17.4383f, 11.564811f, 25.432486f, 16.216259f, 28.788422f);
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

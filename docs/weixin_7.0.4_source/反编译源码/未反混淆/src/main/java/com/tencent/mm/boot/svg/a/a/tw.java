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

public final class tw extends c {
    private final int height = 66;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                a.setColor(-15028967);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(57.0f, 30.37037f);
                l.cubicTo(57.0f, 15.087965f, 44.912033f, 3.0f, 29.62963f, 3.0f);
                l.cubicTo(14.985957f, 3.0f, 3.0f, 15.1921425f, 3.0f, 30.37037f);
                l.cubicTo(3.0f, 44.912033f, 15.087965f, 57.0f, 29.62963f, 57.0f);
                l.cubicTo(44.807858f, 57.0f, 57.0f, 45.01404f, 57.0f, 30.37037f);
                l.close();
                l.moveTo(60.0f, 30.37037f);
                l.cubicTo(60.0f, 46.56889f, 46.56889f, 60.0f, 29.62963f, 60.0f);
                l.cubicTo(13.431111f, 60.0f, 0.0f, 46.56889f, 0.0f, 30.37037f);
                l.cubicTo(0.0f, 13.431111f, 13.431111f, 0.0f, 29.62963f, 0.0f);
                l.cubicTo(46.56889f, 0.0f, 60.0f, 13.431111f, 60.0f, 30.37037f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(16.671656f, 32.738823f);
                l.cubicTo(16.30071f, 32.33078f, 16.3125f, 31.6875f, 16.710756f, 31.289244f);
                l.lineTo(17.289244f, 30.710756f);
                l.cubicTo(17.681784f, 30.318216f, 18.34375f, 30.300781f, 18.75262f, 30.658543f);
                l.lineTo(25.24738f, 36.341457f);
                l.cubicTo(25.66304f, 36.705162f, 26.347137f, 36.704933f, 26.759602f, 36.35434f);
                l.lineTo(45.2404f, 20.645662f);
                l.cubicTo(45.659916f, 20.289072f, 46.3125f, 20.3125f, 46.71076f, 20.710756f);
                l.lineTo(47.28924f, 21.289244f);
                l.cubicTo(47.68178f, 21.681784f, 47.671932f, 22.313156f, 47.28053f, 22.686768f);
                l.lineTo(26.719471f, 42.313232f);
                l.cubicTo(26.322119f, 42.692524f, 25.70072f, 42.67079f, 25.328344f, 42.261177f);
                l.lineTo(16.671656f, 32.738823f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

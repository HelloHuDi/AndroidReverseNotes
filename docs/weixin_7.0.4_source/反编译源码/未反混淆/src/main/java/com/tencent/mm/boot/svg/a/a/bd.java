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

public final class bd extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 15.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 7.5f, 0.0f, 1.0f, 13.125f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(70.5f, 40.908176f);
                l.lineTo(70.5f, 6.375f);
                l.lineTo(4.5f, 6.375f);
                l.lineTo(4.5f, 39.720825f);
                l.lineTo(23.247171f, 24.55972f);
                l.cubicTo(24.981747f, 23.156944f, 27.767345f, 23.224977f, 29.439358f, 24.694063f);
                l.lineTo(46.22596f, 39.443348f);
                l.lineTo(54.784134f, 32.165615f);
                l.cubicTo(56.51744f, 30.69164f, 59.27521f, 30.721584f, 60.957867f, 32.231564f);
                l.lineTo(70.5f, 40.908176f);
                l.close();
                l.moveTo(70.5f, 46.851036f);
                l.lineTo(57.84819f, 35.467094f);
                l.lineTo(49.64241f, 42.445156f);
                l.lineTo(54.684147f, 46.875f);
                l.lineTo(48.041878f, 46.875f);
                l.lineTo(26.27271f, 27.900312f);
                l.lineTo(4.5f, 45.508213f);
                l.lineTo(4.5f, 57.375f);
                l.lineTo(70.5f, 57.375f);
                l.lineTo(70.5f, 46.851036f);
                l.close();
                l.moveTo(3.7192616f, 1.875f);
                l.lineTo(71.28074f, 1.875f);
                l.cubicTo(73.2926f, 1.875f, 75.0f, 3.6792638f, 75.0f, 5.904936f);
                l.lineTo(75.0f, 57.845062f);
                l.cubicTo(75.0f, 60.07932f, 73.33483f, 61.875f, 71.28074f, 61.875f);
                l.lineTo(3.7192616f, 61.875f);
                l.cubicTo(1.7073959f, 61.875f, 0.0f, 60.070736f, 0.0f, 57.845062f);
                l.lineTo(0.0f, 5.904936f);
                l.cubicTo(0.0f, 3.6706808f, 1.6651702f, 1.875f, 3.7192616f, 1.875f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

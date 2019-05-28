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

public final class ua extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 10.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(56.4f, 32.72654f);
                l.lineTo(56.4f, 5.1f);
                l.lineTo(3.6f, 5.1f);
                l.lineTo(3.6f, 31.776659f);
                l.lineTo(18.597736f, 19.647776f);
                l.cubicTo(19.985397f, 18.525555f, 22.213877f, 18.57998f, 23.551487f, 19.75525f);
                l.lineTo(36.98077f, 31.55468f);
                l.lineTo(43.82731f, 25.732492f);
                l.cubicTo(45.21395f, 24.553312f, 47.42017f, 24.577269f, 48.766293f, 25.785252f);
                l.lineTo(56.4f, 32.72654f);
                l.close();
                l.moveTo(56.399998f, 37.480827f);
                l.lineTo(46.278553f, 28.373676f);
                l.lineTo(39.71393f, 33.956127f);
                l.lineTo(43.74732f, 37.5f);
                l.lineTo(38.433502f, 37.5f);
                l.lineTo(21.01817f, 22.32025f);
                l.lineTo(3.6f, 36.40657f);
                l.lineTo(3.6f, 45.9f);
                l.lineTo(56.4f, 45.9f);
                l.lineTo(56.4f, 37.480827f);
                l.close();
                l.moveTo(2.9754093f, 1.5f);
                l.lineTo(57.02459f, 1.5f);
                l.cubicTo(58.634083f, 1.5f, 60.0f, 2.943411f, 60.0f, 4.723949f);
                l.lineTo(60.0f, 46.27605f);
                l.cubicTo(60.0f, 48.063454f, 58.667866f, 49.5f, 57.02459f, 49.5f);
                l.lineTo(2.9754093f, 49.5f);
                l.cubicTo(1.3659167f, 49.5f, 0.0f, 48.056587f, 0.0f, 46.27605f);
                l.lineTo(0.0f, 4.723949f);
                l.cubicTo(0.0f, 2.9365447f, 1.3321362f, 1.5f, 2.9754093f, 1.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

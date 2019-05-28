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
import com.tencent.view.d;

public final class dk extends c {
    private final int height = d.MIC_PTU_TRANS_ROUHE;
    private final int width = d.MIC_PTU_TRANS_ROUHE;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.MIC_PTU_TRANS_ROUHE;
            case 1:
                return d.MIC_PTU_TRANS_ROUHE;
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
                g = c.a(g, 1.0f, 0.0f, -144.0f, 0.0f, 1.0f, -69.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 144.0f, 0.0f, 1.0f, 69.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-3552823);
                Path l = c.l(looper);
                l.moveTo(279.0f, 141.1269f);
                l.cubicTo(279.0f, 62.751225f, 216.54533f, 0.60727614f, 137.77777f, 0.60727614f);
                l.cubicTo(62.454666f, 0.60727614f, 0.0f, 62.751225f, 0.0f, 141.1269f);
                l.cubicTo(0.0f, 216.07527f, 62.454666f, 278.2192f, 137.77777f, 278.2192f);
                l.cubicTo(216.54533f, 278.2192f, 279.0f, 216.07527f, 279.0f, 141.1269f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(131.70822f, 71.3711f);
                l.cubicTo(128.45819f, 71.3711f, 125.94605f, 74.00451f, 126.09674f, 77.24315f);
                l.lineTo(130.2428f, 166.35248f);
                l.cubicTo(130.31987f, 168.00896f, 131.72324f, 169.35179f, 133.37312f, 169.35179f);
                l.lineTo(145.62688f, 169.35179f);
                l.cubicTo(147.27864f, 169.35179f, 148.68036f, 168.004f, 148.7572f, 166.35248f);
                l.lineTo(152.90326f, 77.24315f);
                l.cubicTo(153.05415f, 74.00011f, 150.54134f, 71.3711f, 147.29178f, 71.3711f);
                l.lineTo(131.70822f, 71.3711f);
                l.close();
                l.moveTo(139.5f, 212.89876f);
                l.cubicTo(147.0533f, 212.89876f, 153.17647f, 206.80606f, 153.17647f, 199.29033f);
                l.cubicTo(153.17647f, 191.7746f, 147.0533f, 185.6819f, 139.5f, 185.6819f);
                l.cubicTo(131.9467f, 185.6819f, 125.82353f, 191.7746f, 125.82353f, 199.29033f);
                l.cubicTo(125.82353f, 206.80606f, 131.9467f, 212.89876f, 139.5f, 212.89876f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

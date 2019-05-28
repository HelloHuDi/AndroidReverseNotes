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

public final class id extends c {
    private final int height = 40;
    private final int width = 40;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                k2 = c.a(k2, looper);
                k2.setStrokeWidth(1.0f);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 3.333333f, 0.0f, 1.0f, 3.333333f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-15616);
                Path l = c.l(looper);
                l.moveTo(16.666666f, 33.333332f);
                l.cubicTo(7.4619207f, 33.333332f, 0.0f, 25.871412f, 0.0f, 16.666666f);
                l.cubicTo(0.0f, 7.4619207f, 7.4619207f, 0.0f, 16.666666f, 0.0f);
                l.cubicTo(25.871412f, 0.0f, 33.333332f, 7.4619207f, 33.333332f, 16.666666f);
                l.cubicTo(33.333332f, 25.871412f, 25.871412f, 33.333332f, 16.666666f, 33.333332f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(17.333323f, 15.333354f);
                l2.lineTo(20.0f, 10.0f);
                l2.lineTo(22.5f, 10.0f);
                l2.lineTo(19.833323f, 15.333354f);
                l2.lineTo(22.5f, 15.333354f);
                l2.lineTo(22.5f, 17.333353f);
                l2.lineTo(17.666708f, 17.333353f);
                l2.lineTo(17.666708f, 19.166666f);
                l2.lineTo(22.5f, 19.166666f);
                l2.lineTo(22.5f, 21.166666f);
                l2.lineTo(17.666708f, 21.166666f);
                l2.lineTo(17.666708f, 24.166666f);
                l2.lineTo(15.666707f, 24.166666f);
                l2.lineTo(15.666707f, 21.166666f);
                l2.lineTo(10.833333f, 21.166666f);
                l2.lineTo(10.833333f, 19.166666f);
                l2.lineTo(15.666707f, 19.166666f);
                l2.lineTo(15.666707f, 17.333353f);
                l2.lineTo(10.833333f, 17.333353f);
                l2.lineTo(10.833333f, 15.333354f);
                l2.lineTo(13.5000105f, 15.333354f);
                l2.lineTo(10.833333f, 10.0f);
                l2.lineTo(13.333333f, 10.0f);
                l2.lineTo(16.00001f, 15.333354f);
                l2.lineTo(17.333323f, 15.333354f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                a2 = c.a(k, looper);
                a2.setColor(-1);
                l2 = c.l(looper);
                l2.moveTo(0.0f, 0.0f);
                l2.lineTo(40.0f, 0.0f);
                l2.lineTo(40.0f, 40.0f);
                l2.lineTo(0.0f, 40.0f);
                l2.lineTo(0.0f, 0.0f);
                l2.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l2, c.a(a2, looper));
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

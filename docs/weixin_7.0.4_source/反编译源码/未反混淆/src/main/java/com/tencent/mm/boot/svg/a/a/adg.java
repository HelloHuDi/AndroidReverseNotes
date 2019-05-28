package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adg extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                Paint a2 = c.a(k, looper);
                a2.setColor(-8420471);
                Path l = c.l(looper);
                l.moveTo(96.0f, 47.448277f);
                l.cubicTo(96.0f, 74.50933f, 74.50971f, 96.0f, 48.551723f, 96.0f);
                l.cubicTo(21.490286f, 96.0f, 0.0f, 74.50933f, 0.0f, 47.448277f);
                l.cubicTo(0.0f, 21.488955f, 21.490286f, 5.9487298E-15f, 48.551723f, 5.9487298E-15f);
                l.cubicTo(74.50971f, 5.9487298E-15f, 96.0f, 21.488955f, 96.0f, 47.448277f);
                l.close();
                canvas.saveLayerAlpha(null, 51, 4);
                Paint a3 = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-8617594);
                l = c.l(looper);
                l.moveTo(96.0f, 48.0f);
                l.cubicTo(96.0f, 74.50967f, 74.50967f, 96.0f, 48.0f, 96.0f);
                l.cubicTo(21.490332f, 96.0f, 0.0f, 74.50967f, 0.0f, 48.0f);
                l.cubicTo(0.0f, 21.490332f, 21.490332f, 0.0f, 48.0f, 0.0f);
                l.cubicTo(74.50967f, 0.0f, 96.0f, 21.490332f, 96.0f, 48.0f);
                l.close();
                l.moveTo(2.2325583f, 48.0f);
                l.cubicTo(2.2325583f, 73.27666f, 22.72334f, 93.76744f, 48.0f, 93.76744f);
                l.cubicTo(73.27666f, 93.76744f, 93.76744f, 73.27666f, 93.76744f, 48.0f);
                l.cubicTo(93.76744f, 22.72334f, 73.27666f, 2.2325583f, 48.0f, 2.2325583f);
                l.cubicTo(22.72334f, 2.2325583f, 2.2325583f, 22.72334f, 2.2325583f, 48.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                a = c.a(a, looper);
                k.setColor(-8617594);
                a.setColor(-8617594);
                a.setStrokeWidth(2.0f);
                l = c.l(looper);
                l.moveTo(60.0f, 50.0f);
                l.cubicTo(58.552845f, 50.154545f, 57.8374f, 49.327274f, 59.0f, 48.0f);
                l.cubicTo(58.672085f, 47.436363f, 59.506775f, 46.727272f, 61.0f, 47.0f);
                l.cubicTo(64.03794f, 45.663635f, 66.54201f, 42.945454f, 67.0f, 40.0f);
                l.cubicTo(66.54201f, 35.736362f, 62.845528f, 32.545456f, 59.0f, 32.0f);
                l.cubicTo(53.544716f, 32.545456f, 49.84824f, 35.736362f, 50.0f, 40.0f);
                l.lineTo(50.0f, 57.0f);
                l.cubicTo(49.84824f, 63.272728f, 44.482384f, 68.0f, 38.0f, 68.0f);
                l.cubicTo(31.365854f, 68.0f, 26.0f, 63.272728f, 26.0f, 57.0f);
                l.cubicTo(26.0f, 52.163635f, 30.17344f, 47.79091f, 36.0f, 47.0f);
                l.cubicTo(37.20867f, 46.96364f, 37.80488f, 48.618183f, 37.0f, 49.0f);
                l.cubicTo(36.759224f, 49.496105f, 36.373985f, 50.390907f, 35.0f, 50.0f);
                l.cubicTo(31.962059f, 51.454544f, 29.457994f, 54.172726f, 29.0f, 57.0f);
                l.cubicTo(29.457994f, 61.263638f, 33.154472f, 64.454544f, 37.0f, 65.0f);
                l.cubicTo(42.455284f, 64.454544f, 46.15176f, 61.263638f, 46.0f, 57.0f);
                l.lineTo(46.0f, 40.0f);
                l.cubicTo(46.15176f, 33.727272f, 51.517616f, 29.0f, 58.0f, 29.0f);
                l.cubicTo(64.63415f, 29.0f, 70.0f, 33.727272f, 70.0f, 40.0f);
                l.cubicTo(70.0f, 44.954544f, 65.82656f, 49.20909f, 60.0f, 50.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

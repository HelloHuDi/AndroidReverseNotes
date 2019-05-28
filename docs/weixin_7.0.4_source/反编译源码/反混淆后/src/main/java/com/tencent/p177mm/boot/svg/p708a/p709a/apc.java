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

/* renamed from: com.tencent.mm.boot.svg.a.a.apc */
public final class apc extends C5163c {
    private final int height = 76;
    private final int width = 76;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 4.0f);
                l.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                l.lineTo(72.0f, 0.0f);
                l.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                l.lineTo(76.0f, 72.0f);
                l.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                l.lineTo(4.0f, 76.0f);
                l.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                l.lineTo(0.0f, 4.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-5658199);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(3.7070117f, 6.412617f);
                l.cubicTo(6.3475637f, 3.0910726f, 10.084194f, -0.36092544f, 14.617972f, 0.03043481f);
                l.cubicTo(16.40159f, 5.1482224f, 19.90904f, 9.844545f, 19.92897f, 15.433972f);
                l.cubicTo(17.168846f, 17.22018f, 12.874211f, 18.815727f, 13.252857f, 22.849749f);
                l.cubicTo(14.059969f, 27.385513f, 16.501234f, 31.840998f, 19.958862f, 34.871532f);
                l.cubicTo(23.376635f, 37.169518f, 26.385868f, 33.416473f, 28.398664f, 31.048243f);
                l.cubicTo(29.494743f, 31.028173f, 30.580858f, 31.018139f, 31.676935f, 31.018139f);
                l.cubicTo(35.134563f, 33.908184f, 38.651978f, 36.727985f, 42.0f, 39.74848f);
                l.cubicTo(41.15303f, 41.805634f, 40.993603f, 44.49498f, 38.891125f, 45.72927f);
                l.cubicTo(35.463387f, 48.288162f, 31.447756f, 50.736675f, 26.973764f, 49.793396f);
                l.cubicTo(17.358168f, 48.248024f, 10.452875f, 40.14988f, 5.7297745f, 32.15208f);
                l.cubicTo(1.4251761f, 24.545643f, -1.3249838f, 14.320102f, 3.7070117f, 6.412617f);
                l.lineTo(3.7070117f, 6.412617f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

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

public final class mh extends c {
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(48.0f, 0.0f);
                l.lineTo(48.0f, 48.0f);
                l.lineTo(0.0f, 48.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-14474461);
                g = c.a(g, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(10.740368f, 0.20687631f);
                l2.lineTo(12.706858f, 0.20687631f);
                l2.cubicTo(13.314371f, 0.20687631f, 13.806858f, 0.69936305f, 13.806858f, 1.3068763f);
                l2.cubicTo(13.806758f, 1.3250016f, 13.806758f, 1.3250016f, 13.80626f, 1.3431203f);
                l2.lineTo(13.5392275f, 9.44312f);
                l2.cubicTo(13.519675f, 10.036202f, 13.033229f, 10.506876f, 12.439825f, 10.506876f);
                l2.lineTo(11.0074005f, 10.506876f);
                l2.cubicTo(10.413997f, 10.506876f, 9.92755f, 10.036202f, 9.907998f, 9.44312f);
                l2.lineTo(9.640965f, 1.3431203f);
                l2.cubicTo(9.620948f, 0.735937f, 10.09694f, 0.2274906f, 10.7041235f, 0.20747358f);
                l2.cubicTo(10.722242f, 0.20697586f, 10.722242f, 0.20697586f, 10.740368f, 0.20687631f);
                l2.close();
                l2.moveTo(25.707619f, 6.4065194f);
                l2.cubicTo(26.137196f, 6.836096f, 26.137196f, 7.5325775f, 25.707619f, 7.962154f);
                l2.cubicTo(25.69473f, 7.9749002f, 25.69473f, 7.9749002f, 25.681568f, 7.98736f);
                l2.lineTo(19.765182f, 13.526104f);
                l2.cubicTo(19.331984f, 13.931651f, 18.655197f, 13.920499f, 18.235598f, 13.500898f);
                l2.lineTo(17.222721f, 12.488022f);
                l2.cubicTo(16.803122f, 12.068421f, 16.791967f, 11.391635f, 17.197515f, 10.958438f);
                l2.lineTo(22.73626f, 5.042052f);
                l2.cubicTo(23.15145f, 4.598554f, 23.847551f, 4.5756054f, 24.29105f, 4.990795f);
                l2.cubicTo(24.304213f, 5.003255f, 24.304213f, 5.003255f, 24.3171f, 5.016001f);
                l2.lineTo(25.707619f, 6.4065194f);
                l2.close();
                l2.moveTo(30.516735f, 18.016766f);
                l2.lineTo(30.516735f, 19.983255f);
                l2.cubicTo(30.516735f, 20.590769f, 30.024248f, 21.083254f, 29.416735f, 21.083254f);
                l2.cubicTo(29.39861f, 21.083155f, 29.39861f, 21.083155f, 29.380491f, 21.082657f);
                l2.lineTo(21.28049f, 20.815624f);
                l2.cubicTo(20.687408f, 20.796072f, 20.216734f, 20.309626f, 20.216734f, 19.71622f);
                l2.lineTo(20.216734f, 18.283798f);
                l2.cubicTo(20.216734f, 17.690393f, 20.687408f, 17.203947f, 21.28049f, 17.184395f);
                l2.lineTo(29.380491f, 16.917362f);
                l2.cubicTo(29.987675f, 16.897345f, 30.49612f, 17.373337f, 30.516138f, 17.98052f);
                l2.cubicTo(30.516636f, 17.99864f, 30.516636f, 17.99864f, 30.516735f, 18.016766f);
                l2.close();
                l2.moveTo(4.0f, 10.0f);
                l2.lineTo(4.0f, 38.0f);
                l2.lineTo(20.0f, 38.0f);
                l2.lineTo(20.0f, 26.0f);
                l2.lineTo(24.0f, 26.0f);
                l2.lineTo(24.0f, 40.0f);
                l2.cubicTo(24.0f, 41.10457f, 23.10457f, 42.0f, 22.0f, 42.0f);
                l2.lineTo(2.0f, 42.0f);
                l2.cubicTo(0.8954305f, 42.0f, -3.5527137E-15f, 41.10457f, -7.1054274E-15f, 40.0f);
                l2.lineTo(-7.1054274E-15f, 8.0f);
                l2.cubicTo(-1.0658141E-14f, 6.8954306f, 0.8954305f, 6.0f, 2.0f, 6.0f);
                l2.lineTo(6.0f, 6.0f);
                l2.lineTo(6.0f, 10.0f);
                l2.lineTo(4.0f, 10.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                l2 = c.l(looper);
                l2.moveTo(0.0f, 0.0f);
                l2.lineTo(48.0f, 0.0f);
                l2.lineTo(48.0f, 48.0f);
                l2.lineTo(0.0f, 48.0f);
                l2.lineTo(0.0f, 0.0f);
                l2.close();
                c.j(looper);
                break;
        }
        return 0;
    }
}

package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.rg */
public final class C9147rg extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                k2 = C5163c.m7876a(k2, looper);
                a.setColor(-1);
                k2.setColor(-789517);
                k2.setStrokeWidth(3.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 29.0f, 0.0f, 1.0f, 27.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1766893);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(117.54472f, 97.456635f);
                l2.cubicTo(113.77624f, 90.83052f, 105.46905f, 88.537315f, 98.99011f, 92.33461f);
                l2.cubicTo(92.51117f, 96.131905f, 46.925743f, 136.63382f, 3.3178072f, 94.43031f);
                l2.cubicTo(46.147934f, 163.20174f, 106.741264f, 123.1558f, 112.63702f, 116.32988f);
                l2.cubicTo(118.53277f, 109.50396f, 121.31321f, 104.08274f, 117.54472f, 97.456635f);
                l2.lineTo(117.54472f, 97.456635f);
                l2.lineTo(117.54472f, 97.456635f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-13651898);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(64.6878f, 8.543366f);
                l2.cubicTo(60.91931f, 15.169477f, 63.11657f, 23.619318f, 69.59551f, 27.416613f);
                l2.cubicTo(76.074455f, 31.21391f, 133.41934f, 51.039238f, 119.219505f, 110.47878f);
                l2.cubicTo(156.47333f, 38.43909f, 92.01348f, 5.191617f, 83.24242f, 3.4213428f);
                l2.cubicTo(74.47135f, 1.6510686f, 68.45629f, 1.9172559f, 64.6878f, 8.543366f);
                l2.lineTo(64.6878f, 8.543366f);
                l2.lineTo(64.6878f, 8.543366f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-10239);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(28.981264f, 85.794235f);
                l2.cubicTo(28.981264f, 78.19964f, 17.04363f, 17.872393f, 75.72727f, 0.6363636f);
                l2.cubicTo(-5.5700607f, 3.904629f, -1.6449655f, 77.19804f, 1.273912f, 85.794235f);
                l2.cubicTo(4.1927896f, 94.39043f, 7.4764137f, 99.545456f, 15.127588f, 99.545456f);
                l2.cubicTo(22.77876f, 99.545456f, 28.981264f, 93.388824f, 28.981264f, 85.794235f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-16735005);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(89.16928f, 71.5124f);
                l2.cubicTo(87.17581f, 67.22876f, 85.37822f, 64.08933f, 85.75862f, 59.78788f);
                l2.cubicTo(85.17808f, 49.662067f, 77.04019f, 41.44884f, 67.0f, 41.363636f);
                l2.cubicTo(56.960056f, 41.44884f, 48.822174f, 49.662067f, 48.24138f, 59.78788f);
                l2.cubicTo(48.620693f, 64.08933f, 46.823097f, 67.22876f, 44.830723f, 71.5124f);
                l2.cubicTo(41.104324f, 77.520454f, 42.159588f, 85.53959f, 43.978058f, 85.74931f);
                l2.cubicTo(45.028515f, 85.53959f, 47.16046f, 84.274345f, 49.094044f, 82.39945f);
                l2.cubicTo(49.74825f, 84.71649f, 51.227226f, 87.04038f, 53.35737f, 89.099174f);
                l2.cubicTo(50.38616f, 89.7268f, 48.476444f, 91.21739f, 48.24138f, 92.449036f);
                l2.cubicTo(48.67692f, 95.15261f, 52.90333f, 96.84816f, 57.62069f, 96.63636f);
                l2.cubicTo(61.953903f, 96.43365f, 65.259254f, 95.14077f, 66.14734f, 93.2865f);
                l2.cubicTo(66.66058f, 93.48766f, 66.82425f, 93.49753f, 67.0f, 93.2865f);
                l2.cubicTo(67.18102f, 93.49753f, 67.3487f, 93.48766f, 67.85266f, 93.2865f);
                l2.cubicTo(68.75204f, 95.14077f, 72.052376f, 96.43365f, 76.37931f, 96.63636f);
                l2.cubicTo(81.09725f, 96.84816f, 85.32233f, 95.15261f, 85.75862f, 92.449036f);
                l2.cubicTo(85.52347f, 91.216736f, 83.61409f, 89.7268f, 80.64263f, 89.099174f);
                l2.cubicTo(82.7747f, 87.04038f, 84.24999f, 84.718796f, 84.90595f, 82.39945f);
                l2.cubicTo(86.84247f, 84.27533f, 88.97073f, 85.53959f, 90.02194f, 85.74931f);
                l2.cubicTo(91.84133f, 85.53959f, 92.89593f, 77.520454f, 89.16928f, 71.5124f);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

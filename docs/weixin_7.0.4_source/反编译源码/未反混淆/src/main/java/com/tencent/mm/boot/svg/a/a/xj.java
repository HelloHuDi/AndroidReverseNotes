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

public final class xj extends c {
    private final int height = 144;
    private final int width = 144;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-2565928);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(144.0f, 0.0f);
                l.lineTo(144.0f, 144.0f);
                l.lineTo(0.0f, 144.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, c.a(k2, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(78.44484f, 44.162613f);
                l2.cubicTo(84.704666f, 51.292156f, 88.5f, 60.63898f, 88.5f, 70.87225f);
                l2.cubicTo(88.5f, 81.723785f, 84.23221f, 91.57853f, 77.28353f, 98.84956f);
                l2.lineTo(72.523056f, 95.138885f);
                l2.cubicTo(78.69114f, 88.90604f, 82.5f, 80.33395f, 82.5f, 70.87225f);
                l2.cubicTo(82.5f, 61.983555f, 79.138504f, 53.87998f, 73.6174f, 47.763412f);
                l2.lineTo(78.44484f, 44.162613f);
                l2.close();
                l2.moveTo(100.12927f, 27.988129f);
                l2.cubicTo(109.732765f, 39.648514f, 115.5f, 54.58688f, 115.5f, 70.87225f);
                l2.cubicTo(115.5f, 87.98085f, 109.13496f, 103.60282f, 98.64374f, 115.499306f);
                l2.lineTo(93.90192f, 111.80317f);
                l2.cubicTo(103.60352f, 100.93096f, 109.5f, 86.5902f, 109.5f, 70.87225f);
                l2.cubicTo(109.5f, 55.931896f, 104.17251f, 42.23584f, 95.3136f, 31.580154f);
                l2.lineTo(100.12927f, 27.988129f);
                l2.close();
                l2.moveTo(120.587326f, 12.728405f);
                l2.cubicTo(133.35962f, 28.652878f, 141.0f, 48.87031f, 141.0f, 70.87225f);
                l2.cubicTo(141.0f, 93.89153f, 132.63672f, 114.95747f, 118.78293f, 131.1973f);
                l2.lineTo(114.045685f, 127.50474f);
                l2.cubicTo(127.1076f, 112.28587f, 135.0f, 92.50075f, 135.0f, 70.87225f);
                l2.cubicTo(135.0f, 50.21541f, 127.8008f, 31.240032f, 115.77455f, 16.318272f);
                l2.lineTo(120.587326f, 12.728405f);
                l2.close();
                l2.moveTo(6.0f, 54.0f);
                l2.lineTo(27.0f, 54.0f);
                l2.lineTo(56.9668f, 32.595142f);
                l2.lineTo(56.9668f, 32.595142f);
                l2.cubicTo(57.416214f, 32.27413f, 58.040764f, 32.378223f, 58.361774f, 32.827637f);
                l2.cubicTo(58.477894f, 32.990208f, 58.54266f, 33.18383f, 58.547718f, 33.38355f);
                l2.lineTo(59.347828f, 64.964676f);
                l2.lineTo(58.533905f, 110.598976f);
                l2.lineTo(58.533905f, 110.598976f);
                l2.cubicTo(58.524055f, 111.15118f, 58.068428f, 111.590836f, 57.51623f, 111.580986f);
                l2.cubicTo(57.313927f, 111.57738f, 57.117477f, 111.51248f, 56.952827f, 111.394875f);
                l2.lineTo(27.0f, 90.0f);
                l2.lineTo(6.0f, 90.0f);
                l2.cubicTo(4.343146f, 90.0f, 3.0f, 88.65685f, 3.0f, 87.0f);
                l2.lineTo(3.0f, 57.0f);
                l2.lineTo(3.0f, 57.0f);
                l2.cubicTo(3.0f, 55.343147f, 4.343146f, 54.0f, 6.0f, 54.0f);
                l2.lineTo(6.0f, 54.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

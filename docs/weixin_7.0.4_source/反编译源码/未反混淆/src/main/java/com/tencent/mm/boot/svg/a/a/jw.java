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

public final class jw extends c {
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                k = c.a(k, looper);
                k.setColor(-8617851);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(65.0f, 53.0f);
                l.cubicTo(65.0f, 55.20933f, 62.761665f, 57.0f, 60.0f, 57.0f);
                l.lineTo(55.0f, 57.0f);
                l.lineTo(55.0f, 41.0f);
                l.lineTo(60.0f, 41.0f);
                l.cubicTo(62.761665f, 41.0f, 65.0f, 42.79111f, 65.0f, 45.0f);
                l.lineTo(65.0f, 53.0f);
                l.close();
                l.moveTo(60.0f, 33.0f);
                l.lineTo(48.0f, 33.0f);
                l.lineTo(48.0f, 65.0f);
                l.lineTo(60.0f, 65.0f);
                l.cubicTo(66.627556f, 65.0f, 72.0f, 59.627556f, 72.0f, 53.0f);
                l.lineTo(72.0f, 45.0f);
                l.cubicTo(72.0f, 38.37289f, 66.627556f, 33.0f, 60.0f, 33.0f);
                l.lineTo(60.0f, 33.0f);
                l.close();
                l.moveTo(48.5f, 78.0f);
                l.cubicTo(32.759857f, 78.0f, 20.0f, 65.24014f, 20.0f, 49.5f);
                l.cubicTo(20.0f, 42.182285f, 22.76043f, 35.511475f, 27.293285f, 30.464714f);
                l.lineTo(29.464714f, 28.293737f);
                l.cubicTo(34.511475f, 23.76043f, 41.182285f, 21.0f, 48.5f, 21.0f);
                l.cubicTo(55.817715f, 21.0f, 62.488525f, 23.76043f, 67.535286f, 28.293737f);
                l.lineTo(69.70671f, 30.464714f);
                l.cubicTo(74.23957f, 35.511475f, 77.0f, 42.182285f, 77.0f, 49.5f);
                l.cubicTo(77.0f, 65.24014f, 64.24014f, 78.0f, 48.5f, 78.0f);
                l.lineTo(48.5f, 78.0f);
                l.close();
                l.moveTo(89.0f, 28.320707f);
                l.lineTo(84.54362f, 23.862083f);
                l.lineTo(78.94612f, 29.462835f);
                l.cubicTo(78.10526f, 28.189201f, 77.189674f, 26.969608f, 76.20072f, 25.813969f);
                l.lineTo(81.34762f, 20.664484f);
                l.lineTo(76.891235f, 16.205858f);
                l.lineTo(71.71237f, 21.387772f);
                l.cubicTo(70.703606f, 20.554144f, 69.645325f, 19.779964f, 68.54969f, 19.056675f);
                l.lineTo(74.14538f, 13.458625f);
                l.lineTo(69.688995f, 9.0f);
                l.lineTo(62.753685f, 15.939241f);
                l.cubicTo(58.37472f, 14.0760765f, 53.558674f, 13.040685f, 48.5f, 13.040685f);
                l.cubicTo(43.441326f, 13.040685f, 38.62528f, 14.0760765f, 34.246315f, 15.939241f);
                l.lineTo(27.311008f, 9.0f);
                l.lineTo(22.854622f, 13.458625f);
                l.lineTo(28.450312f, 19.056675f);
                l.cubicTo(27.354671f, 19.779964f, 26.296392f, 20.554144f, 25.287628f, 21.387772f);
                l.lineTo(20.108767f, 16.205858f);
                l.lineTo(15.652381f, 20.664484f);
                l.lineTo(20.799282f, 25.813969f);
                l.cubicTo(19.810324f, 26.969608f, 18.89474f, 28.189201f, 18.053879f, 29.462835f);
                l.lineTo(12.456387f, 23.862083f);
                l.lineTo(8.0f, 28.320707f);
                l.lineTo(14.937108f, 35.2613f);
                l.cubicTo(13.073078f, 39.64066f, 12.038656f, 44.45868f, 12.038656f, 49.520344f);
                l.cubicTo(12.038656f, 69.66747f, 28.362986f, 86.0f, 48.5f, 86.0f);
                l.cubicTo(68.63702f, 86.0f, 84.96134f, 69.66747f, 84.96134f, 49.520344f);
                l.cubicTo(84.96134f, 44.45868f, 83.92692f, 39.64066f, 82.06289f, 35.2613f);
                l.lineTo(89.0f, 28.320707f);
                l.close();
                l.moveTo(36.0f, 53.0f);
                l.cubicTo(36.0f, 55.20933f, 34.20933f, 57.0f, 32.0f, 57.0f);
                l.lineTo(28.0f, 57.0f);
                l.lineTo(28.0f, 65.0f);
                l.lineTo(32.0f, 65.0f);
                l.cubicTo(38.627556f, 65.0f, 44.0f, 59.627556f, 44.0f, 53.0f);
                l.lineTo(44.0f, 33.0f);
                l.lineTo(36.0f, 33.0f);
                l.lineTo(36.0f, 53.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

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

public final class bai extends c {
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
                a.setColor(-12863723);
                g = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(20.389967f, 3.894499f);
                l.cubicTo(25.58415f, -1.7899388f, 35.671696f, -1.1471756f, 40.12385f, 5.139853f);
                l.cubicTo(45.819405f, 12.8128395f, 43.142094f, 23.930635f, 36.814816f, 30.378355f);
                l.cubicTo(35.431038f, 31.493147f, 34.297943f, 33.853294f, 36.082817f, 35.178993f);
                l.cubicTo(43.28248f, 39.40717f, 51.224163f, 43.20349f, 56.35818f, 50.052937f);
                l.cubicTo(58.89511f, 53.22658f, 58.082893f, 57.545147f, 56.659004f, 61.0f);
                l.cubicTo(38.51947f, 60.879482f, 20.369913f, 60.96987f, 2.2303803f, 60.959827f);
                l.cubicTo(1.0170672f, 57.545147f, 0.104575485f, 53.427444f, 2.4910922f, 50.293976f);
                l.cubicTo(7.5248375f, 43.32401f, 15.596879f, 39.668293f, 22.706291f, 35.289467f);
                l.cubicTo(24.63155f, 33.93364f, 23.418236f, 31.483105f, 22.044485f, 30.257837f);
                l.cubicTo(15.677098f, 23.338089f, 13.631513f, 11.226018f, 20.389967f, 3.894499f);
                l.lineTo(20.389967f, 3.894499f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(49.614113f, 20.012203f);
                l.cubicTo(57.72848f, 20.052027f, 65.83278f, 19.922604f, 73.94714f, 20.081894f);
                l.cubicTo(74.01762f, 21.694714f, 74.01762f, 23.307535f, 73.94714f, 24.920355f);
                l.cubicTo(65.63143f, 25.06969f, 57.315716f, 24.950222f, 49.0f, 25.0f);
                l.cubicTo(49.231552f, 23.3374f, 49.422832f, 21.674803f, 49.614113f, 20.012203f);
                l.lineTo(49.614113f, 20.012203f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(45.0f, 33.156006f);
                l.cubicTo(54.639053f, 32.909058f, 64.29819f, 33.007835f, 73.94729f, 33.096737f);
                l.cubicTo(74.01757f, 34.69697f, 74.01757f, 36.297203f, 73.94729f, 37.897438f);
                l.cubicTo(66.92885f, 37.92707f, 59.90037f, 38.154263f, 52.902016f, 37.818413f);
                l.cubicTo(50.191032f, 36.40586f, 47.23907f, 35.269894f, 45.0f, 33.156006f);
                l.lineTo(45.0f, 33.156006f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(62.0f, 46.0f);
                l.cubicTo(65.97941f, 46.00998f, 69.958824f, 45.98004f, 73.93823f, 46.07984f);
                l.cubicTo(74.01883f, 47.696606f, 74.01883f, 49.313374f, 73.9483f, 50.93014f);
                l.cubicTo(70.70433f, 51.02994f, 67.46036f, 50.99002f, 64.20631f, 51.0f);
                l.cubicTo(63.541393f, 49.303394f, 62.805958f, 47.636726f, 62.0f, 46.0f);
                l.lineTo(62.0f, 46.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

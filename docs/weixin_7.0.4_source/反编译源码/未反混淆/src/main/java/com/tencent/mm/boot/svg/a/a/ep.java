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

public final class ep extends c {
    private final int height = 32;
    private final int width = 32;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -307.0f, 0.0f, 1.0f, -749.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 307.0f, 0.0f, 1.0f, 749.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                a = c.a(a, looper);
                a3.setColor(855638016);
                a.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(16.0f, 31.5f);
                l.cubicTo(24.560413f, 31.5f, 31.5f, 24.560413f, 31.5f, 16.0f);
                l.cubicTo(31.5f, 7.439586f, 24.560413f, 0.5f, 16.0f, 0.5f);
                l.cubicTo(7.439586f, 0.5f, 0.5f, 7.439586f, 0.5f, 16.0f);
                l.cubicTo(0.5f, 24.560413f, 7.439586f, 31.5f, 16.0f, 31.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                g = c.a(a2, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(15.0f, 3.5907052f);
                l.lineTo(6.6666665f, 5.4176283f);
                l.lineTo(6.6666665f, 15.163136f);
                l.lineTo(6.6666665f, 16.001057f);
                l.cubicTo(6.6666665f, 16.78138f, 6.1440945f, 17.542246f, 5.441226f, 17.870054f);
                l.cubicTo(5.3105655f, 17.930992f, 4.485161f, 18.115479f, 4.377384f, 18.137161f);
                l.cubicTo(3.3418045f, 18.345497f, 2.5461206f, 17.458466f, 2.5023015f, 16.561483f);
                l.cubicTo(2.458482f, 15.664502f, 3.0467193f, 14.916552f, 3.7292247f, 14.779246f);
                l.lineTo(4.656247f, 14.54665f);
                l.cubicTo(5.1032343f, 14.434498f, 5.4166665f, 14.032707f, 5.4166665f, 13.571865f);
                l.lineTo(5.4166665f, 5.2597876f);
                l.lineTo(5.4166665f, 5.1011295f);
                l.cubicTo(5.4166665f, 4.6312795f, 5.743765f, 4.224795f, 6.202738f, 4.12428f);
                l.lineTo(15.643036f, 2.0568664f);
                l.cubicTo(15.912786f, 1.9977916f, 16.17935f, 2.1685772f, 16.238424f, 2.4383266f);
                l.cubicTo(16.246119f, 2.4734614f, 16.25f, 2.5093238f, 16.25f, 2.5452912f);
                l.lineTo(16.25f, 2.9061635f);
                l.lineTo(16.25f, 12.9448185f);
                l.lineTo(16.25f, 13.78274f);
                l.cubicTo(16.25f, 14.563063f, 15.722891f, 15.323929f, 15.013919f, 15.651737f);
                l.cubicTo(14.882124f, 15.712675f, 14.049552f, 15.8971615f, 13.94084f, 15.918844f);
                l.cubicTo(12.896268f, 16.12718f, 12.093675f, 15.240149f, 12.049476f, 14.343167f);
                l.cubicTo(12.005276f, 13.446185f, 12.59862f, 12.698235f, 13.287052f, 12.560929f);
                l.lineTo(14.23615f, 12.32634f);
                l.cubicTo(14.684809f, 12.215445f, 15.0f, 11.8128605f, 15.0f, 11.3507f);
                l.lineTo(15.0f, 3.5907052f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

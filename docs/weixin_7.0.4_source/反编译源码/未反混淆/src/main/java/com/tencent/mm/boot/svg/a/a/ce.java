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

public final class ce extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-28160);
                Path l = c.l(looper);
                l.moveTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.lineTo(68.0f, 87.0f);
                l.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                l.lineTo(3.0f, 90.0f);
                l.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.lineTo(46.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-3378176);
                l = c.l(looper);
                l.moveTo(68.0f, 22.0f);
                l.lineTo(49.0f, 22.0f);
                l.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                l.lineTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(37.10621f, 52.971058f);
                l.cubicTo(34.776943f, 55.213036f, 30.973436f, 58.62498f, 25.695686f, 63.2069f);
                l.lineTo(24.528019f, 62.039234f);
                l.cubicTo(29.109938f, 56.761486f, 32.521885f, 52.957977f, 34.763863f, 50.62871f);
                l.lineTo(37.10621f, 52.971058f);
                l.close();
                l.moveTo(38.017532f, 52.078514f);
                l.lineTo(35.656406f, 49.71739f);
                l.cubicTo(37.835155f, 47.538635f, 40.33514f, 45.1877f, 43.15635f, 42.66457f);
                l.lineTo(43.15633f, 42.66455f);
                l.cubicTo(43.654514f, 42.219006f, 44.41396f, 42.240166f, 44.88656f, 42.712765f);
                l.lineTo(45.022152f, 42.84841f);
                l.cubicTo(45.494728f, 43.320988f, 45.51589f, 44.080395f, 45.070366f, 44.578552f);
                l.cubicTo(42.547234f, 47.39977f, 40.19629f, 49.899757f, 38.017532f, 52.078514f);
                l.close();
                l.moveTo(24.729465f, 64.04455f);
                l.cubicTo(24.411987f, 64.3194f, 24.089516f, 64.59821f, 23.76205f, 64.881f);
                l.lineTo(21.824629f, 66.26161f);
                l.cubicTo(21.711334f, 66.34235f, 21.554043f, 66.31595f, 21.473309f, 66.20266f);
                l.cubicTo(21.410967f, 66.11517f, 21.410967f, 65.99777f, 21.473309f, 65.91029f);
                l.lineTo(22.853926f, 63.97287f);
                l.cubicTo(23.136705f, 63.645405f, 23.415522f, 63.322933f, 23.690374f, 63.005455f);
                l.lineTo(24.729465f, 64.04455f);
                l.close();
                l.moveTo(21.076923f, 67.44615f);
                l.lineTo(47.661537f, 67.44615f);
                l.cubicTo(48.069378f, 67.44615f, 48.4f, 67.77677f, 48.4f, 68.184616f);
                l.cubicTo(48.4f, 68.59245f, 48.069378f, 68.92308f, 47.661537f, 68.92308f);
                l.lineTo(21.076923f, 68.92308f);
                l.cubicTo(20.669083f, 68.92308f, 20.33846f, 68.59245f, 20.33846f, 68.184616f);
                l.cubicTo(20.33846f, 67.77677f, 20.669083f, 67.44615f, 21.076923f, 67.44615f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

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
import com.tencent.view.d;

public final class baa extends c {
    private final int height = d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;
    private final int width = d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;
            case 1:
                return d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;
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
                float[] a = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = c.a(k, looper);
                a2.setColor(-2763307);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(18.457394f, 1.6814522f);
                l.cubicTo(20.597382f, 1.1715016f, 22.80737f, 1.0515132f, 24.997356f, 1.0215161f);
                l.lineTo(217.01625f, 1.0215161f);
                l.cubicTo(222.21622f, 1.0515132f, 227.63618f, 0.6115558f, 232.57616f, 2.6113622f);
                l.cubicTo(241.65611f, 5.9810357f, 248.11607f, 15.270136f, 247.98607f, 24.979197f);
                l.cubicTo(247.99606f, 91.65274f, 248.01607f, 158.32628f, 247.97607f, 224.99982f);
                l.cubicTo(248.32607f, 237.78859f, 236.85614f, 249.29747f, 224.05621f, 248.97751f);
                l.cubicTo(157.3666f, 249.00749f, 90.68697f, 249.00749f, 23.997362f, 248.97751f);
                l.cubicTo(11.187435f, 249.32747f, -0.29249832f, 237.84859f, 0.007499957f, 225.04982f);
                l.cubicTo(-0.0024999855f, 158.36627f, -0.0024999855f, 91.67274f, 0.007499957f, 24.989195f);
                l.cubicTo(-0.18249895f, 14.170242f, 7.9174542f, 4.0112267f, 18.457394f, 1.6814522f);
                l.lineTo(18.457394f, 1.6814522f);
                l.close();
                l.moveTo(19.43778f, 4.5597763f);
                l.cubicTo(10.841597f, 6.329068f, 3.8147154f, 14.165934f, 3.2149816f, 22.95242f);
                l.cubicTo(2.83515f, 27.65054f, 3.0850391f, 32.368652f, 3.0550525f, 37.066772f);
                l.cubicTo(3.0550525f, 96.02319f, 3.0550525f, 154.96962f, 3.0450568f, 213.91603f);
                l.cubicTo(3.0850391f, 218.58417f, 2.7951677f, 223.28229f, 3.314937f, 227.94043f);
                l.cubicTo(4.0745997f, 234.84767f, 8.882466f, 240.93523f, 15.039733f, 243.95403f);
                l.cubicTo(20.627253f, 246.66293f, 27.014418f, 245.86327f, 33.02175f, 245.96323f);
                l.cubicTo(93.67483f, 245.93323f, 154.3379f, 245.93323f, 214.99098f, 245.96323f);
                l.cubicTo(220.98833f, 245.86327f, 227.37549f, 246.64294f, 232.96301f, 243.95403f);
                l.cubicTo(240.10983f, 240.52539f, 245.09763f, 232.94843f, 244.9277f, 224.94164f);
                l.cubicTo(244.99767f, 160.97722f, 244.8977f, 97.012794f, 244.97768f, 33.04838f);
                l.cubicTo(244.9077f, 27.570572f, 245.50745f, 21.792883f, 243.22845f, 16.634947f);
                l.cubicTo(239.9599f, 9.177929f, 232.16336f, 3.890044f, 223.947f, 4.059976f);
                l.cubicTo(157.98628f, 3.980008f, 92.025566f, 4.09996f, 26.06484f, 4.0f);
                l.cubicTo(23.845825f, 4.039984f, 21.616814f, 4.129948f, 19.43778f, 4.5597763f);
                l.lineTo(19.43778f, 4.5597763f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1842205);
                g = c.a(a, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(17.43778f, 1.5597761f);
                l.cubicTo(19.616814f, 1.129948f, 21.845825f, 1.039984f, 24.06484f, 1.0f);
                l.cubicTo(90.025566f, 1.09996f, 155.98628f, 0.980008f, 221.947f, 1.059976f);
                l.cubicTo(230.16336f, 0.890044f, 237.9599f, 6.177929f, 241.22845f, 13.634946f);
                l.cubicTo(243.50745f, 18.792883f, 242.9077f, 24.570572f, 242.97768f, 30.048382f);
                l.cubicTo(242.8977f, 94.012794f, 242.99767f, 157.97722f, 242.9277f, 221.94164f);
                l.cubicTo(243.09763f, 229.94843f, 238.10983f, 237.52539f, 230.96301f, 240.95403f);
                l.cubicTo(225.37549f, 243.64294f, 218.98833f, 242.86327f, 212.99098f, 242.96323f);
                l.cubicTo(152.3379f, 242.93323f, 91.67483f, 242.93323f, 31.021751f, 242.96323f);
                l.cubicTo(25.014418f, 242.86327f, 18.627253f, 243.66293f, 13.039733f, 240.95403f);
                l.cubicTo(6.882466f, 237.93523f, 2.0746f, 231.84767f, 1.3149371f, 224.94043f);
                l.cubicTo(0.7951678f, 220.28229f, 1.0850391f, 215.58417f, 1.0450569f, 210.91603f);
                l.cubicTo(1.0550524f, 151.96962f, 1.0550524f, 93.02319f, 1.0550524f, 34.066772f);
                l.cubicTo(1.0850391f, 29.368652f, 0.83515006f, 24.65054f, 1.2149814f, 19.95242f);
                l.cubicTo(1.8147153f, 11.165934f, 8.841597f, 3.3290684f, 17.43778f, 1.5597761f);
                l.lineTo(17.43778f, 1.5597761f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

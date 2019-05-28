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

/* renamed from: com.tencent.mm.boot.svg.a.a.bn */
public final class C37523bn extends C5163c {
    private final int height = 46;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                a.setColor(-11184811);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.1462798f, 3.4678159f);
                l.cubicTo(-0.14277528f, 2.6805818f, -0.7123578f, 0.109614864f, 1.4360675f, 0.0f);
                l.cubicTo(4.623731f, 1.624293f, 6.612273f, 4.872879f, 9.310296f, 7.1548615f);
                l.cubicTo(10.96908f, 5.699973f, 12.857696f, 4.5440345f, 14.886209f, 3.6970105f);
                l.cubicTo(15.485769f, 1.9431727f, 16.874752f, -0.3188796f, 19.083132f, 0.52814436f);
                l.cubicTo(20.75191f, 0.827094f, 20.961756f, 2.7104766f, 21.561316f, 3.9660652f);
                l.cubicTo(24.129435f, 5.3213034f, 26.577639f, 7.134931f, 27.756775f, 9.885268f);
                l.cubicTo(30.714607f, 15.515486f, 28.865961f, 22.112309f, 30.7246f, 28.001616f);
                l.cubicTo(32.263474f, 30.851603f, 35.39118f, 32.42607f, 37.0f, 35.26609f);
                l.cubicTo(36.56032f, 35.70455f, 35.70095f, 36.56154f, 35.261276f, 37.0f);
                l.cubicTo(33.11285f, 35.624832f, 31.424088f, 33.68166f, 29.645391f, 31.88796f);
                l.cubicTo(20.142357f, 22.411257f, 10.639321f, 12.944519f, 1.1462798f, 3.4678159f);
                l.lineTo(1.1462798f, 3.4678159f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(6.4937344f, 13.0f);
                l.cubicTo(14.062656f, 20.270292f, 21.491228f, 27.668304f, 29.0f, 34.997543f);
                l.cubicTo(19.666666f, 34.997543f, 10.333333f, 35.00737f, 1.0f, 34.98772f);
                l.cubicTo(1.7719299f, 32.541363f, 3.9172933f, 30.812214f, 4.5889726f, 28.336386f);
                l.cubicTo(6.3233085f, 23.394552f, 5.3508773f, 18.05973f, 6.4937344f, 13.0f);
                l.lineTo(6.4937344f, 13.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

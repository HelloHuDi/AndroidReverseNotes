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

public final class vr extends c {
    private final int height = 40;
    private final int width = 40;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                g = c.a(g, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 10.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(1.2f);
                Path l = c.l(looper);
                l.moveTo(0.6f, 5.1f);
                l.lineTo(0.6f, 18.9f);
                l.cubicTo(0.6f, 19.452284f, 1.0477153f, 19.9f, 1.6f, 19.9f);
                l.lineTo(24.4f, 19.9f);
                l.cubicTo(24.952284f, 19.9f, 25.4f, 19.452284f, 25.4f, 18.9f);
                l.lineTo(25.4f, 5.1f);
                l.cubicTo(25.4f, 4.547715f, 24.952284f, 4.1f, 24.4f, 4.1f);
                l.lineTo(19.191229f, 4.1f);
                l.lineTo(16.751053f, 0.68375236f);
                l.cubicTo(16.71351f, 0.63119316f, 16.652895f, 0.6f, 16.588306f, 0.6f);
                l.lineTo(9.411695f, 0.6f);
                l.cubicTo(9.347104f, 0.6f, 9.2864895f, 0.63119316f, 9.248947f, 0.68375236f);
                l.lineTo(6.8087707f, 4.1f);
                l.lineTo(1.6f, 4.1f);
                l.cubicTo(1.0477153f, 4.1f, 0.6f, 4.547715f, 0.6f, 5.1f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(2.0f, 0.5f);
                l2.lineTo(5.5f, 0.5f);
                l2.lineTo(5.5f, 2.0f);
                l2.lineTo(2.0f, 2.0f);
                l2.lineTo(2.0f, 0.5f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-1);
                l = c.l(looper);
                l.moveTo(7.0f, 11.0f);
                l.lineTo(5.0f, 11.0f);
                l.lineTo(7.75f, 8.25f);
                l.lineTo(10.5f, 11.0f);
                l.lineTo(8.5f, 11.0f);
                l.cubicTo(8.5f, 13.485281f, 10.514719f, 15.5f, 13.0f, 15.5f);
                l.cubicTo(14.264459f, 15.5f, 15.407109f, 14.978478f, 16.224586f, 14.1388f);
                l.lineTo(17.285318f, 15.199532f);
                l.cubicTo(16.196331f, 16.310623f, 14.678672f, 17.0f, 13.0f, 17.0f);
                l.cubicTo(9.686292f, 17.0f, 7.0f, 14.313708f, 7.0f, 11.0f);
                l.close();
                l.moveTo(19.0f, 11.0f);
                l.lineTo(21.0f, 11.0f);
                l.lineTo(18.25f, 13.75f);
                l.lineTo(15.5f, 11.0f);
                l.lineTo(17.5f, 11.0f);
                l.cubicTo(17.5f, 8.514719f, 15.485281f, 6.5f, 13.0f, 6.5f);
                l.cubicTo(11.735541f, 6.5f, 10.592891f, 7.021522f, 9.7754135f, 7.8612f);
                l.lineTo(8.714682f, 6.800468f);
                l.cubicTo(9.803668f, 5.6893764f, 11.321328f, 5.0f, 13.0f, 5.0f);
                l.cubicTo(16.31371f, 5.0f, 19.0f, 7.6862917f, 19.0f, 11.0f);
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

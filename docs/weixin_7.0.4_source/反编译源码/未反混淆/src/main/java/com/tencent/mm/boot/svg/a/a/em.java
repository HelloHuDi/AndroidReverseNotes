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

public final class em extends c {
    private final int height = 45;
    private final int width = 45;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                k2 = c.a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                Paint a2 = c.a(k2, looper);
                a.setColor(1275068416);
                a2.setColor(-1);
                a2.setStrokeWidth(2.3f);
                Path l = c.l(looper);
                l.moveTo(22.5f, 1.1499996f);
                l.cubicTo(34.29128f, 1.1499996f, 43.85f, 10.70872f, 43.85f, 22.5f);
                l.cubicTo(43.85f, 34.29128f, 34.29128f, 43.85f, 22.5f, 43.85f);
                l.cubicTo(10.70872f, 43.85f, 1.1499996f, 34.29128f, 1.1499996f, 22.5f);
                l.cubicTo(1.1499996f, 10.70872f, 10.70872f, 1.1499996f, 22.5f, 1.1499996f);
                l.close();
                canvas.drawPath(l, a);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(29.748446f, 23.296038f);
                l.lineTo(19.473919f, 30.033487f);
                l.cubicTo(19.03428f, 30.321777f, 18.444176f, 30.199085f, 18.155884f, 29.759445f);
                l.cubicTo(18.05418f, 29.60435f, 18.0f, 29.422918f, 18.0f, 29.23745f);
                l.lineTo(18.0f, 15.762551f);
                l.cubicTo(18.0f, 15.236818f, 18.426191f, 14.810628f, 18.951923f, 14.810628f);
                l.cubicTo(19.137392f, 14.810628f, 19.318823f, 14.864809f, 19.473919f, 14.966513f);
                l.lineTo(29.748446f, 21.703962f);
                l.cubicTo(30.188086f, 21.992252f, 30.310778f, 22.582357f, 30.022488f, 23.021997f);
                l.cubicTo(29.950897f, 23.131168f, 29.857618f, 23.22445f, 29.748446f, 23.296038f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

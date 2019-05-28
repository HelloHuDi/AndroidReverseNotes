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

public final class wa extends c {
    private final int height = 48;
    private final int width = 52;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 52;
            case 1:
                return 48;
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
                k.setColor(-7503);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(14.181818f, 0.0f);
                l.cubicTo(7.043382f, 0.0f, 2.0274723E-7f, 6.794741f, 0.0f, 19.047619f);
                l.cubicTo(-2.0274723E-7f, 30.949684f, 12.336814f, 43.475533f, 26.0f, 48.0f);
                l.cubicTo(40.098804f, 43.475533f, 52.0f, 30.618835f, 52.0f, 19.047619f);
                l.cubicTo(52.0f, 6.463891f, 45.245247f, 1.657497E-7f, 37.81818f, 0.0f);
                l.cubicTo(31.004267f, -1.4875212E-7f, 28.267746f, 2.4507387f, 26.0f, 4.7619047f);
                l.cubicTo(23.75256f, 2.4507387f, 20.412228f, 0.0f, 14.181818f, 0.0f);
                l.close();
                l.moveTo(15.702877f, 6.3492064f);
                l.cubicTo(11.534709f, 6.3492064f, 6.3030305f, 10.766748f, 6.3030305f, 18.896448f);
                l.cubicTo(6.3030305f, 27.026146f, 14.82103f, 37.12266f, 26.0f, 40.857143f);
                l.cubicTo(37.535385f, 37.12266f, 45.696968f, 25.122057f, 45.696968f, 18.896448f);
                l.cubicTo(45.696968f, 12.670838f, 41.74611f, 6.3492064f, 35.669422f, 6.3492064f);
                l.cubicTo(30.0944f, 6.3492064f, 27.220886f, 12.0678f, 26.0f, 14.285714f);
                l.cubicTo(24.840904f, 12.0678f, 19.871044f, 6.3492064f, 15.702877f, 6.3492064f);
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

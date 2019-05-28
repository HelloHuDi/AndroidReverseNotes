package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aaf */
public final class aaf extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(52.970562f, 22.029438f);
                l.cubicTo(57.31371f, 26.372583f, 60.0f, 32.37258f, 60.0f, 39.0f);
                l.cubicTo(60.0f, 52.254833f, 49.254833f, 63.0f, 36.0f, 63.0f);
                l.cubicTo(22.745167f, 63.0f, 12.0f, 52.254833f, 12.0f, 39.0f);
                l.cubicTo(12.0f, 25.745167f, 22.745167f, 15.0f, 36.0f, 15.0f);
                l.lineTo(36.0f, 21.0f);
                l.cubicTo(26.058874f, 21.0f, 18.0f, 29.058874f, 18.0f, 39.0f);
                l.cubicTo(18.0f, 48.941124f, 26.058874f, 57.0f, 36.0f, 57.0f);
                l.cubicTo(45.941124f, 57.0f, 54.0f, 48.941124f, 54.0f, 39.0f);
                l.cubicTo(54.0f, 34.155792f, 52.085682f, 29.629839f, 48.72792f, 26.272078f);
                l.lineTo(52.970562f, 22.029438f);
                l.close();
                l.moveTo(31.63806f, 15.395418f);
                l.lineTo(26.485281f, 10.2426405f);
                l.lineTo(30.727922f, 6.0f);
                l.lineTo(42.395184f, 17.667261f);
                l.cubicTo(42.980972f, 18.253048f, 42.980972f, 19.202795f, 42.395184f, 19.788582f);
                l.lineTo(30.727922f, 31.455845f);
                l.lineTo(26.485281f, 27.213203f);
                l.lineTo(32.322514f, 21.375973f);
                l.cubicTo(24.145084f, 23.07356f, 18.0f, 30.319149f, 18.0f, 39.0f);
                l.cubicTo(18.0f, 48.941124f, 26.058874f, 57.0f, 36.0f, 57.0f);
                l.cubicTo(45.941124f, 57.0f, 54.0f, 48.941124f, 54.0f, 39.0f);
                l.cubicTo(54.0f, 34.155792f, 52.085682f, 29.629839f, 48.72792f, 26.272078f);
                l.lineTo(52.970562f, 22.029438f);
                l.cubicTo(57.31371f, 26.372583f, 60.0f, 32.37258f, 60.0f, 39.0f);
                l.cubicTo(60.0f, 52.254833f, 49.254833f, 63.0f, 36.0f, 63.0f);
                l.cubicTo(22.745167f, 63.0f, 12.0f, 52.254833f, 12.0f, 39.0f);
                l.cubicTo(12.0f, 27.234737f, 20.465796f, 17.446768f, 31.63806f, 15.395418f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

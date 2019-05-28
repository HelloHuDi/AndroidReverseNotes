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

public final class sd extends c {
    private final int height = 480;
    private final int width = 480;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-2565928);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(480.0f, 0.0f);
                l.lineTo(480.0f, 480.0f);
                l.lineTo(0.0f, 480.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(377.6f, 272.91428f);
                l2.lineTo(377.6f, 137.6f);
                l2.lineTo(102.4f, 137.6f);
                l2.lineTo(102.4f, 269.6258f);
                l2.lineTo(188.8f, 188.8f);
                l2.lineTo(288.0f, 278.4f);
                l2.lineTo(278.4f, 252.8f);
                l2.lineTo(320.0f, 220.8f);
                l2.lineTo(377.6f, 272.91428f);
                l2.close();
                l2.moveTo(86.4f, 124.594025f);
                l2.cubicTo(86.4f, 122.940475f, 87.736046f, 121.6f, 89.391014f, 121.6f);
                l2.lineTo(390.60898f, 121.6f);
                l2.cubicTo(392.26086f, 121.6f, 393.6f, 122.946335f, 393.6f, 124.594025f);
                l2.lineTo(393.6f, 355.40598f);
                l2.cubicTo(393.6f, 357.05954f, 392.26395f, 358.4f, 390.60898f, 358.4f);
                l2.lineTo(89.391014f, 358.4f);
                l2.cubicTo(87.73912f, 358.4f, 86.4f, 357.05365f, 86.4f, 355.40598f);
                l2.lineTo(86.4f, 124.594025f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

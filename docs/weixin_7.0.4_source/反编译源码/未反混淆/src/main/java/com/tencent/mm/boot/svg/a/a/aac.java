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

public final class aac extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(36.0f, 66.0f);
                l.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                l.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                l.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                l.close();
                l.moveTo(32.295f, 25.140745f);
                l.cubicTo(32.056602f, 24.991747f, 31.78113f, 24.912743f, 31.5f, 24.912743f);
                l.cubicTo(30.671574f, 24.912743f, 30.0f, 25.584316f, 30.0f, 26.412743f);
                l.lineTo(30.0f, 45.587257f);
                l.cubicTo(30.0f, 45.868385f, 30.079004f, 46.14386f, 30.228003f, 46.382256f);
                l.cubicTo(30.667068f, 47.08476f, 31.592493f, 47.29832f, 32.295f, 46.859253f);
                l.lineTo(47.63461f, 37.272f);
                l.cubicTo(47.827763f, 37.151276f, 47.990887f, 36.98815f, 48.11161f, 36.795f);
                l.cubicTo(48.550674f, 36.092495f, 48.337116f, 35.16707f, 47.63461f, 34.728f);
                l.lineTo(32.295f, 25.140745f);
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

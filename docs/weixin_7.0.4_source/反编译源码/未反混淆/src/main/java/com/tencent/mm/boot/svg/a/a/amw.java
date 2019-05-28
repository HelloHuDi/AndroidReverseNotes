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

public final class amw extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(47.9995f, 20.0f);
                l.cubicTo(30.878777f, 20.0f, 17.0f, 31.79821f, 17.0f, 46.35247f);
                l.cubicTo(17.0f, 53.18859f, 20.06195f, 59.415703f, 25.08287f, 64.098785f);
                l.cubicTo(23.80389f, 68.17186f, 21.427929f, 76.0f, 21.427929f, 76.0f);
                l.lineTo(34.25072f, 69.97289f);
                l.cubicTo(38.394653f, 71.719925f, 43.06058f, 72.70594f, 48.0005f, 72.70594f);
                l.cubicTo(65.12122f, 72.70594f, 79.0f, 60.90773f, 79.0f, 46.35147f);
                l.cubicTo(78.999f, 31.79821f, 65.120224f, 20.0f, 47.9995f, 20.0f);
                l.lineTo(47.9995f, 20.0f);
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

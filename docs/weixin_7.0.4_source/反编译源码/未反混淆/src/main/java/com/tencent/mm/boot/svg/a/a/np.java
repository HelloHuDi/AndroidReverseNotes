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

public final class np extends c {
    private final int height = d.MIC_ALPHA_ADJUST_REAL;
    private final int width = d.MIC_ALPHA_ADJUST_REAL;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.MIC_ALPHA_ADJUST_REAL;
            case 1:
                return d.MIC_ALPHA_ADJUST_REAL;
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
                g = c.a(g, 1.0f, 0.0f, -1265.0f, 0.0f, 1.0f, -201.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path l = c.l(looper);
                l.moveTo(1268.0f, 259.5f);
                l.cubicTo(1268.0f, 228.84819f, 1292.8481f, 204.0f, 1323.5f, 204.0f);
                l.lineTo(1323.5f, 204.0f);
                l.cubicTo(1354.1519f, 204.0f, 1379.0f, 228.84819f, 1379.0f, 259.5f);
                l.lineTo(1379.0f, 259.5f);
                l.cubicTo(1379.0f, 290.1518f, 1354.1519f, 315.0f, 1323.5f, 315.0f);
                l.lineTo(1323.5f, 315.0f);
                l.cubicTo(1292.8481f, 315.0f, 1268.0f, 290.1518f, 1268.0f, 259.5f);
                l.lineTo(1268.0f, 259.5f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-16139513);
                l = c.l(looper);
                l.moveTo(1309.1147f, 266.15973f);
                l.cubicTo(1310.8816f, 264.54208f, 1312.0f, 262.14874f, 1312.0f, 259.4782f);
                l.cubicTo(1312.0f, 257.09238f, 1311.1073f, 254.92775f, 1309.6571f, 253.33984f);
                l.lineTo(1302.976f, 260.02097f);
                l.lineTo(1309.1147f, 266.15973f);
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

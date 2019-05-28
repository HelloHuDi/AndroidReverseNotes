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

public final class ip extends c {
    private final int height = 210;
    private final int width = 210;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                Paint a = c.a(k, looper);
                a.setColor(-15028967);
                Path l = c.l(looper);
                l.moveTo(210.0f, 106.296295f);
                l.cubicTo(210.0f, 47.00889f, 162.9911f, 0.0f, 103.703705f, 0.0f);
                l.cubicTo(47.00889f, 0.0f, 0.0f, 47.00889f, 0.0f, 106.296295f);
                l.cubicTo(0.0f, 162.9911f, 47.00889f, 210.0f, 103.703705f, 210.0f);
                l.cubicTo(162.9911f, 210.0f, 210.0f, 162.9911f, 210.0f, 106.296295f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(54.281837f, 109.439514f);
                l.lineTo(58.17945f, 104.19687f);
                l.lineTo(58.17945f, 104.19687f);
                l.cubicTo(58.640762f, 103.57636f, 59.51775f, 103.44731f, 60.138256f, 103.90862f);
                l.cubicTo(60.141663f, 103.911156f, 60.145058f, 103.913704f, 60.148438f, 103.91627f);
                l.lineTo(84.99948f, 122.74494f);
                l.lineTo(84.99948f, 122.74494f);
                l.cubicTo(85.516304f, 123.13652f, 86.2344f, 123.12196f, 86.73493f, 122.709755f);
                l.lineTo(147.92569f, 72.31694f);
                l.lineTo(147.92569f, 72.31694f);
                l.cubicTo(148.47726f, 71.8627f, 149.28241f, 71.89673f, 149.79369f, 72.39588f);
                l.lineTo(153.3208f, 75.83935f);
                l.lineTo(153.3208f, 75.83935f);
                l.cubicTo(153.87405f, 76.37948f, 153.8847f, 77.26585f, 153.34456f, 77.8191f);
                l.cubicTo(153.33617f, 77.8277f, 153.32767f, 77.83619f, 153.31905f, 77.84457f);
                l.lineTo(86.880226f, 142.48117f);
                l.lineTo(86.880226f, 142.48117f);
                l.cubicTo(86.32694f, 143.01945f, 85.44236f, 143.00832f, 84.902794f, 142.4563f);
                l.lineTo(54.40418f, 111.25338f);
                l.lineTo(54.40418f, 111.25338f);
                l.cubicTo(53.922985f, 110.76107f, 53.871113f, 109.99198f, 54.281837f, 109.439514f);
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

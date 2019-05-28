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
import com.tencent.view.d;

public final class ix extends c {
    private final int height = 242;
    private final int width = d.MIC_PTU_ZIPAI_LIGHTWHITE;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.MIC_PTU_ZIPAI_LIGHTWHITE;
            case 1:
                return 242;
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
                Paint a = c.a(k2, looper);
                a.setColor(-3552823);
                a.setStrokeWidth(4.0f);
                Path l = c.l(looper);
                l.moveTo(123.0f, 7.0f);
                l.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                l.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                l.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                l.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-3552823);
                Path l2 = c.l(looper);
                l2.moveTo(117.133484f, 111.829056f);
                l2.lineTo(94.750854f, 89.44642f);
                l2.lineTo(94.750854f, 100.31056f);
                l2.lineTo(116.18076f, 121.74048f);
                l2.lineTo(94.750854f, 143.17038f);
                l2.lineTo(94.750854f, 154.18599f);
                l2.lineTo(117.133484f, 131.80336f);
                l2.lineTo(117.133484f, 165.4863f);
                l2.lineTo(116.812836f, 165.80695f);
                l2.lineTo(117.133484f, 165.80695f);
                l2.lineTo(117.133484f, 176.5019f);
                l2.lineTo(149.46358f, 144.17183f);
                l2.lineTo(148.58734f, 143.2956f);
                l2.lineTo(148.59369f, 143.28926f);
                l2.lineTo(127.12064f, 121.81621f);
                l2.lineTo(148.28012f, 100.65672f);
                l2.lineTo(148.23923f, 100.61583f);
                l2.lineTo(150.24332f, 98.61174f);
                l2.lineTo(117.133484f, 65.501915f);
                l2.lineTo(117.133484f, 75.7257f);
                l2.lineTo(117.133484f, 111.829056f);
                l2.close();
                l2.moveTo(124.9227f, 112.99854f);
                l2.lineTo(139.2686f, 98.65264f);
                l2.lineTo(124.9227f, 84.30673f);
                l2.lineTo(124.9227f, 112.99854f);
                l2.close();
                l2.moveTo(124.9227f, 157.6971f);
                l2.lineTo(138.53004f, 144.08975f);
                l2.lineTo(124.9227f, 130.4824f);
                l2.lineTo(124.9227f, 157.6971f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

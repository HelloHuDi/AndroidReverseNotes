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
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

public final class amc extends c {
    private final int height = ErrorCode.STARTDOWNLOAD_6;
    private final int width = ErrorCode.STARTDOWNLOAD_6;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ErrorCode.STARTDOWNLOAD_6;
            case 1:
                return ErrorCode.STARTDOWNLOAD_6;
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
                k.setColor(-4671304);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(165.0f, 83.51852f);
                l.cubicTo(165.0f, 36.935555f, 128.06444f, 0.0f, 81.48148f, 0.0f);
                l.cubicTo(36.935555f, 0.0f, 0.0f, 36.935555f, 0.0f, 83.51852f);
                l.cubicTo(0.0f, 128.06444f, 36.935555f, 165.0f, 81.48148f, 165.0f);
                l.cubicTo(128.06444f, 165.0f, 165.0f, 128.06444f, 165.0f, 83.51852f);
                l.close();
                l.moveTo(156.0f, 83.40741f);
                l.cubicTo(156.0f, 41.906223f, 123.09378f, 9.0f, 81.59259f, 9.0f);
                l.cubicTo(41.906223f, 9.0f, 9.0f, 41.906223f, 9.0f, 83.40741f);
                l.cubicTo(9.0f, 123.09378f, 41.906223f, 156.0f, 81.59259f, 156.0f);
                l.cubicTo(123.09378f, 156.0f, 156.0f, 123.09378f, 156.0f, 83.40741f);
                l.close();
                l.moveTo(81.06782f, 123.30645f);
                l.cubicTo(79.40914f, 123.30645f, 78.03121f, 121.96418f, 77.99018f, 120.31069f);
                l.lineTo(76.660355f, 66.71527f);
                l.cubicTo(76.6193f, 65.06076f, 77.919846f, 63.719513f, 79.586006f, 63.719513f);
                l.lineTo(85.413994f, 63.719513f);
                l.cubicTo(87.07084f, 63.719513f, 88.38068f, 65.06178f, 88.339645f, 66.71527f);
                l.lineTo(87.00982f, 120.31069f);
                l.cubicTo(86.968765f, 121.9652f, 85.58817f, 123.30645f, 83.93218f, 123.30645f);
                l.lineTo(81.06782f, 123.30645f);
                l.close();
                l.moveTo(82.5f, 41.693546f);
                l.cubicTo(86.41944f, 41.693546f, 89.59677f, 44.87088f, 89.59677f, 48.79032f);
                l.cubicTo(89.59677f, 52.709763f, 86.41944f, 55.887096f, 82.5f, 55.887096f);
                l.cubicTo(78.58056f, 55.887096f, 75.40323f, 52.709763f, 75.40323f, 48.79032f);
                l.cubicTo(75.40323f, 44.87088f, 78.58056f, 41.693546f, 82.5f, 41.693546f);
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

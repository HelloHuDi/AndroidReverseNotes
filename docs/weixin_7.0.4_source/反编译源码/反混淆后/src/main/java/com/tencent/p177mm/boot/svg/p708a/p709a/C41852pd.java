package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.pd */
public final class C41852pd extends C5163c {
    private final int height = ErrorCode.STARTDOWNLOAD_3;
    private final int width = ErrorCode.STARTDOWNLOAD_3;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ErrorCode.STARTDOWNLOAD_3;
            case 1:
                return ErrorCode.STARTDOWNLOAD_3;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
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
                canvas.saveLayerAlpha(null, 128, 4);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.333333f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.6666667f, 80.666664f);
                l.cubicTo(0.6666667f, 36.554592f, 36.554333f, 0.6666667f, 80.666664f, 0.6666667f);
                l.cubicTo(124.779f, 0.6666667f, 160.66667f, 36.554592f, 160.66667f, 80.666664f);
                l.cubicTo(160.66667f, 124.77874f, 124.779f, 160.66667f, 80.666664f, 160.66667f);
                l.cubicTo(36.554333f, 160.66667f, 0.6666667f, 124.77874f, 0.6666667f, 80.666664f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-11711155);
                l = C5163c.m7884l(looper);
                l.moveTo(106.666664f, 96.666664f);
                l.cubicTo(106.666664f, 101.28787f, 104.28978f, 103.666664f, 99.666664f, 103.666664f);
                l.lineTo(60.666668f, 103.666664f);
                l.cubicTo(56.043552f, 103.666664f, 53.666668f, 101.28787f, 53.666668f, 96.666664f);
                l.lineTo(53.666668f, 57.666668f);
                l.lineTo(71.666664f, 57.666668f);
                l.lineTo(77.666664f, 64.666664f);
                l.lineTo(106.666664f, 64.666664f);
                l.lineTo(106.666664f, 98.666664f);
                l.lineTo(106.666664f, 96.666664f);
                l.close();
                l.moveTo(79.666664f, 61.666668f);
                l.lineTo(73.666664f, 54.666668f);
                l.lineTo(53.666668f, 54.666668f);
                l.cubicTo(52.0857f, 54.666668f, 50.666668f, 56.086094f, 50.666668f, 57.666668f);
                l.lineTo(50.666668f, 96.666664f);
                l.cubicTo(50.666668f, 102.8492f, 54.57398f, 106.666664f, 60.666668f, 106.666664f);
                l.lineTo(99.666664f, 106.666664f);
                l.cubicTo(105.75935f, 106.666664f, 109.666664f, 102.8492f, 109.666664f, 96.666664f);
                l.lineTo(109.666664f, 64.666664f);
                l.cubicTo(109.666664f, 62.701645f, 108.24101f, 61.27891f, 106.666664f, 61.666668f);
                l.lineTo(79.666664f, 61.666668f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-11711155);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(59.666668f, 78.666664f);
                l2.lineTo(100.666664f, 78.666664f);
                l2.lineTo(100.666664f, 75.666664f);
                l2.lineTo(59.666668f, 75.666664f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

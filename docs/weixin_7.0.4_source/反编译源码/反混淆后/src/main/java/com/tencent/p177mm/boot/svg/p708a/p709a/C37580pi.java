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

/* renamed from: com.tencent.mm.boot.svg.a.a.pi */
public final class C37580pi extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.222222f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.05f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.6666667f, 80.727776f);
                l.cubicTo(0.6666667f, 36.615704f, 36.554333f, 0.7277778f, 80.666664f, 0.7277778f);
                l.cubicTo(124.779f, 0.7277778f, 160.66667f, 36.615704f, 160.66667f, 80.727776f);
                l.cubicTo(160.66667f, 124.83985f, 124.779f, 160.72778f, 80.666664f, 160.72778f);
                l.cubicTo(36.554333f, 160.72778f, 0.6666667f, 124.83985f, 0.6666667f, 80.727776f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-11711155);
                l = C5163c.m7884l(looper);
                l.moveTo(94.666664f, 75.727776f);
                l.lineTo(94.666664f, 72.727776f);
                l.lineTo(94.666664f, 65.727776f);
                l.cubicTo(94.666664f, 57.59596f, 88.18667f, 50.72778f, 80.150536f, 50.72778f);
                l.lineTo(79.18279f, 50.72778f);
                l.cubicTo(71.13917f, 50.72778f, 64.666664f, 57.594822f, 64.666664f, 65.727776f);
                l.lineTo(64.666664f, 72.727776f);
                l.lineTo(64.666664f, 75.727776f);
                l.lineTo(94.666664f, 75.727776f);
                l.close();
                l.moveTo(67.666664f, 66.39445f);
                l.cubicTo(67.666664f, 59.320904f, 72.80921f, 53.72778f, 78.666664f, 53.72778f);
                l.lineTo(80.666664f, 53.72778f);
                l.cubicTo(86.524124f, 53.72778f, 91.666664f, 59.320904f, 91.666664f, 66.39445f);
                l.lineTo(91.666664f, 72.727776f);
                l.lineTo(67.666664f, 72.727776f);
                l.lineTo(67.666664f, 66.39445f);
                l.close();
                l.moveTo(94.666664f, 72.727776f);
                l.lineTo(94.666664f, 75.727776f);
                l.lineTo(101.666664f, 75.727776f);
                l.lineTo(101.666664f, 107.727776f);
                l.lineTo(57.666668f, 107.727776f);
                l.lineTo(57.666668f, 75.727776f);
                l.lineTo(64.666664f, 75.727776f);
                l.lineTo(64.666664f, 72.727776f);
                l.lineTo(57.666668f, 72.727776f);
                l.cubicTo(56.894035f, 72.88537f, 56.49158f, 73.059715f, 55.666668f, 73.727776f);
                l.cubicTo(55.42945f, 73.78284f, 54.912796f, 74.532776f, 54.666668f, 75.727776f);
                l.cubicTo(54.68995f, 75.62584f, 54.666668f, 107.727776f, 54.666668f, 107.727776f);
                l.cubicTo(54.666668f, 108.5316f, 55.248734f, 109.55201f, 55.666668f, 109.727776f);
                l.cubicTo(56.664536f, 110.51654f, 57.305363f, 110.727776f, 57.666668f, 110.727776f);
                l.lineTo(101.666664f, 110.727776f);
                l.cubicTo(103.168816f, 110.727776f, 104.666664f, 109.22566f, 104.666664f, 107.727776f);
                l.lineTo(104.666664f, 75.727776f);
                l.cubicTo(104.666664f, 74.228775f, 103.17769f, 72.727776f, 101.666664f, 72.727776f);
                l.lineTo(94.666664f, 72.727776f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

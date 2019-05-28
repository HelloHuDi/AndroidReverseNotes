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
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.atb */
public final class atb extends C5163c {
    private final int height = 12;
    private final int width = 64;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 12;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-2565928);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(6.0f, 12.0f);
                l.cubicTo(9.313708f, 12.0f, 12.0f, 9.313708f, 12.0f, 6.0f);
                l.cubicTo(12.0f, 2.6862915f, 9.313708f, 0.0f, 6.0f, 0.0f);
                l.cubicTo(2.6862915f, 0.0f, 0.0f, 2.6862915f, 0.0f, 6.0f);
                l.cubicTo(0.0f, 9.313708f, 2.6862915f, 12.0f, 6.0f, 12.0f);
                l.close();
                l.moveTo(32.0f, 12.0f);
                l.cubicTo(35.31371f, 12.0f, 38.0f, 9.313708f, 38.0f, 6.0f);
                l.cubicTo(38.0f, 2.6862915f, 35.31371f, 0.0f, 32.0f, 0.0f);
                l.cubicTo(28.68629f, 0.0f, 26.0f, 2.6862915f, 26.0f, 6.0f);
                l.cubicTo(26.0f, 9.313708f, 28.68629f, 12.0f, 32.0f, 12.0f);
                l.close();
                l.moveTo(58.0f, 12.0f);
                l.cubicTo(61.31371f, 12.0f, 64.0f, 9.313708f, 64.0f, 6.0f);
                l.cubicTo(64.0f, 2.6862915f, 61.31371f, 0.0f, 58.0f, 0.0f);
                l.cubicTo(54.68629f, 0.0f, 52.0f, 2.6862915f, 52.0f, 6.0f);
                l.cubicTo(52.0f, 9.313708f, 54.68629f, 12.0f, 58.0f, 12.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(6.0f, 12.0f);
                l.cubicTo(9.313708f, 12.0f, 12.0f, 9.313708f, 12.0f, 6.0f);
                l.cubicTo(12.0f, 2.6862915f, 9.313708f, 0.0f, 6.0f, 0.0f);
                l.cubicTo(2.6862915f, 0.0f, 0.0f, 2.6862915f, 0.0f, 6.0f);
                l.cubicTo(0.0f, 9.313708f, 2.6862915f, 12.0f, 6.0f, 12.0f);
                l.close();
                l.moveTo(32.0f, 12.0f);
                l.cubicTo(35.31371f, 12.0f, 38.0f, 9.313708f, 38.0f, 6.0f);
                l.cubicTo(38.0f, 2.6862915f, 35.31371f, 0.0f, 32.0f, 0.0f);
                l.cubicTo(28.68629f, 0.0f, 26.0f, 2.6862915f, 26.0f, 6.0f);
                l.cubicTo(26.0f, 9.313708f, 28.68629f, 12.0f, 32.0f, 12.0f);
                l.close();
                l.moveTo(58.0f, 12.0f);
                l.cubicTo(61.31371f, 12.0f, 64.0f, 9.313708f, 64.0f, 6.0f);
                l.cubicTo(64.0f, 2.6862915f, 61.31371f, 0.0f, 58.0f, 0.0f);
                l.cubicTo(54.68629f, 0.0f, 52.0f, 2.6862915f, 52.0f, 6.0f);
                l.cubicTo(52.0f, 9.313708f, 54.68629f, 12.0f, 58.0f, 12.0f);
                l.close();
                Paint k3 = C5163c.m7883k(looper);
                k3.setFlags(385);
                k3.setStyle(Style.FILL);
                Paint k4 = C5163c.m7883k(looper);
                k4.setFlags(385);
                k4.setStyle(Style.STROKE);
                k3.setColor(WebView.NIGHT_MODE_COLOR);
                k4.setStrokeWidth(1.0f);
                k4.setStrokeCap(Cap.BUTT);
                k4.setStrokeJoin(Join.MITER);
                k4.setStrokeMiter(4.0f);
                k4.setPathEffect(null);
                float[] a2 = C5163c.m7878a(g, 64.0f, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-6556649, -9903790}, new float[]{0.0f, 1.0f}, h, 0);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

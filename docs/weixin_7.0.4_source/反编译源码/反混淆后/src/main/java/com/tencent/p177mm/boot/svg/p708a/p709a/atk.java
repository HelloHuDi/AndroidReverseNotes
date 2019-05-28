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

/* renamed from: com.tencent.mm.boot.svg.a.a.atk */
public final class atk extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                l.moveTo(45.0f, 12.0f);
                l.cubicTo(63.225395f, 12.0f, 78.0f, 26.774603f, 78.0f, 45.0f);
                l.cubicTo(78.0f, 63.225395f, 63.225395f, 78.0f, 45.0f, 78.0f);
                l.cubicTo(26.774603f, 78.0f, 12.0f, 63.225395f, 12.0f, 45.0f);
                l.cubicTo(12.0f, 26.774603f, 26.774603f, 12.0f, 45.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(45.0f, 12.0f);
                l.cubicTo(63.225395f, 12.0f, 78.0f, 26.774603f, 78.0f, 45.0f);
                l.cubicTo(78.0f, 63.225395f, 63.225395f, 78.0f, 45.0f, 78.0f);
                l.cubicTo(26.774603f, 78.0f, 12.0f, 63.225395f, 12.0f, 45.0f);
                l.cubicTo(12.0f, 26.774603f, 26.774603f, 12.0f, 45.0f, 12.0f);
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
                float[] a3 = C5163c.m7878a(g, 66.0f, 0.0f, 12.0f, 0.0f, 66.0f, 12.0f);
                h.reset();
                h.setValues(a3);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-10560163, -5768183}, new float[]{0.0f, 1.0f}, h, 0);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(38.250305f, 53.508274f);
                l2.lineTo(29.74203f, 45.0f);
                l2.lineTo(25.49939f, 49.24264f);
                l2.lineTo(38.22731f, 61.970562f);
                l2.lineTo(38.283035f, 61.914837f);
                l2.lineTo(38.30603f, 61.93783f);
                l2.lineTo(64.62193f, 35.62193f);
                l2.lineTo(60.37929f, 31.37929f);
                l2.lineTo(38.250305f, 53.508274f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

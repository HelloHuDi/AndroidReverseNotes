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

/* renamed from: com.tencent.mm.boot.svg.a.a.asi */
public final class asi extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                k2.setColor(-16896);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(22.7f, 0.0f);
                l.lineTo(25.07f, 0.0f);
                l.cubicTo(36.94f, 0.34f, 47.3f, 10.5f, 48.0f, 22.33f);
                l.lineTo(48.0f, 25.39f);
                l.cubicTo(47.47f, 37.15f, 37.36f, 47.34f, 25.6f, 48.0f);
                l.lineTo(22.61f, 48.0f);
                l.cubicTo(10.79f, 47.47f, 0.57f, 37.25f, 0.0f, 25.44f);
                l.lineTo(0.0f, 22.47f);
                l.cubicTo(0.61f, 10.66f, 10.88f, 0.5f, 22.7f, 0.0f);
                l.lineTo(22.7f, 0.0f);
                l.close();
                l.moveTo(23.290903f, 13.335449f);
                l.cubicTo(20.390598f, 14.737528f, 22.898153f, 19.267319f, 25.697754f, 17.65934f);
                l.cubicTo(28.628271f, 16.237654f, 26.080433f, 11.747081f, 23.290903f, 13.335449f);
                l.lineTo(23.290903f, 13.335449f);
                l.close();
                l.moveTo(20.0f, 20.0f);
                l.lineTo(20.00998f, 20.98f);
                l.cubicTo(20.758484f, 20.99f, 22.25549f, 21.01f, 23.003992f, 21.02f);
                l.lineTo(23.003992f, 34.98f);
                l.cubicTo(22.25549f, 34.99f, 20.758484f, 35.01f, 20.00998f, 35.02f);
                l.lineTo(20.00998f, 36.0f);
                l.lineTo(30.0f, 36.0f);
                l.lineTo(29.99002f, 35.02f);
                l.cubicTo(29.241516f, 35.01f, 27.74451f, 34.99f, 26.996008f, 34.98f);
                l.cubicTo(26.996008f, 29.99f, 27.005987f, 24.99f, 26.996008f, 20.0f);
                l.lineTo(20.0f, 20.0f);
                l.lineTo(20.0f, 20.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(3.290903f, 0.33544943f);
                l.cubicTo(6.080433f, -1.2529188f, 8.628271f, 3.2376533f, 5.697754f, 4.659341f);
                l.cubicTo(2.8981533f, 6.2673187f, 0.39059758f, 1.7375276f, 3.290903f, 0.33544943f);
                l.lineTo(3.290903f, 0.33544943f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 7.0f);
                l.lineTo(6.996008f, 7.0f);
                l.cubicTo(7.005988f, 11.99f, 6.996008f, 16.99f, 6.996008f, 21.98f);
                l.cubicTo(7.744511f, 21.99f, 9.241517f, 22.01f, 9.99002f, 22.02f);
                l.lineTo(10.0f, 23.0f);
                l.lineTo(0.00998004f, 23.0f);
                l.lineTo(0.00998004f, 22.02f);
                l.cubicTo(0.75848305f, 22.01f, 2.255489f, 21.99f, 3.003992f, 21.98f);
                l.lineTo(3.003992f, 8.02f);
                l.cubicTo(2.255489f, 8.01f, 0.75848305f, 7.99f, 0.00998004f, 7.98f);
                l.lineTo(0.0f, 7.0f);
                l.lineTo(0.0f, 7.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

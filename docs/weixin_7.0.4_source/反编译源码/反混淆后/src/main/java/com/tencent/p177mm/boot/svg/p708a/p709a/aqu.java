package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aqu */
public final class aqu extends C5163c {
    private final int height = 270;
    private final int width = 270;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-1202386);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(130.84f, 0.0f);
                l.lineTo(137.49f, 0.0f);
                l.cubicTo(169.21f, 0.52f, 200.58f, 12.66f, 224.28f, 33.78f);
                l.cubicTo(252.31f, 58.19f, 269.23f, 94.64f, 270.0f, 131.79f);
                l.lineTo(270.0f, 137.24f);
                l.cubicTo(269.55f, 165.21f, 260.21f, 192.96f, 243.45f, 215.38f);
                l.cubicTo(219.22f, 248.49f, 179.23f, 269.26f, 138.21f, 270.0f);
                l.lineTo(131.99f, 270.0f);
                l.cubicTo(100.68f, 269.36f, 69.79f, 257.4f, 46.26f, 236.73f);
                l.cubicTo(17.95f, 212.27f, 0.75f, 175.62f, 0.0f, 138.21f);
                l.lineTo(0.0f, 132.68f);
                l.cubicTo(0.48f, 94.98f, 17.71f, 57.93f, 46.25f, 33.31f);
                l.cubicTo(69.47f, 12.83f, 99.93f, 0.99f, 130.84f, 0.0f);
                l.lineTo(130.84f, 0.0f);
                l.close();
                l.moveTo(71.0f, 135.0f);
                l.cubicTo(85.65116f, 149.34f, 100.32233f, 163.67f, 114.98349f, 178.0f);
                l.cubicTo(115.003494f, 166.66f, 114.98349f, 155.33f, 114.99349f, 144.0f);
                l.cubicTo(142.32567f, 143.99f, 169.66783f, 144.0f, 197.0f, 144.0f);
                l.lineTo(197.0f, 127.0f);
                l.lineTo(114.99349f, 127.0f);
                l.cubicTo(114.98349f, 115.33f, 115.003494f, 103.67f, 114.98349f, 92.0f);
                l.cubicTo(100.33233f, 106.34f, 85.65116f, 120.66f, 71.0f, 135.0f);
                l.lineTo(71.0f, 135.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

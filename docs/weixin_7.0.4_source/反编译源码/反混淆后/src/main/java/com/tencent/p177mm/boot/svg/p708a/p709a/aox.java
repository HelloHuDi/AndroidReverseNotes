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

/* renamed from: com.tencent.mm.boot.svg.a.a.aox */
public final class aox extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-9276814);
                canvas.saveLayerAlpha(null, 128, 4);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.94f, 0.0f);
                l.lineTo(37.86f, 0.0f);
                l.cubicTo(45.96f, 0.56f, 53.93f, 3.66f, 59.96f, 9.15f);
                l.cubicTo(67.07f, 15.44f, 71.42f, 24.59f, 72.0f, 34.05f);
                l.lineTo(72.0f, 37.83f);
                l.cubicTo(71.46f, 47.59f, 66.85f, 57.03f, 59.39f, 63.35f);
                l.cubicTo(53.54f, 68.46f, 45.97f, 71.35f, 38.26f, 72.0f);
                l.lineTo(34.11f, 72.0f);
                l.cubicTo(25.1f, 71.45f, 16.32f, 67.55f, 10.09f, 60.97f);
                l.cubicTo(4.16f, 54.9f, 0.65f, 46.69f, 0.0f, 38.25f);
                l.lineTo(0.0f, 34.13f);
                l.cubicTo(0.55f, 24.37f, 5.18f, 14.93f, 12.65f, 8.61f);
                l.cubicTo(18.55f, 3.47f, 26.18f, 0.61f, 33.94f, 0.0f);
                l.lineTo(33.94f, 0.0f);
                l.close();
                l.moveTo(29.4f, 3.66f);
                l.cubicTo(23.12f, 4.97f, 17.2f, 8.12f, 12.68f, 12.67f);
                l.cubicTo(2.03f, 22.96f, -0.12f, 40.65f, 7.83f, 53.16f);
                l.cubicTo(16.0f, 67.24f, 35.31f, 73.15f, 49.93f, 65.9f);
                l.cubicTo(64.75f, 59.37f, 72.74f, 41.04f, 67.36f, 25.73f);
                l.cubicTo(62.61f, 10.2f, 45.28f, 0.06f, 29.4f, 3.66f);
                l.lineTo(29.4f, 3.66f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(24.0f, 24.0f);
                l2.lineTo(48.0f, 24.0f);
                l2.lineTo(48.0f, 48.0f);
                l2.lineTo(24.0f, 48.0f);
                l2.lineTo(24.0f, 24.0f);
                l2.lineTo(24.0f, 24.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

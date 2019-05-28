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

/* renamed from: com.tencent.mm.boot.svg.a.a.bcn */
public final class bcn extends C5163c {
    private final int height = 70;
    private final int width = 80;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 70;
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
                k.setColor(-1);
                canvas.saveLayerAlpha(null, 204, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(37.23f, 0.0f);
                l.lineTo(41.05f, 0.0f);
                l.cubicTo(52.9f, 0.29f, 64.78f, 5.01f, 72.74f, 13.96f);
                l.cubicTo(59.87f, 19.69f, 46.95f, 25.31f, 34.09f, 31.06f);
                l.cubicTo(32.6f, 31.58f, 30.87f, 32.65f, 29.33f, 31.68f);
                l.cubicTo(25.68f, 29.77f, 22.78f, 26.7f, 19.05f, 24.94f);
                l.cubicTo(18.77f, 25.22f, 18.22f, 25.77f, 17.95f, 26.05f);
                l.cubicTo(20.11f, 31.91f, 22.96f, 37.53f, 25.64f, 43.17f);
                l.cubicTo(26.77f, 45.57f, 29.46f, 44.2f, 31.07f, 43.18f);
                l.cubicTo(45.87f, 34.65f, 60.7f, 26.18f, 75.53f, 17.7f);
                l.cubicTo(77.88f, 21.83f, 79.57f, 26.35f, 80.0f, 31.1f);
                l.lineTo(80.0f, 34.4f);
                l.cubicTo(79.53f, 43.48f, 74.44f, 51.87f, 67.24f, 57.24f);
                l.cubicTo(56.19f, 65.76f, 41.1f, 68.0f, 27.75f, 64.53f);
                l.cubicTo(22.08f, 62.87f, 18.26f, 70.19f, 12.88f, 69.67f);
                l.cubicTo(12.94f, 66.33f, 14.52f, 63.28f, 14.9f, 60.0f);
                l.cubicTo(14.76f, 58.48f, 13.17f, 57.74f, 12.22f, 56.75f);
                l.cubicTo(5.34f, 51.41f, 0.51f, 43.26f, 0.0f, 34.47f);
                l.lineTo(0.0f, 31.4f);
                l.cubicTo(0.54f, 23.87f, 4.14f, 16.76f, 9.59f, 11.6f);
                l.cubicTo(16.98f, 4.47f, 27.11f, 0.76f, 37.23f, 0.0f);
                l.lineTo(37.23f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

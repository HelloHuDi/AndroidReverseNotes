package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.uk */
public final class C41875uk extends C5163c {
    private final int height = C44697b.CTRL_INDEX;
    private final int width = C44697b.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C44697b.CTRL_INDEX;
            case 1:
                return C44697b.CTRL_INDEX;
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
                a.setColor(-9207928);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(64.33f, 0.0f);
                l.lineTo(70.46f, 0.0f);
                l.cubicTo(86.43f, 0.79f, 102.07f, 7.27f, 113.68f, 18.29f);
                l.cubicTo(126.44f, 30.11f, 134.1f, 47.02f, 135.0f, 64.36f);
                l.lineTo(135.0f, 70.12f);
                l.cubicTo(134.28f, 87.64f, 126.56f, 104.77f, 113.68f, 116.71f);
                l.cubicTo(102.13f, 127.69f, 86.58f, 134.14f, 70.7f, 135.0f);
                l.lineTo(64.53f, 135.0f);
                l.cubicTo(48.56f, 134.21f, 32.91f, 127.73f, 21.31f, 116.7f);
                l.cubicTo(8.45f, 104.79f, 0.76f, 87.69f, 0.0f, 70.21f);
                l.lineTo(0.0f, 64.57f);
                l.cubicTo(0.83f, 47.17f, 8.5f, 30.16f, 21.31f, 18.31f);
                l.cubicTo(32.87f, 7.31f, 48.43f, 0.86f, 64.33f, 0.0f);
                l.lineTo(64.33f, 0.0f);
                l.close();
                l.moveTo(38.3f, 45.37f);
                l.cubicTo(36.95f, 46.02f, 36.95f, 47.67f, 36.99f, 48.94f);
                l.cubicTo(37.0f, 61.3f, 37.02f, 73.65f, 36.98f, 86.01f);
                l.cubicTo(37.11f, 87.41f, 36.63f, 89.13f, 37.77f, 90.25f);
                l.cubicTo(38.88f, 91.38f, 40.6f, 90.88f, 42.0f, 91.02f);
                l.cubicTo(59.04f, 90.96f, 76.07f, 91.03f, 93.11f, 90.99f);
                l.cubicTo(94.74f, 91.22f, 96.21f, 89.68f, 95.98f, 88.06f);
                l.cubicTo(96.01f, 74.68f, 96.01f, 61.3f, 95.98f, 47.92f);
                l.cubicTo(96.22f, 46.28f, 94.7f, 44.79f, 93.07f, 45.02f);
                l.cubicTo(76.38f, 44.97f, 59.68f, 45.03f, 42.99f, 44.98f);
                l.cubicTo(41.44f, 45.11f, 39.75f, 44.69f, 38.3f, 45.37f);
                l.lineTo(38.3f, 45.37f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(42.0f, 50.0f);
                l.lineTo(91.0f, 50.0f);
                l.cubicTo(91.01f, 58.8f, 90.99f, 67.6f, 91.01f, 76.4f);
                l.cubicTo(88.58f, 72.83f, 86.13f, 68.76f, 81.95f, 67.06f);
                l.cubicTo(78.44f, 66.25f, 75.78f, 69.53f, 73.18f, 71.35f);
                l.cubicTo(73.84f, 72.68f, 74.47f, 74.03f, 75.09f, 75.39f);
                l.cubicTo(70.89f, 70.42f, 67.58f, 64.27f, 61.69f, 61.07f);
                l.cubicTo(59.23f, 59.62f, 56.51f, 61.03f, 54.45f, 62.49f);
                l.cubicTo(49.5f, 65.99f, 45.24f, 70.47f, 41.98f, 75.59f);
                l.cubicTo(42.02f, 67.06f, 41.99f, 58.53f, 42.0f, 50.0f);
                l.lineTo(42.0f, 50.0f);
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

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

/* renamed from: com.tencent.mm.boot.svg.a.a.ug */
public final class C18070ug extends C5163c {
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
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(64.43f, 0.0f);
                l.lineTo(70.36f, 0.0f);
                l.cubicTo(86.61f, 0.76f, 102.53f, 7.46f, 114.22f, 18.81f);
                l.cubicTo(126.68f, 30.6f, 134.12f, 47.3f, 135.0f, 64.4f);
                l.lineTo(135.0f, 70.04f);
                l.cubicTo(134.31f, 87.59f, 126.58f, 104.75f, 113.69f, 116.7f);
                l.cubicTo(102.12f, 127.7f, 86.53f, 134.17f, 70.61f, 135.0f);
                l.lineTo(64.61f, 135.0f);
                l.cubicTo(48.61f, 134.24f, 32.93f, 127.74f, 21.3f, 116.69f);
                l.cubicTo(8.43f, 104.77f, 0.74f, 87.65f, 0.0f, 70.15f);
                l.lineTo(0.0f, 64.68f);
                l.cubicTo(0.8f, 47.25f, 8.47f, 30.21f, 21.28f, 18.33f);
                l.cubicTo(32.87f, 7.3f, 48.48f, 0.83f, 64.43f, 0.0f);
                l.lineTo(64.43f, 0.0f);
                l.close();
                l.moveTo(52.66f, 42.66f);
                l.cubicTo(44.71f, 48.71f, 41.53f, 59.9f, 44.75f, 69.31f);
                l.cubicTo(48.78f, 81.4f, 57.88f, 91.02f, 67.52f, 99.0f);
                l.cubicTo(77.11f, 90.99f, 86.23f, 81.41f, 90.25f, 69.31f);
                l.cubicTo(93.47f, 59.92f, 90.3f, 48.73f, 82.36f, 42.67f);
                l.cubicTo(74.01f, 35.84f, 61.01f, 35.84f, 52.66f, 42.66f);
                l.lineTo(52.66f, 42.66f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(63.25f, 50.28f);
                l.cubicTo(69.49f, 47.7f, 77.27f, 51.6f, 79.0f, 58.1f);
                l.cubicTo(81.0f, 64.22f, 77.06f, 71.37f, 70.86f, 73.02f);
                l.cubicTo(64.78f, 74.97f, 57.7f, 71.09f, 56.01f, 64.96f);
                l.cubicTo(54.11f, 59.14f, 57.5f, 52.33f, 63.25f, 50.28f);
                l.lineTo(63.25f, 50.28f);
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

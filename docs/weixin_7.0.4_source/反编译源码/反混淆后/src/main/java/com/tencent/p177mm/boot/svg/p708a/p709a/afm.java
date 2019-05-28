package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.afm */
public final class afm extends C5163c {
    private final int height = JsApiGetBackgroundAudioState.CTRL_INDEX;
    private final int width = JsApiGetBackgroundAudioState.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiGetBackgroundAudioState.CTRL_INDEX;
            case 1:
                return JsApiGetBackgroundAudioState.CTRL_INDEX;
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 23, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(69.69f, 0.0f);
                l.lineTo(89.35f, 0.0f);
                l.cubicTo(106.27f, 2.71f, 122.64f, 9.98f, 134.93f, 22.1f);
                l.cubicTo(148.15f, 34.62f, 156.22f, 51.83f, 159.0f, 69.7f);
                l.lineTo(159.0f, 89.29f);
                l.cubicTo(156.38f, 106.0f, 149.23f, 122.14f, 137.43f, 134.4f);
                l.cubicTo(124.86f, 147.9f, 107.45f, 156.17f, 89.34f, 159.0f);
                l.lineTo(69.67f, 159.0f);
                l.cubicTo(54.38f, 156.5f, 39.5f, 150.47f, 27.73f, 140.23f);
                l.cubicTo(12.48f, 127.48f, 2.96f, 108.82f, 0.0f, 89.29f);
                l.lineTo(0.0f, 69.66f);
                l.cubicTo(2.74f, 52.26f, 10.43f, 35.46f, 23.1f, 23.05f);
                l.cubicTo(35.51f, 10.39f, 52.3f, 2.75f, 69.69f, 0.0f);
                l.lineTo(69.69f, 0.0f);
                l.close();
                l.moveTo(72.39f, 1.64f);
                l.cubicTo(50.03f, 3.41f, 29.01f, 15.72f, 16.0f, 33.9f);
                l.cubicTo(5.98f, 47.41f, 1.2f, 64.29f, 1.1f, 80.99f);
                l.cubicTo(1.79f, 91.02f, 3.49f, 101.11f, 7.59f, 110.36f);
                l.cubicTo(16.56f, 131.17f, 34.91f, 147.82f, 56.67f, 154.32f);
                l.cubicTo(67.11f, 157.23f, 78.17f, 158.89f, 88.95f, 157.08f);
                l.cubicTo(109.53f, 154.89f, 128.7f, 143.65f, 141.32f, 127.36f);
                l.cubicTo(157.73f, 106.72f, 162.16f, 77.57f, 153.09f, 52.87f);
                l.cubicTo(144.96f, 30.37f, 125.99f, 12.03f, 103.11f, 4.91f);
                l.cubicTo(93.2f, 2.07f, 82.69f, 0.28f, 72.39f, 1.64f);
                l.lineTo(72.39f, 1.64f);
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

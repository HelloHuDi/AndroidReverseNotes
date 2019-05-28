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

/* renamed from: com.tencent.mm.boot.svg.a.a.akp */
public final class akp extends C5163c {
    private final int height = 84;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-6710887);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.949f, 5.8425765f);
                l.cubicTo(21.649f, 1.6792915f, 29.638f, -0.2605797f, 37.503f, 0.0289533f);
                l.cubicTo(45.468f, 0.29652175f, 53.408f, 2.8893397f, 59.778f, 7.714557f);
                l.cubicTo(62.781f, 9.984896f, 65.423f, 12.749436f, 67.47f, 15.911337f);
                l.cubicTo(69.411f, 18.899517f, 70.805f, 22.249115f, 71.491f, 25.74747f);
                l.cubicTo(72.316f, 29.922737f, 72.131f, 34.29269f, 70.953f, 38.38309f);
                l.cubicTo(69.294f, 44.209694f, 65.656f, 49.37037f, 61.004f, 53.215168f);
                l.cubicTo(55.825f, 57.515232f, 49.43f, 60.2638f, 42.799f, 61.347054f);
                l.cubicTo(33.676f, 62.845634f, 24.002f, 61.304123f, 15.968f, 56.670597f);
                l.cubicTo(10.646f, 58.412785f, 5.323f, 60.15697f, 0.0f, 61.90016f);
                l.cubicTo(2.104f, 57.420387f, 4.21f, 52.942608f, 6.312f, 48.461834f);
                l.cubicTo(3.922f, 45.468662f, 2.079f, 42.02522f, 1.034f, 38.337166f);
                l.cubicTo(-0.644f, 32.51755f, -0.26f, 26.141836f, 2.082f, 20.557842f);
                l.cubicTo(4.618f, 14.419743f, 9.327f, 9.31897f, 14.949f, 5.8425765f);
                l.lineTo(14.949f, 5.8425765f);
                l.close();
                l.moveTo(27.728f, 4.9040904f);
                l.cubicTo(21.562f, 6.2858615f, 15.702f, 9.30599f, 11.271f, 13.841675f);
                l.cubicTo(8.666f, 16.505379f, 6.584f, 19.700226f, 5.338f, 23.216555f);
                l.cubicTo(3.605f, 28.044767f, 3.557f, 33.451046f, 5.208f, 38.308212f);
                l.cubicTo(6.376f, 41.79459f, 8.372f, 44.976456f, 10.882f, 47.656136f);
                l.cubicTo(9.586f, 50.4067f, 8.294f, 53.15826f, 7.001f, 55.909824f);
                l.cubicTo(10.312f, 54.807602f, 13.624f, 53.706375f, 16.935f, 52.603157f);
                l.cubicTo(19.917f, 54.464153f, 23.193f, 55.84393f, 26.596f, 56.72351f);
                l.cubicTo(34.704f, 58.804153f, 43.538f, 58.153206f, 51.176f, 54.687794f);
                l.cubicTo(56.381f, 52.325603f, 61.04f, 48.6086f, 64.146f, 43.783382f);
                l.cubicTo(66.169f, 40.65343f, 67.492f, 37.060226f, 67.873f, 33.349213f);
                l.cubicTo(68.256f, 29.74802f, 67.764f, 26.061964f, 66.465f, 22.681417f);
                l.cubicTo(65.237f, 19.464605f, 63.308f, 16.532335f, 60.929f, 14.048342f);
                l.cubicTo(58.65f, 11.667182f, 55.965f, 9.685378f, 53.056f, 8.138873f);
                l.cubicTo(45.369f, 4.055459f, 36.197f, 3.0131402f, 27.728f, 4.9040904f);
                l.lineTo(27.728f, 4.9040904f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

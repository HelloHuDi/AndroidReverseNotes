package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ys */
public final class C45265ys extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 33.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(49.36591f, 13.591381f);
                l.cubicTo(61.974216f, 5.669526f, 76.43786f, -0.0890914f, 91.50997f, 0.0010434911f);
                l.cubicTo(106.56214f, -0.07907641f, 121.00583f, 5.6595116f, 133.60416f, 13.571351f);
                l.cubicTo(153.29466f, 26.32043f, 169.7134f, 43.736492f, 183.0f, 63.00533f);
                l.cubicTo(172.90538f, 77.80748f, 160.7958f, 91.267624f, 147.01047f, 102.70474f);
                l.cubicTo(134.60165f, 112.81988f, 120.39736f, 121.36266f, 104.59708f, 124.65759f);
                l.cubicTo(91.1808f, 127.50185f, 76.96653f, 125.729195f, 64.42805f, 120.26101f);
                l.cubicTo(49.924507f, 114.28207f, 37.306225f, 104.55751f, 25.984684f, 93.801414f);
                l.cubicTo(16.33893f, 84.4374f, 7.551019f, 74.142f, 0.0f, 63.00533f);
                l.cubicTo(13.276628f, 43.74651f, 29.68538f, 26.34046f, 49.36591f, 13.591381f);
                l.lineTo(49.36591f, 13.591381f);
                l.close();
                l.moveTo(57.922127f, 11.815232f);
                l.cubicTo(35.62434f, 23.804834f, 17.612675f, 42.54858f, 3.0f, 63.000843f);
                l.cubicTo(14.612391f, 79.44658f, 28.55723f, 94.373634f, 44.894318f, 106.1734f);
                l.cubicTo(58.61987f, 115.88498f, 74.817406f, 123.32853f, 91.931984f, 122.98882f);
                l.cubicTo(109.365524f, 122.76901f, 125.62287f, 114.696014f, 139.39825f, 104.52483f);
                l.cubicTo(154.7286f, 92.954865f, 167.9458f, 78.697235f, 179.0f, 63.000843f);
                l.cubicTo(173.14896f, 54.608124f, 166.5902f, 46.724957f, 159.5131f, 39.341362f);
                l.cubicTo(144.49176f, 23.974688f, 126.72929f, 9.996809f, 105.53792f, 4.731375f);
                l.cubicTo(89.469955f, 0.65491056f, 72.34541f, 4.0819387f, 57.922127f, 11.815232f);
                l.lineTo(57.922127f, 11.815232f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(80.9461f, 13.323944f);
                l.cubicTo(92.338326f, 10.649595f, 104.673225f, 12.046642f, 115.12279f, 17.335466f);
                l.cubicTo(127.67831f, 23.572289f, 137.33563f, 35.23764f, 141.08624f, 48.689217f);
                l.cubicTo(144.47583f, 60.56412f, 143.34262f, 73.666435f, 137.84708f, 84.75301f);
                l.cubicTo(132.1309f, 96.48821f, 121.661285f, 105.838455f, 109.276245f, 110.149345f);
                l.cubicTo(96.80096f, 114.57999f, 82.56067f, 113.82159f, 70.65699f, 108.04379f);
                l.cubicTo(59.074226f, 102.53544f, 49.787952f, 92.426796f, 45.285217f, 80.462074f);
                l.cubicTo(40.240944f, 67.339806f, 41.033188f, 52.111984f, 47.4714f, 39.598423f);
                l.cubicTo(54.05001f, 26.526047f, 66.61556f, 16.607006f, 80.9461f, 13.323944f);
                l.lineTo(80.9461f, 13.323944f);
                l.close();
                l.moveTo(84.99124f, 15.594493f);
                l.cubicTo(74.17387f, 17.275282f, 64.04633f, 22.894487f, 56.858078f, 31.109468f);
                l.cubicTo(48.590088f, 40.398563f, 44.27114f, 53.0194f, 45.100937f, 65.40154f);
                l.cubicTo(45.83076f, 79.146225f, 52.999016f, 92.36379f, 64.106316f, 100.568825f);
                l.cubicTo(74.063896f, 108.08762f, 87.110725f, 111.35969f, 99.477715f, 109.47999f);
                l.cubicTo(111.90469f, 107.709694f, 123.43189f, 100.70806f, 130.7901f, 90.60344f);
                l.cubicTo(138.1983f, 80.628105f, 141.34753f, 67.69895f, 139.468f, 55.456047f);
                l.cubicTo(137.52847f, 41.77104f, 129.1605f, 29.180042f, 117.29339f, 21.989449f);
                l.cubicTo(107.7657f, 16.091768f, 96.06855f, 13.804303f, 84.99124f, 15.594493f);
                l.lineTo(84.99124f, 15.594493f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(66.0f, 38.39189f);
                l.cubicTo(71.673454f, 32.4223f, 79.1317f, 28.155405f, 87.26797f, 27.0f);
                l.cubicTo(88.19527f, 32.39189f, 89.102615f, 37.79392f, 90.0f, 43.18581f);
                l.cubicTo(86.05151f, 44.949326f, 82.5617f, 47.635136f, 79.79975f, 51.0f);
                l.cubicTo(75.203156f, 46.79392f, 70.596596f, 42.597973f, 66.0f, 38.39189f);
                l.lineTo(66.0f, 38.39189f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(57.91275f, 51.0f);
                l.cubicTo(63.61177f, 53.416126f, 69.31079f, 55.832253f, 75.0f, 58.26877f);
                l.cubicTo(74.6763f, 59.512512f, 74.35261f, 60.756256f, 74.02891f, 62.0f);
                l.cubicTo(68.01601f, 61.592216f, 62.003098f, 61.18443f, 56.0f, 60.78684f);
                l.cubicTo(56.31389f, 57.46339f, 56.94166f, 54.18072f, 57.91275f, 51.0f);
                l.lineTo(57.91275f, 51.0f);
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

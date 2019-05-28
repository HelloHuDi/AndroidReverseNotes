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

/* renamed from: com.tencent.mm.boot.svg.a.a.qx */
public final class C37586qx extends C5163c {
    private final int height = 140;
    private final int width = 140;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 140;
            case 1:
                return 140;
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
                k2.setColor(-1118482);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(140.0f, 0.0f);
                l.lineTo(140.0f, 140.0f);
                l.lineTo(0.0f, 140.0f);
                l.lineTo(0.0f, 0.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(57.01697f, 36.70791f);
                l.cubicTo(52.47772f, 42.007774f, 52.327744f, 49.61193f, 53.287586f, 56.18417f);
                l.cubicTo(54.177437f, 62.365677f, 58.826675f, 66.90413f, 61.326267f, 72.38433f);
                l.cubicTo(62.965996f, 75.5903f, 60.956326f, 79.227066f, 58.146786f, 80.93024f);
                l.cubicTo(50.34807f, 85.88947f, 41.699486f, 89.496185f, 34.320694f, 95.106636f);
                l.cubicTo(29.991405f, 98.26251f, 30.801273f, 104.32379f, 31.761116f, 108.90232f);
                l.cubicTo(56.97698f, 109.04258f, 82.21284f, 109.01252f, 107.4287f, 108.93237f);
                l.cubicTo(111.00812f, 109.022545f, 109.668335f, 104.48409f, 109.95829f, 102.1798f);
                l.cubicTo(110.32823f, 98.77346f, 108.188576f, 95.89811f, 105.47903f, 94.13483f);
                l.cubicTo(98.66014f, 89.41604f, 91.11138f, 85.89949f, 84.00255f, 81.6616f);
                l.cubicTo(81.18301f, 79.998505f, 78.07352f, 76.83261f, 79.4333f, 73.25595f);
                l.cubicTo(81.55295f, 67.455154f, 86.57213f, 63.016888f, 87.64195f, 56.75523f);
                l.cubicTo(88.63179f, 50.182995f, 88.71178f, 42.598877f, 84.292496f, 37.168766f);
                l.cubicTo(77.66359f, 29.10375f, 63.935837f, 28.943453f, 57.01697f, 36.70791f);
                l.lineTo(57.01697f, 36.70791f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-4934220);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 30.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(27.016973f, 6.7079077f);
                l.cubicTo(33.935837f, -1.056548f, 47.663586f, -0.8962496f, 54.2925f, 7.1687655f);
                l.cubicTo(58.711773f, 12.598875f, 58.631786f, 20.182995f, 57.64195f, 26.755232f);
                l.cubicTo(56.572124f, 33.016888f, 51.552948f, 37.45515f, 49.433296f, 43.25595f);
                l.cubicTo(48.073517f, 46.83261f, 51.18301f, 49.998505f, 54.002544f, 51.661602f);
                l.cubicTo(61.11138f, 55.89949f, 68.66014f, 59.41604f, 75.47903f, 64.13483f);
                l.cubicTo(78.188576f, 65.89811f, 80.328224f, 68.77346f, 79.95829f, 72.1798f);
                l.cubicTo(79.668335f, 74.48409f, 81.00812f, 79.022545f, 77.4287f, 78.93237f);
                l.cubicTo(52.21284f, 79.01252f, 26.976978f, 79.04258f, 1.7611154f, 78.90232f);
                l.cubicTo(0.8012729f, 74.32379f, -0.008594216f, 68.26251f, 4.3206954f, 65.106636f);
                l.cubicTo(11.699485f, 59.49619f, 20.348066f, 55.889473f, 28.146788f, 50.93024f);
                l.cubicTo(30.956327f, 49.22707f, 32.965996f, 45.590298f, 31.326265f, 42.38433f);
                l.cubicTo(28.826675f, 36.904125f, 24.177439f, 32.365677f, 23.287584f, 26.184168f);
                l.cubicTo(22.327742f, 19.611933f, 22.477716f, 12.007775f, 27.016973f, 6.7079077f);
                l.lineTo(27.016973f, 6.7079077f);
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

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

/* renamed from: com.tencent.mm.boot.svg.a.a.aoi */
public final class aoi extends C5163c {
    private final int height = 42;
    private final int width = 42;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                k2.setColor(-6710887);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(19.74f, 0.0f);
                l.lineTo(22.04f, 0.0f);
                l.cubicTo(32.38f, 0.39f, 41.32f, 9.17f, 42.0f, 19.47f);
                l.lineTo(42.0f, 22.2f);
                l.cubicTo(41.54f, 32.57f, 32.61f, 41.47f, 22.26f, 42.0f);
                l.lineTo(19.95f, 42.0f);
                l.cubicTo(9.62f, 41.6f, 0.68f, 32.83f, 0.0f, 22.53f);
                l.lineTo(0.0f, 19.8f);
                l.cubicTo(0.47f, 9.43f, 9.4f, 0.53f, 19.74f, 0.0f);
                l.lineTo(19.74f, 0.0f);
                l.close();
                l.moveTo(20.87298f, 6.5409007f);
                l.cubicTo(18.624437f, 7.68438f, 18.225163f, 11.434167f, 20.64182f, 12.587948f);
                l.cubicTo(23.153044f, 14.081682f, 26.683468f, 11.238437f, 25.884918f, 8.477604f);
                l.cubicTo(25.58021f, 6.2627573f, 22.638191f, 5.3150086f, 20.87298f, 6.5409007f);
                l.lineTo(20.87298f, 6.5409007f);
                l.close();
                l.moveTo(19.27931f, 14.632621f);
                l.cubicTo(15.97931f, 16.242502f, 13.227586f, 19.38227f, 13.0f, 23.052f);
                l.cubicTo(14.52069f, 20.922155f, 16.051723f, 18.732317f, 18.327587f, 17.262426f);
                l.cubicTo(17.903448f, 22.822016f, 15.637931f, 28.161621f, 15.875862f, 33.761208f);
                l.cubicTo(15.875862f, 35.551075f, 17.955172f, 36.421013f, 19.51724f, 35.80106f);
                l.cubicTo(23.8f, 34.391163f, 27.048275f, 30.541447f, 28.0f, 26.30176f);
                l.cubicTo(26.272413f, 28.121624f, 24.451725f, 29.891495f, 23.044828f, 31.97134f);
                l.cubicTo(22.082758f, 26.471746f, 25.268965f, 21.192137f, 24.524137f, 15.702541f);
                l.cubicTo(23.8f, 13.502704f, 20.975863f, 13.772684f, 19.27931f, 14.632621f);
                l.lineTo(19.27931f, 14.632621f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(8.87298f, 1.5409008f);
                l.cubicTo(10.638191f, 0.3150088f, 13.58021f, 1.2627572f, 13.884919f, 3.4776042f);
                l.cubicTo(14.683467f, 6.2384367f, 11.153045f, 9.081682f, 8.641821f, 7.587948f);
                l.cubicTo(6.225163f, 6.4341674f, 6.624437f, 2.6843798f, 8.87298f, 1.5409008f);
                l.lineTo(8.87298f, 1.5409008f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(7.27931f, 9.632621f);
                l.cubicTo(8.9758625f, 8.772684f, 11.8f, 8.502704f, 12.5241375f, 10.702541f);
                l.cubicTo(13.268966f, 16.192137f, 10.082759f, 21.471746f, 11.044827f, 26.97134f);
                l.cubicTo(12.451724f, 24.891495f, 14.272414f, 23.121624f, 16.0f, 21.30176f);
                l.cubicTo(15.048276f, 25.541447f, 11.8f, 29.391163f, 7.5172415f, 30.801058f);
                l.cubicTo(5.9551725f, 31.421013f, 3.8758621f, 30.551077f, 3.8758621f, 28.76121f);
                l.cubicTo(3.637931f, 23.161621f, 5.903448f, 17.822016f, 6.327586f, 12.262426f);
                l.cubicTo(4.051724f, 13.732318f, 2.5206897f, 15.922156f, 1.0f, 18.052f);
                l.cubicTo(1.2275863f, 14.38227f, 3.9793103f, 11.242501f, 7.27931f, 9.632621f);
                l.lineTo(7.27931f, 9.632621f);
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

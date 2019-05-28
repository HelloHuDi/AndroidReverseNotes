package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class vu extends c {
    private final int height = 70;
    private final int width = 80;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 70;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-983041);
                Path l = c.l(looper);
                l.moveTo(39.999f, 66.129f);
                l.cubicTo(35.436f, 66.129f, 31.029f, 65.48f, 26.945f, 64.315f);
                l.cubicTo(26.573f, 64.203f, 26.178f, 64.142f, 25.769f, 64.142f);
                l.cubicTo(25.001f, 64.142f, 24.304f, 64.373f, 23.645f, 64.751f);
                l.lineTo(14.89f, 69.766f);
                l.cubicTo(14.646f, 69.905f, 14.409f, 70.012f, 14.12f, 70.012f);
                l.cubicTo(13.384f, 70.012f, 12.787f, 69.42f, 12.787f, 68.69f);
                l.cubicTo(12.787f, 68.362f, 12.918f, 68.036f, 13.002f, 67.722f);
                l.cubicTo(13.052f, 67.536f, 14.13f, 63.545f, 14.804f, 61.054f);
                l.cubicTo(14.88f, 60.774f, 14.944f, 60.503f, 14.944f, 60.211f);
                l.cubicTo(14.944f, 59.322f, 14.502f, 58.536f, 13.824f, 58.056f);
                l.cubicTo(5.393f, 51.995f, 0.006f, 43.027f, 0.006f, 33.065f);
                l.cubicTo(0.006f, 30.372f, 0.398f, 27.756f, 1.133f, 25.25f);
                l.cubicTo(7.438f, 18.998f, 16.145f, 15.132f, 25.763f, 15.132f);
                l.cubicTo(37.198f, 15.132f, 47.347f, 20.597f, 53.699f, 29.038f);
                l.lineTo(60.783f, 22.011f);
                l.cubicTo(52.578f, 11.811f, 39.94f, 5.274f, 25.763f, 5.274f);
                l.cubicTo(22.662f, 5.274f, 19.635f, 5.586f, 16.712f, 6.182f);
                l.cubicTo(23.271f, 2.291f, 31.311f, -0.0f, 39.999f, -0.0f);
                l.cubicTo(62.086f, -0.0f, 79.992f, 14.804f, 79.992f, 33.065f);
                l.cubicTo(79.992f, 51.325f, 62.086f, 66.129f, 39.999f, 66.129f);
                l.close();
                l.moveTo(25.763f, 54.693f);
                l.cubicTo(28.542f, 54.693f, 30.795f, 52.458f, 30.795f, 49.7f);
                l.cubicTo(30.795f, 46.943f, 28.542f, 44.708f, 25.763f, 44.708f);
                l.cubicTo(22.984f, 44.708f, 20.73f, 46.943f, 20.73f, 49.7f);
                l.cubicTo(20.73f, 52.458f, 22.984f, 54.693f, 25.763f, 54.693f);
                l.close();
                l.moveTo(25.763f, 24.991f);
                l.cubicTo(17.069f, 24.991f, 9.416f, 29.41f, 4.961f, 36.108f);
                l.lineTo(12.238f, 43.327f);
                l.cubicTo(14.642f, 38.314f, 19.795f, 34.849f, 25.763f, 34.849f);
                l.cubicTo(31.733f, 34.849f, 36.888f, 38.317f, 39.29f, 43.334f);
                l.lineTo(46.569f, 36.113f);
                l.cubicTo(42.114f, 29.412f, 34.459f, 24.991f, 25.763f, 24.991f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

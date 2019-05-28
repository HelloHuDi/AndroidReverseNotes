package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import org.xwalk.core.XWalkEnvironment;

public final class cu extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-855310);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(90.0f, 0.0f);
                l.lineTo(90.0f, 90.0f);
                l.lineTo(0.0f, 90.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 23.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(21.213203f, 0.54296666f);
                l2.cubicTo(26.642136f, 6.0343003f, 30.0f, 13.620507f, 30.0f, 22.0f);
                l2.cubicTo(30.0f, 30.379494f, 26.642136f, 37.9657f, 21.213203f, 43.457035f);
                l2.lineTo(18.031223f, 40.23848f);
                l2.cubicTo(22.645815f, 35.570847f, 25.5f, 29.122568f, 25.5f, 22.0f);
                l2.cubicTo(25.5f, 14.877431f, 22.645815f, 8.429155f, 18.031223f, 3.7615216f);
                l2.lineTo(21.213203f, 0.54296666f);
                l2.close();
                l2.moveTo(13.788582f, 8.052928f);
                l2.cubicTo(17.317389f, 11.622295f, 19.5f, 16.55333f, 19.5f, 22.0f);
                l2.cubicTo(19.5f, 27.44667f, 17.317389f, 32.377705f, 13.788582f, 35.94707f);
                l2.lineTo(10.606602f, 32.728516f);
                l2.cubicTo(13.321068f, 29.98285f, 15.0f, 26.189747f, 15.0f, 22.0f);
                l2.cubicTo(15.0f, 17.810253f, 13.321068f, 14.01715f, 10.606602f, 11.271483f);
                l2.lineTo(13.788582f, 8.052928f);
                l2.close();
                l2.moveTo(6.363961f, 15.56289f);
                l2.cubicTo(7.9926405f, 17.21029f, 9.0f, 19.486153f, 9.0f, 22.0f);
                l2.cubicTo(9.0f, 24.513847f, 7.9926405f, 26.78971f, 6.363961f, 28.43711f);
                l2.lineTo(0.0f, 22.0f);
                l2.lineTo(6.363961f, 15.56289f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

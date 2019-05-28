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
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.boot.svg.a.a.apv */
public final class apv extends C5163c {
    private final int height = 210;
    private final int width = 210;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                a.setColor(-15724528);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(86.26f, 1.24f);
                l.cubicTo(108.45f, -1.53f, 131.55f, 3.55f, 150.45f, 15.53f);
                l.cubicTo(169.74f, 27.58f, 184.6f, 46.55f, 191.61f, 68.2f);
                l.cubicTo(198.68f, 89.68f, 198.0f, 113.61f, 189.69f, 134.65f);
                l.cubicTo(181.53f, 155.58f, 165.93f, 173.48f, 146.33f, 184.43f);
                l.cubicTo(126.15f, 195.89f, 101.83f, 199.69f, 79.1f, 195.13f);
                l.cubicTo(56.88f, 190.83f, 36.38f, 178.43f, 22.13f, 160.87f);
                l.cubicTo(8.8f, 144.64f, 0.92f, 124.01f, 0.11f, 103.02f);
                l.cubicTo(-1.0f, 79.99f, 6.41f, 56.69f, 20.62f, 38.53f);
                l.cubicTo(36.39f, 18.04f, 60.56f, 4.25f, 86.26f, 1.24f);
                l.lineTo(86.26f, 1.24f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

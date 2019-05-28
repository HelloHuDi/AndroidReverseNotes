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

/* renamed from: com.tencent.mm.boot.svg.a.a.cm */
public final class C18002cm extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-855310);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(90.0f, 0.0f);
                l.lineTo(90.0f, 90.0f);
                l.lineTo(0.0f, 90.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(13.125807f, 35.88405f);
                l2.cubicTo(5.7260823f, 34.961723f, 9.368011E-16f, 28.64956f, 0.0f, 21.0f);
                l2.lineTo(0.0f, 17.25f);
                l2.lineTo(3.75f, 17.25f);
                l2.lineTo(3.75f, 21.0f);
                l2.cubicTo(3.75f, 27.213203f, 8.786797f, 32.25f, 15.0f, 32.25f);
                l2.cubicTo(21.213203f, 32.25f, 26.25f, 27.213203f, 26.25f, 21.0f);
                l2.lineTo(26.25f, 17.25f);
                l2.lineTo(30.0f, 17.25f);
                l2.lineTo(30.0f, 21.0f);
                l2.cubicTo(30.0f, 28.649282f, 24.274334f, 34.961266f, 16.875f, 35.88395f);
                l2.lineTo(16.875f, 42.0f);
                l2.lineTo(13.12812f, 42.0f);
                l2.lineTo(13.125807f, 35.88405f);
                l2.close();
                l2.moveTo(15.0f, 0.0f);
                l2.cubicTo(19.142136f, -7.6089796E-16f, 22.5f, 3.3578644f, 22.5f, 7.5f);
                l2.lineTo(22.5f, 21.0f);
                l2.cubicTo(22.5f, 25.142136f, 19.142136f, 28.5f, 15.0f, 28.5f);
                l2.cubicTo(10.857864f, 28.5f, 7.5f, 25.142136f, 7.5f, 21.0f);
                l2.lineTo(7.5f, 7.5f);
                l2.cubicTo(7.5f, 3.3578644f, 10.857864f, 7.6089796E-16f, 15.0f, 0.0f);
                l2.close();
                l2.moveTo(15.0f, 3.75f);
                l2.cubicTo(12.928932f, 3.75f, 11.25f, 5.428932f, 11.25f, 7.5f);
                l2.lineTo(11.25f, 21.0f);
                l2.cubicTo(11.25f, 23.071068f, 12.928932f, 24.75f, 15.0f, 24.75f);
                l2.cubicTo(17.071068f, 24.75f, 18.75f, 23.071068f, 18.75f, 21.0f);
                l2.lineTo(18.75f, 7.5f);
                l2.cubicTo(18.75f, 5.428932f, 17.071068f, 3.75f, 15.0f, 3.75f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

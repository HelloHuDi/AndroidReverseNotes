package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
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

/* renamed from: com.tencent.mm.boot.svg.a.a.rf */
public final class C6372rf extends C5163c {
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
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-12206054);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(160.65068f, 95.27501f);
                l2.lineTo(168.36555f, 95.27501f);
                l2.cubicTo(169.47209f, 95.27501f, 169.83318f, 94.5596f, 169.1713f, 93.67711f);
                l2.lineTo(156.29543f, 76.50927f);
                l2.cubicTo(155.6316f, 75.62418f, 154.56044f, 75.62678f, 153.89857f, 76.50927f);
                l2.lineTo(141.02269f, 93.67711f);
                l2.cubicTo(140.35887f, 94.562195f, 140.72157f, 95.27501f, 141.82845f, 95.27501f);
                l2.lineTo(148.96237f, 95.27501f);
                l2.cubicTo(148.96115f, 125.298164f, 124.889656f, 149.63637f, 95.19614f, 149.63637f);
                l2.cubicTo(80.87363f, 149.63637f, 67.46696f, 143.96439f, 57.466305f, 134.00328f);
                l2.cubicTo(55.223022f, 136.42978f, 53.46749f, 138.00111f, 49.263695f, 142.4225f);
                l2.cubicTo(61.079872f, 154.19194f, 77.29919f, 161.45454f, 95.19614f, 161.45454f);
                l2.cubicTo(131.34492f, 161.45454f, 160.64946f, 131.82516f, 160.65068f, 95.27501f);
                l2.lineTo(160.65068f, 95.27501f);
                l2.close();
                l2.moveTo(23.204512f, 98.32745f);
                l2.cubicTo(22.542639f, 97.44496f, 22.903711f, 96.72955f, 24.010258f, 96.72955f);
                l2.lineTo(50.547367f, 96.72955f);
                l2.cubicTo(51.654243f, 96.72955f, 52.01693f, 97.44237f, 51.353115f, 98.32745f);
                l2.lineTo(38.477238f, 115.49529f);
                l2.cubicTo(37.815365f, 116.377785f, 36.744205f, 116.38038f, 36.080387f, 115.49529f);
                l2.lineTo(23.204512f, 98.32745f);
                l2.close();
                l2.moveTo(42.250706f, 96.72727f);
                l2.cubicTo(42.250706f, 66.703064f, 66.32267f, 42.363636f, 96.01694f, 42.363636f);
                l2.cubicTo(110.339455f, 42.363636f, 123.74612f, 48.03562f, 133.74677f, 57.99671f);
                l2.cubicTo(135.99005f, 55.570225f, 137.74557f, 53.99889f, 141.94939f, 49.577503f);
                l2.cubicTo(130.13321f, 37.808067f, 113.91389f, 30.545454f, 96.01694f, 30.545454f);
                l2.cubicTo(59.867393f, 30.545454f, 30.562395f, 60.176064f, 30.562395f, 96.72727f);
                l2.lineTo(36.40655f, 96.72727f);
                l2.lineTo(42.250706f, 96.72727f);
                l2.close();
                l2.moveTo(81.12372f, 81.44297f);
                l2.cubicTo(81.12372f, 89.48731f, 83.766464f, 91.53608f, 86.863625f, 96.30573f);
                l2.cubicTo(90.96707f, 102.62398f, 84.63524f, 105.367065f, 81.57996f, 107.10888f);
                l2.cubicTo(70.61376f, 113.363335f, 65.64245f, 115.78745f, 65.64245f, 119.04088f);
                l2.lineTo(65.64245f, 123.10881f);
                l2.cubicTo(65.64245f, 124.62227f, 66.67696f, 125.820465f, 68.29885f, 125.820465f);
                l2.lineTo(124.07696f, 125.820465f);
                l2.cubicTo(125.698845f, 125.820465f, 126.73336f, 124.62227f, 126.73336f, 123.10881f);
                l2.lineTo(126.73336f, 119.04088f);
                l2.cubicTo(126.73336f, 115.78745f, 121.76205f, 113.363335f, 110.795845f, 107.10888f);
                l2.cubicTo(107.74057f, 105.367065f, 101.40874f, 102.62398f, 105.512184f, 96.30573f);
                l2.cubicTo(108.609344f, 91.53608f, 111.25209f, 89.48731f, 111.25209f, 81.44297f);
                l2.cubicTo(111.25209f, 73.09445f, 105.34826f, 64.72955f, 96.187904f, 64.72955f);
                l2.cubicTo(87.02754f, 64.72955f, 81.12372f, 73.09445f, 81.12372f, 81.44297f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

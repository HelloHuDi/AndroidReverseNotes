package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.agl */
public final class agl extends C5163c {
    private final int height = 150;
    private final int width = 150;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 150;
            case 1:
                return 150;
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
                k2.setColor(-921103);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(150.0f, 0.0f);
                l.lineTo(150.0f, 150.0f);
                l.lineTo(0.0f, 150.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                k = C5163c.m7876a(k, looper);
                k.setColor(-3552823);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(88.629036f, 47.177418f);
                l2.cubicTo(85.16202f, 47.177418f, 81.93403f, 48.098953f, 79.19355f, 49.66629f);
                l2.cubicTo(74.166534f, 52.543064f, 70.80645f, 57.627743f, 70.80645f, 63.427418f);
                l2.lineTo(70.80645f, 87.54032f);
                l2.cubicTo(70.80645f, 91.882744f, 66.58145f, 95.40323f, 61.370968f, 95.40323f);
                l2.cubicTo(56.159435f, 95.40323f, 51.935482f, 91.882744f, 51.935482f, 87.54032f);
                l2.cubicTo(51.935482f, 84.44968f, 54.080482f, 81.78363f, 57.193146f, 80.49831f);
                l2.cubicTo(57.4175f, 80.40605f, 57.645f, 80.317986f, 57.87879f, 80.2404f);
                l2.cubicTo(59.838226f, 79.45411f, 61.51879f, 77.97798f, 62.142582f, 76.26387f);
                l2.cubicTo(63.064114f, 73.73306f, 61.348953f, 71.68242f, 58.312824f, 71.68242f);
                l2.cubicTo(57.555885f, 71.68242f, 56.788467f, 71.810326f, 56.048306f, 72.04097f);
                l2.cubicTo(56.045162f, 72.042015f, 56.042015f, 72.04307f, 56.037823f, 72.04411f);
                l2.cubicTo(51.648228f, 73.304276f, 47.98411f, 76.067825f, 45.784595f, 79.67742f);
                l2.cubicTo(44.364033f, 82.01008f, 43.548386f, 84.68871f, 43.548386f, 87.54032f);
                l2.cubicTo(43.548386f, 96.500885f, 51.54339f, 103.79032f, 61.370968f, 103.79032f);
                l2.cubicTo(64.83798f, 103.79032f, 68.06597f, 102.86879f, 70.80645f, 101.30145f);
                l2.cubicTo(75.833466f, 98.424675f, 79.19355f, 93.34f, 79.19355f, 87.54032f);
                l2.lineTo(79.19355f, 63.427418f);
                l2.cubicTo(79.19355f, 59.085f, 83.4175f, 55.564518f, 88.629036f, 55.564518f);
                l2.cubicTo(93.839516f, 55.564518f, 98.064514f, 59.085f, 98.064514f, 63.427418f);
                l2.cubicTo(98.064514f, 66.65016f, 95.738144f, 69.42f, 92.40742f, 70.63403f);
                l2.cubicTo(90.25928f, 71.35427f, 88.49903f, 72.909035f, 87.828064f, 74.751045f);
                l2.cubicTo(86.91177f, 77.26927f, 88.618546f, 79.31153f, 91.641045f, 79.31153f);
                l2.cubicTo(92.325645f, 79.31153f, 93.01758f, 79.194115f, 93.691696f, 79.0033f);
                l2.cubicTo(93.80177f, 78.9729f, 93.910805f, 78.939354f, 94.01984f, 78.90685f);
                l2.cubicTo(98.383224f, 77.63936f, 102.02532f, 74.88419f, 104.214355f, 71.29032f);
                l2.cubicTo(105.63597f, 68.95871f, 106.451614f, 66.27903f, 106.451614f, 63.427418f);
                l2.cubicTo(106.451614f, 54.466854f, 98.45661f, 47.177418f, 88.629036f, 47.177418f);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

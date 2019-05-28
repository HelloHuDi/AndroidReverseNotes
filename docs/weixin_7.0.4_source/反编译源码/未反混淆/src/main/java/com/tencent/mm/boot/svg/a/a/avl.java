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

public final class avl extends c {
    private final int height = 42;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                k2 = c.a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                Paint a2 = c.a(k2, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(0.5f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a, looper);
                a = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(29.854729f, 0.0f);
                l.cubicTo(27.832062f, 0.0f, 25.850395f, 0.525641f, 24.12419f, 1.5180513f);
                l.cubicTo(20.998728f, 3.3157437f, 19.132702f, 6.3665643f, 19.132702f, 9.679153f);
                l.lineTo(19.132702f, 26.694155f);
                l.cubicTo(19.132702f, 30.740538f, 15.359652f, 34.032104f, 10.722446f, 34.032104f);
                l.cubicTo(6.08419f, 34.032104f, 2.3111384f, 30.740538f, 2.3111384f, 26.694155f);
                l.cubicTo(2.3111384f, 23.83782f, 4.3054204f, 21.619616f, 7.114446f, 19.943872f);
                l.cubicTo(7.6916f, 19.600103f, 9.215959f, 18.792717f, 9.414651f, 18.448948f);
                l.cubicTo(9.431472f, 18.419514f, 9.434626f, 18.381666f, 9.447241f, 18.349077f);
                l.cubicTo(9.5302925f, 18.199795f, 9.591267f, 18.037897f, 9.591267f, 17.854975f);
                l.cubicTo(9.591267f, 17.287283f, 9.130805f, 16.82682f, 8.563113f, 16.82682f);
                l.cubicTo(8.337088f, 16.82682f, 8.118421f, 16.893051f, 7.9249845f, 16.992924f);
                l.cubicTo(7.801985f, 17.021307f, 7.6916f, 17.061256f, 7.607497f, 17.102257f);
                l.cubicTo(5.511241f, 18.135666f, 2.6443949f, 19.871334f, 1.310318f, 22.071667f);
                l.cubicTo(0.4524718f, 23.487743f, 4.2051284E-4f, 25.086744f, 4.2051284E-4f, 26.694155f);
                l.cubicTo(4.2051284E-4f, 32.03046f, 4.8089848f, 36.372257f, 10.722446f, 36.372257f);
                l.cubicTo(12.7430105f, 36.372257f, 14.724677f, 35.847668f, 16.452984f, 34.856308f);
                l.cubicTo(19.578445f, 33.057564f, 21.44342f, 30.005692f, 21.44342f, 26.694155f);
                l.lineTo(21.44342f, 9.679153f);
                l.cubicTo(21.44342f, 5.632769f, 25.217524f, 2.3422563f, 29.854729f, 2.3422563f);
                l.cubicTo(34.492985f, 2.3422563f, 38.267086f, 5.632769f, 38.267086f, 9.679153f);
                l.cubicTo(38.267086f, 12.642718f, 36.247574f, 15.298257f, 33.077957f, 16.458872f);
                l.cubicTo(32.311573f, 16.717487f, 31.451626f, 16.904615f, 30.964882f, 17.325129f);
                l.cubicTo(30.664215f, 17.524872f, 30.452908f, 17.850769f, 30.452908f, 18.239744f);
                l.cubicTo(30.452908f, 18.856846f, 31.021652f, 19.286821f, 31.638754f, 19.286821f);
                l.cubicTo(31.79855f, 19.286821f, 31.943626f, 19.256332f, 32.072933f, 19.20377f);
                l.cubicTo(32.330498f, 19.16382f, 32.62801f, 19.03346f, 32.927624f, 18.948307f);
                l.lineTo(33.138935f, 18.88418f);
                l.cubicTo(35.761883f, 18.119898f, 37.936985f, 16.49146f, 39.265804f, 14.299539f);
                l.cubicTo(40.124702f, 12.886616f, 40.576756f, 11.288667f, 40.576756f, 9.679153f);
                l.cubicTo(40.576756f, 4.341795f, 35.76714f, 0.0f, 29.854729f, 0.0f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

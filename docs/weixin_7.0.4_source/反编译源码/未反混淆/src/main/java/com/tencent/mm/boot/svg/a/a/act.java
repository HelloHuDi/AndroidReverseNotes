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

public final class act extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = c.l(looper);
                l.moveTo(59.3675f, 24.311686f);
                l.lineTo(28.040222f, 43.05198f);
                l.lineTo(27.820826f, 43.18168f);
                l.cubicTo(27.549904f, 43.319855f, 27.24491f, 43.401234f, 26.921633f, 43.401234f);
                l.cubicTo(26.171196f, 43.401234f, 25.518824f, 42.979923f, 25.176432f, 42.357704f);
                l.lineTo(25.045958f, 42.06609f);
                l.lineTo(19.583479f, 29.840412f);
                l.cubicTo(19.524475f, 29.707321f, 19.487907f, 29.556429f, 19.487907f, 29.409775f);
                l.cubicTo(19.487907f, 28.846895f, 19.935843f, 28.390827f, 20.48766f, 28.390827f);
                l.cubicTo(20.713703f, 28.390827f, 20.918972f, 28.466274f, 21.086845f, 28.59343f);
                l.lineTo(27.531622f, 33.27364f);
                l.cubicTo(28.001163f, 33.58729f, 28.565445f, 33.772095f, 29.170448f, 33.772095f);
                l.cubicTo(29.530293f, 33.772095f, 29.875177f, 33.704277f, 30.19513f, 33.584747f);
                l.lineTo(57.22311f, 21.483917f);
                l.cubicTo(52.433365f, 16.118635f, 44.747562f, 12.6f, 36.0f, 12.6f);
                l.cubicTo(21.301022f, 12.6f, 9.6f, 22.535152f, 9.6f, 34.472527f);
                l.cubicTo(9.6f, 40.746346f, 12.826998f, 46.636932f, 18.443596f, 50.791683f);
                l.lineTo(20.152246f, 52.05562f);
                l.lineTo(19.368248f, 57.928364f);
                l.lineTo(26.002657f, 54.750523f);
                l.lineTo(27.320723f, 55.1318f);
                l.cubicTo(30.084929f, 55.931404f, 33.006275f, 56.34505f, 36.0f, 56.34505f);
                l.cubicTo(50.69898f, 56.34505f, 62.4f, 46.4099f, 62.4f, 34.472527f);
                l.cubicTo(62.4f, 30.822855f, 61.30626f, 27.360338f, 59.3675f, 24.311686f);
                l.close();
                l.moveTo(36.0f, 59.945053f);
                l.cubicTo(32.61305f, 59.945053f, 29.357191f, 59.468487f, 26.320362f, 58.59002f);
                l.lineTo(17.421125f, 62.8527f);
                l.cubicTo(17.157927f, 62.97877f, 16.863625f, 63.025394f, 16.574291f, 62.98685f);
                l.cubicTo(15.753134f, 62.877464f, 15.176225f, 62.123825f, 15.285729f, 61.303555f);
                l.lineTo(16.302671f, 53.68589f);
                l.cubicTo(9.989763f, 49.01606f, 6.0f, 42.139908f, 6.0f, 34.472527f);
                l.cubicTo(6.0f, 20.404438f, 19.431458f, 9.0f, 36.0f, 9.0f);
                l.cubicTo(52.568542f, 9.0f, 66.0f, 20.404438f, 66.0f, 34.472527f);
                l.cubicTo(66.0f, 48.540615f, 52.568542f, 59.945053f, 36.0f, 59.945053f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

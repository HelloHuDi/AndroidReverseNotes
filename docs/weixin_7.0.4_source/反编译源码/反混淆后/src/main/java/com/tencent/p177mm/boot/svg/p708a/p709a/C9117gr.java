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

/* renamed from: com.tencent.mm.boot.svg.a.a.gr */
public final class C9117gr extends C5163c {
    private final int height = 108;
    private final int width = 108;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                k2.setColor(-13917627);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.lineTo(108.0f, 108.0f);
                l.lineTo(0.0f, 108.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(54.752f, 27.584f);
                l2.cubicTo(46.472f, 27.584f, 39.704f, 30.248f, 34.376f, 35.648f);
                l2.cubicTo(29.264f, 40.688f, 26.744f, 46.952f, 26.744f, 54.512f);
                l2.cubicTo(26.744f, 62.576f, 29.264f, 68.984f, 34.376f, 73.88f);
                l2.cubicTo(39.344f, 78.632f, 46.112f, 81.008f, 54.752f, 81.008f);
                l2.cubicTo(60.44f, 81.008f, 65.552f, 79.856f, 70.16f, 77.624f);
                l2.cubicTo(74.912f, 75.32f, 78.512f, 72.008f, 81.032f, 67.688f);
                l2.lineTo(75.992f, 67.688f);
                l2.cubicTo(73.976f, 70.568f, 71.312f, 72.8f, 68.0f, 74.456f);
                l2.cubicTo(64.256f, 76.256f, 59.792f, 77.192f, 54.752f, 77.192f);
                l2.cubicTo(47.696f, 77.192f, 42.152f, 75.248f, 38.12f, 71.504f);
                l2.cubicTo(33.8f, 67.544f, 31.712f, 61.928f, 31.712f, 54.656f);
                l2.cubicTo(31.712f, 48.032f, 33.8f, 42.488f, 38.048f, 38.168f);
                l2.cubicTo(42.368f, 33.776f, 47.84f, 31.616f, 54.464f, 31.616f);
                l2.cubicTo(60.656f, 31.616f, 65.696f, 33.416f, 69.44f, 37.088f);
                l2.cubicTo(72.896f, 40.472f, 74.624f, 44.72f, 74.624f, 49.832f);
                l2.cubicTo(74.624f, 54.296f, 73.328f, 58.184f, 70.736f, 61.496f);
                l2.cubicTo(68.504f, 64.304f, 66.272f, 65.744f, 64.04f, 65.744f);
                l2.cubicTo(62.672f, 65.744f, 62.024f, 65.096f, 62.024f, 63.944f);
                l2.cubicTo(62.024f, 63.08f, 62.312f, 61.64f, 62.888f, 59.552f);
                l2.lineTo(68.0f, 40.76f);
                l2.lineTo(63.32f, 40.76f);
                l2.lineTo(62.24f, 44.792f);
                l2.cubicTo(61.088f, 41.192f, 58.784f, 39.392f, 55.328f, 39.392f);
                l2.cubicTo(51.008f, 39.392f, 47.336f, 41.264f, 44.168f, 45.152f);
                l2.cubicTo(40.856f, 49.04f, 39.272f, 53.72f, 39.272f, 59.048f);
                l2.cubicTo(39.272f, 62.144f, 40.208f, 64.736f, 42.08f, 66.752f);
                l2.cubicTo(43.952f, 68.768f, 46.4f, 69.848f, 49.424f, 69.848f);
                l2.cubicTo(53.024f, 69.848f, 56.048f, 68.192f, 58.496f, 64.952f);
                l2.cubicTo(58.784f, 68.12f, 60.44f, 69.704f, 63.464f, 69.704f);
                l2.cubicTo(67.208f, 69.704f, 70.664f, 67.688f, 73.832f, 63.728f);
                l2.cubicTo(77.0f, 59.552f, 78.656f, 54.944f, 78.656f, 49.76f);
                l2.cubicTo(78.656f, 43.568f, 76.64f, 38.456f, 72.608f, 34.352f);
                l2.cubicTo(68.216f, 29.816f, 62.24f, 27.584f, 54.752f, 27.584f);
                l2.close();
                l2.moveTo(56.12f, 43.928f);
                l2.cubicTo(57.56f, 43.928f, 58.712f, 44.504f, 59.648f, 45.656f);
                l2.cubicTo(60.44f, 46.592f, 60.872f, 47.744f, 60.872f, 49.04f);
                l2.cubicTo(60.872f, 49.472f, 60.584f, 50.624f, 60.152f, 52.496f);
                l2.lineTo(58.568f, 58.4f);
                l2.cubicTo(57.992f, 60.272f, 56.84f, 62.0f, 55.112f, 63.44f);
                l2.cubicTo(53.384f, 64.88f, 51.584f, 65.6f, 49.784f, 65.6f);
                l2.cubicTo(47.984f, 65.6f, 46.616f, 65.024f, 45.68f, 63.872f);
                l2.cubicTo(44.744f, 62.72f, 44.312f, 61.208f, 44.312f, 59.264f);
                l2.cubicTo(44.312f, 55.016f, 45.536f, 51.416f, 47.984f, 48.392f);
                l2.cubicTo(50.288f, 45.368f, 53.024f, 43.928f, 56.12f, 43.928f);
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

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

public final class adl extends c {
    private final int height = 108;
    private final int width = 108;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                k2 = c.a(k, looper);
                k2.setColor(-15028967);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.lineTo(108.0f, 108.0f);
                l.lineTo(0.0f, 108.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(55.078445f, 25.00014f);
                l2.cubicTo(39.16226f, 25.00014f, 26.207817f, 37.891388f, 26.207817f, 53.74081f);
                l2.cubicTo(26.207817f, 58.80523f, 27.541147f, 63.757267f, 30.065735f, 68.10752f);
                l2.cubicTo(30.065735f, 68.10752f, 27.28029f, 76.87909f, 26.0f, 81.53247f);
                l2.cubicTo(26.0f, 81.997284f, 26.0f, 83.03247f, 28.0f, 82.50686f);
                l2.cubicTo(29.5f, 82.03247f, 41.27883f, 79.004906f, 41.27883f, 79.004906f);
                l2.cubicTo(45.511826f, 81.29943f, 50.25455f, 82.50332f, 55.074802f, 82.50686f);
                l2.cubicTo(71.001915f, 82.50686f, 83.967285f, 69.61561f, 83.967285f, 53.766186f);
                l2.cubicTo(83.986824f, 46.13662f, 80.941284f, 38.81573f, 75.508286f, 33.43238f);
                l2.cubicTo(70.10815f, 28.012098f, 62.748436f, 24.97629f, 55.078445f, 25.00014f);
                l2.close();
                l2.moveTo(42.859886f, 74.32476f);
                l2.lineTo(41.981926f, 73.80273f);
                l2.lineTo(32.89633f, 76.16999f);
                l2.lineTo(35.322556f, 67.3571f);
                l2.lineTo(34.75425f, 66.4508f);
                l2.cubicTo(32.341713f, 62.647125f, 31.066797f, 58.238754f, 31.078484f, 53.74081f);
                l2.cubicTo(31.094553f, 40.54703f, 41.841843f, 29.857033f, 55.100304f, 29.847046f);
                l2.cubicTo(61.508305f, 29.847046f, 67.54472f, 32.34119f, 72.07295f, 36.84733f);
                l2.cubicTo(76.586525f, 41.32263f, 79.11532f, 47.407555f, 79.09662f, 53.748062f);
                l2.cubicTo(79.08569f, 66.93295f, 68.31704f, 77.6527f, 55.08573f, 77.6527f);
                l2.cubicTo(50.78394f, 77.657074f, 46.56114f, 76.506355f, 42.859886f, 74.32476f);
                l2.close();
                l2.moveTo(63.318867f, 57.424023f);
                l2.cubicTo(62.65949f, 57.18476f, 62.178616f, 57.061504f, 61.690456f, 57.786545f);
                l2.cubicTo(61.213226f, 58.500713f, 59.82525f, 60.12118f, 59.402664f, 60.60696f);
                l2.cubicTo(58.980076f, 61.081863f, 58.561134f, 61.15074f, 57.843468f, 60.78822f);
                l2.cubicTo(57.1258f, 60.425697f, 54.79065f, 59.66803f, 52.036556f, 57.221012f);
                l2.cubicTo(49.89448f, 55.317776f, 48.440933f, 52.96139f, 48.018345f, 52.247223f);
                l2.cubicTo(47.59576f, 51.53306f, 47.97099f, 51.13791f, 48.33893f, 50.786263f);
                l2.cubicTo(48.67044f, 50.467243f, 49.056595f, 49.94884f, 49.420895f, 49.528316f);
                l2.cubicTo(49.78519f, 49.10779f, 49.898125f, 48.814148f, 50.13856f, 48.32837f);
                l2.cubicTo(50.378998f, 47.85347f, 50.262424f, 47.432945f, 50.080273f, 47.070423f);
                l2.cubicTo(49.898125f, 46.7079f, 48.451862f, 43.17332f, 47.8617f, 41.73411f);
                l2.cubicTo(47.282463f, 40.32753f, 46.67773f, 40.523293f, 46.233284f, 40.497917f);
                l2.cubicTo(45.8107f, 40.476166f, 45.33347f, 40.476166f, 44.85624f, 40.476166f);
                l2.cubicTo(44.37901f, 40.476166f, 43.592125f, 40.657425f, 42.932743f, 41.37159f);
                l2.cubicTo(42.273365f, 42.08576f, 40.404514f, 43.829483f, 40.404514f, 47.364063f);
                l2.cubicTo(40.404514f, 50.898643f, 42.98739f, 54.309967f, 43.35169f, 54.795746f);
                l2.cubicTo(43.715984f, 55.27065f, 48.440933f, 62.531948f, 55.679535f, 65.63875f);
                l2.cubicTo(57.399025f, 66.37467f, 58.743282f, 66.81695f, 59.78882f, 67.157715f);
                l2.cubicTo(61.519234f, 67.7015f, 63.08936f, 67.62174f, 64.33162f, 67.44048f);
                l2.cubicTo(65.71959f, 67.23747f, 68.60119f, 65.707634f, 69.205925f, 64.02916f);
                l2.cubicTo(69.81066f, 62.350685f, 69.81066f, 60.915104f, 69.62851f, 60.617836f);
                l2.cubicTo(69.45729f, 60.298817f, 68.980064f, 60.12118f, 68.251465f, 59.755035f);
                l2.cubicTo(67.53015f, 59.396137f, 63.97825f, 57.66329f, 63.318867f, 57.424023f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

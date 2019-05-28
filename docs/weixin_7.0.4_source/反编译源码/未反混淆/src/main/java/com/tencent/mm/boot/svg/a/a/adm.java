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

public final class adm extends c {
    private final int height = 45;
    private final int width = 45;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                a.setColor(-16139513);
                Path l = c.l(looper);
                l.moveTo(0.0f, 1.9916575f);
                l.cubicTo(0.0f, 0.89169544f, 0.89889205f, 0.0f, 1.9916575f, 0.0f);
                l.lineTo(43.008343f, 0.0f);
                l.cubicTo(44.108303f, 0.0f, 45.0f, 0.89889205f, 45.0f, 1.9916575f);
                l.lineTo(45.0f, 43.008343f);
                l.cubicTo(45.0f, 44.108303f, 44.10111f, 45.0f, 43.008343f, 45.0f);
                l.lineTo(1.9916575f, 45.0f);
                l.cubicTo(0.89169544f, 45.0f, 0.0f, 44.10111f, 0.0f, 43.008343f);
                l.lineTo(0.0f, 1.9916575f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(31.0f, 29.0f);
                l.lineTo(27.0f, 29.0f);
                l.lineTo(27.0f, 27.0f);
                l.lineTo(31.0f, 27.0f);
                l.lineTo(31.0f, 23.0f);
                l.lineTo(33.0f, 23.0f);
                l.lineTo(33.0f, 27.0f);
                l.lineTo(37.0f, 27.0f);
                l.lineTo(37.0f, 29.0f);
                l.lineTo(33.0f, 29.0f);
                l.lineTo(33.0f, 33.0f);
                l.lineTo(31.0f, 33.0f);
                l.lineTo(31.0f, 29.0f);
                l.close();
                l.moveTo(25.730555f, 35.0f);
                l.lineTo(6.130553f, 35.0f);
                l.cubicTo(5.440284f, 35.0f, 5.0f, 34.490055f, 5.0f, 33.845936f);
                l.lineTo(5.0f, 32.11464f);
                l.cubicTo(5.0f, 30.729998f, 7.1157656f, 29.698303f, 11.782929f, 27.036438f);
                l.cubicTo(13.08324f, 26.29513f, 15.77804f, 25.127686f, 14.031632f, 22.438671f);
                l.cubicTo(12.713493f, 20.408728f, 11.588755f, 19.536785f, 11.588755f, 16.113152f);
                l.cubicTo(11.588755f, 12.560062f, 14.101395f, 9.0f, 18.0f, 9.0f);
                l.cubicTo(21.898605f, 9.0f, 24.411245f, 12.560062f, 24.411245f, 16.113152f);
                l.cubicTo(24.411245f, 19.536785f, 23.286507f, 20.408728f, 21.968369f, 22.438671f);
                l.cubicTo(20.814322f, 24.215603f, 21.599625f, 25.328108f, 22.640343f, 26.092281f);
                l.cubicTo(22.548069f, 26.631046f, 22.5f, 27.184908f, 22.5f, 27.75f);
                l.cubicTo(22.5f, 29.225077f, 22.827538f, 30.623629f, 23.413855f, 31.876896f);
                l.cubicTo(23.971626f, 33.069145f, 24.763592f, 34.129913f, 25.730555f, 35.0f);
                l.close();
                l.moveTo(24.0f, 28.125736f);
                l.cubicTo(24.0f, 28.536228f, 24.030445f, 28.939606f, 24.089201f, 29.333736f);
                l.cubicTo(24.672707f, 33.24789f, 28.048365f, 36.25f, 32.125f, 36.25f);
                l.cubicTo(36.612865f, 36.25f, 40.25f, 32.612865f, 40.25f, 28.125736f);
                l.cubicTo(40.25f, 23.637873f, 36.612865f, 20.0f, 32.125f, 20.0f);
                l.cubicTo(27.637873f, 20.0f, 24.0f, 23.637873f, 24.0f, 28.125736f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

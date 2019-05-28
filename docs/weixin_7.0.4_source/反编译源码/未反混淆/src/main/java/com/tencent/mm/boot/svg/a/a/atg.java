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
import com.tencent.view.d;

public final class atg extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] a = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = c.a(k, looper);
                a2.setColor(-2236963);
                canvas.saveLayerAlpha(null, 222, 4);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(13.408646f, 1.6899189f);
                l.cubicTo(22.319056f, -1.1299042f, 32.56653f, 5.027872f, 34.52223f, 14.085183f);
                l.cubicTo(36.098763f, 19.346195f, 33.48451f, 24.517532f, 30.890213f, 28.951529f);
                l.cubicTo(27.13846f, 35.01963f, 22.788025f, 40.71906f, 17.988577f, 46.0f);
                l.cubicTo(11.84209f, 39.005245f, 5.845274f, 31.601963f, 2.093522f, 23.012962f);
                l.cubicTo(-1.6183176f, 14.404033f, 4.607994f, 3.9318275f, 13.408646f, 1.6899189f);
                l.lineTo(13.408646f, 1.6899189f);
                l.close();
                l.moveTo(3.2691474f, 20.083824f);
                l.cubicTo(6.0192595f, 28.886927f, 12.3555975f, 35.91335f, 18.006926f, 43.0f);
                l.cubicTo(23.275455f, 36.49554f, 28.846195f, 29.981043f, 32.07984f, 22.171675f);
                l.cubicTo(35.4243f, 14.271968f, 29.178625f, 4.7963343f, 20.978659f, 3.3810122f);
                l.cubicTo(11.398599f, 0.9719528f, 1.2040452f, 10.397397f, 3.2691474f, 20.083824f);
                l.lineTo(3.2691474f, 20.083824f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1907998);
                g = c.a(a, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, d.MIC_PTU_SHIGUANG, 4);
                canvas.save();
                Paint a4 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(7.2950993f, 0.192574f);
                l.cubicTo(12.620774f, -1.0085815f, 18.16545f, 3.5875754f, 17.996222f, 9.017592f);
                l.cubicTo(18.175404f, 14.745417f, 11.923957f, 19.470623f, 6.448964f, 17.574585f);
                l.cubicTo(1.8499701f, 16.333721f, -1.0965714f, 11.032754f, 0.38665384f, 6.4961586f);
                l.cubicTo(1.2726072f, 3.309622f, 4.0598764f, 0.8378228f, 7.2950993f, 0.192574f);
                l.lineTo(7.2950993f, 0.192574f);
                l.close();
                l.moveTo(6.4085283f, 2.5550814f);
                l.cubicTo(1.6162406f, 4.3491087f, 0.31749043f, 11.2947f, 4.586251f, 14.351562f);
                l.cubicTo(8.462366f, 18.069908f, 15.227949f, 15.013046f, 15.912561f, 10.001798f);
                l.cubicTo(16.778395f, 5.100796f, 11.039731f, 0.35013187f, 6.4085283f, 2.5550814f);
                l.lineTo(6.4085283f, 2.5550814f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

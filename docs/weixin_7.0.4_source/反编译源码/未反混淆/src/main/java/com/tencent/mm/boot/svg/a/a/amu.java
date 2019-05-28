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

public final class amu extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(23.0f, 7.1054274E-15f);
                l.cubicTo(25.038055f, -0.45212156f, 27.033388f, 0.8979728f, 27.0f, 3.0f);
                l.cubicTo(27.103931f, 7.225281f, 26.91246f, 11.799481f, 27.0f, 16.0f);
                l.cubicTo(21.813272f, 17.743927f, 17.741985f, 21.824436f, 16.0f, 27.0f);
                l.cubicTo(11.786217f, 26.912477f, 7.211057f, 27.103909f, 3.0f, 27.0f);
                l.cubicTo(0.28785312f, 27.073683f, -0.9718273f, 23.718597f, 1.0f, 22.0f);
                l.cubicTo(7.190902f, 15.769161f, 13.7412405f, 9.502306f, 20.0f, 3.0f);
                l.cubicTo(21.11793f, 1.9861085f, 22.105518f, 0.84759617f, 23.0f, 7.1054274E-15f);
                l.lineTo(23.0f, 7.1054274E-15f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(33.0f, 3.0f);
                l.cubicTo(32.901676f, 0.26721036f, 36.287827f, -0.9631879f, 38.0f, 1.0f);
                l.cubicTo(44.89429f, 7.9521565f, 51.999157f, 15.062245f, 59.0f, 22.0f);
                l.cubicTo(60.98858f, 23.654861f, 59.73893f, 27.093925f, 57.0f, 27.0f);
                l.cubicTo(52.77515f, 27.104012f, 48.199818f, 26.912392f, 44.0f, 27.0f);
                l.cubicTo(42.2539f, 21.81935f, 38.182457f, 17.724747f, 33.0f, 16.0f);
                l.cubicTo(33.083076f, 11.784545f, 32.901676f, 7.2159348f, 33.0f, 3.0f);
                l.lineTo(33.0f, 3.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(1.0f, 38.0f);
                l.cubicTo(-0.68084866f, 36.524372f, -0.106408045f, 33.78191f, 2.0f, 33.0f);
                l.cubicTo(6.655866f, 32.803898f, 11.513416f, 33.146706f, 16.0f, 33.0f);
                l.cubicTo(17.741562f, 38.187996f, 21.813036f, 42.281525f, 27.0f, 44.0f);
                l.cubicTo(26.912455f, 48.23025f, 27.103935f, 52.79766f, 27.0f, 57.0f);
                l.cubicTo(27.08378f, 59.724396f, 23.747993f, 60.94439f, 22.0f, 59.0f);
                l.cubicTo(15.121306f, 52.061634f, 7.98615f, 44.963493f, 1.0f, 38.0f);
                l.lineTo(1.0f, 38.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(44.0f, 33.0f);
                l.cubicTo(48.478714f, 33.14441f, 53.31408f, 32.801533f, 58.0f, 33.0f);
                l.cubicTo(60.083588f, 33.71923f, 60.68801f, 36.482403f, 59.0f, 38.0f);
                l.cubicTo(52.03472f, 44.93327f, 44.902557f, 52.042892f, 38.0f, 59.0f);
                l.cubicTo(36.47089f, 60.655113f, 33.73085f, 60.100464f, 33.0f, 58.0f);
                l.cubicTo(32.804073f, 53.3438f, 33.146576f, 48.493122f, 33.0f, 44.0f);
                l.cubicTo(38.19349f, 42.270943f, 42.273327f, 38.196777f, 44.0f, 33.0f);
                l.lineTo(44.0f, 33.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

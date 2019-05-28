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

/* renamed from: com.tencent.mm.boot.svg.a.a.ald */
public final class ald extends C5163c {
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, -56.0f, 0.0f, 1.0f, -265.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 56.0f, 0.0f, 1.0f, 265.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.0f, 45.0f);
                l.cubicTo(3.0f, 21.804039f, 21.804039f, 3.0f, 45.0f, 3.0f);
                l.lineTo(45.0f, 3.0f);
                l.cubicTo(68.19596f, 3.0f, 87.0f, 21.804039f, 87.0f, 45.0f);
                l.lineTo(87.0f, 45.0f);
                l.cubicTo(87.0f, 68.19596f, 68.19596f, 87.0f, 45.0f, 87.0f);
                l.lineTo(45.0f, 87.0f);
                l.cubicTo(21.804039f, 87.0f, 3.0f, 68.19596f, 3.0f, 45.0f);
                l.lineTo(3.0f, 45.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-16139513);
                l = C5163c.m7884l(looper);
                l.moveTo(49.82215f, 67.367676f);
                l.lineTo(46.05924f, 63.60476f);
                l.cubicTo(50.438366f, 58.779804f, 53.118694f, 52.299812f, 53.118694f, 45.175297f);
                l.cubicTo(53.118694f, 38.068485f, 50.451668f, 31.60299f, 46.091843f, 26.781826f);
                l.lineTo(49.854874f, 23.018793f);
                l.cubicTo(55.13197f, 28.813019f, 58.363636f, 36.605614f, 58.363636f, 45.175297f);
                l.cubicTo(58.363636f, 53.76268f, 55.11861f, 61.56976f, 49.82215f, 67.367676f);
                l.close();
                l.moveTo(41.090847f, 58.63637f);
                l.lineTo(37.32728f, 54.872803f);
                l.cubicTo(39.788017f, 52.418816f, 41.31758f, 48.98096f, 41.31758f, 45.175297f);
                l.cubicTo(41.31758f, 41.38734f, 39.80221f, 37.96377f, 37.36156f, 35.512104f);
                l.lineTo(41.124847f, 31.748817f);
                l.cubicTo(44.482662f, 35.17379f, 46.56252f, 39.92448f, 46.56252f, 45.175297f);
                l.cubicTo(46.56252f, 50.443817f, 44.468616f, 55.20883f, 41.090847f, 58.63637f);
                l.close();
                l.moveTo(32.620003f, 50.165524f);
                l.lineTo(27.664072f, 45.209595f);
                l.lineTo(32.655266f, 40.2184f);
                l.cubicTo(33.950462f, 41.45147f, 34.761406f, 43.215885f, 34.761406f, 45.175297f);
                l.cubicTo(34.761406f, 47.152435f, 33.935726f, 48.931026f, 32.620003f, 50.165524f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

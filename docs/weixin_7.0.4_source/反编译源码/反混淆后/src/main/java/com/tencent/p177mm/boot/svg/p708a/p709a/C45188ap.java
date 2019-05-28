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

/* renamed from: com.tencent.mm.boot.svg.a.a.ap */
public final class C45188ap extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.3958402f, 1.5091976f);
                l.cubicTo(3.783774f, 0.71045625f, 5.511202f, 1.1397798f, 7.0389276f, 1.0f);
                l.cubicTo(20.049559f, 1.0898584f, 33.06019f, 0.9301101f, 46.060833f, 1.0698899f);
                l.cubicTo(48.067844f, 0.95007867f, 49.24609f, 3.1366334f, 48.95652f, 4.913833f);
                l.cubicTo(48.93655f, 15.956433f, 49.046387f, 27.009018f, 48.906597f, 38.061604f);
                l.cubicTo(48.97649f, 40.038486f, 46.8896f, 41.276535f, 45.08229f, 40.947056f);
                l.cubicTo(31.3727f, 40.927086f, 17.66311f, 41.026928f, 3.953521f, 40.90712f);
                l.cubicTo(1.9564942f, 41.026928f, 0.73830783f, 38.890297f, 1.047847f, 37.09313f);
                l.cubicTo(1.0079064f, 26.719473f, 1.0678172f, 16.335835f, 1.0178915f, 5.9521966f);
                l.cubicTo(1.0678172f, 4.4046354f, 0.82817405f, 2.4277503f, 2.3958402f, 1.5091976f);
                l.lineTo(2.3958402f, 1.5091976f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(52.01634f, 14.457662f);
                l.cubicTo(57.03326f, 10.022178f, 61.740986f, 5.203629f, 66.96736f, 1.0f);
                l.cubicTo(68.35375f, 3.0665324f, 67.924866f, 5.6169353f, 67.97474f, 7.955645f);
                l.cubicTo(67.94482f, 17.713709f, 67.97474f, 27.471775f, 67.97474f, 37.22984f);
                l.cubicTo(68.01463f, 38.590725f, 67.675514f, 39.840725f, 66.95739f, 41.0f);
                l.cubicTo(61.731014f, 36.836693f, 57.08313f, 31.997984f, 52.036285f, 27.612904f);
                l.cubicTo(51.97644f, 23.227823f, 52.006363f, 18.842741f, 52.01634f, 14.457662f);
                l.lineTo(52.01634f, 14.457662f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

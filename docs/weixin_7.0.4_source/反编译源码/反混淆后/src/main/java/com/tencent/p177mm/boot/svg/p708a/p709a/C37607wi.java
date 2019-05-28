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

/* renamed from: com.tencent.mm.boot.svg.a.a.wi */
public final class C37607wi extends C5163c {
    private final int height = 36;
    private final int width = 40;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 36;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-11048043);
                Path l = C5163c.m7884l(looper);
                l.moveTo(6.223777f, 2.4243011f);
                l.cubicTo(10.598335f, -0.4037837f, 16.69516f, 1.2488136f, 20.001913f, 5.0172887f);
                l.cubicTo(22.709318f, 1.97485f, 26.97365f, 0.38448447f, 30.996866f, 1.2349844f);
                l.cubicTo(33.95228f, 1.8296428f, 36.28078f, 4.2635937f, 37.23836f, 7.070935f);
                l.cubicTo(38.643734f, 11.081422f, 38.023716f, 15.610507f, 36.039665f, 19.31675f);
                l.cubicTo(32.52624f, 26.065432f, 26.649864f, 31.368956f, 20.001913f, 34.923077f);
                l.cubicTo(12.603054f, 30.926418f, 5.9619923f, 24.76548f, 2.8756897f, 16.785994f);
                l.cubicTo(1.1740899f, 11.966495f, 1.7803279f, 5.5635448f, 6.223777f, 2.4243011f);
                l.lineTo(6.223777f, 2.4243011f);
                l.lineTo(6.223777f, 2.4243011f);
                l.close();
                l.moveTo(6.579045f, 8.803145f);
                l.cubicTo(5.6772685f, 12.076567f, 6.2279716f, 15.709856f, 8.059059f, 18.561125f);
                l.cubicTo(11.005321f, 23.336306f, 15.466016f, 26.921152f, 20.002432f, 30.076923f);
                l.cubicTo(23.50628f, 27.668571f, 26.858686f, 24.983397f, 29.639736f, 21.744577f);
                l.cubicTo(31.945807f, 19.045563f, 33.942104f, 15.744459f, 33.831963f, 12.062725f);
                l.cubicTo(33.983406f, 9.391392f, 32.937073f, 6.0210834f, 29.997694f, 5.391313f);
                l.cubicTo(25.970676f, 4.1871367f, 22.94181f, 7.848109f, 20.002432f, 9.965798f);
                l.cubicTo(17.118126f, 7.9173145f, 14.22005f, 4.3324685f, 10.282523f, 5.3359485f);
                l.cubicTo(8.478971f, 5.619691f, 7.0746775f, 7.0799274f, 6.579045f, 8.803145f);
                l.lineTo(6.579045f, 8.803145f);
                l.lineTo(6.579045f, 8.803145f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

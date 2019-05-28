package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ou */
public final class C6366ou extends C5163c {
    private final int height = 62;
    private final int width = 62;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 62;
            case 1:
                return 62;
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
                k = C5163c.m7876a(k2, looper);
                k.setStrokeWidth(1.0f);
                k = C5163c.m7876a(k, looper);
                k.setColor(-11776948);
                k.setStrokeWidth(3.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(12.5f, 51.5f);
                l.lineTo(12.5f, 50.833168f);
                l.cubicTo(12.604213f, 50.756973f, 12.7130165f, 50.673367f, 12.825878f, 50.581997f);
                l.cubicTo(13.609306f, 49.947758f, 14.377914f, 49.098545f, 15.08248f, 48.008003f);
                l.cubicTo(17.25971f, 44.638042f, 18.415026f, 39.67215f, 18.092539f, 32.831554f);
                l.cubicTo(18.56658f, 22.598658f, 22.709154f, 17.582647f, 28.795002f, 16.286835f);
                l.lineTo(31.072823f, 15.801835f);
                l.lineTo(29.689184f, 13.928539f);
                l.cubicTo(29.419085f, 13.562856f, 29.272728f, 13.127208f, 29.272728f, 12.666667f);
                l.cubicTo(29.272728f, 11.47552f, 30.26446f, 10.5f, 31.5f, 10.5f);
                l.cubicTo(32.735542f, 10.5f, 33.727272f, 11.47552f, 33.727272f, 12.666667f);
                l.cubicTo(33.727272f, 13.127208f, 33.580914f, 13.562856f, 33.310818f, 13.928539f);
                l.lineTo(31.927177f, 15.801835f);
                l.lineTo(34.204998f, 16.286835f);
                l.cubicTo(40.290844f, 17.582647f, 44.43342f, 22.598658f, 44.90746f, 32.831554f);
                l.cubicTo(44.584972f, 39.67215f, 45.740288f, 44.638042f, 47.91752f, 48.008003f);
                l.cubicTo(48.622086f, 49.098545f, 49.390694f, 49.947758f, 50.17412f, 50.581997f);
                l.cubicTo(50.286983f, 50.673367f, 50.395786f, 50.756973f, 50.5f, 50.833168f);
                l.lineTo(50.5f, 51.5f);
                l.lineTo(12.5f, 51.5f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

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

public final class dl extends c {
    private final int height = 42;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -275.0f, 0.0f, 1.0f, -1626.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 126.0f, 0.0f, 1.0f, 1626.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 149.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = c.a(k, looper);
                k2 = c.a(a, looper);
                a2.setColor(-70474);
                k2.setColor(-36352);
                k2.setStrokeWidth(5.4f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(42.0f, 21.25926f);
                l.cubicTo(42.0f, 9.401778f, 32.59822f, 0.0f, 20.74074f, 0.0f);
                l.cubicTo(9.401778f, 0.0f, 0.0f, 9.401778f, 0.0f, 21.25926f);
                l.cubicTo(0.0f, 32.59822f, 9.401778f, 42.0f, 20.74074f, 42.0f);
                l.cubicTo(32.59822f, 42.0f, 42.0f, 32.59822f, 42.0f, 21.25926f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-36352);
                l = c.l(looper);
                l.moveTo(7.1932015f, 22.069902f);
                l.cubicTo(7.0209723f, 21.90468f, 7.0013413f, 21.619408f, 7.147708f, 21.434807f);
                l.lineTo(8.144134f, 20.17808f);
                l.cubicTo(8.291237f, 19.992548f, 8.567782f, 19.95389f, 8.763619f, 20.093018f);
                l.lineTo(15.588285f, 24.941442f);
                l.cubicTo(15.783314f, 25.079996f, 16.094162f, 25.074368f, 16.278591f, 24.931952f);
                l.lineTo(33.272747f, 11.8091545f);
                l.cubicTo(33.45896f, 11.6653595f, 33.751038f, 11.677971f, 33.93421f, 11.845651f);
                l.lineTo(34.814766f, 12.651727f);
                l.cubicTo(34.993866f, 12.815679f, 34.995564f, 13.079486f, 34.821854f, 13.237947f);
                l.lineTo(16.258057f, 30.172258f);
                l.cubicTo(16.08287f, 30.332067f, 15.798551f, 30.325104f, 15.629005f, 30.162458f);
                l.lineTo(7.1932015f, 22.069902f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
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

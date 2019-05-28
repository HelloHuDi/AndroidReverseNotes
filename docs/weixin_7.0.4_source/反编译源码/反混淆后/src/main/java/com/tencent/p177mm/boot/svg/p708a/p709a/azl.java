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

/* renamed from: com.tencent.mm.boot.svg.a.a.azl */
public final class azl extends C5163c {
    private final int height = 80;
    private final int width = 80;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 19.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.6294041f);
                l.lineTo(44.081802f, 0.6294054f);
                l.lineTo(44.081802f, 41.746845f);
                l.lineTo(0.0f, 41.74684f);
                l.lineTo(0.0f, 0.6294041f);
                l.close();
                l.moveTo(5.0f, 5.629404f);
                l.lineTo(39.0f, 5.6294045f);
                l.lineTo(39.0f, 36.629406f);
                l.lineTo(5.0f, 36.629402f);
                l.lineTo(5.0f, 5.629404f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 47.88276f, 0.0f, 1.0f, 1.922839f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(17.238659f, 3.8456779f);
                l2.lineTo(21.276552f, 3.8456774f);
                l2.lineTo(21.276552f, 34.611103f);
                l2.lineTo(17.238659f, 34.611107f);
                l2.lineTo(17.238659f, 3.8456779f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(0.2687733f, 13.459874f);
                l2.lineTo(4.221509f, 13.459874f);
                l2.lineTo(4.221509f, 24.99691f);
                l2.lineTo(0.2687733f, 24.99691f);
                l2.lineTo(0.2687733f, 13.459874f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(0.0f, 13.459874f);
                l2.lineTo(21.388449f, 0.0f);
                l2.lineTo(21.388449f, 5.171436f);
                l2.lineTo(0.0f, 18.63131f);
                l2.lineTo(0.0f, 13.459874f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(21.388449f, 33.285347f);
                l2.lineTo(0.0f, 19.825474f);
                l2.lineTo(0.0f, 24.99691f);
                l2.lineTo(21.388449f, 38.456783f);
                l2.lineTo(21.388449f, 33.285347f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

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

/* renamed from: com.tencent.mm.boot.svg.a.a.md */
public final class C9135md extends C5163c {
    private final int height = 32;
    private final int width = 32;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-15432210);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(4.9f, 7.5f);
                l.lineTo(27.1f, 7.5f);
                l.cubicTo(27.597055f, 7.5f, 28.0f, 7.9029436f, 28.0f, 8.4f);
                l.lineTo(28.0f, 23.6f);
                l.cubicTo(28.0f, 24.097055f, 27.597055f, 24.5f, 27.1f, 24.5f);
                l.lineTo(4.9f, 24.5f);
                l.cubicTo(4.4029436f, 24.5f, 4.0f, 24.097055f, 4.0f, 23.6f);
                l.lineTo(4.0f, 8.4f);
                l.cubicTo(4.0f, 7.9029436f, 4.4029436f, 7.5f, 4.9f, 7.5f);
                l.close();
                l.moveTo(9.909091f, 15.46875f);
                l.cubicTo(11.164284f, 15.46875f, 12.181818f, 14.477714f, 12.181818f, 13.255208f);
                l.cubicTo(12.181818f, 12.032703f, 11.164284f, 11.041667f, 9.909091f, 11.041667f);
                l.cubicTo(8.653898f, 11.041667f, 7.6363635f, 12.032703f, 7.6363635f, 13.255208f);
                l.cubicTo(7.6363635f, 14.477714f, 8.653898f, 15.46875f, 9.909091f, 15.46875f);
                l.close();
                l.moveTo(10.066779f, 20.785433f);
                l.cubicTo(11.265334f, 20.785433f, 13.810014f, 21.035427f, 13.810014f, 19.811766f);
                l.cubicTo(13.810014f, 18.588106f, 12.6521635f, 16.354166f, 10.066779f, 16.354166f);
                l.cubicTo(7.481395f, 16.354166f, 6.7272725f, 18.588106f, 6.7272725f, 19.811766f);
                l.cubicTo(6.7272725f, 21.035427f, 8.868224f, 20.785433f, 10.066779f, 20.785433f);
                l.close();
                l.moveTo(16.26818f, 12.8125f);
                l.cubicTo(16.019653f, 12.8125f, 15.818182f, 13.013972f, 15.818182f, 13.2625f);
                l.lineTo(15.818182f, 14.4875f);
                l.cubicTo(15.818182f, 14.736028f, 16.019653f, 14.9375f, 16.26818f, 14.9375f);
                l.lineTo(23.368181f, 14.9375f);
                l.cubicTo(23.61671f, 14.9375f, 23.818182f, 14.736028f, 23.818182f, 14.4875f);
                l.lineTo(23.818182f, 13.2625f);
                l.cubicTo(23.818182f, 13.013972f, 23.61671f, 12.8125f, 23.368181f, 12.8125f);
                l.lineTo(16.26818f, 12.8125f);
                l.close();
                l.moveTo(16.26818f, 17.239584f);
                l.cubicTo(16.019653f, 17.239584f, 15.818182f, 17.441055f, 15.818182f, 17.689583f);
                l.lineTo(15.818182f, 18.914583f);
                l.cubicTo(15.818182f, 19.16311f, 16.019653f, 19.364584f, 16.26818f, 19.364584f);
                l.lineTo(21.004545f, 19.364584f);
                l.cubicTo(21.253073f, 19.364584f, 21.454546f, 19.16311f, 21.454546f, 18.914583f);
                l.lineTo(21.454546f, 17.689583f);
                l.cubicTo(21.454546f, 17.441055f, 21.253073f, 17.239584f, 21.004545f, 17.239584f);
                l.lineTo(16.26818f, 17.239584f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

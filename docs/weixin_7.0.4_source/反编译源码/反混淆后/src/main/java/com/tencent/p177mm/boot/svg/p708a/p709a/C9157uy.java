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

/* renamed from: com.tencent.mm.boot.svg.a.a.uy */
public final class C9157uy extends C5163c {
    private final int height = 108;
    private final int width = 108;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                a.setColor(-16139513);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(50.66866f, 46.318768f);
                l.cubicTo(49.990063f, 46.092545f, 49.707314f, 46.205654f, 49.085266f, 46.544987f);
                l.cubicTo(47.04947f, 47.676094f, 42.073086f, 50.390747f, 39.132492f, 51.917736f);
                l.cubicTo(38.397343f, 52.313625f, 37.605648f, 52.539845f, 36.700848f, 52.539845f);
                l.cubicTo(35.739502f, 52.539845f, 34.891254f, 52.25707f, 34.156105f, 51.804626f);
                l.cubicTo(30.027967f, 49.37275f, 26.126028f, 46.544987f, 22.789587f, 43.151672f);
                l.cubicTo(19.453146f, 39.81491f, 16.625654f, 35.912598f, 14.194011f, 31.784061f);
                l.cubicTo(13.741612f, 31.048843f, 13.458863f, 30.143959f, 13.458863f, 29.239075f);
                l.cubicTo(13.458863f, 28.390745f, 13.685062f, 27.542416f, 14.080911f, 26.807198f);
                l.cubicTo(15.607757f, 23.809769f, 18.32215f, 18.832905f, 19.453146f, 16.85347f);
                l.cubicTo(19.792446f, 16.231363f, 19.905544f, 15.892031f, 19.679346f, 15.269923f);
                l.lineTo(14.872609f, 2.488432f);
                l.cubicTo(14.250561f, 1.0179949f, 12.836815f, 0.05655527f, 11.140319f, 0.0f);
                l.cubicTo(10.461721f, 0.0f, 9.670023f, 0.28277636f, 9.500374f, 0.33933163f);
                l.cubicTo(3.9584892f, 2.3753214f, 0.0f, 7.6349616f, 0.0f, 13.856041f);
                l.cubicTo(0.0f, 15.609255f, 0.45239875f, 17.249357f, 0.5089486f, 17.645245f);
                l.cubicTo(3.223341f, 29.52185f, 9.274175f, 40.097687f, 17.587002f, 48.411312f);
                l.cubicTo(25.899828f, 56.724937f, 36.474648f, 62.77635f, 48.350117f, 65.491005f);
                l.cubicTo(48.745964f, 65.60411f, 50.38591f, 66.0f, 52.138958f, 66.0f);
                l.cubicTo(58.35944f, 66.0f, 63.618576f, 62.04113f, 65.654366f, 56.498714f);
                l.cubicTo(65.71092f, 56.32905f, 66.05022f, 55.537273f, 65.99367f, 54.858612f);
                l.cubicTo(65.88057f, 53.161953f, 64.91922f, 51.748074f, 63.448925f, 51.125965f);
                l.lineTo(50.66866f, 46.318768f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(a2, 1.0f, 0.0f, 29.333332f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(17.37411f, 19.235815f);
                l.cubicTo(20.60845f, 22.413412f, 21.573078f, 26.952837f, 20.041021f, 30.414148f);
                l.cubicTo(24.693933f, 31.378777f, 29.46033f, 30.243921f, 32.694668f, 26.896093f);
                l.cubicTo(38.14198f, 21.335299f, 37.404324f, 11.745763f, 31.049128f, 5.4473104f);
                l.cubicTo(24.63719f, -0.8511422f, 15.047654f, -1.4185704f, 9.600344f, 4.1422253f);
                l.cubicTo(6.3660035f, 7.4333086f, 5.3446326f, 12.08622f, 6.2525177f, 16.625645f);
                l.cubicTo(9.71383f, 15.207074f, 14.13977f, 16.058216f, 17.37411f, 19.235815f);
                l.lineTo(17.37411f, 19.235815f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(18.395481f, 32.85409f);
                l.cubicTo(19.133137f, 32.116432f, 19.643822f, 31.322035f, 20.041021f, 30.414148f);
                l.cubicTo(16.920168f, 29.789978f, 13.799313f, 28.144436f, 11.245886f, 25.647753f);
                l.cubicTo(8.635716f, 23.037582f, 6.9334316f, 19.916729f, 6.2525177f, 16.682388f);
                l.cubicTo(5.28789f, 17.079588f, 4.4367476f, 17.647015f, 3.6990912f, 18.384672f);
                l.cubicTo(0.23777941f, 21.902727f, 0.6917219f, 28.03095f, 4.7772045f, 32.00295f);
                l.cubicTo(8.805944f, 36.03169f, 14.934169f, 36.372143f, 18.395481f, 32.85409f);
                l.lineTo(18.395481f, 32.85409f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}

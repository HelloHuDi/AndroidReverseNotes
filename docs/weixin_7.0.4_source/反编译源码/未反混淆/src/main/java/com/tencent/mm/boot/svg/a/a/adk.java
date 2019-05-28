package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adk extends c {
    private final int height = 108;
    private final int width = 108;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k2 = c.a(k, looper);
                k2.setColor(-13063453);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.lineTo(108.0f, 108.0f);
                l.lineTo(0.0f, 108.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(86.9129f, 31.579287f);
                l2.cubicTo(87.37079f, 30.729229f, 87.75414f, 29.83387f, 88.049644f, 28.901205f);
                l2.cubicTo(88.32917f, 28.01917f, 88.04166f, 27.059858f, 87.31755f, 26.481606f);
                l2.cubicTo(86.59876f, 25.906017f, 85.59247f, 25.8394f, 84.80181f, 26.30573f);
                l2.cubicTo(82.666756f, 27.57682f, 80.37198f, 28.51215f, 77.95474f, 29.109056f);
                l2.cubicTo(75.05032f, 26.481606f, 71.23811f, 25.0f, 67.29812f, 25.0f);
                l2.cubicTo(58.542282f, 25.0f, 51.421013f, 32.128227f, 51.421013f, 40.88462f);
                l2.cubicTo(51.421013f, 41.105793f, 51.426334f, 41.32164f, 51.434322f, 41.542816f);
                l2.cubicTo(42.13807f, 40.38098f, 33.55527f, 35.651035f, 27.578726f, 28.30963f);
                l2.cubicTo(27.120836f, 27.7447f, 26.4127f, 27.448912f, 25.680609f, 27.496878f);
                l2.cubicTo(24.953838f, 27.555502f, 24.298948f, 27.963211f, 23.934233f, 28.600088f);
                l2.cubicTo(22.528614f, 31.014359f, 21.783209f, 33.775047f, 21.783209f, 36.58903f);
                l2.cubicTo(21.783209f, 39.253788f, 22.443424f, 41.817284f, 23.66003f, 44.092987f);
                l2.cubicTo(23.35122f, 44.14362f, 23.047733f, 44.25554f, 22.77087f, 44.418087f);
                l2.cubicTo(22.09202f, 44.82313f, 21.67406f, 45.633217f, 21.67406f, 46.421986f);
                l2.cubicTo(21.67406f, 51.146603f, 23.774504f, 55.48749f, 27.160769f, 58.43471f);
                l2.cubicTo(27.110188f, 58.480015f, 27.06493f, 58.530643f, 27.014349f, 58.581276f);
                l2.cubicTo(26.495228f, 59.17285f, 26.32485f, 59.988266f, 26.564444f, 60.737064f);
                l2.cubicTo(28.023306f, 65.29114f, 31.40691f, 68.84059f, 35.65039f, 70.58334f);
                l2.cubicTo(31.319057f, 72.72847f, 26.290241f, 73.56521f, 21.482386f, 72.99495f);
                l2.cubicTo(20.468103f, 72.90435f, 19.480442f, 73.47727f, 19.129038f, 74.46056f);
                l2.cubicTo(18.782957f, 75.43587f, 19.150335f, 76.520424f, 20.023523f, 77.08269f);
                l2.cubicTo(26.64697f, 81.33031f, 34.29535f, 83.574036f, 42.148716f, 83.574036f);
                l2.cubicTo(67.854515f, 83.574036f, 83.22049f, 62.671677f, 83.22049f, 42.46482f);
                l2.cubicTo(83.22049f, 42.235653f, 83.22049f, 42.01181f, 83.215164f, 41.782642f);
                l2.cubicTo(85.69896f, 39.8427f, 87.85264f, 37.52436f, 89.62564f, 34.870262f);
                l2.cubicTo(90.17404f, 34.049515f, 90.11548f, 32.95963f, 89.47922f, 32.200176f);
                l2.cubicTo(88.85095f, 31.454042f, 87.81537f, 31.19556f, 86.91822f, 31.576622f);
                l2.lineTo(86.9129f, 31.579287f);
                l2.close();
                l2.moveTo(78.72942f, 40.807343f);
                l2.cubicTo(78.75339f, 41.35628f, 78.76669f, 41.915882f, 78.76669f, 42.46482f);
                l2.cubicTo(78.76669f, 60.483913f, 65.06989f, 79.12656f, 42.146053f, 79.12656f);
                l2.cubicTo(38.03302f, 79.12656f, 33.97589f, 78.436386f, 30.13706f, 77.093346f);
                l2.cubicTo(34.734608f, 76.213974f, 39.041977f, 74.252716f, 42.803608f, 71.3055f);
                l2.cubicTo(43.543686f, 70.72191f, 43.839188f, 69.74128f, 43.541023f, 68.845924f);
                l2.cubicTo(43.2402f, 67.955894f, 42.414932f, 67.345665f, 41.472527f, 67.32967f);
                l2.cubicTo(37.766804f, 67.25506f, 34.4045f, 65.41105f, 32.346653f, 62.490475f);
                l2.cubicTo(33.398205f, 62.418526f, 34.43112f, 62.245316f, 35.43209f, 61.97351f);
                l2.cubicTo(36.425076f, 61.701706f, 37.101265f, 60.782364f, 37.066658f, 59.751102f);
                l2.cubicTo(37.03471f, 58.722507f, 36.29197f, 57.848465f, 35.283012f, 57.64328f);
                l2.cubicTo(31.11141f, 56.806545f, 27.836956f, 53.718094f, 26.625673f, 49.710297f);
                l2.cubicTo(27.733131f, 49.990097f, 28.86721f, 50.152645f, 30.003952f, 50.189953f);
                l2.cubicTo(30.980965f, 50.184624f, 31.88876f, 49.585052f, 32.192245f, 48.644394f);
                l2.cubicTo(32.49573f, 47.703735f, 32.139004f, 46.667145f, 31.311071f, 46.118202f);
                l2.cubicTo(28.129793f, 43.986397f, 26.229012f, 40.43161f, 26.229012f, 36.597027f);
                l2.cubicTo(26.229012f, 35.66969f, 26.340822f, 34.753014f, 26.556458f, 33.857655f);
                l2.cubicTo(33.757595f, 41.24703f, 43.527714f, 45.710495f, 53.875523f, 46.232788f);
                l2.cubicTo(54.607616f, 46.238117f, 55.249195f, 45.974308f, 55.693775f, 45.43869f);
                l2.cubicTo(56.138355f, 44.903076f, 56.308735f, 44.18892f, 56.151665f, 43.50674f);
                l2.cubicTo(55.95733f, 42.662014f, 55.856167f, 41.782642f, 55.856167f, 40.89528f);
                l2.cubicTo(55.856167f, 34.5878f, 60.986145f, 29.45814f, 67.287476f, 29.45814f);
                l2.cubicTo(70.436806f, 29.45814f, 73.47699f, 30.77453f, 75.62801f, 33.071552f);
                l2.cubicTo(76.15246f, 33.633816f, 76.92715f, 33.87897f, 77.6832f, 33.73241f);
                l2.cubicTo(78.37003f, 33.59384f, 79.04623f, 33.436623f, 79.71709f, 33.252754f);
                l2.cubicTo(79.41892f, 33.476593f, 79.10479f, 33.68711f, 78.77734f, 33.881638f);
                l2.cubicTo(77.87753f, 34.419918f, 77.47821f, 35.5178f, 77.81631f, 36.509087f);
                l2.cubicTo(78.1544f, 37.500378f, 79.16336f, 38.150578f, 80.18297f, 37.99602f);
                l2.cubicTo(80.43587f, 37.96671f, 80.68611f, 37.934734f, 80.93902f, 37.900093f);
                l2.cubicTo(80.52638f, 38.24118f, 80.095116f, 38.57161f, 79.6532f, 38.88605f);
                l2.cubicTo(79.0409f, 39.331066f, 78.692154f, 40.050552f, 78.72942f, 40.807343f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}

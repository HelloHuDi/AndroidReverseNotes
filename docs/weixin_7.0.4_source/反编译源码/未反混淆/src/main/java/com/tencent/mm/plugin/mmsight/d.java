package com.tencent.mm.plugin.mmsight;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class d {
    private static float ost = 0.01f;
    private static boolean osu = false;
    private static int osv = 0;
    private static int osw = 0;
    private static ConcurrentHashMap<String, Long> osx = new ConcurrentHashMap();

    static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            if (i2 > i) {
                return 1;
            }
            return 0;
        }
    }

    static {
        AppMethodBeat.i(76424);
        AppMethodBeat.o(76424);
    }

    public static void a(com.tencent.mm.plugin.mmsight.model.a.d dVar, SightParams sightParams) {
        AppMethodBeat.i(76400);
        String str = sightParams.osM;
        String str2 = sightParams.osK;
        String str3 = sightParams.osL;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
            Object[] objArr = new Object[2];
            objArr[0] = str;
            int i = osv;
            osv = i + 1;
            objArr[1] = Integer.valueOf(i);
            b bVar = new b(String.format("%s/tempvideo%s.mp4", objArr));
            if (bVar.exists()) {
                bVar.delete();
            }
            b bVar2 = new b(j.w(bVar.dMD()) + ".remux");
            if (bVar2.exists()) {
                bVar2.delete();
            }
            bVar2 = new b(bVar.dME() + ".thumb");
            if (bVar2.exists()) {
                bVar2.delete();
            }
            bVar2 = new b(bVar.dME() + ".soundmp4");
            if (bVar2.exists()) {
                bVar2.delete();
            }
            final int i2 = osv - 3;
            i.R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(76399);
                    for (int access$000 = d.osw; access$000 < i2; access$000++) {
                        b bVar = new b(String.format("%s/tempvideo%s.mp4", new Object[]{str, Integer.valueOf(access$000)}));
                        if (bVar.exists()) {
                            bVar.delete();
                        }
                        b bVar2 = new b(j.w(bVar.dMD()) + ".remux");
                        if (bVar2.exists()) {
                            bVar2.delete();
                        }
                        bVar2 = new b(bVar.dME() + ".thumb");
                        if (bVar2.exists()) {
                            bVar2.delete();
                        }
                    }
                    d.osw = Math.max(i2, 0);
                    AppMethodBeat.o(76399);
                }
            });
            str = j.w(bVar.dMD());
            ab.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", str, bo.bc(str, "") + ".thumb");
            dVar.setFilePath(str);
            dVar.mb(str2);
        } else {
            ab.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", str, str2, str3);
            dVar.setFilePath(str2);
            dVar.mb(str3);
        }
        ab.i("MicroMsg.MMSightUtil", "captureImagePath %s", CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis()));
        dVar.mc(str);
        AppMethodBeat.o(76400);
    }

    public static String RJ(String str) {
        AppMethodBeat.i(76401);
        b bVar = new b(String.format("%s/%s.mp4", new Object[]{str, Long.valueOf(System.currentTimeMillis())}));
        if (bVar.exists()) {
            bVar.delete();
        }
        String w = j.w(bVar.dMD());
        AppMethodBeat.o(76401);
        return w;
    }

    public static void iV(boolean z) {
        osu = z;
    }

    public static Point eu(Context context) {
        AppMethodBeat.i(76402);
        Point hy = ae.hy(context);
        if (!osu && ae.hw(context)) {
            hy.y -= ae.fr(context);
        }
        AppMethodBeat.o(76402);
        return hy;
    }

    public static Point bPg() {
        AppMethodBeat.i(76403);
        Point hy = ae.hy(ah.getContext());
        AppMethodBeat.o(76403);
        return hy;
    }

    public static boolean a(Context context, Point point, boolean z) {
        AppMethodBeat.i(76404);
        Point eu = eu(context);
        ab.i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", point, eu, Float.valueOf(((float) eu.y) / ((float) eu.x)), Float.valueOf(z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x)), Float.valueOf(Math.abs((((float) eu.y) / ((float) eu.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x)))));
        if (Math.abs((((float) eu.y) / ((float) eu.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x))) > ost) {
            AppMethodBeat.o(76404);
            return true;
        }
        AppMethodBeat.o(76404);
        return false;
    }

    public static Point a(Point point, Point point2, boolean z) {
        AppMethodBeat.i(76405);
        Point a = a(point, point2, z, false);
        AppMethodBeat.o(76405);
        return a;
    }

    public static Point a(Point point, Point point2, boolean z, boolean z2) {
        AppMethodBeat.i(76406);
        int i = point2.x;
        int i2 = point2.y;
        int i3 = z ? point.y : point.x;
        int i4 = z ? point.x : point.y;
        int i5 = (int) (((float) i) * (((float) i4) / ((float) i3)));
        if (i5 % 2 != 0) {
            i5--;
        }
        i3 = (int) ((((float) i3) / ((float) i4)) * ((float) i2));
        if (z2) {
            i4 = ev(i5, point2.y);
        } else {
            i4 = i5;
        }
        ab.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", point2, point, Integer.valueOf(i), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z));
        if (i4 > point2.y || i > point2.x) {
            ab.i("MicroMsg.MMSightUtil", "can not adapt to screen");
            AppMethodBeat.o(76406);
            return null;
        }
        Point point3 = new Point(i, i4);
        AppMethodBeat.o(76406);
        return point3;
    }

    public static Point b(Point point, Point point2, boolean z) {
        AppMethodBeat.i(76407);
        Point b = b(point, point2, z, false);
        AppMethodBeat.o(76407);
        return b;
    }

    public static Point b(Point point, Point point2, boolean z, boolean z2) {
        AppMethodBeat.i(76408);
        int i = point2.x;
        int i2 = point2.y;
        int i3 = (int) ((((float) (z ? point.y : point.x)) / ((float) (z ? point.x : point.y))) * ((float) i2));
        if (i3 % 2 != 0) {
            i3++;
        }
        if (z2) {
            i3 = ev(i3, point2.y);
        }
        ab.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", point2, point, Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z));
        if (i3 <= point2.x) {
            Point point3 = new Point(i3, i2);
            AppMethodBeat.o(76408);
            return point3;
        }
        ab.i("MicroMsg.MMSightUtil", "can not adapt to screen");
        AppMethodBeat.o(76408);
        return null;
    }

    public static String cp(List<Size> list) {
        AppMethodBeat.i(76409);
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + ";");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76409);
        return stringBuffer2;
    }

    public static String cq(List<Size> list) {
        AppMethodBeat.i(76410);
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + " " + ((((double) size.height) * 1.0d) / ((double) size.width)) + "||");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76410);
        return stringBuffer2;
    }

    public static ArrayList<Size> c(Parameters parameters) {
        AppMethodBeat.i(76411);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        AppMethodBeat.o(76411);
        return arrayList;
    }

    public static String RK(String str) {
        AppMethodBeat.i(76412);
        try {
            String RK = com.tencent.mm.plugin.sight.base.d.RK(str);
            AppMethodBeat.o(76412);
            return RK;
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", e.getMessage());
            AppMethodBeat.o(76412);
            return null;
        }
    }

    public static String RL(String str) {
        AppMethodBeat.i(76413);
        String str2 = e.euR + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.o(76413);
        return str2;
    }

    public static void RM(String str) {
        AppMethodBeat.i(76414);
        ab.i("MicroMsg.MMSightUtil", "setTime key %s %s", str, bo.dpG().toString());
        osx.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(76414);
    }

    public static long RN(String str) {
        AppMethodBeat.i(76415);
        if (osx.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis() - ((Long) osx.get(str)).longValue();
            AppMethodBeat.o(76415);
            return currentTimeMillis;
        }
        AppMethodBeat.o(76415);
        return 0;
    }

    public static int ev(Context context) {
        AppMethodBeat.i(76416);
        int i;
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            i = (int) (((double) memoryInfo.totalMem) / 1024.0d);
            AppMethodBeat.o(76416);
            return i;
        }
        double e;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            e = (double) e("MemTotal", fileInputStream);
            if (e > 0.0d) {
                e /= 1024.0d;
            }
            try {
                fileInputStream.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            e = 0.0d;
        } catch (Throwable th) {
            fileInputStream.close();
            AppMethodBeat.o(76416);
        }
        i = (int) e;
        AppMethodBeat.o(76416);
        return i;
    }

    private static int e(String str, InputStream inputStream) {
        AppMethodBeat.i(76417);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            int read = inputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == (byte) 10 || i == 0) {
                    if (bArr[i] == (byte) 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            while (i2 < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && bArr[i2] != (byte) 10) {
                                if (Character.isDigit(bArr[i2])) {
                                    i = i2 + 1;
                                    while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && Character.isDigit(bArr[i])) {
                                        i++;
                                    }
                                    i = bo.ank(new String(bArr, 0, i2, i - i2));
                                    AppMethodBeat.o(76417);
                                    return i;
                                }
                                i2++;
                            }
                            AppMethodBeat.o(76417);
                            return 0;
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException | NumberFormatException e) {
        }
        AppMethodBeat.o(76417);
        return 0;
    }

    public static Bitmap ag(String str, long j) {
        AppMethodBeat.i(76418);
        if (bo.isNullOrNil(str) || !com.tencent.mm.vfs.e.ct(str)) {
            ab.e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", str);
            AppMethodBeat.o(76418);
            return null;
        }
        ab.i("MicroMsg.MMSightUtil", "getVideoThumb, %s", str);
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), -1);
            int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), -1);
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            ab.i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mp4Rotate));
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, 2);
            mediaMetadataRetriever.release();
            if (frameAtTime != null) {
                AppMethodBeat.o(76418);
                return frameAtTime;
            }
            int i3;
            ab.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
            if (i <= 0 || i2 <= 0) {
                ab.i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", SightVideoJNI.getSimpleMp4Info(str));
                JSONObject jSONObject = new JSONObject(r0);
                i2 = jSONObject.getInt("videoWidth");
                i3 = jSONObject.getInt("videoHeight");
                i = i2;
            } else {
                i3 = i2;
            }
            byte[] videoThumb = MP4MuxerJNI.getVideoThumb(str, i, i3);
            if (videoThumb == null) {
                ab.e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
                AppMethodBeat.o(76418);
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(videoThumb);
            frameAtTime = Bitmap.createBitmap(i, i3, Config.ARGB_8888);
            frameAtTime.copyPixelsFromBuffer(wrap);
            if (mp4Rotate > 0) {
                frameAtTime = com.tencent.mm.sdk.platformtools.d.b(frameAtTime, (float) mp4Rotate);
            }
            AppMethodBeat.o(76418);
            return frameAtTime;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightUtil", e, "get video thumb error! %s", e.getMessage());
            AppMethodBeat.o(76418);
            return null;
        }
    }

    public static Bitmap tv(String str) {
        AppMethodBeat.i(76419);
        Bitmap ag = ag(str, 0);
        AppMethodBeat.o(76419);
        return ag;
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(76420);
        if (i3 == 0) {
            AppMethodBeat.o(76420);
            return bArr;
        }
        byte[] g = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(bArr.length));
        int i4 = i * i2;
        Object obj = i3 % 180 != 0 ? 1 : null;
        Object obj2 = i3 % 270 != 0 ? 1 : null;
        Object obj3 = i3 >= 180 ? 1 : null;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i; i6++) {
                int i7;
                int i8;
                int i9;
                int i10;
                int i11 = (i5 * i) + i6;
                int i12 = (((i5 >> 1) * i) + i4) + (i6 & -2);
                int i13 = i12 + 1;
                if (obj != null) {
                    i7 = i2;
                } else {
                    i7 = i;
                }
                if (obj != null) {
                    i8 = i;
                } else {
                    i8 = i2;
                }
                if (obj != null) {
                    i9 = i5;
                } else {
                    i9 = i6;
                }
                if (obj != null) {
                    i10 = i6;
                } else {
                    i10 = i5;
                }
                if (obj2 != null) {
                    i9 = (i7 - i9) - 1;
                }
                if (obj3 != null) {
                    i10 = (i8 - i10) - 1;
                }
                i8 = (i10 * i7) + i9;
                i10 = (((i10 >> 1) * i7) + i4) + (i9 & -2);
                i9 = i10 + 1;
                g[i8] = (byte) (bArr[i11] & 255);
                g[i10] = (byte) (bArr[i12] & 255);
                g[i9] = (byte) (bArr[i13] & 255);
            }
        }
        com.tencent.mm.plugin.mmsight.model.a.j.owk.g(bArr);
        AppMethodBeat.o(76420);
        return g;
    }

    public static boolean a(int i, int i2, int i3, PInt pInt, PInt pInt2) {
        int i4;
        int i5;
        boolean z;
        AppMethodBeat.i(76421);
        if (i3 <= 0 || Math.min(i, i2) <= i3) {
            i4 = i2;
            i5 = i;
            z = false;
        } else {
            if (i < i2) {
                i4 = (int) (((float) i2) / ((((float) i) * 1.0f) / ((float) i3)));
                i5 = i3;
            } else {
                i5 = (int) (((float) i) / ((((float) i2) * 1.0f) / ((float) i3)));
                i4 = i3;
            }
            z = true;
        }
        pInt.value = i5;
        pInt2.value = i4;
        ab.d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
        AppMethodBeat.o(76421);
        return z;
    }

    public static int yN(int i) {
        if (i % 16 != 0) {
            while (i % 16 != 0) {
                i++;
            }
        }
        return i;
    }

    public static boolean yO(int i) {
        return i % 16 == 0;
    }

    public static int yP(int i) {
        AppMethodBeat.i(76422);
        int ev = ev(i, BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.o(76422);
        return ev;
    }

    public static int ev(int i, int i2) {
        int i3 = i % 16;
        if (i3 == 0) {
            return i;
        }
        int i4 = (16 - i3) + i;
        if (i4 < i2) {
            return i4;
        }
        return i - i3;
    }

    public static int yQ(int i) {
        AppMethodBeat.i(76423);
        int i2 = i % 32;
        if (i2 == 0) {
            AppMethodBeat.o(76423);
            return i;
        }
        int min = i - Math.min(32, i2);
        if (min < BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.o(76423);
            return min;
        }
        i -= i2;
        AppMethodBeat.o(76423);
        return i;
    }
}

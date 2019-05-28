package com.tencent.p177mm.plugin.mmsight;

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
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.mmsight.model.C46078i;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
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

/* renamed from: com.tencent.mm.plugin.mmsight.d */
public final class C3475d {
    private static float ost = 0.01f;
    private static boolean osu = false;
    private static int osv = 0;
    private static int osw = 0;
    private static ConcurrentHashMap<String, Long> osx = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.mmsight.d$a */
    static class C3477a implements Comparator<Size> {
        private C3477a() {
        }

        /* synthetic */ C3477a(byte b) {
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
        AppMethodBeat.m2504i(76424);
        AppMethodBeat.m2505o(76424);
    }

    /* renamed from: a */
    public static void m5769a(C43304d c43304d, SightParams sightParams) {
        AppMethodBeat.m2504i(76400);
        String str = sightParams.osM;
        String str2 = sightParams.osK;
        String str3 = sightParams.osL;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
            Object[] objArr = new Object[2];
            objArr[0] = str;
            int i = osv;
            osv = i + 1;
            objArr[1] = Integer.valueOf(i);
            C5728b c5728b = new C5728b(String.format("%s/tempvideo%s.mp4", objArr));
            if (c5728b.exists()) {
                c5728b.delete();
            }
            C5728b c5728b2 = new C5728b(C5736j.m8649w(c5728b.dMD()) + ".remux");
            if (c5728b2.exists()) {
                c5728b2.delete();
            }
            c5728b2 = new C5728b(c5728b.dME() + ".thumb");
            if (c5728b2.exists()) {
                c5728b2.delete();
            }
            c5728b2 = new C5728b(c5728b.dME() + ".soundmp4");
            if (c5728b2.exists()) {
                c5728b2.delete();
            }
            final int i2 = osv - 3;
            C46078i.m85848R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(76399);
                    for (int access$000 = C3475d.osw; access$000 < i2; access$000++) {
                        C5728b c5728b = new C5728b(String.format("%s/tempvideo%s.mp4", new Object[]{str, Integer.valueOf(access$000)}));
                        if (c5728b.exists()) {
                            c5728b.delete();
                        }
                        C5728b c5728b2 = new C5728b(C5736j.m8649w(c5728b.dMD()) + ".remux");
                        if (c5728b2.exists()) {
                            c5728b2.delete();
                        }
                        c5728b2 = new C5728b(c5728b.dME() + ".thumb");
                        if (c5728b2.exists()) {
                            c5728b2.delete();
                        }
                    }
                    C3475d.osw = Math.max(i2, 0);
                    AppMethodBeat.m2505o(76399);
                }
            });
            str = C5736j.m8649w(c5728b.dMD());
            C4990ab.m7417i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", str, C5046bo.m7532bc(str, "") + ".thumb");
            c43304d.setFilePath(str);
            c43304d.mo14858mb(str2);
        } else {
            C4990ab.m7417i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", str, str2, str3);
            c43304d.setFilePath(str2);
            c43304d.mo14858mb(str3);
        }
        C4990ab.m7417i("MicroMsg.MMSightUtil", "captureImagePath %s", CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis()));
        c43304d.mo14859mc(str);
        AppMethodBeat.m2505o(76400);
    }

    /* renamed from: RJ */
    public static String m5762RJ(String str) {
        AppMethodBeat.m2504i(76401);
        C5728b c5728b = new C5728b(String.format("%s/%s.mp4", new Object[]{str, Long.valueOf(System.currentTimeMillis())}));
        if (c5728b.exists()) {
            c5728b.delete();
        }
        String w = C5736j.m8649w(c5728b.dMD());
        AppMethodBeat.m2505o(76401);
        return w;
    }

    /* renamed from: iV */
    public static void m5783iV(boolean z) {
        osu = z;
    }

    /* renamed from: eu */
    public static Point m5780eu(Context context) {
        AppMethodBeat.m2504i(76402);
        Point hy = C5222ae.m7953hy(context);
        if (!osu && C5222ae.m7951hw(context)) {
            hy.y -= C5222ae.m7944fr(context);
        }
        AppMethodBeat.m2505o(76402);
        return hy;
    }

    public static Point bPg() {
        AppMethodBeat.m2504i(76403);
        Point hy = C5222ae.m7953hy(C4996ah.getContext());
        AppMethodBeat.m2505o(76403);
        return hy;
    }

    /* renamed from: a */
    public static boolean m5771a(Context context, Point point, boolean z) {
        AppMethodBeat.m2504i(76404);
        Point eu = C3475d.m5780eu(context);
        C4990ab.m7417i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", point, eu, Float.valueOf(((float) eu.y) / ((float) eu.x)), Float.valueOf(z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x)), Float.valueOf(Math.abs((((float) eu.y) / ((float) eu.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x)))));
        if (Math.abs((((float) eu.y) / ((float) eu.x)) - (z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x))) > ost) {
            AppMethodBeat.m2505o(76404);
            return true;
        }
        AppMethodBeat.m2505o(76404);
        return false;
    }

    /* renamed from: a */
    public static Point m5767a(Point point, Point point2, boolean z) {
        AppMethodBeat.m2504i(76405);
        Point a = C3475d.m5768a(point, point2, z, false);
        AppMethodBeat.m2505o(76405);
        return a;
    }

    /* renamed from: a */
    public static Point m5768a(Point point, Point point2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(76406);
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
            i4 = C3475d.m5781ev(i5, point2.y);
        } else {
            i4 = i5;
        }
        C4990ab.m7417i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", point2, point, Integer.valueOf(i), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z));
        if (i4 > point2.y || i > point2.x) {
            C4990ab.m7416i("MicroMsg.MMSightUtil", "can not adapt to screen");
            AppMethodBeat.m2505o(76406);
            return null;
        }
        Point point3 = new Point(i, i4);
        AppMethodBeat.m2505o(76406);
        return point3;
    }

    /* renamed from: b */
    public static Point m5773b(Point point, Point point2, boolean z) {
        AppMethodBeat.m2504i(76407);
        Point b = C3475d.m5774b(point, point2, z, false);
        AppMethodBeat.m2505o(76407);
        return b;
    }

    /* renamed from: b */
    public static Point m5774b(Point point, Point point2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(76408);
        int i = point2.x;
        int i2 = point2.y;
        int i3 = (int) ((((float) (z ? point.y : point.x)) / ((float) (z ? point.x : point.y))) * ((float) i2));
        if (i3 % 2 != 0) {
            i3++;
        }
        if (z2) {
            i3 = C3475d.m5781ev(i3, point2.y);
        }
        C4990ab.m7417i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", point2, point, Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z));
        if (i3 <= point2.x) {
            Point point3 = new Point(i3, i2);
            AppMethodBeat.m2505o(76408);
            return point3;
        }
        C4990ab.m7416i("MicroMsg.MMSightUtil", "can not adapt to screen");
        AppMethodBeat.m2505o(76408);
        return null;
    }

    /* renamed from: cp */
    public static String m5777cp(List<Size> list) {
        AppMethodBeat.m2504i(76409);
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + ";");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(76409);
        return stringBuffer2;
    }

    /* renamed from: cq */
    public static String m5778cq(List<Size> list) {
        AppMethodBeat.m2504i(76410);
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + " " + ((((double) size.height) * 1.0d) / ((double) size.width)) + "||");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(76410);
        return stringBuffer2;
    }

    /* renamed from: c */
    public static ArrayList<Size> m5775c(Parameters parameters) {
        AppMethodBeat.m2504i(76411);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C3477a());
        AppMethodBeat.m2505o(76411);
        return arrayList;
    }

    /* renamed from: RK */
    public static String m5763RK(String str) {
        AppMethodBeat.m2504i(76412);
        try {
            String RK = C21846d.m33384RK(str);
            AppMethodBeat.m2505o(76412);
            return RK;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", e.getMessage());
            AppMethodBeat.m2505o(76412);
            return null;
        }
    }

    /* renamed from: RL */
    public static String m5764RL(String str) {
        AppMethodBeat.m2504i(76413);
        String str2 = C6457e.euR + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.m2505o(76413);
        return str2;
    }

    /* renamed from: RM */
    public static void m5765RM(String str) {
        AppMethodBeat.m2504i(76414);
        C4990ab.m7417i("MicroMsg.MMSightUtil", "setTime key %s %s", str, C5046bo.dpG().toString());
        osx.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(76414);
    }

    /* renamed from: RN */
    public static long m5766RN(String str) {
        AppMethodBeat.m2504i(76415);
        if (osx.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis() - ((Long) osx.get(str)).longValue();
            AppMethodBeat.m2505o(76415);
            return currentTimeMillis;
        }
        AppMethodBeat.m2505o(76415);
        return 0;
    }

    /* renamed from: ev */
    public static int m5782ev(Context context) {
        AppMethodBeat.m2504i(76416);
        int i;
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            i = (int) (((double) memoryInfo.totalMem) / 1024.0d);
            AppMethodBeat.m2505o(76416);
            return i;
        }
        double e;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            e = (double) C3475d.m5779e("MemTotal", fileInputStream);
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
            AppMethodBeat.m2505o(76416);
        }
        i = (int) e;
        AppMethodBeat.m2505o(76416);
        return i;
    }

    /* renamed from: e */
    private static int m5779e(String str, InputStream inputStream) {
        AppMethodBeat.m2504i(76417);
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
                                    i = C5046bo.ank(new String(bArr, 0, i2, i - i2));
                                    AppMethodBeat.m2505o(76417);
                                    return i;
                                }
                                i2++;
                            }
                            AppMethodBeat.m2505o(76417);
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
        AppMethodBeat.m2505o(76417);
        return 0;
    }

    /* renamed from: ag */
    public static Bitmap m5772ag(String str, long j) {
        AppMethodBeat.m2504i(76418);
        if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
            C4990ab.m7413e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", str);
            AppMethodBeat.m2505o(76418);
            return null;
        }
        C4990ab.m7417i("MicroMsg.MMSightUtil", "getVideoThumb, %s", str);
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), -1);
            int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), -1);
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            C4990ab.m7417i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mp4Rotate));
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, 2);
            mediaMetadataRetriever.release();
            if (frameAtTime != null) {
                AppMethodBeat.m2505o(76418);
                return frameAtTime;
            }
            int i3;
            C4990ab.m7416i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
            if (i <= 0 || i2 <= 0) {
                C4990ab.m7417i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", SightVideoJNI.getSimpleMp4Info(str));
                JSONObject jSONObject = new JSONObject(r0);
                i2 = jSONObject.getInt("videoWidth");
                i3 = jSONObject.getInt("videoHeight");
                i = i2;
            } else {
                i3 = i2;
            }
            byte[] videoThumb = MP4MuxerJNI.getVideoThumb(str, i, i3);
            if (videoThumb == null) {
                C4990ab.m7412e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
                AppMethodBeat.m2505o(76418);
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(videoThumb);
            frameAtTime = Bitmap.createBitmap(i, i3, Config.ARGB_8888);
            frameAtTime.copyPixelsFromBuffer(wrap);
            if (mp4Rotate > 0) {
                frameAtTime = C5056d.m7648b(frameAtTime, (float) mp4Rotate);
            }
            AppMethodBeat.m2505o(76418);
            return frameAtTime;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightUtil", e, "get video thumb error! %s", e.getMessage());
            AppMethodBeat.m2505o(76418);
            return null;
        }
    }

    /* renamed from: tv */
    public static Bitmap m5784tv(String str) {
        AppMethodBeat.m2504i(76419);
        Bitmap ag = C3475d.m5772ag(str, 0);
        AppMethodBeat.m2505o(76419);
        return ag;
    }

    /* renamed from: c */
    public static byte[] m5776c(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(76420);
        if (i3 == 0) {
            AppMethodBeat.m2505o(76420);
            return bArr;
        }
        byte[] g = C43305j.owk.mo68846g(Integer.valueOf(bArr.length));
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
        C43305j.owk.mo68845g(bArr);
        AppMethodBeat.m2505o(76420);
        return g;
    }

    /* renamed from: a */
    public static boolean m5770a(int i, int i2, int i3, PInt pInt, PInt pInt2) {
        int i4;
        int i5;
        boolean z;
        AppMethodBeat.m2504i(76421);
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
        C4990ab.m7411d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
        AppMethodBeat.m2505o(76421);
        return z;
    }

    /* renamed from: yN */
    public static int m5785yN(int i) {
        if (i % 16 != 0) {
            while (i % 16 != 0) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: yO */
    public static boolean m5786yO(int i) {
        return i % 16 == 0;
    }

    /* renamed from: yP */
    public static int m5787yP(int i) {
        AppMethodBeat.m2504i(76422);
        int ev = C3475d.m5781ev(i, BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.m2505o(76422);
        return ev;
    }

    /* renamed from: ev */
    public static int m5781ev(int i, int i2) {
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

    /* renamed from: yQ */
    public static int m5788yQ(int i) {
        AppMethodBeat.m2504i(76423);
        int i2 = i % 32;
        if (i2 == 0) {
            AppMethodBeat.m2505o(76423);
            return i;
        }
        int min = i - Math.min(32, i2);
        if (min < BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.m2505o(76423);
            return min;
        }
        i -= i2;
        AppMethodBeat.m2505o(76423);
        return i;
    }
}

package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class d {
    private static int osv = 0;
    private static int osw = 0;

    public static boolean ckV() {
        AppMethodBeat.i(117304);
        if (q.ete.eub == 0) {
            AppMethodBeat.o(117304);
            return false;
        }
        boolean iW = com.tencent.mm.compatible.util.d.iW(14);
        AppMethodBeat.o(117304);
        return iW;
    }

    public static String WO(String str) {
        AppMethodBeat.i(117305);
        String str2 = bo.bc(str, "") + ".thumb";
        AppMethodBeat.o(117305);
        return str2;
    }

    public static String WP(String str) {
        AppMethodBeat.i(117306);
        String str2 = bo.bc(str, "") + ".soundmp4";
        AppMethodBeat.o(117306);
        return str2;
    }

    public static Bitmap ag(String str, int i, int i2) {
        AppMethodBeat.i(117307);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(117307);
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail == null) {
            ab.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", str);
        } else {
            createVideoThumbnail = com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, i2, i, true, true);
        }
        AppMethodBeat.o(117307);
        return createVideoThumbnail;
    }

    public static boolean WQ(String str) {
        AppMethodBeat.i(117308);
        if (bo.isNullOrNil(str) || !e.ct(str)) {
            AppMethodBeat.o(117308);
            return false;
        }
        long yz = bo.yz();
        c cVar = new c();
        int isSightOk = SightVideoJNI.isSightOk(str, cVar.qxg, cVar.qxh, cVar.qxi, cVar.qxk, cVar.qxj, cVar.qxj.length);
        ab.d("MicroMsg.SightUtil", "ashu::check sight use %dms", Long.valueOf(bo.az(yz)));
        if (isSightOk == 0) {
            AppMethodBeat.o(117308);
            return true;
        }
        AppMethodBeat.o(117308);
        return false;
    }

    public static String ckW() {
        Object format;
        String format2;
        AppMethodBeat.i(117309);
        StringBuilder stringBuilder = new StringBuilder(512);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ah.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + f.REV);
        stringBuilderPrinter.println("#accinfo.build=" + f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + g.cdf);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Thread.currentThread().getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + b.xxv);
        stringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.vxi);
        stringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.vxj);
        stringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.vxk);
        stringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.vxl);
        stringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.vxm);
        stringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.DEVICE_NAME);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.eSl);
            format2 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            ab.e("MicroMsg.SightUtil", "check data size failed :%s", e.getMessage());
            format2 = str;
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format2)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        format2 = stringBuilder.toString();
        AppMethodBeat.o(117309);
        return format2;
    }

    public static String RK(String str) {
        AppMethodBeat.i(117310);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extInfo: \n".concat(String.valueOf(a(str, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()))));
        stringBuffer.append("size: " + bo.ga(e.asZ(str)) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str + IOUtils.LINE_SEPARATOR_UNIX);
        String mp4RecordInfo = SightVideoJNI.getMp4RecordInfo(str);
        if (!bo.isNullOrNil(mp4RecordInfo)) {
            stringBuffer.append(mp4RecordInfo);
        }
        stringBuffer.append("isH265:").append(r.uc(str));
        mp4RecordInfo = stringBuffer.toString();
        AppMethodBeat.o(117310);
        return mp4RecordInfo;
    }

    public static String a(String str, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5) {
        AppMethodBeat.i(117311);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            ab.d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
            JSONObject jSONObject = new JSONObject(r0);
            pInt.value = (int) jSONObject.getDouble("videoDuration");
            pInt2.value = jSONObject.getInt("videoWidth");
            pInt3.value = jSONObject.getInt("videoHeight");
            pInt4.value = (int) jSONObject.getDouble("videoFPS");
            pInt5.value = jSONObject.getInt("videoBitrate");
            stringBuffer.append("videoBitrate: ").append(pInt5.value).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("videoWidth,videoHeight: ").append(pInt2.value).append("*").append(pInt3.value);
            stringBuffer.append(" ").append(String.format("%.4f", new Object[]{Double.valueOf((((double) pInt2.value) * 1.0d) / ((double) pInt3.value))})).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("videoDuration: ").append(pInt.value).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("videoFPS: ").append(pInt4.value).append(IOUtils.LINE_SEPARATOR_UNIX);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SightUtil", e, "get media info error", new Object[0]);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(117311);
        return stringBuffer2;
    }

    public static a WR(String str) {
        a aVar = null;
        AppMethodBeat.i(117312);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(117312);
        } else if (e.ct(str)) {
            aVar = new a();
            try {
                ab.d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
                JSONObject jSONObject = new JSONObject(r1);
                aVar.eWK = (int) jSONObject.getDouble("videoDuration");
                aVar.width = jSONObject.getInt("videoWidth");
                aVar.height = jSONObject.getInt("videoHeight");
                aVar.eTk = (int) jSONObject.getDouble("videoFPS");
                aVar.videoBitrate = jSONObject.getInt("videoBitrate");
                aVar.fzS = jSONObject.getInt("audioBitrate");
                aVar.qwV = jSONObject.getInt("audioChannel");
            } catch (Exception e) {
                ab.e("MicroMsg.SightUtil", "get media info error %s", e.toString());
            }
            ab.i("MicroMsg.SightUtil", "get media %s", aVar);
            AppMethodBeat.o(117312);
        } else {
            AppMethodBeat.o(117312);
        }
        return aVar;
    }
}

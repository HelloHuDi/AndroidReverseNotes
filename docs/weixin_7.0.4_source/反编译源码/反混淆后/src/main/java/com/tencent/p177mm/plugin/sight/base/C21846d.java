package com.tencent.p177mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.modelvideo.C26492r;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sight.base.d */
public final class C21846d {
    private static int osv = 0;
    private static int osw = 0;

    public static boolean ckV() {
        AppMethodBeat.m2504i(117304);
        if (C1427q.ete.eub == 0) {
            AppMethodBeat.m2505o(117304);
            return false;
        }
        boolean iW = C1443d.m3068iW(14);
        AppMethodBeat.m2505o(117304);
        return iW;
    }

    /* renamed from: WO */
    public static String m33385WO(String str) {
        AppMethodBeat.m2504i(117305);
        String str2 = C5046bo.m7532bc(str, "") + ".thumb";
        AppMethodBeat.m2505o(117305);
        return str2;
    }

    /* renamed from: WP */
    public static String m33386WP(String str) {
        AppMethodBeat.m2504i(117306);
        String str2 = C5046bo.m7532bc(str, "") + ".soundmp4";
        AppMethodBeat.m2505o(117306);
        return str2;
    }

    /* renamed from: ag */
    public static Bitmap m33390ag(String str, int i, int i2) {
        AppMethodBeat.m2504i(117307);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(117307);
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail == null) {
            C4990ab.m7413e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", str);
        } else {
            createVideoThumbnail = C5056d.m7615a(createVideoThumbnail, i2, i, true, true);
        }
        AppMethodBeat.m2505o(117307);
        return createVideoThumbnail;
    }

    /* renamed from: WQ */
    public static boolean m33387WQ(String str) {
        AppMethodBeat.m2504i(117308);
        if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
            AppMethodBeat.m2505o(117308);
            return false;
        }
        long yz = C5046bo.m7588yz();
        C29015c c29015c = new C29015c();
        int isSightOk = SightVideoJNI.isSightOk(str, c29015c.qxg, c29015c.qxh, c29015c.qxi, c29015c.qxk, c29015c.qxj, c29015c.qxj.length);
        C4990ab.m7411d("MicroMsg.SightUtil", "ashu::check sight use %dms", Long.valueOf(C5046bo.m7525az(yz)));
        if (isSightOk == 0) {
            AppMethodBeat.m2505o(117308);
            return true;
        }
        AppMethodBeat.m2505o(117308);
        return false;
    }

    public static String ckW() {
        Object format;
        String format2;
        AppMethodBeat.m2504i(117309);
        StringBuilder stringBuilder = new StringBuilder(512);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = C4996ah.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + C5058f.REV);
        stringBuilderPrinter.println("#accinfo.build=" + C5058f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5058f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5059g.cdf);
        stringBuilderPrinter.println("#accinfo.env=" + (C4872b.foreground ? "f" : "b") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Thread.currentThread().getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C4872b.xxv);
        stringBuilderPrinter.println("#aacinfo.device_brand=" + C7243d.vxi);
        stringBuilderPrinter.println("#aacinfo.device_model=" + C7243d.vxj);
        stringBuilderPrinter.println("#aacinfo.os_type=" + C7243d.vxk);
        stringBuilderPrinter.println("#aacinfo.os_name=" + C7243d.vxl);
        stringBuilderPrinter.println("#aacinfo.os_version=" + C7243d.vxm);
        stringBuilderPrinter.println("#aacinfo.device_name=" + C7243d.DEVICE_NAME);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(C6457e.eSl);
            format2 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), C6457e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SightUtil", "check data size failed :%s", e.getMessage());
            format2 = str;
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format2)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        format2 = stringBuilder.toString();
        AppMethodBeat.m2505o(117309);
        return format2;
    }

    /* renamed from: RK */
    public static String m33384RK(String str) {
        AppMethodBeat.m2504i(117310);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extInfo: \n".concat(String.valueOf(C21846d.m33389a(str, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()))));
        stringBuffer.append("size: " + C5046bo.m7565ga(C5730e.asZ(str)) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str + IOUtils.LINE_SEPARATOR_UNIX);
        String mp4RecordInfo = SightVideoJNI.getMp4RecordInfo(str);
        if (!C5046bo.isNullOrNil(mp4RecordInfo)) {
            stringBuffer.append(mp4RecordInfo);
        }
        stringBuffer.append("isH265:").append(C26492r.m42230uc(str));
        mp4RecordInfo = stringBuffer.toString();
        AppMethodBeat.m2505o(117310);
        return mp4RecordInfo;
    }

    /* renamed from: a */
    public static String m33389a(String str, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5) {
        AppMethodBeat.m2504i(117311);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            C4990ab.m7411d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
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
            C4990ab.printErrStackTrace("MicroMsg.SightUtil", e, "get media info error", new Object[0]);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(117311);
        return stringBuffer2;
    }

    /* renamed from: WR */
    public static C43528a m33388WR(String str) {
        C43528a c43528a = null;
        AppMethodBeat.m2504i(117312);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(117312);
        } else if (C5730e.m8628ct(str)) {
            c43528a = new C43528a();
            try {
                C4990ab.m7411d("MicroMsg.SightUtil", "get simple mp4 info %s", SightVideoJNI.getSimpleMp4Info(str));
                JSONObject jSONObject = new JSONObject(r1);
                c43528a.eWK = (int) jSONObject.getDouble("videoDuration");
                c43528a.width = jSONObject.getInt("videoWidth");
                c43528a.height = jSONObject.getInt("videoHeight");
                c43528a.eTk = (int) jSONObject.getDouble("videoFPS");
                c43528a.videoBitrate = jSONObject.getInt("videoBitrate");
                c43528a.fzS = jSONObject.getInt("audioBitrate");
                c43528a.qwV = jSONObject.getInt("audioChannel");
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SightUtil", "get media info error %s", e.toString());
            }
            C4990ab.m7417i("MicroMsg.SightUtil", "get media %s", c43528a);
            AppMethodBeat.m2505o(117312);
        } else {
            AppMethodBeat.m2505o(117312);
        }
        return c43528a;
    }
}

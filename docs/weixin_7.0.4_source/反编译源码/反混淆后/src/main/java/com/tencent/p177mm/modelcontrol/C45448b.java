package com.tencent.p177mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.modelcontrol.b */
public final class C45448b {
    public static boolean afz() {
        AppMethodBeat.m2504i(78086);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("C2CImgNotAutoDownloadTimeRange");
        C4990ab.m7416i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(value)));
        boolean rR = C45448b.m83719rR(value);
        AppMethodBeat.m2505o(78086);
        return rR;
    }

    /* renamed from: rR */
    public static boolean m83719rR(String str) {
        AppMethodBeat.m2504i(78087);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78087);
            return false;
        }
        try {
            int afA = C45448b.afA();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                int ank = C5046bo.ank(split4[1]) + (C5046bo.ank(split4[0]) * 60);
                split3 = split3[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (C45448b.m83717H(ank, C5046bo.ank(split3[1]) + (C5046bo.ank(split3[0]) * 60), afA)) {
                    AppMethodBeat.m2505o(78087);
                    return true;
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
        }
        AppMethodBeat.m2505o(78087);
        return false;
    }

    /* renamed from: W */
    public static boolean m83718W(String str, int i) {
        AppMethodBeat.m2504i(78088);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78088);
            return false;
        }
        try {
            int afA = C45448b.afA();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                int ank = C5046bo.ank(split4[1]) + (C5046bo.ank(split4[0]) * 60);
                split3 = split3[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (C45448b.m83717H(ank, (C5046bo.ank(split3[1]) + (C5046bo.ank(split3[0]) * 60)) + i, afA)) {
                    AppMethodBeat.m2505o(78088);
                    return true;
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
        }
        AppMethodBeat.m2505o(78088);
        return false;
    }

    private static int afA() {
        AppMethodBeat.m2504i(78089);
        String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        int ank = (C5046bo.ank(split[1]) + (C5046bo.ank(split[0]) * 60)) - ((((int) C45448b.afB()) - 8) * 60);
        if (ank < 0) {
            ank += 1440;
        } else if (ank >= 1440) {
            ank -= 1440;
        }
        AppMethodBeat.m2505o(78089);
        return ank;
    }

    public static long afB() {
        AppMethodBeat.m2504i(78090);
        long rawOffset = ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
        AppMethodBeat.m2505o(78090);
        return rawOffset;
    }

    /* renamed from: H */
    private static boolean m83717H(int i, int i2, int i3) {
        if (i < i2) {
            if (i3 >= i2 || i3 < i) {
                return false;
            }
            return true;
        } else if (i3 <= 1440 && i3 >= i) {
            return true;
        } else {
            if (i3 >= i2 || i3 < 0) {
                return false;
            }
            return true;
        }
    }
}

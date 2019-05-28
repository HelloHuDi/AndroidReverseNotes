package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b {
    public static boolean afz() {
        AppMethodBeat.i(78086);
        String value = ((a) g.K(a.class)).Nu().getValue("C2CImgNotAutoDownloadTimeRange");
        ab.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(value)));
        boolean rR = rR(value);
        AppMethodBeat.o(78086);
        return rR;
    }

    public static boolean rR(String str) {
        AppMethodBeat.i(78087);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78087);
            return false;
        }
        try {
            int afA = afA();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                int ank = bo.ank(split4[1]) + (bo.ank(split4[0]) * 60);
                split3 = split3[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (H(ank, bo.ank(split3[1]) + (bo.ank(split3[0]) * 60), afA)) {
                    AppMethodBeat.o(78087);
                    return true;
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            ab.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
        }
        AppMethodBeat.o(78087);
        return false;
    }

    public static boolean W(String str, int i) {
        AppMethodBeat.i(78088);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78088);
            return false;
        }
        try {
            int afA = afA();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                int ank = bo.ank(split4[1]) + (bo.ank(split4[0]) * 60);
                split3 = split3[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (H(ank, (bo.ank(split3[1]) + (bo.ank(split3[0]) * 60)) + i, afA)) {
                    AppMethodBeat.o(78088);
                    return true;
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            ab.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
        }
        AppMethodBeat.o(78088);
        return false;
    }

    private static int afA() {
        AppMethodBeat.i(78089);
        String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        int ank = (bo.ank(split[1]) + (bo.ank(split[0]) * 60)) - ((((int) afB()) - 8) * 60);
        if (ank < 0) {
            ank += 1440;
        } else if (ank >= 1440) {
            ank -= 1440;
        }
        AppMethodBeat.o(78089);
        return ank;
    }

    public static long afB() {
        AppMethodBeat.i(78090);
        long rawOffset = ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
        AppMethodBeat.o(78090);
        return rawOffset;
    }

    private static boolean H(int i, int i2, int i3) {
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

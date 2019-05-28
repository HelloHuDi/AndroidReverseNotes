package com.tencent.p177mm.plugin.p468n;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.n.e */
public final class C12691e {
    private static long ors = 0;

    @TargetApi(21)
    public static boolean bOS() {
        AppMethodBeat.m2504i(117865);
        try {
            if (C1443d.m3068iW(21)) {
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                int length = codecInfos.length;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String a = C12691e.m20701a(codecInfos[i]);
                    if (!C5046bo.isNullOrNil(a)) {
                        arrayList.add(Integer.valueOf(i));
                        arrayList2.add(a);
                    }
                }
                if (arrayList.isEmpty()) {
                    AppMethodBeat.m2505o(117865);
                    return false;
                }
                AppMethodBeat.m2505o(117865);
                return true;
            }
            AppMethodBeat.m2505o(117865);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaCodecUtil", e, "isSupportHevc error", new Object[0]);
            AppMethodBeat.m2505o(117865);
            return false;
        }
    }

    public static boolean bOT() {
        AppMethodBeat.m2504i(117866);
        if (C5046bo.m7566gb(ors) > 86400000) {
            AppMethodBeat.m2505o(117866);
            return true;
        }
        AppMethodBeat.m2505o(117866);
        return false;
    }

    public static String bOU() {
        String str;
        AppMethodBeat.m2504i(117867);
        C4990ab.m7411d("MicroMsg.MediaCodecUtil", "check hevc info last rpt time[%d]", Long.valueOf(ors));
        try {
            ors = C5046bo.anU();
            if (C1443d.m3068iW(21)) {
                int i;
                long yz = C5046bo.m7588yz();
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                int length = codecInfos.length;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (i = 0; i < length; i++) {
                    String a = C12691e.m20701a(codecInfos[i]);
                    if (!C5046bo.isNullOrNil(a)) {
                        arrayList.add(Integer.valueOf(i));
                        arrayList2.add(a);
                    }
                }
                if (arrayList.isEmpty()) {
                    str = "";
                    AppMethodBeat.m2505o(117867);
                    return str;
                }
                boolean z = false;
                Object obj = null;
                Object obj2 = null;
                Object obj3 = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                length = 0;
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                int i9 = 0;
                while (i9 < arrayList.size()) {
                    int intValue = ((Integer) arrayList.get(i9)).intValue();
                    str = (String) arrayList2.get(i9);
                    z = codecInfos[intValue].isEncoder();
                    obj = !codecInfos[intValue].isEncoder() ? 1 : null;
                    CodecCapabilities capabilitiesForType = codecInfos[intValue].getCapabilitiesForType(str);
                    if (capabilitiesForType != null) {
                        obj2 = 1;
                        VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                        if (videoCapabilities != null) {
                            i2 = Math.max(((Integer) videoCapabilities.getBitrateRange().getLower()).intValue(), i2);
                            i3 = Math.max(((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue(), i3);
                            i4 = Math.max(((Integer) videoCapabilities.getSupportedFrameRates().getLower()).intValue(), i4);
                            i5 = Math.max(((Integer) videoCapabilities.getSupportedFrameRates().getUpper()).intValue(), i5);
                            i6 = Math.max(((Integer) videoCapabilities.getSupportedWidths().getLower()).intValue(), i6);
                            i7 = Math.max(((Integer) videoCapabilities.getSupportedWidths().getUpper()).intValue(), i7);
                            i8 = Math.max(((Integer) videoCapabilities.getSupportedHeights().getLower()).intValue(), i8);
                            i = Math.max(((Integer) videoCapabilities.getSupportedHeights().getUpper()).intValue(), length);
                        } else {
                            i = length;
                        }
                        stringBuilder.append(codecInfos[intValue].getName()).append("|");
                    } else {
                        obj3 = 1;
                        stringBuilder2.append(codecInfos[intValue].getName()).append("|");
                        i = length;
                    }
                    i9++;
                    length = i;
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(1).append(",");
                if (obj != null && z) {
                    stringBuilder3.append(3).append(",");
                } else if (z) {
                    stringBuilder3.append(2).append(",");
                } else {
                    stringBuilder3.append(1).append(",");
                }
                if (obj2 != null && obj3 != null) {
                    stringBuilder3.append(3).append(",");
                } else if (obj3 != null) {
                    stringBuilder3.append(2).append(",");
                } else {
                    stringBuilder3.append(1).append(",");
                }
                stringBuilder3.append(stringBuilder.toString()).append(",");
                stringBuilder3.append(stringBuilder2.toString()).append(",");
                stringBuilder3.append(i2).append(",").append(i3).append(",");
                stringBuilder3.append(i4).append(",").append(i5).append(",");
                stringBuilder3.append(i6).append(",").append(i7).append(",");
                stringBuilder3.append(i8).append(",").append(length);
                C4990ab.m7417i("MicroMsg.MediaCodecUtil", "high api 21 cost[%d] hevc info %s", Long.valueOf(C5046bo.m7525az(yz)), stringBuilder3.toString());
                AppMethodBeat.m2505o(117867);
                return str;
            }
            str = C12691e.bOV();
            AppMethodBeat.m2505o(117867);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaCodecUtil", e, "report hevc info error %s", e.toString());
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MediaCodecUtil", th, "report hevc info error %s", th.toString());
        }
        str = "";
        AppMethodBeat.m2505o(117867);
        return str;
    }

    private static String bOV() {
        int i;
        AppMethodBeat.m2504i(117868);
        long yz = C5046bo.m7588yz();
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (i = 0; i < codecCount; i++) {
            String a = C12691e.m20701a(MediaCodecList.getCodecInfoAt(i));
            if (!C5046bo.isNullOrNil(a)) {
                arrayList.add(Integer.valueOf(i));
                arrayList2.add(a);
            }
        }
        String str;
        if (arrayList.isEmpty()) {
            str = "";
            AppMethodBeat.m2505o(117868);
            return str;
        }
        boolean z = false;
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        i = 0;
        while (true) {
            codecCount = i;
            if (codecCount >= arrayList.size()) {
                break;
            }
            str = (String) arrayList2.get(codecCount);
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(((Integer) arrayList.get(codecCount)).intValue());
            z = codecInfoAt.isEncoder();
            obj = !codecInfoAt.isEncoder() ? 1 : null;
            if (codecInfoAt.getCapabilitiesForType(str) != null) {
                obj2 = 1;
                stringBuilder.append(codecInfoAt.getName()).append("|");
            } else {
                obj3 = 1;
                stringBuilder2.append(codecInfoAt.getName()).append("|");
            }
            i = codecCount + 1;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(1).append(",");
        if (obj != null && z) {
            stringBuilder3.append(3).append(",");
        } else if (z) {
            stringBuilder3.append(2).append(",");
        } else {
            stringBuilder3.append(1).append(",");
        }
        if (obj2 != null && obj3 != null) {
            stringBuilder3.append(3).append(",");
        } else if (obj3 != null) {
            stringBuilder3.append(2).append(",");
        } else {
            stringBuilder3.append(1).append(",");
        }
        stringBuilder3.append(stringBuilder.toString()).append(",");
        stringBuilder3.append(stringBuilder2.toString());
        C4990ab.m7417i("MicroMsg.MediaCodecUtil", "below api 21 cost[%d] hevc info %s", Long.valueOf(C5046bo.m7525az(yz)), stringBuilder3.toString());
        AppMethodBeat.m2505o(117868);
        return stringBuilder3.toString();
    }

    /* renamed from: a */
    private static String m20701a(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.m2504i(117869);
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        int i = 0;
        while (i < supportedTypes.length) {
            String str = supportedTypes[i];
            if (C5046bo.isNullOrNil(str) || !str.contains("hevc")) {
                i++;
            } else {
                AppMethodBeat.m2505o(117869);
                return str;
            }
        }
        String str2 = "";
        AppMethodBeat.m2505o(117869);
        return str2;
    }
}

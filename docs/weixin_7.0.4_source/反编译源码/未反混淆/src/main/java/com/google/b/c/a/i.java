package com.google.b.c.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import org.xwalk.core.XWalkEnvironment;

public final class i {
    private static final int[] bzP = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] bzQ = new int[][]{new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, d.CTRL_INDEX, 240, 92, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED}, new int[]{28, 24, 185, 166, 223, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, 116, 255, 110, 61}, new int[]{ErrorCode.NEEDDOWNLOAD_FALSE_5, 138, 205, 12, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, 168, 39, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, 60, 97, 120}, new int[]{41, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 158, 91, 61, 42, ErrorCode.NEEDDOWNLOAD_3, 213, 97, 178, 100, 242}, new int[]{156, 97, az.CTRL_INDEX, 252, 95, 9, 157, com.tencent.view.d.MIC_AVROUND_BLUR, 138, 45, 18, 186, 83, 185}, new int[]{83, JsApiChooseWeChatContact.CTRL_INDEX, 100, 39, 188, 75, 66, 61, com.tencent.view.d.MIC_PTU_QINGCONG, 213, 109, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 94, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, 225, 48, 90, 188}, new int[]{15, JsApiChooseWeChatContact.CTRL_INDEX, 244, 9, com.tencent.view.d.MIC_PTU_MEISHI, 71, 168, 2, 188, 160, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 145, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, 79, 108, 82, 27, ErrorCode.NEEDDOWNLOAD_FALSE_4, 186, ErrorCode.NEEDDOWNLOAD_FALSE_2}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, 205, 109, 39, ErrorCode.NEEDDOWNLOAD_FALSE_6, 21, 155, 197, 251, 223, 155, 21, 5, ErrorCode.NEEDDOWNLOAD_FALSE_2, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, 124, 12, 181, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 96, 50, JsApiChooseMedia.CTRL_INDEX}, new int[]{211, 231, 43, 97, 71, 96, 103, ErrorCode.NEEDDOWNLOAD_FALSE_4, 37, 151, ErrorCode.NEEDDOWNLOAD_TRUE, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, n.CTRL_INDEX, 120, 151, com.tencent.view.d.MIC_PTU_MEISHI, 168, 93, 255}, new int[]{com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, com.tencent.view.d.MIC_SketchMark, 242, 218, 130, 250, ErrorCode.STARTDOWNLOAD_3, 181, 102, 120, 84, 179, 220, 251, 80, FaceMoveUtil.TRIANGLE_COUNT, 229, 18, 2, 4, 68, 33, 101, 137, 95, com.tencent.view.d.MIC_AVROUND_BLUR, 115, 44, ErrorCode.NEEDDOWNLOAD_FALSE_5, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 59, 25, 225, 98, 81, 112}, new int[]{77, JsApiChooseMedia.CTRL_INDEX, 137, 31, 19, 38, 22, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 247, 105, 122, 2, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, e.CTRL_INDEX, 242, 8, ErrorCode.NEEDDOWNLOAD_FALSE_5, 95, 100, 9, ErrorCode.STARTDOWNLOAD_8, 105, 214, 111, 57, 121, 21, 1, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, 57, 54, 101, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, 202, 69, 50, 150, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 226, 5, 9, 5}, new int[]{com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, 132, ErrorCode.NEEDDOWNLOAD_FALSE_2, 223, 96, 32, com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, 22, com.tencent.view.d.MIC_PTU_SHIGUANG, e.CTRL_INDEX, com.tencent.view.d.MIC_PTU_SHIGUANG, 231, 205, 188, com.tencent.view.d.MIC_PTU_LENGMEIREN, 87, 191, 106, 16, ErrorCode.NEEDDOWNLOAD_8, 118, 23, 37, 90, ErrorCode.NEEDDOWNLOAD_TRUE, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, ErrorCode.NEEDDOWNLOAD_FALSE_6, 87, 187, ErrorCode.NEEDDOWNLOAD_8, 160, ErrorCode.NEEDDOWNLOAD_FALSE_5, 69, 213, 92, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, 225, 19}, new int[]{ErrorCode.NEEDDOWNLOAD_FALSE_5, 9, 223, com.tencent.view.d.MIC_PTU_SHIGUANG, 12, 17, 220, 208, 100, 29, ErrorCode.NEEDDOWNLOAD_FALSE_5, ErrorCode.NEEDDOWNLOAD_TRUE, 230, az.CTRL_INDEX, 215, com.tencent.view.d.MIC_PTU_AUTOLEVEL, 150, JsApiGetBackgroundAudioState.CTRL_INDEX, 36, 223, 38, 200, 132, 54, 228, 146, 218, com.tencent.view.d.MIC_PTU_FENGJING, com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, 203, 29, 232, 144, com.tencent.view.d.MIC_PTU_SHIGUANG, 22, 150, 201, com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, 62, 207, ErrorCode.STARTDOWNLOAD_5, 13, 137, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, com.tencent.view.d.MIC_SketchMark, 67, 247, 28, 155, 43, 203, 107, com.tencent.view.d.MIC_PTU_MEISHI, 53, ErrorCode.NEEDDOWNLOAD_4, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, ErrorCode.NEEDDOWNLOAD_4, 108, 196, 37, 185, 112, d.CTRL_INDEX, 230, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 250, 106, 185, 221, ErrorCode.NEEDDOWNLOAD_FALSE_5, 64, 114, 71, 161, 44, ErrorCode.NEEDDOWNLOAD_8, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, ErrorCode.STARTDOWNLOAD_4, 31, ErrorCode.NEEDDOWNLOAD_FALSE_6, ErrorCode.NEEDDOWNLOAD_TRUE, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, ErrorCode.NEEDDOWNLOAD_FALSE_3, 89, 251, 149, JsApiGetBackgroundAudioState.CTRL_INDEX, 56, 89, 33, ErrorCode.NEEDDOWNLOAD_8, 244, JsApiMakeVoIPCall.CTRL_INDEX, 36, 73, com.tencent.view.d.MIC_SketchMark, 213, n.CTRL_INDEX, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, 180, com.tencent.view.d.MIC_PTU_FENGJING, 197, 158, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 68, 122, 93, 213, 15, 160, 227, 236, 66, a.CTRL_INDEX, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 185, 202, ErrorCode.STARTDOWNLOAD_8, 179, 25, 220, 232, 96, 210, 231, n.CTRL_INDEX, 223, com.tencent.view.d.MIC_PTU_SHISHANG2, 181, com.tencent.view.d.MIC_PTU_QINGCONG, 59, 52, ErrorCode.NEEDDOWNLOAD_FALSE_2, 25, 49, 232, 211, 189, 64, 54, 108, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 132, 63, 96, 103, 82, 186}};
    private static final int[] bzR = new int[256];
    private static final int[] bzS = new int[255];

    static {
        int i = 1;
        int i2 = 0;
        while (i2 < 255) {
            bzS[i2] = i;
            bzR[i] = i2;
            int i3 = i << 1;
            if (i3 >= 256) {
                i3 ^= 301;
            }
            i2++;
            i = i3;
        }
    }

    public static String a(String str, k kVar) {
        AppMethodBeat.i(57276);
        if (str.length() != kVar.bzW) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The number of codewords does not match the selected symbol");
            AppMethodBeat.o(57276);
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder(kVar.bzW + kVar.bzX);
        stringBuilder.append(str);
        int vv = kVar.vv();
        if (vv == 1) {
            stringBuilder.append(c(str, kVar.bzX));
        } else {
            int i;
            stringBuilder.setLength(stringBuilder.capacity());
            int[] iArr = new int[vv];
            int[] iArr2 = new int[vv];
            int[] iArr3 = new int[vv];
            for (i = 0; i < vv; i++) {
                iArr[i] = kVar.fE(i + 1);
                iArr2[i] = kVar.bAc;
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
            }
            for (int i2 = 0; i2 < vv; i2++) {
                StringBuilder stringBuilder2 = new StringBuilder(iArr[i2]);
                for (i = i2; i < kVar.bzW; i += vv) {
                    stringBuilder2.append(str.charAt(i));
                }
                String c = c(stringBuilder2.toString(), iArr2[i2]);
                i = i2;
                int i3 = 0;
                while (i < iArr2[i2] * vv) {
                    int i4 = i3 + 1;
                    stringBuilder.setCharAt(kVar.bzW + i, c.charAt(i3));
                    i += vv;
                    i3 = i4;
                }
            }
        }
        String stringBuilder3 = stringBuilder.toString();
        AppMethodBeat.o(57276);
        return stringBuilder3;
    }

    private static String c(CharSequence charSequence, int i) {
        AppMethodBeat.i(57277);
        String a = a(charSequence, charSequence.length(), i);
        AppMethodBeat.o(57277);
        return a;
    }

    private static String a(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.i(57278);
        int i4 = 0;
        while (i4 < bzP.length) {
            if (bzP[i4] == i2) {
                break;
            }
            i4++;
        }
        i4 = -1;
        if (i4 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(57278);
            throw illegalArgumentException;
        }
        int[] iArr = bzQ[i4];
        char[] cArr = new char[i2];
        for (i4 = 0; i4 < i2; i4++) {
            cArr[i4] = 0;
        }
        for (int i5 = 0; i5 < i + 0; i5++) {
            int charAt = charSequence.charAt(i5) ^ cArr[i2 - 1];
            i4 = i2 - 1;
            while (i4 > 0) {
                if (charAt == 0 || iArr[i4] == 0) {
                    cArr[i4] = cArr[i4 - 1];
                } else {
                    cArr[i4] = (char) (cArr[i4 - 1] ^ bzS[(bzR[charAt] + bzR[iArr[i4]]) % 255]);
                }
                i4--;
            }
            if (charAt == 0 || iArr[0] == 0) {
                cArr[0] = 0;
            } else {
                cArr[0] = (char) bzS[(bzR[charAt] + bzR[iArr[0]]) % 255];
            }
        }
        char[] cArr2 = new char[i2];
        while (i3 < i2) {
            cArr2[i3] = cArr[(i2 - i3) - 1];
            i3++;
        }
        String valueOf = String.valueOf(cArr2);
        AppMethodBeat.o(57278);
        return valueOf;
    }
}

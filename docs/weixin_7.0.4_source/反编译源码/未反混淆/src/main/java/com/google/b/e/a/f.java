package com.google.b.e.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.s;
import com.tencent.mm.plugin.appbrand.jsapi.j.a;
import com.tencent.mm.plugin.appbrand.jsapi.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.ac;
import com.tencent.mm.plugin.appbrand.jsapi.k.ad;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.appbrand.jsapi.k.m;
import com.tencent.mm.plugin.appbrand.jsapi.k.t;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.share.k;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.plugin.appbrand.jsapi.storage.j;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.d;
import com.tencent.wxmm.v2helper;

final class f {
    private static final int[][] bAZ = new int[][]{new int[]{27, 917}, new int[]{c.CTRL_INDEX, 568, 723, 809}, new int[]{d.MIC_PTU_LENGMEIREN, 308, h.CTRL_INDEX, 284, 646, 653, v2helper.EMethodSetIosMicAbCheckOn, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, 132, 295, 116, JsApiInstallDownloadTask.CTRL_INDEX, v2helper.EMethodSetIosMicAbCheckOn, 295, 42, ErrorCode.NEEDDOWNLOAD_FALSE_6, 65}, new int[]{361, 575, 922, i.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_6, 586, 640, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 536, 742, 677, 742, 687, 284, JsApiChooseMedia.CTRL_INDEX, a.CTRL_INDEX, 273, 494, d.MIC_PTU_ZIPAI_GRADIENT_FASHION, ErrorCode.NEEDDOWNLOAD_8, com.tencent.mm.plugin.appbrand.jsapi.fakenative.a.CTRL_INDEX, 800, 571, 320, 803, e.CTRL_INDEX, 231, 390, 685, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 63, 410}, new int[]{539, v2helper.EMethodOutputVolumeGainEnable, 6, 93, 862, 771, l.CTRL_INDEX, 106, 610, d.MIC_PTU_SHUILIAN, 107, 505, 733, 877, 381, 612, 723, JsApiOpenAdCanvas.CTRL_INDEX, 462, ErrorCode.NEEDDOWNLOAD_FALSE_2, 430, 609, 858, 822, 543, 376, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, 400, 672, 762, 283, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, JsApiAddDownloadTaskStraight.CTRL_INDEX, 35, g.CTRL_INDEX, 31, 460, com.tencent.mm.plugin.appbrand.jsapi.b.g.CTRL_INDEX, 225, com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX, a.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX, 605, 158, 651, 201, com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE, 648, 733, 717, 83, 404, 97, d.MIC_PTU_TRANS_XINXIAN, 771, 840, 629, 4, 381, 843, 623, d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, 543}, new int[]{com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, d.MIC_PTU_DANNAI, 864, 547, 858, 580, d.MIC_PTU_YINGTAOBUDING, 379, 53, 779, 897, JsApiResumeDownloadTask.CTRL_INDEX, 400, 925, 749, 415, 822, 93, 217, 208, 928, 244, 583, 620, d.MIC_PTU_ZIPAI_FAIRYTALE, 148, 447, 631, 292, 908, 490, 704, b.CTRL_INDEX, d.MIC_PTU_ZIPAI_SAPPORO, 457, 907, com.tencent.mm.plugin.appbrand.jsapi.b.g.CTRL_INDEX, 723, 674, 292, 272, 96, 684, v2helper.EMethodSetSendToNetworkOn, 686, 606, 860, 569, JsApiChooseMedia.CTRL_INDEX, 219, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 186, 236, d.MIC_PTU_SHUILIAN, az.CTRL_INDEX, 775, d.MIC_PTU_TRANS_XINGYE, ErrorCode.NEEDDOWNLOAD_FALSE_3, 40, 379, 712, 463, 646, 776, ErrorCode.NEEDDOWNLOAD_FALSE_1, com.tencent.mm.plugin.appbrand.jsapi.p.d.CTRL_INDEX, 297, 763, 156, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, ag.CTRL_INDEX, 378, 382, d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, 380, 602, 754, 336, 89, 614, 87, v2helper.EMethodSetSendToNetworkOn, 670, bd.CTRL_INDEX, 157, 374, 242, 726, 600, 269, 375, 898, 845, m.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX, 130, 814, 587, 804, 34, 211, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 539, 297, 827, 865, 37, a.CTRL_INDEX, 834, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, d.MIC_PTU_HONGKONG, 913, d.MIC_GPU_AUTOLEVEL, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 375, 850, 438, 733, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, d.MIC_PTU_TRANS_XINXIAN, 201, d.MIC_PTU_TRANS_XINXIAN, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, 605, 540, 913, 801, 700, 799, 137, JsApiGetInstallState.CTRL_INDEX, 418, com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.CTRL_INDEX, 668, com.tencent.mm.plugin.appbrand.jsapi.nfc.e.CTRL_INDEX, 859, 370, 694, ErrorCode.THROWABLE_INITX5CORE, 240, 216, d.MIC_PTU_ZIPAI_TOKYO, 284, JsApiChooseMultiMedia.CTRL_INDEX, 209, 884, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 70, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 793, 490, 274, 877, ErrorCode.STARTDOWNLOAD_3, 749, 812, 684, 461, 334, 376, 849, com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, 307, 291, 803, 712, 19, com.tencent.mm.plugin.appbrand.jsapi.nfc.b.CTRL_INDEX, 399, 908, 103, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, 51, 8, a.CTRL_INDEX, 225, d.MIC_PTU_ZIRAN, 470, 637, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY, 66, 255, 917, 269, 463, 830, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH, v2helper.EMethodSetSendToNetworkOff, 848, com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX, n.CTRL_INDEX, 538, 906, 90, 2, 290, 743, 199, 655, com.tencent.mm.hardcoder.i.SCENE_BIZ_SCROLL, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 49, 802, 580, 355, 588, 188, 462, 10, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, 628, 320, 479, 130, 739, 71, d.MIC_PTU_ZIPAI_GRADIENT_FASHION, 318, 374, 601, az.CTRL_INDEX, 605, ErrorCode.NEEDDOWNLOAD_3, 673, 687, d.MIC_PTU_FENGJING, 722, 384, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION, 640, 455, JsApiChooseMedia.CTRL_INDEX, 689, 707, 805, 641, 48, 60, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, com.tencent.mm.plugin.appbrand.weishi.f.CTRL_INDEX, 895, 544, d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 852, 655, d.MIC_PTU_MUSE, 697, 755, 756, 60, 231, 773, 434, v2helper.EMethodSetPlayerPreCorrectCofOff, 726, 528, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS, 118, 49, 795, 32, 144, 500, d.MIC_PTU_SHIGUANG, 836, 394, d.MIC_PTU_TRANS_XINXIAN, 566, ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 9, 647, com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, 73, 914, com.tencent.mm.plugin.appbrand.jsapi.coverview.b.CTRL_INDEX, 126, 32, 681, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, 792, 620, 60, 609, JsApiQueryDownloadTask.CTRL_INDEX, 180, 791, 893, 754, 605, 383, 228, 749, 760, 213, 54, 297, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, 54, 834, 299, 922, 191, 910, com.tencent.mm.plugin.appbrand.jsapi.media.c.CTRL_INDEX, 609, 829, 189, 20, ErrorCode.STARTDOWNLOAD_8, 29, 872, 449, 83, 402, 41, 656, 505, ad.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.audio.m.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_3, 404, 251, 688, 95, com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX, 555, 642, 543, 307, JsApiGetBackgroundAudioState.CTRL_INDEX, 924, JsApiSetLabInfo.CTRL_INDEX, 648, 55, com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX, 10}, new int[]{com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX, 77, com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX, 504, 35, 599, v2helper.EMethodSetIosMicAbCheckOn, 207, 409, 574, 118, com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, 285, 380, 350, com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX, 197, d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE, 920, 155, 914, 299, 229, 643, d.MIC_PTU_WU, 871, 306, 88, 87, JsApiChooseMedia.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX, 781, 846, 75, ErrorCode.TEST_THROWABLE_ISNOT_NULL, com.tencent.mm.plugin.appbrand.jsapi.j.e.CTRL_INDEX, z.CTRL_INDEX, 543, 203, 666, 249, com.tencent.mm.plugin.appbrand.jsapi.i.f.CTRL_INDEX, 781, com.tencent.mm.plugin.appbrand.weishi.f.CTRL_INDEX, 640, d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI, 794, com.tencent.mm.plugin.appbrand.jsapi.q.l.CTRL_INDEX, 539, 781, 408, 390, 644, 102, JsApiOpenAdCanvas.CTRL_INDEX, j.CTRL_INDEX, 290, 632, 545, 37, 858, 916, 552, 41, 542, d.MIC_PTU_ZIRAN, 122, 272, 383, 800, 485, 98, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, com.tencent.mm.plugin.appbrand.jsapi.p.e.CTRL_INDEX, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, com.tencent.mm.plugin.appbrand.jsapi.fakenative.a.CTRL_INDEX, 913, ErrorCode.NEEDDOWNLOAD_3, 808, 684, d.MIC_PTU_SHUILIAN, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, az.CTRL_INDEX, b.CTRL_INDEX, d.MIC_PTU_ZIPAI_SAPPORO, 240, com.tencent.mm.plugin.appbrand.jsapi.j.f.CTRL_INDEX, 794, b.CTRL_INDEX, 768, 848, 51, 610, 384, 168, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 826, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, com.tencent.mm.plugin.appbrand.jsapi.b.j.CTRL_INDEX, 786, 303, 570, 381, 415, 641, 156, d.MIC_PTU_LENGMEIREN, 151, v2helper.EMethodSetIosMicAbCheckOff, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, ErrorCode.STARTDOWNLOAD_3, 864, 229, 65, 861, 841, 512, ErrorCode.STARTDOWNLOAD_5, com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, 221, 92, com.tencent.mm.plugin.appbrand.jsapi.nfc.b.CTRL_INDEX, 785, d.MIC_PTU_YOUJIALI, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, 2, j.CTRL_INDEX, 851, 543, 152, 729, 771, 95, d.MIC_PTU_ZIPAI_THURSDAY, 361, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, 323, 856, 797, d.MIC_PTU_ZIRAN, 51, 684, aj.CTRL_INDEX, ac.CTRL_INDEX, 820, 669, 45, 902, 452, ErrorCode.STARTDOWNLOAD_8, com.tencent.mm.plugin.appbrand.jsapi.coverview.b.CTRL_INDEX, 244, ErrorCode.NEEDDOWNLOAD_FALSE_3, 35, 463, 651, 51, 699, 591, 452, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, 37, 124, 298, 332, 552, 43, v2helper.EMethodPcMicLevel, d.MIC_AVROUND_BLUR, 662, 777, JsApiCancelDownloadTask.CTRL_INDEX, 850, 764, 364, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, 911, 283, 711, com.tencent.mm.plugin.appbrand.jsapi.p.e.CTRL_INDEX, v2helper.EMethodSetPlayerPreCorrectCofOn, d.MIC_PTU_ZIPAI_LIGHTWHITE, d.MIC_PTU_YOUJIALI, com.tencent.mm.plugin.appbrand.jsapi.b.g.CTRL_INDEX, 394, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, ErrorCode.TEST_THROWABLE_ISNOT_NULL, com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX, 777, 699, 688, 43, 408, 842, 383, 721, com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, 560, 644, 714, 559, 62, 145, 873, 663, 713, JsApiGetBackgroundAudioState.CTRL_INDEX, 672, 729, 624, 59, JsApiChooseMedia.CTRL_INDEX, 417, 158, 209, 563, 564, s.CTRL_INDEX, 693, 109, 608, 563, 365, 181, 772, 677, d.MIC_PTU_DANNAI, d.MIC_PTU_ZIPAI_THURSDAY, com.tencent.mm.plugin.appbrand.jsapi.nfc.e.CTRL_INDEX, 708, 410, ad.CTRL_INDEX, 870, be.CTRL_INDEX, 841, 632, 860, d.MIC_PTU_ZIRAN, 536, 35, 777, bb.CTRL_INDEX, 586, v2helper.EMethodSetSpkEnhance, 833, 77, 597, com.tencent.mm.plugin.appbrand.jsapi.i.f.CTRL_INDEX, 269, 757, 632, 695, TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, 247, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 45, 787, 680, 18, 66, 407, 369, 54, com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX, 228, 613, 830, 922, 437, g.CTRL_INDEX, 644, 905, 789, v2helper.EMethodSetPlayerPreCorrectCofOn, d.MIC_PTU_QINGCHENG, JsApiQueryDownloadTask.CTRL_INDEX, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, 252, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, d.MIC_PTU_DANNAI, 756, 665, 397, 808, 851, d.MIC_PTU_MUSE, 473, 795, 378, 31, 647, 915, 459, 806, v.CTRL_INDEX, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY, 425, 216, 548, 249, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 881, 699, com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX, 673, 782, 210, 815, 905, 303, 843, 922, d.MIC_PTU_TRANS_KONGCHENG, 73, com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, 791, 660, ErrorCode.STARTDOWNLOAD_3, com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, 308, 155, v2helper.EMethodOutputVolumeGainEnable, 907, 817, 187, 62, 16, 425, com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX, 336, 286, 437, 375, 273, 610, d.MIC_PTU_YINGTAOBUDING, 183, 923, 116, 667, TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, com.tencent.mm.plugin.appbrand.jsapi.nfc.e.CTRL_INDEX, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 5, 39, 923, d.MIC_PTU_HONGKONG, v2helper.EMethodSetSpkEnhance, 242, 749, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 54, 669, com.tencent.mm.plugin.appbrand.jsapi.wifi.a.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.coverview.b.CTRL_INDEX, 299, com.tencent.mm.plugin.appbrand.jsapi.q.l.CTRL_INDEX, 105, 667, com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX, 640, 672, 576, 540, com.tencent.mm.plugin.appbrand.jsapi.wifi.a.CTRL_INDEX, 486, 721, 610, 46, 656, 447, ErrorCode.NEEDDOWNLOAD_FALSE_1, bd.CTRL_INDEX, k.CTRL_INDEX, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 531, 297, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 762, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, ac.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_5, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, 14, 381, v2helper.EMethodSetSendToNetworkOff, 717, 45, 111, 20, com.tencent.mm.plugin.appbrand.jsapi.b.j.CTRL_INDEX, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, ErrorCode.STARTDOWNLOAD_5, 332, 899, ErrorCode.STARTDOWNLOAD_6, 726, 600, ErrorCode.THROWABLE_INITX5CORE, com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, 655, 357, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, 768, 223, 849, 647, 63, d.MIC_PTU_DANNAI, 863, 251, 366, 304, d.MIC_PTU_BAIXI, 738, 675, 410, t.CTRL_INDEX, 244, 31, 121, 303, d.MIC_PTU_ZIPAI_GRADIENT_FASHION}};

    static int fG(int i) {
        AppMethodBeat.i(57233);
        if (i < 0 || i > 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error correction level must be between 0 and 8!");
            AppMethodBeat.o(57233);
            throw illegalArgumentException;
        }
        int i2 = 1 << (i + 1);
        AppMethodBeat.o(57233);
        return i2;
    }

    static String e(CharSequence charSequence, int i) {
        int i2;
        AppMethodBeat.i(57234);
        int fG = fG(i);
        char[] cArr = new char[fG];
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            int charAt = (charSequence.charAt(i3) + cArr[fG - 1]) % 929;
            for (i2 = fG - 1; i2 > 0; i2--) {
                cArr[i2] = (char) (((929 - ((bAZ[i][i2] * charAt) % 929)) + cArr[i2 - 1]) % 929);
            }
            cArr[0] = (char) ((929 - ((bAZ[i][0] * charAt) % 929)) % 929);
        }
        StringBuilder stringBuilder = new StringBuilder(fG);
        for (i2 = fG - 1; i2 >= 0; i2--) {
            if (cArr[i2] != 0) {
                cArr[i2] = (char) (929 - cArr[i2]);
            }
            stringBuilder.append(cArr[i2]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(57234);
        return stringBuilder2;
    }
}

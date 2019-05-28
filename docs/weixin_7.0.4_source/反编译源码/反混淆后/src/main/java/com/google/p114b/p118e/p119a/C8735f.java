package com.google.p114b.p118e.p119a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C42444a;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C45562b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27141z;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42466ag;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45571aj;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45628v;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C33244g;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42475m;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C45581b;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C16657e;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.C2262b;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.C19365c;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.C33304a;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C42541c;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33379c;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C38360b;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C38361e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19314g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42476h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42478j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C45575b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26982f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33325s;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44699i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C19403g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C2294a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C33332f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C36724c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C38314b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27009m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33337c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42523ac;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42524ad;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42528t;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C10503e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27057d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27059f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C27067l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C45616h;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C19480k;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42570e;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19483d;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19484j;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C27084e;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C19523a;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C38405e;
import com.tencent.p177mm.plugin.appbrand.weishi.C2509f;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.C31128d;
import com.tencent.wxmm.v2helper;

/* renamed from: com.google.b.e.a.f */
final class C8735f {
    private static final int[][] bAZ = new int[][]{new int[]{27, 917}, new int[]{C19482c.CTRL_INDEX, 568, 723, 809}, new int[]{C31128d.MIC_PTU_LENGMEIREN, 308, C42476h.CTRL_INDEX, 284, 646, 653, v2helper.EMethodSetIosMicAbCheckOn, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, 132, 295, 116, JsApiInstallDownloadTask.CTRL_INDEX, v2helper.EMethodSetIosMicAbCheckOn, 295, 42, ErrorCode.NEEDDOWNLOAD_FALSE_6, 65}, new int[]{361, 575, 922, C44699i.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_6, 586, 640, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 536, 742, 677, 742, 687, 284, JsApiChooseMedia.CTRL_INDEX, C2294a.CTRL_INDEX, 273, 494, C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION, ErrorCode.NEEDDOWNLOAD_8, C33304a.CTRL_INDEX, 800, 571, 320, 803, C19394e.CTRL_INDEX, 231, 390, 685, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 63, 410}, new int[]{539, v2helper.EMethodOutputVolumeGainEnable, 6, 93, 862, 771, C38317l.CTRL_INDEX, 106, 610, C31128d.MIC_PTU_SHUILIAN, 107, 505, 733, 877, 381, 612, 723, JsApiOpenAdCanvas.CTRL_INDEX, 462, ErrorCode.NEEDDOWNLOAD_FALSE_2, 430, 609, 858, 822, 543, 376, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, 400, 672, 762, 283, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, JsApiAddDownloadTaskStraight.CTRL_INDEX, 35, C19403g.CTRL_INDEX, 31, 460, C19314g.CTRL_INDEX, 225, C45616h.CTRL_INDEX, C2294a.CTRL_INDEX, C33381d.CTRL_INDEX, 605, 158, 651, 201, C27059f.CTRL_INDEX, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE, 648, 733, 717, 83, 404, 97, C31128d.MIC_PTU_TRANS_XINXIAN, 771, 840, 629, 4, 381, 843, 623, C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, 543}, new int[]{C36724c.CTRL_INDEX, C31128d.MIC_PTU_DANNAI, 864, 547, 858, 580, C31128d.MIC_PTU_YINGTAOBUDING, 379, 53, 779, 897, JsApiResumeDownloadTask.CTRL_INDEX, 400, 925, 749, 415, 822, 93, 217, 208, 928, 244, 583, 620, C31128d.MIC_PTU_ZIPAI_FAIRYTALE, 148, 447, 631, 292, 908, 490, 704, C38314b.CTRL_INDEX, C31128d.MIC_PTU_ZIPAI_SAPPORO, 457, 907, C19314g.CTRL_INDEX, 723, 674, 292, 272, 96, 684, v2helper.EMethodSetSendToNetworkOn, 686, 606, 860, 569, JsApiChooseMedia.CTRL_INDEX, 219, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 186, 236, C31128d.MIC_PTU_SHUILIAN, C33250az.CTRL_INDEX, 775, C31128d.MIC_PTU_TRANS_XINGYE, ErrorCode.NEEDDOWNLOAD_FALSE_3, 40, 379, 712, 463, 646, 776, ErrorCode.NEEDDOWNLOAD_FALSE_1, C27057d.CTRL_INDEX, 297, 763, 156, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, C42466ag.CTRL_INDEX, 378, 382, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, 380, 602, 754, 336, 89, 614, 87, v2helper.EMethodSetSendToNetworkOn, 670, C45580bd.CTRL_INDEX, 157, 374, 242, 726, 600, 269, 375, 898, 845, C27009m.CTRL_INDEX, C33379c.CTRL_INDEX, 130, 814, 587, 804, 34, 211, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 539, 297, 827, 865, 37, C2294a.CTRL_INDEX, 834, C38405e.CTRL_INDEX, C16657e.CTRL_INDEX, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, C31128d.MIC_PTU_HONGKONG, 913, C31128d.MIC_GPU_AUTOLEVEL, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 375, 850, 438, 733, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, C31128d.MIC_PTU_TRANS_XINXIAN, 201, C31128d.MIC_PTU_TRANS_XINXIAN, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, 605, 540, 913, 801, 700, 799, 137, JsApiGetInstallState.CTRL_INDEX, 418, C19365c.CTRL_INDEX, 668, C38361e.CTRL_INDEX, 859, 370, 694, ErrorCode.THROWABLE_INITX5CORE, 240, 216, C31128d.MIC_PTU_ZIPAI_TOKYO, 284, JsApiChooseMultiMedia.CTRL_INDEX, 209, 884, C38405e.CTRL_INDEX, 70, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 793, 490, 274, 877, ErrorCode.STARTDOWNLOAD_3, 749, 812, 684, 461, 334, 376, 849, C36724c.CTRL_INDEX, 307, 291, 803, 712, 19, C38360b.CTRL_INDEX, 399, 908, 103, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, 51, 8, C2294a.CTRL_INDEX, 225, C31128d.MIC_PTU_ZIRAN, 470, 637, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY, 66, 255, 917, 269, 463, 830, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH, v2helper.EMethodSetSendToNetworkOff, 848, C42444a.CTRL_INDEX, C19395n.CTRL_INDEX, 538, 906, 90, 2, 290, 743, 199, 655, C1625i.SCENE_BIZ_SCROLL, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 49, 802, 580, 355, 588, 188, 462, 10, C19392d.CTRL_INDEX, 628, 320, 479, 130, 739, 71, C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION, 318, 374, 601, C33250az.CTRL_INDEX, 605, ErrorCode.NEEDDOWNLOAD_3, 673, 687, C31128d.MIC_PTU_FENGJING, 722, 384, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION, 640, 455, JsApiChooseMedia.CTRL_INDEX, 689, 707, 805, 641, 48, 60, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, C2509f.CTRL_INDEX, 895, 544, C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, 852, 655, C31128d.MIC_PTU_MUSE, 697, 755, 756, 60, 231, 773, 434, v2helper.EMethodSetPlayerPreCorrectCofOff, 726, 528, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS, 118, 49, 795, 32, 144, 500, C31128d.MIC_PTU_SHIGUANG, 836, 394, C31128d.MIC_PTU_TRANS_XINXIAN, 566, ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 9, 647, C16657e.CTRL_INDEX, 73, 914, C2262b.CTRL_INDEX, 126, 32, 681, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, 792, 620, 60, 609, JsApiQueryDownloadTask.CTRL_INDEX, 180, 791, 893, 754, 605, 383, 228, 749, 760, 213, 54, 297, C19392d.CTRL_INDEX, 54, 834, 299, 922, 191, 910, C42541c.CTRL_INDEX, 609, 829, 189, 20, ErrorCode.STARTDOWNLOAD_8, 29, 872, 449, 83, 402, 41, 656, 505, C42524ad.CTRL_INDEX, C42475m.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_3, 404, 251, 688, 95, C19483d.CTRL_INDEX, 555, 642, 543, 307, JsApiGetBackgroundAudioState.CTRL_INDEX, 924, JsApiSetLabInfo.CTRL_INDEX, 648, 55, C19483d.CTRL_INDEX, 10}, new int[]{C33381d.CTRL_INDEX, 77, C45575b.CTRL_INDEX, 504, 35, 599, v2helper.EMethodSetIosMicAbCheckOn, 207, 409, 574, 118, C27084e.CTRL_INDEX, 285, 380, 350, C26982f.CTRL_INDEX, 197, C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE, 920, 155, 914, 299, 229, 643, C31128d.MIC_PTU_WU, 871, 306, 88, 87, JsApiChooseMedia.CTRL_INDEX, C33381d.CTRL_INDEX, 781, 846, 75, ErrorCode.TEST_THROWABLE_ISNOT_NULL, C41234e.CTRL_INDEX, C27141z.CTRL_INDEX, 543, 203, 666, 249, C45604f.CTRL_INDEX, 781, C2509f.CTRL_INDEX, 640, C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI, 794, C27067l.CTRL_INDEX, 539, 781, 408, 390, 644, 102, JsApiOpenAdCanvas.CTRL_INDEX, C19484j.CTRL_INDEX, 290, 632, 545, 37, 858, 916, 552, 41, 542, C31128d.MIC_PTU_ZIRAN, 122, 272, 383, 800, 485, 98, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, C10503e.CTRL_INDEX, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, C33304a.CTRL_INDEX, 913, ErrorCode.NEEDDOWNLOAD_3, 808, 684, C31128d.MIC_PTU_SHUILIAN, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, C33250az.CTRL_INDEX, C38314b.CTRL_INDEX, C31128d.MIC_PTU_ZIPAI_SAPPORO, 240, C33332f.CTRL_INDEX, 794, C45562b.CTRL_INDEX, 768, 848, 51, 610, 384, 168, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 826, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, C42478j.CTRL_INDEX, 786, 303, 570, 381, 415, 641, 156, C31128d.MIC_PTU_LENGMEIREN, 151, v2helper.EMethodSetIosMicAbCheckOff, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, ErrorCode.STARTDOWNLOAD_3, 864, 229, 65, 861, 841, 512, ErrorCode.STARTDOWNLOAD_5, C45581b.CTRL_INDEX, 221, 92, C38360b.CTRL_INDEX, 785, C31128d.MIC_PTU_YOUJIALI, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, C36724c.CTRL_INDEX, 2, C19484j.CTRL_INDEX, 851, 543, 152, 729, 771, 95, C31128d.MIC_PTU_ZIPAI_THURSDAY, 361, C33337c.CTRL_INDEX, 323, 856, 797, C31128d.MIC_PTU_ZIRAN, 51, 684, C45571aj.CTRL_INDEX, C42523ac.CTRL_INDEX, 820, 669, 45, 902, 452, ErrorCode.STARTDOWNLOAD_8, C2262b.CTRL_INDEX, 244, ErrorCode.NEEDDOWNLOAD_FALSE_3, 35, 463, 651, 51, 699, 591, 452, C33337c.CTRL_INDEX, 37, 124, 298, 332, 552, 43, v2helper.EMethodPcMicLevel, C31128d.MIC_AVROUND_BLUR, 662, 777, JsApiCancelDownloadTask.CTRL_INDEX, 850, 764, 364, C33337c.CTRL_INDEX, 911, 283, 711, C10503e.CTRL_INDEX, v2helper.EMethodSetPlayerPreCorrectCofOn, C31128d.MIC_PTU_ZIPAI_LIGHTWHITE, C31128d.MIC_PTU_YOUJIALI, C19314g.CTRL_INDEX, 394, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, ErrorCode.TEST_THROWABLE_ISNOT_NULL, C42570e.CTRL_INDEX, 777, 699, 688, 43, 408, 842, 383, 721, C36724c.CTRL_INDEX, 560, 644, 714, 559, 62, 145, 873, 663, 713, JsApiGetBackgroundAudioState.CTRL_INDEX, 672, 729, 624, 59, JsApiChooseMedia.CTRL_INDEX, 417, 158, 209, 563, 564, C33325s.CTRL_INDEX, 693, 109, 608, 563, 365, 181, 772, 677, C31128d.MIC_PTU_DANNAI, C31128d.MIC_PTU_ZIPAI_THURSDAY, C38361e.CTRL_INDEX, 708, 410, C42524ad.CTRL_INDEX, 870, C38271be.CTRL_INDEX, 841, 632, 860, C31128d.MIC_PTU_ZIRAN, 536, 35, 777, C45579bb.CTRL_INDEX, 586, v2helper.EMethodSetSpkEnhance, 833, 77, 597, C45604f.CTRL_INDEX, 269, 757, 632, 695, TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, 247, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 45, 787, 680, 18, 66, 407, 369, 54, C26982f.CTRL_INDEX, 228, 613, 830, 922, 437, C19403g.CTRL_INDEX, 644, 905, 789, v2helper.EMethodSetPlayerPreCorrectCofOn, C31128d.MIC_PTU_QINGCHENG, JsApiQueryDownloadTask.CTRL_INDEX, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, 252, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, C31128d.MIC_PTU_DANNAI, 756, 665, 397, 808, 851, C31128d.MIC_PTU_MUSE, 473, 795, 378, 31, 647, 915, 459, 806, C45628v.CTRL_INDEX, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY, 425, 216, 548, 249, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 881, 699, C45616h.CTRL_INDEX, 673, 782, 210, 815, 905, 303, 843, 922, C31128d.MIC_PTU_TRANS_KONGCHENG, 73, C33244g.CTRL_INDEX, 791, 660, ErrorCode.STARTDOWNLOAD_3, C27084e.CTRL_INDEX, 308, 155, v2helper.EMethodOutputVolumeGainEnable, 907, 817, 187, 62, 16, 425, C45616h.CTRL_INDEX, 336, 286, 437, 375, 273, 610, C31128d.MIC_PTU_YINGTAOBUDING, 183, 923, 116, 667, TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, C38361e.CTRL_INDEX, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 5, 39, 923, C31128d.MIC_PTU_HONGKONG, v2helper.EMethodSetSpkEnhance, 242, 749, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 54, 669, C19523a.CTRL_INDEX, C2262b.CTRL_INDEX, 299, C27067l.CTRL_INDEX, 105, 667, C27059f.CTRL_INDEX, 640, 672, 576, 540, C19523a.CTRL_INDEX, 486, 721, 610, 46, 656, 447, ErrorCode.NEEDDOWNLOAD_FALSE_1, C45580bd.CTRL_INDEX, C19480k.CTRL_INDEX, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 531, 297, ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, 762, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, C42523ac.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_5, C19392d.CTRL_INDEX, 14, 381, v2helper.EMethodSetSendToNetworkOff, 717, 45, 111, 20, C42478j.CTRL_INDEX, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, ErrorCode.STARTDOWNLOAD_5, 332, 899, ErrorCode.STARTDOWNLOAD_6, 726, 600, ErrorCode.THROWABLE_INITX5CORE, C27084e.CTRL_INDEX, 655, 357, TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, 768, 223, 849, 647, 63, C31128d.MIC_PTU_DANNAI, 863, 251, 366, 304, C31128d.MIC_PTU_BAIXI, 738, 675, 410, C42528t.CTRL_INDEX, 244, 31, 121, 303, C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION}};

    /* renamed from: fG */
    static int m15553fG(int i) {
        AppMethodBeat.m2504i(57233);
        if (i < 0 || i > 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error correction level must be between 0 and 8!");
            AppMethodBeat.m2505o(57233);
            throw illegalArgumentException;
        }
        int i2 = 1 << (i + 1);
        AppMethodBeat.m2505o(57233);
        return i2;
    }

    /* renamed from: e */
    static String m15552e(CharSequence charSequence, int i) {
        int i2;
        AppMethodBeat.m2504i(57234);
        int fG = C8735f.m15553fG(i);
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
        AppMethodBeat.m2505o(57234);
        return stringBuilder2;
    }
}

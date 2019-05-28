package com.tencent.p177mm.protocal;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19281ab;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19283ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19285af;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27141z;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33246ax;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45573as;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C33253d;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.C19365c;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2278j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33325s;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C42520m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C19407x;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C2298d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42521aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42529z;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C38339e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p897a.C38251e;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42571f;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C10557i;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C10559j;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C2352h;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C46894f;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C19523a;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C38405e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.C31128d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.protocal.c */
public final class C15045c {
    private static Map<String, C15081g> vxd = null;

    /* renamed from: com.tencent.mm.protocal.c$ac */
    public static class C4788ac extends C15081g {
        public C4788ac() {
            super(C19285af.NAME, C19285af.NAME, C31128d.MIC_PTU_YOUJIALI, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ad */
    static final class C4789ad extends C15081g {
        C4789ad() {
            super(JsApiChooseMedia.NAME, JsApiChooseMedia.NAME, C31128d.MIC_PTU_ZIPAI_LIGHTRED, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ae */
    public static class C4790ae extends C15081g {
        public C4790ae() {
            super(JsApiChooseVideo.NAME, JsApiChooseVideo.NAME, 191, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bh */
    public static class C4791bh extends C15081g {
        public C4791bh() {
            super("enterEnterpriseChat", "enterEnterpriseChat", 223, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bi */
    static final class C4792bi extends C15081g {
        C4792bi() {
            super("requestWxFacePictureVerify", "requestWxFacePictureVerify", C31128d.MIC_PTU_ZIPAI_MEDSEA, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bq */
    static final class C4793bq extends C15081g {
        C4793bq() {
            super(JsApiGetBackgroundAudioState.NAME, JsApiGetBackgroundAudioState.NAME, C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cr */
    public static class C4794cr extends C15081g {
        public C4794cr() {
            super("getSearchEmotionData", "getSearchEmotionData", C1625i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cu */
    public static class C4795cu extends C15081g {
        public C4795cu() {
            super("getSearchImageList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cv */
    public static class C4796cv extends C15081g {
        public C4796cv() {
            super("getSearchSnsImageList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ea */
    public static class C4797ea extends C15081g {
        public C4797ea() {
            super("kvReport", "kvReport", ErrorCode.NEEDDOWNLOAD_TRUE, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$eb */
    public static class C4798eb extends C15081g {
        public C4798eb() {
            super("launch3rdApp", "launch_3rdApp", 52, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ff */
    public static class C4799ff extends C15081g {
        public C4799ff() {
            super("openEnterpriseChat", "openEnterpriseChat", ErrorCode.STARTDOWNLOAD_6, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fn */
    static final class C4800fn extends C15081g {
        C4800fn() {
            super("openLuckyMoneyHistory", "openLuckyMoneyHistory", C31128d.MIC_PTU_ZIPAI_SAPPORO, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gp */
    static final class C4801gp extends C15081g {
        public C4801gp() {
            super("preloadMiniProgramContacts", "preloadMiniProgramContacts", 303, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gr */
    public static class C4802gr extends C15081g {
        public C4802gr() {
            super("preloadSearchWeapp", "preloadSearchWeapp", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gs */
    static final class C4803gs extends C15081g {
        C4803gs() {
            super("previewVideo", "previewVideo", 252, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jb */
    static final class C4804jb extends C15081g {
        C4804jb() {
            super("shareEmoticon", "shareEmoticon", C31128d.MIC_GPU_AUTOLEVEL, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jc */
    public static class C4805jc extends C15081g {
        public C4805jc() {
            super("shareQQ", "shareQQ", 90, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jk */
    public static class C4806jk extends C15081g {
        public C4806jk() {
            super("showOptionMenu", "", 14, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$km */
    static final class C4807km extends C15081g {
        C4807km() {
            super("updateAppMessageShareData", "updateAppMessageShareData", ErrorCode.TEST_THROWABLE_IS_NULL, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ko */
    static final class C4808ko extends C15081g {
        C4808ko() {
            super("updateTimelineShareData", "updateTimelineShareData", ErrorCode.TEST_THROWABLE_ISNOT_NULL, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kp */
    public static class C4809kp extends C15081g {
        public C4809kp() {
            super(C10559j.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ly */
    public static class C4810ly extends C15081g {
        public C4810ly() {
            super("menu:share:qq", "", 94, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lz */
    public static class C4811lz extends C15081g {
        public C4811lz() {
            super("menu:share:QZone", "", C19392d.CTRL_INDEX, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$v */
    public static class C4812v extends C15081g {
        public C4812v() {
            super("changePayActivityView", "change_pay_activity_view", 207, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$x */
    public static class C4813x extends C15081g {
        public C4813x() {
            super("checkJsApi", "checkJsApi", 84, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$af */
    public static class C14994af extends C15081g {
        public C14994af() {
            super("clearBounceBackground", "clearBounceBackground", 189, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$al */
    static final class C14995al extends C15081g {
        C14995al() {
            super("closeWindowAndGoNext", "closeWindowAndGoNext", 293, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ao */
    static final class C14996ao extends C15081g {
        C14996ao() {
            super("confirmDialog", "confirmDialog", C33325s.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bf */
    public static class C14997bf extends C15081g {
        public C14997bf() {
            super("enableFullScreen", "enableFullScreen", 196, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bg */
    public static class C14998bg extends C15081g {
        public C14998bg() {
            super("enablePullDownRefresh", "enablePullDownRefresh", 199, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bo */
    static final class C14999bo extends C15081g {
        C14999bo() {
            super("recordHistory", "recordHistory", 219, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bp */
    public static class C15000bp extends C15081g {
        public C15000bp() {
            super("geoLocation", "geo_location", 57, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$br */
    public static class C15001br extends C15081g {
        public C15001br() {
            super("getBrandWCPayBindCardRequest", "get_brand_WCPay_bind_card_request", 58, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$by */
    public static class C15002by extends C15081g {
        public C15002by() {
            super("getGameCommInfo", "getGameCommInfo", C31128d.MIC_PTU_QINGCONG, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cj */
    public static class C15003cj extends C15081g {
        public C15003cj() {
            super("getOpenDeviceId", "getOpenDeviceId", 227, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cl */
    public static class C15004cl extends C15081g {
        public C15004cl() {
            super("getLatestAddress", "get_recently_used_address", 46, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$d */
    public static class C15005d extends C15081g {
        public C15005d() {
            super("openEmotionDetailViewLocal", "openEmotionDetailViewLocal", C1625i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dv */
    static final class C15006dv extends C15081g {
        C15006dv() {
            super("jumpDownloaderWidget", "jumpDownloaderWidget", 339, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dx */
    public static class C15007dx extends C15081g {
        public C15007dx() {
            super("jumpToBizProfile", "jump_to_biz_profile", 61, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dy */
    public static class C15008dy extends C15081g {
        public C15008dy() {
            super("jumpWCMall", "jump_wcmall", 51, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ec */
    public static class C15009ec extends C15081g {
        public C15009ec() {
            super("launchApp", "", 27, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ei */
    static final class C15010ei extends C15081g {
        C15010ei() {
            super(C45573as.NAME, C45573as.NAME, Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$el */
    public static class C15011el extends C15081g {
        public C15011el() {
            super(C2278j.NAME, "open_location", 63, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$f */
    public static class C15012f extends C15081g {
        public C15012f() {
            super("scanCover", "scanCover", C19395n.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fc */
    public static class C15013fc extends C15081g {
        public C15013fc() {
            super("openDesignerProfileLocal", "openDesignerProfileLocal", C1625i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fd */
    static final class C15014fd extends C15081g {
        C15014fd() {
            super("openECard", "openECard", C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fe */
    public static class C15015fe extends C15081g {
        public C15015fe() {
            super("openEmoticonTopicList", "openEmoticonTopicList", 212, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fl */
    static final class C15016fl extends C15081g {
        C15016fl() {
            super("openGameWebView", "openGameWebView", C31128d.MIC_PTU_SHUILIAN, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fm */
    public static class C15017fm extends C15081g {
        public C15017fm() {
            super("openLuckyMoneyDetailView", "openLuckyMoneyDetailView", C31128d.MIC_PTU_ZIPAI_LIGHTWHITE, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fo */
    public static class C15018fo extends C15081g {
        public C15018fo() {
            super("openMapNavigateMenu", "openMapNavigateMenu", FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fv */
    static final class C15019fv extends C15081g {
        C15019fv() {
            super("openSearchWAWidgetLogView", "openSearchWAWidgetLogView", Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gg */
    public static class C15020gg extends C15081g {
        public C15020gg() {
            super("openWXDeviceLib", "openWXDeviceLib", C31128d.MIC_ALPHA_ADJUST_REAL, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gi */
    static final class C15021gi extends C15081g {
        C15021gi() {
            super(JsApiOperateBackgroundAudio.NAME, JsApiOperateBackgroundAudio.NAME, C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$go */
    public static class C15022go extends C15081g {
        public C15022go() {
            super(JsApiStartPlayVoice.NAME, JsApiStartPlayVoice.NAME, 99, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hc */
    public static class C15023hc extends C15081g {
        public C15023hc() {
            super("removeSearchWAWidgetView", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hu */
    public static class C15024hu extends C15081g {
        public C15024hu() {
            super(C42520m.NAME, "", ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hv */
    static final class C15025hv extends C15081g {
        C15025hv() {
            super("selectContact", "selectContact", Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$if */
    public static class C15026if extends C15081g {
        public C15026if() {
            super("sendEmail", "send_email", 35, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ii */
    static final class C15027ii extends C15081g {
        C15027ii() {
            super("serviceClick", "serviceClick", 304, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ja */
    public static class C15028ja extends C15081g {
        public C15028ja() {
            super("setStatusBarStyle", "setStatusBarStyle", 206, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ji */
    public static class C15029ji extends C15081g {
        public C15029ji() {
            super("showMenuItems", "showMenuItems", 86, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jj */
    public static class C15030jj extends C15081g {
        public C15030jj() {
            super(C19407x.NAME, C19407x.NAME, 197, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jl */
    public static class C15031jl extends C15081g {
        public C15031jl() {
            super("showSearchActionSheet", "showSearchActionSheet", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$js */
    public static class C15032js extends C15081g {
        public C15032js() {
            super("startMonitoringBeacons", "startMonitoringBeacons", 151, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ju */
    public static class C15033ju extends C15081g {
        public C15033ju() {
            super(JsApiStartRecordVoice.NAME, JsApiStartRecordVoice.NAME, 96, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kd */
    public static class C15034kd extends C15081g {
        public C15034kd() {
            super(JsApiStopPlayVoice.NAME, JsApiStopPlayVoice.NAME, 101, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kf */
    public static class C15035kf extends C15081g {
        public C15035kf() {
            super("selectWalletCurrency", "selectWalletCurrency", 201, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kl */
    public static class C15036kl extends C15081g {
        public C15036kl() {
            super("updateReddotTimeStamps", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kx */
    public static class C15037kx extends C15081g {
        public C15037kx() {
            super("verifyWCPayPassword", "verifyWCPayPassword", 115, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lr */
    static final class C15038lr extends C15081g {
        C15038lr() {
            super("getCCData", "getCCData", 312, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ls */
    static final class C15039ls extends C15081g {
        C15039ls() {
            super(C38251e.NAME, C38251e.NAME, 314, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$mc */
    public static class C15040mc extends C15081g {
        public C15040mc() {
            super("openWebSearchOutLinkItem", "", 320, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$o */
    static final class C15041o extends C15081g {
        C15041o() {
            super("authorize", "authorize", 232, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$p */
    public static class C15042p extends C15081g {
        public C15042p() {
            super("batchAddCard", "batch_add_card", 82, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$w */
    static final class C15043w extends C15081g {
        C15043w() {
            super("checkIsSupportFaceDetect", "checkIsSupportFaceDetect", C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$y */
    public static class C15044y extends C15081g {
        public C15044y() {
            super("chooseCard", "choose_card", 70, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$at */
    static final class C15046at extends C15081g {
        public C15046at() {
            super("currentMpInfo", "currentMpInfo", C19281ab.CTRL_INDEX, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$aw */
    public static class C15047aw extends C15081g {
        public C15047aw() {
            super("disableBounceScroll", "disableBounceScroll", 188, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ca */
    public static class C15048ca extends C15081g {
        public C15048ca() {
            super("getHeadingAndPitch", "get_heading_and_pitch", 33, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cb */
    public static class C15049cb extends C15081g {
        public C15049cb() {
            super("getH5PrepayRequest", "getH5PrepayRequest", 137, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cc */
    public static class C15050cc extends C15081g {
        public C15050cc() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cs */
    public static class C15051cs extends C15081g {
        public C15051cs() {
            super("getSearchGuideData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$df */
    public static class C15052df extends C15081g {
        public C15052df() {
            super("getWXDeviceInfos", "getWXDeviceInfos", C31128d.MIC_AVROUND_BLUR, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dh */
    static final class C15053dh extends C15081g {
        C15053dh() {
            super("handleHaokanAction", "handleHaokanAction", 335, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dm */
    public static class C15054dm extends C15081g {
        public C15054dm() {
            super("hideOptionMenu", "", 14, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$do */
    public static class C15055do extends C15081g {
        public C15055do() {
            super("idCardRealnameVerify", "idCardRealnameVerify", C31128d.MIC_PTU_AUTOLEVEL, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dp */
    public static class C15056dp extends C15081g {
        public C15056dp() {
            super("imagePreview", "", 1, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dq */
    public static class C15057dq extends C15081g {
        public C15057dq() {
            super("insertSearchWAWidgetView", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$eq */
    public static class C15058eq extends C15081g {
        public C15058eq() {
            super("nfcGetId", "nfcGetId", ErrorCode.NEEDDOWNLOAD_4, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$et */
    public static class C15059et extends C15081g {
        public C15059et() {
            super("nfcTransceive", "nfcTransceive", 141, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fx */
    public static class C15060fx extends C15081g {
        public C15060fx() {
            super("openSecurityView", "openSecurityView", 229, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gy */
    public static class C15061gy extends C15081g {
        public C15061gy() {
            super("quicklyAddBrandContact", "quicklyAddBrandContact", 166, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$he */
    public static class C15062he extends C15081g {
        public C15062he() {
            super("reportActionInfo", "reportActionInfo", C31128d.MIC_PTU_FENGJING, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hj */
    public static class C15063hj extends C15081g {
        public C15063hj() {
            super("reportSearchRealTimeStatistics", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hl */
    static final class C15064hl extends C15081g {
        C15064hl() {
            super(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hm */
    static final class C15065hm extends C15081g {
        C15065hm() {
            super("requestWxFaceRegisterInternal", "requestWxFaceRegisterInternal", 272, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hn */
    static final class C15066hn extends C15081g {
        C15066hn() {
            super("requestWxFaceVerifyInternal", "requestWxFaceVerifyInternal", 273, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hs */
    public static class C15067hs extends C15081g {
        public C15067hs() {
            super("scanQRCode", "scanQRCode", 7, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$in */
    static final class C15068in extends C15081g {
        C15068in() {
            super("setGameData", "setGameData", 298, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$io */
    public static class C15069io extends C15081g {
        public C15069io() {
            super("setFontSizeCallback", "", -2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$iq */
    public static class C15070iq extends C15081g {
        public C15070iq() {
            super("setGameDebugConfig", "setGameDebugConfig", 1111111, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$iw */
    static final class C15071iw extends C15081g {
        C15071iw() {
            super("setScreenOrientation", "setScreenOrientation", 270, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jz */
    public static class C15072jz extends C15081g {
        public C15072jz() {
            super("stopMonitoringBeacons", "stopMonitoringBeacons", 152, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kv */
    public static class C15073kv extends C15081g {
        public C15073kv() {
            super("uploadVoice", "uploadVoice", 102, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lb */
    public static class C15074lb extends C15081g {
        public C15074lb() {
            super("videoProxyInit", "videoProxyInit", 156, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lg */
    public static class C15075lg extends C15081g {
        public C15075lg() {
            super("publicCache", "publicCache", 149, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$li */
    public static class C15076li extends C15081g {
        public C15076li() {
            super("shareWeibo", "share_weibo", 3, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lj */
    public static class C15077lj extends C15081g {
        public C15077lj() {
            super("reportWeAppSearchRealtime", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lk */
    public static class C15078lk extends C15081g {
        public C15078lk() {
            super("WNNativeAsyncCallback", "WNNativeAsyncCallback", 10006, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lp */
    public static class C15079lp extends C15081g {
        public C15079lp() {
            super(JsApiWriteCommData.NAME, "write_comm_data", 53, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$m */
    static final class C15080m extends C15081g {
        C15080m() {
            super("addToEmoticon", "addToEmoticon", 274, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$g */
    public static abstract class C15081g {
        protected String NAME = "noName";
        protected String vxe = "";
        protected int vxf = -1;
        protected boolean vxg = false;

        public C15081g(String str, String str2, int i, boolean z) {
            this.NAME = str;
            this.vxe = str2;
            this.vxf = i;
            this.vxg = z;
        }

        public final String getName() {
            return this.NAME;
        }

        public final String dma() {
            return this.vxe;
        }

        public final int dmb() {
            return this.vxf;
        }

        public final boolean dmc() {
            return this.vxg;
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$me */
    public static final class C15082me {
        public static Set<String> vxh;
    }

    /* renamed from: com.tencent.mm.protocal.c$ak */
    public static class C15083ak extends C15081g {
        public C15083ak() {
            super("closeWindow", "close_window", 17, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$am */
    public static class C15084am extends C15081g {
        public C15084am() {
            super("closeWXDeviceLib", "closeWXDeviceLib", 118, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$an */
    public static class C15085an extends C15081g {
        public C15085an() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$au */
    public static class C15086au extends C15081g {
        public C15086au() {
            super("deleteAccountSuccess", "deleteAccountSuccess", 144, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$av */
    public static class C15087av extends C15081g {
        public C15087av() {
            super("deleteSearchHistory", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ba */
    public static class C15088ba extends C15081g {
        public C15088ba() {
            super("downloadVoice", "downloadVoice", 103, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bj */
    static final class C15089bj extends C15081g {
        C15089bj() {
            super("requestWxFacePictureVerifyUnionVideo", "requestWxFacePictureVerifyUnionVideo", C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bx */
    public static class C15090bx extends C15081g {
        public C15090bx() {
            super("getEnterpriseChat", "getEnterpriseChat", 244, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bz */
    public static class C15091bz extends C15081g {
        public C15091bz() {
            super("getPoiInfo", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ck */
    public static class C15092ck extends C15081g {
        public C15092ck() {
            super("getPaymentOrderRequest", "getPaymentOrderRequest", 116, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cm */
    static final class C15093cm extends C15081g {
        C15093cm() {
            super("doGoToRecVideoList", "doGoToRecVideoList", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ct */
    public static class C15094ct extends C15081g {
        public C15094ct() {
            super("getSearchHistory", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dg */
    public static class C15095dg extends C15081g {
        public C15095dg() {
            super("getWXDeviceTicket", "getWXDeviceTicket", 125, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dw */
    public static class C15096dw extends C15081g {
        public C15096dw() {
            super("jumpToInstallUrl", "", 26, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$e */
    public static class C15097e extends C15081g {
        public C15097e() {
            super("getRecevieBizHongBaoRequest", "getRecevieBizHongBaoRequest", C44697b.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$eh */
    static final class C15098eh extends C15081g {
        C15098eh() {
            super("login", "login", 231, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ej */
    public static class C15099ej extends C15081g {
        public C15099ej() {
            super("musicPlay", "playMusic", 69, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ek */
    public static class C15100ek extends C15081g {
        public C15100ek() {
            super("timelineCheckIn", "timeline_check_in", 64, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$er */
    public static class C15101er extends C15081g {
        public C15101er() {
            super("nfcGetInfo", "nfcGetInfo", 148, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$es */
    public static class C15102es extends C15081g {
        public C15102es() {
            super("nfcIsConnect", "nfcIsConnect", C33333a.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ez */
    public static class C15103ez extends C15081g {
        public C15103ez() {
            super("openDesignerEmojiView", "openDesignerEmojiView", 185, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fg */
    public static class C15104fg extends C15081g {
        public C15104fg() {
            super("openEnterpriseContact", "openEnterpriseContact", 183, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ft */
    public static class C15105ft extends C15081g {
        public C15105ft() {
            super("openProductViewWithPid", "open_product_view", 60, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fu */
    static final class C15106fu extends C15081g {
        C15106fu() {
            super("openSearchCanvas", "openSearchCanvas", 283, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fw */
    static final class C15107fw extends C15081g {
        C15107fw() {
            super("openSearchWebView", "openSearchWebView", Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ga */
    public static class C15108ga extends C15081g {
        public C15108ga() {
            super("openUrlWithExtraWebview", "openUrlWithExtraWebview", ErrorCode.NEEDDOWNLOAD_FALSE_3, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gh */
    static final class C15109gh extends C15081g {
        C15109gh() {
            super("openWXSearchPage", "openWXSearchPage", C31128d.MIC_PTU_MUSE, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gj */
    public static class C15110gj extends C15081g {
        public C15110gj() {
            super("operateGameCenterMsg", "operateGameCenterMsg", ErrorCode.NEEDDOWNLOAD_FALSE_4, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gx */
    public static class C15111gx extends C15081g {
        public C15111gx() {
            super(JsApiQueryDownloadTask.NAME, "query_download_task", 40, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hb */
    public static class C15112hb extends C15081g {
        public C15112hb() {
            super("reloadSearchWAWidgetData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hd */
    public static class C15113hd extends C15081g {
        public C15113hd() {
            super(C10557i.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hk */
    public static class C15114hk extends C15081g {
        public C15114hk() {
            super("reportSearchStatistics", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ht */
    public static class C15115ht extends C15081g {
        public C15115ht() {
            super("searchDataHasResult", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ie */
    static final class C15116ie extends C15081g {
        C15116ie() {
            super("menuitem:gameSendDesktop", "menuitem:gameSendDesktop", 255, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ig */
    public static class C15117ig extends C15081g {
        public C15117ig() {
            super("sendServiceAppMessage", "send_service_app_msg", 67, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ih */
    static final class C15118ih extends C15081g {
        C15118ih() {
            super("sendSingleAppMessage", "sendSingleAppMessage", C19523a.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ip */
    public static class C15119ip extends C15081g {
        public C15119ip() {
            super("setFreeWifiOwner", "setFreeWifiOwner", 169, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ix */
    public static class C15120ix extends C15081g {
        public C15120ix() {
            super("setSearchInputWord", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$iy */
    public static class C15121iy extends C15081g {
        public C15121iy() {
            super("setSendDataDirection", "setSendDataDirection", C31128d.MIC_SketchMark, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$iz */
    public static class C15122iz extends C15081g {
        public C15122iz() {
            super("setSnsObjectXmlDescList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jq */
    public static class C15123jq extends C15081g {
        public C15123jq() {
            super("requireSoterBiometricAuthentication", "soter_biometric_authentication", 214, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jr */
    public static class C15124jr extends C15081g {
        public C15124jr() {
            super("getSupportSoter", "getSupportSoter", 213, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jt */
    public static class C15125jt extends C15081g {
        public C15125jt() {
            super(C42529z.NAME, C42529z.NAME, 204, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ke */
    public static class C15126ke extends C15081g {
        public C15126ke() {
            super("streamingVideoPlay", "playStreamingVideo", 209, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kg */
    static final class C15127kg extends C15081g {
        C15127kg() {
            super("tapSearchWAWidgetView", "tapSearchWAWidgetView", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ku */
    public static class C15128ku extends C15081g {
        public C15128ku() {
            super("uploadVideo", "uploadVideo", C33250az.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$la */
    public static class C15129la extends C15081g {
        public C15129la() {
            super("cache", "cache", 150, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lh */
    public static class C15130lh extends C15081g {
        public C15130lh() {
            super("videoProxyPreload", "videoProxyPreload", ErrorCode.NEEDDOWNLOAD_FALSE_2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lq */
    static final class C15131lq extends C15081g {
        C15131lq() {
            super("calRqt", "calRqt", ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$mb */
    public static class C15132mb extends C15081g {
        public C15132mb() {
            super("menu:share:weiboApp", "", 109, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$md */
    public static class C15133md extends C15081g {
        public C15133md() {
            super("uploadIdCardSuccess", "uploadIdCardSuccess", C31128d.MIC_PTU_MEISHI, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$n */
    public static class C15134n extends C15081g {
        public C15134n() {
            super(C27141z.NAME, "ad_data_report", 221, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ag */
    static final class C15135ag extends C15081g {
        C15135ag() {
            super("clearGameData", "clearGameData", 300, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bl */
    static final class C15136bl extends C15081g {
        C15136bl() {
            super("forceUpdateWxaAttr", "forceUpdateWxaAttr", C31128d.MIC_PTU_ZIPAI_TOKYO, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bm */
    public static class C15137bm extends C15081g {
        public C15137bm() {
            super("openEmotionPage", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bn */
    static final class C15138bn extends C15081g {
        C15138bn() {
            super(C19365c.NAME, C19365c.NAME, 338, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cd */
    public static class C15139cd extends C15081g {
        public C15139cd() {
            super(JsApiGetInstallState.NAME, "get_install_state", 25, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cq */
    public static class C15140cq extends C15081g {
        public C15140cq() {
            super("getSearchDisplayNameList", "getSearchDisplayNameList", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cw */
    public static class C15141cw extends C15081g {
        public C15141cw() {
            super("getSearchSuggestionData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cx */
    public static class C15142cx extends C15081g {
        public C15142cx() {
            super("getSendC2CMessageRequest", "get_send_c2c_message_request", 83, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cy */
    static final class C15143cy extends C15081g {
        C15143cy() {
            super("getSystemInfo", "getSystemInfo", C31128d.MIC_PTU_HONGKONG, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cz */
    public static class C15144cz extends C15081g {
        public C15144cz() {
            super("getTeachSearchData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$de */
    public static class C15145de extends C15081g {
        public C15145de() {
            super("getWidgetCaptureImgUrl", "add_contact", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dn */
    public static class C15146dn extends C15081g {
        public C15146dn() {
            super("hideSearchLoading", "hideSearchLoading", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dz */
    public static class C15147dz extends C15081g {
        public C15147dz() {
            super("jumpToWXWallet", "jumpToWXWallet", ErrorCode.NEEDDOWNLOAD_8, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ed */
    static final class C15148ed extends C15081g {
        C15148ed() {
            super("launchApplication", "launchApplication", C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fi */
    public static class C15149fi extends C15081g {
        public C15149fi() {
            super("openGameDetail", "openGameDetail", 131, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fj */
    public static class C15150fj extends C15081g {
        public C15150fj() {
            super("openGameRegion", "openGameRegion", 242, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fk */
    static final class C15151fk extends C15081g {
        C15151fk() {
            super("openGameUrlWithExtraWebView", "openGameUrlWithExtraWebView", 297, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gn */
    public static class C15152gn extends C15081g {
        public C15152gn() {
            super(JsApiPausePlayVoice.NAME, JsApiPausePlayVoice.NAME, 100, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gq */
    static final class C15153gq extends C15081g {
        C15153gq() {
            super("preloadMiniProgramEnv", "preloadMiniProgramEnv", 302, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gt */
    public static class C15154gt extends C15081g {
        public C15154gt() {
            super("preVerifyJSAPI", "pre_verify_jsapi", -3, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gu */
    static final class C15155gu extends C15081g {
        C15155gu() {
            super("privateCommonApi", "privateCommonApi", ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gw */
    public static class C15156gw extends C15081g {
        public C15156gw() {
            super(Scopes.PROFILE, Scopes.PROFILE, 2, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gz */
    public static class C15157gz extends C15081g {
        public C15157gz() {
            super("realtimeReport", "realtimeReport", ErrorCode.NEEDDOWNLOAD_FALSE_1, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hw */
    public static class C15158hw extends C15081g {
        public C15158hw() {
            super("selectEnterpriseContact", "selectEnterpriseContact", 286, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hx */
    public static class C15159hx extends C15081g {
        public C15159hx() {
            super("selectPedometerSource", "selectPedometerSource", 146, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hy */
    public static class C15160hy extends C15081g {
        public C15160hy() {
            super("selectSingleContact", "selectSingleContact", ErrorCode.STARTDOWNLOAD_8, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ia */
    public static class C15161ia extends C15081g {
        public C15161ia() {
            super("sendAppMessage", "send_app_msg", 6, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ib */
    static final class C15162ib extends C15081g {
        public C15162ib() {
            super("sendDataToMiniProgram", "sendDataToMiniProgram", ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jd */
    public static class C15163jd extends C15081g {
        public C15163jd() {
            super("shareQZone", "shareQZone", 132, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jf */
    public static class C15164jf extends C15081g {
        public C15164jf() {
            super("showAllNonBaseMenuItem", "showAllNonBaseMenuItem", 92, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jg */
    public static class C15165jg extends C15081g {
        public C15165jg() {
            super(C38339e.NAME, C38339e.NAME, C31128d.MIC_PTU_ZIPAI_THURSDAY, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jh */
    public static class C15166jh extends C15081g {
        public C15166jh() {
            super("showKeyboard", "showKeyboard", 187, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kj */
    public static class C15167kj extends C15081g {
        public C15167kj() {
            super("unbindBankCard", "unbindBankCard", 216, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kk */
    static final class C15168kk extends C15081g {
        C15168kk() {
            super("updatePageAuth", "updatePageAuth", -2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kn */
    public static class C15169kn extends C15081g {
        public C15169kn() {
            super("updateSearchWAWidgetView", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kq */
    public static class C15170kq extends C15081g {
        public C15170kq() {
            super("updateWASearchTemplate", "updateWASearchTemplate", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kr */
    static final class C15171kr extends C15081g {
        C15171kr() {
            super("uploadEncryptMediaFile", "uploadEncryptMediaFile", C31128d.MIC_PTU_ZIPAI_OKINAWA, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ks */
    public static class C15172ks extends C15081g {
        public C15172ks() {
            super("uploadImage", "uploadImage", 105, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kt */
    public static class C15173kt extends C15081g {
        public C15173kt() {
            super("uploadMediaFile", "uploadMediaFile", C31128d.MIC_PTU_LENGMEIREN, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kw */
    public static class C15174kw extends C15081g {
        public C15174kw() {
            super("uxSearchOpLog", "uxSearchOpLog", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lu */
    public static class C15175lu extends C15081g {
        public C15175lu() {
            super("WNNativeCallbackOnBecomeEdited", "WNNativeCallbackOnBecomeEdited", 10006, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lv */
    public static class C15176lv extends C15081g {
        public C15176lv() {
            super("jumpWSRecVideoList", "", C16681c.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lw */
    public static class C15177lw extends C15081g {
        public C15177lw() {
            super("menu:setfont", "", GmsClientSupervisor.DEFAULT_BIND_FLAGS, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$r */
    public static class C15178r extends C15081g {
        public C15178r() {
            super("batchViewCard", "batchViewCard", 111, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$s */
    static final class C15179s extends C15081g {
        C15179s() {
            super("bindEmail", "bindEmail", 306, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$t */
    public static class C15180t extends C15081g {
        public C15180t() {
            super(JsApiCancelDownloadTask.NAME, "cancel_download_task", 39, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$u */
    public static class C15181u extends C15081g {
        public C15181u() {
            super("cancelSearchActionSheet", "cancelSearchActionSheet", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$aa */
    public static class C15182aa extends C15081g {
        public C15182aa() {
            super(JsApiChooseImage.NAME, JsApiChooseImage.NAME, 104, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ah */
    public static class C15183ah extends C15081g {
        public C15183ah() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$aj */
    public static class C15184aj extends C15081g {
        public C15184aj() {
            super("clickSnsMusicPlayButton", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$aq */
    public static class C15185aq extends C15081g {
        public C15185aq() {
            super("connectToWiFi", "connecttowifi", 71, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$as */
    public static class C15186as extends C15081g {
        public C15186as() {
            super("consumedShareCard", "consumedShareCard", ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$az */
    public static class C15187az extends C15081g {
        public C15187az() {
            super("downloadImage", "downloadImage", 106, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bb */
    public static class C15188bb extends C15081g {
        public C15188bb() {
            super("doExposePreparation", "doExposePreparation", 225, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bd */
    public static class C15189bd extends C15081g {
        public C15189bd() {
            super("editAddress", "edit_address", 29, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bt */
    public static class C15190bt extends C15081g {
        public C15190bt() {
            super("getCurrentSSID", "getCurrentSSID", ErrorCode.NEEDDOWNLOAD_FALSE_6, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bv */
    public static class C15191bv extends C15081g {
        public C15191bv() {
            super("mmsf0001", "mmsf0001", -2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bw */
    static final class C15192bw extends C15081g {
        C15192bw() {
            super("getDownloadWidgetTaskInfos", "getDownloadWidgetTaskInfos", 340, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ce */
    public static class C15193ce extends C15081g {
        public C15193ce() {
            super("getLocalData", "getLocalData", 179, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cn */
    public static class C15194cn extends C15081g {
        public C15194cn() {
            super("getRouteUrl", "getRouteUrl", C31128d.MIC_PTU_AUTOLEVEL, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cp */
    public static class C15195cp extends C15081g {
        public C15195cp() {
            super("getSearchData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$da */
    public static class C15196da extends C15081g {
        public C15196da() {
            super("getTransferMoneyRequest", "get_transfer_money_request", 74, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$db */
    public static class C15197db extends C15081g {
        public C15197db() {
            super("getWCPayRealnameVerify", "getWCPayRealnameVerify", JsApiUploadEncryptedFileToCDN.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dd */
    static final class C15198dd extends C15081g {
        C15198dd() {
            super("getWePkgAuthResult", "getWePkgAuthResult", -3, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dt */
    public static final class C15199dt extends C15081g {
        C15199dt() {
            super("internelWxFaceVerify", "internelWxFaceVerify", ErrorCode.THROWABLE_INITX5CORE, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ee */
    static final class C15200ee extends C15081g {
        C15200ee() {
            super(JsApiLaunchMiniProgram.NAME, JsApiLaunchMiniProgram.NAME, 277, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$eg */
    public static class C15201eg extends C15081g {
        public C15201eg() {
            super("log", "", 0, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$en */
    public static class C15202en extends C15081g {
        public C15202en() {
            super("nfcBatchTransceive", "nfcBatchTransceive", ErrorCode.NEEDDOWNLOAD_3, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ep */
    public static class C15203ep extends C15081g {
        public C15203ep() {
            super("nfcConnect", "nfcConnect", 140, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ew */
    static final class C15204ew extends C15081g {
        C15204ew() {
            super("openBizChat", "openBizChat", C31128d.MIC_PTU_YINGTAOBUDING, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fa */
    public static class C15205fa extends C15081g {
        public C15205fa() {
            super("openDesignerEmojiViewLocal", "openDesignerEmojiViewLocal", C1625i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fq */
    public static class C15206fq extends C15081g {
        public C15206fq() {
            super("openNewPage", "openNewPage", C1625i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fs */
    public static class C15207fs extends C15081g {
        public C15207fs() {
            super("openProductView", "open_product_view", 59, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gb */
    public static class C15208gb extends C15081g {
        public C15208gb() {
            super("openWCPaySpecificView", "open_wcpay_specific_view", 76, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gk */
    public static class C15209gk extends C15081g {
        public C15209gk() {
            super(C2352h.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gm */
    public static class C15210gm extends C15081g {
        public C15210gm() {
            super(JsApiPauseDownloadTask.NAME, "cancel_download_task", C31128d.MIC_PTU_SHISHANG2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gv */
    static final class C15211gv extends C15081g {
        C15211gv() {
            super("privateOpenWeappFunctionalPage", "privateOpenWeappFunctionalPage", 333, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$h */
    public static class C15212h extends C15081g {
        public C15212h() {
            super("addContact", "add_contact", 5, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ha */
    static final class C15213ha extends C15081g {
        C15213ha() {
            super("recordVideo", "recordVideo", 251, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hq */
    public static class C15214hq extends C15081g {
        public C15214hq() {
            super(JsApiResumeDownloadTask.NAME, "resume_download_task", 240, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hz */
    public static class C15215hz extends C15081g {
        public C15215hz() {
            super("sendAppMessageToSpecifiedContact", "sendAppMessageToSpecifiedContact", 168, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$i */
    public static class C15216i extends C15081g {
        public C15216i() {
            super("addCustomMenuItems", "addCustomMenuItems", ErrorCode.STARTDOWNLOAD_5, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ik */
    static final class C15217ik extends C15081g {
        C15217ik() {
            super(JsApiSetBackgroundAudioState.NAME, JsApiSetBackgroundAudioState.NAME, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$im */
    public static class C15218im extends C15081g {
        public C15218im() {
            super("setCloseWindowConfirmDialogInfo", "setCloseWindowConfirmDialogInfo", 77, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$it */
    public static class C15219it extends C15081g {
        public C15219it() {
            super(C27011o.NAME, C27011o.NAME, FaceMoveUtil.TRIANGLE_COUNT, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$je */
    public static class C15220je extends C15081g {
        public C15220je() {
            super("shareWeiboApp", "shareWeiboApp", 107, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jn */
    static final class C15221jn extends C15081g {
        C15221jn() {
            super("showSearchOfBizHistory", "showSearchOfBizHistory", C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jp */
    public static class C15222jp extends C15081g {
        public C15222jp() {
            super("showSmileyPanel", "showSmileyPanel", C31128d.MIC_PTU_SHIGUANG, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$k */
    public static class C15223k extends C15081g {
        public C15223k() {
            super(JsApiAddDownloadTaskStraight.NAME, "add_download_task_straight", 269, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kh */
    public static class C15224kh extends C15081g {
        public C15224kh() {
            super(C42571f.NAME, "share_timeline", 4, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kz */
    static final class C15225kz extends C15081g {
        C15225kz() {
            super("wcPrivacyPolicyResult", "wcPrivacyPolicyResult", C38405e.CTRL_INDEX, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ln */
    public static class C15226ln extends C15081g {
        public C15226ln() {
            super("WNNativeCallbackOnClick", "WNNativeCallbackOnClick", 10006, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lt */
    public static class C15227lt extends C15081g {
        public C15227lt() {
            super("WNNativeCallbackOnBecomeEditing", "WNNativeCallbackOnBecomeEditing", 10006, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$q */
    static final class C15228q extends C15081g {
        C15228q() {
            super("batchUpdateWepkg", "batchUpdateWepkg", 334, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$a */
    public static class C15229a extends C15081g {
        public C15229a() {
            super(JsApiGetMusicPlayerState.NAME, JsApiGetMusicPlayerState.NAME, 210, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ax */
    public static class C15230ax extends C15081g {
        public C15230ax() {
            super("disablePullDownRefresh", "disablePullDownRefresh", 205, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ay */
    public static class C15231ay extends C15081g {
        public C15231ay() {
            super("disconnectWXDevice", "disconnectWXDevice", 124, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$b */
    public static class C15232b extends C15081g {
        public C15232b() {
            super(JsApiOperateMusicPlayer.NAME, JsApiOperateMusicPlayer.NAME, 211, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bc */
    public static class C15233bc extends C15081g {
        public C15233bc() {
            super("doSearchOperation", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bk */
    static final class C15234bk extends C15081g {
        C15234bk() {
            super(C33253d.NAME, C33253d.NAME, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cf */
    static final class C15235cf extends C15081g {
        C15235cf() {
            super("getLocalWePkgInfo", "getLocalWePkgInfo", -2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$cg */
    static final class C15236cg extends C15081g {
        C15236cg() {
            super("getMatchContactList", "getMatchContactList", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ch */
    public static class C15237ch extends C15081g {
        public C15237ch() {
            super("getMsgProofItems", "getMsgProofItems", 226, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ci */
    public static class C15238ci extends C15081g {
        public C15238ci() {
            super(C16674d.NAME, "network_type", 16, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$di */
    static final class C15239di extends C15081g {
        C15239di() {
            super("handleWCPayWalletBuffer", "handleWCPayWalletBuffer", C31128d.MIC_PTU_WU, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dj */
    public static class C15240dj extends C15081g {
        public C15240dj() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dk */
    public static class C15241dk extends C15081g {
        public C15241dk() {
            super("hideMenuItems", "hideMenuItems", 85, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dl */
    public static class C15242dl extends C15081g {
        public C15242dl() {
            super(C2298d.NAME, C2298d.NAME, C27011o.CTRL_INDEX, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dr */
    public static class C15243dr extends C15081g {
        public C15243dr() {
            super(C46894f.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$eu */
    static final class C15244eu extends C15081g {
        C15244eu() {
            super("notifyPageInfo", "notifyPageInfo", -2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ev */
    static final class C15245ev extends C15081g {
        C15245ev() {
            super("openWCPayCardList", "openWCPayCardList", C31128d.MIC_PTU_DANNAI, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ey */
    static final class C15246ey extends C15081g {
        C15246ey() {
            super("openCustomWebview", "openCustomWebview", 256, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fh */
    public static class C15247fh extends C15081g {
        public C15247fh() {
            super("openGameCenter", "openGameCenter", ErrorCode.NEEDDOWNLOAD_FALSE_5, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fz */
    public static class C15248fz extends C15081g {
        public C15248fz() {
            super("openUrlByExtBrowser", "open_url_by_ext_browser", 55, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gc */
    public static final class C15249gc extends C15081g {
        C15249gc() {
            super("openWebViewUseFastLoad", "openWebViewUseFastLoad", 336, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gd */
    static final class C15250gd extends C15081g {
        C15250gd() {
            super("openWeApp", "openWeApp", 250, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ge */
    public static class C15251ge extends C15081g {
        public C15251ge() {
            super("openWeAppPage", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gf */
    public static class C15252gf extends C15081g {
        public C15252gf() {
            super("getBrandWCPayCreateCreditCardRequest", "get_wcpay_create_credit_card_request", 65, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hf */
    static final class C15253hf extends C15081g {
        C15253hf() {
            super("reportGamePageTime", "reportGamePageTime", 301, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hg */
    static final class C15254hg extends C15081g {
        C15254hg() {
            super("reportGameWeb", "reportGameWeb", 332, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hh */
    public static class C15255hh extends C15081g {
        public C15255hh() {
            super("reportIDKey", "reportIDKey", ErrorCode.STARTDOWNLOAD_4, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hi */
    static final class C15256hi extends C15081g {
        C15256hi() {
            super("reportMiniProgramPageData", "reportMiniProgramPageData", 284, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ho */
    static final class C15257ho extends C15081g {
        C15257ho() {
            super("requestWxVoicePrintVerifyInternal", "requestWxVoicePrintVerifyInternal", 292, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hr */
    public static class C15258hr extends C15081g {
        public C15258hr() {
            super("scanLicence", "scanLicence", 203, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$id */
    public static class C15259id extends C15081g {
        public C15259id() {
            super("sendEnterpriseChat", "sendEnterpriseChat", 222, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ir */
    public static class C15260ir extends C15081g {
        public C15260ir() {
            super("setLocalData", "setLocalData", 180, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$is */
    public static class C15261is extends C15081g {
        public C15261is() {
            super("setNavigationBarButtons", "setNavigationBarButtons", JsApiChooseWeChatContact.CTRL_INDEX, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$iv */
    public static class C15262iv extends C15081g {
        public C15262iv() {
            super("setPageTitle", "setPageTitle", 113, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jw */
    public static class C15263jw extends C15081g {
        public C15263jw() {
            super("startSearchItemDetailPage", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jx */
    public static class C15264jx extends C15081g {
        public C15264jx() {
            super("startTempSession", "startTempSession", 128, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jy */
    public static class C15265jy extends C15081g {
        public C15265jy() {
            super("startVoipCall", "startVoipCall", 230, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ka */
    public static class C15266ka extends C15081g {
        public C15266ka() {
            super(C42521aa.NAME, C42521aa.NAME, 200, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kb */
    public static class C15267kb extends C15081g {
        public C15267kb() {
            super(JsApiStopRecordVoice.NAME, JsApiStopRecordVoice.NAME, 98, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$kc */
    public static class C15268kc extends C15081g {
        public C15268kc() {
            super("stopScanWXDevice", "stopScanWXDevice", 122, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lc */
    public static class C15269lc extends C15081g {
        public C15269lc() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", JsApiGetBackgroundAudioState.CTRL_INDEX, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ld */
    public static class C15270ld extends C15081g {
        public C15270ld() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", 160, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$le */
    public static class C15271le extends C15081g {
        public C15271le() {
            super("videoProxyStartPlay", "videoProxyStartPlay", 157, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lf */
    public static class C15272lf extends C15081g {
        public C15272lf() {
            super("videoProxyStopPlay", "videoProxyStopPlay", 158, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ll */
    public static class C15273ll extends C15081g {
        public C15273ll() {
            super("WNNativeCallbackInitData", "WNNativeCallbackInitData", 10006, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lo */
    public static class C15274lo extends C15081g {
        public C15274lo() {
            super("WNNativeCallbackOnLongClick", "WNNativeCallbackOnLongClick", 10006, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ma */
    public static class C15275ma extends C15081g {
        public C15275ma() {
            super("menu:share:timeline", "", 88, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ab */
    public static class C15276ab extends C15081g {
        public C15276ab() {
            super(C19283ae.NAME, C19283ae.NAME, 202, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ai */
    public static class C15277ai extends C15081g {
        public C15277ai() {
            super("clearWebviewCache", "clearWebviewCache", 208, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ap */
    public static class C15278ap extends C15081g {
        public C15278ap() {
            super("connectToFreeWifi", "connectToFreeWifi", 95, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ar */
    public static class C15279ar extends C15081g {
        public C15279ar() {
            super("connectWXDevice", "connectWXDevice", 123, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$be */
    public static class C15280be extends C15081g {
        public C15280be() {
            super("openEmotionUrl", "openEmotionUrl", C1625i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bs */
    public static class C15281bs extends C15081g {
        public C15281bs() {
            super("getBrandWCPayRequest", "get_brand_wcpay_request", 28, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$bu */
    static final class C15282bu extends C15081g {
        C15282bu() {
            super("getGameData", "getGameData", 299, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$c */
    public static class C15283c extends C15081g {
        public C15283c() {
            super("getLocalImgData", "getLocalImgData", 249, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$co */
    public static class C15284co extends C15081g {
        public C15284co() {
            super("getSearchAvatarList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$dc */
    public static class C15285dc extends C15081g {
        public C15285dc() {
            super("getWechatVerifyTicket", "getWechatVerifyTicket", 112, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ds */
    public static class C15286ds extends C15081g {
        public C15286ds() {
            super(JsApiInstallDownloadTask.NAME, "install_download_task", 41, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$du */
    static final class C15287du extends C15081g {
        C15287du() {
            super("invokeMiniProgramAPI", "invokeMiniProgramAPI", 295, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ef */
    public static class C15288ef extends C15081g {
        public C15288ef() {
            super("getWebPayCheckoutCounterRequst", "getWebPayCheckoutCounterRequst", 161, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$em */
    public static class C15289em extends C15081g {
        public C15289em() {
            super("openTimelineCheckInList", "open_timeline_checkin_list", 62, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$eo */
    public static class C15290eo extends C15081g {
        public C15290eo() {
            super("nfcCheckState", "nfcCheckState", 155, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ex */
    static final class C15291ex extends C15081g {
        C15291ex() {
            super(JsApiOpenAdCanvas.NAME, JsApiOpenAdCanvas.NAME, 283, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fb */
    public static class C15292fb extends C15081g {
        public C15292fb() {
            super("openDesignerProfile", "openDesignerProfile", JsApiChooseMedia.CTRL_INDEX, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fp */
    public static class C15293fp extends C15081g {
        public C15293fp() {
            super("openMyDeviceProfile", "openMyDeviceProfile", 145, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fr */
    static final class C15294fr extends C15081g {
        C15294fr() {
            super(C33246ax.NAME, C33246ax.NAME, C31128d.MIC_PTU_QINGCHENG, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$fy */
    public static class C15295fy extends C15081g {
        public C15295fy() {
            super("openSpecificView", "specific_view", 48, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$gl */
    static final class C15296gl extends C15081g {
        C15296gl() {
            super("opVoteAdData", "", -2, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$hp */
    public static class C15297hp extends C15081g {
        public C15297hp() {
            super("resendRemittanceMsg", "resendRemittanceMsg", C31128d.MIC_PTU_ZIPAI_FAIRYTALE, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ic */
    public static class C15298ic extends C15081g {
        public C15298ic() {
            super("sendDataToWXDevice", "sendDataToWXDevice", 120, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ij */
    static final class C15299ij extends C15081g {
        C15299ij() {
            super("setWCPayPassword", "setWCPayPassword", C31128d.MIC_PTU_ZIRAN, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$il */
    public static class C15300il extends C15081g {
        public C15300il() {
            super("setBounceBackground", "setBounceBackground", 218, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$iu */
    public static class C15301iu extends C15081g {
        public C15301iu() {
            super("setPageOwner", "setPageOwner", 114, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$j */
    public static class C15302j extends C15081g {
        public C15302j() {
            super(JsApiAddDownloadTask.NAME, "add_download_task", 38, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jm */
    public static class C15303jm extends C15081g {
        public C15303jm() {
            super("showSearchLoading", "showSearchLoading", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jo */
    public static class C15304jo extends C15081g {
        public C15304jo() {
            super("showSearchToast", "showSearchToast", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$jv */
    public static class C15305jv extends C15081g {
        public C15305jv() {
            super("startScanWXDevice", "startScanWXDevice", 121, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ki */
    public static class C15306ki extends C15081g {
        public C15306ki() {
            super("translateVoice", "translateVoice", 97, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$ky */
    static final class C15307ky extends C15081g {
        C15307ky() {
            super("viewTypeChange", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$l */
    static final class C15308l extends C15081g {
        C15308l() {
            super("addGameDownloadTask", "addGameDownloadTask", -1, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lm */
    public static class C15309lm extends C15081g {
        public C15309lm() {
            super("WNNativeCallbackOnCaretChange", "WNNativeCallbackOnCaretChange", 10006, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$lx */
    public static class C15310lx extends C15081g {
        public C15310lx() {
            super("menu:share:appmessage", "", 89, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$z */
    public static class C15311z extends C15081g {
        public C15311z() {
            super("chooseIdCard", "chooseIdCard", 247, true);
        }
    }

    public static Bundle akC(String str) {
        AppMethodBeat.m2504i(79962);
        Bundle bundle = new Bundle();
        bundle.putBoolean("handle", true);
        bundle.putString("handle_result", str);
        AppMethodBeat.m2505o(79962);
        return bundle;
    }

    public static C15081g akD(String str) {
        AppMethodBeat.m2504i(79963);
        if (vxd == null || vxd.size() <= 0) {
            HashMap hashMap = new HashMap(128);
            vxd = hashMap;
            hashMap.put("log", new C15201eg());
            vxd.put("imagePreview", new C15056dp());
            vxd.put(Scopes.PROFILE, new C15156gw());
            vxd.put("shareWeibo", new C15076li());
            vxd.put(C42571f.NAME, new C15224kh());
            vxd.put(C27141z.NAME, new C15134n());
            vxd.put("streamingVideoPlay", new C15126ke());
            vxd.put("addContact", new C15212h());
            vxd.put("getWidgetCaptureImgUrl", new C15145de());
            vxd.put("sendAppMessage", new C15161ia());
            vxd.put("scanQRCode", new C15067hs());
            vxd.put("hideOptionMenu", new C15054dm());
            vxd.put("showOptionMenu", new C4806jk());
            vxd.put(C16674d.NAME, new C15238ci());
            vxd.put("closeWindow", new C15083ak());
            vxd.put(JsApiGetInstallState.NAME, new C15139cd());
            vxd.put("setFontSizeCallback", new C15069io());
            vxd.put("jumpToInstallUrl", new C15096dw());
            vxd.put("launchApp", new C15009ec());
            vxd.put("getBrandWCPayRequest", new C15281bs());
            vxd.put(C42520m.NAME, new C15024hu());
            vxd.put("editAddress", new C15189bd());
            vxd.put("getHeadingAndPitch", new C15048ca());
            vxd.put("sendEmail", new C15026if());
            vxd.put(JsApiAddDownloadTask.NAME, new C15302j());
            vxd.put(JsApiCancelDownloadTask.NAME, new C15180t());
            vxd.put(JsApiPauseDownloadTask.NAME, new C15210gm());
            vxd.put(JsApiResumeDownloadTask.NAME, new C15214hq());
            vxd.put(JsApiQueryDownloadTask.NAME, new C15111gx());
            vxd.put(JsApiInstallDownloadTask.NAME, new C15286ds());
            vxd.put("getLatestAddress", new C15004cl());
            vxd.put("openSpecificView", new C15295fy());
            vxd.put("jumpWCMall", new C15008dy());
            vxd.put("launch3rdApp", new C4798eb());
            vxd.put(JsApiWriteCommData.NAME, new C15079lp());
            vxd.put("openUrlByExtBrowser", new C15248fz());
            vxd.put("geoLocation", new C15000bp());
            vxd.put("getBrandWCPayBindCardRequest", new C15001br());
            vxd.put("openProductView", new C15207fs());
            vxd.put("openProductViewWithPid", new C15105ft());
            vxd.put("jumpToBizProfile", new C15007dx());
            vxd.put("openTimelineCheckInList", new C15289em());
            vxd.put(C2278j.NAME, new C15011el());
            vxd.put("timelineCheckIn", new C15100ek());
            vxd.put("getBrandWCPayCreateCreditCardRequest", new C15252gf());
            vxd.put("chooseCard", new C15044y());
            vxd.put(C19283ae.NAME, new C15276ab());
            vxd.put("sendServiceAppMessage", new C15117ig());
            vxd.put("musicPlay", new C15099ej());
            vxd.put("mmsf0001", new C15191bv());
            vxd.put("connectToWiFi", new C15185aq());
            vxd.put("getTransferMoneyRequest", new C15196da());
            vxd.put("openWCPaySpecificView", new C15208gb());
            vxd.put("setCloseWindowConfirmDialogInfo", new C15218im());
            vxd.put("batchAddCard", new C15042p());
            vxd.put("preVerifyJSAPI", new C15154gt());
            vxd.put(JsApiStartRecordVoice.NAME, new C15033ju());
            vxd.put(JsApiStopRecordVoice.NAME, new C15267kb());
            vxd.put(JsApiStartPlayVoice.NAME, new C15022go());
            vxd.put(JsApiPausePlayVoice.NAME, new C15152gn());
            vxd.put(JsApiStopPlayVoice.NAME, new C15034kd());
            vxd.put("uploadVoice", new C15073kv());
            vxd.put("downloadVoice", new C15088ba());
            vxd.put(JsApiChooseImage.NAME, new C15182aa());
            vxd.put("uploadImage", new C15172ks());
            vxd.put("downloadImage", new C15187az());
            vxd.put("uploadMediaFile", new C15173kt());
            vxd.put("hideMenuItems", new C15241dk());
            vxd.put("showMenuItems", new C15029ji());
            vxd.put("hideAllNonBaseMenuItem", new C15240dj());
            vxd.put("showAllNonBaseMenuItem", new C15164jf());
            vxd.put("checkJsApi", new C4813x());
            vxd.put("translateVoice", new C15306ki());
            vxd.put("shareQQ", new C4805jc());
            vxd.put("shareWeiboApp", new C15220je());
            vxd.put("shareQZone", new C15163jd());
            vxd.put("connectToFreeWifi", new C15278ap());
            vxd.put("getSendC2CMessageRequest", new C15142cx());
            vxd.put("batchViewCard", new C15178r());
            vxd.put("configWXDeviceWiFi", new C15085an());
            vxd.put("getCurrentSSID", new C15190bt());
            vxd.put("setPageOwner", new C15301iu());
            vxd.put("getWechatVerifyTicket", new C15285dc());
            vxd.put("openWXDeviceLib", new C15020gg());
            vxd.put("startScanWXDevice", new C15305jv());
            vxd.put("stopScanWXDevice", new C15268kc());
            vxd.put("connectWXDevice", new C15279ar());
            vxd.put("disconnectWXDevice", new C15231ay());
            vxd.put("getWXDeviceTicket", new C15095dg());
            vxd.put("getWXDeviceInfos", new C15052df());
            vxd.put("sendDataToWXDevice", new C15298ic());
            vxd.put("closeWXDeviceLib", new C15084am());
            vxd.put("setSendDataDirection", new C15121iy());
            vxd.put("verifyWCPayPassword", new C15037kx());
            vxd.put("getPaymentOrderRequest", new C15092ck());
            vxd.put("openGameDetail", new C15149fi());
            vxd.put("openGameCenter", new C15247fh());
            vxd.put("setGameDebugConfig", new C15070iq());
            vxd.put("startTempSession", new C15264jx());
            vxd.put("getH5PrepayRequest", new C15049cb());
            vxd.put("getH5TransactionRequest", new C15050cc());
            vxd.put("menu:share:timeline", new C15275ma());
            vxd.put("menu:share:appmessage", new C15310lx());
            vxd.put("menu:share:qq", new C4810ly());
            vxd.put("menu:share:weiboApp", new C15132mb());
            vxd.put("menu:setfont", new C15177lw());
            vxd.put("menu:share:weibo", new C15132mb());
            vxd.put("menu:share:QZone", new C4811lz());
            vxd.put("getRecevieBizHongBaoRequest", new C15097e());
            vxd.put(C46894f.NAME, new C15243dr());
            vxd.put(C10559j.NAME, new C4809kp());
            vxd.put(C10557i.NAME, new C15113hd());
            vxd.put(C2352h.NAME, new C15209gk());
            vxd.put("deleteSearchHistory", new C15087av());
            vxd.put("getSearchHistory", new C15094ct());
            vxd.put("getSearchData", new C15195cp());
            vxd.put("getPoiInfo", new C15091bz());
            vxd.put("updateReddotTimeStamps", new C15036kl());
            vxd.put("getTeachSearchData", new C15144cz());
            vxd.put("getSearchGuideData", new C15051cs());
            vxd.put("getSearchAvatarList", new C15284co());
            vxd.put("getSearchSnsImageList", new C4796cv());
            vxd.put("getSearchImageList", new C4795cu());
            vxd.put("getSearchDisplayNameList", new C15140cq());
            vxd.put("startSearchItemDetailPage", new C15263jw());
            vxd.put("reportSearchStatistics", new C15114hk());
            vxd.put("reportSearchRealTimeStatistics", new C15063hj());
            vxd.put("searchDataHasResult", new C15115ht());
            vxd.put("openEmotionPage", new C15137bm());
            vxd.put("getSearchSuggestionData", new C15141cw());
            vxd.put("setSearchInputWord", new C15120ix());
            vxd.put("setSnsObjectXmlDescList", new C15122iz());
            vxd.put("clickSnsMusicPlayButton", new C15184aj());
            vxd.put("openWeAppPage", new C15251ge());
            vxd.put("reportWeAppSearchRealtime", new C15077lj());
            vxd.put("doSearchOperation", new C15233bc());
            vxd.put("insertSearchWAWidgetView", new C15057dq());
            vxd.put("removeSearchWAWidgetView", new C15023hc());
            vxd.put("updateSearchWAWidgetView", new C15169kn());
            vxd.put("showSearchActionSheet", new C15031jl());
            vxd.put("cancelSearchActionSheet", new C15181u());
            vxd.put("showSearchToast", new C15304jo());
            vxd.put("showSearchLoading", new C15303jm());
            vxd.put("hideSearchLoading", new C15146dn());
            vxd.put("updateWASearchTemplate", new C15170kq());
            vxd.put("preloadSearchWeapp", new C4802gr());
            vxd.put("uxSearchOpLog", new C15174kw());
            vxd.put("jumpToWXWallet", new C15147dz());
            vxd.put("scanCover", new C15012f());
            vxd.put("reportActionInfo", new C15062he());
            vxd.put("openMyDeviceProfile", new C15293fp());
            vxd.put("selectPedometerSource", new C15159hx());
            vxd.put("nfcIsConnect", new C15102es());
            vxd.put("nfcConnect", new C15203ep());
            vxd.put("nfcTransceive", new C15059et());
            vxd.put("nfcBatchTransceive", new C15202en());
            vxd.put("nfcGetId", new C15058eq());
            vxd.put("nfcGetInfo", new C15101er());
            vxd.put("startMonitoringBeacons", new C15032js());
            vxd.put("stopMonitoringBeacons", new C15072jz());
            vxd.put("nfcCheckState", new C15290eo());
            vxd.put("videoProxyInit", new C15074lb());
            vxd.put("videoProxyStartPlay", new C15271le());
            vxd.put("videoProxyStopPlay", new C15272lf());
            vxd.put("videoProxySetPlayerState", new C15269lc());
            vxd.put("videoProxySetRemainTime", new C15270ld());
            vxd.put("videoProxyPreload", new C15130lh());
            vxd.put("getWebPayCheckoutCounterRequst", new C15288ef());
            vxd.put("addCustomMenuItems", new C15216i());
            vxd.put("operateGameCenterMsg", new C15110gj());
            vxd.put("openEnterpriseChat", new C4799ff());
            vxd.put("enterEnterpriseChat", new C4791bh());
            vxd.put("openEnterpriseContact", new C15104fg());
            vxd.put("selectEnterpriseContact", new C15158hw());
            vxd.put("getEnterpriseChat", new C15090bx());
            vxd.put("reportIDKey", new C15255hh());
            vxd.put("quicklyAddBrandContact", new C15061gy());
            vxd.put("consumedShareCard", new C15186as());
            vxd.put("cache", new C15129la());
            vxd.put("publicCache", new C15075lg());
            vxd.put("kvReport", new C4797ea());
            vxd.put("realtimeReport", new C15157gz());
            vxd.put("openUrlWithExtraWebview", new C15108ga());
            vxd.put("setFreeWifiOwner", new C15119ip());
            vxd.put("selectSingleContact", new C15160hy());
            vxd.put("sendAppMessageToSpecifiedContact", new C15215hz());
            vxd.put("setLocalData", new C15260ir());
            vxd.put("getLocalData", new C15193ce());
            vxd.put("clearLocalData", new C15183ah());
            vxd.put("showKeyboard", new C15166jh());
            vxd.put("showSmileyPanel", new C15222jp());
            vxd.put("disableBounceScroll", new C15047aw());
            vxd.put("clearBounceBackground", new C14994af());
            vxd.put("setNavigationBarButtons", new C15261is());
            vxd.put("enableFullScreen", new C14997bf());
            vxd.put(C19407x.NAME, new C15030jj());
            vxd.put(C2298d.NAME, new C15242dl());
            vxd.put("enablePullDownRefresh", new C14998bg());
            vxd.put(C42529z.NAME, new C15125jt());
            vxd.put(C42521aa.NAME, new C15266ka());
            vxd.put("disablePullDownRefresh", new C15230ax());
            vxd.put("setPageTitle", new C15262iv());
            vxd.put("setStatusBarStyle", new C15028ja());
            vxd.put("deleteAccountSuccess", new C15086au());
            vxd.put(JsApiChooseVideo.NAME, new C4790ae());
            vxd.put("uploadVideo", new C15128ku());
            vxd.put("openMapNavigateMenu", new C15018fo());
            vxd.put(C27011o.NAME, new C15219it());
            vxd.put("getWCPayRealnameVerify", new C15197db());
            vxd.put("openDesignerEmojiView", new C15103ez());
            vxd.put("openDesignerProfile", new C15292fb());
            vxd.put("openEmoticonTopicList", new C15015fe());
            vxd.put("openDesignerEmojiViewLocal", new C15205fa());
            vxd.put("openDesignerProfileLocal", new C15013fc());
            vxd.put("openEmotionDetailViewLocal", new C15005d());
            vxd.put("openNewPage", new C15206fq());
            vxd.put("getSearchEmotionData", new C4794cr());
            vxd.put("openEmotionUrl", new C15280be());
            vxd.put("WNNativeCallbackOnClick", new C15226ln());
            vxd.put("WNNativeCallbackOnLongClick", new C15274lo());
            vxd.put("WNNativeCallbackOnCaretChange", new C15309lm());
            vxd.put("WNNativeCallbackInitData", new C15273ll());
            vxd.put("WNNativeAsyncCallback", new C15078lk());
            vxd.put("WNNativeCallbackOnBecomeEditing", new C15227lt());
            vxd.put("WNNativeCallbackOnBecomeEdited", new C15175lu());
            vxd.put("changePayActivityView", new C4812v());
            vxd.put("selectWalletCurrency", new C15035kf());
            vxd.put("scanLicence", new C15258hr());
            vxd.put(JsApiOperateMusicPlayer.NAME, new C15232b());
            vxd.put(JsApiGetMusicPlayerState.NAME, new C15229a());
            vxd.put("clearWebviewCache", new C15277ai());
            vxd.put("requireSoterBiometricAuthentication", new C15123jq());
            vxd.put("getSupportSoter", new C15124jr());
            vxd.put("unbindBankCard", new C15167kj());
            vxd.put("setBounceBackground", new C15300il());
            vxd.put("sendEnterpriseChat", new C15259id());
            vxd.put("doExposePreparation", new C15188bb());
            vxd.put("getMsgProofItems", new C15237ch());
            vxd.put("openSecurityView", new C15060fx());
            vxd.put("startVoipCall", new C15265jy());
            vxd.put(C19285af.NAME, new C4788ac());
            vxd.put("getOpenDeviceId", new C15003cj());
            vxd.put("getRouteUrl", new C15194cn());
            vxd.put("idCardRealnameVerify", new C15055do());
            vxd.put("uploadIdCardSuccess", new C15133md());
            vxd.put(C38339e.NAME, new C15165jg());
            vxd.put("openLuckyMoneyDetailView", new C15017fm());
            vxd.put("resendRemittanceMsg", new C15297hp());
            vxd.put("getGameCommInfo", new C15002by());
            vxd.put("openGameRegion", new C15150fj());
            vxd.put("chooseIdCard", new C15311z());
            vxd.put("getLocalImgData", new C15283c());
            vxd.put("openWeApp", new C15250gd());
            vxd.put("recordVideo", new C15213ha());
            vxd.put("previewVideo", new C4803gs());
            vxd.put("uploadEncryptMediaFile", new C15171kr());
            vxd.put(JsApiChooseMedia.NAME, new C4789ad());
            vxd.put("requestWxFacePictureVerify", new C4792bi());
            vxd.put("openCustomWebview", new C15246ey());
            vxd.put("forceUpdateWxaAttr", new C15136bl());
            vxd.put("openLuckyMoneyHistory", new C4800fn());
            vxd.put("menuitem:gameSendDesktop", new C15116ie());
            vxd.put("getWePkgAuthResult", new C15198dd());
            vxd.put("getLocalWePkgInfo", new C15235cf());
            vxd.put("openGameWebView", new C15016fl());
            vxd.put("reportGameWeb", new C15254hg());
            vxd.put("launchApplication", new C15148ed());
            vxd.put("showSearchOfBizHistory", new C15221jn());
            vxd.put("login", new C15098eh());
            vxd.put("authorize", new C15041o());
            vxd.put("requestWxFacePictureVerifyUnionVideo", new C15089bj());
            vxd.put("checkIsSupportFaceDetect", new C15043w());
            vxd.put(JsApiOperateBackgroundAudio.NAME, new C15021gi());
            vxd.put(JsApiSetBackgroundAudioState.NAME, new C15217ik());
            vxd.put(JsApiGetBackgroundAudioState.NAME, new C4793bq());
            vxd.put(JsApiAddDownloadTaskStraight.NAME, new C15223k());
            vxd.put("setScreenOrientation", new C15071iw());
            vxd.put("addToEmoticon", new C15080m());
            vxd.put("shareEmoticon", new C4804jb());
            vxd.put(C45573as.NAME, new C15010ei());
            vxd.put(JsApiOpenAdCanvas.NAME, new C15291ex());
            vxd.put("openSearchCanvas", new C15106fu());
            vxd.put("opVoteAdData", new C15296gl());
            vxd.put("requestWxFaceRegisterInternal", new C15065hm());
            vxd.put("requestWxFaceVerifyInternal", new C15066hn());
            vxd.put(JsApiLaunchMiniProgram.NAME, new C15200ee());
            vxd.put("reportMiniProgramPageData", new C15256hi());
            vxd.put("selectContact", new C15025hv());
            vxd.put("openSearchWAWidgetLogView", new C15019fv());
            vxd.put("reloadSearchWAWidgetData", new C15112hb());
            vxd.put("closeWindowAndGoNext", new C14995al());
            vxd.put("requestWxVoicePrintVerifyInternal", new C15257ho());
            vxd.put("openBizChat", new C15204ew());
            vxd.put("handleWCPayWalletBuffer", new C15239di());
            vxd.put("tapSearchWAWidgetView", new C15127kg());
            vxd.put("getMatchContactList", new C15236cg());
            vxd.put("openSearchWebView", new C15107fw());
            vxd.put("openWXSearchPage", new C15109gh());
            vxd.put("viewTypeChange", new C15307ky());
            vxd.put("invokeMiniProgramAPI", new C15287du());
            vxd.put("openGameUrlWithExtraWebView", new C15151fk());
            vxd.put("setGameData", new C15068in());
            vxd.put("getGameData", new C15282bu());
            vxd.put("clearGameData", new C15135ag());
            vxd.put("openECard", new C15014fd());
            vxd.put("reportGamePageTime", new C15253hf());
            vxd.put("setWCPayPassword", new C15299ij());
            vxd.put("openWCPayCardList", new C15245ev());
            vxd.put("bindEmail", new C15179s());
            vxd.put(C33246ax.NAME, new C15294fr());
            vxd.put("bindEmail", new C15179s());
            vxd.put("doGoToRecVideoList", new C15093cm());
            vxd.put("jumpWSRecVideoList", new C15176lv());
            vxd.put("openWebSearchOutLinkItem", new C15040mc());
            vxd.put("recordHistory", new C14999bo());
            LinkedList<C15081g> linkedList = new LinkedList();
            linkedList.add(new C15153gq());
            linkedList.add(new C4801gp());
            linkedList.add(new C15162ib());
            linkedList.add(new C15053dh());
            linkedList.add(new C15211gv());
            linkedList.add(new C15155gu());
            linkedList.add(new C15138bn());
            linkedList.add(new C15249gc());
            linkedList.add(new C14996ao());
            for (C15081g c15081g : linkedList) {
                vxd.put(c15081g.getName(), c15081g);
            }
            vxd.put("getSystemInfo", new C15143cy());
            vxd.put("serviceClick", new C15027ii());
            vxd.put(C38251e.NAME, new C15039ls());
            vxd.put("sendSingleAppMessage", new C15118ih());
            vxd.put("wcPrivacyPolicyResult", new C15225kz());
            vxd.put("currentMpInfo", new C15046at());
            vxd.put("updateAppMessageShareData", new C4807km());
            vxd.put("updateTimelineShareData", new C4808ko());
            vxd.put("getCCData", new C15038lr());
            vxd.put("calRqt", new C15131lq());
            vxd.put(C33253d.NAME, new C15234bk());
            vxd.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, new C15064hl());
            vxd.put("notifyPageInfo", new C15244eu());
            vxd.put("updatePageAuth", new C15168kk());
            vxd.put("jumpDownloaderWidget", new C15006dv());
            vxd.put("batchUpdateWepkg", new C15228q());
            vxd.put("addGameDownloadTask", new C15308l());
            vxd.put("internelWxFaceVerify", new C15199dt());
            vxd.put("getDownloadWidgetTaskInfos", new C15192bw());
        }
        C15081g c15081g2 = (C15081g) vxd.get(str);
        AppMethodBeat.m2505o(79963);
        return c15081g2;
    }
}

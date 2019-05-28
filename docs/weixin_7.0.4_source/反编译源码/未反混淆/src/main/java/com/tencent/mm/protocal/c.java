package com.tencent.mm.protocal;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class c {
    private static Map<String, g> vxd = null;

    public static class ac extends g {
        public ac() {
            super(com.tencent.mm.plugin.appbrand.jsapi.af.NAME, com.tencent.mm.plugin.appbrand.jsapi.af.NAME, com.tencent.view.d.MIC_PTU_YOUJIALI, true);
        }
    }

    static final class ad extends g {
        ad() {
            super(JsApiChooseMedia.NAME, JsApiChooseMedia.NAME, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, true);
        }
    }

    public static class ae extends g {
        public ae() {
            super(JsApiChooseVideo.NAME, JsApiChooseVideo.NAME, 191, true);
        }
    }

    public static class bh extends g {
        public bh() {
            super("enterEnterpriseChat", "enterEnterpriseChat", 223, false);
        }
    }

    static final class bi extends g {
        bi() {
            super("requestWxFacePictureVerify", "requestWxFacePictureVerify", com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA, true);
        }
    }

    static final class bq extends g {
        bq() {
            super(JsApiGetBackgroundAudioState.NAME, JsApiGetBackgroundAudioState.NAME, com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_FASHION, false);
        }
    }

    public static class cr extends g {
        public cr() {
            super("getSearchEmotionData", "getSearchEmotionData", com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class cu extends g {
        public cu() {
            super("getSearchImageList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class cv extends g {
        public cv() {
            super("getSearchSnsImageList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ea extends g {
        public ea() {
            super("kvReport", "kvReport", ErrorCode.NEEDDOWNLOAD_TRUE, false);
        }
    }

    public static class eb extends g {
        public eb() {
            super("launch3rdApp", "launch_3rdApp", 52, true);
        }
    }

    public static class ff extends g {
        public ff() {
            super("openEnterpriseChat", "openEnterpriseChat", ErrorCode.STARTDOWNLOAD_6, false);
        }
    }

    static final class fn extends g {
        fn() {
            super("openLuckyMoneyHistory", "openLuckyMoneyHistory", com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO, true);
        }
    }

    static final class gp extends g {
        public gp() {
            super("preloadMiniProgramContacts", "preloadMiniProgramContacts", 303, false);
        }
    }

    public static class gr extends g {
        public gr() {
            super("preloadSearchWeapp", "preloadSearchWeapp", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class gs extends g {
        gs() {
            super("previewVideo", "previewVideo", 252, true);
        }
    }

    static final class jb extends g {
        jb() {
            super("shareEmoticon", "shareEmoticon", com.tencent.view.d.MIC_GPU_AUTOLEVEL, true);
        }
    }

    public static class jc extends g {
        public jc() {
            super("shareQQ", "shareQQ", 90, true);
        }
    }

    public static class jk extends g {
        public jk() {
            super("showOptionMenu", "", 14, false);
        }
    }

    static final class km extends g {
        km() {
            super("updateAppMessageShareData", "updateAppMessageShareData", ErrorCode.TEST_THROWABLE_IS_NULL, false);
        }
    }

    static final class ko extends g {
        ko() {
            super("updateTimelineShareData", "updateTimelineShareData", ErrorCode.TEST_THROWABLE_ISNOT_NULL, false);
        }
    }

    public static class kp extends g {
        public kp() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.j.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ly extends g {
        public ly() {
            super("menu:share:qq", "", 94, false);
        }
    }

    public static class lz extends g {
        public lz() {
            super("menu:share:QZone", "", com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, false);
        }
    }

    public static class v extends g {
        public v() {
            super("changePayActivityView", "change_pay_activity_view", 207, true);
        }
    }

    public static class x extends g {
        public x() {
            super("checkJsApi", "checkJsApi", 84, false);
        }
    }

    public static class af extends g {
        public af() {
            super("clearBounceBackground", "clearBounceBackground", 189, false);
        }
    }

    static final class al extends g {
        al() {
            super("closeWindowAndGoNext", "closeWindowAndGoNext", 293, false);
        }
    }

    static final class ao extends g {
        ao() {
            super("confirmDialog", "confirmDialog", com.tencent.mm.plugin.appbrand.jsapi.g.s.CTRL_INDEX, true);
        }
    }

    public static class bf extends g {
        public bf() {
            super("enableFullScreen", "enableFullScreen", 196, false);
        }
    }

    public static class bg extends g {
        public bg() {
            super("enablePullDownRefresh", "enablePullDownRefresh", 199, false);
        }
    }

    static final class bo extends g {
        bo() {
            super("recordHistory", "recordHistory", 219, false);
        }
    }

    public static class bp extends g {
        public bp() {
            super("geoLocation", "geo_location", 57, false);
        }
    }

    public static class br extends g {
        public br() {
            super("getBrandWCPayBindCardRequest", "get_brand_WCPay_bind_card_request", 58, true);
        }
    }

    public static class by extends g {
        public by() {
            super("getGameCommInfo", "getGameCommInfo", com.tencent.view.d.MIC_PTU_QINGCONG, false);
        }
    }

    public static class cj extends g {
        public cj() {
            super("getOpenDeviceId", "getOpenDeviceId", 227, false);
        }
    }

    public static class cl extends g {
        public cl() {
            super("getLatestAddress", "get_recently_used_address", 46, true);
        }
    }

    public static class d extends g {
        public d() {
            super("openEmotionDetailViewLocal", "openEmotionDetailViewLocal", com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    static final class dv extends g {
        dv() {
            super("jumpDownloaderWidget", "jumpDownloaderWidget", 339, true);
        }
    }

    public static class dx extends g {
        public dx() {
            super("jumpToBizProfile", "jump_to_biz_profile", 61, true);
        }
    }

    public static class dy extends g {
        public dy() {
            super("jumpWCMall", "jump_wcmall", 51, true);
        }
    }

    public static class ec extends g {
        public ec() {
            super("launchApp", "", 27, false);
        }
    }

    static final class ei extends g {
        ei() {
            super(com.tencent.mm.plugin.appbrand.jsapi.as.NAME, com.tencent.mm.plugin.appbrand.jsapi.as.NAME, Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    public static class el extends g {
        public el() {
            super(com.tencent.mm.plugin.appbrand.jsapi.e.j.NAME, "open_location", 63, true);
        }
    }

    public static class f extends g {
        public f() {
            super("scanCover", "scanCover", com.tencent.mm.plugin.appbrand.jsapi.g.n.CTRL_INDEX, true);
        }
    }

    public static class fc extends g {
        public fc() {
            super("openDesignerProfileLocal", "openDesignerProfileLocal", com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    static final class fd extends g {
        fd() {
            super("openECard", "openECard", com.tencent.view.d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI, true);
        }
    }

    public static class fe extends g {
        public fe() {
            super("openEmoticonTopicList", "openEmoticonTopicList", 212, true);
        }
    }

    static final class fl extends g {
        fl() {
            super("openGameWebView", "openGameWebView", com.tencent.view.d.MIC_PTU_SHUILIAN, false);
        }
    }

    public static class fm extends g {
        public fm() {
            super("openLuckyMoneyDetailView", "openLuckyMoneyDetailView", com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, false);
        }
    }

    public static class fo extends g {
        public fo() {
            super("openMapNavigateMenu", "openMapNavigateMenu", FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, true);
        }
    }

    static final class fv extends g {
        fv() {
            super("openSearchWAWidgetLogView", "openSearchWAWidgetLogView", Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    public static class gg extends g {
        public gg() {
            super("openWXDeviceLib", "openWXDeviceLib", com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, false);
        }
    }

    static final class gi extends g {
        gi() {
            super(JsApiOperateBackgroundAudio.NAME, JsApiOperateBackgroundAudio.NAME, com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW, false);
        }
    }

    public static class go extends g {
        public go() {
            super(JsApiStartPlayVoice.NAME, JsApiStartPlayVoice.NAME, 99, false);
        }
    }

    public static class hc extends g {
        public hc() {
            super("removeSearchWAWidgetView", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class hu extends g {
        public hu() {
            super(com.tencent.mm.plugin.appbrand.jsapi.i.m.NAME, "", ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, false);
        }
    }

    static final class hv extends g {
        hv() {
            super("selectContact", "selectContact", Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    public static class if extends g {
        public if() {
            super("sendEmail", "send_email", 35, false);
        }
    }

    static final class ii extends g {
        ii() {
            super("serviceClick", "serviceClick", 304, false);
        }
    }

    public static class ja extends g {
        public ja() {
            super("setStatusBarStyle", "setStatusBarStyle", 206, false);
        }
    }

    public static class ji extends g {
        public ji() {
            super("showMenuItems", "showMenuItems", 86, false);
        }
    }

    public static class jj extends g {
        public jj() {
            super(com.tencent.mm.plugin.appbrand.jsapi.k.x.NAME, com.tencent.mm.plugin.appbrand.jsapi.k.x.NAME, 197, false);
        }
    }

    public static class jl extends g {
        public jl() {
            super("showSearchActionSheet", "showSearchActionSheet", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class js extends g {
        public js() {
            super("startMonitoringBeacons", "startMonitoringBeacons", 151, false);
        }
    }

    public static class ju extends g {
        public ju() {
            super(JsApiStartRecordVoice.NAME, JsApiStartRecordVoice.NAME, 96, false);
        }
    }

    public static class kd extends g {
        public kd() {
            super(JsApiStopPlayVoice.NAME, JsApiStopPlayVoice.NAME, 101, false);
        }
    }

    public static class kf extends g {
        public kf() {
            super("selectWalletCurrency", "selectWalletCurrency", 201, true);
        }
    }

    public static class kl extends g {
        public kl() {
            super("updateReddotTimeStamps", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class kx extends g {
        public kx() {
            super("verifyWCPayPassword", "verifyWCPayPassword", 115, true);
        }
    }

    static final class lr extends g {
        lr() {
            super("getCCData", "getCCData", 312, false);
        }
    }

    static final class ls extends g {
        ls() {
            super(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME, 314, true);
        }
    }

    public static class mc extends g {
        public mc() {
            super("openWebSearchOutLinkItem", "", 320, true);
        }
    }

    static final class o extends g {
        o() {
            super("authorize", "authorize", 232, true);
        }
    }

    public static class p extends g {
        public p() {
            super("batchAddCard", "batch_add_card", 82, true);
        }
    }

    static final class w extends g {
        w() {
            super("checkIsSupportFaceDetect", "checkIsSupportFaceDetect", com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE, false);
        }
    }

    public static class y extends g {
        public y() {
            super("chooseCard", "choose_card", 70, true);
        }
    }

    static final class at extends g {
        public at() {
            super("currentMpInfo", "currentMpInfo", com.tencent.mm.plugin.appbrand.jsapi.ab.CTRL_INDEX, false);
        }
    }

    public static class aw extends g {
        public aw() {
            super("disableBounceScroll", "disableBounceScroll", 188, false);
        }
    }

    public static class ca extends g {
        public ca() {
            super("getHeadingAndPitch", "get_heading_and_pitch", 33, false);
        }
    }

    public static class cb extends g {
        public cb() {
            super("getH5PrepayRequest", "getH5PrepayRequest", 137, true);
        }
    }

    public static class cc extends g {
        public cc() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    public static class cs extends g {
        public cs() {
            super("getSearchGuideData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class df extends g {
        public df() {
            super("getWXDeviceInfos", "getWXDeviceInfos", com.tencent.view.d.MIC_AVROUND_BLUR, true);
        }
    }

    static final class dh extends g {
        dh() {
            super("handleHaokanAction", "handleHaokanAction", 335, false);
        }
    }

    public static class dm extends g {
        public dm() {
            super("hideOptionMenu", "", 14, false);
        }
    }

    public static class do extends g {
        public do() {
            super("idCardRealnameVerify", "idCardRealnameVerify", com.tencent.view.d.MIC_PTU_AUTOLEVEL, true);
        }
    }

    public static class dp extends g {
        public dp() {
            super("imagePreview", "", 1, true);
        }
    }

    public static class dq extends g {
        public dq() {
            super("insertSearchWAWidgetView", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class eq extends g {
        public eq() {
            super("nfcGetId", "nfcGetId", ErrorCode.NEEDDOWNLOAD_4, false);
        }
    }

    public static class et extends g {
        public et() {
            super("nfcTransceive", "nfcTransceive", 141, false);
        }
    }

    public static class fx extends g {
        public fx() {
            super("openSecurityView", "openSecurityView", 229, false);
        }
    }

    public static class gy extends g {
        public gy() {
            super("quicklyAddBrandContact", "quicklyAddBrandContact", 166, true);
        }
    }

    public static class he extends g {
        public he() {
            super("reportActionInfo", "reportActionInfo", com.tencent.view.d.MIC_PTU_FENGJING, false);
        }
    }

    public static class hj extends g {
        public hj() {
            super("reportSearchRealTimeStatistics", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class hl extends g {
        hl() {
            super(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, false);
        }
    }

    static final class hm extends g {
        hm() {
            super("requestWxFaceRegisterInternal", "requestWxFaceRegisterInternal", 272, true);
        }
    }

    static final class hn extends g {
        hn() {
            super("requestWxFaceVerifyInternal", "requestWxFaceVerifyInternal", 273, true);
        }
    }

    public static class hs extends g {
        public hs() {
            super("scanQRCode", "scanQRCode", 7, true);
        }
    }

    static final class in extends g {
        in() {
            super("setGameData", "setGameData", 298, false);
        }
    }

    public static class io extends g {
        public io() {
            super("setFontSizeCallback", "", -2, false);
        }
    }

    public static class iq extends g {
        public iq() {
            super("setGameDebugConfig", "setGameDebugConfig", 1111111, false);
        }
    }

    static final class iw extends g {
        iw() {
            super("setScreenOrientation", "setScreenOrientation", 270, false);
        }
    }

    public static class jz extends g {
        public jz() {
            super("stopMonitoringBeacons", "stopMonitoringBeacons", 152, false);
        }
    }

    public static class kv extends g {
        public kv() {
            super("uploadVoice", "uploadVoice", 102, true);
        }
    }

    public static class lb extends g {
        public lb() {
            super("videoProxyInit", "videoProxyInit", 156, false);
        }
    }

    public static class lg extends g {
        public lg() {
            super("publicCache", "publicCache", 149, false);
        }
    }

    public static class li extends g {
        public li() {
            super("shareWeibo", "share_weibo", 3, true);
        }
    }

    public static class lj extends g {
        public lj() {
            super("reportWeAppSearchRealtime", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class lk extends g {
        public lk() {
            super("WNNativeAsyncCallback", "WNNativeAsyncCallback", 10006, false);
        }
    }

    public static class lp extends g {
        public lp() {
            super(JsApiWriteCommData.NAME, "write_comm_data", 53, false);
        }
    }

    static final class m extends g {
        m() {
            super("addToEmoticon", "addToEmoticon", 274, true);
        }
    }

    public static abstract class g {
        protected String NAME = "noName";
        protected String vxe = "";
        protected int vxf = -1;
        protected boolean vxg = false;

        public g(String str, String str2, int i, boolean z) {
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

    public static final class me {
        public static Set<String> vxh;
    }

    public static class ak extends g {
        public ak() {
            super("closeWindow", "close_window", 17, false);
        }
    }

    public static class am extends g {
        public am() {
            super("closeWXDeviceLib", "closeWXDeviceLib", 118, false);
        }
    }

    public static class an extends g {
        public an() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    public static class au extends g {
        public au() {
            super("deleteAccountSuccess", "deleteAccountSuccess", 144, false);
        }
    }

    public static class av extends g {
        public av() {
            super("deleteSearchHistory", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ba extends g {
        public ba() {
            super("downloadVoice", "downloadVoice", 103, true);
        }
    }

    static final class bj extends g {
        bj() {
            super("requestWxFacePictureVerifyUnionVideo", "requestWxFacePictureVerifyUnionVideo", com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, true);
        }
    }

    public static class bx extends g {
        public bx() {
            super("getEnterpriseChat", "getEnterpriseChat", 244, false);
        }
    }

    public static class bz extends g {
        public bz() {
            super("getPoiInfo", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ck extends g {
        public ck() {
            super("getPaymentOrderRequest", "getPaymentOrderRequest", 116, true);
        }
    }

    static final class cm extends g {
        cm() {
            super("doGoToRecVideoList", "doGoToRecVideoList", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ct extends g {
        public ct() {
            super("getSearchHistory", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class dg extends g {
        public dg() {
            super("getWXDeviceTicket", "getWXDeviceTicket", 125, true);
        }
    }

    public static class dw extends g {
        public dw() {
            super("jumpToInstallUrl", "", 26, false);
        }
    }

    public static class e extends g {
        public e() {
            super("getRecevieBizHongBaoRequest", "getRecevieBizHongBaoRequest", com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX, true);
        }
    }

    static final class eh extends g {
        eh() {
            super("login", "login", 231, true);
        }
    }

    public static class ej extends g {
        public ej() {
            super("musicPlay", "playMusic", 69, false);
        }
    }

    public static class ek extends g {
        public ek() {
            super("timelineCheckIn", "timeline_check_in", 64, false);
        }
    }

    public static class er extends g {
        public er() {
            super("nfcGetInfo", "nfcGetInfo", 148, false);
        }
    }

    public static class es extends g {
        public es() {
            super("nfcIsConnect", "nfcIsConnect", com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, true);
        }
    }

    public static class ez extends g {
        public ez() {
            super("openDesignerEmojiView", "openDesignerEmojiView", 185, true);
        }
    }

    public static class fg extends g {
        public fg() {
            super("openEnterpriseContact", "openEnterpriseContact", 183, true);
        }
    }

    public static class ft extends g {
        public ft() {
            super("openProductViewWithPid", "open_product_view", 60, true);
        }
    }

    static final class fu extends g {
        fu() {
            super("openSearchCanvas", "openSearchCanvas", 283, true);
        }
    }

    static final class fw extends g {
        fw() {
            super("openSearchWebView", "openSearchWebView", Downloads.MIN_WAIT_FOR_NETWORK, true);
        }
    }

    public static class ga extends g {
        public ga() {
            super("openUrlWithExtraWebview", "openUrlWithExtraWebview", ErrorCode.NEEDDOWNLOAD_FALSE_3, false);
        }
    }

    static final class gh extends g {
        gh() {
            super("openWXSearchPage", "openWXSearchPage", com.tencent.view.d.MIC_PTU_MUSE, true);
        }
    }

    public static class gj extends g {
        public gj() {
            super("operateGameCenterMsg", "operateGameCenterMsg", ErrorCode.NEEDDOWNLOAD_FALSE_4, false);
        }
    }

    public static class gx extends g {
        public gx() {
            super(JsApiQueryDownloadTask.NAME, "query_download_task", 40, false);
        }
    }

    public static class hb extends g {
        public hb() {
            super("reloadSearchWAWidgetData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class hd extends g {
        public hd() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.i.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class hk extends g {
        public hk() {
            super("reportSearchStatistics", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ht extends g {
        public ht() {
            super("searchDataHasResult", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class ie extends g {
        ie() {
            super("menuitem:gameSendDesktop", "menuitem:gameSendDesktop", 255, false);
        }
    }

    public static class ig extends g {
        public ig() {
            super("sendServiceAppMessage", "send_service_app_msg", 67, true);
        }
    }

    static final class ih extends g {
        ih() {
            super("sendSingleAppMessage", "sendSingleAppMessage", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.CTRL_INDEX, true);
        }
    }

    public static class ip extends g {
        public ip() {
            super("setFreeWifiOwner", "setFreeWifiOwner", 169, false);
        }
    }

    public static class ix extends g {
        public ix() {
            super("setSearchInputWord", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class iy extends g {
        public iy() {
            super("setSendDataDirection", "setSendDataDirection", com.tencent.view.d.MIC_SketchMark, false);
        }
    }

    public static class iz extends g {
        public iz() {
            super("setSnsObjectXmlDescList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class jq extends g {
        public jq() {
            super("requireSoterBiometricAuthentication", "soter_biometric_authentication", 214, true);
        }
    }

    public static class jr extends g {
        public jr() {
            super("getSupportSoter", "getSupportSoter", 213, true);
        }
    }

    public static class jt extends g {
        public jt() {
            super(com.tencent.mm.plugin.appbrand.jsapi.k.z.NAME, com.tencent.mm.plugin.appbrand.jsapi.k.z.NAME, 204, false);
        }
    }

    public static class ke extends g {
        public ke() {
            super("streamingVideoPlay", "playStreamingVideo", 209, false);
        }
    }

    static final class kg extends g {
        kg() {
            super("tapSearchWAWidgetView", "tapSearchWAWidgetView", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ku extends g {
        public ku() {
            super("uploadVideo", "uploadVideo", com.tencent.mm.plugin.appbrand.jsapi.az.CTRL_INDEX, true);
        }
    }

    public static class la extends g {
        public la() {
            super("cache", "cache", 150, false);
        }
    }

    public static class lh extends g {
        public lh() {
            super("videoProxyPreload", "videoProxyPreload", ErrorCode.NEEDDOWNLOAD_FALSE_2, false);
        }
    }

    static final class lq extends g {
        lq() {
            super("calRqt", "calRqt", ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, false);
        }
    }

    public static class mb extends g {
        public mb() {
            super("menu:share:weiboApp", "", 109, false);
        }
    }

    public static class md extends g {
        public md() {
            super("uploadIdCardSuccess", "uploadIdCardSuccess", com.tencent.view.d.MIC_PTU_MEISHI, false);
        }
    }

    public static class n extends g {
        public n() {
            super(com.tencent.mm.plugin.appbrand.jsapi.z.NAME, "ad_data_report", 221, false);
        }
    }

    static final class ag extends g {
        ag() {
            super("clearGameData", "clearGameData", 300, false);
        }
    }

    static final class bl extends g {
        bl() {
            super("forceUpdateWxaAttr", "forceUpdateWxaAttr", com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO, false);
        }
    }

    public static class bm extends g {
        public bm() {
            super("openEmotionPage", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class bn extends g {
        bn() {
            super(com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.NAME, 338, true);
        }
    }

    public static class cd extends g {
        public cd() {
            super(JsApiGetInstallState.NAME, "get_install_state", 25, false);
        }
    }

    public static class cq extends g {
        public cq() {
            super("getSearchDisplayNameList", "getSearchDisplayNameList", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class cw extends g {
        public cw() {
            super("getSearchSuggestionData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class cx extends g {
        public cx() {
            super("getSendC2CMessageRequest", "get_send_c2c_message_request", 83, true);
        }
    }

    static final class cy extends g {
        cy() {
            super("getSystemInfo", "getSystemInfo", com.tencent.view.d.MIC_PTU_HONGKONG, false);
        }
    }

    public static class cz extends g {
        public cz() {
            super("getTeachSearchData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class de extends g {
        public de() {
            super("getWidgetCaptureImgUrl", "add_contact", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class dn extends g {
        public dn() {
            super("hideSearchLoading", "hideSearchLoading", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class dz extends g {
        public dz() {
            super("jumpToWXWallet", "jumpToWXWallet", ErrorCode.NEEDDOWNLOAD_8, true);
        }
    }

    static final class ed extends g {
        ed() {
            super("launchApplication", "launchApplication", com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW, true);
        }
    }

    public static class fi extends g {
        public fi() {
            super("openGameDetail", "openGameDetail", 131, true);
        }
    }

    public static class fj extends g {
        public fj() {
            super("openGameRegion", "openGameRegion", 242, true);
        }
    }

    static final class fk extends g {
        fk() {
            super("openGameUrlWithExtraWebView", "openGameUrlWithExtraWebView", 297, false);
        }
    }

    public static class gn extends g {
        public gn() {
            super(JsApiPausePlayVoice.NAME, JsApiPausePlayVoice.NAME, 100, false);
        }
    }

    static final class gq extends g {
        gq() {
            super("preloadMiniProgramEnv", "preloadMiniProgramEnv", 302, false);
        }
    }

    public static class gt extends g {
        public gt() {
            super("preVerifyJSAPI", "pre_verify_jsapi", -3, false);
        }
    }

    static final class gu extends g {
        gu() {
            super("privateCommonApi", "privateCommonApi", ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, true);
        }
    }

    public static class gw extends g {
        public gw() {
            super(Scopes.PROFILE, Scopes.PROFILE, 2, true);
        }
    }

    public static class gz extends g {
        public gz() {
            super("realtimeReport", "realtimeReport", ErrorCode.NEEDDOWNLOAD_FALSE_1, false);
        }
    }

    public static class hw extends g {
        public hw() {
            super("selectEnterpriseContact", "selectEnterpriseContact", 286, true);
        }
    }

    public static class hx extends g {
        public hx() {
            super("selectPedometerSource", "selectPedometerSource", 146, true);
        }
    }

    public static class hy extends g {
        public hy() {
            super("selectSingleContact", "selectSingleContact", ErrorCode.STARTDOWNLOAD_8, true);
        }
    }

    public static class ia extends g {
        public ia() {
            super("sendAppMessage", "send_app_msg", 6, true);
        }
    }

    static final class ib extends g {
        public ib() {
            super("sendDataToMiniProgram", "sendDataToMiniProgram", ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, false);
        }
    }

    public static class jd extends g {
        public jd() {
            super("shareQZone", "shareQZone", 132, true);
        }
    }

    public static class jf extends g {
        public jf() {
            super("showAllNonBaseMenuItem", "showAllNonBaseMenuItem", 92, false);
        }
    }

    public static class jg extends g {
        public jg() {
            super(com.tencent.mm.plugin.appbrand.jsapi.m.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.m.e.NAME, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, true);
        }
    }

    public static class jh extends g {
        public jh() {
            super("showKeyboard", "showKeyboard", 187, false);
        }
    }

    public static class kj extends g {
        public kj() {
            super("unbindBankCard", "unbindBankCard", 216, true);
        }
    }

    static final class kk extends g {
        kk() {
            super("updatePageAuth", "updatePageAuth", -2, false);
        }
    }

    public static class kn extends g {
        public kn() {
            super("updateSearchWAWidgetView", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class kq extends g {
        public kq() {
            super("updateWASearchTemplate", "updateWASearchTemplate", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class kr extends g {
        kr() {
            super("uploadEncryptMediaFile", "uploadEncryptMediaFile", com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, false);
        }
    }

    public static class ks extends g {
        public ks() {
            super("uploadImage", "uploadImage", 105, true);
        }
    }

    public static class kt extends g {
        public kt() {
            super("uploadMediaFile", "uploadMediaFile", com.tencent.view.d.MIC_PTU_LENGMEIREN, true);
        }
    }

    public static class kw extends g {
        public kw() {
            super("uxSearchOpLog", "uxSearchOpLog", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class lu extends g {
        public lu() {
            super("WNNativeCallbackOnBecomeEdited", "WNNativeCallbackOnBecomeEdited", 10006, false);
        }
    }

    public static class lv extends g {
        public lv() {
            super("jumpWSRecVideoList", "", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, true);
        }
    }

    public static class lw extends g {
        public lw() {
            super("menu:setfont", "", GmsClientSupervisor.DEFAULT_BIND_FLAGS, false);
        }
    }

    public static class r extends g {
        public r() {
            super("batchViewCard", "batchViewCard", 111, true);
        }
    }

    static final class s extends g {
        s() {
            super("bindEmail", "bindEmail", 306, true);
        }
    }

    public static class t extends g {
        public t() {
            super(JsApiCancelDownloadTask.NAME, "cancel_download_task", 39, false);
        }
    }

    public static class u extends g {
        public u() {
            super("cancelSearchActionSheet", "cancelSearchActionSheet", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class aa extends g {
        public aa() {
            super(JsApiChooseImage.NAME, JsApiChooseImage.NAME, 104, true);
        }
    }

    public static class ah extends g {
        public ah() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    public static class aj extends g {
        public aj() {
            super("clickSnsMusicPlayButton", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class aq extends g {
        public aq() {
            super("connectToWiFi", "connecttowifi", 71, false);
        }
    }

    public static class as extends g {
        public as() {
            super("consumedShareCard", "consumedShareCard", ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, true);
        }
    }

    public static class az extends g {
        public az() {
            super("downloadImage", "downloadImage", 106, true);
        }
    }

    public static class bb extends g {
        public bb() {
            super("doExposePreparation", "doExposePreparation", 225, false);
        }
    }

    public static class bd extends g {
        public bd() {
            super("editAddress", "edit_address", 29, true);
        }
    }

    public static class bt extends g {
        public bt() {
            super("getCurrentSSID", "getCurrentSSID", ErrorCode.NEEDDOWNLOAD_FALSE_6, true);
        }
    }

    public static class bv extends g {
        public bv() {
            super("mmsf0001", "mmsf0001", -2, false);
        }
    }

    static final class bw extends g {
        bw() {
            super("getDownloadWidgetTaskInfos", "getDownloadWidgetTaskInfos", 340, false);
        }
    }

    public static class ce extends g {
        public ce() {
            super("getLocalData", "getLocalData", 179, false);
        }
    }

    public static class cn extends g {
        public cn() {
            super("getRouteUrl", "getRouteUrl", com.tencent.view.d.MIC_PTU_AUTOLEVEL, false);
        }
    }

    public static class cp extends g {
        public cp() {
            super("getSearchData", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class da extends g {
        public da() {
            super("getTransferMoneyRequest", "get_transfer_money_request", 74, true);
        }
    }

    public static class db extends g {
        public db() {
            super("getWCPayRealnameVerify", "getWCPayRealnameVerify", JsApiUploadEncryptedFileToCDN.CTRL_INDEX, true);
        }
    }

    static final class dd extends g {
        dd() {
            super("getWePkgAuthResult", "getWePkgAuthResult", -3, false);
        }
    }

    public static final class dt extends g {
        dt() {
            super("internelWxFaceVerify", "internelWxFaceVerify", ErrorCode.THROWABLE_INITX5CORE, true);
        }
    }

    static final class ee extends g {
        ee() {
            super(JsApiLaunchMiniProgram.NAME, JsApiLaunchMiniProgram.NAME, 277, true);
        }
    }

    public static class eg extends g {
        public eg() {
            super("log", "", 0, false);
        }
    }

    public static class en extends g {
        public en() {
            super("nfcBatchTransceive", "nfcBatchTransceive", ErrorCode.NEEDDOWNLOAD_3, false);
        }
    }

    public static class ep extends g {
        public ep() {
            super("nfcConnect", "nfcConnect", 140, false);
        }
    }

    static final class ew extends g {
        ew() {
            super("openBizChat", "openBizChat", com.tencent.view.d.MIC_PTU_YINGTAOBUDING, true);
        }
    }

    public static class fa extends g {
        public fa() {
            super("openDesignerEmojiViewLocal", "openDesignerEmojiViewLocal", com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class fq extends g {
        public fq() {
            super("openNewPage", "openNewPage", com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class fs extends g {
        public fs() {
            super("openProductView", "open_product_view", 59, true);
        }
    }

    public static class gb extends g {
        public gb() {
            super("openWCPaySpecificView", "open_wcpay_specific_view", 76, true);
        }
    }

    public static class gk extends g {
        public gk() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.h.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class gm extends g {
        public gm() {
            super(JsApiPauseDownloadTask.NAME, "cancel_download_task", com.tencent.view.d.MIC_PTU_SHISHANG2, false);
        }
    }

    static final class gv extends g {
        gv() {
            super("privateOpenWeappFunctionalPage", "privateOpenWeappFunctionalPage", 333, false);
        }
    }

    public static class h extends g {
        public h() {
            super("addContact", "add_contact", 5, true);
        }
    }

    static final class ha extends g {
        ha() {
            super("recordVideo", "recordVideo", 251, true);
        }
    }

    public static class hq extends g {
        public hq() {
            super(JsApiResumeDownloadTask.NAME, "resume_download_task", 240, true);
        }
    }

    public static class hz extends g {
        public hz() {
            super("sendAppMessageToSpecifiedContact", "sendAppMessageToSpecifiedContact", 168, true);
        }
    }

    public static class i extends g {
        public i() {
            super("addCustomMenuItems", "addCustomMenuItems", ErrorCode.STARTDOWNLOAD_5, false);
        }
    }

    static final class ik extends g {
        ik() {
            super(JsApiSetBackgroundAudioState.NAME, JsApiSetBackgroundAudioState.NAME, com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, false);
        }
    }

    public static class im extends g {
        public im() {
            super("setCloseWindowConfirmDialogInfo", "setCloseWindowConfirmDialogInfo", 77, false);
        }
    }

    public static class it extends g {
        public it() {
            super(com.tencent.mm.plugin.appbrand.jsapi.k.o.NAME, com.tencent.mm.plugin.appbrand.jsapi.k.o.NAME, FaceMoveUtil.TRIANGLE_COUNT, false);
        }
    }

    public static class je extends g {
        public je() {
            super("shareWeiboApp", "shareWeiboApp", 107, false);
        }
    }

    static final class jn extends g {
        jn() {
            super("showSearchOfBizHistory", "showSearchOfBizHistory", com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_LOLLY, false);
        }
    }

    public static class jp extends g {
        public jp() {
            super("showSmileyPanel", "showSmileyPanel", com.tencent.view.d.MIC_PTU_SHIGUANG, false);
        }
    }

    public static class k extends g {
        public k() {
            super(JsApiAddDownloadTaskStraight.NAME, "add_download_task_straight", 269, true);
        }
    }

    public static class kh extends g {
        public kh() {
            super(com.tencent.mm.plugin.appbrand.jsapi.share.f.NAME, "share_timeline", 4, true);
        }
    }

    static final class kz extends g {
        kz() {
            super("wcPrivacyPolicyResult", "wcPrivacyPolicyResult", com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, false);
        }
    }

    public static class ln extends g {
        public ln() {
            super("WNNativeCallbackOnClick", "WNNativeCallbackOnClick", 10006, false);
        }
    }

    public static class lt extends g {
        public lt() {
            super("WNNativeCallbackOnBecomeEditing", "WNNativeCallbackOnBecomeEditing", 10006, false);
        }
    }

    static final class q extends g {
        q() {
            super("batchUpdateWepkg", "batchUpdateWepkg", 334, false);
        }
    }

    public static class a extends g {
        public a() {
            super(JsApiGetMusicPlayerState.NAME, JsApiGetMusicPlayerState.NAME, 210, false);
        }
    }

    public static class ax extends g {
        public ax() {
            super("disablePullDownRefresh", "disablePullDownRefresh", 205, false);
        }
    }

    public static class ay extends g {
        public ay() {
            super("disconnectWXDevice", "disconnectWXDevice", 124, true);
        }
    }

    public static class b extends g {
        public b() {
            super(JsApiOperateMusicPlayer.NAME, JsApiOperateMusicPlayer.NAME, 211, false);
        }
    }

    public static class bc extends g {
        public bc() {
            super("doSearchOperation", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class bk extends g {
        bk() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.NAME, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, true);
        }
    }

    static final class cf extends g {
        cf() {
            super("getLocalWePkgInfo", "getLocalWePkgInfo", -2, false);
        }
    }

    static final class cg extends g {
        cg() {
            super("getMatchContactList", "getMatchContactList", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class ch extends g {
        public ch() {
            super("getMsgProofItems", "getMsgProofItems", 226, true);
        }
    }

    public static class ci extends g {
        public ci() {
            super(com.tencent.mm.plugin.appbrand.jsapi.q.d.NAME, "network_type", 16, false);
        }
    }

    static final class di extends g {
        di() {
            super("handleWCPayWalletBuffer", "handleWCPayWalletBuffer", com.tencent.view.d.MIC_PTU_WU, false);
        }
    }

    public static class dj extends g {
        public dj() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    public static class dk extends g {
        public dk() {
            super("hideMenuItems", "hideMenuItems", 85, false);
        }
    }

    public static class dl extends g {
        public dl() {
            super(com.tencent.mm.plugin.appbrand.jsapi.k.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.k.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX, false);
        }
    }

    public static class dr extends g {
        public dr() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.f.NAME, "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class eu extends g {
        eu() {
            super("notifyPageInfo", "notifyPageInfo", -2, false);
        }
    }

    static final class ev extends g {
        ev() {
            super("openWCPayCardList", "openWCPayCardList", com.tencent.view.d.MIC_PTU_DANNAI, true);
        }
    }

    static final class ey extends g {
        ey() {
            super("openCustomWebview", "openCustomWebview", 256, false);
        }
    }

    public static class fh extends g {
        public fh() {
            super("openGameCenter", "openGameCenter", ErrorCode.NEEDDOWNLOAD_FALSE_5, true);
        }
    }

    public static class fz extends g {
        public fz() {
            super("openUrlByExtBrowser", "open_url_by_ext_browser", 55, false);
        }
    }

    public static final class gc extends g {
        gc() {
            super("openWebViewUseFastLoad", "openWebViewUseFastLoad", 336, false);
        }
    }

    static final class gd extends g {
        gd() {
            super("openWeApp", "openWeApp", 250, false);
        }
    }

    public static class ge extends g {
        public ge() {
            super("openWeAppPage", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class gf extends g {
        public gf() {
            super("getBrandWCPayCreateCreditCardRequest", "get_wcpay_create_credit_card_request", 65, true);
        }
    }

    static final class hf extends g {
        hf() {
            super("reportGamePageTime", "reportGamePageTime", 301, false);
        }
    }

    static final class hg extends g {
        hg() {
            super("reportGameWeb", "reportGameWeb", 332, false);
        }
    }

    public static class hh extends g {
        public hh() {
            super("reportIDKey", "reportIDKey", ErrorCode.STARTDOWNLOAD_4, false);
        }
    }

    static final class hi extends g {
        hi() {
            super("reportMiniProgramPageData", "reportMiniProgramPageData", 284, false);
        }
    }

    static final class ho extends g {
        ho() {
            super("requestWxVoicePrintVerifyInternal", "requestWxVoicePrintVerifyInternal", 292, true);
        }
    }

    public static class hr extends g {
        public hr() {
            super("scanLicence", "scanLicence", 203, false);
        }
    }

    public static class id extends g {
        public id() {
            super("sendEnterpriseChat", "sendEnterpriseChat", 222, true);
        }
    }

    public static class ir extends g {
        public ir() {
            super("setLocalData", "setLocalData", 180, false);
        }
    }

    public static class is extends g {
        public is() {
            super("setNavigationBarButtons", "setNavigationBarButtons", JsApiChooseWeChatContact.CTRL_INDEX, false);
        }
    }

    public static class iv extends g {
        public iv() {
            super("setPageTitle", "setPageTitle", 113, false);
        }
    }

    public static class jw extends g {
        public jw() {
            super("startSearchItemDetailPage", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class jx extends g {
        public jx() {
            super("startTempSession", "startTempSession", 128, true);
        }
    }

    public static class jy extends g {
        public jy() {
            super("startVoipCall", "startVoipCall", 230, false);
        }
    }

    public static class ka extends g {
        public ka() {
            super(com.tencent.mm.plugin.appbrand.jsapi.k.aa.NAME, com.tencent.mm.plugin.appbrand.jsapi.k.aa.NAME, 200, false);
        }
    }

    public static class kb extends g {
        public kb() {
            super(JsApiStopRecordVoice.NAME, JsApiStopRecordVoice.NAME, 98, false);
        }
    }

    public static class kc extends g {
        public kc() {
            super("stopScanWXDevice", "stopScanWXDevice", 122, true);
        }
    }

    public static class lc extends g {
        public lc() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", JsApiGetBackgroundAudioState.CTRL_INDEX, false);
        }
    }

    public static class ld extends g {
        public ld() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", 160, false);
        }
    }

    public static class le extends g {
        public le() {
            super("videoProxyStartPlay", "videoProxyStartPlay", 157, false);
        }
    }

    public static class lf extends g {
        public lf() {
            super("videoProxyStopPlay", "videoProxyStopPlay", 158, false);
        }
    }

    public static class ll extends g {
        public ll() {
            super("WNNativeCallbackInitData", "WNNativeCallbackInitData", 10006, false);
        }
    }

    public static class lo extends g {
        public lo() {
            super("WNNativeCallbackOnLongClick", "WNNativeCallbackOnLongClick", 10006, false);
        }
    }

    public static class ma extends g {
        public ma() {
            super("menu:share:timeline", "", 88, false);
        }
    }

    public static class ab extends g {
        public ab() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ae.NAME, com.tencent.mm.plugin.appbrand.jsapi.ae.NAME, 202, true);
        }
    }

    public static class ai extends g {
        public ai() {
            super("clearWebviewCache", "clearWebviewCache", 208, false);
        }
    }

    public static class ap extends g {
        public ap() {
            super("connectToFreeWifi", "connectToFreeWifi", 95, false);
        }
    }

    public static class ar extends g {
        public ar() {
            super("connectWXDevice", "connectWXDevice", 123, true);
        }
    }

    public static class be extends g {
        public be() {
            super("openEmotionUrl", "openEmotionUrl", com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class bs extends g {
        public bs() {
            super("getBrandWCPayRequest", "get_brand_wcpay_request", 28, true);
        }
    }

    static final class bu extends g {
        bu() {
            super("getGameData", "getGameData", 299, false);
        }
    }

    public static class c extends g {
        public c() {
            super("getLocalImgData", "getLocalImgData", 249, false);
        }
    }

    public static class co extends g {
        public co() {
            super("getSearchAvatarList", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class dc extends g {
        public dc() {
            super("getWechatVerifyTicket", "getWechatVerifyTicket", 112, false);
        }
    }

    public static class ds extends g {
        public ds() {
            super(JsApiInstallDownloadTask.NAME, "install_download_task", 41, false);
        }
    }

    static final class du extends g {
        du() {
            super("invokeMiniProgramAPI", "invokeMiniProgramAPI", 295, false);
        }
    }

    public static class ef extends g {
        public ef() {
            super("getWebPayCheckoutCounterRequst", "getWebPayCheckoutCounterRequst", 161, true);
        }
    }

    public static class em extends g {
        public em() {
            super("openTimelineCheckInList", "open_timeline_checkin_list", 62, false);
        }
    }

    public static class eo extends g {
        public eo() {
            super("nfcCheckState", "nfcCheckState", 155, true);
        }
    }

    static final class ex extends g {
        ex() {
            super(JsApiOpenAdCanvas.NAME, JsApiOpenAdCanvas.NAME, 283, true);
        }
    }

    public static class fb extends g {
        public fb() {
            super("openDesignerProfile", "openDesignerProfile", JsApiChooseMedia.CTRL_INDEX, true);
        }
    }

    public static class fp extends g {
        public fp() {
            super("openMyDeviceProfile", "openMyDeviceProfile", 145, false);
        }
    }

    static final class fr extends g {
        fr() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ax.NAME, com.tencent.mm.plugin.appbrand.jsapi.ax.NAME, com.tencent.view.d.MIC_PTU_QINGCHENG, true);
        }
    }

    public static class fy extends g {
        public fy() {
            super("openSpecificView", "specific_view", 48, true);
        }
    }

    static final class gl extends g {
        gl() {
            super("opVoteAdData", "", -2, false);
        }
    }

    public static class hp extends g {
        public hp() {
            super("resendRemittanceMsg", "resendRemittanceMsg", com.tencent.view.d.MIC_PTU_ZIPAI_FAIRYTALE, true);
        }
    }

    public static class ic extends g {
        public ic() {
            super("sendDataToWXDevice", "sendDataToWXDevice", 120, true);
        }
    }

    static final class ij extends g {
        ij() {
            super("setWCPayPassword", "setWCPayPassword", com.tencent.view.d.MIC_PTU_ZIRAN, true);
        }
    }

    public static class il extends g {
        public il() {
            super("setBounceBackground", "setBounceBackground", 218, false);
        }
    }

    public static class iu extends g {
        public iu() {
            super("setPageOwner", "setPageOwner", 114, false);
        }
    }

    public static class j extends g {
        public j() {
            super(JsApiAddDownloadTask.NAME, "add_download_task", 38, false);
        }
    }

    public static class jm extends g {
        public jm() {
            super("showSearchLoading", "showSearchLoading", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class jo extends g {
        public jo() {
            super("showSearchToast", "showSearchToast", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    public static class jv extends g {
        public jv() {
            super("startScanWXDevice", "startScanWXDevice", 121, true);
        }
    }

    public static class ki extends g {
        public ki() {
            super("translateVoice", "translateVoice", 97, true);
        }
    }

    static final class ky extends g {
        ky() {
            super("viewTypeChange", "", Downloads.MIN_WAIT_FOR_NETWORK, false);
        }
    }

    static final class l extends g {
        l() {
            super("addGameDownloadTask", "addGameDownloadTask", -1, true);
        }
    }

    public static class lm extends g {
        public lm() {
            super("WNNativeCallbackOnCaretChange", "WNNativeCallbackOnCaretChange", 10006, false);
        }
    }

    public static class lx extends g {
        public lx() {
            super("menu:share:appmessage", "", 89, false);
        }
    }

    public static class z extends g {
        public z() {
            super("chooseIdCard", "chooseIdCard", 247, true);
        }
    }

    public static Bundle akC(String str) {
        AppMethodBeat.i(79962);
        Bundle bundle = new Bundle();
        bundle.putBoolean("handle", true);
        bundle.putString("handle_result", str);
        AppMethodBeat.o(79962);
        return bundle;
    }

    public static g akD(String str) {
        AppMethodBeat.i(79963);
        if (vxd == null || vxd.size() <= 0) {
            HashMap hashMap = new HashMap(128);
            vxd = hashMap;
            hashMap.put("log", new eg());
            vxd.put("imagePreview", new dp());
            vxd.put(Scopes.PROFILE, new gw());
            vxd.put("shareWeibo", new li());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.share.f.NAME, new kh());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.z.NAME, new n());
            vxd.put("streamingVideoPlay", new ke());
            vxd.put("addContact", new h());
            vxd.put("getWidgetCaptureImgUrl", new de());
            vxd.put("sendAppMessage", new ia());
            vxd.put("scanQRCode", new hs());
            vxd.put("hideOptionMenu", new dm());
            vxd.put("showOptionMenu", new jk());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.q.d.NAME, new ci());
            vxd.put("closeWindow", new ak());
            vxd.put(JsApiGetInstallState.NAME, new cd());
            vxd.put("setFontSizeCallback", new io());
            vxd.put("jumpToInstallUrl", new dw());
            vxd.put("launchApp", new ec());
            vxd.put("getBrandWCPayRequest", new bs());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.i.m.NAME, new hu());
            vxd.put("editAddress", new bd());
            vxd.put("getHeadingAndPitch", new ca());
            vxd.put("sendEmail", new if());
            vxd.put(JsApiAddDownloadTask.NAME, new j());
            vxd.put(JsApiCancelDownloadTask.NAME, new t());
            vxd.put(JsApiPauseDownloadTask.NAME, new gm());
            vxd.put(JsApiResumeDownloadTask.NAME, new hq());
            vxd.put(JsApiQueryDownloadTask.NAME, new gx());
            vxd.put(JsApiInstallDownloadTask.NAME, new ds());
            vxd.put("getLatestAddress", new cl());
            vxd.put("openSpecificView", new fy());
            vxd.put("jumpWCMall", new dy());
            vxd.put("launch3rdApp", new eb());
            vxd.put(JsApiWriteCommData.NAME, new lp());
            vxd.put("openUrlByExtBrowser", new fz());
            vxd.put("geoLocation", new bp());
            vxd.put("getBrandWCPayBindCardRequest", new br());
            vxd.put("openProductView", new fs());
            vxd.put("openProductViewWithPid", new ft());
            vxd.put("jumpToBizProfile", new dx());
            vxd.put("openTimelineCheckInList", new em());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.e.j.NAME, new el());
            vxd.put("timelineCheckIn", new ek());
            vxd.put("getBrandWCPayCreateCreditCardRequest", new gf());
            vxd.put("chooseCard", new y());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.ae.NAME, new ab());
            vxd.put("sendServiceAppMessage", new ig());
            vxd.put("musicPlay", new ej());
            vxd.put("mmsf0001", new bv());
            vxd.put("connectToWiFi", new aq());
            vxd.put("getTransferMoneyRequest", new da());
            vxd.put("openWCPaySpecificView", new gb());
            vxd.put("setCloseWindowConfirmDialogInfo", new im());
            vxd.put("batchAddCard", new p());
            vxd.put("preVerifyJSAPI", new gt());
            vxd.put(JsApiStartRecordVoice.NAME, new ju());
            vxd.put(JsApiStopRecordVoice.NAME, new kb());
            vxd.put(JsApiStartPlayVoice.NAME, new go());
            vxd.put(JsApiPausePlayVoice.NAME, new gn());
            vxd.put(JsApiStopPlayVoice.NAME, new kd());
            vxd.put("uploadVoice", new kv());
            vxd.put("downloadVoice", new ba());
            vxd.put(JsApiChooseImage.NAME, new aa());
            vxd.put("uploadImage", new ks());
            vxd.put("downloadImage", new az());
            vxd.put("uploadMediaFile", new kt());
            vxd.put("hideMenuItems", new dk());
            vxd.put("showMenuItems", new ji());
            vxd.put("hideAllNonBaseMenuItem", new dj());
            vxd.put("showAllNonBaseMenuItem", new jf());
            vxd.put("checkJsApi", new x());
            vxd.put("translateVoice", new ki());
            vxd.put("shareQQ", new jc());
            vxd.put("shareWeiboApp", new je());
            vxd.put("shareQZone", new jd());
            vxd.put("connectToFreeWifi", new ap());
            vxd.put("getSendC2CMessageRequest", new cx());
            vxd.put("batchViewCard", new r());
            vxd.put("configWXDeviceWiFi", new an());
            vxd.put("getCurrentSSID", new bt());
            vxd.put("setPageOwner", new iu());
            vxd.put("getWechatVerifyTicket", new dc());
            vxd.put("openWXDeviceLib", new gg());
            vxd.put("startScanWXDevice", new jv());
            vxd.put("stopScanWXDevice", new kc());
            vxd.put("connectWXDevice", new ar());
            vxd.put("disconnectWXDevice", new ay());
            vxd.put("getWXDeviceTicket", new dg());
            vxd.put("getWXDeviceInfos", new df());
            vxd.put("sendDataToWXDevice", new ic());
            vxd.put("closeWXDeviceLib", new am());
            vxd.put("setSendDataDirection", new iy());
            vxd.put("verifyWCPayPassword", new kx());
            vxd.put("getPaymentOrderRequest", new ck());
            vxd.put("openGameDetail", new fi());
            vxd.put("openGameCenter", new fh());
            vxd.put("setGameDebugConfig", new iq());
            vxd.put("startTempSession", new jx());
            vxd.put("getH5PrepayRequest", new cb());
            vxd.put("getH5TransactionRequest", new cc());
            vxd.put("menu:share:timeline", new ma());
            vxd.put("menu:share:appmessage", new lx());
            vxd.put("menu:share:qq", new ly());
            vxd.put("menu:share:weiboApp", new mb());
            vxd.put("menu:setfont", new lw());
            vxd.put("menu:share:weibo", new mb());
            vxd.put("menu:share:QZone", new lz());
            vxd.put("getRecevieBizHongBaoRequest", new e());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.video.f.NAME, new dr());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.video.j.NAME, new kp());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.video.i.NAME, new hd());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.video.h.NAME, new gk());
            vxd.put("deleteSearchHistory", new av());
            vxd.put("getSearchHistory", new ct());
            vxd.put("getSearchData", new cp());
            vxd.put("getPoiInfo", new bz());
            vxd.put("updateReddotTimeStamps", new kl());
            vxd.put("getTeachSearchData", new cz());
            vxd.put("getSearchGuideData", new cs());
            vxd.put("getSearchAvatarList", new co());
            vxd.put("getSearchSnsImageList", new cv());
            vxd.put("getSearchImageList", new cu());
            vxd.put("getSearchDisplayNameList", new cq());
            vxd.put("startSearchItemDetailPage", new jw());
            vxd.put("reportSearchStatistics", new hk());
            vxd.put("reportSearchRealTimeStatistics", new hj());
            vxd.put("searchDataHasResult", new ht());
            vxd.put("openEmotionPage", new bm());
            vxd.put("getSearchSuggestionData", new cw());
            vxd.put("setSearchInputWord", new ix());
            vxd.put("setSnsObjectXmlDescList", new iz());
            vxd.put("clickSnsMusicPlayButton", new aj());
            vxd.put("openWeAppPage", new ge());
            vxd.put("reportWeAppSearchRealtime", new lj());
            vxd.put("doSearchOperation", new bc());
            vxd.put("insertSearchWAWidgetView", new dq());
            vxd.put("removeSearchWAWidgetView", new hc());
            vxd.put("updateSearchWAWidgetView", new kn());
            vxd.put("showSearchActionSheet", new jl());
            vxd.put("cancelSearchActionSheet", new u());
            vxd.put("showSearchToast", new jo());
            vxd.put("showSearchLoading", new jm());
            vxd.put("hideSearchLoading", new dn());
            vxd.put("updateWASearchTemplate", new kq());
            vxd.put("preloadSearchWeapp", new gr());
            vxd.put("uxSearchOpLog", new kw());
            vxd.put("jumpToWXWallet", new dz());
            vxd.put("scanCover", new f());
            vxd.put("reportActionInfo", new he());
            vxd.put("openMyDeviceProfile", new fp());
            vxd.put("selectPedometerSource", new hx());
            vxd.put("nfcIsConnect", new es());
            vxd.put("nfcConnect", new ep());
            vxd.put("nfcTransceive", new et());
            vxd.put("nfcBatchTransceive", new en());
            vxd.put("nfcGetId", new eq());
            vxd.put("nfcGetInfo", new er());
            vxd.put("startMonitoringBeacons", new js());
            vxd.put("stopMonitoringBeacons", new jz());
            vxd.put("nfcCheckState", new eo());
            vxd.put("videoProxyInit", new lb());
            vxd.put("videoProxyStartPlay", new le());
            vxd.put("videoProxyStopPlay", new lf());
            vxd.put("videoProxySetPlayerState", new lc());
            vxd.put("videoProxySetRemainTime", new ld());
            vxd.put("videoProxyPreload", new lh());
            vxd.put("getWebPayCheckoutCounterRequst", new ef());
            vxd.put("addCustomMenuItems", new i());
            vxd.put("operateGameCenterMsg", new gj());
            vxd.put("openEnterpriseChat", new ff());
            vxd.put("enterEnterpriseChat", new bh());
            vxd.put("openEnterpriseContact", new fg());
            vxd.put("selectEnterpriseContact", new hw());
            vxd.put("getEnterpriseChat", new bx());
            vxd.put("reportIDKey", new hh());
            vxd.put("quicklyAddBrandContact", new gy());
            vxd.put("consumedShareCard", new as());
            vxd.put("cache", new la());
            vxd.put("publicCache", new lg());
            vxd.put("kvReport", new ea());
            vxd.put("realtimeReport", new gz());
            vxd.put("openUrlWithExtraWebview", new ga());
            vxd.put("setFreeWifiOwner", new ip());
            vxd.put("selectSingleContact", new hy());
            vxd.put("sendAppMessageToSpecifiedContact", new hz());
            vxd.put("setLocalData", new ir());
            vxd.put("getLocalData", new ce());
            vxd.put("clearLocalData", new ah());
            vxd.put("showKeyboard", new jh());
            vxd.put("showSmileyPanel", new jp());
            vxd.put("disableBounceScroll", new aw());
            vxd.put("clearBounceBackground", new af());
            vxd.put("setNavigationBarButtons", new is());
            vxd.put("enableFullScreen", new bf());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.k.x.NAME, new jj());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.k.d.NAME, new dl());
            vxd.put("enablePullDownRefresh", new bg());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.k.z.NAME, new jt());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.k.aa.NAME, new ka());
            vxd.put("disablePullDownRefresh", new ax());
            vxd.put("setPageTitle", new iv());
            vxd.put("setStatusBarStyle", new ja());
            vxd.put("deleteAccountSuccess", new au());
            vxd.put(JsApiChooseVideo.NAME, new ae());
            vxd.put("uploadVideo", new ku());
            vxd.put("openMapNavigateMenu", new fo());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.k.o.NAME, new it());
            vxd.put("getWCPayRealnameVerify", new db());
            vxd.put("openDesignerEmojiView", new ez());
            vxd.put("openDesignerProfile", new fb());
            vxd.put("openEmoticonTopicList", new fe());
            vxd.put("openDesignerEmojiViewLocal", new fa());
            vxd.put("openDesignerProfileLocal", new fc());
            vxd.put("openEmotionDetailViewLocal", new d());
            vxd.put("openNewPage", new fq());
            vxd.put("getSearchEmotionData", new cr());
            vxd.put("openEmotionUrl", new be());
            vxd.put("WNNativeCallbackOnClick", new ln());
            vxd.put("WNNativeCallbackOnLongClick", new lo());
            vxd.put("WNNativeCallbackOnCaretChange", new lm());
            vxd.put("WNNativeCallbackInitData", new ll());
            vxd.put("WNNativeAsyncCallback", new lk());
            vxd.put("WNNativeCallbackOnBecomeEditing", new lt());
            vxd.put("WNNativeCallbackOnBecomeEdited", new lu());
            vxd.put("changePayActivityView", new v());
            vxd.put("selectWalletCurrency", new kf());
            vxd.put("scanLicence", new hr());
            vxd.put(JsApiOperateMusicPlayer.NAME, new b());
            vxd.put(JsApiGetMusicPlayerState.NAME, new a());
            vxd.put("clearWebviewCache", new ai());
            vxd.put("requireSoterBiometricAuthentication", new jq());
            vxd.put("getSupportSoter", new jr());
            vxd.put("unbindBankCard", new kj());
            vxd.put("setBounceBackground", new il());
            vxd.put("sendEnterpriseChat", new id());
            vxd.put("doExposePreparation", new bb());
            vxd.put("getMsgProofItems", new ch());
            vxd.put("openSecurityView", new fx());
            vxd.put("startVoipCall", new jy());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.af.NAME, new ac());
            vxd.put("getOpenDeviceId", new cj());
            vxd.put("getRouteUrl", new cn());
            vxd.put("idCardRealnameVerify", new do());
            vxd.put("uploadIdCardSuccess", new md());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.m.e.NAME, new jg());
            vxd.put("openLuckyMoneyDetailView", new fm());
            vxd.put("resendRemittanceMsg", new hp());
            vxd.put("getGameCommInfo", new by());
            vxd.put("openGameRegion", new fj());
            vxd.put("chooseIdCard", new z());
            vxd.put("getLocalImgData", new c());
            vxd.put("openWeApp", new gd());
            vxd.put("recordVideo", new ha());
            vxd.put("previewVideo", new gs());
            vxd.put("uploadEncryptMediaFile", new kr());
            vxd.put(JsApiChooseMedia.NAME, new ad());
            vxd.put("requestWxFacePictureVerify", new bi());
            vxd.put("openCustomWebview", new ey());
            vxd.put("forceUpdateWxaAttr", new bl());
            vxd.put("openLuckyMoneyHistory", new fn());
            vxd.put("menuitem:gameSendDesktop", new ie());
            vxd.put("getWePkgAuthResult", new dd());
            vxd.put("getLocalWePkgInfo", new cf());
            vxd.put("openGameWebView", new fl());
            vxd.put("reportGameWeb", new hg());
            vxd.put("launchApplication", new ed());
            vxd.put("showSearchOfBizHistory", new jn());
            vxd.put("login", new eh());
            vxd.put("authorize", new o());
            vxd.put("requestWxFacePictureVerifyUnionVideo", new bj());
            vxd.put("checkIsSupportFaceDetect", new w());
            vxd.put(JsApiOperateBackgroundAudio.NAME, new gi());
            vxd.put(JsApiSetBackgroundAudioState.NAME, new ik());
            vxd.put(JsApiGetBackgroundAudioState.NAME, new bq());
            vxd.put(JsApiAddDownloadTaskStraight.NAME, new k());
            vxd.put("setScreenOrientation", new iw());
            vxd.put("addToEmoticon", new m());
            vxd.put("shareEmoticon", new jb());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.as.NAME, new ei());
            vxd.put(JsApiOpenAdCanvas.NAME, new ex());
            vxd.put("openSearchCanvas", new fu());
            vxd.put("opVoteAdData", new gl());
            vxd.put("requestWxFaceRegisterInternal", new hm());
            vxd.put("requestWxFaceVerifyInternal", new hn());
            vxd.put(JsApiLaunchMiniProgram.NAME, new ee());
            vxd.put("reportMiniProgramPageData", new hi());
            vxd.put("selectContact", new hv());
            vxd.put("openSearchWAWidgetLogView", new fv());
            vxd.put("reloadSearchWAWidgetData", new hb());
            vxd.put("closeWindowAndGoNext", new al());
            vxd.put("requestWxVoicePrintVerifyInternal", new ho());
            vxd.put("openBizChat", new ew());
            vxd.put("handleWCPayWalletBuffer", new di());
            vxd.put("tapSearchWAWidgetView", new kg());
            vxd.put("getMatchContactList", new cg());
            vxd.put("openSearchWebView", new fw());
            vxd.put("openWXSearchPage", new gh());
            vxd.put("viewTypeChange", new ky());
            vxd.put("invokeMiniProgramAPI", new du());
            vxd.put("openGameUrlWithExtraWebView", new fk());
            vxd.put("setGameData", new in());
            vxd.put("getGameData", new bu());
            vxd.put("clearGameData", new ag());
            vxd.put("openECard", new fd());
            vxd.put("reportGamePageTime", new hf());
            vxd.put("setWCPayPassword", new ij());
            vxd.put("openWCPayCardList", new ev());
            vxd.put("bindEmail", new s());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.ax.NAME, new fr());
            vxd.put("bindEmail", new s());
            vxd.put("doGoToRecVideoList", new cm());
            vxd.put("jumpWSRecVideoList", new lv());
            vxd.put("openWebSearchOutLinkItem", new mc());
            vxd.put("recordHistory", new bo());
            LinkedList<g> linkedList = new LinkedList();
            linkedList.add(new gq());
            linkedList.add(new gp());
            linkedList.add(new ib());
            linkedList.add(new dh());
            linkedList.add(new gv());
            linkedList.add(new gu());
            linkedList.add(new bn());
            linkedList.add(new gc());
            linkedList.add(new ao());
            for (g gVar : linkedList) {
                vxd.put(gVar.getName(), gVar);
            }
            vxd.put("getSystemInfo", new cy());
            vxd.put("serviceClick", new ii());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME, new ls());
            vxd.put("sendSingleAppMessage", new ih());
            vxd.put("wcPrivacyPolicyResult", new kz());
            vxd.put("currentMpInfo", new at());
            vxd.put("updateAppMessageShareData", new km());
            vxd.put("updateTimelineShareData", new ko());
            vxd.put("getCCData", new lr());
            vxd.put("calRqt", new lq());
            vxd.put(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.NAME, new bk());
            vxd.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, new hl());
            vxd.put("notifyPageInfo", new eu());
            vxd.put("updatePageAuth", new kk());
            vxd.put("jumpDownloaderWidget", new dv());
            vxd.put("batchUpdateWepkg", new q());
            vxd.put("addGameDownloadTask", new l());
            vxd.put("internelWxFaceVerify", new dt());
            vxd.put("getDownloadWidgetTaskInfos", new bw());
        }
        g gVar2 = (g) vxd.get(str);
        AppMethodBeat.o(79963);
        return gVar2;
    }
}

package com.tencent.mars.cdn;

import com.facebook.internal.Utility;
import com.tencent.mars.Mars;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class CdnLogic {
    public static final int HIT_FILEID = 1;
    public static final int HIT_UPLOADCHECKMD5 = 2;
    public static final int HIT_UPLOADWITHMD5 = 3;
    public static final int ImageFormat_HEVC = 2;
    public static final int ImageFormat_JPEG = 1;
    public static final int MediaTypeAppImage = 20301;
    public static final int MediaTypeFriendsADImageThumb = 20204;
    public static final int MediaTypeFriendsImageThumb = 20205;
    public static final int MediaTypeFriendsVideoThumbImage = 20250;
    public static final int MediaType_FAVORITE_FILE = 10001;
    public static final int MediaType_FAVORITE_VIDEO = 10002;
    public static final int MediaType_FILE = 5;
    public static final int MediaType_FRIENDS = 20201;
    public static final int MediaType_FRIENDS_Video = 20202;
    public static final int MediaType_FULLSIZEIMAGE = 1;
    public static final int MediaType_GlanceVideo = 90;
    public static final int MediaType_IMAGE = 2;
    public static final int MediaType_SnsAdLangdingPageVideo = 100;
    public static final int MediaType_THUMBIMAGE = 3;
    public static final int MediaType_TinyVideo = 6;
    public static final int MediaType_VIDEO = 4;
    public static final int MediaType_WIMDownload = 19;
    public static final int NO_ERROR = 0;
    public static final int NO_HITCACHE = 0;
    public static final int PreloadMode = 2;
    public static final int StorageMode = 0;
    private static final String TAG = "mars.CdnLogic";
    public static final int VideoFormat_Unknown = 0;
    public static final int VideoFormat_X264 = 1;
    public static final int VideoFormat_X265 = 2;
    public static final int VideoPlayMode = 1;
    public static final String defaultApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
    public static final int kAppTypeAdImage = 109;
    public static final int kAppTypeAdVideo = 105;
    public static final int kAppTypeAny = 0;
    public static final int kAppTypeC2C = 1;
    public static final int kAppTypeC2CGroupChat = 2;
    public static final int kAppTypeFavorite = 10;
    public static final int kAppTypeHDVideo = 205;
    public static final int kAppTypeHwPage = 200;
    public static final int kAppTypeMultiJpeg = 101;
    public static final int kAppTypeMultiVCodec = 108;
    public static final int kAppTypeMultiWebp = 104;
    public static final int kAppTypeNearEvent = 201;
    public static final int kAppTypeShop = 200;
    public static final int kAppTypeSingleJpeg = 100;
    public static final int kAppTypeSingleVCodec = 107;
    public static final int kAppTypeSingleWebp = 103;
    public static final int kAppTypeUnknown = -1;
    public static final int kAppTypeVideo = 102;
    public static final int kAppTypeVideoThumb = 150;
    public static final int kAppTypeYunStorage = 202;
    public static final int kBizAny = 0;
    public static final int kBizApp = 4;
    public static final int kBizC2C = 1;
    public static final int kBizFavorite = 2;
    public static final int kBizGeneric = 65535;
    public static final int kBizSns = 3;
    public static final int kBizUnknown = -1;
    public static final int kErrSafeProtoNoAeskey = -21111;
    public static final int kErrUploadHevcIllegal = -5103237;
    public static final int kIpSource_NewDNS = 1;
    public static final int kIpSource_None = 0;
    public static final int kIpSource_SysDNS = 2;
    public static final int kMediaGamePacket = 30002;
    public static final int kMediaLittleAppPacket = 30001;
    public static final int kMediaTypeAdImage = 20204;
    public static final int kMediaTypeAdVideo = 20210;
    public static final int kMediaTypeAny = 0;
    public static final int kMediaTypeAppFile = 20303;
    public static final int kMediaTypeAppVideo = 20302;
    public static final int kMediaTypeBackupFile = 20001;
    public static final int kMediaTypeBeatificFile = 10011;
    public static final int kMediaTypeBigFile = 7;
    public static final int kMediaTypeExposeImage = 11000;
    public static final int kMediaTypeFavoriteBigFile = 10007;
    public static final int kMediaTypeFavoriteFile = 10001;
    public static final int kMediaTypeFavoriteVideo = 10002;
    public static final int kMediaTypeFile = 5;
    public static final int kMediaTypeFriends = 20201;
    public static final int kMediaTypeFriendsVideo = 20202;
    public static final int kMediaTypeFriendsVideoThumbImage = 20250;
    public static final int kMediaTypeFullSizeImage = 1;
    public static final int kMediaTypeHWDevice = 20322;
    public static final int kMediaTypeHWDeviceFile = 20303;
    public static final int kMediaTypeImage = 2;
    public static final int kMediaTypeNearEvent = 20310;
    public static final int kMediaTypeShop = 20301;
    public static final int kMediaTypeSmartHwPage = 20321;
    public static final int kMediaTypeStoryAudio = 40001;
    public static final int kMediaTypeThumbImage = 3;
    public static final int kMediaTypeTinyVideo = 6;
    public static final int kMediaTypeVideo = 4;
    public static final int kMultiImageDownload = 2;
    public static final int kSingleImageDownload = 1;

    public interface AppCallback {
        void reportFlow(int i, int i2, int i3, int i4);

        void requestGetCDN(int i);

        String[] resolveHost(String str, boolean z, int[] iArr);
    }

    public static class C2CDownloadRequest {
        public String aeskey = "";
        public boolean allow_mobile_net_download = false;
        public String argInfo = "";
        public String bakup_url = "";
        public BatchSnsReqImageData[] batchSnsReqImageDatas = null;
        public String bigfileSignature = "";
        public int certificateVerifyPolicy = 2;
        public int chatType = 0;
        public int concurrentCount = 1;
        public int connectionCount = 1;
        public String customHttpHeader = "";
        public String[] dcIpList = null;
        public int dcIpListSource = 2;
        public int expectImageFormat = 1;
        public String fakeBigfileSignature = "";
        public String fakeBigfileSignatureAeskey = "";
        public String feedId = "";
        public int feedPicCount;
        public String fileKey = "";
        public int fileSize = 0;
        public int fileType = 0;
        public String fileid = "";
        public String host = "";
        public int initialDownloadLength = -1;
        public int initialDownloadOffset = -1;
        public boolean isAutoStart = false;
        public boolean isColdSnsData = false;
        public boolean isLargeSVideo = false;
        public boolean isSilentTask = false;
        public boolean isSmallVideo = false;
        public boolean isStorageMode = false;
        public boolean is_resume_task = false;
        public int limitRate = 0;
        public int marscdnAppType = -1;
        public int marscdnBizType = -1;
        public int maxHttpRedirectCount = 3;
        public String msgExtra = "";
        public int msgType = 1;
        public String[] ocIpList = null;
        public int ocIpListSource = 2;
        public int preloadRatio = 30;
        public int queueTimeoutSeconds = 1800;
        public String referer = "";
        public int requestVideoFormat = 1;
        public String savePath = "";
        public String serialized_verify_headers = "";
        public String signalQuality = "";
        public String snsCipherKey = "";
        public String snsScene = "";
        public String statePath = "";
        public int transforTimeoutSeconds = 600;
        public String url = "";
        public boolean useMultithread = false;
        public String videofileid = "";
        public boolean wifiAutoStart = false;

        public C2CDownloadRequest fakeBigfileSignature(String str) {
            this.fakeBigfileSignature = str;
            return this;
        }

        public C2CDownloadRequest fakeBigfileSignatureAeskey(String str) {
            this.fakeBigfileSignatureAeskey = str;
            return this;
        }

        public C2CDownloadRequest argInfo(String str) {
            this.argInfo = str;
            return this;
        }

        public C2CDownloadRequest limitRate(int i) {
            this.limitRate = i;
            return this;
        }

        public C2CDownloadRequest isSilentTask(boolean z) {
            this.isSilentTask = z;
            return this;
        }

        public C2CDownloadRequest queueTimeoutSeconds(int i) {
            this.queueTimeoutSeconds = i;
            return this;
        }

        public C2CDownloadRequest transforTimeoutSeconds(int i) {
            this.transforTimeoutSeconds = i;
            return this;
        }

        public C2CDownloadRequest chatType(int i) {
            this.chatType = i;
            return this;
        }

        public C2CDownloadRequest isStorageMode(boolean z) {
            this.isStorageMode = z;
            return this;
        }

        public C2CDownloadRequest isSmallVideo(boolean z) {
            this.isSmallVideo = z;
            return this;
        }

        public C2CDownloadRequest isLargeSVideo(boolean z) {
            this.isLargeSVideo = z;
            return this;
        }

        public C2CDownloadRequest isAutoStart(boolean z) {
            this.isAutoStart = z;
            return this;
        }

        public C2CDownloadRequest videofileid(String str) {
            this.videofileid = str;
            return this;
        }

        public C2CDownloadRequest msgExtra(String str) {
            this.msgExtra = str;
            return this;
        }

        public C2CDownloadRequest bigfileSignature(String str) {
            this.bigfileSignature = str;
            return this;
        }

        public C2CDownloadRequest initialDownloadOffset(int i) {
            this.initialDownloadOffset = i;
            return this;
        }

        public C2CDownloadRequest initialDownloadLength(int i) {
            this.initialDownloadLength = i;
            return this;
        }

        public C2CDownloadRequest requestVideoFormat(int i) {
            this.requestVideoFormat = i;
            return this;
        }

        public C2CDownloadRequest isColdSnsData(boolean z) {
            this.isColdSnsData = z;
            return this;
        }

        public C2CDownloadRequest preloadRatio(int i) {
            this.preloadRatio = i;
            return this;
        }

        public C2CDownloadRequest host(String str) {
            this.host = str;
            return this;
        }

        public C2CDownloadRequest referer(String str) {
            this.referer = str;
            return this;
        }

        public C2CDownloadRequest ocIpList(String[] strArr) {
            this.ocIpList = strArr;
            return this;
        }

        public C2CDownloadRequest ocIpListSource(int i) {
            this.ocIpListSource = i;
            return this;
        }

        public C2CDownloadRequest dcIpList(String[] strArr) {
            this.dcIpList = strArr;
            return this;
        }

        public C2CDownloadRequest dcIpListSource(int i) {
            this.dcIpListSource = i;
            return this;
        }

        public C2CDownloadRequest snsCipherKey(String str) {
            this.snsCipherKey = str;
            return this;
        }

        public C2CDownloadRequest signalQuality(String str) {
            this.signalQuality = str;
            return this;
        }

        public C2CDownloadRequest snsScene(String str) {
            this.snsScene = str;
            return this;
        }

        public C2CDownloadRequest customHttpHeader(String str) {
            this.customHttpHeader = str;
            return this;
        }

        public C2CDownloadRequest bakup_url(String str) {
            this.bakup_url = str;
            return this;
        }

        public C2CDownloadRequest serialized_verify_headers(String str) {
            this.serialized_verify_headers = str;
            return this;
        }

        public C2CDownloadRequest allow_mobile_net_download(boolean z) {
            this.allow_mobile_net_download = z;
            return this;
        }

        public C2CDownloadRequest is_resume_task(boolean z) {
            this.is_resume_task = z;
            return this;
        }

        public C2CDownloadRequest concurrentCount(int i) {
            this.concurrentCount = i;
            return this;
        }

        public C2CDownloadRequest maxHttpRedirectCount(int i) {
            this.maxHttpRedirectCount = i;
            return this;
        }

        public C2CDownloadRequest wifiAutoStart(boolean z) {
            this.wifiAutoStart = z;
            return this;
        }

        public C2CDownloadRequest statePath(String str) {
            this.statePath = str;
            return this;
        }

        public C2CDownloadRequest connectionCount(int i) {
            this.connectionCount = i;
            return this;
        }

        public C2CDownloadRequest useMultithread(boolean z) {
            this.useMultithread = z;
            return this;
        }

        public C2CDownloadRequest certificateVerifyPolicy(int i) {
            this.certificateVerifyPolicy = i;
            return this;
        }

        public C2CDownloadRequest expectImageFormat(int i) {
            this.expectImageFormat = i;
            return this;
        }

        public static C2CDownloadRequest createC2C(String str, String str2, int i, String str3) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.fileid = str;
            c2CDownloadRequest.aeskey = str2;
            c2CDownloadRequest.fileType = i;
            c2CDownloadRequest.savePath = str3;
            c2CDownloadRequest.marscdnBizType = 1;
            c2CDownloadRequest.marscdnAppType = 1;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createSNS(String str, int i, String str2) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.url = str;
            c2CDownloadRequest.fileType = i;
            c2CDownloadRequest.savePath = str2;
            c2CDownloadRequest.marscdnBizType = 3;
            c2CDownloadRequest.marscdnAppType = 100;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createFavorite(String str, String str2, int i, String str3) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.fileid = str;
            c2CDownloadRequest.aeskey = str2;
            c2CDownloadRequest.fileType = i;
            c2CDownloadRequest.savePath = str3;
            c2CDownloadRequest.marscdnBizType = 2;
            c2CDownloadRequest.marscdnAppType = 10;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createC2CVideo(String str, String str2, int i, String str3) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.fileid = str;
            c2CDownloadRequest.aeskey = str2;
            c2CDownloadRequest.fileType = i;
            c2CDownloadRequest.savePath = str3;
            c2CDownloadRequest.marscdnBizType = 1;
            c2CDownloadRequest.marscdnAppType = 1;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createHttpVideo(String str, String str2) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.url = str;
            c2CDownloadRequest.savePath = str2;
            c2CDownloadRequest.marscdnBizType = 4;
            c2CDownloadRequest.marscdnAppType = 102;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createHttp(String str, String str2) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.url = str;
            c2CDownloadRequest.savePath = str2;
            c2CDownloadRequest.marscdnBizType = 4;
            c2CDownloadRequest.marscdnAppType = 102;
            return c2CDownloadRequest;
        }
    }

    public interface UploadCallback {
        void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult);

        void onUploadProgressChanged(String str, int i, int i2);
    }

    public static class Config {
        public int AckSlice = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        public String ApprovedVideoHosts = CdnLogic.defaultApprovedVideoHosts;
        public int C2COverloadDelaySeconds = 10;
        public int EnableCDNVerifyConnect = 1;
        public int EnableCDNVideoRedirectOC = 1;
        public int EnableSafeCDN = 0;
        public int EnableSnsImageDownload = 0;
        public int EnableSnsStreamDownload = 0;
        public int EnableStreamUploadVideo = 1;
        public int MobileEtl = 70;
        public int Ptl = 35;
        public int SNSOverloadDelaySeconds = 60;
        public int UseDynamicETL = 0;
        public int UseStreamCDN = 1;
        public int WifiEtl = 90;
        public boolean onlyrecvPtl = false;
        public boolean onlysendETL = false;

        public String toString() {
            return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d,safecdn:%d,snsstream:%d, snsimage:%d", new Object[]{Integer.valueOf(this.WifiEtl), Integer.valueOf(this.MobileEtl), Integer.valueOf(this.Ptl), Integer.valueOf(this.UseStreamCDN), Boolean.valueOf(this.onlysendETL), Boolean.valueOf(this.onlyrecvPtl), Integer.valueOf(this.AckSlice), Integer.valueOf(this.EnableCDNVerifyConnect), Integer.valueOf(this.EnableCDNVideoRedirectOC), Integer.valueOf(this.EnableStreamUploadVideo), Integer.valueOf(this.UseDynamicETL), Integer.valueOf(this.C2COverloadDelaySeconds), Integer.valueOf(this.SNSOverloadDelaySeconds), Integer.valueOf(this.EnableSafeCDN), Integer.valueOf(this.EnableSnsStreamDownload), Integer.valueOf(this.EnableSnsImageDownload)});
        }
    }

    public static class GetCdnScene {
        public static final int GET_CDN_AUTH = 1;
        public static final int GET_CDN_CHECK = 4;
        public static final int GET_CDN_DEFAULT = 0;
        public static final int GET_CDN_IGNORE_FETCH_RETRY = 6;
        public static final int GET_CDN_MARS_CACHE_EXPIRED = 9;
        public static final int GET_CDN_MARS_SVR_REQUEST = 8;
        public static final int GET_CDN_MARS_TIMING_FETCH = 7;
        public static final int GET_CDN_NETWORK_CHANGE = 2;
        public static final int GET_CDN_NETWORK_CHANGE_RETRY = 3;
        public static final int GET_CDN_TEST = 5;
        public static final int GET_CDN_USER_ATTRIBUTE_CHANGED = 10;
    }

    public static class SpeedType {
        public static final int stDownload = 2;
        public static final int stUpload = 1;
    }

    public static class C2CDownloadResult {
        public String argInfo = "";
        public int averageConnectCost = 0;
        public int averageRequestCost = 0;
        public int averageRequestSize = 0;
        public int averageSpeed = 0;
        public String batchImageFileKey = "";
        public BatchSnsReqImageData[] batchImageNeedRetry = null;
        public String batchPicFeedId = "";
        public int cSeqCheck = 0;
        public String clientIP = "";
        public int connectCostTime = 0;
        public boolean crossNet = false;
        public int delayTime = 0;
        public int dnsCostTime = 0;
        public long enQueueTime = 0;
        public long endTime = 0;
        public int errorCode = 0;
        public int fileSize = 0;
        public String fileid = "";
        public int firstConnectCost = 0;
        public boolean firstRequestCompleted = false;
        public int firstRequestCost = 0;
        public int firstRequestDownloadSize = 0;
        public int firstRequestSize = 0;
        public String httpResponseHeader = "";
        public int httpStatusCode = 0;
        public boolean isResume = false;
        public boolean isSnsImageProtocolAvailable;
        public boolean moovCompleted = false;
        public int moovCost = 0;
        public int moovFailReason = 0;
        public int moovRequestTimes = 0;
        public int moovSize = 0;
        public int netConnectTimes = 0;
        public String picCachePath = "";
        public int picIndex = -1;
        public int previousCompletedSize = 0;
        public String realUsedURL = "";
        public int receiveCostTime = 0;
        public int recvedBytes = 0;
        public int requestCompletedCount = 0;
        public int requestTimeoutCount = 0;
        public int requestTotalCount = 0;
        public String serverIP = "";
        public long startTime = 0;
        public String transforMsg = "";
        public boolean usePrivateProtocol = false;
        public String[] usedSvrIps;
        public int videoFormat = 0;
        public int waitResponseCostTime = 0;
        public String xErrorNo = "";
    }

    public interface VideoStreamingCallback {
        void onDataAvailable(String str, int i, int i2);

        void onDownloadToEnd(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);

        void onPreloadCompletedWithResult(String str, int i, int i2, C2CDownloadResult c2CDownloadResult);
    }

    public static class BatchSnsReqImageData {
        public String decryptKey = "";
        public String fileKey = "";
        public String imageCachePath = "";
        public int picIndex = 0;
        public boolean retry = true;
        public int totalFileSize = 0;
        public String url = "";
    }

    public static class CdnInfo {
        public byte[] authkey = null;
        public int frontid = 0;
        public String frontip1 = null;
        public String frontip2 = null;
        public int[] frontports = null;
        public int nettype = 0;
        public int uin = 0;
        public int ver = 0;
        public int zoneid = 0;
        public String zoneip1 = null;
        public String zoneip2 = null;
        public int[] zoneports = null;
    }

    public interface DownloadCallback {
        void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult);

        void onDownloadProgressChanged(String str, int i, int i2, boolean z);
    }

    public static class C2CUploadResult {
        public String aeskey = "";
        public String clientIP = "";
        public int connectCostTime = 0;
        public boolean crossNet = false;
        public int delayTime = 0;
        public int errorCode = 0;
        public boolean existOnSvr = false;
        public int fileCrc32 = 0;
        public int fileSize = 0;
        public String fileUrl = "";
        public String fileid = "";
        public String filemd5 = "";
        public int filetype = 0;
        public int hitCache = 0;
        public boolean isResume = false;
        public boolean isVideoReduced = false;
        public int midfileSize = 0;
        public String mp4identifymd5 = "";
        public int receiveCostTime = 0;
        public boolean sendmsgFromCDN = false;
        public String serverIP = "";
        public byte[] skeyrespbuf = null;
        public int thumbfileSize = 0;
        public String thumbfileUrl = "";
        public String thumbfilemd5 = "";
        public String touser = "";
        public String transforMsg = "";
        public boolean uploadBySafecdn = false;
        public String[] usedSvrIps;
        public String videofileid = "";
        public int waitResponseCostTime = 0;
    }

    public static class CdnInfoParams {
        public int c2CretryIntervalMs = 0;
        public int c2CrwtimeoutMs = 0;
        public int c2CshowErrorDelayMs = 0;
        public int snsretryIntervalMs = 0;
        public int snsrwtimeoutMs = 0;
        public int snsshowErrorDelayMs = 0;
    }

    public static class CdnTaskStateInfo {
        public static final int kCompleted = 104;
        public static final int kNotExits = 103;
        public static final int kPausing = 102;
        public static final int kRunning = 100;
        public static final int kWaiting = 101;
        public int completeSize = 0;
        public int fileTotalSize = 0;
        public int taskState = -100;
    }

    public interface SessionCallback {
        byte[] decodeSessionResponseBuf(String str, byte[] bArr);

        byte[] getSessionRequestBuf(String str, byte[] bArr);
    }

    public static class C2CUploadRequest {
        public int apptype = 0;
        public String bigfileSignature = "";
        public int bizscene = 0;
        public int chatType = 0;
        public boolean checkExistOnly = false;
        public int connectionCount = 1;
        public boolean enableHitCheck = true;
        public String fakeBigfileSignature = "";
        public String fakeBigfileSignatureAeskey = "";
        public String fileKey = "";
        public String filePath = "";
        public int fileSize = 0;
        public int fileType = 0;
        public String filemd5 = "";
        public boolean forceNoSafeCdn = false;
        public String forwardAeskey = "";
        public String forwardFileid = "";
        public int isLargeSVideo = 0;
        public boolean isSmallVideo = false;
        public boolean isSnsAdVideo = false;
        public boolean isStorageMode = false;
        public boolean isStreamMedia = false;
        public int lastError = 0;
        public int midfileSize = 0;
        public String midimgPath = "";
        public boolean needCompressImage = false;
        public boolean onlyCheckExist = false;
        public int queueTimeoutSeconds = 1800;
        public boolean sendmsgFromCDN = false;
        public String statePath = "";
        public String thumbfilePath = "";
        public String toUser = "";
        public int transforTimeoutSeconds = 600;
        public boolean trySafeCdn = false;
        public boolean useMultithread = false;
        public int videoSource = 0;

        public C2CUploadRequest toUser(String str) {
            this.toUser = str;
            return this;
        }

        public C2CUploadRequest queueTimeoutSeconds(int i) {
            this.queueTimeoutSeconds = i;
            return this;
        }

        public C2CUploadRequest transforTimeoutSeconds(int i) {
            this.transforTimeoutSeconds = i;
            return this;
        }

        public C2CUploadRequest thumbfilePath(String str) {
            this.thumbfilePath = str;
            return this;
        }

        public C2CUploadRequest forwardFileid(String str) {
            this.forwardFileid = str;
            return this;
        }

        public C2CUploadRequest forwardAeskey(String str) {
            this.forwardAeskey = str;
            return this;
        }

        public C2CUploadRequest filemd5(String str) {
            this.filemd5 = str;
            return this;
        }

        public C2CUploadRequest fakeBigfileSignature(String str) {
            this.fakeBigfileSignature = str;
            return this;
        }

        public C2CUploadRequest fakeBigfileSignatureAeskey(String str) {
            this.fakeBigfileSignatureAeskey = str;
            return this;
        }

        public C2CUploadRequest connectionCount(int i) {
            this.connectionCount = i;
            return this;
        }

        public C2CUploadRequest lastError(int i) {
            this.lastError = i;
            return this;
        }

        public C2CUploadRequest statePath(String str) {
            this.statePath = str;
            return this;
        }

        public C2CUploadRequest midimgPath(String str) {
            this.midimgPath = str;
            return this;
        }

        public C2CUploadRequest sendmsgFromCDN(boolean z) {
            this.sendmsgFromCDN = z;
            return this;
        }

        public C2CUploadRequest isSmallVideo(boolean z) {
            this.isSmallVideo = z;
            return this;
        }

        public C2CUploadRequest isLargeSVideo(int i) {
            this.isLargeSVideo = i;
            return this;
        }

        public C2CUploadRequest videoSource(int i) {
            this.videoSource = i;
            return this;
        }

        public C2CUploadRequest isStreamMedia(boolean z) {
            this.isStreamMedia = z;
            return this;
        }

        public C2CUploadRequest isSnsAdVideo(boolean z) {
            this.isSnsAdVideo = z;
            return this;
        }

        public C2CUploadRequest forceNoSafeCdn(boolean z) {
            this.forceNoSafeCdn = z;
            return this;
        }

        public C2CUploadRequest chatType(int i) {
            this.chatType = i;
            return this;
        }

        public C2CUploadRequest bigfileSignature(String str) {
            this.bigfileSignature = str;
            return this;
        }

        public C2CUploadRequest enableHitCheck(boolean z) {
            this.enableHitCheck = z;
            return this;
        }

        public static C2CUploadRequest createC2C(int i, String str) {
            C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
            c2CUploadRequest.bizscene = 1;
            c2CUploadRequest.apptype = 1;
            c2CUploadRequest.fileType = i;
            c2CUploadRequest.filePath = str;
            c2CUploadRequest.trySafeCdn = true;
            c2CUploadRequest.forceNoSafeCdn = false;
            return c2CUploadRequest;
        }

        public static C2CUploadRequest createC2CExistCheck(String str, String str2, int i) {
            C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
            c2CUploadRequest.bizscene = 1;
            c2CUploadRequest.apptype = 1;
            c2CUploadRequest.fileType = i;
            c2CUploadRequest.forwardFileid = str;
            c2CUploadRequest.forwardAeskey = str2;
            c2CUploadRequest.trySafeCdn = true;
            c2CUploadRequest.forceNoSafeCdn = false;
            c2CUploadRequest.enableHitCheck = true;
            c2CUploadRequest.onlyCheckExist = true;
            return c2CUploadRequest;
        }

        public static C2CUploadRequest createFavorite(int i, String str) {
            C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
            c2CUploadRequest.bizscene = 2;
            c2CUploadRequest.apptype = 10;
            c2CUploadRequest.fileType = i;
            c2CUploadRequest.trySafeCdn = true;
            c2CUploadRequest.forceNoSafeCdn = false;
            c2CUploadRequest.isStorageMode = true;
            return c2CUploadRequest;
        }

        public static C2CUploadRequest createSNS(int i, String str) {
            C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
            c2CUploadRequest.bizscene = 3;
            c2CUploadRequest.apptype = 100;
            c2CUploadRequest.fileType = i;
            c2CUploadRequest.trySafeCdn = true;
            c2CUploadRequest.forceNoSafeCdn = false;
            return c2CUploadRequest;
        }

        public static C2CUploadRequest createApp(int i, int i2, String str) {
            C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
            c2CUploadRequest.bizscene = 4;
            c2CUploadRequest.apptype = i;
            c2CUploadRequest.fileType = i2;
            c2CUploadRequest.trySafeCdn = true;
            c2CUploadRequest.forceNoSafeCdn = false;
            return c2CUploadRequest;
        }
    }

    public static class CertificateVerifyPolicy {
        public static final int kIngoreError = 2;
        public static final int kNoVerify = 0;
        public static final int kStrictVerify = 1;
    }

    public static native int calcFileCrc32(String str);

    public static native String calcFileMD5(String str);

    public static native String calcMP4IdentifyMD5(String str);

    public static native int cancelDownloadTaskWithResult(String str, C2CDownloadResult c2CDownloadResult);

    public static native void cancelTask(String str);

    public static native int cancelUploadTaskWithResult(String str, C2CUploadResult c2CUploadResult);

    public static native String createAeskey();

    public static native String createUniqueFilekey(String str, String str2);

    private static native ArrayList<String> getLoadLibraries();

    public static native int getRecentAverageSpeed(int i);

    public static native boolean getSnsImagePrivateProtocolAvalible();

    public static native CdnTaskStateInfo httpMultiSocketDownloadTaskState(String str);

    public static native boolean isVideoDataAvailable(String str, int i, int i2);

    private static native void onCreate(String str);

    public static native int pauseHttpMultiSocketDownloadTask(String str);

    public static native int queryDownloadedSize(String str, int[] iArr);

    public static native int queryFilesizeLimit(int i, int i2);

    public static native boolean queryVideoMoovInfo(C2CDownloadRequest c2CDownloadRequest, long[] jArr);

    public static native int requestVideoData(String str, int i, int i2, int i3);

    public static native int resumeHttpMultiSocketDownloadTask(String str);

    private static native void setAppCallback(AppCallback appCallback);

    public static native void setCdnInfo(byte[] bArr, byte[] bArr2);

    public static native void setCdnInfoParams(CdnInfoParams cdnInfoParams, CdnInfoParams cdnInfoParams2, int i);

    public static native void setConfig(Config config);

    public static native void setDebugIP(String str);

    public static native void setFlowLimitPerHour(int i);

    public static native void setLegacyCdnInfo(CdnInfo cdnInfo, CdnInfo cdnInfo2, CdnInfo cdnInfo3, CdnInfo cdnInfo4, byte[] bArr, byte[] bArr2);

    private static native void setRSAPublicKeyParams(String str, String str2, String str3);

    public static native void setSnsImagePrivateProtocolAvalible(boolean z);

    private static native void setToUserCiper(String str);

    public static native int startC2CDownload(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startC2CUpload(C2CUploadRequest c2CUploadRequest, UploadCallback uploadCallback);

    public static native int startHttpMultiSocketDownloadTask(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startHttpVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, VideoStreamingCallback videoStreamingCallback, DownloadCallback downloadCallback, int i);

    public static native int startHttpsDownload(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startSNSDownload(C2CDownloadRequest c2CDownloadRequest, VideoStreamingCallback videoStreamingCallback, DownloadCallback downloadCallback, int i);

    public static native int startSSUpload(C2CUploadRequest c2CUploadRequest, SessionCallback sessionCallback, UploadCallback uploadCallback);

    public static native int startURLDownload(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, VideoStreamingCallback videoStreamingCallback, DownloadCallback downloadCallback, int i);

    public static native boolean taskExist(String str);

    public static native void triggerPreConnect(String str, String[] strArr, boolean z);

    static {
        ArrayList arrayList = null;
        try {
            arrayList = getLoadLibraries();
        } catch (UnsatisfiedLinkError e) {
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(arrayList, TAG);
    }

    public static void Initialize(String str, AppCallback appCallback, String str2, String str3, String str4, String str5) {
        C4990ab.m7416i(TAG, "init cdnlogic");
        setAppCallback(appCallback);
        onCreate(str);
        setRSAPublicKeyParams(str2, str3, str4);
        setToUserCiper(str5);
    }

    public static void UnInitialize() {
        C4990ab.m7420w(TAG, "uninit cdnlogic");
        setAppCallback(null);
    }

    public static int doCertificateVerify(String str, byte[][] bArr) {
        int i = -1;
        C4990ab.m7417i(TAG, "certifivate verify for %s", str);
        try {
            C4990ab.m7417i(TAG, "host %s verify result %d, isknownroots %b", str, Integer.valueOf(r1.getStatus()), Boolean.valueOf(X509Util.verifyServerCertificates(bArr, "RSA", str).isIssuedByKnownRoot()));
            return X509Util.verifyServerCertificates(bArr, "RSA", str).getStatus();
        } catch (KeyStoreException e) {
            C4990ab.m7412e(TAG, e.getLocalizedMessage());
            return i;
        } catch (NoSuchAlgorithmException e2) {
            C4990ab.m7412e(TAG, e2.getLocalizedMessage());
            return i;
        } catch (IllegalArgumentException e3) {
            C4990ab.m7412e(TAG, e3.getLocalizedMessage());
            return i;
        } catch (Exception e4) {
            C4990ab.m7412e(TAG, e4.getLocalizedMessage());
            return i;
        }
    }
}

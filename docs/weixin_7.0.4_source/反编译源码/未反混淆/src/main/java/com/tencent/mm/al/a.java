package com.tencent.mm.al;

import com.facebook.internal.Utility;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.SessionCallback;
import com.tencent.mars.cdn.CdnLogic.UploadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements AppCallback, DownloadCallback, SessionCallback, UploadCallback, VideoStreamingCallback {
    private static int fyt = 7340033;
    private static int fyu = 100;
    private static int fyv = 101;
    private static int fyw = 102;
    private static int fyx = 103;
    private int fyA = 0;
    private int fyB = 0;
    private String fyC = "";
    private ap fyD = null;
    public a fyE;
    private mw fyy = null;
    private com.tencent.mm.i.b.a fyz = null;

    public interface a {
        int a(String str, c cVar, d dVar);

        void onDataAvailable(String str, int i, int i2);

        void onDownloadToEnd(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);
    }

    class b {
        public int field_AckSlice = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        public String field_ApprovedVideoHosts = CdnLogic.defaultApprovedVideoHosts;
        public int field_C2COverloadDelaySeconds = 10;
        public int field_EnableCDNVerifyConnect = 1;
        public int field_EnableCDNVideoRedirectOC = 1;
        public int field_EnableSafeCDN = 0;
        public int field_EnableSnsImageDownload = 0;
        public int field_EnableSnsStreamDownload = 0;
        public int field_EnableStreamUploadVideo = 1;
        public int field_Ptl = 35;
        public int field_SNSOverloadDelaySeconds = 60;
        public int field_UseDynamicETL = 0;
        public int field_UseStreamCDN = 1;
        public int field_WifiEtl = 90;
        public int field_noWifiEtl = 70;
        public boolean field_onlyrecvPtl = false;
        public boolean field_onlysendETL = false;

        b() {
        }

        public final String toString() {
            AppMethodBeat.i(77969);
            String format = String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d, safecdn:%d, snsstream:%d, snsimage:%d, videohosts:\n%s", new Object[]{Integer.valueOf(this.field_WifiEtl), Integer.valueOf(this.field_noWifiEtl), Integer.valueOf(this.field_Ptl), Integer.valueOf(this.field_UseStreamCDN), Boolean.valueOf(this.field_onlysendETL), Boolean.valueOf(this.field_onlyrecvPtl), Integer.valueOf(this.field_AckSlice), Integer.valueOf(this.field_EnableCDNVerifyConnect), Integer.valueOf(this.field_EnableCDNVideoRedirectOC), Integer.valueOf(this.field_EnableStreamUploadVideo), Integer.valueOf(this.field_UseDynamicETL), Integer.valueOf(this.field_C2COverloadDelaySeconds), Integer.valueOf(this.field_SNSOverloadDelaySeconds), Integer.valueOf(this.field_EnableSafeCDN), Integer.valueOf(this.field_EnableSnsStreamDownload), Integer.valueOf(this.field_EnableSnsImageDownload), this.field_ApprovedVideoHosts});
            AppMethodBeat.o(77969);
            return format;
        }
    }

    public a(String str, com.tencent.mm.i.b.a aVar) {
        AppMethodBeat.i(77970);
        if (ah.bqo()) {
            this.fyD = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(77968);
                    if (a.this.fyA == 0 && a.this.fyB == 0) {
                        AppMethodBeat.o(77968);
                        return false;
                    }
                    ab.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", a.this.fyC, Integer.valueOf(a.this.fyA), Integer.valueOf(a.this.fyB));
                    if (com.tencent.mm.model.ao.a.flv == null) {
                        ab.e("MicroMsg.CdnTransportEngine", "getNetStat null");
                        AppMethodBeat.o(77968);
                        return false;
                    }
                    com.tencent.mm.model.ao.a.flv.cm(a.this.fyB, a.this.fyA);
                    a.this.fyA = 0;
                    a.this.fyB = 0;
                    AppMethodBeat.o(77968);
                    return true;
                }
            }, true);
        }
        this.fyz = aVar;
        CdnLogic.Initialize(str, this, "1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001", "cdnwx2013usrname");
        ab.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", Integer.valueOf(hashCode()), str, bo.dpG());
        AppMethodBeat.o(77970);
    }

    public static int keep_callFromJni(int i, int i2, byte[] bArr) {
        AppMethodBeat.i(77971);
        if (i == fyu) {
            c.outputJniLog(bArr, "MicroMsg.CdnEngine", i2);
        }
        AppMethodBeat.o(77971);
        return 0;
    }

    private static C2CDownloadRequest a(com.tencent.mm.i.g gVar) {
        boolean z = true;
        AppMethodBeat.i(77972);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileid = gVar.field_fileId;
        c2CDownloadRequest.aeskey = gVar.field_aesKey;
        c2CDownloadRequest.fileType = gVar.field_fileType;
        c2CDownloadRequest.fileKey = gVar.field_mediaId;
        c2CDownloadRequest.fileSize = gVar.field_totalLen;
        c2CDownloadRequest.savePath = gVar.field_fullpath;
        c2CDownloadRequest.isStorageMode = gVar.field_needStorage;
        c2CDownloadRequest.isSmallVideo = gVar.field_smallVideoFlag == 1;
        if (gVar.field_largesvideo <= 0) {
            z = false;
        }
        c2CDownloadRequest.isLargeSVideo = z;
        c2CDownloadRequest.limitRate = gVar.field_limitrate;
        c2CDownloadRequest.isAutoStart = gVar.field_autostart;
        c2CDownloadRequest.chatType = gVar.field_chattype;
        c2CDownloadRequest.isSilentTask = gVar.field_isSilentTask;
        c2CDownloadRequest.requestVideoFormat = gVar.field_requestVideoFormat;
        c2CDownloadRequest.isColdSnsData = gVar.field_isColdSnsData;
        c2CDownloadRequest.signalQuality = gVar.field_signalQuality;
        c2CDownloadRequest.snsScene = gVar.field_snsScene;
        c2CDownloadRequest.requestVideoFormat = gVar.field_requestVideoFormat;
        c2CDownloadRequest.videofileid = gVar.field_videoFileId;
        c2CDownloadRequest.bigfileSignature = gVar.field_svr_signature;
        if (bo.isNullOrNil(c2CDownloadRequest.bigfileSignature)) {
            c2CDownloadRequest.bigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignature = gVar.field_fake_bigfile_signature;
        if (bo.isNullOrNil(c2CDownloadRequest.fakeBigfileSignature)) {
            c2CDownloadRequest.fakeBigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignatureAeskey = gVar.field_fake_bigfile_signature_aeskey;
        if (bo.isNullOrNil(c2CDownloadRequest.fakeBigfileSignatureAeskey)) {
            c2CDownloadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CDownloadRequest.msgExtra = gVar.field_wxmsgparam;
        if (bo.isNullOrNil(c2CDownloadRequest.msgExtra)) {
            c2CDownloadRequest.msgExtra = "";
        }
        c2CDownloadRequest.queueTimeoutSeconds = 0;
        c2CDownloadRequest.transforTimeoutSeconds = 0;
        c2CDownloadRequest.preloadRatio = gVar.field_preloadRatio;
        c2CDownloadRequest.certificateVerifyPolicy = gVar.certificateVerifyPolicy;
        c2CDownloadRequest.expectImageFormat = gVar.expectImageFormat;
        AppMethodBeat.o(77972);
        return c2CDownloadRequest;
    }

    public static int rF(String str) {
        AppMethodBeat.i(77974);
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(77974);
        return 0;
    }

    public final int c(com.tencent.mm.i.g gVar) {
        AppMethodBeat.i(77975);
        int startC2CDownload = CdnLogic.startC2CDownload(a(gVar), this);
        AppMethodBeat.o(77975);
        return startC2CDownload;
    }

    public static int rG(String str) {
        AppMethodBeat.i(77976);
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(77976);
        return 0;
    }

    public static String rH(String str) {
        AppMethodBeat.i(77977);
        String calcFileMD5 = CdnLogic.calcFileMD5(str);
        AppMethodBeat.o(77977);
        return calcFileMD5;
    }

    public static String afp() {
        AppMethodBeat.i(77978);
        String createAeskey = CdnLogic.createAeskey();
        AppMethodBeat.o(77978);
        return createAeskey;
    }

    public static int rI(String str) {
        AppMethodBeat.i(77979);
        int calcFileCrc32 = CdnLogic.calcFileCrc32(str);
        AppMethodBeat.o(77979);
        return calcFileCrc32;
    }

    public static String rJ(String str) {
        AppMethodBeat.i(77980);
        String calcMP4IdentifyMD5 = CdnLogic.calcMP4IdentifyMD5(str);
        AppMethodBeat.o(77980);
        return calcMP4IdentifyMD5;
    }

    public final int a(String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.i(77981);
        ab.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", str, str3);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.savePath = str3;
        c2CDownloadRequest.aeskey = str4;
        c2CDownloadRequest.customHttpHeader = "authkey: " + str5 + IOUtils.LINE_SEPARATOR_WINDOWS;
        c2CDownloadRequest.fileType = i;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.o(77981);
        return startSNSDownload;
    }

    public final int a(String str, String str2, String str3, int i, int i2, int i3, String[] strArr, boolean z) {
        int i4 = 0;
        AppMethodBeat.i(77982);
        String str4 = "MicroMsg.CdnTransportEngine";
        String str5 = "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = str3;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        if (strArr != null) {
            i4 = strArr.length;
        }
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = Boolean.valueOf(z);
        ab.i(str4, str5, objArr);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.savePath = str3;
        c2CDownloadRequest.queueTimeoutSeconds = i2;
        c2CDownloadRequest.transforTimeoutSeconds = i3;
        c2CDownloadRequest.ocIpList = strArr;
        if (!z) {
            c2CDownloadRequest.customHttpHeader = "Accept-Encoding:  ";
        }
        c2CDownloadRequest.fileType = i;
        if (com.tencent.mm.i.a.efP == c2CDownloadRequest.fileType) {
            i4 = CdnLogic.startHttpsDownload(c2CDownloadRequest, this);
            AppMethodBeat.o(77982);
            return i4;
        }
        i4 = CdnLogic.startURLDownload(c2CDownloadRequest, this);
        AppMethodBeat.o(77982);
        return i4;
    }

    public final int a(String str, String str2, String str3, String str4, int i, String[] strArr, boolean z, String str5, String str6, int i2, int i3, int i4) {
        AppMethodBeat.i(77983);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20202;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        if (strArr != null) {
            c2CDownloadRequest.ocIpList = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.ocIpList = null;
        }
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.preloadRatio = i2;
        c2CDownloadRequest.requestVideoFormat = i3;
        c2CDownloadRequest.connectionCount = i4;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, i);
        AppMethodBeat.o(77983);
        return startSNSDownload;
    }

    public final int b(String str, String str2, String str3, String str4, int i, String[] strArr, boolean z, String str5, String str6, int i2, int i3, int i4) {
        AppMethodBeat.i(77984);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = CdnLogic.kMediaTypeAppVideo;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        if (strArr != null) {
            c2CDownloadRequest.ocIpList = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.ocIpList = null;
        }
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.preloadRatio = i2;
        c2CDownloadRequest.requestVideoFormat = i3;
        c2CDownloadRequest.connectionCount = i4;
        c2CDownloadRequest.marscdnAppType = 205;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, i);
        AppMethodBeat.o(77984);
        return startSNSDownload;
    }

    public final int a(f fVar) {
        String[] strArr;
        AppMethodBeat.i(77985);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20201;
        c2CDownloadRequest.fileKey = fVar.field_mediaId;
        c2CDownloadRequest.url = fVar.url;
        c2CDownloadRequest.referer = fVar.referer;
        c2CDownloadRequest.ocIpList = fVar.ege != null ? (String[]) fVar.ege.clone() : null;
        c2CDownloadRequest.ocIpListSource = fVar.egg;
        if (fVar.egf != null) {
            strArr = (String[]) fVar.egf.clone();
        } else {
            strArr = null;
        }
        c2CDownloadRequest.dcIpList = strArr;
        c2CDownloadRequest.dcIpListSource = fVar.egh;
        c2CDownloadRequest.isColdSnsData = fVar.isColdSnsData;
        c2CDownloadRequest.signalQuality = fVar.signalQuality;
        c2CDownloadRequest.snsScene = fVar.snsScene;
        c2CDownloadRequest.concurrentCount = 6;
        c2CDownloadRequest.marscdnBizType = fVar.duk;
        c2CDownloadRequest.marscdnAppType = fVar.egi;
        c2CDownloadRequest.fileType = fVar.fileType;
        c2CDownloadRequest.msgType = 2;
        c2CDownloadRequest.feedId = fVar.cFc;
        c2CDownloadRequest.feedPicCount = fVar.gXe;
        c2CDownloadRequest.batchSnsReqImageDatas = fVar.egb;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.o(77985);
        return startSNSDownload;
    }

    public final int a(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, int i, int i2, boolean z, String str5, String str6, String str7, int i3, int i4, int i5) {
        AppMethodBeat.i(77986);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str4)) {
            ab.e("MicroMsg.CdnTransportEngine", "invalid param.");
            AppMethodBeat.o(77986);
            return -1;
        }
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20201;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.ocIpList = strArr != null ? (String[]) strArr.clone() : null;
        c2CDownloadRequest.ocIpListSource = i;
        c2CDownloadRequest.dcIpList = strArr2 != null ? (String[]) strArr2.clone() : null;
        c2CDownloadRequest.dcIpListSource = i2;
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.snsCipherKey = str7;
        c2CDownloadRequest.concurrentCount = 6;
        c2CDownloadRequest.marscdnBizType = i3;
        c2CDownloadRequest.marscdnAppType = i4;
        c2CDownloadRequest.fileType = i5;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.o(77986);
        return startSNSDownload;
    }

    public static int rK(String str) {
        AppMethodBeat.i(77987);
        ab.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:".concat(String.valueOf(str)));
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(77987);
        return 0;
    }

    public final int a(String str, String str2, String str3, String str4, Map<String, String> map, boolean z, int i, int i2, boolean z2, boolean z3, String[] strArr) {
        AppMethodBeat.i(77988);
        ab.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:".concat(String.valueOf(str)));
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.bakup_url = str4;
        c2CDownloadRequest.savePath = str2;
        c2CDownloadRequest.queueTimeoutSeconds = i;
        c2CDownloadRequest.transforTimeoutSeconds = i2;
        c2CDownloadRequest.ocIpList = strArr;
        c2CDownloadRequest.is_resume_task = z2;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getKey());
                c2CDownloadRequest.serialized_verify_headers += VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getValue());
                c2CDownloadRequest.serialized_verify_headers += ";";
            }
        }
        c2CDownloadRequest.allow_mobile_net_download = z;
        c2CDownloadRequest.wifiAutoStart = z3;
        c2CDownloadRequest.maxHttpRedirectCount = 18;
        int startHttpMultiSocketDownloadTask = CdnLogic.startHttpMultiSocketDownloadTask(c2CDownloadRequest, this);
        AppMethodBeat.o(77988);
        return startHttpMultiSocketDownloadTask;
    }

    public static int rL(String str) {
        AppMethodBeat.i(77989);
        ab.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:".concat(String.valueOf(str)));
        CdnLogic.cancelTask(str);
        AppMethodBeat.o(77989);
        return 0;
    }

    public final int a(com.tencent.mm.i.g gVar, int i) {
        AppMethodBeat.i(77990);
        int startVideoStreamingDownload = CdnLogic.startVideoStreamingDownload(a(gVar), this, this, i);
        AppMethodBeat.o(77990);
        return startVideoStreamingDownload;
    }

    public final int a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2) {
        AppMethodBeat.i(77991);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.fileType = CdnLogic.kMediaTypeAdVideo;
        c2CDownloadRequest.concurrentCount = 10;
        if (strArr != null) {
            c2CDownloadRequest.ocIpList = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.ocIpList = null;
        }
        c2CDownloadRequest.preloadRatio = i2;
        int startHttpVideoStreamingDownload = CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, this, this, i);
        AppMethodBeat.o(77991);
        return startHttpVideoStreamingDownload;
    }

    public final int a(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        AppMethodBeat.i(77992);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.fileType = 90;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.preloadRatio = i2;
        c2CDownloadRequest.concurrentCount = i3;
        c2CDownloadRequest.maxHttpRedirectCount = 100;
        int startHttpVideoStreamingDownload = CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, this, this, i);
        AppMethodBeat.o(77992);
        return startHttpVideoStreamingDownload;
    }

    public static int b(String str, d dVar) {
        AppMethodBeat.i(77993);
        C2CDownloadResult c2CDownloadResult = new C2CDownloadResult();
        int cancelDownloadTaskWithResult = CdnLogic.cancelDownloadTaskWithResult(str, c2CDownloadResult);
        a(c2CDownloadResult, dVar);
        AppMethodBeat.o(77993);
        return cancelDownloadTaskWithResult;
    }

    public static int k(String str, int i, int i2) {
        AppMethodBeat.i(77994);
        int requestVideoData = CdnLogic.requestVideoData(str, i, i2, 0);
        AppMethodBeat.o(77994);
        return requestVideoData;
    }

    public static boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(77995);
        boolean isVideoDataAvailable = CdnLogic.isVideoDataAvailable(str, i, i2);
        AppMethodBeat.o(77995);
        return isVideoDataAvailable;
    }

    public final boolean afq() {
        return this.fyy == null;
    }

    private static CdnInfo a(mw mwVar) {
        AppMethodBeat.i(77996);
        CdnInfo cdnInfo = new CdnInfo();
        if (mwVar == null) {
            AppMethodBeat.o(77996);
            return cdnInfo;
        }
        int i;
        int i2;
        cdnInfo.ver = mwVar.vQV;
        cdnInfo.uin = mwVar.luF;
        cdnInfo.frontid = mwVar.vQX;
        cdnInfo.zoneid = mwVar.vRc;
        cdnInfo.nettype = c.bV(ah.getContext());
        cdnInfo.authkey = aa.a(mwVar.vRb);
        if (mwVar.vQY >= 2) {
            cdnInfo.frontip1 = aa.a((bts) mwVar.vQZ.get(0));
            cdnInfo.frontip2 = aa.a((bts) mwVar.vQZ.get(1));
            ab.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (mwVar.vRd >= 2) {
            cdnInfo.zoneip1 = aa.a((bts) mwVar.vRe.get(0));
            cdnInfo.zoneip2 = aa.a((bts) mwVar.vRe.get(1));
            ab.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (mwVar.vRh > 0) {
            i = ((mx) mwVar.vRf.get(0)).vRj;
            cdnInfo.frontports = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                cdnInfo.frontports[i2] = ((Integer) ((mx) mwVar.vRf.get(0)).vRk.get(i2)).intValue();
            }
        }
        if (mwVar.vRi > 0) {
            i = ((mx) mwVar.vRg.get(0)).vRj;
            cdnInfo.zoneports = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                cdnInfo.zoneports[i2] = ((Integer) ((mx) mwVar.vRg.get(0)).vRk.get(i2)).intValue();
            }
        }
        AppMethodBeat.o(77996);
        return cdnInfo;
    }

    public final boolean a(mw mwVar, mw mwVar2, mw mwVar3, byte[] bArr, byte[] bArr2, mw mwVar4) {
        AppMethodBeat.i(77997);
        ab.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", this.fyy, mwVar, mwVar4, bo.dpG());
        if (mwVar == null && bArr == null) {
            AppMethodBeat.o(77997);
            return false;
        }
        this.fyy = mwVar;
        try {
            CdnLogic.setLegacyCdnInfo(a(mwVar), a(mwVar2), a(mwVar3), a(mwVar4), bArr, bArr2);
            CdnLogic.setDebugIP("");
            if (ae.giS && ae.giJ != null && ae.giJ.length() >= 7) {
                ab.w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", ae.giJ);
                CdnLogic.setDebugIP(ae.giJ);
            }
            AppMethodBeat.o(77997);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + e.getLocalizedMessage());
            AppMethodBeat.o(77997);
            return false;
        }
    }

    public final b afr() {
        AppMethodBeat.i(77998);
        b bVar = new b();
        AppMethodBeat.o(77998);
        return bVar;
    }

    public static void a(b bVar) {
        AppMethodBeat.i(77999);
        ab.i("MicroMsg.CdnTransportEngine", "set WXConfig:".concat(String.valueOf(bVar)));
        Config config = new Config();
        config.AckSlice = bVar.field_AckSlice;
        config.UseDynamicETL = bVar.field_UseDynamicETL;
        config.UseStreamCDN = bVar.field_UseStreamCDN;
        config.C2COverloadDelaySeconds = bVar.field_C2COverloadDelaySeconds;
        config.SNSOverloadDelaySeconds = bVar.field_SNSOverloadDelaySeconds;
        config.EnableCDNVerifyConnect = bVar.field_EnableCDNVerifyConnect;
        config.EnableCDNVideoRedirectOC = bVar.field_EnableCDNVideoRedirectOC;
        config.EnableStreamUploadVideo = bVar.field_EnableStreamUploadVideo;
        config.EnableSafeCDN = bVar.field_EnableSafeCDN;
        config.EnableSnsStreamDownload = bVar.field_EnableSnsStreamDownload;
        config.EnableSnsImageDownload = bVar.field_EnableSnsImageDownload;
        if (!bo.isNullOrNil(bVar.field_ApprovedVideoHosts)) {
            config.ApprovedVideoHosts = bVar.field_ApprovedVideoHosts;
        }
        config.WifiEtl = bVar.field_WifiEtl;
        config.MobileEtl = bVar.field_noWifiEtl;
        config.onlyrecvPtl = bVar.field_onlyrecvPtl;
        config.onlysendETL = bVar.field_onlysendETL;
        config.Ptl = bVar.field_Ptl;
        CdnLogic.setConfig(config);
        AppMethodBeat.o(77999);
    }

    private static int rM(String str) {
        int i;
        AppMethodBeat.i(78000);
        ab.i("MicroMsg.CdnTransportEngine", "ipFromString %s", str);
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            int i2 = 0;
            i = 0;
            while (i2 < address.length) {
                try {
                    i = (i << 8) | (address[i2] & 255);
                    i2++;
                } catch (UnknownHostException e) {
                }
            }
        } catch (UnknownHostException e2) {
            i = 0;
        }
        AppMethodBeat.o(78000);
        return i;
    }

    private static d a(C2CDownloadResult c2CDownloadResult, d dVar) {
        AppMethodBeat.i(78001);
        if (dVar == null) {
            dVar = new d();
        }
        dVar.field_retCode = c2CDownloadResult.errorCode;
        dVar.field_argInfo = c2CDownloadResult.argInfo;
        dVar.field_fileLength = c2CDownloadResult.fileSize;
        dVar.field_fileId = c2CDownloadResult.fileid;
        dVar.field_transInfo = c2CDownloadResult.transforMsg;
        dVar.field_convert2baseline = false;
        dVar.field_recvedBytes = c2CDownloadResult.recvedBytes;
        dVar.field_videoFormat = c2CDownloadResult.videoFormat;
        dVar.field_enQueueTime = c2CDownloadResult.enQueueTime;
        dVar.field_startTime = c2CDownloadResult.startTime;
        dVar.field_endTime = c2CDownloadResult.endTime;
        dVar.field_firstRequestCost = c2CDownloadResult.firstRequestCost;
        dVar.field_firstRequestSize = c2CDownloadResult.firstRequestSize;
        dVar.field_firstRequestDownloadSize = c2CDownloadResult.firstRequestDownloadSize;
        dVar.field_firstRequestCompleted = c2CDownloadResult.firstRequestCompleted;
        dVar.field_averageSpeed = c2CDownloadResult.averageSpeed;
        dVar.field_averageConnectCost = c2CDownloadResult.averageConnectCost;
        dVar.field_firstConnectCost = c2CDownloadResult.firstConnectCost;
        dVar.field_netConnectTimes = c2CDownloadResult.netConnectTimes;
        dVar.field_moovRequestTimes = c2CDownloadResult.moovRequestTimes;
        dVar.field_moovCost = c2CDownloadResult.moovCost;
        dVar.field_moovSize = c2CDownloadResult.moovSize;
        dVar.field_moovCompleted = c2CDownloadResult.moovCompleted;
        dVar.field_moovFailReason = c2CDownloadResult.moovFailReason;
        dVar.field_previousCompletedSize = c2CDownloadResult.previousCompletedSize;
        dVar.field_averageRequestSize = c2CDownloadResult.averageRequestSize;
        dVar.field_averageRequestCost = c2CDownloadResult.averageRequestCost;
        dVar.field_requestTotalCount = c2CDownloadResult.requestTotalCount;
        dVar.field_requestCompletedCount = c2CDownloadResult.requestCompletedCount;
        dVar.field_requestTimeoutCount = c2CDownloadResult.requestTimeoutCount;
        dVar.field_httpStatusCode = c2CDownloadResult.httpStatusCode;
        dVar.field_httpResponseHeader = c2CDownloadResult.httpResponseHeader;
        dVar.field_delayTime = c2CDownloadResult.delayTime;
        dVar.field_dnsCostTime = c2CDownloadResult.dnsCostTime;
        dVar.field_connectCostTime = c2CDownloadResult.connectCostTime;
        dVar.field_waitResponseCostTime = c2CDownloadResult.waitResponseCostTime;
        dVar.field_receiveCostTime = c2CDownloadResult.receiveCostTime;
        dVar.field_clientIP = c2CDownloadResult.clientIP;
        dVar.field_serverIP = c2CDownloadResult.serverIP;
        dVar.field_clientHostIP = rM(c2CDownloadResult.clientIP);
        dVar.field_serverHostIP = rM(c2CDownloadResult.serverIP);
        dVar.field_xErrorNo = c2CDownloadResult.xErrorNo;
        dVar.field_cSeqCheck = c2CDownloadResult.cSeqCheck;
        dVar.field_usePrivateProtocol = c2CDownloadResult.usePrivateProtocol;
        dVar.field_isCrossNet = c2CDownloadResult.crossNet;
        dVar.field_clientIP = c2CDownloadResult.clientIP;
        if (c2CDownloadResult.usedSvrIps != null) {
            dVar.field_usedSvrIps = (String[]) c2CDownloadResult.usedSvrIps.clone();
        }
        dVar.field_isResume = c2CDownloadResult.isResume;
        dVar.ega = c2CDownloadResult.isSnsImageProtocolAvailable;
        dVar.index = c2CDownloadResult.picIndex;
        dVar.cachePath = c2CDownloadResult.picCachePath;
        dVar.cFc = c2CDownloadResult.batchPicFeedId;
        dVar.fileKey = c2CDownloadResult.batchImageFileKey;
        dVar.egb = c2CDownloadResult.batchImageNeedRetry;
        AppMethodBeat.o(78001);
        return dVar;
    }

    public final int keep_onUploadProgress(String str, c cVar) {
        AppMethodBeat.i(78002);
        cVar.field_isUploadTask = true;
        if (this.fyz != null) {
            ab.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", str, Integer.valueOf(cVar.field_toltalLength), Integer.valueOf(cVar.field_finishedLength));
            this.fyz.a(str, cVar, null);
        }
        AppMethodBeat.o(78002);
        return 0;
    }

    public final int keep_onUploadError(String str, d dVar) {
        AppMethodBeat.i(78003);
        if (this.fyz != null) {
            a(dVar);
            this.fyz.a(str, null, dVar);
        }
        AppMethodBeat.o(78003);
        return 0;
    }

    public final int keep_onUploadSuccessed(String str, d dVar) {
        AppMethodBeat.i(78004);
        if (this.fyz != null) {
            ab.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", str);
            a(dVar);
            this.fyz.a(str, null, dVar);
        }
        AppMethodBeat.o(78004);
        return 0;
    }

    public final int keep_onDownloadProgress(String str, c cVar) {
        int a;
        AppMethodBeat.i(78005);
        cVar.field_isUploadTask = false;
        if (this.fyE != null) {
            a = this.fyE.a(str, cVar, null);
        } else {
            a = 0;
        }
        if (a == 0 && this.fyz != null) {
            ab.v("MicroMsg.CdnTransportEngine", "klem keep_onDownloadProgress mediaId:%s", str);
            this.fyz.a(str, cVar, null);
        }
        AppMethodBeat.o(78005);
        return 0;
    }

    public final int keep_onDownloadError(String str, d dVar) {
        int a;
        AppMethodBeat.i(78006);
        if (this.fyE != null) {
            a = this.fyE.a(str, null, dVar);
        } else {
            a = 0;
        }
        if (a == 0 && this.fyz != null) {
            a(dVar);
            this.fyz.a(str, null, dVar);
        }
        AppMethodBeat.o(78006);
        return 0;
    }

    public final int keep_onDownloadSuccessed(String str, d dVar) {
        int a;
        AppMethodBeat.i(78007);
        if (this.fyE != null) {
            a = this.fyE.a(str, null, dVar);
        } else {
            a = 0;
        }
        if (a == 0 && this.fyz != null) {
            a(dVar);
            this.fyz.a(str, null, dVar);
        }
        AppMethodBeat.o(78007);
        return 0;
    }

    public final void keep_cdnGetSkeyBuf(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(78008);
        if (this.fyz != null) {
            this.fyz.a(str, byteArrayOutputStream);
        }
        AppMethodBeat.o(78008);
    }

    public final byte[] keep_cdnDecodePrepareResponse(String str, byte[] bArr) {
        AppMethodBeat.i(78009);
        if (this.fyz != null) {
            byte[] l = this.fyz.l(str, bArr);
            AppMethodBeat.o(78009);
            return l;
        }
        AppMethodBeat.o(78009);
        return null;
    }

    public final void keep_onMoovReady(String str, int i, int i2) {
        AppMethodBeat.i(78010);
        ab.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d, hash[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(hashCode()));
        if (this.fyE != null) {
            this.fyE.onMoovReady(str, i, i2);
            AppMethodBeat.o(78010);
            return;
        }
        ab.e("MicroMsg.CdnTransportEngine", "cdn call on moov ready but onlineVideoCallback is null.hash[%d]", Integer.valueOf(hashCode()));
        h.pYm.k(354, 29, 1);
        AppMethodBeat.o(78010);
    }

    public final void keep_onDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(78011);
        ab.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.fyE != null) {
            this.fyE.onDataAvailable(str, i, i2);
        }
        AppMethodBeat.o(78011);
    }

    public final void keep_onDownloadToEnd(String str, int i, int i2) {
        AppMethodBeat.i(78012);
        ab.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.fyE != null) {
            this.fyE.onDownloadToEnd(str, i, i2);
        }
        AppMethodBeat.o(78012);
    }

    public final void release() {
        AppMethodBeat.i(78013);
        CdnLogic.UnInitialize();
        this.fyz = null;
        AppMethodBeat.o(78013);
    }

    private static void a(d dVar) {
        AppMethodBeat.i(78014);
        if (!(dVar == null || bo.isNullOrNil(dVar.field_transInfo))) {
            int indexOf = dVar.field_transInfo.indexOf("@,");
            if (indexOf > 0) {
                dVar.efY = dVar.field_transInfo.substring(indexOf + 2);
                dVar.field_transInfo = dVar.field_transInfo.substring(0, indexOf);
            }
            ab.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", dVar.field_transInfo, dVar.efY);
        }
        AppMethodBeat.o(78014);
    }

    public final void keep_cdnSendAndRecvData(String str, int i, int i2) {
        AppMethodBeat.i(78015);
        if (i < 0 || i2 < 0) {
            AppMethodBeat.o(78015);
            return;
        }
        this.fyA += i;
        this.fyB += i2;
        if (!bo.isNullOrNil(str)) {
            this.fyC = str;
        }
        if (this.fyA + this.fyB > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB && this.fyD != null) {
            this.fyD.ae(500, 500);
        }
        AppMethodBeat.o(78015);
    }

    public final void keep_OnRequestDoGetCdnDnsInfo(int i) {
        AppMethodBeat.i(78016);
        g.RN();
        if (com.tencent.mm.kernel.a.QX()) {
            f.afu().li(i);
        }
        AppMethodBeat.o(78016);
    }

    public final void requestGetCDN(int i) {
        AppMethodBeat.i(78017);
        if (ah.bqo()) {
            ab.i("MicroMsg.CdnTransportEngine", "requestgetcdn scene %d", Integer.valueOf(i));
            keep_OnRequestDoGetCdnDnsInfo(i);
            AppMethodBeat.o(78017);
            return;
        }
        AppMethodBeat.o(78017);
    }

    public final void reportFlow(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(78018);
        if (ah.bqo()) {
            ab.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3));
            keep_cdnSendAndRecvData("dummy clientmsgid", i2 + i4, i + i3);
            AppMethodBeat.o(78018);
            return;
        }
        AppMethodBeat.o(78018);
    }

    public final String[] resolveHost(String str, boolean z, int[] iArr) {
        AppMethodBeat.i(78019);
        if (ah.bqo()) {
            ab.i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", str, Boolean.valueOf(z));
            List arrayList = new ArrayList();
            iArr[0] = com.tencent.mm.network.b.a(str, z, arrayList);
            ab.i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", Integer.valueOf(iArr[0]), Arrays.toString((String[]) arrayList.toArray(new String[0])));
            AppMethodBeat.o(78019);
            return (String[]) arrayList.toArray(new String[0]);
        }
        AppMethodBeat.o(78019);
        return null;
    }

    public final void onUploadProgressChanged(String str, int i, int i2) {
        AppMethodBeat.i(78020);
        c cVar = new c();
        cVar.field_finishedLength = i;
        cVar.field_toltalLength = i2;
        cVar.field_status = 0;
        cVar.field_mtlnotify = false;
        keep_onUploadProgress(str, cVar);
        AppMethodBeat.o(78020);
    }

    public final byte[] getSessionRequestBuf(String str, byte[] bArr) {
        AppMethodBeat.i(78022);
        if (ah.bqo()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keep_cdnGetSkeyBuf(str, byteArrayOutputStream);
            if (byteArrayOutputStream.size() > 0) {
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                AppMethodBeat.o(78022);
                return toByteArray;
            }
            AppMethodBeat.o(78022);
            return null;
        }
        AppMethodBeat.o(78022);
        return null;
    }

    public final byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        AppMethodBeat.i(78023);
        if (ah.bqo()) {
            byte[] keep_cdnDecodePrepareResponse = keep_cdnDecodePrepareResponse(str, bArr);
            AppMethodBeat.o(78023);
            return keep_cdnDecodePrepareResponse;
        }
        AppMethodBeat.o(78023);
        return null;
    }

    public final void onDownloadProgressChanged(String str, int i, int i2, boolean z) {
        AppMethodBeat.i(78024);
        c cVar = new c();
        cVar.field_finishedLength = i;
        cVar.field_toltalLength = i2;
        cVar.field_status = 0;
        cVar.field_mtlnotify = z;
        keep_onDownloadProgress(str, cVar);
        AppMethodBeat.o(78024);
    }

    public final void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult) {
        AppMethodBeat.i(78025);
        d a = a(c2CDownloadResult, null);
        if (a.field_retCode != 0) {
            keep_onDownloadError(str, a);
            AppMethodBeat.o(78025);
            return;
        }
        keep_onDownloadSuccessed(str, a);
        AppMethodBeat.o(78025);
    }

    public final void onMoovReady(String str, int i, int i2) {
        AppMethodBeat.i(78026);
        keep_onMoovReady(str, i, i2);
        AppMethodBeat.o(78026);
    }

    public final void onDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(78027);
        keep_onDataAvailable(str, i, i2);
        AppMethodBeat.o(78027);
    }

    public final void onDownloadToEnd(String str, int i, int i2) {
        AppMethodBeat.i(78028);
        keep_onDownloadToEnd(str, i, i2);
        AppMethodBeat.o(78028);
    }

    public final void onPreloadCompletedWithResult(String str, int i, int i2, C2CDownloadResult c2CDownloadResult) {
        AppMethodBeat.i(78029);
        if (this.fyz != null) {
            c2CDownloadResult.recvedBytes = i;
            this.fyz.a(str, a(c2CDownloadResult, null));
        }
        AppMethodBeat.o(78029);
    }

    public final int b(com.tencent.mm.i.g gVar) {
        boolean z = true;
        AppMethodBeat.i(77973);
        C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
        c2CUploadRequest.fileKey = gVar.field_mediaId;
        c2CUploadRequest.filePath = gVar.field_fullpath;
        c2CUploadRequest.thumbfilePath = gVar.field_thumbpath;
        c2CUploadRequest.fileSize = gVar.field_totalLen;
        c2CUploadRequest.fileType = gVar.field_fileType;
        c2CUploadRequest.forwardAeskey = gVar.field_aesKey;
        c2CUploadRequest.forwardFileid = gVar.field_fileId;
        c2CUploadRequest.midfileSize = gVar.field_midFileLength;
        c2CUploadRequest.queueTimeoutSeconds = 0;
        c2CUploadRequest.transforTimeoutSeconds = 0;
        c2CUploadRequest.toUser = gVar.field_talker;
        c2CUploadRequest.sendmsgFromCDN = gVar.field_sendmsg_viacdn;
        c2CUploadRequest.needCompressImage = gVar.field_needCompressImage;
        c2CUploadRequest.chatType = gVar.field_chattype;
        c2CUploadRequest.apptype = gVar.field_appType;
        c2CUploadRequest.bizscene = gVar.field_bzScene;
        c2CUploadRequest.checkExistOnly = gVar.field_onlycheckexist;
        c2CUploadRequest.isSmallVideo = gVar.field_smallVideoFlag == 1;
        c2CUploadRequest.isLargeSVideo = gVar.field_largesvideo;
        c2CUploadRequest.videoSource = gVar.field_videosource;
        if (gVar.field_advideoflag != 1) {
            z = false;
        }
        c2CUploadRequest.isSnsAdVideo = z;
        c2CUploadRequest.isStorageMode = gVar.field_needStorage;
        c2CUploadRequest.isStreamMedia = gVar.field_isStreamMedia;
        c2CUploadRequest.enableHitCheck = gVar.field_enable_hitcheck;
        c2CUploadRequest.forceNoSafeCdn = gVar.field_force_aeskeycdn;
        c2CUploadRequest.trySafeCdn = gVar.field_trysafecdn;
        c2CUploadRequest.midimgPath = gVar.field_midimgpath;
        c2CUploadRequest.bigfileSignature = gVar.field_svr_signature;
        if (bo.isNullOrNil(c2CUploadRequest.bigfileSignature)) {
            c2CUploadRequest.bigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignature = gVar.field_fake_bigfile_signature;
        if (bo.isNullOrNil(c2CUploadRequest.fakeBigfileSignature)) {
            c2CUploadRequest.fakeBigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignatureAeskey = gVar.field_fake_bigfile_signature_aeskey;
        if (bo.isNullOrNil(c2CUploadRequest.fakeBigfileSignatureAeskey)) {
            c2CUploadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CUploadRequest.lastError = gVar.lastError;
        int startSSUpload;
        if (c2CUploadRequest.sendmsgFromCDN) {
            startSSUpload = CdnLogic.startSSUpload(c2CUploadRequest, this, this);
            AppMethodBeat.o(77973);
            return startSSUpload;
        }
        startSSUpload = CdnLogic.startC2CUpload(c2CUploadRequest, this);
        AppMethodBeat.o(77973);
        return startSSUpload;
    }

    public final void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult) {
        AppMethodBeat.i(78021);
        d dVar = new d();
        dVar.field_retCode = c2CUploadResult.errorCode;
        dVar.field_toUser = c2CUploadResult.touser;
        dVar.field_UploadHitCacheType = c2CUploadResult.hitCache;
        dVar.field_fileId = c2CUploadResult.fileid;
        dVar.field_aesKey = c2CUploadResult.aeskey;
        dVar.field_filemd5 = c2CUploadResult.filemd5;
        dVar.field_thumbfilemd5 = c2CUploadResult.thumbfilemd5;
        dVar.field_mp4identifymd5 = c2CUploadResult.mp4identifymd5;
        dVar.field_transInfo = c2CUploadResult.transforMsg;
        dVar.field_fileLength = c2CUploadResult.fileSize;
        dVar.field_midimgLength = c2CUploadResult.midfileSize;
        dVar.field_thumbimgLength = c2CUploadResult.thumbfileSize;
        dVar.field_needSendMsgField = !c2CUploadResult.sendmsgFromCDN;
        dVar.field_exist_whencheck = c2CUploadResult.existOnSvr;
        if (c2CUploadResult.skeyrespbuf != null) {
            dVar.field_sKeyrespbuf = (byte[]) c2CUploadResult.skeyrespbuf.clone();
        }
        dVar.field_videoFileId = c2CUploadResult.videofileid;
        dVar.field_filecrc = c2CUploadResult.fileCrc32;
        dVar.field_upload_by_safecdn = c2CUploadResult.uploadBySafecdn;
        dVar.field_isVideoReduced = c2CUploadResult.isVideoReduced;
        if (c2CUploadResult.usedSvrIps != null) {
            dVar.field_usedSvrIps = (String[]) c2CUploadResult.usedSvrIps.clone();
        }
        dVar.field_fileUrl = c2CUploadResult.fileUrl;
        dVar.field_thumbUrl = c2CUploadResult.thumbfileUrl;
        dVar.field_isResume = c2CUploadResult.isResume;
        dVar.field_delayTime = c2CUploadResult.delayTime;
        dVar.field_connectCostTime = c2CUploadResult.connectCostTime;
        dVar.field_waitResponseCostTime = c2CUploadResult.waitResponseCostTime;
        dVar.field_receiveCostTime = c2CUploadResult.receiveCostTime;
        dVar.field_clientIP = c2CUploadResult.clientIP;
        dVar.field_serverIP = c2CUploadResult.serverIP;
        dVar.field_clientHostIP = rM(c2CUploadResult.clientIP);
        dVar.field_serverHostIP = rM(c2CUploadResult.serverIP);
        if (dVar.field_retCode != 0) {
            keep_onUploadError(str, dVar);
            AppMethodBeat.o(78021);
            return;
        }
        keep_onUploadSuccessed(str, dVar);
        AppMethodBeat.o(78021);
    }
}

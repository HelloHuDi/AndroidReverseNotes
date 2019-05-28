package com.tencent.p177mm.p187al;

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
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C18497f;
import com.tencent.p177mm.p235i.C26324b.C26323a;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7273mw;
import com.tencent.p177mm.protocal.protobuf.C7274mx;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
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

/* renamed from: com.tencent.mm.al.a */
public final class C8941a implements AppCallback, DownloadCallback, SessionCallback, UploadCallback, VideoStreamingCallback {
    private static int fyt = 7340033;
    private static int fyu = 100;
    private static int fyv = 101;
    private static int fyw = 102;
    private static int fyx = 103;
    private int fyA = 0;
    private int fyB = 0;
    private String fyC = "";
    private C7564ap fyD = null;
    public C8943a fyE;
    private C7273mw fyy = null;
    private C26323a fyz = null;

    /* renamed from: com.tencent.mm.al.a$1 */
    class C89421 implements C5015a {
        C89421() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(77968);
            if (C8941a.this.fyA == 0 && C8941a.this.fyB == 0) {
                AppMethodBeat.m2505o(77968);
                return false;
            }
            C4990ab.m7417i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", C8941a.this.fyC, Integer.valueOf(C8941a.this.fyA), Integer.valueOf(C8941a.this.fyB));
            if (C26417a.flv == null) {
                C4990ab.m7412e("MicroMsg.CdnTransportEngine", "getNetStat null");
                AppMethodBeat.m2505o(77968);
                return false;
            }
            C26417a.flv.mo44184cm(C8941a.this.fyB, C8941a.this.fyA);
            C8941a.this.fyA = 0;
            C8941a.this.fyB = 0;
            AppMethodBeat.m2505o(77968);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.al.a$a */
    public interface C8943a {
        /* renamed from: a */
        int mo20397a(String str, C18496c c18496c, C9545d c9545d);

        void onDataAvailable(String str, int i, int i2);

        void onDownloadToEnd(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);
    }

    /* renamed from: com.tencent.mm.al.a$b */
    class C8944b {
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

        C8944b() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(77969);
            String format = String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d, safecdn:%d, snsstream:%d, snsimage:%d, videohosts:\n%s", new Object[]{Integer.valueOf(this.field_WifiEtl), Integer.valueOf(this.field_noWifiEtl), Integer.valueOf(this.field_Ptl), Integer.valueOf(this.field_UseStreamCDN), Boolean.valueOf(this.field_onlysendETL), Boolean.valueOf(this.field_onlyrecvPtl), Integer.valueOf(this.field_AckSlice), Integer.valueOf(this.field_EnableCDNVerifyConnect), Integer.valueOf(this.field_EnableCDNVideoRedirectOC), Integer.valueOf(this.field_EnableStreamUploadVideo), Integer.valueOf(this.field_UseDynamicETL), Integer.valueOf(this.field_C2COverloadDelaySeconds), Integer.valueOf(this.field_SNSOverloadDelaySeconds), Integer.valueOf(this.field_EnableSafeCDN), Integer.valueOf(this.field_EnableSnsStreamDownload), Integer.valueOf(this.field_EnableSnsImageDownload), this.field_ApprovedVideoHosts});
            AppMethodBeat.m2505o(77969);
            return format;
        }
    }

    public C8941a(String str, C26323a c26323a) {
        AppMethodBeat.m2504i(77970);
        if (C4996ah.bqo()) {
            this.fyD = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C89421(), true);
        }
        this.fyz = c26323a;
        CdnLogic.Initialize(str, this, "1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001", "cdnwx2013usrname");
        C4990ab.m7417i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", Integer.valueOf(hashCode()), str, C5046bo.dpG());
        AppMethodBeat.m2505o(77970);
    }

    public static int keep_callFromJni(int i, int i2, byte[] bArr) {
        AppMethodBeat.m2504i(77971);
        if (i == fyu) {
            C37458c.outputJniLog(bArr, "MicroMsg.CdnEngine", i2);
        }
        AppMethodBeat.m2505o(77971);
        return 0;
    }

    /* renamed from: a */
    private static C2CDownloadRequest m16115a(C42130g c42130g) {
        boolean z = true;
        AppMethodBeat.m2504i(77972);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileid = c42130g.field_fileId;
        c2CDownloadRequest.aeskey = c42130g.field_aesKey;
        c2CDownloadRequest.fileType = c42130g.field_fileType;
        c2CDownloadRequest.fileKey = c42130g.field_mediaId;
        c2CDownloadRequest.fileSize = c42130g.field_totalLen;
        c2CDownloadRequest.savePath = c42130g.field_fullpath;
        c2CDownloadRequest.isStorageMode = c42130g.field_needStorage;
        c2CDownloadRequest.isSmallVideo = c42130g.field_smallVideoFlag == 1;
        if (c42130g.field_largesvideo <= 0) {
            z = false;
        }
        c2CDownloadRequest.isLargeSVideo = z;
        c2CDownloadRequest.limitRate = c42130g.field_limitrate;
        c2CDownloadRequest.isAutoStart = c42130g.field_autostart;
        c2CDownloadRequest.chatType = c42130g.field_chattype;
        c2CDownloadRequest.isSilentTask = c42130g.field_isSilentTask;
        c2CDownloadRequest.requestVideoFormat = c42130g.field_requestVideoFormat;
        c2CDownloadRequest.isColdSnsData = c42130g.field_isColdSnsData;
        c2CDownloadRequest.signalQuality = c42130g.field_signalQuality;
        c2CDownloadRequest.snsScene = c42130g.field_snsScene;
        c2CDownloadRequest.requestVideoFormat = c42130g.field_requestVideoFormat;
        c2CDownloadRequest.videofileid = c42130g.field_videoFileId;
        c2CDownloadRequest.bigfileSignature = c42130g.field_svr_signature;
        if (C5046bo.isNullOrNil(c2CDownloadRequest.bigfileSignature)) {
            c2CDownloadRequest.bigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignature = c42130g.field_fake_bigfile_signature;
        if (C5046bo.isNullOrNil(c2CDownloadRequest.fakeBigfileSignature)) {
            c2CDownloadRequest.fakeBigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignatureAeskey = c42130g.field_fake_bigfile_signature_aeskey;
        if (C5046bo.isNullOrNil(c2CDownloadRequest.fakeBigfileSignatureAeskey)) {
            c2CDownloadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CDownloadRequest.msgExtra = c42130g.field_wxmsgparam;
        if (C5046bo.isNullOrNil(c2CDownloadRequest.msgExtra)) {
            c2CDownloadRequest.msgExtra = "";
        }
        c2CDownloadRequest.queueTimeoutSeconds = 0;
        c2CDownloadRequest.transforTimeoutSeconds = 0;
        c2CDownloadRequest.preloadRatio = c42130g.field_preloadRatio;
        c2CDownloadRequest.certificateVerifyPolicy = c42130g.certificateVerifyPolicy;
        c2CDownloadRequest.expectImageFormat = c42130g.expectImageFormat;
        AppMethodBeat.m2505o(77972);
        return c2CDownloadRequest;
    }

    /* renamed from: rF */
    public static int m16126rF(String str) {
        AppMethodBeat.m2504i(77974);
        CdnLogic.cancelTask(str);
        AppMethodBeat.m2505o(77974);
        return 0;
    }

    /* renamed from: c */
    public final int mo20374c(C42130g c42130g) {
        AppMethodBeat.m2504i(77975);
        int startC2CDownload = CdnLogic.startC2CDownload(C8941a.m16115a(c42130g), this);
        AppMethodBeat.m2505o(77975);
        return startC2CDownload;
    }

    /* renamed from: rG */
    public static int m16127rG(String str) {
        AppMethodBeat.m2504i(77976);
        CdnLogic.cancelTask(str);
        AppMethodBeat.m2505o(77976);
        return 0;
    }

    /* renamed from: rH */
    public static String m16128rH(String str) {
        AppMethodBeat.m2504i(77977);
        String calcFileMD5 = CdnLogic.calcFileMD5(str);
        AppMethodBeat.m2505o(77977);
        return calcFileMD5;
    }

    public static String afp() {
        AppMethodBeat.m2504i(77978);
        String createAeskey = CdnLogic.createAeskey();
        AppMethodBeat.m2505o(77978);
        return createAeskey;
    }

    /* renamed from: rI */
    public static int m16129rI(String str) {
        AppMethodBeat.m2504i(77979);
        int calcFileCrc32 = CdnLogic.calcFileCrc32(str);
        AppMethodBeat.m2505o(77979);
        return calcFileCrc32;
    }

    /* renamed from: rJ */
    public static String m16130rJ(String str) {
        AppMethodBeat.m2504i(77980);
        String calcMP4IdentifyMD5 = CdnLogic.calcMP4IdentifyMD5(str);
        AppMethodBeat.m2505o(77980);
        return calcMP4IdentifyMD5;
    }

    /* renamed from: a */
    public final int mo20363a(String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.m2504i(77981);
        C4990ab.m7417i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", str, str3);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.savePath = str3;
        c2CDownloadRequest.aeskey = str4;
        c2CDownloadRequest.customHttpHeader = "authkey: " + str5 + IOUtils.LINE_SEPARATOR_WINDOWS;
        c2CDownloadRequest.fileType = i;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.m2505o(77981);
        return startSNSDownload;
    }

    /* renamed from: a */
    public final int mo20362a(String str, String str2, String str3, int i, int i2, int i3, String[] strArr, boolean z) {
        int i4 = 0;
        AppMethodBeat.m2504i(77982);
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
        C4990ab.m7417i(str4, str5, objArr);
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
        if (C42129a.efP == c2CDownloadRequest.fileType) {
            i4 = CdnLogic.startHttpsDownload(c2CDownloadRequest, this);
            AppMethodBeat.m2505o(77982);
            return i4;
        }
        i4 = CdnLogic.startURLDownload(c2CDownloadRequest, this);
        AppMethodBeat.m2505o(77982);
        return i4;
    }

    /* renamed from: a */
    public final int mo20366a(String str, String str2, String str3, String str4, int i, String[] strArr, boolean z, String str5, String str6, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(77983);
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
        AppMethodBeat.m2505o(77983);
        return startSNSDownload;
    }

    /* renamed from: b */
    public final int mo20373b(String str, String str2, String str3, String str4, int i, String[] strArr, boolean z, String str5, String str6, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(77984);
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
        AppMethodBeat.m2505o(77984);
        return startSNSDownload;
    }

    /* renamed from: a */
    public final int mo20360a(C18497f c18497f) {
        String[] strArr;
        AppMethodBeat.m2504i(77985);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = 20201;
        c2CDownloadRequest.fileKey = c18497f.field_mediaId;
        c2CDownloadRequest.url = c18497f.url;
        c2CDownloadRequest.referer = c18497f.referer;
        c2CDownloadRequest.ocIpList = c18497f.ege != null ? (String[]) c18497f.ege.clone() : null;
        c2CDownloadRequest.ocIpListSource = c18497f.egg;
        if (c18497f.egf != null) {
            strArr = (String[]) c18497f.egf.clone();
        } else {
            strArr = null;
        }
        c2CDownloadRequest.dcIpList = strArr;
        c2CDownloadRequest.dcIpListSource = c18497f.egh;
        c2CDownloadRequest.isColdSnsData = c18497f.isColdSnsData;
        c2CDownloadRequest.signalQuality = c18497f.signalQuality;
        c2CDownloadRequest.snsScene = c18497f.snsScene;
        c2CDownloadRequest.concurrentCount = 6;
        c2CDownloadRequest.marscdnBizType = c18497f.duk;
        c2CDownloadRequest.marscdnAppType = c18497f.egi;
        c2CDownloadRequest.fileType = c18497f.fileType;
        c2CDownloadRequest.msgType = 2;
        c2CDownloadRequest.feedId = c18497f.cFc;
        c2CDownloadRequest.feedPicCount = c18497f.gXe;
        c2CDownloadRequest.batchSnsReqImageDatas = c18497f.egb;
        int startSNSDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, this, this, 0);
        AppMethodBeat.m2505o(77985);
        return startSNSDownload;
    }

    /* renamed from: a */
    public final int mo20368a(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, int i, int i2, boolean z, String str5, String str6, String str7, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(77986);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str4)) {
            C4990ab.m7412e("MicroMsg.CdnTransportEngine", "invalid param.");
            AppMethodBeat.m2505o(77986);
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
        AppMethodBeat.m2505o(77986);
        return startSNSDownload;
    }

    /* renamed from: rK */
    public static int m16131rK(String str) {
        AppMethodBeat.m2504i(77987);
        C4990ab.m7416i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:".concat(String.valueOf(str)));
        CdnLogic.cancelTask(str);
        AppMethodBeat.m2505o(77987);
        return 0;
    }

    /* renamed from: a */
    public final int mo20367a(String str, String str2, String str3, String str4, Map<String, String> map, boolean z, int i, int i2, boolean z2, boolean z3, String[] strArr) {
        AppMethodBeat.m2504i(77988);
        C4990ab.m7416i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:".concat(String.valueOf(str)));
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
        AppMethodBeat.m2505o(77988);
        return startHttpMultiSocketDownloadTask;
    }

    /* renamed from: rL */
    public static int m16132rL(String str) {
        AppMethodBeat.m2504i(77989);
        C4990ab.m7416i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:".concat(String.valueOf(str)));
        CdnLogic.cancelTask(str);
        AppMethodBeat.m2505o(77989);
        return 0;
    }

    /* renamed from: a */
    public final int mo20361a(C42130g c42130g, int i) {
        AppMethodBeat.m2504i(77990);
        int startVideoStreamingDownload = CdnLogic.startVideoStreamingDownload(C8941a.m16115a(c42130g), this, this, i);
        AppMethodBeat.m2505o(77990);
        return startVideoStreamingDownload;
    }

    /* renamed from: a */
    public final int mo20365a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2) {
        AppMethodBeat.m2504i(77991);
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
        AppMethodBeat.m2505o(77991);
        return startHttpVideoStreamingDownload;
    }

    /* renamed from: a */
    public final int mo20364a(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        AppMethodBeat.m2504i(77992);
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
        AppMethodBeat.m2505o(77992);
        return startHttpVideoStreamingDownload;
    }

    /* renamed from: b */
    public static int m16121b(String str, C9545d c9545d) {
        AppMethodBeat.m2504i(77993);
        C2CDownloadResult c2CDownloadResult = new C2CDownloadResult();
        int cancelDownloadTaskWithResult = CdnLogic.cancelDownloadTaskWithResult(str, c2CDownloadResult);
        C8941a.m16117a(c2CDownloadResult, c9545d);
        AppMethodBeat.m2505o(77993);
        return cancelDownloadTaskWithResult;
    }

    /* renamed from: k */
    public static int m16125k(String str, int i, int i2) {
        AppMethodBeat.m2504i(77994);
        int requestVideoData = CdnLogic.requestVideoData(str, i, i2, 0);
        AppMethodBeat.m2505o(77994);
        return requestVideoData;
    }

    public static boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(77995);
        boolean isVideoDataAvailable = CdnLogic.isVideoDataAvailable(str, i, i2);
        AppMethodBeat.m2505o(77995);
        return isVideoDataAvailable;
    }

    public final boolean afq() {
        return this.fyy == null;
    }

    /* renamed from: a */
    private static CdnInfo m16116a(C7273mw c7273mw) {
        AppMethodBeat.m2504i(77996);
        CdnInfo cdnInfo = new CdnInfo();
        if (c7273mw == null) {
            AppMethodBeat.m2505o(77996);
            return cdnInfo;
        }
        int i;
        int i2;
        cdnInfo.ver = c7273mw.vQV;
        cdnInfo.uin = c7273mw.luF;
        cdnInfo.frontid = c7273mw.vQX;
        cdnInfo.zoneid = c7273mw.vRc;
        cdnInfo.nettype = C37458c.m63164bV(C4996ah.getContext());
        cdnInfo.authkey = C1946aa.m4150a(c7273mw.vRb);
        if (c7273mw.vQY >= 2) {
            cdnInfo.frontip1 = C1946aa.m4148a((bts) c7273mw.vQZ.get(0));
            cdnInfo.frontip2 = C1946aa.m4148a((bts) c7273mw.vQZ.get(1));
            C4990ab.m7417i("MicroMsg.CdnTransportEngine", "frontip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (c7273mw.vRd >= 2) {
            cdnInfo.zoneip1 = C1946aa.m4148a((bts) c7273mw.vRe.get(0));
            cdnInfo.zoneip2 = C1946aa.m4148a((bts) c7273mw.vRe.get(1));
            C4990ab.m7417i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (c7273mw.vRh > 0) {
            i = ((C7274mx) c7273mw.vRf.get(0)).vRj;
            cdnInfo.frontports = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                cdnInfo.frontports[i2] = ((Integer) ((C7274mx) c7273mw.vRf.get(0)).vRk.get(i2)).intValue();
            }
        }
        if (c7273mw.vRi > 0) {
            i = ((C7274mx) c7273mw.vRg.get(0)).vRj;
            cdnInfo.zoneports = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                cdnInfo.zoneports[i2] = ((Integer) ((C7274mx) c7273mw.vRg.get(0)).vRk.get(i2)).intValue();
            }
        }
        AppMethodBeat.m2505o(77996);
        return cdnInfo;
    }

    /* renamed from: a */
    public final boolean mo20369a(C7273mw c7273mw, C7273mw c7273mw2, C7273mw c7273mw3, byte[] bArr, byte[] bArr2, C7273mw c7273mw4) {
        AppMethodBeat.m2504i(77997);
        C4990ab.m7417i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", this.fyy, c7273mw, c7273mw4, C5046bo.dpG());
        if (c7273mw == null && bArr == null) {
            AppMethodBeat.m2505o(77997);
            return false;
        }
        this.fyy = c7273mw;
        try {
            CdnLogic.setLegacyCdnInfo(C8941a.m16116a(c7273mw), C8941a.m16116a(c7273mw2), C8941a.m16116a(c7273mw3), C8941a.m16116a(c7273mw4), bArr, bArr2);
            CdnLogic.setDebugIP("");
            if (C1947ae.giS && C1947ae.giJ != null && C1947ae.giJ.length() >= 7) {
                C4990ab.m7421w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", C1947ae.giJ);
                CdnLogic.setDebugIP(C1947ae.giJ);
            }
            AppMethodBeat.m2505o(77997);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + e.getLocalizedMessage());
            AppMethodBeat.m2505o(77997);
            return false;
        }
    }

    public final C8944b afr() {
        AppMethodBeat.m2504i(77998);
        C8944b c8944b = new C8944b();
        AppMethodBeat.m2505o(77998);
        return c8944b;
    }

    /* renamed from: a */
    public static void m16118a(C8944b c8944b) {
        AppMethodBeat.m2504i(77999);
        C4990ab.m7416i("MicroMsg.CdnTransportEngine", "set WXConfig:".concat(String.valueOf(c8944b)));
        Config config = new Config();
        config.AckSlice = c8944b.field_AckSlice;
        config.UseDynamicETL = c8944b.field_UseDynamicETL;
        config.UseStreamCDN = c8944b.field_UseStreamCDN;
        config.C2COverloadDelaySeconds = c8944b.field_C2COverloadDelaySeconds;
        config.SNSOverloadDelaySeconds = c8944b.field_SNSOverloadDelaySeconds;
        config.EnableCDNVerifyConnect = c8944b.field_EnableCDNVerifyConnect;
        config.EnableCDNVideoRedirectOC = c8944b.field_EnableCDNVideoRedirectOC;
        config.EnableStreamUploadVideo = c8944b.field_EnableStreamUploadVideo;
        config.EnableSafeCDN = c8944b.field_EnableSafeCDN;
        config.EnableSnsStreamDownload = c8944b.field_EnableSnsStreamDownload;
        config.EnableSnsImageDownload = c8944b.field_EnableSnsImageDownload;
        if (!C5046bo.isNullOrNil(c8944b.field_ApprovedVideoHosts)) {
            config.ApprovedVideoHosts = c8944b.field_ApprovedVideoHosts;
        }
        config.WifiEtl = c8944b.field_WifiEtl;
        config.MobileEtl = c8944b.field_noWifiEtl;
        config.onlyrecvPtl = c8944b.field_onlyrecvPtl;
        config.onlysendETL = c8944b.field_onlysendETL;
        config.Ptl = c8944b.field_Ptl;
        CdnLogic.setConfig(config);
        AppMethodBeat.m2505o(77999);
    }

    /* renamed from: rM */
    private static int m16133rM(String str) {
        int i;
        AppMethodBeat.m2504i(78000);
        C4990ab.m7417i("MicroMsg.CdnTransportEngine", "ipFromString %s", str);
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
        AppMethodBeat.m2505o(78000);
        return i;
    }

    /* renamed from: a */
    private static C9545d m16117a(C2CDownloadResult c2CDownloadResult, C9545d c9545d) {
        AppMethodBeat.m2504i(78001);
        if (c9545d == null) {
            c9545d = new C9545d();
        }
        c9545d.field_retCode = c2CDownloadResult.errorCode;
        c9545d.field_argInfo = c2CDownloadResult.argInfo;
        c9545d.field_fileLength = c2CDownloadResult.fileSize;
        c9545d.field_fileId = c2CDownloadResult.fileid;
        c9545d.field_transInfo = c2CDownloadResult.transforMsg;
        c9545d.field_convert2baseline = false;
        c9545d.field_recvedBytes = c2CDownloadResult.recvedBytes;
        c9545d.field_videoFormat = c2CDownloadResult.videoFormat;
        c9545d.field_enQueueTime = c2CDownloadResult.enQueueTime;
        c9545d.field_startTime = c2CDownloadResult.startTime;
        c9545d.field_endTime = c2CDownloadResult.endTime;
        c9545d.field_firstRequestCost = c2CDownloadResult.firstRequestCost;
        c9545d.field_firstRequestSize = c2CDownloadResult.firstRequestSize;
        c9545d.field_firstRequestDownloadSize = c2CDownloadResult.firstRequestDownloadSize;
        c9545d.field_firstRequestCompleted = c2CDownloadResult.firstRequestCompleted;
        c9545d.field_averageSpeed = c2CDownloadResult.averageSpeed;
        c9545d.field_averageConnectCost = c2CDownloadResult.averageConnectCost;
        c9545d.field_firstConnectCost = c2CDownloadResult.firstConnectCost;
        c9545d.field_netConnectTimes = c2CDownloadResult.netConnectTimes;
        c9545d.field_moovRequestTimes = c2CDownloadResult.moovRequestTimes;
        c9545d.field_moovCost = c2CDownloadResult.moovCost;
        c9545d.field_moovSize = c2CDownloadResult.moovSize;
        c9545d.field_moovCompleted = c2CDownloadResult.moovCompleted;
        c9545d.field_moovFailReason = c2CDownloadResult.moovFailReason;
        c9545d.field_previousCompletedSize = c2CDownloadResult.previousCompletedSize;
        c9545d.field_averageRequestSize = c2CDownloadResult.averageRequestSize;
        c9545d.field_averageRequestCost = c2CDownloadResult.averageRequestCost;
        c9545d.field_requestTotalCount = c2CDownloadResult.requestTotalCount;
        c9545d.field_requestCompletedCount = c2CDownloadResult.requestCompletedCount;
        c9545d.field_requestTimeoutCount = c2CDownloadResult.requestTimeoutCount;
        c9545d.field_httpStatusCode = c2CDownloadResult.httpStatusCode;
        c9545d.field_httpResponseHeader = c2CDownloadResult.httpResponseHeader;
        c9545d.field_delayTime = c2CDownloadResult.delayTime;
        c9545d.field_dnsCostTime = c2CDownloadResult.dnsCostTime;
        c9545d.field_connectCostTime = c2CDownloadResult.connectCostTime;
        c9545d.field_waitResponseCostTime = c2CDownloadResult.waitResponseCostTime;
        c9545d.field_receiveCostTime = c2CDownloadResult.receiveCostTime;
        c9545d.field_clientIP = c2CDownloadResult.clientIP;
        c9545d.field_serverIP = c2CDownloadResult.serverIP;
        c9545d.field_clientHostIP = C8941a.m16133rM(c2CDownloadResult.clientIP);
        c9545d.field_serverHostIP = C8941a.m16133rM(c2CDownloadResult.serverIP);
        c9545d.field_xErrorNo = c2CDownloadResult.xErrorNo;
        c9545d.field_cSeqCheck = c2CDownloadResult.cSeqCheck;
        c9545d.field_usePrivateProtocol = c2CDownloadResult.usePrivateProtocol;
        c9545d.field_isCrossNet = c2CDownloadResult.crossNet;
        c9545d.field_clientIP = c2CDownloadResult.clientIP;
        if (c2CDownloadResult.usedSvrIps != null) {
            c9545d.field_usedSvrIps = (String[]) c2CDownloadResult.usedSvrIps.clone();
        }
        c9545d.field_isResume = c2CDownloadResult.isResume;
        c9545d.ega = c2CDownloadResult.isSnsImageProtocolAvailable;
        c9545d.index = c2CDownloadResult.picIndex;
        c9545d.cachePath = c2CDownloadResult.picCachePath;
        c9545d.cFc = c2CDownloadResult.batchPicFeedId;
        c9545d.fileKey = c2CDownloadResult.batchImageFileKey;
        c9545d.egb = c2CDownloadResult.batchImageNeedRetry;
        AppMethodBeat.m2505o(78001);
        return c9545d;
    }

    public final int keep_onUploadProgress(String str, C18496c c18496c) {
        AppMethodBeat.m2504i(78002);
        c18496c.field_isUploadTask = true;
        if (this.fyz != null) {
            C4990ab.m7419v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", str, Integer.valueOf(c18496c.field_toltalLength), Integer.valueOf(c18496c.field_finishedLength));
            this.fyz.mo23093a(str, c18496c, null);
        }
        AppMethodBeat.m2505o(78002);
        return 0;
    }

    public final int keep_onUploadError(String str, C9545d c9545d) {
        AppMethodBeat.m2504i(78003);
        if (this.fyz != null) {
            C8941a.m16119a(c9545d);
            this.fyz.mo23093a(str, null, c9545d);
        }
        AppMethodBeat.m2505o(78003);
        return 0;
    }

    public final int keep_onUploadSuccessed(String str, C9545d c9545d) {
        AppMethodBeat.m2504i(78004);
        if (this.fyz != null) {
            C4990ab.m7419v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", str);
            C8941a.m16119a(c9545d);
            this.fyz.mo23093a(str, null, c9545d);
        }
        AppMethodBeat.m2505o(78004);
        return 0;
    }

    public final int keep_onDownloadProgress(String str, C18496c c18496c) {
        int a;
        AppMethodBeat.m2504i(78005);
        c18496c.field_isUploadTask = false;
        if (this.fyE != null) {
            a = this.fyE.mo20397a(str, c18496c, null);
        } else {
            a = 0;
        }
        if (a == 0 && this.fyz != null) {
            C4990ab.m7419v("MicroMsg.CdnTransportEngine", "klem keep_onDownloadProgress mediaId:%s", str);
            this.fyz.mo23093a(str, c18496c, null);
        }
        AppMethodBeat.m2505o(78005);
        return 0;
    }

    public final int keep_onDownloadError(String str, C9545d c9545d) {
        int a;
        AppMethodBeat.m2504i(78006);
        if (this.fyE != null) {
            a = this.fyE.mo20397a(str, null, c9545d);
        } else {
            a = 0;
        }
        if (a == 0 && this.fyz != null) {
            C8941a.m16119a(c9545d);
            this.fyz.mo23093a(str, null, c9545d);
        }
        AppMethodBeat.m2505o(78006);
        return 0;
    }

    public final int keep_onDownloadSuccessed(String str, C9545d c9545d) {
        int a;
        AppMethodBeat.m2504i(78007);
        if (this.fyE != null) {
            a = this.fyE.mo20397a(str, null, c9545d);
        } else {
            a = 0;
        }
        if (a == 0 && this.fyz != null) {
            C8941a.m16119a(c9545d);
            this.fyz.mo23093a(str, null, c9545d);
        }
        AppMethodBeat.m2505o(78007);
        return 0;
    }

    public final void keep_cdnGetSkeyBuf(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.m2504i(78008);
        if (this.fyz != null) {
            this.fyz.mo23095a(str, byteArrayOutputStream);
        }
        AppMethodBeat.m2505o(78008);
    }

    public final byte[] keep_cdnDecodePrepareResponse(String str, byte[] bArr) {
        AppMethodBeat.m2504i(78009);
        if (this.fyz != null) {
            byte[] l = this.fyz.mo23098l(str, bArr);
            AppMethodBeat.m2505o(78009);
            return l;
        }
        AppMethodBeat.m2505o(78009);
        return null;
    }

    public final void keep_onMoovReady(String str, int i, int i2) {
        AppMethodBeat.m2504i(78010);
        C4990ab.m7417i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d, hash[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(hashCode()));
        if (this.fyE != null) {
            this.fyE.onMoovReady(str, i, i2);
            AppMethodBeat.m2505o(78010);
            return;
        }
        C4990ab.m7413e("MicroMsg.CdnTransportEngine", "cdn call on moov ready but onlineVideoCallback is null.hash[%d]", Integer.valueOf(hashCode()));
        C7060h.pYm.mo15419k(354, 29, 1);
        AppMethodBeat.m2505o(78010);
    }

    public final void keep_onDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(78011);
        C4990ab.m7417i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.fyE != null) {
            this.fyE.onDataAvailable(str, i, i2);
        }
        AppMethodBeat.m2505o(78011);
    }

    public final void keep_onDownloadToEnd(String str, int i, int i2) {
        AppMethodBeat.m2504i(78012);
        C4990ab.m7417i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.fyE != null) {
            this.fyE.onDownloadToEnd(str, i, i2);
        }
        AppMethodBeat.m2505o(78012);
    }

    public final void release() {
        AppMethodBeat.m2504i(78013);
        CdnLogic.UnInitialize();
        this.fyz = null;
        AppMethodBeat.m2505o(78013);
    }

    /* renamed from: a */
    private static void m16119a(C9545d c9545d) {
        AppMethodBeat.m2504i(78014);
        if (!(c9545d == null || C5046bo.isNullOrNil(c9545d.field_transInfo))) {
            int indexOf = c9545d.field_transInfo.indexOf("@,");
            if (indexOf > 0) {
                c9545d.efY = c9545d.field_transInfo.substring(indexOf + 2);
                c9545d.field_transInfo = c9545d.field_transInfo.substring(0, indexOf);
            }
            C4990ab.m7419v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", c9545d.field_transInfo, c9545d.efY);
        }
        AppMethodBeat.m2505o(78014);
    }

    public final void keep_cdnSendAndRecvData(String str, int i, int i2) {
        AppMethodBeat.m2504i(78015);
        if (i < 0 || i2 < 0) {
            AppMethodBeat.m2505o(78015);
            return;
        }
        this.fyA += i;
        this.fyB += i2;
        if (!C5046bo.isNullOrNil(str)) {
            this.fyC = str;
        }
        if (this.fyA + this.fyB > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB && this.fyD != null) {
            this.fyD.mo16770ae(500, 500);
        }
        AppMethodBeat.m2505o(78015);
    }

    public final void keep_OnRequestDoGetCdnDnsInfo(int i) {
        AppMethodBeat.m2504i(78016);
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            C37461f.afu().mo60373li(i);
        }
        AppMethodBeat.m2505o(78016);
    }

    public final void requestGetCDN(int i) {
        AppMethodBeat.m2504i(78017);
        if (C4996ah.bqo()) {
            C4990ab.m7417i("MicroMsg.CdnTransportEngine", "requestgetcdn scene %d", Integer.valueOf(i));
            keep_OnRequestDoGetCdnDnsInfo(i);
            AppMethodBeat.m2505o(78017);
            return;
        }
        AppMethodBeat.m2505o(78017);
    }

    public final void reportFlow(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(78018);
        if (C4996ah.bqo()) {
            C4990ab.m7417i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i3));
            keep_cdnSendAndRecvData("dummy clientmsgid", i2 + i4, i + i3);
            AppMethodBeat.m2505o(78018);
            return;
        }
        AppMethodBeat.m2505o(78018);
    }

    public final String[] resolveHost(String str, boolean z, int[] iArr) {
        AppMethodBeat.m2504i(78019);
        if (C4996ah.bqo()) {
            C4990ab.m7417i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", str, Boolean.valueOf(z));
            List arrayList = new ArrayList();
            iArr[0] = C1897b.m4018a(str, z, arrayList);
            C4990ab.m7417i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", Integer.valueOf(iArr[0]), Arrays.toString((String[]) arrayList.toArray(new String[0])));
            AppMethodBeat.m2505o(78019);
            return (String[]) arrayList.toArray(new String[0]);
        }
        AppMethodBeat.m2505o(78019);
        return null;
    }

    public final void onUploadProgressChanged(String str, int i, int i2) {
        AppMethodBeat.m2504i(78020);
        C18496c c18496c = new C18496c();
        c18496c.field_finishedLength = i;
        c18496c.field_toltalLength = i2;
        c18496c.field_status = 0;
        c18496c.field_mtlnotify = false;
        keep_onUploadProgress(str, c18496c);
        AppMethodBeat.m2505o(78020);
    }

    public final byte[] getSessionRequestBuf(String str, byte[] bArr) {
        AppMethodBeat.m2504i(78022);
        if (C4996ah.bqo()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keep_cdnGetSkeyBuf(str, byteArrayOutputStream);
            if (byteArrayOutputStream.size() > 0) {
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                AppMethodBeat.m2505o(78022);
                return toByteArray;
            }
            AppMethodBeat.m2505o(78022);
            return null;
        }
        AppMethodBeat.m2505o(78022);
        return null;
    }

    public final byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        AppMethodBeat.m2504i(78023);
        if (C4996ah.bqo()) {
            byte[] keep_cdnDecodePrepareResponse = keep_cdnDecodePrepareResponse(str, bArr);
            AppMethodBeat.m2505o(78023);
            return keep_cdnDecodePrepareResponse;
        }
        AppMethodBeat.m2505o(78023);
        return null;
    }

    public final void onDownloadProgressChanged(String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(78024);
        C18496c c18496c = new C18496c();
        c18496c.field_finishedLength = i;
        c18496c.field_toltalLength = i2;
        c18496c.field_status = 0;
        c18496c.field_mtlnotify = z;
        keep_onDownloadProgress(str, c18496c);
        AppMethodBeat.m2505o(78024);
    }

    public final void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult) {
        AppMethodBeat.m2504i(78025);
        C9545d a = C8941a.m16117a(c2CDownloadResult, null);
        if (a.field_retCode != 0) {
            keep_onDownloadError(str, a);
            AppMethodBeat.m2505o(78025);
            return;
        }
        keep_onDownloadSuccessed(str, a);
        AppMethodBeat.m2505o(78025);
    }

    public final void onMoovReady(String str, int i, int i2) {
        AppMethodBeat.m2504i(78026);
        keep_onMoovReady(str, i, i2);
        AppMethodBeat.m2505o(78026);
    }

    public final void onDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(78027);
        keep_onDataAvailable(str, i, i2);
        AppMethodBeat.m2505o(78027);
    }

    public final void onDownloadToEnd(String str, int i, int i2) {
        AppMethodBeat.m2504i(78028);
        keep_onDownloadToEnd(str, i, i2);
        AppMethodBeat.m2505o(78028);
    }

    public final void onPreloadCompletedWithResult(String str, int i, int i2, C2CDownloadResult c2CDownloadResult) {
        AppMethodBeat.m2504i(78029);
        if (this.fyz != null) {
            c2CDownloadResult.recvedBytes = i;
            this.fyz.mo23094a(str, C8941a.m16117a(c2CDownloadResult, null));
        }
        AppMethodBeat.m2505o(78029);
    }

    /* renamed from: b */
    public final int mo20372b(C42130g c42130g) {
        boolean z = true;
        AppMethodBeat.m2504i(77973);
        C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
        c2CUploadRequest.fileKey = c42130g.field_mediaId;
        c2CUploadRequest.filePath = c42130g.field_fullpath;
        c2CUploadRequest.thumbfilePath = c42130g.field_thumbpath;
        c2CUploadRequest.fileSize = c42130g.field_totalLen;
        c2CUploadRequest.fileType = c42130g.field_fileType;
        c2CUploadRequest.forwardAeskey = c42130g.field_aesKey;
        c2CUploadRequest.forwardFileid = c42130g.field_fileId;
        c2CUploadRequest.midfileSize = c42130g.field_midFileLength;
        c2CUploadRequest.queueTimeoutSeconds = 0;
        c2CUploadRequest.transforTimeoutSeconds = 0;
        c2CUploadRequest.toUser = c42130g.field_talker;
        c2CUploadRequest.sendmsgFromCDN = c42130g.field_sendmsg_viacdn;
        c2CUploadRequest.needCompressImage = c42130g.field_needCompressImage;
        c2CUploadRequest.chatType = c42130g.field_chattype;
        c2CUploadRequest.apptype = c42130g.field_appType;
        c2CUploadRequest.bizscene = c42130g.field_bzScene;
        c2CUploadRequest.checkExistOnly = c42130g.field_onlycheckexist;
        c2CUploadRequest.isSmallVideo = c42130g.field_smallVideoFlag == 1;
        c2CUploadRequest.isLargeSVideo = c42130g.field_largesvideo;
        c2CUploadRequest.videoSource = c42130g.field_videosource;
        if (c42130g.field_advideoflag != 1) {
            z = false;
        }
        c2CUploadRequest.isSnsAdVideo = z;
        c2CUploadRequest.isStorageMode = c42130g.field_needStorage;
        c2CUploadRequest.isStreamMedia = c42130g.field_isStreamMedia;
        c2CUploadRequest.enableHitCheck = c42130g.field_enable_hitcheck;
        c2CUploadRequest.forceNoSafeCdn = c42130g.field_force_aeskeycdn;
        c2CUploadRequest.trySafeCdn = c42130g.field_trysafecdn;
        c2CUploadRequest.midimgPath = c42130g.field_midimgpath;
        c2CUploadRequest.bigfileSignature = c42130g.field_svr_signature;
        if (C5046bo.isNullOrNil(c2CUploadRequest.bigfileSignature)) {
            c2CUploadRequest.bigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignature = c42130g.field_fake_bigfile_signature;
        if (C5046bo.isNullOrNil(c2CUploadRequest.fakeBigfileSignature)) {
            c2CUploadRequest.fakeBigfileSignature = "";
        }
        c2CUploadRequest.fakeBigfileSignatureAeskey = c42130g.field_fake_bigfile_signature_aeskey;
        if (C5046bo.isNullOrNil(c2CUploadRequest.fakeBigfileSignatureAeskey)) {
            c2CUploadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CUploadRequest.lastError = c42130g.lastError;
        int startSSUpload;
        if (c2CUploadRequest.sendmsgFromCDN) {
            startSSUpload = CdnLogic.startSSUpload(c2CUploadRequest, this, this);
            AppMethodBeat.m2505o(77973);
            return startSSUpload;
        }
        startSSUpload = CdnLogic.startC2CUpload(c2CUploadRequest, this);
        AppMethodBeat.m2505o(77973);
        return startSSUpload;
    }

    public final void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult) {
        AppMethodBeat.m2504i(78021);
        C9545d c9545d = new C9545d();
        c9545d.field_retCode = c2CUploadResult.errorCode;
        c9545d.field_toUser = c2CUploadResult.touser;
        c9545d.field_UploadHitCacheType = c2CUploadResult.hitCache;
        c9545d.field_fileId = c2CUploadResult.fileid;
        c9545d.field_aesKey = c2CUploadResult.aeskey;
        c9545d.field_filemd5 = c2CUploadResult.filemd5;
        c9545d.field_thumbfilemd5 = c2CUploadResult.thumbfilemd5;
        c9545d.field_mp4identifymd5 = c2CUploadResult.mp4identifymd5;
        c9545d.field_transInfo = c2CUploadResult.transforMsg;
        c9545d.field_fileLength = c2CUploadResult.fileSize;
        c9545d.field_midimgLength = c2CUploadResult.midfileSize;
        c9545d.field_thumbimgLength = c2CUploadResult.thumbfileSize;
        c9545d.field_needSendMsgField = !c2CUploadResult.sendmsgFromCDN;
        c9545d.field_exist_whencheck = c2CUploadResult.existOnSvr;
        if (c2CUploadResult.skeyrespbuf != null) {
            c9545d.field_sKeyrespbuf = (byte[]) c2CUploadResult.skeyrespbuf.clone();
        }
        c9545d.field_videoFileId = c2CUploadResult.videofileid;
        c9545d.field_filecrc = c2CUploadResult.fileCrc32;
        c9545d.field_upload_by_safecdn = c2CUploadResult.uploadBySafecdn;
        c9545d.field_isVideoReduced = c2CUploadResult.isVideoReduced;
        if (c2CUploadResult.usedSvrIps != null) {
            c9545d.field_usedSvrIps = (String[]) c2CUploadResult.usedSvrIps.clone();
        }
        c9545d.field_fileUrl = c2CUploadResult.fileUrl;
        c9545d.field_thumbUrl = c2CUploadResult.thumbfileUrl;
        c9545d.field_isResume = c2CUploadResult.isResume;
        c9545d.field_delayTime = c2CUploadResult.delayTime;
        c9545d.field_connectCostTime = c2CUploadResult.connectCostTime;
        c9545d.field_waitResponseCostTime = c2CUploadResult.waitResponseCostTime;
        c9545d.field_receiveCostTime = c2CUploadResult.receiveCostTime;
        c9545d.field_clientIP = c2CUploadResult.clientIP;
        c9545d.field_serverIP = c2CUploadResult.serverIP;
        c9545d.field_clientHostIP = C8941a.m16133rM(c2CUploadResult.clientIP);
        c9545d.field_serverHostIP = C8941a.m16133rM(c2CUploadResult.serverIP);
        if (c9545d.field_retCode != 0) {
            keep_onUploadError(str, c9545d);
            AppMethodBeat.m2505o(78021);
            return;
        }
        keep_onUploadSuccessed(str, c9545d);
        AppMethodBeat.m2505o(78021);
    }
}

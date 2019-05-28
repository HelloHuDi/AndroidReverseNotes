package com.tencent.p177mm.p235i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.i.d */
public final class C9545d {
    protected static final char[] egc = "0123456789ABCDEF".toCharArray();
    public String cFc;
    public String cHr;
    public String cachePath;
    public String efY;
    public String efZ;
    public boolean ega;
    public BatchSnsReqImageData[] egb;
    public int field_UploadHitCacheType;
    public String field_aesKey;
    public String field_arg;
    public String field_argInfo;
    public int field_averageConnectCost;
    public int field_averageRequestCost;
    public int field_averageRequestSize;
    public int field_averageSpeed;
    public int field_cSeqCheck;
    public int field_clientHostIP;
    public String field_clientIP;
    public int field_connectCostTime;
    public boolean field_convert2baseline;
    public int field_delayTime;
    public int field_dnsCostTime;
    public long field_enQueueTime;
    public long field_endTime;
    public boolean field_exist_whencheck;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    public int field_filecrc;
    public String field_filemd5;
    public int field_firstConnectCost;
    public boolean field_firstRequestCompleted;
    public int field_firstRequestCost;
    public int field_firstRequestDownloadSize;
    public int field_firstRequestSize;
    public String field_httpResponseHeader;
    public int field_httpStatusCode;
    public boolean field_isCrossNet;
    public boolean field_isResume;
    public boolean field_isVideoReduced;
    public int field_midimgLength;
    public boolean field_moovCompleted;
    public int field_moovCost;
    public int field_moovFailReason;
    public int field_moovRequestTimes;
    public int field_moovSize;
    public String field_mp4identifymd5;
    public boolean field_needSendMsgField;
    public int field_netConnectTimes;
    public int field_previousCompletedSize;
    public int field_receiveCostTime;
    public int field_recvedBytes;
    public int field_requestCompletedCount;
    public int field_requestTimeoutCount;
    public int field_requestTotalCount;
    public int field_retCode;
    public byte[] field_sKeyrespbuf;
    public int field_serverHostIP;
    public String field_serverIP;
    public long field_startTime;
    public String field_thumbUrl;
    public String field_thumbfilemd5;
    public int field_thumbimgLength;
    public String field_toUser;
    public String field_transInfo;
    public boolean field_upload_by_safecdn;
    public boolean field_usePrivateProtocol;
    public String[] field_usedSvrIps;
    public String field_videoFileId;
    public int field_videoFormat;
    public int field_waitResponseCostTime;
    public String field_xErrorNo;
    public String fileKey;
    public int index;

    /* renamed from: Jm */
    public final boolean mo20809Jm() {
        return this.field_upload_by_safecdn && (2 == this.field_UploadHitCacheType || 3 == this.field_UploadHitCacheType);
    }

    public C9545d() {
        this.efY = "";
        this.efZ = ",,,,,,";
        this.field_thumbUrl = "";
        this.field_fileUrl = "";
        this.field_filemd5 = "";
        this.field_thumbfilemd5 = "";
        this.field_mp4identifymd5 = "";
        this.field_exist_whencheck = false;
        this.field_recvedBytes = 0;
        this.field_videoFormat = 0;
        this.field_startTime = 0;
        this.field_endTime = 0;
        this.field_enQueueTime = 0;
        this.field_firstRequestCost = 0;
        this.field_firstRequestSize = 0;
        this.field_firstRequestDownloadSize = 0;
        this.field_firstRequestCompleted = false;
        this.field_averageSpeed = 0;
        this.field_averageConnectCost = 0;
        this.field_firstConnectCost = 0;
        this.field_netConnectTimes = 0;
        this.field_moovRequestTimes = 0;
        this.field_moovCost = 0;
        this.field_moovSize = 0;
        this.field_moovCompleted = false;
        this.field_moovFailReason = 0;
        this.field_previousCompletedSize = 0;
        this.field_averageRequestSize = 0;
        this.field_averageRequestCost = 0;
        this.field_requestTotalCount = 0;
        this.field_requestCompletedCount = 0;
        this.field_requestTimeoutCount = 0;
        this.field_httpStatusCode = 0;
        this.field_isVideoReduced = false;
        this.field_httpResponseHeader = "";
        this.field_dnsCostTime = 0;
        this.field_isResume = false;
        this.field_delayTime = 0;
        this.field_connectCostTime = 0;
        this.field_waitResponseCostTime = 0;
        this.field_receiveCostTime = 0;
        this.field_serverIP = "";
        this.field_clientHostIP = 0;
        this.field_serverHostIP = 0;
        this.field_xErrorNo = "";
        this.field_cSeqCheck = 0;
        this.field_usePrivateProtocol = true;
        this.field_isCrossNet = false;
        this.field_clientIP = "";
        this.field_UploadHitCacheType = 0;
        this.field_needSendMsgField = true;
        this.field_convert2baseline = false;
        this.field_exist_whencheck = false;
    }

    static {
        AppMethodBeat.m2504i(128593);
        AppMethodBeat.m2505o(128593);
    }

    private static String bytesToHex(byte[] bArr) {
        AppMethodBeat.m2504i(128590);
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = egc[i2 >>> 4];
            cArr[(i * 2) + 1] = egc[i2 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.m2505o(128590);
        return str;
    }

    public final String toString() {
        AppMethodBeat.m2504i(128591);
        String format = String.format("id:%s file:%s filelen:%d midlen:%d thlen:%d transInfo:%s retCode:%d toUser:%s arg:%s videoFileId:%s argInfo:%s hitcache:%d needsend:%b msgid:%d convert2baseline:%b thumbUrl:%s fileUrl:%s filemd5:%s thumbfilemd5:%s,mp4identifymd5:%s, exist_whencheck[%b], aesKey[%s], crc[%s], safecdn:%b", new Object[]{this.cHr, this.field_fileId, Integer.valueOf(this.field_fileLength), Integer.valueOf(this.field_midimgLength), Integer.valueOf(this.field_thumbimgLength), this.field_transInfo, Integer.valueOf(this.field_retCode), this.field_toUser, this.field_arg, this.field_videoFileId, this.field_argInfo, Integer.valueOf(this.field_UploadHitCacheType), Boolean.valueOf(this.field_needSendMsgField), Integer.valueOf(0), Boolean.valueOf(this.field_convert2baseline), this.field_thumbUrl, this.field_fileUrl, this.field_filemd5, this.field_thumbfilemd5, this.field_mp4identifymd5, Boolean.valueOf(this.field_exist_whencheck), C5046bo.anv(this.field_aesKey), Integer.valueOf(this.field_filecrc), Boolean.valueOf(this.field_upload_by_safecdn)});
        if (this.field_sKeyrespbuf != null) {
            format = format + String.format("skeyrespbuf:%s", new Object[]{C9545d.bytesToHex(this.field_sKeyrespbuf)});
        }
        AppMethodBeat.m2505o(128591);
        return format;
    }

    /* renamed from: Jn */
    public final String mo20810Jn() {
        AppMethodBeat.m2504i(128592);
        String str = "";
        if (this.field_usedSvrIps != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : this.field_usedSvrIps) {
                stringBuffer.append(append).append("|");
            }
            str = stringBuffer.toString();
        }
        AppMethodBeat.m2505o(128592);
        return str;
    }
}

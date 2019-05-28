package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public final class DownloadChunkLogInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!DownloadChunkLogInfo.class.desiredAssertionStatus());
    private static final String TAG = "DownloadChunkLogInfo";
    public String UUID = "";
    public String appId = "";
    public byte currentRetryCnt = (byte) 0;
    public long endTime = 0;
    public int errorCode = 0;
    public String flag = "";
    public byte isWap = (byte) 0;
    public String networkOperator = "";
    public int networkType = 0;
    public long readHeaderTime = 0;
    public long receiveDataSize = 0;
    public long requestRanagePosition = 0;
    public long requestRanageSize = 0;
    public String requestUrl = "";
    public long responseContentLength = 0;
    public int responseHttpCode = 0;
    public long responseRangeLength = 0;
    public long responseRangePosition = 0;
    public int resultState = 0;
    public long startTime = 0;
    public byte type = (byte) 0;
    public String via = "";

    static {
        AppMethodBeat.i(76041);
        AppMethodBeat.o(76041);
    }

    public final String className() {
        return "jce.DownloadChunkLogInfo";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final String getUUID() {
        return this.UUID;
    }

    public final void setUUID(String str) {
        this.UUID = str;
    }

    public final byte getType() {
        return this.type;
    }

    public final void setType(byte b) {
        this.type = b;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public final String getNetworkOperator() {
        return this.networkOperator;
    }

    public final void setNetworkOperator(String str) {
        this.networkOperator = str;
    }

    public final int getNetworkType() {
        return this.networkType;
    }

    public final void setNetworkType(int i) {
        this.networkType = i;
    }

    public final byte getIsWap() {
        return this.isWap;
    }

    public final void setIsWap(byte b) {
        this.isWap = b;
    }

    public final long getRequestRanagePosition() {
        return this.requestRanagePosition;
    }

    public final void setRequestRanagePosition(long j) {
        this.requestRanagePosition = j;
    }

    public final long getRequestRanageSize() {
        return this.requestRanageSize;
    }

    public final void setRequestRanageSize(long j) {
        this.requestRanageSize = j;
    }

    public final long getResponseRangePosition() {
        return this.responseRangePosition;
    }

    public final void setResponseRangePosition(long j) {
        this.responseRangePosition = j;
    }

    public final long getResponseRangeLength() {
        return this.responseRangeLength;
    }

    public final void setResponseRangeLength(long j) {
        this.responseRangeLength = j;
    }

    public final long getResponseContentLength() {
        return this.responseContentLength;
    }

    public final void setResponseContentLength(long j) {
        this.responseContentLength = j;
    }

    public final int getResponseHttpCode() {
        return this.responseHttpCode;
    }

    public final void setResponseHttpCode(int i) {
        this.responseHttpCode = i;
    }

    public final long getReceiveDataSize() {
        return this.receiveDataSize;
    }

    public final void setReceiveDataSize(long j) {
        this.receiveDataSize = j;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final long getReadHeaderTime() {
        return this.readHeaderTime;
    }

    public final void setReadHeaderTime(long j) {
        this.readHeaderTime = j;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final int getResultState() {
        return this.resultState;
    }

    public final void setResultState(int i) {
        this.resultState = i;
    }

    public final byte getCurrentRetryCnt() {
        return this.currentRetryCnt;
    }

    public final void setCurrentRetryCnt(byte b) {
        this.currentRetryCnt = b;
    }

    public final String getVia() {
        return this.via;
    }

    public final void setVia(String str) {
        this.via = str;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final String getFlag() {
        return this.flag;
    }

    public final void setFlag(String str) {
        this.flag = str;
    }

    public DownloadChunkLogInfo(String str, byte b, String str2, String str3, int i, byte b2, long j, long j2, long j3, long j4, long j5, int i2, long j6, long j7, long j8, long j9, int i3, int i4, byte b3, String str4, String str5, String str6) {
        this.UUID = str;
        this.type = b;
        this.requestUrl = str2;
        this.networkOperator = str3;
        this.networkType = i;
        this.isWap = b2;
        this.requestRanagePosition = j;
        this.requestRanageSize = j2;
        this.responseRangePosition = j3;
        this.responseRangeLength = j4;
        this.responseContentLength = j5;
        this.responseHttpCode = i2;
        this.receiveDataSize = j6;
        this.startTime = j7;
        this.readHeaderTime = j8;
        this.endTime = j9;
        this.errorCode = i3;
        this.resultState = i4;
        this.currentRetryCnt = b3;
        this.via = str4;
        this.appId = str5;
        this.flag = str6;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(76034);
        if (obj == null) {
            AppMethodBeat.o(76034);
            return false;
        }
        DownloadChunkLogInfo downloadChunkLogInfo = (DownloadChunkLogInfo) obj;
        if (JceUtil.equals(this.UUID, downloadChunkLogInfo.UUID) && JceUtil.equals(this.type, downloadChunkLogInfo.type) && JceUtil.equals(this.requestUrl, downloadChunkLogInfo.requestUrl) && JceUtil.equals(this.networkOperator, downloadChunkLogInfo.networkOperator) && JceUtil.equals(this.networkType, downloadChunkLogInfo.networkType) && JceUtil.equals(this.isWap, downloadChunkLogInfo.isWap) && JceUtil.equals(this.requestRanagePosition, downloadChunkLogInfo.requestRanagePosition) && JceUtil.equals(this.requestRanageSize, downloadChunkLogInfo.requestRanageSize) && JceUtil.equals(this.responseRangePosition, downloadChunkLogInfo.responseRangePosition) && JceUtil.equals(this.responseRangeLength, downloadChunkLogInfo.responseRangeLength) && JceUtil.equals(this.responseContentLength, downloadChunkLogInfo.responseContentLength) && JceUtil.equals(this.responseHttpCode, downloadChunkLogInfo.responseHttpCode) && JceUtil.equals(this.receiveDataSize, downloadChunkLogInfo.receiveDataSize) && JceUtil.equals(this.startTime, downloadChunkLogInfo.startTime) && JceUtil.equals(this.readHeaderTime, downloadChunkLogInfo.readHeaderTime) && JceUtil.equals(this.endTime, downloadChunkLogInfo.endTime) && JceUtil.equals(this.errorCode, downloadChunkLogInfo.errorCode) && JceUtil.equals(this.resultState, downloadChunkLogInfo.resultState) && JceUtil.equals(this.currentRetryCnt, downloadChunkLogInfo.currentRetryCnt) && JceUtil.equals(this.via, downloadChunkLogInfo.via) && JceUtil.equals(this.appId, downloadChunkLogInfo.appId) && JceUtil.equals(this.flag, downloadChunkLogInfo.flag)) {
            AppMethodBeat.o(76034);
            return true;
        }
        AppMethodBeat.o(76034);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(76035);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.o(76035);
            throw exception;
        } catch (Exception exception2) {
            ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.o(76035);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(76036);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(76036);
                throw assertionError;
            }
        }
        AppMethodBeat.o(76036);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76037);
        if (this.UUID != null) {
            jceOutputStream.write(this.UUID, 0);
        }
        jceOutputStream.write(this.type, 1);
        if (this.requestUrl != null) {
            jceOutputStream.write(this.requestUrl, 2);
        }
        if (this.networkOperator != null) {
            jceOutputStream.write(this.networkOperator, 3);
        }
        jceOutputStream.write(this.networkType, 4);
        jceOutputStream.write(this.isWap, 5);
        jceOutputStream.write(this.requestRanagePosition, 6);
        jceOutputStream.write(this.requestRanageSize, 7);
        jceOutputStream.write(this.responseRangePosition, 9);
        jceOutputStream.write(this.responseRangeLength, 10);
        jceOutputStream.write(this.responseContentLength, 11);
        jceOutputStream.write(this.responseHttpCode, 12);
        jceOutputStream.write(this.receiveDataSize, 13);
        jceOutputStream.write(this.startTime, 14);
        jceOutputStream.write(this.readHeaderTime, 15);
        jceOutputStream.write(this.endTime, 16);
        jceOutputStream.write(this.errorCode, 17);
        jceOutputStream.write(this.resultState, 18);
        jceOutputStream.write(this.currentRetryCnt, 19);
        if (this.via != null) {
            jceOutputStream.write(this.via, 20);
        }
        if (this.appId != null) {
            jceOutputStream.write(this.appId, 21);
        }
        if (this.flag != null) {
            jceOutputStream.write(this.flag, 22);
        }
        AppMethodBeat.o(76037);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76038);
        this.UUID = jceInputStream.readString(0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.requestUrl = jceInputStream.readString(2, false);
        this.networkOperator = jceInputStream.readString(3, false);
        this.networkType = jceInputStream.read(this.networkType, 4, false);
        this.isWap = jceInputStream.read(this.isWap, 5, false);
        this.requestRanagePosition = jceInputStream.read(this.requestRanagePosition, 6, false);
        this.requestRanageSize = jceInputStream.read(this.requestRanageSize, 7, false);
        this.responseRangePosition = jceInputStream.read(this.responseRangePosition, 9, false);
        this.responseRangeLength = jceInputStream.read(this.responseRangeLength, 10, false);
        this.responseContentLength = jceInputStream.read(this.responseContentLength, 11, false);
        this.responseHttpCode = jceInputStream.read(this.responseHttpCode, 12, false);
        this.receiveDataSize = jceInputStream.read(this.receiveDataSize, 13, false);
        this.startTime = jceInputStream.read(this.startTime, 14, false);
        this.readHeaderTime = jceInputStream.read(this.readHeaderTime, 15, false);
        this.endTime = jceInputStream.read(this.endTime, 16, false);
        this.errorCode = jceInputStream.read(this.errorCode, 17, false);
        this.resultState = jceInputStream.read(this.resultState, 18, false);
        this.currentRetryCnt = jceInputStream.read(this.currentRetryCnt, 19, false);
        this.via = jceInputStream.readString(20, false);
        this.appId = jceInputStream.readString(21, false);
        this.flag = jceInputStream.readString(22, false);
        AppMethodBeat.o(76038);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76039);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.UUID, "UUID");
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.requestUrl, "requestUrl");
        jceDisplayer.display(this.networkOperator, "networkOperator");
        jceDisplayer.display(this.networkType, "networkType");
        jceDisplayer.display(this.isWap, "isWap");
        jceDisplayer.display(this.requestRanagePosition, "requestRanagePosition");
        jceDisplayer.display(this.requestRanageSize, "requestRanageSize");
        jceDisplayer.display(this.responseRangePosition, "responseRangePosition");
        jceDisplayer.display(this.responseRangeLength, "responseRangeLength");
        jceDisplayer.display(this.responseContentLength, "responseContentLength");
        jceDisplayer.display(this.responseHttpCode, "responseHttpCode");
        jceDisplayer.display(this.receiveDataSize, "receiveDataSize");
        jceDisplayer.display(this.startTime, "startTime");
        jceDisplayer.display(this.readHeaderTime, "readHeaderTime");
        jceDisplayer.display(this.endTime, "endTime");
        jceDisplayer.display(this.errorCode, OpenSDKTool4Assistant.EXTRA_ERROR_CODE);
        jceDisplayer.display(this.resultState, "resultState");
        jceDisplayer.display(this.currentRetryCnt, "currentRetryCnt");
        jceDisplayer.display(this.via, OpenSDKTool4Assistant.EXTRA_VIA);
        jceDisplayer.display(this.appId, "appId");
        jceDisplayer.display(this.flag, "flag");
        AppMethodBeat.o(76039);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76040);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.UUID, true);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.requestUrl, true);
        jceDisplayer.displaySimple(this.networkOperator, true);
        jceDisplayer.displaySimple(this.networkType, true);
        jceDisplayer.displaySimple(this.isWap, true);
        jceDisplayer.displaySimple(this.requestRanagePosition, true);
        jceDisplayer.displaySimple(this.requestRanageSize, true);
        jceDisplayer.displaySimple(this.responseRangePosition, true);
        jceDisplayer.displaySimple(this.responseRangeLength, true);
        jceDisplayer.displaySimple(this.responseContentLength, true);
        jceDisplayer.displaySimple(this.responseHttpCode, true);
        jceDisplayer.displaySimple(this.receiveDataSize, true);
        jceDisplayer.displaySimple(this.startTime, true);
        jceDisplayer.displaySimple(this.readHeaderTime, true);
        jceDisplayer.displaySimple(this.endTime, true);
        jceDisplayer.displaySimple(this.errorCode, true);
        jceDisplayer.displaySimple(this.resultState, true);
        jceDisplayer.displaySimple(this.currentRetryCnt, true);
        jceDisplayer.displaySimple(this.via, true);
        jceDisplayer.displaySimple(this.appId, true);
        jceDisplayer.displaySimple(this.flag, false);
        AppMethodBeat.o(76040);
    }
}

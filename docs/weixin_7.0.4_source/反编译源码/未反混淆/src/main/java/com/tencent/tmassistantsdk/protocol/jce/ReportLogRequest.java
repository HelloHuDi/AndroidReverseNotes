package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class ReportLogRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ReportLogRequest.class.desiredAssertionStatus());
    private static final String TAG = "ReportLogRequest";
    static byte[] cache_logData;
    public String hostAppPackageName = "";
    public int hostAppVersion = 0;
    public String hostUserId = "";
    public byte[] logData = null;
    public int logType = 0;

    static {
        AppMethodBeat.i(76081);
        AppMethodBeat.o(76081);
    }

    public final String className() {
        return "jce.ReportLogRequest";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final int getLogType() {
        return this.logType;
    }

    public final void setLogType(int i) {
        this.logType = i;
    }

    public final byte[] getLogData() {
        return this.logData;
    }

    public final void setLogData(byte[] bArr) {
        this.logData = bArr;
    }

    public final String getHostUserId() {
        return this.hostUserId;
    }

    public final void setHostUserId(String str) {
        this.hostUserId = str;
    }

    public final String getHostAppPackageName() {
        return this.hostAppPackageName;
    }

    public final void setHostAppPackageName(String str) {
        this.hostAppPackageName = str;
    }

    public final int getHostAppVersion() {
        return this.hostAppVersion;
    }

    public final void setHostAppVersion(int i) {
        this.hostAppVersion = i;
    }

    public ReportLogRequest(int i, byte[] bArr, String str, String str2, int i2) {
        this.logType = i;
        this.logData = bArr;
        this.hostUserId = str;
        this.hostAppPackageName = str2;
        this.hostAppVersion = i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(76074);
        if (obj == null) {
            AppMethodBeat.o(76074);
            return false;
        }
        ReportLogRequest reportLogRequest = (ReportLogRequest) obj;
        if (JceUtil.equals(this.logType, reportLogRequest.logType) && JceUtil.equals(this.logData, reportLogRequest.logData) && JceUtil.equals(this.hostUserId, reportLogRequest.hostUserId) && JceUtil.equals(this.hostAppPackageName, reportLogRequest.hostAppPackageName) && JceUtil.equals(this.hostAppVersion, reportLogRequest.hostAppVersion)) {
            AppMethodBeat.o(76074);
            return true;
        }
        AppMethodBeat.o(76074);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(76075);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.o(76075);
            throw exception;
        } catch (Exception exception2) {
            ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.o(76075);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(76076);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(76076);
                throw assertionError;
            }
        }
        AppMethodBeat.o(76076);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76077);
        jceOutputStream.write(this.logType, 0);
        if (this.logData != null) {
            jceOutputStream.write(this.logData, 1);
        }
        if (this.hostUserId != null) {
            jceOutputStream.write(this.hostUserId, 2);
        }
        if (this.hostAppPackageName != null) {
            jceOutputStream.write(this.hostAppPackageName, 3);
        }
        jceOutputStream.write(this.hostAppVersion, 4);
        AppMethodBeat.o(76077);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76078);
        this.logType = jceInputStream.read(this.logType, 0, false);
        if (cache_logData == null) {
            byte[] bArr = new byte[1];
            cache_logData = bArr;
            bArr[0] = (byte) 0;
        }
        this.logData = jceInputStream.read(cache_logData, 1, false);
        this.hostUserId = jceInputStream.readString(2, false);
        this.hostAppPackageName = jceInputStream.readString(3, false);
        this.hostAppVersion = jceInputStream.read(this.hostAppVersion, 4, false);
        AppMethodBeat.o(76078);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76079);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.logType, "logType");
        jceDisplayer.display(this.logData, "logData");
        jceDisplayer.display(this.hostUserId, "hostUserId");
        jceDisplayer.display(this.hostAppPackageName, "hostAppPackageName");
        jceDisplayer.display(this.hostAppVersion, "hostAppVersion");
        AppMethodBeat.o(76079);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76080);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.logType, true);
        jceDisplayer.displaySimple(this.logData, true);
        jceDisplayer.displaySimple(this.hostUserId, true);
        jceDisplayer.displaySimple(this.hostAppPackageName, true);
        jceDisplayer.displaySimple(this.hostAppVersion, false);
        AppMethodBeat.o(76080);
    }
}

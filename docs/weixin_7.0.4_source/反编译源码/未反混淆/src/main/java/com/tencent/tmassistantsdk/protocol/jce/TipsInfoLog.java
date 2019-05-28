package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class TipsInfoLog extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!TipsInfoLog.class.desiredAssertionStatus());
    private static final String TAG = "TipsInfoLog";
    public int authorizedBtnClickCount = 0;
    public int authorizedTipsCount = 0;
    public int cancelBtnClickCount = 0;
    public int downloadBtnClickCount = 0;
    public int downloadTipsCount = 0;
    public String gameChannelId = "";
    public String gamePackageName = "";
    public int gameVersionCode = 0;
    public int installBtnClickCount = 0;
    public int installTipsCount = 0;
    public int networkErrorTipsCount = 0;
    public String userId = "";
    public String userIdType = "";

    static {
        AppMethodBeat.i(76157);
        AppMethodBeat.o(76157);
    }

    public final String className() {
        return "jce.TipsInfoLog";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getUserIdType() {
        return this.userIdType;
    }

    public final void setUserIdType(String str) {
        this.userIdType = str;
    }

    public final String getGamePackageName() {
        return this.gamePackageName;
    }

    public final void setGamePackageName(String str) {
        this.gamePackageName = str;
    }

    public final int getGameVersionCode() {
        return this.gameVersionCode;
    }

    public final void setGameVersionCode(int i) {
        this.gameVersionCode = i;
    }

    public final String getGameChannelId() {
        return this.gameChannelId;
    }

    public final void setGameChannelId(String str) {
        this.gameChannelId = str;
    }

    public final int getAuthorizedTipsCount() {
        return this.authorizedTipsCount;
    }

    public final void setAuthorizedTipsCount(int i) {
        this.authorizedTipsCount = i;
    }

    public final int getDownloadTipsCount() {
        return this.downloadTipsCount;
    }

    public final void setDownloadTipsCount(int i) {
        this.downloadTipsCount = i;
    }

    public final int getInstallTipsCount() {
        return this.installTipsCount;
    }

    public final void setInstallTipsCount(int i) {
        this.installTipsCount = i;
    }

    public final int getNetworkErrorTipsCount() {
        return this.networkErrorTipsCount;
    }

    public final void setNetworkErrorTipsCount(int i) {
        this.networkErrorTipsCount = i;
    }

    public final int getCancelBtnClickCount() {
        return this.cancelBtnClickCount;
    }

    public final void setCancelBtnClickCount(int i) {
        this.cancelBtnClickCount = i;
    }

    public final int getDownloadBtnClickCount() {
        return this.downloadBtnClickCount;
    }

    public final void setDownloadBtnClickCount(int i) {
        this.downloadBtnClickCount = i;
    }

    public final int getInstallBtnClickCount() {
        return this.installBtnClickCount;
    }

    public final void setInstallBtnClickCount(int i) {
        this.installBtnClickCount = i;
    }

    public final int getAuthorizedBtnClickCount() {
        return this.authorizedBtnClickCount;
    }

    public final void setAuthorizedBtnClickCount(int i) {
        this.authorizedBtnClickCount = i;
    }

    public TipsInfoLog(String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.userId = str;
        this.userIdType = str2;
        this.gamePackageName = str3;
        this.gameVersionCode = i;
        this.gameChannelId = str4;
        this.authorizedTipsCount = i2;
        this.downloadTipsCount = i3;
        this.installTipsCount = i4;
        this.networkErrorTipsCount = i5;
        this.cancelBtnClickCount = i6;
        this.downloadBtnClickCount = i7;
        this.installBtnClickCount = i8;
        this.authorizedBtnClickCount = i9;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(76150);
        if (obj == null) {
            AppMethodBeat.o(76150);
            return false;
        }
        TipsInfoLog tipsInfoLog = (TipsInfoLog) obj;
        if (JceUtil.equals(this.userId, tipsInfoLog.userId) && JceUtil.equals(this.userIdType, tipsInfoLog.userIdType) && JceUtil.equals(this.gamePackageName, tipsInfoLog.gamePackageName) && JceUtil.equals(this.gameVersionCode, tipsInfoLog.gameVersionCode) && JceUtil.equals(this.gameChannelId, tipsInfoLog.gameChannelId) && JceUtil.equals(this.authorizedTipsCount, tipsInfoLog.authorizedTipsCount) && JceUtil.equals(this.downloadTipsCount, tipsInfoLog.downloadTipsCount) && JceUtil.equals(this.installTipsCount, tipsInfoLog.installTipsCount) && JceUtil.equals(this.networkErrorTipsCount, tipsInfoLog.networkErrorTipsCount) && JceUtil.equals(this.cancelBtnClickCount, tipsInfoLog.cancelBtnClickCount) && JceUtil.equals(this.downloadBtnClickCount, tipsInfoLog.downloadBtnClickCount) && JceUtil.equals(this.installBtnClickCount, tipsInfoLog.installBtnClickCount) && JceUtil.equals(this.authorizedBtnClickCount, tipsInfoLog.authorizedBtnClickCount)) {
            AppMethodBeat.o(76150);
            return true;
        }
        AppMethodBeat.o(76150);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(76151);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.o(76151);
            throw exception;
        } catch (Exception exception2) {
            ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.o(76151);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(76152);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(76152);
                throw assertionError;
            }
        }
        AppMethodBeat.o(76152);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76153);
        if (this.userId != null) {
            jceOutputStream.write(this.userId, 0);
        }
        if (this.userIdType != null) {
            jceOutputStream.write(this.userIdType, 1);
        }
        if (this.gamePackageName != null) {
            jceOutputStream.write(this.gamePackageName, 2);
        }
        jceOutputStream.write(this.gameVersionCode, 3);
        if (this.gameChannelId != null) {
            jceOutputStream.write(this.gameChannelId, 4);
        }
        jceOutputStream.write(this.authorizedTipsCount, 5);
        jceOutputStream.write(this.downloadTipsCount, 6);
        jceOutputStream.write(this.installTipsCount, 7);
        jceOutputStream.write(this.networkErrorTipsCount, 8);
        jceOutputStream.write(this.cancelBtnClickCount, 9);
        jceOutputStream.write(this.downloadBtnClickCount, 10);
        jceOutputStream.write(this.installBtnClickCount, 11);
        jceOutputStream.write(this.authorizedBtnClickCount, 12);
        AppMethodBeat.o(76153);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76154);
        this.userId = jceInputStream.readString(0, false);
        this.userIdType = jceInputStream.readString(1, false);
        this.gamePackageName = jceInputStream.readString(2, false);
        this.gameVersionCode = jceInputStream.read(this.gameVersionCode, 3, false);
        this.gameChannelId = jceInputStream.readString(4, false);
        this.authorizedTipsCount = jceInputStream.read(this.authorizedTipsCount, 5, false);
        this.downloadTipsCount = jceInputStream.read(this.downloadTipsCount, 6, false);
        this.installTipsCount = jceInputStream.read(this.installTipsCount, 7, false);
        this.networkErrorTipsCount = jceInputStream.read(this.networkErrorTipsCount, 8, false);
        this.cancelBtnClickCount = jceInputStream.read(this.cancelBtnClickCount, 9, false);
        this.downloadBtnClickCount = jceInputStream.read(this.downloadBtnClickCount, 10, false);
        this.installBtnClickCount = jceInputStream.read(this.installBtnClickCount, 11, false);
        this.authorizedBtnClickCount = jceInputStream.read(this.authorizedBtnClickCount, 12, false);
        AppMethodBeat.o(76154);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76155);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.userId, "userId");
        jceDisplayer.display(this.userIdType, "userIdType");
        jceDisplayer.display(this.gamePackageName, "gamePackageName");
        jceDisplayer.display(this.gameVersionCode, "gameVersionCode");
        jceDisplayer.display(this.gameChannelId, "gameChannelId");
        jceDisplayer.display(this.authorizedTipsCount, "authorizedTipsCount");
        jceDisplayer.display(this.downloadTipsCount, "downloadTipsCount");
        jceDisplayer.display(this.installTipsCount, "installTipsCount");
        jceDisplayer.display(this.networkErrorTipsCount, "networkErrorTipsCount");
        jceDisplayer.display(this.cancelBtnClickCount, "cancelBtnClickCount");
        jceDisplayer.display(this.downloadBtnClickCount, "downloadBtnClickCount");
        jceDisplayer.display(this.installBtnClickCount, "installBtnClickCount");
        jceDisplayer.display(this.authorizedBtnClickCount, "authorizedBtnClickCount");
        AppMethodBeat.o(76155);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76156);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.userId, true);
        jceDisplayer.displaySimple(this.userIdType, true);
        jceDisplayer.displaySimple(this.gamePackageName, true);
        jceDisplayer.displaySimple(this.gameVersionCode, true);
        jceDisplayer.displaySimple(this.gameChannelId, true);
        jceDisplayer.displaySimple(this.authorizedTipsCount, true);
        jceDisplayer.displaySimple(this.downloadTipsCount, true);
        jceDisplayer.displaySimple(this.installTipsCount, true);
        jceDisplayer.displaySimple(this.networkErrorTipsCount, true);
        jceDisplayer.displaySimple(this.cancelBtnClickCount, true);
        jceDisplayer.displaySimple(this.downloadBtnClickCount, true);
        jceDisplayer.displaySimple(this.installBtnClickCount, true);
        jceDisplayer.displaySimple(this.authorizedBtnClickCount, false);
        AppMethodBeat.o(76156);
    }
}

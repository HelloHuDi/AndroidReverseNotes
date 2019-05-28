package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class IPCCmd implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!IPCCmd.class.desiredAssertionStatus());
    public static final IPCCmd BatchDownloadAction = new IPCCmd(9, 9, "BatchDownloadAction");
    public static final IPCCmd Empty = new IPCCmd(0, 0, "Empty");
    public static final IPCCmd GetDownloadProgress = new IPCCmd(3, 3, "GetDownloadProgress");
    public static final IPCCmd GetDownloadState = new IPCCmd(2, 2, "GetDownloadState");
    public static final IPCCmd OperateDownloadTask = new IPCCmd(1, 1, "OperateDownloadTask");
    public static final IPCCmd QueryDownloadTask = new IPCCmd(4, 4, "QueryDownloadTask");
    public static final IPCCmd QueryLoginInfo = new IPCCmd(6, 6, "QueryLoginInfo");
    public static final IPCCmd QueryLoginState = new IPCCmd(7, 7, "QueryLoginState");
    public static final IPCCmd ServiceFreeAction = new IPCCmd(8, 8, "ServiceFreeAction");
    public static final IPCCmd URIAction = new IPCCmd(5, 5, "URIAction");
    public static final int _BatchDownloadAction = 9;
    public static final int _Empty = 0;
    public static final int _GetDownloadProgress = 3;
    public static final int _GetDownloadState = 2;
    public static final int _OperateDownloadTask = 1;
    public static final int _QueryDownloadTask = 4;
    public static final int _QueryLoginInfo = 6;
    public static final int _QueryLoginState = 7;
    public static final int _ServiceFreeAction = 8;
    public static final int _URIAction = 5;
    private static IPCCmd[] __values = new IPCCmd[10];
    private String __T = new String();
    private int __value;

    static {
        AppMethodBeat.m2504i(75991);
        AppMethodBeat.m2505o(75991);
    }

    public static IPCCmd convert(int i) {
        AppMethodBeat.m2504i(75988);
        for (int i2 = 0; i2 < __values.length; i2++) {
            if (__values[i2].value() == i) {
                IPCCmd iPCCmd = __values[i2];
                AppMethodBeat.m2505o(75988);
                return iPCCmd;
            }
        }
        if ($assertionsDisabled) {
            AppMethodBeat.m2505o(75988);
            return null;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(75988);
        throw assertionError;
    }

    public static IPCCmd convert(String str) {
        AppMethodBeat.m2504i(75989);
        for (int i = 0; i < __values.length; i++) {
            if (__values[i].toString().equals(str)) {
                IPCCmd iPCCmd = __values[i];
                AppMethodBeat.m2505o(75989);
                return iPCCmd;
            }
        }
        if ($assertionsDisabled) {
            AppMethodBeat.m2505o(75989);
            return null;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(75989);
        throw assertionError;
    }

    public final int value() {
        return this.__value;
    }

    public final String toString() {
        return this.__T;
    }

    private IPCCmd(int i, int i2, String str) {
        AppMethodBeat.m2504i(75990);
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
        AppMethodBeat.m2505o(75990);
    }
}

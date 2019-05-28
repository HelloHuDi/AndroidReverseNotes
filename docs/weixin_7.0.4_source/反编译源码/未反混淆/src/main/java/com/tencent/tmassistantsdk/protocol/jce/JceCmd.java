package com.tencent.tmassistantsdk.protocol.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class JceCmd implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!JceCmd.class.desiredAssertionStatus());
    public static final JceCmd Empty = new JceCmd(0, 0, "Empty");
    public static final JceCmd GetAppSimpleDetail = new JceCmd(5, 5, "GetAppSimpleDetail");
    public static final JceCmd GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
    public static final JceCmd GetSettings = new JceCmd(2, 2, "GetSettings");
    public static final JceCmd ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
    public static final JceCmd ReportLog = new JceCmd(1, 1, "ReportLog");
    public static final int _Empty = 0;
    public static final int _GetAppSimpleDetail = 5;
    public static final int _GetAppUpdate = 3;
    public static final int _GetSettings = 2;
    public static final int _ReportApkFileInfo = 4;
    public static final int _ReportLog = 1;
    private static JceCmd[] __values = new JceCmd[6];
    private String __T = new String();
    private int __value;

    static {
        AppMethodBeat.i(76065);
        AppMethodBeat.o(76065);
    }

    public static JceCmd convert(int i) {
        AppMethodBeat.i(76062);
        for (int i2 = 0; i2 < __values.length; i2++) {
            if (__values[i2].value() == i) {
                JceCmd jceCmd = __values[i2];
                AppMethodBeat.o(76062);
                return jceCmd;
            }
        }
        if ($assertionsDisabled) {
            AppMethodBeat.o(76062);
            return null;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(76062);
        throw assertionError;
    }

    public static JceCmd convert(String str) {
        AppMethodBeat.i(76063);
        for (int i = 0; i < __values.length; i++) {
            if (__values[i].toString().equals(str)) {
                JceCmd jceCmd = __values[i];
                AppMethodBeat.o(76063);
                return jceCmd;
            }
        }
        if ($assertionsDisabled) {
            AppMethodBeat.o(76063);
            return null;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(76063);
        throw assertionError;
    }

    public final int value() {
        return this.__value;
    }

    public final String toString() {
        return this.__T;
    }

    private JceCmd(int i, int i2, String str) {
        AppMethodBeat.i(76064);
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
        AppMethodBeat.o(76064);
    }
}

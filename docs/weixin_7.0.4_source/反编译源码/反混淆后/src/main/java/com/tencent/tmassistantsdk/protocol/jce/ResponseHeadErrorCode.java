package com.tencent.tmassistantsdk.protocol.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class ResponseHeadErrorCode implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ResponseHeadErrorCode.class.desiredAssertionStatus());
    public static final ResponseHeadErrorCode EC_BUSINESS_ERROR = new ResponseHeadErrorCode(1, -11, "EC_BUSINESS_ERROR");
    public static final ResponseHeadErrorCode EC_SERVER_INTERNAL_ERROR = new ResponseHeadErrorCode(0, -10, "EC_SERVER_INTERNAL_ERROR");
    public static final int _EC_BUSINESS_ERROR = -11;
    public static final int _EC_SERVER_INTERNAL_ERROR = -10;
    private static ResponseHeadErrorCode[] __values = new ResponseHeadErrorCode[2];
    private String __T = new String();
    private int __value;

    static {
        AppMethodBeat.m2504i(76117);
        AppMethodBeat.m2505o(76117);
    }

    public static ResponseHeadErrorCode convert(int i) {
        AppMethodBeat.m2504i(76114);
        for (int i2 = 0; i2 < __values.length; i2++) {
            if (__values[i2].value() == i) {
                ResponseHeadErrorCode responseHeadErrorCode = __values[i2];
                AppMethodBeat.m2505o(76114);
                return responseHeadErrorCode;
            }
        }
        if ($assertionsDisabled) {
            AppMethodBeat.m2505o(76114);
            return null;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(76114);
        throw assertionError;
    }

    public static ResponseHeadErrorCode convert(String str) {
        AppMethodBeat.m2504i(76115);
        for (int i = 0; i < __values.length; i++) {
            if (__values[i].toString().equals(str)) {
                ResponseHeadErrorCode responseHeadErrorCode = __values[i];
                AppMethodBeat.m2505o(76115);
                return responseHeadErrorCode;
            }
        }
        if ($assertionsDisabled) {
            AppMethodBeat.m2505o(76115);
            return null;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(76115);
        throw assertionError;
    }

    public final int value() {
        return this.__value;
    }

    public final String toString() {
        return this.__T;
    }

    private ResponseHeadErrorCode(int i, int i2, String str) {
        AppMethodBeat.m2504i(76116);
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
        AppMethodBeat.m2505o(76116);
    }
}

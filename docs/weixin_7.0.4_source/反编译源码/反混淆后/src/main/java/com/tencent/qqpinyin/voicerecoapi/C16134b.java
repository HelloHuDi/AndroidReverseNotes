package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.qqpinyin.voicerecoapi.b */
public final class C16134b extends Exception {
    private String hAa = "";
    private int mErrorCode;

    public C16134b(int i) {
        String str;
        AppMethodBeat.m2504i(35441);
        this.mErrorCode = i;
        switch (i) {
            case ZipJNI.UNZ_INTERNALERROR /*-104*/:
                str = "null param or 0 length";
                break;
            case ZipJNI.UNZ_BADZIPFILE /*-103*/:
                str = "already init";
                break;
            case ZipJNI.UNZ_PARAMERROR /*-102*/:
                str = "should init at first";
                break;
            case XWalkUpdater.ERROR_SET_VERNUM /*-101*/:
                str = "speex engine error";
                break;
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                str = "out of memory";
                break;
            default:
                str = "unknown error";
                break;
        }
        this.hAa = str;
        new StringBuilder("errorCode: ").append(this.mErrorCode).append("\t msg: ").append(this.hAa);
        AppMethodBeat.m2505o(35441);
    }
}

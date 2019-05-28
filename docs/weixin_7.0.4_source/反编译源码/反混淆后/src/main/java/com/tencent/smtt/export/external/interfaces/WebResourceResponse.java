package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public class WebResourceResponse {
    private String mEncoding;
    private InputStream mInputStream;
    private String mMimeType;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private int mStatusCode;

    public WebResourceResponse(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        AppMethodBeat.m2504i(63820);
        setStatusCodeAndReasonPhrase(i, str3);
        setResponseHeaders(map);
        AppMethodBeat.m2505o(63820);
    }

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        AppMethodBeat.m2504i(63819);
        this.mMimeType = str;
        this.mEncoding = str2;
        setData(inputStream);
        AppMethodBeat.m2505o(63819);
    }

    public InputStream getData() {
        return this.mInputStream;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setData(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.mResponseHeaders = map;
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        this.mStatusCode = i;
        this.mReasonPhrase = str;
    }
}

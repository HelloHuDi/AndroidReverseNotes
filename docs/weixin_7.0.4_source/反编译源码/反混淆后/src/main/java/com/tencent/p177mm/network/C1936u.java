package com.tencent.p177mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.network.u */
public final class C1936u {
    private Map<String, List<String>> bqH = null;
    public HttpURLConnection connection;
    public int gcI;
    public String gdF;
    public URL url;

    public C1936u(URL url, int i) {
        AppMethodBeat.m2504i(58618);
        this.url = url;
        this.gcI = i;
        this.connection = (HttpURLConnection) this.url.openConnection();
        if (1 == this.gcI) {
            this.connection.setInstanceFollowRedirects(false);
        }
        AppMethodBeat.m2505o(58618);
    }

    public final int getResponseCode() {
        int responseCode;
        AppMethodBeat.m2504i(58619);
        while (true) {
            if (1 == this.gcI && this.bqH == null) {
                this.bqH = this.connection.getRequestProperties();
            }
            responseCode = this.connection.getResponseCode();
            if (1 == this.gcI && 302 == responseCode) {
                String headerField = this.connection.getHeaderField("Location");
                if (headerField == null) {
                    AppMethodBeat.m2505o(58619);
                    break;
                }
                this.url = new URL(this.url, headerField);
                this.connection = (HttpURLConnection) this.url.openConnection();
                this.connection.setInstanceFollowRedirects(false);
                if (this.bqH != null) {
                    for (String str : this.bqH.keySet()) {
                        if (!(str.equals("Host") || str.equals("X-Online-Host"))) {
                            List list = (List) this.bqH.get(str);
                            for (int i = 0; i < list.size(); i++) {
                                this.connection.setRequestProperty(str, (String) list.get(i));
                            }
                        }
                    }
                }
                this.connection.setRequestProperty("Host", this.url.getHost());
                this.connection.setRequestProperty("X-Online-Host", this.url.getHost());
            } else {
                AppMethodBeat.m2505o(58619);
            }
        }
        return responseCode;
    }

    public final void setRequestMethod(String str) {
        AppMethodBeat.m2504i(58620);
        this.connection.setRequestMethod(str);
        AppMethodBeat.m2505o(58620);
    }

    public final void connect() {
        AppMethodBeat.m2504i(58621);
        if (1 == this.gcI && this.bqH == null) {
            this.bqH = this.connection.getRequestProperties();
        }
        this.connection.connect();
        AppMethodBeat.m2505o(58621);
    }

    public final Map<String, List<String>> getHeaderFields() {
        AppMethodBeat.m2504i(58622);
        if (1 == this.gcI && this.bqH == null) {
            this.bqH = this.connection.getRequestProperties();
        }
        Map headerFields = this.connection.getHeaderFields();
        AppMethodBeat.m2505o(58622);
        return headerFields;
    }

    public final String getHeaderField(String str) {
        AppMethodBeat.m2504i(58623);
        if (1 == this.gcI && this.bqH == null) {
            this.bqH = this.connection.getRequestProperties();
        }
        String headerField = this.connection.getHeaderField(str);
        AppMethodBeat.m2505o(58623);
        return headerField;
    }

    public final int getHeaderFieldInt(String str, int i) {
        AppMethodBeat.m2504i(58624);
        if (1 == this.gcI && this.bqH == null) {
            this.bqH = this.connection.getRequestProperties();
        }
        int headerFieldInt = this.connection.getHeaderFieldInt(str, i);
        AppMethodBeat.m2505o(58624);
        return headerFieldInt;
    }

    public final InputStream getInputStream() {
        AppMethodBeat.m2504i(58625);
        if (1 == this.gcI) {
            if (this.bqH == null) {
                this.bqH = this.connection.getRequestProperties();
            }
            getResponseCode();
        }
        InputStream inputStream = this.connection.getInputStream();
        AppMethodBeat.m2505o(58625);
        return inputStream;
    }

    public final OutputStream getOutputStream() {
        AppMethodBeat.m2504i(58626);
        if (1 == this.gcI) {
            if (this.bqH == null) {
                this.bqH = this.connection.getRequestProperties();
            }
            getResponseCode();
        }
        OutputStream outputStream = this.connection.getOutputStream();
        AppMethodBeat.m2505o(58626);
        return outputStream;
    }

    public final void amX() {
        AppMethodBeat.m2504i(58627);
        this.connection.setDoInput(true);
        AppMethodBeat.m2505o(58627);
    }

    public final void amY() {
        AppMethodBeat.m2504i(58628);
        this.connection.setDoOutput(true);
        AppMethodBeat.m2505o(58628);
    }

    public final void setRequestProperty(String str, String str2) {
        AppMethodBeat.m2504i(58629);
        this.connection.setRequestProperty(str, str2);
        AppMethodBeat.m2505o(58629);
    }

    public final void setUseCaches(boolean z) {
        AppMethodBeat.m2504i(58630);
        this.connection.setUseCaches(z);
        AppMethodBeat.m2505o(58630);
    }

    public final void setConnectTimeout(int i) {
        AppMethodBeat.m2504i(58631);
        this.connection.setConnectTimeout(i);
        AppMethodBeat.m2505o(58631);
    }

    public final void setReadTimeout(int i) {
        AppMethodBeat.m2504i(58632);
        this.connection.setReadTimeout(i);
        AppMethodBeat.m2505o(58632);
    }

    /* renamed from: vc */
    public final void mo5661vc(String str) {
        AppMethodBeat.m2504i(58633);
        this.connection.setRequestProperty("Referer", str);
        AppMethodBeat.m2505o(58633);
    }

    public final String toString() {
        AppMethodBeat.m2504i(58634);
        String httpURLConnection = this.connection.toString();
        AppMethodBeat.m2505o(58634);
        return httpURLConnection;
    }
}

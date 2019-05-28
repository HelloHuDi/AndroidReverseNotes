package org.p1128b.p1132d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.p1128b.p1130b.C16472a;
import org.p1128b.p1130b.C36641b;
import org.p1128b.p1134g.C46862d;

/* renamed from: org.b.d.f */
class C36642f {
    private C41174j BYP;
    private C16475e BYQ;
    private C16475e BYR;
    private byte[] BYS = null;
    private boolean BYT = false;
    private Long BYU = null;
    private Long BYV = null;
    private String charset;
    private HttpURLConnection connection;
    private Map<String, String> headers;
    private String url;
    private String wyn = null;

    public C36642f(C41174j c41174j, String str) {
        AppMethodBeat.m2504i(77250);
        this.BYP = c41174j;
        this.url = str;
        this.BYQ = new C16475e();
        this.BYR = new C16475e();
        this.headers = new HashMap();
        AppMethodBeat.m2505o(77250);
    }

    public String ena() {
        AppMethodBeat.m2504i(77252);
        C16475e c16475e = this.BYQ;
        String str = this.url;
        C46862d.m89100r(str, "Cannot append to null URL");
        String enh = c16475e.enh();
        if (enh.equals("")) {
            AppMethodBeat.m2505o(77252);
            return str;
        }
        str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(str.indexOf(63) != -1 ? "&" : Character.valueOf('?')).toString())).append(enh).toString();
        AppMethodBeat.m2505o(77252);
        return str;
    }

    /* renamed from: h */
    private void m60741h(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(77253);
        for (String str : this.headers.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.headers.get(str));
        }
        AppMethodBeat.m2505o(77253);
    }

    public void addHeader(String str, String str2) {
        AppMethodBeat.m2504i(77254);
        this.headers.put(str, str2);
        AppMethodBeat.m2505o(77254);
    }

    /* renamed from: jm */
    public void mo41406jm(String str, String str2) {
        AppMethodBeat.m2504i(77255);
        this.BYQ.BYO.add(new C31206d(str, str2));
        AppMethodBeat.m2505o(77255);
    }

    public C16475e emY() {
        AppMethodBeat.m2504i(77256);
        try {
            C16475e c16475e = new C16475e();
            c16475e.awV(new URL(this.url).getQuery());
            c16475e.mo30363a(this.BYQ);
            AppMethodBeat.m2505o(77256);
            return c16475e;
        } catch (MalformedURLException e) {
            C36641b c36641b = new C36641b("Malformed URL", e);
            AppMethodBeat.m2505o(77256);
            throw c36641b;
        }
    }

    public C16475e ene() {
        return this.BYR;
    }

    public String getUrl() {
        return this.url;
    }

    public String enf() {
        AppMethodBeat.m2504i(77257);
        String replace = this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
        AppMethodBeat.m2505o(77257);
        return replace;
    }

    private byte[] eni() {
        AppMethodBeat.m2504i(77258);
        byte[] bArr;
        if (this.BYS != null) {
            bArr = this.BYS;
            AppMethodBeat.m2505o(77258);
            return bArr;
        }
        try {
            bArr = (this.wyn != null ? this.wyn : this.BYR.enh()).getBytes(enb());
            AppMethodBeat.m2505o(77258);
            return bArr;
        } catch (UnsupportedEncodingException e) {
            C36641b c36641b = new C36641b("Unsupported Charset: " + enb(), e);
            AppMethodBeat.m2505o(77258);
            throw c36641b;
        }
    }

    public C41174j emZ() {
        return this.BYP;
    }

    public String enb() {
        AppMethodBeat.m2504i(77259);
        String name;
        if (this.charset == null) {
            name = Charset.defaultCharset().name();
            AppMethodBeat.m2505o(77259);
            return name;
        }
        name = this.charset;
        AppMethodBeat.m2505o(77259);
        return name;
    }

    public String toString() {
        AppMethodBeat.m2504i(77260);
        String format = String.format("@Request(%s %s)", new Object[]{emZ(), getUrl()});
        AppMethodBeat.m2505o(77260);
        return format;
    }

    public C41172g enc() {
        AppMethodBeat.m2504i(77251);
        try {
            String ena = ena();
            if (this.connection == null) {
                System.setProperty("http.keepAlive", this.BYT ? "true" : "false");
                this.connection = (HttpURLConnection) new URL(ena).openConnection();
            }
            this.connection.setRequestMethod(this.BYP.name());
            if (this.BYU != null) {
                this.connection.setConnectTimeout(this.BYU.intValue());
            }
            if (this.BYV != null) {
                this.connection.setReadTimeout(this.BYV.intValue());
            }
            m60741h(this.connection);
            if (this.BYP.equals(C41174j.PUT) || this.BYP.equals(C41174j.POST)) {
                HttpURLConnection httpURLConnection = this.connection;
                byte[] eni = eni();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(eni.length));
                if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(eni);
            }
            C41172g c41172g = new C41172g(this.connection);
            AppMethodBeat.m2505o(77251);
            return c41172g;
        } catch (Exception e) {
            C16472a c16472a = new C16472a(e);
            AppMethodBeat.m2505o(77251);
            throw c16472a;
        }
    }
}

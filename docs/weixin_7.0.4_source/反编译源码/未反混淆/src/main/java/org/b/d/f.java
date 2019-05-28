package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.b.b.a;
import org.b.b.b;
import org.b.g.d;

class f {
    private j BYP;
    private e BYQ;
    private e BYR;
    private byte[] BYS = null;
    private boolean BYT = false;
    private Long BYU = null;
    private Long BYV = null;
    private String charset;
    private HttpURLConnection connection;
    private Map<String, String> headers;
    private String url;
    private String wyn = null;

    public f(j jVar, String str) {
        AppMethodBeat.i(77250);
        this.BYP = jVar;
        this.url = str;
        this.BYQ = new e();
        this.BYR = new e();
        this.headers = new HashMap();
        AppMethodBeat.o(77250);
    }

    public String ena() {
        AppMethodBeat.i(77252);
        e eVar = this.BYQ;
        String str = this.url;
        d.r(str, "Cannot append to null URL");
        String enh = eVar.enh();
        if (enh.equals("")) {
            AppMethodBeat.o(77252);
            return str;
        }
        str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(str.indexOf(63) != -1 ? "&" : Character.valueOf('?')).toString())).append(enh).toString();
        AppMethodBeat.o(77252);
        return str;
    }

    private void h(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(77253);
        for (String str : this.headers.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.headers.get(str));
        }
        AppMethodBeat.o(77253);
    }

    public void addHeader(String str, String str2) {
        AppMethodBeat.i(77254);
        this.headers.put(str, str2);
        AppMethodBeat.o(77254);
    }

    public void jm(String str, String str2) {
        AppMethodBeat.i(77255);
        this.BYQ.BYO.add(new d(str, str2));
        AppMethodBeat.o(77255);
    }

    public e emY() {
        AppMethodBeat.i(77256);
        try {
            e eVar = new e();
            eVar.awV(new URL(this.url).getQuery());
            eVar.a(this.BYQ);
            AppMethodBeat.o(77256);
            return eVar;
        } catch (MalformedURLException e) {
            b bVar = new b("Malformed URL", e);
            AppMethodBeat.o(77256);
            throw bVar;
        }
    }

    public e ene() {
        return this.BYR;
    }

    public String getUrl() {
        return this.url;
    }

    public String enf() {
        AppMethodBeat.i(77257);
        String replace = this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
        AppMethodBeat.o(77257);
        return replace;
    }

    private byte[] eni() {
        AppMethodBeat.i(77258);
        byte[] bArr;
        if (this.BYS != null) {
            bArr = this.BYS;
            AppMethodBeat.o(77258);
            return bArr;
        }
        try {
            bArr = (this.wyn != null ? this.wyn : this.BYR.enh()).getBytes(enb());
            AppMethodBeat.o(77258);
            return bArr;
        } catch (UnsupportedEncodingException e) {
            b bVar = new b("Unsupported Charset: " + enb(), e);
            AppMethodBeat.o(77258);
            throw bVar;
        }
    }

    public j emZ() {
        return this.BYP;
    }

    public String enb() {
        AppMethodBeat.i(77259);
        String name;
        if (this.charset == null) {
            name = Charset.defaultCharset().name();
            AppMethodBeat.o(77259);
            return name;
        }
        name = this.charset;
        AppMethodBeat.o(77259);
        return name;
    }

    public String toString() {
        AppMethodBeat.i(77260);
        String format = String.format("@Request(%s %s)", new Object[]{emZ(), getUrl()});
        AppMethodBeat.o(77260);
        return format;
    }

    public g enc() {
        AppMethodBeat.i(77251);
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
            h(this.connection);
            if (this.BYP.equals(j.PUT) || this.BYP.equals(j.POST)) {
                HttpURLConnection httpURLConnection = this.connection;
                byte[] eni = eni();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(eni.length));
                if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(eni);
            }
            g gVar = new g(this.connection);
            AppMethodBeat.o(77251);
            return gVar;
        } catch (Exception e) {
            a aVar = new a(e);
            AppMethodBeat.o(77251);
            throw aVar;
        }
    }
}

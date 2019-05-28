package com.bumptech.glide.p086c.p087a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31966e;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p090c.C31950g;
import com.bumptech.glide.p095h.C31975e;
import com.bumptech.glide.p095h.C45001c;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.c.a.j */
public final class C44980j implements C0742d<InputStream> {
    static final C25403b azq = new C17515a();
    private final C31950g azr;
    private final int azs;
    private final C25403b azt;
    private HttpURLConnection azu;
    private InputStream azv;
    private volatile boolean isCancelled;

    /* renamed from: com.bumptech.glide.c.a.j$a */
    static class C17515a implements C25403b {
        C17515a() {
        }

        /* renamed from: b */
        public final HttpURLConnection mo31944b(URL url) {
            AppMethodBeat.m2504i(91720);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            AppMethodBeat.m2505o(91720);
            return httpURLConnection;
        }
    }

    /* renamed from: com.bumptech.glide.c.a.j$b */
    interface C25403b {
        /* renamed from: b */
        HttpURLConnection mo31944b(URL url);
    }

    static {
        AppMethodBeat.m2504i(91724);
        AppMethodBeat.m2505o(91724);
    }

    public C44980j(C31950g c31950g, int i) {
        this(c31950g, i, azq);
    }

    private C44980j(C31950g c31950g, int i, C25403b c25403b) {
        this.azr = c31950g;
        this.azs = i;
        this.azt = c25403b;
    }

    /* renamed from: a */
    public final void mo2184a(C37192g c37192g, C0743a<? super InputStream> c0743a) {
        AppMethodBeat.m2504i(91721);
        long ok = C31975e.m51954ok();
        try {
            C31950g c31950g = this.azr;
            if (c31950g.aEc == null) {
                if (TextUtils.isEmpty(c31950g.aEb)) {
                    String str = c31950g.aEa;
                    if (TextUtils.isEmpty(str)) {
                        str = ((URL) C8561i.m15217d(c31950g.url, "Argument must not be null")).toString();
                    }
                    c31950g.aEb = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
                }
                c31950g.aEc = new URL(c31950g.aEb);
            }
            c0743a.mo2189S(m82362a(c31950g.aEc, 0, null, this.azr.aDZ.getHeaders()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(C31975e.m51955q(ok));
                AppMethodBeat.m2505o(91721);
                return;
            }
        } catch (IOException e) {
            Log.isLoggable("HttpUrlFetcher", 3);
            c0743a.mo2190b(e);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(C31975e.m51955q(ok));
                AppMethodBeat.m2505o(91721);
                return;
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(C31975e.m51955q(ok));
            }
            AppMethodBeat.m2505o(91721);
        }
        AppMethodBeat.m2505o(91721);
    }

    /* renamed from: a */
    private InputStream m82362a(URL url, int i, URL url2, Map<String, String> map) {
        AppMethodBeat.m2504i(91722);
        while (true) {
            URL url3 = url;
            C31966e c31966e;
            if (i >= 5) {
                c31966e = new C31966e("Too many (> 5) redirects!");
                AppMethodBeat.m2505o(91722);
                throw c31966e;
            }
            if (url2 != null) {
                try {
                    if (url3.toURI().equals(url2.toURI())) {
                        c31966e = new C31966e("In re-direct loop");
                        AppMethodBeat.m2505o(91722);
                        throw c31966e;
                    }
                } catch (URISyntaxException e) {
                }
            }
            this.azu = this.azt.mo31944b(url3);
            for (Entry entry : map.entrySet()) {
                this.azu.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            this.azu.setConnectTimeout(this.azs);
            this.azu.setReadTimeout(this.azs);
            this.azu.setUseCaches(false);
            this.azu.setDoInput(true);
            this.azu.setInstanceFollowRedirects(false);
            this.azu.connect();
            this.azv = this.azu.getInputStream();
            if (this.isCancelled) {
                AppMethodBeat.m2505o(91722);
                return null;
            }
            boolean z;
            int responseCode = this.azu.getResponseCode();
            if (responseCode / 100 == 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                HttpURLConnection httpURLConnection = this.azu;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.azv = C45001c.m82413b(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        new StringBuilder("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
                    }
                    this.azv = httpURLConnection.getInputStream();
                }
                InputStream inputStream = this.azv;
                AppMethodBeat.m2505o(91722);
                return inputStream;
            }
            if (responseCode / 100 == 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String headerField = this.azu.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    c31966e = new C31966e("Received empty or null redirect url");
                    AppMethodBeat.m2505o(91722);
                    throw c31966e;
                }
                url = new URL(url3, headerField);
                cleanup();
                i++;
                url2 = url3;
            } else if (responseCode == -1) {
                c31966e = new C31966e(responseCode);
                AppMethodBeat.m2505o(91722);
                throw c31966e;
            } else {
                c31966e = new C31966e(this.azu.getResponseMessage(), responseCode);
                AppMethodBeat.m2505o(91722);
                throw c31966e;
            }
        }
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(91723);
        if (this.azv != null) {
            try {
                this.azv.close();
            } catch (IOException e) {
            }
        }
        if (this.azu != null) {
            this.azu.disconnect();
        }
        this.azu = null;
        AppMethodBeat.m2505o(91723);
    }

    public final void cancel() {
        this.isCancelled = true;
    }

    /* renamed from: mg */
    public final Class<InputStream> mo2187mg() {
        return InputStream.class;
    }

    /* renamed from: mh */
    public final C25405a mo2188mh() {
        return C25405a.REMOTE;
    }
}

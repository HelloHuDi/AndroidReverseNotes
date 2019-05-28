package com.bumptech.glide.c.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.c.c.g;
import com.bumptech.glide.h.c;
import com.bumptech.glide.h.e;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public final class j implements d<InputStream> {
    static final b azq = new a();
    private final g azr;
    private final int azs;
    private final b azt;
    private HttpURLConnection azu;
    private InputStream azv;
    private volatile boolean isCancelled;

    static class a implements b {
        a() {
        }

        public final HttpURLConnection b(URL url) {
            AppMethodBeat.i(91720);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            AppMethodBeat.o(91720);
            return httpURLConnection;
        }
    }

    interface b {
        HttpURLConnection b(URL url);
    }

    static {
        AppMethodBeat.i(91724);
        AppMethodBeat.o(91724);
    }

    public j(g gVar, int i) {
        this(gVar, i, azq);
    }

    private j(g gVar, int i, b bVar) {
        this.azr = gVar;
        this.azs = i;
        this.azt = bVar;
    }

    public final void a(com.bumptech.glide.g gVar, com.bumptech.glide.c.a.d.a<? super InputStream> aVar) {
        AppMethodBeat.i(91721);
        long ok = e.ok();
        try {
            g gVar2 = this.azr;
            if (gVar2.aEc == null) {
                if (TextUtils.isEmpty(gVar2.aEb)) {
                    String str = gVar2.aEa;
                    if (TextUtils.isEmpty(str)) {
                        str = ((URL) i.d(gVar2.url, "Argument must not be null")).toString();
                    }
                    gVar2.aEb = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
                }
                gVar2.aEc = new URL(gVar2.aEb);
            }
            aVar.S(a(gVar2.aEc, 0, null, this.azr.aDZ.getHeaders()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(e.q(ok));
                AppMethodBeat.o(91721);
                return;
            }
        } catch (IOException e) {
            Log.isLoggable("HttpUrlFetcher", 3);
            aVar.b(e);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(e.q(ok));
                AppMethodBeat.o(91721);
                return;
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(e.q(ok));
            }
            AppMethodBeat.o(91721);
        }
        AppMethodBeat.o(91721);
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) {
        AppMethodBeat.i(91722);
        while (true) {
            URL url3 = url;
            com.bumptech.glide.c.e eVar;
            if (i >= 5) {
                eVar = new com.bumptech.glide.c.e("Too many (> 5) redirects!");
                AppMethodBeat.o(91722);
                throw eVar;
            }
            if (url2 != null) {
                try {
                    if (url3.toURI().equals(url2.toURI())) {
                        eVar = new com.bumptech.glide.c.e("In re-direct loop");
                        AppMethodBeat.o(91722);
                        throw eVar;
                    }
                } catch (URISyntaxException e) {
                }
            }
            this.azu = this.azt.b(url3);
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
                AppMethodBeat.o(91722);
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
                    this.azv = c.b(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        new StringBuilder("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
                    }
                    this.azv = httpURLConnection.getInputStream();
                }
                InputStream inputStream = this.azv;
                AppMethodBeat.o(91722);
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
                    eVar = new com.bumptech.glide.c.e("Received empty or null redirect url");
                    AppMethodBeat.o(91722);
                    throw eVar;
                }
                url = new URL(url3, headerField);
                cleanup();
                i++;
                url2 = url3;
            } else if (responseCode == -1) {
                eVar = new com.bumptech.glide.c.e(responseCode);
                AppMethodBeat.o(91722);
                throw eVar;
            } else {
                eVar = new com.bumptech.glide.c.e(this.azu.getResponseMessage(), responseCode);
                AppMethodBeat.o(91722);
                throw eVar;
            }
        }
    }

    public final void cleanup() {
        AppMethodBeat.i(91723);
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
        AppMethodBeat.o(91723);
    }

    public final void cancel() {
        this.isCancelled = true;
    }

    public final Class<InputStream> mg() {
        return InputStream.class;
    }

    public final com.bumptech.glide.c.a mh() {
        return com.bumptech.glide.c.a.REMOTE;
    }
}

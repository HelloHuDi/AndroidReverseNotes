package com.tencent.mm.loader.e;

import com.tencent.mm.hardcoder.i;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.b.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b extends com.tencent.mm.loader.d.b<String> {
    public final void a(a<String> aVar, f fVar, com.tencent.mm.loader.d.b.b bVar) {
        ab.d("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data from url:%s", aVar);
        try {
            com.tencent.mm.loader.h.f fVar2;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL((String) aVar.value()).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
            if (httpURLConnection == null) {
                ab.i("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                ab.w("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                fVar2 = null;
            } else {
                InputStream inputStream = httpURLConnection.getInputStream();
                String contentType = httpURLConnection.getContentType();
                byte[] a = d.a(inputStream, false);
                httpURLConnection.disconnect();
                fVar2 = new com.tencent.mm.loader.h.b(a, contentType, new AnonymousClass1(a));
            }
            bVar.a(fVar2);
        } catch (InterruptedException e) {
            ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e));
            bVar.onError();
        } catch (UnknownHostException e2) {
            ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e2));
            bVar.onError();
        } catch (SSLHandshakeException e3) {
            ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e3));
            bVar.onError();
        } catch (SocketException e4) {
            ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e4));
            bVar.onError();
        } catch (SocketTimeoutException e5) {
            ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e5));
            bVar.onError();
        } catch (IOException e6) {
            ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e6));
            bVar.onError();
        } catch (Exception e7) {
            ab.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e7));
            bVar.onError();
        }
    }
}

package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
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

public final class b implements com.tencent.mm.at.a.c.b {
    public final com.tencent.mm.at.a.d.b sE(String str) {
        AppMethodBeat.i(116082);
        ab.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", str);
        com.tencent.mm.at.a.d.b bVar;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
            if (httpURLConnection == null) {
                ab.i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                ab.w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                AppMethodBeat.o(116082);
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentType = httpURLConnection.getContentType();
            byte[] y = e.y(inputStream);
            httpURLConnection.disconnect();
            bVar = new com.tencent.mm.at.a.d.b(y, contentType);
            AppMethodBeat.o(116082);
            return bVar;
        } catch (InterruptedException e) {
            ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e));
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(116082);
            return bVar;
        } catch (UnknownHostException e2) {
            ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e2));
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(116082);
            return bVar;
        } catch (SSLHandshakeException e3) {
            ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e3));
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(116082);
            return bVar;
        } catch (SocketException e4) {
            ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e4));
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(116082);
            return bVar;
        } catch (SocketTimeoutException e5) {
            ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e5));
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(116082);
            return bVar;
        } catch (IOException e6) {
            ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e6));
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(116082);
            return bVar;
        } catch (Exception e7) {
            ab.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", bo.l(e7));
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(116082);
            return bVar;
        }
    }
}

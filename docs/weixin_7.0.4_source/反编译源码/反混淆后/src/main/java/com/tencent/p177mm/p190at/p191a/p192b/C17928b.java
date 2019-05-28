package com.tencent.p177mm.p190at.p191a.p192b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

/* renamed from: com.tencent.mm.at.a.b.b */
public final class C17928b implements C37474b {
    /* renamed from: sE */
    public final C37477b mo33454sE(String str) {
        AppMethodBeat.m2504i(116082);
        C4990ab.m7411d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", str);
        C37477b c37477b;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
            if (httpURLConnection == null) {
                C4990ab.m7416i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                C4990ab.m7420w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                AppMethodBeat.m2505o(116082);
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentType = httpURLConnection.getContentType();
            byte[] y = C36693e.m60878y(inputStream);
            httpURLConnection.disconnect();
            c37477b = new C37477b(y, contentType);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        } catch (InterruptedException e) {
            C4990ab.m7413e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        } catch (UnknownHostException e2) {
            C4990ab.m7413e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e2));
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        } catch (SSLHandshakeException e3) {
            C4990ab.m7413e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e3));
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        } catch (SocketException e4) {
            C4990ab.m7413e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e4));
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        } catch (SocketTimeoutException e5) {
            C4990ab.m7413e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e5));
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        } catch (IOException e6) {
            C4990ab.m7413e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e6));
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        } catch (Exception e7) {
            C4990ab.m7413e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e7));
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(116082);
            return c37477b;
        }
    }
}

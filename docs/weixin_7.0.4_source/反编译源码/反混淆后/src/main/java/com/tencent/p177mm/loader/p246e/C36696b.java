package com.tencent.p177mm.loader.p246e;

import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.loader.p1197h.C18552b;
import com.tencent.p177mm.loader.p1197h.C18552b.C185531;
import com.tencent.p177mm.loader.p1197h.C42162f;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p245d.C32725b;
import com.tencent.p177mm.loader.p245d.C32725b.C18531b;
import com.tencent.p177mm.loader.p863f.C32733f;
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

/* renamed from: com.tencent.mm.loader.e.b */
public final class C36696b extends C32725b<String> {
    /* renamed from: a */
    public final void mo37770a(C42156a<String> c42156a, C32733f c32733f, C18531b c18531b) {
        C4990ab.m7411d("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data from url:%s", c42156a);
        try {
            C42162f c42162f;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL((String) c42156a.value()).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
            if (httpURLConnection == null) {
                C4990ab.m7416i("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                C4990ab.m7420w("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                c42162f = null;
            } else {
                InputStream inputStream = httpURLConnection.getInputStream();
                String contentType = httpURLConnection.getContentType();
                byte[] a = C9571d.m17056a(inputStream, false);
                httpURLConnection.disconnect();
                c42162f = new C18552b(a, contentType, new C185531(a));
            }
            c18531b.mo33782a(c42162f);
        } catch (InterruptedException e) {
            C4990ab.m7413e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
            c18531b.onError();
        } catch (UnknownHostException e2) {
            C4990ab.m7413e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e2));
            c18531b.onError();
        } catch (SSLHandshakeException e3) {
            C4990ab.m7413e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e3));
            c18531b.onError();
        } catch (SocketException e4) {
            C4990ab.m7413e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e4));
            c18531b.onError();
        } catch (SocketTimeoutException e5) {
            C4990ab.m7413e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e5));
            c18531b.onError();
        } catch (IOException e6) {
            C4990ab.m7413e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e6));
            c18531b.onError();
        } catch (Exception e7) {
            C4990ab.m7413e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", C5046bo.m7574l(e7));
            c18531b.onError();
        }
    }
}

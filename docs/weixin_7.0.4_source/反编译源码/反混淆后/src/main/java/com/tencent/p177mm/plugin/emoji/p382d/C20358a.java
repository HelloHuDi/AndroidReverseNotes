package com.tencent.p177mm.plugin.emoji.p382d;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1897b.C1896b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p192b.C36693e;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

/* renamed from: com.tencent.mm.plugin.emoji.d.a */
public final class C20358a implements C37474b {

    /* renamed from: com.tencent.mm.plugin.emoji.d.a$a */
    static class C2931a {
        /* renamed from: b */
        private static C1936u m5214b(String str, C1896b c1896b) {
            AppMethodBeat.m2504i(62334);
            C1936u a = C1897b.m4020a(str, c1896b);
            String str2 = "";
            if (C4996ah.bqo() && C1720g.m3531RK()) {
                r2 = new Object[4];
                C1720g.m3534RN();
                r2[1] = C1183p.getString(C1668a.m3383QF());
                r2[2] = Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext()));
                r2[3] = Integer.valueOf(C5023at.getStrength(C4996ah.getContext()));
                str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r2);
            }
            C4990ab.m7411d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", str2);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str2);
            a.setConnectTimeout(15000);
            a.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
            AppMethodBeat.m2505o(62334);
            return a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        public static C37477b m5215c(String str, C1896b c1896b) {
            Throwable e;
            AppMethodBeat.m2504i(62335);
            C1936u b = C2931a.m5214b(str, c1896b);
            if (b == null) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
            }
            if (b.getResponseCode() == 302) {
                try {
                    C4990ab.m7417i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", str);
                    String headerField = b.getHeaderField(C8741b.LOCATION);
                    if (!C5046bo.isNullOrNil(headerField)) {
                        C1896b c1896b2 = new C1896b(headerField);
                        try {
                            b.connection.disconnect();
                            b = C2931a.m5214b(headerField, c1896b2);
                            c1896b = c1896b2;
                        } catch (Exception e2) {
                            e = e2;
                            c1896b = c1896b2;
                            C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                            if (C1897b.m4017a(b) != 0) {
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                    if (C1897b.m4017a(b) != 0) {
                    }
                }
            }
            if (C1897b.m4017a(b) != 0) {
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, c1896b.f1239ip, c1896b.f1239ip, Integer.valueOf(c1896b.gcI), Integer.valueOf(b.getResponseCode()));
                switch (b.getResponseCode()) {
                    case 404:
                        C7060h.pYm.mo8378a(315, 8, 1, false);
                        break;
                    case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                        C7060h.pYm.mo8378a(315, 9, 1, false);
                        break;
                    case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                        C7060h.pYm.mo8378a(315, 10, 1, false);
                        break;
                    case 504:
                        C7060h.pYm.mo8378a(315, 11, 1, false);
                        break;
                    default:
                        C7060h.pYm.mo8378a(315, 12, 1, false);
                        break;
                }
                int i = c1896b.gcI;
                String str2 = c1896b.f1239ip;
                if (i == 1 && C5023at.isConnected(C4996ah.getContext())) {
                    C1897b.reportFailIp(str2);
                }
                AppMethodBeat.m2505o(62335);
                return null;
            }
            InputStream inputStream = b.getInputStream();
            if (inputStream == null) {
                C4990ab.m7411d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
                AppMethodBeat.m2505o(62335);
                return null;
            }
            String contentType = b.connection.getContentType();
            byte[] a = C36693e.m60877a(inputStream, false);
            b.connection.disconnect();
            C37477b c37477b = new C37477b(a, contentType);
            AppMethodBeat.m2505o(62335);
            return c37477b;
        }
    }

    /* renamed from: sE */
    public final C37477b mo33454sE(String str) {
        String str2;
        int i;
        Throwable e;
        int i2;
        String str3;
        C37477b c37477b;
        AppMethodBeat.m2504i(62336);
        String str4 = "";
        String str5 = "";
        try {
            C1896b c1896b = new C1896b(str);
            if (!C5046bo.isNullOrNil(c1896b.f1239ip)) {
                str4 = c1896b.f1239ip;
            }
            str2 = c1896b.f1239ip;
            try {
                i = c1896b.gcI;
            } catch (ProtocolException e2) {
                e = e2;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 7, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (InterruptedException e3) {
                e = e3;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 0, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (UnknownHostException e4) {
                e = e4;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 1, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (SSLHandshakeException e5) {
                e = e5;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 2, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (SocketException e6) {
                e = e6;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 3, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (SocketTimeoutException e7) {
                e = e7;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 4, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (IOException e8) {
                e = e8;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 5, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (Exception e9) {
                e = e9;
                i2 = 0;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 6, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            }
            try {
                c37477b = C2931a.m5215c(str, c1896b);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (ProtocolException e10) {
                e = e10;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 7, 1, false);
                if (i2 == 1 && C5023at.isConnected(C4996ah.getContext())) {
                    C1897b.reportFailIp(str3);
                }
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (InterruptedException e11) {
                e = e11;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 0, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (UnknownHostException e12) {
                e = e12;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 1, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (SSLHandshakeException e13) {
                e = e13;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 2, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (SocketException e14) {
                e = e14;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 3, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (SocketTimeoutException e15) {
                e = e15;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 4, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (IOException e16) {
                e = e16;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 5, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            } catch (Exception e17) {
                e = e17;
                i2 = i;
                str3 = str4;
                C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
                C7060h.pYm.mo8378a(315, 6, 1, false);
                C1897b.reportFailIp(str3);
                c37477b = new C37477b(null, null);
                AppMethodBeat.m2505o(62336);
                return c37477b;
            }
        } catch (ProtocolException e18) {
            e = e18;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 7, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        } catch (InterruptedException e19) {
            e = e19;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 0, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        } catch (UnknownHostException e20) {
            e = e20;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 1, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        } catch (SSLHandshakeException e21) {
            e = e21;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 2, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        } catch (SocketException e22) {
            e = e22;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 3, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        } catch (SocketTimeoutException e23) {
            e = e23;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 4, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        } catch (IOException e24) {
            e = e24;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 5, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        } catch (Exception e25) {
            e = e25;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            C4990ab.m7413e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), C5046bo.m7574l(e));
            C7060h.pYm.mo8378a(315, 6, 1, false);
            C1897b.reportFailIp(str3);
            c37477b = new C37477b(null, null);
            AppMethodBeat.m2505o(62336);
            return c37477b;
        }
    }
}

package com.tencent.mm.plugin.emoji.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.at.a.b.e;
import com.tencent.mm.at.a.c.b;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class a implements b {

    static class a {
        private static u b(String str, com.tencent.mm.network.b.b bVar) {
            AppMethodBeat.i(62334);
            u a = com.tencent.mm.network.b.a(str, bVar);
            String str2 = "";
            if (ah.bqo() && g.RK()) {
                r2 = new Object[4];
                g.RN();
                r2[1] = p.getString(com.tencent.mm.kernel.a.QF());
                r2[2] = Integer.valueOf(at.getNetTypeForStat(ah.getContext()));
                r2[3] = Integer.valueOf(at.getStrength(ah.getContext()));
                str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r2);
            }
            ab.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", str2);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str2);
            a.setConnectTimeout(15000);
            a.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
            AppMethodBeat.o(62334);
            return a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.at.a.d.b c(String str, com.tencent.mm.network.b.b bVar) {
            Throwable e;
            AppMethodBeat.i(62335);
            u b = b(str, bVar);
            if (b == null) {
                ab.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
            }
            if (b.getResponseCode() == 302) {
                try {
                    ab.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", str);
                    String headerField = b.getHeaderField(FirebaseAnalytics.b.LOCATION);
                    if (!bo.isNullOrNil(headerField)) {
                        com.tencent.mm.network.b.b bVar2 = new com.tencent.mm.network.b.b(headerField);
                        try {
                            b.connection.disconnect();
                            b = b(headerField, bVar2);
                            bVar = bVar2;
                        } catch (Exception e2) {
                            e = e2;
                            bVar = bVar2;
                            ab.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                            if (com.tencent.mm.network.b.a(b) != 0) {
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                    if (com.tencent.mm.network.b.a(b) != 0) {
                    }
                }
            }
            if (com.tencent.mm.network.b.a(b) != 0) {
                ab.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, bVar.ip, bVar.ip, Integer.valueOf(bVar.gcI), Integer.valueOf(b.getResponseCode()));
                switch (b.getResponseCode()) {
                    case 404:
                        h.pYm.a(315, 8, 1, false);
                        break;
                    case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                        h.pYm.a(315, 9, 1, false);
                        break;
                    case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                        h.pYm.a(315, 10, 1, false);
                        break;
                    case 504:
                        h.pYm.a(315, 11, 1, false);
                        break;
                    default:
                        h.pYm.a(315, 12, 1, false);
                        break;
                }
                int i = bVar.gcI;
                String str2 = bVar.ip;
                if (i == 1 && at.isConnected(ah.getContext())) {
                    com.tencent.mm.network.b.reportFailIp(str2);
                }
                AppMethodBeat.o(62335);
                return null;
            }
            InputStream inputStream = b.getInputStream();
            if (inputStream == null) {
                ab.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
                AppMethodBeat.o(62335);
                return null;
            }
            String contentType = b.connection.getContentType();
            byte[] a = e.a(inputStream, false);
            b.connection.disconnect();
            com.tencent.mm.at.a.d.b bVar3 = new com.tencent.mm.at.a.d.b(a, contentType);
            AppMethodBeat.o(62335);
            return bVar3;
        }
    }

    public final com.tencent.mm.at.a.d.b sE(String str) {
        String str2;
        int i;
        Throwable e;
        int i2;
        String str3;
        com.tencent.mm.at.a.d.b bVar;
        AppMethodBeat.i(62336);
        String str4 = "";
        String str5 = "";
        try {
            com.tencent.mm.network.b.b bVar2 = new com.tencent.mm.network.b.b(str);
            if (!bo.isNullOrNil(bVar2.ip)) {
                str4 = bVar2.ip;
            }
            str2 = bVar2.ip;
            try {
                i = bVar2.gcI;
            } catch (ProtocolException e2) {
                e = e2;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 7, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (InterruptedException e3) {
                e = e3;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 0, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (UnknownHostException e4) {
                e = e4;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 1, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (SSLHandshakeException e5) {
                e = e5;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 2, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (SocketException e6) {
                e = e6;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 3, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (SocketTimeoutException e7) {
                e = e7;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 4, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (IOException e8) {
                e = e8;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 5, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (Exception e9) {
                e = e9;
                i2 = 0;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 6, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            }
            try {
                bVar = a.c(str, bVar2);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (ProtocolException e10) {
                e = e10;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 7, 1, false);
                if (i2 == 1 && at.isConnected(ah.getContext())) {
                    com.tencent.mm.network.b.reportFailIp(str3);
                }
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (InterruptedException e11) {
                e = e11;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 0, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (UnknownHostException e12) {
                e = e12;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 1, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (SSLHandshakeException e13) {
                e = e13;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 2, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (SocketException e14) {
                e = e14;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 3, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (SocketTimeoutException e15) {
                e = e15;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 4, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (IOException e16) {
                e = e16;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 5, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            } catch (Exception e17) {
                e = e17;
                i2 = i;
                str3 = str4;
                ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
                h.pYm.a(315, 6, 1, false);
                com.tencent.mm.network.b.reportFailIp(str3);
                bVar = new com.tencent.mm.at.a.d.b(null, null);
                AppMethodBeat.o(62336);
                return bVar;
            }
        } catch (ProtocolException e18) {
            e = e18;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 7, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        } catch (InterruptedException e19) {
            e = e19;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 0, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        } catch (UnknownHostException e20) {
            e = e20;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 1, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        } catch (SSLHandshakeException e21) {
            e = e21;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 2, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        } catch (SocketException e22) {
            e = e22;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 3, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        } catch (SocketTimeoutException e23) {
            e = e23;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 4, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        } catch (IOException e24) {
            e = e24;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 5, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        } catch (Exception e25) {
            e = e25;
            i2 = 0;
            str2 = str5;
            str3 = str4;
            ab.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str3, str2, Integer.valueOf(i2), bo.l(e));
            h.pYm.a(315, 6, 1, false);
            com.tencent.mm.network.b.reportFailIp(str3);
            bVar = new com.tencent.mm.at.a.d.b(null, null);
            AppMethodBeat.o(62336);
            return bVar;
        }
    }
}

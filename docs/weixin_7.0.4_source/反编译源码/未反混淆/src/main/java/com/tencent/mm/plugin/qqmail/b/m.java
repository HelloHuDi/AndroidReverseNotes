package com.tencent.mm.plugin.qqmail.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.qqmail.b.n.a;
import com.tencent.mm.plugin.qqmail.b.n.b;
import com.tencent.mm.plugin.qqmail.b.n.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public final class m extends n {
    private boolean isCancelled = false;
    private HttpClient ptV = null;
    private HttpRequestBase ptW = null;
    private HttpResponse ptZ = null;
    private int result = 0;

    public final c a(String str, String str2, b bVar, a aVar) {
        AppMethodBeat.i(67955);
        ab.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + bVar);
        c cVar;
        try {
            String value;
            Object obj;
            InputStream inputStream;
            OutputStream fileOutputStream;
            int read;
            this.isCancelled = false;
            this.ptV = new DefaultHttpClient();
            if (bVar.pub == 0) {
                this.ptW = new HttpGet(n.f(str, str2, bVar.pub == 0 ? bVar.puc : null));
            } else {
                Map map;
                if (bVar.pub == 0) {
                    map = bVar.puc;
                } else {
                    map = null;
                }
                this.ptW = new HttpPost(n.f(str, str2, map));
            }
            this.ptW.addHeader("User-Agent", userAgent);
            this.ptW.addHeader("Host", host);
            System.setProperty("http.keepAlive", "false");
            this.ptW.addHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.ptW.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            this.ptW.addHeader("Content-Type", "text/html");
            this.ptW.addHeader("Cookie", n.W(bVar.pud));
            if (bVar.pub == 1) {
                a(bVar, this.ptW);
            }
            this.ptZ = this.ptV.execute(this.ptW);
            this.result = this.ptZ.getStatusLine().getStatusCode();
            String str3 = null;
            String str4 = null;
            CharSequence charSequence = null;
            if (this.ptZ.getFirstHeader("set-cookie") != null) {
                value = this.ptZ.getFirstHeader("set-cookie").getValue();
            } else {
                value = null;
            }
            if (this.ptZ.getFirstHeader("Content-Encoding") != null) {
                str3 = this.ptZ.getFirstHeader("Content-Encoding").getValue();
            }
            if (this.ptZ.getFirstHeader("Content-Disposition") != null) {
                str4 = this.ptZ.getFirstHeader("Content-Disposition").getValue();
            }
            if (str4 != null && str4.contains("attachment;") && str2.contains("download")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                if (this.ptZ.getFirstHeader("Content-Length") != null) {
                    charSequence = this.ptZ.getFirstHeader("Content-Length").getValue();
                }
                if (!TextUtils.isEmpty(charSequence) && ((long) bo.getInt(charSequence, 0)) > 5242880) {
                    cVar = new c(-10000, null, "mail content to large");
                    return cVar;
                }
            }
            HttpEntity entity = this.ptZ.getEntity();
            entity.getContentLength();
            InputStream content = entity.getContent();
            if (str3 == null || !str3.contains("gzip")) {
                inputStream = content;
            } else {
                inputStream = new GZIPInputStream(content);
            }
            if (obj != null) {
                Object valueOf;
                str4 = pua;
                StringBuilder stringBuilder = new StringBuilder();
                if (bVar.puc.get("default_attach_name") == null) {
                    valueOf = Long.valueOf(System.currentTimeMillis());
                } else {
                    Serializable valueOf2 = (Serializable) bVar.puc.get("default_attach_name");
                }
                fileOutputStream = new FileOutputStream(new File(str4, stringBuilder.append(valueOf2).toString()), true);
            } else {
                fileOutputStream = new ByteArrayOutputStream();
            }
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (!this.isCancelled) {
                read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                    aVar.ccp();
                }
            }
            if (this.isCancelled) {
                fileOutputStream.flush();
                fileOutputStream.close();
                if (this.ptV != null) {
                    this.ptV.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(67955);
                return null;
            }
            String str5;
            read = this.result;
            Map Vh = n.Vh(value);
            if (obj != null) {
                str5 = "";
            } else {
                str5 = new String(((ByteArrayOutputStream) fileOutputStream).toByteArray());
            }
            c cVar2 = new c(read, Vh, str5);
            fileOutputStream.flush();
            fileOutputStream.close();
            entity.consumeContent();
            ab.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
            if (this.ptV != null) {
                this.ptV.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(67955);
            return cVar2;
        } catch (UnsupportedEncodingException e) {
            cVar = new c(-10001, null, "unsupported ecoding");
        } catch (UnknownHostException e2) {
            cVar = new c(-10005, null, "unknow host");
        } catch (ClientProtocolException e3) {
            cVar = new c(-10002, null, "client protocol error");
        } catch (IllegalStateException e4) {
            cVar = new c(-10003, null, "illegal state");
        } catch (FileNotFoundException e5) {
            cVar = new c(-10004, null, "output file not found");
        } catch (Exception e6) {
            ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e6, "http unavailable", new Object[0]);
            cVar = new c(this.result == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : this.result, null, null);
        } catch (OutOfMemoryError e7) {
            ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e7, "http unavailable", new Object[0]);
            cVar = new c(this.result == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : this.result, null, null);
        } finally {
            if (this.ptV != null) {
                this.ptV.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(67955);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(67956);
        ab.d("MicroMsg.URLConnectionUtil", "cancel conection.");
        this.isCancelled = true;
        if (!(this.ptW == null || this.ptW.isAborted())) {
            this.ptW.abort();
        }
        if (this.ptV != null) {
            this.ptV.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(67956);
    }

    private static void a(b bVar, HttpRequestBase httpRequestBase) {
        AppMethodBeat.i(67957);
        if (bVar.puc == null) {
            AppMethodBeat.o(67957);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : bVar.puc.keySet()) {
            arrayList.add(new BasicNameValuePair(str, (String) bVar.puc.get(str)));
        }
        ((HttpPost) httpRequestBase).setEntity(new UrlEncodedFormEntity(arrayList, ProtocolPackage.ServerEncoding));
        AppMethodBeat.o(67957);
    }
}

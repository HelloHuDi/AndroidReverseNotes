package com.tencent.p177mm.plugin.qqmail.p486b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C28742a;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C39538b;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C43402c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.qqmail.b.m */
public final class C44756m extends C43403n {
    private boolean isCancelled = false;
    private HttpClient ptV = null;
    private HttpRequestBase ptW = null;
    private HttpResponse ptZ = null;
    private int result = 0;

    /* renamed from: a */
    public final C43402c mo36997a(String str, String str2, C39538b c39538b, C28742a c28742a) {
        AppMethodBeat.m2504i(67955);
        C4990ab.m7410d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + c39538b);
        C43402c c43402c;
        try {
            String value;
            Object obj;
            InputStream inputStream;
            OutputStream fileOutputStream;
            int read;
            this.isCancelled = false;
            this.ptV = new DefaultHttpClient();
            if (c39538b.pub == 0) {
                this.ptW = new HttpGet(C43403n.m77463f(str, str2, c39538b.pub == 0 ? c39538b.puc : null));
            } else {
                Map map;
                if (c39538b.pub == 0) {
                    map = c39538b.puc;
                } else {
                    map = null;
                }
                this.ptW = new HttpPost(C43403n.m77463f(str, str2, map));
            }
            this.ptW.addHeader("User-Agent", userAgent);
            this.ptW.addHeader("Host", host);
            System.setProperty("http.keepAlive", "false");
            this.ptW.addHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.ptW.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            this.ptW.addHeader("Content-Type", "text/html");
            this.ptW.addHeader("Cookie", C43403n.m77462W(c39538b.pud));
            if (c39538b.pub == 1) {
                C44756m.m81610a(c39538b, this.ptW);
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
                if (!TextUtils.isEmpty(charSequence) && ((long) C5046bo.getInt(charSequence, 0)) > 5242880) {
                    c43402c = new C43402c(-10000, null, "mail content to large");
                    return c43402c;
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
                if (c39538b.puc.get("default_attach_name") == null) {
                    valueOf = Long.valueOf(System.currentTimeMillis());
                } else {
                    Serializable valueOf2 = (Serializable) c39538b.puc.get("default_attach_name");
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
                    c28742a.ccp();
                }
            }
            if (this.isCancelled) {
                fileOutputStream.flush();
                fileOutputStream.close();
                if (this.ptV != null) {
                    this.ptV.getConnectionManager().shutdown();
                }
                AppMethodBeat.m2505o(67955);
                return null;
            }
            String str5;
            read = this.result;
            Map Vh = C43403n.m77461Vh(value);
            if (obj != null) {
                str5 = "";
            } else {
                str5 = new String(((ByteArrayOutputStream) fileOutputStream).toByteArray());
            }
            C43402c c43402c2 = new C43402c(read, Vh, str5);
            fileOutputStream.flush();
            fileOutputStream.close();
            entity.consumeContent();
            C4990ab.m7410d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + c43402c2);
            if (this.ptV != null) {
                this.ptV.getConnectionManager().shutdown();
            }
            AppMethodBeat.m2505o(67955);
            return c43402c2;
        } catch (UnsupportedEncodingException e) {
            c43402c = new C43402c(-10001, null, "unsupported ecoding");
        } catch (UnknownHostException e2) {
            c43402c = new C43402c(-10005, null, "unknow host");
        } catch (ClientProtocolException e3) {
            c43402c = new C43402c(-10002, null, "client protocol error");
        } catch (IllegalStateException e4) {
            c43402c = new C43402c(-10003, null, "illegal state");
        } catch (FileNotFoundException e5) {
            c43402c = new C43402c(-10004, null, "output file not found");
        } catch (Exception e6) {
            C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e6, "http unavailable", new Object[0]);
            c43402c = new C43402c(this.result == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : this.result, null, null);
        } catch (OutOfMemoryError e7) {
            C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e7, "http unavailable", new Object[0]);
            c43402c = new C43402c(this.result == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : this.result, null, null);
        } finally {
            if (this.ptV != null) {
                this.ptV.getConnectionManager().shutdown();
            }
            AppMethodBeat.m2505o(67955);
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(67956);
        C4990ab.m7410d("MicroMsg.URLConnectionUtil", "cancel conection.");
        this.isCancelled = true;
        if (!(this.ptW == null || this.ptW.isAborted())) {
            this.ptW.abort();
        }
        if (this.ptV != null) {
            this.ptV.getConnectionManager().shutdown();
        }
        AppMethodBeat.m2505o(67956);
    }

    /* renamed from: a */
    private static void m81610a(C39538b c39538b, HttpRequestBase httpRequestBase) {
        AppMethodBeat.m2504i(67957);
        if (c39538b.puc == null) {
            AppMethodBeat.m2505o(67957);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : c39538b.puc.keySet()) {
            arrayList.add(new BasicNameValuePair(str, (String) c39538b.puc.get(str)));
        }
        ((HttpPost) httpRequestBase).setEntity(new UrlEncodedFormEntity(arrayList, ProtocolPackage.ServerEncoding));
        AppMethodBeat.m2505o(67957);
    }
}

package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.net.Proxy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bc */
public abstract class C41032bc {
    /* renamed from: a */
    private static C41032bc f16440a = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bc$a */
    public static class C31026a extends C41032bc {
        /* renamed from: a */
        private Context f14061a;

        /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bc$a$1 */
        class C310251 implements HttpRequestRetryHandler {
            C310251() {
            }

            public final boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
                if (i >= 3) {
                    return false;
                }
                if (iOException instanceof NoHttpResponseException) {
                    return true;
                }
                if (iOException instanceof ClientProtocolException) {
                    return true;
                }
                return false;
            }
        }

        public C31026a(Context context) {
            this.f14061a = context;
        }

        /* renamed from: a */
        public final byte[] mo50349a(String str, byte[] bArr, C44499az c44499az) {
            AppMethodBeat.m2504i(98543);
            if (str == null) {
                C16205ag.m24687d("no destUrl!", new Object[0]);
                AppMethodBeat.m2505o(98543);
                return null;
            }
            long j;
            Exception exception;
            C31023ba c31023ba = null;
            int i = 0;
            if (bArr == null) {
                j = 0;
            } else {
                j = (long) bArr.length;
            }
            C16205ag.m24691h("start req: %s sz:%d", str, Long.valueOf(j));
            String str2 = "";
            String str3 = "";
            Object obj = null;
            int i2 = 0;
            String str4 = str;
            while (true) {
                int i3 = i + 1;
                Exception exception2;
                if (i >= 3 || i2 >= 2) {
                    exception = new Exception(str2);
                    AppMethodBeat.m2505o(98543);
                } else if (obj != null) {
                    exception2 = new Exception("net redirect");
                    AppMethodBeat.m2505o(98543);
                    throw exception2;
                } else {
                    Object obj2;
                    int i4;
                    if (i3 > 1) {
                        C16205ag.m24691h("try time:".concat(String.valueOf(i3)), new Object[0]);
                        if (i3 == 2 && c44499az.mo70869c() == 2) {
                            c44499az.mo41920b(false);
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            C16205ag.m24684a(e);
                        }
                    }
                    String n = C24349e.m37622n(this.f14061a);
                    new Date().getTime();
                    try {
                        c31023ba = C31026a.m49838a(str4, bArr, n, i3);
                    } catch (Exception exception22) {
                        n = exception22.toString();
                        if (str3.equals(n)) {
                            str2 = str2 + i3 + ":same ";
                        } else {
                            str2 = str2 + i3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + n + " ";
                        }
                        str3 = n;
                    }
                    new Date().getTime();
                    if (c31023ba != null) {
                        HttpResponse httpResponse = c31023ba.f14059a;
                        HttpEntity entity = httpResponse.getEntity();
                        long j2 = 0;
                        if (entity != null) {
                            j2 = entity.getContentLength();
                            if (j2 < 0) {
                                j2 = 0;
                            }
                        }
                        int statusCode = httpResponse.getStatusLine().getStatusCode();
                        C16205ag.m24691h("response code:%d ", Integer.valueOf(statusCode));
                        C16205ag.m24691h("contentLength:%d ", Long.valueOf(j2));
                        if (statusCode != 200) {
                            obj2 = (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) ? 1 : null;
                            if (obj2 != null) {
                                obj2 = 1;
                                Header firstHeader = httpResponse.getFirstHeader("Location");
                                if (firstHeader == null) {
                                    C16205ag.m24687d("redirect code:" + statusCode + " Location is null! return", new Object[0]);
                                    try {
                                        if (c31023ba.f14060b != null) {
                                            c31023ba.f14060b.abort();
                                        }
                                    } catch (Exception e2) {
                                    }
                                    AppMethodBeat.m2505o(98543);
                                    return null;
                                }
                                i4 = i2 + 1;
                                i = 0;
                                String value = firstHeader.getValue();
                                C16205ag.m24691h("redirect code:%d , to:%s", Integer.valueOf(statusCode), value);
                                try {
                                    if (c31023ba.f14060b != null) {
                                        c31023ba.f14060b.abort();
                                    }
                                    obj = 1;
                                    i2 = i4;
                                    str4 = value;
                                } catch (Exception e3) {
                                    str4 = value;
                                }
                            }
                        } else if (httpResponse.containsHeader("encrypt-status")) {
                            C16205ag.m24687d("svr encry failed: " + httpResponse.getFirstHeader("encrypt-status").getValue(), new Object[0]);
                            AppMethodBeat.m2505o(98543);
                            return null;
                        } else {
                            byte[] a = m49840a(httpResponse, c31023ba.f14060b);
                            AppMethodBeat.m2505o(98543);
                            return a;
                        }
                    }
                    obj2 = obj;
                    i4 = i2;
                    i = i3;
                    obj = obj2;
                    i2 = i4;
                }
            }
            exception = new Exception(str2);
            AppMethodBeat.m2505o(98543);
            throw exception;
        }

        /* renamed from: a */
        private static C31023ba m49838a(String str, byte[] bArr, String str2, int i) {
            Throwable th;
            C31023ba c31023ba = null;
            AppMethodBeat.m2504i(98544);
            if (str == null) {
                C16205ag.m24687d("no destUrl!", new Object[0]);
                AppMethodBeat.m2505o(98544);
            } else {
                HttpEntity byteArrayEntity;
                HttpPost httpPost;
                if (bArr != null) {
                    try {
                        byteArrayEntity = new ByteArrayEntity(bArr);
                    } catch (Throwable th2) {
                        th = th2;
                        httpPost = null;
                    }
                } else {
                    byteArrayEntity = new ByteArrayEntity("".getBytes());
                }
                HttpClient a = C31026a.m49839a(str2, i);
                if (a == null) {
                    C16205ag.m24687d("no httpClient!", new Object[0]);
                    AppMethodBeat.m2505o(98544);
                } else {
                    httpPost = new HttpPost(str);
                    try {
                        httpPost.setHeader("wup_version", "3.0");
                        httpPost.setHeader("TYPE_COMPRESS", "2");
                        httpPost.setHeader("encr_type", "rsapost");
                        C44540v a2 = C44540v.m80860a();
                        if (a2 != null) {
                            httpPost.setHeader("bea_key", a2.mo70947j());
                        }
                        httpPost.setEntity(byteArrayEntity);
                        HttpResponse execute = a.execute(httpPost, new BasicHttpContext());
                        C16205ag.m24691h("execute request:\n %s", ((HttpRequest) r0.getAttribute("http.request")).getRequestLine().toString());
                        c31023ba = new C31023ba(execute, httpPost);
                        AppMethodBeat.m2505o(98544);
                    } catch (Throwable th3) {
                        th = th3;
                        C16205ag.m24684a(th);
                        C16205ag.m24687d("execute error:%s", th.toString());
                        if (httpPost != null) {
                            httpPost.abort();
                        }
                        Exception exception = new Exception(th.toString());
                        AppMethodBeat.m2505o(98544);
                        throw exception;
                    }
                }
            }
            return c31023ba;
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8 A:{SYNTHETIC, Splitter:B:45:0x00d8} */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00dd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private byte[] m49840a(HttpResponse httpResponse, HttpPost httpPost) {
            Throwable th;
            byte[] bArr = null;
            AppMethodBeat.m2504i(98545);
            if (httpResponse == null) {
                AppMethodBeat.m2505o(98545);
            } else {
                if (httpResponse.getStatusLine().getStatusCode() != 200) {
                    StatusLine statusLine = httpResponse.getStatusLine();
                    C16205ag.m24686c("request failure code:%d , line:%s ", Integer.valueOf(r1), statusLine);
                    AppMethodBeat.m2505o(98545);
                } else {
                    if (httpResponse.containsHeader("session_id") && httpResponse.containsHeader("max_time")) {
                        C44540v.m80860a().mo70935a(this.f14061a, httpResponse.getFirstHeader("session_id").getValue(), httpResponse.getFirstHeader("max_time").getValue());
                    }
                    HttpEntity entity = httpResponse.getEntity();
                    if (entity == null) {
                        C16205ag.m24687d("no response datas!", new Object[0]);
                        AppMethodBeat.m2505o(98545);
                    } else {
                        BufferedInputStream bufferedInputStream;
                        try {
                            bufferedInputStream = new BufferedInputStream(new DataInputStream(entity.getContent()));
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
                                while (true) {
                                    int read = bufferedInputStream.read();
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(read);
                                }
                                byteArrayOutputStream.flush();
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable th2) {
                                    C16205ag.m24684a(th2);
                                }
                                if (httpPost != null) {
                                    httpPost.abort();
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            bufferedInputStream = bArr;
                            if (bufferedInputStream != null) {
                            }
                            if (httpPost != null) {
                            }
                            AppMethodBeat.m2505o(98545);
                            throw th2;
                        }
                        AppMethodBeat.m2505o(98545);
                    }
                }
            }
            return bArr;
        }

        /* renamed from: a */
        private static HttpClient m49839a(String str, int i) {
            AppMethodBeat.m2504i(98546);
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, C1625i.sHCENCODEVIDEOTIMEOUT);
                HttpConnectionParams.setSocketBufferSize(basicHttpParams, 2000);
                basicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                defaultHttpClient.setHttpRequestRetryHandler(new C310251());
                if (str == null || !str.toLowerCase(Locale.US).contains("wap") || i == 2) {
                    if (str != null) {
                        C16205ag.m24683a("Don't use proxy: %s, try time: %s", str, Integer.valueOf(i));
                    }
                    defaultHttpClient.getParams().removeParameter("http.route.default-proxy");
                } else {
                    C16205ag.m24683a("use proxy: %s, try time: %s", str, Integer.valueOf(i));
                    defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort()));
                }
                AppMethodBeat.m2505o(98546);
                return defaultHttpClient;
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                C16205ag.m24687d("httpclient error!", new Object[0]);
                AppMethodBeat.m2505o(98546);
                return null;
            }
        }
    }

    /* renamed from: a */
    public abstract byte[] mo50349a(String str, byte[] bArr, C44499az c44499az);

    /* renamed from: a */
    public static synchronized C41032bc m71345a(Context context) {
        C41032bc c41032bc;
        synchronized (C41032bc.class) {
            if (f16440a == null && context != null) {
                f16440a = new C31026a(context);
            }
            c41032bc = f16440a;
        }
        return c41032bc;
    }
}

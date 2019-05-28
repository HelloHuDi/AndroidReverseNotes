package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.net.Proxy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.tencentmap.mapsdk.a.e;
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

public abstract class bc {
    private static bc a = null;

    public static class a extends bc {
        private Context a;

        public a(Context context) {
            this.a = context;
        }

        public final byte[] a(String str, byte[] bArr, az azVar) {
            AppMethodBeat.i(98543);
            if (str == null) {
                ag.d("no destUrl!", new Object[0]);
                AppMethodBeat.o(98543);
                return null;
            }
            long j;
            Exception exception;
            ba baVar = null;
            int i = 0;
            if (bArr == null) {
                j = 0;
            } else {
                j = (long) bArr.length;
            }
            ag.h("start req: %s sz:%d", str, Long.valueOf(j));
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
                    AppMethodBeat.o(98543);
                } else if (obj != null) {
                    exception2 = new Exception("net redirect");
                    AppMethodBeat.o(98543);
                    throw exception2;
                } else {
                    Object obj2;
                    int i4;
                    if (i3 > 1) {
                        ag.h("try time:".concat(String.valueOf(i3)), new Object[0]);
                        if (i3 == 2 && azVar.c() == 2) {
                            azVar.b(false);
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            ag.a(e);
                        }
                    }
                    String n = e.n(this.a);
                    new Date().getTime();
                    try {
                        baVar = a(str4, bArr, n, i3);
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
                    if (baVar != null) {
                        HttpResponse httpResponse = baVar.a;
                        HttpEntity entity = httpResponse.getEntity();
                        long j2 = 0;
                        if (entity != null) {
                            j2 = entity.getContentLength();
                            if (j2 < 0) {
                                j2 = 0;
                            }
                        }
                        int statusCode = httpResponse.getStatusLine().getStatusCode();
                        ag.h("response code:%d ", Integer.valueOf(statusCode));
                        ag.h("contentLength:%d ", Long.valueOf(j2));
                        if (statusCode != 200) {
                            obj2 = (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) ? 1 : null;
                            if (obj2 != null) {
                                obj2 = 1;
                                Header firstHeader = httpResponse.getFirstHeader("Location");
                                if (firstHeader == null) {
                                    ag.d("redirect code:" + statusCode + " Location is null! return", new Object[0]);
                                    try {
                                        if (baVar.b != null) {
                                            baVar.b.abort();
                                        }
                                    } catch (Exception e2) {
                                    }
                                    AppMethodBeat.o(98543);
                                    return null;
                                }
                                i4 = i2 + 1;
                                i = 0;
                                String value = firstHeader.getValue();
                                ag.h("redirect code:%d , to:%s", Integer.valueOf(statusCode), value);
                                try {
                                    if (baVar.b != null) {
                                        baVar.b.abort();
                                    }
                                    obj = 1;
                                    i2 = i4;
                                    str4 = value;
                                } catch (Exception e3) {
                                    str4 = value;
                                }
                            }
                        } else if (httpResponse.containsHeader("encrypt-status")) {
                            ag.d("svr encry failed: " + httpResponse.getFirstHeader("encrypt-status").getValue(), new Object[0]);
                            AppMethodBeat.o(98543);
                            return null;
                        } else {
                            byte[] a = a(httpResponse, baVar.b);
                            AppMethodBeat.o(98543);
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
            AppMethodBeat.o(98543);
            throw exception;
        }

        private static ba a(String str, byte[] bArr, String str2, int i) {
            Throwable th;
            ba baVar = null;
            AppMethodBeat.i(98544);
            if (str == null) {
                ag.d("no destUrl!", new Object[0]);
                AppMethodBeat.o(98544);
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
                HttpClient a = a(str2, i);
                if (a == null) {
                    ag.d("no httpClient!", new Object[0]);
                    AppMethodBeat.o(98544);
                } else {
                    httpPost = new HttpPost(str);
                    try {
                        httpPost.setHeader("wup_version", "3.0");
                        httpPost.setHeader("TYPE_COMPRESS", "2");
                        httpPost.setHeader("encr_type", "rsapost");
                        v a2 = v.a();
                        if (a2 != null) {
                            httpPost.setHeader("bea_key", a2.j());
                        }
                        httpPost.setEntity(byteArrayEntity);
                        HttpResponse execute = a.execute(httpPost, new BasicHttpContext());
                        ag.h("execute request:\n %s", ((HttpRequest) r0.getAttribute("http.request")).getRequestLine().toString());
                        baVar = new ba(execute, httpPost);
                        AppMethodBeat.o(98544);
                    } catch (Throwable th3) {
                        th = th3;
                        ag.a(th);
                        ag.d("execute error:%s", th.toString());
                        if (httpPost != null) {
                            httpPost.abort();
                        }
                        Exception exception = new Exception(th.toString());
                        AppMethodBeat.o(98544);
                        throw exception;
                    }
                }
            }
            return baVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8 A:{SYNTHETIC, Splitter:B:45:0x00d8} */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00dd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private byte[] a(HttpResponse httpResponse, HttpPost httpPost) {
            Throwable th;
            byte[] bArr = null;
            AppMethodBeat.i(98545);
            if (httpResponse == null) {
                AppMethodBeat.o(98545);
            } else {
                if (httpResponse.getStatusLine().getStatusCode() != 200) {
                    StatusLine statusLine = httpResponse.getStatusLine();
                    ag.c("request failure code:%d , line:%s ", Integer.valueOf(r1), statusLine);
                    AppMethodBeat.o(98545);
                } else {
                    if (httpResponse.containsHeader("session_id") && httpResponse.containsHeader("max_time")) {
                        v.a().a(this.a, httpResponse.getFirstHeader("session_id").getValue(), httpResponse.getFirstHeader("max_time").getValue());
                    }
                    HttpEntity entity = httpResponse.getEntity();
                    if (entity == null) {
                        ag.d("no response datas!", new Object[0]);
                        AppMethodBeat.o(98545);
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
                                    ag.a(th2);
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
                            AppMethodBeat.o(98545);
                            throw th2;
                        }
                        AppMethodBeat.o(98545);
                    }
                }
            }
            return bArr;
        }

        private static HttpClient a(String str, int i) {
            AppMethodBeat.i(98546);
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, i.sHCENCODEVIDEOTIMEOUT);
                HttpConnectionParams.setSocketBufferSize(basicHttpParams, 2000);
                basicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                defaultHttpClient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
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
                });
                if (str == null || !str.toLowerCase(Locale.US).contains("wap") || i == 2) {
                    if (str != null) {
                        ag.a("Don't use proxy: %s, try time: %s", str, Integer.valueOf(i));
                    }
                    defaultHttpClient.getParams().removeParameter("http.route.default-proxy");
                } else {
                    ag.a("use proxy: %s, try time: %s", str, Integer.valueOf(i));
                    defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort()));
                }
                AppMethodBeat.o(98546);
                return defaultHttpClient;
            } catch (Throwable th) {
                ag.a(th);
                ag.d("httpclient error!", new Object[0]);
                AppMethodBeat.o(98546);
                return null;
            }
        }
    }

    public abstract byte[] a(String str, byte[] bArr, az azVar);

    public static synchronized bc a(Context context) {
        bc bcVar;
        synchronized (bc.class) {
            if (a == null && context != null) {
                a = new a(context);
            }
            bcVar = a;
        }
        return bcVar;
    }
}

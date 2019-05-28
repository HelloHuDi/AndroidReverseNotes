package com.tencent.tmassistantsdk.network;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.HttpClientUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public abstract class GetHttpRequest {
    protected static final String REQUEST_SERVER_URL = "http://appicsh.qq.com/cgi-bin/appstage/yyb_get_userapp_info";
    protected static final String TAG = "NetworkTask";
    protected HttpGet mHttpGet = null;

    public abstract void onFinished(JSONObject jSONObject, int i);

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean sendData(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mHttpGet == null) {
                new Thread(new Runnable() {
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x0136=Splitter:B:54:0x0136, B:40:0x00e7=Splitter:B:40:0x00e7, B:61:0x015e=Splitter:B:61:0x015e, B:47:0x010f=Splitter:B:47:0x010f} */
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x00aa=Splitter:B:27:0x00aa, B:33:0x00cc=Splitter:B:33:0x00cc} */
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x00aa=Splitter:B:27:0x00aa, B:33:0x00cc=Splitter:B:33:0x00cc} */
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x00aa=Splitter:B:27:0x00aa, B:33:0x00cc=Splitter:B:33:0x00cc} */
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x00aa=Splitter:B:27:0x00aa, B:33:0x00cc=Splitter:B:33:0x00cc} */
                    /* JADX WARNING: Removed duplicated region for block: B:51:0x0128  */
                    /* JADX WARNING: Removed duplicated region for block: B:58:0x0150  */
                    /* JADX WARNING: Removed duplicated region for block: B:65:0x0178  */
                    /* JADX WARNING: Removed duplicated region for block: B:70:0x018c  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        Throwable e;
                        AppMethodBeat.m2504i(75835);
                        String str = str;
                        HttpClient createHttpClient;
                        try {
                            GetHttpRequest.this.mHttpGet = new HttpGet();
                            GetHttpRequest.this.mHttpGet.setURI(new URI(GetHttpRequest.REQUEST_SERVER_URL.concat(String.valueOf(str))));
                            createHttpClient = HttpClientUtil.createHttpClient();
                            try {
                                HttpClientUtil.setProxy(createHttpClient);
                                HttpResponse execute = createHttpClient.execute(GetHttpRequest.this.mHttpGet);
                                if (execute != null && execute.getStatusLine().getStatusCode() == 200) {
                                    HttpEntity entity = execute.getEntity();
                                    if (entity != null) {
                                        byte[] toByteArray = EntityUtils.toByteArray(entity);
                                        if (toByteArray == null || toByteArray.length <= 0) {
                                            TMLog.m60588i(GetHttpRequest.TAG, "data invalidate");
                                            GetHttpRequest.this.onFinished(null, 704);
                                            GetHttpRequest.this.mHttpGet = null;
                                            if (createHttpClient != null) {
                                                createHttpClient.getConnectionManager().shutdown();
                                            }
                                            AppMethodBeat.m2505o(75835);
                                            return;
                                        }
                                        String str2 = new String(toByteArray, ProtocolPackage.ServerEncoding);
                                        if (TextUtils.isEmpty(str2)) {
                                            TMLog.m60588i(GetHttpRequest.TAG, "failed to convert byte[] to string");
                                            GetHttpRequest.this.onFinished(null, 606);
                                            GetHttpRequest.this.mHttpGet = null;
                                            if (createHttpClient != null) {
                                                createHttpClient.getConnectionManager().shutdown();
                                            }
                                            AppMethodBeat.m2505o(75835);
                                            return;
                                        }
                                        JSONObject jSONObject = new JSONObject(str2);
                                        TMLog.m60588i(GetHttpRequest.TAG, "success to received data");
                                        GetHttpRequest.this.onFinished(jSONObject, 0);
                                        GetHttpRequest.this.mHttpGet = null;
                                        if (createHttpClient != null) {
                                            createHttpClient.getConnectionManager().shutdown();
                                        }
                                        AppMethodBeat.m2505o(75835);
                                        return;
                                    }
                                }
                                GetHttpRequest.this.onFinished(null, 704);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                    createHttpClient.getConnectionManager().shutdown();
                                    AppMethodBeat.m2505o(75835);
                                    return;
                                }
                            } catch (ConnectTimeoutException e2) {
                                e = e2;
                                try {
                                    C4990ab.printErrStackTrace(GetHttpRequest.TAG, e, "", new Object[0]);
                                    GetHttpRequest.this.onFinished(null, 601);
                                    GetHttpRequest.this.mHttpGet = null;
                                    if (createHttpClient != null) {
                                        createHttpClient.getConnectionManager().shutdown();
                                        AppMethodBeat.m2505o(75835);
                                        return;
                                    }
                                    AppMethodBeat.m2505o(75835);
                                } catch (Throwable th) {
                                    e = th;
                                    GetHttpRequest.this.mHttpGet = null;
                                    if (createHttpClient != null) {
                                    }
                                    AppMethodBeat.m2505o(75835);
                                    throw e;
                                }
                            } catch (ConnectException e3) {
                                e = e3;
                                C4990ab.printErrStackTrace(GetHttpRequest.TAG, e, "", new Object[0]);
                                GetHttpRequest.this.onFinished(null, 1);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                }
                                AppMethodBeat.m2505o(75835);
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                C4990ab.printErrStackTrace(GetHttpRequest.TAG, e, "", new Object[0]);
                                GetHttpRequest.this.onFinished(null, 602);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                }
                                AppMethodBeat.m2505o(75835);
                            } catch (Exception e5) {
                                e = e5;
                                C4990ab.printErrStackTrace(GetHttpRequest.TAG, e, "", new Object[0]);
                                GetHttpRequest.this.onFinished(null, 604);
                                GetHttpRequest.this.mHttpGet = null;
                                if (createHttpClient != null) {
                                }
                                AppMethodBeat.m2505o(75835);
                            }
                        } catch (ConnectTimeoutException e6) {
                            e = e6;
                            createHttpClient = null;
                        } catch (ConnectException e7) {
                            e = e7;
                            createHttpClient = null;
                            C4990ab.printErrStackTrace(GetHttpRequest.TAG, e, "", new Object[0]);
                            GetHttpRequest.this.onFinished(null, 1);
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                AppMethodBeat.m2505o(75835);
                                return;
                            }
                            AppMethodBeat.m2505o(75835);
                        } catch (SocketTimeoutException e8) {
                            e = e8;
                            createHttpClient = null;
                            C4990ab.printErrStackTrace(GetHttpRequest.TAG, e, "", new Object[0]);
                            GetHttpRequest.this.onFinished(null, 602);
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                AppMethodBeat.m2505o(75835);
                                return;
                            }
                            AppMethodBeat.m2505o(75835);
                        } catch (Exception e9) {
                            e = e9;
                            createHttpClient = null;
                            C4990ab.printErrStackTrace(GetHttpRequest.TAG, e, "", new Object[0]);
                            GetHttpRequest.this.onFinished(null, 604);
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                AppMethodBeat.m2505o(75835);
                                return;
                            }
                            AppMethodBeat.m2505o(75835);
                        } catch (Throwable th2) {
                            e = th2;
                            createHttpClient = null;
                            GetHttpRequest.this.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                            }
                            AppMethodBeat.m2505o(75835);
                            throw e;
                        }
                        AppMethodBeat.m2505o(75835);
                    }
                }).start();
            }
        }
        return false;
    }
}

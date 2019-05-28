package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.HttpClientUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.Request;
import com.tencent.tmassistantsdk.protocol.jce.Response;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.ByteArrayBuffer;

public abstract class PostHttpRequest {
    static final String REQUEST_SERVER_URL = "http://masdk.3g.qq.com/";
    static final String TAG = "BaseHttpRequest";
    HttpPost mHttpPost = null;

    public abstract void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i);

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean sendRequest(final JceStruct jceStruct) {
        if (jceStruct != null) {
            if (this.mHttpPost == null) {
                new Thread(new Runnable() {
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x0110=Splitter:B:49:0x0110, B:16:0x0078=Splitter:B:16:0x0078, B:56:0x0138=Splitter:B:56:0x0138, B:42:0x00ea=Splitter:B:42:0x00ea} */
                    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168  */
                    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103  */
                    /* JADX WARNING: Removed duplicated region for block: B:53:0x012a  */
                    /* JADX WARNING: Removed duplicated region for block: B:60:0x0154  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        Throwable e;
                        AppMethodBeat.i(75838);
                        Request buildRequest = ProtocolPackage.buildRequest(jceStruct);
                        byte[] buildPostData = ProtocolPackage.buildPostData(buildRequest);
                        PostHttpRequest.this.mHttpPost = new HttpPost(PostHttpRequest.REQUEST_SERVER_URL);
                        PostHttpRequest.this.mHttpPost.addHeader("User-Agent", "AssistantDownloader");
                        PostHttpRequest.this.mHttpPost.setEntity(new ByteArrayEntity(buildPostData));
                        HttpClient createHttpClient;
                        try {
                            createHttpClient = HttpClientUtil.createHttpClient();
                            try {
                                HttpClientUtil.setProxy(createHttpClient);
                                HttpResponse execute = createHttpClient.execute(PostHttpRequest.this.mHttpPost);
                                if (execute != null && execute.getStatusLine().getStatusCode() == 200) {
                                    HttpEntity entity = execute.getEntity();
                                    if (entity != null) {
                                        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) entity.getContentLength());
                                        InputStream content = entity.getContent();
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = content.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayBuffer.append(bArr, 0, read);
                                        }
                                        buildPostData = byteArrayBuffer.buffer();
                                        if (buildPostData != null && buildPostData.length > 4) {
                                            Response unpackPackage = ProtocolPackage.unpackPackage(buildPostData);
                                            if (!(unpackPackage == null || unpackPackage.body == null)) {
                                                JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(jceStruct, unpackPackage.body);
                                                if (unpageageJceResponse != null) {
                                                    PostHttpRequest.this.onFinished(jceStruct, unpageageJceResponse, unpackPackage.head.ret);
                                                    PostHttpRequest.this.mHttpPost = null;
                                                    if (createHttpClient != null) {
                                                        createHttpClient.getConnectionManager().shutdown();
                                                    }
                                                    AppMethodBeat.o(75838);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                                PostHttpRequest.this.mHttpPost = null;
                                if (createHttpClient != null) {
                                    createHttpClient.getConnectionManager().shutdown();
                                    AppMethodBeat.o(75838);
                                    return;
                                }
                            } catch (ConnectTimeoutException e2) {
                                e = e2;
                                try {
                                    ab.printErrStackTrace(PostHttpRequest.TAG, e, "", new Object[0]);
                                    PostHttpRequest.this.onFinished(buildRequest, null, 601);
                                    PostHttpRequest.this.mHttpPost = null;
                                    if (createHttpClient != null) {
                                        createHttpClient.getConnectionManager().shutdown();
                                        AppMethodBeat.o(75838);
                                        return;
                                    }
                                    AppMethodBeat.o(75838);
                                } catch (Throwable th) {
                                    e = th;
                                    PostHttpRequest.this.mHttpPost = null;
                                    if (createHttpClient != null) {
                                        createHttpClient.getConnectionManager().shutdown();
                                    }
                                    AppMethodBeat.o(75838);
                                    throw e;
                                }
                            } catch (ConnectException e3) {
                                e = e3;
                                ab.printErrStackTrace(PostHttpRequest.TAG, e, "", new Object[0]);
                                PostHttpRequest.this.onFinished(buildRequest, null, 1);
                                PostHttpRequest.this.mHttpPost = null;
                                if (createHttpClient != null) {
                                }
                                AppMethodBeat.o(75838);
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                ab.printErrStackTrace(PostHttpRequest.TAG, e, "", new Object[0]);
                                PostHttpRequest.this.onFinished(buildRequest, null, 602);
                                PostHttpRequest.this.mHttpPost = null;
                                if (createHttpClient != null) {
                                }
                                AppMethodBeat.o(75838);
                            } catch (Exception e5) {
                                e = e5;
                                ab.printErrStackTrace(PostHttpRequest.TAG, e, "", new Object[0]);
                                PostHttpRequest.this.onFinished(jceStruct, null, 604);
                                PostHttpRequest.this.mHttpPost = null;
                                if (createHttpClient != null) {
                                }
                                AppMethodBeat.o(75838);
                            }
                        } catch (ConnectTimeoutException e6) {
                            e = e6;
                            createHttpClient = null;
                        } catch (ConnectException e7) {
                            e = e7;
                            createHttpClient = null;
                            ab.printErrStackTrace(PostHttpRequest.TAG, e, "", new Object[0]);
                            PostHttpRequest.this.onFinished(buildRequest, null, 1);
                            PostHttpRequest.this.mHttpPost = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                AppMethodBeat.o(75838);
                                return;
                            }
                            AppMethodBeat.o(75838);
                        } catch (SocketTimeoutException e8) {
                            e = e8;
                            createHttpClient = null;
                            ab.printErrStackTrace(PostHttpRequest.TAG, e, "", new Object[0]);
                            PostHttpRequest.this.onFinished(buildRequest, null, 602);
                            PostHttpRequest.this.mHttpPost = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                AppMethodBeat.o(75838);
                                return;
                            }
                            AppMethodBeat.o(75838);
                        } catch (Exception e9) {
                            e = e9;
                            createHttpClient = null;
                            ab.printErrStackTrace(PostHttpRequest.TAG, e, "", new Object[0]);
                            PostHttpRequest.this.onFinished(jceStruct, null, 604);
                            PostHttpRequest.this.mHttpPost = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                AppMethodBeat.o(75838);
                                return;
                            }
                            AppMethodBeat.o(75838);
                        } catch (Throwable th2) {
                            e = th2;
                            createHttpClient = null;
                            PostHttpRequest.this.mHttpPost = null;
                            if (createHttpClient != null) {
                            }
                            AppMethodBeat.o(75838);
                            throw e;
                        }
                        AppMethodBeat.o(75838);
                    }
                }).start();
            }
        }
        return false;
    }

    public synchronized void cancleRequest() {
        if (!(this.mHttpPost == null || this.mHttpPost.isAborted())) {
            TMLog.i(TAG, "BaseHttpRequest:" + this + " cancleRequest");
            try {
                this.mHttpPost.abort();
                this.mHttpPost = null;
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
                this.mHttpPost = null;
            } catch (Throwable th) {
                this.mHttpPost = null;
            }
        }
        return;
    }
}

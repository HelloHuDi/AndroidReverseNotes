package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Map;
import java.util.Map.Entry;

public class DefaultMediaHTTPConnection implements IMediaHTTPConnection {
    private static final int CONNECT_TIMEOUT_MS = 30000;
    private static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "MediaHTTPConnection";
    private static final boolean VERBOSE = false;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private long mTotalSize = -1;
    private URL mURL = null;

    public boolean connect(URL url, Map<String, String> map) {
        AppMethodBeat.i(104788);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.mHeaders = map;
        AppMethodBeat.o(104788);
        return true;
    }

    private boolean parseBoolean(String str) {
        AppMethodBeat.i(104789);
        try {
            if (Long.parseLong(str) != 0) {
                AppMethodBeat.o(104789);
                return true;
            }
            AppMethodBeat.o(104789);
            return false;
        } catch (NumberFormatException e) {
            if ("true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str)) {
                AppMethodBeat.o(104789);
                return true;
            }
            AppMethodBeat.o(104789);
            return false;
        }
    }

    private boolean filterOutInternalHeaders(String str, String str2) {
        AppMethodBeat.i(104790);
        if ("android-allow-cross-domain-redirect".equalsIgnoreCase(str)) {
            this.mAllowCrossDomainRedirect = parseBoolean(str2);
            this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
            AppMethodBeat.o(104790);
            return true;
        }
        AppMethodBeat.o(104790);
        return false;
    }

    public void disconnect() {
        AppMethodBeat.i(104791);
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        AppMethodBeat.o(104791);
    }

    private void teardownConnection() {
        AppMethodBeat.i(104792);
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
        AppMethodBeat.o(104792);
    }

    private static final boolean isLocalHost(URL url) {
        AppMethodBeat.i(104793);
        if (url == null) {
            AppMethodBeat.o(104793);
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            AppMethodBeat.o(104793);
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                AppMethodBeat.o(104793);
                return true;
            }
        } catch (IllegalArgumentException e) {
            Logger.e(TAG, "isLocalHost", e);
        }
        AppMethodBeat.o(104793);
        return false;
    }

    /* JADX WARNING: Missing block: B:79:0x01f6, code skipped:
            if (r9.mAllowCrossDomainRedirect == false) goto L_0x0200;
     */
    /* JADX WARNING: Missing block: B:80:0x01f8, code skipped:
            r9.mURL = r9.mConnection.getURL();
     */
    /* JADX WARNING: Missing block: B:82:0x0202, code skipped:
            if (r2 != 206) goto L_0x023d;
     */
    /* JADX WARNING: Missing block: B:83:0x0204, code skipped:
            r0 = r9.mConnection.getHeaderField("Content-Range");
            r9.mTotalSize = -1;
     */
    /* JADX WARNING: Missing block: B:84:0x0211, code skipped:
            if (r0 == null) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:85:0x0213, code skipped:
            r1 = r0.lastIndexOf(47);
     */
    /* JADX WARNING: Missing block: B:86:0x0219, code skipped:
            if (r1 < 0) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:89:?, code skipped:
            r9.mTotalSize = java.lang.Long.parseLong(r0.substring(r1 + 1));
     */
    /* JADX WARNING: Missing block: B:98:0x023f, code skipped:
            if (r2 == 200) goto L_0x0258;
     */
    /* JADX WARNING: Missing block: B:99:0x0241, code skipped:
            r0 = new java.io.IOException("failed! status code: ".concat(java.lang.String.valueOf(r2)));
            com.tencent.matrix.trace.core.AppMethodBeat.o(104794);
     */
    /* JADX WARNING: Missing block: B:100:0x0257, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:101:0x0258, code skipped:
            r9.mTotalSize = (long) r9.mConnection.getContentLength();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekTo(long j) {
        AppMethodBeat.i(104794);
        teardownConnection();
        try {
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
            int i = 0;
            while (true) {
                if (isLocalHost) {
                    this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                } else {
                    this.mConnection = (HttpURLConnection) url.openConnection();
                }
                Logger.i(TAG, "setConnectTimeout " + this.mURL);
                this.mConnection.setConnectTimeout(CONNECT_TIMEOUT_MS);
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                String str = "Accept-Encoding";
                Object obj = null;
                if (this.mHeaders != null) {
                    for (Entry entry : this.mHeaders.entrySet()) {
                        Object obj2;
                        this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        if (obj == null && str.equals(entry.getKey())) {
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                }
                if (j > 0) {
                    this.mConnection.setRequestProperty("Range", "bytes=" + j + "-");
                }
                if (obj == null) {
                    this.mConnection.setRequestProperty(str, "");
                }
                int responseCode = this.mConnection.getResponseCode();
                if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307) {
                    break;
                }
                int i2 = i + 1;
                NoRouteToHostException noRouteToHostException;
                if (i2 > 20) {
                    noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(104794);
                    throw noRouteToHostException;
                }
                String requestMethod = this.mConnection.getRequestMethod();
                if (responseCode != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
                    String headerField = this.mConnection.getHeaderField("Location");
                    if (headerField == null) {
                        noRouteToHostException = new NoRouteToHostException("Invalid redirect");
                        AppMethodBeat.o(104794);
                        throw noRouteToHostException;
                    }
                    url = new URL(this.mURL, headerField);
                    if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                        boolean equals = this.mURL.getProtocol().equals(url.getProtocol());
                        if (this.mAllowCrossProtocolRedirect || equals) {
                            equals = this.mURL.getHost().equals(url.getHost());
                            if (this.mAllowCrossDomainRedirect || equals) {
                                if (responseCode != 307) {
                                    this.mURL = url;
                                }
                                i = i2;
                            } else {
                                noRouteToHostException = new NoRouteToHostException("Cross-domain redirects are disallowed");
                                AppMethodBeat.o(104794);
                                throw noRouteToHostException;
                            }
                        }
                        noRouteToHostException = new NoRouteToHostException("Cross-protocol redirects are disallowed");
                        AppMethodBeat.o(104794);
                        throw noRouteToHostException;
                    }
                    noRouteToHostException = new NoRouteToHostException("Unsupported protocol redirect");
                    AppMethodBeat.o(104794);
                    throw noRouteToHostException;
                }
                noRouteToHostException = new NoRouteToHostException("Invalid redirect");
                AppMethodBeat.o(104794);
                throw noRouteToHostException;
            }
            if (j <= 0 || responseCode == 206) {
                this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                this.mCurrentOffset = j;
                AppMethodBeat.o(104794);
                return;
            }
            ProtocolException protocolException = new ProtocolException();
            AppMethodBeat.o(104794);
            throw protocolException;
        } catch (Exception e) {
            IOException iOException = new IOException("An suspicious exception occurred: " + e.getMessage());
            AppMethodBeat.o(104794);
            throw iOException;
        } catch (IOException e2) {
            this.mTotalSize = -1;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1;
            Logger.e(TAG, "seekTo", e2);
            AppMethodBeat.o(104794);
            throw e2;
        }
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(104795);
        try {
            if (j != this.mCurrentOffset) {
                seekTo(j);
            }
            int read = this.mInputStream.read(bArr, i, i2);
            if (read == -1) {
                read = 0;
            }
            this.mCurrentOffset += (long) read;
            AppMethodBeat.o(104795);
            return read;
        } catch (ProtocolException e) {
            Logger.w(TAG, "readAt " + j + " / " + i2 + " => " + e);
            AppMethodBeat.o(104795);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.w(TAG, "readAt " + j + " / " + i2 + " => " + e2);
            AppMethodBeat.o(104795);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.w(TAG, "readAt " + j + " / " + i2 + " => " + e3);
            AppMethodBeat.o(104795);
            return -1010;
        } catch (IOException e4) {
            AppMethodBeat.o(104795);
            return -2;
        } catch (Exception e5) {
            AppMethodBeat.o(104795);
            return -3;
        }
    }

    public long getSize() {
        AppMethodBeat.i(104796);
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (IOException e) {
                Logger.e(TAG, "getSize", e);
                AppMethodBeat.o(104796);
                return -1;
            }
        }
        long j = this.mTotalSize;
        AppMethodBeat.o(104796);
        return j;
    }

    public String getMIMEType() {
        String str;
        AppMethodBeat.i(104797);
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (IOException e) {
                Logger.e(TAG, "getMIMEType", e);
                str = "application/octet-stream";
                AppMethodBeat.o(104797);
                return str;
            }
        }
        str = this.mConnection.getContentType();
        AppMethodBeat.o(104797);
        return str;
    }

    public String getUri() {
        AppMethodBeat.i(104798);
        String url = this.mURL.toString();
        AppMethodBeat.o(104798);
        return url;
    }
}

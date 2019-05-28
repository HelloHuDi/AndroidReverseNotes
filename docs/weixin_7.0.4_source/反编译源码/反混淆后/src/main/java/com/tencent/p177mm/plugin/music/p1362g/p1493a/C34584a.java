package com.tencent.p177mm.plugin.music.p1362g.p1493a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9060h;
import com.tencent.p177mm.plugin.music.cache.C21343c;
import com.tencent.p177mm.plugin.music.cache.C28550a;
import com.tencent.p177mm.plugin.music.cache.C28551d;
import com.tencent.p177mm.plugin.music.cache.C28551d.C12660a;
import com.tencent.p177mm.plugin.music.cache.C39432e;
import com.tencent.p177mm.plugin.music.cache.C39433g;
import com.tencent.p177mm.plugin.music.cache.C43322h;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.music.g.a.a */
public final class C34584a implements IMediaHTTPConnection {
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private String mMimeType = "";
    private long mTotalSize = -1;
    private URL mURL = null;
    private C28550a oNZ;
    public URL oOa = null;
    private byte[] oOb = new byte[1];

    public C34584a() {
        AppMethodBeat.m2504i(137675);
        AppMethodBeat.m2505o(137675);
    }

    public final boolean connect(URL url, Map<String, String> map) {
        AppMethodBeat.m2504i(137676);
        Logger.m71025i("MicroMsg.Music.MMMediaHTTPConnection", "connect");
        Logger.m71025i("MicroMsg.Music.MMMediaHTTPConnection", "connect: uri=" + url + ", headers=" + map);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.oOa = url;
        this.mHeaders = map;
        this.mTotalSize = -1;
        this.mMimeType = "";
        if (C4996ah.bqo()) {
            CharSequence SP;
            String url2 = this.mURL.toString();
            if (C39432e.bTG()) {
                SP = ((C21343c) C43329b.m77295ar(C21343c.class)).mo36784SP(url2);
            } else {
                C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                SP = null;
            }
            if (!(TextUtils.isEmpty(SP) || SP.equalsIgnoreCase(this.mURL.toString()))) {
                C4990ab.m7417i("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", SP);
                try {
                    this.mURL = new URL(SP);
                } catch (MalformedURLException e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", e, "playUrl", new Object[0]);
                }
            }
        }
        if (this.mURL != null) {
            C39433g.m67358r(this.mURL.toString(), map);
            Logger.m71025i("MicroMsg.Music.MMMediaHTTPConnection", "headers=".concat(String.valueOf(map)));
        }
        this.oNZ = new C28550a(this);
        C28550a c28550a = this.oNZ;
        String url3 = c28550a.oKV.oOa.toString();
        c28550a.oKW = new C28551d(url3);
        c28550a.oKW.gjQ = c28550a.oKV.getSize();
        C28551d c28551d = c28550a.oKW;
        C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "initData");
        if (c28551d.gjQ <= 0) {
            C4990ab.m7412e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
        } else {
            if (c28551d.gjQ % 8192 == 0 || c28551d.gjQ < 8192) {
                c28551d.count = (int) (c28551d.gjQ / 8192);
            } else {
                c28551d.count = ((int) (c28551d.gjQ / 8192)) + 1;
            }
            if (c28551d.gjQ <= 8192) {
                C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                c28551d.count = 1;
            }
            C4990ab.m7417i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", Long.valueOf(c28551d.gjQ), Integer.valueOf(c28551d.count));
            c28551d.oLc = new BitSet(c28551d.count);
            c28551d.cFI = C39433g.m67345SW(c28551d.mUrl);
            if (TextUtils.isEmpty(c28551d.cFI)) {
                C4990ab.m7412e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
            } else {
                C4990ab.m7417i("MicroMsg.Music.IndexBitMgr", "musicId:%s", c28551d.cFI);
                C9060h SQ = C39432e.m67338SQ(c28551d.cFI);
                if (SQ == null) {
                    C4990ab.m7412e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
                } else {
                    C4990ab.m7417i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", Integer.valueOf(SQ.fKw));
                    if (SQ.fKv == null || SQ.fKv.length == 0) {
                        C4990ab.m7412e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
                    } else {
                        c28551d.oLc = C12660a.m20651bb(SQ.fKv);
                        if (c28551d.oLc == null) {
                            C4990ab.m7412e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                            c28551d.oLc = new BitSet(c28551d.count);
                        } else if (c28551d.count < c28551d.oLc.cardinality()) {
                            C4990ab.m7413e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", Integer.valueOf(c28551d.count), Integer.valueOf(c28551d.oLc.cardinality()));
                            c28551d.clearCache();
                        } else if (SQ.fKy != 1) {
                            C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
                            if (c28551d.count > 1) {
                                c28551d.mo46618zA(c28551d.count - 1);
                                c28551d.mo46618zA(c28551d.count - 2);
                            } else {
                                c28551d.mo46618zA(c28551d.count - 1);
                            }
                            c28551d.mo46619zx(0);
                        }
                        C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + c28551d.oLc.toString());
                        C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + c28551d.count + "," + c28551d.oLc.cardinality());
                    }
                }
            }
        }
        c28550a.oKX = new C43322h(url3);
        if (!new File(c28550a.oKX.fileName).exists()) {
            C4990ab.m7416i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
            c28550a.oKW.clearCache();
        } else if (c28550a.oKX.bTH() != c28550a.oKV.getSize() && c28550a.oKV.getSize() != -1) {
            C4990ab.m7416i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
            c28550a.oKW.clearCache();
            C43322h c43322h = c28550a.oKX;
            Logger.m71025i("MicroMsg.Music.PieceFileCache", "deleteFile");
            C43322h.m77263HS(c43322h.fileName);
        } else if (c28550a.oKV.getSize() == -1) {
            C4990ab.m7416i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
        } else {
            C4990ab.m7416i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
        }
        long size = c28550a.oKV.getSize();
        C43322h c43322h2 = c28550a.oKX;
        Logger.m71025i("MicroMsg.Music.PieceFileCache", "open");
        try {
            File file = new File(c43322h2.fileName);
            if (!file.exists()) {
                C4990ab.m7417i("MicroMsg.Music.PieceFileCache", "create file:%b", Boolean.valueOf(file.createNewFile()));
            }
            c43322h2.randomAccessFile = new RandomAccessFile(file, "rws");
            Logger.m71023e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", c43322h2.fileName);
        } catch (FileNotFoundException e2) {
            Logger.m71022e("MicroMsg.Music.PieceFileCache", "file not found", e2);
            Logger.m71023e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", c43322h2.fileName);
        } catch (IOException e22) {
            Logger.m71022e("MicroMsg.Music.PieceFileCache", "io ", e22);
            Logger.m71023e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", c43322h2.fileName);
        } catch (Throwable th) {
            Logger.m71023e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", c43322h2.fileName);
            AppMethodBeat.m2505o(137676);
        }
        c28550a.oKX.setLength(size);
        C39433g.m67353ah(url3, size);
        C4990ab.m7416i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + size + ",pieceFileCache length is " + c28550a.oKX.getLength());
        String mIMEType = c28550a.oKV.getMIMEType();
        if (!(TextUtils.isEmpty(mIMEType) || "application/octet-stream".equalsIgnoreCase(mIMEType))) {
            C39433g.m67357fo(url3, mIMEType);
        }
        c28550a.f13697Lp = -1;
        c28550a.mSize = 0;
        c28550a.oKY = -1;
        c28550a.oKZ = 0;
        AppMethodBeat.m2505o(137676);
        return true;
    }

    public final void disconnect() {
        AppMethodBeat.m2504i(137677);
        Logger.m71025i("MicroMsg.Music.MMMediaHTTPConnection", "disconnect");
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        if (this.oNZ != null) {
            C28550a c28550a = this.oNZ;
            c28550a.bTx();
            c28550a.oKW.bTE();
            c28550a.oKX.close();
            c28550a.oKV = null;
            C4990ab.m7416i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
            this.oNZ = null;
        }
        AppMethodBeat.m2505o(137677);
    }

    private void teardownConnection() {
        AppMethodBeat.m2504i(137678);
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
        AppMethodBeat.m2505o(137678);
    }

    private static final boolean isLocalHost(URL url) {
        AppMethodBeat.m2504i(137679);
        if (url == null) {
            AppMethodBeat.m2505o(137679);
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            AppMethodBeat.m2505o(137679);
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                AppMethodBeat.m2505o(137679);
                return true;
            }
        } catch (IllegalArgumentException e) {
            Logger.m71023e("MicroMsg.Music.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", String.valueOf(e));
        }
        AppMethodBeat.m2505o(137679);
        return false;
    }

    /* JADX WARNING: Missing block: B:80:0x01eb, code skipped:
            if (r11.mAllowCrossDomainRedirect == false) goto L_0x01f5;
     */
    /* JADX WARNING: Missing block: B:81:0x01ed, code skipped:
            r11.mURL = r11.mConnection.getURL();
     */
    /* JADX WARNING: Missing block: B:83:0x01f7, code skipped:
            if (r1 != 206) goto L_0x0255;
     */
    /* JADX WARNING: Missing block: B:84:0x01f9, code skipped:
            r0 = r11.mConnection.getHeaderField("Content-Range");
            r11.mTotalSize = -1;
     */
    /* JADX WARNING: Missing block: B:85:0x0206, code skipped:
            if (r0 == null) goto L_0x021e;
     */
    /* JADX WARNING: Missing block: B:86:0x0208, code skipped:
            r2 = r0.lastIndexOf(47);
     */
    /* JADX WARNING: Missing block: B:87:0x020e, code skipped:
            if (r2 < 0) goto L_0x021e;
     */
    /* JADX WARNING: Missing block: B:91:?, code skipped:
            r11.mTotalSize = com.tencent.p177mm.sdk.platformtools.C5046bo.getLong(r0.substring(r2 + 1), 0);
     */
    /* JADX WARNING: Missing block: B:103:0x0257, code skipped:
            if (r1 == 200) goto L_0x0265;
     */
    /* JADX WARNING: Missing block: B:104:0x0259, code skipped:
            r0 = new java.io.IOException();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(137680);
     */
    /* JADX WARNING: Missing block: B:105:0x0264, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:106:0x0265, code skipped:
            r11.mTotalSize = (long) r11.mConnection.getContentLength();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekTo(long j) {
        Object e;
        AppMethodBeat.m2504i(137680);
        teardownConnection();
        int i = 0;
        try {
            URL url = this.mURL;
            boolean isLocalHost = C34584a.isLocalHost(url);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (isLocalHost) {
                    try {
                        this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                    } catch (IOException e2) {
                        e = e2;
                        i = i3;
                        this.mTotalSize = -1;
                        this.mInputStream = null;
                        this.mConnection = null;
                        this.mCurrentOffset = -1;
                        Logger.m71023e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", e + ", response:" + i);
                        AppMethodBeat.m2505o(137680);
                        throw e;
                    }
                }
                this.mConnection = (HttpURLConnection) url.openConnection();
                this.mConnection.setConnectTimeout(30000);
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                String str = "Accept-Encoding";
                Object obj = null;
                if (this.mHeaders != null) {
                    for (Entry entry : this.mHeaders.entrySet()) {
                        this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        if (obj == null && str.equals(entry.getKey())) {
                            e = 1;
                        } else {
                            e = obj;
                        }
                        obj = e;
                    }
                }
                if (j > 0) {
                    this.mConnection.setRequestProperty("Range", "bytes=" + j + "-");
                }
                if (obj == null) {
                    this.mConnection.setRequestProperty(str, "");
                }
                i = this.mConnection.getResponseCode();
                C39433g.m67354cI(this.oOa.toString(), i);
                if (i != 300 && i != 301 && i != 302 && i != 303 && i != 307) {
                    break;
                }
                int i4 = i2 + 1;
                NoRouteToHostException noRouteToHostException;
                if (i4 > 20) {
                    noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i4)));
                    AppMethodBeat.m2505o(137680);
                    throw noRouteToHostException;
                }
                String requestMethod = this.mConnection.getRequestMethod();
                if (i != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
                    String headerField = this.mConnection.getHeaderField("Location");
                    if (headerField == null) {
                        noRouteToHostException = new NoRouteToHostException("Invalid redirect");
                        AppMethodBeat.m2505o(137680);
                        throw noRouteToHostException;
                    }
                    url = new URL(this.mURL, headerField);
                    if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                        boolean equals = this.mURL.getProtocol().equals(url.getProtocol());
                        if (this.mAllowCrossProtocolRedirect || equals) {
                            equals = this.mURL.getHost().equals(url.getHost());
                            if (this.mAllowCrossDomainRedirect || equals) {
                                if (i != 307) {
                                    this.mURL = url;
                                }
                                i2 = i4;
                                i3 = i;
                            } else {
                                noRouteToHostException = new NoRouteToHostException("Cross-domain redirects are disallowed");
                                AppMethodBeat.m2505o(137680);
                                throw noRouteToHostException;
                            }
                        }
                        noRouteToHostException = new NoRouteToHostException("Cross-protocol redirects are disallowed");
                        AppMethodBeat.m2505o(137680);
                        throw noRouteToHostException;
                    }
                    noRouteToHostException = new NoRouteToHostException("Unsupported protocol redirect");
                    AppMethodBeat.m2505o(137680);
                    throw noRouteToHostException;
                }
                noRouteToHostException = new NoRouteToHostException("Invalid redirect");
                AppMethodBeat.m2505o(137680);
                throw noRouteToHostException;
            }
            if (TextUtils.isEmpty(this.mMimeType)) {
                this.mMimeType = this.mConnection.getContentType();
                C4990ab.m7417i("MicroMsg.Music.MMMediaHTTPConnection", "mimeType:", this.mMimeType);
            }
            if (j <= 0 || i == 206) {
                this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                this.mCurrentOffset = j;
                AppMethodBeat.m2505o(137680);
                return;
            }
            ProtocolException protocolException = new ProtocolException();
            AppMethodBeat.m2505o(137680);
            throw protocolException;
        } catch (IOException e3) {
            e = e3;
            this.mTotalSize = -1;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1;
            Logger.m71023e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", e + ", response:" + i);
            AppMethodBeat.m2505o(137680);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049 A:{Catch:{ ProtocolException -> 0x00aa, NoRouteToHostException -> 0x01d9, UnknownServiceException -> 0x0246, IOException -> 0x02b9, Exception -> 0x033d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(137681);
        if (i2 > this.oOb.length) {
            this.oOb = new byte[i2];
        }
        Arrays.fill(this.oOb, 0, this.oOb.length, (byte) 0);
        try {
            C28550a c28550a;
            byte[] bArr2;
            int i3;
            int size;
            if (this.oNZ != null) {
                c28550a = this.oNZ;
                bArr2 = this.oOb;
                i3 = (int) j;
                if (bArr2 == null || i3 < 0 || i2 < 0) {
                    C4990ab.m7413e("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", Integer.valueOf(i3), Integer.valueOf(i2));
                } else if (c28550a.oKV.getSize() <= 0) {
                    C4990ab.m7412e("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + c28550a.oKV.getSize());
                } else {
                    if (((long) (i3 + i2)) > c28550a.oKV.getSize()) {
                        C4990ab.m7413e("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", Integer.valueOf(i3), Integer.valueOf(i3 + i2), Long.valueOf(c28550a.oKV.getSize()));
                        size = ((int) c28550a.oKV.getSize()) - i3;
                    } else {
                        size = i2;
                    }
                    if (c28550a.oKW.mo46616eE(i3, size)) {
                        size = c28550a.oKX.mo68870b(bArr2, (long) i3, size);
                        if (size > 0) {
                            if (size != i2) {
                                Logger.m71025i("MicroMsg.Music.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                            }
                            System.arraycopy(this.oOb, 0, bArr, i, size);
                            AppMethodBeat.m2505o(137681);
                            return size;
                        }
                    }
                }
                size = -1;
                if (size > 0) {
                }
            }
            if (this.mTotalSize <= 0 || j < this.mTotalSize || i2 <= 0) {
                Logger.m71020d("MicroMsg.Music.MMMediaHTTPConnection", "read from network");
                if (j != this.mCurrentOffset) {
                    seekTo(j);
                }
                size = this.mInputStream.read(this.oOb, 0, i2);
                if (size == -1) {
                    size = 0;
                } else {
                    System.arraycopy(this.oOb, 0, bArr, i, size);
                }
                this.mCurrentOffset += (long) size;
                if (this.oNZ != null) {
                    c28550a = this.oNZ;
                    bArr2 = this.oOb;
                    i3 = (int) j;
                    if (bArr2 == null || i3 < 0 || size < 0) {
                        C4990ab.m7413e("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", Integer.valueOf(i3), Integer.valueOf(size));
                    } else if (c28550a.oKV.getSize() <= 0) {
                        C4990ab.m7412e("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + c28550a.oKV.getSize());
                    } else {
                        int i4 = i3 + size;
                        if (((long) i4) > c28550a.oKV.getSize()) {
                            C4990ab.m7413e("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", Integer.valueOf(i4), Long.valueOf(c28550a.oKV.getSize()));
                        } else {
                            if (c28550a.mo46611zu(i3) && c28550a.mo46611zu(i4)) {
                                if (!(c28550a.mo46612zv(i3) && c28550a.mo46612zv(i4))) {
                                    if (c28550a.mo46612zv(i3)) {
                                        c28550a.mo46610u(bArr2, i3, size);
                                        if (c28550a.mSize == 81920) {
                                            c28550a.bTx();
                                            c28550a.mo46613zw(i4);
                                        }
                                    } else {
                                        c28550a.bTx();
                                        c28550a.mo46613zw(i3);
                                        c28550a.mo46610u(bArr2, i3, size);
                                    }
                                }
                            } else if (c28550a.mo46611zu(i3) && !c28550a.mo46611zu(i4) && c28550a.mo46612zv(i3)) {
                                int i5 = 81920 - c28550a.mSize;
                                int i6 = size - i5;
                                if (i5 > 0) {
                                    c28550a.mo46610u(bArr2, i3, i5);
                                }
                                c28550a.bTx();
                                i3 += i5;
                                c28550a.mo46613zw(i3);
                                if (i6 > 0) {
                                    c28550a.mo46609d(bArr2, i5, i3, i6);
                                }
                            } else {
                                c28550a.bTx();
                                c28550a.mo46613zw(i3);
                                c28550a.mo46610u(bArr2, i3, size);
                            }
                            if (((long) i4) == c28550a.oKV.getSize()) {
                                c28550a.bTx();
                                c28550a.mo46613zw(i4);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(137681);
                return size;
            }
            C4990ab.m7413e("MicroMsg.Music.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", Long.valueOf(this.mTotalSize), Long.valueOf(j), Integer.valueOf(i2));
            AppMethodBeat.m2505o(137681);
            return 0;
        } catch (ProtocolException e) {
            Logger.m71021e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => " + e);
            C39433g.m67355cJ(this.oOa.toString(), 750);
            AppMethodBeat.m2505o(137681);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.m71021e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => " + e2);
            C39433g.m67355cJ(this.oOa.toString(), TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
            AppMethodBeat.m2505o(137681);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.m71021e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => " + e3);
            C39433g.m67355cJ(this.oOa.toString(), TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
            AppMethodBeat.m2505o(137681);
            return -1010;
        } catch (IOException e4) {
            Logger.m71021e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => -1 " + e4);
            C39433g.m67355cJ(this.oOa.toString(), 753);
            AppMethodBeat.m2505o(137681);
            return -1;
        } catch (Exception e5) {
            Logger.m71021e("MicroMsg.Music.MMMediaHTTPConnection", "unknown exception ".concat(String.valueOf(e5)));
            Logger.m71021e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => -1");
            C39433g.m67355cJ(this.oOa.toString(), 754);
            AppMethodBeat.m2505o(137681);
            return -1;
        }
    }

    public final long getSize() {
        AppMethodBeat.m2504i(137682);
        long j;
        if (this.mTotalSize > 0) {
            j = this.mTotalSize;
            AppMethodBeat.m2505o(137682);
            return j;
        } else if (C39433g.m67349Ta(this.oOa.toString()) > 0) {
            this.mTotalSize = C39433g.m67349Ta(this.oOa.toString());
            j = this.mTotalSize;
            AppMethodBeat.m2505o(137682);
            return j;
        } else {
            if (this.mConnection == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    seekTo(0);
                    C4990ab.m7411d("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (IOException e) {
                    Logger.m71023e("MicroMsg.Music.MMMediaHTTPConnection", "getSize exception:%s", String.valueOf(e));
                    this.mTotalSize = -1;
                }
            }
            if (this.mTotalSize > 0) {
                j = this.mTotalSize;
                AppMethodBeat.m2505o(137682);
                return j;
            } else if (C39433g.m67356ek(this.oOa.toString()) > 0) {
                this.mTotalSize = C39433g.m67356ek(this.oOa.toString());
                j = this.mTotalSize;
                AppMethodBeat.m2505o(137682);
                return j;
            } else {
                AppMethodBeat.m2505o(137682);
                return -1;
            }
        }
    }

    public final String getMIMEType() {
        AppMethodBeat.m2504i(137683);
        String SZ;
        if (TextUtils.isEmpty(this.mMimeType)) {
            SZ = C39433g.m67348SZ(this.oOa.toString());
            if (TextUtils.isEmpty(SZ)) {
                long currentTimeMillis;
                if (this.mConnection == null) {
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                        seekTo(0);
                        SZ = this.mConnection.getContentType();
                        C4990ab.m7411d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } catch (IOException e) {
                        Logger.m71023e("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType exception:%s", String.valueOf(e));
                        SZ = "";
                    }
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                    SZ = this.mConnection.getContentType();
                    Logger.m71025i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:".concat(String.valueOf(SZ)));
                    C4990ab.m7411d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                this.mMimeType = SZ;
                if (TextUtils.isEmpty(SZ)) {
                    SZ = C39433g.m67347SY(this.oOa.toString());
                    this.mMimeType = SZ;
                    if (TextUtils.isEmpty(SZ)) {
                        SZ = "application/octet-stream";
                        AppMethodBeat.m2505o(137683);
                        return SZ;
                    }
                    AppMethodBeat.m2505o(137683);
                    return SZ;
                }
                AppMethodBeat.m2505o(137683);
                return SZ;
            }
            this.mMimeType = SZ;
            AppMethodBeat.m2505o(137683);
            return SZ;
        }
        Logger.m71025i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:" + this.mMimeType);
        SZ = this.mMimeType;
        AppMethodBeat.m2505o(137683);
        return SZ;
    }

    public final String getUri() {
        AppMethodBeat.m2504i(137684);
        String url = this.mURL.toString();
        AppMethodBeat.m2505o(137684);
        return url;
    }
}

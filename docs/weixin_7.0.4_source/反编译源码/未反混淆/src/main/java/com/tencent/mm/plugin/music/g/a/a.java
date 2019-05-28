package com.tencent.mm.plugin.music.g.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.h;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
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

public final class a implements IMediaHTTPConnection {
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private String mMimeType = "";
    private long mTotalSize = -1;
    private URL mURL = null;
    private com.tencent.mm.plugin.music.cache.a oNZ;
    public URL oOa = null;
    private byte[] oOb = new byte[1];

    public a() {
        AppMethodBeat.i(137675);
        AppMethodBeat.o(137675);
    }

    public final boolean connect(URL url, Map<String, String> map) {
        AppMethodBeat.i(137676);
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect");
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect: uri=" + url + ", headers=" + map);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.oOa = url;
        this.mHeaders = map;
        this.mTotalSize = -1;
        this.mMimeType = "";
        if (ah.bqo()) {
            CharSequence SP;
            String url2 = this.mURL.toString();
            if (e.bTG()) {
                SP = ((c) b.ar(c.class)).SP(url2);
            } else {
                ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                SP = null;
            }
            if (!(TextUtils.isEmpty(SP) || SP.equalsIgnoreCase(this.mURL.toString()))) {
                ab.i("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", SP);
                try {
                    this.mURL = new URL(SP);
                } catch (MalformedURLException e) {
                    ab.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", e, "playUrl", new Object[0]);
                }
            }
        }
        if (this.mURL != null) {
            g.r(this.mURL.toString(), map);
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "headers=".concat(String.valueOf(map)));
        }
        this.oNZ = new com.tencent.mm.plugin.music.cache.a(this);
        com.tencent.mm.plugin.music.cache.a aVar = this.oNZ;
        String url3 = aVar.oKV.oOa.toString();
        aVar.oKW = new d(url3);
        aVar.oKW.gjQ = aVar.oKV.getSize();
        d dVar = aVar.oKW;
        ab.i("MicroMsg.Music.IndexBitMgr", "initData");
        if (dVar.gjQ <= 0) {
            ab.e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
        } else {
            if (dVar.gjQ % 8192 == 0 || dVar.gjQ < 8192) {
                dVar.count = (int) (dVar.gjQ / 8192);
            } else {
                dVar.count = ((int) (dVar.gjQ / 8192)) + 1;
            }
            if (dVar.gjQ <= 8192) {
                ab.i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                dVar.count = 1;
            }
            ab.i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", Long.valueOf(dVar.gjQ), Integer.valueOf(dVar.count));
            dVar.oLc = new BitSet(dVar.count);
            dVar.cFI = g.SW(dVar.mUrl);
            if (TextUtils.isEmpty(dVar.cFI)) {
                ab.e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
            } else {
                ab.i("MicroMsg.Music.IndexBitMgr", "musicId:%s", dVar.cFI);
                h SQ = e.SQ(dVar.cFI);
                if (SQ == null) {
                    ab.e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
                } else {
                    ab.i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", Integer.valueOf(SQ.fKw));
                    if (SQ.fKv == null || SQ.fKv.length == 0) {
                        ab.e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
                    } else {
                        dVar.oLc = com.tencent.mm.plugin.music.cache.d.a.bb(SQ.fKv);
                        if (dVar.oLc == null) {
                            ab.e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                            dVar.oLc = new BitSet(dVar.count);
                        } else if (dVar.count < dVar.oLc.cardinality()) {
                            ab.e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", Integer.valueOf(dVar.count), Integer.valueOf(dVar.oLc.cardinality()));
                            dVar.clearCache();
                        } else if (SQ.fKy != 1) {
                            ab.i("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
                            if (dVar.count > 1) {
                                dVar.zA(dVar.count - 1);
                                dVar.zA(dVar.count - 2);
                            } else {
                                dVar.zA(dVar.count - 1);
                            }
                            dVar.zx(0);
                        }
                        ab.i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + dVar.oLc.toString());
                        ab.i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + dVar.count + "," + dVar.oLc.cardinality());
                    }
                }
            }
        }
        aVar.oKX = new com.tencent.mm.plugin.music.cache.h(url3);
        if (!new File(aVar.oKX.fileName).exists()) {
            ab.i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
            aVar.oKW.clearCache();
        } else if (aVar.oKX.bTH() != aVar.oKV.getSize() && aVar.oKV.getSize() != -1) {
            ab.i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
            aVar.oKW.clearCache();
            com.tencent.mm.plugin.music.cache.h hVar = aVar.oKX;
            Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
            com.tencent.mm.plugin.music.cache.h.HS(hVar.fileName);
        } else if (aVar.oKV.getSize() == -1) {
            ab.i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
        } else {
            ab.i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
        }
        long size = aVar.oKV.getSize();
        com.tencent.mm.plugin.music.cache.h hVar2 = aVar.oKX;
        Logger.i("MicroMsg.Music.PieceFileCache", "open");
        try {
            File file = new File(hVar2.fileName);
            if (!file.exists()) {
                ab.i("MicroMsg.Music.PieceFileCache", "create file:%b", Boolean.valueOf(file.createNewFile()));
            }
            hVar2.randomAccessFile = new RandomAccessFile(file, "rws");
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
        } catch (FileNotFoundException e2) {
            Logger.e("MicroMsg.Music.PieceFileCache", "file not found", e2);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
        } catch (IOException e22) {
            Logger.e("MicroMsg.Music.PieceFileCache", "io ", e22);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
        } catch (Throwable th) {
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
            AppMethodBeat.o(137676);
        }
        aVar.oKX.setLength(size);
        g.ah(url3, size);
        ab.i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + size + ",pieceFileCache length is " + aVar.oKX.getLength());
        String mIMEType = aVar.oKV.getMIMEType();
        if (!(TextUtils.isEmpty(mIMEType) || "application/octet-stream".equalsIgnoreCase(mIMEType))) {
            g.fo(url3, mIMEType);
        }
        aVar.Lp = -1;
        aVar.mSize = 0;
        aVar.oKY = -1;
        aVar.oKZ = 0;
        AppMethodBeat.o(137676);
        return true;
    }

    public final void disconnect() {
        AppMethodBeat.i(137677);
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "disconnect");
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        if (this.oNZ != null) {
            com.tencent.mm.plugin.music.cache.a aVar = this.oNZ;
            aVar.bTx();
            aVar.oKW.bTE();
            aVar.oKX.close();
            aVar.oKV = null;
            ab.i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
            this.oNZ = null;
        }
        AppMethodBeat.o(137677);
    }

    private void teardownConnection() {
        AppMethodBeat.i(137678);
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
        AppMethodBeat.o(137678);
    }

    private static final boolean isLocalHost(URL url) {
        AppMethodBeat.i(137679);
        if (url == null) {
            AppMethodBeat.o(137679);
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            AppMethodBeat.o(137679);
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                AppMethodBeat.o(137679);
                return true;
            }
        } catch (IllegalArgumentException e) {
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", String.valueOf(e));
        }
        AppMethodBeat.o(137679);
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
            r11.mTotalSize = com.tencent.mm.sdk.platformtools.bo.getLong(r0.substring(r2 + 1), 0);
     */
    /* JADX WARNING: Missing block: B:103:0x0257, code skipped:
            if (r1 == 200) goto L_0x0265;
     */
    /* JADX WARNING: Missing block: B:104:0x0259, code skipped:
            r0 = new java.io.IOException();
            com.tencent.matrix.trace.core.AppMethodBeat.o(137680);
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
        AppMethodBeat.i(137680);
        teardownConnection();
        int i = 0;
        try {
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
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
                        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", e + ", response:" + i);
                        AppMethodBeat.o(137680);
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
                g.cI(this.oOa.toString(), i);
                if (i != 300 && i != 301 && i != 302 && i != 303 && i != 307) {
                    break;
                }
                int i4 = i2 + 1;
                NoRouteToHostException noRouteToHostException;
                if (i4 > 20) {
                    noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i4)));
                    AppMethodBeat.o(137680);
                    throw noRouteToHostException;
                }
                String requestMethod = this.mConnection.getRequestMethod();
                if (i != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
                    String headerField = this.mConnection.getHeaderField("Location");
                    if (headerField == null) {
                        noRouteToHostException = new NoRouteToHostException("Invalid redirect");
                        AppMethodBeat.o(137680);
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
                                AppMethodBeat.o(137680);
                                throw noRouteToHostException;
                            }
                        }
                        noRouteToHostException = new NoRouteToHostException("Cross-protocol redirects are disallowed");
                        AppMethodBeat.o(137680);
                        throw noRouteToHostException;
                    }
                    noRouteToHostException = new NoRouteToHostException("Unsupported protocol redirect");
                    AppMethodBeat.o(137680);
                    throw noRouteToHostException;
                }
                noRouteToHostException = new NoRouteToHostException("Invalid redirect");
                AppMethodBeat.o(137680);
                throw noRouteToHostException;
            }
            if (TextUtils.isEmpty(this.mMimeType)) {
                this.mMimeType = this.mConnection.getContentType();
                ab.i("MicroMsg.Music.MMMediaHTTPConnection", "mimeType:", this.mMimeType);
            }
            if (j <= 0 || i == 206) {
                this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                this.mCurrentOffset = j;
                AppMethodBeat.o(137680);
                return;
            }
            ProtocolException protocolException = new ProtocolException();
            AppMethodBeat.o(137680);
            throw protocolException;
        } catch (IOException e3) {
            e = e3;
            this.mTotalSize = -1;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1;
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", e + ", response:" + i);
            AppMethodBeat.o(137680);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049 A:{Catch:{ ProtocolException -> 0x00aa, NoRouteToHostException -> 0x01d9, UnknownServiceException -> 0x0246, IOException -> 0x02b9, Exception -> 0x033d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(137681);
        if (i2 > this.oOb.length) {
            this.oOb = new byte[i2];
        }
        Arrays.fill(this.oOb, 0, this.oOb.length, (byte) 0);
        try {
            com.tencent.mm.plugin.music.cache.a aVar;
            byte[] bArr2;
            int i3;
            int size;
            if (this.oNZ != null) {
                aVar = this.oNZ;
                bArr2 = this.oOb;
                i3 = (int) j;
                if (bArr2 == null || i3 < 0 || i2 < 0) {
                    ab.e("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", Integer.valueOf(i3), Integer.valueOf(i2));
                } else if (aVar.oKV.getSize() <= 0) {
                    ab.e("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + aVar.oKV.getSize());
                } else {
                    if (((long) (i3 + i2)) > aVar.oKV.getSize()) {
                        ab.e("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", Integer.valueOf(i3), Integer.valueOf(i3 + i2), Long.valueOf(aVar.oKV.getSize()));
                        size = ((int) aVar.oKV.getSize()) - i3;
                    } else {
                        size = i2;
                    }
                    if (aVar.oKW.eE(i3, size)) {
                        size = aVar.oKX.b(bArr2, (long) i3, size);
                        if (size > 0) {
                            if (size != i2) {
                                Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                            }
                            System.arraycopy(this.oOb, 0, bArr, i, size);
                            AppMethodBeat.o(137681);
                            return size;
                        }
                    }
                }
                size = -1;
                if (size > 0) {
                }
            }
            if (this.mTotalSize <= 0 || j < this.mTotalSize || i2 <= 0) {
                Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "read from network");
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
                    aVar = this.oNZ;
                    bArr2 = this.oOb;
                    i3 = (int) j;
                    if (bArr2 == null || i3 < 0 || size < 0) {
                        ab.e("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", Integer.valueOf(i3), Integer.valueOf(size));
                    } else if (aVar.oKV.getSize() <= 0) {
                        ab.e("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + aVar.oKV.getSize());
                    } else {
                        int i4 = i3 + size;
                        if (((long) i4) > aVar.oKV.getSize()) {
                            ab.e("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", Integer.valueOf(i4), Long.valueOf(aVar.oKV.getSize()));
                        } else {
                            if (aVar.zu(i3) && aVar.zu(i4)) {
                                if (!(aVar.zv(i3) && aVar.zv(i4))) {
                                    if (aVar.zv(i3)) {
                                        aVar.u(bArr2, i3, size);
                                        if (aVar.mSize == 81920) {
                                            aVar.bTx();
                                            aVar.zw(i4);
                                        }
                                    } else {
                                        aVar.bTx();
                                        aVar.zw(i3);
                                        aVar.u(bArr2, i3, size);
                                    }
                                }
                            } else if (aVar.zu(i3) && !aVar.zu(i4) && aVar.zv(i3)) {
                                int i5 = 81920 - aVar.mSize;
                                int i6 = size - i5;
                                if (i5 > 0) {
                                    aVar.u(bArr2, i3, i5);
                                }
                                aVar.bTx();
                                i3 += i5;
                                aVar.zw(i3);
                                if (i6 > 0) {
                                    aVar.d(bArr2, i5, i3, i6);
                                }
                            } else {
                                aVar.bTx();
                                aVar.zw(i3);
                                aVar.u(bArr2, i3, size);
                            }
                            if (((long) i4) == aVar.oKV.getSize()) {
                                aVar.bTx();
                                aVar.zw(i4);
                            }
                        }
                    }
                }
                AppMethodBeat.o(137681);
                return size;
            }
            ab.e("MicroMsg.Music.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", Long.valueOf(this.mTotalSize), Long.valueOf(j), Integer.valueOf(i2));
            AppMethodBeat.o(137681);
            return 0;
        } catch (ProtocolException e) {
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => " + e);
            g.cJ(this.oOa.toString(), 750);
            AppMethodBeat.o(137681);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => " + e2);
            g.cJ(this.oOa.toString(), TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
            AppMethodBeat.o(137681);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => " + e3);
            g.cJ(this.oOa.toString(), TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
            AppMethodBeat.o(137681);
            return -1010;
        } catch (IOException e4) {
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => -1 " + e4);
            g.cJ(this.oOa.toString(), 753);
            AppMethodBeat.o(137681);
            return -1;
        } catch (Exception e5) {
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "unknown exception ".concat(String.valueOf(e5)));
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + j + " / " + i2 + " => -1");
            g.cJ(this.oOa.toString(), 754);
            AppMethodBeat.o(137681);
            return -1;
        }
    }

    public final long getSize() {
        AppMethodBeat.i(137682);
        long j;
        if (this.mTotalSize > 0) {
            j = this.mTotalSize;
            AppMethodBeat.o(137682);
            return j;
        } else if (g.Ta(this.oOa.toString()) > 0) {
            this.mTotalSize = g.Ta(this.oOa.toString());
            j = this.mTotalSize;
            AppMethodBeat.o(137682);
            return j;
        } else {
            if (this.mConnection == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    seekTo(0);
                    ab.d("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (IOException e) {
                    Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getSize exception:%s", String.valueOf(e));
                    this.mTotalSize = -1;
                }
            }
            if (this.mTotalSize > 0) {
                j = this.mTotalSize;
                AppMethodBeat.o(137682);
                return j;
            } else if (g.ek(this.oOa.toString()) > 0) {
                this.mTotalSize = g.ek(this.oOa.toString());
                j = this.mTotalSize;
                AppMethodBeat.o(137682);
                return j;
            } else {
                AppMethodBeat.o(137682);
                return -1;
            }
        }
    }

    public final String getMIMEType() {
        AppMethodBeat.i(137683);
        String SZ;
        if (TextUtils.isEmpty(this.mMimeType)) {
            SZ = g.SZ(this.oOa.toString());
            if (TextUtils.isEmpty(SZ)) {
                long currentTimeMillis;
                if (this.mConnection == null) {
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                        seekTo(0);
                        SZ = this.mConnection.getContentType();
                        ab.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } catch (IOException e) {
                        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType exception:%s", String.valueOf(e));
                        SZ = "";
                    }
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                    SZ = this.mConnection.getContentType();
                    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:".concat(String.valueOf(SZ)));
                    ab.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                this.mMimeType = SZ;
                if (TextUtils.isEmpty(SZ)) {
                    SZ = g.SY(this.oOa.toString());
                    this.mMimeType = SZ;
                    if (TextUtils.isEmpty(SZ)) {
                        SZ = "application/octet-stream";
                        AppMethodBeat.o(137683);
                        return SZ;
                    }
                    AppMethodBeat.o(137683);
                    return SZ;
                }
                AppMethodBeat.o(137683);
                return SZ;
            }
            this.mMimeType = SZ;
            AppMethodBeat.o(137683);
            return SZ;
        }
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:" + this.mMimeType);
        SZ = this.mMimeType;
        AppMethodBeat.o(137683);
        return SZ;
    }

    public final String getUri() {
        AppMethodBeat.i(137684);
        String url = this.mURL.toString();
        AppMethodBeat.o(137684);
        return url;
    }
}

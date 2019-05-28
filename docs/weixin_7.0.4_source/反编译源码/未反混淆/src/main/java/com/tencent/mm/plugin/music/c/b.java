package com.tencent.mm.plugin.music.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.ttpic.device.DeviceUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements Runnable {
    public int clN = 0;
    public boolean isStop = true;
    public boolean mgU;
    public String mimeType = "";
    private String oLs = null;
    public e oLt;
    public a oLu;
    public float oLv;
    private long oLw = DeviceUtils.LOW_END_SCREEN_SIZE;
    public int oLx = -1;
    public b oLy;

    class a implements Runnable {
        int action;

        public final void run() {
            AppMethodBeat.i(137465);
            if (b.this.oLy != null) {
                b.this.oLy.zD(this.action);
            }
            AppMethodBeat.o(137465);
        }

        a(int i) {
            this.action = i;
        }
    }

    public interface b {
        void zD(int i);
    }

    public b(e eVar, a aVar) {
        boolean z = true;
        AppMethodBeat.i(137466);
        this.oLt = eVar;
        this.oLu = aVar;
        boolean z2 = aVar.oLn == 0 && aVar.oLo == 0 && aVar.endFlag == 0;
        boolean z3;
        if (aVar.oLp == 0 && aVar.oLr == 0 && aVar.oLq == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!(z2 && z3)) {
            z = false;
        }
        if (z) {
            ab.e("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
        } else {
            ab.i("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
        }
        this.mgU = at.isWifi(ah.getContext());
        AppMethodBeat.o(137466);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:439:0x0d92=Splitter:B:439:0x0d92, B:255:0x0895=Splitter:B:255:0x0895, B:355:0x0b6a=Splitter:B:355:0x0b6a, B:397:0x0c7e=Splitter:B:397:0x0c7e} */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x0ed7 A:{SYNTHETIC, Splitter:B:492:0x0ed7} */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x0edc A:{SYNTHETIC, Splitter:B:495:0x0edc} */
    /* JADX WARNING: Removed duplicated region for block: B:498:0x0ee1  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x08e5 A:{SYNTHETIC, Splitter:B:268:0x08e5} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x08ea A:{SYNTHETIC, Splitter:B:271:0x08ea} */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x08ef  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0bba A:{SYNTHETIC, Splitter:B:368:0x0bba} */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0bbf A:{SYNTHETIC, Splitter:B:371:0x0bbf} */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0bc4  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x0cce A:{SYNTHETIC, Splitter:B:410:0x0cce} */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0cd3 A:{SYNTHETIC, Splitter:B:413:0x0cd3} */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0cd8  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0de2 A:{SYNTHETIC, Splitter:B:452:0x0de2} */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x0de7 A:{SYNTHETIC, Splitter:B:455:0x0de7} */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0dec  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x08ba  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0adc  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0b07  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x08e5 A:{SYNTHETIC, Splitter:B:268:0x08e5} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x08ea A:{SYNTHETIC, Splitter:B:271:0x08ea} */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x08ef  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0b8f  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0bf1  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0bba A:{SYNTHETIC, Splitter:B:368:0x0bba} */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0bbf A:{SYNTHETIC, Splitter:B:371:0x0bbf} */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0bc4  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0ca3  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0d05  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0d2f  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x0cce A:{SYNTHETIC, Splitter:B:410:0x0cce} */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0cd3 A:{SYNTHETIC, Splitter:B:413:0x0cd3} */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0cd8  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x0db7  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0e19  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0e43  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0de2 A:{SYNTHETIC, Splitter:B:452:0x0de2} */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x0de7 A:{SYNTHETIC, Splitter:B:455:0x0de7} */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0dec  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0eac  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x0f0d  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0f37  */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x0ed7 A:{SYNTHETIC, Splitter:B:492:0x0ed7} */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x0edc A:{SYNTHETIC, Splitter:B:495:0x0edc} */
    /* JADX WARNING: Removed duplicated region for block: B:498:0x0ee1  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0eac  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x0f0d  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0f37  */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x0ed7 A:{SYNTHETIC, Splitter:B:492:0x0ed7} */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x0edc A:{SYNTHETIC, Splitter:B:495:0x0edc} */
    /* JADX WARNING: Removed duplicated region for block: B:498:0x0ee1  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0755 A:{SYNTHETIC, Splitter:B:199:0x0755} */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x075a A:{SYNTHETIC, Splitter:B:202:0x075a} */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x075f  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x08ba  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0adc  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0b07  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x08e5 A:{SYNTHETIC, Splitter:B:268:0x08e5} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x08ea A:{SYNTHETIC, Splitter:B:271:0x08ea} */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x08ef  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0b8f  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0bf1  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0bba A:{SYNTHETIC, Splitter:B:368:0x0bba} */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0bbf A:{SYNTHETIC, Splitter:B:371:0x0bbf} */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0bc4  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0ca3  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0d05  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0d2f  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x0cce A:{SYNTHETIC, Splitter:B:410:0x0cce} */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0cd3 A:{SYNTHETIC, Splitter:B:413:0x0cd3} */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0cd8  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x0db7  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0e19  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0e43  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0de2 A:{SYNTHETIC, Splitter:B:452:0x0de2} */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x0de7 A:{SYNTHETIC, Splitter:B:455:0x0de7} */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0dec  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0eac  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x0f0d  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0f37  */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x0ed7 A:{SYNTHETIC, Splitter:B:492:0x0ed7} */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x0edc A:{SYNTHETIC, Splitter:B:495:0x0edc} */
    /* JADX WARNING: Removed duplicated region for block: B:498:0x0ee1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Throwable e;
        AppMethodBeat.i(137468);
        if (this.isStop) {
            AppMethodBeat.o(137468);
            return;
        }
        String str = null;
        boolean isNetworkConnected = at.isNetworkConnected(ah.getContext());
        this.clN = 0;
        this.oLx = 0;
        com.tencent.mm.plugin.music.e.a aVar = k.bUf().oLX;
        if (isNetworkConnected) {
            boolean SX;
            long j;
            long j2;
            long j3;
            Object obj;
            if (this.mgU) {
                SX = g.SX(this.oLt.playUrl);
                if (aVar != null) {
                    str = aVar.Th(this.oLt.playUrl);
                }
                ab.i("MicroMsg.Music.MusicDownloadTask", "downloadUrl:%s", str);
                j = this.oLu.oLp;
                j2 = this.oLu.oLr;
                if (j2 != 0) {
                    this.oLw = j2 / 4;
                }
                if (j < this.oLw) {
                    j3 = this.oLw;
                } else {
                    j3 = (long) (((float) j) + (0.15f * ((float) this.oLu.oLr)));
                }
                obj = this.oLu.oLq == 1 ? 1 : null;
            } else {
                if (aVar != null) {
                    str = aVar.Th(this.oLt.playUrl);
                }
                ab.i("MicroMsg.Music.MusicDownloadTask", "downloadUrl:%s", str);
                SX = false;
                j = this.oLu.oLn;
                j2 = this.oLu.oLo;
                if (j2 != 0) {
                    this.oLw = j2 / 4;
                }
                if (j < this.oLw) {
                    j3 = this.oLw;
                } else {
                    j3 = (long) (((float) j) + (0.15f * ((float) this.oLu.oLo)));
                }
                obj = this.oLu.endFlag == 1 ? 1 : null;
            }
            if (this.oLw < 256000) {
                this.oLw = 256000;
                ab.i("MicroMsg.Music.MusicDownloadTask", "music firstTimeDownloadSize is less than startPlayLength, update firstTimeDownloadSize");
            }
            File file = new File(com.tencent.mm.plugin.music.h.b.aW(this.oLt.fJU, this.mgU));
            if (!file.exists()) {
                try {
                    ab.i("MicroMsg.Music.MusicDownloadTask", "create file:%b", Boolean.valueOf(file.createNewFile()));
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2, " createNewFile fail, path:%s", file.getAbsolutePath());
                }
                j = 0;
                j3 = this.oLw;
                obj = null;
                ab.i("MicroMsg.Music.MusicDownloadTask", "music file delete and create again %d", Long.valueOf(j3));
            }
            ab.i("MicroMsg.Music.MusicDownloadTask", "downloadLength=%d musicFile.Length=%d endRange=%d", Long.valueOf(j), Long.valueOf(file.length()), Long.valueOf(j3));
            if ((j >= this.oLw && this.oLv == 0.0f) || r3 != null) {
                ab.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.isStop = true;
                al.d(new a(1));
                AppMethodBeat.o(137468);
            } else if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.Music.MusicDownloadTask", "downloadUrl is null");
                this.isStop = true;
                al.d(new a(-2));
                AppMethodBeat.o(137468);
            } else {
                InputStream inputStream = null;
                RandomAccessFile randomAccessFile = null;
                RandomAccessFile randomAccessFile2;
                HttpURLConnection s;
                InputStream inputStream2;
                try {
                    if (file.exists()) {
                        randomAccessFile2 = new RandomAccessFile(file, "rws");
                        try {
                            ab.i("MicroMsg.Music.MusicDownloadTask", "create connection %s", str);
                            HashMap hashMap = new HashMap(10);
                            hashMap.put("Accept-Encoding", "gzip, deflate");
                            if (j3 > j) {
                                ab.d("MicroMsg.Music.MusicDownloadTask", "range : %d-%d", Long.valueOf(j), Long.valueOf(j3));
                                hashMap.put("range", "bytes=" + j + "-" + j3);
                            }
                            if (SX || com.tencent.mm.plugin.music.h.e.Tw(str)) {
                                ab.i("MicroMsg.Music.MusicDownloadTask", "set cookie");
                                hashMap.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
                                hashMap.put("referer", "stream12.qqmusic.qq.com");
                            }
                            hashMap.put("user-agent", System.getProperty("http.agent") + " Built-in music  MicroMessenger/" + com.tencent.mm.plugin.music.h.e.eE(ah.getContext()));
                            s = s(str, hashMap);
                            try {
                                int responseCode = s.getResponseCode();
                                if (responseCode == 200 || responseCode == 206) {
                                    String str2;
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "getResponseCode:%d", Integer.valueOf(responseCode));
                                    ab.d("MicroMsg.Music.MusicDownloadTask", "user-agent: " + s.getRequestProperty("user-agent"));
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "ContentType:%s", s.getContentType());
                                    this.mimeType = str;
                                    if (!TextUtils.isEmpty(this.mimeType) && TextUtils.isEmpty(this.oLu.mimeType)) {
                                        this.oLu.mimeType = this.mimeType;
                                        String str3 = this.oLt.fJU;
                                        str2 = this.mimeType;
                                        if (com.tencent.mm.plugin.music.cache.e.bTG()) {
                                            ((c) com.tencent.mm.plugin.music.f.c.b.ar(c.class)).fn(str3, str2);
                                        } else {
                                            ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                                        }
                                    }
                                    long[] Tg = Tg(s.getHeaderField("Content-Range"));
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "content-range: %s contentLen=%d", str2, Long.valueOf(bo.getLong(s.getHeaderField("Content-Length"), 0)));
                                    if (Tg == null) {
                                        ab.i("MicroMsg.Music.MusicDownloadTask", "not support range feature");
                                        if (j != 0) {
                                            j = 0;
                                        }
                                        j2 = r2;
                                    } else if (j <= 0 || j == Tg[0]) {
                                        j2 = Tg[2];
                                    } else {
                                        ab.e("MicroMsg.Music.MusicDownloadTask", "return http error, need to download again");
                                        zC(6);
                                        if (j2 == 0 && j > 0) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (IOException e3) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3, " music raf close fail", new Object[0]);
                                            }
                                            jn(j);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else if (j2 != 0 && j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            P(j, j2);
                                        } else if (j2 == 0 || j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        } else {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            jn(j2);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        }
                                        try {
                                            randomAccessFile2.close();
                                        } catch (IOException e32) {
                                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32, " music raf close fail", new Object[0]);
                                        }
                                        if (s != null) {
                                            s.disconnect();
                                        }
                                        this.isStop = true;
                                        ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        AppMethodBeat.o(137468);
                                        return;
                                    }
                                    long j4 = 10000000;
                                    if (j2 != 0) {
                                        j4 = j2;
                                    }
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "fileLen=%d downloadLength=%d", Long.valueOf(j4), Long.valueOf(j));
                                    randomAccessFile2.setLength(j4);
                                    randomAccessFile2.seek(j);
                                    inputStream2 = s.getInputStream();
                                    try {
                                        byte[] bArr = new byte[4096];
                                        while (!this.isStop) {
                                            int read = inputStream2.read(bArr);
                                            if (read <= 0) {
                                                ab.e("MicroMsg.Music.MusicDownloadTask", "read length:%d, isStop:%b, downloadLength:%d, realFileLength:%d", Integer.valueOf(read), Boolean.valueOf(this.isStop), Long.valueOf(j), Long.valueOf(j4));
                                                break;
                                            }
                                            randomAccessFile2.write(bArr, 0, read);
                                            j += (long) read;
                                            ab.v("MicroMsg.Music.MusicDownloadTask", "update updateCurrentDownloadLength %d %d", Long.valueOf(j), Long.valueOf(j4));
                                            if (this.mgU) {
                                                this.oLu.oLp = j;
                                                this.oLu.oLr = j4;
                                            } else {
                                                this.oLu.oLn = j;
                                                this.oLu.oLo = j4;
                                            }
                                            if (j >= 256000) {
                                                al.d(new a(1));
                                            }
                                        }
                                        if (j2 == 0 && j > 0) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (IOException e322) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e322, " music raf close fail", new Object[0]);
                                            }
                                            jn(j);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else if (j2 != 0 && j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            P(j, j2);
                                        } else if (j2 == 0 || j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        } else {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            jn(j2);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (IOException e3222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        try {
                                            randomAccessFile2.close();
                                        } catch (IOException e32222) {
                                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32222, " music raf close fail", new Object[0]);
                                        }
                                        if (s != null) {
                                            s.disconnect();
                                        }
                                        this.isStop = true;
                                        ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        AppMethodBeat.o(137468);
                                        return;
                                    } catch (ProtocolException e4) {
                                        e = e4;
                                        randomAccessFile = randomAccessFile2;
                                    } catch (NoRouteToHostException e5) {
                                        e = e5;
                                        inputStream = inputStream2;
                                        try {
                                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                            this.clN = TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA;
                                            zC(5);
                                            if (j2 != 0 && j > 0) {
                                                ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                                try {
                                                    randomAccessFile2.setLength(j);
                                                } catch (IOException e322222) {
                                                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e322222, " music raf close fail", new Object[0]);
                                                }
                                                jn(j);
                                                if (j < 256000) {
                                                    al.d(new a(1));
                                                }
                                            } else if (j2 == 0 && j != j2) {
                                                ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                                P(j, j2);
                                            } else if (j2 == 0 && j == j2) {
                                                ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                                jn(j2);
                                                if (j < 256000) {
                                                    al.d(new a(1));
                                                }
                                            } else {
                                                ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e3222222) {
                                                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3222222, " music is close fail", new Object[0]);
                                                }
                                            }
                                            if (randomAccessFile2 != null) {
                                                try {
                                                    randomAccessFile2.close();
                                                } catch (IOException e32222222) {
                                                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32222222, " music raf close fail", new Object[0]);
                                                }
                                            }
                                            if (s != null) {
                                                s.disconnect();
                                            }
                                            this.isStop = true;
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                            AppMethodBeat.o(137468);
                                        } catch (Throwable th) {
                                            e = th;
                                            if (j2 != 0) {
                                            }
                                            if (j2 == 0) {
                                            }
                                            if (j2 == 0) {
                                            }
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                            if (inputStream != null) {
                                            }
                                            if (randomAccessFile2 != null) {
                                            }
                                            if (s != null) {
                                            }
                                            this.isStop = true;
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                            AppMethodBeat.o(137468);
                                            throw e;
                                        }
                                    } catch (UnknownServiceException e6) {
                                        e = e6;
                                        inputStream = inputStream2;
                                        ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                        this.clN = TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
                                        zC(5);
                                        if (j2 != 0 && j > 0) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (IOException e322222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e322222222, " music raf close fail", new Object[0]);
                                            }
                                            jn(j);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else if (j2 == 0 && j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            P(j, j2);
                                        } else if (j2 == 0 && j == j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            jn(j2);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e3222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3222222222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile2 != null) {
                                            try {
                                                randomAccessFile2.close();
                                            } catch (IOException e32222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32222222222, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (s != null) {
                                            s.disconnect();
                                        }
                                        this.isStop = true;
                                        ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        AppMethodBeat.o(137468);
                                    } catch (IOException e7) {
                                        e = e7;
                                        inputStream = inputStream2;
                                        ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                        this.clN = 753;
                                        zC(5);
                                        if (j2 != 0 && j > 0) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (IOException e322222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e322222222222, " music raf close fail", new Object[0]);
                                            }
                                            jn(j);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else if (j2 == 0 && j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            P(j, j2);
                                        } else if (j2 == 0 && j == j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            jn(j2);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e3222222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3222222222222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile2 != null) {
                                            try {
                                                randomAccessFile2.close();
                                            } catch (IOException e32222222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32222222222222, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (s != null) {
                                            s.disconnect();
                                        }
                                        this.isStop = true;
                                        ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        AppMethodBeat.o(137468);
                                    } catch (Exception e8) {
                                        e = e8;
                                        inputStream = inputStream2;
                                        ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                        this.clN = 754;
                                        zC(5);
                                        if (j2 != 0 && j > 0) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (IOException e322222222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e322222222222222, " music raf close fail", new Object[0]);
                                            }
                                            jn(j);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else if (j2 == 0 && j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            P(j, j2);
                                        } else if (j2 == 0 && j == j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            jn(j2);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e3222222222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3222222222222222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile2 != null) {
                                            try {
                                                randomAccessFile2.close();
                                            } catch (IOException e32222222222222222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32222222222222222, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (s != null) {
                                            s.disconnect();
                                        }
                                        this.isStop = true;
                                        ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        AppMethodBeat.o(137468);
                                    } catch (Throwable th2) {
                                        e = th2;
                                        inputStream = inputStream2;
                                        if (j2 != 0 && j > 0) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (IOException e22) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22, " music raf close fail", new Object[0]);
                                            }
                                            jn(j);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else if (j2 == 0 && j != j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            P(j, j2);
                                        } else if (j2 == 0 && j == j2) {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                            jn(j2);
                                            if (j < 256000) {
                                                al.d(new a(1));
                                            }
                                        } else {
                                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile2 != null) {
                                            try {
                                                randomAccessFile2.close();
                                            } catch (IOException e2222) {
                                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (s != null) {
                                            s.disconnect();
                                        }
                                        this.isStop = true;
                                        ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        AppMethodBeat.o(137468);
                                        throw e;
                                    }
                                }
                                zB(responseCode);
                                ab.e("MicroMsg.Music.MusicDownloadTask", "music http req error responseCode:%d", Integer.valueOf(responseCode));
                                this.oLx = responseCode;
                                zC(-1);
                                if (j2 == 0 && j > 0) {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile2.setLength(j);
                                    } catch (IOException e322222222222222222) {
                                        ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e322222222222222222, " music raf close fail", new Object[0]);
                                    }
                                    jn(j);
                                    if (j < 256000) {
                                        al.d(new a(1));
                                    }
                                } else if (j2 != 0 && j != j2) {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                    P(j, j2);
                                } else if (j2 == 0 || j != j2) {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                } else {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                    jn(j2);
                                    if (j < 256000) {
                                        al.d(new a(1));
                                    }
                                }
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e3222222222222222222) {
                                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3222222222222222222, " music raf close fail", new Object[0]);
                                }
                                if (s != null) {
                                    s.disconnect();
                                }
                                this.isStop = true;
                                ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                AppMethodBeat.o(137468);
                                return;
                            } catch (ProtocolException e9) {
                                e = e9;
                                randomAccessFile = randomAccessFile2;
                                inputStream2 = null;
                            } catch (NoRouteToHostException e10) {
                                e = e10;
                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                this.clN = TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA;
                                zC(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream != null) {
                                }
                                if (randomAccessFile2 != null) {
                                }
                                if (s != null) {
                                }
                                this.isStop = true;
                                ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                AppMethodBeat.o(137468);
                            } catch (UnknownServiceException e11) {
                                e = e11;
                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                this.clN = TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
                                zC(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream != null) {
                                }
                                if (randomAccessFile2 != null) {
                                }
                                if (s != null) {
                                }
                                this.isStop = true;
                                ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                AppMethodBeat.o(137468);
                            } catch (IOException e12) {
                                e = e12;
                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                this.clN = 753;
                                zC(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream != null) {
                                }
                                if (randomAccessFile2 != null) {
                                }
                                if (s != null) {
                                }
                                this.isStop = true;
                                ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                AppMethodBeat.o(137468);
                            } catch (Exception e13) {
                                e = e13;
                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                this.clN = 754;
                                zC(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream != null) {
                                }
                                if (randomAccessFile2 != null) {
                                }
                                if (s != null) {
                                }
                                this.isStop = true;
                                ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                AppMethodBeat.o(137468);
                            }
                        } catch (ProtocolException e14) {
                            e = e14;
                            randomAccessFile = randomAccessFile2;
                            inputStream2 = null;
                            s = null;
                            try {
                                ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                                this.clN = 750;
                                zC(5);
                                if (j2 != 0 && j > 0) {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile.setLength(j);
                                    } catch (IOException e32222222222222222222) {
                                        ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                    jn(j);
                                    if (j < 256000) {
                                        al.d(new a(1));
                                    }
                                } else if (j2 == 0 && j != j2) {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                    P(j, j2);
                                } else if (j2 == 0 && j == j2) {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                                    jn(j2);
                                    if (j < 256000) {
                                        al.d(new a(1));
                                    }
                                } else {
                                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e322222222222222222222) {
                                        ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e322222222222222222222, " music is close fail", new Object[0]);
                                    }
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e3222222222222222222222) {
                                        ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e3222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                }
                                if (s != null) {
                                    s.disconnect();
                                }
                                this.isStop = true;
                                ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                AppMethodBeat.o(137468);
                            } catch (Throwable th3) {
                                e = th3;
                                randomAccessFile2 = randomAccessFile;
                                inputStream = inputStream2;
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream != null) {
                                }
                                if (randomAccessFile2 != null) {
                                }
                                if (s != null) {
                                }
                                this.isStop = true;
                                ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                AppMethodBeat.o(137468);
                                throw e;
                            }
                        } catch (NoRouteToHostException e15) {
                            e = e15;
                            s = null;
                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                            this.clN = TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA;
                            zC(5);
                            if (j2 != 0) {
                            }
                            if (j2 == 0) {
                            }
                            if (j2 == 0) {
                            }
                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            if (inputStream != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                            if (s != null) {
                            }
                            this.isStop = true;
                            ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            AppMethodBeat.o(137468);
                        } catch (UnknownServiceException e16) {
                            e = e16;
                            s = null;
                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                            this.clN = TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
                            zC(5);
                            if (j2 != 0) {
                            }
                            if (j2 == 0) {
                            }
                            if (j2 == 0) {
                            }
                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            if (inputStream != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                            if (s != null) {
                            }
                            this.isStop = true;
                            ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            AppMethodBeat.o(137468);
                        } catch (IOException e17) {
                            e = e17;
                            s = null;
                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                            this.clN = 753;
                            zC(5);
                            if (j2 != 0) {
                            }
                            if (j2 == 0) {
                            }
                            if (j2 == 0) {
                            }
                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            if (inputStream != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                            if (s != null) {
                            }
                            this.isStop = true;
                            ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            AppMethodBeat.o(137468);
                        } catch (Exception e18) {
                            e = e18;
                            s = null;
                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                            this.clN = 754;
                            zC(5);
                            if (j2 != 0) {
                            }
                            if (j2 == 0) {
                            }
                            if (j2 == 0) {
                            }
                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            if (inputStream != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                            if (s != null) {
                            }
                            this.isStop = true;
                            ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            AppMethodBeat.o(137468);
                        } catch (Throwable th4) {
                            e = th4;
                            s = null;
                            if (j2 != 0) {
                            }
                            if (j2 == 0) {
                            }
                            if (j2 == 0) {
                            }
                            ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            if (inputStream != null) {
                            }
                            if (randomAccessFile2 != null) {
                            }
                            if (s != null) {
                            }
                            this.isStop = true;
                            ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            AppMethodBeat.o(137468);
                            throw e;
                        }
                    }
                    this.isStop = true;
                    ab.e("MicroMsg.Music.MusicDownloadTask", "create fail or musicFile not exist, musicFile:%s", file.getAbsolutePath());
                    zC(19);
                    if (j2 == 0 && j > 0) {
                        ab.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                        RandomAccessFile randomAccessFile3 = null;
                        try {
                            randomAccessFile3.setLength(j);
                        } catch (IOException e32222222222222222222222) {
                            ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e32222222222222222222222, " music raf close fail", new Object[0]);
                        }
                        jn(j);
                        if (j < 256000) {
                            al.d(new a(1));
                        }
                    } else if (j2 != 0 && j != j2) {
                        ab.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                        P(j, j2);
                    } else if (j2 == 0 || j != j2) {
                        ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                    } else {
                        ab.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", Long.valueOf(j2), Long.valueOf(j));
                        jn(j2);
                        if (j < 256000) {
                            al.d(new a(1));
                        }
                    }
                    this.isStop = true;
                    ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    AppMethodBeat.o(137468);
                } catch (ProtocolException e19) {
                    e = e19;
                    inputStream2 = null;
                    s = null;
                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                    this.clN = 750;
                    zC(5);
                    if (j2 != 0) {
                    }
                    if (j2 == 0) {
                    }
                    if (j2 == 0) {
                    }
                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                    if (inputStream2 != null) {
                    }
                    if (randomAccessFile != null) {
                    }
                    if (s != null) {
                    }
                    this.isStop = true;
                    ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    AppMethodBeat.o(137468);
                } catch (NoRouteToHostException e20) {
                    e = e20;
                    randomAccessFile2 = null;
                    s = null;
                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                    this.clN = TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA;
                    zC(5);
                    if (j2 != 0) {
                    }
                    if (j2 == 0) {
                    }
                    if (j2 == 0) {
                    }
                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                    if (inputStream != null) {
                    }
                    if (randomAccessFile2 != null) {
                    }
                    if (s != null) {
                    }
                    this.isStop = true;
                    ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    AppMethodBeat.o(137468);
                } catch (UnknownServiceException e21) {
                    e = e21;
                    randomAccessFile2 = null;
                    s = null;
                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                    this.clN = TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
                    zC(5);
                    if (j2 != 0) {
                    }
                    if (j2 == 0) {
                    }
                    if (j2 == 0) {
                    }
                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                    if (inputStream != null) {
                    }
                    if (randomAccessFile2 != null) {
                    }
                    if (s != null) {
                    }
                    this.isStop = true;
                    ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    AppMethodBeat.o(137468);
                } catch (IOException e23) {
                    e = e23;
                    randomAccessFile2 = null;
                    s = null;
                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                    this.clN = 753;
                    zC(5);
                    if (j2 != 0) {
                    }
                    if (j2 == 0) {
                    }
                    if (j2 == 0) {
                    }
                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                    if (inputStream != null) {
                    }
                    if (randomAccessFile2 != null) {
                    }
                    if (s != null) {
                    }
                    this.isStop = true;
                    ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    AppMethodBeat.o(137468);
                } catch (Exception e24) {
                    e = e24;
                    randomAccessFile2 = null;
                    s = null;
                    ab.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e, " download  music file fail, :%s", file.getAbsolutePath());
                    this.clN = 754;
                    zC(5);
                    if (j2 != 0) {
                    }
                    if (j2 == 0) {
                    }
                    if (j2 == 0) {
                    }
                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                    if (inputStream != null) {
                    }
                    if (randomAccessFile2 != null) {
                    }
                    if (s != null) {
                    }
                    this.isStop = true;
                    ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    AppMethodBeat.o(137468);
                } catch (Throwable th5) {
                    e = th5;
                    randomAccessFile2 = null;
                    s = null;
                    if (j2 != 0) {
                    }
                    if (j2 == 0) {
                    }
                    if (j2 == 0) {
                    }
                    ab.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                    if (inputStream != null) {
                    }
                    if (randomAccessFile2 != null) {
                    }
                    if (s != null) {
                    }
                    this.isStop = true;
                    ab.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    AppMethodBeat.o(137468);
                    throw e;
                }
            }
        } else if (this.oLu.oLp != 0 && ((this.oLu.oLp >= this.oLw || this.oLu.oLp == this.oLu.oLr) && (((float) this.oLu.oLp) / ((float) this.oLu.oLr)) - this.oLv >= 0.15f)) {
            ab.i("MicroMsg.Music.MusicDownloadTask", "can start play");
            this.isStop = true;
            this.mgU = true;
            al.d(new a(1));
            AppMethodBeat.o(137468);
        } else if (this.oLu.oLn == 0 || ((this.oLu.oLn < this.oLw && this.oLu.oLn != this.oLu.oLo) || (((float) this.oLu.oLn) / ((float) this.oLu.oLo)) - this.oLv < 0.15f)) {
            ab.i("MicroMsg.Music.MusicDownloadTask", "not connect network");
            this.isStop = true;
            zC(4);
            AppMethodBeat.o(137468);
        } else {
            ab.i("MicroMsg.Music.MusicDownloadTask", "can start play");
            this.isStop = true;
            this.mgU = false;
            al.d(new a(1));
            AppMethodBeat.o(137468);
        }
    }

    private HttpURLConnection s(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        int i;
        AppMethodBeat.i(137469);
        if (TextUtils.isEmpty(this.oLs)) {
            httpURLConnection = null;
            i = 0;
        } else {
            ab.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
            str = this.oLs;
            httpURLConnection = null;
            i = 0;
        }
        while (true) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            ab.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", str);
            com.tencent.mm.plugin.music.e.a aVar = k.bUf().oLX;
            URL url = new URL(str);
            if (aVar != null) {
                url = aVar.Ti(str);
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(25000);
            httpURLConnection.setInstanceFollowRedirects(false);
            for (Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int responseCode = httpURLConnection.getResponseCode();
            ab.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", Integer.valueOf(responseCode), Integer.valueOf(i));
            if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                zB(responseCode);
                String requestMethod = httpURLConnection.getRequestMethod();
                if (responseCode == 307 && !requestMethod.equals("GET") && !requestMethod.equals("HEAD")) {
                    AppMethodBeat.o(137469);
                    break;
                }
                requestMethod = httpURLConnection.getHeaderField("Location");
                if (requestMethod != null) {
                    URL url2 = new URL(httpURLConnection.getURL(), requestMethod);
                    ab.i("MicroMsg.Music.MusicDownloadTask", "location:%s", requestMethod);
                    ab.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", url2.toString());
                    if (!url2.getProtocol().equals("https") && !url2.getProtocol().equals("http")) {
                        ab.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", Integer.valueOf(responseCode));
                        AppMethodBeat.o(137469);
                        break;
                    }
                    responseCode = i + 1;
                    if (responseCode > 5) {
                        ab.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: ".concat(String.valueOf(responseCode)));
                        AppMethodBeat.o(137469);
                        break;
                    }
                    str = url2.toString();
                    this.oLs = str;
                    i = responseCode;
                } else {
                    ab.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", Integer.valueOf(responseCode));
                    AppMethodBeat.o(137469);
                    break;
                }
            }
            if (!(responseCode == 200 || responseCode == 206)) {
                this.oLs = null;
            }
            AppMethodBeat.o(137469);
        }
        return httpURLConnection;
    }

    private static void zB(int i) {
        AppMethodBeat.i(137470);
        d dVar = (d) com.tencent.mm.plugin.music.f.c.b.ar(d.class);
        if (dVar != null) {
            dVar.zG(i);
        }
        AppMethodBeat.o(137470);
    }

    private void zC(int i) {
        AppMethodBeat.i(137471);
        this.oLs = null;
        al.d(new a(i));
        AppMethodBeat.o(137471);
    }

    private void jn(long j) {
        AppMethodBeat.i(137472);
        if (this.mgU) {
            this.oLu.oLp = j;
            this.oLu.oLq = 1;
            this.oLu.oLr = j;
            com.tencent.mm.plugin.music.cache.e.a(this.oLt.fJU, this.oLu);
        } else {
            this.oLu.oLn = j;
            this.oLu.endFlag = 1;
            this.oLu.oLo = j;
            com.tencent.mm.plugin.music.cache.e.a(this.oLt.fJU, this.oLu);
        }
        al.d(new a(2));
        AppMethodBeat.o(137472);
    }

    private void P(long j, long j2) {
        AppMethodBeat.i(137473);
        if (this.mgU) {
            this.oLu.oLp = j;
            this.oLu.oLq = 0;
            this.oLu.oLr = j2;
            com.tencent.mm.plugin.music.cache.e.a(this.oLt.fJU, this.oLu);
        } else {
            this.oLu.oLn = j;
            this.oLu.endFlag = 0;
            this.oLu.oLo = j2;
            com.tencent.mm.plugin.music.cache.e.a(this.oLt.fJU, this.oLu);
        }
        al.d(new a(3));
        AppMethodBeat.o(137473);
    }

    private static long[] Tg(String str) {
        AppMethodBeat.i(137474);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(137474);
            return null;
        }
        try {
            String[] split = str.replace("bytes", "").trim().split("-");
            long longValue = Long.valueOf(split[0]).longValue();
            split = split[1].split("/");
            long longValue2 = Long.valueOf(split[0]).longValue();
            long longValue3 = Long.valueOf(split[1]).longValue();
            long[] jArr = new long[]{longValue, longValue2, longValue3};
            AppMethodBeat.o(137474);
            return jArr;
        } catch (Exception e) {
            AppMethodBeat.o(137474);
            return null;
        }
    }

    public final void start() {
        AppMethodBeat.i(137467);
        if (this.isStop) {
            this.isStop = false;
            com.tencent.mm.sdk.g.d.post(this, "music_download_thread");
            AppMethodBeat.o(137467);
            return;
        }
        AppMethodBeat.o(137467);
    }
}

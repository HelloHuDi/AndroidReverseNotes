package com.tencent.p177mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.music.cache.h */
public final class C43322h {
    public String fileName;
    private String mUrl;
    public RandomAccessFile randomAccessFile = null;

    public C43322h(String str) {
        AppMethodBeat.m2504i(137445);
        this.mUrl = str;
        this.fileName = C12673b.m20672Tv(this.mUrl);
        C4990ab.m7417i("MicroMsg.Music.PieceFileCache", "PieceFileCache mUrl:%s, fileName:%s,", this.mUrl, this.fileName);
        AppMethodBeat.m2505o(137445);
    }

    public final synchronized void close() {
        AppMethodBeat.m2504i(137446);
        Logger.m71025i("MicroMsg.Music.PieceFileCache", "close");
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
                AppMethodBeat.m2505o(137446);
            } catch (IOException e) {
                Logger.m71023e("MicroMsg.Music.PieceFileCache", "close RandomAccessFile error ", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(137446);
    }

    /* renamed from: b */
    public final synchronized int mo68870b(byte[] bArr, long j, int i) {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(137447);
            if (i == 0) {
                Logger.m71021e("MicroMsg.Music.PieceFileCache", "read error, length == 0");
                AppMethodBeat.m2505o(137447);
            } else if (this.randomAccessFile == null) {
                Logger.m71021e("MicroMsg.Music.PieceFileCache", "read error, randomAccessFile is null");
                AppMethodBeat.m2505o(137447);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    i2 = this.randomAccessFile.read(bArr, 0, i);
                    AppMethodBeat.m2505o(137447);
                } catch (IOException e) {
                    Logger.m71021e("MicroMsg.Music.PieceFileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.m2505o(137447);
                }
            }
        }
        return i2;
    }

    /* renamed from: c */
    public final synchronized boolean mo68872c(byte[] bArr, long j, int i) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(137448);
            if (i == 0) {
                Logger.m71021e("MicroMsg.Music.PieceFileCache", "write error, length == 0");
                AppMethodBeat.m2505o(137448);
            } else if (this.randomAccessFile == null) {
                Logger.m71021e("MicroMsg.Music.PieceFileCache", "write error, randomAccessFile is null");
                AppMethodBeat.m2505o(137448);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    this.randomAccessFile.write(bArr, 0, i);
                    AppMethodBeat.m2505o(137448);
                    z = true;
                } catch (IOException e) {
                    Logger.m71021e("MicroMsg.Music.PieceFileCache", String.format("Error writing %d bytes to from buffer with size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.m2505o(137448);
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(137449);
            if (this.randomAccessFile == null) {
                Logger.m71021e("MicroMsg.Music.PieceFileCache", "getLength error, randomAccessFile is null");
                AppMethodBeat.m2505o(137449);
            } else {
                try {
                    i = (int) this.randomAccessFile.length();
                    AppMethodBeat.m2505o(137449);
                } catch (IOException e) {
                    Logger.m71023e("MicroMsg.Music.PieceFileCache", "Error get length of file , err %s", e.getMessage());
                    AppMethodBeat.m2505o(137449);
                }
            }
        }
        return i;
    }

    public final synchronized void setLength(long j) {
        AppMethodBeat.m2504i(137450);
        if (this.randomAccessFile == null) {
            Logger.m71021e("MicroMsg.Music.PieceFileCache", "setLength error, randomAccessFile is null");
            AppMethodBeat.m2505o(137450);
        } else if (j <= 0) {
            Logger.m71021e("MicroMsg.Music.PieceFileCache", "setLength error, length is ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(137450);
        } else {
            Logger.m71023e("MicroMsg.Music.PieceFileCache", "set file length %s ", String.valueOf(j));
            try {
                this.randomAccessFile.setLength(j);
                AppMethodBeat.m2505o(137450);
            } catch (IOException e) {
                Logger.m71023e("MicroMsg.Music.PieceFileCache", "Error set length of file, err %s", e.getMessage());
                AppMethodBeat.m2505o(137450);
            }
        }
    }

    public final synchronized long bTH() {
        long length;
        AppMethodBeat.m2504i(137451);
        File file = new File(this.fileName);
        if (file.exists()) {
            length = file.length();
            AppMethodBeat.m2505o(137451);
        } else {
            length = -1;
            AppMethodBeat.m2505o(137451);
        }
        return length;
    }

    /* renamed from: ek */
    public static long m77266ek(String str) {
        AppMethodBeat.m2504i(137452);
        File file = new File(C12673b.m20672Tv(str));
        if (file.exists()) {
            long length = file.length();
            AppMethodBeat.m2505o(137452);
            return length;
        }
        AppMethodBeat.m2505o(137452);
        return -1;
    }

    /* renamed from: HS */
    public static void m77263HS(String str) {
        AppMethodBeat.m2504i(137453);
        Logger.m71025i("MicroMsg.Music.PieceFileCache", "deleteFile, fileName:".concat(String.valueOf(str)));
        File file = new File(str);
        if (file.exists()) {
            Logger.m71025i("MicroMsg.Music.PieceFileCache", "delete the piece File");
            file.delete();
            AppMethodBeat.m2505o(137453);
            return;
        }
        Logger.m71021e("MicroMsg.Music.PieceFileCache", "file not exist, delete piece File fail");
        AppMethodBeat.m2505o(137453);
    }

    /* renamed from: Td */
    public static boolean m77264Td(String str) {
        AppMethodBeat.m2504i(137454);
        Logger.m71025i("MicroMsg.Music.PieceFileCache", "existFileByUrl");
        boolean Te = C43322h.m77265Te(C12673b.m20672Tv(str));
        AppMethodBeat.m2505o(137454);
        return Te;
    }

    /* renamed from: Te */
    private static boolean m77265Te(String str) {
        AppMethodBeat.m2504i(137455);
        Logger.m71025i("MicroMsg.Music.PieceFileCache", "existFile, fileName:".concat(String.valueOf(str)));
        C4990ab.m7417i("MicroMsg.Music.PieceFileCache", "the piece File exist:%b", Boolean.valueOf(new File(str).exists()));
        AppMethodBeat.m2505o(137455);
        return new File(str).exists();
    }
}

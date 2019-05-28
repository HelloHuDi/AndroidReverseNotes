package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class h {
    public String fileName;
    private String mUrl;
    public RandomAccessFile randomAccessFile = null;

    public h(String str) {
        AppMethodBeat.i(137445);
        this.mUrl = str;
        this.fileName = b.Tv(this.mUrl);
        ab.i("MicroMsg.Music.PieceFileCache", "PieceFileCache mUrl:%s, fileName:%s,", this.mUrl, this.fileName);
        AppMethodBeat.o(137445);
    }

    public final synchronized void close() {
        AppMethodBeat.i(137446);
        Logger.i("MicroMsg.Music.PieceFileCache", "close");
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
                AppMethodBeat.o(137446);
            } catch (IOException e) {
                Logger.e("MicroMsg.Music.PieceFileCache", "close RandomAccessFile error ", e.getMessage());
            }
        }
        AppMethodBeat.o(137446);
    }

    public final synchronized int b(byte[] bArr, long j, int i) {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(137447);
            if (i == 0) {
                Logger.e("MicroMsg.Music.PieceFileCache", "read error, length == 0");
                AppMethodBeat.o(137447);
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.Music.PieceFileCache", "read error, randomAccessFile is null");
                AppMethodBeat.o(137447);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    i2 = this.randomAccessFile.read(bArr, 0, i);
                    AppMethodBeat.o(137447);
                } catch (IOException e) {
                    Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.o(137447);
                }
            }
        }
        return i2;
    }

    public final synchronized boolean c(byte[] bArr, long j, int i) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(137448);
            if (i == 0) {
                Logger.e("MicroMsg.Music.PieceFileCache", "write error, length == 0");
                AppMethodBeat.o(137448);
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.Music.PieceFileCache", "write error, randomAccessFile is null");
                AppMethodBeat.o(137448);
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    this.randomAccessFile.write(bArr, 0, i);
                    AppMethodBeat.o(137448);
                    z = true;
                } catch (IOException e) {
                    Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error writing %d bytes to from buffer with size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
                    AppMethodBeat.o(137448);
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i = -1;
        synchronized (this) {
            AppMethodBeat.i(137449);
            if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.Music.PieceFileCache", "getLength error, randomAccessFile is null");
                AppMethodBeat.o(137449);
            } else {
                try {
                    i = (int) this.randomAccessFile.length();
                    AppMethodBeat.o(137449);
                } catch (IOException e) {
                    Logger.e("MicroMsg.Music.PieceFileCache", "Error get length of file , err %s", e.getMessage());
                    AppMethodBeat.o(137449);
                }
            }
        }
        return i;
    }

    public final synchronized void setLength(long j) {
        AppMethodBeat.i(137450);
        if (this.randomAccessFile == null) {
            Logger.e("MicroMsg.Music.PieceFileCache", "setLength error, randomAccessFile is null");
            AppMethodBeat.o(137450);
        } else if (j <= 0) {
            Logger.e("MicroMsg.Music.PieceFileCache", "setLength error, length is ".concat(String.valueOf(j)));
            AppMethodBeat.o(137450);
        } else {
            Logger.e("MicroMsg.Music.PieceFileCache", "set file length %s ", String.valueOf(j));
            try {
                this.randomAccessFile.setLength(j);
                AppMethodBeat.o(137450);
            } catch (IOException e) {
                Logger.e("MicroMsg.Music.PieceFileCache", "Error set length of file, err %s", e.getMessage());
                AppMethodBeat.o(137450);
            }
        }
    }

    public final synchronized long bTH() {
        long length;
        AppMethodBeat.i(137451);
        File file = new File(this.fileName);
        if (file.exists()) {
            length = file.length();
            AppMethodBeat.o(137451);
        } else {
            length = -1;
            AppMethodBeat.o(137451);
        }
        return length;
    }

    public static long ek(String str) {
        AppMethodBeat.i(137452);
        File file = new File(b.Tv(str));
        if (file.exists()) {
            long length = file.length();
            AppMethodBeat.o(137452);
            return length;
        }
        AppMethodBeat.o(137452);
        return -1;
    }

    public static void HS(String str) {
        AppMethodBeat.i(137453);
        Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile, fileName:".concat(String.valueOf(str)));
        File file = new File(str);
        if (file.exists()) {
            Logger.i("MicroMsg.Music.PieceFileCache", "delete the piece File");
            file.delete();
            AppMethodBeat.o(137453);
            return;
        }
        Logger.e("MicroMsg.Music.PieceFileCache", "file not exist, delete piece File fail");
        AppMethodBeat.o(137453);
    }

    public static boolean Td(String str) {
        AppMethodBeat.i(137454);
        Logger.i("MicroMsg.Music.PieceFileCache", "existFileByUrl");
        boolean Te = Te(b.Tv(str));
        AppMethodBeat.o(137454);
        return Te;
    }

    private static boolean Te(String str) {
        AppMethodBeat.i(137455);
        Logger.i("MicroMsg.Music.PieceFileCache", "existFile, fileName:".concat(String.valueOf(str)));
        ab.i("MicroMsg.Music.PieceFileCache", "the piece File exist:%b", Boolean.valueOf(new File(str).exists()));
        AppMethodBeat.o(137455);
        return new File(str).exists();
    }
}

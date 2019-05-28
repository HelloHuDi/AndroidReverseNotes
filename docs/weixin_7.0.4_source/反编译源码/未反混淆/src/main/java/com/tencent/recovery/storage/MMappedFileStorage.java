package com.tencent.recovery.storage;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.recovery.log.RecoveryLog;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class MMappedFileStorage {
    private int Arv;
    private File Arw;
    private File Arx;
    private MappedByteBuffer Ary;
    private RandomAccessFile Arz;
    private int currentIndex;

    public final synchronized void e(byte[] bArr, boolean z) {
        try {
            if (this.Arz == null) {
                if (!this.Arx.exists()) {
                    this.Arx.createNewFile();
                }
                this.Arz = new RandomAccessFile(this.Arx, "rw");
            }
            if (this.Ary == null) {
                this.Ary = this.Arz.getChannel().map(MapMode.READ_WRITE, 0, (long) this.Arv);
            }
            if (!(this.Arx == null || this.Ary == null)) {
                if (this.currentIndex + bArr.length > this.Arv || z) {
                    this.Ary.force();
                    try {
                        this.Arz.close();
                    } catch (IOException e) {
                    }
                    h(this.Arx, this.Arw);
                    this.currentIndex = 4;
                    this.Arx.delete();
                    this.Arx.createNewFile();
                    this.Arz = new RandomAccessFile(this.Arx, "rw");
                    this.Ary = this.Arz.getChannel().map(MapMode.READ_WRITE, 0, (long) this.Arv);
                    this.Ary.putInt(this.currentIndex - 4);
                }
                if (bArr.length >= 0) {
                    this.Ary.position(this.currentIndex);
                    this.Ary.put(bArr);
                    this.Ary.position(0);
                    this.currentIndex += bArr.length;
                    this.Ary.putInt(this.currentIndex - 4);
                }
            }
        } catch (Exception e2) {
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e2, "appendToBuffer", new Object[0]);
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x005d A:{SYNTHETIC, Splitter:B:35:0x005d} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0062 A:{SYNTHETIC, Splitter:B:38:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A:{SYNTHETIC, Splitter:B:26:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A:{SYNTHETIC, Splitter:B:29:0x0052} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005d A:{SYNTHETIC, Splitter:B:35:0x005d} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0062 A:{SYNTHETIC, Splitter:B:38:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A:{SYNTHETIC, Splitter:B:26:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A:{SYNTHETIC, Splitter:B:29:0x0052} */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A:{SYNTHETIC, RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void h(File file, File file2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        int i = 0;
        DataInputStream dataInputStream;
        try {
            int readInt;
            dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                readInt = dataInputStream.readInt();
                fileOutputStream = new FileOutputStream(file2, true);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException e4) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (dataInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw e;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int i2 = i;
                    i = i2 + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT > readInt ? readInt - i2 : WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    if (i > 0) {
                        i = dataInputStream.read(bArr, 0, i);
                        if (i > 0) {
                            fileOutputStream.write(bArr, 0, i);
                            i += i2;
                        }
                    }
                    try {
                        dataInputStream.close();
                    } catch (IOException e7) {
                    }
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException e8) {
                        return;
                    }
                }
            } catch (Exception e9) {
                e = e9;
                RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                if (dataInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            dataInputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
            if (dataInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            dataInputStream = null;
            if (dataInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw e;
        }
    }
}

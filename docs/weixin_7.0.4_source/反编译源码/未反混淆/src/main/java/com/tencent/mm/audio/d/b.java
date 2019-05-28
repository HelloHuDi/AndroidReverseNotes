package com.tencent.mm.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b {
    private OutputStream crl;
    private int crm;
    public String mFilePath;

    public b(String str, int i, int i2) {
        AppMethodBeat.i(55762);
        this.mFilePath = str;
        try {
            this.crl = e.L(str, false);
            ByteBuffer allocate = ByteBuffer.allocate(44);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(1179011410);
            allocate.putInt(0);
            allocate.putInt(1163280727);
            allocate.putInt(544501094);
            allocate.putInt(16);
            allocate.putShort((short) 1);
            allocate.putShort((short) i);
            allocate.putInt(i2);
            allocate.putInt((i2 * i) * 2);
            allocate.putShort((short) (i * 2));
            allocate.putShort((short) 16);
            allocate.putInt(1635017060);
            allocate.putInt(0);
            this.crm = 44;
            this.crl.write(allocate.array());
            AppMethodBeat.o(55762);
        } catch (IOException e) {
            ab.e("MicroMsg.PcmWriter", "create file failed: " + e.getMessage());
            AppMethodBeat.o(55762);
        }
    }

    public final boolean y(byte[] bArr, int i) {
        AppMethodBeat.i(55763);
        if (this.crl == null) {
            AppMethodBeat.o(55763);
            return false;
        }
        try {
            this.crl.write(bArr, 0, i);
            this.crm += i;
            AppMethodBeat.o(55763);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.PcmWriter", "write to file failed: " + e.getMessage());
            AppMethodBeat.o(55763);
            return false;
        }
    }

    public final void Fg() {
        AppMethodBeat.i(55764);
        try {
            this.crl.close();
        } catch (IOException e) {
            ab.e("MicroMsg.PcmWriter", "close file failed: " + e.getMessage());
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = e.ck(this.mFilePath, true);
            randomAccessFile.seek(4);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(this.crm - 8);
            randomAccessFile.write(allocate.array());
            allocate.rewind();
            allocate.putInt(this.crm - 42);
            randomAccessFile.seek(40);
            randomAccessFile.write(allocate.array());
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.o(55764);
                    return;
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.PcmWriter", e2, "", new Object[0]);
                    AppMethodBeat.o(55764);
                    return;
                }
            }
        } catch (FileNotFoundException e3) {
            ab.printErrStackTrace("MicroMsg.PcmWriter", e3, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.o(55764);
                    return;
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.PcmWriter", e22, "", new Object[0]);
                    AppMethodBeat.o(55764);
                    return;
                }
            }
        } catch (IOException e222) {
            ab.printErrStackTrace("MicroMsg.PcmWriter", e222, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.o(55764);
                    return;
                } catch (IOException e2222) {
                    ab.printErrStackTrace("MicroMsg.PcmWriter", e2222, "", new Object[0]);
                    AppMethodBeat.o(55764);
                    return;
                }
            }
        } catch (Throwable th) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                    ab.printErrStackTrace("MicroMsg.PcmWriter", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(55764);
        }
        AppMethodBeat.o(55764);
    }
}

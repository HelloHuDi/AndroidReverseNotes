package com.tencent.p177mm.audio.p1180d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.audio.d.b */
public final class C37482b {
    private OutputStream crl;
    private int crm;
    public String mFilePath;

    public C37482b(String str, int i, int i2) {
        AppMethodBeat.m2504i(55762);
        this.mFilePath = str;
        try {
            this.crl = C5730e.m8617L(str, false);
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
            AppMethodBeat.m2505o(55762);
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.PcmWriter", "create file failed: " + e.getMessage());
            AppMethodBeat.m2505o(55762);
        }
    }

    /* renamed from: y */
    public final boolean mo60392y(byte[] bArr, int i) {
        AppMethodBeat.m2504i(55763);
        if (this.crl == null) {
            AppMethodBeat.m2505o(55763);
            return false;
        }
        try {
            this.crl.write(bArr, 0, i);
            this.crm += i;
            AppMethodBeat.m2505o(55763);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.PcmWriter", "write to file failed: " + e.getMessage());
            AppMethodBeat.m2505o(55763);
            return false;
        }
    }

    /* renamed from: Fg */
    public final void mo60391Fg() {
        AppMethodBeat.m2504i(55764);
        try {
            this.crl.close();
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.PcmWriter", "close file failed: " + e.getMessage());
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = C5730e.m8626ck(this.mFilePath, true);
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
                    AppMethodBeat.m2505o(55764);
                    return;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.PcmWriter", e2, "", new Object[0]);
                    AppMethodBeat.m2505o(55764);
                    return;
                }
            }
        } catch (FileNotFoundException e3) {
            C4990ab.printErrStackTrace("MicroMsg.PcmWriter", e3, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.m2505o(55764);
                    return;
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.PcmWriter", e22, "", new Object[0]);
                    AppMethodBeat.m2505o(55764);
                    return;
                }
            }
        } catch (IOException e222) {
            C4990ab.printErrStackTrace("MicroMsg.PcmWriter", e222, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.m2505o(55764);
                    return;
                } catch (IOException e2222) {
                    C4990ab.printErrStackTrace("MicroMsg.PcmWriter", e2222, "", new Object[0]);
                    AppMethodBeat.m2505o(55764);
                    return;
                }
            }
        } catch (Throwable th) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                    C4990ab.printErrStackTrace("MicroMsg.PcmWriter", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(55764);
        }
        AppMethodBeat.m2505o(55764);
    }
}

package com.tencent.mm.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public final class r {
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0063=Splitter:B:28:0x0063, B:11:0x002a=Splitter:B:11:0x002a} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A:{SYNTHETIC, Splitter:B:33:0x007d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compress(byte[] bArr) {
        Throwable e;
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.Zlib", e2, "", new Object[0]);
                }
            } catch (Exception e3) {
                e = e3;
            } catch (OutOfMemoryError e4) {
                throw new OutOfMemoryError("crash upload data length:" + bArr.length);
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
            try {
                ab.printErrStackTrace("MicroMsg.Zlib", e, "", new Object[0]);
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.Zlib", e22, "", new Object[0]);
                    }
                }
                deflater.end();
                return bArr;
            } catch (Throwable th) {
                e = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        ab.printErrStackTrace("MicroMsg.Zlib", e6, "", new Object[0]);
                    }
                }
                throw e;
            }
        } catch (OutOfMemoryError e7) {
            byteArrayOutputStream = null;
            throw new OutOfMemoryError("crash upload data length:" + bArr.length);
        } catch (Throwable th2) {
            e = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            throw e;
        }
        deflater.end();
        return bArr;
    }

    public static byte[] B(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        Throwable e = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.Zlib", e2, "", new Object[0]);
            }
        } catch (Exception e3) {
            e = e3;
            ab.printErrStackTrace("MicroMsg.Zlib", e, "exception when loop read byte", new Object[0]);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e22) {
                ab.printErrStackTrace("MicroMsg.Zlib", e22, "", new Object[0]);
            }
        } catch (Throwable e4) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                ab.printErrStackTrace("MicroMsg.Zlib", e5, "", new Object[0]);
            }
            throw e4;
        }
        inflater.end();
        if (e4 == null) {
            return bArr;
        }
        throw new Exception(e4);
    }
}

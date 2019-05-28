package com.tencent.tmassistantsdk.protocol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ZipUtils {
    private static final String TAG = "ZipUtils";

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037 A:{SYNTHETIC, Splitter:B:13:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] zip(byte[] bArr) {
        Throwable th;
        AppMethodBeat.m2504i(76026);
        Deflater deflater = new Deflater();
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                deflater.setLevel(9);
                deflater.setInput(bArr);
                deflater.finish();
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                deflater.end();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                AppMethodBeat.m2505o(76026);
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
                deflater.end();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(76026);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            deflater.end();
            if (byteArrayOutputStream != null) {
            }
            AppMethodBeat.m2505o(76026);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A:{SYNTHETIC, Splitter:B:15:0x003a} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0055 A:{SYNTHETIC, Splitter:B:27:0x0055} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] unzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        byte[] toByteArray;
        AppMethodBeat.m2504i(76027);
        Inflater inflater = new Inflater();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                inflater.setInput(bArr);
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                }
                inflater.end();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (DataFormatException e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    inflater.end();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.m2505o(76027);
                    return toByteArray;
                } catch (Throwable th) {
                    e = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    inflater.end();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.m2505o(76027);
                    throw e;
                }
            }
        } catch (DataFormatException e6) {
            e = e6;
            byteArrayOutputStream = null;
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            inflater.end();
            if (byteArrayOutputStream != null) {
            }
            toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.m2505o(76027);
            return toByteArray;
        } catch (Throwable th2) {
            e = th2;
            inflater.end();
            if (byteArrayOutputStream2 != null) {
            }
            AppMethodBeat.m2505o(76027);
            throw e;
        }
        toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(76027);
        return toByteArray;
    }
}

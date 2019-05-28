package com.tencent.qqmusic.mediaplayer.codec.wav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.CacheBytesManager;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.InputStream;

public class WaveReader {
    private static final String TAG = "WaveReader";
    private static final int WAV_FORMAT = 1463899717;
    private static final int WAV_FORMAT_CHUNK_ID = 1718449184;
    private static final int WAV_HEADER_CHUNK_ID = 1380533830;
    private static final int WAV_HEADER_SIZE = 50;

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ff A:{SYNTHETIC, Splitter:B:54:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e8 A:{SYNTHETIC, Splitter:B:46:0x00e8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isWavFormat(String str) {
        Throwable e;
        Throwable e2;
        AppMethodBeat.m2504i(128531);
        byte[] bArr = CacheBytesManager.getStatic(50);
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                int readUnsignedInt = readUnsignedInt(bArr, 0);
                if (readUnsignedInt != WAV_HEADER_CHUNK_ID) {
                    Logger.m71025i(TAG, "isWavFormat Invalid WAVE header chunk ID = ".concat(String.valueOf(readUnsignedInt)));
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        Logger.m71024e(TAG, e3);
                    }
                    CacheBytesManager.recycle(bArr);
                    AppMethodBeat.m2505o(128531);
                    return false;
                }
                readUnsignedInt = readUnsignedInt(bArr, 8);
                if (readUnsignedInt != WAV_FORMAT) {
                    Logger.m71025i(TAG, "isWavFormat Invalid WAVE format = ".concat(String.valueOf(readUnsignedInt)));
                    try {
                        fileInputStream.close();
                    } catch (Exception e32) {
                        Logger.m71024e(TAG, e32);
                    }
                    CacheBytesManager.recycle(bArr);
                    AppMethodBeat.m2505o(128531);
                    return false;
                }
                readUnsignedInt = readUnsignedInt(bArr, 12);
                if (readUnsignedInt != WAV_FORMAT_CHUNK_ID) {
                    Logger.m71025i(TAG, "isWavFormat Invalid WAVE format chunk ID formatId = ".concat(String.valueOf(readUnsignedInt)));
                    try {
                        fileInputStream.close();
                    } catch (Exception e322) {
                        Logger.m71024e(TAG, e322);
                    }
                    CacheBytesManager.recycle(bArr);
                    AppMethodBeat.m2505o(128531);
                    return false;
                }
                Logger.m71025i(TAG, "isWavFormat formatSize = ".concat(String.valueOf(readUnsignedIntLE(bArr, 16))));
                Logger.m71025i(TAG, "isWavFormat mAudioFormat = ".concat(String.valueOf(readUnsignedShortLE(bArr, 20))));
                try {
                    fileInputStream.close();
                } catch (Exception e22) {
                    Logger.m71024e(TAG, e22);
                }
                CacheBytesManager.recycle(bArr);
                AppMethodBeat.m2505o(128531);
                return true;
            } catch (Exception e4) {
                e322 = e4;
                try {
                    Logger.m71024e(TAG, e322);
                    if (fileInputStream != null) {
                    }
                    CacheBytesManager.recycle(bArr);
                    AppMethodBeat.m2505o(128531);
                    return false;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3222) {
                            Logger.m71024e(TAG, e3222);
                        }
                    }
                    CacheBytesManager.recycle(bArr);
                    AppMethodBeat.m2505o(128531);
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e3222 = e5;
            fileInputStream = null;
            Logger.m71024e(TAG, e3222);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e32222) {
                    Logger.m71024e(TAG, e32222);
                }
            }
            CacheBytesManager.recycle(bArr);
            AppMethodBeat.m2505o(128531);
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            CacheBytesManager.recycle(bArr);
            AppMethodBeat.m2505o(128531);
            throw e22;
        }
    }

    private static int readUnsignedInt(byte[] bArr, int i) {
        if (i + 4 > bArr.length) {
            return -1;
        }
        return ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
    }

    private static int readUnsignedIntLE(byte[] bArr, int i) {
        if (i + 4 > bArr.length) {
            return -1;
        }
        return (((bArr[0] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
    }

    private static short readUnsignedShortLE(byte[] bArr, int i) {
        AppMethodBeat.m2504i(128532);
        if (i + 2 > bArr.length) {
            AppMethodBeat.m2505o(128532);
            return (short) -1;
        }
        short byteToShortLE = byteToShortLE(bArr[i], bArr[i + 1]);
        AppMethodBeat.m2505o(128532);
        return byteToShortLE;
    }

    private static short byteToShortLE(byte b, byte b2) {
        return (short) ((b & 255) | ((b2 & 255) << 8));
    }
}

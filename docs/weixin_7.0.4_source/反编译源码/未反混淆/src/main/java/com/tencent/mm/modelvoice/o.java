package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class o {
    public static int uK(String str) {
        AppMethodBeat.i(116605);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116605);
            return -1;
        }
        ab.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(str)));
        if (h(str, 0, false)) {
            AppMethodBeat.o(116605);
            return 0;
        } else if (i(str, 0, false)) {
            AppMethodBeat.o(116605);
            return 2;
        } else {
            AppMethodBeat.o(116605);
            return 1;
        }
    }

    public static int g(String str, int i, boolean z) {
        AppMethodBeat.i(116606);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116606);
            return -1;
        }
        ab.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(str)));
        if (h(str, i, z)) {
            AppMethodBeat.o(116606);
            return 0;
        } else if (i(str, i, z)) {
            AppMethodBeat.o(116606);
            return 2;
        } else {
            AppMethodBeat.o(116606);
            return 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6 A:{SYNTHETIC, Splitter:B:42:0x00e6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean h(String str, int i, boolean z) {
        Object str2;
        Throwable e;
        AppMethodBeat.i(116607);
        if (!z) {
            if (i == 0) {
                str2 = q.getFullPath(str2);
            } else {
                str2 = null;
            }
        }
        ab.d("MicroMsg.VoiceFile", "path ".concat(String.valueOf(str2)));
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str2, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    ab.e("MicroMsg.VoiceFile", "read amr file header failed!");
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e2));
                    }
                    AppMethodBeat.o(116607);
                    return false;
                }
                ab.i("MicroMsg.VoiceFile", "isAmrHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bo.ca(bArr), new String(bArr), "#!AMR\n");
                if (new String(bArr).endsWith("#!AMR\n")) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e22) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e22));
                    }
                    AppMethodBeat.o(116607);
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e222) {
                    ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e222));
                }
                AppMethodBeat.o(116607);
                return false;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            try {
                ab.printErrStackTrace("MicroMsg.VoiceFile", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2222) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e2222));
                    }
                }
                AppMethodBeat.o(116607);
                return false;
            } catch (Throwable e32) {
                e = e32;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e22222) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e22222));
                    }
                }
                AppMethodBeat.o(116607);
                throw e;
            }
        } catch (Throwable th) {
            e = th;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(116607);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f5 A:{SYNTHETIC, Splitter:B:43:0x00f5} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f5 A:{SYNTHETIC, Splitter:B:43:0x00f5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean i(String str, int i, boolean z) {
        Object str2;
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        AppMethodBeat.i(116608);
        if (!z) {
            if (i == 0) {
                str2 = q.getFullPath(str2);
            } else if (i == 1) {
                ab.e("MicroMsg.VoiceFile", "isSilkHeader usertype error, TYPE_RECOGNIZER_BIZ fileName:%s", str2);
                AppMethodBeat.o(116608);
                return false;
            } else {
                str2 = null;
            }
        }
        ab.d("MicroMsg.VoiceFile", "isSilkHeader path ".concat(String.valueOf(str2)));
        try {
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(str2, "r");
            try {
                byte[] bArr = new byte[9];
                randomAccessFile3.seek(1);
                if (randomAccessFile3.read(bArr, 0, 9) == -1) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e));
                    }
                    AppMethodBeat.o(116608);
                    return false;
                }
                ab.i("MicroMsg.VoiceFile", "isSilkHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bo.ca(bArr), new String(bArr), "#!SILK_V3");
                if (new String(bArr).endsWith("#!SILK_V3")) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e2) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e2));
                    }
                    AppMethodBeat.o(116608);
                    return true;
                }
                try {
                    randomAccessFile3.close();
                } catch (IOException e22) {
                    ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e22));
                }
                AppMethodBeat.o(116608);
                return false;
            } catch (Exception e3) {
                randomAccessFile2 = randomAccessFile3;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile3;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(116608);
                throw th;
            }
        } catch (Exception e4) {
            try {
                ab.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e222) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e222));
                    }
                }
                AppMethodBeat.o(116608);
                return false;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2222) {
                        ab.e("MicroMsg.VoiceFile", "exception:%s", bo.l(e2222));
                    }
                }
                AppMethodBeat.o(116608);
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(116608);
            throw th;
        }
    }

    public static int uj(String str) {
        boolean z = true;
        AppMethodBeat.i(116609);
        int uL;
        String fullPath;
        File file;
        int length;
        switch (uK(str)) {
            case 0:
                uL = uL(q.getFullPath(str));
                AppMethodBeat.o(116609);
                return uL;
            case 1:
                fullPath = q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (file.exists()) {
                    length = (int) file.length();
                    if (length <= 0) {
                        AppMethodBeat.o(116609);
                        return 0;
                    }
                    AppMethodBeat.o(116609);
                    return length;
                }
                AppMethodBeat.o(116609);
                return 0;
            case 2:
                fullPath = q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (file.exists()) {
                    length = (int) file.length();
                    if (length <= 0) {
                        AppMethodBeat.o(116609);
                        return 0;
                    }
                    AppMethodBeat.o(116609);
                    return length;
                }
                AppMethodBeat.o(116609);
                return 0;
            default:
                uL = uL(q.getFullPath(str));
                AppMethodBeat.o(116609);
                return uL;
        }
    }

    private static int uL(String str) {
        AppMethodBeat.i(116610);
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (file.exists()) {
            int length = ((int) file.length()) - 6;
            if (length <= 0) {
                AppMethodBeat.o(116610);
                return 0;
            }
            AppMethodBeat.o(116610);
            return length;
        }
        AppMethodBeat.o(116610);
        return 0;
    }
}

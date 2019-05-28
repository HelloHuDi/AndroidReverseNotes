package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class h {
    private static Boolean evF = null;
    private static Boolean evG = null;
    private static Boolean evH = null;

    public static File getExternalStorageDirectory() {
        AppMethodBeat.i(93079);
        File externalStorageDirectory;
        if (bo.isNullOrNil(q.etn.est)) {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
            AppMethodBeat.o(93079);
            return externalStorageDirectory;
        }
        externalStorageDirectory = new File(q.etn.est);
        AppMethodBeat.o(93079);
        return externalStorageDirectory;
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        AppMethodBeat.i(93080);
        File externalStoragePublicDirectory;
        if (bo.isNullOrNil(q.etn.esu)) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str);
            AppMethodBeat.o(93080);
            return externalStoragePublicDirectory;
        }
        externalStoragePublicDirectory = new File(q.etn.esu);
        AppMethodBeat.o(93080);
        return externalStoragePublicDirectory;
    }

    public static File getDataDirectory() {
        AppMethodBeat.i(93081);
        File dataDirectory;
        if (bo.isNullOrNil(q.etn.esv)) {
            dataDirectory = Environment.getDataDirectory();
            AppMethodBeat.o(93081);
            return dataDirectory;
        }
        dataDirectory = new File(q.etn.esv);
        AppMethodBeat.o(93081);
        return dataDirectory;
    }

    public static File getRootDirectory() {
        AppMethodBeat.i(93082);
        File rootDirectory;
        if (bo.isNullOrNil(q.etn.esw)) {
            rootDirectory = Environment.getRootDirectory();
            AppMethodBeat.o(93082);
            return rootDirectory;
        }
        rootDirectory = new File(q.etn.esw);
        AppMethodBeat.o(93082);
        return rootDirectory;
    }

    public static File getDownloadCacheDirectory() {
        AppMethodBeat.i(93083);
        File downloadCacheDirectory;
        if (bo.isNullOrNil(q.etn.esy)) {
            downloadCacheDirectory = Environment.getDownloadCacheDirectory();
            AppMethodBeat.o(93083);
            return downloadCacheDirectory;
        }
        downloadCacheDirectory = new File(q.etn.esy);
        AppMethodBeat.o(93083);
        return downloadCacheDirectory;
    }

    public static String getExternalStorageState() {
        AppMethodBeat.i(93084);
        String externalStorageState;
        if (bo.isNullOrNil(q.etn.esx)) {
            externalStorageState = Environment.getExternalStorageState();
            AppMethodBeat.o(93084);
            return externalStorageState;
        }
        externalStorageState = q.etn.esx;
        AppMethodBeat.o(93084);
        return externalStorageState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c A:{SYNTHETIC, Splitter:B:22:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052 A:{SYNTHETIC, Splitter:B:16:0x0052} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static boolean Ms() {
        Throwable e;
        boolean booleanValue;
        AppMethodBeat.i(93085);
        if (evF == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    evF = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        evF = Boolean.FALSE;
                        if (fileInputStream != null) {
                        }
                        booleanValue = evF.booleanValue();
                        AppMethodBeat.o(93085);
                        return booleanValue;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(93085);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                evF = Boolean.FALSE;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                booleanValue = evF.booleanValue();
                AppMethodBeat.o(93085);
                return booleanValue;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                    }
                }
                AppMethodBeat.o(93085);
                throw e;
            }
        }
        booleanValue = evF.booleanValue();
        AppMethodBeat.o(93085);
        return booleanValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A:{SYNTHETIC, Splitter:B:22:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c A:{SYNTHETIC, Splitter:B:16:0x005c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Mt() {
        Throwable e;
        boolean booleanValue;
        AppMethodBeat.i(93086);
        if (evG == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    evG = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        evG = Boolean.FALSE;
                        if (fileInputStream != null) {
                        }
                        booleanValue = evG.booleanValue();
                        AppMethodBeat.o(93086);
                        return booleanValue;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.o(93086);
                        throw e;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                evG = Boolean.FALSE;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                    }
                }
                booleanValue = evG.booleanValue();
                AppMethodBeat.o(93086);
                return booleanValue;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(93086);
                throw e;
            }
        }
        booleanValue = evG.booleanValue();
        AppMethodBeat.o(93086);
        return booleanValue;
    }

    public static int Mu() {
        return 4;
    }
}

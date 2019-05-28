package com.tencent.p177mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/* renamed from: com.tencent.mm.compatible.util.h */
public final class C1448h {
    private static Boolean evF = null;
    private static Boolean evG = null;
    private static Boolean evH = null;

    public static File getExternalStorageDirectory() {
        AppMethodBeat.m2504i(93079);
        File externalStorageDirectory;
        if (C5046bo.isNullOrNil(C1427q.etn.est)) {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
            AppMethodBeat.m2505o(93079);
            return externalStorageDirectory;
        }
        externalStorageDirectory = new File(C1427q.etn.est);
        AppMethodBeat.m2505o(93079);
        return externalStorageDirectory;
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        AppMethodBeat.m2504i(93080);
        File externalStoragePublicDirectory;
        if (C5046bo.isNullOrNil(C1427q.etn.esu)) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str);
            AppMethodBeat.m2505o(93080);
            return externalStoragePublicDirectory;
        }
        externalStoragePublicDirectory = new File(C1427q.etn.esu);
        AppMethodBeat.m2505o(93080);
        return externalStoragePublicDirectory;
    }

    public static File getDataDirectory() {
        AppMethodBeat.m2504i(93081);
        File dataDirectory;
        if (C5046bo.isNullOrNil(C1427q.etn.esv)) {
            dataDirectory = Environment.getDataDirectory();
            AppMethodBeat.m2505o(93081);
            return dataDirectory;
        }
        dataDirectory = new File(C1427q.etn.esv);
        AppMethodBeat.m2505o(93081);
        return dataDirectory;
    }

    public static File getRootDirectory() {
        AppMethodBeat.m2504i(93082);
        File rootDirectory;
        if (C5046bo.isNullOrNil(C1427q.etn.esw)) {
            rootDirectory = Environment.getRootDirectory();
            AppMethodBeat.m2505o(93082);
            return rootDirectory;
        }
        rootDirectory = new File(C1427q.etn.esw);
        AppMethodBeat.m2505o(93082);
        return rootDirectory;
    }

    public static File getDownloadCacheDirectory() {
        AppMethodBeat.m2504i(93083);
        File downloadCacheDirectory;
        if (C5046bo.isNullOrNil(C1427q.etn.esy)) {
            downloadCacheDirectory = Environment.getDownloadCacheDirectory();
            AppMethodBeat.m2505o(93083);
            return downloadCacheDirectory;
        }
        downloadCacheDirectory = new File(C1427q.etn.esy);
        AppMethodBeat.m2505o(93083);
        return downloadCacheDirectory;
    }

    public static String getExternalStorageState() {
        AppMethodBeat.m2504i(93084);
        String externalStorageState;
        if (C5046bo.isNullOrNil(C1427q.etn.esx)) {
            externalStorageState = Environment.getExternalStorageState();
            AppMethodBeat.m2505o(93084);
            return externalStorageState;
        }
        externalStorageState = C1427q.etn.esx;
        AppMethodBeat.m2505o(93084);
        return externalStorageState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c A:{SYNTHETIC, Splitter:B:22:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052 A:{SYNTHETIC, Splitter:B:16:0x0052} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    /* renamed from: Ms */
    public static boolean m3076Ms() {
        Throwable e;
        boolean booleanValue;
        AppMethodBeat.m2504i(93085);
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
                        C4990ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        evF = Boolean.FALSE;
                        if (fileInputStream != null) {
                        }
                        booleanValue = evF.booleanValue();
                        AppMethodBeat.m2505o(93085);
                        return booleanValue;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(93085);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                evF = Boolean.FALSE;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                booleanValue = evF.booleanValue();
                AppMethodBeat.m2505o(93085);
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
                AppMethodBeat.m2505o(93085);
                throw e;
            }
        }
        booleanValue = evF.booleanValue();
        AppMethodBeat.m2505o(93085);
        return booleanValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A:{SYNTHETIC, Splitter:B:22:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c A:{SYNTHETIC, Splitter:B:16:0x005c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Mt */
    public static boolean m3077Mt() {
        Throwable e;
        boolean booleanValue;
        AppMethodBeat.m2504i(93086);
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
                        C4990ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        evG = Boolean.FALSE;
                        if (fileInputStream != null) {
                        }
                        booleanValue = evG.booleanValue();
                        AppMethodBeat.m2505o(93086);
                        return booleanValue;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.m2505o(93086);
                        throw e;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                evG = Boolean.FALSE;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                    }
                }
                booleanValue = evG.booleanValue();
                AppMethodBeat.m2505o(93086);
                return booleanValue;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(93086);
                throw e;
            }
        }
        booleanValue = evG.booleanValue();
        AppMethodBeat.m2505o(93086);
        return booleanValue;
    }

    /* renamed from: Mu */
    public static int m3078Mu() {
        return 4;
    }
}

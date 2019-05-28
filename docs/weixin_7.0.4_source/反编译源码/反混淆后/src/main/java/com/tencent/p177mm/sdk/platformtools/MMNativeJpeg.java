package com.tencent.p177mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.tencent.mm.sdk.platformtools.MMNativeJpeg */
public class MMNativeJpeg {
    public static final int FAKE_PARTIAL_PROGRESSIVE_QUALITY = 25;
    public static final String TAG = "MMJPEG.JAVA";

    private static String exception2String(Throwable th) {
        AppMethodBeat.m2504i(93404);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.m2505o(93404);
        return stringWriter2;
    }

    public static void Destroy() {
    }

    private static boolean checkAndroidVersion() {
        AppMethodBeat.m2504i(93405);
        if (VERSION.SDK_INT < 11) {
            C4990ab.m7416i(TAG, "early version before android 3.0  unsupported.");
            AppMethodBeat.m2505o(93405);
            return false;
        }
        AppMethodBeat.m2505o(93405);
        return true;
    }

    public static int queryQuality(String str) {
        AppMethodBeat.m2504i(93406);
        if (!MMNativeJpeg.checkAndroidVersion()) {
            AppMethodBeat.m2505o(93406);
            return 0;
        } else if (C5730e.m8628ct(str)) {
            try {
                int queryQuality = mmjpeg.queryQuality(str);
                C4990ab.m7417i(TAG, "after query quality:%d", Integer.valueOf(queryQuality));
                if (queryQuality < Downloads.MIN_WAIT_FOR_NETWORK && queryQuality >= 24) {
                    AppMethodBeat.m2505o(93406);
                    return queryQuality;
                } else if (1 == mmjpeg.isProgressiveFile(str)) {
                    AppMethodBeat.m2505o(93406);
                    return 25;
                } else {
                    C4990ab.m7420w(TAG, "invalid jpeg file or too small quality.");
                    AppMethodBeat.m2505o(93406);
                    return 0;
                }
            } catch (Exception e) {
                C4990ab.m7413e(TAG, "queryQuality failed. exception:%s", MMNativeJpeg.exception2String(e));
                AppMethodBeat.m2505o(93406);
                return 0;
            } catch (IncompatibleClassChangeError e2) {
                C4990ab.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                AppMethodBeat.m2505o(93406);
                throw incompatibleClassChangeError;
            } catch (Error e3) {
                C4990ab.m7413e(TAG, "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", e3.toString());
                AppMethodBeat.m2505o(93406);
                return 0;
            }
        } else {
            AppMethodBeat.m2505o(93406);
            return 0;
        }
    }

    public static boolean isProgressive(String str) {
        AppMethodBeat.m2504i(93407);
        C4990ab.m7419v(TAG, "isProgressive:%s", str);
        if (!MMNativeJpeg.checkAndroidVersion()) {
            AppMethodBeat.m2505o(93407);
            return false;
        } else if (C5730e.m8628ct(str)) {
            C4990ab.m7411d(TAG, "check progressive for file:%s", str);
            try {
                int isProgressiveFile = mmjpeg.isProgressiveFile(str);
                if (1 == isProgressiveFile || isProgressiveFile == 0) {
                    C4990ab.m7417i(TAG, "file:%s progressive:%d", str, Integer.valueOf(isProgressiveFile));
                    if (isProgressiveFile == 1) {
                        AppMethodBeat.m2505o(93407);
                        return true;
                    }
                    AppMethodBeat.m2505o(93407);
                    return false;
                }
                C4990ab.m7413e(TAG, "check failed. error:%d", Integer.valueOf(isProgressiveFile));
                AppMethodBeat.m2505o(93407);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e(TAG, "isProgressive exception:%s", MMNativeJpeg.exception2String(e));
                AppMethodBeat.m2505o(93407);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(93407);
            return false;
        }
    }

    public static boolean convertToProgressive(String str, int i) {
        AppMethodBeat.m2504i(93408);
        if (MMNativeJpeg.checkAndroidVersion()) {
            try {
                String str2 = str + ".prog.dat";
                C4990ab.m7411d(TAG, "convert %s to %s use progressive.quality:%d", str, str2, Integer.valueOf(i));
                if (mmjpeg.convertToProgressive(str, str2) != 0) {
                    C4990ab.m7413e(TAG, "convert failed. error:%d", Integer.valueOf(mmjpeg.convertToProgressive(str, str2)));
                    AppMethodBeat.m2505o(93408);
                    return false;
                }
                C4990ab.m7417i(TAG, "convert ret:%b", Boolean.valueOf(C5730e.m8623aQ(str2, str)));
                AppMethodBeat.m2505o(93408);
                return r1;
            } catch (Exception e) {
                C4990ab.m7413e(TAG, "convertToProgressive exception:%s", MMNativeJpeg.exception2String(e));
                AppMethodBeat.m2505o(93408);
                return false;
            }
        }
        AppMethodBeat.m2505o(93408);
        return false;
    }

    public static Bitmap decodeAsBitmap(String str) {
        AppMethodBeat.m2504i(93409);
        C4990ab.m7419v(TAG, "decodeAsBitmap:%s", str);
        try {
            JpegParams queryParams = mmjpeg.queryParams(str);
            if (queryParams == null) {
                C4990ab.m7412e(TAG, "can't query jpeg parames.");
                AppMethodBeat.m2505o(93409);
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(queryParams.Width, queryParams.Height, Config.ARGB_8888);
            if (mmjpeg.decodeToBitmap(str, createBitmap)) {
                C4990ab.m7416i(TAG, "decode bitmap successed.");
                AppMethodBeat.m2505o(93409);
                return createBitmap;
            }
            C4990ab.m7412e(TAG, "can't decode to bmp.");
            AppMethodBeat.m2505o(93409);
            return null;
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "decodeAsBitmap exception:%s", MMNativeJpeg.exception2String(e));
            AppMethodBeat.m2505o(93409);
            return null;
        } catch (OutOfMemoryError e2) {
            C4990ab.m7413e(TAG, "decodeAsBitmap OOM:%s", str);
            AppMethodBeat.m2505o(93409);
            return null;
        }
    }

    public static boolean Convert2Baseline(String str, int i) {
        AppMethodBeat.m2504i(93410);
        if (MMNativeJpeg.isProgressive(str)) {
            OutputStream outputStream = null;
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    C4990ab.m7416i(TAG, "c2b:use mmjpeg to decode.");
                    decodeFile = MMNativeJpeg.decodeAsBitmap(str);
                }
                if (decodeFile != null) {
                    String str2 = str + ".base";
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    outputStream = C5730e.m8617L(str2, false);
                    if (decodeFile.compress(compressFormat, i, outputStream)) {
                        C4990ab.m7417i(TAG, "c2b: convert baseline %s ok.", str2);
                        boolean C = C40616m.m70056C(str2, str, true);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        AppMethodBeat.m2505o(93410);
                        return C;
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                C4990ab.m7413e(TAG, "c2b:exception:%s", MMNativeJpeg.exception2String(e3));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (OutOfMemoryError e5) {
                C4990ab.m7412e(TAG, "c2b: oom");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                    }
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e7) {
                    }
                }
                AppMethodBeat.m2505o(93410);
            }
            AppMethodBeat.m2505o(93410);
            return false;
        }
        C4990ab.m7413e(TAG, "c2b: not progressive file.%s", str);
        AppMethodBeat.m2505o(93410);
        return true;
    }

    public static boolean IsJpegFile(String str) {
        AppMethodBeat.m2504i(93411);
        try {
            if (mmjpeg.queryParams(str) == null) {
                C4990ab.m7412e(TAG, "IsJpegFile : can't query jpeg parames.");
                AppMethodBeat.m2505o(93411);
                return false;
            }
            AppMethodBeat.m2505o(93411);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "IsJpegFile exception:%s", MMNativeJpeg.exception2String(e));
            AppMethodBeat.m2505o(93411);
            return false;
        }
    }
}

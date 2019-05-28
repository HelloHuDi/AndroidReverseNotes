package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MMNativeJpeg {
    public static final int FAKE_PARTIAL_PROGRESSIVE_QUALITY = 25;
    public static final String TAG = "MMJPEG.JAVA";

    private static String exception2String(Throwable th) {
        AppMethodBeat.i(93404);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(93404);
        return stringWriter2;
    }

    public static void Destroy() {
    }

    private static boolean checkAndroidVersion() {
        AppMethodBeat.i(93405);
        if (VERSION.SDK_INT < 11) {
            ab.i(TAG, "early version before android 3.0  unsupported.");
            AppMethodBeat.o(93405);
            return false;
        }
        AppMethodBeat.o(93405);
        return true;
    }

    public static int queryQuality(String str) {
        AppMethodBeat.i(93406);
        if (!checkAndroidVersion()) {
            AppMethodBeat.o(93406);
            return 0;
        } else if (e.ct(str)) {
            try {
                int queryQuality = mmjpeg.queryQuality(str);
                ab.i(TAG, "after query quality:%d", Integer.valueOf(queryQuality));
                if (queryQuality < Downloads.MIN_WAIT_FOR_NETWORK && queryQuality >= 24) {
                    AppMethodBeat.o(93406);
                    return queryQuality;
                } else if (1 == mmjpeg.isProgressiveFile(str)) {
                    AppMethodBeat.o(93406);
                    return 25;
                } else {
                    ab.w(TAG, "invalid jpeg file or too small quality.");
                    AppMethodBeat.o(93406);
                    return 0;
                }
            } catch (Exception e) {
                ab.e(TAG, "queryQuality failed. exception:%s", exception2String(e));
                AppMethodBeat.o(93406);
                return 0;
            } catch (IncompatibleClassChangeError e2) {
                ab.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                AppMethodBeat.o(93406);
                throw incompatibleClassChangeError;
            } catch (Error e3) {
                ab.e(TAG, "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", e3.toString());
                AppMethodBeat.o(93406);
                return 0;
            }
        } else {
            AppMethodBeat.o(93406);
            return 0;
        }
    }

    public static boolean isProgressive(String str) {
        AppMethodBeat.i(93407);
        ab.v(TAG, "isProgressive:%s", str);
        if (!checkAndroidVersion()) {
            AppMethodBeat.o(93407);
            return false;
        } else if (e.ct(str)) {
            ab.d(TAG, "check progressive for file:%s", str);
            try {
                int isProgressiveFile = mmjpeg.isProgressiveFile(str);
                if (1 == isProgressiveFile || isProgressiveFile == 0) {
                    ab.i(TAG, "file:%s progressive:%d", str, Integer.valueOf(isProgressiveFile));
                    if (isProgressiveFile == 1) {
                        AppMethodBeat.o(93407);
                        return true;
                    }
                    AppMethodBeat.o(93407);
                    return false;
                }
                ab.e(TAG, "check failed. error:%d", Integer.valueOf(isProgressiveFile));
                AppMethodBeat.o(93407);
                return false;
            } catch (Exception e) {
                ab.e(TAG, "isProgressive exception:%s", exception2String(e));
                AppMethodBeat.o(93407);
                return false;
            }
        } else {
            AppMethodBeat.o(93407);
            return false;
        }
    }

    public static boolean convertToProgressive(String str, int i) {
        AppMethodBeat.i(93408);
        if (checkAndroidVersion()) {
            try {
                String str2 = str + ".prog.dat";
                ab.d(TAG, "convert %s to %s use progressive.quality:%d", str, str2, Integer.valueOf(i));
                if (mmjpeg.convertToProgressive(str, str2) != 0) {
                    ab.e(TAG, "convert failed. error:%d", Integer.valueOf(mmjpeg.convertToProgressive(str, str2)));
                    AppMethodBeat.o(93408);
                    return false;
                }
                ab.i(TAG, "convert ret:%b", Boolean.valueOf(e.aQ(str2, str)));
                AppMethodBeat.o(93408);
                return r1;
            } catch (Exception e) {
                ab.e(TAG, "convertToProgressive exception:%s", exception2String(e));
                AppMethodBeat.o(93408);
                return false;
            }
        }
        AppMethodBeat.o(93408);
        return false;
    }

    public static Bitmap decodeAsBitmap(String str) {
        AppMethodBeat.i(93409);
        ab.v(TAG, "decodeAsBitmap:%s", str);
        try {
            JpegParams queryParams = mmjpeg.queryParams(str);
            if (queryParams == null) {
                ab.e(TAG, "can't query jpeg parames.");
                AppMethodBeat.o(93409);
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(queryParams.Width, queryParams.Height, Config.ARGB_8888);
            if (mmjpeg.decodeToBitmap(str, createBitmap)) {
                ab.i(TAG, "decode bitmap successed.");
                AppMethodBeat.o(93409);
                return createBitmap;
            }
            ab.e(TAG, "can't decode to bmp.");
            AppMethodBeat.o(93409);
            return null;
        } catch (Exception e) {
            ab.e(TAG, "decodeAsBitmap exception:%s", exception2String(e));
            AppMethodBeat.o(93409);
            return null;
        } catch (OutOfMemoryError e2) {
            ab.e(TAG, "decodeAsBitmap OOM:%s", str);
            AppMethodBeat.o(93409);
            return null;
        }
    }

    public static boolean Convert2Baseline(String str, int i) {
        AppMethodBeat.i(93410);
        if (isProgressive(str)) {
            OutputStream outputStream = null;
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    ab.i(TAG, "c2b:use mmjpeg to decode.");
                    decodeFile = decodeAsBitmap(str);
                }
                if (decodeFile != null) {
                    String str2 = str + ".base";
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    outputStream = e.L(str2, false);
                    if (decodeFile.compress(compressFormat, i, outputStream)) {
                        ab.i(TAG, "c2b: convert baseline %s ok.", str2);
                        boolean C = m.C(str2, str, true);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        AppMethodBeat.o(93410);
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
                ab.e(TAG, "c2b:exception:%s", exception2String(e3));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (OutOfMemoryError e5) {
                ab.e(TAG, "c2b: oom");
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
                AppMethodBeat.o(93410);
            }
            AppMethodBeat.o(93410);
            return false;
        }
        ab.e(TAG, "c2b: not progressive file.%s", str);
        AppMethodBeat.o(93410);
        return true;
    }

    public static boolean IsJpegFile(String str) {
        AppMethodBeat.i(93411);
        try {
            if (mmjpeg.queryParams(str) == null) {
                ab.e(TAG, "IsJpegFile : can't query jpeg parames.");
                AppMethodBeat.o(93411);
                return false;
            }
            AppMethodBeat.o(93411);
            return true;
        } catch (Exception e) {
            ab.e(TAG, "IsJpegFile exception:%s", exception2String(e));
            AppMethodBeat.o(93411);
            return false;
        }
    }
}

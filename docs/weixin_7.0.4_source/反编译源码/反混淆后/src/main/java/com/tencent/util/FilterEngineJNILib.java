package com.tencent.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Environment;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.view.C44569b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterEngineJNILib {
    private static long mLastDate = 0;
    private static int mSameSecondCount = 0;

    public static native void nativeCopyImage(Bitmap bitmap, long j);

    public static byte[] getAssetContents(String str) {
        AppMethodBeat.m2504i(86583);
        if (C44569b.AIC == null) {
            AppMethodBeat.m2505o(86583);
            return null;
        }
        InputStream open = C44569b.AIC.getAssets().open(str, 3);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        AppMethodBeat.m2505o(86583);
        return bArr;
    }

    public static String generateBundlePath(String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(86584);
        if (str2 != null) {
            str3 = str + "." + str2;
        } else {
            str3 = str;
        }
        if (new File(str3).exists()) {
            AppMethodBeat.m2505o(86584);
            return str3;
        }
        Context context = C44569b.AIC;
        if (context == null) {
            AppMethodBeat.m2505o(86584);
            return null;
        }
        File dir = context.getDir("filter", 0);
        if (dir.isDirectory() || dir.mkdirs()) {
            File file = new File(dir, str3);
            if (!file.exists()) {
                file.mkdirs();
                file.delete();
                try {
                    InputStream auA = C44569b.auA(str3);
                    if (auA != null) {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        while (true) {
                            int read = auA.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        auA.close();
                        fileOutputStream.close();
                    } else {
                        C16371i.m25186k("filter", "generateBundlePath notfound".concat(String.valueOf(str)));
                        AppMethodBeat.m2505o(86584);
                        return null;
                    }
                } catch (IOException e) {
                }
            }
            str3 = file.getAbsolutePath();
            AppMethodBeat.m2505o(86584);
            return str3;
        }
        AppMethodBeat.m2505o(86584);
        return null;
    }

    public static byte[] readBundleData(String str) {
        AppMethodBeat.m2504i(86585);
        byte[] bArr = null;
        try {
            InputStream auA = C44569b.auA(str);
            if (auA == null) {
                C16371i.m25188m("FilterDefault", "decodeBitmap  getStream " + str + " not exist");
            }
            bArr = C36570e.m60594O(auA);
            C5989g.closeQuietly(auA);
        } catch (Exception e) {
            C16371i.m25183a("FilterDefault", "decodeBitmap  getStream", e);
        }
        AppMethodBeat.m2505o(86585);
        return bArr;
    }

    public static QImage readBundleImage(String str) {
        AppMethodBeat.m2504i(86586);
        Bitmap vt = C44569b.m80951vt(str);
        if (vt == null || vt.isRecycled()) {
            AppMethodBeat.m2505o(86586);
            return null;
        }
        QImage Bitmap2QImage = QImage.Bitmap2QImage(vt);
        C36569b.recycle(vt);
        AppMethodBeat.m2505o(86586);
        return Bitmap2QImage;
    }

    public static void recycleImage(Bitmap bitmap) {
        AppMethodBeat.m2504i(86587);
        if (!(bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        System.gc();
        AppMethodBeat.m2505o(86587);
    }

    private static String getSDPath() {
        AppMethodBeat.m2504i(86588);
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = Environment.getExternalStorageDirectory();
        }
        String file2 = file.toString();
        AppMethodBeat.m2505o(86588);
        return file2;
    }

    public static void writeToAlbum(long j, int i, int i2) {
        AppMethodBeat.m2504i(86589);
        if (C44569b.AIF) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            C16371i.m25186k("filter", "writeToAlbum: " + i + " " + i2);
            nativeCopyImage(createBitmap, j);
            C16371i.m25186k("filter", "writeToAlbum ret: ".concat(String.valueOf(saveBitmap(createBitmap, getSDPath() + "/filter/" + generateName(System.currentTimeMillis()) + FileUtils.PIC_POSTFIX_JPEG))));
            createBitmap.recycle();
        }
        AppMethodBeat.m2505o(86589);
    }

    private static synchronized String generateName(long j) {
        String format;
        synchronized (FilterEngineJNILib.class) {
            AppMethodBeat.m2504i(86590);
            format = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss").format(new Date(j));
            if (j / 1000 == mLastDate / 1000) {
                mSameSecondCount++;
                format = format + "_" + mSameSecondCount;
            } else {
                mLastDate = j;
                mSameSecondCount = 0;
            }
            AppMethodBeat.m2505o(86590);
        }
        return format;
    }

    private static int saveBitmap(Bitmap bitmap, String str) {
        Throwable th;
        AppMethodBeat.m2504i(86591);
        C16371i.m25186k("filter", "saveBitmap: ".concat(String.valueOf(str)));
        OutputStream outputStream = null;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            C16371i.m25186k("filter", "exists: " + file.exists());
            OutputStream fileOutputStream = new FileOutputStream(str);
            if (bitmap != null) {
                try {
                    bitmap.compress(CompressFormat.JPEG, 95, fileOutputStream);
                    fileOutputStream.flush();
                } catch (Exception e) {
                    outputStream = fileOutputStream;
                    C5989g.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(86591);
                    return 0;
                } catch (OutOfMemoryError e2) {
                    outputStream = fileOutputStream;
                    C5989g.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(86591);
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    C5989g.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(86591);
                    throw th;
                }
            }
            C5989g.closeQuietly(fileOutputStream);
            AppMethodBeat.m2505o(86591);
            return 1;
        } catch (Exception e3) {
            C5989g.closeQuietly(outputStream);
            AppMethodBeat.m2505o(86591);
            return 0;
        } catch (OutOfMemoryError e4) {
            C5989g.closeQuietly(outputStream);
            AppMethodBeat.m2505o(86591);
            return 0;
        } catch (Throwable th3) {
            th = th3;
            C5989g.closeQuietly(outputStream);
            AppMethodBeat.m2505o(86591);
            throw th;
        }
    }
}

package com.tencent.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Environment;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.view.b;
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
        AppMethodBeat.i(86583);
        if (b.AIC == null) {
            AppMethodBeat.o(86583);
            return null;
        }
        InputStream open = b.AIC.getAssets().open(str, 3);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        AppMethodBeat.o(86583);
        return bArr;
    }

    public static String generateBundlePath(String str, String str2) {
        String str3;
        AppMethodBeat.i(86584);
        if (str2 != null) {
            str3 = str + "." + str2;
        } else {
            str3 = str;
        }
        if (new File(str3).exists()) {
            AppMethodBeat.o(86584);
            return str3;
        }
        Context context = b.AIC;
        if (context == null) {
            AppMethodBeat.o(86584);
            return null;
        }
        File dir = context.getDir("filter", 0);
        if (dir.isDirectory() || dir.mkdirs()) {
            File file = new File(dir, str3);
            if (!file.exists()) {
                file.mkdirs();
                file.delete();
                try {
                    InputStream auA = b.auA(str3);
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
                        i.k("filter", "generateBundlePath notfound".concat(String.valueOf(str)));
                        AppMethodBeat.o(86584);
                        return null;
                    }
                } catch (IOException e) {
                }
            }
            str3 = file.getAbsolutePath();
            AppMethodBeat.o(86584);
            return str3;
        }
        AppMethodBeat.o(86584);
        return null;
    }

    public static byte[] readBundleData(String str) {
        AppMethodBeat.i(86585);
        byte[] bArr = null;
        try {
            InputStream auA = b.auA(str);
            if (auA == null) {
                i.m("FilterDefault", "decodeBitmap  getStream " + str + " not exist");
            }
            bArr = e.O(auA);
            g.closeQuietly(auA);
        } catch (Exception e) {
            i.a("FilterDefault", "decodeBitmap  getStream", e);
        }
        AppMethodBeat.o(86585);
        return bArr;
    }

    public static QImage readBundleImage(String str) {
        AppMethodBeat.i(86586);
        Bitmap vt = b.vt(str);
        if (vt == null || vt.isRecycled()) {
            AppMethodBeat.o(86586);
            return null;
        }
        QImage Bitmap2QImage = QImage.Bitmap2QImage(vt);
        b.recycle(vt);
        AppMethodBeat.o(86586);
        return Bitmap2QImage;
    }

    public static void recycleImage(Bitmap bitmap) {
        AppMethodBeat.i(86587);
        if (!(bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        System.gc();
        AppMethodBeat.o(86587);
    }

    private static String getSDPath() {
        AppMethodBeat.i(86588);
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = Environment.getExternalStorageDirectory();
        }
        String file2 = file.toString();
        AppMethodBeat.o(86588);
        return file2;
    }

    public static void writeToAlbum(long j, int i, int i2) {
        AppMethodBeat.i(86589);
        if (b.AIF) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            i.k("filter", "writeToAlbum: " + i + " " + i2);
            nativeCopyImage(createBitmap, j);
            i.k("filter", "writeToAlbum ret: ".concat(String.valueOf(saveBitmap(createBitmap, getSDPath() + "/filter/" + generateName(System.currentTimeMillis()) + FileUtils.PIC_POSTFIX_JPEG))));
            createBitmap.recycle();
        }
        AppMethodBeat.o(86589);
    }

    private static synchronized String generateName(long j) {
        String format;
        synchronized (FilterEngineJNILib.class) {
            AppMethodBeat.i(86590);
            format = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss").format(new Date(j));
            if (j / 1000 == mLastDate / 1000) {
                mSameSecondCount++;
                format = format + "_" + mSameSecondCount;
            } else {
                mLastDate = j;
                mSameSecondCount = 0;
            }
            AppMethodBeat.o(86590);
        }
        return format;
    }

    private static int saveBitmap(Bitmap bitmap, String str) {
        Throwable th;
        AppMethodBeat.i(86591);
        i.k("filter", "saveBitmap: ".concat(String.valueOf(str)));
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
            i.k("filter", "exists: " + file.exists());
            OutputStream fileOutputStream = new FileOutputStream(str);
            if (bitmap != null) {
                try {
                    bitmap.compress(CompressFormat.JPEG, 95, fileOutputStream);
                    fileOutputStream.flush();
                } catch (Exception e) {
                    outputStream = fileOutputStream;
                    g.closeQuietly(outputStream);
                    AppMethodBeat.o(86591);
                    return 0;
                } catch (OutOfMemoryError e2) {
                    outputStream = fileOutputStream;
                    g.closeQuietly(outputStream);
                    AppMethodBeat.o(86591);
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    g.closeQuietly(outputStream);
                    AppMethodBeat.o(86591);
                    throw th;
                }
            }
            g.closeQuietly(fileOutputStream);
            AppMethodBeat.o(86591);
            return 1;
        } catch (Exception e3) {
            g.closeQuietly(outputStream);
            AppMethodBeat.o(86591);
            return 0;
        } catch (OutOfMemoryError e4) {
            g.closeQuietly(outputStream);
            AppMethodBeat.o(86591);
            return 0;
        } catch (Throwable th3) {
            th = th3;
            g.closeQuietly(outputStream);
            AppMethodBeat.o(86591);
            throw th;
        }
    }
}

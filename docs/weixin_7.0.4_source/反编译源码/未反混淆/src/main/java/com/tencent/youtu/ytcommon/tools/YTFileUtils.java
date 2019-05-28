package com.tencent.youtu.ytcommon.tools;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class YTFileUtils {
    private YTFileUtils() {
        AppMethodBeat.i(118086);
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(118086);
        throw assertionError;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A:{SYNTHETIC, Splitter:B:17:0x0055} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static StringBuilder readAssetFile(Context context, String str) {
        RuntimeException runtimeException;
        Throwable e;
        RuntimeException runtimeException2;
        AppMethodBeat.i(118087);
        StringBuilder stringBuilder = new StringBuilder("");
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!stringBuilder.toString().equals("")) {
                            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                        }
                        stringBuilder.append(readLine);
                    } else {
                        try {
                            bufferedReader.close();
                            AppMethodBeat.o(118087);
                            return stringBuilder;
                        } catch (IOException e2) {
                            runtimeException = new RuntimeException("IOException occurred. ", e2);
                            AppMethodBeat.o(118087);
                            throw runtimeException;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        runtimeException2 = new RuntimeException("IOException occurred. ", e);
                        AppMethodBeat.o(118087);
                        throw runtimeException2;
                    } catch (Throwable th) {
                        e = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22) {
                                runtimeException = new RuntimeException("IOException occurred. ", e22);
                                AppMethodBeat.o(118087);
                                throw runtimeException;
                            }
                        }
                        AppMethodBeat.o(118087);
                        throw e;
                    }
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            runtimeException2 = new RuntimeException("IOException occurred. ", e);
            AppMethodBeat.o(118087);
            throw runtimeException2;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(118087);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A:{SYNTHETIC, Splitter:B:21:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static StringBuilder readFile(String str) {
        RuntimeException runtimeException;
        Throwable e;
        RuntimeException runtimeException2;
        AppMethodBeat.i(118088);
        File file = new File(str);
        StringBuilder stringBuilder = new StringBuilder("");
        if (file.isFile()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!stringBuilder.toString().equals("")) {
                                stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                            }
                            stringBuilder.append(readLine);
                        } else {
                            try {
                                bufferedReader.close();
                                AppMethodBeat.o(118088);
                                return stringBuilder;
                            } catch (IOException e2) {
                                runtimeException = new RuntimeException("IOException occurred. ", e2);
                                AppMethodBeat.o(118088);
                                throw runtimeException;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            runtimeException2 = new RuntimeException("IOException occurred. ", e);
                            AppMethodBeat.o(118088);
                            throw runtimeException2;
                        } catch (Throwable e32) {
                            e = e32;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e22) {
                                    runtimeException = new RuntimeException("IOException occurred. ", e22);
                                    AppMethodBeat.o(118088);
                                    throw runtimeException;
                                }
                            }
                            AppMethodBeat.o(118088);
                            throw e;
                        }
                    }
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                runtimeException2 = new RuntimeException("IOException occurred. ", e);
                AppMethodBeat.o(118088);
                throw runtimeException2;
            } catch (Throwable th) {
                e = th;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(118088);
                throw e;
            }
        }
        AppMethodBeat.o(118088);
        return null;
    }

    public static boolean copyAsset(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(118089);
        try {
            InputStream open = assetManager.open(str);
            new File(str2).createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            copyFile(open, fileOutputStream);
            open.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.o(118089);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(118089);
            return false;
        }
    }

    public static void copyFileOrDir(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(118090);
        try {
            String[] list = assetManager.list(str);
            if (list.length == 0) {
                copyAsset(assetManager, str, str2 + "/" + str);
                AppMethodBeat.o(118090);
                return;
            }
            String str3;
            if (str2.endsWith(File.separator)) {
                str3 = str2 + str;
            } else {
                str3 = str2 + File.separator + str;
            }
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdir();
            }
            for (String str4 : list) {
                copyFileOrDir(assetManager, str + "/" + str4, str2);
            }
            AppMethodBeat.o(118090);
        } catch (IOException e) {
            AppMethodBeat.o(118090);
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(118091);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(118091);
                return;
            }
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap;
        AppMethodBeat.i(118092);
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                bitmap = bitmapDrawable.getBitmap();
                AppMethodBeat.o(118092);
                return bitmap;
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        AppMethodBeat.o(118092);
        return bitmap;
    }

    public static boolean zipFileAtPath(String str, String str2) {
        AppMethodBeat.i(118093);
        File file = new File(str);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
            if (!file.isDirectory()) {
                byte[] bArr = new byte[2048];
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 2048);
                zipOutputStream.putNextEntry(new ZipEntry(getLastPathComponent(str)));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            } else {
                zipSubFolder(zipOutputStream, file, file.getParent().length());
            }
            zipOutputStream.close();
            AppMethodBeat.o(118093);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(118093);
            return false;
        }
    }

    private static void zipSubFolder(ZipOutputStream zipOutputStream, File file, int i) {
        AppMethodBeat.i(118094);
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                zipSubFolder(zipOutputStream, file2, i);
            } else {
                byte[] bArr = new byte[2048];
                String path = file2.getPath();
                String substring = path.substring(i);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path), 2048);
                zipOutputStream.putNextEntry(new ZipEntry(substring));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
            }
        }
        AppMethodBeat.o(118094);
    }

    public static String getLastPathComponent(String str) {
        AppMethodBeat.i(118095);
        String[] split = str.split("/");
        String str2;
        if (split.length == 0) {
            str2 = "";
            AppMethodBeat.o(118095);
            return str2;
        }
        str2 = split[split.length - 1];
        AppMethodBeat.o(118095);
        return str2;
    }

    public static void deleteFile(File file) {
        AppMethodBeat.i(118096);
        if (file.isFile()) {
            file.delete();
            AppMethodBeat.o(118096);
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                AppMethodBeat.o(118096);
                return;
            }
            for (File deleteFile : listFiles) {
                deleteFile(deleteFile);
            }
            file.delete();
        }
        AppMethodBeat.o(118096);
    }
}

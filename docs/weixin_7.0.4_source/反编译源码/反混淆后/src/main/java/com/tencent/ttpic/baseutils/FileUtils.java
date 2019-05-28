package com.tencent.ttpic.baseutils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils {
    public static final String PIC_POSTFIX_JPEG = ".jpg";
    public static final String PIC_POSTFIX_PNG = ".png";
    public static final String PIC_POSTFIX_WEBP = ".webp";
    public static final String RES_PREFIX_ASSETS = "assets://";
    public static final String RES_PREFIX_HTTP = "http://";
    public static final String RES_PREFIX_HTTPS = "https://";
    public static final String RES_PREFIX_STORAGE = "/";
    public static final AssetFileComparator SIMPLE_ASSET_COMPARATOR = new C59742();
    private static final String TAG = FileUtils.class.getSimpleName();

    /* renamed from: com.tencent.ttpic.baseutils.FileUtils$2 */
    static class C59742 implements AssetFileComparator {
        C59742() {
        }

        public final boolean equals(Context context, String str, File file) {
            AppMethodBeat.m2504i(49672);
            long access$000 = FileUtils.access$000(context, str);
            if (access$000 == -1 || access$000 != file.length()) {
                AppMethodBeat.m2505o(49672);
                return false;
            }
            AppMethodBeat.m2505o(49672);
            return true;
        }
    }

    static class FileCopyTask extends AsyncTask<String, String, Boolean> {
        String mDestPath;
        OnFileCopyListener mListener;
        InputStream mSrcInputStream;

        FileCopyTask(InputStream inputStream, String str) {
            this.mSrcInputStream = inputStream;
            this.mDestPath = str;
        }

        public void setOnFileCopyListener(OnFileCopyListener onFileCopyListener) {
            this.mListener = onFileCopyListener;
        }

        /* Access modifiers changed, original: protected */
        public void onPreExecute() {
            AppMethodBeat.m2504i(49673);
            super.onPreExecute();
            if (this.mListener != null) {
                this.mListener.onCopyStart();
            }
            AppMethodBeat.m2505o(49673);
        }

        /* Access modifiers changed, original: protected|varargs */
        public Boolean doInBackground(String... strArr) {
            AppMethodBeat.m2504i(49674);
            Boolean valueOf = Boolean.valueOf(FileUtils.copyFile(this.mSrcInputStream, this.mDestPath));
            AppMethodBeat.m2505o(49674);
            return valueOf;
        }

        /* Access modifiers changed, original: protected */
        public void onPostExecute(Boolean bool) {
            AppMethodBeat.m2504i(49675);
            super.onPostExecute(bool);
            if (this.mListener != null) {
                if (bool.booleanValue()) {
                    this.mListener.onCopySuccess();
                    AppMethodBeat.m2505o(49675);
                    return;
                }
                this.mListener.onCopyFailed();
            }
            AppMethodBeat.m2505o(49675);
        }
    }

    public interface OnFileCopyListener {
        void onCopyFailed();

        void onCopyStart();

        void onCopySuccess();
    }

    public interface AssetFileComparator {
        boolean equals(Context context, String str, File file);
    }

    static /* synthetic */ long access$000(Context context, String str) {
        AppMethodBeat.m2504i(49715);
        long assetLength = getAssetLength(context, str);
        AppMethodBeat.m2505o(49715);
        return assetLength;
    }

    static {
        AppMethodBeat.m2504i(49716);
        AppMethodBeat.m2505o(49716);
    }

    public static String checkPhoto(String str) {
        AppMethodBeat.m2504i(49678);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49678);
            return null;
        } else if (new File(str).exists()) {
            AppMethodBeat.m2505o(49678);
            return str;
        } else {
            if (str.substring(str.lastIndexOf("/")).lastIndexOf(".") == -1) {
                String str2 = str + PIC_POSTFIX_JPEG;
                if (new File(str2).exists()) {
                    AppMethodBeat.m2505o(49678);
                    return str2;
                }
                str2 = str + ".png";
                if (new File(str2).exists()) {
                    AppMethodBeat.m2505o(49678);
                    return str2;
                }
            }
            AppMethodBeat.m2505o(49678);
            return str;
        }
    }

    public static String checkAssetsPhoto(Context context, String str) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(49679);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49679);
            return inputStream;
        }
        AssetManager assets = context.getAssets();
        try {
            inputStream = assets.open(str);
            return str;
        } catch (IOException e) {
            IOUtils.closeQuietly(inputStream);
            if (str.lastIndexOf(".") != -1) {
                str = str.substring(0, str.lastIndexOf(46) + 1) + "webp";
                try {
                    inputStream = assets.open(str);
                    return str;
                } catch (IOException e2) {
                    IOUtils.closeQuietly(inputStream);
                    AppMethodBeat.m2505o(49679);
                    return inputStream;
                } catch (Throwable th) {
                    IOUtils.closeQuietly(inputStream);
                    AppMethodBeat.m2505o(49679);
                }
            }
            String str2 = str + PIC_POSTFIX_JPEG;
            try {
                inputStream = assets.open(str2);
                return str2;
            } catch (IOException e3) {
                IOUtils.closeQuietly(inputStream);
                str2 = str + PIC_POSTFIX_WEBP;
                try {
                    inputStream = assets.open(str2);
                    return str2;
                } catch (IOException e4) {
                    IOUtils.closeQuietly(inputStream);
                    str = str + ".png";
                    try {
                        inputStream = assets.open(str);
                        return str;
                    } catch (IOException e5) {
                        return inputStream;
                    } finally {
                        IOUtils.closeQuietly(inputStream);
                        AppMethodBeat.m2505o(49679);
                    }
                } catch (Throwable th2) {
                    IOUtils.closeQuietly(inputStream);
                    AppMethodBeat.m2505o(49679);
                }
            } finally {
                IOUtils.closeQuietly(inputStream);
                AppMethodBeat.m2505o(49679);
            }
        } finally {
            IOUtils.closeQuietly(inputStream);
            AppMethodBeat.m2505o(49679);
        }
    }

    public static boolean isDirectoryWritable(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(49680);
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.isDirectory()) {
                try {
                    z = file.canWrite();
                    AppMethodBeat.m2505o(49680);
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(49680);
        } else {
            AppMethodBeat.m2505o(49680);
        }
        return z;
    }

    public static String getRealPath(String str) {
        AppMethodBeat.m2504i(49681);
        if (TextUtils.isEmpty(str) || !str.startsWith("assets://")) {
            AppMethodBeat.m2505o(49681);
            return str;
        }
        str = str.substring(9);
        AppMethodBeat.m2505o(49681);
        return str;
    }

    public static String getFileNameByPath(String str) {
        AppMethodBeat.m2504i(49682);
        LogUtils.m50210v(TAG, "[getFileNameByPath] path = ".concat(String.valueOf(str)));
        Object obj = null;
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(".");
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf >= 0 && indexOf > lastIndexOf) {
                obj = str.substring(lastIndexOf + 1, indexOf);
            }
        }
        LogUtils.m50210v(TAG, "[getFileNameByPath] return title = ".concat(String.valueOf(obj)));
        AppMethodBeat.m2505o(49682);
        return obj;
    }

    public static String getFileNameFromUrl(String str) {
        AppMethodBeat.m2504i(49683);
        if (str == null) {
            AppMethodBeat.m2505o(49683);
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            AppMethodBeat.m2505o(49683);
            return null;
        } else if (lastIndexOf == str.length() - 1) {
            AppMethodBeat.m2505o(49683);
            return null;
        } else {
            String substring = str.substring(lastIndexOf + 1);
            AppMethodBeat.m2505o(49683);
            return substring;
        }
    }

    public static String getFileSuffixFromUrl(String str) {
        AppMethodBeat.m2504i(49684);
        if (str == null) {
            AppMethodBeat.m2505o(49684);
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            AppMethodBeat.m2505o(49684);
            return null;
        } else if (lastIndexOf == str.length() - 1) {
            AppMethodBeat.m2505o(49684);
            return null;
        } else {
            String substring = str.substring(lastIndexOf + 1);
            AppMethodBeat.m2505o(49684);
            return substring;
        }
    }

    public static void save(File file, String str) {
        Writer bufferedWriter;
        Throwable e;
        AppMethodBeat.m2504i(49685);
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = null;
                try {
                    LogUtils.m50206e(e);
                    IOUtils.closeQuietly(fileOutputStream);
                    IOUtils.closeQuietly(bufferedWriter);
                    AppMethodBeat.m2505o(49685);
                } catch (Throwable th) {
                    e = th;
                    IOUtils.closeQuietly(fileOutputStream);
                    IOUtils.closeQuietly(bufferedWriter);
                    AppMethodBeat.m2505o(49685);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedWriter = null;
                IOUtils.closeQuietly(fileOutputStream);
                IOUtils.closeQuietly(bufferedWriter);
                AppMethodBeat.m2505o(49685);
                throw e;
            }
            try {
                bufferedWriter.write(str);
                IOUtils.closeQuietly(fileOutputStream);
                IOUtils.closeQuietly(bufferedWriter);
                AppMethodBeat.m2505o(49685);
            } catch (Exception e3) {
                e = e3;
                LogUtils.m50206e(e);
                IOUtils.closeQuietly(fileOutputStream);
                IOUtils.closeQuietly(bufferedWriter);
                AppMethodBeat.m2505o(49685);
            }
        } catch (Exception e4) {
            e = e4;
            bufferedWriter = null;
            fileOutputStream = null;
            LogUtils.m50206e(e);
            IOUtils.closeQuietly(fileOutputStream);
            IOUtils.closeQuietly(bufferedWriter);
            AppMethodBeat.m2505o(49685);
        } catch (Throwable th3) {
            e = th3;
            bufferedWriter = null;
            fileOutputStream = null;
            IOUtils.closeQuietly(fileOutputStream);
            IOUtils.closeQuietly(bufferedWriter);
            AppMethodBeat.m2505o(49685);
            throw e;
        }
    }

    public static String load(Context context, String str, String str2) {
        AppMethodBeat.m2504i(49686);
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str3 = "";
            AppMethodBeat.m2505o(49686);
            return str3;
        } else if (str.startsWith("assets://")) {
            str3 = loadAssetsString(context, getRealPath(str) + File.separator + str2);
            AppMethodBeat.m2505o(49686);
            return str3;
        } else {
            str3 = load(new File(str + File.separator + str2));
            AppMethodBeat.m2505o(49686);
            return str3;
        }
    }

    private static String load(File file) {
        InputStream inputStream;
        Throwable th;
        AppMethodBeat.m2504i(49687);
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream.read(bArr);
                String str = new String(bArr, "UTF-8");
                IOUtils.closeQuietly(fileInputStream);
                AppMethodBeat.m2505o(49687);
                return str;
            } catch (FileNotFoundException e) {
                inputStream = fileInputStream;
                IOUtils.closeQuietly(inputStream);
                AppMethodBeat.m2505o(49687);
                return null;
            } catch (Exception e2) {
                IOUtils.closeQuietly(fileInputStream);
                AppMethodBeat.m2505o(49687);
                return null;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(fileInputStream);
                AppMethodBeat.m2505o(49687);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            inputStream = null;
            IOUtils.closeQuietly(inputStream);
            AppMethodBeat.m2505o(49687);
            return null;
        } catch (Exception e4) {
            fileInputStream = null;
            IOUtils.closeQuietly(fileInputStream);
            AppMethodBeat.m2505o(49687);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            IOUtils.closeQuietly(fileInputStream);
            AppMethodBeat.m2505o(49687);
            throw th;
        }
    }

    public static String loadAssetsString(Context context, String str) {
        String stringBuilder;
        Throwable th;
        Reader reader;
        AppMethodBeat.m2504i(49688);
        StringBuilder stringBuilder2 = new StringBuilder();
        InputStream open;
        Reader bufferedReader;
        try {
            open = context.getAssets().open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder2.append(readLine);
                        stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                    } catch (IOException e) {
                        IOUtils.closeQuietly(bufferedReader);
                        IOUtils.closeQuietly(open);
                        stringBuilder = stringBuilder2.toString();
                        AppMethodBeat.m2505o(49688);
                        return stringBuilder;
                    } catch (Throwable th2) {
                        th = th2;
                        reader = bufferedReader;
                        IOUtils.closeQuietly(reader);
                        IOUtils.closeQuietly(open);
                        AppMethodBeat.m2505o(49688);
                        throw th;
                    }
                }
                IOUtils.closeQuietly(bufferedReader);
                IOUtils.closeQuietly(open);
            } catch (IOException e2) {
                bufferedReader = null;
                IOUtils.closeQuietly(bufferedReader);
                IOUtils.closeQuietly(open);
                stringBuilder = stringBuilder2.toString();
                AppMethodBeat.m2505o(49688);
                return stringBuilder;
            } catch (Throwable th3) {
                th = th3;
                reader = null;
                IOUtils.closeQuietly(reader);
                IOUtils.closeQuietly(open);
                AppMethodBeat.m2505o(49688);
                throw th;
            }
        } catch (IOException e3) {
            bufferedReader = null;
            open = null;
        } catch (Throwable th32) {
            th = th32;
            reader = null;
            open = null;
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(open);
            AppMethodBeat.m2505o(49688);
            throw th;
        }
        stringBuilder = stringBuilder2.toString();
        AppMethodBeat.m2505o(49688);
        return stringBuilder;
    }

    public static String loadRawResourceString(Context context, int i) {
        AppMethodBeat.m2504i(49689);
        Reader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(i));
        Reader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine);
                    stringBuilder.append(10);
                } else {
                    IOUtils.closeQuietly(inputStreamReader);
                    IOUtils.closeQuietly(bufferedReader);
                    String stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.m2505o(49689);
                    return stringBuilder2;
                }
            } catch (IOException e) {
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(bufferedReader);
                AppMethodBeat.m2505o(49689);
                return null;
            } catch (Throwable th) {
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(bufferedReader);
                AppMethodBeat.m2505o(49689);
            }
        }
    }

    public static boolean copyAssets(Context context, String str, String str2) {
        AppMethodBeat.m2504i(49690);
        boolean copyAssets = copyAssets(context, str, str2, SIMPLE_ASSET_COMPARATOR);
        AppMethodBeat.m2505o(49690);
        return copyAssets;
    }

    public static boolean copyAssets(Context context, String str, String str2, AssetFileComparator assetFileComparator) {
        AppMethodBeat.m2504i(49691);
        boolean performCopyAssetsFile = performCopyAssetsFile(context, str, str2, assetFileComparator);
        AppMethodBeat.m2505o(49691);
        return performCopyAssetsFile;
    }

    private static boolean performCopyAssetsFile(Context context, String str, String str2, AssetFileComparator assetFileComparator) {
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        boolean z = false;
        Closeable closeable3 = null;
        AppMethodBeat.m2504i(49692);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(49692);
            return false;
        }
        AssetManager assets = context.getAssets();
        File file = new File(str2);
        Closeable open;
        Closeable bufferedOutputStream;
        try {
            if (file.exists()) {
                if (assetFileComparator != null && assetFileComparator.equals(context, str, file)) {
                    closeSilently(null);
                    closeSilently(null);
                    AppMethodBeat.m2505o(49692);
                    return true;
                } else if (file.isDirectory()) {
                    delete(file);
                }
            }
            File parentFile = file.getParentFile();
            if (parentFile.isFile()) {
                delete(parentFile);
            }
            if (parentFile.exists() || parentFile.mkdirs()) {
                open = assets.open(str);
                try {
                    if (open.available() > 0) {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = open.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            closeable3 = bufferedOutputStream;
                            z = true;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable2 = bufferedOutputStream;
                            closeSilently(open);
                            closeSilently(closeable2);
                            AppMethodBeat.m2505o(49692);
                            throw th;
                        }
                    }
                    closeSilently(open);
                    closeSilently(closeable3);
                } catch (Throwable th3) {
                    th = th3;
                    closeable2 = null;
                    closeSilently(open);
                    closeSilently(closeable2);
                    AppMethodBeat.m2505o(49692);
                    throw th;
                }
                AppMethodBeat.m2505o(49692);
                return z;
            }
            closeSilently(null);
            closeSilently(null);
            AppMethodBeat.m2505o(49692);
            return false;
        } catch (Throwable th32) {
            th = th32;
            closeable2 = null;
            open = null;
            closeSilently(open);
            closeSilently(closeable2);
            AppMethodBeat.m2505o(49692);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037 A:{SYNTHETIC, Splitter:B:22:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long getAssetLength(Context context, String str) {
        long length;
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        Closeable closeable = null;
        AppMethodBeat.m2504i(49693);
        AssetManager assets = context.getAssets();
        AssetFileDescriptor openFd;
        try {
            openFd = assets.openFd(str);
            try {
                length = openFd.getLength();
                if (openFd != null) {
                    try {
                        openFd.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(49693);
                return length;
            } catch (IOException e2) {
                assetFileDescriptor = openFd;
            } catch (Throwable th2) {
                th = th2;
                if (openFd != null) {
                }
                AppMethodBeat.m2505o(49693);
                throw th;
            }
        } catch (IOException e3) {
            assetFileDescriptor = null;
        } catch (Throwable th3) {
            th = th3;
            openFd = null;
            if (openFd != null) {
                try {
                    openFd.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.m2505o(49693);
            throw th;
        }
        Closeable open;
        try {
            open = assets.open(str);
            try {
                length = (long) open.available();
                closeSilently(open);
                AppMethodBeat.m2505o(49693);
                return length;
            } catch (IOException e5) {
                closeable = open;
                closeSilently(closeable);
                AppMethodBeat.m2505o(49693);
                return -1;
            } catch (Throwable th4) {
                th = th4;
                closeSilently(open);
                AppMethodBeat.m2505o(49693);
                throw th;
            }
        } catch (IOException e6) {
        } catch (Throwable th5) {
            th = th5;
            open = null;
            closeSilently(open);
            AppMethodBeat.m2505o(49693);
            throw th;
        }
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e7) {
            }
        }
        open = assets.open(str);
        length = (long) open.available();
        closeSilently(open);
        AppMethodBeat.m2505o(49693);
        return length;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030 A:{Catch:{ IOException -> 0x003a }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047 A:{Catch:{ IOException -> 0x0051 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyRaw(Context context, int i, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        AppMethodBeat.m2504i(49694);
        InputStream openRawResource = context.getResources().openRawResource(i);
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(str);
            try {
                copyFile(openRawResource, (OutputStream) fileOutputStream2);
                try {
                    openRawResource.close();
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    AppMethodBeat.m2505o(49694);
                } catch (IOException e) {
                    AppMethodBeat.m2505o(49694);
                }
            } catch (Exception e2) {
                try {
                    openRawResource.close();
                    if (fileOutputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(49694);
                } catch (IOException e3) {
                    AppMethodBeat.m2505o(49694);
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    openRawResource.close();
                    if (fileOutputStream != null) {
                    }
                } catch (IOException e4) {
                }
                AppMethodBeat.m2505o(49694);
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream2 = null;
            openRawResource.close();
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            AppMethodBeat.m2505o(49694);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            openRawResource.close();
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            AppMethodBeat.m2505o(49694);
            throw th;
        }
    }

    public static void clearDir(File file) {
        AppMethodBeat.m2504i(49695);
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(49695);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    clearDir(file2);
                } else {
                    file2.delete();
                }
            }
            file.delete();
            AppMethodBeat.m2505o(49695);
            return;
        }
        AppMethodBeat.m2505o(49695);
    }

    public static void clearDirs(File[] fileArr) {
        AppMethodBeat.m2504i(49696);
        if (fileArr == null) {
            AppMethodBeat.m2505o(49696);
            return;
        }
        for (File clearDir : fileArr) {
            clearDir(clearDir);
        }
        AppMethodBeat.m2505o(49696);
    }

    public static boolean exists(String str) {
        AppMethodBeat.m2504i(49697);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49697);
            return false;
        } else if (str.indexOf("assets") >= 0 || new File(str).exists()) {
            AppMethodBeat.m2505o(49697);
            return true;
        } else {
            AppMethodBeat.m2505o(49697);
            return false;
        }
    }

    public static boolean Move(File file, String str) {
        AppMethodBeat.m2504i(49698);
        boolean renameTo = file.renameTo(new File(new File(str), file.getName()));
        AppMethodBeat.m2505o(49698);
        return renameTo;
    }

    public static void delete(String str) {
        AppMethodBeat.m2504i(49699);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49699);
            return;
        }
        delete(new File(str));
        AppMethodBeat.m2505o(49699);
    }

    public static void delete(File file) {
        AppMethodBeat.m2504i(49700);
        if (file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(49700);
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                AppMethodBeat.m2505o(49700);
                return;
            }
            for (File delete : listFiles) {
                delete(delete);
            }
            file.delete();
        }
        AppMethodBeat.m2505o(49700);
    }

    public static void delete(File file, boolean z) {
        AppMethodBeat.m2504i(49701);
        if (file == null || !file.exists()) {
            AppMethodBeat.m2505o(49701);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(49701);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(49701);
                return;
            }
            for (File delete : listFiles) {
                delete(delete, z);
            }
            if (!z) {
                file.delete();
            }
            AppMethodBeat.m2505o(49701);
        }
    }

    public static void deleteFiles(String str, final String str2) {
        AppMethodBeat.m2504i(49702);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49702);
            return;
        }
        File[] listFiles = new File(str).listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.m2504i(49671);
                if (TextUtils.isEmpty(str2)) {
                    AppMethodBeat.m2505o(49671);
                    return true;
                }
                boolean endsWith = str.endsWith(str2);
                AppMethodBeat.m2505o(49671);
                return endsWith;
            }
        });
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        AppMethodBeat.m2505o(49702);
    }

    public static void deleteAllFilesOfDir(File file) {
        AppMethodBeat.m2504i(49703);
        if (!file.exists()) {
            AppMethodBeat.m2505o(49703);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(49703);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteAllFilesOfDir : listFiles) {
                    deleteAllFilesOfDir(deleteAllFilesOfDir);
                }
            }
            file.delete();
            AppMethodBeat.m2505o(49703);
        }
    }

    private static void closeSilently(Closeable closeable) {
        AppMethodBeat.m2504i(49704);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.m2505o(49704);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.m2505o(49704);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044 A:{SYNTHETIC, Splitter:B:16:0x0044} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A:{SYNTHETIC, Splitter:B:19:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A:{SYNTHETIC, Splitter:B:31:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A:{SYNTHETIC, Splitter:B:34:0x006a} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089 A:{SYNTHETIC, Splitter:B:48:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009a A:{SYNTHETIC, Splitter:B:57:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A:{SYNTHETIC, Splitter:B:31:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A:{SYNTHETIC, Splitter:B:34:0x006a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String readTxtFile(Context context, String str) {
        Throwable th;
        BufferedReader bufferedReader;
        Throwable th2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        AppMethodBeat.m2504i(49705);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49705);
            return null;
        }
        String readLine;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader4;
        if (str.startsWith("assets://")) {
            InputStream open;
            try {
                open = context.getAssets().open(str.substring(9));
                try {
                    bufferedReader4 = new BufferedReader(new InputStreamReader(open));
                    while (true) {
                        try {
                            readLine = bufferedReader4.readLine();
                            if (readLine != null) {
                                stringBuilder.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            if (bufferedReader4 != null) {
                                try {
                                    bufferedReader4.close();
                                } catch (IOException e3) {
                                }
                            }
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (IOException e4) {
                                }
                            }
                            readLine = stringBuilder.toString();
                            AppMethodBeat.m2505o(49705);
                            return readLine;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader4;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                }
                            }
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (IOException e6) {
                                }
                            }
                            AppMethodBeat.m2505o(49705);
                            throw th;
                        }
                    }
                    bufferedReader4.close();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (IOException e8) {
                    bufferedReader4 = null;
                    if (bufferedReader4 != null) {
                    }
                    if (open != null) {
                    }
                    readLine = stringBuilder.toString();
                    AppMethodBeat.m2505o(49705);
                    return readLine;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (open != null) {
                    }
                    AppMethodBeat.m2505o(49705);
                    throw th;
                }
            } catch (IOException e9) {
                bufferedReader4 = null;
                open = null;
            } catch (Throwable th42) {
                th = th42;
                bufferedReader = null;
                open = null;
                if (bufferedReader != null) {
                }
                if (open != null) {
                }
                AppMethodBeat.m2505o(49705);
                throw th;
            }
        }
        try {
            bufferedReader4 = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    readLine = bufferedReader4.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e10) {
                        }
                    }
                } catch (IOException e11) {
                    bufferedReader3 = bufferedReader4;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e12) {
                        }
                    }
                    readLine = stringBuilder.toString();
                    AppMethodBeat.m2505o(49705);
                    return readLine;
                } catch (Throwable th32) {
                    th2 = th32;
                    bufferedReader2 = bufferedReader4;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e13) {
                        }
                    }
                    AppMethodBeat.m2505o(49705);
                    throw th2;
                }
            }
            bufferedReader4.close();
        } catch (IOException e14) {
            if (bufferedReader3 != null) {
            }
            readLine = stringBuilder.toString();
            AppMethodBeat.m2505o(49705);
            return readLine;
        } catch (Throwable th422) {
            th2 = th422;
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
            }
            AppMethodBeat.m2505o(49705);
            throw th2;
        }
        readLine = stringBuilder.toString();
        AppMethodBeat.m2505o(49705);
        return readLine;
    }

    public static String getSHA1(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(49706);
        if (new File(str).exists()) {
            try {
                int read;
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[4096];
                while (true) {
                    read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                fileInputStream.close();
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : instance.digest()) {
                    int i = b & 255;
                    stringBuilder.append(i < 16 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
                    stringBuilder.append(Integer.toHexString(i).toLowerCase());
                }
                str2 = stringBuilder.toString();
                AppMethodBeat.m2505o(49706);
            } catch (Exception e) {
                AppMethodBeat.m2505o(49706);
            }
        } else {
            AppMethodBeat.m2505o(49706);
        }
        return str2;
    }

    public static String getMD5(String str, String str2) {
        String str3 = null;
        AppMethodBeat.m2504i(49707);
        if (new File(str).exists()) {
            try {
                int read;
                MessageDigest instance = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[4096];
                while (true) {
                    read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                instance.update(str2.getBytes());
                fileInputStream.close();
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : instance.digest()) {
                    int i = b & 255;
                    stringBuilder.append(i < 16 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
                    stringBuilder.append(Integer.toHexString(i).toLowerCase());
                }
                str3 = stringBuilder.toString();
                AppMethodBeat.m2505o(49707);
            } catch (Exception e) {
                AppMethodBeat.m2505o(49707);
            }
        } else {
            AppMethodBeat.m2505o(49707);
        }
        return str3;
    }

    public static String md5ForBase64Data(String str) {
        int i = 0;
        AppMethodBeat.m2504i(49708);
        char[] cArr = new char[]{'r', 'D', 'z', 'o', 'i', 'e', '5', 'e', '3', 'o', 'n', 'g', 'f', 'z', '1', 'l'};
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i2 = 0; i2 < 16; i2++) {
            stringBuffer.append(cArr[i2]);
        }
        String stringBuffer2;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(stringBuffer.toString().getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer3 = new StringBuffer();
            int length = digest.length;
            while (i < length) {
                stringBuffer3.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i] & 255)}));
                i++;
            }
            stringBuffer2 = stringBuffer3.toString();
            AppMethodBeat.m2505o(49708);
            return stringBuffer2;
        } catch (NoSuchAlgorithmException e) {
            stringBuffer2 = "";
            AppMethodBeat.m2505o(49708);
            return stringBuffer2;
        }
    }

    public static String toBase64(String str) {
        String str2;
        AppMethodBeat.m2504i(49709);
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 2);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                base64OutputStream.write(bArr, 0, read);
            }
            base64OutputStream.flush();
            base64OutputStream.close();
            str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            try {
                byteArrayOutputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            str2 = null;
        }
        AppMethodBeat.m2505o(49709);
        return str2;
    }

    public static boolean copyFile(String str, String str2) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(49710);
        try {
            if (new File(str).exists()) {
                fileInputStream = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    try {
                        LogUtils.m50206e(e);
                        IOUtils.closeQuietly(fileInputStream);
                        IOUtils.closeQuietly(fileOutputStream);
                        AppMethodBeat.m2505o(49710);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.closeQuietly(fileInputStream);
                        IOUtils.closeQuietly(fileOutputStream);
                        AppMethodBeat.m2505o(49710);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    IOUtils.closeQuietly(fileInputStream);
                    IOUtils.closeQuietly(fileOutputStream);
                    AppMethodBeat.m2505o(49710);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            IOUtils.closeQuietly(fileInputStream);
                            IOUtils.closeQuietly(fileOutputStream);
                            AppMethodBeat.m2505o(49710);
                            return true;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    LogUtils.m50206e(e);
                    IOUtils.closeQuietly(fileInputStream);
                    IOUtils.closeQuietly(fileOutputStream);
                    AppMethodBeat.m2505o(49710);
                    return false;
                }
            }
            IOUtils.closeQuietly(null);
            IOUtils.closeQuietly(null);
            AppMethodBeat.m2505o(49710);
            return false;
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
            IOUtils.closeQuietly(fileInputStream);
            IOUtils.closeQuietly(fileOutputStream);
            AppMethodBeat.m2505o(49710);
            throw th;
        }
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.m2504i(49711);
        if (inputStream == null || outputStream == null) {
            AppMethodBeat.m2505o(49711);
            return false;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
        } catch (Exception e) {
            LogUtils.m50206e(e);
        }
        AppMethodBeat.m2505o(49711);
        return true;
    }

    public static boolean copyFile(InputStream inputStream, String str) {
        Throwable th;
        AppMethodBeat.m2504i(49712);
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(fileOutputStream);
                        AppMethodBeat.m2505o(49712);
                        return true;
                    }
                }
            } catch (Exception e) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(fileOutputStream);
                AppMethodBeat.m2505o(49712);
                return false;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(fileOutputStream);
                AppMethodBeat.m2505o(49712);
                throw th;
            }
        } catch (Exception e2) {
            fileOutputStream = null;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
            AppMethodBeat.m2505o(49712);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
            AppMethodBeat.m2505o(49712);
            throw th;
        }
    }

    public static void asyncCopyFile(InputStream inputStream, String str, OnFileCopyListener onFileCopyListener) {
        AppMethodBeat.m2504i(49713);
        FileCopyTask fileCopyTask = new FileCopyTask(inputStream, str);
        fileCopyTask.setOnFileCopyListener(onFileCopyListener);
        fileCopyTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[0]);
        AppMethodBeat.m2505o(49713);
    }

    public static String readTextFileFromRaw(Context context, int i) {
        AppMethodBeat.m2504i(49714);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i)));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine);
                    stringBuilder.append(10);
                } else {
                    String stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.m2505o(49714);
                    return stringBuilder2;
                }
            } catch (IOException e) {
                AppMethodBeat.m2505o(49714);
                return null;
            }
        }
    }
}

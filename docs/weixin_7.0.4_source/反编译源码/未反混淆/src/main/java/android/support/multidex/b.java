package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.xwalk.core.XWalkEnvironment;

final class b {
    private static Method wZ;

    static List<File> a(Context context, ApplicationInfo applicationInfo, File file, boolean z) {
        List a;
        Object obj = null;
        new StringBuilder("MultiDexExtractor.load(").append(applicationInfo.sourceDir).append(", ").append(z).append(")");
        File file2 = new File(applicationInfo.sourceDir);
        long g = c.g(file2);
        if (g == -1) {
            g--;
        }
        if (!z) {
            SharedPreferences K = K(context);
            if (!(K.getLong(Param.TIMESTAMP, -1) == e(file2) && K.getLong("crc", -1) == g)) {
                obj = 1;
            }
            if (obj == null) {
                try {
                    a = a(context, file2, file);
                } catch (IOException e) {
                }
                new StringBuilder("load found ").append(a.size()).append(" secondary dex files");
                return a;
            }
        }
        a = c(file2, file);
        long e2 = e(file2);
        int size = a.size() + 1;
        Editor edit = K(context).edit();
        edit.putLong(Param.TIMESTAMP, e2);
        edit.putLong("crc", g);
        edit.putInt("dex.number", size);
        if (wZ != null) {
            try {
                wZ.invoke(edit, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException e3) {
            }
            new StringBuilder("load found ").append(a.size()).append(" secondary dex files");
            return a;
        }
        edit.commit();
        new StringBuilder("load found ").append(a.size()).append(" secondary dex files");
        return a;
    }

    private static List<File> a(Context context, File file, File file2) {
        String str = file.getName() + ".classes";
        int i = K(context).getInt("dex.number", 1);
        ArrayList arrayList = new ArrayList(i);
        int i2 = 2;
        while (i2 <= i) {
            File file3 = new File(file2, str + i2 + ".zip");
            if (file3.isFile()) {
                arrayList.add(file3);
                if (f(file3)) {
                    i2++;
                } else {
                    new StringBuilder("Invalid zip file: ").append(file3);
                    throw new IOException("Invalid ZIP file.");
                }
            }
            throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
        }
        return arrayList;
    }

    private static long e(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static List<File> c(File file, File file2) {
        String str = file.getName() + ".classes";
        b(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i + ".zip");
                arrayList.add(file3);
                new StringBuilder("Extraction is needed for file ").append(file3);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    i2++;
                    a(zipFile, entry, file3, str);
                    boolean f = f(file3);
                    new StringBuilder("Extraction ").append(f ? "success" : "failed").append(" - length ").append(file3.getAbsolutePath()).append(": ").append(file3.length());
                    if (!f) {
                        file3.delete();
                        if (file3.exists()) {
                            new StringBuilder("Failed to delete corrupted secondary dex '").append(file3.getPath()).append("'");
                            z = f;
                        }
                    }
                    z = f;
                }
                if (z) {
                    int i3 = i + 1;
                    entry = zipFile.getEntry("classes" + i3 + ".dex");
                    i = i3;
                } else {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    private static SharedPreferences K(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void b(File file, final String str) {
        file.mkdirs();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return !file.getName().startsWith(str);
                }
            });
            if (listFiles == null) {
                new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
                return;
            }
            for (File file2 : listFiles) {
                new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
                if (file2.delete()) {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                }
            }
            return;
        }
        throw new IOException("Failed to create dex directory " + file.getPath());
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(str, ".zip", file.getParentFile());
        new StringBuilder("Extracting ").append(createTempFile.getPath());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry(XWalkEnvironment.XWALK_CORE_CLASSES_DEX);
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            new StringBuilder("Renaming to ").append(file.getPath());
            if (createTempFile.renameTo(file)) {
                closeQuietly(inputStream);
                createTempFile.delete();
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A:{Splitter:B:0:0x0000, ExcHandler: ZipException (e java.util.zip.ZipException)} */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A:{Splitter:B:0:0x0000, ExcHandler: ZipException (e java.util.zip.ZipException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:7:?, code skipped:
            new java.lang.StringBuilder("Failed to close zip file: ").append(r2.getAbsolutePath());
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            new java.lang.StringBuilder("File ").append(r2.getAbsolutePath()).append(" is not a valid zip file.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean f(File file) {
        try {
            new ZipFile(file).close();
            return true;
        } catch (ZipException e) {
        } catch (IOException e2) {
            new StringBuilder("Got an IOException trying to open zip file: ").append(file.getAbsolutePath());
        }
        return false;
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    static {
        try {
            wZ = Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e) {
            wZ = null;
        }
    }
}

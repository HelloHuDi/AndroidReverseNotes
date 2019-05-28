package com.tencent.xweb;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.util.f;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class XWebCoreContentProvider extends ContentProvider {

    public static class d {
        public String ANj = "";
        public String ANk = "";
        public int ihB = 0;
        public int opType = -1;
    }

    public static class c {
        public String ANh = "";
        public d ANi = new d();
        public int errCode = -1;

        public c() {
            AppMethodBeat.i(3947);
            AppMethodBeat.o(3947);
        }
    }

    public static class a {
        private static List<b> ANf = new ArrayList();
        private static final Object ANg = new Object();

        static {
            AppMethodBeat.i(3946);
            AppMethodBeat.o(3946);
        }

        public static void a(b bVar) {
            AppMethodBeat.i(3944);
            synchronized (ANg) {
                try {
                    ANf.add(bVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(3944);
                }
            }
        }

        public static void dUn() {
            AppMethodBeat.i(3945);
            Log.i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
            synchronized (ANg) {
                try {
                    for (b bVar : ANf) {
                        f.bX(bVar.key, bVar.value);
                    }
                    ANf.clear();
                } finally {
                    AppMethodBeat.o(3945);
                }
            }
        }
    }

    public static class b {
        public int key = -1;
        public String value = "";
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(3948);
        if (contentValues == null || contentValues.size() == 0) {
            Log.d("XWebCoreContentProvider", "insert values is null or empty");
            AppMethodBeat.o(3948);
        } else if (y(uri).opType != 3) {
            Log.d("XWebCoreContentProvider", "insert wrong opType");
            AppMethodBeat.o(3948);
        } else {
            Context context = getContext();
            if (context == null) {
                Log.e("XWebCoreContentProvider", "insert context is null");
                AppMethodBeat.o(3948);
            } else if ("com.tencent.mm".equals(context.getPackageName())) {
                Log.d("XWebCoreContentProvider", "insert start report");
                for (Entry entry : contentValues.valueSet()) {
                    try {
                        int parseInt = Integer.parseInt((String) entry.getKey());
                        String str = (String) entry.getValue();
                        if (!(!f.Sw(parseInt) || str == null || str.isEmpty())) {
                            if (f.hasInit()) {
                                Log.d("XWebCoreContentProvider", "insert report " + parseInt + " " + str);
                                f.bX(parseInt, str);
                            } else {
                                Log.d("XWebCoreContentProvider", "insert reporter not init, cache " + parseInt + " " + str);
                                b bVar = new b();
                                bVar.key = parseInt;
                                bVar.value = str;
                                a.a(bVar);
                            }
                        }
                    } catch (Exception e) {
                        Log.d("XWebCoreContentProvider", "insert parse error");
                    }
                }
                AppMethodBeat.o(3948);
            } else {
                Log.e("XWebCoreContentProvider", "insert current not mm, return");
                AppMethodBeat.o(3948);
            }
        }
        return null;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        AppMethodBeat.i(3949);
        d y = y(uri);
        c cVar = new c();
        cVar.errCode = -1;
        cVar.ANi = y;
        Context context = getContext();
        if (context == null) {
            Log.e("XWebCoreContentProvider", "openFile context is null");
            cVar.errCode = -2;
            a(null, cVar);
            AppMethodBeat.o(3949);
            return null;
        }
        String stringBuilder;
        try {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                for (int i = 0; i < packagesForUid.length; i++) {
                    if (i != packagesForUid.length - 1) {
                        stringBuilder2.append(packagesForUid[i]).append("+");
                    } else {
                        stringBuilder2.append(packagesForUid[i]);
                    }
                }
                stringBuilder = stringBuilder2.toString();
                if (!stringBuilder.isEmpty()) {
                    y.ANj = stringBuilder;
                }
            }
        } catch (Exception e) {
            Log.e("XWebCoreContentProvider", "tryRefillCallerName error " + e.getMessage());
        }
        stringBuilder = context.getPackageName();
        cVar.ANh = stringBuilder;
        Log.d("XWebCoreContentProvider", "openFile current package: ".concat(String.valueOf(stringBuilder)));
        if (XWalkEnvironment.isProvider(stringBuilder)) {
            switch (y.opType) {
                case 1:
                    Log.d("XWebCoreContentProvider", "openFile test msg from " + y.ANj);
                    cVar.errCode = 2;
                    a(context, cVar);
                    AppMethodBeat.o(3949);
                    return null;
                case 2:
                    Log.d("XWebCoreContentProvider", "openFile request from " + y.ANj);
                    File file = new File(XWalkEnvironment.getPatchFileListConfig(context, y.ihB));
                    if (!file.exists()) {
                        file = new File(XWalkEnvironment.getDownloadZipFileListConfig(context, y.ihB));
                        if (!file.exists()) {
                            Log.d("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + y.ihB);
                            cVar.errCode = -4;
                            a(context, cVar);
                            AppMethodBeat.o(3949);
                            return null;
                        }
                    }
                    ParcelFileDescriptor open;
                    if (y.ANk.equals(XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME)) {
                        int readAvailableVersionFromSP = XWalkEnvironment.readAvailableVersionFromSP(context);
                        if (readAvailableVersionFromSP == -1) {
                            Log.d("XWebCoreContentProvider", "openFile can not get current version");
                            cVar.errCode = -8;
                            a(context, cVar);
                            AppMethodBeat.o(3949);
                            return null;
                        } else if (y.ihB > readAvailableVersionFromSP) {
                            Log.d("XWebCoreContentProvider", "openFile target version installing");
                            cVar.errCode = -9;
                            a(context, cVar);
                            AppMethodBeat.o(3949);
                            return null;
                        } else {
                            Log.d("XWebCoreContentProvider", "openFile return listConfigFile");
                            cVar.errCode = 1;
                            a(context, cVar);
                            open = ParcelFileDescriptor.open(file, 268435456);
                            AppMethodBeat.o(3949);
                            return open;
                        }
                    }
                    Map ax = ax(file);
                    if (ax.size() == 0) {
                        Log.e("XWebCoreContentProvider", "openFile fileMap is null or empty");
                        cVar.errCode = -5;
                        a(context, cVar);
                        AppMethodBeat.o(3949);
                        return null;
                    } else if (ax.containsKey(y.ANk)) {
                        if (y.ANk.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                            file = new File(XWalkEnvironment.getDownloadApkPath(context, y.ihB));
                        } else {
                            file = new File(XWalkEnvironment.getExtractedCoreFile(context, y.ihB, y.ANk));
                        }
                        if (file.exists()) {
                            Log.d("XWebCoreContentProvider", "openFile return file " + y.ANk);
                            cVar.errCode = 0;
                            a(context, cVar);
                            open = ParcelFileDescriptor.open(file, 268435456);
                            AppMethodBeat.o(3949);
                            return open;
                        }
                        Log.d("XWebCoreContentProvider", "openFile file not exist " + y.ANk);
                        cVar.errCode = -6;
                        a(context, cVar);
                        AppMethodBeat.o(3949);
                        return null;
                    } else {
                        Log.d("XWebCoreContentProvider", "openFile caller attempt to get file " + y.ANk);
                        cVar.errCode = -7;
                        a(context, cVar);
                        AppMethodBeat.o(3949);
                        return null;
                    }
                default:
                    Log.d("XWebCoreContentProvider", "openFile invalid uri");
                    cVar.errCode = -1;
                    a(context, cVar);
                    AppMethodBeat.o(3949);
                    return null;
            }
        }
        Log.e("XWebCoreContentProvider", "openFile current is not provider");
        cVar.errCode = -3;
        a(context, cVar);
        AppMethodBeat.o(3949);
        return null;
    }

    private static void a(Context context, c cVar) {
        String substring;
        AppMethodBeat.i(3950);
        String substring2 = cVar.ANh.length() > 100 ? cVar.ANh.substring(0, 99) : cVar.ANh;
        String substring3 = cVar.ANi.ANj.length() > 100 ? cVar.ANi.ANj.substring(0, 99) : cVar.ANi.ANj;
        if (cVar.ANi.ANk.length() > 100) {
            substring = cVar.ANi.ANk.substring(0, 99);
        } else {
            substring = cVar.ANi.ANk;
        }
        substring2 = cVar.errCode + "," + substring2 + "," + cVar.ANi.opType + "," + substring3 + "," + cVar.ANi.ihB + "," + substring;
        if (context != null && !"com.tencent.mm".equals(cVar.ANh)) {
            Log.d("XWebCoreContentProvider", "doReport need post to mm ".concat(String.valueOf(substring2)));
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                Log.e("XWebCoreContentProvider", "doReport content resolver is null");
                AppMethodBeat.o(3950);
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("15625", substring2);
                contentResolver.insert(b("com.tencent.mm", cVar.ANh, 3, 0, ""), contentValues);
                AppMethodBeat.o(3950);
            } catch (Exception e) {
                Log.d("XWebCoreContentProvider", "doReport error post to mm");
                AppMethodBeat.o(3950);
            }
        } else if (f.hasInit()) {
            Log.d("XWebCoreContentProvider", "doReport ".concat(String.valueOf(substring2)));
            f.bX(15625, substring2);
            AppMethodBeat.o(3950);
        } else {
            Log.d("XWebCoreContentProvider", "doReport reporter not init, cache ".concat(String.valueOf(substring2)));
            b bVar = new b();
            bVar.key = 15625;
            bVar.value = substring2;
            a.a(bVar);
            AppMethodBeat.o(3950);
        }
    }

    private static Map<String, String> ax(File file) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(3951);
        HashMap hashMap = new HashMap();
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.isEmpty()) {
                        String[] split = readLine.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (!(split.length != 2 || split[0] == null || split[0].isEmpty() || split[1] == null || split[1].isEmpty())) {
                            hashMap.put(split[0], split[1]);
                            Log.d("XWebCoreContentProvider", "readListConfigFile found " + split[0]);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e("XWebCoreContentProvider", "readListConfigFile error: " + e.getMessage());
                        com.tencent.xweb.util.b.tryClose(bufferedReader);
                        AppMethodBeat.o(3951);
                        return hashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.xweb.util.b.tryClose(bufferedReader);
                        AppMethodBeat.o(3951);
                        throw th;
                    }
                }
            }
            com.tencent.xweb.util.b.tryClose(bufferedReader);
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            Log.e("XWebCoreContentProvider", "readListConfigFile error: " + e.getMessage());
            com.tencent.xweb.util.b.tryClose(bufferedReader);
            AppMethodBeat.o(3951);
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            com.tencent.xweb.util.b.tryClose(bufferedReader);
            AppMethodBeat.o(3951);
            throw th;
        }
        AppMethodBeat.o(3951);
        return hashMap;
    }

    private static d y(Uri uri) {
        AppMethodBeat.i(3952);
        d dVar = new d();
        dVar.opType = -1;
        String uri2 = uri.toString();
        if (uri2.length() > 1000) {
            Log.d("XWebCoreContentProvider", "parseUri exceed max length");
            AppMethodBeat.o(3952);
            return dVar;
        }
        Log.d("XWebCoreContentProvider", "parseUri ".concat(String.valueOf(uri2)));
        List pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() < 2) {
            Log.d("XWebCoreContentProvider", "parseUri strList invalid");
            AppMethodBeat.o(3952);
            return dVar;
        }
        uri2 = (String) pathSegments.get(0);
        if (uri2 == null || uri2.isEmpty()) {
            Log.d("XWebCoreContentProvider", "parseUri callerName invalid");
            AppMethodBeat.o(3952);
            return dVar;
        }
        dVar.ANj = uri2;
        try {
            int parseInt = Integer.parseInt((String) pathSegments.get(1));
            switch (parseInt) {
                case 1:
                case 3:
                    if (pathSegments.size() == 2) {
                        dVar.opType = parseInt;
                        Log.d("XWebCoreContentProvider", "parseUri result: ".concat(String.valueOf(parseInt)));
                    } else {
                        Log.d("XWebCoreContentProvider", "parseUri wrong params on test or report");
                    }
                    AppMethodBeat.o(3952);
                    return dVar;
                case 2:
                    int parseInt2;
                    uri2 = null;
                    if (pathSegments.size() == 4) {
                        uri2 = (String) pathSegments.get(3);
                        try {
                            parseInt2 = Integer.parseInt((String) pathSegments.get(2));
                        } catch (Exception e) {
                            Log.d("XWebCoreContentProvider", "parseUri error parse targetVersion");
                            parseInt2 = -1;
                        }
                    } else {
                        parseInt2 = -1;
                    }
                    if (parseInt2 == -1 || uri2 == null || uri2.isEmpty()) {
                        Log.d("XWebCoreContentProvider", "parseUri wrong params on get file");
                    } else {
                        dVar.opType = parseInt;
                        dVar.ihB = parseInt2;
                        dVar.ANk = uri2;
                        Log.d("XWebCoreContentProvider", "parseUri result: " + parseInt + " " + parseInt2 + " " + uri2);
                    }
                    AppMethodBeat.o(3952);
                    return dVar;
                default:
                    Log.d("XWebCoreContentProvider", "parseUri invalid opType");
                    AppMethodBeat.o(3952);
                    return dVar;
            }
        } catch (Exception e2) {
            Log.d("XWebCoreContentProvider", "parseUri error parse opType");
            AppMethodBeat.o(3952);
            return dVar;
        }
    }

    public static Uri b(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.i(3953);
        if (str2.isEmpty()) {
            str2 = " ";
        }
        Uri parse;
        switch (i) {
            case 2:
                parse = Uri.parse("content://" + str + ".sdk.xweb.XWebCoreProvider/" + str2 + "/" + i + "/" + i2 + "/" + str3);
                AppMethodBeat.o(3953);
                return parse;
            default:
                parse = Uri.parse("content://" + str + ".sdk.xweb.XWebCoreProvider/" + str2 + "/" + i);
                AppMethodBeat.o(3953);
                return parse;
        }
    }

    public static void dUm() {
        AppMethodBeat.i(3954);
        a.dUn();
        AppMethodBeat.o(3954);
    }
}

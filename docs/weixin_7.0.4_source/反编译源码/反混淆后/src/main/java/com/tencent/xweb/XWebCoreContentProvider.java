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
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C41131b;
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

    /* renamed from: com.tencent.xweb.XWebCoreContentProvider$d */
    public static class C36583d {
        public String ANj = "";
        public String ANk = "";
        public int ihB = 0;
        public int opType = -1;
    }

    /* renamed from: com.tencent.xweb.XWebCoreContentProvider$c */
    public static class C41117c {
        public String ANh = "";
        public C36583d ANi = new C36583d();
        public int errCode = -1;

        public C41117c() {
            AppMethodBeat.m2504i(3947);
            AppMethodBeat.m2505o(3947);
        }
    }

    /* renamed from: com.tencent.xweb.XWebCoreContentProvider$a */
    public static class C44571a {
        private static List<C46829b> ANf = new ArrayList();
        private static final Object ANg = new Object();

        static {
            AppMethodBeat.m2504i(3946);
            AppMethodBeat.m2505o(3946);
        }

        /* renamed from: a */
        public static void m80952a(C46829b c46829b) {
            AppMethodBeat.m2504i(3944);
            synchronized (ANg) {
                try {
                    ANf.add(c46829b);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(3944);
                }
            }
        }

        public static void dUn() {
            AppMethodBeat.m2504i(3945);
            Log.m81049i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
            synchronized (ANg) {
                try {
                    for (C46829b c46829b : ANf) {
                        C24532f.m38172bX(c46829b.key, c46829b.value);
                    }
                    ANf.clear();
                } finally {
                    AppMethodBeat.m2505o(3945);
                }
            }
        }
    }

    /* renamed from: com.tencent.xweb.XWebCoreContentProvider$b */
    public static class C46829b {
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
        AppMethodBeat.m2504i(3948);
        if (contentValues == null || contentValues.size() == 0) {
            Log.m81045d("XWebCoreContentProvider", "insert values is null or empty");
            AppMethodBeat.m2505o(3948);
        } else if (m89066y(uri).opType != 3) {
            Log.m81045d("XWebCoreContentProvider", "insert wrong opType");
            AppMethodBeat.m2505o(3948);
        } else {
            Context context = getContext();
            if (context == null) {
                Log.m81046e("XWebCoreContentProvider", "insert context is null");
                AppMethodBeat.m2505o(3948);
            } else if ("com.tencent.mm".equals(context.getPackageName())) {
                Log.m81045d("XWebCoreContentProvider", "insert start report");
                for (Entry entry : contentValues.valueSet()) {
                    try {
                        int parseInt = Integer.parseInt((String) entry.getKey());
                        String str = (String) entry.getValue();
                        if (!(!C24532f.m38166Sw(parseInt) || str == null || str.isEmpty())) {
                            if (C24532f.hasInit()) {
                                Log.m81045d("XWebCoreContentProvider", "insert report " + parseInt + " " + str);
                                C24532f.m38172bX(parseInt, str);
                            } else {
                                Log.m81045d("XWebCoreContentProvider", "insert reporter not init, cache " + parseInt + " " + str);
                                C46829b c46829b = new C46829b();
                                c46829b.key = parseInt;
                                c46829b.value = str;
                                C44571a.m80952a(c46829b);
                            }
                        }
                    } catch (Exception e) {
                        Log.m81045d("XWebCoreContentProvider", "insert parse error");
                    }
                }
                AppMethodBeat.m2505o(3948);
            } else {
                Log.m81046e("XWebCoreContentProvider", "insert current not mm, return");
                AppMethodBeat.m2505o(3948);
            }
        }
        return null;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        AppMethodBeat.m2504i(3949);
        C36583d y = m89066y(uri);
        C41117c c41117c = new C41117c();
        c41117c.errCode = -1;
        c41117c.ANi = y;
        Context context = getContext();
        if (context == null) {
            Log.m81046e("XWebCoreContentProvider", "openFile context is null");
            c41117c.errCode = -2;
            m89063a(null, c41117c);
            AppMethodBeat.m2505o(3949);
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
            Log.m81046e("XWebCoreContentProvider", "tryRefillCallerName error " + e.getMessage());
        }
        stringBuilder = context.getPackageName();
        c41117c.ANh = stringBuilder;
        Log.m81045d("XWebCoreContentProvider", "openFile current package: ".concat(String.valueOf(stringBuilder)));
        if (XWalkEnvironment.isProvider(stringBuilder)) {
            switch (y.opType) {
                case 1:
                    Log.m81045d("XWebCoreContentProvider", "openFile test msg from " + y.ANj);
                    c41117c.errCode = 2;
                    m89063a(context, c41117c);
                    AppMethodBeat.m2505o(3949);
                    return null;
                case 2:
                    Log.m81045d("XWebCoreContentProvider", "openFile request from " + y.ANj);
                    File file = new File(XWalkEnvironment.getPatchFileListConfig(context, y.ihB));
                    if (!file.exists()) {
                        file = new File(XWalkEnvironment.getDownloadZipFileListConfig(context, y.ihB));
                        if (!file.exists()) {
                            Log.m81045d("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + y.ihB);
                            c41117c.errCode = -4;
                            m89063a(context, c41117c);
                            AppMethodBeat.m2505o(3949);
                            return null;
                        }
                    }
                    ParcelFileDescriptor open;
                    if (y.ANk.equals(XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME)) {
                        int readAvailableVersionFromSP = XWalkEnvironment.readAvailableVersionFromSP(context);
                        if (readAvailableVersionFromSP == -1) {
                            Log.m81045d("XWebCoreContentProvider", "openFile can not get current version");
                            c41117c.errCode = -8;
                            m89063a(context, c41117c);
                            AppMethodBeat.m2505o(3949);
                            return null;
                        } else if (y.ihB > readAvailableVersionFromSP) {
                            Log.m81045d("XWebCoreContentProvider", "openFile target version installing");
                            c41117c.errCode = -9;
                            m89063a(context, c41117c);
                            AppMethodBeat.m2505o(3949);
                            return null;
                        } else {
                            Log.m81045d("XWebCoreContentProvider", "openFile return listConfigFile");
                            c41117c.errCode = 1;
                            m89063a(context, c41117c);
                            open = ParcelFileDescriptor.open(file, 268435456);
                            AppMethodBeat.m2505o(3949);
                            return open;
                        }
                    }
                    Map ax = m89064ax(file);
                    if (ax.size() == 0) {
                        Log.m81046e("XWebCoreContentProvider", "openFile fileMap is null or empty");
                        c41117c.errCode = -5;
                        m89063a(context, c41117c);
                        AppMethodBeat.m2505o(3949);
                        return null;
                    } else if (ax.containsKey(y.ANk)) {
                        if (y.ANk.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                            file = new File(XWalkEnvironment.getDownloadApkPath(context, y.ihB));
                        } else {
                            file = new File(XWalkEnvironment.getExtractedCoreFile(context, y.ihB, y.ANk));
                        }
                        if (file.exists()) {
                            Log.m81045d("XWebCoreContentProvider", "openFile return file " + y.ANk);
                            c41117c.errCode = 0;
                            m89063a(context, c41117c);
                            open = ParcelFileDescriptor.open(file, 268435456);
                            AppMethodBeat.m2505o(3949);
                            return open;
                        }
                        Log.m81045d("XWebCoreContentProvider", "openFile file not exist " + y.ANk);
                        c41117c.errCode = -6;
                        m89063a(context, c41117c);
                        AppMethodBeat.m2505o(3949);
                        return null;
                    } else {
                        Log.m81045d("XWebCoreContentProvider", "openFile caller attempt to get file " + y.ANk);
                        c41117c.errCode = -7;
                        m89063a(context, c41117c);
                        AppMethodBeat.m2505o(3949);
                        return null;
                    }
                default:
                    Log.m81045d("XWebCoreContentProvider", "openFile invalid uri");
                    c41117c.errCode = -1;
                    m89063a(context, c41117c);
                    AppMethodBeat.m2505o(3949);
                    return null;
            }
        }
        Log.m81046e("XWebCoreContentProvider", "openFile current is not provider");
        c41117c.errCode = -3;
        m89063a(context, c41117c);
        AppMethodBeat.m2505o(3949);
        return null;
    }

    /* renamed from: a */
    private static void m89063a(Context context, C41117c c41117c) {
        String substring;
        AppMethodBeat.m2504i(3950);
        String substring2 = c41117c.ANh.length() > 100 ? c41117c.ANh.substring(0, 99) : c41117c.ANh;
        String substring3 = c41117c.ANi.ANj.length() > 100 ? c41117c.ANi.ANj.substring(0, 99) : c41117c.ANi.ANj;
        if (c41117c.ANi.ANk.length() > 100) {
            substring = c41117c.ANi.ANk.substring(0, 99);
        } else {
            substring = c41117c.ANi.ANk;
        }
        substring2 = c41117c.errCode + "," + substring2 + "," + c41117c.ANi.opType + "," + substring3 + "," + c41117c.ANi.ihB + "," + substring;
        if (context != null && !"com.tencent.mm".equals(c41117c.ANh)) {
            Log.m81045d("XWebCoreContentProvider", "doReport need post to mm ".concat(String.valueOf(substring2)));
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                Log.m81046e("XWebCoreContentProvider", "doReport content resolver is null");
                AppMethodBeat.m2505o(3950);
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("15625", substring2);
                contentResolver.insert(m89065b("com.tencent.mm", c41117c.ANh, 3, 0, ""), contentValues);
                AppMethodBeat.m2505o(3950);
            } catch (Exception e) {
                Log.m81045d("XWebCoreContentProvider", "doReport error post to mm");
                AppMethodBeat.m2505o(3950);
            }
        } else if (C24532f.hasInit()) {
            Log.m81045d("XWebCoreContentProvider", "doReport ".concat(String.valueOf(substring2)));
            C24532f.m38172bX(15625, substring2);
            AppMethodBeat.m2505o(3950);
        } else {
            Log.m81045d("XWebCoreContentProvider", "doReport reporter not init, cache ".concat(String.valueOf(substring2)));
            C46829b c46829b = new C46829b();
            c46829b.key = 15625;
            c46829b.value = substring2;
            C44571a.m80952a(c46829b);
            AppMethodBeat.m2505o(3950);
        }
    }

    /* renamed from: ax */
    private static Map<String, String> m89064ax(File file) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(3951);
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
                            Log.m81045d("XWebCoreContentProvider", "readListConfigFile found " + split[0]);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.m81046e("XWebCoreContentProvider", "readListConfigFile error: " + e.getMessage());
                        C41131b.tryClose(bufferedReader);
                        AppMethodBeat.m2505o(3951);
                        return hashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        C41131b.tryClose(bufferedReader);
                        AppMethodBeat.m2505o(3951);
                        throw th;
                    }
                }
            }
            C41131b.tryClose(bufferedReader);
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            Log.m81046e("XWebCoreContentProvider", "readListConfigFile error: " + e.getMessage());
            C41131b.tryClose(bufferedReader);
            AppMethodBeat.m2505o(3951);
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            C41131b.tryClose(bufferedReader);
            AppMethodBeat.m2505o(3951);
            throw th;
        }
        AppMethodBeat.m2505o(3951);
        return hashMap;
    }

    /* renamed from: y */
    private static C36583d m89066y(Uri uri) {
        AppMethodBeat.m2504i(3952);
        C36583d c36583d = new C36583d();
        c36583d.opType = -1;
        String uri2 = uri.toString();
        if (uri2.length() > 1000) {
            Log.m81045d("XWebCoreContentProvider", "parseUri exceed max length");
            AppMethodBeat.m2505o(3952);
            return c36583d;
        }
        Log.m81045d("XWebCoreContentProvider", "parseUri ".concat(String.valueOf(uri2)));
        List pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() < 2) {
            Log.m81045d("XWebCoreContentProvider", "parseUri strList invalid");
            AppMethodBeat.m2505o(3952);
            return c36583d;
        }
        uri2 = (String) pathSegments.get(0);
        if (uri2 == null || uri2.isEmpty()) {
            Log.m81045d("XWebCoreContentProvider", "parseUri callerName invalid");
            AppMethodBeat.m2505o(3952);
            return c36583d;
        }
        c36583d.ANj = uri2;
        try {
            int parseInt = Integer.parseInt((String) pathSegments.get(1));
            switch (parseInt) {
                case 1:
                case 3:
                    if (pathSegments.size() == 2) {
                        c36583d.opType = parseInt;
                        Log.m81045d("XWebCoreContentProvider", "parseUri result: ".concat(String.valueOf(parseInt)));
                    } else {
                        Log.m81045d("XWebCoreContentProvider", "parseUri wrong params on test or report");
                    }
                    AppMethodBeat.m2505o(3952);
                    return c36583d;
                case 2:
                    int parseInt2;
                    uri2 = null;
                    if (pathSegments.size() == 4) {
                        uri2 = (String) pathSegments.get(3);
                        try {
                            parseInt2 = Integer.parseInt((String) pathSegments.get(2));
                        } catch (Exception e) {
                            Log.m81045d("XWebCoreContentProvider", "parseUri error parse targetVersion");
                            parseInt2 = -1;
                        }
                    } else {
                        parseInt2 = -1;
                    }
                    if (parseInt2 == -1 || uri2 == null || uri2.isEmpty()) {
                        Log.m81045d("XWebCoreContentProvider", "parseUri wrong params on get file");
                    } else {
                        c36583d.opType = parseInt;
                        c36583d.ihB = parseInt2;
                        c36583d.ANk = uri2;
                        Log.m81045d("XWebCoreContentProvider", "parseUri result: " + parseInt + " " + parseInt2 + " " + uri2);
                    }
                    AppMethodBeat.m2505o(3952);
                    return c36583d;
                default:
                    Log.m81045d("XWebCoreContentProvider", "parseUri invalid opType");
                    AppMethodBeat.m2505o(3952);
                    return c36583d;
            }
        } catch (Exception e2) {
            Log.m81045d("XWebCoreContentProvider", "parseUri error parse opType");
            AppMethodBeat.m2505o(3952);
            return c36583d;
        }
    }

    /* renamed from: b */
    public static Uri m89065b(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.m2504i(3953);
        if (str2.isEmpty()) {
            str2 = " ";
        }
        Uri parse;
        switch (i) {
            case 2:
                parse = Uri.parse("content://" + str + ".sdk.xweb.XWebCoreProvider/" + str2 + "/" + i + "/" + i2 + "/" + str3);
                AppMethodBeat.m2505o(3953);
                return parse;
            default:
                parse = Uri.parse("content://" + str + ".sdk.xweb.XWebCoreProvider/" + str2 + "/" + i);
                AppMethodBeat.m2505o(3953);
                return parse;
        }
    }

    public static void dUm() {
        AppMethodBeat.m2504i(3954);
        C44571a.dUn();
        AppMethodBeat.m2505o(3954);
    }
}

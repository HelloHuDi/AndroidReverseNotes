package com.tencent.wcdb.repair;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBDumpUtil {
    private static final String TAG = "WCDB.DBDumpUtil";

    public interface ExecuteSqlCallback {
        String preExecute(String str);
    }

    private static native boolean nativeDumpDB(String str, String str2, String str3);

    private static native boolean nativeIsSqlComplete(String str);

    public static boolean doRecoveryDb(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        AppMethodBeat.m2504i(12648);
        boolean doRecoveryDb = doRecoveryDb(sQLiteDatabase, str, str2, str3, null, null, null, true);
        AppMethodBeat.m2505o(12648);
        return doRecoveryDb;
    }

    public static boolean doRecoveryDb(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, List<String> list, List<String> list2, ExecuteSqlCallback executeSqlCallback, boolean z) {
        AppMethodBeat.m2504i(12649);
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            Log.m9452w(TAG, "Database is not open");
            AppMethodBeat.m2505o(12649);
            return false;
        } else if (nativeDumpDB(str, str2, str3)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str3));
                sQLiteDatabase.execSQL("PRAGMA foreign_keys=OFF;");
                sQLiteDatabase.beginTransaction();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                try {
                    HashMap hashMap = new HashMap();
                    Object obj = null;
                    String str4 = null;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String str5;
                            Object tableNameFromSql;
                            int i4;
                            if (obj != null) {
                                str5 = str4 + IOUtils.LINE_SEPARATOR_UNIX + readLine;
                                if (!str5.endsWith(";")) {
                                    str4 = str5;
                                } else if (!nativeIsSqlComplete(str5)) {
                                    str4 = str5;
                                }
                            } else if (readLine.startsWith("INSERT") || readLine.startsWith("CREATE TABLE")) {
                                if (readLine.endsWith(";") && nativeIsSqlComplete(readLine)) {
                                    str5 = readLine;
                                } else {
                                    if (!TextUtils.isEmpty(str4)) {
                                        readLine = str4 + IOUtils.LINE_SEPARATOR_UNIX + readLine;
                                    }
                                    obj = 1;
                                    str4 = readLine;
                                }
                            }
                            Object i42 = null;
                            if (list2 != null && list2.size() > 0) {
                                tableNameFromSql = getTableNameFromSql(str5);
                                for (String readLine2 : list2) {
                                    if (tableNameFromSql.equals(readLine2)) {
                                        i42 = null;
                                        break;
                                    }
                                }
                                i42 = 1;
                            } else if (list == null || list.size() <= 0) {
                                tableNameFromSql = null;
                            } else {
                                tableNameFromSql = getTableNameFromSql(str5);
                                for (String readLine22 : list) {
                                    if (tableNameFromSql.equals(readLine22)) {
                                        i42 = 1;
                                        str5 = "";
                                        break;
                                    }
                                }
                                i42 = null;
                            }
                            if (i42 != null) {
                                Log.m9449i(TAG, "filter table %s", tableNameFromSql);
                                obj = null;
                                str4 = str5;
                            } else {
                                try {
                                    if (str5.startsWith("CREATE TABLE")) {
                                        hashMap.put(tableNameFromSql, buildColumnsString(getColumnNamesFromSql(str5)));
                                    } else if (str5.startsWith("INSERT INTO")) {
                                        readLine22 = (String) hashMap.get(tableNameFromSql);
                                        if (!TextUtils.isEmpty(readLine22)) {
                                            StringBuilder stringBuilder = new StringBuilder("INSERT INTO ");
                                            stringBuilder.append("\"").append(tableNameFromSql).append("\"");
                                            str4 = stringBuilder.toString();
                                            stringBuilder.append(readLine22);
                                            str5 = str5.replace(str4, stringBuilder.toString());
                                        }
                                    }
                                    readLine22 = null;
                                    if (executeSqlCallback != null) {
                                        readLine22 = executeSqlCallback.preExecute(str5);
                                    }
                                    if (TextUtils.isEmpty(readLine22)) {
                                        readLine22 = str5;
                                    }
                                    i2++;
                                    sQLiteDatabase.execSQL(readLine22);
                                    i42 = i3 + 1;
                                    if (i42 >= 100) {
                                        try {
                                            sQLiteDatabase.setTransactionSuccessful();
                                            sQLiteDatabase.endTransaction();
                                            sQLiteDatabase.beginTransaction();
                                            i42 = 0;
                                        } catch (Exception e) {
                                            i++;
                                            obj = null;
                                            str4 = null;
                                            i3 = i42;
                                        }
                                    }
                                } catch (Exception e2) {
                                    i42 = i3;
                                    i++;
                                    obj = null;
                                    str4 = null;
                                    i3 = i42;
                                }
                                obj = null;
                                str4 = null;
                                i3 = i42;
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                            }
                        }
                    }
                    bufferedReader.close();
                    if (i2 > i) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.setTransactionSuccessful();
                        }
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                        if (z) {
                            File file = new File(str3);
                            if (file.exists()) {
                                file.delete();
                            }
                            file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                        Log.m9449i(TAG, "restore : %d , fail:%d ", Integer.valueOf(i2), Integer.valueOf(i));
                        AppMethodBeat.m2505o(12649);
                        return true;
                    }
                    AppMethodBeat.m2505o(12649);
                    return false;
                } catch (IOException e4) {
                    Log.m9452w(TAG, "I/O error in read sql file ");
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                    AppMethodBeat.m2505o(12649);
                    return false;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                    AppMethodBeat.m2505o(12649);
                }
            } catch (FileNotFoundException e7) {
                Log.m9453w(TAG, "SQL file '%s' not found", str3);
                AppMethodBeat.m2505o(12649);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(12649);
            return false;
        }
    }

    public static String buildColumnsString(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(12650);
        String str;
        if (arrayList == null || arrayList.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(12650);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                stringBuilder.append((String) arrayList.get(i2));
                if (i2 != arrayList.size() - 1) {
                    stringBuilder.append(",");
                }
                i = i2 + 1;
            } else {
                stringBuilder.append(")");
                str = stringBuilder.toString();
                System.out.println(str);
                AppMethodBeat.m2505o(12650);
                return str;
            }
        }
    }

    public static String getTableNameFromSql(String str) {
        AppMethodBeat.m2504i(12651);
        if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        String[] split = str.split("\\s");
        if (split == null || split.length <= 1) {
            AppMethodBeat.m2505o(12651);
            return null;
        }
        String replaceAll = split[2].replaceAll("\"", "");
        AppMethodBeat.m2505o(12651);
        return replaceAll;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A:{SYNTHETIC, Splitter:B:18:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A:{SYNTHETIC, Splitter:B:24:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFile(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.m2504i(12652);
        File file = new File(str);
        if (file.exists()) {
            FileInputStream fileInputStream2;
            try {
                int length = (int) file.length();
                fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[length];
                    if (fileInputStream2.read(bArr) != length) {
                        Log.m9453w(TAG, "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", str, Integer.valueOf(length), Integer.valueOf(fileInputStream2.read(bArr)));
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                        }
                        AppMethodBeat.m2505o(12652);
                        return null;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e2) {
                    }
                    AppMethodBeat.m2505o(12652);
                    return bArr;
                } catch (Exception e3) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    Log.m9444e(TAG, "readFromFile failed!");
                    AppMethodBeat.m2505o(12652);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(12652);
                    throw th;
                }
            } catch (Exception e4) {
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                Log.m9444e(TAG, "readFromFile failed!");
                AppMethodBeat.m2505o(12652);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.m2505o(12652);
                throw th;
            }
        }
        Log.m9453w(TAG, "readFromFile error, file is not exit, path = %s", str);
        AppMethodBeat.m2505o(12652);
        return null;
    }

    public static ArrayList<String> getColumnNamesFromSql(String str) {
        AppMethodBeat.m2504i(12653);
        ArrayList arrayList = new ArrayList();
        String[] split = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).trim().split(",");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
            arrayList.add(split[i].substring(0, split[i].indexOf(" ")));
        }
        AppMethodBeat.m2505o(12653);
        return arrayList;
    }
}

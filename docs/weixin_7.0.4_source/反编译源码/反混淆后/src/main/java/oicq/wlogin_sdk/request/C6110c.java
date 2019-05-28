package oicq.wlogin_sdk.request;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.C6118c;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.request.c */
public final class C6110c {
    TreeMap<Long, WloginAllSigInfo> BUm = new TreeMap();
    Context _context;

    public C6110c(Context context) {
        AppMethodBeat.m2504i(96415);
        this._context = context;
        AppMethodBeat.m2505o(96415);
    }

    /* renamed from: a */
    public final synchronized int mo13518a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        int i;
        WloginAllSigInfo wloginAllSigInfo;
        Object obj;
        AppMethodBeat.m2504i(96416);
        WloginAllSigInfo wloginAllSigInfo2 = (WloginAllSigInfo) this.BUm.get(new Long(j));
        if (wloginAllSigInfo2 == null) {
            wloginAllSigInfo = new WloginAllSigInfo();
        } else {
            wloginAllSigInfo = wloginAllSigInfo2;
        }
        Object obj2 = new byte[0];
        WloginSigInfo wloginSigInfo = (WloginSigInfo) wloginAllSigInfo._tk_map.get(new Long(j2));
        if (wloginSigInfo == null || wloginSigInfo._en_A1 == null) {
            obj = obj2;
        } else {
            obj = (byte[]) wloginSigInfo._en_A1.clone();
        }
        wloginAllSigInfo._useInfo = new WloginSimpleInfo(j, bArr, bArr2, bArr3, bArr4);
        int put_siginfo = wloginAllSigInfo.put_siginfo(j2, j3, j4, j5, j6, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
        C6120util.awF("before put_siginfo, ret=".concat(String.valueOf(put_siginfo)));
        if (this._context != null) {
            TreeMap cj = C6110c.m9625cj(this._context, "tk_file");
            if (cj == null) {
                cj = new TreeMap();
            }
            C6120util.awF("after loadTKTreeMap");
            cj.put(new Long(j), wloginAllSigInfo.get_clone());
            put_siginfo = m9623a(cj, "tk_file");
            C6120util.awF("after refreshTKTreeMap, ret=".concat(String.valueOf(put_siginfo)));
        }
        i = put_siginfo;
        if (i != 0) {
            wloginSigInfo = (WloginSigInfo) wloginAllSigInfo._tk_map.get(new Long(j2));
            if (wloginSigInfo != null) {
                wloginSigInfo._en_A1 = (byte[]) obj.clone();
            }
        }
        this.BUm.put(new Long(j), wloginAllSigInfo);
        AppMethodBeat.m2505o(96416);
        return i;
    }

    /* renamed from: of */
    private synchronized WloginAllSigInfo m9627of(long j) {
        WloginAllSigInfo wloginAllSigInfo;
        AppMethodBeat.m2504i(96417);
        C6120util.m9681jh("get_all_siginfo", "uin=".concat(String.valueOf(j)));
        wloginAllSigInfo = (WloginAllSigInfo) this.BUm.get(new Long(j));
        if (wloginAllSigInfo != null) {
            AppMethodBeat.m2505o(96417);
        } else if (this._context == null) {
            AppMethodBeat.m2505o(96417);
            wloginAllSigInfo = null;
        } else {
            TreeMap cj = C6110c.m9625cj(this._context, "tk_file");
            if (cj == null) {
                AppMethodBeat.m2505o(96417);
                wloginAllSigInfo = null;
            } else {
                wloginAllSigInfo = (WloginAllSigInfo) cj.get(new Long(j));
                if (wloginAllSigInfo == null) {
                    C6120util.m9681jh("get_all_siginfo", BuildConfig.COMMAND);
                    AppMethodBeat.m2505o(96417);
                    wloginAllSigInfo = null;
                } else {
                    this.BUm.put(new Long(j), wloginAllSigInfo);
                    wloginAllSigInfo = wloginAllSigInfo.get_clone();
                    AppMethodBeat.m2505o(96417);
                }
            }
        }
        return wloginAllSigInfo;
    }

    /* renamed from: og */
    public final synchronized WloginSigInfo mo13520og(long j) {
        WloginSigInfo wloginSigInfo;
        AppMethodBeat.m2504i(96418);
        C6120util.m9681jh("get_siginfo", "uin=" + j + "appid=522017402");
        WloginAllSigInfo of = m9627of(j);
        if (of == null) {
            AppMethodBeat.m2505o(96418);
            wloginSigInfo = null;
        } else {
            wloginSigInfo = (WloginSigInfo) of._tk_map.get(Long.valueOf(522017402));
            if (wloginSigInfo == null) {
                AppMethodBeat.m2505o(96418);
                wloginSigInfo = null;
            } else {
                AppMethodBeat.m2505o(96418);
            }
        }
        return wloginSigInfo;
    }

    /* renamed from: i */
    public final synchronized void mo13519i(Long l) {
        AppMethodBeat.m2504i(96419);
        this.BUm.remove(l);
        if (this._context != null) {
            TreeMap cj = C6110c.m9625cj(this._context, "tk_file");
            if (cj == null) {
                AppMethodBeat.m2505o(96419);
            } else {
                cj.remove(l);
                m9623a(cj, "tk_file");
            }
        }
        AppMethodBeat.m2505o(96419);
    }

    /* renamed from: a */
    private synchronized int m9623a(TreeMap treeMap, String str) {
        int i;
        AppMethodBeat.m2504i(96420);
        i = 0;
        if (str == "tk_file") {
            i = m9624b(treeMap, str);
        }
        AppMethodBeat.m2505o(96420);
        return i;
    }

    /* renamed from: b */
    private synchronized int m9624b(TreeMap treeMap, String str) {
        int a;
        AppMethodBeat.m2504i(96421);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(C6112i.BUO, "DESede");
            Cipher instance = Cipher.getInstance("DESede");
            instance.init(1, secretKeySpec);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new CipherOutputStream(byteArrayOutputStream, instance));
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.close();
            a = C6110c.m9622a(this._context, str, byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            C6120util.m9682ji("exception", stringWriter.toString());
            a = -1022;
        }
        AppMethodBeat.m2505o(96421);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0095 A:{SYNTHETIC, Splitter:B:19:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d6 A:{SYNTHETIC, Splitter:B:32:0x00d6} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0118 A:{SYNTHETIC, Splitter:B:45:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0159 A:{SYNTHETIC, Splitter:B:54:0x0159} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0095 A:{SYNTHETIC, Splitter:B:19:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d6 A:{SYNTHETIC, Splitter:B:32:0x00d6} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0118 A:{SYNTHETIC, Splitter:B:45:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0159 A:{SYNTHETIC, Splitter:B:54:0x0159} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cj */
    private static TreeMap m9625cj(Context context, String str) {
        TreeMap treeMap;
        Exception exception;
        TreeMap treeMap2;
        StringWriter stringWriter;
        PrintWriter printWriter;
        TreeMap treeMap3;
        byte[] jJ;
        SecretKeySpec secretKeySpec;
        Cipher instance;
        AppMethodBeat.m2504i(96422);
        byte[] ck = C6110c.m9626ck(context, str);
        if (ck != null) {
            SecretKeySpec secretKeySpec2;
            Cipher instance2;
            ObjectInputStream objectInputStream;
            try {
                secretKeySpec2 = new SecretKeySpec(C6112i.BUO, "DESede");
                instance2 = Cipher.getInstance("DESede");
                instance2.init(2, secretKeySpec2);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance2));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                    try {
                        objectInputStream.close();
                        AppMethodBeat.m2505o(96422);
                    } catch (Exception e) {
                        exception = e;
                        treeMap2 = treeMap;
                        stringWriter = new StringWriter();
                        printWriter = new PrintWriter(stringWriter, true);
                        exception.printStackTrace(printWriter);
                        printWriter.flush();
                        stringWriter.flush();
                        C6120util.m9682ji("exception", stringWriter.toString());
                        treeMap3 = treeMap2;
                        try {
                            jJ = C6120util.m9672jJ(context);
                            secretKeySpec = new SecretKeySpec(jJ, "DESede");
                            instance = Cipher.getInstance("DESede");
                            instance.init(2, secretKeySpec);
                            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                            treeMap = (TreeMap) objectInputStream.readObject();
                            if (treeMap != null) {
                            }
                        } catch (Exception e2) {
                            treeMap = treeMap3;
                        }
                        treeMap3 = treeMap;
                        try {
                            jJ = C6120util.m9671jI(context);
                            secretKeySpec = new SecretKeySpec(C6118c.m9651cM(jJ), "DESede");
                            instance = Cipher.getInstance("DESede");
                            instance.init(2, secretKeySpec);
                            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                            treeMap = (TreeMap) objectInputStream.readObject();
                            if (treeMap != null) {
                            }
                        } catch (Exception e3) {
                            treeMap = treeMap3;
                        }
                        treeMap3 = treeMap;
                        try {
                            jJ = C6120util.m9670jH(context);
                            secretKeySpec = new SecretKeySpec(C6118c.m9651cM(jJ), "DESede");
                            instance = Cipher.getInstance("DESede");
                            instance.init(2, secretKeySpec);
                            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                            treeMap = (TreeMap) objectInputStream.readObject();
                            if (treeMap != null) {
                            }
                        } catch (Exception e4) {
                            treeMap = treeMap3;
                        }
                        treeMap3 = treeMap;
                        try {
                            secretKeySpec2 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
                            instance2 = Cipher.getInstance("DESede");
                            instance2.init(2, secretKeySpec2);
                            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance2));
                            treeMap = (TreeMap) objectInputStream.readObject();
                            if (treeMap != null) {
                            }
                        } catch (Exception e5) {
                            treeMap = treeMap3;
                        }
                        AppMethodBeat.m2505o(96422);
                        return treeMap;
                    }
                }
                treeMap3 = treeMap;
                jJ = C6120util.m9672jJ(context);
                if (jJ != null && jJ.length > 0) {
                    secretKeySpec = new SecretKeySpec(jJ, "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                    treeMap = (TreeMap) objectInputStream.readObject();
                    if (treeMap != null) {
                        try {
                            objectInputStream.close();
                            AppMethodBeat.m2505o(96422);
                        } catch (Exception e6) {
                        }
                    }
                    treeMap3 = treeMap;
                }
                jJ = C6120util.m9671jI(context);
                if (jJ != null && jJ.length > 0) {
                    secretKeySpec = new SecretKeySpec(C6118c.m9651cM(jJ), "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                    treeMap = (TreeMap) objectInputStream.readObject();
                    if (treeMap != null) {
                        try {
                            objectInputStream.close();
                            AppMethodBeat.m2505o(96422);
                        } catch (Exception e7) {
                        }
                    }
                    treeMap3 = treeMap;
                }
                jJ = C6120util.m9670jH(context);
                if (jJ != null && jJ.length > 0) {
                    secretKeySpec = new SecretKeySpec(C6118c.m9651cM(jJ), "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                    treeMap = (TreeMap) objectInputStream.readObject();
                    if (treeMap != null) {
                        try {
                            objectInputStream.close();
                            AppMethodBeat.m2505o(96422);
                        } catch (Exception e8) {
                        }
                    }
                    treeMap3 = treeMap;
                }
                secretKeySpec2 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
                instance2 = Cipher.getInstance("DESede");
                instance2.init(2, secretKeySpec2);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance2));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                    try {
                        objectInputStream.close();
                        AppMethodBeat.m2505o(96422);
                    } catch (Exception e9) {
                    }
                }
                AppMethodBeat.m2505o(96422);
            } catch (Exception e10) {
                exception = e10;
                treeMap2 = null;
                stringWriter = new StringWriter();
                printWriter = new PrintWriter(stringWriter, true);
                exception.printStackTrace(printWriter);
                printWriter.flush();
                stringWriter.flush();
                C6120util.m9682ji("exception", stringWriter.toString());
                treeMap3 = treeMap2;
                jJ = C6120util.m9672jJ(context);
                secretKeySpec = new SecretKeySpec(jJ, "DESede");
                instance = Cipher.getInstance("DESede");
                instance.init(2, secretKeySpec);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                }
                treeMap3 = treeMap;
                jJ = C6120util.m9671jI(context);
                secretKeySpec = new SecretKeySpec(C6118c.m9651cM(jJ), "DESede");
                instance = Cipher.getInstance("DESede");
                instance.init(2, secretKeySpec);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                }
                treeMap3 = treeMap;
                jJ = C6120util.m9670jH(context);
                secretKeySpec = new SecretKeySpec(C6118c.m9651cM(jJ), "DESede");
                instance = Cipher.getInstance("DESede");
                instance.init(2, secretKeySpec);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                }
                treeMap3 = treeMap;
                secretKeySpec2 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
                instance2 = Cipher.getInstance("DESede");
                instance2.init(2, secretKeySpec2);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance2));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                }
                AppMethodBeat.m2505o(96422);
                return treeMap;
            }
        }
        treeMap = null;
        AppMethodBeat.m2505o(96422);
        return treeMap;
    }

    /* renamed from: a */
    private static int m9622a(Context context, String str, byte[] bArr) {
        Exception e;
        C6107a c6107a = null;
        AppMethodBeat.m2504i(96423);
        try {
            C6107a c6107a2 = new C6107a(context, str);
            try {
                SQLiteDatabase writableDatabase = c6107a2.getWritableDatabase();
                try {
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (ID INTEGER PRIMARY KEY, " + str + " BLOB);");
                    try {
                        String str2 = str;
                        Cursor query = writableDatabase.query(str2, new String[]{"ID"}, "ID=0", null, null, null, null);
                        if (query.getCount() == 0) {
                            try {
                                writableDatabase.execSQL("insert into " + str + " (ID, " + str + ") values (?,?);", new Object[]{Integer.valueOf(0), new byte[1]});
                            } catch (SQLException e2) {
                                C6120util.m9683l(e2);
                                query.close();
                                c6107a2.close();
                                AppMethodBeat.m2505o(96423);
                                return -1022;
                            }
                        }
                        try {
                            writableDatabase.execSQL("update " + str + " set " + str + " =? where ID=0", new Object[]{bArr});
                            query.close();
                            c6107a2.close();
                            AppMethodBeat.m2505o(96423);
                            return 0;
                        } catch (SQLException e22) {
                            C6120util.m9683l(e22);
                            query.close();
                            c6107a2.close();
                            AppMethodBeat.m2505o(96423);
                            return -1022;
                        }
                    } catch (SQLException e222) {
                        C6120util.m9683l(e222);
                        c6107a2.close();
                        AppMethodBeat.m2505o(96423);
                        return -1022;
                    }
                } catch (SQLException e2222) {
                    C6120util.m9683l(e2222);
                    c6107a2.close();
                    AppMethodBeat.m2505o(96423);
                    return -1022;
                }
            } catch (Exception e3) {
                e = e3;
                c6107a = c6107a2;
            }
        } catch (Exception e4) {
            e = e4;
            C6120util.m9683l(e);
            if (c6107a != null) {
                c6107a.close();
            }
            AppMethodBeat.m2505o(96423);
            return -1022;
        }
    }

    /* renamed from: ck */
    private static byte[] m9626ck(Context context, String str) {
        Exception e;
        C6107a c6107a;
        AppMethodBeat.m2504i(96424);
        Boolean bool = Boolean.FALSE;
        try {
            C6107a c6107a2 = new C6107a(context, str);
            try {
                SQLiteDatabase readableDatabase = c6107a2.getReadableDatabase();
                Cursor query;
                try {
                    Cursor rawQuery = readableDatabase.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + str + "' ", null);
                    try {
                        if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                            bool = Boolean.TRUE;
                        }
                        if (!(rawQuery == null || rawQuery.isClosed())) {
                            rawQuery.close();
                        }
                        if (bool.booleanValue()) {
                            String str2 = str;
                            query = readableDatabase.query(str2, new String[]{str}, "ID=0", null, null, null, null);
                            if (query.getCount() == 0) {
                                query.close();
                                c6107a2.close();
                                AppMethodBeat.m2505o(96424);
                                return null;
                            }
                            query.moveToFirst();
                            byte[] blob = query.getBlob(0);
                            query.close();
                            c6107a2.close();
                            AppMethodBeat.m2505o(96424);
                            return blob;
                        }
                        c6107a2.close();
                        AppMethodBeat.m2505o(96424);
                        return null;
                    } catch (SQLException e2) {
                        e = e2;
                        query = rawQuery;
                        C6120util.m9683l(e);
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        c6107a2.close();
                        AppMethodBeat.m2505o(96424);
                        return null;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    query = null;
                }
            } catch (Exception e4) {
                e = e4;
                c6107a = c6107a2;
            }
        } catch (Exception e5) {
            e = e5;
            c6107a = null;
            C6120util.m9683l(e);
            if (c6107a != null) {
                c6107a.close();
            }
            AppMethodBeat.m2505o(96424);
            return null;
        }
    }
}

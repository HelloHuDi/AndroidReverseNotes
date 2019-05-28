package oicq.wlogin_sdk.request;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
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
import oicq.wlogin_sdk.tools.util;

public final class c {
    TreeMap<Long, WloginAllSigInfo> BUm = new TreeMap();
    Context _context;

    public c(Context context) {
        AppMethodBeat.i(96415);
        this._context = context;
        AppMethodBeat.o(96415);
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        int i;
        WloginAllSigInfo wloginAllSigInfo;
        Object obj;
        AppMethodBeat.i(96416);
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
        util.awF("before put_siginfo, ret=".concat(String.valueOf(put_siginfo)));
        if (this._context != null) {
            TreeMap cj = cj(this._context, "tk_file");
            if (cj == null) {
                cj = new TreeMap();
            }
            util.awF("after loadTKTreeMap");
            cj.put(new Long(j), wloginAllSigInfo.get_clone());
            put_siginfo = a(cj, "tk_file");
            util.awF("after refreshTKTreeMap, ret=".concat(String.valueOf(put_siginfo)));
        }
        i = put_siginfo;
        if (i != 0) {
            wloginSigInfo = (WloginSigInfo) wloginAllSigInfo._tk_map.get(new Long(j2));
            if (wloginSigInfo != null) {
                wloginSigInfo._en_A1 = (byte[]) obj.clone();
            }
        }
        this.BUm.put(new Long(j), wloginAllSigInfo);
        AppMethodBeat.o(96416);
        return i;
    }

    private synchronized WloginAllSigInfo of(long j) {
        WloginAllSigInfo wloginAllSigInfo;
        AppMethodBeat.i(96417);
        util.jh("get_all_siginfo", "uin=".concat(String.valueOf(j)));
        wloginAllSigInfo = (WloginAllSigInfo) this.BUm.get(new Long(j));
        if (wloginAllSigInfo != null) {
            AppMethodBeat.o(96417);
        } else if (this._context == null) {
            AppMethodBeat.o(96417);
            wloginAllSigInfo = null;
        } else {
            TreeMap cj = cj(this._context, "tk_file");
            if (cj == null) {
                AppMethodBeat.o(96417);
                wloginAllSigInfo = null;
            } else {
                wloginAllSigInfo = (WloginAllSigInfo) cj.get(new Long(j));
                if (wloginAllSigInfo == null) {
                    util.jh("get_all_siginfo", BuildConfig.COMMAND);
                    AppMethodBeat.o(96417);
                    wloginAllSigInfo = null;
                } else {
                    this.BUm.put(new Long(j), wloginAllSigInfo);
                    wloginAllSigInfo = wloginAllSigInfo.get_clone();
                    AppMethodBeat.o(96417);
                }
            }
        }
        return wloginAllSigInfo;
    }

    public final synchronized WloginSigInfo og(long j) {
        WloginSigInfo wloginSigInfo;
        AppMethodBeat.i(96418);
        util.jh("get_siginfo", "uin=" + j + "appid=522017402");
        WloginAllSigInfo of = of(j);
        if (of == null) {
            AppMethodBeat.o(96418);
            wloginSigInfo = null;
        } else {
            wloginSigInfo = (WloginSigInfo) of._tk_map.get(Long.valueOf(522017402));
            if (wloginSigInfo == null) {
                AppMethodBeat.o(96418);
                wloginSigInfo = null;
            } else {
                AppMethodBeat.o(96418);
            }
        }
        return wloginSigInfo;
    }

    public final synchronized void i(Long l) {
        AppMethodBeat.i(96419);
        this.BUm.remove(l);
        if (this._context != null) {
            TreeMap cj = cj(this._context, "tk_file");
            if (cj == null) {
                AppMethodBeat.o(96419);
            } else {
                cj.remove(l);
                a(cj, "tk_file");
            }
        }
        AppMethodBeat.o(96419);
    }

    private synchronized int a(TreeMap treeMap, String str) {
        int i;
        AppMethodBeat.i(96420);
        i = 0;
        if (str == "tk_file") {
            i = b(treeMap, str);
        }
        AppMethodBeat.o(96420);
        return i;
    }

    private synchronized int b(TreeMap treeMap, String str) {
        int a;
        AppMethodBeat.i(96421);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(i.BUO, "DESede");
            Cipher instance = Cipher.getInstance("DESede");
            instance.init(1, secretKeySpec);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new CipherOutputStream(byteArrayOutputStream, instance));
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.close();
            a = a(this._context, str, byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            util.ji("exception", stringWriter.toString());
            a = -1022;
        }
        AppMethodBeat.o(96421);
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
    private static TreeMap cj(Context context, String str) {
        TreeMap treeMap;
        Exception exception;
        TreeMap treeMap2;
        StringWriter stringWriter;
        PrintWriter printWriter;
        TreeMap treeMap3;
        byte[] jJ;
        SecretKeySpec secretKeySpec;
        Cipher instance;
        AppMethodBeat.i(96422);
        byte[] ck = ck(context, str);
        if (ck != null) {
            SecretKeySpec secretKeySpec2;
            Cipher instance2;
            ObjectInputStream objectInputStream;
            try {
                secretKeySpec2 = new SecretKeySpec(i.BUO, "DESede");
                instance2 = Cipher.getInstance("DESede");
                instance2.init(2, secretKeySpec2);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance2));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                    try {
                        objectInputStream.close();
                        AppMethodBeat.o(96422);
                    } catch (Exception e) {
                        exception = e;
                        treeMap2 = treeMap;
                        stringWriter = new StringWriter();
                        printWriter = new PrintWriter(stringWriter, true);
                        exception.printStackTrace(printWriter);
                        printWriter.flush();
                        stringWriter.flush();
                        util.ji("exception", stringWriter.toString());
                        treeMap3 = treeMap2;
                        try {
                            jJ = util.jJ(context);
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
                            jJ = util.jI(context);
                            secretKeySpec = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cM(jJ), "DESede");
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
                            jJ = util.jH(context);
                            secretKeySpec = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cM(jJ), "DESede");
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
                        AppMethodBeat.o(96422);
                        return treeMap;
                    }
                }
                treeMap3 = treeMap;
                jJ = util.jJ(context);
                if (jJ != null && jJ.length > 0) {
                    secretKeySpec = new SecretKeySpec(jJ, "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                    treeMap = (TreeMap) objectInputStream.readObject();
                    if (treeMap != null) {
                        try {
                            objectInputStream.close();
                            AppMethodBeat.o(96422);
                        } catch (Exception e6) {
                        }
                    }
                    treeMap3 = treeMap;
                }
                jJ = util.jI(context);
                if (jJ != null && jJ.length > 0) {
                    secretKeySpec = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cM(jJ), "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                    treeMap = (TreeMap) objectInputStream.readObject();
                    if (treeMap != null) {
                        try {
                            objectInputStream.close();
                            AppMethodBeat.o(96422);
                        } catch (Exception e7) {
                        }
                    }
                    treeMap3 = treeMap;
                }
                jJ = util.jH(context);
                if (jJ != null && jJ.length > 0) {
                    secretKeySpec = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cM(jJ), "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                    treeMap = (TreeMap) objectInputStream.readObject();
                    if (treeMap != null) {
                        try {
                            objectInputStream.close();
                            AppMethodBeat.o(96422);
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
                        AppMethodBeat.o(96422);
                    } catch (Exception e9) {
                    }
                }
                AppMethodBeat.o(96422);
            } catch (Exception e10) {
                exception = e10;
                treeMap2 = null;
                stringWriter = new StringWriter();
                printWriter = new PrintWriter(stringWriter, true);
                exception.printStackTrace(printWriter);
                printWriter.flush();
                stringWriter.flush();
                util.ji("exception", stringWriter.toString());
                treeMap3 = treeMap2;
                jJ = util.jJ(context);
                secretKeySpec = new SecretKeySpec(jJ, "DESede");
                instance = Cipher.getInstance("DESede");
                instance.init(2, secretKeySpec);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                }
                treeMap3 = treeMap;
                jJ = util.jI(context);
                secretKeySpec = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cM(jJ), "DESede");
                instance = Cipher.getInstance("DESede");
                instance.init(2, secretKeySpec);
                objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(ck), instance));
                treeMap = (TreeMap) objectInputStream.readObject();
                if (treeMap != null) {
                }
                treeMap3 = treeMap;
                jJ = util.jH(context);
                secretKeySpec = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cM(jJ), "DESede");
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
                AppMethodBeat.o(96422);
                return treeMap;
            }
        }
        treeMap = null;
        AppMethodBeat.o(96422);
        return treeMap;
    }

    private static int a(Context context, String str, byte[] bArr) {
        Exception e;
        a aVar = null;
        AppMethodBeat.i(96423);
        try {
            a aVar2 = new a(context, str);
            try {
                SQLiteDatabase writableDatabase = aVar2.getWritableDatabase();
                try {
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (ID INTEGER PRIMARY KEY, " + str + " BLOB);");
                    try {
                        String str2 = str;
                        Cursor query = writableDatabase.query(str2, new String[]{"ID"}, "ID=0", null, null, null, null);
                        if (query.getCount() == 0) {
                            try {
                                writableDatabase.execSQL("insert into " + str + " (ID, " + str + ") values (?,?);", new Object[]{Integer.valueOf(0), new byte[1]});
                            } catch (SQLException e2) {
                                util.l(e2);
                                query.close();
                                aVar2.close();
                                AppMethodBeat.o(96423);
                                return -1022;
                            }
                        }
                        try {
                            writableDatabase.execSQL("update " + str + " set " + str + " =? where ID=0", new Object[]{bArr});
                            query.close();
                            aVar2.close();
                            AppMethodBeat.o(96423);
                            return 0;
                        } catch (SQLException e22) {
                            util.l(e22);
                            query.close();
                            aVar2.close();
                            AppMethodBeat.o(96423);
                            return -1022;
                        }
                    } catch (SQLException e222) {
                        util.l(e222);
                        aVar2.close();
                        AppMethodBeat.o(96423);
                        return -1022;
                    }
                } catch (SQLException e2222) {
                    util.l(e2222);
                    aVar2.close();
                    AppMethodBeat.o(96423);
                    return -1022;
                }
            } catch (Exception e3) {
                e = e3;
                aVar = aVar2;
            }
        } catch (Exception e4) {
            e = e4;
            util.l(e);
            if (aVar != null) {
                aVar.close();
            }
            AppMethodBeat.o(96423);
            return -1022;
        }
    }

    private static byte[] ck(Context context, String str) {
        Exception e;
        a aVar;
        AppMethodBeat.i(96424);
        Boolean bool = Boolean.FALSE;
        try {
            a aVar2 = new a(context, str);
            try {
                SQLiteDatabase readableDatabase = aVar2.getReadableDatabase();
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
                                aVar2.close();
                                AppMethodBeat.o(96424);
                                return null;
                            }
                            query.moveToFirst();
                            byte[] blob = query.getBlob(0);
                            query.close();
                            aVar2.close();
                            AppMethodBeat.o(96424);
                            return blob;
                        }
                        aVar2.close();
                        AppMethodBeat.o(96424);
                        return null;
                    } catch (SQLException e2) {
                        e = e2;
                        query = rawQuery;
                        util.l(e);
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        aVar2.close();
                        AppMethodBeat.o(96424);
                        return null;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    query = null;
                }
            } catch (Exception e4) {
                e = e4;
                aVar = aVar2;
            }
        } catch (Exception e5) {
            e = e5;
            aVar = null;
            util.l(e);
            if (aVar != null) {
                aVar.close();
            }
            AppMethodBeat.o(96424);
            return null;
        }
    }
}

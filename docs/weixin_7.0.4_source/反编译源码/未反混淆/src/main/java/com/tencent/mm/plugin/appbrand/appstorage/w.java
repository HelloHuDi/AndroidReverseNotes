package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.m;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;

public final class w extends g {
    public final String gXQ;
    public final String gYj;
    public volatile long gYk;
    private final b gYl;
    private final b gYm;
    private final a gYn;
    private final a gYo;
    private final a gYp;
    private final a gYq;
    private final a gYr;
    private final b gYs;
    private final a gYt;
    private final a gYu;
    private final a gYv;
    private final a gYw;
    private final a gYx;

    interface a {
        j a(File file, Object... objArr);
    }

    abstract class b implements a {
        public abstract j G(File file);

        private b() {
        }

        /* synthetic */ b(w wVar, byte b) {
            this();
        }

        public final j a(File file, Object... objArr) {
            return G(file);
        }
    }

    public w(String str) {
        this(str, "file:///usr");
    }

    public w(String str, String str2) {
        AppMethodBeat.i(105453);
        this.gYk = -1;
        this.gYl = new b() {
            public final j G(File file) {
                AppMethodBeat.i(105439);
                j jVar;
                if (file.exists()) {
                    jVar = j.OK;
                    AppMethodBeat.o(105439);
                    return jVar;
                }
                jVar = j.RET_NOT_EXISTS;
                AppMethodBeat.o(105439);
                return jVar;
            }
        };
        this.gYm = new b() {
            public final j G(File file) {
                AppMethodBeat.i(105444);
                j jVar;
                if (!file.exists()) {
                    jVar = j.RET_NOT_EXISTS;
                    AppMethodBeat.o(105444);
                    return jVar;
                } else if (file.isDirectory()) {
                    jVar = j.OK;
                    AppMethodBeat.o(105444);
                    return jVar;
                } else {
                    jVar = j.ERR_IS_FILE;
                    AppMethodBeat.o(105444);
                    return jVar;
                }
            }
        };
        this.gYn = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105445);
                j jVar;
                if (file.exists()) {
                    jVar = j.RET_ALREADY_EXISTS;
                    AppMethodBeat.o(105445);
                    return jVar;
                } else if (((Boolean) objArr[0]).booleanValue() ? file.mkdirs() : file.mkdir()) {
                    jVar = j.OK;
                    AppMethodBeat.o(105445);
                    return jVar;
                } else {
                    jVar = j.ERR_OP_FAIL;
                    AppMethodBeat.o(105445);
                    return jVar;
                }
            }
        };
        this.gYo = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105446);
                j jVar;
                if (file.isFile() || !file.exists()) {
                    jVar = j.RET_NOT_EXISTS;
                    AppMethodBeat.o(105446);
                    return jVar;
                } else if (file.equals(w.this.awW())) {
                    jVar = j.ERR_PERMISSION_DENIED;
                    AppMethodBeat.o(105446);
                    return jVar;
                } else if (((Boolean) objArr[0]).booleanValue()) {
                    d.d("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
                    try {
                        l.E(file);
                        jVar = j.OK;
                        AppMethodBeat.o(105446);
                        return jVar;
                    } catch (Exception e) {
                        d.e("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", e);
                        jVar = j.ERR_OP_FAIL;
                        AppMethodBeat.o(105446);
                        return jVar;
                    }
                } else {
                    File[] listFiles = file.listFiles();
                    if (listFiles.length > 0) {
                        if (listFiles.length != 1) {
                            jVar = j.ERR_DIR_NOT_EMPTY;
                            AppMethodBeat.o(105446);
                            return jVar;
                        } else if (listFiles[0].getName().equals(".nomedia")) {
                            listFiles[0].delete();
                        } else {
                            jVar = j.ERR_DIR_NOT_EMPTY;
                            AppMethodBeat.o(105446);
                            return jVar;
                        }
                    }
                    if (file.delete()) {
                        jVar = j.OK;
                        AppMethodBeat.o(105446);
                        return jVar;
                    }
                    jVar = j.ERR_OP_FAIL;
                    AppMethodBeat.o(105446);
                    return jVar;
                }
            }
        };
        this.gYp = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105448);
                j jVar;
                if (!file.isDirectory()) {
                    jVar = j.ERR_IS_FILE;
                    AppMethodBeat.o(105448);
                    return jVar;
                } else if (l.F(file)) {
                    jVar = j.ERR_SYMLINK;
                    AppMethodBeat.o(105448);
                    return jVar;
                } else {
                    final LinkedList linkedList = new LinkedList();
                    final String quote = Pattern.quote(file.getAbsolutePath());
                    file.listFiles(new FileFilter() {
                        public final boolean accept(File file) {
                            AppMethodBeat.i(105447);
                            boolean z = !file.getName().endsWith(".nomedia");
                            if (z) {
                                h hVar = new h();
                                hVar.fileName = l.yj(file.getAbsolutePath().replaceFirst(quote, ""));
                                linkedList.add(hVar);
                            }
                            AppMethodBeat.o(105447);
                            return z;
                        }
                    });
                    ((j) objArr[0]).value = linkedList;
                    jVar = j.OK;
                    AppMethodBeat.o(105448);
                    return jVar;
                }
            }
        };
        this.gYq = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105449);
                j jVar = (j) objArr[0];
                j jVar2;
                if (!file.exists()) {
                    jVar2 = j.RET_NOT_EXISTS;
                    AppMethodBeat.o(105449);
                    return jVar2;
                } else if (!file.isFile()) {
                    jVar2 = j.ERR_PERMISSION_DENIED;
                    AppMethodBeat.o(105449);
                    return jVar2;
                } else if (l.F(file)) {
                    jVar2 = j.ERR_SYMLINK;
                    AppMethodBeat.o(105449);
                    return jVar2;
                } else {
                    if (jVar != null) {
                        jVar.value = l.D(file);
                    }
                    jVar2 = j.OK;
                    AppMethodBeat.o(105449);
                    return jVar2;
                }
            }
        };
        this.gYr = new a() {
            public final j a(File file, Object... objArr) {
                Exception e;
                Throwable th;
                AppMethodBeat.i(105450);
                j jVar;
                if (l.F(file)) {
                    jVar = j.ERR_SYMLINK;
                    AppMethodBeat.o(105450);
                    return jVar;
                }
                InputStream inputStream = (InputStream) objArr[0];
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                if (inputStream instanceof ZipInputStream) {
                    if (l.a((ZipInputStream) inputStream, file.getAbsolutePath()) != 0) {
                        jVar = j.ERR_OP_FAIL;
                        AppMethodBeat.o(105450);
                        return jVar;
                    } else if (w.this.gYk <= 0 || w.a(w.this) <= w.this.gYk) {
                        jVar = j.OK;
                        AppMethodBeat.o(105450);
                        return jVar;
                    } else {
                        file.delete();
                        jVar = j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                        AppMethodBeat.o(105450);
                        return jVar;
                    }
                } else if (file.isDirectory()) {
                    jVar = j.RET_ALREADY_EXISTS;
                    AppMethodBeat.o(105450);
                    return jVar;
                } else {
                    if (w.this.gYk > 0) {
                        try {
                            if (((long) inputStream.available()) + w.a(w.this) > w.this.gYk) {
                                jVar = j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                                AppMethodBeat.o(105450);
                                return jVar;
                            }
                        } catch (Exception e2) {
                            d.e("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile, access available e=%s", e2);
                            jVar = j.ERR_OP_FAIL;
                            AppMethodBeat.o(105450);
                            return jVar;
                        }
                    }
                    if (file.exists() || !booleanValue) {
                        Closeable fileOutputStream;
                        j jVar2;
                        try {
                            fileOutputStream = new FileOutputStream(file, booleanValue);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = inputStream.read(bArr, 0, 4096);
                                    if (read != -1) {
                                        fileOutputStream.write(bArr, 0, read);
                                    } else {
                                        fileOutputStream.flush();
                                        jVar2 = j.OK;
                                        bo.b(fileOutputStream);
                                        bo.b(inputStream);
                                        AppMethodBeat.o(105450);
                                        return jVar2;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    d.i("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile exp %s", e);
                                    jVar2 = j.ERR_OP_FAIL;
                                    bo.b(fileOutputStream);
                                    bo.b(inputStream);
                                    AppMethodBeat.o(105450);
                                    return jVar2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bo.b(fileOutputStream);
                                    bo.b(inputStream);
                                    AppMethodBeat.o(105450);
                                    throw th;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            fileOutputStream = null;
                            d.i("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile exp %s", e);
                            jVar2 = j.ERR_OP_FAIL;
                            bo.b(fileOutputStream);
                            bo.b(inputStream);
                            AppMethodBeat.o(105450);
                            return jVar2;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                            bo.b(fileOutputStream);
                            bo.b(inputStream);
                            AppMethodBeat.o(105450);
                            throw th;
                        }
                    }
                    jVar = j.RET_NOT_EXISTS;
                    AppMethodBeat.o(105450);
                    return jVar;
                }
            }
        };
        this.gYs = new b() {
            public final j G(File file) {
                AppMethodBeat.i(105451);
                j jVar;
                if (file.isDirectory()) {
                    jVar = j.ERR_IS_DIRECTORY;
                    AppMethodBeat.o(105451);
                    return jVar;
                } else if (file.exists()) {
                    int unlink = FileUnlink.unlink(file.getPath());
                    if (unlink != 0) {
                        d.e("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", Integer.valueOf(unlink), file.getPath());
                    }
                    if (unlink == 0) {
                        jVar = j.OK;
                        AppMethodBeat.o(105451);
                        return jVar;
                    }
                    jVar = j.ERR_OP_FAIL;
                    AppMethodBeat.o(105451);
                    return jVar;
                } else {
                    jVar = j.RET_NOT_EXISTS;
                    AppMethodBeat.o(105451);
                    return jVar;
                }
            }
        };
        this.gYt = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105452);
                j jVar;
                if (file.exists()) {
                    int stat = FileStat.stat(file.getPath(), (k) objArr[0]);
                    if (stat != 0) {
                        d.e("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", Integer.valueOf(stat), file.getPath());
                    }
                    if (stat == 0) {
                        jVar = j.OK;
                        AppMethodBeat.o(105452);
                        return jVar;
                    }
                    jVar = j.ERR_OP_FAIL;
                    AppMethodBeat.o(105452);
                    return jVar;
                }
                jVar = j.RET_NOT_EXISTS;
                AppMethodBeat.o(105452);
                return jVar;
            }
        };
        this.gYu = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105441);
                j jVar;
                if (file.isDirectory()) {
                    final List list = (List) objArr[0];
                    final String quote = Pattern.quote(file.getAbsolutePath());
                    l.a(file, new FileFilter() {
                        public final boolean accept(File file) {
                            AppMethodBeat.i(105440);
                            boolean z = !file.getName().endsWith(".nomedia");
                            if (z && !file.isDirectory()) {
                                u uVar = new u(l.yj(file.getAbsolutePath().replaceFirst(quote, "")));
                                FileStat.stat(file.getAbsolutePath(), uVar);
                                list.add(uVar);
                            }
                            AppMethodBeat.o(105440);
                            return z;
                        }
                    });
                    jVar = j.OK;
                    AppMethodBeat.o(105441);
                    return jVar;
                }
                jVar = j.ERR_NOT_SUPPORTED;
                AppMethodBeat.o(105441);
                return jVar;
            }
        };
        this.gYv = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105442);
                File file2 = (File) objArr[0];
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                j jVar;
                if (file.isDirectory()) {
                    jVar = j.RET_ALREADY_EXISTS;
                    AppMethodBeat.o(105442);
                    return jVar;
                } else if (l.F(file)) {
                    jVar = j.ERR_SYMLINK;
                    AppMethodBeat.o(105442);
                    return jVar;
                } else if (w.this.gYk > 0 && w.a(w.this) + file2.length() > w.this.gYk) {
                    jVar = j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.o(105442);
                    return jVar;
                } else if (booleanValue) {
                    if (i.bx(file2.getAbsolutePath(), file.getAbsolutePath())) {
                        jVar = j.OK;
                        AppMethodBeat.o(105442);
                        return jVar;
                    }
                    jVar = j.ERR_OP_FAIL;
                    AppMethodBeat.o(105442);
                    return jVar;
                } else if (m.C(file2.getAbsolutePath(), file.getAbsolutePath(), false)) {
                    jVar = j.OK;
                    AppMethodBeat.o(105442);
                    return jVar;
                } else {
                    jVar = j.ERR_OP_FAIL;
                    AppMethodBeat.o(105442);
                    return jVar;
                }
            }
        };
        this.gYw = new a() {
            public final j a(File file, Object... objArr) {
                ((j) objArr[0]).value = file;
                return j.OK;
            }
        };
        this.gYx = new a() {
            public final j a(File file, Object... objArr) {
                AppMethodBeat.i(105443);
                j jVar;
                if (l.F(file)) {
                    jVar = j.ERR_SYMLINK;
                    AppMethodBeat.o(105443);
                    return jVar;
                } else if (file.isFile() && file.exists()) {
                    jVar = j.RET_ALREADY_EXISTS;
                    AppMethodBeat.o(105443);
                    return jVar;
                } else {
                    int unzip = ZipJNI.unzip(((File) objArr[0]).getAbsolutePath(), file.getAbsolutePath(), null);
                    d.i("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", r0.getAbsolutePath(), Integer.valueOf(unzip));
                    if (unzip != 0) {
                        switch (unzip) {
                            case ZipJNI.UNZ_ERR_OPEN_WRITE /*-106*/:
                                jVar = j.ERR_WRITE_ZIP_ENTRY;
                                AppMethodBeat.o(105443);
                                return jVar;
                            case ZipJNI.UNZ_CRCERROR /*-105*/:
                            case ZipJNI.UNZ_INTERNALERROR /*-104*/:
                            case ZipJNI.UNZ_BADZIPFILE /*-103*/:
                            case ZipJNI.UNZ_PARAMERROR /*-102*/:
                            case -1:
                            case 2:
                                jVar = j.ERR_BAD_ZIP_FILE;
                                AppMethodBeat.o(105443);
                                return jVar;
                            case 1:
                                jVar = j.ERR_PERMISSION_DENIED;
                                AppMethodBeat.o(105443);
                                return jVar;
                            default:
                                jVar = j.ERR_OP_FAIL;
                                AppMethodBeat.o(105443);
                                return jVar;
                        }
                    } else if (w.this.gYk <= 0 || w.a(w.this) <= w.this.gYk) {
                        jVar = j.OK;
                        AppMethodBeat.o(105443);
                        return jVar;
                    } else {
                        l.E(file);
                        jVar = j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                        AppMethodBeat.o(105443);
                        return jVar;
                    }
                }
            }
        };
        this.gXQ = str;
        this.gYj = str2;
        d.i("MicroMsg.LuggageNonFlattenedFileSystem", "mRootPath:%s mPathPrefix:%s", this.gXQ, this.gYj);
        AppMethodBeat.o(105453);
    }

    public final boolean ca(String str) {
        AppMethodBeat.i(105454);
        boolean startsWith = bo.nullAsNil(str).startsWith(this.gYj);
        AppMethodBeat.o(105454);
        return startsWith;
    }

    public final void initialize() {
        AppMethodBeat.i(105455);
        File awW = awW();
        if (awW == null || !awW.exists()) {
            d.e("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
        }
        AppMethodBeat.o(105455);
    }

    public final void release() {
    }

    public final void awP() {
        AppMethodBeat.i(105456);
        File file = new File(this.gXQ);
        l.E(file);
        if (file.exists()) {
            file.delete();
        }
        AppMethodBeat.o(105456);
    }

    public final j a(j<String> jVar) {
        return j.ERR_NOT_SUPPORTED;
    }

    /* Access modifiers changed, original: final */
    public final File awW() {
        AppMethodBeat.i(105457);
        if (TextUtils.isEmpty(this.gXQ)) {
            AppMethodBeat.o(105457);
            return null;
        }
        File file = new File(this.gXQ);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.mkdirs();
        try {
            new File(file.getPath() + "/.nomedia").createNewFile();
        } catch (Exception e) {
        }
        AppMethodBeat.o(105457);
        return file;
    }

    private j a(String str, a aVar, boolean z, Object... objArr) {
        AppMethodBeat.i(105458);
        j jVar;
        if (bo.isNullOrNil(str)) {
            jVar = j.ERR_PERMISSION_DENIED;
            AppMethodBeat.o(105458);
            return jVar;
        }
        String yj = l.yj(str.replaceFirst(Pattern.quote(this.gYj), ""));
        File awW = awW();
        if (awW == null) {
            jVar = j.ERR_FS_NOT_MOUNTED;
            AppMethodBeat.o(105458);
            return jVar;
        }
        yj = org.apache.commons.a.b.jj(awW.getAbsolutePath(), yj);
        if (bo.isNullOrNil(yj)) {
            jVar = j.ERR_PERMISSION_DENIED;
            AppMethodBeat.o(105458);
            return jVar;
        }
        Object obj;
        awW = new File(yj);
        File awW2 = awW();
        if (awW2 == null || !e(awW2, awW)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            jVar = j.ERR_PERMISSION_DENIED;
            AppMethodBeat.o(105458);
            return jVar;
        } else if (z || awW.getParentFile().exists()) {
            jVar = aVar.a(awW, objArr);
            AppMethodBeat.o(105458);
            return jVar;
        } else {
            jVar = j.ERR_PARENT_DIR_NOT_EXISTS;
            AppMethodBeat.o(105458);
            return jVar;
        }
    }

    private j a(String str, a aVar, Object... objArr) {
        AppMethodBeat.i(105459);
        j a = a(str, aVar, false, objArr);
        AppMethodBeat.o(105459);
        return a;
    }

    private static boolean e(File file, File file2) {
        AppMethodBeat.i(105460);
        Object file22;
        while (file22 != null) {
            if (file.equals(file22)) {
                AppMethodBeat.o(105460);
                return true;
            }
            file22 = file22.getParentFile();
        }
        AppMethodBeat.o(105460);
        return false;
    }

    public final j yd(String str) {
        AppMethodBeat.i(105461);
        j a = a(str, this.gYl, new Object[0]);
        AppMethodBeat.o(105461);
        return a;
    }

    public final j ye(String str) {
        AppMethodBeat.i(105462);
        j a = a(str, this.gYm, new Object[0]);
        AppMethodBeat.o(105462);
        return a;
    }

    public final j X(String str, boolean z) {
        AppMethodBeat.i(105463);
        j a = a(str, this.gYn, z, Boolean.valueOf(z));
        AppMethodBeat.o(105463);
        return a;
    }

    public final j Y(String str, boolean z) {
        AppMethodBeat.i(105464);
        j a = a(str, this.gYo, z, Boolean.valueOf(z));
        AppMethodBeat.o(105464);
        return a;
    }

    public final j a(String str, j<List<h>> jVar) {
        AppMethodBeat.i(105465);
        j a = a(str, this.gYp, jVar);
        AppMethodBeat.o(105465);
        return a;
    }

    public final j b(String str, j<ByteBuffer> jVar) {
        AppMethodBeat.i(105466);
        j a = a(str, this.gYq, jVar);
        AppMethodBeat.o(105466);
        return a;
    }

    public final j a(String str, InputStream inputStream, boolean z) {
        AppMethodBeat.i(105467);
        j jVar;
        if (inputStream == null) {
            jVar = j.ERR_OP_FAIL;
            AppMethodBeat.o(105467);
            return jVar;
        }
        jVar = a(str, this.gYr, inputStream, Boolean.valueOf(z));
        AppMethodBeat.o(105467);
        return jVar;
    }

    public final j yf(String str) {
        AppMethodBeat.i(105468);
        j a = a(str, this.gYs, new Object[0]);
        AppMethodBeat.o(105468);
        return a;
    }

    public final j a(String str, k kVar) {
        AppMethodBeat.i(105469);
        j a = a(str, this.gYt, kVar);
        AppMethodBeat.o(105469);
        return a;
    }

    public final j g(String str, List<u> list) {
        AppMethodBeat.i(105470);
        j a = a(str, this.gYu, list);
        AppMethodBeat.o(105470);
        return a;
    }

    public final j a(String str, File file, boolean z) {
        AppMethodBeat.i(105471);
        j a = a(str, this.gYv, file, Boolean.valueOf(z));
        AppMethodBeat.o(105471);
        return a;
    }

    public final File Z(String str, boolean z) {
        AppMethodBeat.i(105472);
        j jVar = new j();
        a(str, this.gYw, jVar);
        File file = (File) jVar.value;
        if (file == null) {
            d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", str);
            AppMethodBeat.o(105472);
            return null;
        } else if (!file.exists()) {
            d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", str);
            AppMethodBeat.o(105472);
            return null;
        } else if (!z && !file.isFile()) {
            d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", str);
            AppMethodBeat.o(105472);
            return null;
        } else if (l.F(file)) {
            d.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", str);
            AppMethodBeat.o(105472);
            return null;
        } else {
            AppMethodBeat.o(105472);
            return file;
        }
    }

    public final j b(String str, File file) {
        AppMethodBeat.i(105473);
        j a = a(str, this.gYx, file);
        AppMethodBeat.o(105473);
        return a;
    }

    public final j a(File file, String str, boolean z, j<String> jVar) {
        return j.ERR_NOT_SUPPORTED;
    }

    public final j a(File file, String str, j<String> jVar) {
        AppMethodBeat.i(105474);
        j jVar2;
        if (!ca(str)) {
            jVar2 = j.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(105474);
            return jVar2;
        } else if (file == null || !file.exists()) {
            jVar2 = j.ERR_OP_FAIL;
            AppMethodBeat.o(105474);
            return jVar2;
        } else if (TextUtils.isEmpty(str)) {
            jVar2 = j.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(105474);
            return jVar2;
        } else {
            jVar2 = ye(str);
            if (jVar2 == j.RET_NOT_EXISTS || jVar2 == j.ERR_IS_FILE) {
                try {
                    jVar2 = a(str, new FileInputStream(file), false);
                    if (jVar != null) {
                        jVar.value = str;
                    }
                } catch (Exception e) {
                    jVar2 = j.ERR_OP_FAIL;
                    AppMethodBeat.o(105474);
                    return jVar2;
                }
            }
            AppMethodBeat.o(105474);
            return jVar2;
        }
    }

    public final List<com.tencent.mm.plugin.appbrand.appstorage.p.a> awQ() {
        return null;
    }
}

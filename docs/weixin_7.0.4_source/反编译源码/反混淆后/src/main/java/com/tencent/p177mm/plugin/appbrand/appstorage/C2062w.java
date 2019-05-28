package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p.C19093a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C40616m;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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
import org.apache.commons.p1431a.C36638b;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w */
public final class C2062w extends C24685g {
    public final String gXQ;
    public final String gYj;
    public volatile long gYk;
    private final C2069b gYl;
    private final C2069b gYm;
    private final C2064a gYn;
    private final C2064a gYo;
    private final C2064a gYp;
    private final C2064a gYq;
    private final C2064a gYr;
    private final C2069b gYs;
    private final C2064a gYt;
    private final C2064a gYu;
    private final C2064a gYv;
    private final C2064a gYw;
    private final C2064a gYx;

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$6 */
    class C20636 extends C2069b {
        C20636() {
            super(C2062w.this, (byte) 0);
        }

        /* renamed from: G */
        public final C45518j mo5852G(File file) {
            AppMethodBeat.m2504i(105444);
            C45518j c45518j;
            if (!file.exists()) {
                c45518j = C45518j.RET_NOT_EXISTS;
                AppMethodBeat.m2505o(105444);
                return c45518j;
            } else if (file.isDirectory()) {
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105444);
                return c45518j;
            } else {
                c45518j = C45518j.ERR_IS_FILE;
                AppMethodBeat.m2505o(105444);
                return c45518j;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$a */
    interface C2064a {
        /* renamed from: a */
        C45518j mo5853a(File file, Object... objArr);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$4 */
    class C20654 implements C2064a {
        C20654() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            ((C19681j) objArr[0]).value = file;
            return C45518j.OK;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$5 */
    class C20665 implements C2064a {
        C20665() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105443);
            C45518j c45518j;
            if (C42367l.m74942F(file)) {
                c45518j = C45518j.ERR_SYMLINK;
                AppMethodBeat.m2505o(105443);
                return c45518j;
            } else if (file.isFile() && file.exists()) {
                c45518j = C45518j.RET_ALREADY_EXISTS;
                AppMethodBeat.m2505o(105443);
                return c45518j;
            } else {
                int unzip = ZipJNI.unzip(((File) objArr[0]).getAbsolutePath(), file.getAbsolutePath(), null);
                C45124d.m82930i("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", r0.getAbsolutePath(), Integer.valueOf(unzip));
                if (unzip != 0) {
                    switch (unzip) {
                        case ZipJNI.UNZ_ERR_OPEN_WRITE /*-106*/:
                            c45518j = C45518j.ERR_WRITE_ZIP_ENTRY;
                            AppMethodBeat.m2505o(105443);
                            return c45518j;
                        case ZipJNI.UNZ_CRCERROR /*-105*/:
                        case ZipJNI.UNZ_INTERNALERROR /*-104*/:
                        case ZipJNI.UNZ_BADZIPFILE /*-103*/:
                        case ZipJNI.UNZ_PARAMERROR /*-102*/:
                        case -1:
                        case 2:
                            c45518j = C45518j.ERR_BAD_ZIP_FILE;
                            AppMethodBeat.m2505o(105443);
                            return c45518j;
                        case 1:
                            c45518j = C45518j.ERR_PERMISSION_DENIED;
                            AppMethodBeat.m2505o(105443);
                            return c45518j;
                        default:
                            c45518j = C45518j.ERR_OP_FAIL;
                            AppMethodBeat.m2505o(105443);
                            return c45518j;
                    }
                } else if (C2062w.this.gYk <= 0 || C2062w.m4232a(C2062w.this) <= C2062w.this.gYk) {
                    c45518j = C45518j.OK;
                    AppMethodBeat.m2505o(105443);
                    return c45518j;
                } else {
                    C42367l.m74941E(file);
                    c45518j = C45518j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.m2505o(105443);
                    return c45518j;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$7 */
    class C20677 implements C2064a {
        C20677() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105445);
            C45518j c45518j;
            if (file.exists()) {
                c45518j = C45518j.RET_ALREADY_EXISTS;
                AppMethodBeat.m2505o(105445);
                return c45518j;
            } else if (((Boolean) objArr[0]).booleanValue() ? file.mkdirs() : file.mkdir()) {
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105445);
                return c45518j;
            } else {
                c45518j = C45518j.ERR_OP_FAIL;
                AppMethodBeat.m2505o(105445);
                return c45518j;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$8 */
    class C20688 implements C2064a {
        C20688() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105446);
            C45518j c45518j;
            if (file.isFile() || !file.exists()) {
                c45518j = C45518j.RET_NOT_EXISTS;
                AppMethodBeat.m2505o(105446);
                return c45518j;
            } else if (file.equals(C2062w.this.awW())) {
                c45518j = C45518j.ERR_PERMISSION_DENIED;
                AppMethodBeat.m2505o(105446);
                return c45518j;
            } else if (((Boolean) objArr[0]).booleanValue()) {
                C45124d.m82925d("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
                try {
                    C42367l.m74941E(file);
                    c45518j = C45518j.OK;
                    AppMethodBeat.m2505o(105446);
                    return c45518j;
                } catch (Exception e) {
                    C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", e);
                    c45518j = C45518j.ERR_OP_FAIL;
                    AppMethodBeat.m2505o(105446);
                    return c45518j;
                }
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles.length > 0) {
                    if (listFiles.length != 1) {
                        c45518j = C45518j.ERR_DIR_NOT_EMPTY;
                        AppMethodBeat.m2505o(105446);
                        return c45518j;
                    } else if (listFiles[0].getName().equals(".nomedia")) {
                        listFiles[0].delete();
                    } else {
                        c45518j = C45518j.ERR_DIR_NOT_EMPTY;
                        AppMethodBeat.m2505o(105446);
                        return c45518j;
                    }
                }
                if (file.delete()) {
                    c45518j = C45518j.OK;
                    AppMethodBeat.m2505o(105446);
                    return c45518j;
                }
                c45518j = C45518j.ERR_OP_FAIL;
                AppMethodBeat.m2505o(105446);
                return c45518j;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$b */
    abstract class C2069b implements C2064a {
        /* renamed from: G */
        public abstract C45518j mo5852G(File file);

        private C2069b() {
        }

        /* synthetic */ C2069b(C2062w c2062w, byte b) {
            this();
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            return mo5852G(file);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$11 */
    class C207011 implements C2064a {
        C207011() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            Exception e;
            Throwable th;
            AppMethodBeat.m2504i(105450);
            C45518j c45518j;
            if (C42367l.m74942F(file)) {
                c45518j = C45518j.ERR_SYMLINK;
                AppMethodBeat.m2505o(105450);
                return c45518j;
            }
            InputStream inputStream = (InputStream) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (inputStream instanceof ZipInputStream) {
                if (C42367l.m74943a((ZipInputStream) inputStream, file.getAbsolutePath()) != 0) {
                    c45518j = C45518j.ERR_OP_FAIL;
                    AppMethodBeat.m2505o(105450);
                    return c45518j;
                } else if (C2062w.this.gYk <= 0 || C2062w.m4232a(C2062w.this) <= C2062w.this.gYk) {
                    c45518j = C45518j.OK;
                    AppMethodBeat.m2505o(105450);
                    return c45518j;
                } else {
                    file.delete();
                    c45518j = C45518j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.m2505o(105450);
                    return c45518j;
                }
            } else if (file.isDirectory()) {
                c45518j = C45518j.RET_ALREADY_EXISTS;
                AppMethodBeat.m2505o(105450);
                return c45518j;
            } else {
                if (C2062w.this.gYk > 0) {
                    try {
                        if (((long) inputStream.available()) + C2062w.m4232a(C2062w.this) > C2062w.this.gYk) {
                            c45518j = C45518j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                            AppMethodBeat.m2505o(105450);
                            return c45518j;
                        }
                    } catch (Exception e2) {
                        C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile, access available e=%s", e2);
                        c45518j = C45518j.ERR_OP_FAIL;
                        AppMethodBeat.m2505o(105450);
                        return c45518j;
                    }
                }
                if (file.exists() || !booleanValue) {
                    Closeable fileOutputStream;
                    C45518j c45518j2;
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
                                    c45518j2 = C45518j.OK;
                                    C5046bo.m7527b(fileOutputStream);
                                    C5046bo.m7527b(inputStream);
                                    AppMethodBeat.m2505o(105450);
                                    return c45518j2;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                C45124d.m82930i("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile exp %s", e);
                                c45518j2 = C45518j.ERR_OP_FAIL;
                                C5046bo.m7527b(fileOutputStream);
                                C5046bo.m7527b(inputStream);
                                AppMethodBeat.m2505o(105450);
                                return c45518j2;
                            } catch (Throwable th2) {
                                th = th2;
                                C5046bo.m7527b(fileOutputStream);
                                C5046bo.m7527b(inputStream);
                                AppMethodBeat.m2505o(105450);
                                throw th;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileOutputStream = null;
                        C45124d.m82930i("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile exp %s", e);
                        c45518j2 = C45518j.ERR_OP_FAIL;
                        C5046bo.m7527b(fileOutputStream);
                        C5046bo.m7527b(inputStream);
                        AppMethodBeat.m2505o(105450);
                        return c45518j2;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        C5046bo.m7527b(fileOutputStream);
                        C5046bo.m7527b(inputStream);
                        AppMethodBeat.m2505o(105450);
                        throw th;
                    }
                }
                c45518j = C45518j.RET_NOT_EXISTS;
                AppMethodBeat.m2505o(105450);
                return c45518j;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$13 */
    class C207113 implements C2064a {
        C207113() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105452);
            C45518j c45518j;
            if (file.exists()) {
                int stat = FileStat.stat(file.getPath(), (C42366k) objArr[0]);
                if (stat != 0) {
                    C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", Integer.valueOf(stat), file.getPath());
                }
                if (stat == 0) {
                    c45518j = C45518j.OK;
                    AppMethodBeat.m2505o(105452);
                    return c45518j;
                }
                c45518j = C45518j.ERR_OP_FAIL;
                AppMethodBeat.m2505o(105452);
                return c45518j;
            }
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(105452);
            return c45518j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$1 */
    class C20721 extends C2069b {
        C20721() {
            super(C2062w.this, (byte) 0);
        }

        /* renamed from: G */
        public final C45518j mo5852G(File file) {
            AppMethodBeat.m2504i(105439);
            C45518j c45518j;
            if (file.exists()) {
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105439);
                return c45518j;
            }
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(105439);
            return c45518j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$2 */
    class C20732 implements C2064a {
        C20732() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105441);
            C45518j c45518j;
            if (file.isDirectory()) {
                final List list = (List) objArr[0];
                final String quote = Pattern.quote(file.getAbsolutePath());
                C42367l.m74944a(file, new FileFilter() {
                    public final boolean accept(File file) {
                        AppMethodBeat.m2504i(105440);
                        boolean z = !file.getName().endsWith(".nomedia");
                        if (z && !file.isDirectory()) {
                            C33103u c33103u = new C33103u(C42367l.m74945yj(file.getAbsolutePath().replaceFirst(quote, "")));
                            FileStat.stat(file.getAbsolutePath(), c33103u);
                            list.add(c33103u);
                        }
                        AppMethodBeat.m2505o(105440);
                        return z;
                    }
                });
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105441);
                return c45518j;
            }
            c45518j = C45518j.ERR_NOT_SUPPORTED;
            AppMethodBeat.m2505o(105441);
            return c45518j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$3 */
    class C20753 implements C2064a {
        C20753() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105442);
            File file2 = (File) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            C45518j c45518j;
            if (file.isDirectory()) {
                c45518j = C45518j.RET_ALREADY_EXISTS;
                AppMethodBeat.m2505o(105442);
                return c45518j;
            } else if (C42367l.m74942F(file)) {
                c45518j = C45518j.ERR_SYMLINK;
                AppMethodBeat.m2505o(105442);
                return c45518j;
            } else if (C2062w.this.gYk > 0 && C2062w.m4232a(C2062w.this) + file2.length() > C2062w.this.gYk) {
                c45518j = C45518j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                AppMethodBeat.m2505o(105442);
                return c45518j;
            } else if (booleanValue) {
                if (C38121i.m64493bx(file2.getAbsolutePath(), file.getAbsolutePath())) {
                    c45518j = C45518j.OK;
                    AppMethodBeat.m2505o(105442);
                    return c45518j;
                }
                c45518j = C45518j.ERR_OP_FAIL;
                AppMethodBeat.m2505o(105442);
                return c45518j;
            } else if (C40616m.m70056C(file2.getAbsolutePath(), file.getAbsolutePath(), false)) {
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105442);
                return c45518j;
            } else {
                c45518j = C45518j.ERR_OP_FAIL;
                AppMethodBeat.m2505o(105442);
                return c45518j;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$9 */
    class C20769 implements C2064a {
        C20769() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105448);
            C45518j c45518j;
            if (!file.isDirectory()) {
                c45518j = C45518j.ERR_IS_FILE;
                AppMethodBeat.m2505o(105448);
                return c45518j;
            } else if (C42367l.m74942F(file)) {
                c45518j = C45518j.ERR_SYMLINK;
                AppMethodBeat.m2505o(105448);
                return c45518j;
            } else {
                final LinkedList linkedList = new LinkedList();
                final String quote = Pattern.quote(file.getAbsolutePath());
                file.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        AppMethodBeat.m2504i(105447);
                        boolean z = !file.getName().endsWith(".nomedia");
                        if (z) {
                            C26753h c26753h = new C26753h();
                            c26753h.fileName = C42367l.m74945yj(file.getAbsolutePath().replaceFirst(quote, ""));
                            linkedList.add(c26753h);
                        }
                        AppMethodBeat.m2505o(105447);
                        return z;
                    }
                });
                ((C19681j) objArr[0]).value = linkedList;
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105448);
                return c45518j;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$10 */
    class C207810 implements C2064a {
        C207810() {
        }

        /* renamed from: a */
        public final C45518j mo5853a(File file, Object... objArr) {
            AppMethodBeat.m2504i(105449);
            C19681j c19681j = (C19681j) objArr[0];
            C45518j c45518j;
            if (!file.exists()) {
                c45518j = C45518j.RET_NOT_EXISTS;
                AppMethodBeat.m2505o(105449);
                return c45518j;
            } else if (!file.isFile()) {
                c45518j = C45518j.ERR_PERMISSION_DENIED;
                AppMethodBeat.m2505o(105449);
                return c45518j;
            } else if (C42367l.m74942F(file)) {
                c45518j = C45518j.ERR_SYMLINK;
                AppMethodBeat.m2505o(105449);
                return c45518j;
            } else {
                if (c19681j != null) {
                    c19681j.value = C42367l.m74940D(file);
                }
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105449);
                return c45518j;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.w$12 */
    class C207912 extends C2069b {
        C207912() {
            super(C2062w.this, (byte) 0);
        }

        /* renamed from: G */
        public final C45518j mo5852G(File file) {
            AppMethodBeat.m2504i(105451);
            C45518j c45518j;
            if (file.isDirectory()) {
                c45518j = C45518j.ERR_IS_DIRECTORY;
                AppMethodBeat.m2505o(105451);
                return c45518j;
            } else if (file.exists()) {
                int unlink = FileUnlink.unlink(file.getPath());
                if (unlink != 0) {
                    C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", Integer.valueOf(unlink), file.getPath());
                }
                if (unlink == 0) {
                    c45518j = C45518j.OK;
                    AppMethodBeat.m2505o(105451);
                    return c45518j;
                }
                c45518j = C45518j.ERR_OP_FAIL;
                AppMethodBeat.m2505o(105451);
                return c45518j;
            } else {
                c45518j = C45518j.RET_NOT_EXISTS;
                AppMethodBeat.m2505o(105451);
                return c45518j;
            }
        }
    }

    public C2062w(String str) {
        this(str, "file:///usr");
    }

    public C2062w(String str, String str2) {
        AppMethodBeat.m2504i(105453);
        this.gYk = -1;
        this.gYl = new C20721();
        this.gYm = new C20636();
        this.gYn = new C20677();
        this.gYo = new C20688();
        this.gYp = new C20769();
        this.gYq = new C207810();
        this.gYr = new C207011();
        this.gYs = new C207912();
        this.gYt = new C207113();
        this.gYu = new C20732();
        this.gYv = new C20753();
        this.gYw = new C20654();
        this.gYx = new C20665();
        this.gXQ = str;
        this.gYj = str2;
        C45124d.m82930i("MicroMsg.LuggageNonFlattenedFileSystem", "mRootPath:%s mPathPrefix:%s", this.gXQ, this.gYj);
        AppMethodBeat.m2505o(105453);
    }

    /* renamed from: ca */
    public final boolean mo5845ca(String str) {
        AppMethodBeat.m2504i(105454);
        boolean startsWith = C5046bo.nullAsNil(str).startsWith(this.gYj);
        AppMethodBeat.m2505o(105454);
        return startsWith;
    }

    public final void initialize() {
        AppMethodBeat.m2504i(105455);
        File awW = awW();
        if (awW == null || !awW.exists()) {
            C45124d.m82927e("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
        }
        AppMethodBeat.m2505o(105455);
    }

    public final void release() {
    }

    public final void awP() {
        AppMethodBeat.m2504i(105456);
        File file = new File(this.gXQ);
        C42367l.m74941E(file);
        if (file.exists()) {
            file.delete();
        }
        AppMethodBeat.m2505o(105456);
    }

    /* renamed from: a */
    public final C45518j mo5833a(C19681j<String> c19681j) {
        return C45518j.ERR_NOT_SUPPORTED;
    }

    /* Access modifiers changed, original: final */
    public final File awW() {
        AppMethodBeat.m2504i(105457);
        if (TextUtils.isEmpty(this.gXQ)) {
            AppMethodBeat.m2505o(105457);
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
        AppMethodBeat.m2505o(105457);
        return file;
    }

    /* renamed from: a */
    private C45518j m4233a(String str, C2064a c2064a, boolean z, Object... objArr) {
        AppMethodBeat.m2504i(105458);
        C45518j c45518j;
        if (C5046bo.isNullOrNil(str)) {
            c45518j = C45518j.ERR_PERMISSION_DENIED;
            AppMethodBeat.m2505o(105458);
            return c45518j;
        }
        String yj = C42367l.m74945yj(str.replaceFirst(Pattern.quote(this.gYj), ""));
        File awW = awW();
        if (awW == null) {
            c45518j = C45518j.ERR_FS_NOT_MOUNTED;
            AppMethodBeat.m2505o(105458);
            return c45518j;
        }
        yj = C36638b.m60739jj(awW.getAbsolutePath(), yj);
        if (C5046bo.isNullOrNil(yj)) {
            c45518j = C45518j.ERR_PERMISSION_DENIED;
            AppMethodBeat.m2505o(105458);
            return c45518j;
        }
        Object obj;
        awW = new File(yj);
        File awW2 = awW();
        if (awW2 == null || !C2062w.m4235e(awW2, awW)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            c45518j = C45518j.ERR_PERMISSION_DENIED;
            AppMethodBeat.m2505o(105458);
            return c45518j;
        } else if (z || awW.getParentFile().exists()) {
            c45518j = c2064a.mo5853a(awW, objArr);
            AppMethodBeat.m2505o(105458);
            return c45518j;
        } else {
            c45518j = C45518j.ERR_PARENT_DIR_NOT_EXISTS;
            AppMethodBeat.m2505o(105458);
            return c45518j;
        }
    }

    /* renamed from: a */
    private C45518j m4234a(String str, C2064a c2064a, Object... objArr) {
        AppMethodBeat.m2504i(105459);
        C45518j a = m4233a(str, c2064a, false, objArr);
        AppMethodBeat.m2505o(105459);
        return a;
    }

    /* renamed from: e */
    private static boolean m4235e(File file, File file2) {
        AppMethodBeat.m2504i(105460);
        Object file22;
        while (file22 != null) {
            if (file.equals(file22)) {
                AppMethodBeat.m2505o(105460);
                return true;
            }
            file22 = file22.getParentFile();
        }
        AppMethodBeat.m2505o(105460);
        return false;
    }

    /* renamed from: yd */
    public final C45518j mo5849yd(String str) {
        AppMethodBeat.m2504i(105461);
        C45518j a = m4234a(str, this.gYl, new Object[0]);
        AppMethodBeat.m2505o(105461);
        return a;
    }

    /* renamed from: ye */
    public final C45518j mo5850ye(String str) {
        AppMethodBeat.m2504i(105462);
        C45518j a = m4234a(str, this.gYm, new Object[0]);
        AppMethodBeat.m2505o(105462);
        return a;
    }

    /* renamed from: X */
    public final C45518j mo5830X(String str, boolean z) {
        AppMethodBeat.m2504i(105463);
        C45518j a = m4233a(str, this.gYn, z, Boolean.valueOf(z));
        AppMethodBeat.m2505o(105463);
        return a;
    }

    /* renamed from: Y */
    public final C45518j mo5831Y(String str, boolean z) {
        AppMethodBeat.m2504i(105464);
        C45518j a = m4233a(str, this.gYo, z, Boolean.valueOf(z));
        AppMethodBeat.m2505o(105464);
        return a;
    }

    /* renamed from: a */
    public final C45518j mo5837a(String str, C19681j<List<C26753h>> c19681j) {
        AppMethodBeat.m2504i(105465);
        C45518j a = m4234a(str, this.gYp, c19681j);
        AppMethodBeat.m2505o(105465);
        return a;
    }

    /* renamed from: b */
    public final C45518j mo5843b(String str, C19681j<ByteBuffer> c19681j) {
        AppMethodBeat.m2504i(105466);
        C45518j a = m4234a(str, this.gYq, c19681j);
        AppMethodBeat.m2505o(105466);
        return a;
    }

    /* renamed from: a */
    public final C45518j mo5839a(String str, InputStream inputStream, boolean z) {
        AppMethodBeat.m2504i(105467);
        C45518j c45518j;
        if (inputStream == null) {
            c45518j = C45518j.ERR_OP_FAIL;
            AppMethodBeat.m2505o(105467);
            return c45518j;
        }
        c45518j = m4234a(str, this.gYr, inputStream, Boolean.valueOf(z));
        AppMethodBeat.m2505o(105467);
        return c45518j;
    }

    /* renamed from: yf */
    public final C45518j mo5851yf(String str) {
        AppMethodBeat.m2504i(105468);
        C45518j a = m4234a(str, this.gYs, new Object[0]);
        AppMethodBeat.m2505o(105468);
        return a;
    }

    /* renamed from: a */
    public final C45518j mo5836a(String str, C42366k c42366k) {
        AppMethodBeat.m2504i(105469);
        C45518j a = m4234a(str, this.gYt, c42366k);
        AppMethodBeat.m2505o(105469);
        return a;
    }

    /* renamed from: g */
    public final C45518j mo5846g(String str, List<C33103u> list) {
        AppMethodBeat.m2504i(105470);
        C45518j a = m4234a(str, this.gYu, list);
        AppMethodBeat.m2505o(105470);
        return a;
    }

    /* renamed from: a */
    public final C45518j mo5838a(String str, File file, boolean z) {
        AppMethodBeat.m2504i(105471);
        C45518j a = m4234a(str, this.gYv, file, Boolean.valueOf(z));
        AppMethodBeat.m2505o(105471);
        return a;
    }

    /* renamed from: Z */
    public final File mo5832Z(String str, boolean z) {
        AppMethodBeat.m2504i(105472);
        C19681j c19681j = new C19681j();
        m4234a(str, this.gYw, c19681j);
        File file = (File) c19681j.value;
        if (file == null) {
            C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", str);
            AppMethodBeat.m2505o(105472);
            return null;
        } else if (!file.exists()) {
            C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", str);
            AppMethodBeat.m2505o(105472);
            return null;
        } else if (!z && !file.isFile()) {
            C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", str);
            AppMethodBeat.m2505o(105472);
            return null;
        } else if (C42367l.m74942F(file)) {
            C45124d.m82928e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", str);
            AppMethodBeat.m2505o(105472);
            return null;
        } else {
            AppMethodBeat.m2505o(105472);
            return file;
        }
    }

    /* renamed from: b */
    public final C45518j mo5844b(String str, File file) {
        AppMethodBeat.m2504i(105473);
        C45518j a = m4234a(str, this.gYx, file);
        AppMethodBeat.m2505o(105473);
        return a;
    }

    /* renamed from: a */
    public final C45518j mo5835a(File file, String str, boolean z, C19681j<String> c19681j) {
        return C45518j.ERR_NOT_SUPPORTED;
    }

    /* renamed from: a */
    public final C45518j mo5834a(File file, String str, C19681j<String> c19681j) {
        AppMethodBeat.m2504i(105474);
        C45518j c45518j;
        if (!mo5845ca(str)) {
            c45518j = C45518j.ERR_NOT_SUPPORTED;
            AppMethodBeat.m2505o(105474);
            return c45518j;
        } else if (file == null || !file.exists()) {
            c45518j = C45518j.ERR_OP_FAIL;
            AppMethodBeat.m2505o(105474);
            return c45518j;
        } else if (TextUtils.isEmpty(str)) {
            c45518j = C45518j.ERR_NOT_SUPPORTED;
            AppMethodBeat.m2505o(105474);
            return c45518j;
        } else {
            c45518j = mo5850ye(str);
            if (c45518j == C45518j.RET_NOT_EXISTS || c45518j == C45518j.ERR_IS_FILE) {
                try {
                    c45518j = mo5839a(str, new FileInputStream(file), false);
                    if (c19681j != null) {
                        c19681j.value = str;
                    }
                } catch (Exception e) {
                    c45518j = C45518j.ERR_OP_FAIL;
                    AppMethodBeat.m2505o(105474);
                    return c45518j;
                }
            }
            AppMethodBeat.m2505o(105474);
            return c45518j;
        }
    }

    public final List<C19093a> awQ() {
        return null;
    }
}

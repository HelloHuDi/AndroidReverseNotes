package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class h {
    private static volatile h uPE = null;
    private q uPF = null;

    private h() {
    }

    public static h deH() {
        AppMethodBeat.i(26780);
        if (uPE == null) {
            synchronized (h.class) {
                try {
                    if (uPE == null) {
                        uPE = new h();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(26780);
                    }
                }
            }
        }
        h hVar = uPE;
        AppMethodBeat.o(26780);
        return hVar;
    }

    public final q deI() {
        AppMethodBeat.i(26781);
        q qVar;
        if (this.uPF != null) {
            qVar = this.uPF;
            AppMethodBeat.o(26781);
            return qVar;
        }
        aw.ZK();
        String str = (String) c.Ry().get(a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, (Object) "");
        ab.d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(26781);
            return null;
        }
        byte[] anf = bo.anf(str);
        if (anf.length <= 0) {
            AppMethodBeat.o(26781);
            return null;
        }
        this.uPF = bF(anf);
        String str2 = "WNNoteKeepTopManager";
        String str3 = "getCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.uPF != null ? this.uPF.ddR() : BuildConfig.COMMAND;
        ab.d(str2, str3, objArr);
        qVar = this.uPF;
        AppMethodBeat.o(26781);
        return qVar;
    }

    public final void a(q qVar) {
        AppMethodBeat.i(26782);
        this.uPF = qVar;
        byte[] b = b(this.uPF);
        String str = "";
        if (b != null && b.length > 0) {
            str = bo.cd(b);
        }
        String str2 = "WNNoteKeepTopManager";
        String str3 = "setCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.uPF != null ? this.uPF.ddR() : BuildConfig.COMMAND;
        ab.i(str2, str3, objArr);
        ab.i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", str);
        aw.ZK();
        c.Ry().set(a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, bo.nullAsNil(str));
        AppMethodBeat.o(26782);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A:{SYNTHETIC, Splitter:B:21:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A:{Catch:{ Exception -> 0x0059 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A:{SYNTHETIC, Splitter:B:21:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A:{Catch:{ Exception -> 0x0059 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A:{SYNTHETIC, Splitter:B:31:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073 A:{Catch:{ Exception -> 0x007a }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A:{SYNTHETIC, Splitter:B:31:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073 A:{Catch:{ Exception -> 0x007a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static q bF(byte[] bArr) {
        q qVar;
        Exception e;
        Throwable th;
        AppMethodBeat.i(26783);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(26783);
            return null;
        }
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    qVar = (q) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                        ab.e("WNNoteKeepTopManager", "toObject close exception:%s", e2);
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.e("WNNoteKeepTopManager", "toObject exception:%s", e);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e4) {
                                ab.e("WNNoteKeepTopManager", "toObject close exception:%s", e4);
                                qVar = null;
                            }
                        }
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        qVar = null;
                        AppMethodBeat.o(26783);
                        return qVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                        }
                        if (byteArrayInputStream != null) {
                        }
                        AppMethodBeat.o(26783);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e4 = e5;
                objectInputStream = null;
                ab.e("WNNoteKeepTopManager", "toObject exception:%s", e4);
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
                qVar = null;
                AppMethodBeat.o(26783);
                return qVar;
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e22) {
                        ab.e("WNNoteKeepTopManager", "toObject close exception:%s", e22);
                        AppMethodBeat.o(26783);
                        throw th;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                AppMethodBeat.o(26783);
                throw th;
            }
        } catch (Exception e6) {
            e4 = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
            ab.e("WNNoteKeepTopManager", "toObject exception:%s", e4);
            if (objectInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            qVar = null;
            AppMethodBeat.o(26783);
            return qVar;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
            if (objectInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            AppMethodBeat.o(26783);
            throw th;
        }
        AppMethodBeat.o(26783);
        return qVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f A:{SYNTHETIC, Splitter:B:20:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A:{Catch:{ Exception -> 0x0058 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A:{SYNTHETIC, Splitter:B:29:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A:{Catch:{ Exception -> 0x0078 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A:{SYNTHETIC, Splitter:B:29:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A:{Catch:{ Exception -> 0x0078 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(q qVar) {
        Exception e;
        Throwable th;
        byte[] bArr = null;
        AppMethodBeat.i(26784);
        if (qVar == null) {
            AppMethodBeat.o(26784);
        } else {
            ByteArrayOutputStream byteArrayOutputStream;
            ObjectOutputStream objectOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(qVar);
                        objectOutputStream.flush();
                        bArr = byteArrayOutputStream.toByteArray();
                        try {
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            ab.e("WNNoteKeepTopManager", "toByteArray close exception:%s", e2);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    objectOutputStream = bArr;
                    try {
                        ab.e("WNNoteKeepTopManager", "toByteArray exception:%s", e2);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e22) {
                                ab.e("WNNoteKeepTopManager", "toByteArray close exception:%s", e22);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        AppMethodBeat.o(26784);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        AppMethodBeat.o(26784);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = bArr;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e5) {
                            ab.e("WNNoteKeepTopManager", "toByteArray close exception:%s", e5);
                            AppMethodBeat.o(26784);
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    AppMethodBeat.o(26784);
                    throw th;
                }
            } catch (Exception e6) {
                e22 = e6;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                ab.e("WNNoteKeepTopManager", "toByteArray exception:%s", e22);
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.o(26784);
                return bArr;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.o(26784);
                throw th;
            }
            AppMethodBeat.o(26784);
        }
        return bArr;
    }
}

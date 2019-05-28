package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29979q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.h */
public class C14738h {
    private static volatile C14738h uPE = null;
    private C29979q uPF = null;

    private C14738h() {
    }

    public static C14738h deH() {
        AppMethodBeat.m2504i(26780);
        if (uPE == null) {
            synchronized (C14738h.class) {
                try {
                    if (uPE == null) {
                        uPE = new C14738h();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(26780);
                    }
                }
            }
        }
        C14738h c14738h = uPE;
        AppMethodBeat.m2505o(26780);
        return c14738h;
    }

    public final C29979q deI() {
        AppMethodBeat.m2504i(26781);
        C29979q c29979q;
        if (this.uPF != null) {
            c29979q = this.uPF;
            AppMethodBeat.m2505o(26781);
            return c29979q;
        }
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, (Object) "");
        C4990ab.m7411d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(26781);
            return null;
        }
        byte[] anf = C5046bo.anf(str);
        if (anf.length <= 0) {
            AppMethodBeat.m2505o(26781);
            return null;
        }
        this.uPF = C14738h.m22930bF(anf);
        String str2 = "WNNoteKeepTopManager";
        String str3 = "getCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.uPF != null ? this.uPF.ddR() : BuildConfig.COMMAND;
        C4990ab.m7411d(str2, str3, objArr);
        c29979q = this.uPF;
        AppMethodBeat.m2505o(26781);
        return c29979q;
    }

    /* renamed from: a */
    public final void mo27009a(C29979q c29979q) {
        AppMethodBeat.m2504i(26782);
        this.uPF = c29979q;
        byte[] b = C14738h.m22929b(this.uPF);
        String str = "";
        if (b != null && b.length > 0) {
            str = C5046bo.m7543cd(b);
        }
        String str2 = "WNNoteKeepTopManager";
        String str3 = "setCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.uPF != null ? this.uPF.ddR() : BuildConfig.COMMAND;
        C4990ab.m7417i(str2, str3, objArr);
        C4990ab.m7417i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", str);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, C5046bo.nullAsNil(str));
        AppMethodBeat.m2505o(26782);
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
    /* renamed from: bF */
    private static C29979q m22930bF(byte[] bArr) {
        C29979q c29979q;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(26783);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.m2505o(26783);
            return null;
        }
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    c29979q = (C29979q) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                        C4990ab.m7413e("WNNoteKeepTopManager", "toObject close exception:%s", e2);
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.m7413e("WNNoteKeepTopManager", "toObject exception:%s", e);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e4) {
                                C4990ab.m7413e("WNNoteKeepTopManager", "toObject close exception:%s", e4);
                                c29979q = null;
                            }
                        }
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        c29979q = null;
                        AppMethodBeat.m2505o(26783);
                        return c29979q;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                        }
                        if (byteArrayInputStream != null) {
                        }
                        AppMethodBeat.m2505o(26783);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e4 = e5;
                objectInputStream = null;
                C4990ab.m7413e("WNNoteKeepTopManager", "toObject exception:%s", e4);
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
                c29979q = null;
                AppMethodBeat.m2505o(26783);
                return c29979q;
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e22) {
                        C4990ab.m7413e("WNNoteKeepTopManager", "toObject close exception:%s", e22);
                        AppMethodBeat.m2505o(26783);
                        throw th;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                AppMethodBeat.m2505o(26783);
                throw th;
            }
        } catch (Exception e6) {
            e4 = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
            C4990ab.m7413e("WNNoteKeepTopManager", "toObject exception:%s", e4);
            if (objectInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            c29979q = null;
            AppMethodBeat.m2505o(26783);
            return c29979q;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
            if (objectInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            AppMethodBeat.m2505o(26783);
            throw th;
        }
        AppMethodBeat.m2505o(26783);
        return c29979q;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f A:{SYNTHETIC, Splitter:B:20:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A:{Catch:{ Exception -> 0x0058 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A:{SYNTHETIC, Splitter:B:29:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A:{Catch:{ Exception -> 0x0078 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A:{SYNTHETIC, Splitter:B:29:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A:{Catch:{ Exception -> 0x0078 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static byte[] m22929b(C29979q c29979q) {
        Exception e;
        Throwable th;
        byte[] bArr = null;
        AppMethodBeat.m2504i(26784);
        if (c29979q == null) {
            AppMethodBeat.m2505o(26784);
        } else {
            ByteArrayOutputStream byteArrayOutputStream;
            ObjectOutputStream objectOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(c29979q);
                        objectOutputStream.flush();
                        bArr = byteArrayOutputStream.toByteArray();
                        try {
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            C4990ab.m7413e("WNNoteKeepTopManager", "toByteArray close exception:%s", e2);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    objectOutputStream = bArr;
                    try {
                        C4990ab.m7413e("WNNoteKeepTopManager", "toByteArray exception:%s", e2);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e22) {
                                C4990ab.m7413e("WNNoteKeepTopManager", "toByteArray close exception:%s", e22);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        AppMethodBeat.m2505o(26784);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(26784);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = bArr;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e5) {
                            C4990ab.m7413e("WNNoteKeepTopManager", "toByteArray close exception:%s", e5);
                            AppMethodBeat.m2505o(26784);
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    AppMethodBeat.m2505o(26784);
                    throw th;
                }
            } catch (Exception e6) {
                e22 = e6;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                C4990ab.m7413e("WNNoteKeepTopManager", "toByteArray exception:%s", e22);
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.m2505o(26784);
                return bArr;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.m2505o(26784);
                throw th;
            }
            AppMethodBeat.m2505o(26784);
        }
        return bArr;
    }
}

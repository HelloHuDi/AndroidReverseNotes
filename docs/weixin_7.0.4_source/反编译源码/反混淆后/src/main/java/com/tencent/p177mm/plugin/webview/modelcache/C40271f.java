package com.tencent.p177mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.f */
public final class C40271f {
    private final SparseArray<C40272b<C40270a>> unM = new SparseArray();

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.f$c */
    public static final class C14520c {
        public final int unN;
        public final int unO;

        public C14520c(int i, int i2) {
            this.unO = i;
            this.unN = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.f$a */
    static final class C40270a {
        public final String appId;
        public final String cSx;
        public final String cSy;
        public final int cSz;
        public final int key;
        public final int unN;
        public final int unO;
        public final String unP;
    }

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.f$b */
    static final class C40272b<T> {
        final byte[] eMl = new byte[0];
        final SparseArray<T> unQ = new SparseArray();

        public C40272b() {
            AppMethodBeat.m2504i(6829);
            AppMethodBeat.m2505o(6829);
        }

        public final T valueAt(int i) {
            AppMethodBeat.m2504i(6830);
            Object valueAt = this.unQ.valueAt(i);
            AppMethodBeat.m2505o(6830);
            return valueAt;
        }

        public final void remove(int i) {
            AppMethodBeat.m2504i(6831);
            this.unQ.remove(i);
            AppMethodBeat.m2505o(6831);
        }
    }

    public C40271f() {
        AppMethodBeat.m2504i(6832);
        AppMethodBeat.m2505o(6832);
    }

    /* renamed from: IM */
    public final boolean mo63626IM(int i) {
        C40272b c40272b;
        AppMethodBeat.m2504i(6833);
        synchronized (this.unM) {
            try {
                c40272b = (C40272b) this.unM.get(i);
                this.unM.remove(i);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(6833);
                }
            }
        }
        if (c40272b != null) {
            synchronized (c40272b.eMl) {
                try {
                    c40272b.unQ.clear();
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(6833);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(6833);
        return true;
    }

    /* renamed from: a */
    public final boolean mo63627a(int i, String str, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(6834);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || !(i2 == 2 || i2 == 1 || i2 == 3)) {
            AppMethodBeat.m2505o(6834);
            return false;
        }
        C40272b c40272b;
        synchronized (this.unM) {
            try {
                c40272b = (C40272b) this.unM.get(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(6834);
            }
        }
        if (c40272b == null) {
            return true;
        }
        synchronized (c40272b.eMl) {
            try {
                if (c40272b.unQ.size() == 0) {
                } else {
                    LinkedList<Integer> linkedList = new LinkedList();
                    for (int i3 = 0; i3 < c40272b.unQ.size(); i3++) {
                        C40270a c40270a = (C40270a) c40272b.valueAt(i3);
                        if (C5046bo.nullAsNil(c40270a.appId).equals(str) && C5046bo.nullAsNil(c40270a.cSx).equals(str2) && C5046bo.nullAsNil(c40270a.cSy).equals(str3) && c40270a.cSz == i2) {
                            linkedList.add(Integer.valueOf(c40270a.key));
                        }
                    }
                    for (Integer intValue : linkedList) {
                        c40272b.remove(intValue.intValue());
                    }
                    AppMethodBeat.m2505o(6834);
                    return true;
                }
            } finally {
                AppMethodBeat.m2505o(6834);
            }
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo63628a(int i, String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.m2504i(6835);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4) || !(i2 == 2 || i2 == 1 || i2 == 3)) {
            AppMethodBeat.m2505o(6835);
            return false;
        }
        C40272b c40272b;
        synchronized (this.unM) {
            try {
                c40272b = (C40272b) this.unM.get(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(6835);
            }
        }
        if (c40272b == null) {
            return true;
        }
        synchronized (c40272b.eMl) {
            try {
                if (c40272b.unQ.size() == 0) {
                } else {
                    LinkedList<Integer> linkedList = new LinkedList();
                    for (int i3 = 0; i3 < c40272b.unQ.size(); i3++) {
                        C40270a c40270a = (C40270a) c40272b.valueAt(i3);
                        if (C5046bo.nullAsNil(c40270a.appId).equals(str) && C5046bo.nullAsNil(c40270a.cSx).equals(str2) && C5046bo.nullAsNil(c40270a.cSy).equals(str3) && C5046bo.nullAsNil(c40270a.unP).equals(str4) && c40270a.cSz == i2) {
                            linkedList.add(Integer.valueOf(c40270a.key));
                        }
                    }
                    for (Integer intValue : linkedList) {
                        c40272b.remove(intValue.intValue());
                    }
                    AppMethodBeat.m2505o(6835);
                    return true;
                }
            } finally {
                AppMethodBeat.m2505o(6835);
            }
        }
        return true;
    }

    /* renamed from: u */
    public final List<C14520c> mo63629u(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(6836);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4)) {
            AppMethodBeat.m2505o(6836);
            return null;
        }
        String aeM = C14525q.aeM(str);
        if (C5046bo.isNullOrNil(aeM)) {
            AppMethodBeat.m2505o(6836);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.unM) {
            int size;
            int i = 0;
            while (true) {
                C40272b c40272b;
                try {
                    if (i < this.unM.size()) {
                        c40272b = (C40272b) this.unM.valueAt(i);
                        if (c40272b != null) {
                            byte[] bArr = c40272b.eMl;
                            synchronized (bArr) {
                                int i2 = size;
                                while (true) {
                                    size = c40272b.unQ.size();
                                    if (i2 >= size) {
                                        break;
                                    }
                                    C40270a c40270a = (C40270a) c40272b.valueAt(i2);
                                    if (C5046bo.nullAsNil(c40270a.unP).equals(aeM) && C5046bo.nullAsNil(c40270a.appId).equals(str2) && C5046bo.nullAsNil(c40270a.cSx).equals(str3) && C5046bo.nullAsNil(c40270a.cSy).equals(str4)) {
                                        linkedList.add(new C14520c(c40270a.unO, c40270a.unN));
                                    }
                                    i2++;
                                }
                                i++;
                            }
                        } else {
                            i++;
                        }
                    }
                } catch (Throwable th) {
                    c40272b = th;
                } finally {
                    size = 6836;
                    AppMethodBeat.m2505o(6836);
                }
            }
            AppMethodBeat.m2505o(size);
        }
        AppMethodBeat.m2505o(6836);
        return linkedList;
    }
}

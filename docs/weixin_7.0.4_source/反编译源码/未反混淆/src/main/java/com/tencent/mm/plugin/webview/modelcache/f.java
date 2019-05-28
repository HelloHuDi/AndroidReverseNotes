package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class f {
    private final SparseArray<b<a>> unM = new SparseArray();

    public static final class c {
        public final int unN;
        public final int unO;

        public c(int i, int i2) {
            this.unO = i;
            this.unN = i2;
        }
    }

    static final class a {
        public final String appId;
        public final String cSx;
        public final String cSy;
        public final int cSz;
        public final int key;
        public final int unN;
        public final int unO;
        public final String unP;
    }

    static final class b<T> {
        final byte[] eMl = new byte[0];
        final SparseArray<T> unQ = new SparseArray();

        public b() {
            AppMethodBeat.i(6829);
            AppMethodBeat.o(6829);
        }

        public final T valueAt(int i) {
            AppMethodBeat.i(6830);
            Object valueAt = this.unQ.valueAt(i);
            AppMethodBeat.o(6830);
            return valueAt;
        }

        public final void remove(int i) {
            AppMethodBeat.i(6831);
            this.unQ.remove(i);
            AppMethodBeat.o(6831);
        }
    }

    public f() {
        AppMethodBeat.i(6832);
        AppMethodBeat.o(6832);
    }

    public final boolean IM(int i) {
        b bVar;
        AppMethodBeat.i(6833);
        synchronized (this.unM) {
            try {
                bVar = (b) this.unM.get(i);
                this.unM.remove(i);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(6833);
                }
            }
        }
        if (bVar != null) {
            synchronized (bVar.eMl) {
                try {
                    bVar.unQ.clear();
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(6833);
                    }
                }
            }
        }
        AppMethodBeat.o(6833);
        return true;
    }

    public final boolean a(int i, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(6834);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || !(i2 == 2 || i2 == 1 || i2 == 3)) {
            AppMethodBeat.o(6834);
            return false;
        }
        b bVar;
        synchronized (this.unM) {
            try {
                bVar = (b) this.unM.get(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(6834);
            }
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.eMl) {
            try {
                if (bVar.unQ.size() == 0) {
                } else {
                    LinkedList<Integer> linkedList = new LinkedList();
                    for (int i3 = 0; i3 < bVar.unQ.size(); i3++) {
                        a aVar = (a) bVar.valueAt(i3);
                        if (bo.nullAsNil(aVar.appId).equals(str) && bo.nullAsNil(aVar.cSx).equals(str2) && bo.nullAsNil(aVar.cSy).equals(str3) && aVar.cSz == i2) {
                            linkedList.add(Integer.valueOf(aVar.key));
                        }
                    }
                    for (Integer intValue : linkedList) {
                        bVar.remove(intValue.intValue());
                    }
                    AppMethodBeat.o(6834);
                    return true;
                }
            } finally {
                AppMethodBeat.o(6834);
            }
        }
        return true;
    }

    public final boolean a(int i, String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(6835);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4) || !(i2 == 2 || i2 == 1 || i2 == 3)) {
            AppMethodBeat.o(6835);
            return false;
        }
        b bVar;
        synchronized (this.unM) {
            try {
                bVar = (b) this.unM.get(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(6835);
            }
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.eMl) {
            try {
                if (bVar.unQ.size() == 0) {
                } else {
                    LinkedList<Integer> linkedList = new LinkedList();
                    for (int i3 = 0; i3 < bVar.unQ.size(); i3++) {
                        a aVar = (a) bVar.valueAt(i3);
                        if (bo.nullAsNil(aVar.appId).equals(str) && bo.nullAsNil(aVar.cSx).equals(str2) && bo.nullAsNil(aVar.cSy).equals(str3) && bo.nullAsNil(aVar.unP).equals(str4) && aVar.cSz == i2) {
                            linkedList.add(Integer.valueOf(aVar.key));
                        }
                    }
                    for (Integer intValue : linkedList) {
                        bVar.remove(intValue.intValue());
                    }
                    AppMethodBeat.o(6835);
                    return true;
                }
            } finally {
                AppMethodBeat.o(6835);
            }
        }
        return true;
    }

    public final List<c> u(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(6836);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4)) {
            AppMethodBeat.o(6836);
            return null;
        }
        String aeM = q.aeM(str);
        if (bo.isNullOrNil(aeM)) {
            AppMethodBeat.o(6836);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.unM) {
            int size;
            int i = 0;
            while (true) {
                b bVar;
                try {
                    if (i < this.unM.size()) {
                        bVar = (b) this.unM.valueAt(i);
                        if (bVar != null) {
                            byte[] bArr = bVar.eMl;
                            synchronized (bArr) {
                                int i2 = size;
                                while (true) {
                                    size = bVar.unQ.size();
                                    if (i2 >= size) {
                                        break;
                                    }
                                    a aVar = (a) bVar.valueAt(i2);
                                    if (bo.nullAsNil(aVar.unP).equals(aeM) && bo.nullAsNil(aVar.appId).equals(str2) && bo.nullAsNil(aVar.cSx).equals(str3) && bo.nullAsNil(aVar.cSy).equals(str4)) {
                                        linkedList.add(new c(aVar.unO, aVar.unN));
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
                    bVar = th;
                } finally {
                    size = 6836;
                    AppMethodBeat.o(6836);
                }
            }
            AppMethodBeat.o(size);
        }
        AppMethodBeat.o(6836);
        return linkedList;
    }
}

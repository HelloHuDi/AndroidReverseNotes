package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d implements f, g {
    final List<b> fDn = Collections.synchronizedList(new LinkedList());
    private HashSet<b> fDo = new HashSet();
    b fDp = null;
    private k fDq = null;
    public boolean fDr = false;

    public interface a {
        void a(long j, long j2, int i, int i2, Object obj);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar);
    }

    static class c {
        a fDw;
        Object fDx;

        public c(a aVar, Object obj) {
            this.fDw = aVar;
            this.fDx = obj;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            if (this.fDw == ((c) obj).fDw) {
                return true;
            }
            return false;
        }
    }

    static class b {
        private int aBR = 0;
        public long eln;
        public long fDs;
        public int fDt;
        public int fDu;
        public List<c> fDv;

        public b(long j, long j2, int i) {
            this.fDs = j;
            this.eln = j2;
            this.fDt = i;
            this.fDu = 0;
        }

        public final boolean a(a aVar, Object obj) {
            AppMethodBeat.i(78173);
            if (this.fDv == null) {
                this.fDv = Collections.synchronizedList(new LinkedList());
            }
            c cVar = new c(aVar, obj);
            if (this.fDv.contains(cVar)) {
                ab.d("ModelImage.DownloadImgService.Task", "task item already exists");
                AppMethodBeat.o(78173);
                return false;
            }
            this.fDv.add(cVar);
            AppMethodBeat.o(78173);
            return true;
        }

        public final boolean b(a aVar) {
            AppMethodBeat.i(78174);
            c cVar = new c(aVar, null);
            if (this.fDv.contains(cVar)) {
                this.fDv.remove(cVar);
                AppMethodBeat.o(78174);
                return true;
            }
            AppMethodBeat.o(78174);
            return false;
        }

        public final int agO() {
            AppMethodBeat.i(78175);
            int size = this.fDv.size();
            AppMethodBeat.o(78175);
            return size;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.fDs == this.fDs && bVar.eln == this.eln && bVar.fDt == this.fDt) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(78176);
            if (this.aBR == 0) {
                this.aBR = (this.fDs + "_" + this.eln + "_" + this.fDt).hashCode();
            }
            int i = this.aBR;
            AppMethodBeat.o(78176);
            return i;
        }
    }

    public d() {
        AppMethodBeat.i(78177);
        com.tencent.mm.kernel.g.RO().eJo.a(109, (f) this);
        AppMethodBeat.o(78177);
    }

    public final boolean a(long j, long j2, int i, Object obj, int i2, a aVar) {
        AppMethodBeat.i(78178);
        if (a(j, j2, i, obj, i2, aVar, -1, false) >= 0) {
            AppMethodBeat.o(78178);
            return true;
        }
        AppMethodBeat.o(78178);
        return false;
    }

    public final int a(long j, long j2, Object obj, a aVar) {
        AppMethodBeat.i(78179);
        int a = a(j, j2, 1, obj, R.drawable.b0p, aVar, 0, false);
        AppMethodBeat.o(78179);
        return a;
    }

    public final int a(long j, long j2, int i, Object obj, int i2, a aVar, int i3, boolean z) {
        AppMethodBeat.i(78180);
        if (aVar == null) {
            ab.e("ModelImage.DownloadImgService", "listener is null");
            AppMethodBeat.o(78180);
            return -1;
        }
        b bVar = new b(j, j2, i);
        bVar.fDu = i2;
        if (this.fDo.contains(bVar)) {
            ab.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] add failed, task already done");
            AppMethodBeat.o(78180);
            return -2;
        } else if (this.fDp == null || !bVar.equals(this.fDp)) {
            int indexOf = this.fDn.indexOf(bVar);
            if (indexOf < 0 || indexOf >= this.fDn.size()) {
                ab.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] no found task, create a new task(" + j + " " + j2 + " " + i + ") mLockStart: %s callbackDuration %s", Boolean.valueOf(this.fDr), Integer.valueOf(i3));
                bVar.a(aVar, obj);
                if (!((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.comm.a.b.class)).bhI()) {
                    this.fDn.add(bVar);
                } else if (!z || this.fDn.size() <= 0) {
                    this.fDn.add(bVar);
                } else {
                    this.fDn.add(0, bVar);
                }
                lq(i3);
                AppMethodBeat.o(78180);
                return 0;
            } else if (((b) this.fDn.get(indexOf)).a(aVar, obj)) {
                AppMethodBeat.o(78180);
                return 0;
            } else {
                AppMethodBeat.o(78180);
                return -4;
            }
        } else if (this.fDp.a(aVar, obj)) {
            AppMethodBeat.o(78180);
            return 0;
        } else {
            AppMethodBeat.o(78180);
            return -3;
        }
    }

    public final boolean a(long j, long j2, int i) {
        AppMethodBeat.i(78181);
        b bVar = new b(j, j2, i);
        if (this.fDp != null && this.fDp.equals(bVar)) {
            AppMethodBeat.o(78181);
            return true;
        } else if (this.fDn.indexOf(bVar) >= 0) {
            AppMethodBeat.o(78181);
            return true;
        } else {
            AppMethodBeat.o(78181);
            return false;
        }
    }

    public final boolean a(long j, long j2, a aVar) {
        AppMethodBeat.i(78182);
        b bVar = new b(j, j2, 1);
        b bVar2 = null;
        if (this.fDp == null || !this.fDp.equals(bVar)) {
            int indexOf = this.fDn.indexOf(bVar);
            if (-1 != indexOf) {
                bVar2 = (b) this.fDn.get(indexOf);
            }
        } else {
            bVar2 = this.fDp;
        }
        if (bVar2 != null) {
            bVar2.b(aVar);
            a(bVar2);
            ab.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task has been canceled, (" + j + ", " + j2 + ", 1)");
            AppMethodBeat.o(78182);
            return true;
        }
        ab.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task no found, (" + j + ", " + j2 + ", 1)");
        AppMethodBeat.o(78182);
        return false;
    }

    public final void a(a aVar) {
        String str;
        String str2;
        Object[] objArr;
        b bVar;
        AppMethodBeat.i(78183);
        ab.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] cancel all tasks of listener");
        this.fDr = true;
        if (this.fDp != null) {
            str = "ModelImage.DownloadImgService";
            str2 = "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s";
            objArr = new Object[3];
            objArr[0] = this.fDp == null ? "mCurTaskInfo is null" : this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt;
            objArr[1] = Integer.valueOf(this.fDn.size());
            objArr[2] = Boolean.valueOf(this.fDr);
            ab.i(str, str2, objArr);
            if (((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.comm.a.b.class)).bhI()) {
                b(this.fDp);
            } else {
                this.fDp.b(aVar);
                bVar = this.fDp;
                if (bVar.fDv != null) {
                    bVar.fDv.clear();
                }
                a(this.fDp);
            }
        }
        LinkedList<b> linkedList = new LinkedList();
        synchronized (this.fDn) {
            try {
                linkedList.addAll(this.fDn);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(78183);
                }
            }
        }
        for (b bVar2 : linkedList) {
            if (bVar2 != null) {
                bVar2.b(aVar);
                a(bVar2);
            }
        }
        agN();
        str = "ModelImage.DownloadImgService";
        str2 = "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s";
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(aVar.hashCode());
        objArr[1] = this.fDp == null ? "mCurTaskInfo is null" : this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt;
        ab.i(str, str2, objArr);
        AppMethodBeat.o(78183);
    }

    private boolean a(b bVar) {
        AppMethodBeat.i(78184);
        if (bVar == null || bVar.agO() > 0) {
            AppMethodBeat.o(78184);
            return false;
        }
        boolean b = b(bVar);
        AppMethodBeat.o(78184);
        return b;
    }

    public final boolean x(long j, long j2) {
        AppMethodBeat.i(78185);
        boolean b = b(new b(j, j2, 1));
        AppMethodBeat.o(78185);
        return b;
    }

    /* Access modifiers changed, original: final */
    public final boolean b(b bVar) {
        AppMethodBeat.i(78186);
        if (bVar == null) {
            ab.e("ModelImage.DownloadImgService", "task is null");
            AppMethodBeat.o(78186);
            return false;
        }
        ab.i("ModelImage.DownloadImgService", "cancel scene, (" + bVar.fDs + ", " + bVar.eln + ", " + bVar.fDt + ")");
        if (this.fDp != null && this.fDp.equals(bVar)) {
            com.tencent.mm.kernel.g.RO().eJo.c(this.fDq);
            this.fDq = null;
            ab.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", Long.valueOf(bVar.fDs), Long.valueOf(bVar.eln), Integer.valueOf(bVar.fDt));
            c(this.fDp);
            this.fDp = null;
            lq(-1);
            AppMethodBeat.o(78186);
            return true;
        } else if (this.fDn.contains(bVar)) {
            if (this.fDn.remove(bVar)) {
                c(bVar);
            }
            AppMethodBeat.o(78186);
            return true;
        } else {
            AppMethodBeat.o(78186);
            return false;
        }
    }

    private static void c(b bVar) {
        AppMethodBeat.i(78187);
        if (bVar == null) {
            ab.e("ModelImage.DownloadImgService", "task is null");
            AppMethodBeat.o(78187);
        } else if (bVar.fDv == null) {
            ab.e("ModelImage.DownloadImgService", "task callback list is null");
            AppMethodBeat.o(78187);
        } else {
            for (c cVar : bVar.fDv) {
                if (cVar.fDw != null) {
                    cVar.fDw.a(bVar.fDs, bVar.eln, bVar.fDt, bVar.fDu, cVar.fDx);
                }
            }
            AppMethodBeat.o(78187);
        }
    }

    public final void agN() {
        AppMethodBeat.i(78188);
        this.fDr = false;
        lq(-1);
        AppMethodBeat.o(78188);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78189);
        if (this.fDq != mVar) {
            ab.d("ModelImage.DownloadImgService", "scene changed");
            AppMethodBeat.o(78189);
            return;
        }
        if (!(this.fDp == null || this.fDp.fDv == null)) {
            this.fDo.add(new b(this.fDp.fDs, this.fDp.eln, this.fDp.fDt));
            ab.i("ModelImage.DownloadImgService", "scene end, (" + this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt + ")");
            for (c cVar : new ArrayList(this.fDp.fDv)) {
                if (cVar.fDw != null) {
                    cVar.fDw.a(this.fDp.fDs, this.fDp.eln, this.fDp.fDt, this.fDp.fDu, cVar.fDx, i, i2, str, mVar);
                }
            }
            this.fDp = null;
            this.fDq = null;
            lq(-1);
        }
        AppMethodBeat.o(78189);
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(78190);
        if (this.fDq != mVar) {
            ab.d("ModelImage.DownloadImgService", "scene changed");
            AppMethodBeat.o(78190);
            return;
        }
        if (!(this.fDp == null || this.fDp.fDv == null)) {
            for (c cVar : new ArrayList(this.fDp.fDv)) {
                if (cVar.fDw != null) {
                    cVar.fDw.a(this.fDp.fDs, this.fDp.eln, this.fDp.fDt, this.fDp.fDu, cVar.fDx, i, i2, mVar);
                }
            }
        }
        AppMethodBeat.o(78190);
    }

    /* JADX WARNING: Missing block: B:19:0x008a, code skipped:
            if (r11.fDp != null) goto L_0x009f;
     */
    /* JADX WARNING: Missing block: B:20:0x008c, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
            com.tencent.matrix.trace.core.AppMethodBeat.o(78191);
     */
    /* JADX WARNING: Missing block: B:25:0x009f, code skipped:
            r11.fDq = new com.tencent.mm.at.k(r11.fDp.fDs, r11.fDp.eln, r11.fDp.fDt, r11, r12);
            r11.fDq.fFe = r11.fDp.fDu;
            com.tencent.mm.sdk.platformtools.ab.i("ModelImage.DownloadImgService", "do scene, (" + r11.fDp.fDs + ", " + r11.fDp.eln + ", " + r11.fDp.fDt + ")");
            com.tencent.mm.kernel.g.RO().eJo.a(r11.fDq, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(78191);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void lq(int i) {
        AppMethodBeat.i(78191);
        synchronized (this.fDn) {
            try {
                if (this.fDp != null || this.fDn.size() <= 0 || true == this.fDr) {
                    String str = "ModelImage.DownloadImgService";
                    String str2 = "mCurTaskInfo %s mTodoList %s mLockStart %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = this.fDp == null ? "mCurTaskInfo is null" : this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt;
                    objArr[1] = Integer.valueOf(this.fDn.size());
                    objArr[2] = Boolean.valueOf(this.fDr);
                    ab.i(str, str2, objArr);
                } else {
                    this.fDp = (b) this.fDn.remove(0);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(78191);
            }
        }
    }
}

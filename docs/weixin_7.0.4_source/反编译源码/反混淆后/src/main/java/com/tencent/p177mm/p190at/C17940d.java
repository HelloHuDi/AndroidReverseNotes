package com.tencent.p177mm.p190at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.at.d */
public final class C17940d implements C1202f, C32231g {
    final List<C17941b> fDn = Collections.synchronizedList(new LinkedList());
    private HashSet<C17941b> fDo = new HashSet();
    C17941b fDp = null;
    private C25826k fDq = null;
    public boolean fDr = false;

    /* renamed from: com.tencent.mm.at.d$a */
    public interface C9017a {
        /* renamed from: a */
        void mo20449a(long j, long j2, int i, int i2, Object obj);

        /* renamed from: a */
        void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m);

        /* renamed from: a */
        void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m);
    }

    /* renamed from: com.tencent.mm.at.d$c */
    static class C17939c {
        C9017a fDw;
        Object fDx;

        public C17939c(C9017a c9017a, Object obj) {
            this.fDw = c9017a;
            this.fDx = obj;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C17939c)) {
                return false;
            }
            if (this.fDw == ((C17939c) obj).fDw) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.at.d$b */
    static class C17941b {
        private int aBR = 0;
        public long eln;
        public long fDs;
        public int fDt;
        public int fDu;
        public List<C17939c> fDv;

        public C17941b(long j, long j2, int i) {
            this.fDs = j;
            this.eln = j2;
            this.fDt = i;
            this.fDu = 0;
        }

        /* renamed from: a */
        public final boolean mo33472a(C9017a c9017a, Object obj) {
            AppMethodBeat.m2504i(78173);
            if (this.fDv == null) {
                this.fDv = Collections.synchronizedList(new LinkedList());
            }
            C17939c c17939c = new C17939c(c9017a, obj);
            if (this.fDv.contains(c17939c)) {
                C4990ab.m7410d("ModelImage.DownloadImgService.Task", "task item already exists");
                AppMethodBeat.m2505o(78173);
                return false;
            }
            this.fDv.add(c17939c);
            AppMethodBeat.m2505o(78173);
            return true;
        }

        /* renamed from: b */
        public final boolean mo33474b(C9017a c9017a) {
            AppMethodBeat.m2504i(78174);
            C17939c c17939c = new C17939c(c9017a, null);
            if (this.fDv.contains(c17939c)) {
                this.fDv.remove(c17939c);
                AppMethodBeat.m2505o(78174);
                return true;
            }
            AppMethodBeat.m2505o(78174);
            return false;
        }

        public final int agO() {
            AppMethodBeat.m2504i(78175);
            int size = this.fDv.size();
            AppMethodBeat.m2505o(78175);
            return size;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C17941b)) {
                return false;
            }
            C17941b c17941b = (C17941b) obj;
            if (c17941b.fDs == this.fDs && c17941b.eln == this.eln && c17941b.fDt == this.fDt) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(78176);
            if (this.aBR == 0) {
                this.aBR = (this.fDs + "_" + this.eln + "_" + this.fDt).hashCode();
            }
            int i = this.aBR;
            AppMethodBeat.m2505o(78176);
            return i;
        }
    }

    public C17940d() {
        AppMethodBeat.m2504i(78177);
        C1720g.m3535RO().eJo.mo14539a(109, (C1202f) this);
        AppMethodBeat.m2505o(78177);
    }

    /* renamed from: a */
    public final boolean mo33467a(long j, long j2, int i, Object obj, int i2, C9017a c9017a) {
        AppMethodBeat.m2504i(78178);
        if (mo33463a(j, j2, i, obj, i2, c9017a, -1, false) >= 0) {
            AppMethodBeat.m2505o(78178);
            return true;
        }
        AppMethodBeat.m2505o(78178);
        return false;
    }

    /* renamed from: a */
    public final int mo33464a(long j, long j2, Object obj, C9017a c9017a) {
        AppMethodBeat.m2504i(78179);
        int a = mo33463a(j, j2, 1, obj, C25738R.drawable.b0p, c9017a, 0, false);
        AppMethodBeat.m2505o(78179);
        return a;
    }

    /* renamed from: a */
    public final int mo33463a(long j, long j2, int i, Object obj, int i2, C9017a c9017a, int i3, boolean z) {
        AppMethodBeat.m2504i(78180);
        if (c9017a == null) {
            C4990ab.m7412e("ModelImage.DownloadImgService", "listener is null");
            AppMethodBeat.m2505o(78180);
            return -1;
        }
        C17941b c17941b = new C17941b(j, j2, i);
        c17941b.fDu = i2;
        if (this.fDo.contains(c17941b)) {
            C4990ab.m7412e("ModelImage.DownloadImgService", "[" + c9017a.hashCode() + "] add failed, task already done");
            AppMethodBeat.m2505o(78180);
            return -2;
        } else if (this.fDp == null || !c17941b.equals(this.fDp)) {
            int indexOf = this.fDn.indexOf(c17941b);
            if (indexOf < 0 || indexOf >= this.fDn.size()) {
                C4990ab.m7417i("ModelImage.DownloadImgService", "[" + c9017a.hashCode() + "] no found task, create a new task(" + j + " " + j2 + " " + i + ") mLockStart: %s callbackDuration %s", Boolean.valueOf(this.fDr), Integer.valueOf(i3));
                c17941b.mo33472a(c9017a, obj);
                if (!((C20286b) C1720g.m3528K(C20286b.class)).bhI()) {
                    this.fDn.add(c17941b);
                } else if (!z || this.fDn.size() <= 0) {
                    this.fDn.add(c17941b);
                } else {
                    this.fDn.add(0, c17941b);
                }
                m28191lq(i3);
                AppMethodBeat.m2505o(78180);
                return 0;
            } else if (((C17941b) this.fDn.get(indexOf)).mo33472a(c9017a, obj)) {
                AppMethodBeat.m2505o(78180);
                return 0;
            } else {
                AppMethodBeat.m2505o(78180);
                return -4;
            }
        } else if (this.fDp.mo33472a(c9017a, obj)) {
            AppMethodBeat.m2505o(78180);
            return 0;
        } else {
            AppMethodBeat.m2505o(78180);
            return -3;
        }
    }

    /* renamed from: a */
    public final boolean mo33466a(long j, long j2, int i) {
        AppMethodBeat.m2504i(78181);
        C17941b c17941b = new C17941b(j, j2, i);
        if (this.fDp != null && this.fDp.equals(c17941b)) {
            AppMethodBeat.m2505o(78181);
            return true;
        } else if (this.fDn.indexOf(c17941b) >= 0) {
            AppMethodBeat.m2505o(78181);
            return true;
        } else {
            AppMethodBeat.m2505o(78181);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo33468a(long j, long j2, C9017a c9017a) {
        AppMethodBeat.m2504i(78182);
        C17941b c17941b = new C17941b(j, j2, 1);
        C17941b c17941b2 = null;
        if (this.fDp == null || !this.fDp.equals(c17941b)) {
            int indexOf = this.fDn.indexOf(c17941b);
            if (-1 != indexOf) {
                c17941b2 = (C17941b) this.fDn.get(indexOf);
            }
        } else {
            c17941b2 = this.fDp;
        }
        if (c17941b2 != null) {
            c17941b2.mo33474b(c9017a);
            m28189a(c17941b2);
            C4990ab.m7416i("ModelImage.DownloadImgService", "[" + c9017a.hashCode() + "] task has been canceled, (" + j + ", " + j2 + ", 1)");
            AppMethodBeat.m2505o(78182);
            return true;
        }
        C4990ab.m7412e("ModelImage.DownloadImgService", "[" + c9017a.hashCode() + "] task no found, (" + j + ", " + j2 + ", 1)");
        AppMethodBeat.m2505o(78182);
        return false;
    }

    /* renamed from: a */
    public final void mo33465a(C9017a c9017a) {
        String str;
        String str2;
        Object[] objArr;
        C17941b c17941b;
        AppMethodBeat.m2504i(78183);
        C4990ab.m7416i("ModelImage.DownloadImgService", "[" + c9017a.hashCode() + "] cancel all tasks of listener");
        this.fDr = true;
        if (this.fDp != null) {
            str = "ModelImage.DownloadImgService";
            str2 = "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s";
            objArr = new Object[3];
            objArr[0] = this.fDp == null ? "mCurTaskInfo is null" : this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt;
            objArr[1] = Integer.valueOf(this.fDn.size());
            objArr[2] = Boolean.valueOf(this.fDr);
            C4990ab.m7417i(str, str2, objArr);
            if (((C20286b) C1720g.m3528K(C20286b.class)).bhI()) {
                mo33470b(this.fDp);
            } else {
                this.fDp.mo33474b(c9017a);
                c17941b = this.fDp;
                if (c17941b.fDv != null) {
                    c17941b.fDv.clear();
                }
                m28189a(this.fDp);
            }
        }
        LinkedList<C17941b> linkedList = new LinkedList();
        synchronized (this.fDn) {
            try {
                linkedList.addAll(this.fDn);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(78183);
                }
            }
        }
        for (C17941b c17941b2 : linkedList) {
            if (c17941b2 != null) {
                c17941b2.mo33474b(c9017a);
                m28189a(c17941b2);
            }
        }
        agN();
        str = "ModelImage.DownloadImgService";
        str2 = "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s";
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(c9017a.hashCode());
        objArr[1] = this.fDp == null ? "mCurTaskInfo is null" : this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt;
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(78183);
    }

    /* renamed from: a */
    private boolean m28189a(C17941b c17941b) {
        AppMethodBeat.m2504i(78184);
        if (c17941b == null || c17941b.agO() > 0) {
            AppMethodBeat.m2505o(78184);
            return false;
        }
        boolean b = mo33470b(c17941b);
        AppMethodBeat.m2505o(78184);
        return b;
    }

    /* renamed from: x */
    public final boolean mo33471x(long j, long j2) {
        AppMethodBeat.m2504i(78185);
        boolean b = mo33470b(new C17941b(j, j2, 1));
        AppMethodBeat.m2505o(78185);
        return b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo33470b(C17941b c17941b) {
        AppMethodBeat.m2504i(78186);
        if (c17941b == null) {
            C4990ab.m7412e("ModelImage.DownloadImgService", "task is null");
            AppMethodBeat.m2505o(78186);
            return false;
        }
        C4990ab.m7416i("ModelImage.DownloadImgService", "cancel scene, (" + c17941b.fDs + ", " + c17941b.eln + ", " + c17941b.fDt + ")");
        if (this.fDp != null && this.fDp.equals(c17941b)) {
            C1720g.m3535RO().eJo.mo14547c(this.fDq);
            this.fDq = null;
            C4990ab.m7417i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", Long.valueOf(c17941b.fDs), Long.valueOf(c17941b.eln), Integer.valueOf(c17941b.fDt));
            C17940d.m28190c(this.fDp);
            this.fDp = null;
            m28191lq(-1);
            AppMethodBeat.m2505o(78186);
            return true;
        } else if (this.fDn.contains(c17941b)) {
            if (this.fDn.remove(c17941b)) {
                C17940d.m28190c(c17941b);
            }
            AppMethodBeat.m2505o(78186);
            return true;
        } else {
            AppMethodBeat.m2505o(78186);
            return false;
        }
    }

    /* renamed from: c */
    private static void m28190c(C17941b c17941b) {
        AppMethodBeat.m2504i(78187);
        if (c17941b == null) {
            C4990ab.m7412e("ModelImage.DownloadImgService", "task is null");
            AppMethodBeat.m2505o(78187);
        } else if (c17941b.fDv == null) {
            C4990ab.m7412e("ModelImage.DownloadImgService", "task callback list is null");
            AppMethodBeat.m2505o(78187);
        } else {
            for (C17939c c17939c : c17941b.fDv) {
                if (c17939c.fDw != null) {
                    c17939c.fDw.mo20449a(c17941b.fDs, c17941b.eln, c17941b.fDt, c17941b.fDu, c17939c.fDx);
                }
            }
            AppMethodBeat.m2505o(78187);
        }
    }

    public final void agN() {
        AppMethodBeat.m2504i(78188);
        this.fDr = false;
        m28191lq(-1);
        AppMethodBeat.m2505o(78188);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78189);
        if (this.fDq != c1207m) {
            C4990ab.m7410d("ModelImage.DownloadImgService", "scene changed");
            AppMethodBeat.m2505o(78189);
            return;
        }
        if (!(this.fDp == null || this.fDp.fDv == null)) {
            this.fDo.add(new C17941b(this.fDp.fDs, this.fDp.eln, this.fDp.fDt));
            C4990ab.m7416i("ModelImage.DownloadImgService", "scene end, (" + this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt + ")");
            for (C17939c c17939c : new ArrayList(this.fDp.fDv)) {
                if (c17939c.fDw != null) {
                    c17939c.fDw.mo20451a(this.fDp.fDs, this.fDp.eln, this.fDp.fDt, this.fDp.fDu, c17939c.fDx, i, i2, str, c1207m);
                }
            }
            this.fDp = null;
            this.fDq = null;
            m28191lq(-1);
        }
        AppMethodBeat.m2505o(78189);
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(78190);
        if (this.fDq != c1207m) {
            C4990ab.m7410d("ModelImage.DownloadImgService", "scene changed");
            AppMethodBeat.m2505o(78190);
            return;
        }
        if (!(this.fDp == null || this.fDp.fDv == null)) {
            for (C17939c c17939c : new ArrayList(this.fDp.fDv)) {
                if (c17939c.fDw != null) {
                    c17939c.fDw.mo20450a(this.fDp.fDs, this.fDp.eln, this.fDp.fDt, this.fDp.fDu, c17939c.fDx, i, i2, c1207m);
                }
            }
        }
        AppMethodBeat.m2505o(78190);
    }

    /* JADX WARNING: Missing block: B:19:0x008a, code skipped:
            if (r11.fDp != null) goto L_0x009f;
     */
    /* JADX WARNING: Missing block: B:20:0x008c, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(78191);
     */
    /* JADX WARNING: Missing block: B:25:0x009f, code skipped:
            r11.fDq = new com.tencent.p177mm.p190at.C25826k(r11.fDp.fDs, r11.fDp.eln, r11.fDp.fDt, r11, r12);
            r11.fDq.fFe = r11.fDp.fDu;
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("ModelImage.DownloadImgService", "do scene, (" + r11.fDp.fDs + ", " + r11.fDp.eln + ", " + r11.fDp.fDt + ")");
            com.tencent.p177mm.kernel.C1720g.m3535RO().eJo.mo14541a(r11.fDq, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(78191);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: lq */
    private void m28191lq(int i) {
        AppMethodBeat.m2504i(78191);
        synchronized (this.fDn) {
            try {
                if (this.fDp != null || this.fDn.size() <= 0 || true == this.fDr) {
                    String str = "ModelImage.DownloadImgService";
                    String str2 = "mCurTaskInfo %s mTodoList %s mLockStart %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = this.fDp == null ? "mCurTaskInfo is null" : this.fDp.fDs + ", " + this.fDp.eln + ", " + this.fDp.fDt;
                    objArr[1] = Integer.valueOf(this.fDn.size());
                    objArr[2] = Boolean.valueOf(this.fDr);
                    C4990ab.m7417i(str, str2, objArr);
                } else {
                    this.fDp = (C17941b) this.fDn.remove(0);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78191);
            }
        }
    }
}

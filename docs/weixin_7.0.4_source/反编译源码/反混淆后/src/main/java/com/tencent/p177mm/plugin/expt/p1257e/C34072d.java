package com.tencent.p177mm.plugin.expt.p1257e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.expt.p396d.C7503a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.e.d */
public final class C34072d extends C7563j<C7503a> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{C7563j.m13217a(C7503a.ccO, "ExptItem")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(73631);
        AppMethodBeat.m2505o(73631);
    }

    public C34072d(C4927e c4927e) {
        super(c4927e, C7503a.ccO, "ExptItem", diI);
        this.bSd = c4927e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vd */
    public final C7503a mo54621vd(int i) {
        C7503a c7503a;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(73623);
        Cursor query;
        try {
            query = this.bSd.query("ExptItem", null, "exptId=?", new String[]{String.valueOf(i)}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c7503a = new C7503a();
                        try {
                            c7503a.mo8995d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.ExptStorage", "get expt error [%s]", e.toString());
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.m2505o(73623);
                                return c7503a;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.m2505o(73623);
                                throw th;
                            }
                        }
                        AppMethodBeat.m2505o(73623);
                        return c7503a;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c7503a = null;
                    C4990ab.m7413e("MicroMsg.ExptStorage", "get expt error [%s]", e.toString());
                    if (query != null) {
                    }
                    AppMethodBeat.m2505o(73623);
                    return c7503a;
                }
            }
            c7503a = null;
            if (query != null) {
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            c7503a = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(73623);
            throw th;
        }
        AppMethodBeat.m2505o(73623);
        return c7503a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<C7503a> brw() {
        List<C7503a> linkedList;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(73624);
        Cursor rawQuery;
        try {
            rawQuery = this.bSd.rawQuery("select rowid,exptId,groupId,exptSeq from ExptItem order by exptId", null);
            if (rawQuery != null) {
                try {
                    linkedList = new LinkedList();
                    while (rawQuery.moveToNext()) {
                        try {
                            C7503a c7503a = new C7503a();
                            c7503a.mo8995d(rawQuery);
                            linkedList.add(c7503a);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.ExptStorage", "get all expt without content error [%s]", e.toString());
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                AppMethodBeat.m2505o(73624);
                                return linkedList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (rawQuery != null) {
                                }
                                AppMethodBeat.m2505o(73624);
                                throw th;
                            }
                        }
                    }
                    C4990ab.m7411d("MicroMsg.ExptStorage", "get all expt without content [%d]", Integer.valueOf(linkedList.size()));
                } catch (Exception e3) {
                    e = e3;
                    linkedList = null;
                    C4990ab.m7413e("MicroMsg.ExptStorage", "get all expt without content error [%s]", e.toString());
                    if (rawQuery != null) {
                    }
                    AppMethodBeat.m2505o(73624);
                    return linkedList;
                }
            }
            linkedList = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e4) {
            e = e4;
            rawQuery = null;
            linkedList = null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(73624);
            throw th;
        }
        AppMethodBeat.m2505o(73624);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<Integer> brx() {
        ArrayList<Integer> arrayList;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(73625);
        Cursor rawQuery;
        try {
            rawQuery = this.bSd.rawQuery("select exptId from ExptItem", null);
            if (rawQuery != null) {
                try {
                    arrayList = new ArrayList();
                    while (rawQuery.moveToNext()) {
                        try {
                            arrayList.add(Integer.valueOf(rawQuery.getInt(0)));
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.ExptStorage", "get all expt id error[%s]", e.toString());
                                if (rawQuery != null) {
                                }
                                AppMethodBeat.m2505o(73625);
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                AppMethodBeat.m2505o(73625);
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    arrayList = null;
                    C4990ab.m7413e("MicroMsg.ExptStorage", "get all expt id error[%s]", e.toString());
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.m2505o(73625);
                    return arrayList;
                }
            }
            arrayList = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e4) {
            e = e4;
            rawQuery = null;
            arrayList = null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
            }
            AppMethodBeat.m2505o(73625);
            throw th;
        }
        AppMethodBeat.m2505o(73625);
        return arrayList;
    }

    /* renamed from: ve */
    private boolean m55836ve(int i) {
        int delete;
        AppMethodBeat.m2504i(73626);
        try {
            delete = this.bSd.delete("ExptItem", "exptId=?", new String[]{String.valueOf(i)});
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ExptStorage", "delete expt by id [%s]", e.toString());
            delete = 0;
        }
        if (delete > 0) {
            AppMethodBeat.m2505o(73626);
            return true;
        }
        AppMethodBeat.m2505o(73626);
        return false;
    }

    /* renamed from: a */
    private boolean m55835a(C7503a c7503a) {
        AppMethodBeat.m2504i(73627);
        if (c7503a == null) {
            AppMethodBeat.m2505o(73627);
            return false;
        }
        boolean a;
        try {
            a = super.mo10099a(c7503a);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ExptStorage", "replace expt error [%s]", e.toString());
            a = false;
        }
        C4990ab.m7411d("MicroMsg.ExptStorage", "replace expt ret[%b] item[%s]", Boolean.valueOf(a), c7503a.toString());
        AppMethodBeat.m2505o(73627);
        return a;
    }

    /* renamed from: bH */
    public final List<C7503a> mo54617bH(List<C7503a> list) {
        long j = -1;
        AppMethodBeat.m2504i(73628);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(73628);
            return null;
        }
        C7480h c7480h;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            j = c7480h2.mo15639iV(-1);
            c7480h = c7480h2;
        } else {
            c7480h = null;
        }
        try {
            LinkedList linkedList = new LinkedList();
            for (C7503a c7503a : list) {
                if (m55835a(c7503a)) {
                    linkedList.add(c7503a);
                }
            }
            if (c7480h != null) {
                c7480h.mo15640mB(j);
            }
            AppMethodBeat.m2505o(73628);
            return linkedList;
        } catch (Throwable th) {
            if (c7480h != null) {
                c7480h.mo15640mB(j);
            }
            AppMethodBeat.m2505o(73628);
        }
    }

    /* renamed from: bB */
    public final int mo54616bB(List<Integer> list) {
        C7480h c7480h;
        long j = -1;
        int i = 0;
        AppMethodBeat.m2504i(73629);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(73629);
        } else {
            if (this.bSd instanceof C7480h) {
                C7480h c7480h2 = (C7480h) this.bSd;
                j = c7480h2.mo15639iV(-1);
                c7480h = c7480h2;
            } else {
                c7480h = null;
            }
            try {
                for (Integer intValue : list) {
                    int i2;
                    if (m55836ve(intValue.intValue())) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
            } finally {
                if (c7480h != null) {
                    c7480h.mo15640mB(j);
                }
                AppMethodBeat.m2505o(73629);
            }
        }
        return i;
    }

    public final int brt() {
        int i = 0;
        AppMethodBeat.m2504i(73630);
        try {
            i = this.bSd.delete("ExptItem", null, null);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ExptStorage", "delete all expt error[%s]", e.toString());
        }
        AppMethodBeat.m2505o(73630);
        return i;
    }
}

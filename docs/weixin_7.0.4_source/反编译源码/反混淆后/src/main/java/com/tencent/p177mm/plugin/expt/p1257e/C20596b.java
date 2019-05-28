package com.tencent.p177mm.plugin.expt.p1257e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.e.b */
public final class C20596b extends C7563j<C27891a> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{C7563j.m13217a(C27891a.ccO, "ExptKeyMapId")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(73614);
        AppMethodBeat.m2505o(73614);
    }

    public C20596b(C4927e c4927e) {
        super(c4927e, C27891a.ccO, "ExptKeyMapId", diI);
        this.bSd = c4927e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: KX */
    public final int mo35861KX(String str) {
        int i;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(73608);
        Cursor query;
        try {
            query = this.bSd.query("ExptKeyMapId", new String[]{"exptId"}, "exptKey=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        i = query.getInt(0);
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(73608);
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", str, e.toString());
                        if (query != null) {
                            query.close();
                        }
                        i = -1;
                        AppMethodBeat.m2505o(73608);
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(73608);
                        throw th;
                    }
                }
            }
            i = -1;
            if (query != null) {
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(73608);
            throw th;
        }
        AppMethodBeat.m2505o(73608);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Lc */
    public final C27891a mo35862Lc(String str) {
        C27891a c27891a;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(73609);
        Cursor query;
        try {
            query = this.bSd.query("ExptKeyMapId", null, "exptKey=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c27891a = new C27891a();
                        try {
                            c27891a.mo8995d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", str, e.toString());
                                if (query != null) {
                                }
                                AppMethodBeat.m2505o(73609);
                                return c27891a;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.m2505o(73609);
                                throw th;
                            }
                        }
                        AppMethodBeat.m2505o(73609);
                        return c27891a;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c27891a = null;
                    C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", str, e.toString());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(73609);
                    return c27891a;
                }
            }
            c27891a = null;
            if (query != null) {
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            c27891a = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(73609);
            throw th;
        }
        AppMethodBeat.m2505o(73609);
        return c27891a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: bC */
    public final int mo35863bC(List<C27891a> list) {
        C7480h c7480h;
        Exception e;
        long j = -1;
        AppMethodBeat.m2504i(73610);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(73610);
            return 0;
        }
        int i;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            j = c7480h2.mo15639iV(-1);
            c7480h = c7480h2;
        } else {
            c7480h = null;
        }
        try {
            i = 0;
            for (C27891a a : list) {
                try {
                    int i2;
                    if (mo16759a((C4925c) a, false)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", e.toString());
                        if (c7480h != null) {
                            c7480h.mo15640mB(j);
                        }
                        C4990ab.m7417i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
                        AppMethodBeat.m2505o(73610);
                        return i;
                    } catch (Throwable th) {
                        if (c7480h != null) {
                            c7480h.mo15640mB(j);
                        }
                        AppMethodBeat.m2505o(73610);
                    }
                }
            }
            if (c7480h != null) {
                c7480h.mo15640mB(j);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", e.toString());
            if (c7480h != null) {
            }
            C4990ab.m7417i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
            AppMethodBeat.m2505o(73610);
            return i;
        }
        C4990ab.m7417i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
        AppMethodBeat.m2505o(73610);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: bD */
    public final int mo35864bD(List<C27891a> list) {
        C7480h c7480h;
        Exception e;
        long j = -1;
        AppMethodBeat.m2504i(73611);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(73611);
            return 0;
        }
        int i;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            j = c7480h2.mo15639iV(-1);
            c7480h = c7480h2;
        } else {
            c7480h = null;
        }
        try {
            i = 0;
            for (C27891a c27891a : list) {
                try {
                    int i2;
                    if (mo16758a(c27891a.xDa, (C4925c) c27891a, false)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", e.toString());
                        if (c7480h != null) {
                            c7480h.mo15640mB(j);
                        }
                        C4990ab.m7417i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
                        AppMethodBeat.m2505o(73611);
                        return i;
                    } catch (Throwable th) {
                        if (c7480h != null) {
                            c7480h.mo15640mB(j);
                        }
                        AppMethodBeat.m2505o(73611);
                    }
                }
            }
            if (c7480h != null) {
                c7480h.mo15640mB(j);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", e.toString());
            if (c7480h != null) {
            }
            C4990ab.m7417i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
            AppMethodBeat.m2505o(73611);
            return i;
        }
        C4990ab.m7417i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
        AppMethodBeat.m2505o(73611);
        return i;
    }

    /* renamed from: bE */
    public final int mo35865bE(List<Integer> list) {
        AppMethodBeat.m2504i(73612);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(73612);
            return 0;
        }
        C7480h c7480h;
        int i = 0;
        long j = -1;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            j = c7480h2.mo15639iV(-1);
            c7480h = c7480h2;
        } else {
            c7480h = null;
        }
        try {
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                if (this.bSd.delete("ExptKeyMapId", "exptId=?", new String[]{String.valueOf(intValue2)}) > 0) {
                    intValue2 = i + 1;
                } else {
                    intValue2 = i;
                }
                i = intValue2;
            }
            if (c7480h != null) {
                c7480h.mo15640mB(j);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", e.toString(), Integer.valueOf(0));
            if (c7480h != null) {
                c7480h.mo15640mB(j);
            }
        } catch (Throwable th) {
            if (c7480h != null) {
                c7480h.mo15640mB(j);
            }
            AppMethodBeat.m2505o(73612);
        }
        C4990ab.m7417i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", Integer.valueOf(list.size()), Integer.valueOf(i));
        AppMethodBeat.m2505o(73612);
        return i;
    }

    public final int brt() {
        int i = 0;
        AppMethodBeat.m2504i(73613);
        try {
            i = this.bSd.delete("ExptKeyMapId", null, null);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ExptKeyMapIdStorage", "delete all expt error[%s]", e.toString());
        }
        AppMethodBeat.m2505o(73613);
        return i;
    }
}

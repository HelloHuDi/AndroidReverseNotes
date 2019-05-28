package com.tencent.mm.plugin.expt.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.expt.d.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends j<a> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{j.a(a.ccO, "ExptItem")};
    private e bSd;

    static {
        AppMethodBeat.i(73631);
        AppMethodBeat.o(73631);
    }

    public d(e eVar) {
        super(eVar, a.ccO, "ExptItem", diI);
        this.bSd = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a vd(int i) {
        a aVar;
        Exception e;
        Throwable th;
        AppMethodBeat.i(73623);
        Cursor query;
        try {
            query = this.bSd.query("ExptItem", null, "exptId=?", new String[]{String.valueOf(i)}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar = new a();
                        try {
                            aVar.d(query);
                            if (query != null) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.e("MicroMsg.ExptStorage", "get expt error [%s]", e.toString());
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.o(73623);
                                return aVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.o(73623);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(73623);
                        return aVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    aVar = null;
                    ab.e("MicroMsg.ExptStorage", "get expt error [%s]", e.toString());
                    if (query != null) {
                    }
                    AppMethodBeat.o(73623);
                    return aVar;
                }
            }
            aVar = null;
            if (query != null) {
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            aVar = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(73623);
            throw th;
        }
        AppMethodBeat.o(73623);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<a> brw() {
        List<a> linkedList;
        Exception e;
        Throwable th;
        AppMethodBeat.i(73624);
        Cursor rawQuery;
        try {
            rawQuery = this.bSd.rawQuery("select rowid,exptId,groupId,exptSeq from ExptItem order by exptId", null);
            if (rawQuery != null) {
                try {
                    linkedList = new LinkedList();
                    while (rawQuery.moveToNext()) {
                        try {
                            a aVar = new a();
                            aVar.d(rawQuery);
                            linkedList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.e("MicroMsg.ExptStorage", "get all expt without content error [%s]", e.toString());
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                AppMethodBeat.o(73624);
                                return linkedList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (rawQuery != null) {
                                }
                                AppMethodBeat.o(73624);
                                throw th;
                            }
                        }
                    }
                    ab.d("MicroMsg.ExptStorage", "get all expt without content [%d]", Integer.valueOf(linkedList.size()));
                } catch (Exception e3) {
                    e = e3;
                    linkedList = null;
                    ab.e("MicroMsg.ExptStorage", "get all expt without content error [%s]", e.toString());
                    if (rawQuery != null) {
                    }
                    AppMethodBeat.o(73624);
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
            AppMethodBeat.o(73624);
            throw th;
        }
        AppMethodBeat.o(73624);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<Integer> brx() {
        ArrayList<Integer> arrayList;
        Exception e;
        Throwable th;
        AppMethodBeat.i(73625);
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
                                ab.e("MicroMsg.ExptStorage", "get all expt id error[%s]", e.toString());
                                if (rawQuery != null) {
                                }
                                AppMethodBeat.o(73625);
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                AppMethodBeat.o(73625);
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    arrayList = null;
                    ab.e("MicroMsg.ExptStorage", "get all expt id error[%s]", e.toString());
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    AppMethodBeat.o(73625);
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
            AppMethodBeat.o(73625);
            throw th;
        }
        AppMethodBeat.o(73625);
        return arrayList;
    }

    private boolean ve(int i) {
        int delete;
        AppMethodBeat.i(73626);
        try {
            delete = this.bSd.delete("ExptItem", "exptId=?", new String[]{String.valueOf(i)});
        } catch (Exception e) {
            ab.e("MicroMsg.ExptStorage", "delete expt by id [%s]", e.toString());
            delete = 0;
        }
        if (delete > 0) {
            AppMethodBeat.o(73626);
            return true;
        }
        AppMethodBeat.o(73626);
        return false;
    }

    private boolean a(a aVar) {
        AppMethodBeat.i(73627);
        if (aVar == null) {
            AppMethodBeat.o(73627);
            return false;
        }
        boolean a;
        try {
            a = super.a(aVar);
        } catch (Exception e) {
            ab.e("MicroMsg.ExptStorage", "replace expt error [%s]", e.toString());
            a = false;
        }
        ab.d("MicroMsg.ExptStorage", "replace expt ret[%b] item[%s]", Boolean.valueOf(a), aVar.toString());
        AppMethodBeat.o(73627);
        return a;
    }

    public final List<a> bH(List<a> list) {
        long j = -1;
        AppMethodBeat.i(73628);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(73628);
            return null;
        }
        h hVar;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            j = hVar2.iV(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            LinkedList linkedList = new LinkedList();
            for (a aVar : list) {
                if (a(aVar)) {
                    linkedList.add(aVar);
                }
            }
            if (hVar != null) {
                hVar.mB(j);
            }
            AppMethodBeat.o(73628);
            return linkedList;
        } catch (Throwable th) {
            if (hVar != null) {
                hVar.mB(j);
            }
            AppMethodBeat.o(73628);
        }
    }

    public final int bB(List<Integer> list) {
        h hVar;
        long j = -1;
        int i = 0;
        AppMethodBeat.i(73629);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(73629);
        } else {
            if (this.bSd instanceof h) {
                h hVar2 = (h) this.bSd;
                j = hVar2.iV(-1);
                hVar = hVar2;
            } else {
                hVar = null;
            }
            try {
                for (Integer intValue : list) {
                    int i2;
                    if (ve(intValue.intValue())) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
            } finally {
                if (hVar != null) {
                    hVar.mB(j);
                }
                AppMethodBeat.o(73629);
            }
        }
        return i;
    }

    public final int brt() {
        int i = 0;
        AppMethodBeat.i(73630);
        try {
            i = this.bSd.delete("ExptItem", null, null);
        } catch (Exception e) {
            ab.e("MicroMsg.ExptStorage", "delete all expt error[%s]", e.toString());
        }
        AppMethodBeat.o(73630);
        return i;
    }
}

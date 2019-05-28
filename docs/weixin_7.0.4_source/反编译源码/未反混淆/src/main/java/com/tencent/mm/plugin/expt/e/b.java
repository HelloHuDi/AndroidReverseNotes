package com.tencent.mm.plugin.expt.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class b extends j<a> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{j.a(a.ccO, "ExptKeyMapId")};
    private e bSd;

    static {
        AppMethodBeat.i(73614);
        AppMethodBeat.o(73614);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "ExptKeyMapId", diI);
        this.bSd = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int KX(String str) {
        int i;
        Exception e;
        Throwable th;
        AppMethodBeat.i(73608);
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
                        AppMethodBeat.o(73608);
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", str, e.toString());
                        if (query != null) {
                            query.close();
                        }
                        i = -1;
                        AppMethodBeat.o(73608);
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(73608);
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
            AppMethodBeat.o(73608);
            throw th;
        }
        AppMethodBeat.o(73608);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a Lc(String str) {
        a aVar;
        Exception e;
        Throwable th;
        AppMethodBeat.i(73609);
        Cursor query;
        try {
            query = this.bSd.query("ExptKeyMapId", null, "exptKey=?", new String[]{str}, null, null, null);
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
                                ab.e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", str, e.toString());
                                if (query != null) {
                                }
                                AppMethodBeat.o(73609);
                                return aVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.o(73609);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(73609);
                        return aVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    aVar = null;
                    ab.e("MicroMsg.ExptKeyMapIdStorage", "get expt id [%s] [%s]", str, e.toString());
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(73609);
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
            AppMethodBeat.o(73609);
            throw th;
        }
        AppMethodBeat.o(73609);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int bC(List<a> list) {
        h hVar;
        Exception e;
        long j = -1;
        AppMethodBeat.i(73610);
        if (list.size() <= 0) {
            AppMethodBeat.o(73610);
            return 0;
        }
        int i;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            j = hVar2.iV(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            i = 0;
            for (a a : list) {
                try {
                    int i2;
                    if (a((c) a, false)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", e.toString());
                        if (hVar != null) {
                            hVar.mB(j);
                        }
                        ab.i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
                        AppMethodBeat.o(73610);
                        return i;
                    } catch (Throwable th) {
                        if (hVar != null) {
                            hVar.mB(j);
                        }
                        AppMethodBeat.o(73610);
                    }
                }
            }
            if (hVar != null) {
                hVar.mB(j);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            ab.e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", e.toString());
            if (hVar != null) {
            }
            ab.i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
            AppMethodBeat.o(73610);
            return i;
        }
        ab.i("MicroMsg.ExptKeyMapIdStorage", "insert expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
        AppMethodBeat.o(73610);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int bD(List<a> list) {
        h hVar;
        Exception e;
        long j = -1;
        AppMethodBeat.i(73611);
        if (list.size() <= 0) {
            AppMethodBeat.o(73611);
            return 0;
        }
        int i;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            j = hVar2.iV(-1);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            i = 0;
            for (a aVar : list) {
                try {
                    int i2;
                    if (a(aVar.xDa, (c) aVar, false)) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", e.toString());
                        if (hVar != null) {
                            hVar.mB(j);
                        }
                        ab.i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
                        AppMethodBeat.o(73611);
                        return i;
                    } catch (Throwable th) {
                        if (hVar != null) {
                            hVar.mB(j);
                        }
                        AppMethodBeat.o(73611);
                    }
                }
            }
            if (hVar != null) {
                hVar.mB(j);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            ab.e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", e.toString());
            if (hVar != null) {
            }
            ab.i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
            AppMethodBeat.o(73611);
            return i;
        }
        ab.i("MicroMsg.ExptKeyMapIdStorage", "update expt keymapid map size[%d] ret[%s]", Integer.valueOf(list.size()), Integer.valueOf(i));
        AppMethodBeat.o(73611);
        return i;
    }

    public final int bE(List<Integer> list) {
        AppMethodBeat.i(73612);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(73612);
            return 0;
        }
        h hVar;
        int i = 0;
        long j = -1;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            j = hVar2.iV(-1);
            hVar = hVar2;
        } else {
            hVar = null;
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
            if (hVar != null) {
                hVar.mB(j);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", e.toString(), Integer.valueOf(0));
            if (hVar != null) {
                hVar.mB(j);
            }
        } catch (Throwable th) {
            if (hVar != null) {
                hVar.mB(j);
            }
            AppMethodBeat.o(73612);
        }
        ab.i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", Integer.valueOf(list.size()), Integer.valueOf(i));
        AppMethodBeat.o(73612);
        return i;
    }

    public final int brt() {
        int i = 0;
        AppMethodBeat.i(73613);
        try {
            i = this.bSd.delete("ExptKeyMapId", null, null);
        } catch (Exception e) {
            ab.e("MicroMsg.ExptKeyMapIdStorage", "delete all expt error[%s]", e.toString());
        }
        AppMethodBeat.o(73613);
        return i;
    }
}

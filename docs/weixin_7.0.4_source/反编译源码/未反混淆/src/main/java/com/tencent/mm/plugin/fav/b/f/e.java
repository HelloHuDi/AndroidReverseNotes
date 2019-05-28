package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends j<com.tencent.mm.plugin.fav.a.j> implements aa {
    private com.tencent.mm.sdk.e.e bSd;

    public final /* synthetic */ boolean a(com.tencent.mm.plugin.fav.a.j jVar) {
        AppMethodBeat.i(5467);
        boolean b = super.b((c) jVar);
        AppMethodBeat.o(5467);
        return b;
    }

    public final /* synthetic */ boolean a(com.tencent.mm.plugin.fav.a.j jVar, String[] strArr) {
        AppMethodBeat.i(5466);
        boolean c = super.c(jVar, strArr);
        AppMethodBeat.o(5466);
        return c;
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, com.tencent.mm.plugin.fav.a.j.ccO, "FavSearchInfo", null);
        this.bSd = eVar;
    }

    public final ArrayList<Long> b(List<String> list, List<String> list2, List<Integer> list3) {
        Iterator it;
        String str;
        AppMethodBeat.i(5460);
        ArrayList<Long> arrayList = new ArrayList();
        String str2 = "select localId from FavSearchInfo";
        String str3 = " 1=1 ";
        if (!(list == null || list.isEmpty())) {
            it = list.iterator();
            while (true) {
                str = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str + " and content like '%" + ((String) it.next()) + "%'";
            }
            str3 = str;
        }
        if (!(list2 == null || list2.isEmpty())) {
            it = list2.iterator();
            while (true) {
                str = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str + " and tagContent like '%" + ((String) it.next()) + "%'";
            }
            str3 = str;
        }
        str3 = str2 + " where " + str3;
        List bL = bL(list3);
        List bM = bM(list3);
        if (!(bo.ek(bL) && bo.ek(bM))) {
            int i;
            int intValue;
            str = str3 + " and (";
            if (!bo.ek(bL)) {
                str = str + "type = " + bL.get(0);
                i = 1;
                while (i < bL.size()) {
                    intValue = ((Integer) bL.get(i)).intValue();
                    i++;
                    str = str + " or type = " + intValue;
                }
            }
            if (!bo.ek(bM)) {
                if (!bo.ek(bL)) {
                    str = str + " or ";
                }
                str = str + "subtype & " + com.tencent.mm.plugin.fav.a.j.vx(((Integer) bM.get(0)).intValue()) + " != 0";
                i = 1;
                while (i < bM.size()) {
                    intValue = ((Integer) bM.get(i)).intValue();
                    i++;
                    str = str + " or subtype & " + com.tencent.mm.plugin.fav.a.j.vx(intValue) + " != 0";
                }
            }
            str3 = str + ")";
        }
        ab.d("MicroMsg.FavSearchStorage", "search id sql {%s}", str3 + " order by time desc");
        Cursor a = this.bSd.a(str3, null, 2);
        if (a == null) {
            AppMethodBeat.o(5460);
            return arrayList;
        }
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        AppMethodBeat.o(5460);
        return arrayList;
    }

    private static List<Integer> bL(List<Integer> list) {
        AppMethodBeat.i(5461);
        if (bo.ek(list)) {
            AppMethodBeat.o(5461);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : list) {
            switch (intValue.intValue()) {
                case 1:
                    arrayList.add(Integer.valueOf(1));
                    break;
                case 3:
                    arrayList.add(Integer.valueOf(3));
                    break;
                case 4:
                    arrayList.add(Integer.valueOf(4));
                    break;
                case 5:
                    arrayList.add(Integer.valueOf(5));
                    break;
                case 6:
                    arrayList.add(Integer.valueOf(6));
                    break;
                case 7:
                    arrayList.add(Integer.valueOf(7));
                    break;
                case 8:
                    arrayList.add(Integer.valueOf(8));
                    break;
                case 9:
                    arrayList.add(Integer.valueOf(9));
                    break;
                case 10:
                    arrayList.add(Integer.valueOf(10));
                    break;
                case 11:
                    arrayList.add(Integer.valueOf(11));
                    break;
                case 12:
                    arrayList.add(Integer.valueOf(12));
                    break;
                case 13:
                    arrayList.add(Integer.valueOf(13));
                    break;
                case 14:
                    arrayList.add(Integer.valueOf(15));
                    break;
                case 15:
                    arrayList.add(Integer.valueOf(16));
                    break;
                case 16:
                    arrayList.add(Integer.valueOf(17));
                    break;
                case 17:
                    arrayList.add(Integer.valueOf(14));
                    break;
                case 18:
                    arrayList.add(Integer.valueOf(18));
                    break;
                case 19:
                    arrayList.add(Integer.valueOf(19));
                    break;
                case 21:
                    arrayList.add(Integer.valueOf(2));
                    arrayList.add(Integer.valueOf(4));
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(5461);
        return arrayList;
    }

    private static List<Integer> bM(List<Integer> list) {
        AppMethodBeat.i(5462);
        if (bo.ek(list)) {
            AppMethodBeat.o(5462);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : list) {
            switch (intValue.intValue()) {
                case 1:
                    arrayList.add(Integer.valueOf(1));
                    break;
                case 3:
                    arrayList.add(Integer.valueOf(3));
                    break;
                case 4:
                    arrayList.add(Integer.valueOf(4));
                    break;
                case 5:
                    arrayList.add(Integer.valueOf(5));
                    break;
                case 6:
                    arrayList.add(Integer.valueOf(6));
                    break;
                case 7:
                    arrayList.add(Integer.valueOf(7));
                    break;
                case 8:
                    arrayList.add(Integer.valueOf(8));
                    break;
                case 9:
                    arrayList.add(Integer.valueOf(9));
                    break;
                case 10:
                    arrayList.add(Integer.valueOf(10));
                    break;
                case 11:
                    arrayList.add(Integer.valueOf(11));
                    break;
                case 12:
                    arrayList.add(Integer.valueOf(12));
                    break;
                case 13:
                    arrayList.add(Integer.valueOf(13));
                    break;
                case 14:
                    arrayList.add(Integer.valueOf(14));
                    break;
                case 15:
                    arrayList.add(Integer.valueOf(15));
                    break;
                case 16:
                    arrayList.add(Integer.valueOf(16));
                    break;
                case 17:
                    arrayList.add(Integer.valueOf(17));
                    break;
                case 19:
                    arrayList.add(Integer.valueOf(19));
                    break;
                case 21:
                    arrayList.add(Integer.valueOf(2));
                    arrayList.add(Integer.valueOf(4));
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(5462);
        return arrayList;
    }

    public final boolean LT(String str) {
        AppMethodBeat.i(5463);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(5463);
            return false;
        }
        int i;
        ab.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", "select count(localId) from FavSearchInfo where tagContent like '%" + str + "%'");
        Cursor a = this.bSd.a(r2, null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
        }
        if (a != null) {
            a.close();
        }
        if (i > 0) {
            AppMethodBeat.o(5463);
            return true;
        }
        AppMethodBeat.o(5463);
        return false;
    }

    public final void iG(long j) {
        AppMethodBeat.i(5464);
        this.bSd.hY("FavSearchInfo", "delete from FavSearchInfo where localId = ".concat(String.valueOf(j)));
        AppMethodBeat.o(5464);
    }

    public final com.tencent.mm.plugin.fav.a.j iH(long j) {
        com.tencent.mm.plugin.fav.a.j jVar = null;
        AppMethodBeat.i(5465);
        Cursor a = this.bSd.a("select * from FavSearchInfo where localId = ".concat(String.valueOf(j)), null, 2);
        if (a == null) {
            AppMethodBeat.o(5465);
        } else {
            if (a.moveToFirst()) {
                jVar = new com.tencent.mm.plugin.fav.a.j();
                jVar.d(a);
            }
            a.close();
            AppMethodBeat.o(5465);
        }
        return jVar;
    }
}

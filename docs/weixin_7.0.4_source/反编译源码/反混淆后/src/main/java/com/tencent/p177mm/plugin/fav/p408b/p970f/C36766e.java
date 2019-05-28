package com.tencent.p177mm.plugin.fav.p408b.p970f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fav.p407a.C31355j;
import com.tencent.p177mm.plugin.fav.p407a.C34123aa;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.b.f.e */
public final class C36766e extends C7563j<C31355j> implements C34123aa {
    private C4927e bSd;

    /* renamed from: a */
    public final /* synthetic */ boolean mo54687a(C31355j c31355j) {
        AppMethodBeat.m2504i(5467);
        boolean b = super.mo10101b((C4925c) c31355j);
        AppMethodBeat.m2505o(5467);
        return b;
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo54688a(C31355j c31355j, String[] strArr) {
        AppMethodBeat.m2504i(5466);
        boolean c = super.mo10103c(c31355j, strArr);
        AppMethodBeat.m2505o(5466);
        return c;
    }

    public C36766e(C4927e c4927e) {
        super(c4927e, C31355j.ccO, "FavSearchInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: b */
    public final ArrayList<Long> mo54689b(List<String> list, List<String> list2, List<Integer> list3) {
        Iterator it;
        String str;
        AppMethodBeat.m2504i(5460);
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
        List bL = C36766e.m61001bL(list3);
        List bM = C36766e.m61002bM(list3);
        if (!(C5046bo.m7548ek(bL) && C5046bo.m7548ek(bM))) {
            int i;
            int intValue;
            str = str3 + " and (";
            if (!C5046bo.m7548ek(bL)) {
                str = str + "type = " + bL.get(0);
                i = 1;
                while (i < bL.size()) {
                    intValue = ((Integer) bL.get(i)).intValue();
                    i++;
                    str = str + " or type = " + intValue;
                }
            }
            if (!C5046bo.m7548ek(bM)) {
                if (!C5046bo.m7548ek(bL)) {
                    str = str + " or ";
                }
                str = str + "subtype & " + C31355j.m50656vx(((Integer) bM.get(0)).intValue()) + " != 0";
                i = 1;
                while (i < bM.size()) {
                    intValue = ((Integer) bM.get(i)).intValue();
                    i++;
                    str = str + " or subtype & " + C31355j.m50656vx(intValue) + " != 0";
                }
            }
            str3 = str + ")";
        }
        C4990ab.m7411d("MicroMsg.FavSearchStorage", "search id sql {%s}", str3 + " order by time desc");
        Cursor a = this.bSd.mo10104a(str3, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5460);
            return arrayList;
        }
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        AppMethodBeat.m2505o(5460);
        return arrayList;
    }

    /* renamed from: bL */
    private static List<Integer> m61001bL(List<Integer> list) {
        AppMethodBeat.m2504i(5461);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(5461);
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
        AppMethodBeat.m2505o(5461);
        return arrayList;
    }

    /* renamed from: bM */
    private static List<Integer> m61002bM(List<Integer> list) {
        AppMethodBeat.m2504i(5462);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(5462);
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
        AppMethodBeat.m2505o(5462);
        return arrayList;
    }

    /* renamed from: LT */
    public final boolean mo54686LT(String str) {
        AppMethodBeat.m2504i(5463);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(5463);
            return false;
        }
        int i;
        C4990ab.m7411d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", "select count(localId) from FavSearchInfo where tagContent like '%" + str + "%'");
        Cursor a = this.bSd.mo10104a(r2, null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
        }
        if (a != null) {
            a.close();
        }
        if (i > 0) {
            AppMethodBeat.m2505o(5463);
            return true;
        }
        AppMethodBeat.m2505o(5463);
        return false;
    }

    /* renamed from: iG */
    public final void mo54690iG(long j) {
        AppMethodBeat.m2504i(5464);
        this.bSd.mo10108hY("FavSearchInfo", "delete from FavSearchInfo where localId = ".concat(String.valueOf(j)));
        AppMethodBeat.m2505o(5464);
    }

    /* renamed from: iH */
    public final C31355j mo54691iH(long j) {
        C31355j c31355j = null;
        AppMethodBeat.m2504i(5465);
        Cursor a = this.bSd.mo10104a("select * from FavSearchInfo where localId = ".concat(String.valueOf(j)), null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5465);
        } else {
            if (a.moveToFirst()) {
                c31355j = new C31355j();
                c31355j.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(5465);
        }
        return c31355j;
    }
}

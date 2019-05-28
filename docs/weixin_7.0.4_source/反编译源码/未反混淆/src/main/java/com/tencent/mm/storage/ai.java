package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ai extends j<af> implements com.tencent.mm.cd.g.a {
    public static final String[] fnj = new String[]{j.a(af.ccO, "ContactLabel")};
    private e bSd;
    private HashMap<String, int[]> xXd;
    public HashMap<Integer, ArrayList<String>> xXe;

    public enum a {
        EQUAL,
        NOEQUAL,
        NOEXISTS;

        static {
            AppMethodBeat.o(29029);
        }
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        AppMethodBeat.i(29058);
        boolean b = b(true, (af) cVar, strArr);
        AppMethodBeat.o(29058);
        return b;
    }

    static {
        AppMethodBeat.i(29061);
        AppMethodBeat.o(29061);
    }

    public ai(e eVar) {
        this(eVar, af.ccO, "ContactLabel");
    }

    private ai(e eVar, com.tencent.mm.sdk.e.c.a aVar, String str) {
        super(eVar, aVar, str, null);
        AppMethodBeat.i(29030);
        this.xXd = null;
        this.xXe = null;
        this.bSd = eVar;
        eVar.hY("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
        AppMethodBeat.o(29030);
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final ArrayList<String> dsm() {
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(29031);
        long anU = bo.anU();
        Cursor a = this.bSd.a("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ", 2);
        if (a == null) {
            AppMethodBeat.o(29031);
        } else {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            ab.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(arrayList.size()), bo.dpG());
            AppMethodBeat.o(29031);
        }
        return arrayList;
    }

    public final ArrayList<af> dsn() {
        ArrayList<af> arrayList = null;
        AppMethodBeat.i(29032);
        long anU = bo.anU();
        Cursor a = this.bSd.a("select * from ContactLabel order by createTime ASC ", null, 2);
        if (a == null) {
            AppMethodBeat.o(29032);
        } else {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                af afVar = new af();
                afVar.d(a);
                arrayList.add(afVar);
            }
            a.close();
            ab.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(arrayList.size()), bo.dpG());
            AppMethodBeat.o(29032);
        }
        return arrayList;
    }

    public final void ahw() {
        AppMethodBeat.i(29033);
        ab.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", bo.dpG());
        this.xXd = null;
        this.xXe = null;
        AppMethodBeat.o(29033);
    }

    public final void dso() {
        AppMethodBeat.i(29034);
        if (this.xXd == null || this.xXe == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            long anU = bo.anU();
            Cursor a = this.bSd.a("select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.n.a.NS() + " !=0 ) and ( contactLabelIds != '') ;", null, 2);
            if (a == null) {
                this.xXd = hashMap;
                this.xXe = hashMap2;
                AppMethodBeat.o(29034);
                return;
            }
            while (a.moveToNext()) {
                String string = a.getString(0);
                if (!bo.isNullOrNil(string)) {
                    String[] split = bo.nullAsNil(a.getString(1)).split(",");
                    if (split != null && split.length > 0) {
                        int[] iArr = new int[split.length];
                        for (int i = 0; i < split.length; i++) {
                            iArr[i] = bo.getInt(split[i], -1);
                            if (hashMap2.containsKey(Integer.valueOf(iArr[i]))) {
                                ((ArrayList) hashMap2.get(Integer.valueOf(iArr[i]))).add(string);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(string);
                                hashMap2.put(Integer.valueOf(iArr[i]), arrayList);
                            }
                        }
                        hashMap.put(string, iArr);
                    }
                }
            }
            a.close();
            ab.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(hashMap.size()), Integer.valueOf(hashMap2.size()), bo.dpG());
            this.xXd = hashMap;
            this.xXe = hashMap2;
            AppMethodBeat.o(29034);
            return;
        }
        AppMethodBeat.o(29034);
    }

    public final ArrayList<String> aoD(String str) {
        int i = -1;
        AppMethodBeat.i(29035);
        long anU = bo.anU();
        int i2 = bo.getInt(str, -1);
        if (i2 == -1) {
            ab.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", str);
            AppMethodBeat.o(29035);
            return null;
        }
        dso();
        ArrayList<String> arrayList = (ArrayList) this.xXe.get(Integer.valueOf(i2));
        String str2 = "MicroMsg.Label.ContactLabelStorage";
        String str3 = "getUserNameListById time:%s id:%s count:%s stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(bo.gb(anU));
        objArr[1] = str;
        if (arrayList != null) {
            i = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bo.dpG();
        ab.i(str2, str3, objArr);
        AppMethodBeat.o(29035);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<String> w(String str, List<String> list) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(29036);
        ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ");
        Cursor a;
        try {
            a = this.bSd.a("select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"}, 2);
            try {
                int columnIndex = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        String string = a.getString(columnIndex);
                        if (list == null || list.size() <= 0 || !list.contains(string)) {
                            arrayList.add(string);
                        }
                    } while (a.moveToNext());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29036);
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(29036);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29036);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29036);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(29036);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<String> R(String[] strArr) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(29037);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(29037);
            return null;
        }
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < length; i++) {
            stringBuilder.append("'" + strArr[i] + "'");
            if (i < length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.bSd.a(stringBuilder.toString(), null, 2);
            try {
                length = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        arrayList.add(a.getString(length));
                    } while (a.moveToNext());
                    ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29037);
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(29037);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29037);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29037);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(29037);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<String> ai(ArrayList<String> arrayList) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(29038);
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(29038);
            return null;
        }
        int size = arrayList.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelName");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("\"" + ((String) arrayList.get(i)) + "\"");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.bSd.a(stringBuilder.toString(), null, 2);
            try {
                int columnIndex = a.getColumnIndex("labelID");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(a.getString(columnIndex));
                    } while (a.moveToNext());
                    ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] resut size:%d", Integer.valueOf(arrayList2.size()));
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29038);
                    return arrayList2;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(29038);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29038);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29038);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(29038);
            throw th;
        }
    }

    private boolean a(boolean z, af afVar) {
        AppMethodBeat.i(29039);
        boolean b = super.b((c) afVar);
        if (b && z) {
            anF(a("insert", afVar));
        }
        AppMethodBeat.o(29039);
        return b;
    }

    public final boolean pI(String str) {
        int delete;
        AppMethodBeat.i(29040);
        ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", String.valueOf(str));
        ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "labelID =? ");
        try {
            delete = this.bSd.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e) {
            ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", e.toString());
            delete = -1;
        }
        if (delete > 0) {
            AppMethodBeat.o(29040);
            return true;
        }
        AppMethodBeat.o(29040);
        return false;
    }

    private boolean a(boolean z, af afVar, String... strArr) {
        AppMethodBeat.i(29041);
        boolean a = super.a((c) afVar, strArr);
        if (a && z) {
            anF(a("delete", afVar));
            dsp();
        }
        ahw();
        AppMethodBeat.o(29041);
        return a;
    }

    public final boolean a(af afVar, String... strArr) {
        AppMethodBeat.i(29042);
        boolean a = a(true, afVar, strArr);
        AppMethodBeat.o(29042);
        return a;
    }

    public final boolean b(boolean z, af afVar, String... strArr) {
        AppMethodBeat.i(29043);
        boolean c = super.c(afVar, strArr);
        if (c && z) {
            anF(a("update", afVar));
        }
        ahw();
        AppMethodBeat.o(29043);
        return c;
    }

    public final boolean eq(List<af> list) {
        AppMethodBeat.i(29044);
        if (list.size() <= 0) {
            ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
            AppMethodBeat.o(29044);
        } else {
            long iV;
            h hVar = null;
            if (this.bSd instanceof h) {
                h hVar2 = (h) this.bSd;
                iV = hVar2.iV(Thread.currentThread().getId());
                ab.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(iV));
                hVar = hVar2;
            } else {
                iV = -1;
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                String c = c((af) list.get(i));
                if (!bo.isNullOrNil(c)) {
                    pI(c);
                }
            }
            if (hVar != null) {
                hVar.mB(iV);
                ab.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            ahw();
            AppMethodBeat.o(29044);
        }
        return false;
    }

    public final boolean er(List<af> list) {
        AppMethodBeat.i(29045);
        if (list.size() <= 0) {
            ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
            AppMethodBeat.o(29045);
        } else {
            long iV;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            h hVar = null;
            if (this.bSd instanceof h) {
                h hVar2 = (h) this.bSd;
                iV = hVar2.iV(Thread.currentThread().getId());
                ab.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(iV));
                hVar = hVar2;
            } else {
                iV = -1;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                af afVar = (af) list.get(i);
                if (afVar != null) {
                    switch (b(afVar)) {
                        case EQUAL:
                            break;
                        case NOEQUAL:
                            b(false, afVar, "labelID");
                            arrayList2.add(afVar);
                            break;
                        case NOEXISTS:
                            afVar.field_createTime = System.currentTimeMillis();
                            a(false, afVar);
                            arrayList.add(afVar);
                            break;
                        default:
                            ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                            break;
                    }
                }
            }
            if (hVar != null) {
                hVar.mB(iV);
                ab.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
            }
            if (arrayList.size() > 0) {
                anF(x("insert", arrayList));
            }
            if (arrayList2.size() > 0) {
                anF(x("update", arrayList2));
            }
            ahw();
            AppMethodBeat.o(29045);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String PD(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(29046);
        Cursor a;
        try {
            a = this.bSd.a("ContactLabel", new String[]{"labelName"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] label string is %s", String.valueOf(a.getString(a.getColumnIndex("labelName"))));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29046);
                        return r0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29046);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29046);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(29046);
            throw th;
        }
        AppMethodBeat.o(29046);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String PE(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(29047);
        Cursor a;
        try {
            a = this.bSd.a("ContactLabel", new String[]{"labelID"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] label id is %s", String.valueOf(a.getString(a.getColumnIndex("labelID"))));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29047);
                        return r0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29047);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29047);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(29047);
            throw th;
        }
        AppMethodBeat.o(29047);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final af aoE(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.i(29048);
        Cursor a;
        try {
            a = this.bSd.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        af afVar = new af();
                        afVar.d(a);
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29048);
                        return afVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29048);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                        }
                        AppMethodBeat.o(29048);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(29048);
            throw th;
        }
        AppMethodBeat.o(29048);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final af aoF(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.i(29049);
        Cursor a;
        try {
            a = this.bSd.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        af afVar = new af();
                        afVar.d(a);
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29049);
                        return afVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29049);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                        }
                        AppMethodBeat.o(29049);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(29049);
            throw th;
        }
        AppMethodBeat.o(29049);
        return null;
    }

    private a b(af afVar) {
        AppMethodBeat.i(29050);
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select * from ContactLabel where labelID=?", new String[]{afVar.field_labelID}, 2);
            a aVar;
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                aVar = a.NOEXISTS;
                AppMethodBeat.o(29050);
                return aVar;
            }
            if (afVar.field_labelName.equalsIgnoreCase(bo.bc(cursor.getString(cursor.getColumnIndex("labelName")), ""))) {
                aVar = a.EQUAL;
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(29050);
                return aVar;
            }
            aVar = a.NOEQUAL;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(29050);
            return aVar;
        } catch (Exception e) {
            ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(29050);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String c(af afVar) {
        Exception e;
        Throwable th;
        String str = null;
        AppMethodBeat.i(29051);
        Cursor a;
        try {
            a = this.bSd.a("select * from ContactLabel where labelName=? and isTemporary =?", new String[]{afVar.field_labelName, "1"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        boolean equalsIgnoreCase = afVar.field_labelName.equalsIgnoreCase(bo.bc(a.getString(a.getColumnIndex("labelName")), ""));
                        ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] itemname:%s dbname:%s", afVar.field_labelName, String.valueOf(r1));
                        if (equalsIgnoreCase) {
                            str = a.getString(a.getColumnIndex("labelID"));
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.o(29051);
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29051);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(29051);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(29051);
            throw th;
        }
        AppMethodBeat.o(29051);
        return str;
    }

    private static String a(String str, af afVar) {
        AppMethodBeat.i(29052);
        if (afVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(afVar);
            String x = x(str, arrayList);
            AppMethodBeat.o(29052);
            return x;
        }
        AppMethodBeat.o(29052);
        return null;
    }

    private static String x(String str, List<af> list) {
        AppMethodBeat.i(29053);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(29053);
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            af afVar = (af) list.get(i);
            if (afVar != null) {
                stringBuilder.append(afVar.field_labelID);
                if (i < size - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", stringBuilder.toString());
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(29053);
        return stringBuilder2;
    }

    private static void dsp() {
        AppMethodBeat.i(29054);
        ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        tv tvVar = new tv();
        tvVar.cPX.cvc = 3000;
        com.tencent.mm.sdk.b.a.xxA.m(tvVar);
        AppMethodBeat.o(29054);
    }

    public final boolean es(List<af> list) {
        AppMethodBeat.i(29055);
        if (list == null || list.size() <= 0) {
            ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            AppMethodBeat.o(29055);
            return false;
        }
        long iV;
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            ab.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", Long.valueOf(iV));
            hVar = hVar2;
        } else {
            iV = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(false, (af) list.get(i), "labelID");
        }
        if (hVar != null) {
            hVar.mB(iV);
            ab.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        anF(x("delete", list));
        dsp();
        AppMethodBeat.o(29055);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<af> et(List<af> list) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(29056);
        if (list.size() <= 0) {
            AppMethodBeat.o(29056);
            return null;
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" not in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("'" + ((af) list.get(i)).field_labelID + "'");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.bSd.a(stringBuilder.toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    ArrayList<af> arrayList = new ArrayList();
                    do {
                        af afVar = new af();
                        afVar.d(a);
                        arrayList.add(afVar);
                    } while (a.moveToNext());
                    ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29056);
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(29056);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(29056);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                    }
                    AppMethodBeat.o(29056);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(29056);
            throw th;
        }
    }
}

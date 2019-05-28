package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C26245tv;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.storage.ai */
public final class C40622ai extends C7563j<C46619af> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46619af.ccO, "ContactLabel")};
    private C4927e bSd;
    private HashMap<String, int[]> xXd;
    public HashMap<Integer, ArrayList<String>> xXe;

    /* renamed from: com.tencent.mm.storage.ai$a */
    public enum C40623a {
        EQUAL,
        NOEQUAL,
        NOEXISTS;

        static {
            AppMethodBeat.m2505o(29029);
        }
    }

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(29058);
        boolean b = mo64075b(true, (C46619af) c4925c, strArr);
        AppMethodBeat.m2505o(29058);
        return b;
    }

    static {
        AppMethodBeat.m2504i(29061);
        AppMethodBeat.m2505o(29061);
    }

    public C40622ai(C4927e c4927e) {
        this(c4927e, C46619af.ccO, "ContactLabel");
    }

    private C40622ai(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        AppMethodBeat.m2504i(29030);
        this.xXd = null;
        this.xXe = null;
        this.bSd = c4927e;
        c4927e.mo10108hY("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
        AppMethodBeat.m2505o(29030);
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    public final ArrayList<String> dsm() {
        ArrayList<String> arrayList = null;
        AppMethodBeat.m2504i(29031);
        long anU = C5046bo.anU();
        Cursor a = this.bSd.mo10105a("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ", 2);
        if (a == null) {
            AppMethodBeat.m2505o(29031);
        } else {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(arrayList.size()), C5046bo.dpG());
            AppMethodBeat.m2505o(29031);
        }
        return arrayList;
    }

    public final ArrayList<C46619af> dsn() {
        ArrayList<C46619af> arrayList = null;
        AppMethodBeat.m2504i(29032);
        long anU = C5046bo.anU();
        Cursor a = this.bSd.mo10104a("select * from ContactLabel order by createTime ASC ", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(29032);
        } else {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                C46619af c46619af = new C46619af();
                c46619af.mo8995d(a);
                arrayList.add(c46619af);
            }
            a.close();
            C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(arrayList.size()), C5046bo.dpG());
            AppMethodBeat.m2505o(29032);
        }
        return arrayList;
    }

    public final void ahw() {
        AppMethodBeat.m2504i(29033);
        C4990ab.m7419v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", C5046bo.dpG());
        this.xXd = null;
        this.xXe = null;
        AppMethodBeat.m2505o(29033);
    }

    public final void dso() {
        AppMethodBeat.m2504i(29034);
        if (this.xXd == null || this.xXe == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            long anU = C5046bo.anU();
            Cursor a = this.bSd.mo10104a("select username , contactLabelIds from rcontact where (type & " + C7486a.m12935NS() + " !=0 ) and ( contactLabelIds != '') ;", null, 2);
            if (a == null) {
                this.xXd = hashMap;
                this.xXe = hashMap2;
                AppMethodBeat.m2505o(29034);
                return;
            }
            while (a.moveToNext()) {
                String string = a.getString(0);
                if (!C5046bo.isNullOrNil(string)) {
                    String[] split = C5046bo.nullAsNil(a.getString(1)).split(",");
                    if (split != null && split.length > 0) {
                        int[] iArr = new int[split.length];
                        for (int i = 0; i < split.length; i++) {
                            iArr[i] = C5046bo.getInt(split[i], -1);
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
            C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(hashMap.size()), Integer.valueOf(hashMap2.size()), C5046bo.dpG());
            this.xXd = hashMap;
            this.xXe = hashMap2;
            AppMethodBeat.m2505o(29034);
            return;
        }
        AppMethodBeat.m2505o(29034);
    }

    public final ArrayList<String> aoD(String str) {
        int i = -1;
        AppMethodBeat.m2504i(29035);
        long anU = C5046bo.anU();
        int i2 = C5046bo.getInt(str, -1);
        if (i2 == -1) {
            C4990ab.m7413e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", str);
            AppMethodBeat.m2505o(29035);
            return null;
        }
        dso();
        ArrayList<String> arrayList = (ArrayList) this.xXe.get(Integer.valueOf(i2));
        String str2 = "MicroMsg.Label.ContactLabelStorage";
        String str3 = "getUserNameListById time:%s id:%s count:%s stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(C5046bo.m7566gb(anU));
        objArr[1] = str;
        if (arrayList != null) {
            i = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = C5046bo.dpG();
        C4990ab.m7417i(str2, str3, objArr);
        AppMethodBeat.m2505o(29035);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: w */
    public final ArrayList<String> mo64084w(String str, List<String> list) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(29036);
        C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ");
        Cursor a;
        try {
            a = this.bSd.mo10104a("select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"}, 2);
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
                    AppMethodBeat.m2505o(29036);
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(29036);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29036);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29036);
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
            AppMethodBeat.m2505o(29036);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: R */
    public final ArrayList<String> mo64068R(String[] strArr) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(29037);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.m2505o(29037);
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
        C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
            try {
                length = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        arrayList.add(a.getString(length));
                    } while (a.moveToNext());
                    C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29037);
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(29037);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29037);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29037);
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
            AppMethodBeat.m2505o(29037);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ai */
    public final ArrayList<String> mo64071ai(ArrayList<String> arrayList) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(29038);
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.m2505o(29038);
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
        C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
            try {
                int columnIndex = a.getColumnIndex("labelID");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(a.getString(columnIndex));
                    } while (a.moveToNext());
                    C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] resut size:%d", Integer.valueOf(arrayList2.size()));
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29038);
                    return arrayList2;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(29038);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29038);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29038);
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
            AppMethodBeat.m2505o(29038);
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m70080a(boolean z, C46619af c46619af) {
        AppMethodBeat.m2504i(29039);
        boolean b = super.mo10101b((C4925c) c46619af);
        if (b && z) {
            anF(C40622ai.m70079a("insert", c46619af));
        }
        AppMethodBeat.m2505o(29039);
        return b;
    }

    /* renamed from: pI */
    public final boolean mo64083pI(String str) {
        int delete;
        AppMethodBeat.m2504i(29040);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", String.valueOf(str));
        C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "labelID =? ");
        try {
            delete = this.bSd.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", e.toString());
            delete = -1;
        }
        if (delete > 0) {
            AppMethodBeat.m2505o(29040);
            return true;
        }
        AppMethodBeat.m2505o(29040);
        return false;
    }

    /* renamed from: a */
    private boolean m70081a(boolean z, C46619af c46619af, String... strArr) {
        AppMethodBeat.m2504i(29041);
        boolean a = super.mo16760a((C4925c) c46619af, strArr);
        if (a && z) {
            anF(C40622ai.m70079a("delete", c46619af));
            C40622ai.dsp();
        }
        ahw();
        AppMethodBeat.m2505o(29041);
        return a;
    }

    /* renamed from: a */
    public final boolean mo64069a(C46619af c46619af, String... strArr) {
        AppMethodBeat.m2504i(29042);
        boolean a = m70081a(true, c46619af, strArr);
        AppMethodBeat.m2505o(29042);
        return a;
    }

    /* renamed from: b */
    public final boolean mo64075b(boolean z, C46619af c46619af, String... strArr) {
        AppMethodBeat.m2504i(29043);
        boolean c = super.mo10103c(c46619af, strArr);
        if (c && z) {
            anF(C40622ai.m70079a("update", c46619af));
        }
        ahw();
        AppMethodBeat.m2505o(29043);
        return c;
    }

    /* renamed from: eq */
    public final boolean mo64079eq(List<C46619af> list) {
        AppMethodBeat.m2504i(29044);
        if (list.size() <= 0) {
            C4990ab.m7416i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
            AppMethodBeat.m2505o(29044);
        } else {
            long iV;
            C7480h c7480h = null;
            if (this.bSd instanceof C7480h) {
                C7480h c7480h2 = (C7480h) this.bSd;
                iV = c7480h2.mo15639iV(Thread.currentThread().getId());
                C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(iV));
                c7480h = c7480h2;
            } else {
                iV = -1;
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                String c = m70083c((C46619af) list.get(i));
                if (!C5046bo.isNullOrNil(c)) {
                    mo64083pI(c);
                }
            }
            if (c7480h != null) {
                c7480h.mo15640mB(iV);
                C4990ab.m7416i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            ahw();
            AppMethodBeat.m2505o(29044);
        }
        return false;
    }

    /* renamed from: er */
    public final boolean mo64080er(List<C46619af> list) {
        AppMethodBeat.m2504i(29045);
        if (list.size() <= 0) {
            C4990ab.m7416i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
            AppMethodBeat.m2505o(29045);
        } else {
            long iV;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            C7480h c7480h = null;
            if (this.bSd instanceof C7480h) {
                C7480h c7480h2 = (C7480h) this.bSd;
                iV = c7480h2.mo15639iV(Thread.currentThread().getId());
                C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(iV));
                c7480h = c7480h2;
            } else {
                iV = -1;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C46619af c46619af = (C46619af) list.get(i);
                if (c46619af != null) {
                    switch (m70082b(c46619af)) {
                        case EQUAL:
                            break;
                        case NOEQUAL:
                            mo64075b(false, c46619af, "labelID");
                            arrayList2.add(c46619af);
                            break;
                        case NOEXISTS:
                            c46619af.field_createTime = System.currentTimeMillis();
                            m70080a(false, c46619af);
                            arrayList.add(c46619af);
                            break;
                        default:
                            C4990ab.m7420w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                            break;
                    }
                }
            }
            if (c7480h != null) {
                c7480h.mo15640mB(iV);
                C4990ab.m7416i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
            }
            if (arrayList.size() > 0) {
                anF(C40622ai.m70084x("insert", arrayList));
            }
            if (arrayList2.size() > 0) {
                anF(C40622ai.m70084x("update", arrayList2));
            }
            ahw();
            AppMethodBeat.m2505o(29045);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: PD */
    public final String mo64066PD(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(29046);
        Cursor a;
        try {
            a = this.bSd.mo10105a("ContactLabel", new String[]{"labelName"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] label string is %s", String.valueOf(a.getString(a.getColumnIndex("labelName"))));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29046);
                        return r0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29046);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29046);
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
            AppMethodBeat.m2505o(29046);
            throw th;
        }
        AppMethodBeat.m2505o(29046);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: PE */
    public final String mo64067PE(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(29047);
        Cursor a;
        try {
            a = this.bSd.mo10105a("ContactLabel", new String[]{"labelID"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] label id is %s", String.valueOf(a.getString(a.getColumnIndex("labelID"))));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29047);
                        return r0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29047);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29047);
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
            AppMethodBeat.m2505o(29047);
            throw th;
        }
        AppMethodBeat.m2505o(29047);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C46619af aoE(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.m2504i(29048);
        Cursor a;
        try {
            a = this.bSd.mo10105a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        C46619af c46619af = new C46619af();
                        c46619af.mo8995d(a);
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29048);
                        return c46619af;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29048);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                        }
                        AppMethodBeat.m2505o(29048);
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
            AppMethodBeat.m2505o(29048);
            throw th;
        }
        AppMethodBeat.m2505o(29048);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C46619af aoF(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.m2504i(29049);
        Cursor a;
        try {
            a = this.bSd.mo10105a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        C46619af c46619af = new C46619af();
                        c46619af.mo8995d(a);
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29049);
                        return c46619af;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29049);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                        }
                        AppMethodBeat.m2505o(29049);
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
            AppMethodBeat.m2505o(29049);
            throw th;
        }
        AppMethodBeat.m2505o(29049);
        return null;
    }

    /* renamed from: b */
    private C40623a m70082b(C46619af c46619af) {
        AppMethodBeat.m2504i(29050);
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a("select * from ContactLabel where labelID=?", new String[]{c46619af.field_labelID}, 2);
            C40623a c40623a;
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                c40623a = C40623a.NOEXISTS;
                AppMethodBeat.m2505o(29050);
                return c40623a;
            }
            if (c46619af.field_labelName.equalsIgnoreCase(C5046bo.m7532bc(cursor.getString(cursor.getColumnIndex("labelName")), ""))) {
                c40623a = C40623a.EQUAL;
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(29050);
                return c40623a;
            }
            c40623a = C40623a.NOEQUAL;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(29050);
            return c40623a;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(29050);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private String m70083c(C46619af c46619af) {
        Exception e;
        Throwable th;
        String str = null;
        AppMethodBeat.m2504i(29051);
        Cursor a;
        try {
            a = this.bSd.mo10104a("select * from ContactLabel where labelName=? and isTemporary =?", new String[]{c46619af.field_labelName, "1"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        boolean equalsIgnoreCase = c46619af.field_labelName.equalsIgnoreCase(C5046bo.m7532bc(a.getString(a.getColumnIndex("labelName")), ""));
                        C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] itemname:%s dbname:%s", c46619af.field_labelName, String.valueOf(r1));
                        if (equalsIgnoreCase) {
                            str = a.getString(a.getColumnIndex("labelID"));
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.m2505o(29051);
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29051);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(29051);
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
            AppMethodBeat.m2505o(29051);
            throw th;
        }
        AppMethodBeat.m2505o(29051);
        return str;
    }

    /* renamed from: a */
    private static String m70079a(String str, C46619af c46619af) {
        AppMethodBeat.m2504i(29052);
        if (c46619af != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c46619af);
            String x = C40622ai.m70084x(str, arrayList);
            AppMethodBeat.m2505o(29052);
            return x;
        }
        AppMethodBeat.m2505o(29052);
        return null;
    }

    /* renamed from: x */
    private static String m70084x(String str, List<C46619af> list) {
        AppMethodBeat.m2504i(29053);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(29053);
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C46619af c46619af = (C46619af) list.get(i);
            if (c46619af != null) {
                stringBuilder.append(c46619af.field_labelID);
                if (i < size - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", stringBuilder.toString());
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(29053);
        return stringBuilder2;
    }

    private static void dsp() {
        AppMethodBeat.m2504i(29054);
        C4990ab.m7416i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        C26245tv c26245tv = new C26245tv();
        c26245tv.cPX.cvc = 3000;
        C4879a.xxA.mo10055m(c26245tv);
        AppMethodBeat.m2505o(29054);
    }

    /* renamed from: es */
    public final boolean mo64081es(List<C46619af> list) {
        AppMethodBeat.m2504i(29055);
        if (list == null || list.size() <= 0) {
            C4990ab.m7420w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            AppMethodBeat.m2505o(29055);
            return false;
        }
        long iV;
        C7480h c7480h = null;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            iV = c7480h2.mo15639iV(Thread.currentThread().getId());
            C4990ab.m7417i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", Long.valueOf(iV));
            c7480h = c7480h2;
        } else {
            iV = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m70081a(false, (C46619af) list.get(i), "labelID");
        }
        if (c7480h != null) {
            c7480h.mo15640mB(iV);
            C4990ab.m7416i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        anF(C40622ai.m70084x("delete", list));
        C40622ai.dsp();
        AppMethodBeat.m2505o(29055);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: et */
    public final ArrayList<C46619af> mo64082et(List<C46619af> list) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(29056);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(29056);
            return null;
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" not in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("'" + ((C46619af) list.get(i)).field_labelID + "'");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    ArrayList<C46619af> arrayList = new ArrayList();
                    do {
                        C46619af c46619af = new C46619af();
                        c46619af.mo8995d(a);
                        arrayList.add(c46619af);
                    } while (a.moveToNext());
                    C4990ab.m7411d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29056);
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(29056);
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7421w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(29056);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                    }
                    AppMethodBeat.m2505o(29056);
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
            AppMethodBeat.m2505o(29056);
            throw th;
        }
    }
}

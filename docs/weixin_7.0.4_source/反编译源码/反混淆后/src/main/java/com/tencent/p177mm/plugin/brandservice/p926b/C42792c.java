package com.tencent.p177mm.plugin.brandservice.p926b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.protocal.protobuf.C30201lk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.b.c */
public final class C42792c implements C1202f {
    public LinkedList<C27511a> jKu = new LinkedList();
    private boolean jKv = false;
    private List<C30201lk> jKw = new LinkedList();
    private List<C30201lk> jKx = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.brandservice.b.c$a */
    public interface C27511a {
        void aVU();
    }

    public C42792c() {
        AppMethodBeat.m2504i(13829);
        C1720g.m3540Rg().mo14539a(387, (C1202f) this);
        C1720g.m3540Rg().mo14541a(new C42794e(), 0);
        AppMethodBeat.m2505o(13829);
    }

    public final void init() {
        AppMethodBeat.m2504i(13830);
        long currentTimeMillis = System.currentTimeMillis();
        this.jKw.clear();
        this.jKx.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.conRemarkPYFull");
        stringBuilder.append(", rcontact.conRemarkPYShort");
        stringBuilder.append(", rcontact.showHead");
        stringBuilder.append(", rcontact.pyInitial");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(C7616ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        stringBuilder.append(" order by showHead asc, ");
        stringBuilder.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" upper(quanPin) asc, ");
        stringBuilder.append(" upper(nickname) asc");
        C4990ab.m7411d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", stringBuilder.toString());
        C1720g.m3537RQ();
        Cursor a = C1720g.m3536RP().eJN.mo10104a(r0, null, 2);
        HashMap hashMap = new HashMap();
        if (a != null) {
            int i = 0;
            while (a.moveToNext()) {
                i++;
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(a);
                C16527d c16527d = new C16527d();
                c16527d.mo8995d(a);
                if (!c7616ad.field_username.equals("gh_43f2581f6fd6")) {
                    C30201lk c30201lk = new C30201lk();
                    c30201lk.userName = c7616ad.field_username;
                    c30201lk.ehM = c7616ad;
                    c30201lk.pkW = c16527d;
                    if (!C1855t.m3943nl(c30201lk.userName)) {
                        hashMap.put(c30201lk.userName, c30201lk);
                        if (c30201lk.pkW.field_type != 3) {
                            if (c30201lk.pkW.field_type == 2) {
                                this.jKw.add(c30201lk);
                            } else if (c30201lk.pkW.field_type == 1 || c30201lk.pkW.field_type == 0) {
                                this.jKx.add(c30201lk);
                            }
                        }
                    }
                }
            }
            C4990ab.m7411d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", Integer.valueOf(i));
            a.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        stringBuilder = new StringBuilder();
        stringBuilder.append("select username");
        stringBuilder.append(" from rcontact");
        stringBuilder.append(" where (verifyFlag & ").append(C7616ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (type & 1) != 0 ");
        C4990ab.m7411d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", stringBuilder.toString());
        C1720g.m3537RQ();
        Cursor a2 = C1720g.m3536RP().eJN.mo10104a(r0, null, 0);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            while (a2.moveToNext()) {
                String string = a2.getString(0);
                if (!hashMap.containsKey(string)) {
                    arrayList.add(string);
                }
            }
            a2.close();
            C4990ab.m7417i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", Integer.valueOf(arrayList.size()), arrayList);
            if (!arrayList.isEmpty()) {
                C1720g.m3537RQ();
                long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C26417a.flu.mo20967ai((String) it.next(), "");
                }
                C1720g.m3537RQ();
                C1720g.m3536RP().eJN.mo15640mB(iV);
            }
        }
        C4990ab.m7411d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        C4990ab.m7411d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", Integer.valueOf(this.jKx.size()), Integer.valueOf(this.jKw.size()));
        C4990ab.m7411d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(13830);
    }

    public final void release() {
        AppMethodBeat.m2504i(13831);
        C1720g.m3540Rg().mo14546b(387, (C1202f) this);
        if (this.jKv) {
            ArrayList arrayList = new ArrayList(this.jKw.size() + this.jKx.size());
            for (C30201lk add : this.jKw) {
                arrayList.add(add);
            }
            for (C30201lk add2 : this.jKx) {
                arrayList.add(add2);
            }
            C1720g.m3540Rg().mo14541a(new C20029j(arrayList), 0);
        }
        AppMethodBeat.m2505o(13831);
    }

    /* renamed from: rY */
    public final List<C30201lk> mo68262rY(int i) {
        switch (i) {
            case 2:
                return this.jKw;
            default:
                return this.jKx;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(13832);
        C4990ab.m7421w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 387) {
                LinkedList linkedList = ((C42794e) c1207m).jKy;
                if (linkedList == null) {
                    C4990ab.m7412e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
                    AppMethodBeat.m2505o(13832);
                    return;
                } else if (this.jKw == null || this.jKx == null) {
                    C4990ab.m7412e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
                    AppMethodBeat.m2505o(13832);
                    return;
                } else {
                    int i4;
                    if (linkedList.size() != this.jKw.size() + this.jKx.size()) {
                        i4 = 1;
                    } else {
                        for (C30201lk c30201lk : this.jKw) {
                            if (c30201lk != null) {
                                if (!linkedList.contains(c30201lk.userName)) {
                                }
                            }
                            i3 = 1;
                        }
                        if (i3 == 0) {
                            for (C30201lk c30201lk2 : this.jKx) {
                                if (c30201lk2 != null) {
                                    if (!linkedList.contains(c30201lk2.userName)) {
                                    }
                                }
                                i4 = 1;
                            }
                        }
                        i4 = i3;
                    }
                    if (i4 != 0) {
                        init();
                        Iterator it = this.jKu.iterator();
                        while (it.hasNext()) {
                            ((C27511a) it.next()).aVU();
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(13832);
            return;
        }
        AppMethodBeat.m2505o(13832);
    }
}

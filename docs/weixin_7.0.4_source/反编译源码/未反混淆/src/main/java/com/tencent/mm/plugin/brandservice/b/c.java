package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c implements f {
    public LinkedList<a> jKu = new LinkedList();
    private boolean jKv = false;
    private List<lk> jKw = new LinkedList();
    private List<lk> jKx = new LinkedList();

    public interface a {
        void aVU();
    }

    public c() {
        AppMethodBeat.i(13829);
        g.Rg().a(387, (f) this);
        g.Rg().a(new e(), 0);
        AppMethodBeat.o(13829);
    }

    public final void init() {
        AppMethodBeat.i(13830);
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
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        stringBuilder.append(" order by showHead asc, ");
        stringBuilder.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" upper(quanPin) asc, ");
        stringBuilder.append(" upper(nickname) asc");
        ab.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", stringBuilder.toString());
        g.RQ();
        Cursor a = g.RP().eJN.a(r0, null, 2);
        HashMap hashMap = new HashMap();
        if (a != null) {
            int i = 0;
            while (a.moveToNext()) {
                i++;
                ad adVar = new ad();
                adVar.d(a);
                d dVar = new d();
                dVar.d(a);
                if (!adVar.field_username.equals("gh_43f2581f6fd6")) {
                    lk lkVar = new lk();
                    lkVar.userName = adVar.field_username;
                    lkVar.ehM = adVar;
                    lkVar.pkW = dVar;
                    if (!t.nl(lkVar.userName)) {
                        hashMap.put(lkVar.userName, lkVar);
                        if (lkVar.pkW.field_type != 3) {
                            if (lkVar.pkW.field_type == 2) {
                                this.jKw.add(lkVar);
                            } else if (lkVar.pkW.field_type == 1 || lkVar.pkW.field_type == 0) {
                                this.jKx.add(lkVar);
                            }
                        }
                    }
                }
            }
            ab.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", Integer.valueOf(i));
            a.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        stringBuilder = new StringBuilder();
        stringBuilder.append("select username");
        stringBuilder.append(" from rcontact");
        stringBuilder.append(" where (verifyFlag & ").append(ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (type & 1) != 0 ");
        ab.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", stringBuilder.toString());
        g.RQ();
        Cursor a2 = g.RP().eJN.a(r0, null, 0);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            while (a2.moveToNext()) {
                String string = a2.getString(0);
                if (!hashMap.containsKey(string)) {
                    arrayList.add(string);
                }
            }
            a2.close();
            ab.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", Integer.valueOf(arrayList.size()), arrayList);
            if (!arrayList.isEmpty()) {
                g.RQ();
                long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.model.ao.a.flu.ai((String) it.next(), "");
                }
                g.RQ();
                g.RP().eJN.mB(iV);
            }
        }
        ab.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        ab.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", Integer.valueOf(this.jKx.size()), Integer.valueOf(this.jKw.size()));
        ab.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(13830);
    }

    public final void release() {
        AppMethodBeat.i(13831);
        g.Rg().b(387, (f) this);
        if (this.jKv) {
            ArrayList arrayList = new ArrayList(this.jKw.size() + this.jKx.size());
            for (lk add : this.jKw) {
                arrayList.add(add);
            }
            for (lk add2 : this.jKx) {
                arrayList.add(add2);
            }
            g.Rg().a(new j(arrayList), 0);
        }
        AppMethodBeat.o(13831);
    }

    public final List<lk> rY(int i) {
        switch (i) {
            case 2:
                return this.jKw;
            default:
                return this.jKx;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(13832);
        ab.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 387) {
                LinkedList linkedList = ((e) mVar).jKy;
                if (linkedList == null) {
                    ab.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
                    AppMethodBeat.o(13832);
                    return;
                } else if (this.jKw == null || this.jKx == null) {
                    ab.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
                    AppMethodBeat.o(13832);
                    return;
                } else {
                    int i4;
                    if (linkedList.size() != this.jKw.size() + this.jKx.size()) {
                        i4 = 1;
                    } else {
                        for (lk lkVar : this.jKw) {
                            if (lkVar != null) {
                                if (!linkedList.contains(lkVar.userName)) {
                                }
                            }
                            i3 = 1;
                        }
                        if (i3 == 0) {
                            for (lk lkVar2 : this.jKx) {
                                if (lkVar2 != null) {
                                    if (!linkedList.contains(lkVar2.userName)) {
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
                            ((a) it.next()).aVU();
                        }
                    }
                }
            }
            AppMethodBeat.o(13832);
            return;
        }
        AppMethodBeat.o(13832);
    }
}

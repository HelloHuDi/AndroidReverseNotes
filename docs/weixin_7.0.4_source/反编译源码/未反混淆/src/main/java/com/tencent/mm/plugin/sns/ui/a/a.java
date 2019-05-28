package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.b.b;
import com.tencent.mm.plugin.sns.ui.a.b.c;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public final class a extends BaseAdapter implements w {
    private static HashMap<Long, a> rEE = new HashMap();
    private static boolean rEF = false;
    private boolean eJj = false;
    public au rEA;
    public b rEB;
    public boolean rEC;
    public com.tencent.mm.vending.base.Vending.a rED = new com.tencent.mm.vending.base.Vending.a() {
        public final void cuN() {
            AppMethodBeat.i(39932);
            if (!a.this.rEC) {
                a.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(39932);
        }
    };

    static class a {
        int fjN;
        String id;
        int mGJ;
        int networkType;
        HashSet<Integer> rEH;
        HashSet<Integer> rEI;
        HashSet<Integer> rEJ;
        HashSet<Integer> rEK;
        int rEL;
        long rEM;
        int rEN;
        int rEO;
        int rEP;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(39946);
        n DP = DP(i);
        AppMethodBeat.o(39946);
        return DP;
    }

    public a(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.d.b bVar, i iVar, String str, b bVar2) {
        AppMethodBeat.i(39933);
        this.rEA = new au(mMActivity, listView, bVar, iVar, this);
        this.rEA.rps = true;
        if (bVar2 == null) {
            bVar2 = new c();
        }
        this.rEB = bVar2;
        this.rEB.a(mMActivity, this.rEA, str);
        b bVar3 = this.rEB;
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", Integer.valueOf(10));
        bVar3.a = 10;
        this.rEB.addVendingDataChangedCallback(this.rED);
        AppMethodBeat.o(39933);
    }

    public final void sg() {
        AppMethodBeat.i(39934);
        if (this.eJj) {
            AppMethodBeat.o(39934);
            return;
        }
        this.eJj = true;
        this.rEB.notifyVendingDataChangeSynchronize();
        AppMethodBeat.o(39934);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(39935);
        View h = this.rEA.h(i, view);
        AppMethodBeat.o(39935);
        return h;
    }

    public final int getViewTypeCount() {
        return 15;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(39936);
        int itemViewType = this.rEA.getItemViewType(i);
        AppMethodBeat.o(39936);
        return itemViewType;
    }

    public final void crP() {
        AppMethodBeat.i(139045);
        this.rEB.notifyVendingDataChange();
        AppMethodBeat.o(139045);
    }

    public final n DP(int i) {
        AppMethodBeat.i(39938);
        av avVar = (av) this.rEB.get(i);
        if (avVar == null) {
            AppMethodBeat.o(39938);
            return null;
        }
        n nVar = avVar.qBY;
        AppMethodBeat.o(39938);
        return nVar;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.rEB.c;
    }

    static {
        AppMethodBeat.i(39947);
        AppMethodBeat.o(39947);
    }

    public static void F(n nVar) {
        AppMethodBeat.i(39939);
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (!rEE.containsKey(Long.valueOf(j))) {
                a aVar = new a();
                if (!(nVar.cqu() == null || nVar.cqu().xfI == null || nVar.cqu().xfI.wbJ != 1 || nVar.cqu().xfI.wbK == null || nVar.cqu().xfI.wbK.size() <= 0)) {
                    aVar.fjN = nVar.cqu().xfI.wbK.size();
                    aVar.rEH = new HashSet();
                    aVar.rEI = new HashSet();
                    aVar.rEJ = new HashSet();
                    aVar.rEK = new HashSet();
                    aVar.id = nVar.cqu().Id;
                    aVar.rEP = nVar.cqu().dtW;
                    try {
                        cbf q = aj.q(nVar);
                        aVar.rEN = q.xao;
                        aVar.rEO = q.xar;
                    } catch (Exception e) {
                        aVar.rEN = 0;
                        aVar.rEO = 0;
                    }
                    try {
                        g.RQ();
                        aVar.mGJ = ((j) g.K(j.class)).bOr().Rp(nVar.field_userName);
                        long currentTimeMillis = System.currentTimeMillis();
                        g.RQ();
                        aVar.rEM = (currentTimeMillis - ((j) g.K(j.class)).bOr().Rt(nVar.field_userName)) / 1000;
                    } catch (Exception e2) {
                        aVar.mGJ = 0;
                        aVar.rEM = 0;
                    }
                    rEE.put(Long.valueOf(j), aVar);
                }
            }
        }
        AppMethodBeat.o(39939);
    }

    public static void b(n nVar, int i) {
        AppMethodBeat.i(39940);
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                a aVar = (a) rEE.get(Long.valueOf(j));
                if (aVar.rEL == 0) {
                    aVar.rEL = i + 1;
                }
                if (aVar.rEH == null) {
                    aVar.rEH = new HashSet();
                }
                aVar.rEH.add(Integer.valueOf(i + 1));
            }
        }
        AppMethodBeat.o(39940);
    }

    public static void c(n nVar, int i) {
        AppMethodBeat.i(39941);
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                a aVar = (a) rEE.get(Long.valueOf(j));
                if (aVar.rEI == null) {
                    aVar.rEI = new HashSet();
                }
                if (!aVar.rEI.contains(Integer.valueOf(i + 1))) {
                    aVar.rEI.add(Integer.valueOf(i + 1));
                }
            }
        }
        AppMethodBeat.o(39941);
    }

    public static void d(n nVar, int i) {
        AppMethodBeat.i(39942);
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                a aVar = (a) rEE.get(Long.valueOf(j));
                if (aVar.rEJ == null) {
                    aVar.rEJ = new HashSet();
                }
                if (!aVar.rEJ.contains(Integer.valueOf(i + 1))) {
                    aVar.rEJ.add(Integer.valueOf(i + 1));
                }
            }
        }
        AppMethodBeat.o(39942);
    }

    public static void e(n nVar, int i) {
        AppMethodBeat.i(39943);
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (rEE.containsKey(Long.valueOf(j))) {
                a aVar = (a) rEE.get(Long.valueOf(j));
                if (aVar.rEK == null) {
                    aVar.rEK = new HashSet();
                }
                if (!aVar.rEK.contains(Integer.valueOf(i + 1))) {
                    aVar.rEK.add(Integer.valueOf(i + 1));
                }
            }
        }
        AppMethodBeat.o(39943);
    }

    public static void cuM() {
        AppMethodBeat.i(39944);
        for (Entry value : rEE.entrySet()) {
            String str;
            String str2;
            String str3;
            a aVar = (a) value.getValue();
            aVar.networkType = com.tencent.mm.plugin.sns.data.i.cms();
            ab.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", Integer.valueOf(aVar.fjN), Integer.valueOf(aVar.rEH.size()), Integer.valueOf(aVar.rEL), Integer.valueOf(aVar.networkType), aVar.id);
            String str4 = "";
            Iterator it = aVar.rEI.iterator();
            while (true) {
                str = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str + ((Integer) it.next()) + "|";
            }
            if (str.length() >= 2) {
                str = str.substring(0, str.length() - 1);
            }
            str4 = "";
            Iterator it2 = aVar.rEJ.iterator();
            while (true) {
                str2 = str4;
                if (!it2.hasNext()) {
                    break;
                }
                str4 = str2 + ((Integer) it2.next()) + "|";
            }
            if (str2.length() >= 2) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            str4 = "";
            Iterator it3 = aVar.rEK.iterator();
            while (true) {
                str3 = str4;
                if (!it3.hasNext()) {
                    break;
                }
                str4 = str3 + ((Integer) it3.next()) + "|";
            }
            if (str3.length() >= 2) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            h.pYm.e(11599, Integer.valueOf(aVar.fjN), Integer.valueOf(aVar.rEH.size()), Integer.valueOf(aVar.rEL), Integer.valueOf(aVar.networkType), Integer.valueOf(0), aVar.id, Long.valueOf(aVar.rEM), Integer.valueOf(aVar.mGJ), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar.rEN), Integer.valueOf(aVar.rEO), Integer.valueOf(0), str, str2, str3, Integer.valueOf(0), "", Integer.valueOf(aVar.rEP));
        }
        rEE.clear();
        AppMethodBeat.o(39944);
    }

    public static void d(TimeLineObject timeLineObject) {
        int i;
        AppMethodBeat.i(39945);
        if (timeLineObject.xfI.wbN != null) {
            i = timeLineObject.xfI.wbN.vGc;
        } else {
            i = -1;
        }
        ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(timeLineObject.xfI.Url, i, 2, timeLineObject.Id);
        if (!(rEF || i == -1 || !((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(24))) {
            rEF = true;
            ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rX(2);
        }
        if (i == 5 && ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP() && timeLineObject.xfI.wbN != null && !bo.isNullOrNil(timeLineObject.xfI.wbN.lvx)) {
            String str = timeLineObject.xfI.wbN.lvx;
            String v = q.v(str, 0, "@T");
            if (!e.ct(v)) {
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePH = true;
                aVar.ePJ = v;
                o.ahp().a(str, aVar.ahG(), null);
            }
        }
        AppMethodBeat.o(39945);
    }

    public final /* bridge */ /* synthetic */ Vending crQ() {
        return this.rEB;
    }
}

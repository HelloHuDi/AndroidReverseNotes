package com.tencent.mm.plugin.fav.ui.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.d.d;
import com.tencent.mm.plugin.fav.ui.d.e;
import com.tencent.mm.plugin.fav.ui.d.f;
import com.tencent.mm.plugin.fav.ui.d.h;
import com.tencent.mm.plugin.fav.ui.d.i;
import com.tencent.mm.plugin.fav.ui.d.j;
import com.tencent.mm.plugin.fav.ui.d.k;
import com.tencent.mm.plugin.fav.ui.d.m;
import com.tencent.mm.plugin.fav.ui.d.n;
import com.tencent.mm.plugin.fav.ui.d.o;
import com.tencent.mm.plugin.fav.ui.d.p;
import com.tencent.mm.plugin.fav.ui.d.q;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b extends a {
    private c hAA;
    public int jSW;
    private boolean mlc;
    public List<g> mld;
    private List<g> mle;
    private List<g> mlf;
    public List<Long> mlg;
    public boolean mlh;
    private Map<Long, g> mli;
    private List<Integer> mlj;
    private List<String> mlk;
    private List<String> mll;
    private SparseArray<a> mlm;
    private boolean mln;
    public a.c mlo;
    public boolean mlp;
    public boolean mlq;
    public ListView mlr;
    public String query;
    public int scene;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(74316);
        g vE = vE(i);
        AppMethodBeat.o(74316);
        return vE;
    }

    public b(l lVar, boolean z) {
        AppMethodBeat.i(74294);
        this.mlc = false;
        this.mld = new ArrayList();
        this.mle = new ArrayList();
        this.mlf = new LinkedList();
        this.mlg = new ArrayList();
        this.mlh = false;
        this.mli = new TreeMap();
        this.mlj = new ArrayList();
        this.mlk = new LinkedList();
        this.mll = new LinkedList();
        this.mlm = new SparseArray();
        this.mln = false;
        this.mlp = false;
        this.mlq = false;
        this.query = "";
        this.hAA = new c<ke>() {
            {
                AppMethodBeat.i(74292);
                this.xxI = ke.class.getName().hashCode();
                AppMethodBeat.o(74292);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(74293);
                ke keVar = (ke) bVar;
                if (keVar instanceof ke) {
                    switch (keVar.cFH.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 7:
                            b.this.notifyDataSetChanged();
                            break;
                    }
                }
                AppMethodBeat.o(74293);
                return false;
            }
        };
        this.type = -1;
        this.mlm.put(1, new m(lVar));
        this.mlm.put(2, new d(lVar));
        this.mlm.put(3, new q(lVar));
        this.mlm.put(4, new p(lVar));
        this.mlm.put(5, new o(lVar));
        this.mlm.put(6, new e(lVar));
        this.mlm.put(7, new com.tencent.mm.plugin.fav.ui.d.g(lVar));
        this.mlm.put(8, new com.tencent.mm.plugin.fav.ui.d.c(lVar));
        this.mlm.put(10, new i(lVar));
        this.mlm.put(12, new com.tencent.mm.plugin.fav.ui.d.l(lVar));
        this.mlm.put(15, new com.tencent.mm.plugin.fav.ui.d.l(lVar));
        this.mlm.put(11, new f(lVar));
        this.mlm.put(14, new j(lVar));
        this.mlm.put(16, new k(lVar));
        this.mlm.put(17, new com.tencent.mm.plugin.fav.ui.d.b(lVar));
        this.mlm.put(18, new h(lVar));
        this.mlm.put(-2, new n(lVar));
        if (z != this.mlp) {
            this.mlp = z;
            if (z) {
                this.mli.clear();
            }
        }
        if (!this.mlp) {
            bvX();
        }
        bvY();
        notifyDataSetChanged();
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
        AppMethodBeat.o(74294);
    }

    public final void finish() {
        AppMethodBeat.i(74295);
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        AppMethodBeat.o(74295);
    }

    private void lV(int i) {
        int i2 = this.jSW;
        if (i == 0) {
            this.jSW = 0;
        } else if (i2 == 0) {
            this.jSW = i;
        } else if (i2 != i) {
            this.jSW = 4;
        }
    }

    public final void bvX() {
        AppMethodBeat.i(74296);
        if (bwa()) {
            ab.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
            AppMethodBeat.o(74296);
        } else if (com.tencent.mm.plugin.fav.a.b.buo()) {
            ab.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
            AppMethodBeat.o(74296);
        } else if (this.mlp) {
            this.mle = g(this.mld, this.mlg);
            this.mlc = true;
            AppMethodBeat.o(74296);
        } else {
            try {
                this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.q(this.lastUpdateTime, this.type);
                AppMethodBeat.o(74296);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FavoriteAdapter", e, "", new Object[0]);
                AppMethodBeat.o(74296);
            }
        }
    }

    private static List<g> g(List<g> list, List<Long> list2) {
        int i = 0;
        AppMethodBeat.i(74297);
        ArrayList arrayList = new ArrayList();
        if (list2 == null) {
            AppMethodBeat.o(74297);
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            Long valueOf = Long.valueOf(((g) list.get(list.size() - 1)).field_localId);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (valueOf.equals(list2.get(i2))) {
                    i = i2 + 1;
                    break;
                }
            }
        }
        int i3 = i;
        while (i3 < i + 20 && i3 < list2.size()) {
            g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(((Long) list2.get(i3)).longValue());
            if (iE != null) {
                arrayList.add(iE);
            }
            i3++;
        }
        AppMethodBeat.o(74297);
        return arrayList;
    }

    private void bvZ() {
        AppMethodBeat.i(74298);
        lV(0);
        this.mlg = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buZ();
        AppMethodBeat.o(74298);
    }

    private void bP(List<g> list) {
        AppMethodBeat.i(74299);
        if (list == null) {
            AppMethodBeat.o(74299);
            return;
        }
        ab.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", Integer.valueOf(list.size()));
        ab.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", Integer.valueOf(this.mlf.size()));
        list.clear();
        AppMethodBeat.o(74299);
    }

    private boolean bwa() {
        AppMethodBeat.i(74300);
        if (this.mlk.isEmpty() && this.mll.isEmpty() && this.mlj.isEmpty()) {
            AppMethodBeat.o(74300);
            return false;
        }
        AppMethodBeat.o(74300);
        return true;
    }

    public final void a(boolean z, g gVar) {
        AppMethodBeat.i(74301);
        if (z == this.mlh) {
            AppMethodBeat.o(74301);
            return;
        }
        this.mlh = z;
        if (z) {
            this.mli.clear();
            if (gVar != null) {
                g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(gVar.field_localId);
                if (iE != null) {
                    this.mli.put(Long.valueOf(iE.field_localId), iE);
                }
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(74301);
    }

    public final List<g> hk(boolean z) {
        AppMethodBeat.i(74302);
        LinkedList linkedList = new LinkedList();
        for (g gVar : this.mli.values()) {
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        if (z) {
            this.mli.clear();
        }
        AppMethodBeat.o(74302);
        return linkedList;
    }

    public final int bwb() {
        AppMethodBeat.i(74303);
        int size = this.mli.size();
        AppMethodBeat.o(74303);
        return size;
    }

    public final long bwc() {
        AppMethodBeat.i(74304);
        long j = 0;
        Iterator it = this.mli.values().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar != null) {
                    j = gVar.field_datatotalsize + j2;
                } else {
                    j = j2;
                }
            } else {
                AppMethodBeat.o(74304);
                return j2;
            }
        }
    }

    public final void c(List<Integer> list, List<String> list2, List<String> list3) {
        AppMethodBeat.i(74305);
        lV(0);
        this.mlj.clear();
        if (list != null) {
            this.mlj.addAll(list);
            if (!list.isEmpty()) {
                lV(2);
            }
        }
        this.mlk.clear();
        if (list2 != null) {
            this.mlk.addAll(list2);
            if (!list2.isEmpty()) {
                lV(3);
            }
        }
        this.mll.clear();
        if (list3 != null) {
            this.mll.addAll(list3);
            if (!list3.isEmpty()) {
                lV(1);
            }
        }
        this.mln = true;
        bvY();
        this.mln = false;
        AppMethodBeat.o(74305);
    }

    public final void bvY() {
        AppMethodBeat.i(74306);
        ab.v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.mlc = false;
        bP(this.mle);
        if (bwa()) {
            ab.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", this.mlk, this.mll, this.mlj);
            this.mle = com.tencent.mm.plugin.fav.a.b.a(this.mlk, this.mll, this.mlj, this.mlf, this.mkZ, this.mla);
            int size = this.mle == null ? 0 : this.mle.size();
            com.tencent.mm.plugin.report.service.h.pYm.e(10649, Integer.valueOf(size));
        } else {
            ab.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type));
            if (this.mlp) {
                bvZ();
                this.mle = g(null, this.mlg);
            } else {
                this.mle = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.mkZ, this.mla);
                if (this.mle != null && this.lastUpdateTime == 0 && this.mle.size() > 0) {
                    this.lastUpdateTime = ((g) this.mle.get(this.mle.size() - 1)).field_updateTime;
                }
            }
        }
        if (this.mle == null) {
            ab.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.mle = new ArrayList();
        }
        if (!(this.mlp || bwa() || this.mle.size() >= 20 || ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().t(this.lastUpdateTime, this.type))) {
            ab.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            bvX();
        }
        this.mlc = true;
        ab.v("MicroMsg.FavoriteAdapter", "reset data list end");
        AppMethodBeat.o(74306);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(74307);
        boolean isEmpty = this.mld.isEmpty();
        AppMethodBeat.o(74307);
        return isEmpty;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(74308);
        ab.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", Boolean.valueOf(this.mlc));
        if (this.mlc) {
            if (this.mlp && this.mle != null && this.mld != null && this.mle.size() == this.mld.size()) {
                this.mlq = true;
            }
            List list = this.mld;
            this.mld = this.mle;
            this.mle = list;
            this.mlc = false;
        }
        ab.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
        AppMethodBeat.o(74308);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(74309);
        if (i == 0) {
            AppMethodBeat.o(74309);
            return 0;
        }
        g vE = vE(i - 1);
        switch (vE.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                int i2 = vE.field_type;
                AppMethodBeat.o(74309);
                return i2;
            default:
                ab.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", Integer.valueOf(vE.field_type));
                AppMethodBeat.o(74309);
                return -2;
        }
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(74310);
        int size = this.mlm.size() + 4;
        AppMethodBeat.o(74310);
        return size;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(74311);
        View view2;
        if (i == 0) {
            view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(0, 0));
            view2.setBackgroundResource(R.color.ov);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            AppMethodBeat.o(74311);
            return view2;
        }
        g vE = vE(i - 1);
        a aVar = (a) this.mlm.get(vE.field_type);
        if (aVar == null) {
            ab.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", Integer.valueOf(vE.field_type));
            aVar = (a) this.mlm.get(-2);
            bvW();
            view2 = aVar.a(view, viewGroup, vE);
            AppMethodBeat.o(74311);
            return view2;
        }
        aVar.moE.jLC = bwa();
        aVar.moE.lastUpdateTime = this.lastUpdateTime;
        aVar.moE.mlh = this.mlh;
        aVar.moE.mli = this.mli;
        aVar.moE.moG = this.mlo;
        aVar.moE.mlp = this.mlp;
        view2 = aVar.a(view, viewGroup, vE);
        AppMethodBeat.o(74311);
        return view2;
    }

    public final g vE(int i) {
        AppMethodBeat.i(74312);
        g gVar;
        if (i < 0 || i >= this.mld.size()) {
            ab.e("MicroMsg.FavoriteAdapter", "get item, but position error");
            gVar = new g();
            AppMethodBeat.o(74312);
            return gVar;
        }
        gVar = (g) this.mld.get(i);
        AppMethodBeat.o(74312);
        return gVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getCount() {
        AppMethodBeat.i(74313);
        int size = this.mld.size() + 1;
        AppMethodBeat.o(74313);
        return size;
    }

    public final int iK(long j) {
        int i = 0;
        AppMethodBeat.i(74314);
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
        if (iE == null) {
            AppMethodBeat.o(74314);
            return -1;
        } else if (this.mli.size() >= 30) {
            ab.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", Integer.valueOf(30));
            com.tencent.mm.ui.base.h.bQ(ah.getContext(), ah.getContext().getResources().getString(R.string.bpm, new Object[]{Integer.valueOf(30)}));
            AppMethodBeat.o(74314);
            return -1;
        } else {
            this.mli.put(Long.valueOf(j), iE);
            if (iE.field_updateTime < this.lastUpdateTime) {
                this.lastUpdateTime = iE.field_updateTime;
                bvY();
                for (g iE2 : this.mle) {
                    if (iE2.field_localId == j) {
                        notifyDataSetChanged();
                        AppMethodBeat.o(74314);
                        return i;
                    }
                    i++;
                }
                notifyDataSetChanged();
            } else {
                for (g iE22 : this.mld) {
                    if (iE22.field_localId == j) {
                        notifyDataSetChanged();
                        AppMethodBeat.o(74314);
                        return i;
                    }
                    i++;
                }
            }
            AppMethodBeat.o(74314);
            return -1;
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(74315);
        com.tencent.mm.plugin.fav.ui.d.a.b bVar = (com.tencent.mm.plugin.fav.ui.d.a.b) view.getTag();
        if (bVar == null) {
            ab.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
            AppMethodBeat.o(74315);
        } else if (bVar.mgf == null) {
            ab.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
            AppMethodBeat.o(74315);
        } else if (!this.mlh && !this.mlp) {
            a aVar = (a) this.mlm.get(bVar.mgf.field_type);
            if (aVar != null) {
                StringBuilder stringBuilder = new StringBuilder();
                g gVar = bVar.mgf;
                String str = gVar.field_id + "_" + (System.currentTimeMillis() / 1000);
                LinkedList<String> linkedList = gVar.field_tagProto.wiJ;
                if (!bo.ek(linkedList)) {
                    for (String append : linkedList) {
                        stringBuilder.append(append).append(";");
                    }
                }
                abh abh = new abh();
                abh.scene = this.scene;
                abh.jSW = this.jSW;
                if (this.mlr != null) {
                    abh.index = i - this.mlr.getHeaderViewsCount();
                } else {
                    abh.index = i;
                }
                abh.query = this.query;
                abh.cvF = str;
                abh.mfg = stringBuilder.toString();
                aVar.a(view, abh);
                ab.d("MicroMsg.FavoriteAdapter", "item click type %s", Integer.valueOf(bVar.mgf.field_type));
            }
            AppMethodBeat.o(74315);
        } else if (bVar.gnD.isChecked() || this.mli.size() < 30) {
            bVar.gnD.setChecked(!bVar.gnD.isChecked());
            AppMethodBeat.o(74315);
        } else {
            ab.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", Integer.valueOf(30));
            com.tencent.mm.ui.base.h.bQ(ah.getContext(), ah.getContext().getResources().getString(R.string.bpm, new Object[]{Integer.valueOf(30)}));
            AppMethodBeat.o(74315);
        }
    }
}

package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class c extends com.tencent.mm.ui.base.sortview.b {
    private int emW;
    protected int gOW;
    protected String jKW;
    protected int jKX;
    private List<a> jLa = new ArrayList();
    private boolean jLb;
    protected boolean jLc;
    protected boolean jLd;
    int jLe;
    protected long[] jLf;
    protected b jLg;

    protected static class a {
        public int count;
        public long ctk;
        public List<mn> elG;
        public int jLh;
        public List<String> jLi;
        public boolean jLj;
        public boolean jLk;
        public List<mh> jLl;

        protected a() {
        }
    }

    public interface b {
        void a(c cVar, com.tencent.mm.ui.base.sortview.a aVar, int i, String str, int i2, int i3);
    }

    public c(Context context) {
        super(context);
        AppMethodBeat.i(13886);
        v(true, true);
        this.jLb = true;
        c(1);
        AppMethodBeat.o(13886);
    }

    public void h(String str, List<mh> list) {
        AppMethodBeat.i(13887);
        this.jLa.clear();
        this.yDr.clear();
        al.d(this.yDs);
        this.emW = 0;
        this.jKW = str;
        if (list != null) {
            this.jLe = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < list.size(); i++) {
                mh mhVar = (mh) list.get(i);
                if (!(mhVar == null || mhVar.naO == null || mhVar.naO.size() <= 0)) {
                    a a = a(mhVar);
                    this.emW += a(a);
                    this.jLa.add(a);
                    ab.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", Long.valueOf(a.ctk), Integer.valueOf(a.count), Integer.valueOf(this.emW));
                }
            }
            aWa();
        }
        al.d(this.yDs);
        AppMethodBeat.o(13887);
    }

    private a a(mh mhVar) {
        AppMethodBeat.i(13888);
        a aVar = new a();
        aVar.jLl = new LinkedList();
        aVar.jLl.add(mhVar);
        aVar.ctk = mhVar.vQd;
        aVar.count = mhVar.naO.size();
        aVar.jLh = mhVar.vQe;
        aVar.elG = new LinkedList();
        aVar.elG.addAll(mhVar.naO);
        aVar.jLi = mhVar.vQf;
        aVar.jLj = this.jLd;
        aVar.jLk = b(aVar);
        AppMethodBeat.o(13888);
        return aVar;
    }

    public void a(mh mhVar, boolean z) {
        AppMethodBeat.i(13889);
        if ((this.jLb && mhVar == null) || mhVar.naO == null) {
            ab.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
            AppMethodBeat.o(13889);
            return;
        }
        if (isEmpty()) {
            this.jLe = (int) (System.currentTimeMillis() / 1000);
        }
        a gD = gD(mhVar.vQd);
        if (gD != null) {
            if (gD.elG == null) {
                gD.elG = new LinkedList();
            }
            gD.elG.addAll(mhVar.naO);
            if (gD.jLl == null) {
                gD.jLl = new LinkedList();
            }
            gD.jLl.add(mhVar);
            gD.count += mhVar.naO.size();
            this.emW += mhVar.naO.size();
        } else if (z) {
            this.jLa.add(a(mhVar));
            aWa();
        } else {
            ab.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", Long.valueOf(mhVar.vQd));
            AppMethodBeat.o(13889);
            return;
        }
        al.d(this.yDs);
        AppMethodBeat.o(13889);
    }

    /* Access modifiers changed, original: final */
    public final a gD(long j) {
        AppMethodBeat.i(13890);
        int gE = gE(j);
        if (gE >= 0) {
            a aVar = (a) this.jLa.get(gE);
            AppMethodBeat.o(13890);
            return aVar;
        }
        AppMethodBeat.o(13890);
        return null;
    }

    private int gE(long j) {
        AppMethodBeat.i(13891);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jLa.size()) {
                AppMethodBeat.o(13891);
                return -1;
            } else if (((a) this.jLa.get(i2)).ctk == j) {
                AppMethodBeat.o(13891);
                return i2;
            } else {
                i = i2 + 1;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a rZ(int i) {
        AppMethodBeat.i(13892);
        if (i >= 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.jLa.size(); i3++) {
                a aVar = (a) this.jLa.get(i3);
                i2 += a(aVar);
                if (i < i2) {
                    AppMethodBeat.o(13892);
                    return aVar;
                }
            }
        }
        AppMethodBeat.o(13892);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final mh sa(int i) {
        int i2 = 0;
        AppMethodBeat.i(13893);
        if (i >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.jLa.size()) {
                a aVar = (a) this.jLa.get(i3);
                int a = a(aVar);
                i4 += a;
                if (i < i4) {
                    i4 = (aVar.jLj ? 1 : 0) + (i4 - a);
                    while (i2 < aVar.jLl.size()) {
                        mh mhVar = (mh) aVar.jLl.get(i2);
                        i4 += mhVar.naO.size();
                        if (i < i4) {
                            AppMethodBeat.o(13893);
                            return mhVar;
                        }
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        AppMethodBeat.o(13893);
        return null;
    }

    private static int a(a aVar) {
        int i = 1;
        if (aVar == null) {
            return 0;
        }
        int i2 = (aVar.jLj ? 1 : 0) + aVar.count;
        if (!aVar.jLk) {
            i = 0;
        }
        return i2 + i;
    }

    private synchronized void aWa() {
        boolean z = true;
        synchronized (this) {
            int i;
            a aVar;
            AppMethodBeat.i(13894);
            HashMap hashMap = new HashMap();
            for (i = 0; i < this.jLa.size(); i++) {
                aVar = (a) this.jLa.get(i);
                if (aVar != null) {
                    hashMap.put(Long.valueOf(aVar.ctk), aVar);
                }
            }
            this.jLa.clear();
            this.emW = 0;
            for (long valueOf : this.jLf) {
                aVar = (a) hashMap.get(Long.valueOf(valueOf));
                if (aVar != null) {
                    this.jLa.add(aVar);
                    this.emW = a(aVar) + this.emW;
                }
            }
            if (this.jLa.size() > 0) {
                aVar = (a) this.jLa.get(this.jLa.size() - 1);
                if (aVar.jLk == this.jLb) {
                    this.emW = (aVar.jLk ? -1 : 1) + this.emW;
                    if (this.jLb) {
                        z = false;
                    }
                    aVar.jLk = z;
                }
            }
            hashMap.clear();
            AppMethodBeat.o(13894);
        }
    }

    private boolean b(a aVar) {
        return this.jLc && aVar.jLh != 0;
    }

    public final void v(boolean z, boolean z2) {
        this.jLd = z;
        this.jLc = z2;
    }

    public final void setScene(int i) {
        this.gOW = i;
    }

    public final void setAddContactScene(int i) {
        this.jKX = i;
    }

    public final void c(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.jLf = jArr;
        }
    }

    public int getCount() {
        return this.emW;
    }

    public void aWb() {
        AppMethodBeat.i(13895);
        h(null, null);
        this.jLe = 0;
        AppMethodBeat.o(13895);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final com.tencent.mm.ui.base.sortview.a sb(int i) {
        com.tencent.mm.ui.base.sortview.a eVar;
        int i2 = 0;
        AppMethodBeat.i(13896);
        int i3 = 0;
        for (int i4 = 0; i4 < this.jLa.size(); i4++) {
            a aVar = (a) this.jLa.get(i4);
            int a = a(aVar);
            i3 += a;
            if (aVar.jLj && i == i3 - a) {
                mh mhVar = aVar.jLl.size() == 0 ? null : (mh) aVar.jLl.get(0);
                if (mhVar != null) {
                    d dVar = new d(mhVar.Title);
                    AppMethodBeat.o(13896);
                    return dVar;
                }
            } else if (aVar.jLk && i == i3 - 1) {
                eVar = new e(aVar.ctk, aVar.count, this.jKW);
                AppMethodBeat.o(13896);
                return eVar;
            } else if (i < i3) {
                i4 = (i - i3) + aVar.count;
                if (aVar.jLk) {
                    i2 = 1;
                }
                i2 += i4;
                mn mnVar = (mn) aVar.elG.get(i2);
                long j = aVar.ctk;
                b bVar = this.jLg;
                if (mnVar == null) {
                    ab.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                    AppMethodBeat.o(13896);
                    return null;
                }
                if (j == 1) {
                    ab.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                    eVar = new a(mnVar);
                } else if (j == 4) {
                    eVar = new g(mnVar);
                } else if (j == 1073741824) {
                    eVar = new g(mnVar);
                } else {
                    eVar = new g(mnVar);
                }
                if (eVar instanceof com.tencent.mm.plugin.brandservice.ui.base.a) {
                    com.tencent.mm.plugin.brandservice.ui.base.a aVar2 = (com.tencent.mm.plugin.brandservice.ui.base.a) eVar;
                    aVar2.sf(i2);
                    aVar2.setPosition(i);
                    aVar2.setReporter(bVar);
                }
                AppMethodBeat.o(13896);
                return eVar;
            }
        }
        eVar = new g(null);
        AppMethodBeat.o(13896);
        return eVar;
    }

    public Object[] sc(int i) {
        Object obj;
        AppMethodBeat.i(13897);
        a rZ = rZ(i);
        mh sa = sa(i);
        if (sa != null) {
            obj = sa.vQg;
        } else {
            String obj2 = "";
        }
        if (rZ != null) {
            Object[] objArr = new Object[]{this, rZ.jLi, Integer.valueOf(this.jKX), obj2};
            AppMethodBeat.o(13897);
            return objArr;
        }
        AppMethodBeat.o(13897);
        return null;
    }

    public final void setReporter(b bVar) {
        this.jLg = bVar;
    }
}

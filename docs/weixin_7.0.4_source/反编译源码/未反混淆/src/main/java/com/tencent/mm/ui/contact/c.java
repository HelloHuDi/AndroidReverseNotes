package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends o implements b {
    private Cursor gnQ;
    private int pUv;
    private a zkH;
    private int zkI;
    private int zkJ;
    private int zkK;
    private int zkL;
    private int zkM;
    private int zkN;
    private HashMap<String, Integer> zkO;
    private SparseArray<String> zkP;

    public static class a {
        public String zjx = "@all.contact.without.chatroom";
        public boolean zkQ = false;
        public boolean zkR = false;
        public boolean zkS = false;
        public boolean zkT = false;
        public boolean zkU = false;
        public boolean zkV = false;
        public String zkW;
        public String zkX;
        public boolean zkY = false;
        public String zkZ = "";
        public String zla = "";
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, a aVar, boolean z3) {
        super((l) mMBaseSelectContactUI, (List) list, z, z2, z3);
        AppMethodBeat.i(105190);
        this.zkI = BaseClientBuilder.API_PRIORITY_OTHER;
        this.pUv = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkM = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkN = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkO = null;
        this.zkP = null;
        ab.i("MicroMsg.AlphabetContactAdapter", "create!");
        if (aVar != null) {
            this.zkH = aVar;
        } else {
            this.zkH = new a();
        }
        g.RQ();
        ((j) g.K(j.class)).XM().a(this);
        Km();
        AppMethodBeat.o(105190);
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, a aVar) {
        this(mMBaseSelectContactUI, list, true, z, aVar, false);
    }

    private void Km() {
        AppMethodBeat.i(105191);
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        this.zkI = BaseClientBuilder.API_PRIORITY_OTHER;
        this.pUv = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zkN = BaseClientBuilder.API_PRIORITY_OTHER;
        if (this.zkO != null) {
            this.zkO.clear();
        } else {
            this.zkO = new HashMap();
        }
        if (this.zkP != null) {
            this.zkP.clear();
        } else {
            this.zkP = new SparseArray();
        }
        ArrayList arrayList = new ArrayList();
        int count;
        int i;
        Object eB;
        String[] W;
        if (this.zkH.zkU) {
            g.RQ();
            Cursor k = ((j) g.K(j.class)).XM().k(bo.P(this.zkH.zkX.split(",")), false);
            arrayList.add(k);
            count = k.getCount();
            ab.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", Integer.valueOf(count));
            if (count > 0) {
                this.zkN = 0;
                count = (count + 1) + 0;
                bM(this.zkN, "☆");
                i = count;
            } else {
                this.zkN = BaseClientBuilder.API_PRIORITY_OTHER;
                i = 0;
            }
            if (this.zkH.zjx == "@all.contact.without.chatroom.without.openim.without.openimfavour") {
                g.RQ();
                eB = ((j) g.K(j.class)).XM().eB(bo.P(this.zkH.zkW.split(",")));
            } else {
                g.RQ();
                eB = ((j) g.K(j.class)).XM().eA(bo.P(this.zkH.zkW.split(",")));
            }
            arrayList.add(eB);
            count = eB.getCount();
            if (count > 0) {
                this.zkJ = i;
                i += count + 1;
                bM(this.zkJ, "☆");
            } else {
                this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
            }
            ArrayList P = bo.P(this.zkH.zkW.split(","));
            g.RQ();
            arrayList.add(((j) g.K(j.class)).XM().k(P, true));
            W = t.W(P);
            int[] V = t.V(P);
            if (!(W == null || V == null)) {
                for (count = 0; count < W.length; count++) {
                    if (count < V.length) {
                        bM(V[count] + i, W[count]);
                        i++;
                    }
                }
                k.getCount();
            }
        } else {
            Cursor ew;
            if (this.zkH.zkV) {
                this.zkM = 0;
                bM(this.zkM, "nonLimit");
                i = 1;
            } else {
                i = 0;
            }
            if (this.zkH.zkY && this.zkH.zkZ != null && !bo.isNullOrNil(this.zkH.zkZ)) {
                ArrayList P2 = bo.P(this.zkH.zkZ.split(";"));
                g.RQ();
                ew = ((j) g.K(j.class)).XM().ew(P2);
                arrayList.add(ew);
                count = ew.getCount();
                if (count > 0) {
                    this.zkI = i;
                    i += count + 1;
                    bM(this.zkI, "↑");
                } else {
                    this.zkI = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            } else if (this.zkH.zkQ) {
                ew = g.fm(this.elZ);
                arrayList.add(ew);
                count = ew.getCount();
                if (count > 0) {
                    this.pUv = i;
                    i += count + 1;
                    bM(this.pUv, "↑");
                } else {
                    this.pUv = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            if (this.zkH.zkR) {
                if (this.zkH.zjx == "@all.contact.without.chatroom.without.openim.without.openimfavour") {
                    g.RQ();
                    eB = ((j) g.K(j.class)).XM().eD(this.elZ);
                } else {
                    g.RQ();
                    eB = ((j) g.K(j.class)).XM().eC(this.elZ);
                }
                arrayList.add(eB);
                count = eB.getCount();
                if (count > 0) {
                    this.zkJ = i;
                    i += count + 1;
                    bM(this.zkJ, "☆");
                } else {
                    this.zkJ = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            g.RQ();
            Cursor b = ((j) g.K(j.class)).XM().b(this.zkH.zjx, "", this.elZ);
            arrayList.add(b);
            W = t.a(this.zkH.zjx, "", "", this.elZ);
            int[] a = t.a(this.zkH.zjx, "", this.elZ, "");
            if (!(W == null || a == null)) {
                int i2 = i;
                for (count = 0; count < W.length; count++) {
                    if (count < a.length) {
                        bM(a[count] + i2, W[count]);
                        i2++;
                    }
                }
                i += b.getCount() + W.length;
            }
            if (this.zkH.zkS) {
                g.RQ();
                ew = ((j) g.K(j.class)).XM().c("@all.chatroom.contact", "", this.elZ);
                arrayList.add(ew);
                count = ew.getCount();
                if (count > 0) {
                    this.zkK = i;
                    i += count + 1;
                    bM(this.zkK, this.zmV.getActivity().getString(R.string.dl));
                } else {
                    this.zkK = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            if (this.zkH.zkT) {
                g.RQ();
                ew = ((j) g.K(j.class)).XM().c("@verify.contact", "", this.elZ);
                arrayList.add(ew);
                if (ew.getCount() > 0) {
                    this.zkL = i;
                    bM(this.zkL, this.zmV.getActivity().getString(R.string.e1p));
                } else {
                    this.zkL = BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
        }
        ab.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", this.zkO.toString());
        this.gnQ = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(105191);
    }

    private void bM(int i, String str) {
        AppMethodBeat.i(105192);
        this.zkO.put(str, Integer.valueOf(i));
        this.zkP.put(i, str);
        AppMethodBeat.o(105192);
    }

    public final int arM(String str) {
        AppMethodBeat.i(105193);
        if (str.equals("↑")) {
            AppMethodBeat.o(105193);
            return 0;
        } else if (this.zkO == null) {
            AppMethodBeat.o(105193);
            return -1;
        } else if (this.zkO.containsKey(str)) {
            int intValue = ((Integer) this.zkO.get(str)).intValue() + this.zmV.getContentLV().getHeaderViewsCount();
            AppMethodBeat.o(105193);
            return intValue;
        } else {
            AppMethodBeat.o(105193);
            return -1;
        }
    }

    public final int getCount() {
        AppMethodBeat.i(105194);
        int size = (this.zkO == null ? 0 : this.zkO.size()) + this.gnQ.getCount();
        AppMethodBeat.o(105194);
        return size;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(105195);
        com.tencent.mm.ui.contact.a.a bN;
        if (i == this.zkN) {
            bN = bN(i, this.zmV.getActivity().getString(R.string.e1r));
            AppMethodBeat.o(105195);
            return bN;
        } else if (i == this.zkI) {
            bN = bN(i, this.zkH.zla);
            AppMethodBeat.o(105195);
            return bN;
        } else if (i == this.pUv) {
            bN = bN(i, this.zmV.getActivity().getString(R.string.e1j));
            AppMethodBeat.o(105195);
            return bN;
        } else if (i == this.zkJ) {
            bN = bN(i, this.zmV.getActivity().getString(R.string.e1d));
            AppMethodBeat.o(105195);
            return bN;
        } else if (i == this.zkK) {
            bN = bN(i, this.zmV.getActivity().getString(R.string.dl));
            AppMethodBeat.o(105195);
            return bN;
        } else if (i == this.zkL) {
            bN = bN(i, this.zmV.getActivity().getString(R.string.e1p));
            AppMethodBeat.o(105195);
            return bN;
        } else if (i == this.zkM) {
            bN = new k(i);
            AppMethodBeat.o(105195);
            return bN;
        } else if (this.zkP.indexOfKey(i) >= 0) {
            bN = bN(i, (String) this.zkP.get(i));
            AppMethodBeat.o(105195);
            return bN;
        } else {
            int i2 = i;
            int i3 = 0;
            while (i3 <= this.zkP.size()) {
                if (this.zkP.indexOfKey(i2) >= 0) {
                    i3++;
                }
                i2--;
                if (i2 < 0) {
                    break;
                }
            }
            if (this.gnQ.moveToPosition(i - i3)) {
                ab.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
                ad adVar = new ad();
                adVar.d(this.gnQ);
                bN = new e(i);
                bN.ehM = adVar;
                bN.zmW = clI();
                bN.zmX = this.zmX;
                AppMethodBeat.o(105195);
                return bN;
            }
            ab.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
            AppMethodBeat.o(105195);
            return null;
        }
    }

    private static com.tencent.mm.ui.contact.a.a bN(int i, String str) {
        AppMethodBeat.i(105196);
        h hVar = new h(i);
        hVar.mKQ = str;
        AppMethodBeat.o(105196);
        return hVar;
    }

    public final void finish() {
        AppMethodBeat.i(105197);
        super.finish();
        ab.i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        g.RQ();
        ((j) g.K(j.class)).XM().b(this);
        AppMethodBeat.o(105197);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(105198);
        Km();
        notifyDataSetChanged();
        AppMethodBeat.o(105198);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(105199);
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.zkN, this.zkI, this.pUv, this.zkJ, this.zkK, this.zkL};
        for (int i2 = 0; i2 < 6; i2++) {
            if (i == iArr[i2]) {
                AppMethodBeat.o(105199);
                return true;
            }
        }
        if (this.zkP.indexOfKey(i) >= 0) {
            AppMethodBeat.o(105199);
            return true;
        }
        AppMethodBeat.o(105199);
        return false;
    }
}

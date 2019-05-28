package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends BaseAdapter {
    public static int MAX_COUNT = 44;
    public static int vkC = 5;
    private boolean cEH;
    private List<String> cFX = new ArrayList();
    u eih;
    boolean ekq;
    private com.tencent.mm.at.a.a.c elH = null;
    private Context mContext;
    boolean mgP = false;
    private List<ad> sBb = new ArrayList();
    private String username;
    a vkD;
    private ArrayList<ad> vkE = new ArrayList();
    boolean vkF = false;
    boolean vkG = false;
    private List<Object> vkH = new ArrayList();
    int vkI = 0;
    int vkJ = 0;
    d vkK;
    public boolean vkL = false;
    public boolean vkM = false;
    public boolean vkN = false;
    private boolean vkO = true;
    boolean vkP = false;
    int vkQ = 12;
    String vkR;
    private final int vkS;
    public boolean vkT = false;
    private boolean vkU = true;
    boolean vkV = true;
    public boolean vkW = false;

    class b {
        public int order;
        public Object vkY;

        public b(Object obj, int i) {
            this.vkY = obj;
            this.order = i;
        }
    }

    class c {
        public ImageView ejo;
        public TextView ejp;
        public TextView elJ;
        public TextView elK;
        public ImageView iYg;
        public int klY;
        public ImageView qpr;
        public ImageView vkZ;

        c() {
        }
    }

    public interface a {
        void dfM();
    }

    public j(Context context) {
        AppMethodBeat.i(79744);
        this.mContext = context;
        this.ekq = false;
        this.vkS = context.getResources().getDimensionPixelSize(R.dimen.f15do);
        AppMethodBeat.o(79744);
    }

    private void djA() {
        AppMethodBeat.i(79745);
        if (this.mgP && com.tencent.mm.pluginsdk.ui.applet.p.a.vlj != null) {
            this.elH = com.tencent.mm.pluginsdk.ui.applet.p.a.vlj.ajA(this.username);
        }
        AppMethodBeat.o(79745);
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(79746);
        this.username = str;
        this.cEH = t.kH(str);
        if (!(this.cEH || com.tencent.mm.pluginsdk.ui.applet.p.a.vlj == null)) {
            this.mgP = com.tencent.mm.pluginsdk.ui.applet.p.a.vlj.ajy(str);
        }
        if (!this.mgP) {
            this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(str);
        }
        djA();
        AppMethodBeat.o(79746);
    }

    public final boolean djB() {
        AppMethodBeat.i(79747);
        boolean z;
        if (this.mgP) {
            z = this.vkG;
            AppMethodBeat.o(79747);
            return z;
        }
        z = t.kH(this.username);
        AppMethodBeat.o(79747);
        return z;
    }

    /* renamed from: do */
    public final void m9do(List<String> list) {
        this.vkO = true;
        this.cFX = list;
    }

    public final void ah(ArrayList<ad> arrayList) {
        this.vkO = false;
        this.vkE = arrayList;
    }

    public final void Kh() {
        AppMethodBeat.i(79748);
        if (this.cFX == null && this.vkE == null) {
            AppMethodBeat.o(79748);
            return;
        }
        if (!this.vkO) {
            djC();
        } else if (this.cFX != null) {
            ab.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", Integer.valueOf(this.cFX.size()));
            this.sBb.clear();
            this.vkH.clear();
            LinkedList linkedList = new LinkedList();
            if (this.cFX.size() > 0) {
                int i = 1;
                for (String str : this.cFX) {
                    if (this.mgP) {
                        this.vkH.add(com.tencent.mm.pluginsdk.ui.applet.p.a.vlj.ajz(str));
                    } else {
                        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
                        if (this.eih != null && str.equals(this.eih.field_roomowner)) {
                            linkedList.add(new b(aoO, 0));
                        } else if (this.eih == null || !this.eih.aoo(aoO.field_username)) {
                            linkedList.add(new b(aoO, 100));
                        } else {
                            linkedList.add(new b(aoO, i));
                            i++;
                        }
                    }
                }
                if (this.vkU) {
                    Collections.sort(linkedList, new Comparator<b>() {
                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((b) obj).order - ((b) obj2).order;
                        }
                    });
                }
                if (!this.mgP) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.sBb.add((ad) ((b) it.next()).vkY);
                    }
                }
            }
            if (this.mgP) {
                this.vkJ = this.vkH.size();
            } else if (!this.cEH) {
                this.vkJ = this.sBb.size();
            } else if (this.eih == null || this.eih.JR()) {
                this.vkJ = this.sBb.size() >= MAX_COUNT + -1 ? MAX_COUNT - 1 : this.sBb.size();
            } else {
                this.vkJ = this.sBb.size() >= MAX_COUNT ? MAX_COUNT : this.sBb.size();
            }
        }
        if (this.vkJ == 0) {
            this.vkI = vkC;
        } else if (this.vkM && this.vkL && this.vkN) {
            this.vkI = (((this.vkJ + 2) / vkC) + 1) * vkC;
        } else if ((this.vkM && this.vkL && !this.vkN) || ((this.vkM && !this.vkL && this.vkN) || (!this.vkM && this.vkL && this.vkN))) {
            this.vkI = (((this.vkJ + 1) / vkC) + 1) * vkC;
        } else if ((this.vkM && !this.vkL && !this.vkN) || ((!this.vkM && this.vkL && !this.vkN) || (!this.vkM && !this.vkL && this.vkN))) {
            this.vkI = ((this.vkJ / vkC) + 1) * vkC;
        } else if (!(this.vkM || this.vkL || this.vkN)) {
            this.vkI = (((this.vkJ - 1) / vkC) + 1) * vkC;
        }
        ab.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.vkJ + " realySize : " + this.vkI);
        dfM();
        AppMethodBeat.o(79748);
    }

    private void djC() {
        AppMethodBeat.i(79749);
        if (this.vkE == null) {
            AppMethodBeat.o(79749);
            return;
        }
        ab.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", Integer.valueOf(this.vkE.size()));
        this.sBb.clear();
        if (this.vkE.size() > 0) {
            Iterator it = this.vkE.iterator();
            while (it.hasNext()) {
                this.sBb.add((ad) it.next());
            }
        }
        this.vkJ = this.sBb.size();
        AppMethodBeat.o(79749);
    }

    private void KV(int i) {
        AppMethodBeat.i(79751);
        if (i < this.vkJ) {
            this.ekq = true;
            dfM();
        }
        AppMethodBeat.o(79751);
    }

    private void dfM() {
        AppMethodBeat.i(79752);
        if (this.vkD != null) {
            this.vkD.dfM();
        }
        AppMethodBeat.o(79752);
    }

    private c ew(View view) {
        AppMethodBeat.i(79753);
        c cVar = new c();
        cVar.vkZ = (ImageView) view.findViewById(R.id.av5);
        cVar.ejo = (ImageView) view.findViewById(R.id.e3x);
        cVar.qpr = (ImageView) view.findViewById(R.id.e3y);
        cVar.ejp = (TextView) view.findViewById(R.id.e41);
        cVar.elJ = (TextView) view.findViewById(R.id.e42);
        cVar.elK = (TextView) view.findViewById(R.id.e43);
        cVar.iYg = (ImageView) view.findViewById(R.id.e3z);
        cVar.ejo.setScaleType(ScaleType.CENTER_CROP);
        view.setTag(cVar);
        AppMethodBeat.o(79753);
        return cVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object item;
        ap apVar;
        int i2;
        c ew;
        int dimensionPixelSize;
        AppMethodBeat.i(79754);
        if (i < this.vkJ) {
            if (this.mgP) {
                item = getItem(i);
                apVar = null;
                i2 = 0;
            } else {
                item = null;
                apVar = (ad) getItem(i);
                i2 = 0;
            }
        } else if (i == this.vkJ && this.vkM) {
            item = null;
            apVar = null;
            i2 = 3;
        } else if (i == this.vkJ + 1 && this.vkL) {
            item = null;
            apVar = null;
            i2 = 4;
        } else if (i == this.vkJ + 1 && this.vkN && !this.vkL) {
            item = null;
            apVar = null;
            i2 = 5;
        } else if (i == this.vkJ + 2 && this.vkN && this.vkL) {
            item = null;
            apVar = null;
            i2 = 5;
        } else {
            item = null;
            apVar = null;
            i2 = 2;
        }
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.ap0, null);
            ew = ew(view);
        } else {
            c cVar = (c) view.getTag();
            if (cVar == null) {
                ew = ew(view);
            } else {
                ew = cVar;
            }
        }
        if (vkC == 4 || this.vkW) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ly);
            ew.ejo.getLayoutParams().height = dimensionPixelSize;
            ew.ejo.getLayoutParams().width = dimensionPixelSize;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.lw);
            ew.ejo.getLayoutParams().height = dimensionPixelSize;
            ew.ejo.getLayoutParams().width = dimensionPixelSize;
        }
        ew.vkZ.setVisibility(8);
        ew.elK.setVisibility(8);
        TextView textView;
        if (i2 == 0) {
            String str;
            CharSequence mJ;
            ew.ejo.setVisibility(0);
            if (this.cEH) {
                if (bo.isNullOrNil(apVar.field_conRemark)) {
                    str = apVar.field_username;
                    if (this.eih == null) {
                        Object mJ2 = null;
                    } else {
                        mJ2 = this.eih.mJ(str);
                    }
                } else {
                    mJ2 = apVar.field_conRemark;
                }
                if (bo.isNullOrNil(mJ2)) {
                    mJ2 = apVar.field_conRemark;
                }
                if (bo.isNullOrNil(mJ2)) {
                    mJ2 = apVar.Oi();
                }
                mJ2 = com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, mJ2, ew.ejp.getTextSize());
            } else if (this.mgP) {
                mJ2 = com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, com.tencent.mm.pluginsdk.ui.applet.p.a.vlj.cu(item), ew.ejp.getTextSize());
            } else if (ad.aox(apVar.field_username)) {
                mJ2 = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).e(ah.getContext(), apVar.Oj(), (int) ew.ejp.getTextSize());
            } else {
                mJ2 = com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, apVar.Oj(), ew.ejp.getTextSize());
            }
            if (mJ2 instanceof SpannableString) {
                ew.ejp.setVisibility(8);
                ew.elJ.setVisibility(0);
                ew.elJ.setText(mJ2);
            } else {
                ew.ejp.setVisibility(0);
                ew.elJ.setVisibility(8);
                ew.ejp.setText(mJ2);
            }
            str = com.tencent.mm.openim.room.a.a.A(apVar);
            if (TextUtils.isEmpty(str)) {
                ew.elK.setVisibility(8);
            } else {
                ew.elK.setVisibility(0);
                ew.elK.setText(str);
            }
            ew.ejo.setContentDescription("");
            if (this.mgP) {
                o.ahp().a(com.tencent.mm.pluginsdk.ui.applet.p.a.vlj.cv(item), ew.ejo, this.elH);
                ew.ejo.setBackgroundDrawable(null);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(ew.ejo, apVar.field_username);
                com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) ew.ejo.getDrawable();
                if (this.vkK != null) {
                    this.vkK.a(aVar);
                }
            }
            if (this.mgP) {
                if (!this.ekq || (this.vkR != null && this.vkR.equals(com.tencent.mm.pluginsdk.ui.applet.p.a.vlj.cw(item)))) {
                    ew.qpr.setVisibility(8);
                } else {
                    ew.qpr.setVisibility(0);
                }
            } else if (!this.ekq || (this.vkR != null && this.vkR.equals(apVar.field_username))) {
                ew.qpr.setVisibility(8);
            } else {
                ew.qpr.setVisibility(0);
            }
        } else if (i2 == 3) {
            ew.ejp.setVisibility(i == 0 ? 8 : 4);
            textView = ew.elJ;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            ew.qpr.setVisibility(8);
            if (this.ekq) {
                ew.ejo.setVisibility(4);
            } else {
                ew.ejo.setVisibility(0);
                if (this.mgP) {
                    o.ahp().a("", ew.ejo, this.elH);
                    ew.ejo.setBackgroundDrawable(null);
                }
                ew.ejo.setImageResource(R.drawable.e4);
                ew.ejo.setContentDescription(this.mContext.getString(R.string.d0));
            }
        } else if (i2 == 4) {
            ew.ejp.setVisibility(1 == i ? 8 : 4);
            textView = ew.elJ;
            if (1 == i) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            ew.qpr.setVisibility(8);
            if (this.ekq || this.vkJ == 0) {
                ew.ejo.setVisibility(4);
            } else {
                ew.ejo.setVisibility(0);
                if (this.mgP) {
                    o.ahp().a("", ew.ejo, this.elH);
                    ew.ejo.setBackgroundDrawable(null);
                }
                ew.ejo.setImageResource(R.drawable.e5);
                ew.ejo.setContentDescription(this.mContext.getString(R.string.b52));
            }
        } else if (i2 == 5) {
            textView = ew.ejp;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            textView = ew.elJ;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            ew.qpr.setVisibility(8);
            if (this.ekq) {
                ew.ejo.setVisibility(4);
            } else {
                ew.ejo.setVisibility(0);
                if (this.mgP) {
                    o.ahp().a("", ew.ejo, this.elH);
                    ew.ejo.setBackgroundDrawable(null);
                }
                ew.ejo.setImageResource(R.drawable.e6);
                ew.ejo.setContentDescription(this.mContext.getString(R.string.d1j));
            }
        } else if (i2 == 2) {
            if (this.mgP) {
                o.ahp().a("", ew.ejo, this.elH);
            }
            ew.ejp.setVisibility(4);
            ew.elJ.setVisibility(4);
            ew.qpr.setVisibility(8);
            ew.ejo.setVisibility(4);
            ew.ejo.setImageResource(R.drawable.uv);
            ew.ejo.setBackgroundResource(R.drawable.uv);
        }
        if (!this.mgP || item == null) {
            ew.iYg.setVisibility(8);
        }
        ew.klY = i2;
        AppMethodBeat.o(79754);
        return view;
    }

    public final boolean KW(int i) {
        return i < this.vkJ;
    }

    public final void djD() {
        AppMethodBeat.i(79755);
        this.ekq = false;
        Kh();
        AppMethodBeat.o(79755);
    }

    public final void ci(List<String> list) {
        AppMethodBeat.i(79756);
        m9do(list);
        Kh();
        AppMethodBeat.o(79756);
    }

    public final int getCount() {
        AppMethodBeat.i(79757);
        int min;
        if (this.vkP) {
            min = Math.min(this.vkQ, this.vkI);
            AppMethodBeat.o(79757);
            return min;
        }
        min = this.vkI;
        AppMethodBeat.o(79757);
        return min;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(79758);
        Object obj;
        if (i >= this.vkJ) {
            AppMethodBeat.o(79758);
            return null;
        } else if (this.mgP) {
            obj = this.vkH.get(i);
            AppMethodBeat.o(79758);
            return obj;
        } else {
            obj = this.sBb.get(i);
            AppMethodBeat.o(79758);
            return obj;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean KU(int i) {
        AppMethodBeat.i(79750);
        if (this.ekq) {
            AppMethodBeat.o(79750);
            return false;
        }
        KV(i);
        AppMethodBeat.o(79750);
        return true;
    }
}

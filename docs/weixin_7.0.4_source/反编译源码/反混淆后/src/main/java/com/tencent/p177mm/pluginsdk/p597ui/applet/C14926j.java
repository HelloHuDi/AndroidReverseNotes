package com.tencent.p177mm.pluginsdk.p597ui.applet;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C46502p.C35851a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.j */
public final class C14926j extends BaseAdapter {
    public static int MAX_COUNT = 44;
    public static int vkC = 5;
    private boolean cEH;
    private List<String> cFX = new ArrayList();
    C7577u eih;
    boolean ekq;
    private C25814c elH = null;
    private Context mContext;
    boolean mgP = false;
    private List<C7616ad> sBb = new ArrayList();
    private String username;
    C14928a vkD;
    private ArrayList<C7616ad> vkE = new ArrayList();
    boolean vkF = false;
    boolean vkG = false;
    private List<Object> vkH = new ArrayList();
    int vkI = 0;
    int vkJ = 0;
    C14943d vkK;
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

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.j$b */
    class C4742b {
        public int order;
        public Object vkY;

        public C4742b(Object obj, int i) {
            this.vkY = obj;
            this.order = i;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.j$c */
    class C4743c {
        public ImageView ejo;
        public TextView ejp;
        public TextView elJ;
        public TextView elK;
        public ImageView iYg;
        public int klY;
        public ImageView qpr;
        public ImageView vkZ;

        C4743c() {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.j$1 */
    class C149271 implements Comparator<C4742b> {
        C149271() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C4742b) obj).order - ((C4742b) obj2).order;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.j$a */
    public interface C14928a {
        void dfM();
    }

    public C14926j(Context context) {
        AppMethodBeat.m2504i(79744);
        this.mContext = context;
        this.ekq = false;
        this.vkS = context.getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
        AppMethodBeat.m2505o(79744);
    }

    private void djA() {
        AppMethodBeat.m2504i(79745);
        if (this.mgP && C35851a.vlj != null) {
            this.elH = C35851a.vlj.ajA(this.username);
        }
        AppMethodBeat.m2505o(79745);
    }

    public final void setUsername(String str) {
        AppMethodBeat.m2504i(79746);
        this.username = str;
        this.cEH = C1855t.m3896kH(str);
        if (!(this.cEH || C35851a.vlj == null)) {
            this.mgP = C35851a.vlj.ajy(str);
        }
        if (!this.mgP) {
            this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        }
        djA();
        AppMethodBeat.m2505o(79746);
    }

    public final boolean djB() {
        AppMethodBeat.m2504i(79747);
        boolean z;
        if (this.mgP) {
            z = this.vkG;
            AppMethodBeat.m2505o(79747);
            return z;
        }
        z = C1855t.m3896kH(this.username);
        AppMethodBeat.m2505o(79747);
        return z;
    }

    /* renamed from: do */
    public final void mo27258do(List<String> list) {
        this.vkO = true;
        this.cFX = list;
    }

    /* renamed from: ah */
    public final void mo27254ah(ArrayList<C7616ad> arrayList) {
        this.vkO = false;
        this.vkE = arrayList;
    }

    /* renamed from: Kh */
    public final void mo27253Kh() {
        AppMethodBeat.m2504i(79748);
        if (this.cFX == null && this.vkE == null) {
            AppMethodBeat.m2505o(79748);
            return;
        }
        if (!this.vkO) {
            djC();
        } else if (this.cFX != null) {
            C4990ab.m7411d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", Integer.valueOf(this.cFX.size()));
            this.sBb.clear();
            this.vkH.clear();
            LinkedList linkedList = new LinkedList();
            if (this.cFX.size() > 0) {
                int i = 1;
                for (String str : this.cFX) {
                    if (this.mgP) {
                        this.vkH.add(C35851a.vlj.ajz(str));
                    } else {
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                        if (this.eih != null && str.equals(this.eih.field_roomowner)) {
                            linkedList.add(new C4742b(aoO, 0));
                        } else if (this.eih == null || !this.eih.aoo(aoO.field_username)) {
                            linkedList.add(new C4742b(aoO, 100));
                        } else {
                            linkedList.add(new C4742b(aoO, i));
                            i++;
                        }
                    }
                }
                if (this.vkU) {
                    Collections.sort(linkedList, new C149271());
                }
                if (!this.mgP) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.sBb.add((C7616ad) ((C4742b) it.next()).vkY);
                    }
                }
            }
            if (this.mgP) {
                this.vkJ = this.vkH.size();
            } else if (!this.cEH) {
                this.vkJ = this.sBb.size();
            } else if (this.eih == null || this.eih.mo16786JR()) {
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
        C4990ab.m7410d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.vkJ + " realySize : " + this.vkI);
        dfM();
        AppMethodBeat.m2505o(79748);
    }

    private void djC() {
        AppMethodBeat.m2504i(79749);
        if (this.vkE == null) {
            AppMethodBeat.m2505o(79749);
            return;
        }
        C4990ab.m7411d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", Integer.valueOf(this.vkE.size()));
        this.sBb.clear();
        if (this.vkE.size() > 0) {
            Iterator it = this.vkE.iterator();
            while (it.hasNext()) {
                this.sBb.add((C7616ad) it.next());
            }
        }
        this.vkJ = this.sBb.size();
        AppMethodBeat.m2505o(79749);
    }

    /* renamed from: KV */
    private void m23204KV(int i) {
        AppMethodBeat.m2504i(79751);
        if (i < this.vkJ) {
            this.ekq = true;
            dfM();
        }
        AppMethodBeat.m2505o(79751);
    }

    private void dfM() {
        AppMethodBeat.m2504i(79752);
        if (this.vkD != null) {
            this.vkD.dfM();
        }
        AppMethodBeat.m2505o(79752);
    }

    /* renamed from: ew */
    private C4743c m23205ew(View view) {
        AppMethodBeat.m2504i(79753);
        C4743c c4743c = new C4743c();
        c4743c.vkZ = (ImageView) view.findViewById(2131822732);
        c4743c.ejo = (ImageView) view.findViewById(2131827163);
        c4743c.qpr = (ImageView) view.findViewById(2131827164);
        c4743c.ejp = (TextView) view.findViewById(2131827167);
        c4743c.elJ = (TextView) view.findViewById(2131827168);
        c4743c.elK = (TextView) view.findViewById(2131827169);
        c4743c.iYg = (ImageView) view.findViewById(2131827165);
        c4743c.ejo.setScaleType(ScaleType.CENTER_CROP);
        view.setTag(c4743c);
        AppMethodBeat.m2505o(79753);
        return c4743c;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object item;
        C6562ap c6562ap;
        int i2;
        C4743c ew;
        int dimensionPixelSize;
        AppMethodBeat.m2504i(79754);
        if (i < this.vkJ) {
            if (this.mgP) {
                item = getItem(i);
                c6562ap = null;
                i2 = 0;
            } else {
                item = null;
                c6562ap = (C7616ad) getItem(i);
                i2 = 0;
            }
        } else if (i == this.vkJ && this.vkM) {
            item = null;
            c6562ap = null;
            i2 = 3;
        } else if (i == this.vkJ + 1 && this.vkL) {
            item = null;
            c6562ap = null;
            i2 = 4;
        } else if (i == this.vkJ + 1 && this.vkN && !this.vkL) {
            item = null;
            c6562ap = null;
            i2 = 5;
        } else if (i == this.vkJ + 2 && this.vkN && this.vkL) {
            item = null;
            c6562ap = null;
            i2 = 5;
        } else {
            item = null;
            c6562ap = null;
            i2 = 2;
        }
        if (view == null) {
            view = View.inflate(this.mContext, 2130970531, null);
            ew = m23205ew(view);
        } else {
            C4743c c4743c = (C4743c) view.getTag();
            if (c4743c == null) {
                ew = m23205ew(view);
            } else {
                ew = c4743c;
            }
        }
        if (vkC == 4 || this.vkW) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9974ly);
            ew.ejo.getLayoutParams().height = dimensionPixelSize;
            ew.ejo.getLayoutParams().width = dimensionPixelSize;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9972lw);
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
                if (C5046bo.isNullOrNil(c6562ap.field_conRemark)) {
                    str = c6562ap.field_username;
                    if (this.eih == null) {
                        Object mJ2 = null;
                    } else {
                        mJ2 = this.eih.mo16807mJ(str);
                    }
                } else {
                    mJ2 = c6562ap.field_conRemark;
                }
                if (C5046bo.isNullOrNil(mJ2)) {
                    mJ2 = c6562ap.field_conRemark;
                }
                if (C5046bo.isNullOrNil(mJ2)) {
                    mJ2 = c6562ap.mo16706Oi();
                }
                mJ2 = C44089j.m79293b(this.mContext, mJ2, ew.ejp.getTextSize());
            } else if (this.mgP) {
                mJ2 = C44089j.m79293b(this.mContext, C35851a.vlj.mo9886cu(item), ew.ejp.getTextSize());
            } else if (C7616ad.aox(c6562ap.field_username)) {
                mJ2 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44308e(C4996ah.getContext(), c6562ap.mo16707Oj(), (int) ew.ejp.getTextSize());
            } else {
                mJ2 = C44089j.m79293b(this.mContext, c6562ap.mo16707Oj(), ew.ejp.getTextSize());
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
            str = C42249a.m74595A(c6562ap);
            if (TextUtils.isEmpty(str)) {
                ew.elK.setVisibility(8);
            } else {
                ew.elK.setVisibility(0);
                ew.elK.setText(str);
            }
            ew.ejo.setContentDescription("");
            if (this.mgP) {
                C32291o.ahp().mo43766a(C35851a.vlj.mo9887cv(item), ew.ejo, this.elH);
                ew.ejo.setBackgroundDrawable(null);
            } else {
                C40460b.m69434b(ew.ejo, c6562ap.field_username);
                C40459a c40459a = (C40459a) ew.ejo.getDrawable();
                if (this.vkK != null) {
                    this.vkK.mo27290a(c40459a);
                }
            }
            if (this.mgP) {
                if (!this.ekq || (this.vkR != null && this.vkR.equals(C35851a.vlj.mo9888cw(item)))) {
                    ew.qpr.setVisibility(8);
                } else {
                    ew.qpr.setVisibility(0);
                }
            } else if (!this.ekq || (this.vkR != null && this.vkR.equals(c6562ap.field_username))) {
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
                    C32291o.ahp().mo43766a("", ew.ejo, this.elH);
                    ew.ejo.setBackgroundDrawable(null);
                }
                ew.ejo.setImageResource(C25738R.drawable.f6436e4);
                ew.ejo.setContentDescription(this.mContext.getString(C25738R.string.f8717d0));
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
                    C32291o.ahp().mo43766a("", ew.ejo, this.elH);
                    ew.ejo.setBackgroundDrawable(null);
                }
                ew.ejo.setImageResource(C25738R.drawable.f6437e5);
                ew.ejo.setContentDescription(this.mContext.getString(C25738R.string.b52));
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
                    C32291o.ahp().mo43766a("", ew.ejo, this.elH);
                    ew.ejo.setBackgroundDrawable(null);
                }
                ew.ejo.setImageResource(C25738R.drawable.f6438e6);
                ew.ejo.setContentDescription(this.mContext.getString(C25738R.string.d1j));
            }
        } else if (i2 == 2) {
            if (this.mgP) {
                C32291o.ahp().mo43766a("", ew.ejo, this.elH);
            }
            ew.ejp.setVisibility(4);
            ew.elJ.setVisibility(4);
            ew.qpr.setVisibility(8);
            ew.ejo.setVisibility(4);
            ew.ejo.setImageResource(C25738R.drawable.f6900uv);
            ew.ejo.setBackgroundResource(C25738R.drawable.f6900uv);
        }
        if (!this.mgP || item == null) {
            ew.iYg.setVisibility(8);
        }
        ew.klY = i2;
        AppMethodBeat.m2505o(79754);
        return view;
    }

    /* renamed from: KW */
    public final boolean mo27252KW(int i) {
        return i < this.vkJ;
    }

    public final void djD() {
        AppMethodBeat.m2504i(79755);
        this.ekq = false;
        mo27253Kh();
        AppMethodBeat.m2505o(79755);
    }

    /* renamed from: ci */
    public final void mo27255ci(List<String> list) {
        AppMethodBeat.m2504i(79756);
        mo27258do(list);
        mo27253Kh();
        AppMethodBeat.m2505o(79756);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(79757);
        int min;
        if (this.vkP) {
            min = Math.min(this.vkQ, this.vkI);
            AppMethodBeat.m2505o(79757);
            return min;
        }
        min = this.vkI;
        AppMethodBeat.m2505o(79757);
        return min;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(79758);
        Object obj;
        if (i >= this.vkJ) {
            AppMethodBeat.m2505o(79758);
            return null;
        } else if (this.mgP) {
            obj = this.vkH.get(i);
            AppMethodBeat.m2505o(79758);
            return obj;
        } else {
            obj = this.sBb.get(i);
            AppMethodBeat.m2505o(79758);
            return obj;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: KU */
    public final boolean mo27251KU(int i) {
        AppMethodBeat.m2504i(79750);
        if (this.ekq) {
            AppMethodBeat.m2505o(79750);
            return false;
        }
        m23204KV(i);
        AppMethodBeat.m2505o(79750);
        return true;
    }
}

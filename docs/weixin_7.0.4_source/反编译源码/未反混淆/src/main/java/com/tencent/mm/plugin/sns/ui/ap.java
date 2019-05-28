package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ap extends com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a {
    public static int[] rtD = new int[]{R.string.ely, R.string.elw, R.string.els, R.string.ell};
    public static int[] rth = new int[]{R.string.elx, R.string.elv, R.string.elr, R.string.elk};
    private Context mContext;
    private LayoutInflater mInflater;
    ArrayList<String> rtE;
    public int rtF = 0;
    public boolean rtG = false;
    public ArrayList<String> rtH = new ArrayList();
    public ArrayList<String> rtI = new ArrayList();
    public ArrayList<String> rtJ = new ArrayList();
    public ArrayList<String> rtK = new ArrayList();
    b rtL = null;
    public int style;

    public interface b {
        void a(c cVar);
    }

    class c {
        public int rtQ;
        public int rtR;

        c() {
        }
    }

    class a {
        TextView nQl;
        ImageView olR;
        TextView rtN;
        TextView rtO;
        ImageView rtP;
        TextView titleView;

        private a() {
        }

        /* synthetic */ a(ap apVar, byte b) {
            this();
        }
    }

    public ap(Context context) {
        AppMethodBeat.i(39050);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        AppMethodBeat.o(39050);
    }

    public final Object getChild(int i, int i2) {
        AppMethodBeat.i(39051);
        Object obj = this.rtE.get(i2);
        AppMethodBeat.o(39051);
        return obj;
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    public final void T(ArrayList<String> arrayList) {
        AppMethodBeat.i(39052);
        List<String> ctC = ctC();
        List arrayList2 = new ArrayList();
        if (!(ctC == null || arrayList == null)) {
            for (String str : ctC) {
                if (h(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            Object c = bo.c(arrayList2, ",");
            g.RQ();
            g.RP().Ry().set(335875, c);
        }
        this.rtE = arrayList;
        AppMethodBeat.o(39052);
    }

    private static List<String> ctC() {
        AppMethodBeat.i(39053);
        g.RQ();
        String str = (String) g.RP().Ry().get(335875, null);
        ab.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(39053);
            return null;
        }
        List<String> P = bo.P(str.split(","));
        AppMethodBeat.o(39053);
        return P;
    }

    public static void ZF(String str) {
        AppMethodBeat.i(39054);
        ab.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", str);
        if (ctC() != null) {
            List arrayList = new ArrayList(ctC());
            if (!h(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                Object c = bo.c(arrayList, ",");
                g.RQ();
                g.RP().Ry().set(335875, c);
            }
            AppMethodBeat.o(39054);
            return;
        }
        g.RQ();
        g.RP().Ry().set(335875, (Object) str);
        AppMethodBeat.o(39054);
    }

    private static boolean h(List<String> list, String str) {
        AppMethodBeat.i(39055);
        for (String equals : list) {
            if (equals.equals(str)) {
                AppMethodBeat.o(39055);
                return true;
            }
        }
        AppMethodBeat.o(39055);
        return false;
    }

    private boolean bg(int i, String str) {
        AppMethodBeat.i(39056);
        boolean h;
        if (i == 1) {
            h = h(this.rtH, str);
            AppMethodBeat.o(39056);
            return h;
        }
        h = h(this.rtI, str);
        AppMethodBeat.o(39056);
        return h;
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(39057);
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.mInflater.inflate(R.layout.avi, null);
            } else {
                inflate = this.mInflater.inflate(R.layout.avh, null);
            }
            a aVar2 = new a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(R.id.eju);
            aVar2.olR = (ImageView) inflate.findViewById(R.id.ejs);
            aVar2.nQl = (TextView) inflate.findViewById(R.id.ejv);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.titleView.setText(rth[i]);
        aVar.nQl.setText(rtD[i]);
        switch (i) {
            case 0:
            case 1:
                if (this.rtF == i) {
                    aVar.olR.setImageResource(R.raw.radio_on);
                    aVar.olR.setContentDescription(this.mContext.getString(R.string.e2_));
                    break;
                }
                aVar.olR.setImageResource(R.raw.radio_off);
                break;
            case 2:
                if (this.rtF == i) {
                    aVar.olR.setImageResource(R.raw.radio_on);
                    aVar.olR.setContentDescription(this.mContext.getString(R.string.e2_));
                    break;
                }
                aVar.olR.setImageResource(R.raw.radio_off);
                break;
            case 3:
                if (this.style != 1) {
                    if (this.rtF == i) {
                        aVar.olR.setImageResource(R.raw.radio_on_red);
                        aVar.olR.setContentDescription(this.mContext.getString(R.string.e2_));
                        break;
                    }
                    aVar.olR.setImageResource(R.raw.radio_off);
                    break;
                } else if (this.rtF == i) {
                    aVar.olR.setImageResource(R.raw.round_selector_checked_orange);
                    aVar.olR.setContentDescription(this.mContext.getString(R.string.e2_));
                    break;
                } else {
                    aVar.olR.setImageResource(R.raw.radio_off);
                    break;
                }
        }
        if (this.rtG && i == 1) {
            view = new View(this.mContext);
            view.setVisibility(8);
            AppMethodBeat.o(39057);
            return view;
        }
        AppMethodBeat.o(39057);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private static List<String> O(List<String> list) {
        AppMethodBeat.i(39058);
        LinkedList linkedList = new LinkedList();
        g.RQ();
        if (!g.RN().QY()) {
            AppMethodBeat.o(39058);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(39058);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                g.RQ();
                ad aoO = ((j) g.K(j.class)).XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.o(39058);
            return linkedList;
        }
    }

    public final View d(int i, int i2, View view) {
        a aVar;
        AppMethodBeat.i(39059);
        if (view == null) {
            View inflate;
            if (this.style == 1) {
                inflate = this.mInflater.inflate(R.layout.avg, null);
            } else {
                inflate = this.mInflater.inflate(R.layout.avf, null);
            }
            a aVar2 = new a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(R.id.eju);
            aVar2.nQl = (TextView) inflate.findViewById(R.id.ejv);
            aVar2.rtN = (TextView) inflate.findViewById(R.id.ejw);
            aVar2.rtO = (TextView) inflate.findViewById(R.id.ejx);
            aVar2.olR = (ImageView) inflate.findViewById(R.id.ejs);
            aVar2.rtP = (ImageView) inflate.findViewById(R.id.ejt);
            aVar2.rtP.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(39049);
                    c cVar = (view.getTag() == null || !(view.getTag() instanceof c)) ? null : (c) view.getTag();
                    if (cVar == null) {
                        ab.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
                        AppMethodBeat.o(39049);
                        return;
                    }
                    if (ap.this.rtL != null) {
                        ap.this.rtL.a(cVar);
                    }
                    AppMethodBeat.o(39049);
                }
            });
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        ImageView imageView = aVar.rtP;
        Object tag = imageView.getTag();
        if (tag == null || !(tag instanceof c)) {
            c cVar = new c();
            cVar.rtQ = i;
            cVar.rtR = i2;
            imageView.setTag(cVar);
        } else {
            c cVar2 = (c) imageView.getTag();
            cVar2.rtQ = i;
            cVar2.rtR = i2;
        }
        if (i2 == this.rtE.size()) {
            aVar.titleView.setVisibility(8);
            aVar.nQl.setVisibility(8);
            aVar.olR.setVisibility(8);
            aVar.rtP.setVisibility(8);
            aVar.rtN.setVisibility(0);
            aVar.rtO.setVisibility(0);
            if (i == 3) {
                if (this.rtK.size() > 0) {
                    aVar.rtO.setText("√".concat(String.valueOf(bo.c(O(this.rtK), ","))));
                    aVar.rtO.setVisibility(0);
                    aVar.rtO.setTextColor(this.mContext.getResources().getColor(R.color.a0z));
                } else {
                    aVar.rtO.setText("");
                    aVar.rtO.setVisibility(8);
                }
            } else if (i == 2) {
                if (this.rtJ.size() > 0) {
                    aVar.rtO.setText("√".concat(String.valueOf(bo.c(O(this.rtJ), ","))));
                    aVar.rtO.setVisibility(0);
                    aVar.rtO.setTextColor(this.mContext.getResources().getColor(R.color.a0y));
                } else {
                    aVar.rtO.setText("");
                    aVar.rtO.setVisibility(8);
                }
            }
        } else {
            CharSequence charSequence;
            aVar.titleView.setVisibility(0);
            aVar.nQl.setVisibility(0);
            aVar.olR.setVisibility(0);
            aVar.rtP.setVisibility(0);
            aVar.rtN.setVisibility(8);
            aVar.rtO.setVisibility(8);
            CharSequence charSequence2 = (String) this.rtE.get(i2);
            aVar.titleView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, charSequence2));
            TextView textView = aVar.nQl;
            List<String> PH = com.tencent.mm.plugin.label.a.a.bJa().PH(com.tencent.mm.plugin.label.a.a.bJa().PE(charSequence2));
            if (PH == null || PH.size() == 0) {
                charSequence = "";
            } else {
                List arrayList = new ArrayList(PH.size());
                for (String mJ : PH) {
                    arrayList.add(((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(mJ));
                }
                charSequence = com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, bo.c(arrayList, ","));
            }
            textView.setText(charSequence);
            aVar.rtP.setImageResource(R.raw.sns_label_more_btn);
            if (this.style == 1) {
                if (i == 2) {
                    if (bg(1, charSequence2)) {
                        aVar.olR.setImageResource(R.raw.sight_list_checkbox_selected);
                    } else {
                        aVar.olR.setImageResource(R.raw.sight_list_checkbox_unselected);
                    }
                } else if (i == 3) {
                    if (this.rtF != i) {
                        aVar.olR.setImageResource(R.raw.sight_list_checkbox_unselected_red);
                    } else {
                        aVar.olR.setImageResource(R.raw.sight_list_checkbox_selected_red);
                    }
                    if (bg(2, charSequence2)) {
                        aVar.olR.setImageResource(R.raw.sight_list_checkbox_selected_red);
                    } else {
                        aVar.olR.setImageResource(R.raw.sight_list_checkbox_unselected_red);
                    }
                }
            } else if (i == 2) {
                if (bg(1, charSequence2)) {
                    aVar.olR.setImageResource(R.raw.checkbox_selected);
                } else {
                    aVar.olR.setImageResource(R.raw.checkbox_unselected);
                }
            } else if (i == 3) {
                if (bg(2, charSequence2)) {
                    aVar.olR.setImageResource(R.raw.checkbox_selected_red);
                } else {
                    aVar.olR.setImageResource(R.raw.checkbox_unselected);
                }
            }
        }
        AppMethodBeat.o(39059);
        return view;
    }

    public final int Ec(int i) {
        AppMethodBeat.i(39060);
        if (i <= 1 || this.rtE == null) {
            AppMethodBeat.o(39060);
            return 0;
        }
        int size = this.rtE.size() + 1;
        AppMethodBeat.o(39060);
        return size;
    }
}

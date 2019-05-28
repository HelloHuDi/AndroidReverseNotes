package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c extends p<com.tencent.mm.plugin.ipcall.a.g.c> implements com.tencent.mm.ah.d.a {
    static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> nzw = null;
    HashMap<String, Integer> emK = new HashMap();
    av gGg = new av();
    private String gtX;
    boolean jLC = false;
    private Context mContext;
    private OnClickListener nAA = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(21995);
            if (view.getTag() instanceof Integer) {
                com.tencent.mm.plugin.ipcall.a.g.c xn = c.this.xn(((Integer) view.getTag()).intValue());
                Intent intent = new Intent(c.this.context, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", xn.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", xn.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", xn.field_wechatUsername);
                c.this.context.startActivity(intent);
            }
            AppMethodBeat.o(21995);
        }
    };
    private d nAw;
    private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> nAx = new HashMap();
    private HashSet<String> nAy = new HashSet();
    private boolean nAz = false;

    class b {
        ImageView eks;
        TextView gtO;
        TextView nAE;
        LinearLayout nAF;
        TextView nAG;
        TextView nAH;
        TextView nAI;
        TextView nAJ;
        ImageView nAK;
        View nAL;
        View nAM;
        View nAN;
        ImageView nAO;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }

    class a {
        String nAC;
        String nAD;

        public a(String str, String str2) {
            this.nAD = str2;
            this.nAC = str;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(22013);
        com.tencent.mm.plugin.ipcall.a.g.c xn = xn(i);
        AppMethodBeat.o(22013);
        return xn;
    }

    public c(Context context) {
        super(context, null);
        AppMethodBeat.i(21997);
        pN(true);
        this.mContext = context;
        this.nAw = new d(context);
        o.acd().a((com.tencent.mm.ah.d.a) this);
        AppMethodBeat.o(21997);
    }

    public final int getCount() {
        AppMethodBeat.i(21998);
        int count = super.getCount();
        AppMethodBeat.o(21998);
        return count;
    }

    public final int bIe() {
        AppMethodBeat.i(21999);
        int count = super.getCount();
        AppMethodBeat.o(21999);
        return count;
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c xn(int i) {
        AppMethodBeat.i(22000);
        com.tencent.mm.plugin.ipcall.a.g.c cVar = (com.tencent.mm.plugin.ipcall.a.g.c) super.getItem(i);
        AppMethodBeat.o(22000);
        return cVar;
    }

    public final void vM(String str) {
        AppMethodBeat.i(22001);
        this.gtX = str;
        if (bo.isNullOrNil(this.gtX)) {
            this.nAz = false;
        } else {
            this.nAz = true;
        }
        this.yld.clear();
        KC();
        notifyDataSetChanged();
        AppMethodBeat.o(22001);
    }

    public final void KC() {
        Cursor OS;
        AppMethodBeat.i(22002);
        if (this.nAz) {
            this.jLC = true;
            OS = i.bHw().OS(this.gtX);
            this.jLC = false;
        } else {
            OS = i.bHw().bHZ();
        }
        if (OS != null) {
            OS.moveToFirst();
        }
        setCursor(OS);
        bIg();
        AppMethodBeat.o(22002);
    }

    public final void bIf() {
        AppMethodBeat.i(22003);
        super.bIf();
        AppMethodBeat.o(22003);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(22005);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.a8t, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.nAM = view.findViewById(R.id.clz);
            bVar.nAN = view.findViewById(R.id.cm0);
            bVar.eks = (ImageView) view.findViewById(R.id.qk);
            bVar.gtO = (TextView) view.findViewById(R.id.b6e);
            bVar.nAE = (TextView) view.findViewById(R.id.ckk);
            bVar.nAF = (LinearLayout) view.findViewById(R.id.cm3);
            bVar.nAG = (TextView) view.findViewById(R.id.cm4);
            bVar.nAH = (TextView) view.findViewById(R.id.cm5);
            bVar.nAI = (TextView) view.findViewById(R.id.cly);
            bVar.nAJ = (TextView) view.findViewById(R.id.clx);
            bVar.nAK = (ImageView) view.findViewById(R.id.cm6);
            bVar.nAL = view.findViewById(R.id.cm2);
            bVar.nAL.setClickable(true);
            bVar.nAO = (ImageView) view.findViewById(R.id.p3);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.nAL.setClickable(true);
        bVar2.nAL.setTag(Integer.valueOf(i));
        bVar2.nAO.setVisibility(8);
        if (wK(i)) {
            bVar2.gtO.setVisibility(8);
            bVar2.nAE.setVisibility(8);
            bVar2.nAF.setVisibility(8);
            bVar2.eks.setVisibility(8);
            bVar2.eks.setTag(null);
            bVar2.nAJ.setVisibility(8);
            bVar2.nAI.setVisibility(8);
            bVar2.nAK.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.a.g.c xn = xn(i);
            if (xn != null) {
                String str;
                if (bo.isNullOrNil(xn.field_systemAddressBookUsername)) {
                    bVar2.gtO.setVisibility(8);
                    bVar2.nAE.setVisibility(8);
                } else {
                    bVar2.gtO.setVisibility(0);
                    LayoutParams layoutParams;
                    RelativeLayout.LayoutParams layoutParams2;
                    if (this.nAz) {
                        bVar2.nAE.setVisibility(0);
                        layoutParams = (LayoutParams) bVar2.nAM.getLayoutParams();
                        layoutParams.height = (int) bVar2.nAE.getContext().getResources().getDimension(R.dimen.abc);
                        bVar2.nAM.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.eks.getLayoutParams();
                        layoutParams2.height = (int) bVar2.eks.getContext().getResources().getDimension(R.dimen.b7);
                        layoutParams2.width = (int) bVar2.eks.getContext().getResources().getDimension(R.dimen.b7);
                        bVar2.eks.setLayoutParams(layoutParams2);
                    } else {
                        bVar2.nAE.setVisibility(8);
                        layoutParams = (LayoutParams) bVar2.nAM.getLayoutParams();
                        layoutParams.height = (int) bVar2.nAE.getContext().getResources().getDimension(R.dimen.b8);
                        bVar2.nAM.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.eks.getLayoutParams();
                        layoutParams2.height = (int) bVar2.eks.getContext().getResources().getDimension(R.dimen.aba);
                        layoutParams2.width = (int) bVar2.eks.getContext().getResources().getDimension(R.dimen.aba);
                        bVar2.eks.setLayoutParams(layoutParams2);
                    }
                    if (this.nAz && xn.nzx == null && nzw != null && nzw.containsKey(xn.field_contactId)) {
                        xn.nzx = ((com.tencent.mm.plugin.ipcall.a.g.c) nzw.get(xn.field_contactId)).nzx;
                    } else if (this.nAz && xn.nzx == null && (nzw == null || nzw.containsKey(xn.field_contactId))) {
                        xn.nzx = com.tencent.mm.plugin.ipcall.a.g.b.OP(xn.field_contactId);
                    }
                    if (!bo.isNullOrNil(this.gtX) && (bo.A(this.gtX.charAt(0)) || this.gtX.startsWith("+"))) {
                        bVar2.nAE.setText(f.a(a(xn, this.gtX), av.amM(this.gtX)));
                        bVar2.gtO.setText(f.a(xn.field_systemAddressBookUsername, this.gtX));
                    } else if (!bo.isNullOrNil(this.gtX) && !bo.A(this.gtX.charAt(0))) {
                        CharSequence charSequence = xn.field_systemAddressBookUsername;
                        String str2 = xn.field_systemAddressBookUsername;
                        String str3 = this.gtX;
                        if (bo.isNullOrNil(str3) || bo.isNullOrNil(str2)) {
                            str = "";
                        } else {
                            if (!bo.amT(str3) && bo.amU(str3)) {
                                int i2;
                                int i3;
                                ArrayList arrayList = new ArrayList();
                                for (i2 = 0; i2 < str2.length(); i2++) {
                                    String substring = str2.substring(i2, i2 + 1);
                                    arrayList.add(new a(g.vo(substring), substring));
                                }
                                for (i2 = 2; i2 <= str2.length(); i2++) {
                                    for (i3 = 0; i3 <= str2.length() - i2; i3++) {
                                        String substring2 = str2.substring(i3, i3 + i2);
                                        arrayList.add(new a(g.vo(substring2), substring2));
                                    }
                                }
                                i2 = 0;
                                while (true) {
                                    i3 = i2;
                                    if (i3 >= arrayList.size()) {
                                        break;
                                    }
                                    a aVar = (a) arrayList.get(i3);
                                    if (aVar.nAC.contains(str3)) {
                                        str = aVar.nAD;
                                        break;
                                    }
                                    i2 = i3 + 1;
                                }
                            }
                            str = str3;
                        }
                        bVar2.gtO.setText(f.a(charSequence, str));
                        bVar2.nAE.setText(a(xn, this.gtX));
                    } else if (bo.isNullOrNil(this.gtX)) {
                        bVar2.gtO.setText(xn.field_systemAddressBookUsername);
                    }
                }
                ImageView imageView = bVar2.eks;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.drawable.b7h);
                    if (xn != null) {
                        if (!bo.isNullOrNil(xn.field_contactId) && !bo.isNullOrNil(xn.field_wechatUsername)) {
                            this.nAw.a(xn.field_contactId, xn.field_wechatUsername, imageView);
                        } else if (!bo.isNullOrNil(xn.field_contactId)) {
                            this.nAw.c(xn.field_contactId, imageView);
                        } else if (!bo.isNullOrNil(xn.field_wechatUsername)) {
                            this.nAw.e(xn.field_wechatUsername, imageView);
                        }
                        if (!bo.isNullOrNil(xn.field_wechatUsername)) {
                            this.nAy.add(xn.field_wechatUsername);
                        }
                    }
                }
                bVar2.nAF.setVisibility(8);
                str = Pc(xn.field_sortKey);
                if (i == 0) {
                    bVar2.nAI.setVisibility(0);
                    bVar2.nAI.setText(str);
                    bVar2.nAJ.setVisibility(8);
                } else if (Pc(xn(i - 1).field_sortKey).equals(str)) {
                    bVar2.nAI.setVisibility(8);
                    bVar2.nAI.setText("");
                    bVar2.nAJ.setVisibility(8);
                } else {
                    bVar2.nAI.setVisibility(0);
                    bVar2.nAI.setText(str);
                    bVar2.nAJ.setVisibility(8);
                }
            }
            bVar2.nAL.setVisibility(8);
            bVar2.nAK.setVisibility(8);
            bVar2.nAK.setOnClickListener(this.nAA);
        }
        Object obj = 1;
        if (!(xn(i + 1) == null || xn(i) == null || Pc(xn(i + 1).field_sortKey).equals(Pc(xn(i).field_sortKey)))) {
            obj = null;
        }
        if (i + 1 == getCount() || obj == null) {
            bVar2.nAN.setVisibility(8);
        } else {
            bVar2.nAN.setVisibility(0);
        }
        AppMethodBeat.o(22005);
        return view;
    }

    private static String a(com.tencent.mm.plugin.ipcall.a.g.c cVar, String str) {
        AppMethodBeat.i(22006);
        if (!(cVar == null || cVar.nzx == null)) {
            Iterator it = cVar.nzx.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.contains(str)) {
                    AppMethodBeat.o(22006);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(22006);
        return null;
    }

    private static String Pc(String str) {
        AppMethodBeat.i(22007);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(22007);
            return str2;
        } else if (str.startsWith(com.tencent.mm.plugin.ipcall.a.g.b.emJ)) {
            str2 = "#";
            AppMethodBeat.o(22007);
            return str2;
        } else {
            str2 = str.toUpperCase().substring(0, 1);
            AppMethodBeat.o(22007);
            return str2;
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(22008);
        int itemViewType = super.getItemViewType(i);
        AppMethodBeat.o(22008);
        return itemViewType;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(22009);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(22009);
        return viewTypeCount;
    }

    public final void qj(String str) {
        AppMethodBeat.i(22010);
        if (this.nAy.contains(str)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21996);
                    c.this.notifyDataSetChanged();
                    AppMethodBeat.o(21996);
                }
            });
        }
        AppMethodBeat.o(22010);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(22011);
        this.nAx.clear();
        super.notifyDataSetChanged();
        AppMethodBeat.o(22011);
    }

    private void bIg() {
        AppMethodBeat.i(22012);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            Object obj = null;
            try {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    while (!cursor.isAfterLast()) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = new com.tencent.mm.plugin.ipcall.a.g.c();
                        cVar.d(cursor);
                        String Pc = Pc(cVar.field_sortKey);
                        if (i == 0) {
                            this.emK.put(Pc, Integer.valueOf(i));
                        } else if (!(obj == null || Pc.equals(obj))) {
                            this.emK.put(Pc, Integer.valueOf(i));
                        }
                        i++;
                        cursor.moveToNext();
                        String obj2 = Pc;
                    }
                }
                AppMethodBeat.o(22012);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(22012);
    }

    public final void KD() {
        AppMethodBeat.i(22004);
        super.bIf();
        KC();
        AppMethodBeat.o(22004);
    }
}

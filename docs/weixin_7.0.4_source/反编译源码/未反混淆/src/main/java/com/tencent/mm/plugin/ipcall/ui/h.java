package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h extends p<c> implements com.tencent.mm.ah.d.a {
    private static HashMap<String, c> nzw = null;
    private boolean jLC = false;
    private d nAw;
    private HashMap<Long, c> nAx = new HashMap();
    private HashSet<String> nAy = new HashSet();
    private boolean nAz = false;
    ArrayList<k> nDZ;
    private OnClickListener nEa = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22238);
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (com.tencent.mm.plugin.ipcall.b.c.eo(h.this.context)) {
                    k xt = h.this.xt(intValue);
                    c cVar = null;
                    if (xt.field_addressId > 0) {
                        if (h.this.nAx.containsKey(Long.valueOf(xt.field_addressId))) {
                            cVar = (c) h.this.nAx.get(Long.valueOf(xt.field_addressId));
                        } else {
                            cVar = i.bHw().iU(xt.field_addressId);
                        }
                        if (cVar != null) {
                            h.this.nAx.put(Long.valueOf(xt.field_addressId), cVar);
                        }
                    }
                    Intent intent;
                    if (cVar != null) {
                        intent = new Intent(h.this.context, IPCallTalkUI.class);
                        intent.putExtra("IPCallTalkUI_phoneNumber", xt.field_phonenumber);
                        intent.putExtra("IPCallTalkUI_contactId", cVar.field_contactId);
                        intent.putExtra("IPCallTalkUI_nickname", cVar.field_systemAddressBookUsername);
                        intent.putExtra("IPCallTalkUI_toWechatUsername", cVar.field_wechatUsername);
                        intent.putExtra("IPCallTalkUI_dialScene", 3);
                        com.tencent.mm.plugin.report.service.h.pYm.e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        ((FragmentActivity) h.this.context).startActivityForResult(intent, 1001);
                        AppMethodBeat.o(22238);
                        return;
                    }
                    intent = new Intent(h.this.context, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_phoneNumber", xt.field_phonenumber);
                    intent.putExtra("IPCallTalkUI_dialScene", 3);
                    com.tencent.mm.plugin.report.service.h.pYm.e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                    ((FragmentActivity) h.this.context).startActivityForResult(intent, 1001);
                } else {
                    AppMethodBeat.o(22238);
                    return;
                }
            }
            AppMethodBeat.o(22238);
        }
    };

    class a {
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

        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(22250);
        c cVar = (c) obj;
        if (cVar == null) {
            cVar = new c();
        }
        cVar.d(cursor);
        AppMethodBeat.o(22250);
        return cVar;
    }

    public h(Context context) {
        super(context, null);
        AppMethodBeat.i(22240);
        pN(true);
        this.nAw = new d(context);
        o.acd().a((com.tencent.mm.ah.d.a) this);
        AppMethodBeat.o(22240);
    }

    public final int getCount() {
        AppMethodBeat.i(22243);
        if (this.nDZ == null) {
            this.nDZ = m.bIb();
        }
        if (this.nDZ != null) {
            int size = this.nDZ.size();
            AppMethodBeat.o(22243);
            return size;
        }
        AppMethodBeat.o(22243);
        return 0;
    }

    public final k xt(int i) {
        AppMethodBeat.i(22244);
        k kVar = (k) this.nDZ.get(i);
        AppMethodBeat.o(22244);
        return kVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(22245);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.a8t, viewGroup, false);
            a aVar = new a(this, (byte) 0);
            aVar.nAM = view.findViewById(R.id.clz);
            aVar.nAN = view.findViewById(R.id.cm0);
            aVar.eks = (ImageView) view.findViewById(R.id.qk);
            aVar.gtO = (TextView) view.findViewById(R.id.b6e);
            aVar.nAE = (TextView) view.findViewById(R.id.ckk);
            aVar.nAF = (LinearLayout) view.findViewById(R.id.cm3);
            aVar.nAG = (TextView) view.findViewById(R.id.cm4);
            aVar.nAH = (TextView) view.findViewById(R.id.cm5);
            aVar.nAI = (TextView) view.findViewById(R.id.cly);
            aVar.nAJ = (TextView) view.findViewById(R.id.clx);
            aVar.nAK = (ImageView) view.findViewById(R.id.cm6);
            aVar.nAL = view.findViewById(R.id.cm2);
            aVar.nAL.setClickable(true);
            aVar.nAO = (ImageView) view.findViewById(R.id.p3);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.nAL.setClickable(true);
        aVar2.nAL.setTag(Integer.valueOf(i));
        aVar2.nAO.setVisibility(8);
        if (wK(i)) {
            aVar2.gtO.setVisibility(8);
            aVar2.nAE.setVisibility(8);
            aVar2.nAF.setVisibility(8);
            aVar2.eks.setVisibility(8);
            aVar2.eks.setTag(null);
            aVar2.nAJ.setVisibility(8);
            aVar2.nAI.setVisibility(8);
            aVar2.nAK.setVisibility(8);
        } else {
            k xt = xt(i);
            if (xt != null) {
                c cVar;
                if (i == 0) {
                    aVar2.nAJ.setVisibility(0);
                    aVar2.nAI.setVisibility(8);
                    aVar2.nAJ.setText(this.context.getString(R.string.chg));
                } else {
                    aVar2.nAJ.setVisibility(8);
                    aVar2.nAI.setVisibility(8);
                }
                aVar2.nAO.setVisibility(0);
                aVar2.gtO.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) aVar2.nAM.getLayoutParams();
                layoutParams.height = (int) aVar2.nAE.getContext().getResources().getDimension(R.dimen.b8);
                aVar2.nAM.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar2.eks.getLayoutParams();
                layoutParams2.height = (int) aVar2.eks.getContext().getResources().getDimension(R.dimen.aba);
                layoutParams2.width = (int) aVar2.eks.getContext().getResources().getDimension(R.dimen.aba);
                aVar2.eks.setLayoutParams(layoutParams2);
                if (xt.field_addressId > 0) {
                    if (this.nAx.containsKey(Long.valueOf(xt.field_addressId))) {
                        cVar = (c) this.nAx.get(Long.valueOf(xt.field_addressId));
                    } else {
                        cVar = i.bHw().iU(xt.field_addressId);
                    }
                    if (cVar != null) {
                        this.nAx.put(Long.valueOf(xt.field_addressId), cVar);
                        aVar2.gtO.setText(cVar.field_systemAddressBookUsername);
                    }
                } else {
                    aVar2.gtO.setText(com.tencent.mm.plugin.ipcall.b.a.Pw(xt.field_phonenumber));
                    cVar = null;
                }
                aVar2.nAE.setVisibility(8);
                aVar2.nAF.setVisibility(0);
                aVar2.nAH.setText(com.tencent.mm.plugin.ipcall.b.c.iY(xt.field_calltime));
                if (xt.field_duration > 0) {
                    aVar2.nAG.setText(com.tencent.mm.plugin.ipcall.b.c.jc(xt.field_duration));
                } else {
                    aVar2.nAG.setText(com.tencent.mm.plugin.ipcall.b.c.xy(xt.field_status));
                }
                ImageView imageView = aVar2.eks;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.drawable.b7h);
                    if (cVar != null) {
                        if (!bo.isNullOrNil(cVar.field_contactId) && !bo.isNullOrNil(cVar.field_wechatUsername)) {
                            this.nAw.a(cVar.field_contactId, cVar.field_wechatUsername, imageView);
                        } else if (!bo.isNullOrNil(cVar.field_contactId)) {
                            this.nAw.c(cVar.field_contactId, imageView);
                        } else if (!bo.isNullOrNil(cVar.field_wechatUsername)) {
                            this.nAw.e(cVar.field_wechatUsername, imageView);
                        }
                        if (!bo.isNullOrNil(cVar.field_wechatUsername)) {
                            this.nAy.add(cVar.field_wechatUsername);
                        }
                    }
                }
            }
            aVar2.nAL.setVisibility(0);
            aVar2.nAK.setVisibility(0);
            aVar2.nAL.setOnClickListener(this.nEa);
        }
        AppMethodBeat.o(22245);
        return view;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(22246);
        int itemViewType = super.getItemViewType(i);
        AppMethodBeat.o(22246);
        return itemViewType;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(22247);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(22247);
        return viewTypeCount;
    }

    public final void qj(String str) {
        AppMethodBeat.i(22248);
        if (this.nAy.contains(str)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22239);
                    h.this.notifyDataSetChanged();
                    AppMethodBeat.o(22239);
                }
            });
        }
        AppMethodBeat.o(22248);
    }

    public final void KD() {
        AppMethodBeat.i(138615);
        this.nDZ = m.bIb();
        AppMethodBeat.o(138615);
    }

    public final void KC() {
        AppMethodBeat.i(139022);
        this.nDZ = m.bIb();
        AppMethodBeat.o(139022);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(22249);
        this.nDZ = m.bIb();
        this.nAx.clear();
        super.notifyDataSetChanged();
        AppMethodBeat.o(22249);
    }
}

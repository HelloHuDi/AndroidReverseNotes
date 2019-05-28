package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class l extends i {
    private View jcl;
    private LayoutInflater mInflater;
    private MaxListView tHB = ((MaxListView) this.jcl.findViewById(R.id.f_y));
    private TextView tHC = ((TextView) this.jcl.findViewById(R.id.f_x));
    private a tHD = new a();
    private b tHE;
    private b tpu;

    public interface b {
        void a(FavorPayInfo favorPayInfo);
    }

    static final class c {
        TextView iDT;
        TextView kEq;
        TextView kiF;
        View tHL;
        ImageView tHM;
        CheckBox tHN;

        c() {
        }
    }

    class a extends BaseAdapter {
        int tHG = -1;
        List<t> tHH = new LinkedList();
        j tHI = null;
        p<String> tHJ = new p<String>() {
            public final String a(Vector<com.tencent.mm.plugin.wallet_core.model.p.b> vector, int i) {
                AppMethodBeat.i(47379);
                String str;
                if (vector == null) {
                    ab.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
                    str = "";
                    AppMethodBeat.o(47379);
                    return str;
                }
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= vector.size()) {
                        break;
                    }
                    com.tencent.mm.plugin.wallet_core.model.p.a aVar = ((com.tencent.mm.plugin.wallet_core.model.p.b) vector.get(i3)).tzL;
                    if (i3 == i || aVar == com.tencent.mm.plugin.wallet_core.model.p.a.CHECKED) {
                        stringBuilder.append(((String) ((com.tencent.mm.plugin.wallet_core.model.p.b) vector.get(i3)).tzK) + "-");
                    }
                    i2 = i3 + 1;
                }
                if (stringBuilder.length() == 0) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    AppMethodBeat.o(47379);
                    return str;
                }
                if (stringBuilder.length() > 1) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                str = stringBuilder.toString();
                AppMethodBeat.o(47379);
                return str;
            }
        };

        public a() {
            AppMethodBeat.i(47380);
            AppMethodBeat.o(47380);
        }

        public final int getCount() {
            AppMethodBeat.i(47381);
            int size = this.tHH.size();
            AppMethodBeat.o(47381);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(47382);
            Object obj = this.tHH.get(i);
            AppMethodBeat.o(47382);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            f fVar;
            String str;
            String str2;
            AppMethodBeat.i(47383);
            if (view == null) {
                view = l.this.mInflater.inflate(R.layout.b3w, viewGroup, false);
                c cVar2 = new c();
                cVar2.tHL = view.findViewById(R.id.f_4);
                cVar2.iDT = (TextView) view.findViewById(R.id.f_6);
                cVar2.kiF = (TextView) view.findViewById(R.id.f_7);
                cVar2.kEq = (TextView) view.findViewById(R.id.f_8);
                cVar2.tHN = (CheckBox) view.findViewById(R.id.f_9);
                cVar2.tHM = (ImageView) view.findViewById(R.id.f_5);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            t tVar = (t) getItem(i);
            if (i != this.tHG || this.tHG <= 0) {
                cVar.tHL.setVisibility(8);
                cVar.tHM.setVisibility(0);
            } else {
                cVar.tHL.setVisibility(0);
                cVar.tHM.setVisibility(8);
            }
            if (bo.isNullOrNil(tVar.tnN)) {
                cVar.iDT.setVisibility(8);
            } else {
                cVar.iDT.setText(tVar.tnN);
                cVar.iDT.setVisibility(0);
            }
            String str3 = tVar.tmO;
            if (!(this.tHI == null || this.tHI.tnm == null)) {
                LinkedList linkedList = this.tHI.tnm;
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    if (str3.equals(((f) linkedList.get(i2)).tmO)) {
                        fVar = (f) linkedList.get(i2);
                        break;
                    }
                }
            }
            fVar = null;
            String str4 = tVar.tmP;
            str3 = tVar.tmQ;
            if (fVar != null) {
                str = fVar.tmP;
                str2 = fVar.tmQ;
            } else {
                str = str4;
                str2 = str3;
            }
            if (bo.isNullOrNil(str)) {
                cVar.kiF.setVisibility(8);
            } else {
                cVar.kiF.setText(str);
                cVar.kiF.setVisibility(0);
            }
            if (bo.isNullOrNil(str2)) {
                cVar.kEq.setVisibility(8);
            } else {
                cVar.kEq.setText(str2);
                cVar.kEq.setVisibility(0);
            }
            com.tencent.mm.plugin.wallet_core.model.p.a aVar = ((com.tencent.mm.plugin.wallet_core.model.p.b) this.tHJ.tzD.get(i)).tzL;
            if (aVar == com.tencent.mm.plugin.wallet_core.model.p.a.DISABLED) {
                cVar.tHN.setChecked(false);
                cVar.tHN.setEnabled(false);
            } else {
                cVar.tHN.setEnabled(true);
                if (aVar == com.tencent.mm.plugin.wallet_core.model.p.a.CHECKED) {
                    cVar.tHN.setChecked(true);
                } else {
                    cVar.tHN.setChecked(false);
                }
            }
            AppMethodBeat.o(47383);
            return view;
        }
    }

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(47391);
        lVar.cRC();
        AppMethodBeat.o(47391);
    }

    private l(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(47384);
        this.mInflater = LayoutInflater.from(context);
        this.jcl = LayoutInflater.from(context).inflate(R.layout.b44, null);
        this.tHB.setAdapter(this.tHD);
        this.jcl.findViewById(R.id.f_z).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47377);
                l.a(l.this);
                l.this.dismiss();
                AppMethodBeat.o(47377);
            }
        });
        AppMethodBeat.o(47384);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(47385);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.o(47385);
    }

    public final void dismiss() {
        AppMethodBeat.i(47386);
        try {
            super.dismiss();
            AppMethodBeat.o(47386);
        } catch (Exception e) {
            ab.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(47386);
        }
    }

    public static l a(Context context, Orders orders, String str, b bVar, OnCancelListener onCancelListener) {
        AppMethodBeat.i(47387);
        l lVar = new l(context);
        lVar.setOnCancelListener(onCancelListener);
        lVar.setCancelable(true);
        lVar.setCanceledOnTouchOutside(false);
        lVar.tpu = c.tDU.a(orders);
        if (lVar.tpu == null) {
            ab.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            lVar.dismiss();
        } else {
            int i;
            Object obj;
            a aVar = lVar.tHD;
            h hVar = l.this.tpu.tDO;
            String acY = l.this.tpu.acY(str);
            aVar.tHH = l.this.tpu.cRl();
            aVar.tHI = l.this.tpu.acU(acY);
            aVar.tHG = -1;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= aVar.tHH.size()) {
                    break;
                }
                if (((t) aVar.tHH.get(i)).tnR != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    aVar.tHG = i;
                    break;
                }
                i2 = i + 1;
            }
            LinkedList linkedList = new LinkedList();
            if (aVar.tHH != null) {
                i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= aVar.tHH.size()) {
                        break;
                    }
                    linkedList.add(((t) aVar.tHH.get(i)).tmO);
                    i2 = i + 1;
                }
                LinkedList linkedList2 = new LinkedList();
                if (hVar != null && hVar.tmV != null) {
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= hVar.tmV.size()) {
                            break;
                        }
                        String str2 = ((t) hVar.tmV.get(i)).tmO;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                        i2 = i + 1;
                    }
                }
                LinkedList linkedList3 = new LinkedList();
                if (hVar == null || hVar.tmW == null || hVar.tmW.tni == null) {
                    ab.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    obj = null;
                } else {
                    LinkedList linkedList4 = hVar.tmW.tni;
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= linkedList4.size()) {
                            break;
                        }
                        String str3 = ((j) linkedList4.get(i)).tnk;
                        i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= linkedList2.size()) {
                                obj = null;
                                break;
                            } else if (str3.contains((CharSequence) linkedList2.get(i3))) {
                                obj = 1;
                                break;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                        if (obj == null) {
                            linkedList3.add(str3);
                        }
                        i2 = i + 1;
                    }
                    LinkedList linkedList5 = new LinkedList();
                    if (!(bo.isNullOrNil(acY) || acY.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                        String[] split = acY.split("-");
                        if (split != null) {
                            for (Object add : split) {
                                linkedList5.add(add);
                            }
                        } else {
                            ab.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            obj = null;
                        }
                    }
                    aVar.tHJ.d(linkedList, linkedList5, linkedList3);
                    obj = 1;
                }
            } else {
                ab.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                obj = null;
            }
            if (obj == null) {
                ab.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                lVar.dismiss();
            } else {
                lVar.tHC.setText(R.string.fes);
                lVar.tHB.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(47378);
                        a b = l.this.tHD;
                        p pVar = b.tHJ;
                        if (i < pVar.tzD.size()) {
                            com.tencent.mm.plugin.wallet_core.model.p.a aVar = ((com.tencent.mm.plugin.wallet_core.model.p.b) pVar.tzD.get(i)).tzL;
                            com.tencent.mm.plugin.wallet_core.model.p.a aVar2 = com.tencent.mm.plugin.wallet_core.model.p.a.CHECKED;
                            for (int i2 = 0; i2 < pVar.tzD.size(); i2++) {
                                pVar.a(i2, com.tencent.mm.plugin.wallet_core.model.p.a.UNCHECKED);
                            }
                            switch (com.tencent.mm.plugin.wallet_core.model.p.AnonymousClass1.tzF[aVar.ordinal()]) {
                                case 1:
                                    pVar.a(i, com.tencent.mm.plugin.wallet_core.model.p.a.CHECKED);
                                    break;
                                case 2:
                                    pVar.a(i, com.tencent.mm.plugin.wallet_core.model.p.a.UNCHECKED);
                                    break;
                            }
                        }
                        b.notifyDataSetChanged();
                        AppMethodBeat.o(47378);
                    }
                });
            }
        }
        lVar.tHE = bVar;
        lVar.show();
        com.tencent.mm.ui.base.h.a(context, lVar);
        AppMethodBeat.o(47387);
        return lVar;
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(47388);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(47388);
    }

    private void cRC() {
        AppMethodBeat.i(47389);
        ab.d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.tHD != null) {
            p pVar = this.tHD.tHJ;
            this.tHE.a(this.tpu.acX(pVar.a(pVar.tzD, -1)));
        }
        AppMethodBeat.o(47389);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47390);
        if (i == 4) {
            cRC();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(47390);
        return onKeyUp;
    }
}

package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseAdapter {
    private final Context mContext;
    private int mCount = 0;
    private ArrayList<Bankcard> tll;
    private int tlm;
    com.tencent.mm.plugin.wallet_core.utils.a tln;
    List<String> tlo;

    class a {
        public ImageView tlA = null;
        public WalletTextView tlB = null;
        public TextView tlC = null;
        public TextView tlp = null;
        public TextView tlq = null;
        public TextView tlr = null;
        public RelativeLayout tls = null;
        public ImageView tlt = null;
        public ImageView tlu = null;
        public TextView tlv = null;
        public TextView tlw = null;
        public TextView tlx = null;
        public ImageView tly = null;
        public ImageView tlz = null;

        a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(45738);
        Bankcard Hd = Hd(i);
        AppMethodBeat.o(45738);
        return Hd;
    }

    public a(Context context, ArrayList<Bankcard> arrayList) {
        AppMethodBeat.i(45732);
        this.mContext = context;
        this.tll = arrayList;
        this.tlm = 0;
        this.tln = new com.tencent.mm.plugin.wallet_core.utils.a();
        this.tln.b(this.mContext, this.tll);
        cNr();
        AppMethodBeat.o(45732);
    }

    public final void W(ArrayList<Bankcard> arrayList) {
        AppMethodBeat.i(45733);
        this.tll = arrayList;
        if (arrayList != null) {
            this.mCount = arrayList.size();
        } else {
            this.mCount = 0;
        }
        if (this.mCount > 0) {
            this.tln.b(this.mContext, this.tll);
        }
        cNr();
        AppMethodBeat.o(45733);
    }

    private void cNr() {
        AppMethodBeat.i(45734);
        g.RQ();
        this.tlo = bo.P(((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, (Object) "")).split(","));
        AppMethodBeat.o(45734);
    }

    public int getCount() {
        return this.mCount;
    }

    private Bankcard Hd(int i) {
        AppMethodBeat.i(45735);
        if (i < 0 || i >= this.mCount) {
            AppMethodBeat.o(45735);
            return null;
        }
        Bankcard bankcard = (Bankcard) this.tll.get(i);
        AppMethodBeat.o(45735);
        return bankcard;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        AppMethodBeat.i(45736);
        Bankcard Hd = Hd(i);
        if (Hd == null) {
            AppMethodBeat.o(45736);
            return 4;
        } else if (Hd.field_bankcardState == 9) {
            if (Hd.field_wxcreditState == 0) {
                AppMethodBeat.o(45736);
                return 2;
            }
            AppMethodBeat.o(45736);
            return 3;
        } else if (Hd.cPb() && "CITIC_CREDIT".equals(Hd.field_bankcardType)) {
            AppMethodBeat.o(45736);
            return 5;
        } else if (Hd.cPg()) {
            AppMethodBeat.o(45736);
            return 6;
        } else if (!Hd.cPf() || r.YM()) {
            AppMethodBeat.o(45736);
            return 1;
        } else {
            AppMethodBeat.o(45736);
            return 0;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(45737);
        Bankcard Hd = Hd(i);
        if (Hd == null) {
            AppMethodBeat.o(45737);
            return view;
        }
        boolean z;
        String bigDecimal;
        int itemViewType = getItemViewType(i);
        if (this.tlo == null || this.tlo.isEmpty() || Hd == null) {
            z = false;
        } else {
            for (String bigDecimal2 : this.tlo) {
                if (bigDecimal2.equals(Hd.field_bindSerial)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        ab.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", Integer.valueOf(i), Hd.field_card_bottom_wording, Boolean.valueOf(z));
        a aVar;
        a aVar2;
        switch (itemViewType) {
            case 0:
                view = b.a(this.mContext, view, Hd, R.layout.b35, this.tln, z, itemViewType);
                AppMethodBeat.o(45737);
                return view;
            case 1:
                view = b.a(this.mContext, view, Hd, R.layout.b3b, this.tln, z, itemViewType);
                AppMethodBeat.o(45737);
                return view;
            case 2:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, R.layout.b3f, null);
                    aVar = new a();
                    aVar.tlu = (ImageView) view.findViewById(R.id.f71);
                    aVar.tlq = (TextView) view.findViewById(R.id.f72);
                    aVar.tlx = (TextView) view.findViewById(R.id.f8e);
                    aVar.tly = (ImageView) view.findViewById(R.id.f74);
                    aVar.tlz = (ImageView) view.findViewById(R.id.f75);
                    aVar.tlA = (ImageView) view.findViewById(R.id.f76);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                aVar2.tlq.setText(this.mContext.getString(R.string.fg8, new Object[]{Hd.field_bankName}));
                if (b.b(Hd)) {
                    aVar2.tlx.setVisibility(0);
                } else {
                    aVar2.tlx.setVisibility(8);
                }
                AppMethodBeat.o(45737);
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, R.layout.b3i, null);
                    aVar = new a();
                    aVar.tlu = (ImageView) view.findViewById(R.id.f71);
                    aVar.tlq = (TextView) view.findViewById(R.id.f72);
                    aVar.tlv = (TextView) view.findViewById(R.id.f79);
                    aVar.tly = (ImageView) view.findViewById(R.id.f74);
                    aVar.tlz = (ImageView) view.findViewById(R.id.f75);
                    aVar.tlA = (ImageView) view.findViewById(R.id.f76);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                switch (Hd.field_wxcreditState) {
                    case 1:
                        aVar2.tlv.setBackgroundResource(R.drawable.bky);
                        aVar2.tlv.setVisibility(0);
                        break;
                    case 3:
                        aVar2.tlv.setBackgroundResource(R.drawable.bko);
                        aVar2.tlv.setVisibility(0);
                        break;
                    default:
                        aVar2.tlv.setVisibility(8);
                        break;
                }
                aVar2.tlq.setText(Hd.field_bankName);
                this.tln.a(this.mContext, Hd, aVar2.tlu);
                AppMethodBeat.o(45737);
                return view;
            case 4:
                view = View.inflate(this.mContext, R.layout.b36, null);
                AppMethodBeat.o(45737);
                return view;
            case 5:
                view = b.a(this.mContext, view, Hd, R.layout.b3g, this.tln, z, itemViewType);
                AppMethodBeat.o(45737);
                return view;
            case 6:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, R.layout.b3_, null);
                    aVar = new a();
                    aVar.tlu = (ImageView) view.findViewById(R.id.f71);
                    aVar.tlq = (TextView) view.findViewById(R.id.f72);
                    aVar.tlr = (TextView) view.findViewById(R.id.f73);
                    aVar.tlv = (TextView) view.findViewById(R.id.f79);
                    aVar.tlB = (WalletTextView) view.findViewById(R.id.f7w);
                    aVar.tlt = (ImageView) view.findViewById(R.id.f70);
                    aVar.tlC = (TextView) view.findViewById(R.id.f7x);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.tlu.setImageDrawable(com.tencent.mm.svg.a.a.f(this.mContext.getResources(), R.raw.honey_pay_bank_logo));
                if ((aVar.tlu instanceof CdnImageView) && !bo.isNullOrNil(Hd.txk)) {
                    ((CdnImageView) aVar.tlu).setUseSdcardCache(true);
                    ((CdnImageView) aVar.tlu).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cRb());
                    ((CdnImageView) aVar.tlu).eb(Hd.txk, R.raw.honey_pay_bank_logo);
                }
                aVar.tlq.setText(j.b(this.mContext, e.eK(e.mJ(Hd.txg), 10), aVar.tlq.getTextSize()));
                aVar.tlr.setText(Hd.txj);
                if (Hd.txh == 0) {
                    bigDecimal2 = e.a(Hd.txf, "100", 2, RoundingMode.HALF_UP).toString();
                    aVar.tlB.setPrefix(ae.dOd());
                    aVar.tlB.setText(bigDecimal2);
                    aVar.tlB.setVisibility(0);
                    aVar.tlC.setVisibility(0);
                } else {
                    aVar.tlB.setVisibility(4);
                    aVar.tlC.setVisibility(4);
                }
                AppMethodBeat.o(45737);
                return view;
            default:
                AppMethodBeat.o(45737);
                return view;
        }
    }
}

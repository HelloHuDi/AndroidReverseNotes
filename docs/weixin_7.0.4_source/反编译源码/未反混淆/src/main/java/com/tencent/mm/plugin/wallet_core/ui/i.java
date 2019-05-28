package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class i extends BaseAdapter {
    private Context mContext;
    private Orders pWy = null;
    private int tGK = -1;
    public String tGL = "";
    public boolean tGM = true;
    private boolean tGN = false;
    protected ArrayList<Bankcard> tgB;
    private com.tencent.mm.plugin.wallet_core.utils.a tln;
    private int toE;

    class a {
        public TextView gne;
        public TextView pnu;
        public FavourLayout tGP;
        public CheckedTextView tGQ;
        public CdnImageView tGR;

        a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(47320);
        Bankcard Hd = Hd(i);
        AppMethodBeat.o(47320);
        return Hd;
    }

    public i(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        AppMethodBeat.i(47313);
        this.mContext = context;
        this.tgB = arrayList;
        this.toE = i;
        this.pWy = orders;
        this.tln = new com.tencent.mm.plugin.wallet_core.utils.a();
        this.tln.b(this.mContext, this.tgB);
        if (orders != null && orders.tAy == 1) {
            this.tGN = true;
        }
        AppMethodBeat.o(47313);
    }

    public int getCount() {
        int i = 0;
        AppMethodBeat.i(47314);
        if (!this.tGN) {
            if (this.pWy == null || !this.pWy.tAm.equals("CFT")) {
                i = 1;
            }
            if (this.tgB != null) {
                i += this.tgB.size();
                AppMethodBeat.o(47314);
                return i;
            }
            AppMethodBeat.o(47314);
            return i;
        } else if (this.tgB == null) {
            AppMethodBeat.o(47314);
            return 0;
        } else {
            i = this.tgB.size();
            AppMethodBeat.o(47314);
            return i;
        }
    }

    public Bankcard Hd(int i) {
        AppMethodBeat.i(47315);
        Bankcard bankcard;
        if (this.tGN) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.o(47315);
            return bankcard;
        }
        int count = getCount();
        if (this.pWy == null || !this.pWy.tAm.equals("CFT")) {
            count--;
        }
        if (i < count) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.o(47315);
            return bankcard;
        }
        AppMethodBeat.o(47315);
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        AppMethodBeat.i(47316);
        Bankcard Hd = Hd(i);
        if (Hd == null) {
            AppMethodBeat.o(47316);
            return true;
        } else if (Hd.a(this.toE, this.pWy) != 0) {
            AppMethodBeat.o(47316);
            return false;
        } else {
            AppMethodBeat.o(47316);
            return true;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(47317);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.b3r, null);
            aVar = new a();
            aVar.gne = (TextView) view.findViewById(R.id.cx);
            aVar.pnu = (TextView) view.findViewById(R.id.a81);
            aVar.tGQ = (CheckedTextView) view.findViewById(R.id.da1);
            aVar.tGR = (CdnImageView) view.findViewById(R.id.f71);
            aVar.tGP = (FavourLayout) view.findViewById(R.id.f9r);
            aVar.pnu.setText("");
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pnu.setTextColor(ah.getResources().getColor(R.color.s0));
        aVar.tGP.setVisibility(8);
        Bankcard Hd = Hd(i);
        LinkedList linkedList;
        if (Hd == null) {
            aVar.tGQ.setVisibility(4);
            aVar.pnu.setVisibility(8);
            aVar.gne.setText(R.string.fnt);
            aVar.tGR.setVisibility(8);
            LinkedList linkedList2 = new LinkedList();
            if (!(this.pWy == null || this.pWy.tAr == null || this.pWy.tAr.tnf == null)) {
                n nVar = this.pWy.tAr.tnf.tmB;
                if (nVar != null) {
                    Iterator it = nVar.tns.iterator();
                    while (it.hasNext()) {
                        linkedList2.add(((o) it.next()).pOz);
                    }
                    linkedList = linkedList2;
                    if (this.tGM && linkedList.size() > 0) {
                        aVar.tGP.setVisibility(0);
                        aVar.pnu.setVisibility(8);
                        aVar.tGP.setWording(linkedList);
                    }
                }
            }
            linkedList = linkedList2;
            aVar.tGP.setVisibility(0);
            aVar.pnu.setVisibility(8);
            aVar.tGP.setWording(linkedList);
        } else {
            aVar.tGR.setVisibility(0);
            aVar.tGQ.setVisibility(0);
            aVar.pnu.setVisibility(0);
            aVar.pnu.setText("");
            if (Hd.cPg()) {
                aVar.gne.setText(j.b(this.mContext, Hd.field_desc, aVar.gne.getTextSize()));
            } else {
                aVar.gne.setText(Hd.field_desc);
            }
            Bankcard bankcard;
            if (Hd.cPc()) {
                bankcard = r.cPI().thy;
                if (!bo.isNullOrNil(bankcard.twT)) {
                    aVar.gne.setText(bankcard.twT);
                } else if (bankcard.twS >= 0.0d) {
                    aVar.gne.setText(this.mContext.getString(ae.dOh(), new Object[]{e.G(bankcard.twS)}));
                } else {
                    aVar.gne.setText(this.mContext.getText(R.string.fg1));
                }
            } else if (Hd.cPd()) {
                bankcard = r.cPI().tCZ;
                if (!bo.isNullOrNil(bankcard.twT)) {
                    aVar.gne.setText(bankcard.twT);
                } else if (bankcard.twS >= 0.0d) {
                    aVar.gne.setText(this.mContext.getString(R.string.fhz, new Object[]{e.G(bankcard.twS)}));
                } else {
                    aVar.gne.setText(this.mContext.getText(R.string.fg1));
                }
            }
            aVar.pnu.setVisibility(0);
            switch (Hd.a(this.toE, this.pWy)) {
                case 1:
                    aVar.pnu.setText(R.string.fnz);
                    break;
                case 2:
                    aVar.pnu.setText(R.string.fo5);
                    break;
                case 3:
                    aVar.pnu.setText(R.string.fo_);
                    break;
                case 4:
                    aVar.pnu.setText(R.string.fo1);
                    break;
                case 5:
                    aVar.pnu.setText(R.string.fnx);
                    break;
                case 6:
                    aVar.pnu.setText(R.string.fo3);
                    break;
                case 7:
                    aVar.pnu.setText(R.string.fo8);
                    break;
                case 8:
                    aVar.pnu.setText(Hd.field_forbidWord);
                    break;
                default:
                    if (!bo.isNullOrNil(Hd.field_tips)) {
                        aVar.pnu.setText(Hd.field_tips);
                        break;
                    }
                    aVar.pnu.setVisibility(8);
                    break;
            }
            String charSequence = aVar.pnu.getText().toString();
            aVar.gne.setTextColor(this.mContext.getResources().getColor(R.color.w4));
            if (this.tGL.equalsIgnoreCase(Hd.field_bindSerial)) {
                aVar.tGQ.setChecked(true);
                aVar.tGQ.setEnabled(true);
            } else if (isEnabled(i)) {
                aVar.tGQ.setChecked(false);
                aVar.tGQ.setEnabled(true);
            } else {
                aVar.tGQ.setEnabled(false);
                aVar.tGQ.setChecked(false);
                aVar.gne.setTextColor(this.mContext.getResources().getColor(R.color.s0));
            }
            aVar.tGR.setTag(R.id.d7, null);
            aVar.tGR.setTag(null);
            aVar.tGR.setImageDrawable(null);
            aVar.pnu.setOnClickListener(null);
            if (Hd.cPc()) {
                com.tencent.mm.plugin.wallet_core.utils.a.j(aVar.tGR);
            } else if (Hd.cPd()) {
                this.tln.a(Hd, aVar.tGR);
            } else if (Hd.cPg()) {
                aVar.tGR.setImageDrawable(com.tencent.mm.svg.a.a.f(ah.getResources(), R.raw.honey_pay_bank_logo));
                if (!bo.isNullOrNil(Hd.txk)) {
                    aVar.tGR.setUseSdcardCache(true);
                    aVar.tGR.setImgSavedPath(b.cRb());
                    aVar.tGR.eb(Hd.txk, R.raw.honey_pay_bank_logo);
                }
            } else {
                this.tln.a(this.mContext, Hd, aVar.tGR);
            }
            if (!bo.isNullOrNil(Hd.field_forbid_title) && !bo.isNullOrNil(Hd.field_forbid_url)) {
                charSequence = charSequence + "  ";
                SpannableString spannableString = new SpannableString(charSequence + Hd.field_forbid_title);
                aVar.pnu.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(47312);
                        if (view.getTag() instanceof String) {
                            Intent intent = new Intent();
                            ab.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", (String) view.getTag());
                            intent.putExtra("rawUrl", r0);
                            intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                            intent.putExtra("pay_channel", 1);
                            d.b(i.this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, WalletChangeBankcardUI.toB);
                        }
                        AppMethodBeat.o(47312);
                    }
                });
                spannableString.setSpan(new ForegroundColorSpan(ah.getResources().getColor(R.color.a4f)), charSequence.length(), charSequence.length() + Hd.field_forbid_title.length(), 34);
                aVar.pnu.setText(spannableString);
                aVar.pnu.setTag(Hd.field_forbid_url);
            } else if (this.tGM && bo.isNullOrNil(Hd.field_forbidWord) && bo.isNullOrNil(charSequence)) {
                linkedList = g(Hd);
                if (linkedList.size() > 0) {
                    aVar.tGP.setVisibility(0);
                    aVar.pnu.setVisibility(8);
                    aVar.tGP.setWording(linkedList);
                }
            }
        }
        AppMethodBeat.o(47317);
        return view;
    }

    private LinkedList<String> g(Bankcard bankcard) {
        AppMethodBeat.i(47318);
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.pWy == null || this.pWy.tAr == null || this.pWy.tAr.tnf == null)) {
            Iterator it = this.pWy.tAr.tnf.tmA.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.pbo.equals(bankcard.field_bindSerial)) {
                    it = cVar.tmL.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((com.tencent.mm.plugin.wallet.a.d) it.next()).pOz);
                    }
                    AppMethodBeat.o(47318);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.o(47318);
        return linkedList;
    }

    public final void f(ArrayList<Bankcard> arrayList, boolean z) {
        AppMethodBeat.i(47319);
        if (arrayList == null) {
            this.tgB = new ArrayList();
        } else {
            this.tgB = arrayList;
        }
        this.tGM = z;
        if (this.tgB.size() > 0) {
            this.tln.b(this.mContext, this.tgB);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(47319);
    }
}

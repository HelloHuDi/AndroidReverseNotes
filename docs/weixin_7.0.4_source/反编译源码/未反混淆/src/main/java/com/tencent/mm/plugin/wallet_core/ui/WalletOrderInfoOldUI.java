package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.us;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoOldUI extends WalletOrderInfoUI {
    protected boolean ctK = true;
    protected boolean ctL = false;
    protected boolean ctM = false;
    protected String igi = null;
    protected String mAppId = "";
    protected String oXY;
    protected PayInfo pVL;
    private String pVl;
    private com.tencent.mm.sdk.b.c pap = new com.tencent.mm.sdk.b.c<us>() {
        {
            AppMethodBeat.i(47477);
            this.xxI = us.class.getName().hashCode();
            AppMethodBeat.o(47477);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(47478);
            us usVar = (us) bVar;
            if (usVar instanceof us) {
                if (!usVar.cRy.cRz.oZd) {
                    ab.i("MicroMsg.WalletOrderInfoOldUI", "block pass");
                    AppMethodBeat.o(47478);
                    return true;
                } else if ("1".equals(usVar.cRy.cRz.cRb) || "2".equals(usVar.cRy.cRz.cRb)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.a(usVar.cRy.cRz.cRb, usVar.cRy.cRz.cRc, usVar.cRy.cRz.cRd, usVar.cRy.cRz.cRe, usVar.cRy.cRz.cRf, WalletOrderInfoOldUI.this.pVL == null ? 0 : WalletOrderInfoOldUI.this.pVL.cIf);
                    ab.i("MicroMsg.WalletOrderInfoOldUI", "receive guide");
                    WalletOrderInfoOldUI.this.mBundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.o(47478);
            return false;
        }
    };
    protected String pdC = null;
    protected boolean tEC = false;
    private HashMap<String, b> tEH = new HashMap();
    protected String tEI;
    protected LinearLayout tIK = null;
    protected TextView tIL = null;
    protected TextView tIM = null;
    protected a tIN = null;
    protected String tIO = null;
    protected HashMap<String, TextView> tIP = new HashMap();
    protected c tIQ;
    protected Map<Long, String> tIR = new HashMap();
    private d tIS;
    private boolean tIT = false;
    protected com.tencent.mm.model.ao.b.a tIU = new com.tencent.mm.model.ao.b.a() {
        public final void o(String str, boolean z) {
            AppMethodBeat.i(47479);
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            ab.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoOldUI.this.S(aoO);
            AppMethodBeat.o(47479);
        }
    };
    private OnLongClickListener tIV = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(47484);
            if (view.getId() == R.id.fdo || view.getId() == R.id.fdy) {
                try {
                    String str = (String) view.getTag();
                    Toast.makeText(WalletOrderInfoOldUI.this, R.string.fkm, 0).show();
                    com.tencent.mm.pluginsdk.f.a.b(str, str);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(47484);
            return true;
        }
    };
    protected Set<String> tIc = null;
    protected List<Commodity> tId = null;
    private com.tencent.mm.sdk.b.c tIy = new com.tencent.mm.sdk.b.c<aq>() {
        {
            AppMethodBeat.i(47474);
            this.xxI = aq.class.getName().hashCode();
            AppMethodBeat.o(47474);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(47475);
            aq aqVar = (aq) bVar;
            if (aqVar instanceof aq) {
                WalletOrderInfoOldUI.this.tIO = aqVar.ctH.ctJ;
                WalletOrderInfoOldUI.this.ctK = aqVar.ctH.ctK;
                WalletOrderInfoOldUI.this.ctL = aqVar.ctH.ctL;
                WalletOrderInfoOldUI.this.ctM = aqVar.ctH.ctM;
                if (WalletOrderInfoOldUI.this.ctM && !bo.isNullOrNil(WalletOrderInfoOldUI.this.tEI)) {
                    for (int i = 0; i < WalletOrderInfoOldUI.this.tId.size(); i++) {
                        Commodity commodity = (Commodity) WalletOrderInfoOldUI.this.tId.get(i);
                        int i2 = -1;
                        for (int i3 = 0; i3 < commodity.tBa.size(); i3++) {
                            Promotions promotions = (Promotions) commodity.tBa.get(i3);
                            if (promotions.type == Orders.tAQ && !bo.isNullOrNil(promotions.url) && promotions.url.equals(WalletOrderInfoOldUI.this.tEI)) {
                                i2 = i3;
                            }
                        }
                        if (i2 >= 0) {
                            commodity.tBa.remove(i2);
                        }
                    }
                }
                WalletOrderInfoOldUI.this.tIN.notifyDataSetChanged();
                if (!bo.isNullOrNil(WalletOrderInfoOldUI.this.tEI)) {
                    TextView textView = (TextView) WalletOrderInfoOldUI.this.tIP.get(WalletOrderInfoOldUI.this.tEI);
                    if (textView != null) {
                        textView.setClickable(WalletOrderInfoOldUI.this.ctK);
                        textView.setEnabled(WalletOrderInfoOldUI.this.ctK);
                        textView.setOnClickListener(null);
                        if (WalletOrderInfoOldUI.this.ctL) {
                            textView.setVisibility(8);
                        }
                    }
                }
                aqVar.ctI.csN = true;
            }
            AppMethodBeat.o(47475);
            return false;
        }
    };
    protected Orders tog;

    class c extends BaseAdapter {
        protected List<Promotions> tBa;

        class a {
            TextView gne;
            TextView gtb;
            CdnImageView kqn;
            int tBn;
            TextView tJp;
            CheckBox tJq;
            int type;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(47497);
            Promotions Hx = Hx(i);
            AppMethodBeat.o(47497);
            return Hx;
        }

        public c(List<Promotions> list) {
            AppMethodBeat.i(47493);
            this.tBa = null;
            this.tBa = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Promotions promotions = (Promotions) list.get(i);
                if (promotions != null && (!bo.isNullOrNil(promotions.pcm) || promotions.uZM == 2 || promotions.uZM == 1)) {
                    this.tBa.add(list.get(i));
                }
            }
            AppMethodBeat.o(47493);
        }

        public final int getCount() {
            AppMethodBeat.i(47494);
            if (this.tBa != null) {
                int size = this.tBa.size();
                AppMethodBeat.o(47494);
                return size;
            }
            AppMethodBeat.o(47494);
            return 0;
        }

        public final Promotions Hx(int i) {
            AppMethodBeat.i(47495);
            Promotions promotions = (Promotions) this.tBa.get(i);
            AppMethodBeat.o(47495);
            return promotions;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            String lJ;
            a aVar;
            AppMethodBeat.i(47496);
            Promotions Hx = Hx(i);
            if (bo.isNullOrNil(Hx.pcm) && Hx.ttW > 0) {
                lJ = WalletOrderInfoOldUI.this.lJ(Hx.ttW);
                h hVar = h.pYm;
                Object[] objArr = new Object[6];
                objArr[0] = WalletOrderInfoOldUI.this.pVl;
                objArr[1] = Integer.valueOf(1);
                objArr[2] = Integer.valueOf(Hx.uZM);
                if ("-1".equals(lJ)) {
                    lJ = Integer.valueOf(5);
                }
                objArr[3] = lJ;
                objArr[4] = Long.valueOf(Hx.ttW);
                objArr[5] = Long.valueOf(Hx.tzR);
                hVar.e(13471, objArr);
            }
            a aVar2;
            View inflate;
            View view2;
            if (view == null) {
                aVar2 = new a();
                aVar2.type = Hx.type;
                if (Hx.type == Orders.tAQ) {
                    if (Hx.tBn == 1) {
                        inflate = View.inflate(WalletOrderInfoOldUI.this, R.layout.b5d, null);
                        aVar2.kqn = (CdnImageView) inflate.findViewById(R.id.fe5);
                        aVar2.gne = (TextView) inflate.findViewById(R.id.fe7);
                        aVar2.tJp = (TextView) inflate.findViewById(R.id.fe9);
                        aVar2.gtb = (TextView) inflate.findViewById(R.id.fe8);
                        if (!TextUtils.isEmpty(Hx.url)) {
                            WalletOrderInfoOldUI.this.tIP.put(Hx.url, aVar2.tJp);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    } else {
                        inflate = View.inflate(WalletOrderInfoOldUI.this, R.layout.b5e, null);
                        aVar2.kqn = (CdnImageView) inflate.findViewById(R.id.fe5);
                        aVar2.tJp = (TextView) inflate.findViewById(R.id.fe9);
                        aVar2.gtb = (TextView) inflate.findViewById(R.id.fe8);
                        aVar2.gne = (TextView) inflate.findViewById(R.id.fe7);
                        if (!TextUtils.isEmpty(Hx.url)) {
                            WalletOrderInfoOldUI.this.tIP.put(Hx.url, aVar2.tJp);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    }
                    aVar2.tBn = Hx.tBn;
                    view = view2;
                    aVar = aVar2;
                } else {
                    view = View.inflate(WalletOrderInfoOldUI.this, R.layout.b5f, null);
                    aVar2.kqn = (CdnImageView) view.findViewById(R.id.fe5);
                    aVar2.tJp = (TextView) view.findViewById(R.id.fe9);
                    aVar2.gtb = (TextView) view.findViewById(R.id.fe8);
                    aVar2.tJq = (CheckBox) view.findViewById(R.id.f9i);
                    if (!TextUtils.isEmpty(Hx.url)) {
                        WalletOrderInfoOldUI.this.tIP.put(Hx.url, aVar2.tJp);
                    }
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
            } else {
                a aVar3 = (a) view.getTag();
                int i2 = 0;
                if (Hx.type == aVar3.type && (Hx.type != Orders.tAQ || Hx.tBn == aVar3.tBn)) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    aVar2 = new a();
                    aVar2.type = Hx.type;
                    if (Hx.type == Orders.tAQ) {
                        if (Hx.tBn == 1) {
                            inflate = View.inflate(WalletOrderInfoOldUI.this, R.layout.b5d, null);
                            aVar2.kqn = (CdnImageView) inflate.findViewById(R.id.fe5);
                            aVar2.gne = (TextView) inflate.findViewById(R.id.fe7);
                            aVar2.tJp = (TextView) inflate.findViewById(R.id.fe9);
                            aVar2.gtb = (TextView) inflate.findViewById(R.id.fe8);
                            if (!TextUtils.isEmpty(Hx.url)) {
                                WalletOrderInfoOldUI.this.tIP.put(Hx.url, aVar2.tJp);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        } else {
                            inflate = View.inflate(WalletOrderInfoOldUI.this, R.layout.b5e, null);
                            aVar2.kqn = (CdnImageView) inflate.findViewById(R.id.fe5);
                            aVar2.tJp = (TextView) inflate.findViewById(R.id.fe9);
                            aVar2.gtb = (TextView) inflate.findViewById(R.id.fe8);
                            aVar2.gne = (TextView) inflate.findViewById(R.id.fe7);
                            if (!TextUtils.isEmpty(Hx.url)) {
                                WalletOrderInfoOldUI.this.tIP.put(Hx.url, aVar2.tJp);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        }
                        aVar2.tBn = Hx.tBn;
                        view = view2;
                        aVar = aVar2;
                    } else {
                        view = View.inflate(WalletOrderInfoOldUI.this, R.layout.b5f, null);
                        aVar2.kqn = (CdnImageView) view.findViewById(R.id.fe5);
                        aVar2.tJp = (TextView) view.findViewById(R.id.fe9);
                        aVar2.gtb = (TextView) view.findViewById(R.id.fe8);
                        aVar2.tJq = (CheckBox) view.findViewById(R.id.f9i);
                        if (!TextUtils.isEmpty(Hx.url)) {
                            WalletOrderInfoOldUI.this.tIP.put(Hx.url, aVar2.tJp);
                        }
                        view.setTag(aVar2);
                        aVar = aVar2;
                    }
                } else {
                    aVar = aVar3;
                }
            }
            if (Hx != null) {
                b bVar = (b) WalletOrderInfoOldUI.this.tEH.get(Hx.ttW);
                ab.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(bVar)));
                if (bVar != null) {
                    aVar.kqn.setUrl(bVar.cIY);
                    aVar.gtb.setText(bVar.cEh);
                    aVar.tJp.setText(bVar.tID);
                } else {
                    aVar.kqn.setUrl(Hx.pia);
                    aVar.gtb.setText(Hx.name);
                    aVar.tJp.setText(Hx.tzS);
                }
                if (bo.isNullOrNil(Hx.pcm)) {
                    aVar.tJp.setVisibility(0);
                    if (aVar.tJq != null) {
                        aVar.tJq.setVisibility(8);
                    }
                } else {
                    aVar.tJp.setVisibility(8);
                    if (aVar.tJq != null) {
                        aVar.tJq.setVisibility(0);
                        if (WalletOrderInfoOldUI.this.tIc.contains(Hx.pcm)) {
                            aVar.tJq.setChecked(true);
                        } else {
                            aVar.tJq.setChecked(false);
                        }
                    }
                }
                if (aVar.gne != null && bVar != null && !bo.isNullOrNil(bVar.title)) {
                    aVar.gne.setText(bVar.title);
                } else if (aVar.gne != null && !bo.isNullOrNil(Hx.title)) {
                    aVar.gne.setText(Hx.title);
                } else if (aVar.gne != null) {
                    aVar.gne.setVisibility(8);
                }
                if (!(bo.isNullOrNil(WalletOrderInfoOldUI.this.tEI) || aVar.tJp == null)) {
                    aVar.tJp.setClickable(WalletOrderInfoOldUI.this.ctK);
                    aVar.tJp.setEnabled(WalletOrderInfoOldUI.this.ctK);
                    aVar.tJp.setOnClickListener(null);
                    if (WalletOrderInfoOldUI.this.ctL) {
                        aVar.tJp.setVisibility(8);
                    }
                }
                lJ = WalletOrderInfoOldUI.this.lJ(Hx.ttW);
                if (lJ.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    aVar.tJp.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.a3p));
                    aVar.tJp.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.a61));
                } else if (lJ.equals("-1") || lJ.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    aVar.tJp.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(R.drawable.fy));
                    aVar.tJp.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.a61));
                } else if (lJ.equals("4") || lJ.equals("2") || lJ.equals("1")) {
                    aVar.tJp.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.a3p));
                    aVar.tJp.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.s0));
                } else {
                    ab.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
                }
            }
            if (aVar.tJp != null) {
                int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(WalletOrderInfoOldUI.this.mController.ylL, 15.0f);
                int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(WalletOrderInfoOldUI.this.mController.ylL, 5.0f);
                aVar.tJp.setPadding(b, b2, b, b2);
            }
            AppMethodBeat.o(47496);
            return view;
        }
    }

    class d {
        public String cBT;
        public String pQe;
        public long tBC;
        public String tIF;
        public String tIG;
        public String tIH;
        public String tuv;

        public d(String str, String str2, String str3, String str4, String str5, String str6, long j) {
            this.tuv = str;
            this.tIF = str2;
            this.tIG = str3;
            this.tIH = str4;
            this.cBT = str5;
            this.pQe = str6;
            this.tBC = j;
        }
    }

    public class a extends BaseAdapter {

        class a {
            TextView gnC;
            CdnImageView tEO;
            TextView tEP;
            TextView tEQ;
            TextView tIZ;
            TextView tJa;
            TextView tJb;
            TextView tJc;
            TextView tJd;
            TextView tJe;
            TextView tJf;
            View tJg;
            MaxListView tJh;
            View tJi;
            TextView tJj;
            TextView tJk;
            TextView tJl;
            TextView tJm;
            View tJn;
            ViewGroup tJo;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(47490);
            Commodity Hw = Hw(i);
            AppMethodBeat.o(47490);
            return Hw;
        }

        public final int getCount() {
            AppMethodBeat.i(47487);
            if (WalletOrderInfoOldUI.this.tId != null) {
                int size = WalletOrderInfoOldUI.this.tId.size();
                AppMethodBeat.o(47487);
                return size;
            }
            AppMethodBeat.o(47487);
            return 0;
        }

        private Commodity Hw(int i) {
            AppMethodBeat.i(47488);
            Commodity commodity = (Commodity) WalletOrderInfoOldUI.this.tId.get(i);
            AppMethodBeat.o(47488);
            return commodity;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(47489);
            if (view == null) {
                view = View.inflate(WalletOrderInfoOldUI.this, R.layout.b5c, null);
                a aVar2 = new a();
                aVar2.tIZ = (TextView) view.findViewById(R.id.fdv);
                aVar2.gnC = (TextView) view.findViewById(R.id.fdo);
                aVar2.tJc = (TextView) view.findViewById(R.id.fdh);
                aVar2.tJa = (TextView) view.findViewById(R.id.fdj);
                aVar2.tJb = (TextView) view.findViewById(R.id.fdk);
                aVar2.tJb.getPaint().setFlags(16);
                aVar2.tJd = (TextView) view.findViewById(R.id.fdy);
                aVar2.tJe = (TextView) view.findViewById(R.id.fdu);
                aVar2.tJf = (TextView) view.findViewById(R.id.fdw);
                aVar2.tJh = (MaxListView) view.findViewById(R.id.fe0);
                aVar2.tJi = view.findViewById(R.id.fdl);
                aVar2.tJg = view.findViewById(R.id.fdz);
                aVar2.tJk = (TextView) view.findViewById(R.id.fdq);
                aVar2.tJj = (TextView) view.findViewById(R.id.fdp);
                aVar2.tJl = (TextView) view.findViewById(R.id.fds);
                aVar2.tJm = (TextView) view.findViewById(R.id.fdr);
                aVar2.tJo = (ViewGroup) view.findViewById(R.id.fe2);
                aVar2.tEO = (CdnImageView) view.findViewById(R.id.e2j);
                aVar2.tEP = (TextView) view.findViewById(R.id.fe4);
                aVar2.tEQ = (TextView) view.findViewById(R.id.fe3);
                aVar2.tJn = view.findViewById(R.id.fe1);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            final Commodity Hw = Hw(i);
            if (!(Hw == null || aVar == null)) {
                CharSequence string;
                WalletOrderInfoOldUI.this.pVl = Hw.cAa;
                aVar.tJa.setText(e.e(Hw.kCJ, Hw.pcl));
                if (Hw.tAR < 0.0d || Hw.kCJ >= Hw.tAR) {
                    aVar.tJb.setVisibility(8);
                } else {
                    aVar.tJb.setText(e.e(Hw.tAR, Hw.pcl));
                    aVar.tJb.setVisibility(0);
                }
                LinearLayout linearLayout = (LinearLayout) aVar.tJi;
                List list = Hw.tAU;
                linearLayout.removeAllViews();
                if (list != null && list.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= list.size()) {
                            break;
                        }
                        DiscountInfo discountInfo = (DiscountInfo) list.get(i3);
                        TextView textView = new TextView(WalletOrderInfoOldUI.this.mController.ylL);
                        LayoutParams layoutParams = new LayoutParams(-2, -2);
                        layoutParams.bottomMargin = WalletOrderInfoOldUI.this.mController.ylL.getResources().getDimensionPixelOffset(R.dimen.f15do);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextAppearance(WalletOrderInfoOldUI.this.mController.ylL, R.style.ox);
                        if (discountInfo.tBm > 0.0d) {
                            textView.setText(discountInfo.pOz + e.e(discountInfo.tBm / 100.0d, WalletOrderInfoOldUI.this.tog.pcl));
                        } else {
                            textView.setText(discountInfo.pOz);
                        }
                        linearLayout.addView(textView);
                        textView.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.a4e));
                        i2 = i3 + 1;
                    }
                }
                if (linearLayout.getChildCount() > 0) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                TextView textView2 = aVar.tIZ;
                WalletOrderInfoOldUI walletOrderInfoOldUI = WalletOrderInfoOldUI.this;
                if (r.YM()) {
                    string = walletOrderInfoOldUI.getString(R.string.fl_);
                } else {
                    string = walletOrderInfoOldUI.getString(R.string.fl9);
                }
                textView2.setText(string);
                aVar.tJc.setText(Hw.pca);
                aVar.gnC.setText(Hw.desc);
                aVar.gnC.setTag(Hw.desc);
                aVar.gnC.setOnLongClickListener(WalletOrderInfoOldUI.this.tIV);
                aVar.gnC.setBackgroundResource(R.drawable.a66);
                aVar.tJd.setText(Hw.cAa);
                aVar.tJd.setTag(Hw.cAa);
                aVar.tJd.setOnLongClickListener(WalletOrderInfoOldUI.this.tIV);
                aVar.tJd.setBackgroundResource(R.drawable.a66);
                aVar.tJe.setText(e.kC(Hw.pch));
                aVar.tJf.setText(Hw.pcj);
                String str = Hw.tAV;
                if (aVar.tJl != null) {
                    if (bo.isNullOrNil(str)) {
                        aVar.tJm.setVisibility(8);
                        aVar.tJl.setVisibility(8);
                    } else {
                        aVar.tJl.setText(str);
                        aVar.tJl.setVisibility(0);
                        aVar.tJm.setVisibility(0);
                    }
                }
                str = Hw.tAX;
                if (aVar.tJk != null) {
                    if (bo.isNullOrNil(str)) {
                        aVar.tJj.setVisibility(8);
                        aVar.tJk.setVisibility(8);
                    } else {
                        aVar.tJk.setText(str);
                        aVar.tJk.setVisibility(0);
                        aVar.tJj.setVisibility(0);
                    }
                }
                if (Hw.tBa.size() > 0) {
                    Promotions promotions = (Promotions) Hw.tBa.get(0);
                    h.pYm.e(13033, Integer.valueOf(1), promotions.pcm, promotions.url, promotions.name, WalletOrderInfoOldUI.this.pVl);
                    WalletOrderInfoOldUI.this.tIQ = new c(Hw.tBa);
                    aVar.tJh.setAdapter(WalletOrderInfoOldUI.this.tIQ);
                    aVar.tJh.setOnItemClickListener(new OnItemClickListener() {
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            AppMethodBeat.i(47485);
                            Promotions Hx = WalletOrderInfoOldUI.this.tIQ.Hx(i);
                            if (bo.isNullOrNil(Hx.pcm)) {
                                String lJ = WalletOrderInfoOldUI.this.lJ(Hx.ttW);
                                if ("-1".equals(lJ) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(lJ)) {
                                    h.pYm.e(13472, WalletOrderInfoOldUI.this.pVl, Integer.valueOf(Hx.uZM), Integer.valueOf(1), Long.valueOf(Hx.ttW), Long.valueOf(Hx.tzR));
                                    h.pYm.e(13033, Integer.valueOf(2), "", Hx.url, Hx.name, "");
                                    if (!bo.isNullOrNil(Hx.uZP) && !bo.isNullOrNil(Hx.uZQ)) {
                                        ab.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", Hx.uZP, Hx.uZQ);
                                        se seVar = new se();
                                        seVar.cOf.userName = Hx.uZP;
                                        seVar.cOf.cOh = bo.bc(Hx.uZQ, "");
                                        seVar.cOf.scene = 1060;
                                        seVar.cOf.cst = WalletOrderInfoOldUI.this.oXY;
                                        seVar.cOf.cOi = 0;
                                        com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                        h.pYm.e(14118, WalletOrderInfoOldUI.this.oXY, WalletOrderInfoOldUI.this.cNH(), Integer.valueOf(2));
                                        WalletOrderInfoOldUI.this.tIS = new d(Hx.ttW, Hx.uZN, Hx.tzP, Hx.tzQ, WalletOrderInfoOldUI.this.cNH(), WalletOrderInfoOldUI.this.pVl, Hx.tzR);
                                        WalletOrderInfoOldUI.this.tIT = true;
                                        AppMethodBeat.o(47485);
                                        return;
                                    } else if (Hx.uZM == 1) {
                                        WalletOrderInfoOldUI.this.a(Hx);
                                        AppMethodBeat.o(47485);
                                        return;
                                    } else if (Hx.uZM != 2 || bo.isNullOrNil(Hx.url)) {
                                        ab.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                                    } else if (WalletOrderInfoOldUI.this.tEH.containsKey(Hx.ttW)) {
                                        ab.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", ((b) WalletOrderInfoOldUI.this.tEH.get(Hx.ttW)).url);
                                        WalletOrderInfoOldUI.this.acZ(r0.url);
                                        AppMethodBeat.o(47485);
                                        return;
                                    } else {
                                        WalletOrderInfoOldUI.this.tEI = Hx.url;
                                        WalletOrderInfoOldUI.this.a(Hx.url, new d(Hx.ttW, Hx.uZN, Hx.tzP, Hx.tzQ, WalletOrderInfoOldUI.this.cNH(), WalletOrderInfoOldUI.this.pVl, Hx.tzR));
                                        AppMethodBeat.o(47485);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(47485);
                                return;
                            }
                            if (WalletOrderInfoOldUI.this.tIc.contains(Hx.pcm)) {
                                WalletOrderInfoOldUI.this.tIc.remove(Hx.pcm);
                            } else {
                                WalletOrderInfoOldUI.this.tIc.add(Hx.pcm);
                            }
                            WalletOrderInfoOldUI.this.tIN.notifyDataSetChanged();
                            AppMethodBeat.o(47485);
                        }
                    });
                    WalletOrderInfoOldUI.this.tIQ.notifyDataSetChanged();
                    aVar.tJh.setVisibility(0);
                    aVar.tJg.setVisibility(0);
                } else {
                    aVar.tJh.setVisibility(8);
                    aVar.tJo.setVisibility(8);
                    aVar.tJg.setVisibility(8);
                }
                if (Hw.tAY == null || bo.isNullOrNil(Hw.tAY.tzW)) {
                    aVar.tJo.setVisibility(8);
                    aVar.tJn.setVisibility(8);
                } else {
                    aVar.tEO.setUrl(Hw.tAY.tzU);
                    aVar.tEP.setText(Hw.tAY.tzV);
                    aVar.tEQ.setText(Hw.tAY.ttf);
                    aVar.tJo.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(47486);
                            se seVar = new se();
                            seVar.cOf.userName = Hw.tAY.tzW;
                            seVar.cOf.cOh = bo.bc(Hw.tAY.ttg, "");
                            seVar.cOf.scene = 1034;
                            seVar.cOf.cOi = 0;
                            com.tencent.mm.sdk.b.a.xxA.m(seVar);
                            h.pYm.e(14118, WalletOrderInfoOldUI.this.oXY, WalletOrderInfoOldUI.this.cNH(), Integer.valueOf(1));
                            AppMethodBeat.o(47486);
                        }
                    });
                    aVar.tJn.setVisibility(0);
                }
            }
            AppMethodBeat.o(47489);
            return view;
        }
    }

    class b {
        public String cEh;
        public String cIY;
        public String tID;
        public String title;
        public String url;

        public b(JSONObject jSONObject) {
            AppMethodBeat.i(47491);
            if (jSONObject == null) {
                AppMethodBeat.o(47491);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
            if (optJSONObject != null) {
                this.url = optJSONObject.optString("url");
                this.cEh = optJSONObject.optString("wording");
                this.cIY = optJSONObject.optString("icon");
                this.tID = optJSONObject.optString("btn_text");
                this.title = optJSONObject.optString("title");
            }
            AppMethodBeat.o(47491);
        }

        public final String toString() {
            AppMethodBeat.i(47492);
            String str = this.url + " , " + this.cEh + " , " + this.cIY + " , " + this.tID + " , " + this.title;
            AppMethodBeat.o(47492);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOrderInfoOldUI() {
        AppMethodBeat.i(47498);
        AppMethodBeat.o(47498);
    }

    public final int getLayoutId() {
        return R.layout.b5b;
    }

    private void Kh() {
        int i = 1;
        AppMethodBeat.i(47499);
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.oXY = this.mBundle.getString("key_trans_id");
        this.mBundle.getInt("key_pay_type", -1);
        ab.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", this.oXY);
        this.tog = cRD();
        if (this.tog != null) {
            AM(0);
            d(this.tog);
            if (!(aE == null || this.tog == null || this.pVL == null)) {
                boolean z;
                this.mAppId = this.pVL.appId;
                boolean dNG = aE.dNG();
                com.tencent.mm.plugin.wallet_core.utils.d.a(this, this.mBundle, 7);
                int i2 = this.mBundle.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                h hVar = h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.pVL.cIf);
                if (this.pVL.cIf == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (!dNG) {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(z.dNX());
                objArr[4] = Integer.valueOf((int) (this.tog.pTN * 100.0d));
                objArr[5] = this.tog.pcl;
                objArr[6] = Integer.valueOf(i2);
                hVar.e(10691, objArr);
            }
            if (!((com.tencent.mm.plugin.wallet_core.model.r.cPI().cQg() || aE == null || !aE.dNG()) && r.YI())) {
                r.YJ();
            }
            if (this.tog == null || this.tog.tAq == null || this.tog.tAq.size() <= 0) {
                ab.c("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.fkw, 0, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(47473);
                        WalletOrderInfoOldUI.this.done();
                        AppMethodBeat.o(47473);
                    }
                });
            } else {
                this.tId = this.tog.tAq;
                this.oXY = ((Commodity) this.tId.get(0)).cAa;
                if (!(this.pVL == null || aE == null || (!aE.dNF() && !aE.dNG()))) {
                    cRI();
                }
            }
            if (this.oXY == null) {
                if (((i) g.K(i.class)).g(this)) {
                    this.tIT = false;
                }
                AppMethodBeat.o(47499);
                return;
            }
        }
        ab.c("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.fkw, 0, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(47476);
                WalletOrderInfoOldUI.this.finish();
                AppMethodBeat.o(47476);
            }
        });
        AppMethodBeat.o(47499);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47500);
        super.onCreate(bundle);
        AM(4);
        this.tIc = new HashSet();
        Kh();
        initView();
        nf(1979);
        com.tencent.mm.sdk.b.a.xxA.c(this.tIy);
        com.tencent.mm.sdk.b.a.xxA.c(this.pap);
        this.tIT = false;
        AppMethodBeat.o(47500);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cRI() {
        AppMethodBeat.i(47502);
        a(new y(cNH(), 21), true, true);
        AppMethodBeat.o(47502);
    }

    /* Access modifiers changed, original: protected */
    public void adb(String str) {
        AppMethodBeat.i(47503);
        a(new com.tencent.mm.plugin.wallet_core.c.z(str), true, true);
        AppMethodBeat.o(47503);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dt(String str, int i) {
        AppMethodBeat.i(47504);
        a(new com.tencent.mm.plugin.wallet_core.c.z(str, i), true, true);
        AppMethodBeat.o(47504);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Promotions promotions) {
        AppMethodBeat.i(47505);
        a(new n(promotions, cNH(), this.oXY, promotions.tzR), true, false);
        AppMethodBeat.o(47505);
    }

    private void d(Orders orders) {
        AppMethodBeat.i(47506);
        this.tIc.clear();
        if (orders == null || orders.tAq == null) {
            ab.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
            AppMethodBeat.o(47506);
            return;
        }
        for (Commodity commodity : orders.tAq) {
            if (commodity.tAh == 2 && !bo.isNullOrNil(commodity.tAS)) {
                ab.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
                this.tIc.add(commodity.tAS);
            }
        }
        AppMethodBeat.o(47506);
    }

    public final void initView() {
        AppMethodBeat.i(47507);
        setMMTitle((int) R.string.flt);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(R.string.qt);
        if (this.pVL == null || this.pVL.cIf != 2) {
            if (!(this.tog == null || bo.isNullOrNil(this.tog.tAB))) {
                string = this.tog.tAB;
            }
        } else if (!bo.isNullOrNil(this.pVL.tRb)) {
            string = getString(R.string.g1) + this.pVL.tRb;
        } else if (!(bo.isNullOrNil(this.pVL.appId) || bo.isNullOrNil(com.tencent.mm.pluginsdk.model.app.g.t(this, this.pVL.appId)))) {
            string = getString(R.string.g1) + com.tencent.mm.pluginsdk.model.app.g.t(this, this.pVL.appId);
        }
        addTextOptionMenu(0, string, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47480);
                WalletOrderInfoOldUI.this.done();
                AppMethodBeat.o(47480);
                return true;
            }
        });
        this.tIK = (LinearLayout) findViewById(R.id.fdd);
        this.tIL = (TextView) findViewById(R.id.fde);
        this.tIM = (TextView) findViewById(R.id.fdg);
        MaxListView maxListView = (MaxListView) findViewById(R.id.fdf);
        this.tIN = new a();
        maxListView.setAdapter(this.tIN);
        cRJ();
        cRK();
        ((ScrollView) findViewById(R.id.bb_)).pageScroll(33);
        AppMethodBeat.o(47507);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRJ() {
        AppMethodBeat.i(47508);
        if (this.tog != null) {
            int i;
            this.tId = this.tog.tAq;
            for (Commodity commodity : this.tId) {
                if ("1".equals(commodity.pce)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.tIK.setVisibility(0);
            this.tIL.setVisibility(0);
            if (i == 0) {
                this.tIL.setText(R.string.flg);
            } else if (!bo.isNullOrNil(this.tog.tAj) && !bo.isNullOrNil(this.tog.tAj.trim())) {
                this.tIL.setText(this.tog.tAj);
                AppMethodBeat.o(47508);
                return;
            } else if (this.tog.tuo != 1) {
                this.tIL.setText(R.string.flf);
                AppMethodBeat.o(47508);
                return;
            } else {
                this.tIL.setText(R.string.fle);
                AppMethodBeat.o(47508);
                return;
            }
        }
        AppMethodBeat.o(47508);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, d dVar) {
        AppMethodBeat.i(47509);
        cRq();
        this.tIS = dVar;
        e.a((Context) this, str, false, 1);
        this.tIT = false;
        AppMethodBeat.o(47509);
    }

    /* Access modifiers changed, original: protected|final */
    public final void acZ(String str) {
        AppMethodBeat.i(47510);
        cRq();
        e.n(this, str, false);
        this.tIT = false;
        AppMethodBeat.o(47510);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRq() {
        int i = 0;
        AppMethodBeat.i(47511);
        if (!this.tEC) {
            iy iyVar = new iy();
            iyVar.cEc.requestCode = 4;
            com.tencent.mm.g.a.iy.a aVar = iyVar.cEc;
            if (this.mBundle.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bFZ = i;
            com.tencent.mm.sdk.b.a.xxA.m(iyVar);
            this.tEC = true;
        }
        AppMethodBeat.o(47511);
    }

    /* Access modifiers changed, original: protected|final */
    public final void S(ad adVar) {
        AppMethodBeat.i(47512);
        if (!(adVar == null || ((int) adVar.ewQ) == 0)) {
            String Oi = adVar.Oi();
            ab.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + Oi + " username: " + adVar.field_username);
            if (this.tId != null && this.tId.size() > 0) {
                for (Commodity commodity : this.tId) {
                    commodity.pcm = Oi;
                }
                this.tIN.notifyDataSetChanged();
            }
            this.igi = adVar.field_username;
        }
        AppMethodBeat.o(47512);
    }

    public void onDestroy() {
        AppMethodBeat.i(47513);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.tIy);
        com.tencent.mm.sdk.b.a.xxA.d(this.pap);
        ng(1979);
        AppMethodBeat.o(47513);
    }

    public final void cRH() {
        AppMethodBeat.i(47515);
        cRq();
        this.tIT = false;
        ap apVar = new ap();
        apVar.ctF.ctG = true;
        com.tencent.mm.sdk.b.a.xxA.m(apVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.mBundle.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.mBundle.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.mBundle.getBoolean("intent_pay_end"));
        ab.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + this.mBundle.getInt("intent_pay_end_errcode"));
        for (String str : this.tIc) {
            if (!bo.isNullOrNil(str)) {
                ab.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", str);
                if (this.tog == null || this.pVL == null) {
                    g.RO().eJo.a(new com.tencent.mm.wallet_core.c.r(str), 0);
                } else {
                    String str2;
                    p pVar = g.RO().eJo;
                    String str3 = this.tog.czZ;
                    if (this.tog.tAq.size() > 0) {
                        str2 = ((Commodity) this.tog.tAq.get(0)).cAa;
                    } else {
                        str2 = "";
                    }
                    pVar.a(new com.tencent.mm.wallet_core.c.r(str, str3, str2, this.pVL.cIf, this.pVL.cIb, this.tog.tAh), 0);
                }
            }
            h.pYm.e(13033, Integer.valueOf(2), str, "", "", "");
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        if (!(this.tog == null || bo.isNullOrNil(this.tog.lvz))) {
            String d = WalletOrderInfoUI.d(this.tog.lvz, this.tog.czZ, this.tog.tAq.size() > 0 ? ((Commodity) this.tog.tAq.get(0)).cAa : "", this.pVL.kck, this.pVL.hHV);
            ab.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(d)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", r.Yz());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.bp.d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(47515);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47516);
        if (i == 4) {
            done();
            AppMethodBeat.o(47516);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(47516);
        return onKeyUp;
    }

    public void onResume() {
        AppMethodBeat.i(47518);
        super.onResume();
        ab.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", Boolean.valueOf(this.tIT));
        if (this.tIT) {
            a(new aa(this.tIS.tuv, this.tIS.tIF, this.tIS.tIG, this.tIS.tIH, this.tIS.cBT, this.tIS.pQe, this.tIS.tBC), true, true);
        }
        AppMethodBeat.o(47518);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(47519);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            a(new aa(this.tIS.tuv, this.tIS.tIF, this.tIS.tIG, this.tIS.tIH, this.tIS.cBT, this.tIS.pQe, this.tIS.tBC), true, true);
        }
        AppMethodBeat.o(47519);
    }

    private void cRK() {
        AppMethodBeat.i(47520);
        if (this.tog == null || this.tog.tAq == null || this.tog.tAq.size() <= 0 || ((Commodity) this.tog.tAq.get(0)).tBc == null || bo.isNullOrNil(((Commodity) this.tog.tAq.get(0)).tBc.text) || bo.isNullOrNil(((Commodity) this.tog.tAq.get(0)).tBc.url)) {
            ab.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
            this.tIM.setVisibility(8);
            AppMethodBeat.o(47520);
            return;
        }
        this.tIM.setVisibility(0);
        this.tIM.setText(((Commodity) this.tog.tAq.get(0)).tBc.text);
        this.tIM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47483);
                e.n(WalletOrderInfoOldUI.this, ((Commodity) WalletOrderInfoOldUI.this.tog.tAq.get(0)).tBc.url, false);
                AppMethodBeat.o(47483);
            }
        });
        AppMethodBeat.o(47520);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47521);
        if ((mVar instanceof aa) && i == 0 && i2 == 0) {
            boolean z;
            aa aaVar = (aa) mVar;
            b bVar = new b(aaVar.hwh);
            if (bo.isNullOrNil(bVar.url) || bo.isNullOrNil(bVar.cEh)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.tEH.put(aaVar.tuv, bVar);
            }
            this.tIN.notifyDataSetChanged();
        }
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.z) {
            if (i == 0 && i2 == 0) {
                AM(0);
                this.tog = ((com.tencent.mm.plugin.wallet_core.c.z) mVar).tux;
                if (this.tog != null) {
                    this.tId = this.tog.tAq;
                }
                d(this.tog);
                ab.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.tId);
                if (!(this.tId == null || this.tId.size() == 0)) {
                    Commodity commodity = (Commodity) this.tId.get(0);
                    this.oXY = commodity.cAa;
                    ab.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + commodity.toString());
                    ad aoO = ((j) g.K(j.class)).XM().aoO(commodity.pcm);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        com.tencent.mm.model.ao.a.flu.a(commodity.pcm, "", this.tIU);
                    } else {
                        S(aoO);
                    }
                    this.tIN.notifyDataSetChanged();
                    cRJ();
                }
            }
            if (this.tIN != null) {
                this.tIN.notifyDataSetChanged();
            }
            cRK();
            AppMethodBeat.o(47521);
            return true;
        }
        if (mVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) mVar;
                String str2 = nVar.tud;
                this.tIR.put(Long.valueOf(nVar.tug.ttW), str2);
                nVar.tug.tzS = nVar.ehr;
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !bo.isNullOrNil(nVar.tue)) {
                    com.tencent.mm.ui.base.h.b((Context) this, nVar.tue, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    CharSequence string;
                    if (bo.isNullOrNil(nVar.tue)) {
                        string = getString(R.string.fns);
                    } else {
                        string = nVar.tue;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.tIN.notifyDataSetChanged();
                AppMethodBeat.o(47521);
                return true;
            } else if (mVar instanceof n) {
                if (bo.isNullOrNil(str)) {
                    str = getString(R.string.fu2);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(47521);
                return true;
            }
        }
        AppMethodBeat.o(47521);
        return false;
    }

    public final String lJ(long j) {
        AppMethodBeat.i(47522);
        String str;
        if (this.tIR.containsKey(Long.valueOf(j))) {
            str = (String) this.tIR.get(Long.valueOf(j));
            AppMethodBeat.o(47522);
            return str;
        }
        str = "-1";
        AppMethodBeat.o(47522);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public Orders cRD() {
        AppMethodBeat.i(47501);
        Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
        AppMethodBeat.o(47501);
        return orders;
    }

    public void done() {
        AppMethodBeat.i(47514);
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(47481);
                        WalletOrderInfoOldUI.this.cRH();
                        AppMethodBeat.o(47481);
                    }
                });
                this.mBundle.remove("key_realname_guide_helper");
                if (!b) {
                    cRH();
                }
            }
            AppMethodBeat.o(47514);
            return;
        }
        cRH();
        AppMethodBeat.o(47514);
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.i(47517);
        Dialog a = com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(R.string.fla), getResources().getStringArray(R.array.au), "", new com.tencent.mm.ui.base.h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(47482);
                switch (i) {
                    case 0:
                        WalletOrderInfoOldUI.this.tIT = false;
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoOldUI.this.pdC).toString()));
                        intent.addFlags(268435456);
                        WalletOrderInfoOldUI.this.startActivity(intent);
                        break;
                }
                AppMethodBeat.o(47482);
            }
        });
        AppMethodBeat.o(47517);
        return a;
    }
}

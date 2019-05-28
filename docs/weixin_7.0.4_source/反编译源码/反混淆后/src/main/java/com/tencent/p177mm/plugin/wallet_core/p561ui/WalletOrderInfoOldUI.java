package com.tencent.p177mm.plugin.wallet_core.p561ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p230g.p231a.C18216ap;
import com.tencent.p177mm.p230g.p231a.C18218aq;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C45334iy;
import com.tencent.p177mm.p230g.p231a.C45334iy.C26168a;
import com.tencent.p177mm.p230g.p231a.C9489us;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MaxListView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11927i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22564z;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.C40093aa;
import com.tencent.p177mm.plugin.wallet_core.p749c.C46360n;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1079f.C14832a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44431r;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI */
public class WalletOrderInfoOldUI extends WalletOrderInfoUI {
    protected boolean ctK = true;
    protected boolean ctL = false;
    protected boolean ctM = false;
    protected String igi = null;
    protected String mAppId = "";
    protected String oXY;
    protected PayInfo pVL;
    private String pVl;
    private C4884c pap = new C354955();
    protected String pdC = null;
    protected boolean tEC = false;
    private HashMap<String, C35499b> tEH = new HashMap();
    protected String tEI;
    protected LinearLayout tIK = null;
    protected TextView tIL = null;
    protected TextView tIM = null;
    protected C35497a tIN = null;
    protected String tIO = null;
    protected HashMap<String, TextView> tIP = new HashMap();
    protected C29659c tIQ;
    protected Map<Long, String> tIR = new HashMap();
    private C29660d tIS;
    private boolean tIT = false;
    protected C9636a tIU = new C354966();
    private OnLongClickListener tIV = new C2260811();
    protected Set<String> tIc = null;
    protected List<Commodity> tId = null;
    private C4884c tIy = new C354933();
    protected Orders tog;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$10 */
    class C2260710 implements OnClickListener {
        C2260710() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47483);
            C36391e.m60016n(WalletOrderInfoOldUI.this, ((Commodity) WalletOrderInfoOldUI.this.tog.tAq.get(0)).tBc.url, false);
            AppMethodBeat.m2505o(47483);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$11 */
    class C2260811 implements OnLongClickListener {
        C2260811() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(47484);
            if (view.getId() == 2131828930 || view.getId() == 2131828940) {
                try {
                    String str = (String) view.getTag();
                    Toast.makeText(WalletOrderInfoOldUI.this, C25738R.string.fkm, 0).show();
                    C14832a.m23084b(str, str);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(47484);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$2 */
    class C226092 implements DialogInterface.OnClickListener {
        C226092() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$7 */
    class C226107 implements OnMenuItemClickListener {
        C226107() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47480);
            WalletOrderInfoOldUI.this.done();
            AppMethodBeat.m2505o(47480);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$8 */
    class C226118 implements DialogInterface.OnClickListener {
        C226118() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47481);
            WalletOrderInfoOldUI.this.cRH();
            AppMethodBeat.m2505o(47481);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$9 */
    class C226129 implements C30391c {
        C226129() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(47482);
            switch (i) {
                case 0:
                    WalletOrderInfoOldUI.this.tIT = false;
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoOldUI.this.pdC).toString()));
                    intent.addFlags(268435456);
                    WalletOrderInfoOldUI.this.startActivity(intent);
                    break;
            }
            AppMethodBeat.m2505o(47482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$1 */
    class C296571 implements DialogInterface.OnClickListener {
        C296571() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47473);
            WalletOrderInfoOldUI.this.done();
            AppMethodBeat.m2505o(47473);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$c */
    class C29659c extends BaseAdapter {
        protected List<Promotions> tBa;

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$c$a */
        class C29658a {
            TextView gne;
            TextView gtb;
            CdnImageView kqn;
            int tBn;
            TextView tJp;
            CheckBox tJq;
            int type;

            C29658a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(47497);
            Promotions Hx = mo47907Hx(i);
            AppMethodBeat.m2505o(47497);
            return Hx;
        }

        public C29659c(List<Promotions> list) {
            AppMethodBeat.m2504i(47493);
            this.tBa = null;
            this.tBa = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Promotions promotions = (Promotions) list.get(i);
                if (promotions != null && (!C5046bo.isNullOrNil(promotions.pcm) || promotions.uZM == 2 || promotions.uZM == 1)) {
                    this.tBa.add(list.get(i));
                }
            }
            AppMethodBeat.m2505o(47493);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47494);
            if (this.tBa != null) {
                int size = this.tBa.size();
                AppMethodBeat.m2505o(47494);
                return size;
            }
            AppMethodBeat.m2505o(47494);
            return 0;
        }

        /* renamed from: Hx */
        public final Promotions mo47907Hx(int i) {
            AppMethodBeat.m2504i(47495);
            Promotions promotions = (Promotions) this.tBa.get(i);
            AppMethodBeat.m2505o(47495);
            return promotions;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            String lJ;
            C29658a c29658a;
            AppMethodBeat.m2504i(47496);
            Promotions Hx = mo47907Hx(i);
            if (C5046bo.isNullOrNil(Hx.pcm) && Hx.ttW > 0) {
                lJ = WalletOrderInfoOldUI.this.mo56235lJ(Hx.ttW);
                C7060h c7060h = C7060h.pYm;
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
                c7060h.mo8381e(13471, objArr);
            }
            C29658a c29658a2;
            View inflate;
            View view2;
            if (view == null) {
                c29658a2 = new C29658a();
                c29658a2.type = Hx.type;
                if (Hx.type == Orders.tAQ) {
                    if (Hx.tBn == 1) {
                        inflate = View.inflate(WalletOrderInfoOldUI.this, 2130971140, null);
                        c29658a2.kqn = (CdnImageView) inflate.findViewById(2131828947);
                        c29658a2.gne = (TextView) inflate.findViewById(2131828949);
                        c29658a2.tJp = (TextView) inflate.findViewById(2131828951);
                        c29658a2.gtb = (TextView) inflate.findViewById(2131828950);
                        if (!TextUtils.isEmpty(Hx.url)) {
                            WalletOrderInfoOldUI.this.tIP.put(Hx.url, c29658a2.tJp);
                        }
                        inflate.setTag(c29658a2);
                        view2 = inflate;
                    } else {
                        inflate = View.inflate(WalletOrderInfoOldUI.this, 2130971141, null);
                        c29658a2.kqn = (CdnImageView) inflate.findViewById(2131828947);
                        c29658a2.tJp = (TextView) inflate.findViewById(2131828951);
                        c29658a2.gtb = (TextView) inflate.findViewById(2131828950);
                        c29658a2.gne = (TextView) inflate.findViewById(2131828949);
                        if (!TextUtils.isEmpty(Hx.url)) {
                            WalletOrderInfoOldUI.this.tIP.put(Hx.url, c29658a2.tJp);
                        }
                        inflate.setTag(c29658a2);
                        view2 = inflate;
                    }
                    c29658a2.tBn = Hx.tBn;
                    view = view2;
                    c29658a = c29658a2;
                } else {
                    view = View.inflate(WalletOrderInfoOldUI.this, 2130971142, null);
                    c29658a2.kqn = (CdnImageView) view.findViewById(2131828947);
                    c29658a2.tJp = (TextView) view.findViewById(2131828951);
                    c29658a2.gtb = (TextView) view.findViewById(2131828950);
                    c29658a2.tJq = (CheckBox) view.findViewById(2131828739);
                    if (!TextUtils.isEmpty(Hx.url)) {
                        WalletOrderInfoOldUI.this.tIP.put(Hx.url, c29658a2.tJp);
                    }
                    view.setTag(c29658a2);
                    c29658a = c29658a2;
                }
            } else {
                C29658a c29658a3 = (C29658a) view.getTag();
                int i2 = 0;
                if (Hx.type == c29658a3.type && (Hx.type != Orders.tAQ || Hx.tBn == c29658a3.tBn)) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    c29658a2 = new C29658a();
                    c29658a2.type = Hx.type;
                    if (Hx.type == Orders.tAQ) {
                        if (Hx.tBn == 1) {
                            inflate = View.inflate(WalletOrderInfoOldUI.this, 2130971140, null);
                            c29658a2.kqn = (CdnImageView) inflate.findViewById(2131828947);
                            c29658a2.gne = (TextView) inflate.findViewById(2131828949);
                            c29658a2.tJp = (TextView) inflate.findViewById(2131828951);
                            c29658a2.gtb = (TextView) inflate.findViewById(2131828950);
                            if (!TextUtils.isEmpty(Hx.url)) {
                                WalletOrderInfoOldUI.this.tIP.put(Hx.url, c29658a2.tJp);
                            }
                            inflate.setTag(c29658a2);
                            view2 = inflate;
                        } else {
                            inflate = View.inflate(WalletOrderInfoOldUI.this, 2130971141, null);
                            c29658a2.kqn = (CdnImageView) inflate.findViewById(2131828947);
                            c29658a2.tJp = (TextView) inflate.findViewById(2131828951);
                            c29658a2.gtb = (TextView) inflate.findViewById(2131828950);
                            c29658a2.gne = (TextView) inflate.findViewById(2131828949);
                            if (!TextUtils.isEmpty(Hx.url)) {
                                WalletOrderInfoOldUI.this.tIP.put(Hx.url, c29658a2.tJp);
                            }
                            inflate.setTag(c29658a2);
                            view2 = inflate;
                        }
                        c29658a2.tBn = Hx.tBn;
                        view = view2;
                        c29658a = c29658a2;
                    } else {
                        view = View.inflate(WalletOrderInfoOldUI.this, 2130971142, null);
                        c29658a2.kqn = (CdnImageView) view.findViewById(2131828947);
                        c29658a2.tJp = (TextView) view.findViewById(2131828951);
                        c29658a2.gtb = (TextView) view.findViewById(2131828950);
                        c29658a2.tJq = (CheckBox) view.findViewById(2131828739);
                        if (!TextUtils.isEmpty(Hx.url)) {
                            WalletOrderInfoOldUI.this.tIP.put(Hx.url, c29658a2.tJp);
                        }
                        view.setTag(c29658a2);
                        c29658a = c29658a2;
                    }
                } else {
                    c29658a = c29658a3;
                }
            }
            if (Hx != null) {
                C35499b c35499b = (C35499b) WalletOrderInfoOldUI.this.tEH.get(Hx.ttW);
                C4990ab.m7416i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(c35499b)));
                if (c35499b != null) {
                    c29658a.kqn.setUrl(c35499b.cIY);
                    c29658a.gtb.setText(c35499b.cEh);
                    c29658a.tJp.setText(c35499b.tID);
                } else {
                    c29658a.kqn.setUrl(Hx.pia);
                    c29658a.gtb.setText(Hx.name);
                    c29658a.tJp.setText(Hx.tzS);
                }
                if (C5046bo.isNullOrNil(Hx.pcm)) {
                    c29658a.tJp.setVisibility(0);
                    if (c29658a.tJq != null) {
                        c29658a.tJq.setVisibility(8);
                    }
                } else {
                    c29658a.tJp.setVisibility(8);
                    if (c29658a.tJq != null) {
                        c29658a.tJq.setVisibility(0);
                        if (WalletOrderInfoOldUI.this.tIc.contains(Hx.pcm)) {
                            c29658a.tJq.setChecked(true);
                        } else {
                            c29658a.tJq.setChecked(false);
                        }
                    }
                }
                if (c29658a.gne != null && c35499b != null && !C5046bo.isNullOrNil(c35499b.title)) {
                    c29658a.gne.setText(c35499b.title);
                } else if (c29658a.gne != null && !C5046bo.isNullOrNil(Hx.title)) {
                    c29658a.gne.setText(Hx.title);
                } else if (c29658a.gne != null) {
                    c29658a.gne.setVisibility(8);
                }
                if (!(C5046bo.isNullOrNil(WalletOrderInfoOldUI.this.tEI) || c29658a.tJp == null)) {
                    c29658a.tJp.setClickable(WalletOrderInfoOldUI.this.ctK);
                    c29658a.tJp.setEnabled(WalletOrderInfoOldUI.this.ctK);
                    c29658a.tJp.setOnClickListener(null);
                    if (WalletOrderInfoOldUI.this.ctL) {
                        c29658a.tJp.setVisibility(8);
                    }
                }
                lJ = WalletOrderInfoOldUI.this.mo56235lJ(Hx.ttW);
                if (lJ.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    c29658a.tJp.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(C25738R.color.a3p));
                    c29658a.tJp.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(C25738R.color.a61));
                } else if (lJ.equals("-1") || lJ.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    c29658a.tJp.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(C25738R.drawable.f6492fy));
                    c29658a.tJp.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(C25738R.color.a61));
                } else if (lJ.equals("4") || lJ.equals("2") || lJ.equals("1")) {
                    c29658a.tJp.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(C25738R.color.a3p));
                    c29658a.tJp.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(C25738R.color.f12092s0));
                } else {
                    C4990ab.m7412e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
                }
            }
            if (c29658a.tJp != null) {
                int b = C4977b.m7371b(WalletOrderInfoOldUI.this.mController.ylL, 15.0f);
                int b2 = C4977b.m7371b(WalletOrderInfoOldUI.this.mController.ylL, 5.0f);
                c29658a.tJp.setPadding(b, b2, b, b2);
            }
            AppMethodBeat.m2505o(47496);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$d */
    class C29660d {
        public String cBT;
        public String pQe;
        public long tBC;
        public String tIF;
        public String tIG;
        public String tIH;
        public String tuv;

        public C29660d(String str, String str2, String str3, String str4, String str5, String str6, long j) {
            this.tuv = str;
            this.tIF = str2;
            this.tIG = str3;
            this.tIH = str4;
            this.cBT = str5;
            this.pQe = str6;
            this.tBC = j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$3 */
    class C354933 extends C4884c<C18218aq> {
        C354933() {
            AppMethodBeat.m2504i(47474);
            this.xxI = C18218aq.class.getName().hashCode();
            AppMethodBeat.m2505o(47474);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47475);
            C18218aq c18218aq = (C18218aq) c4883b;
            if (c18218aq instanceof C18218aq) {
                WalletOrderInfoOldUI.this.tIO = c18218aq.ctH.ctJ;
                WalletOrderInfoOldUI.this.ctK = c18218aq.ctH.ctK;
                WalletOrderInfoOldUI.this.ctL = c18218aq.ctH.ctL;
                WalletOrderInfoOldUI.this.ctM = c18218aq.ctH.ctM;
                if (WalletOrderInfoOldUI.this.ctM && !C5046bo.isNullOrNil(WalletOrderInfoOldUI.this.tEI)) {
                    for (int i = 0; i < WalletOrderInfoOldUI.this.tId.size(); i++) {
                        Commodity commodity = (Commodity) WalletOrderInfoOldUI.this.tId.get(i);
                        int i2 = -1;
                        for (int i3 = 0; i3 < commodity.tBa.size(); i3++) {
                            Promotions promotions = (Promotions) commodity.tBa.get(i3);
                            if (promotions.type == Orders.tAQ && !C5046bo.isNullOrNil(promotions.url) && promotions.url.equals(WalletOrderInfoOldUI.this.tEI)) {
                                i2 = i3;
                            }
                        }
                        if (i2 >= 0) {
                            commodity.tBa.remove(i2);
                        }
                    }
                }
                WalletOrderInfoOldUI.this.tIN.notifyDataSetChanged();
                if (!C5046bo.isNullOrNil(WalletOrderInfoOldUI.this.tEI)) {
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
                c18218aq.ctI.csN = true;
            }
            AppMethodBeat.m2505o(47475);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$4 */
    class C354944 implements DialogInterface.OnClickListener {
        C354944() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47476);
            WalletOrderInfoOldUI.this.finish();
            AppMethodBeat.m2505o(47476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$5 */
    class C354955 extends C4884c<C9489us> {
        C354955() {
            AppMethodBeat.m2504i(47477);
            this.xxI = C9489us.class.getName().hashCode();
            AppMethodBeat.m2505o(47477);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47478);
            C9489us c9489us = (C9489us) c4883b;
            if (c9489us instanceof C9489us) {
                if (!c9489us.cRy.cRz.oZd) {
                    C4990ab.m7416i("MicroMsg.WalletOrderInfoOldUI", "block pass");
                    AppMethodBeat.m2505o(47478);
                    return true;
                } else if ("1".equals(c9489us.cRy.cRz.cRb) || "2".equals(c9489us.cRy.cRz.cRb)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.mo74571a(c9489us.cRy.cRz.cRb, c9489us.cRy.cRz.cRc, c9489us.cRy.cRz.cRd, c9489us.cRy.cRz.cRe, c9489us.cRy.cRz.cRf, WalletOrderInfoOldUI.this.pVL == null ? 0 : WalletOrderInfoOldUI.this.pVL.cIf);
                    C4990ab.m7416i("MicroMsg.WalletOrderInfoOldUI", "receive guide");
                    WalletOrderInfoOldUI.this.mBundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.m2505o(47478);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$6 */
    class C354966 implements C9636a {
        C354966() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(47479);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            C4990ab.m7410d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoOldUI.this.mo47912S(aoO);
            AppMethodBeat.m2505o(47479);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$a */
    public class C35497a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$a$1 */
        class C354921 implements OnItemClickListener {
            C354921() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(47485);
                Promotions Hx = WalletOrderInfoOldUI.this.tIQ.mo47907Hx(i);
                if (C5046bo.isNullOrNil(Hx.pcm)) {
                    String lJ = WalletOrderInfoOldUI.this.mo56235lJ(Hx.ttW);
                    if ("-1".equals(lJ) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(lJ)) {
                        C7060h.pYm.mo8381e(13472, WalletOrderInfoOldUI.this.pVl, Integer.valueOf(Hx.uZM), Integer.valueOf(1), Long.valueOf(Hx.ttW), Long.valueOf(Hx.tzR));
                        C7060h.pYm.mo8381e(13033, Integer.valueOf(2), "", Hx.url, Hx.name, "");
                        if (!C5046bo.isNullOrNil(Hx.uZP) && !C5046bo.isNullOrNil(Hx.uZQ)) {
                            C4990ab.m7417i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", Hx.uZP, Hx.uZQ);
                            C32628se c32628se = new C32628se();
                            c32628se.cOf.userName = Hx.uZP;
                            c32628se.cOf.cOh = C5046bo.m7532bc(Hx.uZQ, "");
                            c32628se.cOf.scene = 1060;
                            c32628se.cOf.cst = WalletOrderInfoOldUI.this.oXY;
                            c32628se.cOf.cOi = 0;
                            C4879a.xxA.mo10055m(c32628se);
                            C7060h.pYm.mo8381e(14118, WalletOrderInfoOldUI.this.oXY, WalletOrderInfoOldUI.this.cNH(), Integer.valueOf(2));
                            WalletOrderInfoOldUI.this.tIS = new C29660d(Hx.ttW, Hx.uZN, Hx.tzP, Hx.tzQ, WalletOrderInfoOldUI.this.cNH(), WalletOrderInfoOldUI.this.pVl, Hx.tzR);
                            WalletOrderInfoOldUI.this.tIT = true;
                            AppMethodBeat.m2505o(47485);
                            return;
                        } else if (Hx.uZM == 1) {
                            WalletOrderInfoOldUI.this.mo56227a(Hx);
                            AppMethodBeat.m2505o(47485);
                            return;
                        } else if (Hx.uZM != 2 || C5046bo.isNullOrNil(Hx.url)) {
                            C4990ab.m7412e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                        } else if (WalletOrderInfoOldUI.this.tEH.containsKey(Hx.ttW)) {
                            C4990ab.m7417i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", ((C35499b) WalletOrderInfoOldUI.this.tEH.get(Hx.ttW)).url);
                            WalletOrderInfoOldUI.this.acZ(r0.url);
                            AppMethodBeat.m2505o(47485);
                            return;
                        } else {
                            WalletOrderInfoOldUI.this.tEI = Hx.url;
                            WalletOrderInfoOldUI.this.mo56228a(Hx.url, new C29660d(Hx.ttW, Hx.uZN, Hx.tzP, Hx.tzQ, WalletOrderInfoOldUI.this.cNH(), WalletOrderInfoOldUI.this.pVl, Hx.tzR));
                            AppMethodBeat.m2505o(47485);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(47485);
                    return;
                }
                if (WalletOrderInfoOldUI.this.tIc.contains(Hx.pcm)) {
                    WalletOrderInfoOldUI.this.tIc.remove(Hx.pcm);
                } else {
                    WalletOrderInfoOldUI.this.tIc.add(Hx.pcm);
                }
                WalletOrderInfoOldUI.this.tIN.notifyDataSetChanged();
                AppMethodBeat.m2505o(47485);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$a$a */
        class C35498a {
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

            C35498a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(47490);
            Commodity Hw = m58262Hw(i);
            AppMethodBeat.m2505o(47490);
            return Hw;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47487);
            if (WalletOrderInfoOldUI.this.tId != null) {
                int size = WalletOrderInfoOldUI.this.tId.size();
                AppMethodBeat.m2505o(47487);
                return size;
            }
            AppMethodBeat.m2505o(47487);
            return 0;
        }

        /* renamed from: Hw */
        private Commodity m58262Hw(int i) {
            AppMethodBeat.m2504i(47488);
            Commodity commodity = (Commodity) WalletOrderInfoOldUI.this.tId.get(i);
            AppMethodBeat.m2505o(47488);
            return commodity;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C35498a c35498a;
            AppMethodBeat.m2504i(47489);
            if (view == null) {
                view = View.inflate(WalletOrderInfoOldUI.this, 2130971139, null);
                C35498a c35498a2 = new C35498a();
                c35498a2.tIZ = (TextView) view.findViewById(2131828937);
                c35498a2.gnC = (TextView) view.findViewById(2131828930);
                c35498a2.tJc = (TextView) view.findViewById(2131828923);
                c35498a2.tJa = (TextView) view.findViewById(2131828925);
                c35498a2.tJb = (TextView) view.findViewById(2131828926);
                c35498a2.tJb.getPaint().setFlags(16);
                c35498a2.tJd = (TextView) view.findViewById(2131828940);
                c35498a2.tJe = (TextView) view.findViewById(2131828936);
                c35498a2.tJf = (TextView) view.findViewById(2131828938);
                c35498a2.tJh = (MaxListView) view.findViewById(2131828942);
                c35498a2.tJi = view.findViewById(2131828927);
                c35498a2.tJg = view.findViewById(2131828941);
                c35498a2.tJk = (TextView) view.findViewById(2131828932);
                c35498a2.tJj = (TextView) view.findViewById(2131828931);
                c35498a2.tJl = (TextView) view.findViewById(2131828934);
                c35498a2.tJm = (TextView) view.findViewById(2131828933);
                c35498a2.tJo = (ViewGroup) view.findViewById(2131828944);
                c35498a2.tEO = (CdnImageView) view.findViewById(2131827112);
                c35498a2.tEP = (TextView) view.findViewById(2131828946);
                c35498a2.tEQ = (TextView) view.findViewById(2131828945);
                c35498a2.tJn = view.findViewById(2131828943);
                view.setTag(c35498a2);
                c35498a = c35498a2;
            } else {
                c35498a = (C35498a) view.getTag();
            }
            final Commodity Hw = m58262Hw(i);
            if (!(Hw == null || c35498a == null)) {
                CharSequence string;
                WalletOrderInfoOldUI.this.pVl = Hw.cAa;
                c35498a.tJa.setText(C36391e.m60006e(Hw.kCJ, Hw.pcl));
                if (Hw.tAR < 0.0d || Hw.kCJ >= Hw.tAR) {
                    c35498a.tJb.setVisibility(8);
                } else {
                    c35498a.tJb.setText(C36391e.m60006e(Hw.tAR, Hw.pcl));
                    c35498a.tJb.setVisibility(0);
                }
                LinearLayout linearLayout = (LinearLayout) c35498a.tJi;
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
                        layoutParams.bottomMargin = WalletOrderInfoOldUI.this.mController.ylL.getResources().getDimensionPixelOffset(C25738R.dimen.f9723do);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextAppearance(WalletOrderInfoOldUI.this.mController.ylL, C25738R.style.f11102ox);
                        if (discountInfo.tBm > 0.0d) {
                            textView.setText(discountInfo.pOz + C36391e.m60006e(discountInfo.tBm / 100.0d, WalletOrderInfoOldUI.this.tog.pcl));
                        } else {
                            textView.setText(discountInfo.pOz);
                        }
                        linearLayout.addView(textView);
                        textView.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(C25738R.color.a4e));
                        i2 = i3 + 1;
                    }
                }
                if (linearLayout.getChildCount() > 0) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                TextView textView2 = c35498a.tIZ;
                WalletOrderInfoOldUI walletOrderInfoOldUI = WalletOrderInfoOldUI.this;
                if (C1853r.m3831YM()) {
                    string = walletOrderInfoOldUI.getString(C25738R.string.fl_);
                } else {
                    string = walletOrderInfoOldUI.getString(C25738R.string.fl9);
                }
                textView2.setText(string);
                c35498a.tJc.setText(Hw.pca);
                c35498a.gnC.setText(Hw.desc);
                c35498a.gnC.setTag(Hw.desc);
                c35498a.gnC.setOnLongClickListener(WalletOrderInfoOldUI.this.tIV);
                c35498a.gnC.setBackgroundResource(C25738R.drawable.a66);
                c35498a.tJd.setText(Hw.cAa);
                c35498a.tJd.setTag(Hw.cAa);
                c35498a.tJd.setOnLongClickListener(WalletOrderInfoOldUI.this.tIV);
                c35498a.tJd.setBackgroundResource(C25738R.drawable.a66);
                c35498a.tJe.setText(C36391e.m60014kC(Hw.pch));
                c35498a.tJf.setText(Hw.pcj);
                String str = Hw.tAV;
                if (c35498a.tJl != null) {
                    if (C5046bo.isNullOrNil(str)) {
                        c35498a.tJm.setVisibility(8);
                        c35498a.tJl.setVisibility(8);
                    } else {
                        c35498a.tJl.setText(str);
                        c35498a.tJl.setVisibility(0);
                        c35498a.tJm.setVisibility(0);
                    }
                }
                str = Hw.tAX;
                if (c35498a.tJk != null) {
                    if (C5046bo.isNullOrNil(str)) {
                        c35498a.tJj.setVisibility(8);
                        c35498a.tJk.setVisibility(8);
                    } else {
                        c35498a.tJk.setText(str);
                        c35498a.tJk.setVisibility(0);
                        c35498a.tJj.setVisibility(0);
                    }
                }
                if (Hw.tBa.size() > 0) {
                    Promotions promotions = (Promotions) Hw.tBa.get(0);
                    C7060h.pYm.mo8381e(13033, Integer.valueOf(1), promotions.pcm, promotions.url, promotions.name, WalletOrderInfoOldUI.this.pVl);
                    WalletOrderInfoOldUI.this.tIQ = new C29659c(Hw.tBa);
                    c35498a.tJh.setAdapter(WalletOrderInfoOldUI.this.tIQ);
                    c35498a.tJh.setOnItemClickListener(new C354921());
                    WalletOrderInfoOldUI.this.tIQ.notifyDataSetChanged();
                    c35498a.tJh.setVisibility(0);
                    c35498a.tJg.setVisibility(0);
                } else {
                    c35498a.tJh.setVisibility(8);
                    c35498a.tJo.setVisibility(8);
                    c35498a.tJg.setVisibility(8);
                }
                if (Hw.tAY == null || C5046bo.isNullOrNil(Hw.tAY.tzW)) {
                    c35498a.tJo.setVisibility(8);
                    c35498a.tJn.setVisibility(8);
                } else {
                    c35498a.tEO.setUrl(Hw.tAY.tzU);
                    c35498a.tEP.setText(Hw.tAY.tzV);
                    c35498a.tEQ.setText(Hw.tAY.ttf);
                    c35498a.tJo.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(47486);
                            C32628se c32628se = new C32628se();
                            c32628se.cOf.userName = Hw.tAY.tzW;
                            c32628se.cOf.cOh = C5046bo.m7532bc(Hw.tAY.ttg, "");
                            c32628se.cOf.scene = 1034;
                            c32628se.cOf.cOi = 0;
                            C4879a.xxA.mo10055m(c32628se);
                            C7060h.pYm.mo8381e(14118, WalletOrderInfoOldUI.this.oXY, WalletOrderInfoOldUI.this.cNH(), Integer.valueOf(1));
                            AppMethodBeat.m2505o(47486);
                        }
                    });
                    c35498a.tJn.setVisibility(0);
                }
            }
            AppMethodBeat.m2505o(47489);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$b */
    class C35499b {
        public String cEh;
        public String cIY;
        public String tID;
        public String title;
        public String url;

        public C35499b(JSONObject jSONObject) {
            AppMethodBeat.m2504i(47491);
            if (jSONObject == null) {
                AppMethodBeat.m2505o(47491);
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
            AppMethodBeat.m2505o(47491);
        }

        public final String toString() {
            AppMethodBeat.m2504i(47492);
            String str = this.url + " , " + this.cEh + " , " + this.cIY + " , " + this.tID + " , " + this.title;
            AppMethodBeat.m2505o(47492);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletOrderInfoOldUI() {
        AppMethodBeat.m2504i(47498);
        AppMethodBeat.m2505o(47498);
    }

    public final int getLayoutId() {
        return 2130971138;
    }

    /* renamed from: Kh */
    private void m58245Kh() {
        int i = 1;
        AppMethodBeat.m2504i(47499);
        C40931c aE = C24143a.m37112aE(this);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.oXY = this.mBundle.getString("key_trans_id");
        this.mBundle.getInt("key_pay_type", -1);
        C4990ab.m7417i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", this.oXY);
        this.tog = cRD();
        if (this.tog != null) {
            mo9439AM(0);
            m58252d(this.tog);
            if (!(aE == null || this.tog == null || this.pVL == null)) {
                boolean z;
                this.mAppId = this.pVL.appId;
                boolean dNG = aE.dNG();
                C40148d.m68847a(this, this.mBundle, 7);
                int i2 = this.mBundle.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                C7060h c7060h = C7060h.pYm;
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
                objArr[3] = Integer.valueOf(C36381z.dNX());
                objArr[4] = Integer.valueOf((int) (this.tog.pTN * 100.0d));
                objArr[5] = this.tog.pcl;
                objArr[6] = Integer.valueOf(i2);
                c7060h.mo8381e(10691, objArr);
            }
            if (!((C14241r.cPI().cQg() || aE == null || !aE.dNG()) && C1853r.m3827YI())) {
                C1853r.m3828YJ();
            }
            if (this.tog == null || this.tog.tAq == null || this.tog.tAq.size() <= 0) {
                C4990ab.m7409c("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
                C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C296571());
            } else {
                this.tId = this.tog.tAq;
                this.oXY = ((Commodity) this.tId.get(0)).cAa;
                if (!(this.pVL == null || aE == null || (!aE.dNF() && !aE.dNG()))) {
                    cRI();
                }
            }
            if (this.oXY == null) {
                if (((C11927i) C1720g.m3528K(C11927i.class)).mo7362g(this)) {
                    this.tIT = false;
                }
                AppMethodBeat.m2505o(47499);
                return;
            }
        }
        C4990ab.m7409c("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C354944());
        AppMethodBeat.m2505o(47499);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47500);
        super.onCreate(bundle);
        mo9439AM(4);
        this.tIc = new HashSet();
        m58245Kh();
        initView();
        mo39992nf(1979);
        C4879a.xxA.mo10052c(this.tIy);
        C4879a.xxA.mo10052c(this.pap);
        this.tIT = false;
        AppMethodBeat.m2505o(47500);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cRI() {
        AppMethodBeat.m2504i(47502);
        mo39970a(new C35475y(cNH(), 21), true, true);
        AppMethodBeat.m2505o(47502);
    }

    /* Access modifiers changed, original: protected */
    public void adb(String str) {
        AppMethodBeat.m2504i(47503);
        mo39970a(new C22564z(str), true, true);
        AppMethodBeat.m2505o(47503);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dt */
    public final void mo47914dt(String str, int i) {
        AppMethodBeat.m2504i(47504);
        mo39970a(new C22564z(str, i), true, true);
        AppMethodBeat.m2505o(47504);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo56227a(Promotions promotions) {
        AppMethodBeat.m2504i(47505);
        mo39970a(new C46360n(promotions, cNH(), this.oXY, promotions.tzR), true, false);
        AppMethodBeat.m2505o(47505);
    }

    /* renamed from: d */
    private void m58252d(Orders orders) {
        AppMethodBeat.m2504i(47506);
        this.tIc.clear();
        if (orders == null || orders.tAq == null) {
            C4990ab.m7420w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
            AppMethodBeat.m2505o(47506);
            return;
        }
        for (Commodity commodity : orders.tAq) {
            if (commodity.tAh == 2 && !C5046bo.isNullOrNil(commodity.tAS)) {
                C4990ab.m7410d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
                this.tIc.add(commodity.tAS);
            }
        }
        AppMethodBeat.m2505o(47506);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47507);
        setMMTitle((int) C25738R.string.flt);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(C25738R.string.f9142qt);
        if (this.pVL == null || this.pVL.cIf != 2) {
            if (!(this.tog == null || C5046bo.isNullOrNil(this.tog.tAB))) {
                string = this.tog.tAB;
            }
        } else if (!C5046bo.isNullOrNil(this.pVL.tRb)) {
            string = getString(C25738R.string.f8823g1) + this.pVL.tRb;
        } else if (!(C5046bo.isNullOrNil(this.pVL.appId) || C5046bo.isNullOrNil(C46494g.m87756t(this, this.pVL.appId)))) {
            string = getString(C25738R.string.f8823g1) + C46494g.m87756t(this, this.pVL.appId);
        }
        addTextOptionMenu(0, string, new C226107());
        this.tIK = (LinearLayout) findViewById(2131828919);
        this.tIL = (TextView) findViewById(2131828920);
        this.tIM = (TextView) findViewById(2131828922);
        MaxListView maxListView = (MaxListView) findViewById(2131828921);
        this.tIN = new C35497a();
        maxListView.setAdapter(this.tIN);
        cRJ();
        cRK();
        ((ScrollView) findViewById(2131823366)).pageScroll(33);
        AppMethodBeat.m2505o(47507);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRJ() {
        AppMethodBeat.m2504i(47508);
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
                this.tIL.setText(C25738R.string.flg);
            } else if (!C5046bo.isNullOrNil(this.tog.tAj) && !C5046bo.isNullOrNil(this.tog.tAj.trim())) {
                this.tIL.setText(this.tog.tAj);
                AppMethodBeat.m2505o(47508);
                return;
            } else if (this.tog.tuo != 1) {
                this.tIL.setText(C25738R.string.flf);
                AppMethodBeat.m2505o(47508);
                return;
            } else {
                this.tIL.setText(C25738R.string.fle);
                AppMethodBeat.m2505o(47508);
                return;
            }
        }
        AppMethodBeat.m2505o(47508);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo56228a(String str, C29660d c29660d) {
        AppMethodBeat.m2504i(47509);
        cRq();
        this.tIS = c29660d;
        C36391e.m59984a((Context) this, str, false, 1);
        this.tIT = false;
        AppMethodBeat.m2505o(47509);
    }

    /* Access modifiers changed, original: protected|final */
    public final void acZ(String str) {
        AppMethodBeat.m2504i(47510);
        cRq();
        C36391e.m60016n(this, str, false);
        this.tIT = false;
        AppMethodBeat.m2505o(47510);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRq() {
        int i = 0;
        AppMethodBeat.m2504i(47511);
        if (!this.tEC) {
            C45334iy c45334iy = new C45334iy();
            c45334iy.cEc.requestCode = 4;
            C26168a c26168a = c45334iy.cEc;
            if (this.mBundle.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            c26168a.bFZ = i;
            C4879a.xxA.mo10055m(c45334iy);
            this.tEC = true;
        }
        AppMethodBeat.m2505o(47511);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: S */
    public final void mo47912S(C7616ad c7616ad) {
        AppMethodBeat.m2504i(47512);
        if (!(c7616ad == null || ((int) c7616ad.ewQ) == 0)) {
            String Oi = c7616ad.mo16706Oi();
            C4990ab.m7410d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + Oi + " username: " + c7616ad.field_username);
            if (this.tId != null && this.tId.size() > 0) {
                for (Commodity commodity : this.tId) {
                    commodity.pcm = Oi;
                }
                this.tIN.notifyDataSetChanged();
            }
            this.igi = c7616ad.field_username;
        }
        AppMethodBeat.m2505o(47512);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47513);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.tIy);
        C4879a.xxA.mo10053d(this.pap);
        mo39993ng(1979);
        AppMethodBeat.m2505o(47513);
    }

    public final void cRH() {
        AppMethodBeat.m2504i(47515);
        cRq();
        this.tIT = false;
        C18216ap c18216ap = new C18216ap();
        c18216ap.ctF.ctG = true;
        C4879a.xxA.mo10055m(c18216ap);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.mBundle.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.mBundle.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.mBundle.getBoolean("intent_pay_end"));
        C4990ab.m7416i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + this.mBundle.getInt("intent_pay_end_errcode"));
        for (String str : this.tIc) {
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7417i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", str);
                if (this.tog == null || this.pVL == null) {
                    C1720g.m3535RO().eJo.mo14541a(new C44431r(str), 0);
                } else {
                    String str2;
                    C6300p c6300p = C1720g.m3535RO().eJo;
                    String str3 = this.tog.czZ;
                    if (this.tog.tAq.size() > 0) {
                        str2 = ((Commodity) this.tog.tAq.get(0)).cAa;
                    } else {
                        str2 = "";
                    }
                    c6300p.mo14541a(new C44431r(str, str3, str2, this.pVL.cIf, this.pVL.cIb, this.tog.tAh), 0);
                }
            }
            C7060h.pYm.mo8381e(13033, Integer.valueOf(2), str, "", "", "");
        }
        C24143a.m37116j(this, bundle);
        if (!(this.tog == null || C5046bo.isNullOrNil(this.tog.lvz))) {
            String d = WalletOrderInfoUI.m47042d(this.tog.lvz, this.tog.czZ, this.tog.tAq.size() > 0 ? ((Commodity) this.tog.tAq.get(0)).cAa : "", this.pVL.kck, this.pVL.hHV);
            C4990ab.m7410d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(d)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("stastic_scene", 8);
            C25985d.m41467b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(47515);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47516);
        if (i == 4) {
            done();
            AppMethodBeat.m2505o(47516);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(47516);
        return onKeyUp;
    }

    public void onResume() {
        AppMethodBeat.m2504i(47518);
        super.onResume();
        C4990ab.m7417i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", Boolean.valueOf(this.tIT));
        if (this.tIT) {
            mo39970a(new C40093aa(this.tIS.tuv, this.tIS.tIF, this.tIS.tIG, this.tIS.tIH, this.tIS.cBT, this.tIS.pQe, this.tIS.tBC), true, true);
        }
        AppMethodBeat.m2505o(47518);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47519);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            mo39970a(new C40093aa(this.tIS.tuv, this.tIS.tIF, this.tIS.tIG, this.tIS.tIH, this.tIS.cBT, this.tIS.pQe, this.tIS.tBC), true, true);
        }
        AppMethodBeat.m2505o(47519);
    }

    private void cRK() {
        AppMethodBeat.m2504i(47520);
        if (this.tog == null || this.tog.tAq == null || this.tog.tAq.size() <= 0 || ((Commodity) this.tog.tAq.get(0)).tBc == null || C5046bo.isNullOrNil(((Commodity) this.tog.tAq.get(0)).tBc.text) || C5046bo.isNullOrNil(((Commodity) this.tog.tAq.get(0)).tBc.url)) {
            C4990ab.m7416i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
            this.tIM.setVisibility(8);
            AppMethodBeat.m2505o(47520);
            return;
        }
        this.tIM.setVisibility(0);
        this.tIM.setText(((Commodity) this.tog.tAq.get(0)).tBc.text);
        this.tIM.setOnClickListener(new C2260710());
        AppMethodBeat.m2505o(47520);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47521);
        if ((c1207m instanceof C40093aa) && i == 0 && i2 == 0) {
            boolean z;
            C40093aa c40093aa = (C40093aa) c1207m;
            C35499b c35499b = new C35499b(c40093aa.hwh);
            if (C5046bo.isNullOrNil(c35499b.url) || C5046bo.isNullOrNil(c35499b.cEh)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.tEH.put(c40093aa.tuv, c35499b);
            }
            this.tIN.notifyDataSetChanged();
        }
        if (c1207m instanceof C22564z) {
            if (i == 0 && i2 == 0) {
                mo9439AM(0);
                this.tog = ((C22564z) c1207m).tux;
                if (this.tog != null) {
                    this.tId = this.tog.tAq;
                }
                m58252d(this.tog);
                C4990ab.m7410d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.tId);
                if (!(this.tId == null || this.tId.size() == 0)) {
                    Commodity commodity = (Commodity) this.tId.get(0);
                    this.oXY = commodity.cAa;
                    C4990ab.m7410d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + commodity.toString());
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(commodity.pcm);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        C26417a.flu.mo20966a(commodity.pcm, "", this.tIU);
                    } else {
                        mo47912S(aoO);
                    }
                    this.tIN.notifyDataSetChanged();
                    cRJ();
                }
            }
            if (this.tIN != null) {
                this.tIN.notifyDataSetChanged();
            }
            cRK();
            AppMethodBeat.m2505o(47521);
            return true;
        }
        if (c1207m instanceof C46360n) {
            if (i == 0 && i2 == 0) {
                C46360n c46360n = (C46360n) c1207m;
                String str2 = c46360n.tud;
                this.tIR.put(Long.valueOf(c46360n.tug.ttW), str2);
                c46360n.tug.tzS = c46360n.ehr;
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !C5046bo.isNullOrNil(c46360n.tue)) {
                    C30379h.m48461b((Context) this, c46360n.tue, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    CharSequence string;
                    if (C5046bo.isNullOrNil(c46360n.tue)) {
                        string = getString(C25738R.string.fns);
                    } else {
                        string = c46360n.tue;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.tIN.notifyDataSetChanged();
                AppMethodBeat.m2505o(47521);
                return true;
            } else if (c1207m instanceof C46360n) {
                if (C5046bo.isNullOrNil(str)) {
                    str = getString(C25738R.string.fu2);
                }
                C30379h.m48448a((Context) this, str, null, false, new C226092());
                AppMethodBeat.m2505o(47521);
                return true;
            }
        }
        AppMethodBeat.m2505o(47521);
        return false;
    }

    /* renamed from: lJ */
    public final String mo56235lJ(long j) {
        AppMethodBeat.m2504i(47522);
        String str;
        if (this.tIR.containsKey(Long.valueOf(j))) {
            str = (String) this.tIR.get(Long.valueOf(j));
            AppMethodBeat.m2505o(47522);
            return str;
        }
        str = "-1";
        AppMethodBeat.m2505o(47522);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public Orders cRD() {
        AppMethodBeat.m2504i(47501);
        Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
        AppMethodBeat.m2505o(47501);
        return orders;
    }

    public void done() {
        AppMethodBeat.m2504i(47514);
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.mo74574b(this, bundle, new C226118());
                this.mBundle.remove("key_realname_guide_helper");
                if (!b) {
                    cRH();
                }
            }
            AppMethodBeat.m2505o(47514);
            return;
        }
        cRH();
        AppMethodBeat.m2505o(47514);
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(47517);
        Dialog a = C30379h.m48422a(this.mController.ylL, getString(C25738R.string.fla), getResources().getStringArray(C25738R.array.f12640au), "", new C226129());
        AppMethodBeat.m2505o(47517);
        return a;
    }
}

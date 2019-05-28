package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.qqmail.p486b.C12876a;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C43404o;
import com.tencent.p177mm.plugin.qqmail.p486b.C46149p;
import com.tencent.p177mm.plugin.qqmail.p486b.C46149p.C43405a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI */
public class MailAddrListUI extends MMActivity {
    private TextView gya = null;
    private C46149p puD = null;
    private C44275p pyj = null;
    private TextView pyk = null;
    private ListView pyl;
    private C21542a pym;
    private List<C43404o> pyn;
    private C43405a pyo = new C434081();

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$5 */
    class C215395 implements OnMenuItemClickListener {
        C215395() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68315);
            MailAddrListUI.this.setResult(0);
            MailAddrListUI.this.finish();
            AppMethodBeat.m2505o(68315);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$6 */
    class C215406 implements OnClickListener {
        C215406() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68316);
            C4978c.m7375a(MailAddrListUI.this.pyl);
            AppMethodBeat.m2505o(68316);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$a */
    class C21542a extends BaseAdapter {
        private final Context context;
        boolean pyq = false;
        boolean pyr = false;
        Map<String, C43404o> pys = new HashMap();

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$a$a */
        class C21541a {
            CheckBox gnD;
            TextView gxi;
            TextView pyt;
            TextView pyu;

            C21541a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(68326);
            C43404o Bu = mo37016Bu(i);
            AppMethodBeat.m2505o(68326);
            return Bu;
        }

        public C21542a(Context context) {
            AppMethodBeat.m2504i(68318);
            this.context = context;
            AppMethodBeat.m2505o(68318);
        }

        /* renamed from: c */
        public final void mo37018c(C43404o c43404o) {
            AppMethodBeat.m2504i(68319);
            this.pys.put(c43404o.nJq, c43404o);
            AppMethodBeat.m2505o(68319);
        }

        public final int cdf() {
            AppMethodBeat.m2504i(68320);
            int size = this.pys.size();
            AppMethodBeat.m2505o(68320);
            return size;
        }

        /* renamed from: Bt */
        private int m33006Bt(int i) {
            if (this.pyr) {
                return i;
            }
            if (i == 0) {
                return 0;
            }
            return i - 1;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(68321);
            int size = MailAddrListUI.this.pyn.size();
            if (size == 0) {
                if (this.pyq) {
                    AppMethodBeat.m2505o(68321);
                    return 1;
                }
                AppMethodBeat.m2505o(68321);
                return 0;
            } else if (this.pyr) {
                AppMethodBeat.m2505o(68321);
                return size;
            } else {
                size++;
                AppMethodBeat.m2505o(68321);
                return size;
            }
        }

        private TextView getTitleTextView() {
            AppMethodBeat.m2504i(68322);
            TextView textView = new TextView(this.context);
            textView.setBackgroundResource(C25738R.drawable.a_r);
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            textView.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
            int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            int dimensionPixelSize2 = MailAddrListUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            AppMethodBeat.m2505o(68322);
            return textView;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C21541a c21541a;
            boolean z;
            AppMethodBeat.m2504i(68323);
            if (i == 0) {
                if (this.pyq) {
                    TextView titleTextView = getTitleTextView();
                    titleTextView.setText(C25738R.string.dd6);
                    int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
                    titleTextView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    titleTextView.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9728dt));
                    titleTextView.setGravity(17);
                    AppMethodBeat.m2505o(68323);
                    return titleTextView;
                } else if (!this.pyr) {
                    view = getTitleTextView();
                    view.setText(C25738R.string.dd5);
                    AppMethodBeat.m2505o(68323);
                    return view;
                }
            }
            if (view == null || view.getTag() == null) {
                C21541a c21541a2 = new C21541a();
                view = View.inflate(this.context, 2130970424, null);
                c21541a2.pyt = (TextView) view.findViewById(2131826687);
                c21541a2.gxi = (TextView) view.findViewById(2131826689);
                c21541a2.pyu = (TextView) view.findViewById(2131826690);
                c21541a2.gnD = (CheckBox) view.findViewById(2131826691);
                view.setTag(c21541a2);
                c21541a = c21541a2;
            } else {
                c21541a = (C21541a) view.getTag();
            }
            C43404o Bu = mo37016Bu(i);
            if (this.pyr || i <= 10) {
                c21541a.pyt.setVisibility(8);
            } else {
                C43404o Bu2 = mo37016Bu(i - 1);
                if (i == 11) {
                    Bu2 = null;
                }
                String d = C21542a.m33007d(Bu);
                String d2 = C21542a.m33007d(Bu2);
                if (d == null) {
                    c21541a.pyt.setVisibility(8);
                } else if (d.equals(d2)) {
                    c21541a.pyt.setVisibility(8);
                } else {
                    c21541a.pyt.setText(d.toUpperCase());
                    c21541a.pyt.setVisibility(0);
                }
            }
            c21541a.gxi.setText(Bu.name);
            c21541a.pyu.setText(Bu.nJq);
            CheckBox checkBox = c21541a.gnD;
            if (this.pys.get(Bu.nJq) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            AppMethodBeat.m2505o(68323);
            return view;
        }

        /* renamed from: d */
        private static String m33007d(C43404o c43404o) {
            AppMethodBeat.m2504i(68324);
            if (c43404o == null) {
                AppMethodBeat.m2505o(68324);
                return null;
            }
            String Vd = C12876a.m20870Vd(c43404o.puh);
            char charAt = Vd.length() > 1 ? Vd.charAt(0) : '~';
            String valueOf;
            switch (charAt) {
                case '{':
                    charAt = Vd.charAt(1);
                    if (C5046bo.m7498A(charAt)) {
                        valueOf = String.valueOf(charAt);
                        AppMethodBeat.m2505o(68324);
                        return valueOf;
                    }
                    valueOf = "~";
                    AppMethodBeat.m2505o(68324);
                    return valueOf;
                case '~':
                    valueOf = "~";
                    AppMethodBeat.m2505o(68324);
                    return valueOf;
                default:
                    if (C5046bo.m7590z(charAt)) {
                        valueOf = String.valueOf(charAt);
                        AppMethodBeat.m2505o(68324);
                        return valueOf;
                    }
                    valueOf = "~";
                    AppMethodBeat.m2505o(68324);
                    return valueOf;
            }
        }

        /* renamed from: Bu */
        public final C43404o mo37016Bu(int i) {
            AppMethodBeat.m2504i(68325);
            C43404o c43404o = (C43404o) MailAddrListUI.this.pyn.get(m33006Bt(i));
            AppMethodBeat.m2505o(68325);
            return c43404o;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            if (i == 0) {
                return this.pyr;
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$4 */
    class C287644 implements OnScrollListener {
        C287644() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(68314);
            if (1 == i) {
                MailAddrListUI.this.aqX();
            }
            AppMethodBeat.m2505o(68314);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$7 */
    class C287657 implements OnMenuItemClickListener {
        C287657() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68317);
            C21542a e = MailAddrListUI.this.pym;
            ArrayList arrayList = new ArrayList();
            for (String str : e.pys.keySet()) {
                arrayList.add(e.pys.get(str));
            }
            ComposeUI.m45711cH(arrayList);
            MailAddrListUI.this.setResult(-1);
            MailAddrListUI.this.finish();
            AppMethodBeat.m2505o(68317);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$8 */
    class C395448 implements OnCancelListener {
        C395448() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$2 */
    class C434062 implements C5600b {
        C434062() {
        }

        public final void apq() {
        }

        public final void apr() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(68312);
            String bc = C5046bo.m7532bc(str, "");
            MailAddrListUI.this.pyn = MailAddrListUI.this.puD.mo74096Vi(bc.toLowerCase().trim());
            if (bc.length() > 0) {
                MailAddrListUI.this.pym.pyr = true;
            } else {
                MailAddrListUI.this.pym.pyr = false;
            }
            MailAddrListUI.this.pym.pyq = false;
            if (MailAddrListUI.this.pyn.size() == 0) {
                MailAddrListUI.this.enableOptionMenu(false);
                MailAddrListUI.this.pyk.setVisibility(0);
            } else {
                MailAddrListUI.this.enableOptionMenu(true);
                MailAddrListUI.this.pyk.setVisibility(8);
            }
            MailAddrListUI.this.pym.notifyDataSetChanged();
            AppMethodBeat.m2505o(68312);
        }

        public final void apo() {
        }

        public final void app() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$3 */
    class C434073 implements OnItemClickListener {
        C434073() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(68313);
            C21542a e = MailAddrListUI.this.pym;
            C43404o Bu = e.mo37016Bu(i - MailAddrListUI.this.pyl.getHeaderViewsCount());
            String str = Bu.nJq;
            if (e.pys.containsKey(str)) {
                e.pys.remove(str);
            } else {
                e.pys.put(str, Bu);
            }
            e.notifyDataSetChanged();
            MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(C25738R.string.dcx) + (MailAddrListUI.this.pym.cdf() > 0 ? "(" + MailAddrListUI.this.pym.cdf() + ")" : ""));
            AppMethodBeat.m2505o(68313);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$1 */
    class C434081 extends C43405a {
        C434081() {
        }

        public final void onComplete() {
            AppMethodBeat.m2504i(68311);
            if (MailAddrListUI.this.pyj != null) {
                MailAddrListUI.this.pyj.dismiss();
            }
            MailAddrListUI.this.pyn = MailAddrListUI.this.puD.mo74096Vi(null);
            if (MailAddrListUI.this.pyn.size() == 0) {
                MailAddrListUI.this.gya.setText(C25738R.string.e_t);
                MailAddrListUI.this.gya.setVisibility(0);
            }
            String[] stringArrayExtra = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
            for (String Vj : stringArrayExtra == null ? new String[]{""} : stringArrayExtra) {
                C43404o Vj2 = C46149p.m86140Vj(Vj);
                if (Vj2 != null) {
                    int i;
                    for (C43404o c43404o : MailAddrListUI.this.pyn) {
                        if (c43404o.nJq.equalsIgnoreCase(Vj2.nJq)) {
                            MailAddrListUI.this.pym.mo37018c(c43404o);
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        MailAddrListUI.this.pym.mo37018c(Vj2);
                    }
                }
            }
            MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(C25738R.string.dcx) + (MailAddrListUI.this.pym.cdf() > 0 ? "(" + MailAddrListUI.this.pym.cdf() + ")" : ""));
            MailAddrListUI.this.pym.notifyDataSetChanged();
            AppMethodBeat.m2505o(68311);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MailAddrListUI() {
        AppMethodBeat.m2504i(68327);
        AppMethodBeat.m2505o(68327);
    }

    public final int getLayoutId() {
        return 2130970423;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68328);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.dcx);
        this.pyn = new ArrayList();
        this.puD = C12884ac.ccC().puD;
        initView();
        this.puD.mo74097a(this.pyo);
        this.puD.ccq();
        AppMethodBeat.m2505o(68328);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.m2504i(68329);
        this.pyl = (ListView) findViewById(2131826685);
        this.gya = (TextView) findViewById(2131825025);
        this.pyk = (TextView) findViewById(2131826686);
        this.pym = new C21542a(this);
        C5601o c5601o = new C5601o((byte) 0);
        c5601o.zHa = new C434062();
        mo17380a(c5601o);
        this.pyl.setAdapter(this.pym);
        this.pyl.setOnItemClickListener(new C434073());
        this.pyl.setOnScrollListener(new C287644());
        this.pyn = this.puD.mo74096Vi(null);
        this.pym.notifyDataSetChanged();
        setBackBtn(new C215395());
        C215406 c215406 = new C215406();
        addTextOptionMenu(0, getString(C25738R.string.dcw), new C287657());
        if (this.pyn.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        enableOptionMenu(z);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.pyj = C30379h.m48458b(context, getString(C25738R.string.dcv), true, new C395448());
        AppMethodBeat.m2505o(68329);
    }

    public void onPause() {
        AppMethodBeat.m2504i(68330);
        super.onPause();
        AppMethodBeat.m2505o(68330);
    }

    public void onResume() {
        AppMethodBeat.m2504i(68331);
        super.onResume();
        this.pym.notifyDataSetChanged();
        AppMethodBeat.m2505o(68331);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(68332);
        super.onDestroy();
        this.puD.mo74098b(this.pyo);
        AppMethodBeat.m2505o(68332);
    }
}

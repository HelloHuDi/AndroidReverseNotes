package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c.C210961;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C46032c;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C21080h;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C34375g;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C34376j;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34372f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C23249h;
import com.tencent.p177mm.pluginsdk.model.C23249h.C14889a;
import com.tencent.p177mm.pluginsdk.model.C44064n;
import com.tencent.p177mm.protocal.protobuf.aqo;
import com.tencent.p177mm.protocal.protobuf.crt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI */
public class IPCallRechargeUI extends MMActivity implements C1202f {
    TextView kEq;
    private C14889a lbF = new C122891();
    private int lbo = -1;
    private String[] lbs;
    private C7306ak mHandler = new C122793();
    ProgressDialog nBv;
    private String[] nEc;
    private String[] nEd;
    private String nEe;
    private String nEf;
    private boolean nEg = false;
    private int nEh;
    private int nEi = -1;
    private String nEj;
    private String nEk;
    private C21080h nEl = new C21080h();
    private C34375g nEm = new C34375g();
    private C34376j nEn = new C34376j();
    RelativeLayout nEo;
    GridView nEp;
    ListView nEq;
    C12286a nEr;
    Button nEs;
    C34372f nEt;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$4 */
    class C122774 implements OnClickListener {
        C122774() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22254);
            IPCallRechargeUI.this.finish();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", IPCallRechargeUI.this.getString(C25738R.string.cgp));
            intent.putExtra("showShare", false);
            C25985d.m41467b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(22254);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$3 */
    class C122793 extends C7306ak {
        C122793() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(22253);
            switch (message.what) {
                case 1002:
                    IPCallRechargeUI.this.nEq.setVisibility(0);
                    IPCallRechargeUI.m20222k(IPCallRechargeUI.this);
                    AppMethodBeat.m2505o(22253);
                    return;
                default:
                    C4990ab.m7420w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                    AppMethodBeat.m2505o(22253);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$5 */
    class C122805 implements OnMenuItemClickListener {
        C122805() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22255);
            IPCallRechargeUI.this.finish();
            AppMethodBeat.m2505o(22255);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$10 */
    class C1228110 implements OnClickListener {
        C1228110() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22261);
            IPCallRechargeUI.m20221j(IPCallRechargeUI.this);
            AppMethodBeat.m2505o(22261);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$11 */
    class C1228211 implements OnClickListener {
        C1228211() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22262);
            IPCallRechargeUI.this.finish();
            AppMethodBeat.m2505o(22262);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$12 */
    class C1228312 implements OnClickListener {
        C1228312() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$6 */
    class C122846 implements OnMenuItemClickListener {
        C122846() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22256);
            IPCallRechargeUI.m20219h(IPCallRechargeUI.this);
            AppMethodBeat.m2505o(22256);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$8 */
    class C122858 implements OnCancelListener {
        C122858() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22259);
            try {
                if (IPCallRechargeUI.this.nEt != null) {
                    C9638aw.m17182Rg().mo14547c(IPCallRechargeUI.this.nEt);
                }
                IPCallRechargeUI.this.finish();
                AppMethodBeat.m2505o(22259);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", e.getMessage());
                AppMethodBeat.m2505o(22259);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$a */
    static class C12286a extends BaseAdapter {
        private IPCallRechargeUI nEw = null;
        aqo nEx = null;
        List<crt> ngC = null;

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$a$a */
        class C12287a {
            TextView nDC;
            TextView nEA;
            TextView nEB;
            Button nEC;
            TextView nEz;

            private C12287a() {
            }

            /* synthetic */ C12287a(C12286a c12286a, byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$a$1 */
        class C122881 implements View.OnClickListener {
            C122881() {
            }

            public final void onClick(View view) {
                Object obj;
                AppMethodBeat.m2504i(22263);
                IPCallRechargeUI a = C12286a.this.nEw;
                if (C5059g.dnY()) {
                    obj = null;
                } else {
                    C5652a c5652a = new C5652a(a);
                    c5652a.mo11450PZ(C25738R.string.cjc);
                    c5652a.mo11453Qc(C25738R.string.f9151r4).mo11457a(new C210961());
                    c5652a.aMb().show();
                    obj = 1;
                }
                if (obj != null) {
                    C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "onClick recharged, non gp version!");
                    AppMethodBeat.m2505o(22263);
                    return;
                }
                IPCallRechargeUI.m20211b(C12286a.this.nEw, ((Integer) view.getTag()).intValue());
                AppMethodBeat.m2505o(22263);
            }
        }

        public C12286a(IPCallRechargeUI iPCallRechargeUI) {
            AppMethodBeat.m2504i(22264);
            Assert.assertTrue(true);
            this.nEw = iPCallRechargeUI;
            AppMethodBeat.m2505o(22264);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(22265);
            if (this.ngC == null) {
                AppMethodBeat.m2505o(22265);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.m2505o(22265);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(22266);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.m2505o(22266);
                return obj;
            }
            AppMethodBeat.m2505o(22266);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C12287a c12287a;
            AppMethodBeat.m2504i(22267);
            if (view == null) {
                view = ((LayoutInflater) this.nEw.getSystemService("layout_inflater")).inflate(2130969905, viewGroup, false);
                c12287a = new C12287a(this, (byte) 0);
                c12287a.nDC = (TextView) view.findViewById(2131825184);
                c12287a.nEz = (TextView) view.findViewById(2131825185);
                c12287a.nEA = (TextView) view.findViewById(2131825187);
                c12287a.nEB = (TextView) view.findViewById(2131825186);
                c12287a.nEC = (Button) view.findViewById(2131825182);
                view.setTag(c12287a);
            } else {
                c12287a = (C12287a) view.getTag();
            }
            crt crt = (crt) getItem(i);
            if (crt == null) {
                AppMethodBeat.m2505o(22267);
            } else {
                c12287a.nDC.setText(crt.wOs);
                c12287a.nEz.setText(crt.xpq);
                c12287a.nEA.setText(crt.xpr);
                if (C5046bo.isNullOrNil(crt.xpr)) {
                    c12287a.nEA.setVisibility(8);
                } else {
                    c12287a.nEA.setVisibility(0);
                }
                if (this.nEx != null) {
                    c12287a.nEB.setText(String.format(this.nEw.getString(C25738R.string.chl), new Object[]{C46041a.m85630Pp(this.nEx.wuk), String.valueOf(crt.xpo)}));
                }
                c12287a.nEC.setTag(Integer.valueOf(i));
                c12287a.nEC.setOnClickListener(new C122881());
                AppMethodBeat.m2505o(22267);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$1 */
    class C122891 implements C14889a {
        C122891() {
        }

        /* renamed from: A */
        public final void mo24138A(ArrayList<C44064n> arrayList) {
            AppMethodBeat.m2504i(22251);
            IPCallRechargeUI.this.nEl.nzj = C5046bo.anU();
            if (arrayList == null || arrayList.size() <= 0) {
                if (IPCallRechargeUI.this.nBv != null && IPCallRechargeUI.this.nBv.isShowing()) {
                    IPCallRechargeUI.this.nBv.dismiss();
                }
                C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
                IPCallRechargeUI.this.lbo = 10236;
                IPCallRechargeUI.this.bIt();
                AppMethodBeat.m2505o(22251);
                return;
            }
            IPCallRechargeUI.this.nEc = new String[arrayList.size()];
            IPCallRechargeUI.this.nEd = new String[arrayList.size()];
            C44064n c44064n = (C44064n) arrayList.get(0);
            if (c44064n.vbt == 10232) {
                C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    c44064n = (C44064n) it.next();
                    IPCallRechargeUI.this.nEc[i] = new BigDecimal(c44064n.vbs).divide(new BigDecimal(1000000)).toString();
                    IPCallRechargeUI.this.nEd[i] = c44064n.vbr;
                    i++;
                }
                if (IPCallRechargeUI.this.nEh > 0 && IPCallRechargeUI.this.nEd.length > 0) {
                    String str = IPCallRechargeUI.this.nEd[0];
                    if (!(C5046bo.isNullOrNil(str) || str.equals(IPCallRechargeUI.this.nEf))) {
                        C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.this.nEf + ",google wallet currency:" + str);
                        IPCallRechargeUI.m20209a(IPCallRechargeUI.this, str);
                        AppMethodBeat.m2505o(22251);
                        return;
                    }
                }
                if (IPCallRechargeUI.this.nBv != null && IPCallRechargeUI.this.nBv.isShowing()) {
                    IPCallRechargeUI.this.nBv.dismiss();
                }
                IPCallRechargeUI.this.bIt();
                AppMethodBeat.m2505o(22251);
                return;
            }
            if (IPCallRechargeUI.this.nBv != null && IPCallRechargeUI.this.nBv.isShowing()) {
                IPCallRechargeUI.this.nBv.dismiss();
            }
            IPCallRechargeUI.this.lbo = c44064n.vbt;
            C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.this.lbo);
            IPCallRechargeUI.this.bIt();
            AppMethodBeat.m2505o(22251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$7 */
    class C122907 extends ClickableSpan {
        C122907() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22257);
            ((TextView) view).setHighlightColor(IPCallRechargeUI.this.getResources().getColor(C25738R.color.a3p));
            Intent intent = new Intent();
            String str = IPCallRechargeUI.this.getString(C25738R.string.chm) + "&usedcc=";
            List bHf = C46032c.bHc().bHf();
            if (bHf.size() > 0) {
                int size = bHf.size();
                if (size > 5) {
                    size = 5;
                }
                int i = 0;
                while (i < size) {
                    String Pr = C46041a.m85632Pr(((Integer) bHf.get(i)).toString());
                    if (C5046bo.isNullOrNil(Pr)) {
                        Pr = str;
                    } else {
                        Pr = str + Pr + "|";
                    }
                    i++;
                    str = Pr;
                }
                if (str.endsWith("|")) {
                    str = str.substring(0, str.length() - 1);
                }
            } else {
                str = str + C46041a.m85632Pr(C34382c.bIR());
            }
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            C25985d.m41467b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(22257);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(22258);
            textPaint.setColor(IPCallRechargeUI.this.getResources().getColor(C25738R.color.f12123t7));
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(22258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$9 */
    class C122919 implements C30391c {
        C122919() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(22260);
            switch (i) {
                case 0:
                    C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "start restore");
                    IPCallRechargeUI.this.nEn.start();
                    C7060h.pYm.mo8378a(257, 14, 1, true);
                    Intent intent = new Intent();
                    intent.putExtra("key_action_type", 200002);
                    intent.putExtra("key_force_google", true);
                    C25985d.m41468b(IPCallRechargeUI.this, "wallet_index", ".ui.WalletIapUI", intent, 2002);
                    IPCallRechargeUI iPCallRechargeUI = IPCallRechargeUI.this;
                    if (!iPCallRechargeUI.isFinishing()) {
                        Context context = iPCallRechargeUI.mController.ylL;
                        iPCallRechargeUI.getString(C25738R.string.f9238tz);
                        iPCallRechargeUI.nBv = C30379h.m48458b(context, iPCallRechargeUI.getString(C25738R.string.ch0), false, null);
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                    AppMethodBeat.m2505o(22260);
                    return;
            }
            AppMethodBeat.m2505o(22260);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallRechargeUI() {
        AppMethodBeat.m2504i(22268);
        AppMethodBeat.m2505o(22268);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22269);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(929, (C1202f) this);
        setMMTitle((int) C25738R.string.chh);
        setBackBtn(new C122805());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C122846());
        this.nEo = (RelativeLayout) findViewById(2131824244);
        this.nEp = (GridView) findViewById(2131825189);
        this.nEq = (ListView) findViewById(2131825181);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.mController.ylL, 2130969904, null);
        this.nEq.addFooterView(viewGroup, null, false);
        this.nEr = new C12286a(this);
        this.nEq.setAdapter(this.nEr);
        this.kEq = (TextView) viewGroup.findViewById(2131821051);
        this.nEs = (Button) findViewById(2131825190);
        String string = getString(C25738R.string.chn);
        Spannable newSpannable = Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new C122907(), 0, string.length(), 33);
        this.kEq.setText(newSpannable);
        this.kEq.setMovementMethod(LinkMovementMethod.getInstance());
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.nBv = C30379h.m48458b(context, getString(C25738R.string.ch0), true, new C122858());
        m20205Ph("");
        this.nEl.start();
        C7060h.pYm.mo8378a(257, 4, 1, true);
        AppMethodBeat.m2505o(22269);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22270);
        super.onDestroy();
        this.nEl.nyL = C5046bo.anU();
        this.nEl.finish();
        C9638aw.m17182Rg().mo14546b(929, (C1202f) this);
        AppMethodBeat.m2505o(22270);
    }

    public final int getLayoutId() {
        return 2130969906;
    }

    /* renamed from: Ph */
    private void m20205Ph(String str) {
        String Pr;
        AppMethodBeat.m2504i(22271);
        List bHf = C46032c.bHc().bHf();
        if (bHf.size() == 0) {
            Pr = C46041a.m85632Pr(C34382c.bIR());
        } else {
            Pr = C46041a.m85632Pr(((Integer) bHf.get(0)).toString());
        }
        this.nEt = new C34372f(Pr, str);
        C9638aw.m17182Rg().mo14541a(this.nEt, 0);
        AppMethodBeat.m2505o(22271);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22272);
        C4990ab.m7417i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        boolean z;
        ArrayList stringArrayListExtra;
        if (i == 2001) {
            int intExtra;
            int intExtra2;
            String string;
            int i3;
            String str = "";
            z = false;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                int intExtra3 = intent.getIntExtra("key_gw_error_code", 0);
                intExtra2 = intent.getIntExtra("key_response_position", 0);
                if (intExtra == 100000001) {
                    z = true;
                }
                C4990ab.m7417i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra3), Integer.valueOf(intExtra2), String.valueOf(z));
                if (intExtra != 6 || intExtra3 == 0) {
                    this.nEm.nzd = (long) intExtra;
                } else {
                    this.nEm.nzd = (long) intExtra3;
                }
                if (intExtra2 == 3) {
                    C7060h.pYm.mo8378a(257, 9, 1, true);
                    C7060h.pYm.mo8378a(257, 11, 1, true);
                    this.nEm.nzd = 0;
                    this.nEm.nze = 2;
                    string = getString(C25738R.string.ck1);
                } else {
                    if (intExtra2 != 1) {
                        if (i2 == -1 && intExtra == 0) {
                            C7060h.pYm.mo8378a(257, 9, 1, true);
                            string = stringExtra;
                        } else if (z) {
                            C7060h.pYm.mo8378a(257, 9, 1, true);
                            C7060h.pYm.mo8378a(257, 12, 1, true);
                            this.nEm.nzd = 0;
                            this.nEm.nze = 1;
                        }
                    }
                    string = stringExtra;
                }
                this.nEm.nzc = longExtra;
                this.nEm.nyL = C5046bo.anU();
                this.nEm.finish();
                i3 = intExtra3;
            } else {
                i3 = 0;
                intExtra2 = 0;
                intExtra = 0;
                string = str;
            }
            if (i2 == -1) {
                if (intent != null && intExtra == 0) {
                    stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                    intent.getStringArrayListExtra("key_response_series_ids");
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        C4990ab.m7417i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", C5046bo.nullAsNil((String) it.next()));
                    }
                    C7060h.pYm.mo8378a(257, 6, 1, true);
                    C7060h.pYm.mo8378a(257, 10, 1, true);
                    Toast.makeText(this, C25738R.string.cj1, 0).show();
                    finish();
                    AppMethodBeat.m2505o(22272);
                    return;
                } else if (intent != null && intExtra == 100000002) {
                    C7060h.pYm.mo8378a(257, 6, 1, true);
                    m20204JD(string);
                    AppMethodBeat.m2505o(22272);
                    return;
                } else if (intent != null && intExtra == 109) {
                    m20204JD(string);
                    AppMethodBeat.m2505o(22272);
                    return;
                } else if (intent != null && intExtra == 1) {
                    string = getString(C25738R.string.ciz);
                    C7060h.pYm.mo8378a(257, 8, 1, true);
                    Toast.makeText(this, string, 0).show();
                    AppMethodBeat.m2505o(22272);
                    return;
                } else if (intent == null || intExtra != 113) {
                    C7060h.pYm.mo8378a(257, 7, 1, true);
                    if (intExtra2 == 3) {
                        m20204JD(string);
                        AppMethodBeat.m2505o(22272);
                        return;
                    } else if (intExtra == 100000001 || intExtra == 6) {
                        if (i3 == 0) {
                            Toast.makeText(this, getString(C25738R.string.cgx), 0).show();
                            AppMethodBeat.m2505o(22272);
                            return;
                        }
                        string = getString(C25738R.string.cgz);
                        if (!m20206Pi(string)) {
                            Toast.makeText(this, string, 0).show();
                        }
                    }
                } else {
                    C30379h.m48438a((Context) this, getString(C25738R.string.cik), getString(C25738R.string.cj0), new C1228110());
                    AppMethodBeat.m2505o(22272);
                    return;
                }
            }
            AppMethodBeat.m2505o(22272);
            return;
        }
        if (i == 2002) {
            if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
            }
            String str2 = "";
            int i4 = 0;
            int i5 = 0;
            z = false;
            if (intent != null) {
                i4 = intent.getIntExtra("key_err_code", 0);
                str2 = intent.getStringExtra("key_err_msg");
                i5 = intent.getIntExtra("key_response_position", 0);
                if (i4 == 100000001) {
                    z = true;
                }
                C4990ab.m7417i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(i4), str2, Integer.valueOf(i5), String.valueOf(z));
            }
            CharSequence charSequence = str2;
            this.nEn.nzm = (long) i4;
            this.nEn.nzk = 0;
            if (i2 != -1) {
                this.nEn.nzl = 2;
                C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, C25738R.string.cje, 0).show();
            } else if (intent == null || i4 != 0) {
                if (z) {
                    this.nEn.nzl = 1;
                    C7060h.pYm.mo8378a(257, 17, 1, true);
                    charSequence = getString(C25738R.string.cjf);
                } else if (i5 == 3) {
                    this.nEn.nzl = 2;
                    C7060h.pYm.mo8378a(257, 16, 1, true);
                } else {
                    this.nEn.nzl = 2;
                }
                C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, charSequence, 0).show();
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    this.nEn.nzl = 3;
                    C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, C25738R.string.cjf, 0).show();
                } else {
                    this.nEn.nzl = 0;
                    C7060h.pYm.mo8378a(257, 15, 1, true);
                    C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    C30379h.m48438a((Context) this, getString(C25738R.string.cjg), getString(C25738R.string.cjh), new C1228211());
                }
            }
            this.nEn.nyL = C5046bo.anU();
            this.nEn.finish();
        }
        AppMethodBeat.m2505o(22272);
    }

    /* renamed from: JD */
    private void m20204JD(String str) {
        AppMethodBeat.m2504i(22273);
        if (TextUtils.isEmpty(str)) {
            str = getString(C25738R.string.cj0);
        }
        C30379h.m48438a((Context) this, str, getString(C25738R.string.cj0), new C1228312());
        AppMethodBeat.m2505o(22273);
    }

    /* renamed from: Pi */
    private boolean m20206Pi(String str) {
        AppMethodBeat.m2504i(22274);
        if (C34382c.bIS() && this.nEi >= 0) {
            Object item = this.nEr.getItem(this.nEi);
            if ((item instanceof crt) && !C5046bo.isNullOrNil(((crt) item).xpt)) {
                final String str2 = ((crt) item).xpt;
                C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(str2)));
                C30379h.m48445a((Context) this, str, getString(C25738R.string.cj0), getString(C25738R.string.cib), getString(C25738R.string.f9076or), true, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(22252);
                        C7060h.pYm.mo8378a(257, 3, 1, true);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("showShare", false);
                        C25985d.m41467b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.m2505o(22252);
                    }
                }, null);
                AppMethodBeat.m2505o(22274);
                return true;
            }
        }
        AppMethodBeat.m2505o(22274);
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(22275);
        C4990ab.m7417i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i2), str);
        if (c1207m instanceof C34372f) {
            C21080h c21080h = this.nEl;
            c21080h.nzh = C5046bo.anU();
            c21080h.nzi = (long) i2;
            if (i == 0 && i2 == 0) {
                aqo aqo = ((C34372f) c1207m).nyq;
                this.nEr.ngC = aqo.CellList;
                this.nEr.nEx = aqo;
                this.nEr.notifyDataSetChanged();
                this.lbs = new String[aqo.CellList.size()];
                Iterator it = aqo.CellList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.lbs[i4] = ((crt) it.next()).ProductID;
                    i4++;
                }
                this.nEj = aqo.wup;
                this.nEk = aqo.wuq;
                this.nEe = aqo.wuk;
                this.nEf = aqo.wuo;
                this.nEh = aqo.wun;
                if (this.nEg) {
                    this.nEd = new String[aqo.CellList.size()];
                    for (int i5 = 0; i5 < this.nEd.length; i5++) {
                        this.nEd[i5] = aqo.wuo;
                    }
                    this.nEc = new String[aqo.CellList.size()];
                    while (i3 < this.nEc.length) {
                        this.nEc[i3] = IPCallDynamicTextView.m44981Pg(((crt) aqo.CellList.get(i3)).wOs);
                        i3++;
                    }
                }
                if (((C34372f) c1207m).nyr) {
                    C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.lbs != null && this.lbs.length > 0) {
                        C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        C23249h.m35678a(this, this.lbs, this.lbF);
                    }
                    AppMethodBeat.m2505o(22275);
                    return;
                }
                if (this.nBv != null && this.nBv.isShowing()) {
                    this.nBv.dismiss();
                }
                bIt();
                AppMethodBeat.m2505o(22275);
                return;
            }
            if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
            }
            Toast.makeText(this.mController.ylL, getString(C25738R.string.cgx), 0).show();
            finish();
        }
        AppMethodBeat.m2505o(22275);
    }

    public final void bIt() {
        AppMethodBeat.m2504i(22276);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
        AppMethodBeat.m2505o(22276);
    }

    /* renamed from: h */
    static /* synthetic */ void m20219h(IPCallRechargeUI iPCallRechargeUI) {
        AppMethodBeat.m2504i(22278);
        C30379h.m48424a(iPCallRechargeUI.mController.ylL, null, null, iPCallRechargeUI.getResources().getString(C25738R.string.cjd), false, new C122919());
        AppMethodBeat.m2505o(22278);
    }

    /* renamed from: j */
    static /* synthetic */ void m20221j(IPCallRechargeUI iPCallRechargeUI) {
        AppMethodBeat.m2504i(22279);
        if (iPCallRechargeUI.nEr != null) {
            iPCallRechargeUI.nEr.ngC = null;
            iPCallRechargeUI.nEr.notifyDataSetChanged();
        }
        if (iPCallRechargeUI.nEq != null) {
            iPCallRechargeUI.nEq.setVisibility(4);
        }
        if (iPCallRechargeUI.nBv != null) {
            iPCallRechargeUI.nBv.show();
        }
        iPCallRechargeUI.m20205Ph("");
        AppMethodBeat.m2505o(22279);
    }

    /* renamed from: k */
    static /* synthetic */ void m20222k(IPCallRechargeUI iPCallRechargeUI) {
        AppMethodBeat.m2504i(22280);
        if (!(C5046bo.isNullOrNil(iPCallRechargeUI.nEj) || C5046bo.isNullOrNil(iPCallRechargeUI.nEk))) {
            C4990ab.m7416i("MicroMsg.IPCallRechargeUI", "showGotoExchangeRecordsAlert");
            C30379h.m48445a((Context) iPCallRechargeUI, iPCallRechargeUI.nEk, iPCallRechargeUI.nEj, iPCallRechargeUI.getString(C25738R.string.chi), iPCallRechargeUI.getString(C25738R.string.chj), false, null, new C122774());
        }
        AppMethodBeat.m2505o(22280);
    }
}

package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C18256eo;
import com.tencent.p177mm.p230g.p231a.C9472sl;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.exdevice.model.C20495e;
import com.tencent.p177mm.plugin.exdevice.model.C20495e.C20494b;
import com.tencent.p177mm.plugin.exdevice.model.C27852f;
import com.tencent.p177mm.plugin.exdevice.model.C38957l;
import com.tencent.p177mm.plugin.exdevice.model.C42998t;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.protocal.protobuf.C30196jl;
import com.tencent.p177mm.protocal.protobuf.buq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI */
public class ExdeviceAddDataSourceUI extends MMActivity implements C1202f, C20494b {
    private C44275p ejZ;
    private final BroadcastReceiver jIA = new C430084();
    private View kZq;
    private C43011a lyc;
    private List<C11666b> lyd;
    private TextView lye;
    private TextView lyf;
    private TextView lyg;
    private RelativeLayout lyh;
    private LocationManager lyi;
    private boolean lyj = false;
    private C38957l lyk;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$b */
    static class C11666b {
        String cxb;
        public String iconUrl;
        C27878c lys;
        String mac;
        String name;

        private C11666b() {
            this.lys = C27878c.NORMAL;
        }

        /* synthetic */ C11666b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$1 */
    class C205551 implements OnMenuItemClickListener {
        C205551() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19769);
            ExdeviceAddDataSourceUI.this.finish();
            AppMethodBeat.m2505o(19769);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$2 */
    class C205562 implements Runnable {
        C205562() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19770);
            if (ExdeviceAddDataSourceUI.this.ejZ != null && ExdeviceAddDataSourceUI.this.ejZ.isShowing()) {
                ExdeviceAddDataSourceUI.this.ejZ.dismiss();
            }
            AppMethodBeat.m2505o(19770);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$8 */
    class C205588 implements Runnable {
        C205588() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19782);
            ExdeviceAddDataSourceUI.this.lyc.mo68551bw(ExdeviceAddDataSourceUI.this.lyd);
            ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
            AppMethodBeat.m2505o(19782);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$9 */
    class C205599 implements Runnable {
        C205599() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19783);
            ExdeviceAddDataSourceUI.this.kZq.setVisibility(8);
            ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
            AppMethodBeat.m2505o(19783);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$7 */
    class C278767 implements Runnable {
        C278767() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19781);
            C4990ab.m7410d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
            C4879a.xxA.mo10055m(new C9472sl());
            AppMethodBeat.m2505o(19781);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$c */
    enum C27878c {
        NORMAL,
        ADDING,
        ADDED;

        static {
            AppMethodBeat.m2505o(19797);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$11 */
    class C4300711 implements Runnable {
        C4300711() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19787);
            ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
            AppMethodBeat.m2505o(19787);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$4 */
    class C430084 extends BroadcastReceiver {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$4$1 */
        class C116651 implements Runnable {
            C116651() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19773);
                if (!ExdeviceAddDataSourceUI.this.lyj || ExdeviceAddDataSourceUI.this.lyi.isProviderEnabled("gps")) {
                    ExdeviceAddDataSourceUI.m85052a(ExdeviceAddDataSourceUI.this, 3);
                    C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                    AppMethodBeat.m2505o(19773);
                    return;
                }
                ExdeviceAddDataSourceUI.m85052a(ExdeviceAddDataSourceUI.this, 4);
                AppMethodBeat.m2505o(19773);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$4$3 */
        class C205573 implements Runnable {
            C205573() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19775);
                if (C42904a.aVH()) {
                    ExdeviceAddDataSourceUI.m85052a(ExdeviceAddDataSourceUI.this, 3);
                    C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                    AppMethodBeat.m2505o(19775);
                    return;
                }
                ExdeviceAddDataSourceUI.m85052a(ExdeviceAddDataSourceUI.this, 1);
                AppMethodBeat.m2505o(19775);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$4$2 */
        class C278742 implements Runnable {
            C278742() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19774);
                ExdeviceAddDataSourceUI.m85052a(ExdeviceAddDataSourceUI.this, 1);
                C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                AppMethodBeat.m2505o(19774);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$4$4 */
        class C278754 implements Runnable {
            C278754() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19776);
                ExdeviceAddDataSourceUI.m85052a(ExdeviceAddDataSourceUI.this, 4);
                C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                AppMethodBeat.m2505o(19776);
            }
        }

        C430084() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(19777);
            if (intent == null) {
                C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
                AppMethodBeat.m2505o(19777);
                return;
            }
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", C8415j.INVALID_ID) == 12) {
                    if (C42904a.aVH()) {
                        ExdeviceAddDataSourceUI.this.runOnUiThread(new C116651());
                        if (!ExdeviceAddDataSourceUI.this.lyj || ExdeviceAddDataSourceUI.this.lyi.isProviderEnabled("gps")) {
                            C45891ad.bph();
                            C20495e.boJ();
                        }
                    }
                } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", C8415j.INVALID_ID) == 10 && !C42904a.aVH()) {
                    ExdeviceAddDataSourceUI.this.runOnUiThread(new C278742());
                    C45891ad.bpi().stopScan();
                }
            }
            if (ExdeviceAddDataSourceUI.this.lyj && "android.location.MODE_CHANGED".equals(action)) {
                if (ExdeviceAddDataSourceUI.this.lyi.isProviderEnabled("gps")) {
                    ExdeviceAddDataSourceUI.this.runOnUiThread(new C205573());
                    if (C42904a.aVH()) {
                        C45891ad.bph();
                        C20495e.boJ();
                        AppMethodBeat.m2505o(19777);
                        return;
                    }
                }
                ExdeviceAddDataSourceUI.this.runOnUiThread(new C278754());
                C45891ad.bpi().stopScan();
            }
            AppMethodBeat.m2505o(19777);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$5 */
    class C430095 extends ClickableSpan {
        C430095() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19778);
            C27852f.m44278ao(ExdeviceAddDataSourceUI.this.mController.ylL, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
            AppMethodBeat.m2505o(19778);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(19779);
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(19779);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$6 */
    class C430106 implements OnItemClickListener {
        C430106() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(19780);
            C11666b uN = ExdeviceAddDataSourceUI.this.lyc.mo68556uN(i - ((ListView) adapterView).getHeaderViewsCount());
            if (uN.lys != C27878c.NORMAL) {
                AppMethodBeat.m2505o(19780);
            } else if (ExdeviceAddDataSourceUI.m85050Kz(uN.mac)) {
                ExdeviceAddDataSourceUI.m85053a(ExdeviceAddDataSourceUI.this, uN.mac);
                uN.lys = C27878c.ADDING;
                ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
                AppMethodBeat.m2505o(19780);
            } else {
                C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
                AppMethodBeat.m2505o(19780);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$a */
    static final class C43011a extends BaseAdapter {
        private List<C11666b> lyd = new LinkedList();
        private C25814c lyr;

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$a$a */
        static class C27877a {
            TextView gxi;
            ImageView iqT;

            private C27877a() {
            }

            /* synthetic */ C27877a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(19794);
            C11666b uN = mo68556uN(i);
            AppMethodBeat.m2505o(19794);
            return uN;
        }

        public C43011a() {
            AppMethodBeat.m2504i(19788);
            C17927a c17927a = new C17927a();
            c17927a.ePT = C25738R.drawable.b2y;
            this.lyr = c17927a.ahG();
            AppMethodBeat.m2505o(19788);
        }

        /* renamed from: bw */
        public final void mo68551bw(List<C11666b> list) {
            AppMethodBeat.m2504i(19789);
            this.lyd.clear();
            if (list == null || list.size() == 0) {
                AppMethodBeat.m2505o(19789);
                return;
            }
            this.lyd.addAll(list);
            AppMethodBeat.m2505o(19789);
        }

        /* renamed from: KA */
        public final C11666b mo68550KA(String str) {
            AppMethodBeat.m2504i(19790);
            if (!C5046bo.isNullOrNil(str)) {
                for (C11666b c11666b : this.lyd) {
                    if (str.equalsIgnoreCase(c11666b.mac)) {
                        AppMethodBeat.m2505o(19790);
                        return c11666b;
                    }
                }
            }
            AppMethodBeat.m2505o(19790);
            return null;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(19791);
            int size = this.lyd.size();
            AppMethodBeat.m2505o(19791);
            return size;
        }

        /* renamed from: uN */
        public final C11666b mo68556uN(int i) {
            AppMethodBeat.m2504i(19792);
            C11666b c11666b = (C11666b) this.lyd.get(i);
            AppMethodBeat.m2505o(19792);
            return c11666b;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C27877a c27877a;
            AppMethodBeat.m2504i(19793);
            C11666b uN = mo68556uN(i);
            if (view == null) {
                C27877a c27877a2 = new C27877a();
                view = View.inflate(viewGroup.getContext(), 2130969406, null);
                c27877a2.iqT = (ImageView) view.findViewById(2131823624);
                c27877a2.gxi = (TextView) view.findViewById(2131823625);
                view.setTag(c27877a2);
                c27877a = c27877a2;
            } else {
                c27877a = (C27877a) view.getTag();
            }
            C4990ab.m7411d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), uN.name, uN.mac);
            c27877a.gxi.setText(uN.name);
            C32291o.ahp().mo43766a(uN.iconUrl, c27877a.iqT, this.lyr);
            AppMethodBeat.m2505o(19793);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ExdeviceAddDataSourceUI() {
        AppMethodBeat.m2504i(19798);
        AppMethodBeat.m2505o(19798);
    }

    /* renamed from: Kz */
    static /* synthetic */ boolean m85050Kz(String str) {
        AppMethodBeat.m2504i(19809);
        boolean aC = ExdeviceAddDataSourceUI.m85055aC(str, true);
        AppMethodBeat.m2505o(19809);
        return aC;
    }

    public final int getLayoutId() {
        return 2130969407;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(19799);
        super.onCreate(bundle);
        setBackBtn(new C205551());
        setMMTitle((int) C25738R.string.beg);
        if (!(!C1443d.m3068iW(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            this.lyj = true;
        }
        this.lyd = new LinkedList();
        this.lyi = (LocationManager) this.mController.ylL.getSystemService(C8741b.LOCATION);
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.mController.ylL.registerReceiver(this.jIA, intentFilter);
        C9638aw.m17182Rg().mo14539a(536, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1706, (C1202f) this);
        C45891ad.bph().mo35801a((C20494b) this);
        if (!C42904a.m76178dv(this.mController.ylL)) {
            C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
            m85063uM(2);
            AppMethodBeat.m2505o(19799);
        } else if (!C42904a.aVH()) {
            C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
            m85063uM(1);
            AppMethodBeat.m2505o(19799);
        } else if (this.lyi == null || !this.lyj || this.lyi.isProviderEnabled("gps")) {
            C45891ad.bph();
            C20495e.boJ();
            AppMethodBeat.m2505o(19799);
        } else {
            C4990ab.m7416i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
            m85063uM(4);
            AppMethodBeat.m2505o(19799);
        }
    }

    /* renamed from: uM */
    private void m85063uM(int i) {
        AppMethodBeat.m2504i(19800);
        switch (i) {
            case 1:
                this.lyh.setVisibility(8);
                this.lyf.setText(C25738R.string.bf7);
                this.lyg.setText(C25738R.string.ber);
                AppMethodBeat.m2505o(19800);
                return;
            case 2:
                this.lyh.setVisibility(8);
                this.lyf.setText(C25738R.string.bf5);
                this.lyg.setText("");
                AppMethodBeat.m2505o(19800);
                return;
            case 3:
                this.lyh.setVisibility(0);
                this.kZq.setVisibility(0);
                break;
            case 4:
                this.lyh.setVisibility(8);
                this.lyf.setText(C25738R.string.bf7);
                this.lyg.setText(C25738R.string.bgh);
                AppMethodBeat.m2505o(19800);
                return;
        }
        AppMethodBeat.m2505o(19800);
    }

    public final void initView() {
        AppMethodBeat.m2504i(19801);
        this.mListView = (ListView) findViewById(2131821698);
        View inflate = View.inflate(this, 2130969409, null);
        this.lyh = (RelativeLayout) findViewById(2131823629);
        this.kZq = View.inflate(this, 2130969408, null);
        this.lye = (TextView) findViewById(2131823630);
        this.lyf = (TextView) findViewById(2131823627);
        this.lyg = (TextView) findViewById(2131823628);
        String string = getString(C25738R.string.bhw);
        String string2 = getString(C25738R.string.bfl);
        SpannableString spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new ForegroundColorSpan(C25738R.color.f12123t7), string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new C430095(), string.length(), string.length() + string2.length(), 33);
        this.lye.setMovementMethod(LinkMovementMethod.getInstance());
        this.lye.setText(spannableString);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(this.kZq, null, false);
        this.lyc = new C43011a();
        this.mListView.setAdapter(this.lyc);
        this.mListView.setOnItemClickListener(new C430106());
        AppMethodBeat.m2505o(19801);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(19802);
        super.onDestroy();
        C9638aw.m17180RS().mo10302aa(new C278767());
        C9638aw.m17182Rg().mo14546b(536, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1706, (C1202f) this);
        this.mController.ylL.unregisterReceiver(this.jIA);
        C45891ad.bph().mo35803b(this);
        C45891ad.bpi().stopScan();
        AppMethodBeat.m2505o(19802);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19803);
        C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
            AppMethodBeat.m2505o(19803);
        } else if (c1207m.getType() == 536) {
            bpD();
            this.lyk = null;
            C30196jl boP = ((C38957l) c1207m).boP();
            if (i == 0 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("device_mac", C42992b.m76346KK(C42992b.m76347KL(boP.vLj.vKF)));
                ExdeviceAddDataSourceUI.m85055aC(C42992b.m76347KL(boP.vLj.vKF), false);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(19803);
                return;
            }
            C11666b KA = this.lyc.mo68550KA(C42992b.m76347KL(boP.vLj.vKF));
            if (KA != null) {
                KA.lys = C27878c.NORMAL;
                ExdeviceAddDataSourceUI.m85055aC(KA.mac, false);
            }
            C4990ab.m7412e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
            AppMethodBeat.m2505o(19803);
        } else {
            if (c1207m.getType() == 1706) {
                buq boS = ((C42998t) c1207m).boS();
                if (i == 0 && i2 == 0) {
                    C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", Long.valueOf(boS.vLj.dFq));
                    if (0 != (boS.vLj.dFq & 1)) {
                        if (C45891ad.boW().mo45706dS(boS.vLi.jBE, boS.vLi.vIk) != null) {
                            C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", boS.vLj.vKF);
                            AppMethodBeat.m2505o(19803);
                            return;
                        }
                        C11666b c11666b = new C11666b();
                        c11666b.name = boS.vKL.wyX == null ? "" : C1946aa.m4148a(boS.vKL.wyX);
                        c11666b.mac = C42992b.m76347KL(boS.vLj.vKF);
                        c11666b.cxb = boS.vKK;
                        c11666b.iconUrl = boS.vLj.IconUrl;
                        this.lyd.add(c11666b);
                        C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", c11666b.mac, c11666b.name);
                        runOnUiThread(new C205588());
                    }
                } else {
                    C4990ab.m7413e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.m2505o(19803);
                    return;
                }
            }
            AppMethodBeat.m2505o(19803);
        }
    }

    /* renamed from: p */
    public final void mo23423p(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(19804);
        C4990ab.m7411d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
        if (z) {
            runOnUiThread(new C205599());
        }
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
            AppMethodBeat.m2505o(19804);
            return;
        }
        int i = 0;
        while (i < this.lyd.size()) {
            int i2;
            C11666b c11666b = (C11666b) this.lyd.get(i);
            if (c11666b == null || C5046bo.isNullOrNil(c11666b.mac)) {
                i2 = i - 1;
                this.lyd.remove(i);
            } else if (c11666b.mac.equalsIgnoreCase(str2)) {
                C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", str2);
                AppMethodBeat.m2505o(19804);
                return;
            } else {
                i2 = i;
            }
            i = i2 + 1;
        }
        boolean a = C9638aw.m17182Rg().mo14541a(new C42998t(str2.replaceAll(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, ""), null, null), 0);
        C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", Boolean.valueOf(a), str2);
        AppMethodBeat.m2505o(19804);
    }

    /* renamed from: c */
    public final void mo23422c(String str, int i, long j) {
        AppMethodBeat.m2504i(19805);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
            AppMethodBeat.m2505o(19805);
            return;
        }
        final C11666b KA = this.lyc.mo68550KA(str);
        if (KA == null) {
            C4990ab.m7421w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", str);
            AppMethodBeat.m2505o(19805);
            return;
        }
        if (KA.lys == C27878c.ADDING && i == 4) {
            KA.lys = C27878c.NORMAL;
            bpD();
            runOnUiThread(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$10$2 */
                class C278722 implements OnClickListener {
                    C278722() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(19785);
                        C27852f.m44278ao(ExdeviceAddDataSourceUI.this.mController.ylL, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
                        AppMethodBeat.m2505o(19785);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$10$1 */
                class C278731 implements OnClickListener {
                    C278731() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(19784);
                        ExdeviceAddDataSourceUI.this.lyd.remove(KA);
                        ExdeviceAddDataSourceUI.this.lyc.mo68551bw(ExdeviceAddDataSourceUI.this.lyd);
                        ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
                        AppMethodBeat.m2505o(19784);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(19786);
                    C30379h.m48429a(ExdeviceAddDataSourceUI.this, (int) C25738R.string.bfo, (int) C25738R.string.bfm, (int) C25738R.string.bfn, (int) C25738R.string.bfp, false, new C278731(), new C278722()).show();
                    AppMethodBeat.m2505o(19786);
                }
            });
        } else if (i == 2) {
            if (KA.lys == C27878c.ADDING) {
                KA.lys = C27878c.ADDED;
                C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", KA.mac, KA.name);
                if (KA.cxb != null) {
                    this.lyk = new C38957l(KA.cxb, 0);
                    C9638aw.m17182Rg().mo14541a(this.lyk, 0);
                }
            } else {
                C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", str);
                ExdeviceAddDataSourceUI.m85055aC(str, false);
            }
        } else if (i == 1 || i == 2) {
            AppMethodBeat.m2505o(19805);
            return;
        } else {
            KA.lys = C27878c.NORMAL;
        }
        runOnUiThread(new C4300711());
        AppMethodBeat.m2505o(19805);
    }

    /* renamed from: b */
    public final void mo23421b(String str, byte[] bArr, boolean z) {
    }

    /* renamed from: aC */
    private static boolean m85055aC(String str, boolean z) {
        AppMethodBeat.m2504i(19806);
        C18256eo c18256eo = new C18256eo();
        c18256eo.cye.mac = str;
        c18256eo.cye.cwA = z;
        if (C4879a.xxA.mo10055m(c18256eo)) {
            AppMethodBeat.m2505o(19806);
            return true;
        }
        C4990ab.m7417i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", str);
        AppMethodBeat.m2505o(19806);
        return false;
    }

    private void bpD() {
        AppMethodBeat.m2504i(19807);
        runOnUiThread(new C205562());
        AppMethodBeat.m2505o(19807);
    }
}

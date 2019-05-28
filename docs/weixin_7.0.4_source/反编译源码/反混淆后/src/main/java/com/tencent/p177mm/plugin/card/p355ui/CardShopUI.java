package com.tencent.p177mm.plugin.card.p355ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2278j;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C6814m;
import com.tencent.p177mm.plugin.card.p352b.C6814m.C6815a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI */
public class CardShopUI extends MMActivity implements C6815a {
    private ProgressDialog fsh;
    private OnClickListener gKK = new C387625();
    BroadcastReceiver jIA = new C387644();
    private String kaE;
    private C42837b kaS;
    private ArrayList<C23422od> kaY = new ArrayList();
    private boolean khx = false;
    private LinearLayout knA;
    private View knB;
    private TextView knC;
    private String kny = "";
    private C33785a knz;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$2 */
    class C201702 implements OnMenuItemClickListener {
        C201702() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88630);
            CardShopUI.this.finish();
            AppMethodBeat.m2505o(88630);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$a */
    class C33785a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$a$a */
        class C33784a {
            public TextView knE;
            public TextView knF;
            public TextView knG;
            public ImageView knH;
            public View knI;

            C33784a() {
            }
        }

        /* synthetic */ C33785a(CardShopUI cardShopUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(88638);
            C23422od tf = m55233tf(i);
            AppMethodBeat.m2505o(88638);
            return tf;
        }

        private C33785a() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(88635);
            int size = CardShopUI.this.kaY.size();
            AppMethodBeat.m2505o(88635);
            return size;
        }

        /* renamed from: tf */
        private C23422od m55233tf(int i) {
            AppMethodBeat.m2504i(88636);
            C23422od c23422od = (C23422od) CardShopUI.this.kaY.get(i);
            AppMethodBeat.m2505o(88636);
            return c23422od;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C33784a c33784a;
            AppMethodBeat.m2504i(88637);
            if (view == null) {
                view = View.inflate(CardShopUI.this.mController.ylL, 2130968978, null);
                C33784a c33784a2 = new C33784a();
                c33784a2.knE = (TextView) view.findViewById(2131822311);
                c33784a2.knF = (TextView) view.findViewById(2131822312);
                c33784a2.knG = (TextView) view.findViewById(2131822313);
                c33784a2.knH = (ImageView) view.findViewById(2131822315);
                c33784a2.knI = view.findViewById(2131822314);
                view.setTag(c33784a2);
                c33784a = c33784a2;
            } else {
                c33784a = (C33784a) view.getTag();
            }
            C23422od tf = m55233tf(i);
            if (tf == null) {
                c33784a.knE.setText("");
                c33784a.knF.setText("");
                c33784a.knG.setText("");
                AppMethodBeat.m2505o(88637);
            } else {
                c33784a.knE.setText(tf.name);
                if (tf.qVo <= 0.0f) {
                    c33784a.knF.setVisibility(8);
                } else {
                    c33784a.knF.setText(C38736l.m65730g(CardShopUI.this.getBaseContext(), tf.qVo));
                    c33784a.knF.setVisibility(0);
                }
                c33784a.knG.setText(tf.duc + tf.dud + tf.fBg);
                c33784a.knI.setOnClickListener(CardShopUI.this.gKK);
                c33784a.knI.setTag(tf);
                AppMethodBeat.m2505o(88637);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$3 */
    class C387613 implements OnCancelListener {
        C387613() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(88631);
            C6814m baZ = C42852am.baZ();
            baZ.mo15083a(CardShopUI.this.kny, CardShopUI.this);
            if (baZ.kbR != null) {
                C1720g.m3535RO().eJo.mo14547c(baZ.kbR);
            }
            AppMethodBeat.m2505o(88631);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$5 */
    class C387625 implements OnClickListener {
        C387625() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88633);
            if (view.getId() == 2131822314) {
                C23422od c23422od = (C23422od) view.getTag();
                if (c23422od != null) {
                    C45774b.m84622a(CardShopUI.this, c23422od.cEB, c23422od.cGm, c23422od.fBg);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(5), CardShopUI.this.kaS.aZZ(), CardShopUI.this.kaS.baa(), "", c23422od.name);
                }
            }
            AppMethodBeat.m2505o(88633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$6 */
    class C387636 implements DialogInterface.OnClickListener {
        C387636() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88634);
            CardShopUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(88634);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$4 */
    class C387644 extends BroadcastReceiver {
        C387644() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(88632);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.LOCALE_CHANGED") && CardShopUI.bdv()) {
                CardShopUI.m65766e(CardShopUI.this);
            }
            AppMethodBeat.m2505o(88632);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardShopUI() {
        AppMethodBeat.m2504i(88639);
        AppMethodBeat.m2505o(88639);
    }

    static /* synthetic */ boolean bdv() {
        AppMethodBeat.m2504i(88649);
        boolean bdu = CardShopUI.bdu();
        AppMethodBeat.m2505o(88649);
        return bdu;
    }

    /* renamed from: e */
    static /* synthetic */ void m65766e(CardShopUI cardShopUI) {
        AppMethodBeat.m2504i(88650);
        cardShopUI.axU();
        AppMethodBeat.m2505o(88650);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        CardShopUI cardShopUI;
        AppMethodBeat.m2504i(88640);
        super.onCreate(bundle);
        this.kaS = (C42837b) getIntent().getParcelableExtra("key_card_info_data");
        String stringExtra = getIntent().getStringExtra("KEY_CARD_TP_ID");
        String stringExtra2 = getIntent().getStringExtra("KEY_CARD_ID");
        if (this.kaS != null) {
            C4990ab.m7416i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
            this.kny = this.kaS.baa();
            stringExtra2 = this.kaS.aZZ();
            cardShopUI = this;
        } else {
            if (!TextUtils.isEmpty(stringExtra)) {
                this.kny = stringExtra;
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "";
                    cardShopUI = this;
                } else {
                    cardShopUI = this;
                }
            }
            if (TextUtils.isEmpty(this.kny)) {
                C4990ab.m7412e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
                finish();
            }
            C4990ab.m7417i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.khx = r0;
            if (this.khx) {
                bdt();
            }
            initView();
            AppMethodBeat.m2505o(88640);
        }
        cardShopUI.kaE = stringExtra2;
        if (TextUtils.isEmpty(this.kny)) {
        }
        C4990ab.m7417i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.khx = r0;
        if (this.khx) {
        }
        initView();
        AppMethodBeat.m2505o(88640);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88641);
        if (TextUtils.isEmpty(this.kaS.aZV().vUz)) {
            setMMTitle((int) C25738R.string.acr);
        } else {
            setMMTitle(this.kaS.aZV().vUz);
        }
        this.mListView = (ListView) findViewById(2131822316);
        this.knA = (LinearLayout) View.inflate(getBaseContext(), 2130968951, null);
        this.mListView.addHeaderView(this.knA);
        this.knz = new C33785a(this, (byte) 0);
        this.mListView.setAdapter(this.knz);
        final Intent intent = getIntent();
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(88629);
                if (i == 0) {
                    C4990ab.m7418v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
                    AppMethodBeat.m2505o(88629);
                    return;
                }
                if (i > 0) {
                    i--;
                }
                C23422od c23422od = (C23422od) CardShopUI.this.kaY.get(i);
                if (TextUtils.isEmpty(c23422od.vTL) || TextUtils.isEmpty(c23422od.vTM)) {
                    if (!TextUtils.isEmpty(c23422od.kdF)) {
                        C45774b.m84626a(CardShopUI.this, c23422od.kdF, 1);
                        C7060h.pYm.mo8381e(11941, Integer.valueOf(4), CardShopUI.this.kaS.aZZ(), CardShopUI.this.kaS.baa(), "", c23422od.name);
                    }
                    AppMethodBeat.m2505o(88629);
                    return;
                }
                C45774b.m84634d(CardShopUI.this.kaE, c23422od.vTL, c23422od.vTM, FilterEnum4Shaka.MIC_SHAKA_ADD2_17, intent.getIntExtra("key_from_appbrand_type", 0));
                AppMethodBeat.m2505o(88629);
            }
        });
        setBackBtn(new C201702());
        this.knB = View.inflate(this, 2130968950, null);
        if (this.knA != null) {
            this.knA.addView(this.knB);
        }
        this.knC = (TextView) this.knB.findViewById(2131822213);
        this.knC.setText(C25738R.string.aho);
        this.knB.setVisibility(8);
        AppMethodBeat.m2505o(88641);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88642);
        if (this.khx) {
            unregisterReceiver(this.jIA);
        }
        C42852am.baZ().mo15083a(this.kny, this);
        super.onDestroy();
        AppMethodBeat.m2505o(88642);
    }

    public final int getLayoutId() {
        return 2130968980;
    }

    /* renamed from: a */
    public final void mo15085a(boolean z, ArrayList<C23422od> arrayList) {
        AppMethodBeat.m2504i(88643);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        String str = "MicroMsg.CardShopUI";
        String str2 = "onGotCardShop, isOk = %b, shop list size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        C4990ab.m7411d(str, str2, objArr);
        if (!z) {
            C4990ab.m7412e("MicroMsg.CardShopUI", "onGotCardShop fail");
            AppMethodBeat.m2505o(88643);
        } else if (arrayList == null || arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
            AppMethodBeat.m2505o(88643);
        } else {
            if (this.kaY != null) {
                this.kaY.clear();
                this.kaY.addAll(arrayList);
                this.knB.setVisibility(0);
            } else {
                this.knB.setVisibility(8);
            }
            this.knz.notifyDataSetChanged();
            AppMethodBeat.m2505o(88643);
        }
    }

    private void bdt() {
        AppMethodBeat.m2504i(88644);
        C4990ab.m7416i("MicroMsg.CardShopUI", C2278j.NAME);
        registerReceiver();
        if (CardShopUI.bdu()) {
            axU();
            AppMethodBeat.m2505o(88644);
            return;
        }
        C42840d.m76039c(this);
        AppMethodBeat.m2505o(88644);
    }

    private static boolean bdu() {
        boolean z;
        AppMethodBeat.m2504i(88645);
        if (C38736l.agA() || C38736l.agB()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.m2505o(88645);
            return false;
        }
        AppMethodBeat.m2505o(88645);
        return true;
    }

    private void axU() {
        AppMethodBeat.m2504i(88646);
        if (C42852am.baZ().mo15084a(this.kny, this.kaE, (C6815a) this)) {
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.fsh = C30379h.m48458b(context, getString(C25738R.string.ady), true, new C387613());
            AppMethodBeat.m2505o(88646);
            return;
        }
        C30379h.m48465bQ(this, getString(C25738R.string.adx));
        AppMethodBeat.m2505o(88646);
    }

    private void registerReceiver() {
        AppMethodBeat.m2504i(88647);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.jIA, intentFilter);
        AppMethodBeat.m2505o(88647);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(88648);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(88648);
            return;
        }
        C4990ab.m7417i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.atb), false, new C387636(), null);
                    break;
                }
                C4990ab.m7416i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.khx);
                if (!this.khx) {
                    this.khx = true;
                    bdt();
                }
                AppMethodBeat.m2505o(88648);
                return;
        }
        AppMethodBeat.m2505o(88648);
    }
}

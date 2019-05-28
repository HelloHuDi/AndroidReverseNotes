package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.e.j;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;

public class CardShopUI extends MMActivity implements com.tencent.mm.plugin.card.b.m.a {
    private ProgressDialog fsh;
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(88633);
            if (view.getId() == R.id.ajt) {
                od odVar = (od) view.getTag();
                if (odVar != null) {
                    b.a(CardShopUI.this, odVar.cEB, odVar.cGm, odVar.fBg);
                    h.pYm.e(11941, Integer.valueOf(5), CardShopUI.this.kaS.aZZ(), CardShopUI.this.kaS.baa(), "", odVar.name);
                }
            }
            AppMethodBeat.o(88633);
        }
    };
    BroadcastReceiver jIA = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(88632);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.LOCALE_CHANGED") && CardShopUI.bdv()) {
                CardShopUI.e(CardShopUI.this);
            }
            AppMethodBeat.o(88632);
        }
    };
    private String kaE;
    private com.tencent.mm.plugin.card.base.b kaS;
    private ArrayList<od> kaY = new ArrayList();
    private boolean khx = false;
    private LinearLayout knA;
    private View knB;
    private TextView knC;
    private String kny = "";
    private a knz;
    private ListView mListView;

    class a extends BaseAdapter {

        class a {
            public TextView knE;
            public TextView knF;
            public TextView knG;
            public ImageView knH;
            public View knI;

            a() {
            }
        }

        /* synthetic */ a(CardShopUI cardShopUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(88638);
            od tf = tf(i);
            AppMethodBeat.o(88638);
            return tf;
        }

        private a() {
        }

        public final int getCount() {
            AppMethodBeat.i(88635);
            int size = CardShopUI.this.kaY.size();
            AppMethodBeat.o(88635);
            return size;
        }

        private od tf(int i) {
            AppMethodBeat.i(88636);
            od odVar = (od) CardShopUI.this.kaY.get(i);
            AppMethodBeat.o(88636);
            return odVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(88637);
            if (view == null) {
                view = View.inflate(CardShopUI.this.mController.ylL, R.layout.k6, null);
                a aVar2 = new a();
                aVar2.knE = (TextView) view.findViewById(R.id.ajq);
                aVar2.knF = (TextView) view.findViewById(R.id.ajr);
                aVar2.knG = (TextView) view.findViewById(R.id.ajs);
                aVar2.knH = (ImageView) view.findViewById(R.id.aju);
                aVar2.knI = view.findViewById(R.id.ajt);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            od tf = tf(i);
            if (tf == null) {
                aVar.knE.setText("");
                aVar.knF.setText("");
                aVar.knG.setText("");
                AppMethodBeat.o(88637);
            } else {
                aVar.knE.setText(tf.name);
                if (tf.qVo <= 0.0f) {
                    aVar.knF.setVisibility(8);
                } else {
                    aVar.knF.setText(l.g(CardShopUI.this.getBaseContext(), tf.qVo));
                    aVar.knF.setVisibility(0);
                }
                aVar.knG.setText(tf.duc + tf.dud + tf.fBg);
                aVar.knI.setOnClickListener(CardShopUI.this.gKK);
                aVar.knI.setTag(tf);
                AppMethodBeat.o(88637);
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardShopUI() {
        AppMethodBeat.i(88639);
        AppMethodBeat.o(88639);
    }

    static /* synthetic */ boolean bdv() {
        AppMethodBeat.i(88649);
        boolean bdu = bdu();
        AppMethodBeat.o(88649);
        return bdu;
    }

    static /* synthetic */ void e(CardShopUI cardShopUI) {
        AppMethodBeat.i(88650);
        cardShopUI.axU();
        AppMethodBeat.o(88650);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        CardShopUI cardShopUI;
        AppMethodBeat.i(88640);
        super.onCreate(bundle);
        this.kaS = (com.tencent.mm.plugin.card.base.b) getIntent().getParcelableExtra("key_card_info_data");
        String stringExtra = getIntent().getStringExtra("KEY_CARD_TP_ID");
        String stringExtra2 = getIntent().getStringExtra("KEY_CARD_ID");
        if (this.kaS != null) {
            ab.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
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
                ab.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
                finish();
            }
            ab.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.khx = r0;
            if (this.khx) {
                bdt();
            }
            initView();
            AppMethodBeat.o(88640);
        }
        cardShopUI.kaE = stringExtra2;
        if (TextUtils.isEmpty(this.kny)) {
        }
        ab.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.khx = r0;
        if (this.khx) {
        }
        initView();
        AppMethodBeat.o(88640);
    }

    public final void initView() {
        AppMethodBeat.i(88641);
        if (TextUtils.isEmpty(this.kaS.aZV().vUz)) {
            setMMTitle((int) R.string.acr);
        } else {
            setMMTitle(this.kaS.aZV().vUz);
        }
        this.mListView = (ListView) findViewById(R.id.ajv);
        this.knA = (LinearLayout) View.inflate(getBaseContext(), R.layout.jf, null);
        this.mListView.addHeaderView(this.knA);
        this.knz = new a(this, (byte) 0);
        this.mListView.setAdapter(this.knz);
        final Intent intent = getIntent();
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(88629);
                if (i == 0) {
                    ab.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
                    AppMethodBeat.o(88629);
                    return;
                }
                if (i > 0) {
                    i--;
                }
                od odVar = (od) CardShopUI.this.kaY.get(i);
                if (TextUtils.isEmpty(odVar.vTL) || TextUtils.isEmpty(odVar.vTM)) {
                    if (!TextUtils.isEmpty(odVar.kdF)) {
                        b.a(CardShopUI.this, odVar.kdF, 1);
                        h.pYm.e(11941, Integer.valueOf(4), CardShopUI.this.kaS.aZZ(), CardShopUI.this.kaS.baa(), "", odVar.name);
                    }
                    AppMethodBeat.o(88629);
                    return;
                }
                b.d(CardShopUI.this.kaE, odVar.vTL, odVar.vTM, FilterEnum4Shaka.MIC_SHAKA_ADD2_17, intent.getIntExtra("key_from_appbrand_type", 0));
                AppMethodBeat.o(88629);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88630);
                CardShopUI.this.finish();
                AppMethodBeat.o(88630);
                return true;
            }
        });
        this.knB = View.inflate(this, R.layout.je, null);
        if (this.knA != null) {
            this.knA.addView(this.knB);
        }
        this.knC = (TextView) this.knB.findViewById(R.id.ah3);
        this.knC.setText(R.string.aho);
        this.knB.setVisibility(8);
        AppMethodBeat.o(88641);
    }

    public void onDestroy() {
        AppMethodBeat.i(88642);
        if (this.khx) {
            unregisterReceiver(this.jIA);
        }
        am.baZ().a(this.kny, this);
        super.onDestroy();
        AppMethodBeat.o(88642);
    }

    public final int getLayoutId() {
        return R.layout.k8;
    }

    public final void a(boolean z, ArrayList<od> arrayList) {
        AppMethodBeat.i(88643);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        String str = "MicroMsg.CardShopUI";
        String str2 = "onGotCardShop, isOk = %b, shop list size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        ab.d(str, str2, objArr);
        if (!z) {
            ab.e("MicroMsg.CardShopUI", "onGotCardShop fail");
            AppMethodBeat.o(88643);
        } else if (arrayList == null || arrayList.size() == 0) {
            ab.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
            AppMethodBeat.o(88643);
        } else {
            if (this.kaY != null) {
                this.kaY.clear();
                this.kaY.addAll(arrayList);
                this.knB.setVisibility(0);
            } else {
                this.knB.setVisibility(8);
            }
            this.knz.notifyDataSetChanged();
            AppMethodBeat.o(88643);
        }
    }

    private void bdt() {
        AppMethodBeat.i(88644);
        ab.i("MicroMsg.CardShopUI", j.NAME);
        registerReceiver();
        if (bdu()) {
            axU();
            AppMethodBeat.o(88644);
            return;
        }
        d.c(this);
        AppMethodBeat.o(88644);
    }

    private static boolean bdu() {
        boolean z;
        AppMethodBeat.i(88645);
        if (l.agA() || l.agB()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(88645);
            return false;
        }
        AppMethodBeat.o(88645);
        return true;
    }

    private void axU() {
        AppMethodBeat.i(88646);
        if (am.baZ().a(this.kny, this.kaE, (com.tencent.mm.plugin.card.b.m.a) this)) {
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.fsh = com.tencent.mm.ui.base.h.b(context, getString(R.string.ady), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(88631);
                    m baZ = am.baZ();
                    baZ.a(CardShopUI.this.kny, CardShopUI.this);
                    if (baZ.kbR != null) {
                        g.RO().eJo.c(baZ.kbR);
                    }
                    AppMethodBeat.o(88631);
                }
            });
            AppMethodBeat.o(88646);
            return;
        }
        com.tencent.mm.ui.base.h.bQ(this, getString(R.string.adx));
        AppMethodBeat.o(88646);
    }

    private void registerReceiver() {
        AppMethodBeat.i(88647);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.jIA, intentFilter);
        AppMethodBeat.o(88647);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(88648);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(88648);
            return;
        }
        ab.i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.atb), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(88634);
                            CardShopUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(88634);
                        }
                    }, null);
                    break;
                }
                ab.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.khx);
                if (!this.khx) {
                    this.khx = true;
                    bdt();
                }
                AppMethodBeat.o(88648);
                return;
        }
        AppMethodBeat.o(88648);
    }
}

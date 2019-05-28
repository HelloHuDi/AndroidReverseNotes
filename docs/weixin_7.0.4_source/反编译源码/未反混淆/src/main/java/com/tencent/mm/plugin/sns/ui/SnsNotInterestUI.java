package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.q.b;
import java.util.HashMap;

public class SnsNotInterestUI extends MMPreference implements f {
    private static final String[] ruB = new String[]{"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] ruC = new int[]{1, 2, 4, 8, 16, 32, 64};
    private static final int[] ruG = new int[]{R.string.ekh, R.string.ekm, R.string.ekn, R.string.ekg, R.string.ekf, R.string.ekk, R.string.eki};
    private p ejZ = null;
    private com.tencent.mm.ui.base.preference.f iFE;
    private String psX = null;
    private HashMap<String, Boolean> ruD = new HashMap(ruB.length);
    private HashMap<Integer, Boolean> ruE = new HashMap(ruC.length);
    private HashMap<String, Integer> ruF = new HashMap(ruC.length);
    private TextView ruH;
    private EditText ruI;
    private ListView ruJ;
    private LinearLayout ruK;
    private int ruL;
    private int ruM;
    private long ruN;
    private boolean ruO = false;
    private boolean ruP = false;
    r ruQ = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsNotInterestUI() {
        AppMethodBeat.i(39127);
        AppMethodBeat.o(39127);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39128);
        super.onCreate(bundle);
        this.ruL = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.ruN = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (this.ruN != 0) {
            String str = af.cnF().kD(this.ruN).field_userName;
            if (str != null) {
                g.RQ();
                ad aoN = ((j) g.K(j.class)).XM().aoN(str);
                if (aoN.dtS == 2) {
                    ruG[1] = R.string.ekl;
                } else if (aoN.dtS == 1) {
                    ruG[1] = R.string.ekm;
                }
            }
        }
        g.RQ();
        g.RO().eJo.a(218, (f) this);
        ctF();
        initView();
        AppMethodBeat.o(39128);
    }

    private void ctF() {
        int i = 0;
        AppMethodBeat.i(39129);
        for (Object put : ruB) {
            this.ruD.put(put, Boolean.FALSE);
        }
        for (int valueOf : ruC) {
            this.ruE.put(Integer.valueOf(valueOf), Boolean.FALSE);
        }
        while (i < ruC.length) {
            this.ruF.put(ruB[i], Integer.valueOf(ruC[i]));
            i++;
        }
        AppMethodBeat.o(39129);
    }

    public void onDestroy() {
        AppMethodBeat.i(39130);
        super.onDestroy();
        ctF();
        g.RQ();
        g.RO().eJo.b(218, (f) this);
        gm gmVar = new gm();
        gmVar.cBf.cBg = this.ruO;
        gmVar.cBf.cBh = this.ruN;
        a.xxA.m(gmVar);
        AppMethodBeat.o(39130);
    }

    public final void initView() {
        AppMethodBeat.i(39131);
        super.initView();
        setMMTitle((int) R.string.ekq);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39123);
                SnsNotInterestUI.this.finish();
                AppMethodBeat.o(39123);
                return true;
            }
        });
        this.ruH = (TextView) findViewById(R.id.eik);
        this.ruI = (EditText) findViewById(R.id.eil);
        this.ruJ = (ListView) findViewById(16908298);
        this.ruK = (LinearLayout) findViewById(R.id.eij);
        this.ruK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39124);
                SnsNotInterestUI.this.ruK.requestFocus();
                SnsNotInterestUI.this.aqX();
                AppMethodBeat.o(39124);
            }
        });
        this.ruI.setVisibility(8);
        this.ruH.setVisibility(8);
        this.iFE = this.yCw;
        ctG();
        a(0, getString(R.string.a9m), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39125);
                SnsNotInterestUI.b(SnsNotInterestUI.this);
                AppMethodBeat.o(39125);
                return true;
            }
        }, b.GREEN);
        enableOptionMenu(0, false);
        AppMethodBeat.o(39131);
    }

    private void ctG() {
        AppMethodBeat.i(39132);
        if (this.iFE == null) {
            ab.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
            AppMethodBeat.o(39132);
            return;
        }
        if (this.iFE.aqO("sns_expose_desc") == null) {
            PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
            preferenceTitleCategory.setTitle((int) R.string.ekd);
            preferenceTitleCategory.setKey("sns_expose_desc");
            this.iFE.b(preferenceTitleCategory);
        }
        for (int i = 0; i < ruB.length; i++) {
            String str = ruB[i];
            int i2 = ruG[i];
            if (this.iFE.aqO(str) == null) {
                Preference preference = new Preference(this);
                preference.setTitle(i2);
                preference.setKey(str);
                preference.setLayoutResource(R.layout.ae4);
                preference.setWidgetLayoutResource(R.layout.aed);
                this.iFE.b(preference);
            }
        }
        AppMethodBeat.o(39132);
    }

    public final int getLayoutId() {
        return R.layout.av6;
    }

    public final int JC() {
        return -1;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(39133);
        if (preference == null) {
            AppMethodBeat.o(39133);
            return false;
        }
        String str = preference.mKey;
        if (this.ruD.containsKey(str)) {
            boolean z;
            int i;
            boolean booleanValue = ((Boolean) this.ruD.get(str)).booleanValue();
            if (booleanValue) {
                preference.setWidgetLayoutResource(R.layout.aed);
            } else {
                preference.setWidgetLayoutResource(R.layout.aec);
            }
            fVar.notifyDataSetChanged();
            if (booleanValue) {
                z = false;
            } else {
                z = true;
            }
            this.ruD.put(str, Boolean.valueOf(z));
            this.ruE.put(Integer.valueOf(((Integer) this.ruF.get(str)).intValue()), Boolean.valueOf(z));
            ab.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", str, Integer.valueOf(i), Boolean.valueOf(z));
            for (Boolean booleanValue2 : this.ruD.values()) {
                if (booleanValue2.booleanValue()) {
                    i = 1;
                    break;
                }
            }
            booleanValue = false;
            if (i != 0) {
                enableOptionMenu(0, true);
            } else {
                enableOptionMenu(0, false);
            }
            if (z && str.equals("sns_expose_reason_other")) {
                this.ruI.setVisibility(0);
                this.ruH.setVisibility(0);
                this.ruI.requestFocus();
                this.ruP = true;
                showVKB();
            } else if (((Boolean) this.ruD.get("sns_expose_reason_other")).booleanValue()) {
                this.ruJ.requestFocus();
                aqX();
            } else {
                this.ruI.setVisibility(8);
                this.ruH.setVisibility(8);
                this.ruJ.requestFocus();
                this.ruP = false;
                aqX();
            }
            AppMethodBeat.o(39133);
            return true;
        }
        AppMethodBeat.o(39133);
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(39134);
        ab.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (mVar.getType() == 218) {
            this.ejZ.dismiss();
            this.ejZ = null;
            if (((r) mVar).type == 9) {
                if (i == 0 && i2 == 0) {
                    this.ruO = true;
                    Toast.makeText(this, R.string.ekp, 1).show();
                    finish();
                    AppMethodBeat.o(39134);
                    return;
                }
                this.ruO = false;
                Toast.makeText(this, R.string.eke, 1).show();
            }
        }
        AppMethodBeat.o(39134);
    }

    static /* synthetic */ void b(SnsNotInterestUI snsNotInterestUI) {
        AppMethodBeat.i(39135);
        snsNotInterestUI.ruM = 0;
        for (Integer intValue : snsNotInterestUI.ruE.keySet()) {
            int intValue2 = intValue.intValue();
            if (((Boolean) snsNotInterestUI.ruE.get(Integer.valueOf(intValue2))).booleanValue()) {
                if (snsNotInterestUI.ruM == 0) {
                    snsNotInterestUI.ruM = intValue2;
                } else {
                    snsNotInterestUI.ruM |= intValue2;
                }
            }
        }
        if (!(snsNotInterestUI.ruN == 0 || snsNotInterestUI.ruL == 0)) {
            Context context = snsNotInterestUI.mController.ylL;
            snsNotInterestUI.getString(R.string.tz);
            snsNotInterestUI.ejZ = h.b(context, snsNotInterestUI.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(39126);
                    g.RQ();
                    g.RO().eJo.c(SnsNotInterestUI.this.ruQ);
                    AppMethodBeat.o(39126);
                }
            });
            ab.d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", Long.valueOf(snsNotInterestUI.ruN), Integer.valueOf(snsNotInterestUI.ruL), Integer.valueOf(snsNotInterestUI.ruM), Boolean.valueOf(snsNotInterestUI.ruP));
            snsNotInterestUI.ruQ = new r(snsNotInterestUI.ruN, snsNotInterestUI.ruL, snsNotInterestUI.ruM, snsNotInterestUI.ruP ? snsNotInterestUI.ruI.getText().toString() : null);
            g.RQ();
            g.RO().eJo.a(snsNotInterestUI.ruQ, 0);
        }
        AppMethodBeat.o(39135);
    }
}

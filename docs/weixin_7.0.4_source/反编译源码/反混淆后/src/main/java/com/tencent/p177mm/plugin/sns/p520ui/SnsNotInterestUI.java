package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6485gm;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotInterestUI */
public class SnsNotInterestUI extends MMPreference implements C1202f {
    private static final String[] ruB = new String[]{"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] ruC = new int[]{1, 2, 4, 8, 16, 32, 64};
    private static final int[] ruG = new int[]{C25738R.string.ekh, C25738R.string.ekm, C25738R.string.ekn, C25738R.string.ekg, C25738R.string.ekf, C25738R.string.ekk, C25738R.string.eki};
    private C44275p ejZ = null;
    private C15541f iFE;
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
    C46224r ruQ = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotInterestUI$4 */
    class C71264 implements OnCancelListener {
        C71264() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(39126);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c(SnsNotInterestUI.this.ruQ);
            AppMethodBeat.m2505o(39126);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotInterestUI$1 */
    class C71271 implements OnMenuItemClickListener {
        C71271() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39123);
            SnsNotInterestUI.this.finish();
            AppMethodBeat.m2505o(39123);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotInterestUI$2 */
    class C71282 implements OnClickListener {
        C71282() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39124);
            SnsNotInterestUI.this.ruK.requestFocus();
            SnsNotInterestUI.this.aqX();
            AppMethodBeat.m2505o(39124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsNotInterestUI$3 */
    class C71293 implements OnMenuItemClickListener {
        C71293() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39125);
            SnsNotInterestUI.m11937b(SnsNotInterestUI.this);
            AppMethodBeat.m2505o(39125);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsNotInterestUI() {
        AppMethodBeat.m2504i(39127);
        AppMethodBeat.m2505o(39127);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39128);
        super.onCreate(bundle);
        this.ruL = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.ruN = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (this.ruN != 0) {
            String str = C13373af.cnF().mo62941kD(this.ruN).field_userName;
            if (str != null) {
                C1720g.m3537RQ();
                C7616ad aoN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(str);
                if (aoN.dtS == 2) {
                    ruG[1] = C25738R.string.ekl;
                } else if (aoN.dtS == 1) {
                    ruG[1] = C25738R.string.ekm;
                }
            }
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(218, (C1202f) this);
        ctF();
        initView();
        AppMethodBeat.m2505o(39128);
    }

    private void ctF() {
        int i = 0;
        AppMethodBeat.m2504i(39129);
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
        AppMethodBeat.m2505o(39129);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39130);
        super.onDestroy();
        ctF();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(218, (C1202f) this);
        C6485gm c6485gm = new C6485gm();
        c6485gm.cBf.cBg = this.ruO;
        c6485gm.cBf.cBh = this.ruN;
        C4879a.xxA.mo10055m(c6485gm);
        AppMethodBeat.m2505o(39130);
    }

    public final void initView() {
        AppMethodBeat.m2504i(39131);
        super.initView();
        setMMTitle((int) C25738R.string.ekq);
        setBackBtn(new C71271());
        this.ruH = (TextView) findViewById(2131827742);
        this.ruI = (EditText) findViewById(2131827743);
        this.ruJ = (ListView) findViewById(16908298);
        this.ruK = (LinearLayout) findViewById(2131827741);
        this.ruK.setOnClickListener(new C71282());
        this.ruI.setVisibility(8);
        this.ruH.setVisibility(8);
        this.iFE = this.yCw;
        ctG();
        mo17379a(0, getString(C25738R.string.a9m), (OnMenuItemClickListener) new C71293(), C5535b.GREEN);
        enableOptionMenu(0, false);
        AppMethodBeat.m2505o(39131);
    }

    private void ctG() {
        AppMethodBeat.m2504i(39132);
        if (this.iFE == null) {
            C4990ab.m7412e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
            AppMethodBeat.m2505o(39132);
            return;
        }
        if (this.iFE.aqO("sns_expose_desc") == null) {
            PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
            preferenceTitleCategory.setTitle((int) C25738R.string.ekd);
            preferenceTitleCategory.setKey("sns_expose_desc");
            this.iFE.mo27713b(preferenceTitleCategory);
        }
        for (int i = 0; i < ruB.length; i++) {
            String str = ruB[i];
            int i2 = ruG[i];
            if (this.iFE.aqO(str) == null) {
                Preference preference = new Preference(this);
                preference.setTitle(i2);
                preference.setKey(str);
                preference.setLayoutResource(2130970127);
                preference.setWidgetLayoutResource(2130970137);
                this.iFE.mo27713b(preference);
            }
        }
        AppMethodBeat.m2505o(39132);
    }

    public final int getLayoutId() {
        return 2130970758;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(39133);
        if (preference == null) {
            AppMethodBeat.m2505o(39133);
            return false;
        }
        String str = preference.mKey;
        if (this.ruD.containsKey(str)) {
            boolean z;
            int i;
            boolean booleanValue = ((Boolean) this.ruD.get(str)).booleanValue();
            if (booleanValue) {
                preference.setWidgetLayoutResource(2130970137);
            } else {
                preference.setWidgetLayoutResource(2130970136);
            }
            c15541f.notifyDataSetChanged();
            if (booleanValue) {
                z = false;
            } else {
                z = true;
            }
            this.ruD.put(str, Boolean.valueOf(z));
            this.ruE.put(Integer.valueOf(((Integer) this.ruF.get(str)).intValue()), Boolean.valueOf(z));
            C4990ab.m7411d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", str, Integer.valueOf(i), Boolean.valueOf(z));
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
            AppMethodBeat.m2505o(39133);
            return true;
        }
        AppMethodBeat.m2505o(39133);
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39134);
        C4990ab.m7411d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (c1207m.getType() == 218) {
            this.ejZ.dismiss();
            this.ejZ = null;
            if (((C46224r) c1207m).type == 9) {
                if (i == 0 && i2 == 0) {
                    this.ruO = true;
                    Toast.makeText(this, C25738R.string.ekp, 1).show();
                    finish();
                    AppMethodBeat.m2505o(39134);
                    return;
                }
                this.ruO = false;
                Toast.makeText(this, C25738R.string.eke, 1).show();
            }
        }
        AppMethodBeat.m2505o(39134);
    }

    /* renamed from: b */
    static /* synthetic */ void m11937b(SnsNotInterestUI snsNotInterestUI) {
        AppMethodBeat.m2504i(39135);
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
            snsNotInterestUI.getString(C25738R.string.f9238tz);
            snsNotInterestUI.ejZ = C30379h.m48458b(context, snsNotInterestUI.getString(C25738R.string.f9260un), true, new C71264());
            C4990ab.m7411d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", Long.valueOf(snsNotInterestUI.ruN), Integer.valueOf(snsNotInterestUI.ruL), Integer.valueOf(snsNotInterestUI.ruM), Boolean.valueOf(snsNotInterestUI.ruP));
            snsNotInterestUI.ruQ = new C46224r(snsNotInterestUI.ruN, snsNotInterestUI.ruL, snsNotInterestUI.ruM, snsNotInterestUI.ruP ? snsNotInterestUI.ruI.getText().toString() : null);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(snsNotInterestUI.ruQ, 0);
        }
        AppMethodBeat.m2505o(39135);
    }
}

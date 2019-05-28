package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p230g.p231a.C18379qt;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5510e.C5504k;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5620a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SightUploadUI */
public class SightUploadUI extends MMActivity {
    private String desc = "";
    DisplayMetrics pFD;
    private String rmH = "";
    private String rmI = "";
    private SnsEditText rnb;
    private C22150y rnc = null;
    private LinearLayout rnd;
    private SnsSightUploadSayFooter rne;
    private int rnf = 0;
    private int rng = 0;
    private ArrayList<String> rnh;
    private boolean rni = false;
    private int rnj = 0;
    private boolean rnk = false;
    private long rnl = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SightUploadUI$2 */
    class C78282 implements C5620a {
        C78282() {
        }

        public final void bMu() {
            AppMethodBeat.m2504i(38584);
            SightUploadUI.this.aqX();
            C18379qt c18379qt = new C18379qt();
            c18379qt.cMT.type = 0;
            c18379qt.cMT.cMV = false;
            C4879a.xxA.mo10055m(c18379qt);
            SightUploadUI.this.finish();
            AppMethodBeat.m2505o(38584);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SightUploadUI$4 */
    class C78294 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SightUploadUI$4$1 */
        class C78301 implements C30391c {
            C78301() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(38586);
                switch (i) {
                    case 0:
                        C18379qt c18379qt = new C18379qt();
                        c18379qt.cMT.type = 0;
                        c18379qt.cMT.cMX = true;
                        c18379qt.cMT.cMV = true;
                        C4879a.xxA.mo10055m(c18379qt);
                        SightUploadUI.this.aqX();
                        SightUploadUI.this.finish();
                        break;
                }
                AppMethodBeat.m2505o(38586);
            }
        }

        C78294() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38587);
            C30379h.m48422a(SightUploadUI.this.mController.ylL, null, new String[]{SightUploadUI.this.getString(C25738R.string.eif)}, null, new C78301());
            AppMethodBeat.m2505o(38587);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SightUploadUI$5 */
    class C78315 implements OnMenuItemClickListener {
        C78315() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38590);
            if (SightUploadUI.this.isFinishing()) {
                AppMethodBeat.m2505o(38590);
            } else {
                SightUploadUI.this.desc = SightUploadUI.this.rnb.getText().toString();
                final int pasterLen = SightUploadUI.this.rnb.getPasterLen();
                C7357c PM = C7357c.m12555d(SightUploadUI.this.rnb).mo15877PM(C42164b.m74335MW());
                PM.zIx = true;
                PM.mo15879a(new C5581a() {
                    /* renamed from: ki */
                    public final void mo11317ki(String str) {
                        AppMethodBeat.m2504i(38588);
                        PInt pInt = new PInt();
                        SightUploadUI.this.rnc.mo8912a(SightUploadUI.this.rnj, 0, null, SightUploadUI.this.desc, null, SightUploadUI.this.rne.getLocation(), pasterLen, SightUploadUI.this.rni, SightUploadUI.this.rnh, pInt, "", SightUploadUI.this.rnf, SightUploadUI.this.rng);
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[4];
                        objArr[0] = Long.valueOf(SightUploadUI.this.rnl);
                        objArr[1] = Long.valueOf(C5046bo.anT());
                        objArr[2] = Integer.valueOf(SightUploadUI.this.rnk ? 0 : 1);
                        objArr[3] = Integer.valueOf(pInt.value);
                        c7060h.mo8381e(13303, objArr);
                        String str2 = "MicroMsg.SightUploadUI";
                        String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                        objArr = new Object[4];
                        objArr[0] = Long.valueOf(SightUploadUI.this.rnl);
                        objArr[1] = Long.valueOf(C5046bo.anT());
                        objArr[2] = Integer.valueOf(SightUploadUI.this.rnk ? 0 : 1);
                        objArr[3] = Integer.valueOf(pInt.value);
                        C4990ab.m7411d(str2, str3, objArr);
                        AppMethodBeat.m2505o(38588);
                    }

                    /* renamed from: JW */
                    public final void mo11315JW() {
                    }

                    /* renamed from: JX */
                    public final void mo11316JX() {
                        AppMethodBeat.m2504i(38589);
                        C30379h.m48467g(SightUploadUI.this, C25738R.string.eqg, C25738R.string.eqh);
                        AppMethodBeat.m2505o(38589);
                    }
                });
                AppMethodBeat.m2505o(38590);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SightUploadUI$3 */
    class C78333 implements OnMenuItemClickListener {
        C78333() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38585);
            C18379qt c18379qt = new C18379qt();
            c18379qt.cMT.type = 0;
            c18379qt.cMT.cMV = false;
            C4879a.xxA.mo10055m(c18379qt);
            SightUploadUI.this.aqX();
            SightUploadUI.this.finish();
            AppMethodBeat.m2505o(38585);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38591);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        this.pFD = getResources().getDisplayMetrics();
        this.rnc = new C39827ak(this);
        this.rnc.mo8910M(bundle);
        this.rnd = (LinearLayout) findViewById(2131827848);
        this.rnd.addView(this.rnc.crH());
        setMMTitle((int) C25738R.string.eq0);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(C25738R.color.f11782h4));
        this.rnk = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rnl = getIntent().getLongExtra("KTouchCameraTime", 0);
        initView();
        C30036f.m47545n(this);
        AppMethodBeat.m2505o(38591);
    }

    public final int getLayoutId() {
        return 2130970799;
    }

    public final void initView() {
        AppMethodBeat.m2504i(38592);
        this.rnb = (SnsEditText) findViewById(2131825373);
        final int paddingLeft = this.pFD.widthPixels - (this.rnb.getPaddingLeft() + this.rnd.getPaddingRight());
        this.rnb.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(38583);
                SightUploadUI.this.rnb.setWidth((int) (((double) paddingLeft) * 0.7d));
                SightUploadUI.this.rnd.setLayoutParams(new LayoutParams((int) (((double) paddingLeft) * 0.3d), SightUploadUI.this.rnd.getHeight()));
                AppMethodBeat.m2505o(38583);
            }
        }, 100);
        if (!C5046bo.isNullOrNil(getIntent().getStringExtra(C5504k.ygd))) {
            this.rnb.setText(getIntent().getStringExtra(C5504k.ygd));
        }
        this.rnb.setBackListener(new C78282());
        this.rne = (SnsSightUploadSayFooter) findViewById(2131827849);
        this.rne.setMMEditText(this.rnb);
        this.rne.setVisibility(0);
        setBackBtn(new C78333());
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            addIconOptionMenu(1, C1318a.sight_draft_menu, new C78294());
        }
        mo17379a(0, getString(C25738R.string.f9221tf), (OnMenuItemClickListener) new C78315(), C5535b.BLACK);
        enableOptionMenu(true);
        AppMethodBeat.m2505o(38592);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38593);
        super.onResume();
        C4990ab.m7410d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rne;
        if (snsSightUploadSayFooter.eAk.getVisibility() == 8) {
            snsSightUploadSayFooter.crP.showVKB();
        }
        AppMethodBeat.m2505o(38593);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38594);
        super.onDestroy();
        this.rnc.crI();
        this.rne.rwZ.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rne;
        if (snsSightUploadSayFooter.eAk != null) {
            snsSightUploadSayFooter.eAk.mo11686AC();
            snsSightUploadSayFooter.eAk.destroy();
        }
        AppMethodBeat.m2505o(38594);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38595);
        super.onPause();
        aqX();
        AppMethodBeat.m2505o(38595);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(38596);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(38596);
            return;
        }
        if (i == 6 || i == 5 || i == 10) {
            SnsSightUploadSayFooter snsSightUploadSayFooter = this.rne;
            if (intent != null) {
                if (i == 10) {
                    snsSightUploadSayFooter.rwZ.mo8732ao(intent);
                } else if (i == 5) {
                    snsSightUploadSayFooter.rwY.mo62963a(i, i2, intent, null);
                }
            }
        }
        if (i == 5) {
            if (intent == null) {
                AppMethodBeat.m2505o(38596);
                return;
            }
            int intExtra = intent.getIntExtra("Ktag_range_index", 0);
            if (intExtra >= 2) {
                Iterator it;
                this.rmH = intent.getStringExtra("Klabel_name_list");
                this.rmI = intent.getStringExtra("Kother_user_name_list");
                List<String> asList = Arrays.asList(this.rmH.split(","));
                List list;
                if (C5046bo.isNullOrNil(this.rmI)) {
                    list = null;
                } else {
                    list = Arrays.asList(this.rmI.split(","));
                }
                this.rnh = new ArrayList();
                if (asList != null && asList.size() > 0) {
                    for (String PE : asList) {
                        List<String> PH = C21156a.bJa().mo41635PH(C21156a.bJa().mo41632PE(PE));
                        if (PH == null || PH.size() == 0) {
                            C4990ab.m7412e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                            break;
                        }
                        for (String PE2 : PH) {
                            if (!this.rnh.contains(PE2)) {
                                this.rnh.add(PE2);
                                C4990ab.m7411d("MicroMsg.SightUploadUI", "dz:name : %s", PE2);
                            }
                        }
                    }
                }
                if (asList != null) {
                    int i3;
                    int i4 = 0;
                    it = asList.iterator();
                    while (true) {
                        i3 = i4;
                        if (!it.hasNext()) {
                            break;
                        } else if (C5046bo.isNullOrNil((String) it.next())) {
                            i4 = i3;
                        } else {
                            i4 = i3 + 1;
                        }
                    }
                    this.rnf = i3;
                }
                this.rng = 0;
                if (list != null && list.size() > 0) {
                    for (String PE22 : list) {
                        if (!this.rnh.contains(PE22)) {
                            this.rnh.add(PE22);
                            this.rng++;
                        }
                    }
                }
                if (intExtra == 2) {
                    this.rni = false;
                } else {
                    this.rni = true;
                }
            }
            if (1 == intExtra) {
                this.rnj = 1;
                AppMethodBeat.m2505o(38596);
                return;
            }
            this.rnj = 0;
        }
        AppMethodBeat.m2505o(38596);
    }
}

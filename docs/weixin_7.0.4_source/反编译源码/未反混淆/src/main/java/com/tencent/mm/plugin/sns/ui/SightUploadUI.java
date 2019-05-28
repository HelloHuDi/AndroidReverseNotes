package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.m.b;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SightUploadUI extends MMActivity {
    private String desc = "";
    DisplayMetrics pFD;
    private String rmH = "";
    private String rmI = "";
    private SnsEditText rnb;
    private y rnc = null;
    private LinearLayout rnd;
    private SnsSightUploadSayFooter rne;
    private int rnf = 0;
    private int rng = 0;
    private ArrayList<String> rnh;
    private boolean rni = false;
    private int rnj = 0;
    private boolean rnk = false;
    private long rnl = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38591);
        f.m(this);
        super.onCreate(bundle);
        this.pFD = getResources().getDisplayMetrics();
        this.rnc = new ak(this);
        this.rnc.M(bundle);
        this.rnd = (LinearLayout) findViewById(R.id.elf);
        this.rnd.addView(this.rnc.crH());
        setMMTitle((int) R.string.eq0);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.h4));
        this.rnk = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rnl = getIntent().getLongExtra("KTouchCameraTime", 0);
        initView();
        f.n(this);
        AppMethodBeat.o(38591);
    }

    public final int getLayoutId() {
        return R.layout.aw_;
    }

    public final void initView() {
        AppMethodBeat.i(38592);
        this.rnb = (SnsEditText) findViewById(R.id.csj);
        final int paddingLeft = this.pFD.widthPixels - (this.rnb.getPaddingLeft() + this.rnd.getPaddingRight());
        this.rnb.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38583);
                SightUploadUI.this.rnb.setWidth((int) (((double) paddingLeft) * 0.7d));
                SightUploadUI.this.rnd.setLayoutParams(new LayoutParams((int) (((double) paddingLeft) * 0.3d), SightUploadUI.this.rnd.getHeight()));
                AppMethodBeat.o(38583);
            }
        }, 100);
        if (!bo.isNullOrNil(getIntent().getStringExtra(k.ygd))) {
            this.rnb.setText(getIntent().getStringExtra(k.ygd));
        }
        this.rnb.setBackListener(new a() {
            public final void bMu() {
                AppMethodBeat.i(38584);
                SightUploadUI.this.aqX();
                qt qtVar = new qt();
                qtVar.cMT.type = 0;
                qtVar.cMT.cMV = false;
                com.tencent.mm.sdk.b.a.xxA.m(qtVar);
                SightUploadUI.this.finish();
                AppMethodBeat.o(38584);
            }
        });
        this.rne = (SnsSightUploadSayFooter) findViewById(R.id.elg);
        this.rne.setMMEditText(this.rnb);
        this.rne.setVisibility(0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38585);
                qt qtVar = new qt();
                qtVar.cMT.type = 0;
                qtVar.cMT.cMV = false;
                com.tencent.mm.sdk.b.a.xxA.m(qtVar);
                SightUploadUI.this.aqX();
                SightUploadUI.this.finish();
                AppMethodBeat.o(38585);
                return true;
            }
        });
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            addIconOptionMenu(1, R.raw.sight_draft_menu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(38587);
                    h.a(SightUploadUI.this.mController.ylL, null, new String[]{SightUploadUI.this.getString(R.string.eif)}, null, new c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(38586);
                            switch (i) {
                                case 0:
                                    qt qtVar = new qt();
                                    qtVar.cMT.type = 0;
                                    qtVar.cMT.cMX = true;
                                    qtVar.cMT.cMV = true;
                                    com.tencent.mm.sdk.b.a.xxA.m(qtVar);
                                    SightUploadUI.this.aqX();
                                    SightUploadUI.this.finish();
                                    break;
                            }
                            AppMethodBeat.o(38586);
                        }
                    });
                    AppMethodBeat.o(38587);
                    return false;
                }
            });
        }
        a(0, getString(R.string.tf), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38590);
                if (SightUploadUI.this.isFinishing()) {
                    AppMethodBeat.o(38590);
                } else {
                    SightUploadUI.this.desc = SightUploadUI.this.rnb.getText().toString();
                    final int pasterLen = SightUploadUI.this.rnb.getPasterLen();
                    com.tencent.mm.ui.tools.b.c PM = com.tencent.mm.ui.tools.b.c.d(SightUploadUI.this.rnb).PM(b.MW());
                    PM.zIx = true;
                    PM.a(new com.tencent.mm.ui.tools.b.c.a() {
                        public final void ki(String str) {
                            AppMethodBeat.i(38588);
                            PInt pInt = new PInt();
                            SightUploadUI.this.rnc.a(SightUploadUI.this.rnj, 0, null, SightUploadUI.this.desc, null, SightUploadUI.this.rne.getLocation(), pasterLen, SightUploadUI.this.rni, SightUploadUI.this.rnh, pInt, "", SightUploadUI.this.rnf, SightUploadUI.this.rng);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = Long.valueOf(SightUploadUI.this.rnl);
                            objArr[1] = Long.valueOf(bo.anT());
                            objArr[2] = Integer.valueOf(SightUploadUI.this.rnk ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            hVar.e(13303, objArr);
                            String str2 = "MicroMsg.SightUploadUI";
                            String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                            objArr = new Object[4];
                            objArr[0] = Long.valueOf(SightUploadUI.this.rnl);
                            objArr[1] = Long.valueOf(bo.anT());
                            objArr[2] = Integer.valueOf(SightUploadUI.this.rnk ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            ab.d(str2, str3, objArr);
                            AppMethodBeat.o(38588);
                        }

                        public final void JW() {
                        }

                        public final void JX() {
                            AppMethodBeat.i(38589);
                            h.g(SightUploadUI.this, R.string.eqg, R.string.eqh);
                            AppMethodBeat.o(38589);
                        }
                    });
                    AppMethodBeat.o(38590);
                }
                return false;
            }
        }, q.b.BLACK);
        enableOptionMenu(true);
        AppMethodBeat.o(38592);
    }

    public void onResume() {
        AppMethodBeat.i(38593);
        super.onResume();
        ab.d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rne;
        if (snsSightUploadSayFooter.eAk.getVisibility() == 8) {
            snsSightUploadSayFooter.crP.showVKB();
        }
        AppMethodBeat.o(38593);
    }

    public void onDestroy() {
        AppMethodBeat.i(38594);
        super.onDestroy();
        this.rnc.crI();
        this.rne.rwZ.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rne;
        if (snsSightUploadSayFooter.eAk != null) {
            snsSightUploadSayFooter.eAk.AC();
            snsSightUploadSayFooter.eAk.destroy();
        }
        AppMethodBeat.o(38594);
    }

    public void onPause() {
        AppMethodBeat.i(38595);
        super.onPause();
        aqX();
        AppMethodBeat.o(38595);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(38596);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(38596);
            return;
        }
        if (i == 6 || i == 5 || i == 10) {
            SnsSightUploadSayFooter snsSightUploadSayFooter = this.rne;
            if (intent != null) {
                if (i == 10) {
                    snsSightUploadSayFooter.rwZ.ao(intent);
                } else if (i == 5) {
                    snsSightUploadSayFooter.rwY.a(i, i2, intent, null);
                }
            }
        }
        if (i == 5) {
            if (intent == null) {
                AppMethodBeat.o(38596);
                return;
            }
            int intExtra = intent.getIntExtra("Ktag_range_index", 0);
            if (intExtra >= 2) {
                Iterator it;
                this.rmH = intent.getStringExtra("Klabel_name_list");
                this.rmI = intent.getStringExtra("Kother_user_name_list");
                List<String> asList = Arrays.asList(this.rmH.split(","));
                List list;
                if (bo.isNullOrNil(this.rmI)) {
                    list = null;
                } else {
                    list = Arrays.asList(this.rmI.split(","));
                }
                this.rnh = new ArrayList();
                if (asList != null && asList.size() > 0) {
                    for (String PE : asList) {
                        List<String> PH = com.tencent.mm.plugin.label.a.a.bJa().PH(com.tencent.mm.plugin.label.a.a.bJa().PE(PE));
                        if (PH == null || PH.size() == 0) {
                            ab.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                            break;
                        }
                        for (String PE2 : PH) {
                            if (!this.rnh.contains(PE2)) {
                                this.rnh.add(PE2);
                                ab.d("MicroMsg.SightUploadUI", "dz:name : %s", PE2);
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
                        } else if (bo.isNullOrNil((String) it.next())) {
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
                AppMethodBeat.o(38596);
                return;
            }
            this.rnj = 0;
        }
        AppMethodBeat.o(38596);
    }
}

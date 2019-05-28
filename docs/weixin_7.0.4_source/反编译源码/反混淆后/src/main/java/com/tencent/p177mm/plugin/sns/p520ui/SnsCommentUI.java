package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p516g.C39736h;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(17)
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentUI */
public class SnsCommentUI extends MMActivity implements C1202f {
    private int cNE;
    private int czs;
    private SnsEditText rrH;
    private int rrI = 0;
    private boolean rrJ = false;
    private boolean rrK = false;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentUI$4 */
    class C78824 implements TextWatcher {
        C78824() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(38919);
            if (SnsCommentUI.this.rrH.getText().toString().trim().length() > 0) {
                SnsCommentUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(38919);
                return;
            }
            SnsCommentUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(38919);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentUI$2 */
    class C78832 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentUI$2$1 */
        class C78841 implements C5581a {
            C78841() {
            }

            /* renamed from: ki */
            public final void mo11317ki(String str) {
                AppMethodBeat.m2504i(38915);
                String trim = SnsCommentUI.this.rrH.getText().toString().trim();
                SnsCommentUI.this.rrH.setText("");
                if (trim.length() > 0) {
                    switch (SnsCommentUI.this.rrI) {
                        case 0:
                            SnsCommentUI.this.aqX();
                            SnsCommentUI.m13996a(SnsCommentUI.this, trim);
                            AppMethodBeat.m2505o(38915);
                            return;
                        case 1:
                            SnsCommentUI.this.aqX();
                            SnsCommentUI.m13998b(SnsCommentUI.this, trim);
                            AppMethodBeat.m2505o(38915);
                            return;
                        case 2:
                            SnsCommentUI.this.aqX();
                            long longExtra = SnsCommentUI.this.getIntent().getLongExtra("sns_id", 0);
                            long longExtra2 = SnsCommentUI.this.getIntent().getLongExtra("action_st_time", 0);
                            String bc = C5046bo.m7532bc(SnsCommentUI.this.getIntent().getStringExtra("sns_uxinfo"), "");
                            trim = C5046bo.m7532bc(SnsCommentUI.this.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                            long currentTimeMillis = System.currentTimeMillis();
                            C39736h coB = C13373af.cnx().coB();
                            if (coB != null && coB.coC()) {
                                String str2 = coB.qPn;
                                String str3 = coB.qPm;
                                C4990ab.m7410d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + bc + " actionresult: " + trim + " " + longExtra2 + " " + currentTimeMillis);
                                C7060h.pYm.mo8381e(11988, str2, str3, "", "", C29036i.m46117jV(longExtra), bc, trim, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
                                SnsCommentUI.this.rrK = true;
                                SnsCommentUI.this.finish();
                                break;
                            }
                            AppMethodBeat.m2505o(38915);
                            return;
                            break;
                    }
                }
                AppMethodBeat.m2505o(38915);
            }

            /* renamed from: JW */
            public final void mo11315JW() {
            }

            /* renamed from: JX */
            public final void mo11316JX() {
                AppMethodBeat.m2504i(38916);
                C30379h.m48467g(SnsCommentUI.this, C25738R.string.eqg, C25738R.string.eqh);
                AppMethodBeat.m2505o(38916);
            }
        }

        C78832() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            int i;
            AppMethodBeat.m2504i(38917);
            if (SnsCommentUI.this.rrI == 0) {
                C42164b.m74336MX();
            }
            if (SnsCommentUI.this.rrI == 2) {
                i = 200;
            } else {
                i = C42164b.m74335MW();
            }
            C7357c PM = C7357c.m12555d(SnsCommentUI.this.rrH).mo15877PM(i);
            PM.zIx = true;
            PM.mo15879a(new C78841());
            AppMethodBeat.m2505o(38917);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentUI$1 */
    class C78851 implements OnCancelListener {
        C78851() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentUI$3 */
    class C78863 implements OnMenuItemClickListener {
        C78863() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38918);
            SnsCommentUI.this.aqX();
            SnsCommentUI.this.finish();
            AppMethodBeat.m2505o(38918);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38920);
        super.onCreate(bundle);
        this.cNE = getIntent().getIntExtra("sns_comment_localId", 0);
        this.rrI = getIntent().getIntExtra("sns_comment_type", 0);
        this.czs = getIntent().getIntExtra("sns_source", 0);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(213, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(38920);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38921);
        super.onPause();
        if (this.rrH != null) {
            Object trim = this.rrH.getText().toString().trim();
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(68408, trim);
            if (C5046bo.isNullOrNil(trim)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(7489, Integer.valueOf(0));
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(7489, Integer.valueOf(this.rrH.getPasterLen()));
                AppMethodBeat.m2505o(38921);
                return;
            }
        }
        AppMethodBeat.m2505o(38921);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38922);
        super.onResume();
        showVKB();
        AppMethodBeat.m2505o(38922);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38923);
        super.onDestroy();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(213, (C1202f) this);
        AppMethodBeat.m2505o(38923);
    }

    public final void initView() {
        AppMethodBeat.m2504i(38924);
        this.rrH = (SnsEditText) findViewById(2131821019);
        mo17379a(0, getString(C25738R.string.f9221tf), (OnMenuItemClickListener) new C78832(), C5535b.GREEN);
        if (this.rrI == 0) {
            setMMTitle((int) C25738R.string.ek3);
        } else if (this.rrI == 1) {
            setMMTitle((int) C25738R.string.eqp);
            C1720g.m3537RQ();
            String bc = C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(68408, (Object) ""), "");
            C1720g.m3537RQ();
            this.rrH.setPasterLen(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(7489, Integer.valueOf(0)), 0));
            this.rrH.append(C5046bo.m7532bc(bc, ""));
            if (bc == null || bc.length() <= 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        } else if (this.rrI == 2) {
            setMMTitle((int) C25738R.string.eit);
            enableOptionMenu(false);
        }
        setBackBtn(new C78863());
        this.rrH.addTextChangedListener(new C78824());
        AppMethodBeat.m2505o(38924);
    }

    public final int getLayoutId() {
        return 2130970756;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(38925);
        C4990ab.m7416i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType() + " @" + hashCode());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (c1207m.getType()) {
            case 213:
                if (this.rrJ) {
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(38925);
    }

    public void finish() {
        AppMethodBeat.m2504i(38926);
        super.finish();
        if (!this.rrK && this.rrI == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String bc = C5046bo.m7532bc(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = C5046bo.m7532bc(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            C39736h coB = C13373af.cnx().coB();
            if (coB == null || !coB.coC()) {
                AppMethodBeat.m2505o(38926);
                return;
            }
            String str2 = coB.qPn;
            String str3 = coB.qPm;
            C4990ab.m7410d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + bc + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
            C7060h.pYm.mo8381e(11988, str2, str3, "", "", C29036i.m46117jV(longExtra), bc, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
        }
        AppMethodBeat.m2505o(38926);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(38927);
        if (i == 4) {
            aqX();
            finish();
            AppMethodBeat.m2505o(38927);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(38927);
        return onKeyDown;
    }

    /* renamed from: a */
    static /* synthetic */ void m13996a(SnsCommentUI snsCommentUI, String str) {
        AppMethodBeat.m2504i(38928);
        C46236n DK = C13373af.cnF().mo62914DK(snsCommentUI.cNE);
        if (DK != null) {
            snsCommentUI.rrJ = true;
            if (DK.cqT()) {
                C3890a.m6184a(DK, 2, str, "", snsCommentUI.czs);
            } else {
                C3890a.m6186a(DK.field_userName, 3, str, DK, snsCommentUI.czs);
            }
            snsCommentUI.aqX();
            snsCommentUI.getString(C25738R.string.f9238tz);
            snsCommentUI.tipDialog = C30379h.m48458b((Context) snsCommentUI, snsCommentUI.getString(C25738R.string.f9222th), true, new C78851());
        }
        AppMethodBeat.m2505o(38928);
    }

    /* renamed from: b */
    static /* synthetic */ void m13998b(SnsCommentUI snsCommentUI, String str) {
        AppMethodBeat.m2504i(38929);
        if (!snsCommentUI.isFinishing()) {
            C1853r.m3846Yz();
            C29054ax c29054ax = new C29054ax(2);
            c29054ax.mo47144Ym(str);
            if (snsCommentUI.rrH.getPasterLen() > C24826a.qFE) {
                c29054ax.mo47138Dd(2);
            }
            c29054ax.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
        AppMethodBeat.m2505o(38929);
    }
}

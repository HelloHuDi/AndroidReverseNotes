package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18211ag;
import com.tencent.p177mm.p230g.p231a.C32647tt;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.account.bind.p1217a.C18798d;
import com.tencent.p177mm.plugin.account.friend.p272a.C26585an;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ */
public class StartUnbindQQ extends MMWizardActivity implements C1202f {
    private String grq = null;
    private View guo;
    private C5653c gup;
    private C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ$3 */
    class C19783 implements OnClickListener {
        C19783() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13764);
            StartUnbindQQ.m53875b(StartUnbindQQ.this);
            AppMethodBeat.m2505o(13764);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ$1 */
    class C329501 implements OnMenuItemClickListener {
        C329501() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13761);
            StartUnbindQQ.this.finish();
            AppMethodBeat.m2505o(13761);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ$2 */
    class C329512 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ$2$1 */
        class C98671 implements OnClickListener {
            C98671() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13762);
                C1720g.m3540Rg().mo14541a(new C18798d(""), 0);
                StartUnbindQQ startUnbindQQ = StartUnbindQQ.this;
                Context context = StartUnbindQQ.this;
                StartUnbindQQ.this.getString(C25738R.string.f9238tz);
                startUnbindQQ.tipDialog = C30379h.m48458b(context, StartUnbindQQ.this.getString(C25738R.string.e4v), true, null);
                AppMethodBeat.m2505o(13762);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ$2$2 */
        class C188122 implements OnClickListener {
            C188122() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C329512() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13763);
            if (StartUnbindQQ.this.gup == null) {
                StartUnbindQQ.this.gup = C30379h.m48440a(StartUnbindQQ.this, StartUnbindQQ.this.getString(C25738R.string.e4u), null, new C98671(), new C188122());
                AppMethodBeat.m2505o(13763);
                return;
            }
            StartUnbindQQ.this.gup.show();
            AppMethodBeat.m2505o(13763);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13765);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_OKINAWA, (C1202f) this);
        this.grq = getIntent().getStringExtra("notice");
        AppMethodBeat.m2505o(13765);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13766);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_OKINAWA, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(13766);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13767);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(13767);
    }

    public final int getLayoutId() {
        return 2130970845;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13768);
        setMMTitle((int) C25738R.string.ey9);
        this.guo = findViewById(2131827984);
        setBackBtn(new C329501());
        this.guo.setOnClickListener(new C329512());
        AppMethodBeat.m2505o(13768);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13769);
        C4990ab.m7410d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
        if (c1207m.getType() == C31128d.MIC_PTU_ZIPAI_OKINAWA) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0) {
                int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(9, null), 0);
                C4990ab.m7410d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(a)));
                if (a != 0) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().delete(new C1183p(a) + "@qqim");
                }
                Object obj = C1720g.m3536RP().mo5239Ry().get(102407, null);
                if (obj != null && ((String) obj).length() > 0) {
                    C1720g.m3536RP().mo5239Ry().set(102407, null);
                }
                try {
                    C4879a.xxA.mo10055m(new C18211ag());
                    String str2 = new C1183p(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(9, null), 0)) + "@qqim";
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().delete(str2);
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoU(str2);
                    C17884o.act().mo33393qp(str2);
                    String str3 = C1853r.m3846Yz() + "@qqim";
                    C17884o.act().mo33393qp(str3);
                    C17884o.acd();
                    C41732d.m73516E(str2, false);
                    C17884o.acd();
                    C41732d.m73516E(str2, true);
                    C17884o.acd();
                    C41732d.m73516E(str3, false);
                    C17884o.acd();
                    C41732d.m73516E(str3, true);
                    C26585an c26585an = (C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg();
                    C4990ab.m7410d("MicroMsg.QQGroupStorage", "delete all");
                    if (c26585an.fni.delete("qqgroup", null, null) > 0) {
                        c26585an.doNotify();
                    }
                    C24679a.gkF.mo38844BS();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                    C4990ab.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                }
                C1720g.m3536RP().mo5239Ry().set(9, Integer.valueOf(0));
                C32647tt c32647tt = new C32647tt();
                c32647tt.cPS.cPT = false;
                c32647tt.cPS.cPU = true;
                C4879a.xxA.mo10055m(c32647tt);
                if (C5046bo.isNullOrNil(this.grq)) {
                    mo27541Ni(1);
                } else {
                    C30379h.m48443a((Context) this, this.grq, "", getString(C25738R.string.f9151r4), new C19783());
                }
            }
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(this, null, null);
                AppMethodBeat.m2505o(13769);
                return;
            }
        }
        AppMethodBeat.m2505o(13769);
    }

    /* renamed from: b */
    static /* synthetic */ void m53875b(StartUnbindQQ startUnbindQQ) {
        AppMethodBeat.m2504i(13770);
        startUnbindQQ.mo27541Ni(1);
        AppMethodBeat.m2505o(13770);
    }
}

package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C42280aa;
import com.tencent.p177mm.plugin.account.friend.p272a.C45499p;
import com.tencent.p177mm.plugin.account.friend.p272a.C9880q;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.aco;
import com.tencent.p177mm.protocal.protobuf.auv;
import com.tencent.p177mm.protocal.protobuf.bea;
import com.tencent.p177mm.protocal.protobuf.bed;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI */
public class RecommendFriendUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private C38039b gxY;
    private ListView gxZ;
    private LinkedList<aco> gxf = new LinkedList();
    private boolean gxg;
    private TextView gya;
    private LinkedList<bed> gyb = new LinkedList();
    private int gyc = -1;
    private boolean gyd = false;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI$1 */
    class C98911 implements OnItemClickListener {
        C98911() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = 0;
            AppMethodBeat.m2504i(108627);
            if (RecommendFriendUI.this.gxg) {
                RecommendFriendUI recommendFriendUI = RecommendFriendUI.this;
                C38039b b = RecommendFriendUI.this.gxY;
                if (b.gxg) {
                    i2 = ((aco) b.gxf.get(i)).weB;
                }
                RecommendFriendUI.m17529a(recommendFriendUI, i2);
                AppMethodBeat.m2505o(108627);
                return;
            }
            RecommendFriendUI.this.gxY.mo60794na(i);
            if (RecommendFriendUI.this.gxY.aqw().length > 0) {
                RecommendFriendUI.this.showOptionMenu(true);
                AppMethodBeat.m2505o(108627);
                return;
            }
            RecommendFriendUI.this.showOptionMenu(false);
            AppMethodBeat.m2505o(108627);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI$3 */
    class C98933 implements OnMenuItemClickListener {
        C98933() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(108630);
            RecommendFriendUI.m17533d(RecommendFriendUI.this);
            AppMethodBeat.m2505o(108630);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI$2 */
    class C98942 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI$2$2 */
        class C98922 implements OnClickListener {
            C98922() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI$2$1 */
        class C98951 implements OnClickListener {
            C98951() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(108628);
                RecommendFriendUI.m17532c(RecommendFriendUI.this);
                AppMethodBeat.m2505o(108628);
            }
        }

        C98942() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(108629);
            int length = RecommendFriendUI.this.gxY.aqw().length;
            C30379h.m48440a(RecommendFriendUI.this.mController.ylL, RecommendFriendUI.this.mController.ylL.getResources().getQuantityString(C25738R.plurals.f9604q, length, new Object[]{Integer.valueOf(length)}), RecommendFriendUI.this.getString(C25738R.string.f9238tz), new C98951(), new C98922());
            AppMethodBeat.m2505o(108629);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI$6 */
    class C98966 implements OnClickListener {
        C98966() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108633);
            RecommendFriendUI.this.finish();
            AppMethodBeat.m2505o(108633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI$4 */
    class C98974 implements View.OnClickListener {
        C98974() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108631);
            C4978c.m7375a(RecommendFriendUI.this.gxZ);
            AppMethodBeat.m2505o(108631);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RecommendFriendUI() {
        AppMethodBeat.m2504i(108634);
        AppMethodBeat.m2505o(108634);
    }

    /* renamed from: a */
    static /* synthetic */ void m17529a(RecommendFriendUI recommendFriendUI, int i) {
        AppMethodBeat.m2504i(108645);
        recommendFriendUI.m17535nb(i);
        AppMethodBeat.m2505o(108645);
    }

    /* renamed from: d */
    static /* synthetic */ void m17533d(RecommendFriendUI recommendFriendUI) {
        AppMethodBeat.m2504i(108647);
        recommendFriendUI.goBack();
        AppMethodBeat.m2505o(108647);
    }

    public final int getLayoutId() {
        return 2130969872;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(108635);
        super.onCreate(bundle);
        this.gyc = C5046bo.getInt(getIntent().getStringExtra("recommend_type"), 0);
        this.gxg = false;
        C1720g.m3540Rg().mo14539a((int) C44697b.CTRL_INDEX, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(108635);
    }

    public final void initView() {
        AppMethodBeat.m2504i(108636);
        this.gya = (TextView) findViewById(2131825025);
        if (this.gyc == 1) {
            setMMTitle((int) C25738R.string.e_q);
            this.gya.setText(C25738R.string.e_u);
        } else if (this.gyc == 2) {
            setMMTitle((int) C25738R.string.e_p);
            this.gya.setText(C25738R.string.e_t);
        } else {
            setMMTitle((int) C25738R.string.e7m);
            this.gya.setText(C25738R.string.e_v);
        }
        this.gxY = new C38039b(getLayoutInflater());
        this.gxZ = (ListView) findViewById(2131825024);
        this.gxZ.setOnItemClickListener(new C98911());
        this.gxZ.setAdapter(this.gxY);
        addTextOptionMenu(0, getString(C25738R.string.cer), new C98942());
        showOptionMenu(false);
        aqx();
        setBackBtn(new C98933());
        C98974 c98974 = new C98974();
        AppMethodBeat.m2505o(108636);
    }

    private void goBack() {
        AppMethodBeat.m2504i(108637);
        if (this.gyc != 0) {
            finish();
            AppMethodBeat.m2505o(108637);
        } else if (this.gxg || this.gyd) {
            finish();
            AppMethodBeat.m2505o(108637);
        } else {
            aqz();
            AppMethodBeat.m2505o(108637);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(108638);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(108638);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(108638);
        return onKeyDown;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(108639);
        C1720g.m3540Rg().mo14546b((int) C44697b.CTRL_INDEX, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(108639);
    }

    private void aqx() {
        AppMethodBeat.m2504i(108640);
        this.gyd = true;
        final C1207m c42280aa = new C42280aa(this.gyc);
        C1720g.m3540Rg().mo14541a(c42280aa, 0);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.ceu), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(108632);
                C1720g.m3540Rg().mo14547c(c42280aa);
                RecommendFriendUI.this.finish();
                AppMethodBeat.m2505o(108632);
            }
        });
        AppMethodBeat.m2505o(108640);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(108641);
        C4990ab.m7416i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0 && c1207m.getType() == C44697b.CTRL_INDEX) {
            this.gyb = ((bea) ((C42280aa) c1207m).ehh.fsH.fsP).ndm;
            this.gxf = ((bea) ((C42280aa) c1207m).ehh.fsH.fsP).vFk;
            this.gyd = false;
            if (this.gyb.size() <= 0) {
                aqy();
                AppMethodBeat.m2505o(108641);
                return;
            } else if (this.gyc == 0 && this.gxf.size() <= 0) {
                aqy();
                AppMethodBeat.m2505o(108641);
                return;
            } else if (this.gyc != 0) {
                m17535nb(-1);
                AppMethodBeat.m2505o(108641);
                return;
            } else {
                aqz();
                AppMethodBeat.m2505o(108641);
                return;
            }
        }
        aqy();
        AppMethodBeat.m2505o(108641);
    }

    private void aqy() {
        AppMethodBeat.m2504i(108642);
        this.gya.setVisibility(0);
        this.gxZ.setVisibility(8);
        AppMethodBeat.m2505o(108642);
    }

    /* renamed from: nb */
    private void m17535nb(int i) {
        AppMethodBeat.m2504i(108643);
        C4990ab.m7416i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.gyb.size());
        this.gxY.mo60788a(this.gyb, i);
        this.gxZ.setAdapter(this.gxY);
        this.gxg = false;
        if (this.gyc == 0) {
            String str = "";
            int i2 = 0;
            while (i2 < this.gxf.size()) {
                String str2;
                if (i == ((aco) this.gxf.get(i2)).weB) {
                    str2 = ((aco) this.gxf.get(i2)).wkk;
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
            setMMTitle(str);
        }
        this.gxY.gxg = this.gxg;
        this.gxY.notifyDataSetChanged();
        AppMethodBeat.m2505o(108643);
    }

    private void aqz() {
        AppMethodBeat.m2504i(108644);
        Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", this.gyc == 0);
        C4990ab.m7416i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.gxf.size());
        this.gxY.gxf = this.gxf;
        this.gxZ.setAdapter(this.gxY);
        showOptionMenu(false);
        this.gxg = true;
        setMMTitle((int) C25738R.string.e7m);
        this.gxY.gxg = this.gxg;
        this.gxY.notifyDataSetChanged();
        AppMethodBeat.m2505o(108644);
    }

    /* renamed from: c */
    static /* synthetic */ void m17532c(RecommendFriendUI recommendFriendUI) {
        AppMethodBeat.m2504i(108646);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < recommendFriendUI.gxY.aqw().length) {
                auv auv = new auv();
                auv.jBB = C5046bo.nullAsNil(recommendFriendUI.gxY.aqw()[i2]);
                auv.wyY = recommendFriendUI.gyc;
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(22, auv));
                C45499p c45499p = new C45499p();
                c45499p.username = recommendFriendUI.gxY.aqw()[i2];
                c45499p.gvE = recommendFriendUI.gyc;
                c45499p.fvK = (int) C5046bo.anT();
                ((C9880q) ((C7599a) C1720g.m3530M(C7599a.class)).getInviteFriendOpenStg()).mo21239b(c45499p);
                i = i2 + 1;
            } else {
                C30379h.m48431a(recommendFriendUI.mController.ylL, (int) C25738R.string.ces, (int) C25738R.string.f9238tz, new C98966());
                AppMethodBeat.m2505o(108646);
                return;
            }
        }
    }
}

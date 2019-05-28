package com.tencent.p177mm.plugin.account.p275ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p629f.p630a.C15885b;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c.C30705a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30706e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI */
public class ShowNonWeixinFriendUI extends MMActivity implements C8915a {
    private long gIk = 0;
    private String gIl = "";

    /* renamed from: com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI$2 */
    class C189362 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI$2$1 */
        class C189371 implements C30705a {

            /* renamed from: com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI$2$1$1 */
            class C189381 implements DialogInterface.OnClickListener {
                C189381() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(125585);
                    ShowNonWeixinFriendUI.this.finish();
                    AppMethodBeat.m2505o(125585);
                }
            }

            C189371() {
            }

            /* renamed from: a */
            public final void mo5792a(C30706e c30706e) {
                AppMethodBeat.m2504i(125586);
                C4990ab.m7412e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                AppMethodBeat.m2505o(125586);
            }

            /* renamed from: a */
            public final void mo5791a(C15885b c15885b) {
                AppMethodBeat.m2504i(125587);
                C4990ab.m7412e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                AppMethodBeat.m2505o(125587);
            }

            /* renamed from: p */
            public final void mo5794p(Bundle bundle) {
                AppMethodBeat.m2504i(125588);
                C4990ab.m7416i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
                C30379h.m48431a(ShowNonWeixinFriendUI.this.mController.ylL, (int) C25738R.string.bmi, (int) C25738R.string.f9238tz, new C189381());
                AppMethodBeat.m2505o(125588);
            }

            public final void onCancel() {
                AppMethodBeat.m2504i(125589);
                C4990ab.m7412e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
                AppMethodBeat.m2505o(125589);
            }
        }

        C189362() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125590);
            C30704c c30704c = new C30704c(ShowNonWeixinFriendUI.this.getString(C25738R.string.g7d));
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ShowNonWeixinFriendUI.this.getString(C25738R.string.bmd));
            bundle.putString("to", Long.toString(ShowNonWeixinFriendUI.this.gIk));
            c30704c.mo49071a(ShowNonWeixinFriendUI.this, "apprequests", bundle, new C189371());
            AppMethodBeat.m2505o(125590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI$1 */
    class C266501 implements OnMenuItemClickListener {
        C266501() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125584);
            ShowNonWeixinFriendUI.this.aqX();
            ShowNonWeixinFriendUI.this.finish();
            AppMethodBeat.m2505o(125584);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125591);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.cea);
        this.gIk = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.gIl = getIntent().getStringExtra("Contact_KFacebookName");
        initView();
        AppMethodBeat.m2505o(125591);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125592);
        super.onPause();
        C17884o.acd().mo67503e(this);
        AppMethodBeat.m2505o(125592);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125593);
        super.onResume();
        C17884o.acd().mo67502d(this);
        AppMethodBeat.m2505o(125593);
    }

    public final int getLayoutId() {
        return 2130969486;
    }

    public final void initView() {
        AppMethodBeat.m2504i(125594);
        ImageView imageView = (ImageView) findViewById(2131823851);
        TextView textView = (TextView) findViewById(2131823852);
        TextView textView2 = (TextView) findViewById(2131823853);
        imageView.setBackgroundDrawable(C1338a.m2864g(this, C1318a.default_mobile_avatar));
        imageView.setImageBitmap(C41730b.m73500pS(this.gIk));
        textView.setText(this.gIl);
        textView2.setText(getString(C25738R.string.ce9, new Object[]{this.gIl}));
        setBackBtn(new C266501());
        ((Button) findViewById(2131823854)).setOnClickListener(new C189362());
        AppMethodBeat.m2505o(125594);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(125595);
        initView();
        AppMethodBeat.m2505o(125595);
    }
}

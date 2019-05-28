package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.account.friend.p272a.C32956ab;
import com.tencent.p177mm.plugin.account.friend.p272a.C45497g;
import com.tencent.p177mm.plugin.account.model.C26603h;
import com.tencent.p177mm.plugin.account.model.C9908i;
import com.tencent.p177mm.plugin.account.p275ui.C33040d.C18961a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

@Deprecated
/* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI */
public class FacebookFriendUI extends MMActivity implements C8915a, C1202f {
    private ProgressDialog ehJ = null;
    C33040d gBe;
    private ListView gtT;
    private View gtV;
    String gtX;
    private TextView gtY = null;
    private boolean gxV = false;

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$2 */
    class C20182 implements OnMenuItemClickListener {
        C20182() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124808);
            FacebookFriendUI.this.aqX();
            FacebookFriendUI.this.finish();
            AppMethodBeat.m2505o(124808);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$1 */
    class C99211 implements C5600b {
        C99211() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(124807);
            FacebookFriendUI.this.gtX = C5046bo.m7586vA(str);
            FacebookFriendUI facebookFriendUI = FacebookFriendUI.this;
            if (facebookFriendUI.gBe != null) {
                facebookFriendUI.gBe.mo53600vM(facebookFriendUI.gtX);
            }
            AppMethodBeat.m2505o(124807);
        }

        public final void apo() {
        }

        public final void app() {
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$3 */
    class C99223 implements OnClickListener {
        C99223() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124809);
            C4978c.m7375a(FacebookFriendUI.this.gtT);
            AppMethodBeat.m2505o(124809);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$8 */
    class C165748 extends C9908i {
        C165748() {
        }

        /* renamed from: p */
        public final void mo21265p(Bundle bundle) {
            AppMethodBeat.m2504i(124814);
            super.mo21265p(bundle);
            AppMethodBeat.m2505o(124814);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(124815);
            super.onError(i, str);
            if (i == 3) {
                FacebookFriendUI.m25474f(FacebookFriendUI.this);
            }
            AppMethodBeat.m2505o(124815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$11 */
    class C1657711 implements OnMenuItemClickListener {
        C1657711() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124818);
            FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, InviteFacebookFriendsUI.class));
            AppMethodBeat.m2505o(124818);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$12 */
    class C1657812 implements OnClickListener {
        C1657812() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124819);
            FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, FacebookAuthUI.class));
            AppMethodBeat.m2505o(124819);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$7 */
    class C165807 implements OnItemClickListener {
        C165807() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(124813);
            C45497g c45497g = (C45497g) FacebookFriendUI.this.gBe.getItem(i - FacebookFriendUI.this.gtT.getHeaderViewsCount());
            if (c45497g.status == 100 || c45497g.status == 101) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", c45497g.getUsername());
                intent.putExtra("Contact_Nick", c45497g.apD());
                intent.putExtra("Contact_KFacebookId", c45497g.dtU);
                intent.putExtra("Contact_KFacebookName", c45497g.apL());
                intent.putExtra("Contact_Scene", 31);
                C24679a.gkE.mo38912c(intent, FacebookFriendUI.this);
            }
            if (c45497g.status == 102) {
                AppMethodBeat.m2505o(124813);
            } else {
                AppMethodBeat.m2505o(124813);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$4 */
    class C165814 implements DialogInterface.OnClickListener {
        C165814() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124810);
            Intent intent = new Intent(FacebookFriendUI.this.mController.ylL, FacebookAuthUI.class);
            intent.putExtra("is_force_unbind", true);
            FacebookFriendUI.this.mController.ylL.startActivity(intent);
            FacebookFriendUI.this.finish();
            AppMethodBeat.m2505o(124810);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookFriendUI$6 */
    class C165826 implements C18961a {
        C165826() {
        }

        /* renamed from: mT */
        public final void mo30539mT(int i) {
            AppMethodBeat.m2504i(124812);
            if (i > 0) {
                FacebookFriendUI.this.gtY.setVisibility(8);
                AppMethodBeat.m2505o(124812);
                return;
            }
            FacebookFriendUI.this.gtY.setVisibility(0);
            AppMethodBeat.m2505o(124812);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124820);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.btc);
        C1720g.m3540Rg().mo14539a(32, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(124820);
    }

    public void onResume() {
        AppMethodBeat.m2504i(124821);
        super.onResume();
        C17884o.acd().mo67502d(this);
        this.gBe.notifyDataSetChanged();
        AppMethodBeat.m2505o(124821);
    }

    public void onPause() {
        AppMethodBeat.m2504i(124822);
        super.onPause();
        C17884o.acd().mo67503e(this);
        AppMethodBeat.m2505o(124822);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(124823);
        C1720g.m3540Rg().mo14546b(32, (C1202f) this);
        this.gBe.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(124823);
    }

    public final int getLayoutId() {
        return 2130969545;
    }

    public final void initView() {
        AppMethodBeat.m2504i(124824);
        this.gtT = (ListView) findViewById(2131824012);
        this.gtY = (TextView) findViewById(2131824013);
        this.gtY.setText(C25738R.string.bmc);
        final TextView textView = (TextView) findViewById(2131821807);
        textView.setText(C25738R.string.bma);
        C5601o c5601o = new C5601o((byte) 0);
        c5601o.zHa = new C99211();
        mo17380a(c5601o);
        this.gBe = new C33040d(this, new C30723a() {
            public final void apt() {
                AppMethodBeat.m2504i(124811);
                if (C1853r.m3847Za() && FacebookFriendUI.this.gxV) {
                    if (FacebookFriendUI.this.gBe.getCount() == 0) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                FacebookFriendUI.this.gxV = false;
                AppMethodBeat.m2505o(124811);
            }
        });
        this.gBe.gBa = new C165826();
        this.gtT.setAdapter(this.gBe);
        this.gtV = findViewById(2131824014);
        this.gtT.setOnItemClickListener(new C165807());
        C4990ab.m7410d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + C1853r.m3847Za());
        if (C1853r.m3847Za()) {
            this.gtT.setVisibility(0);
            this.gtV.setVisibility(8);
            long c = C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(65831, null));
            String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(65830, null));
            if (C5046bo.m7566gb(c) > 86400000 && nullAsNil.length() > 0) {
                C30704c c30704c = new C30704c(getString(C25738R.string.g7d));
                c30704c.arX(nullAsNil);
                new C26603h(c30704c, new C165748()).apm();
            }
            final C1207m c32956ab = new C32956ab();
            c32956ab.aqg();
            final C7564ap c7564ap = new C7564ap(new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(124816);
                    C1720g.m3536RP().mo5239Ry().set(65829, Integer.valueOf(1));
                    C1720g.m3540Rg().mo14541a(c32956ab, 0);
                    AppMethodBeat.m2505o(124816);
                    return false;
                }
            }, false);
            if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(65829, null)) > 0) {
                C1720g.m3536RP().mo5239Ry().set(65829, Integer.valueOf(1));
                C1720g.m3540Rg().mo14541a(c32956ab, 0);
            } else {
                c7564ap.mo16770ae(5000, 5000);
            }
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.df7), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(124817);
                    c7564ap.stopTimer();
                    C1720g.m3540Rg().mo14547c(c32956ab);
                    AppMethodBeat.m2505o(124817);
                }
            });
            addTextOptionMenu(0, getString(C25738R.string.btd), new C1657711());
        } else {
            this.gtT.setVisibility(8);
            this.gtV.setVisibility(0);
            ((TextView) findViewById(2131824015)).setText(C25738R.string.bsi);
            this.gtV.setOnClickListener(new C1657812());
        }
        setBackBtn(new C20182());
        C99223 c99223 = new C99223();
        AppMethodBeat.m2505o(124824);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124825);
        C4990ab.m7416i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() != 32) {
            AppMethodBeat.m2505o(124825);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -68) {
            if (C5046bo.isNullOrNil(str)) {
                str = "error";
            }
            m25470bj(getString(C25738R.string.f9238tz), str);
            AppMethodBeat.m2505o(124825);
        } else if (i == 0 && i2 == 0) {
            this.gBe.mo5248a(null, null);
            AppMethodBeat.m2505o(124825);
        } else {
            Toast.makeText(this, C25738R.string.d08, 0).show();
            AppMethodBeat.m2505o(124825);
        }
    }

    /* renamed from: bj */
    private void m25470bj(String str, String str2) {
        AppMethodBeat.m2504i(124826);
        C30379h.m48440a((Context) this, str2, str, new C165814(), null);
        AppMethodBeat.m2505o(124826);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(124827);
        this.gBe.notifyDataSetChanged();
        AppMethodBeat.m2505o(124827);
    }

    /* renamed from: f */
    static /* synthetic */ void m25474f(FacebookFriendUI facebookFriendUI) {
        AppMethodBeat.m2504i(124828);
        C4990ab.m7412e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.m25470bj(facebookFriendUI.getString(C25738R.string.f9238tz), facebookFriendUI.getString(C25738R.string.bmb));
        AppMethodBeat.m2505o(124828);
    }
}

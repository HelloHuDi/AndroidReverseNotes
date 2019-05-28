package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C24054q;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI */
public class AppBrandOpenWeRunSettingUI extends MMActivity implements C1202f {
    private C7616ad ehM = null;
    private ImageView eks;
    private TextView gne;
    private TextView gnh;
    private TextView gtO;
    private TextView iGX;
    C44275p iGY;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI$3 */
    class C24703 implements C9636a {
        C24703() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(132996);
            C4990ab.m7417i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", Boolean.valueOf(z), str);
            AppBrandOpenWeRunSettingUI.this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO("gh_43f2581f6fd6");
            AppBrandOpenWeRunSettingUI.m43378a(AppBrandOpenWeRunSettingUI.this);
            AppBrandOpenWeRunSettingUI.this.iGY.dismiss();
            AppMethodBeat.m2505o(132996);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI$1 */
    class C107651 implements OnClickListener {
        C107651() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(132994);
            C22162d.m33785kT(13);
            C1202f c1202f = AppBrandOpenWeRunSettingUI.this;
            c1202f.getString(C25738R.string.f9238tz);
            c1202f.iGY = C30379h.m48458b((Context) c1202f, c1202f.getString(C25738R.string.e_c), true, null);
            c1202f.iGY.show();
            C1720g.m3535RO().eJo.mo14539a(30, c1202f);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            C1720g.m3535RO().eJo.mo14541a(new C46498m(1, linkedList, linkedList2, "", ""), 0);
            AppMethodBeat.m2505o(132994);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI$2 */
    class C107662 implements OnMenuItemClickListener {
        C107662() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(132995);
            AppBrandOpenWeRunSettingUI.this.finish();
            AppMethodBeat.m2505o(132995);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI$4 */
    class C107674 implements Runnable {
        C107674() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132997);
            AppBrandOpenWeRunSettingUI.this.finish();
            AppMethodBeat.m2505o(132997);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m43378a(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        AppMethodBeat.m2504i(133001);
        appBrandOpenWeRunSettingUI.aMk();
        AppMethodBeat.m2505o(133001);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(132998);
        super.onCreate(bundle);
        setMMTitle(getString(C25738R.string.f8972la));
        this.eks = (ImageView) findViewById(2131821239);
        this.gtO = (TextView) findViewById(2131821240);
        this.gnh = (TextView) findViewById(2131821241);
        this.gne = (TextView) findViewById(2131821242);
        this.iGX = (TextView) findViewById(2131821244);
        this.iGX.setOnClickListener(new C107651());
        setBackBtn(new C107662());
        String nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO("gh_43f2581f6fd6");
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0) {
            getString(C25738R.string.f9238tz);
            this.iGY = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, null);
            this.iGY.show();
            C26417a.flu.mo20966a("gh_43f2581f6fd6", "", new C24703());
        }
        this.gne.setText(getString(C25738R.string.f8974lc, new Object[]{nullAsNil}));
        aMk();
        AppMethodBeat.m2505o(132998);
    }

    public final int getLayoutId() {
        return 2130968697;
    }

    private void aMk() {
        AppMethodBeat.m2504i(132999);
        C40460b.m69434b(this.eks, this.ehM.field_username);
        this.gtO.setText(this.ehM.mo16707Oj());
        if (C7486a.m12942jh(this.ehM.field_type)) {
            this.gnh.setTextColor(C24054q.m37013ii(this.mController.ylL));
            this.gnh.setText(C25738R.string.e_a);
            this.gnh.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.ap2, 0, 0, 0);
            this.iGX.setText(C25738R.string.e_a);
            this.iGX.setClickable(false);
            AppMethodBeat.m2505o(132999);
            return;
        }
        this.gnh.setTextColor(C24054q.m37014ij(this.mController.ylL));
        this.gnh.setText(C25738R.string.e_i);
        this.gnh.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.ap1, 0, 0, 0);
        this.iGX.setText(C25738R.string.e_9);
        this.iGX.setClickable(true);
        AppMethodBeat.m2505o(132999);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(133000);
        if (c1207m instanceof C46498m) {
            C1720g.m3535RO().eJo.mo14546b(30, (C1202f) this);
            if (i == 0 && i2 == 0) {
                String dhl = ((C46498m) c1207m).dhl();
                C4990ab.m7417i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", dhl);
                this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO("gh_43f2581f6fd6");
                C7616ad c7616ad = this.ehM;
                if (c7616ad == null || C5046bo.isNullOrNil(dhl)) {
                    C4990ab.m7412e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + dhl + ", contact = " + c7616ad);
                } else {
                    C16527d c16527d;
                    if (C1855t.m3911mX(c7616ad.field_username)) {
                        String nullAsNil = C5046bo.nullAsNil(c7616ad.field_username);
                        C16527d qX = C17903f.m28104qX(nullAsNil);
                        if (qX != null) {
                            qX.field_username = dhl;
                        }
                        C41747z.aeR().delete(nullAsNil);
                        c7616ad.mo14709iH(nullAsNil);
                        c16527d = qX;
                    } else {
                        c16527d = null;
                    }
                    c7616ad.setUsername(dhl);
                    if (((int) c7616ad.ewQ) == 0) {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15708aa(c7616ad);
                    }
                    if (((int) c7616ad.ewQ) <= 0) {
                        C4990ab.m7412e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
                    } else {
                        C1855t.m3960q(c7616ad);
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
                        if (c16527d != null) {
                            C41747z.aeR().mo43724d(c16527d);
                        } else {
                            c16527d = C17903f.m28104qX(aoO.field_username);
                            if (c16527d == null || c16527d.adJ()) {
                                C4990ab.m7410d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
                                C26417a.flu.mo20967ai(aoO.field_username, "");
                                C41730b.m73506pY(aoO.field_username);
                            } else if (aoO.dsi()) {
                                C4990ab.m7411d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", Integer.valueOf(aoO.duj));
                                C26417a.flu.mo20967ai(aoO.field_username, "");
                                C41730b.m73506pY(aoO.field_username);
                            }
                        }
                    }
                }
                C41747z.aeR().mo43726e(C41747z.aeR().mo43729qP(this.ehM.field_username));
                C1720g.m3536RP().mo5239Ry().set(327825, Boolean.TRUE);
                setResult(-1);
                C5004al.m7442n(new C107674(), 1500);
            } else {
                C4990ab.m7413e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                    Toast.makeText(C4996ah.getContext(), str, 1).show();
                }
                setResult(1);
            }
            if (this.iGY != null) {
                this.iGY.dismiss();
            }
            aMk();
        }
        AppMethodBeat.m2505o(133000);
    }
}

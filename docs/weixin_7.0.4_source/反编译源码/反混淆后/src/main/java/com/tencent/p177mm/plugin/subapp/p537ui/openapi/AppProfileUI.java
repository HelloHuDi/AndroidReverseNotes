package com.tencent.p177mm.plugin.subapp.p537ui.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.p069v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.subapp.p537ui.openapi.AppHeaderPreference.C43670a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI */
public class AppProfileUI extends MMPreference implements C4931a {
    private C15541f ehK;
    private C7306ak handler = null;
    private C40439f neJ;
    private C43670a suF;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI$2 */
    class C223492 implements OnMenuItemClickListener {
        C223492() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25452);
            AppProfileUI.this.finish();
            AppMethodBeat.m2505o(25452);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI$3 */
    class C223503 extends C7306ak {
        C223503() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(25453);
            AppProfileUI.this.finish();
            AppMethodBeat.m2505o(25453);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI$1 */
    class C399421 implements C43670a {
        C399421() {
        }

        public final String cDK() {
            AppMethodBeat.m2504i(25448);
            String b = C46494g.m87733b(AppProfileUI.this.mController.ylL, AppProfileUI.this.neJ, null);
            AppMethodBeat.m2505o(25448);
            return b;
        }

        public final Bitmap cDL() {
            AppMethodBeat.m2504i(25449);
            Bitmap b = C46494g.m87732b(AppProfileUI.this.neJ.field_appId, 1, C1338a.getDensity(AppProfileUI.this));
            AppMethodBeat.m2505o(25449);
            return b;
        }

        /* renamed from: lY */
        public final String mo63139lY(boolean z) {
            AppMethodBeat.m2504i(25450);
            String string = AppProfileUI.this.mController.ylL.getString(z ? C25738R.string.e_a : C25738R.string.e_i);
            AppMethodBeat.m2505o(25450);
            return string;
        }

        public final String getHint() {
            AppMethodBeat.m2504i(25451);
            AppCompatActivity appCompatActivity = AppProfileUI.this.mController.ylL;
            C40439f a = AppProfileUI.this.neJ;
            if (appCompatActivity == null || a == null) {
                AppMethodBeat.m2505o(25451);
                return null;
            }
            String fK = C46494g.m87746fK(appCompatActivity);
            if (fK.equalsIgnoreCase("zh_CN")) {
                fK = a.field_appDiscription;
                AppMethodBeat.m2505o(25451);
                return fK;
            } else if (fK.equalsIgnoreCase("zh_TW") || fK.equalsIgnoreCase("zh_HK")) {
                if (C5046bo.isNullOrNil(a.field_appDiscription_tw)) {
                    fK = a.field_appDiscription;
                    AppMethodBeat.m2505o(25451);
                    return fK;
                }
                fK = a.field_appDiscription_tw;
                AppMethodBeat.m2505o(25451);
                return fK;
            } else if (fK.equalsIgnoreCase("en")) {
                if (C5046bo.isNullOrNil(a.field_appDiscription_en)) {
                    fK = a.field_appDiscription;
                    AppMethodBeat.m2505o(25451);
                    return fK;
                }
                fK = a.field_appDiscription_en;
                AppMethodBeat.m2505o(25451);
                return fK;
            } else if (C5046bo.isNullOrNil(a.field_appDiscription_en)) {
                fK = a.field_appDiscription;
                AppMethodBeat.m2505o(25451);
                return fK;
            } else {
                fK = a.field_appDiscription_en;
                AppMethodBeat.m2505o(25451);
                return fK;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8468h;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25454);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(25454);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25455);
        super.onResume();
        C14877am.bYJ().mo10116c(this);
        AppMethodBeat.m2505o(25455);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25456);
        C14877am.bYJ().mo10117d(this);
        super.onPause();
        AppMethodBeat.m2505o(25456);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.m2504i(25457);
        this.suF = new C399421();
        this.neJ = C46494g.m87739bT(getIntent().getStringExtra("AppProfileUI_AppId"), true);
        String str = "initView : appInfo does not exist";
        if (this.neJ == null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        setMMTitle((int) C25738R.string.f9207sy);
        this.ehK = this.yCw;
        setBackBtn(new C223492());
        refresh();
        AppMethodBeat.m2505o(25457);
    }

    private void refresh() {
        boolean z = true;
        AppMethodBeat.m2504i(25458);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8468h);
        if (this.neJ.field_status == 1) {
            this.ehK.aqP("app_profile_add");
        } else {
            this.ehK.aqP("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.ehK.aqO("app_profile_header");
        C43670a c43670a = this.suF;
        if (this.neJ.field_status != 1) {
            z = false;
        }
        appHeaderPreference.mo74454a(c43670a, z);
        AppMethodBeat.m2505o(25458);
    }

    private void cDM() {
        AppMethodBeat.m2504i(25459);
        this.handler = new C223503();
        this.handler.sendEmptyMessageDelayed(0, 30);
        AppMethodBeat.m2505o(25459);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(25461);
        if (str.equals(this.neJ.field_appId)) {
            initView();
        }
        AppMethodBeat.m2505o(25461);
    }

    /* renamed from: a */
    private static void m81678a(C40439f c40439f, boolean z) {
        AppMethodBeat.m2504i(25462);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C6333a(10165, c40439f.field_appId + "," + (z ? "1" : "2")));
        C9638aw.m17190ZK();
        C18628c.m29077XL().mo7920c(new C6332h(linkedList));
        AppMethodBeat.m2505o(25462);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(25460);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.neJ.field_status = 1;
            this.neJ.field_modifyTime = System.currentTimeMillis();
            C14877am.bYJ().mo56566a(this.neJ, new String[0]);
            refresh();
            AppProfileUI.m81678a(this.neJ, true);
            cDM();
            AppMethodBeat.m2505o(25460);
            return true;
        } else if (str.equals("app_profile_remove")) {
            this.neJ.field_status = 0;
            this.neJ.field_modifyTime = System.currentTimeMillis();
            C14877am.bYJ().mo56566a(this.neJ, new String[0]);
            refresh();
            AppProfileUI.m81678a(this.neJ, false);
            cDM();
            AppMethodBeat.m2505o(25460);
            return true;
        } else {
            AppMethodBeat.m2505o(25460);
            return false;
        }
    }
}

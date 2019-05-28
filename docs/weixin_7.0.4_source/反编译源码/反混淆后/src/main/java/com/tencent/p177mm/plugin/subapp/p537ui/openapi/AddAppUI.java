package com.tencent.p177mm.plugin.subapp.p537ui.openapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI */
public class AddAppUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private AppPreference sus;
    private AppPreference sut;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI$1 */
    class C223451 implements OnMenuItemClickListener {
        C223451() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25416);
            AddAppUI.this.finish();
            AppMethodBeat.m2505o(25416);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI$2 */
    class C223462 implements OnItemClickListener {
        C223462() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25417);
            AddAppUI.m34050a(AddAppUI.this, AddAppUI.this.sus.mo69311Fq(i).field_appId);
            AppMethodBeat.m2505o(25417);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI$3 */
    class C223473 implements OnItemClickListener {
        C223473() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25418);
            AddAppUI.m34052f(AddAppUI.this.sus.mo69311Fq(i));
            AddAppUI.this.initView();
            AppMethodBeat.m2505o(25418);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI$4 */
    class C223484 implements OnItemClickListener {
        C223484() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25419);
            AddAppUI.m34050a(AddAppUI.this, AddAppUI.this.sut.mo69311Fq(i).field_appId);
            AppMethodBeat.m2505o(25419);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8466e;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25420);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(25420);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25421);
        super.onResume();
        initView();
        if (this.sus != null) {
            this.sus.onResume();
        }
        if (this.sut != null) {
            this.sut.onResume();
        }
        AppMethodBeat.m2505o(25421);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25422);
        super.onPause();
        if (this.sus != null) {
            this.sus.onPause();
        }
        if (this.sut != null) {
            this.sut.onPause();
        }
        AppMethodBeat.m2505o(25422);
    }

    public final void initView() {
        AppMethodBeat.m2504i(25423);
        setMMTitle((int) C25738R.string.f8720d4);
        setBackBtn(new C223451());
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8466e);
        cDJ();
        AppMethodBeat.m2505o(25423);
    }

    private void cDJ() {
        AppMethodBeat.m2504i(25424);
        this.sus = (AppPreference) this.ehK.aqO("addapp_added");
        this.sus.suw = 1;
        this.sus.suz = new C223462();
        this.sus.suA = new C223473();
        this.sut = (AppPreference) this.ehK.aqO("addapp_available");
        this.sut.suw = 0;
        this.sut.suz = new C223484();
        AppMethodBeat.m2505o(25424);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25426);
        C4990ab.m7410d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i == 0 && i2 == 0) {
            AppMethodBeat.m2505o(25426);
            return;
        }
        C4990ab.m7412e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        AppMethodBeat.m2505o(25426);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(25425);
        if (preference.mKey.equals("addapp_recommend")) {
            String g = C4988aa.m7402g(this.mController.ylL.getSharedPreferences(C4996ah.doA(), 0));
            String string = getString(C25738R.string.f8725d9, new Object[]{Integer.valueOf(C7243d.vxo), g, C4988aa.doq()});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(25425);
            return true;
        }
        AppMethodBeat.m2505o(25425);
        return false;
    }

    /* renamed from: f */
    static /* synthetic */ void m34052f(C40439f c40439f) {
        AppMethodBeat.m2504i(25428);
        c40439f.field_status = 0;
        c40439f.field_modifyTime = System.currentTimeMillis();
        C14877am.bYJ().mo56566a(c40439f, new String[0]);
        AppMethodBeat.m2505o(25428);
    }
}

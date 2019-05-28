package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class AddAppUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private AppPreference sus;
    private AppPreference sut;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.e;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25420);
        super.onCreate(bundle);
        AppMethodBeat.o(25420);
    }

    public void onResume() {
        AppMethodBeat.i(25421);
        super.onResume();
        initView();
        if (this.sus != null) {
            this.sus.onResume();
        }
        if (this.sut != null) {
            this.sut.onResume();
        }
        AppMethodBeat.o(25421);
    }

    public void onPause() {
        AppMethodBeat.i(25422);
        super.onPause();
        if (this.sus != null) {
            this.sus.onPause();
        }
        if (this.sut != null) {
            this.sut.onPause();
        }
        AppMethodBeat.o(25422);
    }

    public final void initView() {
        AppMethodBeat.i(25423);
        setMMTitle((int) R.string.d4);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25416);
                AddAppUI.this.finish();
                AppMethodBeat.o(25416);
                return true;
            }
        });
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.e);
        cDJ();
        AppMethodBeat.o(25423);
    }

    private void cDJ() {
        AppMethodBeat.i(25424);
        this.sus = (AppPreference) this.ehK.aqO("addapp_added");
        this.sus.suw = 1;
        this.sus.suz = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(25417);
                AddAppUI.a(AddAppUI.this, AddAppUI.this.sus.Fq(i).field_appId);
                AppMethodBeat.o(25417);
            }
        };
        this.sus.suA = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(25418);
                AddAppUI.f(AddAppUI.this.sus.Fq(i));
                AddAppUI.this.initView();
                AppMethodBeat.o(25418);
            }
        };
        this.sut = (AppPreference) this.ehK.aqO("addapp_available");
        this.sut.suw = 0;
        this.sut.suz = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(25419);
                AddAppUI.a(AddAppUI.this, AddAppUI.this.sut.Fq(i).field_appId);
                AppMethodBeat.o(25419);
            }
        };
        AppMethodBeat.o(25424);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(25426);
        ab.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i == 0 && i2 == 0) {
            AppMethodBeat.o(25426);
            return;
        }
        ab.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        AppMethodBeat.o(25426);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(25425);
        if (preference.mKey.equals("addapp_recommend")) {
            String g = aa.g(this.mController.ylL.getSharedPreferences(ah.doA(), 0));
            String string = getString(R.string.d9, new Object[]{Integer.valueOf(d.vxo), g, aa.doq()});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(25425);
            return true;
        }
        AppMethodBeat.o(25425);
        return false;
    }

    static /* synthetic */ void f(com.tencent.mm.pluginsdk.model.app.f fVar) {
        AppMethodBeat.i(25428);
        fVar.field_status = 0;
        fVar.field_modifyTime = System.currentTimeMillis();
        am.bYJ().a(fVar, new String[0]);
        AppMethodBeat.o(25428);
    }
}

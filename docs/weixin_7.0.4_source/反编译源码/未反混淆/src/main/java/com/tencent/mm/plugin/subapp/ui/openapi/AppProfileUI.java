package com.tencent.mm.plugin.subapp.ui.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import junit.framework.Assert;

public class AppProfileUI extends MMPreference implements a {
    private f ehK;
    private ak handler = null;
    private com.tencent.mm.pluginsdk.model.app.f neJ;
    private AppHeaderPreference.a suF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.h;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25454);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(25454);
    }

    public void onResume() {
        AppMethodBeat.i(25455);
        super.onResume();
        am.bYJ().c(this);
        AppMethodBeat.o(25455);
    }

    public void onPause() {
        AppMethodBeat.i(25456);
        am.bYJ().d(this);
        super.onPause();
        AppMethodBeat.o(25456);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.i(25457);
        this.suF = new AppHeaderPreference.a() {
            public final String cDK() {
                AppMethodBeat.i(25448);
                String b = g.b(AppProfileUI.this.mController.ylL, AppProfileUI.this.neJ, null);
                AppMethodBeat.o(25448);
                return b;
            }

            public final Bitmap cDL() {
                AppMethodBeat.i(25449);
                Bitmap b = g.b(AppProfileUI.this.neJ.field_appId, 1, com.tencent.mm.bz.a.getDensity(AppProfileUI.this));
                AppMethodBeat.o(25449);
                return b;
            }

            public final String lY(boolean z) {
                AppMethodBeat.i(25450);
                String string = AppProfileUI.this.mController.ylL.getString(z ? R.string.e_a : R.string.e_i);
                AppMethodBeat.o(25450);
                return string;
            }

            public final String getHint() {
                AppMethodBeat.i(25451);
                AppCompatActivity appCompatActivity = AppProfileUI.this.mController.ylL;
                com.tencent.mm.pluginsdk.model.app.f a = AppProfileUI.this.neJ;
                if (appCompatActivity == null || a == null) {
                    AppMethodBeat.o(25451);
                    return null;
                }
                String fK = g.fK(appCompatActivity);
                if (fK.equalsIgnoreCase("zh_CN")) {
                    fK = a.field_appDiscription;
                    AppMethodBeat.o(25451);
                    return fK;
                } else if (fK.equalsIgnoreCase("zh_TW") || fK.equalsIgnoreCase("zh_HK")) {
                    if (bo.isNullOrNil(a.field_appDiscription_tw)) {
                        fK = a.field_appDiscription;
                        AppMethodBeat.o(25451);
                        return fK;
                    }
                    fK = a.field_appDiscription_tw;
                    AppMethodBeat.o(25451);
                    return fK;
                } else if (fK.equalsIgnoreCase("en")) {
                    if (bo.isNullOrNil(a.field_appDiscription_en)) {
                        fK = a.field_appDiscription;
                        AppMethodBeat.o(25451);
                        return fK;
                    }
                    fK = a.field_appDiscription_en;
                    AppMethodBeat.o(25451);
                    return fK;
                } else if (bo.isNullOrNil(a.field_appDiscription_en)) {
                    fK = a.field_appDiscription;
                    AppMethodBeat.o(25451);
                    return fK;
                } else {
                    fK = a.field_appDiscription_en;
                    AppMethodBeat.o(25451);
                    return fK;
                }
            }
        };
        this.neJ = g.bT(getIntent().getStringExtra("AppProfileUI_AppId"), true);
        String str = "initView : appInfo does not exist";
        if (this.neJ == null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        setMMTitle((int) R.string.sy);
        this.ehK = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25452);
                AppProfileUI.this.finish();
                AppMethodBeat.o(25452);
                return true;
            }
        });
        refresh();
        AppMethodBeat.o(25457);
    }

    private void refresh() {
        boolean z = true;
        AppMethodBeat.i(25458);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.h);
        if (this.neJ.field_status == 1) {
            this.ehK.aqP("app_profile_add");
        } else {
            this.ehK.aqP("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.ehK.aqO("app_profile_header");
        AppHeaderPreference.a aVar = this.suF;
        if (this.neJ.field_status != 1) {
            z = false;
        }
        appHeaderPreference.a(aVar, z);
        AppMethodBeat.o(25458);
    }

    private void cDM() {
        AppMethodBeat.i(25459);
        this.handler = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(25453);
                AppProfileUI.this.finish();
                AppMethodBeat.o(25453);
            }
        };
        this.handler.sendEmptyMessageDelayed(0, 30);
        AppMethodBeat.o(25459);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(25461);
        if (str.equals(this.neJ.field_appId)) {
            initView();
        }
        AppMethodBeat.o(25461);
    }

    private static void a(com.tencent.mm.pluginsdk.model.app.f fVar, boolean z) {
        AppMethodBeat.i(25462);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new h.a(10165, fVar.field_appId + "," + (z ? "1" : "2")));
        aw.ZK();
        c.XL().c(new h(linkedList));
        AppMethodBeat.o(25462);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(25460);
        String str = preference.mKey;
        ab.i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.neJ.field_status = 1;
            this.neJ.field_modifyTime = System.currentTimeMillis();
            am.bYJ().a(this.neJ, new String[0]);
            refresh();
            a(this.neJ, true);
            cDM();
            AppMethodBeat.o(25460);
            return true;
        } else if (str.equals("app_profile_remove")) {
            this.neJ.field_status = 0;
            this.neJ.field_modifyTime = System.currentTimeMillis();
            am.bYJ().a(this.neJ, new String[0]);
            refresh();
            a(this.neJ, false);
            cDM();
            AppMethodBeat.o(25460);
            return true;
        } else {
            AppMethodBeat.o(25460);
            return false;
        }
    }
}

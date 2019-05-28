package com.tencent.mm.plugin.subapp.ui.openapi;

import android.database.Cursor;
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
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private ServicePreference suH;
    private ServicePreference suI;
    private PreferenceTitleCategory suJ;
    private PreferenceTitleCategory suK;
    private List<com.tencent.mm.pluginsdk.model.app.f> suL = new ArrayList();
    private List<com.tencent.mm.pluginsdk.model.app.f> suM = new ArrayList();
    private OnItemClickListener suN;
    private OnItemClickListener suO;
    private String talker;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ServiceAppUI() {
        AppMethodBeat.i(25474);
        AppMethodBeat.o(25474);
    }

    public final int JC() {
        return R.xml.bk;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25475);
        super.onCreate(bundle);
        AppMethodBeat.o(25475);
    }

    public void onResume() {
        AppMethodBeat.i(25476);
        super.onResume();
        initView();
        if (this.suH != null) {
            this.suH.onResume();
        }
        if (this.suI != null) {
            this.suI.onResume();
        }
        AppMethodBeat.o(25476);
    }

    public void onPause() {
        AppMethodBeat.i(25477);
        super.onPause();
        if (this.suH != null) {
            this.suH.onPause();
        }
        if (this.suI != null) {
            this.suI.onPause();
        }
        AppMethodBeat.o(25477);
    }

    public final void initView() {
        AppMethodBeat.i(25478);
        setMMTitle((int) R.string.e3u);
        this.talker = getIntent().getStringExtra("service_app_talker_user");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25471);
                ServiceAppUI.this.finish();
                AppMethodBeat.o(25471);
                return true;
            }
        });
        cDN();
        cDO();
        this.ehK = this.yCw;
        this.ehK.removeAll();
        if (this.suL.size() > 0) {
            this.suH = new ServicePreference(this);
            this.suH.qnw = this.suL;
            if (this.suN != null) {
                this.suH.suz = this.suN;
            }
            if (this.suJ == null) {
                this.suJ = new PreferenceTitleCategory(this);
                this.suJ.setTitle((int) R.string.g36);
            }
            this.ehK.b(this.suJ);
            this.ehK.b(this.suH);
        }
        if (this.suM.size() > 0) {
            this.suI = new ServicePreference(this);
            this.suI.qnw = this.suM;
            if (this.suO != null) {
                this.suI.suz = this.suO;
            }
            if (this.suK == null) {
                this.suK = new PreferenceTitleCategory(this);
                this.suK.setTitle((int) R.string.a9o);
            }
            this.ehK.b(this.suK);
            this.ehK.b(this.suI);
        }
        AppMethodBeat.o(25478);
    }

    private void cDN() {
        Cursor eQ;
        AppMethodBeat.i(25479);
        this.suL.clear();
        this.suM.clear();
        if (t.kH(this.talker)) {
            eQ = am.bYJ().eQ(0, 2);
        } else if (t.mZ(this.talker)) {
            eQ = am.bYJ().eQ(0, 4);
        } else {
            eQ = am.bYJ().eQ(0, 1);
        }
        if (eQ != null) {
            if (eQ.moveToFirst()) {
                do {
                    com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                    fVar.d(eQ);
                    if (fVar.field_serviceAppType == 1) {
                        this.suL.add(fVar);
                    } else if (fVar.field_serviceAppType == 2) {
                        this.suM.add(fVar);
                    }
                } while (eQ.moveToNext());
            }
            eQ.close();
        }
        AppMethodBeat.o(25479);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(25480);
        ab.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i == 0 && i2 == 0) {
            AppMethodBeat.o(25480);
            return;
        }
        ab.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        AppMethodBeat.o(25480);
    }

    private void cDO() {
        AppMethodBeat.i(25481);
        if (this.suN == null) {
            this.suN = new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(25472);
                    if (ServiceAppUI.this.suH == null) {
                        ab.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                        AppMethodBeat.o(25472);
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f Fq = ServiceAppUI.this.suH.Fq(i);
                    if (Fq == null) {
                        ab.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                        AppMethodBeat.o(25472);
                        return;
                    }
                    ab.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(Fq.dnv), Fq.field_packageName, Fq.field_appId);
                    ServiceAppUI.a(ServiceAppUI.this, Fq);
                    AppMethodBeat.o(25472);
                }
            };
        }
        if (this.suO == null) {
            this.suO = new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(25473);
                    if (ServiceAppUI.this.suI == null) {
                        ab.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                        AppMethodBeat.o(25473);
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f Fq = ServiceAppUI.this.suI.Fq(i);
                    if (Fq == null) {
                        ab.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                        AppMethodBeat.o(25473);
                        return;
                    }
                    ab.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(Fq.dnv), Fq.field_packageName, Fq.field_appId);
                    ServiceAppUI.a(ServiceAppUI.this, Fq);
                    AppMethodBeat.o(25473);
                }
            };
        }
        AppMethodBeat.o(25481);
    }
}

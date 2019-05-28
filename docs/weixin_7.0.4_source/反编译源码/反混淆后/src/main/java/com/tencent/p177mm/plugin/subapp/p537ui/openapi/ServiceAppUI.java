package com.tencent.p177mm.plugin.subapp.p537ui.openapi;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI */
public class ServiceAppUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private ServicePreference suH;
    private ServicePreference suI;
    private PreferenceTitleCategory suJ;
    private PreferenceTitleCategory suK;
    private List<C40439f> suL = new ArrayList();
    private List<C40439f> suM = new ArrayList();
    private OnItemClickListener suN;
    private OnItemClickListener suO;
    private String talker;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI$1 */
    class C436721 implements OnMenuItemClickListener {
        C436721() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25471);
            ServiceAppUI.this.finish();
            AppMethodBeat.m2505o(25471);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI$2 */
    class C436732 implements OnItemClickListener {
        C436732() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25472);
            if (ServiceAppUI.this.suH == null) {
                C4990ab.m7412e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                AppMethodBeat.m2505o(25472);
                return;
            }
            C40439f Fq = ServiceAppUI.this.suH.mo9110Fq(i);
            if (Fq == null) {
                C4990ab.m7412e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                AppMethodBeat.m2505o(25472);
                return;
            }
            C4990ab.m7417i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(Fq.dnv), Fq.field_packageName, Fq.field_appId);
            ServiceAppUI.m86843a(ServiceAppUI.this, Fq);
            AppMethodBeat.m2505o(25472);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI$3 */
    class C436743 implements OnItemClickListener {
        C436743() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(25473);
            if (ServiceAppUI.this.suI == null) {
                C4990ab.m7412e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                AppMethodBeat.m2505o(25473);
                return;
            }
            C40439f Fq = ServiceAppUI.this.suI.mo9110Fq(i);
            if (Fq == null) {
                C4990ab.m7412e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                AppMethodBeat.m2505o(25473);
                return;
            }
            C4990ab.m7417i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(Fq.dnv), Fq.field_packageName, Fq.field_appId);
            ServiceAppUI.m86843a(ServiceAppUI.this, Fq);
            AppMethodBeat.m2505o(25473);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ServiceAppUI() {
        AppMethodBeat.m2504i(25474);
        AppMethodBeat.m2505o(25474);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8536bk;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25475);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(25475);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25476);
        super.onResume();
        initView();
        if (this.suH != null) {
            this.suH.onResume();
        }
        if (this.suI != null) {
            this.suI.onResume();
        }
        AppMethodBeat.m2505o(25476);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25477);
        super.onPause();
        if (this.suH != null) {
            this.suH.onPause();
        }
        if (this.suI != null) {
            this.suI.onPause();
        }
        AppMethodBeat.m2505o(25477);
    }

    public final void initView() {
        AppMethodBeat.m2504i(25478);
        setMMTitle((int) C25738R.string.e3u);
        this.talker = getIntent().getStringExtra("service_app_talker_user");
        setBackBtn(new C436721());
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
                this.suJ.setTitle((int) C25738R.string.g36);
            }
            this.ehK.mo27713b(this.suJ);
            this.ehK.mo27713b(this.suH);
        }
        if (this.suM.size() > 0) {
            this.suI = new ServicePreference(this);
            this.suI.qnw = this.suM;
            if (this.suO != null) {
                this.suI.suz = this.suO;
            }
            if (this.suK == null) {
                this.suK = new PreferenceTitleCategory(this);
                this.suK.setTitle((int) C25738R.string.a9o);
            }
            this.ehK.mo27713b(this.suK);
            this.ehK.mo27713b(this.suI);
        }
        AppMethodBeat.m2505o(25478);
    }

    private void cDN() {
        Cursor eQ;
        AppMethodBeat.m2504i(25479);
        this.suL.clear();
        this.suM.clear();
        if (C1855t.m3896kH(this.talker)) {
            eQ = C14877am.bYJ().mo56572eQ(0, 2);
        } else if (C1855t.m3913mZ(this.talker)) {
            eQ = C14877am.bYJ().mo56572eQ(0, 4);
        } else {
            eQ = C14877am.bYJ().mo56572eQ(0, 1);
        }
        if (eQ != null) {
            if (eQ.moveToFirst()) {
                do {
                    C40439f c40439f = new C40439f();
                    c40439f.mo8995d(eQ);
                    if (c40439f.field_serviceAppType == 1) {
                        this.suL.add(c40439f);
                    } else if (c40439f.field_serviceAppType == 2) {
                        this.suM.add(c40439f);
                    }
                } while (eQ.moveToNext());
            }
            eQ.close();
        }
        AppMethodBeat.m2505o(25479);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25480);
        C4990ab.m7410d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i == 0 && i2 == 0) {
            AppMethodBeat.m2505o(25480);
            return;
        }
        C4990ab.m7412e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        AppMethodBeat.m2505o(25480);
    }

    private void cDO() {
        AppMethodBeat.m2504i(25481);
        if (this.suN == null) {
            this.suN = new C436732();
        }
        if (this.suO == null) {
            this.suO = new C436743();
        }
        AppMethodBeat.m2505o(25481);
    }
}

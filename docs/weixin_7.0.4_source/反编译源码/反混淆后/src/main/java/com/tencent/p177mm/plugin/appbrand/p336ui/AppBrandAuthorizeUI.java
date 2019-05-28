package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C45374tz;
import com.tencent.p177mm.p230g.p231a.C45374tz.C18404a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C45536u;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.protocal.protobuf.C35920fu;
import com.tencent.p177mm.protocal.protobuf.bbm;
import com.tencent.p177mm.protocal.protobuf.cwh;
import com.tencent.p177mm.protocal.protobuf.cwi;
import com.tencent.p177mm.protocal.protobuf.cwr;
import com.tencent.p177mm.protocal.protobuf.cws;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI */
public class AppBrandAuthorizeUI extends MMPreference {
    private C44275p ejZ;
    List<C35920fu> iFC = new ArrayList();
    private C45536u iFD;
    protected C15541f iFE;
    private boolean iFF = false;
    private boolean iFG = true;
    private boolean iFH = false;
    private C7355b iFI = null;
    private String igi;
    private String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$AuthStateChangedByUserEvent */
    public static final class AuthStateChangedByUserEvent implements Parcelable {
        public static final Creator<AuthStateChangedByUserEvent> CREATOR = new C24671();

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$AuthStateChangedByUserEvent$1 */
        static class C24671 implements Creator<AuthStateChangedByUserEvent> {
            C24671() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AuthStateChangedByUserEvent[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132907);
                AuthStateChangedByUserEvent authStateChangedByUserEvent = new AuthStateChangedByUserEvent((byte) 0);
                AppMethodBeat.m2505o(132907);
                return authStateChangedByUserEvent;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
        }

        AuthStateChangedByUserEvent(byte b) {
        }

        static {
            AppMethodBeat.m2504i(132908);
            AppMethodBeat.m2505o(132908);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$a */
    interface C10750a {
        /* renamed from: bV */
        void mo22308bV(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$3 */
    class C107533 implements Runnable {
        C107533() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132894);
            if (AppBrandAuthorizeUI.this.ejZ != null && AppBrandAuthorizeUI.this.ejZ.isShowing()) {
                AppBrandAuthorizeUI.this.ejZ.dismiss();
            }
            AppMethodBeat.m2505o(132894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$1 */
    class C107551 implements OnMenuItemClickListener {
        C107551() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(132892);
            AppBrandAuthorizeUI.m18433a(AppBrandAuthorizeUI.this);
            AppBrandAuthorizeUI.this.finish();
            AppMethodBeat.m2505o(132892);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$2 */
    class C107562 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$2$1 */
        class C107571 implements OnCancelListener {
            C107571() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        C107562() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132893);
            if (AppBrandAuthorizeUI.this.ejZ == null) {
                AppBrandAuthorizeUI appBrandAuthorizeUI = AppBrandAuthorizeUI.this;
                Context context = AppBrandAuthorizeUI.this.mController.ylL;
                AppBrandAuthorizeUI.this.getString(C25738R.string.f9238tz);
                appBrandAuthorizeUI.ejZ = C30379h.m48427a(context, 3, AppBrandAuthorizeUI.this.getString(C25738R.string.f9318wh), false, new C107571());
            }
            AppBrandAuthorizeUI.this.ejZ.show();
            AppMethodBeat.m2505o(132893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$14 */
    class C1075814 implements C1224a {
        C1075814() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(132906);
            C4990ab.m7411d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                cwi cwi = (cwi) c7472b.fsH.fsP;
                if (cwi == null) {
                    AppBrandAuthorizeUI.m18442e(AppBrandAuthorizeUI.this);
                    C4990ab.m7412e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
                } else {
                    int i3 = cwi.xsa.errCode;
                    String str2 = cwi.xsa.aIm;
                    if (i3 == 0) {
                        AppBrandAuthorizeUI.this.iFC = cwi.xsb;
                        AppBrandAuthorizeUI.m18436a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.iFC);
                    } else {
                        AppBrandAuthorizeUI.m18442e(AppBrandAuthorizeUI.this);
                        C4990ab.m7413e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", str2);
                    }
                }
                AppMethodBeat.m2505o(132906);
            } else {
                AppBrandAuthorizeUI.m18442e(AppBrandAuthorizeUI.this);
                AppMethodBeat.m2505o(132906);
            }
            return 0;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppBrandAuthorizeUI() {
        AppMethodBeat.m2504i(132909);
        AppMethodBeat.m2505o(132909);
    }

    /* renamed from: e */
    static /* synthetic */ void m18442e(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.m2504i(132922);
        appBrandAuthorizeUI.m18443eD(true);
        AppMethodBeat.m2505o(132922);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8467g;
    }

    /* renamed from: a */
    public final boolean mo8453a(final C15541f c15541f, final Preference preference) {
        AppMethodBeat.m2504i(132911);
        C4990ab.m7411d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", preference.mKey);
        if (this.iFC == null) {
            C4990ab.m7420w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
            AppMethodBeat.m2505o(132911);
        } else {
            String str = preference.mKey;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.AppBrandAuthorizeUI", "key is null");
                AppMethodBeat.m2505o(132911);
            } else {
                for (final C35920fu c35920fu : this.iFC) {
                    if (str.equals(C5046bo.nullAsNil(c35920fu.scope))) {
                        this.iFF = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            c35920fu.state = 1;
                            m18432a(new C10750a() {
                                /* renamed from: bV */
                                public final void mo22308bV(boolean z) {
                                    AppMethodBeat.m2504i(132899);
                                    AppBrandAuthorizeUI.m18437a(AppBrandAuthorizeUI.this, z, true, preference, c15541f, c35920fu);
                                    AppMethodBeat.m2505o(132899);
                                }
                            });
                        } else if (this.iFG) {
                            this.iFG = false;
                            C5652a c5652a = new C5652a(this);
                            c5652a.asE(getString(C25738R.string.f8842gt));
                            c5652a.asJ(getString(C25738R.string.f8841gs));
                            c5652a.mo11457a(new OnClickListener() {

                                /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI$9$1 */
                                class C107611 implements C10750a {
                                    C107611() {
                                    }

                                    /* renamed from: bV */
                                    public final void mo22308bV(boolean z) {
                                        AppMethodBeat.m2504i(132900);
                                        AppBrandAuthorizeUI.m18437a(AppBrandAuthorizeUI.this, z, false, preference, c15541f, c35920fu);
                                        AppMethodBeat.m2505o(132900);
                                    }
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(132901);
                                    c35920fu.state = 2;
                                    AppBrandAuthorizeUI.m18434a(AppBrandAuthorizeUI.this, new C107611());
                                    C4990ab.m7410d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
                                    AppMethodBeat.m2505o(132901);
                                }
                            });
                            c5652a.asK(getString(C25738R.string.f9076or));
                            c5652a.mo11476b(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(132902);
                                    C4990ab.m7410d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
                                    c35920fu.state = 1;
                                    ((CheckBoxPreference) preference).uOT = true;
                                    c15541f.notifyDataSetChanged();
                                    AppMethodBeat.m2505o(132902);
                                }
                            });
                            c5652a.mo11478f(new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(132903);
                                    C4990ab.m7410d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
                                    c35920fu.state = 1;
                                    ((CheckBoxPreference) preference).uOT = true;
                                    c15541f.notifyDataSetChanged();
                                    AppMethodBeat.m2505o(132903);
                                }
                            });
                            C5653c aMb = c5652a.aMb();
                            aMb.setCanceledOnTouchOutside(false);
                            aMb.show();
                        } else {
                            c35920fu.state = 2;
                            m18432a(new C10750a() {
                                /* renamed from: bV */
                                public final void mo22308bV(boolean z) {
                                    AppMethodBeat.m2504i(132904);
                                    AppBrandAuthorizeUI.m18437a(AppBrandAuthorizeUI.this, z, false, preference, c15541f, c35920fu);
                                    AppMethodBeat.m2505o(132904);
                                }
                            });
                        }
                    }
                }
                AppMethodBeat.m2505o(132911);
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m18432a(final C10750a c10750a) {
        AppMethodBeat.m2504i(132912);
        if (C5023at.isConnected(C4996ah.getContext())) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(132905);
                    if (AppBrandAuthorizeUI.this.iFF) {
                        AppBrandAuthorizeUI.this.iFF = false;
                        AppBrandAuthorizeUI.m18435a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.mAppId, AppBrandAuthorizeUI.this.iFC, c10750a);
                    }
                    AppMethodBeat.m2505o(132905);
                }
            });
            AppMethodBeat.m2505o(132912);
            return;
        }
        C23639t.makeText(this, getString(C25738R.string.f9319wi), 1).show();
        if (c10750a != null) {
            c10750a.mo22308bV(false);
        }
        AppMethodBeat.m2505o(132912);
    }

    /* renamed from: eD */
    private void m18443eD(final boolean z) {
        AppMethodBeat.m2504i(132913);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132896);
                Preference preference = new Preference(AppBrandAuthorizeUI.this);
                preference.yDf = false;
                if (z) {
                    preference.setLayoutResource(2130968662);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(C25738R.string.f8843gu, new Object[]{AppBrandAuthorizeUI.this.iFD.nickname}));
                } else {
                    preference.setLayoutResource(2130968663);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(C25738R.string.f8844gv, new Object[]{AppBrandAuthorizeUI.this.iFD.nickname}));
                }
                AppBrandAuthorizeUI.this.iFE.mo27713b(preference);
                AppBrandAuthorizeUI.this.iFE.notifyDataSetChanged();
                AppMethodBeat.m2505o(132896);
            }
        });
        AppMethodBeat.m2505o(132913);
    }

    public void onPause() {
        AppMethodBeat.m2504i(132914);
        if (this.iFF) {
            C4990ab.m7410d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
        }
        super.onPause();
        AppMethodBeat.m2505o(132914);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(132915);
        C4990ab.m7410d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
        aMc();
        super.onBackPressed();
        AppMethodBeat.m2505o(132915);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(132916);
        super.onDestroy();
        AppMethodBeat.m2505o(132916);
    }

    private void aMc() {
        AppMethodBeat.m2504i(132917);
        if (this.iFH) {
            JSONArray jSONArray = new JSONArray();
            for (C35920fu c35920fu : this.iFC) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scope", c35920fu.scope);
                    jSONObject.put("state", c35920fu.state);
                    jSONObject.put("desc", c35920fu.vHE);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e, "", new Object[0]);
                }
            }
            C4990ab.m7411d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", jSONArray);
            Intent intent = new Intent();
            intent.putExtra("key_app_authorize_state", jSONArray.toString());
            setResult(-1, intent);
            AppMethodBeat.m2505o(132917);
            return;
        }
        AppMethodBeat.m2505o(132917);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(132910);
        this.yll = true;
        super.onCreate(bundle);
        setBackBtn(new C107551());
        setMMTitle((int) C25738R.string.f8850h2);
        mo17446xE(this.mController.dyj());
        this.iFE = this.yCw;
        String stringExtra = getIntent().getStringExtra("key_username");
        this.igi = stringExtra;
        if (C5046bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.m2505o(132910);
            return;
        }
        this.iFH = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
        this.iFD = C26842p.m42735zh(this.igi);
        if (this.iFD == null) {
            C4990ab.m7412e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
            AppMethodBeat.m2505o(132910);
            return;
        }
        this.mAppId = this.iFD.appId;
        stringExtra = this.mAppId;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cwh();
        c1196a.fsK = new cwi();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        c1196a.fsI = FaceManager.FACE_ACQUIRED_UP;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        cwh cwh = new cwh();
        cwh.appId = stringExtra;
        c1196a.fsJ = cwh;
        C1226w.m2655a(c1196a.acD(), new C1075814(), true);
        AppMethodBeat.m2505o(132910);
    }

    /* renamed from: a */
    static /* synthetic */ void m18437a(AppBrandAuthorizeUI appBrandAuthorizeUI, boolean z, boolean z2, Preference preference, C15541f c15541f, C35920fu c35920fu) {
        AppMethodBeat.m2504i(132919);
        final boolean z3 = z;
        final Preference preference2 = preference;
        final boolean z4 = z2;
        final C35920fu c35920fu2 = c35920fu;
        final C15541f c15541f2 = c15541f;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                int i = 1;
                AppMethodBeat.m2504i(132898);
                if (z3) {
                    ((CheckBoxPreference) preference2).uOT = z4;
                    c35920fu2.state = z4 ? 1 : 2;
                    c15541f2.notifyDataSetChanged();
                    AppMethodBeat.m2505o(132898);
                    return;
                }
                boolean z;
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference2;
                if (z4) {
                    z = false;
                } else {
                    z = true;
                }
                checkBoxPreference.uOT = z;
                C35920fu c35920fu = c35920fu2;
                if (z4) {
                    i = 2;
                }
                c35920fu.state = i;
                c15541f2.notifyDataSetChanged();
                AppMethodBeat.m2505o(132898);
            }
        });
        AppMethodBeat.m2505o(132919);
    }

    /* renamed from: a */
    static /* synthetic */ void m18435a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str, final List list, final C10750a c10750a) {
        AppMethodBeat.m2504i(132921);
        LinkedList linkedList = new LinkedList();
        for (C35920fu c35920fu : list) {
            bbm bbm = new bbm();
            bbm.qjG = c35920fu.scope;
            bbm.qjH = c35920fu.state;
            linkedList.add(bbm);
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cwr();
        c1196a.fsK = new cws();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp_modauth";
        c1196a.fsI = 1188;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        cwr cwr = new cwr();
        cwr.appId = str;
        cwr.xsn = linkedList;
        c1196a.fsJ = cwr;
        C5004al.m7441d(new C107562());
        C1226w.m2655a(c1196a.acD(), new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(132895);
                C4990ab.m7411d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    boolean z;
                    cws cws = (cws) c7472b.fsH.fsP;
                    if (cws == null) {
                        C4990ab.m7412e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
                        z = false;
                    } else {
                        int i3 = cws.xsa.errCode;
                        String str2 = cws.xsa.aIm;
                        if (i3 == 0) {
                            C4990ab.m7410d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
                            AppBrandAuthorizeUI.m18438b(AppBrandAuthorizeUI.this, list);
                            AppBrandAuthorizeUI.m18446h(AppBrandAuthorizeUI.this);
                            z = true;
                        } else {
                            C4990ab.m7413e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errCode %d  error %s", Integer.valueOf(i3), str2);
                            z = false;
                        }
                    }
                    AppBrandAuthorizeUI.m18445g(AppBrandAuthorizeUI.this);
                    if (c10750a != null) {
                        c10750a.mo22308bV(z);
                    }
                    AppMethodBeat.m2505o(132895);
                } else {
                    AppBrandAuthorizeUI.m18445g(AppBrandAuthorizeUI.this);
                    C23639t.makeText(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.getString(C25738R.string.f9319wi), 1).show();
                    if (c10750a != null) {
                        c10750a.mo22308bV(false);
                    }
                    AppMethodBeat.m2505o(132895);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.m2505o(132921);
    }

    /* renamed from: g */
    static /* synthetic */ void m18445g(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.m2504i(132924);
        C5004al.m7441d(new C107533());
        AppMethodBeat.m2505o(132924);
    }

    /* renamed from: b */
    static /* synthetic */ void m18438b(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        AppMethodBeat.m2504i(132925);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                C35920fu c35920fu = (C35920fu) list.get(i);
                if ("scope.subscribemsg".equals(c35920fu.scope)) {
                    boolean z = c35920fu.state == 2;
                    C45374tz c45374tz = new C45374tz();
                    c45374tz.cQf.csl = appBrandAuthorizeUI.igi;
                    C18404a c18404a = c45374tz.cQf;
                    if (z) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    c18404a.action = i;
                    c45374tz.cQf.cQh = 1;
                    C4879a.xxA.mo10055m(c45374tz);
                    C4990ab.m7417i("MicroMsg.AppBrandAuthorizeUI", "updateSubscribeMsgItem banMsg:%b", Boolean.valueOf(z));
                    AppMethodBeat.m2505o(132925);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(132925);
    }

    /* renamed from: h */
    static /* synthetic */ void m18446h(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.m2504i(132926);
        C10276d.m17931a(appBrandAuthorizeUI.mAppId, new AuthStateChangedByUserEvent());
        AppMethodBeat.m2505o(132926);
    }
}

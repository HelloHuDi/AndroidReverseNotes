package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.protocal.protobuf.cws;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandAuthorizeUI extends MMPreference {
    private p ejZ;
    List<fu> iFC = new ArrayList();
    private u iFD;
    protected f iFE;
    private boolean iFF = false;
    private boolean iFG = true;
    private boolean iFH = false;
    private b iFI = null;
    private String igi;
    private String mAppId;

    public static final class AuthStateChangedByUserEvent implements Parcelable {
        public static final Creator<AuthStateChangedByUserEvent> CREATOR = new Creator<AuthStateChangedByUserEvent>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AuthStateChangedByUserEvent[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132907);
                AuthStateChangedByUserEvent authStateChangedByUserEvent = new AuthStateChangedByUserEvent((byte) 0);
                AppMethodBeat.o(132907);
                return authStateChangedByUserEvent;
            }
        };

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
        }

        AuthStateChangedByUserEvent(byte b) {
        }

        static {
            AppMethodBeat.i(132908);
            AppMethodBeat.o(132908);
        }
    }

    interface a {
        void bV(boolean z);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandAuthorizeUI() {
        AppMethodBeat.i(132909);
        AppMethodBeat.o(132909);
    }

    static /* synthetic */ void e(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(132922);
        appBrandAuthorizeUI.eD(true);
        AppMethodBeat.o(132922);
    }

    public final int JC() {
        return R.xml.g;
    }

    public final boolean a(final f fVar, final Preference preference) {
        AppMethodBeat.i(132911);
        ab.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", preference.mKey);
        if (this.iFC == null) {
            ab.w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
            AppMethodBeat.o(132911);
        } else {
            String str = preference.mKey;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.AppBrandAuthorizeUI", "key is null");
                AppMethodBeat.o(132911);
            } else {
                for (final fu fuVar : this.iFC) {
                    if (str.equals(bo.nullAsNil(fuVar.scope))) {
                        this.iFF = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            fuVar.state = 1;
                            a(new a() {
                                public final void bV(boolean z) {
                                    AppMethodBeat.i(132899);
                                    AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, z, true, preference, fVar, fuVar);
                                    AppMethodBeat.o(132899);
                                }
                            });
                        } else if (this.iFG) {
                            this.iFG = false;
                            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                            aVar.asE(getString(R.string.gt));
                            aVar.asJ(getString(R.string.gs));
                            aVar.a(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(132901);
                                    fuVar.state = 2;
                                    AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, new a() {
                                        public final void bV(boolean z) {
                                            AppMethodBeat.i(132900);
                                            AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, z, false, preference, fVar, fuVar);
                                            AppMethodBeat.o(132900);
                                        }
                                    });
                                    ab.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
                                    AppMethodBeat.o(132901);
                                }
                            });
                            aVar.asK(getString(R.string.or));
                            aVar.b(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(132902);
                                    ab.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
                                    fuVar.state = 1;
                                    ((CheckBoxPreference) preference).uOT = true;
                                    fVar.notifyDataSetChanged();
                                    AppMethodBeat.o(132902);
                                }
                            });
                            aVar.f(new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(132903);
                                    ab.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
                                    fuVar.state = 1;
                                    ((CheckBoxPreference) preference).uOT = true;
                                    fVar.notifyDataSetChanged();
                                    AppMethodBeat.o(132903);
                                }
                            });
                            c aMb = aVar.aMb();
                            aMb.setCanceledOnTouchOutside(false);
                            aMb.show();
                        } else {
                            fuVar.state = 2;
                            a(new a() {
                                public final void bV(boolean z) {
                                    AppMethodBeat.i(132904);
                                    AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, z, false, preference, fVar, fuVar);
                                    AppMethodBeat.o(132904);
                                }
                            });
                        }
                    }
                }
                AppMethodBeat.o(132911);
            }
        }
        return false;
    }

    private void a(final a aVar) {
        AppMethodBeat.i(132912);
        if (at.isConnected(ah.getContext())) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132905);
                    if (AppBrandAuthorizeUI.this.iFF) {
                        AppBrandAuthorizeUI.this.iFF = false;
                        AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.mAppId, AppBrandAuthorizeUI.this.iFC, aVar);
                    }
                    AppMethodBeat.o(132905);
                }
            });
            AppMethodBeat.o(132912);
            return;
        }
        t.makeText(this, getString(R.string.wi), 1).show();
        if (aVar != null) {
            aVar.bV(false);
        }
        AppMethodBeat.o(132912);
    }

    private void eD(final boolean z) {
        AppMethodBeat.i(132913);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132896);
                Preference preference = new Preference(AppBrandAuthorizeUI.this);
                preference.yDf = false;
                if (z) {
                    preference.setLayoutResource(R.layout.bm);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(R.string.gu, new Object[]{AppBrandAuthorizeUI.this.iFD.nickname}));
                } else {
                    preference.setLayoutResource(R.layout.bn);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(R.string.gv, new Object[]{AppBrandAuthorizeUI.this.iFD.nickname}));
                }
                AppBrandAuthorizeUI.this.iFE.b(preference);
                AppBrandAuthorizeUI.this.iFE.notifyDataSetChanged();
                AppMethodBeat.o(132896);
            }
        });
        AppMethodBeat.o(132913);
    }

    public void onPause() {
        AppMethodBeat.i(132914);
        if (this.iFF) {
            ab.d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
        }
        super.onPause();
        AppMethodBeat.o(132914);
    }

    public void onBackPressed() {
        AppMethodBeat.i(132915);
        ab.d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
        aMc();
        super.onBackPressed();
        AppMethodBeat.o(132915);
    }

    public void onDestroy() {
        AppMethodBeat.i(132916);
        super.onDestroy();
        AppMethodBeat.o(132916);
    }

    private void aMc() {
        AppMethodBeat.i(132917);
        if (this.iFH) {
            JSONArray jSONArray = new JSONArray();
            for (fu fuVar : this.iFC) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scope", fuVar.scope);
                    jSONObject.put("state", fuVar.state);
                    jSONObject.put("desc", fuVar.vHE);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e, "", new Object[0]);
                }
            }
            ab.d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", jSONArray);
            Intent intent = new Intent();
            intent.putExtra("key_app_authorize_state", jSONArray.toString());
            setResult(-1, intent);
            AppMethodBeat.o(132917);
            return;
        }
        AppMethodBeat.o(132917);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(132910);
        this.yll = true;
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(132892);
                AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this);
                AppBrandAuthorizeUI.this.finish();
                AppMethodBeat.o(132892);
                return false;
            }
        });
        setMMTitle((int) R.string.h2);
        xE(this.mController.dyj());
        this.iFE = this.yCw;
        String stringExtra = getIntent().getStringExtra("key_username");
        this.igi = stringExtra;
        if (bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.o(132910);
            return;
        }
        this.iFH = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
        this.iFD = com.tencent.mm.plugin.appbrand.config.p.zh(this.igi);
        if (this.iFD == null) {
            ab.e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
            AppMethodBeat.o(132910);
            return;
        }
        this.mAppId = this.iFD.appId;
        stringExtra = this.mAppId;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new cwh();
        aVar.fsK = new cwi();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        aVar.fsI = FaceManager.FACE_ACQUIRED_UP;
        aVar.fsL = 0;
        aVar.fsM = 0;
        cwh cwh = new cwh();
        cwh.appId = stringExtra;
        aVar.fsJ = cwh;
        w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(132906);
                ab.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    cwi cwi = (cwi) bVar.fsH.fsP;
                    if (cwi == null) {
                        AppBrandAuthorizeUI.e(AppBrandAuthorizeUI.this);
                        ab.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
                    } else {
                        int i3 = cwi.xsa.errCode;
                        String str2 = cwi.xsa.aIm;
                        if (i3 == 0) {
                            AppBrandAuthorizeUI.this.iFC = cwi.xsb;
                            AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.iFC);
                        } else {
                            AppBrandAuthorizeUI.e(AppBrandAuthorizeUI.this);
                            ab.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", str2);
                        }
                    }
                    AppMethodBeat.o(132906);
                } else {
                    AppBrandAuthorizeUI.e(AppBrandAuthorizeUI.this);
                    AppMethodBeat.o(132906);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.o(132910);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, boolean z, boolean z2, Preference preference, f fVar, fu fuVar) {
        AppMethodBeat.i(132919);
        final boolean z3 = z;
        final Preference preference2 = preference;
        final boolean z4 = z2;
        final fu fuVar2 = fuVar;
        final f fVar2 = fVar;
        al.d(new Runnable() {
            public final void run() {
                int i = 1;
                AppMethodBeat.i(132898);
                if (z3) {
                    ((CheckBoxPreference) preference2).uOT = z4;
                    fuVar2.state = z4 ? 1 : 2;
                    fVar2.notifyDataSetChanged();
                    AppMethodBeat.o(132898);
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
                fu fuVar = fuVar2;
                if (z4) {
                    i = 2;
                }
                fuVar.state = i;
                fVar2.notifyDataSetChanged();
                AppMethodBeat.o(132898);
            }
        });
        AppMethodBeat.o(132919);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str, final List list, final a aVar) {
        AppMethodBeat.i(132921);
        LinkedList linkedList = new LinkedList();
        for (fu fuVar : list) {
            bbm bbm = new bbm();
            bbm.qjG = fuVar.scope;
            bbm.qjH = fuVar.state;
            linkedList.add(bbm);
        }
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new cwr();
        aVar2.fsK = new cws();
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp_modauth";
        aVar2.fsI = 1188;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        cwr cwr = new cwr();
        cwr.appId = str;
        cwr.xsn = linkedList;
        aVar2.fsJ = cwr;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132893);
                if (AppBrandAuthorizeUI.this.ejZ == null) {
                    AppBrandAuthorizeUI appBrandAuthorizeUI = AppBrandAuthorizeUI.this;
                    Context context = AppBrandAuthorizeUI.this.mController.ylL;
                    AppBrandAuthorizeUI.this.getString(R.string.tz);
                    appBrandAuthorizeUI.ejZ = h.a(context, 3, AppBrandAuthorizeUI.this.getString(R.string.wh), false, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                }
                AppBrandAuthorizeUI.this.ejZ.show();
                AppMethodBeat.o(132893);
            }
        });
        w.a(aVar2.acD(), new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(132895);
                ab.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    boolean z;
                    cws cws = (cws) bVar.fsH.fsP;
                    if (cws == null) {
                        ab.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
                        z = false;
                    } else {
                        int i3 = cws.xsa.errCode;
                        String str2 = cws.xsa.aIm;
                        if (i3 == 0) {
                            ab.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
                            AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this, list);
                            AppBrandAuthorizeUI.h(AppBrandAuthorizeUI.this);
                            z = true;
                        } else {
                            ab.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errCode %d  error %s", Integer.valueOf(i3), str2);
                            z = false;
                        }
                    }
                    AppBrandAuthorizeUI.g(AppBrandAuthorizeUI.this);
                    if (aVar != null) {
                        aVar.bV(z);
                    }
                    AppMethodBeat.o(132895);
                } else {
                    AppBrandAuthorizeUI.g(AppBrandAuthorizeUI.this);
                    t.makeText(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.getString(R.string.wi), 1).show();
                    if (aVar != null) {
                        aVar.bV(false);
                    }
                    AppMethodBeat.o(132895);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.o(132921);
    }

    static /* synthetic */ void g(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(132924);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132894);
                if (AppBrandAuthorizeUI.this.ejZ != null && AppBrandAuthorizeUI.this.ejZ.isShowing()) {
                    AppBrandAuthorizeUI.this.ejZ.dismiss();
                }
                AppMethodBeat.o(132894);
            }
        });
        AppMethodBeat.o(132924);
    }

    static /* synthetic */ void b(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        AppMethodBeat.i(132925);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                fu fuVar = (fu) list.get(i);
                if ("scope.subscribemsg".equals(fuVar.scope)) {
                    boolean z = fuVar.state == 2;
                    tz tzVar = new tz();
                    tzVar.cQf.csl = appBrandAuthorizeUI.igi;
                    com.tencent.mm.g.a.tz.a aVar = tzVar.cQf;
                    if (z) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    aVar.action = i;
                    tzVar.cQf.cQh = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(tzVar);
                    ab.i("MicroMsg.AppBrandAuthorizeUI", "updateSubscribeMsgItem banMsg:%b", Boolean.valueOf(z));
                    AppMethodBeat.o(132925);
                    return;
                }
            }
        }
        AppMethodBeat.o(132925);
    }

    static /* synthetic */ void h(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(132926);
        d.a(appBrandAuthorizeUI.mAppId, new AuthStateChangedByUserEvent());
        AppMethodBeat.o(132926);
    }
}

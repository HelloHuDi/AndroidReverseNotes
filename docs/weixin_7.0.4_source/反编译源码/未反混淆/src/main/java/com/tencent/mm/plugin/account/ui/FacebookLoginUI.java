package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.ui.f.a.e;
import org.json.JSONObject;

public class FacebookLoginUI extends MMPreference implements f {
    private static final String[] gAu = new String[]{"public_profile"};
    private String cOG = "";
    private d gAT;
    private String gAW = "";
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(124829);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(124829);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(124830);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(124830);
                return false;
            }
            ab.i("MicroMsg.FacebookLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(124830);
            return true;
        }
    };
    private OnCancelListener gAs;
    private com.tencent.mm.ui.f.a.c gBj;
    private p gBk;
    private q gBl;
    private ba gBm = new ba();
    private b gBn;
    boolean gBo = true;
    private String gsF;

    final class a implements com.tencent.mm.ui.f.a.c.a {
        private a() {
        }

        /* synthetic */ a(FacebookLoginUI facebookLoginUI, byte b) {
            this();
        }

        public final void p(Bundle bundle) {
            AppMethodBeat.i(124845);
            FacebookLoginUI.this.gAW = FacebookLoginUI.this.gBj.gqE;
            FacebookLoginUI.b(FacebookLoginUI.this);
            AppMethodBeat.o(124845);
        }

        public final void a(e eVar) {
            AppMethodBeat.i(124846);
            ab.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + eVar.getMessage());
            h.b(FacebookLoginUI.this, eVar.getMessage(), FacebookLoginUI.this.getString(R.string.bm2), true);
            FacebookLoginUI.aqR();
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            g.RN();
            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("L14")).append(",2").toString());
            com.tencent.mm.plugin.report.service.h.pYm.a(582, 7, 1, false);
            AppMethodBeat.o(124846);
        }

        public final void a(com.tencent.mm.ui.f.a.b bVar) {
            AppMethodBeat.i(124847);
            ab.d("MicroMsg.FacebookLoginUI", "onError:" + bVar.getMessage());
            h.b(FacebookLoginUI.this, bVar.getMessage(), FacebookLoginUI.this.getString(R.string.bm2), true);
            FacebookLoginUI.aqR();
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            g.RN();
            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("L14")).append(",2").toString());
            com.tencent.mm.plugin.report.service.h.pYm.a(582, 8, 1, false);
            AppMethodBeat.o(124847);
        }

        public final void onCancel() {
            AppMethodBeat.i(124848);
            ab.d("MicroMsg.FacebookLoginUI", "onCancel");
            FacebookLoginUI.aqR();
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            g.RN();
            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("L14")).append(",2").toString());
            com.tencent.mm.plugin.report.service.h.pYm.a(582, 9, 1, false);
            AppMethodBeat.o(124848);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FacebookLoginUI() {
        AppMethodBeat.i(124849);
        AppMethodBeat.o(124849);
    }

    static /* synthetic */ void b(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(124863);
        facebookLoginUI.aqO();
        AppMethodBeat.o(124863);
    }

    static /* synthetic */ void e(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(124864);
        facebookLoginUI.aqQ();
        AppMethodBeat.o(124864);
    }

    static /* synthetic */ void i(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(124866);
        facebookLoginUI.goBack();
        AppMethodBeat.o(124866);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124850);
        super.onCreate(bundle);
        setMMTitle((int) R.string.co3);
        com.tencent.mm.plugin.account.a.a.gkF.BV();
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        g.Rg().a(701, (f) this);
        g.Rg().a(252, (f) this);
        AppMethodBeat.o(124850);
    }

    public void onDestroy() {
        AppMethodBeat.i(124851);
        super.onDestroy();
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        AppMethodBeat.o(124851);
    }

    public void onResume() {
        AppMethodBeat.i(124852);
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L100_200_FB")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("L100_200_FB");
        AppMethodBeat.o(124852);
    }

    public void onPause() {
        AppMethodBeat.i(124853);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("L100_200_FB")).append(",2").toString());
        AppMethodBeat.o(124853);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(124854);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(124854);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(124854);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(124855);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        finish();
        AppMethodBeat.o(124855);
    }

    private void aqO() {
        AppMethodBeat.i(124856);
        getString(R.string.tz);
        this.gBk = h.b((Context) this, getString(R.string.cou), true, null);
        this.gBk.setOnCancelListener(this.gAs);
        ab.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", "facebook@wechat_auth", Integer.valueOf(this.gAW.length()), this.gAW.substring(0, 4));
        this.gBl = new q("facebook@wechat_auth", this.gAW, 0, "", "", "", 0, "", true, false);
        g.Rg().a(this.gBl, 0);
        AppMethodBeat.o(124856);
    }

    private void aqP() {
        AppMethodBeat.i(124857);
        if (com.tencent.mm.pluginsdk.model.app.q.u(this, "com.facebook.katana")) {
            if (this.gAT == null) {
                this.gAT = new d(getString(R.string.g7d));
                this.gAT.dJd();
            }
            if (this.gAT.dJc()) {
                aqO();
            } else {
                this.gAT.logout();
                this.gAT.a(this, new d.b() {
                    public final void onSuccess() {
                        AppMethodBeat.i(124833);
                        ab.i("MicroMsg.FacebookLoginUI", "facebook-android login success!");
                        FacebookLoginUI.this.gAW = FacebookLoginUI.this.gAT.zxJ.getToken();
                        FacebookLoginUI.b(FacebookLoginUI.this);
                        AppMethodBeat.o(124833);
                    }

                    public final void onCancel() {
                        AppMethodBeat.i(124834);
                        ab.i("MicroMsg.FacebookLoginUI", "facebook-android login cancel!");
                        AppMethodBeat.o(124834);
                    }

                    public final void onError(String str) {
                        AppMethodBeat.i(124835);
                        ab.i("MicroMsg.FacebookLoginUI", "facebook-android login error! %s", str);
                        h.b(FacebookLoginUI.this, FacebookLoginUI.this.getString(R.string.bm2), "", true);
                        AppMethodBeat.o(124835);
                    }
                }, gAu);
            }
        } else {
            try {
                if (this.gBj != null) {
                    this.gBj.ie(this);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "", new Object[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L14,");
            g.RN();
            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("L14")).append(",1").toString());
            this.gBj = new com.tencent.mm.ui.f.a.c(getString(R.string.g7d));
            this.gBj.a((Activity) this, gAu, new a(this, (byte) 0));
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(582, 5, 1, false);
        AppMethodBeat.o(124857);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124858);
        ab.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", Integer.valueOf(mVar.hashCode()), Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gBk != null) {
            this.gBk.dismiss();
            this.gBk = null;
        }
        if (!bo.cv(this)) {
            AppMethodBeat.o(124858);
        } else if (mVar instanceof q) {
            this.cOG = ((q) mVar).ajm();
            Object obj = null;
            if ((mVar.getType() == 252 || mVar.getType() == 701) && i == 4 && (i2 == -16 || i2 == -17)) {
                obj = 1;
                g.Rg().a(new bk(new com.tencent.mm.model.bk.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        AppMethodBeat.i(124842);
                        if (eVar == null) {
                            AppMethodBeat.o(124842);
                            return;
                        }
                        com.tencent.mm.network.c adg = eVar.adg();
                        byte[] bArr = new byte[0];
                        byte[] bArr2 = new byte[0];
                        byte[] bArr3 = new byte[0];
                        g.RN();
                        adg.a(bArr, bArr2, bArr3, com.tencent.mm.kernel.a.QF());
                        AppMethodBeat.o(124842);
                    }
                }), 0);
            }
            if (obj != null || (i == 0 && i2 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                l.apX();
                this.gBm.daR = 1;
                this.gBm.cVS = 12;
                this.gBm.ajK();
                z.vx(r.Yz());
                w.cm(this);
                z.showAddrBookUploadConfirm(this, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(124843);
                        Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(FacebookLoginUI.this);
                        bh.addFlags(67108864);
                        FacebookLoginUI.this.startActivity(bh);
                        StringBuilder stringBuilder = new StringBuilder();
                        g.RN();
                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
                        g.RN();
                        com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("L14")).append(",4").toString());
                        FacebookLoginUI.this.finish();
                        AppMethodBeat.o(124843);
                    }
                }, false, 2);
                AppMethodBeat.o(124858);
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                z.f(this, str, 0);
                AppMethodBeat.o(124858);
            } else if (i2 == -217) {
                z.a(this, com.tencent.mm.platformtools.e.a((q) mVar), i2);
                AppMethodBeat.o(124858);
            } else if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.gBn == null) {
                    this.gBn = new b() {
                        public final m a(m mVar, String str) {
                            AppMethodBeat.i(124844);
                            q qVar = new q("facebook@wechat_auth", FacebookLoginUI.this.gAW, ((q) mVar).getSecCodeType(), str, ((q) mVar).ajn(), ((q) mVar).ajp(), 0, "", true, false);
                            AppMethodBeat.o(124844);
                            return qVar;
                        }
                    };
                }
                b bVar = this.gBn;
                byte[] ajo = ((q) mVar).ajo();
                bVar.gAi = mVar;
                if (bVar.gue == null) {
                    bVar.gue = com.tencent.mm.ui.applet.SecurityImage.a.a(this, 0, ajo, "", "", new com.tencent.mm.plugin.account.ui.b.AnonymousClass1(this), null, new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            b.this.gue = null;
                        }
                    }, bVar);
                    AppMethodBeat.o(124858);
                    return;
                }
                bVar.gue.b(0, ajo, "", "");
                AppMethodBeat.o(124858);
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -107:
                            this.gBm.daR = 1;
                            this.gBm.cVS = 11;
                            this.gBm.ajK();
                            h.d(this, getString(R.string.bmm), "", getString(R.string.dmw), getString(R.string.cp8), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(124840);
                                    if (com.tencent.mm.protocal.d.vxr) {
                                        FacebookLoginUI.e(FacebookLoginUI.this);
                                        AppMethodBeat.o(124840);
                                        return;
                                    }
                                    FacebookLoginUI.f(FacebookLoginUI.this);
                                    AppMethodBeat.o(124840);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(124841);
                                    FacebookLoginUI.this.finish();
                                    AppMethodBeat.o(124841);
                                }
                            });
                            obj = 1;
                            break;
                        case -75:
                            z.cu(this.mController.ylL);
                            obj = 1;
                            break;
                        case -72:
                            h.g(this.mController.ylL, R.string.dmb, R.string.tz);
                            obj = 1;
                            break;
                        case -30:
                            if (com.tencent.mm.protocal.d.vxr) {
                                aqQ();
                            }
                            obj = 1;
                            break;
                        case -9:
                            h.g(this, R.string.cof, R.string.cog);
                            obj = 1;
                            break;
                        case -1:
                            if (g.Rg().acS() == 5) {
                                h.g(this, R.string.d5n, R.string.d5m);
                                obj = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            h.g(this, R.string.be9, R.string.cog);
                            obj = 1;
                            break;
                    }
                }
                if (com.tencent.mm.plugin.account.a.a.gkF.a(this.mController.ylL, i, i2, str)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppMethodBeat.o(124858);
                    return;
                }
                if (mVar.getType() == 252 || mVar.getType() == 701) {
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null && jY.a(this, null, null)) {
                        AppMethodBeat.o(124858);
                        return;
                    }
                }
                Toast.makeText(this, getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.o(124858);
            }
        } else {
            AppMethodBeat.o(124858);
        }
    }

    private void aqQ() {
        AppMethodBeat.i(124859);
        String string = getString(R.string.b3m, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.vxo), aa.dor()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        com.tencent.mm.plugin.account.a.a.gkE.i(intent, this);
        AppMethodBeat.o(124859);
    }

    public final void initView() {
        AppMethodBeat.i(124860);
        this.gBj = new com.tencent.mm.ui.f.a.c(getString(R.string.g7d));
        this.gAs = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(124831);
                if (FacebookLoginUI.this.gBl != null) {
                    g.Rg().c(FacebookLoginUI.this.gBl);
                }
                AppMethodBeat.o(124831);
            }
        };
        aqP();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124832);
                FacebookLoginUI.i(FacebookLoginUI.this);
                AppMethodBeat.o(124832);
                return true;
            }
        });
        AppMethodBeat.o(124860);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(124861);
        String str = "MicroMsg.FacebookLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
            if (!bo.isNullOrNil(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            ab.i(str2, str3, objArr2);
            if (intExtra == -217) {
                aqP();
                AppMethodBeat.o(124861);
                return;
            }
        }
        if (this.gBj != null) {
            this.gBj.h(i, i2, intent);
        }
        if (this.gAT != null) {
            this.gAT.h(i, i2, intent);
        }
        AppMethodBeat.o(124861);
    }

    public final int JC() {
        return R.xml.ar;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(124862);
        String str = preference.mKey;
        if (str == null) {
            ab.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            AppMethodBeat.o(124862);
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            aqP();
            AppMethodBeat.o(124862);
            return true;
        } else {
            AppMethodBeat.o(124862);
            return false;
        }
    }

    static /* synthetic */ void f(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(124865);
        if (com.tencent.mm.pluginsdk.model.app.q.u(facebookLoginUI, "com.facebook.katana")) {
            facebookLoginUI.gAT.a("name,picture.type(large)", new com.tencent.mm.ui.f.a.d.a() {
                public final void g(JSONObject jSONObject) {
                    AppMethodBeat.i(124836);
                    ab.i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture completed!");
                    if (jSONObject != null) {
                        try {
                            Intent intent = new Intent(FacebookLoginUI.this, RegByMobileRegAIOUI.class);
                            String str = null;
                            if (!(FacebookLoginUI.this.gAT.zxJ == null || FacebookLoginUI.this.gAT.zxJ.getToken() == null)) {
                                str = FacebookLoginUI.this.gAT.zxJ.getToken().toString();
                            }
                            intent.putExtra("third_app_token", str);
                            intent.putExtra("register_title", FacebookLoginUI.this.getString(R.string.b34));
                            if (jSONObject.has("name")) {
                                intent.putExtra("register_nick_name", jSONObject.getString("name"));
                                ab.i("MicroMsg.FacebookLoginUI", "name %s", jSONObject.getString("name"));
                            }
                            if (jSONObject.has("picture")) {
                                ab.i("MicroMsg.FacebookLoginUI", "picture %s", jSONObject.get("picture"));
                                intent.putExtra("register_avatar", ((JSONObject) jSONObject.get("picture")).getJSONObject("data").getString("url"));
                            }
                            FacebookLoginUI.this.startActivity(intent);
                            FacebookLoginUI.this.finish();
                            FacebookLoginUI.this.gBm.daR = 1;
                            FacebookLoginUI.this.gBm.cVS = 4;
                            FacebookLoginUI.this.gBm.ajK();
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "parse json error!", new Object[0]);
                            h.b(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                            AppMethodBeat.o(124836);
                            return;
                        }
                    }
                    AppMethodBeat.o(124836);
                }

                public final void onError(String str) {
                    AppMethodBeat.i(124837);
                    ab.i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture error! %s", str);
                    h.b(FacebookLoginUI.this, FacebookLoginUI.this.getString(R.string.bm2), "", true);
                    AppMethodBeat.o(124837);
                }
            });
            AppMethodBeat.o(124865);
            return;
        }
        g.RS().a(new com.tencent.mm.sdk.platformtools.al.a() {
            JSONObject gBq = null;

            public final boolean acf() {
                AppMethodBeat.i(124838);
                Bundle bundle = new Bundle();
                bundle.putString(GraphRequest.FIELDS_PARAM, "name,picture.type(large)");
                try {
                    ab.i("MicroMsg.FacebookLoginUI", "result json %s", FacebookLoginUI.this.gBj.q("me", bundle));
                    this.gBq = new JSONObject(r0);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "get name and picture error!", new Object[0]);
                    h.b(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                }
                AppMethodBeat.o(124838);
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.i(124839);
                if (this.gBq != null) {
                    try {
                        Intent intent = new Intent(FacebookLoginUI.this, RegByMobileRegAIOUI.class);
                        intent.putExtra("third_app_token", FacebookLoginUI.this.gBj.gqE.toString());
                        intent.putExtra("register_title", FacebookLoginUI.this.getString(R.string.b34));
                        intent.putExtra("register_nick_name", this.gBq.getString("name"));
                        intent.putExtra("register_avatar", ((JSONObject) this.gBq.get("picture")).getJSONObject("data").getString("url"));
                        FacebookLoginUI.this.startActivity(intent);
                        FacebookLoginUI.this.gBm.daR = 1;
                        FacebookLoginUI.this.gBm.cVS = 4;
                        FacebookLoginUI.this.gBm.ajK();
                        FacebookLoginUI.this.finish();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "parse json error!", new Object[0]);
                        h.b(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                    }
                }
                AppMethodBeat.o(124839);
                return true;
            }
        });
        AppMethodBeat.o(124865);
    }

    static /* synthetic */ void aqR() {
        AppMethodBeat.i(124867);
        g.RP().eJH.set(20, Integer.valueOf(bo.a((Integer) g.RP().eJH.get(20), 0) + 1));
        AppMethodBeat.o(124867);
    }
}

package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.ui.f.a.e;
import java.util.ArrayList;
import org.json.JSONObject;

@a(3)
public class WelcomeActivity extends MMFragmentActivity {
    private static final String[] gAu = new String[]{"public_profile"};
    private d gAT;
    private c gBj;
    private ba gBm = new ba();
    private WelcomeSelectView gIt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WelcomeActivity() {
        AppMethodBeat.i(125650);
        AppMethodBeat.o(125650);
    }

    static /* synthetic */ void f(WelcomeActivity welcomeActivity) {
        AppMethodBeat.i(125659);
        welcomeActivity.arM();
        AppMethodBeat.o(125659);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125651);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.gIt = new WelcomeSelectView(this);
        setContentView((View) this.gIt);
        this.gIt.arN();
        this.gIt.gIx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125633);
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                intent.putExtra("from_login_history", true);
                com.tencent.mm.plugin.account.a.a.gkE.o(intent, WelcomeActivity.this);
                AppMethodBeat.o(125633);
            }
        });
        this.gIt.gIv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125641);
                Intent intent = new Intent(WelcomeActivity.this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                WelcomeActivity.this.startActivity(intent);
                AppMethodBeat.o(125641);
            }
        });
        final ArrayList arrayList = new ArrayList();
        m mVar = new m(this, 1001, 0);
        mVar.setTitle((int) R.string.dkp);
        arrayList.add(mVar);
        mVar = new m(this, 1002, 0);
        if (b.ahL()) {
            mVar.setTitle((int) R.string.dkn);
            arrayList.add(mVar);
        }
        if (arrayList.size() > 1) {
            final com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 1, false);
            dVar.rBl = new n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(125642);
                    if (lVar.dzR()) {
                        for (m i : arrayList) {
                            lVar.i(i);
                        }
                    }
                    AppMethodBeat.o(125642);
                }
            };
            dVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(125643);
                    switch (menuItem.getItemId()) {
                        case 1001:
                            WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class));
                            AppMethodBeat.o(125643);
                            return;
                        case 1002:
                            WelcomeActivity.this.gBm.daR = 1;
                            WelcomeActivity.this.gBm.cVS = 2;
                            WelcomeActivity.this.gBm.ajK();
                            WelcomeActivity.b(WelcomeActivity.this);
                            break;
                    }
                    AppMethodBeat.o(125643);
                }
            };
            dVar.zQf = new com.tencent.mm.ui.widget.a.d.a() {
                public final void onDismiss() {
                }
            };
            this.gIt.gIw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125644);
                    if (com.tencent.mm.protocal.d.vxr) {
                        WelcomeActivity.c(WelcomeActivity.this);
                        AppMethodBeat.o(125644);
                        return;
                    }
                    dVar.cpD();
                    if (arrayList.contains(mVar)) {
                        WelcomeActivity.this.gBm.daR = 1;
                        WelcomeActivity.this.gBm.cVS = 1;
                        WelcomeActivity.this.gBm.ajK();
                    }
                    AppMethodBeat.o(125644);
                }
            });
            AppMethodBeat.o(125651);
            return;
        }
        this.gIt.gIw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125645);
                if (com.tencent.mm.protocal.d.vxr) {
                    WelcomeActivity.c(WelcomeActivity.this);
                    AppMethodBeat.o(125645);
                    return;
                }
                WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class));
                AppMethodBeat.o(125645);
            }
        });
        AppMethodBeat.o(125651);
    }

    public void onResume() {
        AppMethodBeat.i(125652);
        super.onResume();
        this.gIt.init();
        AppMethodBeat.o(125652);
    }

    private void arM() {
        AppMethodBeat.i(125653);
        if (q.u(this, "com.facebook.katana")) {
            this.gAT.a("name,picture.type(large)", new d.a() {
                public final void g(JSONObject jSONObject) {
                    AppMethodBeat.i(125646);
                    ab.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture completed!");
                    if (jSONObject != null) {
                        try {
                            Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                            String str = null;
                            if (!(WelcomeActivity.this.gAT.zxJ == null || WelcomeActivity.this.gAT.zxJ.getToken() == null)) {
                                str = WelcomeActivity.this.gAT.zxJ.getToken().toString();
                            }
                            intent.putExtra("third_app_token", str);
                            intent.putExtra("reg_3d_app_type", 1);
                            intent.putExtra("register_title", WelcomeActivity.this.getString(R.string.b34));
                            if (jSONObject.has("name")) {
                                intent.putExtra("register_nick_name", jSONObject.getString("name"));
                                ab.i("MicroMsg.WelcomeActivity", "name %s", jSONObject.getString("name"));
                            }
                            if (jSONObject.has("picture")) {
                                ab.i("MicroMsg.WelcomeActivity", "picture %s", jSONObject.get("picture"));
                                intent.putExtra("register_avatar", ((JSONObject) jSONObject.get("picture")).getJSONObject("data").getString("url"));
                            }
                            WelcomeActivity.this.startActivity(intent);
                            WelcomeActivity.this.gBm.daR = 1;
                            WelcomeActivity.this.gBm.cVS = 3;
                            WelcomeActivity.this.gBm.ajK();
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.WelcomeActivity", e, "parse json error!", new Object[0]);
                            h.b(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                            AppMethodBeat.o(125646);
                            return;
                        }
                    }
                    AppMethodBeat.o(125646);
                }

                public final void onError(String str) {
                    AppMethodBeat.i(125647);
                    ab.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture error! %s", str);
                    h.b(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.bm2), "", true);
                    AppMethodBeat.o(125647);
                }
            });
            AppMethodBeat.o(125653);
            return;
        }
        g.RS().a(new al.a() {
            JSONObject gBq = null;

            public final boolean acf() {
                AppMethodBeat.i(125648);
                Bundle bundle = new Bundle();
                bundle.putString(GraphRequest.FIELDS_PARAM, "name,picture.type(large)");
                try {
                    ab.i("MicroMsg.WelcomeActivity", "result json %s", WelcomeActivity.this.gBj.q("me", bundle));
                    this.gBq = new JSONObject(r0);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WelcomeActivity", e, "get name and picture error!", new Object[0]);
                    h.b(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                }
                AppMethodBeat.o(125648);
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.i(125649);
                if (this.gBq != null) {
                    try {
                        Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                        intent.putExtra("third_app_token", WelcomeActivity.this.gBj.gqE.toString());
                        intent.putExtra("reg_3d_app_type", 1);
                        intent.putExtra("register_title", WelcomeActivity.this.getString(R.string.b34));
                        intent.putExtra("register_nick_name", this.gBq.getString("name"));
                        intent.putExtra("register_avatar", ((JSONObject) this.gBq.get("picture")).getJSONObject("data").getString("url"));
                        WelcomeActivity.this.startActivity(intent);
                        WelcomeActivity.this.gBm.daR = 1;
                        WelcomeActivity.this.gBm.cVS = 3;
                        WelcomeActivity.this.gBm.ajK();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.WelcomeActivity", e, "parse json error!", new Object[0]);
                        h.b(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                    }
                }
                AppMethodBeat.o(125649);
                return true;
            }
        });
        AppMethodBeat.o(125653);
    }

    public void onDestroy() {
        AppMethodBeat.i(125654);
        super.onDestroy();
        this.gBm.ajK();
        if (this.gAT != null) {
            this.gAT.logout();
        }
        AppMethodBeat.o(125654);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125655);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            com.tencent.mm.ui.base.b.hM(this);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125655);
        return onKeyDown;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(125656);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.WelcomeActivity";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.gAT != null) {
            this.gAT.h(i, i2, intent);
        }
        AppMethodBeat.o(125656);
    }

    static /* synthetic */ void b(WelcomeActivity welcomeActivity) {
        AppMethodBeat.i(125657);
        if (q.u(welcomeActivity, "com.facebook.katana")) {
            if (welcomeActivity.gAT == null) {
                welcomeActivity.gAT = new d(welcomeActivity.getString(R.string.g7d));
                welcomeActivity.gAT.dJd();
            }
            if (welcomeActivity.gAT.dJc()) {
                welcomeActivity.arM();
                AppMethodBeat.o(125657);
                return;
            }
            welcomeActivity.gAT.logout();
            welcomeActivity.gAT.a(welcomeActivity, new d.b() {
                public final void onSuccess() {
                    AppMethodBeat.i(125634);
                    ab.i("MicroMsg.WelcomeActivity", "facebook-android login success!");
                    WelcomeActivity.f(WelcomeActivity.this);
                    AppMethodBeat.o(125634);
                }

                public final void onCancel() {
                    AppMethodBeat.i(125635);
                    ab.i("MicroMsg.WelcomeActivity", "facebook-android login cancel!");
                    AppMethodBeat.o(125635);
                }

                public final void onError(String str) {
                    AppMethodBeat.i(125636);
                    ab.i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", str);
                    h.b(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.bm2), "", true);
                    AppMethodBeat.o(125636);
                }
            }, gAu);
            AppMethodBeat.o(125657);
            return;
        }
        welcomeActivity.gBj = new c(welcomeActivity.getString(R.string.g7d));
        welcomeActivity.gBj.a((Activity) welcomeActivity, gAu, new c.a() {
            public final void p(Bundle bundle) {
                AppMethodBeat.i(125637);
                ab.i("MicroMsg.WelcomeActivity", "facebook login success");
                WelcomeActivity.f(WelcomeActivity.this);
                AppMethodBeat.o(125637);
            }

            public final void a(e eVar) {
                AppMethodBeat.i(125638);
                ab.i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", eVar.getMessage());
                h.b(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.bm2), "", true);
                AppMethodBeat.o(125638);
            }

            public final void a(com.tencent.mm.ui.f.a.b bVar) {
                AppMethodBeat.i(125639);
                ab.i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", bVar.getMessage());
                h.b(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.bm2), "", true);
                AppMethodBeat.o(125639);
            }

            public final void onCancel() {
                AppMethodBeat.i(125640);
                ab.i("MicroMsg.WelcomeActivity", "facebook login cancel");
                AppMethodBeat.o(125640);
            }
        });
        AppMethodBeat.o(125657);
    }

    static /* synthetic */ void c(WelcomeActivity welcomeActivity) {
        AppMethodBeat.i(125658);
        String string = welcomeActivity.getString(R.string.b3m, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.vxo), aa.dor()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        com.tencent.mm.plugin.account.a.a.gkE.i(intent, welcomeActivity);
        AppMethodBeat.o(125658);
    }
}

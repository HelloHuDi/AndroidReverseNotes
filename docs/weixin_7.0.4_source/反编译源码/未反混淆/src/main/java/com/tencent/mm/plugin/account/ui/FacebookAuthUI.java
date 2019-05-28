package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.ui.f.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FacebookAuthUI extends MMPreference implements f {
    private static final String[] gAu = new String[]{"public_profile"};
    private com.tencent.mm.ui.base.preference.f ehK;
    private d gAT;
    private boolean gAU = false;
    private boolean gAV = false;
    private String gAW = "";
    private final Map<String, Preference> gAX = new HashMap();
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(124775);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(124775);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(124776);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(124776);
                return false;
            }
            ab.i("MicroMsg.FacebookAuthUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(124776);
            return true;
        }
    };
    private ProgressDialog gAr;
    private OnCancelListener gAs;
    private v gAt;
    private com.tencent.mm.ui.f.a.c gyN;

    final class a implements com.tencent.mm.ui.f.a.c.a {
        private a() {
        }

        /* synthetic */ a(FacebookAuthUI facebookAuthUI, byte b) {
            this();
        }

        public final void p(Bundle bundle) {
            AppMethodBeat.i(124783);
            FacebookAuthUI.this.gAW = FacebookAuthUI.this.gyN.gqE;
            g.RP().Ry().set(65830, FacebookAuthUI.this.gAW);
            if (FacebookAuthUI.this.gyN.zxC != 0) {
                g.RP().Ry().set(65832, Long.valueOf(FacebookAuthUI.this.gyN.zxC));
            }
            FacebookAuthUI.d(FacebookAuthUI.this);
            AppMethodBeat.o(124783);
        }

        public final void a(e eVar) {
            AppMethodBeat.i(124784);
            ab.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + eVar.zxP);
            h.b(FacebookAuthUI.this, eVar.getMessage(), FacebookAuthUI.this.getString(R.string.avy), true);
            FacebookAuthUI.aqN();
            com.tencent.mm.plugin.report.service.h.pYm.a(582, 2, 1, false);
            AppMethodBeat.o(124784);
        }

        public final void a(com.tencent.mm.ui.f.a.b bVar) {
            AppMethodBeat.i(124785);
            ab.d("MicroMsg.FacebookAuthUI", "onError:" + bVar.getMessage());
            h.b(FacebookAuthUI.this, bVar.getMessage(), FacebookAuthUI.this.getString(R.string.avy), true);
            FacebookAuthUI.aqN();
            com.tencent.mm.plugin.report.service.h.pYm.a(582, 3, 1, false);
            AppMethodBeat.o(124785);
        }

        public final void onCancel() {
            AppMethodBeat.i(124786);
            ab.d("MicroMsg.FacebookAuthUI", "onCancel");
            FacebookAuthUI.aqN();
            com.tencent.mm.plugin.report.service.h.pYm.a(582, 4, 1, false);
            AppMethodBeat.o(124786);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FacebookAuthUI() {
        AppMethodBeat.i(124787);
        AppMethodBeat.o(124787);
    }

    static /* synthetic */ void aqN() {
        AppMethodBeat.i(124800);
        dp(false);
        AppMethodBeat.o(124800);
    }

    static /* synthetic */ void d(FacebookAuthUI facebookAuthUI) {
        AppMethodBeat.i(124799);
        facebookAuthUI.aqL();
        AppMethodBeat.o(124799);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124788);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.o(124788);
    }

    public void onResume() {
        AppMethodBeat.i(124789);
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        super.onResume();
        g.Rg().a(183, (f) this);
        g.Rg().a((int) com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        aqM();
        AppMethodBeat.o(124789);
    }

    public void onPause() {
        AppMethodBeat.i(124790);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        g.Rg().b(183, (f) this);
        g.Rg().b((int) com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        AppMethodBeat.o(124790);
    }

    public final int JC() {
        return R.xml.aq;
    }

    public final void initView() {
        AppMethodBeat.i(124791);
        this.gAU = getIntent().getBooleanExtra("is_force_unbind", false);
        this.gAs = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(124777);
                if (FacebookAuthUI.this.gAt != null) {
                    g.Rg().c(FacebookAuthUI.this.gAt);
                }
                AppMethodBeat.o(124777);
            }
        };
        setMMTitle((int) R.string.a5x);
        this.ehK.addPreferencesFromResource(R.xml.aq);
        Preference aqO = this.ehK.aqO("facebook_auth_tip");
        if (aqO != null) {
            this.gAX.put("facebook_auth_tip", aqO);
        }
        aqO = this.ehK.aqO("facebook_auth_cat");
        if (aqO != null) {
            this.gAX.put("facebook_auth_cat", aqO);
        }
        aqO = this.ehK.aqO("facebook_auth_bind_btn");
        if (aqO != null) {
            this.gAX.put("facebook_auth_bind_btn", aqO);
        }
        aqO = this.ehK.aqO("facebook_auth_account");
        if (aqO != null) {
            this.gAX.put("facebook_auth_account", aqO);
        }
        aqO = this.ehK.aqO("facebook_auth_cat2");
        if (aqO != null) {
            this.gAX.put("facebook_auth_cat2", aqO);
        }
        aqO = this.ehK.aqO("facebook_auth_unbind_btn");
        if (aqO != null) {
            this.gAX.put("facebook_auth_unbind_btn", aqO);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124778);
                Intent intent = FacebookAuthUI.this.getIntent();
                intent.putExtra("bind_facebook_succ", FacebookAuthUI.this.gAV);
                FacebookAuthUI.this.setResult(-1, intent);
                FacebookAuthUI.this.finish();
                AppMethodBeat.o(124778);
                return true;
            }
        });
        AppMethodBeat.o(124791);
    }

    private void aqL() {
        AppMethodBeat.i(124793);
        this.gAr = ProgressDialog.show(this, getString(R.string.tz), getString(R.string.bm0), true);
        this.gAr.setOnCancelListener(this.gAs);
        this.gAt = new v(1, this.gAW);
        g.Rg().a(this.gAt, 0);
        dp(true);
        com.tencent.mm.plugin.report.service.h.pYm.a(582, 1, 1, false);
        AppMethodBeat.o(124793);
    }

    private void aqM() {
        Preference preference;
        AppMethodBeat.i(124794);
        this.ehK.removeAll();
        boolean Za = this.gAU ? false : r.Za();
        if (this.gAX.containsKey("facebook_auth_tip")) {
            preference = (Preference) this.gAX.get("facebook_auth_tip");
            preference.setTitle(Za ? R.string.bm9 : R.string.blz);
            this.ehK.b(preference);
        }
        if (this.gAX.containsKey("facebook_auth_cat")) {
            this.ehK.b((Preference) this.gAX.get("facebook_auth_cat"));
        }
        if (Za) {
            if (this.gAX.containsKey("facebook_auth_account")) {
                preference = (Preference) this.gAX.get("facebook_auth_account");
                preference.setTitle(getString(R.string.bm1) + g.RP().Ry().get(65826, null));
                this.ehK.b(preference);
            }
            if (this.gAX.containsKey("facebook_auth_cat2")) {
                this.ehK.b((Preference) this.gAX.get("facebook_auth_cat2"));
            }
            if (this.gAX.containsKey("facebook_auth_unbind_btn")) {
                this.ehK.b((Preference) this.gAX.get("facebook_auth_unbind_btn"));
            }
        } else if (this.gAX.containsKey("facebook_auth_bind_btn")) {
            this.ehK.b((Preference) this.gAX.get("facebook_auth_bind_btn"));
            AppMethodBeat.o(124794);
            return;
        }
        AppMethodBeat.o(124794);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(124795);
        String str = "MicroMsg.FacebookAuthUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookAuthUI";
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
                aqL();
                AppMethodBeat.o(124795);
                return;
            }
        }
        if (this.gyN != null) {
            this.gyN.h(i, i2, intent);
        }
        if (this.gAT != null) {
            this.gAT.h(i, i2, intent);
        }
        AppMethodBeat.o(124795);
    }

    private static void dp(boolean z) {
        AppMethodBeat.i(124796);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.az.h.a(32, z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.az.h(arrayList));
        AppMethodBeat.o(124796);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124797);
        com.tencent.mm.h.a jY;
        if (mVar.getType() != com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (mVar.getType() == 183) {
                if (this.gAr != null) {
                    this.gAr.dismiss();
                }
                int i3 = ((v) mVar).opType;
                if (i == 0 && i2 == 0) {
                    Toast.makeText(this, i3 == 0 ? R.string.aw4 : R.string.avz, 1).show();
                    this.gAU = false;
                    aqM();
                    if (i3 == 1) {
                        ((j) g.K(j.class)).XR().aoX("facebookapp");
                        ((j) g.K(j.class)).bOr().Rh("facebookapp");
                        this.gAV = true;
                    }
                    AppMethodBeat.o(124797);
                    return;
                } else if (i == 4 && i2 == -67) {
                    Toast.makeText(this, R.string.bm3, 1).show();
                    AppMethodBeat.o(124797);
                    return;
                } else if (i == 4 && i2 == -5) {
                    Toast.makeText(this, i3 == 1 ? R.string.blx : R.string.bm6, 1).show();
                    AppMethodBeat.o(124797);
                    return;
                } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                    z.f(this, str, 0);
                    AppMethodBeat.o(124797);
                    return;
                } else {
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, null, null);
                        AppMethodBeat.o(124797);
                        return;
                    }
                    Toast.makeText(this, i3 == 0 ? R.string.aw3 : R.string.avy, 1).show();
                }
            }
            AppMethodBeat.o(124797);
        } else if (i == 0 && i2 == 0) {
            this.gAt = new v(0, "");
            g.Rg().a(this.gAt, 0);
            AppMethodBeat.o(124797);
        } else {
            if (this.gAr != null) {
                this.gAr.dismiss();
            }
            if (i2 == -82) {
                h.a((Context) this, (int) R.string.e4r, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(124797);
            } else if (i2 == -83) {
                h.a((Context) this, (int) R.string.e4o, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(124797);
            } else if (i2 == -84) {
                h.a((Context) this, (int) R.string.e4p, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(124797);
            } else if (i2 == -85) {
                h.a((Context) this, (int) R.string.e4n, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(124797);
            } else if (i2 == -86) {
                h.a((Context) this, (int) R.string.e4t, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(124797);
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                z.f(this, str, 0);
                AppMethodBeat.o(124797);
            } else if (i2 == -217) {
                z.a(this, com.tencent.mm.platformtools.e.a((q) mVar), i2);
                AppMethodBeat.o(124797);
            } else {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this, null, null);
                    AppMethodBeat.o(124797);
                    return;
                }
                AppMethodBeat.o(124797);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(124798);
        if (i == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.gAV);
            setResult(-1, intent);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(124798);
        return onKeyDown;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(124792);
        String str = preference.mKey;
        if (str == null) {
            ab.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            AppMethodBeat.o(124792);
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            if (com.tencent.mm.pluginsdk.model.app.q.u(this, "com.facebook.katana")) {
                if (this.gAT == null) {
                    this.gAT = new d(getString(R.string.g7d));
                    this.gAT.dJd();
                }
                if (this.gAT.dJc()) {
                    aqL();
                } else {
                    this.gAT.logout();
                    this.gAT.a(this, new d.b() {
                        public final void onSuccess() {
                            AppMethodBeat.i(124779);
                            ab.i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
                            FacebookAuthUI.this.gAW = FacebookAuthUI.this.gAT.zxJ.getToken();
                            FacebookAuthUI.d(FacebookAuthUI.this);
                            AppMethodBeat.o(124779);
                        }

                        public final void onCancel() {
                            AppMethodBeat.i(124780);
                            ab.i("MicroMsg.FacebookAuthUI", "facebook-android login cancel!");
                            AppMethodBeat.o(124780);
                        }

                        public final void onError(String str) {
                            AppMethodBeat.i(124781);
                            ab.i("MicroMsg.FacebookAuthUI", "facebook-android login error! %s", str);
                            h.b(FacebookAuthUI.this, FacebookAuthUI.this.getString(R.string.bm2), "", true);
                            AppMethodBeat.o(124781);
                        }
                    }, gAu);
                }
            } else {
                try {
                    this.gyN.ie(this);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
                }
                this.gyN = new com.tencent.mm.ui.f.a.c(getString(R.string.g7d));
                this.gyN.a((Activity) this, gAu, new a(this, (byte) 0));
            }
            AppMethodBeat.o(124792);
            return true;
        } else if (str.equals("facebook_auth_unbind_btn")) {
            h.a((Context) this, (int) R.string.bm7, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(124782);
                    FacebookAuthUI.this.gAr = ProgressDialog.show(FacebookAuthUI.this, FacebookAuthUI.this.getString(R.string.tz), FacebookAuthUI.this.getString(R.string.bm_), true);
                    FacebookAuthUI.this.gAr.setOnCancelListener(FacebookAuthUI.this.gAs);
                    g.Rg().a(new y(y.gvX), 0);
                    AppMethodBeat.o(124782);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(124792);
            return true;
        } else {
            AppMethodBeat.o(124792);
            return false;
        }
    }
}

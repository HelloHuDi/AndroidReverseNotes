package com.tencent.p177mm.plugin.account.p275ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.p629f.p630a.C15885b;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d.C15886b;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c.C30705a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30706e;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.friend.p272a.C32967v;
import com.tencent.p177mm.plugin.account.friend.p272a.C32970y;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI */
public class FacebookAuthUI extends MMPreference implements C1202f {
    private static final String[] gAu = new String[]{"public_profile"};
    private C15541f ehK;
    private C15887d gAT;
    private boolean gAU = false;
    private boolean gAV = false;
    private String gAW = "";
    private final Map<String, Preference> gAX = new HashMap();
    private C4884c gAY = new C380491();
    private ProgressDialog gAr;
    private OnCancelListener gAs;
    private C32967v gAt;
    private C30704c gyN;

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$2 */
    class C188692 implements OnClickListener {
        C188692() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$4 */
    class C188704 implements OnCancelListener {
        C188704() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(124777);
            if (FacebookAuthUI.this.gAt != null) {
                C1720g.m3540Rg().mo14547c(FacebookAuthUI.this.gAt);
            }
            AppMethodBeat.m2505o(124777);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$5 */
    class C266125 implements OnMenuItemClickListener {
        C266125() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124778);
            Intent intent = FacebookAuthUI.this.getIntent();
            intent.putExtra("bind_facebook_succ", FacebookAuthUI.this.gAV);
            FacebookAuthUI.this.setResult(-1, intent);
            FacebookAuthUI.this.finish();
            AppMethodBeat.m2505o(124778);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$a */
    final class C26613a implements C30705a {
        private C26613a() {
        }

        /* synthetic */ C26613a(FacebookAuthUI facebookAuthUI, byte b) {
            this();
        }

        /* renamed from: p */
        public final void mo5794p(Bundle bundle) {
            AppMethodBeat.m2504i(124783);
            FacebookAuthUI.this.gAW = FacebookAuthUI.this.gyN.gqE;
            C1720g.m3536RP().mo5239Ry().set(65830, FacebookAuthUI.this.gAW);
            if (FacebookAuthUI.this.gyN.zxC != 0) {
                C1720g.m3536RP().mo5239Ry().set(65832, Long.valueOf(FacebookAuthUI.this.gyN.zxC));
            }
            FacebookAuthUI.m64380d(FacebookAuthUI.this);
            AppMethodBeat.m2505o(124783);
        }

        /* renamed from: a */
        public final void mo5792a(C30706e c30706e) {
            AppMethodBeat.m2504i(124784);
            C4990ab.m7410d("MicroMsg.FacebookAuthUI", "onFacebookError:" + c30706e.zxP);
            C30379h.m48461b(FacebookAuthUI.this, c30706e.getMessage(), FacebookAuthUI.this.getString(C25738R.string.avy), true);
            FacebookAuthUI.aqN();
            C7060h.pYm.mo8378a(582, 2, 1, false);
            AppMethodBeat.m2505o(124784);
        }

        /* renamed from: a */
        public final void mo5791a(C15885b c15885b) {
            AppMethodBeat.m2504i(124785);
            C4990ab.m7410d("MicroMsg.FacebookAuthUI", "onError:" + c15885b.getMessage());
            C30379h.m48461b(FacebookAuthUI.this, c15885b.getMessage(), FacebookAuthUI.this.getString(C25738R.string.avy), true);
            FacebookAuthUI.aqN();
            C7060h.pYm.mo8378a(582, 3, 1, false);
            AppMethodBeat.m2505o(124785);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(124786);
            C4990ab.m7410d("MicroMsg.FacebookAuthUI", "onCancel");
            FacebookAuthUI.aqN();
            C7060h.pYm.mo8378a(582, 4, 1, false);
            AppMethodBeat.m2505o(124786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$3 */
    class C329863 implements OnClickListener {
        C329863() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$10 */
    class C3804410 implements OnClickListener {
        C3804410() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$6 */
    class C380456 implements C15886b {
        C380456() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(124779);
            C4990ab.m7416i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
            FacebookAuthUI.this.gAW = FacebookAuthUI.this.gAT.zxJ.getToken();
            FacebookAuthUI.m64380d(FacebookAuthUI.this);
            AppMethodBeat.m2505o(124779);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(124780);
            C4990ab.m7416i("MicroMsg.FacebookAuthUI", "facebook-android login cancel!");
            AppMethodBeat.m2505o(124780);
        }

        public final void onError(String str) {
            AppMethodBeat.m2504i(124781);
            C4990ab.m7417i("MicroMsg.FacebookAuthUI", "facebook-android login error! %s", str);
            C30379h.m48461b(FacebookAuthUI.this, FacebookAuthUI.this.getString(C25738R.string.bm2), "", true);
            AppMethodBeat.m2505o(124781);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$7 */
    class C380467 implements OnClickListener {
        C380467() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124782);
            FacebookAuthUI.this.gAr = ProgressDialog.show(FacebookAuthUI.this, FacebookAuthUI.this.getString(C25738R.string.f9238tz), FacebookAuthUI.this.getString(C25738R.string.bm_), true);
            FacebookAuthUI.this.gAr.setOnCancelListener(FacebookAuthUI.this.gAs);
            C1720g.m3540Rg().mo14541a(new C32970y(C32970y.gvX), 0);
            AppMethodBeat.m2505o(124782);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$9 */
    class C380479 implements OnClickListener {
        C380479() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$11 */
    class C3804811 implements OnClickListener {
        C3804811() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$1 */
    class C380491 extends C4884c<C37745jk> {
        C380491() {
            AppMethodBeat.m2504i(124775);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(124775);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124776);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(124776);
                return false;
            }
            C4990ab.m7417i("MicroMsg.FacebookAuthUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(124776);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookAuthUI$8 */
    class C380508 implements OnClickListener {
        C380508() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FacebookAuthUI() {
        AppMethodBeat.m2504i(124787);
        AppMethodBeat.m2505o(124787);
    }

    static /* synthetic */ void aqN() {
        AppMethodBeat.m2504i(124800);
        FacebookAuthUI.m64381dp(false);
        AppMethodBeat.m2505o(124800);
    }

    /* renamed from: d */
    static /* synthetic */ void m64380d(FacebookAuthUI facebookAuthUI) {
        AppMethodBeat.m2504i(124799);
        facebookAuthUI.aqL();
        AppMethodBeat.m2505o(124799);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124788);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.m2505o(124788);
    }

    public void onResume() {
        AppMethodBeat.m2504i(124789);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        C1720g.m3540Rg().mo14539a(183, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        aqM();
        AppMethodBeat.m2505o(124789);
    }

    public void onPause() {
        AppMethodBeat.m2504i(124790);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        C1720g.m3540Rg().mo14546b(183, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        AppMethodBeat.m2505o(124790);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8506aq;
    }

    public final void initView() {
        AppMethodBeat.m2504i(124791);
        this.gAU = getIntent().getBooleanExtra("is_force_unbind", false);
        this.gAs = new C188704();
        setMMTitle((int) C25738R.string.a5x);
        this.ehK.addPreferencesFromResource(C25738R.xml.f8506aq);
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
        setBackBtn(new C266125());
        AppMethodBeat.m2505o(124791);
    }

    private void aqL() {
        AppMethodBeat.m2504i(124793);
        this.gAr = ProgressDialog.show(this, getString(C25738R.string.f9238tz), getString(C25738R.string.bm0), true);
        this.gAr.setOnCancelListener(this.gAs);
        this.gAt = new C32967v(1, this.gAW);
        C1720g.m3540Rg().mo14541a(this.gAt, 0);
        FacebookAuthUI.m64381dp(true);
        C7060h.pYm.mo8378a(582, 1, 1, false);
        AppMethodBeat.m2505o(124793);
    }

    private void aqM() {
        Preference preference;
        AppMethodBeat.m2504i(124794);
        this.ehK.removeAll();
        boolean Za = this.gAU ? false : C1853r.m3847Za();
        if (this.gAX.containsKey("facebook_auth_tip")) {
            preference = (Preference) this.gAX.get("facebook_auth_tip");
            preference.setTitle(Za ? C25738R.string.bm9 : C25738R.string.blz);
            this.ehK.mo27713b(preference);
        }
        if (this.gAX.containsKey("facebook_auth_cat")) {
            this.ehK.mo27713b((Preference) this.gAX.get("facebook_auth_cat"));
        }
        if (Za) {
            if (this.gAX.containsKey("facebook_auth_account")) {
                preference = (Preference) this.gAX.get("facebook_auth_account");
                preference.setTitle(getString(C25738R.string.bm1) + C1720g.m3536RP().mo5239Ry().get(65826, null));
                this.ehK.mo27713b(preference);
            }
            if (this.gAX.containsKey("facebook_auth_cat2")) {
                this.ehK.mo27713b((Preference) this.gAX.get("facebook_auth_cat2"));
            }
            if (this.gAX.containsKey("facebook_auth_unbind_btn")) {
                this.ehK.mo27713b((Preference) this.gAX.get("facebook_auth_unbind_btn"));
            }
        } else if (this.gAX.containsKey("facebook_auth_bind_btn")) {
            this.ehK.mo27713b((Preference) this.gAX.get("facebook_auth_bind_btn"));
            AppMethodBeat.m2505o(124794);
            return;
        }
        AppMethodBeat.m2505o(124794);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(124795);
        String str = "MicroMsg.FacebookAuthUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7417i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookAuthUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
            if (!C5046bo.isNullOrNil(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            C4990ab.m7417i(str2, str3, objArr2);
            if (intExtra == -217) {
                aqL();
                AppMethodBeat.m2505o(124795);
                return;
            }
        }
        if (this.gyN != null) {
            this.gyN.mo49075h(i, i2, intent);
        }
        if (this.gAT != null) {
            this.gAT.mo28126h(i, i2, intent);
        }
        AppMethodBeat.m2505o(124795);
    }

    /* renamed from: dp */
    private static void m64381dp(boolean z) {
        AppMethodBeat.m2504i(124796);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C6333a(32, z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6332h(arrayList));
        AppMethodBeat.m2505o(124796);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124797);
        C42124a jY;
        if (c1207m.getType() != C31128d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (c1207m.getType() == 183) {
                if (this.gAr != null) {
                    this.gAr.dismiss();
                }
                int i3 = ((C32967v) c1207m).opType;
                if (i == 0 && i2 == 0) {
                    Toast.makeText(this, i3 == 0 ? C25738R.string.aw4 : C25738R.string.avz, 1).show();
                    this.gAU = false;
                    aqM();
                    if (i3 == 1) {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("facebookapp");
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15254Rh("facebookapp");
                        this.gAV = true;
                    }
                    AppMethodBeat.m2505o(124797);
                    return;
                } else if (i == 4 && i2 == -67) {
                    Toast.makeText(this, C25738R.string.bm3, 1).show();
                    AppMethodBeat.m2505o(124797);
                    return;
                } else if (i == 4 && i2 == -5) {
                    Toast.makeText(this, i3 == 1 ? C25738R.string.blx : C25738R.string.bm6, 1).show();
                    AppMethodBeat.m2505o(124797);
                    return;
                } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                    C42257z.m74635f(this, str, 0);
                    AppMethodBeat.m2505o(124797);
                    return;
                } else {
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, null, null);
                        AppMethodBeat.m2505o(124797);
                        return;
                    }
                    Toast.makeText(this, i3 == 0 ? C25738R.string.aw3 : C25738R.string.avy, 1).show();
                }
            }
            AppMethodBeat.m2505o(124797);
        } else if (i == 0 && i2 == 0) {
            this.gAt = new C32967v(0, "");
            C1720g.m3540Rg().mo14541a(this.gAt, 0);
            AppMethodBeat.m2505o(124797);
        } else {
            if (this.gAr != null) {
                this.gAr.dismiss();
            }
            if (i2 == -82) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4r, (int) C25738R.string.f9238tz, new C380479());
                AppMethodBeat.m2505o(124797);
            } else if (i2 == -83) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4o, (int) C25738R.string.f9238tz, new C3804410());
                AppMethodBeat.m2505o(124797);
            } else if (i2 == -84) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4p, (int) C25738R.string.f9238tz, new C3804811());
                AppMethodBeat.m2505o(124797);
            } else if (i2 == -85) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4n, (int) C25738R.string.f9238tz, new C188692());
                AppMethodBeat.m2505o(124797);
            } else if (i2 == -86) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4t, (int) C25738R.string.f9238tz, new C329863());
                AppMethodBeat.m2505o(124797);
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                C42257z.m74635f(this, str, 0);
                AppMethodBeat.m2505o(124797);
            } else if (i2 == -217) {
                C42257z.m74633a(this, C1948e.m4157a((C6686q) c1207m), i2);
                AppMethodBeat.m2505o(124797);
            } else {
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this, null, null);
                    AppMethodBeat.m2505o(124797);
                    return;
                }
                AppMethodBeat.m2505o(124797);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(124798);
        if (i == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.gAV);
            setResult(-1, intent);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(124798);
        return onKeyDown;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(124792);
        String str = preference.mKey;
        if (str == null) {
            C4990ab.m7412e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            AppMethodBeat.m2505o(124792);
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            if (C35800q.m58700u(this, "com.facebook.katana")) {
                if (this.gAT == null) {
                    this.gAT = new C15887d(getString(C25738R.string.g7d));
                    this.gAT.dJd();
                }
                if (this.gAT.dJc()) {
                    aqL();
                } else {
                    this.gAT.logout();
                    this.gAT.mo28122a(this, new C380456(), gAu);
                }
            } else {
                try {
                    this.gyN.mo49076ie(this);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
                }
                this.gyN = new C30704c(getString(C25738R.string.g7d));
                this.gyN.mo49070a((Activity) this, gAu, new C26613a(this, (byte) 0));
            }
            AppMethodBeat.m2505o(124792);
            return true;
        } else if (str.equals("facebook_auth_unbind_btn")) {
            C30379h.m48432a((Context) this, (int) C25738R.string.bm7, (int) C25738R.string.f9238tz, new C380467(), new C380508());
            AppMethodBeat.m2505o(124792);
            return true;
        } else {
            AppMethodBeat.m2505o(124792);
            return false;
        }
    }
}

package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.profile.p1286a.C43387b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI */
public class ContactMoreInfoUI extends MMActivity implements OnClickListener, C28114l {
    private String edV;
    C7577u eih;
    private String ejD;
    boolean ejU = false;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private C7616ad ldh;
    private C43387b pkh;
    private ProfileNormalItemView plQ;
    private ProfileNormalItemView plR;
    private ProfileNormalItemView plS;
    private ProfileNormalItemView plT;
    private ProfileNormalItemView plU;
    private ProfileNormalItemView plV;
    private ProfileNormalItemView plW;
    private ProfileNormalItemView plX;
    private String plY;
    private String plZ;
    private String pma;
    private String pmb;
    private long pmc;
    private String pmd;
    String pme = null;

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI$1 */
    class C346991 implements OnMenuItemClickListener {
        C346991() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23406);
            ContactMoreInfoUI.this.finish();
            AppMethodBeat.m2505o(23406);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI$3 */
    class C347003 implements OnClickListener {
        C347003() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23408);
            if (C5046bo.isNullOrNil(ContactMoreInfoUI.this.plZ)) {
                ContactMoreInfoUI.this.plZ = ContactMoreInfoUI.this.ldh.dup;
            }
            if (!C5046bo.isNullOrNil(ContactMoreInfoUI.this.plZ)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ContactMoreInfoUI.this.plZ);
                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                C25985d.m41467b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(23408);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI$4 */
    class C347014 implements OnClickListener {
        C347014() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI$2 */
    class C395062 implements OnClickListener {
        C395062() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23407);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ContactMoreInfoUI.this.pme);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            C25985d.m41467b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(23407);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactMoreInfoUI() {
        AppMethodBeat.m2504i(23410);
        AppMethodBeat.m2505o(23410);
    }

    public final int getLayoutId() {
        return 2130969218;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(23411);
        super.onCreate(bundle);
        this.ejU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.ejD = getIntent().getStringExtra("Contact_ChatRoomId");
        this.edV = getIntent().getStringExtra("Contact_User");
        C9638aw.m17190ZK();
        this.ldh = C18628c.m29078XM().aoO(this.edV);
        this.plY = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.plZ = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.pma = getIntent().getStringExtra("verify_gmail");
        this.pmb = getIntent().getStringExtra("profileName");
        if (!C5046bo.isNullOrNil(this.ejD)) {
            C9638aw.m17190ZK();
            this.eih = C18628c.m29087XV().mo14885oa(this.ejD);
        }
        this.pkh = new C43387b(this, this.ldh);
        initView();
        AppMethodBeat.m2505o(23411);
    }

    public final void initView() {
        AppMethodBeat.m2504i(23412);
        super.initView();
        setMMTitle((int) C25738R.string.f9169rn);
        setBackBtn(new C346991());
        this.plQ = (ProfileNormalItemView) findViewById(2131823055);
        this.plR = (ProfileNormalItemView) findViewById(2131823057);
        this.plS = (ProfileNormalItemView) findViewById(2131823058);
        this.plT = (ProfileNormalItemView) findViewById(2131821046);
        this.plT.setVisibility(8);
        this.plT.mTitle = getString(C25738R.string.avm);
        this.plW = (ProfileNormalItemView) findViewById(2131823053);
        this.plW.mo62465Bg(C25738R.string.b0a);
        this.plW.cbw();
        this.plX = (ProfileNormalItemView) findViewById(2131823054);
        this.plX.mo62465Bg(C25738R.string.b1p);
        this.plV = (ProfileNormalItemView) findViewById(2131823056);
        this.plU = (ProfileNormalItemView) findViewById(2131823052);
        this.plU.cbx();
        caN();
        caO();
        caP();
        caQ();
        caR();
        m67497L(this.ldh);
        if (!this.ldh.field_username.equals(C1853r.m3846Yz())) {
            m67498M(this.ldh);
        }
        AppMethodBeat.m2505o(23412);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: L */
    private boolean m67497L(C7616ad c7616ad) {
        String str;
        CharSequence optString;
        AppMethodBeat.m2504i(23413);
        if (C1853r.m3846Yz().equals(c7616ad.field_username)) {
            C9638aw.m17190ZK();
            str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_PROFILE_WEIDIANINFO_STRING, null);
        } else {
            str = c7616ad.duq;
        }
        if (!C5046bo.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.pme = jSONObject.optString("ShopUrl");
                optString = jSONObject.optString("ShopName");
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.ContactMoreInfoUI", e, "", new Object[0]);
            }
            if (C5046bo.isNullOrNil(this.pme)) {
                this.plV.setVisibility(0);
                this.plV.ppl = optString;
                this.plV.mo62467Bi(getResources().getColor(C25738R.color.a87));
                ProfileNormalItemView profileNormalItemView = this.plV;
                profileNormalItemView.ppm = new C395062();
                profileNormalItemView.cby();
                AppMethodBeat.m2505o(23413);
                return true;
            }
            this.plV.setVisibility(8);
            AppMethodBeat.m2505o(23413);
            return false;
        }
        optString = null;
        if (C5046bo.isNullOrNil(this.pme)) {
        }
    }

    private boolean caN() {
        AppMethodBeat.m2504i(23414);
        String value = C26373g.m41964Nu().getValue("LinkedinPluginClose");
        boolean z = C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0;
        if (!z || C5046bo.isNullOrNil(this.ldh.dun)) {
            this.plQ.setVisibility(8);
            AppMethodBeat.m2505o(23414);
            return false;
        }
        this.plQ.setVisibility(0);
        if (C5046bo.isNullOrNil(this.plY)) {
            this.plY = this.ldh.duo;
        }
        ProfileNormalItemView profileNormalItemView = this.plQ;
        profileNormalItemView.ppl = this.plY;
        profileNormalItemView.ppm = new C347003();
        boolean cby = profileNormalItemView.mo62467Bi(getResources().getColor(C25738R.color.a87)).cby();
        AppMethodBeat.m2505o(23414);
        return cby;
    }

    private boolean caO() {
        AppMethodBeat.m2504i(23415);
        this.plR.setVisibility(0);
        ProfileNormalItemView profileNormalItemView = this.plR;
        profileNormalItemView.ppl = this.pma;
        boolean cby = profileNormalItemView.cby();
        AppMethodBeat.m2505o(23415);
        return cby;
    }

    private boolean caP() {
        AppMethodBeat.m2504i(23416);
        C9638aw.m17190ZK();
        int h = C5046bo.m7567h((Integer) C18628c.m29072Ry().get(9, null));
        this.pmc = getIntent().getLongExtra("Contact_Uin", 0);
        this.pmd = getIntent().getStringExtra("Contact_QQNick");
        if (this.pmc == 0 || h == 0) {
            this.plS.setVisibility(8);
            AppMethodBeat.m2505o(23416);
            return false;
        }
        if (this.pmd == null || this.pmd.length() == 0) {
            C9878ao jx = ContactMoreInfoUI.m67502jx(this.pmc);
            if (jx != null) {
                this.pmd = jx.getDisplayName();
            }
        }
        String str = C5046bo.nullAsNil(this.pmd) + " " + new C1183p(this.pmc).longValue();
        this.plS.setVisibility(0);
        ProfileNormalItemView profileNormalItemView = this.plS;
        profileNormalItemView.ppl = str;
        profileNormalItemView.ppm = new C347014();
        boolean cby = profileNormalItemView.cby();
        AppMethodBeat.m2505o(23416);
        return cby;
    }

    /* renamed from: jx */
    private static C9878ao m67502jx(long j) {
        AppMethodBeat.m2504i(23417);
        C9878ao ge = C32923a.getQQListStg().mo73284ge(j);
        if (ge == null) {
            AppMethodBeat.m2505o(23417);
            return null;
        }
        AppMethodBeat.m2505o(23417);
        return ge;
    }

    private boolean caQ() {
        AppMethodBeat.m2504i(23418);
        ProfileNormalItemView profileNormalItemView = this.plW;
        profileNormalItemView.ppl = C44089j.m79292b((Context) this, this.ldh.signature);
        boolean cby = profileNormalItemView.cby();
        AppMethodBeat.m2505o(23418);
        return cby;
    }

    private boolean caR() {
        AppMethodBeat.m2504i(23419);
        C4990ab.m7417i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", Integer.valueOf(this.ldh.getSource()));
        switch (this.ldh.getSource()) {
            case 1:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b1c);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b1d);
                break;
            case 3:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b1f);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b1g);
                break;
            case 4:
            case 12:
                this.plX.mo62466Bh(C25738R.string.bw3);
                break;
            case 8:
            case 14:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b0x);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b0y);
                break;
            case 10:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b1l);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b1m);
                break;
            case 13:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b1l);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b1m);
                break;
            case 15:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b1_);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b1a);
                break;
            case 17:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b0r);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b0u);
                break;
            case 18:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b11);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b12);
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b1i);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b1j);
                break;
            case 25:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b0o);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b0p);
                break;
            case 30:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    this.plX.mo62466Bh(C25738R.string.b16);
                    break;
                }
                this.plX.mo62466Bh(C25738R.string.b17);
                break;
            case 34:
                this.plX.mo62466Bh(C25738R.string.b0m);
                break;
            case 48:
                this.plX.mo62466Bh(C25738R.string.b19);
                break;
            case C42464aa.CTRL_INDEX /*58*/:
            case C2206au.CTRL_INDEX /*59*/:
            case 60:
                this.plX.mo62466Bh(C25738R.string.c8k);
                break;
            case 76:
                this.plX.mo62466Bh(C25738R.string.b14);
                break;
            default:
                this.plX.ppl = null;
                break;
        }
        boolean cby = this.plX.cby();
        AppMethodBeat.m2505o(23419);
        return cby;
    }

    /* renamed from: b */
    public final void mo8215b(C28109j c28109j) {
        AppMethodBeat.m2504i(23421);
        if (c28109j.bFZ == 0) {
            final int intValue = ((Integer) ((C45966l) c28109j.mEy.get(0)).userData).intValue();
            this.plU.ppl = getString(C25738R.string.avf, new Object[]{Integer.valueOf(intValue)});
            this.plU.ppm = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(23409);
                    C3163e.m5424vW(intValue);
                    if (intValue > 0) {
                        Intent intent = new Intent(ContactMoreInfoUI.this, CommonChatroomInfoUI.class);
                        intent.putExtra("Select_Talker_Name", ContactMoreInfoUI.this.ldh.field_username);
                        ContactMoreInfoUI.this.startActivity(intent);
                    }
                    AppMethodBeat.m2505o(23409);
                }
            };
        } else {
            this.plU.ppl = getString(C25738R.string.avf, new Object[]{Integer.valueOf(0)});
        }
        this.plU.cby();
        AppMethodBeat.m2505o(23421);
    }

    public void onClick(View view) {
    }

    /* renamed from: M */
    private boolean m67498M(C7616ad c7616ad) {
        AppMethodBeat.m2504i(23420);
        if (c7616ad.field_username.equals(C1853r.m3846Yz())) {
            this.plU.setVisibility(8);
            AppMethodBeat.m2505o(23420);
            return false;
        }
        if (c7616ad.dtS == 1) {
            this.plU.mo62465Bg(C25738R.string.avc);
        } else if (c7616ad.dtS == 2) {
            this.plU.mo62465Bg(C25738R.string.avb);
        } else {
            this.plU.mo62465Bg(C25738R.string.avg);
        }
        this.plU.cby();
        C20846i c20846i = new C20846i();
        c20846i.query = c7616ad.field_username;
        c20846i.mEw = this;
        c20846i.handler = this.handler;
        c20846i.hbo = 5;
        ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(23420);
        return true;
    }
}

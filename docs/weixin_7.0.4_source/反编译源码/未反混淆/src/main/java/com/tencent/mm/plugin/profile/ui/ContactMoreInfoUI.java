package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactMoreInfoUI extends MMActivity implements OnClickListener, l {
    private String edV;
    u eih;
    private String ejD;
    boolean ejU = false;
    private ak handler = new ak(Looper.getMainLooper());
    private ad ldh;
    private b pkh;
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactMoreInfoUI() {
        AppMethodBeat.i(23410);
        AppMethodBeat.o(23410);
    }

    public final int getLayoutId() {
        return R.layout.ql;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23411);
        super.onCreate(bundle);
        this.ejU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.ejD = getIntent().getStringExtra("Contact_ChatRoomId");
        this.edV = getIntent().getStringExtra("Contact_User");
        aw.ZK();
        this.ldh = c.XM().aoO(this.edV);
        this.plY = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.plZ = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.pma = getIntent().getStringExtra("verify_gmail");
        this.pmb = getIntent().getStringExtra("profileName");
        if (!bo.isNullOrNil(this.ejD)) {
            aw.ZK();
            this.eih = c.XV().oa(this.ejD);
        }
        this.pkh = new b(this, this.ldh);
        initView();
        AppMethodBeat.o(23411);
    }

    public final void initView() {
        AppMethodBeat.i(23412);
        super.initView();
        setMMTitle((int) R.string.rn);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23406);
                ContactMoreInfoUI.this.finish();
                AppMethodBeat.o(23406);
                return true;
            }
        });
        this.plQ = (ProfileNormalItemView) findViewById(R.id.b3v);
        this.plR = (ProfileNormalItemView) findViewById(R.id.b3x);
        this.plS = (ProfileNormalItemView) findViewById(R.id.b3y);
        this.plT = (ProfileNormalItemView) findViewById(R.id.mv);
        this.plT.setVisibility(8);
        this.plT.mTitle = getString(R.string.avm);
        this.plW = (ProfileNormalItemView) findViewById(R.id.b3t);
        this.plW.Bg(R.string.b0a);
        this.plW.cbw();
        this.plX = (ProfileNormalItemView) findViewById(R.id.b3u);
        this.plX.Bg(R.string.b1p);
        this.plV = (ProfileNormalItemView) findViewById(R.id.b3w);
        this.plU = (ProfileNormalItemView) findViewById(R.id.b3s);
        this.plU.cbx();
        caN();
        caO();
        caP();
        caQ();
        caR();
        L(this.ldh);
        if (!this.ldh.field_username.equals(r.Yz())) {
            M(this.ldh);
        }
        AppMethodBeat.o(23412);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean L(ad adVar) {
        String str;
        CharSequence optString;
        AppMethodBeat.i(23413);
        if (r.Yz().equals(adVar.field_username)) {
            aw.ZK();
            str = (String) c.Ry().get(a.USERINFO_PROFILE_WEIDIANINFO_STRING, null);
        } else {
            str = adVar.duq;
        }
        if (!bo.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.pme = jSONObject.optString("ShopUrl");
                optString = jSONObject.optString("ShopName");
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.ContactMoreInfoUI", e, "", new Object[0]);
            }
            if (bo.isNullOrNil(this.pme)) {
                this.plV.setVisibility(0);
                this.plV.ppl = optString;
                this.plV.Bi(getResources().getColor(R.color.a87));
                ProfileNormalItemView profileNormalItemView = this.plV;
                profileNormalItemView.ppm = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(23407);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", ContactMoreInfoUI.this.pme);
                        intent.putExtra("geta8key_username", r.Yz());
                        d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(23407);
                    }
                };
                profileNormalItemView.cby();
                AppMethodBeat.o(23413);
                return true;
            }
            this.plV.setVisibility(8);
            AppMethodBeat.o(23413);
            return false;
        }
        optString = null;
        if (bo.isNullOrNil(this.pme)) {
        }
    }

    private boolean caN() {
        AppMethodBeat.i(23414);
        String value = g.Nu().getValue("LinkedinPluginClose");
        boolean z = bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0;
        if (!z || bo.isNullOrNil(this.ldh.dun)) {
            this.plQ.setVisibility(8);
            AppMethodBeat.o(23414);
            return false;
        }
        this.plQ.setVisibility(0);
        if (bo.isNullOrNil(this.plY)) {
            this.plY = this.ldh.duo;
        }
        ProfileNormalItemView profileNormalItemView = this.plQ;
        profileNormalItemView.ppl = this.plY;
        profileNormalItemView.ppm = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(23408);
                if (bo.isNullOrNil(ContactMoreInfoUI.this.plZ)) {
                    ContactMoreInfoUI.this.plZ = ContactMoreInfoUI.this.ldh.dup;
                }
                if (!bo.isNullOrNil(ContactMoreInfoUI.this.plZ)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ContactMoreInfoUI.this.plZ);
                    intent.putExtra("geta8key_username", r.Yz());
                    d.b(ContactMoreInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(23408);
            }
        };
        boolean cby = profileNormalItemView.Bi(getResources().getColor(R.color.a87)).cby();
        AppMethodBeat.o(23414);
        return cby;
    }

    private boolean caO() {
        AppMethodBeat.i(23415);
        this.plR.setVisibility(0);
        ProfileNormalItemView profileNormalItemView = this.plR;
        profileNormalItemView.ppl = this.pma;
        boolean cby = profileNormalItemView.cby();
        AppMethodBeat.o(23415);
        return cby;
    }

    private boolean caP() {
        AppMethodBeat.i(23416);
        aw.ZK();
        int h = bo.h((Integer) c.Ry().get(9, null));
        this.pmc = getIntent().getLongExtra("Contact_Uin", 0);
        this.pmd = getIntent().getStringExtra("Contact_QQNick");
        if (this.pmc == 0 || h == 0) {
            this.plS.setVisibility(8);
            AppMethodBeat.o(23416);
            return false;
        }
        if (this.pmd == null || this.pmd.length() == 0) {
            ao jx = jx(this.pmc);
            if (jx != null) {
                this.pmd = jx.getDisplayName();
            }
        }
        String str = bo.nullAsNil(this.pmd) + " " + new p(this.pmc).longValue();
        this.plS.setVisibility(0);
        ProfileNormalItemView profileNormalItemView = this.plS;
        profileNormalItemView.ppl = str;
        profileNormalItemView.ppm = new OnClickListener() {
            public final void onClick(View view) {
            }
        };
        boolean cby = profileNormalItemView.cby();
        AppMethodBeat.o(23416);
        return cby;
    }

    private static ao jx(long j) {
        AppMethodBeat.i(23417);
        ao ge = com.tencent.mm.plugin.account.a.getQQListStg().ge(j);
        if (ge == null) {
            AppMethodBeat.o(23417);
            return null;
        }
        AppMethodBeat.o(23417);
        return ge;
    }

    private boolean caQ() {
        AppMethodBeat.i(23418);
        ProfileNormalItemView profileNormalItemView = this.plW;
        profileNormalItemView.ppl = j.b((Context) this, this.ldh.signature);
        boolean cby = profileNormalItemView.cby();
        AppMethodBeat.o(23418);
        return cby;
    }

    private boolean caR() {
        AppMethodBeat.i(23419);
        ab.i("MicroMsg.ContactMoreInfoUI", "[initFriendSource] source:%s", Integer.valueOf(this.ldh.getSource()));
        switch (this.ldh.getSource()) {
            case 1:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b1c);
                    break;
                }
                this.plX.Bh(R.string.b1d);
                break;
            case 3:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b1f);
                    break;
                }
                this.plX.Bh(R.string.b1g);
                break;
            case 4:
            case 12:
                this.plX.Bh(R.string.bw3);
                break;
            case 8:
            case 14:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b0x);
                    break;
                }
                this.plX.Bh(R.string.b0y);
                break;
            case 10:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b1l);
                    break;
                }
                this.plX.Bh(R.string.b1m);
                break;
            case 13:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b1l);
                    break;
                }
                this.plX.Bh(R.string.b1m);
                break;
            case 15:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b1_);
                    break;
                }
                this.plX.Bh(R.string.b1a);
                break;
            case 17:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b0r);
                    break;
                }
                this.plX.Bh(R.string.b0u);
                break;
            case 18:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b11);
                    break;
                }
                this.plX.Bh(R.string.b12);
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b1i);
                    break;
                }
                this.plX.Bh(R.string.b1j);
                break;
            case 25:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b0o);
                    break;
                }
                this.plX.Bh(R.string.b0p);
                break;
            case 30:
                if (this.ldh.Ol() <= 1000000) {
                    this.plX.Bh(R.string.b16);
                    break;
                }
                this.plX.Bh(R.string.b17);
                break;
            case 34:
                this.plX.Bh(R.string.b0m);
                break;
            case 48:
                this.plX.Bh(R.string.b19);
                break;
            case aa.CTRL_INDEX /*58*/:
            case au.CTRL_INDEX /*59*/:
            case 60:
                this.plX.Bh(R.string.c8k);
                break;
            case 76:
                this.plX.Bh(R.string.b14);
                break;
            default:
                this.plX.ppl = null;
                break;
        }
        boolean cby = this.plX.cby();
        AppMethodBeat.o(23419);
        return cby;
    }

    public final void b(com.tencent.mm.plugin.fts.a.a.j jVar) {
        AppMethodBeat.i(23421);
        if (jVar.bFZ == 0) {
            final int intValue = ((Integer) ((com.tencent.mm.plugin.fts.a.a.l) jVar.mEy.get(0)).userData).intValue();
            this.plU.ppl = getString(R.string.avf, new Object[]{Integer.valueOf(intValue)});
            this.plU.ppm = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23409);
                    e.vW(intValue);
                    if (intValue > 0) {
                        Intent intent = new Intent(ContactMoreInfoUI.this, CommonChatroomInfoUI.class);
                        intent.putExtra("Select_Talker_Name", ContactMoreInfoUI.this.ldh.field_username);
                        ContactMoreInfoUI.this.startActivity(intent);
                    }
                    AppMethodBeat.o(23409);
                }
            };
        } else {
            this.plU.ppl = getString(R.string.avf, new Object[]{Integer.valueOf(0)});
        }
        this.plU.cby();
        AppMethodBeat.o(23421);
    }

    public void onClick(View view) {
    }

    private boolean M(ad adVar) {
        AppMethodBeat.i(23420);
        if (adVar.field_username.equals(r.Yz())) {
            this.plU.setVisibility(8);
            AppMethodBeat.o(23420);
            return false;
        }
        if (adVar.dtS == 1) {
            this.plU.Bg(R.string.avc);
        } else if (adVar.dtS == 2) {
            this.plU.Bg(R.string.avb);
        } else {
            this.plU.Bg(R.string.avg);
        }
        this.plU.cby();
        i iVar = new i();
        iVar.query = adVar.field_username;
        iVar.mEw = this;
        iVar.handler = this.handler;
        iVar.hbo = 5;
        ((n) com.tencent.mm.kernel.g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(23420);
        return true;
    }
}

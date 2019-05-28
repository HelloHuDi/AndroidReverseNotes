package com.tencent.p177mm.plugin.game.p433ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.p177mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.game.p731d.C12112ao;
import com.tencent.p177mm.plugin.game.p731d.C28200z;
import com.tencent.p177mm.plugin.game.p731d.C39183aa;
import com.tencent.p177mm.plugin.game.p731d.C45988ap;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI */
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    /* renamed from: JU */
    private String f3575JU;
    private ProgressDialog fsh = null;
    private String gHT;
    private String mAppId;
    private String mPackageName;
    private String nep;
    private String neq;
    private String ner;
    private String nes;
    private int neu = 1;

    /* renamed from: com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI$2 */
    class C167752 implements C1224a {
        C167752() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(111703);
            C45988ap c45988ap = (C45988ap) c7472b.fsH.fsP;
            if (i == 0 && i2 == 0) {
                C4990ab.m7417i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", c45988ap.nbf);
                CreateOrJoinChatroomUI.m25850a(CreateOrJoinChatroomUI.this);
                CreateOrJoinChatroomUI.m25852a(CreateOrJoinChatroomUI.this, r0);
                AppMethodBeat.m2505o(111703);
            } else {
                C4990ab.m7413e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4) {
                    CreateOrJoinChatroomUI.m25851a(CreateOrJoinChatroomUI.this, c45988ap.luT);
                } else {
                    CreateOrJoinChatroomUI.m25851a(CreateOrJoinChatroomUI.this, -1);
                }
                CreateOrJoinChatroomUI.m25850a(CreateOrJoinChatroomUI.this);
                CreateOrJoinChatroomUI.this.finish();
                AppMethodBeat.m2505o(111703);
            }
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI$1 */
    class C167761 implements C1224a {
        C167761() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(111702);
            C39183aa c39183aa = (C39183aa) c7472b.fsH.fsP;
            if (i == 0 && i2 == 0) {
                C4990ab.m7417i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", c39183aa.naw);
                CreateOrJoinChatroomUI.m25850a(CreateOrJoinChatroomUI.this);
                CreateOrJoinChatroomUI.m25852a(CreateOrJoinChatroomUI.this, r0);
                AppMethodBeat.m2505o(111702);
            } else {
                C4990ab.m7413e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4) {
                    CreateOrJoinChatroomUI.m25851a(CreateOrJoinChatroomUI.this, c39183aa.luT);
                } else {
                    CreateOrJoinChatroomUI.m25851a(CreateOrJoinChatroomUI.this, -1);
                }
                CreateOrJoinChatroomUI.m25850a(CreateOrJoinChatroomUI.this);
                CreateOrJoinChatroomUI.this.finish();
                AppMethodBeat.m2505o(111702);
            }
            return 0;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m25850a(CreateOrJoinChatroomUI createOrJoinChatroomUI) {
        AppMethodBeat.m2504i(111710);
        createOrJoinChatroomUI.bFd();
        AppMethodBeat.m2505o(111710);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111704);
        super.onCreate(bundle);
        requestWindowFeature(1);
        C4990ab.m7416i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.f3575JU = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        this.mPackageName = intent.getStringExtra("package_name");
        this.mAppId = intent.getStringExtra("key_app_id");
        this.nep = intent.getStringExtra("key_transaction");
        this.neq = intent.getStringExtra(C8741b.GROUP_ID);
        this.ner = intent.getStringExtra("chatroom_name");
        this.gHT = intent.getStringExtra("chatroom_nickname");
        this.nes = intent.getStringExtra("ext_msg");
        if (C5046bo.isNullOrNil(this.f3575JU) || C5046bo.isNullOrNil(this.mAppId) || C5046bo.isNullOrNil(this.neq)) {
            C4990ab.m7412e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            AppMethodBeat.m2505o(111704);
            return;
        }
        this.fsh = C30379h.m48458b((Context) this, getBaseContext().getString(C25738R.string.c8a), true, null);
        C1196a c1196a;
        C7472b acD;
        byte[] bArr;
        if (this.f3575JU.equals("action_create")) {
            C4990ab.m7417i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", this.mAppId, this.neq, this.ner);
            c1196a = new C1196a();
            c1196a.fsJ = new C28200z();
            c1196a.fsK = new C39183aa();
            c1196a.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            c1196a.fsI = 1205;
            acD = c1196a.acD();
            C28200z c28200z = (C28200z) acD.fsG.fsP;
            c28200z.mZr = this.mAppId;
            c28200z.nat = this.neq;
            if (this.ner == null) {
                bArr = new byte[0];
            } else {
                bArr = this.ner.getBytes();
            }
            c28200z.nau = new C1332b(bArr);
            if (this.gHT == null) {
                bArr = new byte[0];
            } else {
                bArr = this.gHT.getBytes();
            }
            c28200z.nav = new C1332b(bArr);
            C1226w.m2654a(acD, new C167761());
            AppMethodBeat.m2505o(111704);
            return;
        }
        if (this.f3575JU.equals("action_join")) {
            c1196a = new C1196a();
            c1196a.fsJ = new C12112ao();
            c1196a.fsK = new C45988ap();
            c1196a.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            c1196a.fsI = 1206;
            acD = c1196a.acD();
            C12112ao c12112ao = (C12112ao) acD.fsG.fsP;
            c12112ao.mZr = this.mAppId;
            c12112ao.nat = this.neq;
            if (this.gHT == null) {
                bArr = new byte[0];
            } else {
                bArr = this.gHT.getBytes();
            }
            c12112ao.nav = new C1332b(bArr);
            C1226w.m2654a(acD, new C167752());
        }
        AppMethodBeat.m2505o(111704);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(111705);
        bFd();
        super.onDestroy();
        AppMethodBeat.m2505o(111705);
    }

    private void bFd() {
        AppMethodBeat.m2504i(111706);
        if (this.fsh != null && this.fsh.isShowing()) {
            this.fsh.cancel();
        }
        AppMethodBeat.m2505o(111706);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(111707);
        if (i == 5) {
            if (i2 == 4) {
                m25853wE(0);
            } else if (i2 == 5) {
                if (intent != null) {
                    C23257a.vax.mo52974b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i2 == 0) {
                m25853wE(-2);
            }
        }
        finish();
        AppMethodBeat.m2505o(111707);
    }

    /* renamed from: wE */
    private void m25853wE(int i) {
        AppMethodBeat.m2504i(111708);
        C40439f bT = C46494g.m87739bT(this.mAppId, true);
        Bundle bundle = new Bundle();
        if (this.f3575JU.equals("action_create")) {
            Resp resp = new Resp();
            if (bT != null) {
                resp.openId = bT.field_openId;
            }
            resp.transaction = this.nep;
            resp.extMsg = this.nes;
            resp.errCode = i;
            resp.toBundle(bundle);
        } else if (this.f3575JU.equals("action_join")) {
            JoinChatroom.Resp resp2 = new JoinChatroom.Resp();
            if (bT != null) {
                resp2.openId = bT.field_openId;
            }
            resp2.transaction = this.nep;
            resp2.extMsg = this.nes;
            resp2.errCode = i;
            resp2.toBundle(bundle);
        }
        Args args = new Args();
        args.targetPkgName = this.mPackageName;
        args.bundle = bundle;
        C35799p.m58687at(bundle);
        C35799p.m58688au(bundle);
        MMessageActV2.send(C4996ah.getContext(), args);
        AppMethodBeat.m2505o(111708);
    }
}

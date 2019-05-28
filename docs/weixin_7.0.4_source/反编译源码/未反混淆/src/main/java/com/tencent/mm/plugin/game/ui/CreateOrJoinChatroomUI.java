package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    private String JU;
    private ProgressDialog fsh = null;
    private String gHT;
    private String mAppId;
    private String mPackageName;
    private String nep;
    private String neq;
    private String ner;
    private String nes;
    private int neu = 1;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI) {
        AppMethodBeat.i(111710);
        createOrJoinChatroomUI.bFd();
        AppMethodBeat.o(111710);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111704);
        super.onCreate(bundle);
        requestWindowFeature(1);
        ab.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.JU = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        this.mPackageName = intent.getStringExtra("package_name");
        this.mAppId = intent.getStringExtra("key_app_id");
        this.nep = intent.getStringExtra("key_transaction");
        this.neq = intent.getStringExtra(b.GROUP_ID);
        this.ner = intent.getStringExtra("chatroom_name");
        this.gHT = intent.getStringExtra("chatroom_nickname");
        this.nes = intent.getStringExtra("ext_msg");
        if (bo.isNullOrNil(this.JU) || bo.isNullOrNil(this.mAppId) || bo.isNullOrNil(this.neq)) {
            ab.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            AppMethodBeat.o(111704);
            return;
        }
        this.fsh = h.b((Context) this, getBaseContext().getString(R.string.c8a), true, null);
        com.tencent.mm.ai.b.a aVar;
        com.tencent.mm.ai.b acD;
        byte[] bArr;
        if (this.JU.equals("action_create")) {
            ab.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", this.mAppId, this.neq, this.ner);
            aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new z();
            aVar.fsK = new aa();
            aVar.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            aVar.fsI = 1205;
            acD = aVar.acD();
            z zVar = (z) acD.fsG.fsP;
            zVar.mZr = this.mAppId;
            zVar.nat = this.neq;
            if (this.ner == null) {
                bArr = new byte[0];
            } else {
                bArr = this.ner.getBytes();
            }
            zVar.nau = new com.tencent.mm.bt.b(bArr);
            if (this.gHT == null) {
                bArr = new byte[0];
            } else {
                bArr = this.gHT.getBytes();
            }
            zVar.nav = new com.tencent.mm.bt.b(bArr);
            w.a(acD, new w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(111702);
                    aa aaVar = (aa) bVar.fsH.fsP;
                    if (i == 0 && i2 == 0) {
                        ab.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", aaVar.naw);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, r0);
                        AppMethodBeat.o(111702);
                    } else {
                        ab.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 4) {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, aaVar.luT);
                        } else {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, -1);
                        }
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.this.finish();
                        AppMethodBeat.o(111702);
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(111704);
            return;
        }
        if (this.JU.equals("action_join")) {
            aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new ao();
            aVar.fsK = new ap();
            aVar.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            aVar.fsI = 1206;
            acD = aVar.acD();
            ao aoVar = (ao) acD.fsG.fsP;
            aoVar.mZr = this.mAppId;
            aoVar.nat = this.neq;
            if (this.gHT == null) {
                bArr = new byte[0];
            } else {
                bArr = this.gHT.getBytes();
            }
            aoVar.nav = new com.tencent.mm.bt.b(bArr);
            w.a(acD, new w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(111703);
                    ap apVar = (ap) bVar.fsH.fsP;
                    if (i == 0 && i2 == 0) {
                        ab.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", apVar.nbf);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, r0);
                        AppMethodBeat.o(111703);
                    } else {
                        ab.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 4) {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, apVar.luT);
                        } else {
                            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, -1);
                        }
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                        CreateOrJoinChatroomUI.this.finish();
                        AppMethodBeat.o(111703);
                    }
                    return 0;
                }
            });
        }
        AppMethodBeat.o(111704);
    }

    public void onDestroy() {
        AppMethodBeat.i(111705);
        bFd();
        super.onDestroy();
        AppMethodBeat.o(111705);
    }

    private void bFd() {
        AppMethodBeat.i(111706);
        if (this.fsh != null && this.fsh.isShowing()) {
            this.fsh.cancel();
        }
        AppMethodBeat.o(111706);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(111707);
        if (i == 5) {
            if (i2 == 4) {
                wE(0);
            } else if (i2 == 5) {
                if (intent != null) {
                    r.a.vax.b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i2 == 0) {
                wE(-2);
            }
        }
        finish();
        AppMethodBeat.o(111707);
    }

    private void wE(int i) {
        AppMethodBeat.i(111708);
        f bT = g.bT(this.mAppId, true);
        Bundle bundle = new Bundle();
        if (this.JU.equals("action_create")) {
            Resp resp = new Resp();
            if (bT != null) {
                resp.openId = bT.field_openId;
            }
            resp.transaction = this.nep;
            resp.extMsg = this.nes;
            resp.errCode = i;
            resp.toBundle(bundle);
        } else if (this.JU.equals("action_join")) {
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
        p.at(bundle);
        p.au(bundle);
        MMessageActV2.send(ah.getContext(), args);
        AppMethodBeat.o(111708);
    }
}

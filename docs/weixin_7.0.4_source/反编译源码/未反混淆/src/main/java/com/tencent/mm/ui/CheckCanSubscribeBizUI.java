package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.he;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI extends MMActivity implements f, a, b {
    private String appId;
    private int cvd;
    private String cyv;
    private String extInfo;
    private boolean foa = false;
    private int fromScene;
    private String mGZ;
    private int scene;
    private String toUserName;
    private int yfB;
    private LinkedList<bts> yfC;
    private boolean yfD = false;
    private boolean yfE = false;
    private boolean yfF = false;
    private boolean yfG = false;
    private String yfH;
    private int yfI = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        AppMethodBeat.i(29159);
        checkCanSubscribeBizUI.dwq();
        AppMethodBeat.o(29159);
    }

    static /* synthetic */ void c(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        AppMethodBeat.i(29160);
        checkCanSubscribeBizUI.dws();
        AppMethodBeat.o(29160);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29144);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!aw.ZM() || aw.QT()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.o(29144);
            return;
        }
        aw.Rg().a(605, (f) this);
        ((j) g.K(j.class)).XM().a(this);
        z.aeR().c(this);
        if (aAk()) {
            String str = this.appId;
            String str2 = this.toUserName;
            String str3 = this.extInfo;
            int i = this.yfB;
            LinkedList linkedList = this.yfC;
            String str4 = this.cyv;
            int i2 = this.cvd;
            int i3 = this.scene;
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new qt();
            aVar.fsK = new qu();
            aVar.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            aVar.fsI = 605;
            com.tencent.mm.ai.b acD = aVar.acD();
            qt qtVar = (qt) acD.fsG.fsP;
            qtVar.mZr = str;
            qtVar.ndF = str2;
            qtVar.ndT = str3;
            qtVar.vXK = i;
            qtVar.vXL = linkedList;
            qtVar.vXM = null;
            qtVar.vXN = str4;
            qtVar.vFH = i2;
            qtVar.Scene = i3;
            ab.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i3));
            w.a(acD, new w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(29142);
                    qu quVar = (qu) bVar.fsH.fsP;
                    CheckCanSubscribeBizUI.this.mGZ = quVar.vXO;
                    if (i == 0 && i2 == 0 && !bo.isNullOrNil(quVar.vXO) && !bo.isNullOrNil(quVar.ndF)) {
                        CheckCanSubscribeBizUI.this.toUserName = quVar.ndF;
                        CheckCanSubscribeBizUI.this.yfH = quVar.vXP;
                        CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
                        AppMethodBeat.o(29142);
                    } else if (u.a.a(CheckCanSubscribeBizUI.this, i, i2, str, 7)) {
                        CheckCanSubscribeBizUI.this.setResult(5);
                        CheckCanSubscribeBizUI.this.finish();
                        AppMethodBeat.o(29142);
                    } else {
                        CheckCanSubscribeBizUI.c(CheckCanSubscribeBizUI.this);
                        CheckCanSubscribeBizUI.this.setResult(3);
                        CheckCanSubscribeBizUI.this.finish();
                        AppMethodBeat.o(29142);
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(29144);
            return;
        }
        setResult(2);
        dwt();
        finish();
        AppMethodBeat.o(29144);
    }

    public void onStart() {
        AppMethodBeat.i(29145);
        super.onStart();
        AppMethodBeat.o(29145);
    }

    public void onResume() {
        AppMethodBeat.i(29146);
        super.onResume();
        AppMethodBeat.o(29146);
    }

    public void onDestroy() {
        AppMethodBeat.i(29147);
        super.onDestroy();
        if (this.yfC != null) {
            this.yfC.clear();
        }
        if (aw.RK()) {
            aw.Rg().b(605, (f) this);
            z.aeR().d(this);
            ((j) g.K(j.class)).XM().b(this);
        }
        AppMethodBeat.o(29147);
    }

    public void onPause() {
        AppMethodBeat.i(29148);
        super.onPause();
        AppMethodBeat.o(29148);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return R.layout.a99;
    }

    private boolean aAk() {
        AppMethodBeat.i(29149);
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            AppMethodBeat.o(29149);
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.toUserName = intent.getStringExtra("toUserName");
        if (bo.isNullOrNil(this.toUserName)) {
            ab.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            AppMethodBeat.o(29149);
            return false;
        }
        this.extInfo = intent.getStringExtra(IssueStorage.COLUMN_EXT_INFO);
        this.cvd = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.yfI = intent.getIntExtra("jump_profile_type", 0);
        switch (this.cvd) {
            case 1:
                if (!bo.isNullOrNil(this.appId)) {
                    this.fromScene = 68;
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        this.yfC = new LinkedList();
                        for (int i = 0; i < stringArrayListExtra.size(); i++) {
                            String str = (String) stringArrayListExtra.get(i);
                            if (!bo.isNullOrNil(str)) {
                                ab.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", Integer.valueOf(i), str);
                                this.yfC.add(aa.vy(str));
                            }
                        }
                        if (this.yfC.size() != 0) {
                            this.yfB = this.yfC.size();
                            break;
                        }
                        ab.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        AppMethodBeat.o(29149);
                        return false;
                    }
                    ab.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                    AppMethodBeat.o(29149);
                    return false;
                }
                ab.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                AppMethodBeat.o(29149);
                return false;
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                ab.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", Integer.valueOf(this.cvd));
                AppMethodBeat.o(29149);
                return false;
        }
        this.cyv = intent.getStringExtra("fromURL");
        AppMethodBeat.o(29149);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(29150);
        ab.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (mVar.getType() != 605) {
            if (mVar.getType() == d.MIC_PTU_MEISHI) {
                aw.Rg().b((int) d.MIC_PTU_MEISHI, (f) this);
                if (i == 0 && i2 == 0) {
                    h hVar = (h) mVar;
                    int aiV = hVar.aiV();
                    ab.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", Integer.valueOf(aiV));
                    if (aiV == 15) {
                        ab.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", Integer.valueOf(aiV), hVar.aiT());
                        com.tencent.mm.sdk.b.b heVar = new he();
                        heVar.cBW.actionCode = aiV;
                        heVar.cBW.result = r1;
                        heVar.cBW.context = this;
                        com.tencent.mm.sdk.b.a.xxA.a(heVar, Looper.myLooper());
                        finish();
                        AppMethodBeat.o(29150);
                        return;
                    }
                    dws();
                    AppMethodBeat.o(29150);
                    return;
                }
                dws();
                AppMethodBeat.o(29150);
                return;
            }
            ab.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", Integer.valueOf(mVar.getType()));
        }
        AppMethodBeat.o(29150);
    }

    private synchronized void dwq() {
        AppMethodBeat.i(29151);
        ab.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.yfD);
        Intent intent;
        if (this.scene == 1) {
            intent = new Intent();
            intent.putExtra("rawUrl", this.yfH);
            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
            AppMethodBeat.o(29151);
        } else if (this.scene == 0 && this.yfI == 1) {
            if (this.yfF) {
                ab.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
                AppMethodBeat.o(29151);
            } else {
                this.yfF = true;
                aw.Rg().a((int) d.MIC_PTU_MEISHI, (f) this);
                aw.Rg().a(new h(this.extInfo, null, 4, 0, (int) System.currentTimeMillis(), new byte[0]), 0);
                AppMethodBeat.o(29151);
            }
        } else if (dwr() && this.yfD) {
            if (!this.yfF) {
                ab.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                intent = new Intent().putExtra("Chat_User", this.toUserName);
                intent.putExtra("finish_direct", true);
                if (bo.isNullOrNil(this.toUserName)) {
                    e.a(intent, this.toUserName);
                }
                intent.setClass(this, ChattingUI.class);
                if (!this.yfE) {
                    setResult(-1);
                    this.yfF = true;
                    startActivity(intent);
                    finish();
                }
            }
            AppMethodBeat.o(29151);
        } else {
            if (this.yfD && !this.yfF) {
                ab.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
                ad aoO = ((j) g.K(j.class)).XM().aoO(this.toUserName);
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", this.fromScene);
                intent2.putExtra("Verify_ticket", this.mGZ);
                if (aoO != null) {
                    intent2.putExtra("Contact_Alias", aoO.Hq());
                    intent2.putExtra("Contact_Nick", aoO.field_nickname);
                    intent2.putExtra("Contact_Signature", aoO.signature);
                    intent2.putExtra("Contact_RegionCode", aoO.dui);
                    intent2.putExtra("Contact_Sex", aoO.dtS);
                    intent2.putExtra("Contact_VUser_Info", aoO.duh);
                    intent2.putExtra("Contact_VUser_Info_Flag", aoO.field_verifyFlag);
                    intent2.putExtra("Contact_KWeibo_flag", aoO.field_weiboFlag);
                    intent2.putExtra("Contact_KWeibo", aoO.dug);
                    intent2.putExtra("Contact_KWeiboNick", aoO.field_weiboNickname);
                }
                e.r(intent2, this.toUserName);
                if (!this.yfE) {
                    setResult(-1);
                    this.yfF = true;
                    com.tencent.mm.bp.d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    finish();
                }
            }
            AppMethodBeat.o(29151);
        }
    }

    private synchronized boolean dwr() {
        boolean z;
        Object obj;
        AppMethodBeat.i(29152);
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.toUserName);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            ab.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
            obj = 1;
        } else {
            obj = null;
        }
        com.tencent.mm.aj.d dVar = null;
        if (obj == null) {
            dVar = com.tencent.mm.aj.f.qX(this.toUserName);
        }
        if (dVar == null || dVar.adJ()) {
            ab.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + dVar + ") is null or should update.");
            obj = 1;
        }
        if (this.yfG) {
            if (aoO == null) {
                this.yfD = false;
                setResult(5);
                dwt();
                finish();
                AppMethodBeat.o(29152);
                z = false;
            } else {
                this.yfD = true;
                this.foa = true;
                if (!com.tencent.mm.n.a.jh(aoO.field_type)) {
                    AppMethodBeat.o(29152);
                    z = false;
                }
                this.yfD = true;
                this.foa = true;
                AppMethodBeat.o(29152);
                z = true;
            }
        } else if (obj != null) {
            if (this.yfD) {
                setResult(5);
                dwt();
                finish();
            } else {
                ao.a.flu.a(this.toUserName, "", new ao.b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(29141);
                        if (!z) {
                            CheckCanSubscribeBizUI.this.yfG = true;
                            CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
                        }
                        AppMethodBeat.o(29141);
                    }
                });
            }
            AppMethodBeat.o(29152);
            z = false;
        } else {
            if (!com.tencent.mm.n.a.jh(aoO.field_type)) {
                ab.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
                this.yfD = true;
                AppMethodBeat.o(29152);
                z = false;
            }
            this.yfD = true;
            this.foa = true;
            AppMethodBeat.o(29152);
            z = true;
        }
        return z;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(29153);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.yfE = true;
            if (this.yfF) {
                AppMethodBeat.o(29153);
                return true;
            }
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(29153);
        return onKeyDown;
    }

    private void dws() {
        AppMethodBeat.i(29154);
        Toast.makeText(this, getString(R.string.f0m), 1).show();
        bpI();
        AppMethodBeat.o(29154);
    }

    private void dwt() {
        AppMethodBeat.i(29155);
        Toast.makeText(this, R.string.dmd, 1).show();
        bpI();
        AppMethodBeat.o(29155);
    }

    private void bpI() {
        AppMethodBeat.i(29156);
        if (this.cvd == 1) {
            LauncherUI.ho(this);
        }
        AppMethodBeat.o(29156);
    }

    public final void a(final String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(29157);
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29143);
                ab.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.this.toUserName + ", userName = " + str);
                if (CheckCanSubscribeBizUI.this.toUserName.equals(str)) {
                    CheckCanSubscribeBizUI.this.yfD = true;
                    if (!CheckCanSubscribeBizUI.this.foa) {
                        CheckCanSubscribeBizUI.b(CheckCanSubscribeBizUI.this);
                    }
                }
                AppMethodBeat.o(29143);
            }
        });
        AppMethodBeat.o(29157);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(29158);
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(29158);
            return;
        }
        a((String) obj, null);
        AppMethodBeat.o(29158);
    }
}

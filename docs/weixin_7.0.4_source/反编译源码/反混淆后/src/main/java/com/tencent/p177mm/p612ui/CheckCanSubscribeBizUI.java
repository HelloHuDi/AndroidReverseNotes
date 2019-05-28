package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C26151he;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C23433qt;
import com.tencent.p177mm.protocal.protobuf.C23434qu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.CheckCanSubscribeBizUI */
public class CheckCanSubscribeBizUI extends MMActivity implements C1202f, C4931a, C4937b {
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

    /* renamed from: com.tencent.mm.ui.CheckCanSubscribeBizUI$1 */
    class C413401 implements C9636a {
        C413401() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(29141);
            if (!z) {
                CheckCanSubscribeBizUI.this.yfG = true;
                CheckCanSubscribeBizUI.m79832b(CheckCanSubscribeBizUI.this);
            }
            AppMethodBeat.m2505o(29141);
        }
    }

    /* renamed from: com.tencent.mm.ui.CheckCanSubscribeBizUI$2 */
    class C442332 implements C1224a {
        C442332() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(29142);
            C23434qu c23434qu = (C23434qu) c7472b.fsH.fsP;
            CheckCanSubscribeBizUI.this.mGZ = c23434qu.vXO;
            if (i == 0 && i2 == 0 && !C5046bo.isNullOrNil(c23434qu.vXO) && !C5046bo.isNullOrNil(c23434qu.ndF)) {
                CheckCanSubscribeBizUI.this.toUserName = c23434qu.ndF;
                CheckCanSubscribeBizUI.this.yfH = c23434qu.vXP;
                CheckCanSubscribeBizUI.m79832b(CheckCanSubscribeBizUI.this);
                AppMethodBeat.m2505o(29142);
            } else if (C30784a.m49123a(CheckCanSubscribeBizUI.this, i, i2, str, 7)) {
                CheckCanSubscribeBizUI.this.setResult(5);
                CheckCanSubscribeBizUI.this.finish();
                AppMethodBeat.m2505o(29142);
            } else {
                CheckCanSubscribeBizUI.m79834c(CheckCanSubscribeBizUI.this);
                CheckCanSubscribeBizUI.this.setResult(3);
                CheckCanSubscribeBizUI.this.finish();
                AppMethodBeat.m2505o(29142);
            }
            return 0;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m79832b(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        AppMethodBeat.m2504i(29159);
        checkCanSubscribeBizUI.dwq();
        AppMethodBeat.m2505o(29159);
    }

    /* renamed from: c */
    static /* synthetic */ void m79834c(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        AppMethodBeat.m2504i(29160);
        checkCanSubscribeBizUI.dws();
        AppMethodBeat.m2505o(29160);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29144);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.m2505o(29144);
            return;
        }
        C9638aw.m17182Rg().mo14539a(605, (C1202f) this);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this);
        C41747z.aeR().mo10116c(this);
        if (aAk()) {
            String str = this.appId;
            String str2 = this.toUserName;
            String str3 = this.extInfo;
            int i = this.yfB;
            LinkedList linkedList = this.yfC;
            String str4 = this.cyv;
            int i2 = this.cvd;
            int i3 = this.scene;
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new C23433qt();
            c1196a.fsK = new C23434qu();
            c1196a.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            c1196a.fsI = 605;
            C7472b acD = c1196a.acD();
            C23433qt c23433qt = (C23433qt) acD.fsG.fsP;
            c23433qt.mZr = str;
            c23433qt.ndF = str2;
            c23433qt.ndT = str3;
            c23433qt.vXK = i;
            c23433qt.vXL = linkedList;
            c23433qt.vXM = null;
            c23433qt.vXN = str4;
            c23433qt.vFH = i2;
            c23433qt.Scene = i3;
            C4990ab.m7417i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i3));
            C1226w.m2654a(acD, new C442332());
            AppMethodBeat.m2505o(29144);
            return;
        }
        setResult(2);
        dwt();
        finish();
        AppMethodBeat.m2505o(29144);
    }

    public void onStart() {
        AppMethodBeat.m2504i(29145);
        super.onStart();
        AppMethodBeat.m2505o(29145);
    }

    public void onResume() {
        AppMethodBeat.m2504i(29146);
        super.onResume();
        AppMethodBeat.m2505o(29146);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(29147);
        super.onDestroy();
        if (this.yfC != null) {
            this.yfC.clear();
        }
        if (C9638aw.m17179RK()) {
            C9638aw.m17182Rg().mo14546b(605, (C1202f) this);
            C41747z.aeR().mo10117d(this);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        }
        AppMethodBeat.m2505o(29147);
    }

    public void onPause() {
        AppMethodBeat.m2504i(29148);
        super.onPause();
        AppMethodBeat.m2505o(29148);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return 2130969910;
    }

    private boolean aAk() {
        AppMethodBeat.m2504i(29149);
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            AppMethodBeat.m2505o(29149);
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.toUserName = intent.getStringExtra("toUserName");
        if (C5046bo.isNullOrNil(this.toUserName)) {
            C4990ab.m7412e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            AppMethodBeat.m2505o(29149);
            return false;
        }
        this.extInfo = intent.getStringExtra(IssueStorage.COLUMN_EXT_INFO);
        this.cvd = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.yfI = intent.getIntExtra("jump_profile_type", 0);
        switch (this.cvd) {
            case 1:
                if (!C5046bo.isNullOrNil(this.appId)) {
                    this.fromScene = 68;
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        this.yfC = new LinkedList();
                        for (int i = 0; i < stringArrayListExtra.size(); i++) {
                            String str = (String) stringArrayListExtra.get(i);
                            if (!C5046bo.isNullOrNil(str)) {
                                C4990ab.m7417i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", Integer.valueOf(i), str);
                                this.yfC.add(C1946aa.m4154vy(str));
                            }
                        }
                        if (this.yfC.size() != 0) {
                            this.yfB = this.yfC.size();
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        AppMethodBeat.m2505o(29149);
                        return false;
                    }
                    C4990ab.m7412e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                    AppMethodBeat.m2505o(29149);
                    return false;
                }
                C4990ab.m7412e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                AppMethodBeat.m2505o(29149);
                return false;
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                C4990ab.m7413e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", Integer.valueOf(this.cvd));
                AppMethodBeat.m2505o(29149);
                return false;
        }
        this.cyv = intent.getStringExtra("fromURL");
        AppMethodBeat.m2505o(29149);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(29150);
        C4990ab.m7410d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (c1207m.getType() != 605) {
            if (c1207m.getType() == C31128d.MIC_PTU_MEISHI) {
                C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
                if (i == 0 && i2 == 0) {
                    C6681h c6681h = (C6681h) c1207m;
                    int aiV = c6681h.aiV();
                    C4990ab.m7417i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", Integer.valueOf(aiV));
                    if (aiV == 15) {
                        C4990ab.m7411d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", Integer.valueOf(aiV), c6681h.aiT());
                        C4883b c26151he = new C26151he();
                        c26151he.cBW.actionCode = aiV;
                        c26151he.cBW.result = r1;
                        c26151he.cBW.context = this;
                        C4879a.xxA.mo10048a(c26151he, Looper.myLooper());
                        finish();
                        AppMethodBeat.m2505o(29150);
                        return;
                    }
                    dws();
                    AppMethodBeat.m2505o(29150);
                    return;
                }
                dws();
                AppMethodBeat.m2505o(29150);
                return;
            }
            C4990ab.m7413e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", Integer.valueOf(c1207m.getType()));
        }
        AppMethodBeat.m2505o(29150);
    }

    private synchronized void dwq() {
        AppMethodBeat.m2504i(29151);
        C4990ab.m7416i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.yfD);
        Intent intent;
        if (this.scene == 1) {
            intent = new Intent();
            intent.putExtra("rawUrl", this.yfH);
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
            AppMethodBeat.m2505o(29151);
        } else if (this.scene == 0 && this.yfI == 1) {
            if (this.yfF) {
                C4990ab.m7416i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
                AppMethodBeat.m2505o(29151);
            } else {
                this.yfF = true;
                C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
                C9638aw.m17182Rg().mo14541a(new C6681h(this.extInfo, null, 4, 0, (int) System.currentTimeMillis(), new byte[0]), 0);
                AppMethodBeat.m2505o(29151);
            }
        } else if (dwr() && this.yfD) {
            if (!this.yfF) {
                C4990ab.m7416i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                intent = new Intent().putExtra("Chat_User", this.toUserName);
                intent.putExtra("finish_direct", true);
                if (C5046bo.isNullOrNil(this.toUserName)) {
                    C36249e.m59677a(intent, this.toUserName);
                }
                intent.setClass(this, ChattingUI.class);
                if (!this.yfE) {
                    setResult(-1);
                    this.yfF = true;
                    startActivity(intent);
                    finish();
                }
            }
            AppMethodBeat.m2505o(29151);
        } else {
            if (this.yfD && !this.yfF) {
                C4990ab.m7416i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.toUserName);
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", this.fromScene);
                intent2.putExtra("Verify_ticket", this.mGZ);
                if (aoO != null) {
                    intent2.putExtra("Contact_Alias", aoO.mo14673Hq());
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
                C36249e.m59678r(intent2, this.toUserName);
                if (!this.yfE) {
                    setResult(-1);
                    this.yfF = true;
                    C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    finish();
                }
            }
            AppMethodBeat.m2505o(29151);
        }
    }

    private synchronized boolean dwr() {
        boolean z;
        Object obj;
        AppMethodBeat.m2504i(29152);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.toUserName);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            C4990ab.m7420w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
            obj = 1;
        } else {
            obj = null;
        }
        C16527d c16527d = null;
        if (obj == null) {
            c16527d = C17903f.m28104qX(this.toUserName);
        }
        if (c16527d == null || c16527d.adJ()) {
            C4990ab.m7412e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + c16527d + ") is null or should update.");
            obj = 1;
        }
        if (this.yfG) {
            if (aoO == null) {
                this.yfD = false;
                setResult(5);
                dwt();
                finish();
                AppMethodBeat.m2505o(29152);
                z = false;
            } else {
                this.yfD = true;
                this.foa = true;
                if (!C7486a.m12942jh(aoO.field_type)) {
                    AppMethodBeat.m2505o(29152);
                    z = false;
                }
                this.yfD = true;
                this.foa = true;
                AppMethodBeat.m2505o(29152);
                z = true;
            }
        } else if (obj != null) {
            if (this.yfD) {
                setResult(5);
                dwt();
                finish();
            } else {
                C26417a.flu.mo20966a(this.toUserName, "", new C413401());
            }
            AppMethodBeat.m2505o(29152);
            z = false;
        } else {
            if (!C7486a.m12942jh(aoO.field_type)) {
                C4990ab.m7420w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
                this.yfD = true;
                AppMethodBeat.m2505o(29152);
                z = false;
            }
            this.yfD = true;
            this.foa = true;
            AppMethodBeat.m2505o(29152);
            z = true;
        }
        return z;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(29153);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.yfE = true;
            if (this.yfF) {
                AppMethodBeat.m2505o(29153);
                return true;
            }
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(29153);
        return onKeyDown;
    }

    private void dws() {
        AppMethodBeat.m2504i(29154);
        Toast.makeText(this, getString(C25738R.string.f0m), 1).show();
        bpI();
        AppMethodBeat.m2505o(29154);
    }

    private void dwt() {
        AppMethodBeat.m2504i(29155);
        Toast.makeText(this, C25738R.string.dmd, 1).show();
        bpI();
        AppMethodBeat.m2505o(29155);
    }

    private void bpI() {
        AppMethodBeat.m2504i(29156);
        if (this.cvd == 1) {
            LauncherUI.m59303ho(this);
        }
        AppMethodBeat.m2505o(29156);
    }

    /* renamed from: a */
    public final void mo5248a(final String str, C4935m c4935m) {
        AppMethodBeat.m2504i(29157);
        new C7306ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(29143);
                C4990ab.m7410d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.this.toUserName + ", userName = " + str);
                if (CheckCanSubscribeBizUI.this.toUserName.equals(str)) {
                    CheckCanSubscribeBizUI.this.yfD = true;
                    if (!CheckCanSubscribeBizUI.this.foa) {
                        CheckCanSubscribeBizUI.m79832b(CheckCanSubscribeBizUI.this);
                    }
                }
                AppMethodBeat.m2505o(29143);
            }
        });
        AppMethodBeat.m2505o(29157);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(29158);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(29158);
            return;
        }
        mo5248a((String) obj, null);
        AppMethodBeat.m2505o(29158);
    }
}

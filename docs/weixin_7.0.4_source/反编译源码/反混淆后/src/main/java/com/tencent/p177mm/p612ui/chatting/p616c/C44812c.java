package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.plugin.p825a.C25808a;
import com.tencent.p177mm.chatroom.p216ui.ChatroomInfoUI;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16530c;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e.C25765a;
import com.tencent.p177mm.p184aj.C25764e.C25765a.C25766a;
import com.tencent.p177mm.p184aj.C25764e.C25765a.C8934b;
import com.tencent.p177mm.p184aj.C25772n;
import com.tencent.p177mm.p184aj.C32237a;
import com.tencent.p177mm.p184aj.C37455j;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C25759h;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8923a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8924b;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p199ax.C6328d;
import com.tencent.p177mm.p202bf.C25858d;
import com.tencent.p177mm.p230g.p231a.C18247ed;
import com.tencent.p177mm.p230g.p231a.C45358pm;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.bizchat.BizChatroomInfoUI;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C35868e;
import com.tencent.p177mm.protocal.protobuf.C23406kf;
import com.tencent.p177mm.protocal.protobuf.C23407kg;
import com.tencent.p177mm.protocal.protobuf.bxk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C40635r;
import com.tencent.p177mm.storage.C40635r.C40633a;
import com.tencent.p177mm.storage.C40635r.C40639b;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@C15590a(dFp = C36135d.class)
/* renamed from: com.tencent.mm.ui.chatting.c.c */
public class C44812c extends C44291a implements C25772n, C36135d {
    private bxk fwz = null;
    public boolean mgP = false;
    private C16527d pkW;
    private C5653c pmG = null;
    public C45143j pmx;
    public C45142c yDI;
    private C25753a yEn = new C407279();
    protected final C35868e yGx = new C448148();
    protected final C30473a yHz = new C361381();
    private C25808a yNW;
    private long yNX = 0;
    private C7620bi yNY;
    public boolean yNZ = false;
    private long yOa = -1;
    private RelativeLayout yOb;
    private TextView yOc;
    private int yOd;
    private boolean yOe = false;
    private boolean yOf = false;
    private C25765a yOg = new C2373510();
    private boolean yOh = false;

    /* renamed from: com.tencent.mm.ui.chatting.c.c$15 */
    class C1561515 implements Runnable {
        C1561515() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31207);
            if (C44812c.this.cgL == null) {
                AppMethodBeat.m2505o(31207);
                return;
            }
            boolean isInEditMode = ((C15612h) C44812c.this.cgL.mo74857aF(C15612h.class)).isInEditMode();
            if (C44812c.this.mgP && !isInEditMode) {
                C25754e.m40895d(C44812c.this.yDI);
            }
            AppMethodBeat.m2505o(31207);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$5 */
    class C156165 implements OnClickListener {
        C156165() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$7 */
    class C156177 implements Runnable {
        C156177() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31198);
            long currentTimeMillis = System.currentTimeMillis();
            if (!C44812c.this.mgP || C44812c.this.yDI == null || C44812c.this.cgL.sRl == null) {
                C4990ab.m7417i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", C44812c.this.yDI, C44812c.this.cgL.sRl);
            } else {
                C44812c.m81958f(C44812c.this);
                C41747z.afe();
                C45142c c45142c = C44812c.this.yDI;
                if (C1668a.m3404jP(C1720g.m3534RN().eIV)) {
                    C37951y.m64164b(c45142c.field_brandUserName, 7, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{c45142c.field_brandUserName, c45142c.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                    C4990ab.m7411d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", r3);
                }
                if (C44812c.this.yNZ) {
                    if (C44812c.this.yDI.afh()) {
                        C41747z.aeZ();
                        C25759h.m40925aH(C44812c.this.yDI.field_bizChatServId, C44812c.this.cgL.sRl.field_username);
                    } else {
                        C25754e.m40897f(C44812c.this.yDI);
                    }
                }
                C44812c.m81960g(C44812c.this);
            }
            C4990ab.m7411d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(31198);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$10 */
    class C2373510 implements C25765a {
        C2373510() {
        }

        /* renamed from: a */
        public final void mo11091a(final C8934b c8934b) {
            AppMethodBeat.m2504i(31202);
            if (c8934b != null && c8934b.fwk == C25766a.UPDATE && c8934b.fuO != null && c8934b.fuO.equals(C44812c.this.cgL.getTalkerUserName())) {
                C9638aw.m17190ZK();
                final C7616ad aoO = C18628c.m29078XM().aoO(c8934b.fuO);
                if (aoO == null || ((int) aoO.ewQ) == 0) {
                    C4990ab.m7417i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", c8934b.fuO);
                    AppMethodBeat.m2505o(31202);
                    return;
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(31201);
                        if (C44812c.this.yOe && c8934b.fuO.equals(C44812c.this.cgL.getTalkerUserName())) {
                            C4990ab.m7416i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                            C44812c.this.pkW = C17903f.m28104qX(c8934b.fuO);
                            if (C44812c.this.cgL != null && C44812c.this.yOf) {
                                ((C15614o) C44812c.this.cgL.mo74857aF(C15614o.class)).mo27832ae(aoO);
                            }
                        }
                        AppMethodBeat.m2505o(31201);
                    }
                });
            }
            AppMethodBeat.m2505o(31202);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$a */
    public interface C30473a {
        boolean dDC();
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$1 */
    class C361381 implements C30473a {

        /* renamed from: com.tencent.mm.ui.chatting.c.c$1$1 */
        class C361391 implements Runnable {
            C361391() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31194);
                if (!(C44812c.this.yOb == null || C44812c.this.yOb.getVisibility() == 8)) {
                    C44812c.this.yOb.setVisibility(8);
                }
                if (C44812c.this.cgL == null) {
                    C4990ab.m7412e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
                    AppMethodBeat.m2505o(31194);
                    return;
                }
                ((C44299r) C44812c.this.cgL.mo74857aF(C44299r.class)).dEm();
                C44812c.this.cgL.aWv();
                AppMethodBeat.m2505o(31194);
            }
        }

        C361381() {
        }

        public final boolean dDC() {
            AppMethodBeat.m2504i(31195);
            if (C44812c.this.yOb == null) {
                C40729i.m70424a(C44812c.this.cgL.yTx, 2131822379);
                C44812c.this.yOb = (RelativeLayout) C44812c.this.cgL.findViewById(2131822725);
                C44812c.this.yOc = (TextView) C44812c.this.cgL.findViewById(2131822726);
                C44812c.this.yOc.setText(C25738R.string.aj9);
            }
            C44812c.this.yOb.setVisibility(0);
            C46650a.dFz().postDelayed(new C361391(), 5000);
            AppMethodBeat.m2505o(31195);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$2 */
    class C361402 implements OnClickListener {
        C361402() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$3 */
    class C361413 implements OnClickListener {
        C361413() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$9 */
    class C407279 implements C25753a {
        C407279() {
        }

        /* renamed from: a */
        public final void mo15833a(C8924b c8924b) {
            AppMethodBeat.m2504i(31200);
            if (C44812c.this.mgP && c8924b != null && c8924b.fxq == C44812c.this.dDz()) {
                if (!C44812c.this.cgL.caA) {
                    C4990ab.m7416i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
                    AppMethodBeat.m2505o(31200);
                    return;
                } else if (c8924b.fxA != C8923a.DELETE) {
                    C4990ab.m7416i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
                    C44812c.this.yDI = C41747z.aeT().mo60349aK(C44812c.this.dDz());
                    if (C44812c.this.yNZ) {
                        C44812c.this.yOh = C25754e.m40893c(C44812c.this.yDI);
                        ((C44299r) C44812c.this.cgL.mo74857aF(C44299r.class)).dEp();
                    } else {
                        C45143j cH = C41747z.aeV().mo60356cH(C44812c.this.yDI.field_bizChatServId);
                        if (cH != null) {
                            C44812c.this.pmx = cH;
                        }
                    }
                    ((C44299r) C44812c.this.cgL.mo74857aF(C44299r.class)).dEm();
                    AppMethodBeat.m2505o(31200);
                    return;
                } else if (C44812c.this.yNZ) {
                    Toast.makeText(C4996ah.getContext(), C44812c.this.cgL.yTx.getMMResources().getString(C25738R.string.dsd), 1).show();
                    C44812c.this.cgL.yTx.dBP();
                }
            }
            AppMethodBeat.m2505o(31200);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$11 */
    class C4430011 implements Runnable {
        C4430011() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31203);
            C45358pm c45358pm = new C45358pm();
            if (C44812c.this.pkW != null) {
                c45358pm.cLH.userName = C44812c.this.pkW.field_username;
                C4879a.xxA.mo10055m(c45358pm);
            }
            AppMethodBeat.m2505o(31203);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$12 */
    class C4430112 implements Runnable {
        C4430112() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31204);
            if (!C7486a.m12942jh(C44812c.this.cgL.sRl.field_type) && C44812c.this.cgL.sRl.dsf()) {
                C44812c.this.cgL.yTx.setMMSubTitle((int) C25738R.string.ak3);
            }
            AppMethodBeat.m2505o(31204);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$14 */
    class C4481314 implements OnClickListener {
        C4481314() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31206);
            C44812c.this.pkW.field_hadAlert = 1;
            C16527d c = C44812c.this.pkW;
            if (c != null) {
                c.field_brandFlag &= -5;
                C17903f.m28100g(c);
            }
            C41747z.afc().mo43734rj(C44812c.this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31206);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c$8 */
    class C448148 implements C35868e {
        C448148() {
        }

        /* renamed from: oS */
        public final boolean mo48814oS(boolean z) {
            AppMethodBeat.m2504i(31199);
            if (C44812c.this.pkW == null) {
                AppMethodBeat.m2505o(31199);
                return false;
            }
            C16529b cJ = C44812c.this.pkW.mo30481cJ(false);
            if (cJ == null) {
                AppMethodBeat.m2505o(31199);
                return false;
            }
            C16530c aeo = cJ.aeo();
            if (aeo == null || aeo.fvL == null || aeo.fvL.isEmpty()) {
                AppMethodBeat.m2505o(31199);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(((C37455j) aeo.fvL.get(0)).value);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE;
                appBrandStatObject.cst = C44812c.this.pkW.field_username;
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(C44812c.this.cgL.yTx.getContext(), jSONObject.optString("userName"), null, 0, 0, jSONObject.optString("pagePath"), appBrandStatObject, C44812c.this.pkW.field_appId);
                AppMethodBeat.m2505o(31199);
                return true;
            } catch (JSONException e) {
                AppMethodBeat.m2505o(31199);
                return false;
            }
        }
    }

    public C44812c() {
        AppMethodBeat.m2504i(31208);
        AppMethodBeat.m2505o(31208);
    }

    public final C16527d dDj() {
        return this.pkW;
    }

    public final C45142c dDk() {
        return this.yDI;
    }

    public final C45143j dDl() {
        return this.pmx;
    }

    public final boolean dDm() {
        return this.mgP;
    }

    public final boolean dDn() {
        return this.yNZ;
    }

    /* renamed from: aU */
    public static boolean m81953aU(Intent intent) {
        AppMethodBeat.m2504i(31209);
        String stringExtra = intent.getStringExtra("Chat_User");
        boolean booleanExtra = intent.getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
            AppMethodBeat.m2505o(31209);
            return true;
        } else if (booleanExtra && intent.getLongExtra("key_biz_chat_id", -1) == -1) {
            C4990ab.m7412e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
            AppMethodBeat.m2505o(31209);
            return true;
        } else {
            AppMethodBeat.m2505o(31209);
            return false;
        }
    }

    public final boolean dDo() {
        AppMethodBeat.m2504i(31210);
        if (this.mgP) {
            if (this.yNZ) {
                int fB = C25754e.m40898fB(dDz());
                if (!C5046bo.isNullOrNil(this.yDI.field_chatName)) {
                    ((C44299r) this.cgL.mo74857aF(C44299r.class)).mo64255M(this.cgL.yTx.getMMResources().getString(C25738R.string.bwu, new Object[]{this.yDI.field_chatName, Integer.valueOf(fB)}));
                } else if (fB == 0) {
                    this.cgL.yTx.setMMTitle(this.cgL.yTx.getMMResources().getString(C25738R.string.ao1));
                } else {
                    this.cgL.yTx.setMMTitle(this.cgL.yTx.getMMResources().getString(C25738R.string.bwu, new Object[]{this.cgL.yTx.getMMResources().getString(C25738R.string.ao1), Integer.valueOf(fB)}));
                }
            } else {
                this.cgL.yTx.setMMTitle(this.pmx.field_userName);
            }
            AppMethodBeat.m2505o(31210);
            return true;
        }
        AppMethodBeat.m2505o(31210);
        return false;
    }

    public final C30473a dDp() {
        return this.yHz;
    }

    public final C35868e dDq() {
        return this.yGx;
    }

    /* renamed from: ru */
    public final String mo57024ru(String str) {
        AppMethodBeat.m2504i(31211);
        C45143j ro = this.yDI.mo73054ro(str);
        if (ro != null) {
            String str2 = ro.field_headImageUrl;
            AppMethodBeat.m2505o(31211);
            return str2;
        }
        AppMethodBeat.m2505o(31211);
        return null;
    }

    public final List<C7620bi> dDr() {
        int i = 100;
        AppMethodBeat.m2504i(31212);
        C32232a fv = C41747z.aeU().mo60340fv(dDz());
        if (fv.field_unReadCount <= 100) {
            i = fv.field_unReadCount;
        }
        C9638aw.m17190ZK();
        List o = C18628c.m29081XP().mo74802o(this.cgL.sRl.field_username, dDz(), i);
        AppMethodBeat.m2505o(31212);
        return o;
    }

    public final boolean dDs() {
        return this.yOh;
    }

    private void djt() {
        int currentTimeMillis;
        AppMethodBeat.m2504i(31213);
        C1831bh.m3767A("bizflag", false);
        if (this.mgP) {
            dDB();
            C41747z.afe();
            C45142c c45142c = this.yDI;
            if (C1668a.m3404jP(C1720g.m3534RN().eIV)) {
                C37951y.m64164b(c45142c.field_brandUserName, 8, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{c45142c.field_brandUserName, c45142c.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                C4990ab.m7411d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", r2);
            }
        }
        if (this.yNX != 0) {
            currentTimeMillis = ((int) (System.currentTimeMillis() - this.yNX)) / 1000;
        } else {
            currentTimeMillis = 0;
        }
        if (C9638aw.m17179RK()) {
            if (this.mgP) {
                C41747z.aeT().mo60346a(this.yEn);
            }
            if (this.cgL.sRl != null && this.cgL.sRl.dsf()) {
                C41747z.aeR().mo43721a(this.yOg);
            }
            if (C7486a.m12942jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && !C17903f.m28103kq(this.cgL.getTalkerUserName())) {
                if (this.pkW != null && this.pkW.adM()) {
                    if (this.fwz == null) {
                        this.fwz = new bxk();
                    }
                    this.fwz.wXr = currentTimeMillis;
                    this.fwz.wXv = this.cgL.yTx.getIntExtra("Main_IndexInSessionList", 0);
                    this.fwz.wXt = this.cgL.yTx.getIntExtra("Main_UnreadCount", 0);
                    if (this.yNY != null) {
                        this.fwz.wXu = this.yNY.getType();
                        if (this.fwz.wXt > 0) {
                            this.fwz.wXs = ((int) (this.yNX - this.yNY.field_createTime)) / 1000;
                        }
                    }
                }
                C41747z.afc().mo43731a(this.cgL.getTalkerUserName(), this.fwz);
            }
        }
        if (C25808a.m41064a(this.pkW) && this.yNW != null) {
            C4990ab.m7417i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", dDw());
            this.yNW.mo43758a(2, this.pkW);
            this.cgL.yTx.setMMSubTitle(null);
        }
        if (C7486a.m12942jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && currentTimeMillis != 0) {
            int intExtra = this.cgL.yTx.getIntExtra("specific_chat_from_scene", 0);
            int sessionId = C30309s.getSessionId();
            C7060h.pYm.mo8381e(10638, this.cgL.getTalkerUserName(), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.cgL.yTx.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.cgL.yTx.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(intExtra), Integer.valueOf(sessionId));
        }
        if (this.yNW != null) {
            C25808a c25808a = this.yNW;
            C4990ab.m7410d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
            if (c25808a.cgM != null) {
                C4879a.xxA.mo10053d(c25808a.cgM);
                c25808a.cgM = null;
                if (c25808a.cgP != null) {
                    c25808a.cgP.clear();
                }
            }
            c25808a.cgQ = false;
            if (c25808a.cgN != null) {
                C4879a.xxA.mo10053d(c25808a.cgN);
                c25808a.cgN = null;
            }
            this.yNW = null;
        }
        C30309s.aom(null);
        this.yNX = 0;
        AppMethodBeat.m2505o(31213);
    }

    public final void dDt() {
        AppMethodBeat.m2504i(31214);
        if (this.pkW == null) {
            AppMethodBeat.m2505o(31214);
            return;
        }
        String string;
        final boolean z = (C26443d.agA() || C26443d.agB()) ? false : true;
        if (this.pkW.field_hadAlert == 0 && z) {
            string = this.cgL.yTx.getMMResources().getString(C25738R.string.ak5, new Object[]{this.cgL.sRl.mo16707Oj()});
        } else if (z) {
            string = this.cgL.yTx.getMMResources().getString(C25738R.string.ak6);
        } else {
            string = this.cgL.yTx.getMMResources().getString(C25738R.string.ak4, new Object[]{this.cgL.sRl.mo16707Oj()});
        }
        this.pmG = C30379h.m48440a(this.cgL.yTx.getContext(), string, this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(31205);
                C44812c.this.pkW.field_hadAlert = 1;
                C16527d c = C44812c.this.pkW;
                if (c != null) {
                    c.field_brandFlag |= 4;
                    C17903f.m28100g(c);
                }
                if (z) {
                    C44812c.this.cgL.yTx.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    AppMethodBeat.m2505o(31205);
                    return;
                }
                C41747z.afc().mo43734rj(C44812c.this.cgL.getTalkerUserName());
                AppMethodBeat.m2505o(31205);
            }
        }, new C4481314());
        AppMethodBeat.m2505o(31214);
    }

    public final void dDu() {
        AppMethodBeat.m2504i(31215);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", this.cgL.getTalkerUserName());
        intent.putExtra("key_start_biz_profile_setting_from_scene", 1);
        C25985d.m41467b(this.cgL.yTx.getContext(), Scopes.PROFILE, ".ui.newbizinfo.NewBizInfoSettingUI", intent);
        AppMethodBeat.m2505o(31215);
    }

    public final int dDv() {
        return this.yOd;
    }

    /* renamed from: f */
    private boolean m81959f(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(31216);
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (this.pkW == null || this.pkW.mo30481cJ(false) == null || this.pkW.mo30481cJ(false).aeo() == null || this.pkW.mo30481cJ(false).aeo().fvL == null || this.pkW.mo30481cJ(false).aeo().fvL.isEmpty())) {
            ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX().dkc();
        }
        AppMethodBeat.m2505o(31216);
        return false;
    }

    public final String dDw() {
        if (this.mgP) {
            if (this.yNZ) {
                if (this.yDI == null) {
                    return null;
                }
                return this.yDI.field_chatName;
            } else if (this.pmx != null) {
                return this.pmx.field_userName;
            } else {
                return null;
            }
        } else if (this.cgL.sRl != null) {
            return this.cgL.sRl.field_nickname;
        } else {
            return null;
        }
    }

    public final boolean dDx() {
        AppMethodBeat.m2504i(31217);
        Intent intent = new Intent(this.cgL.yTx.getContext(), ChatroomInfoUI.class);
        int i = (this.cgL.dFw() || this.yNZ) ? true : 0;
        if (i != 0 && !this.mgP) {
            intent.putExtra("Chat_User", this.cgL.sRl.field_username);
            intent.putExtra("RoomInfo_Id", this.cgL.getTalkerUserName());
            intent.putExtra("Is_Chatroom", this.cgL.dFw());
            intent.putExtra("fromChatting", true);
            this.cgL.startActivity(intent);
            AppMethodBeat.m2505o(31217);
            return true;
        } else if (this.mgP) {
            intent.setClass(this.cgL.yTx.getContext(), BizChatroomInfoUI.class);
            intent.putExtra("Chat_User", this.cgL.sRl.field_username);
            intent.putExtra("key_biz_chat_id", dDz());
            if (this.cgL.yTx.thisActivity() instanceof ChattingUI) {
                intent.putExtra("key_biz_chat_info_from_scene", 1);
            } else {
                intent.putExtra("key_biz_chat_info_from_scene", 2);
            }
            this.cgL.yTx.startActivity(intent);
            AppMethodBeat.m2505o(31217);
            return true;
        } else if (C1855t.m3920nF(this.cgL.getTalkerUserName()) || C7616ad.aou(this.cgL.getTalkerUserName()) || C7616ad.aow(this.cgL.getTalkerUserName()) || C1855t.m3916nB(this.cgL.getTalkerUserName()) || C7616ad.m13548mR(this.cgL.getTalkerUserName()) || this.cgL.sRl.dsf()) {
            boolean z;
            intent = new Intent();
            C36249e.m59678r(intent, this.cgL.getTalkerUserName());
            if (this.cgL.yTx.getIntExtra("chat_from_scene", 0) == 2) {
                intent.putExtra("Kdel_from", 2);
            } else {
                intent.putExtra("Kdel_from", 0);
            }
            intent.putExtra("chat_from_scene", this.cgL.yTx.getIntExtra("chat_from_scene", 0));
            intent.putExtra("preUsername", this.cgL.getTalkerUserName());
            intent.putExtra("preChatName", this.cgL.getTalkerUserName());
            i = (this.pkW == null || !this.pkW.adM()) ? 7 : 6;
            intent.putExtra("preChatTYPE", this.cgL.yTx.getIntExtra("preChatTYPE", i));
            Intent intent2 = this.cgL.yTx.getContext().getIntent();
            int intExtra = intent2.getIntExtra("key_temp_session_scene", 5);
            if (intExtra == 16 || intExtra == 17 || intent2.getBooleanExtra("key_biz_profile_stay_after_follow_op", false)) {
                intent.putExtra("Kdel_from", 1);
                z = true;
            } else {
                z = false;
            }
            intent.putExtra("key_biz_profile_stay_after_follow_op", z);
            if (((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL() && C40729i.arl(this.cgL.getTalkerUserName())) {
                if (intExtra == 16) {
                    intent.putExtra("Contact_Scene", 92);
                } else if (intExtra == 17) {
                    intent.putExtra("Contact_Scene", 93);
                } else if (intExtra == 18) {
                    intent.putExtra("Contact_Scene", 94);
                } else {
                    intent.putExtra("Contact_Scene", 81);
                }
            }
            if (this.cgL.getTalkerUserName().equals("gh_43f2581f6fd6")) {
                C22162d.m33785kT(2);
                C16841a.bVv();
                if (C1301c.m2776lQ(C32321b.fKF)) {
                    C16841a.bVt();
                    C6328d.m10412lR(C32321b.fKF);
                    intent.putExtra("key_from_wesport_right_newtips", true);
                }
            }
            intent.putExtra("KOpenArticleSceneFromScene", 0);
            C25985d.m41468b(this.cgL.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent, 213);
            AppMethodBeat.m2505o(31217);
            return true;
        } else {
            AppMethodBeat.m2505o(31217);
            return false;
        }
    }

    public final boolean dDy() {
        boolean z = false;
        AppMethodBeat.m2504i(31218);
        if (this.cgL == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
            AppMethodBeat.m2505o(31218);
            return false;
        }
        if (this.cgL.sRl.dsf() && this.pkW != null) {
            if (this.mgP) {
                z = C41747z.aeU().mo60342fx(dDz());
                AppMethodBeat.m2505o(31218);
                return z;
            } else if (this.pkW.adQ()) {
                if (!(this.pkW.mo30481cJ(false) == null || this.pkW.mo30481cJ(false).aer() == null || C5046bo.isNullOrNil(this.pkW.adX()))) {
                    C9638aw.m17190ZK();
                    C7617ak apn = C18628c.m29083XR().apn(this.pkW.adX());
                    if (apn != null && apn.field_username.equals(this.cgL.getTalkerUserName()) && apn.field_unReadCount > 0) {
                        if (this.cgL.yTx.getIntExtra("chat_from_scene", 0) == 2) {
                            AppMethodBeat.m2505o(31218);
                            return false;
                        }
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().apb(this.pkW.adX());
                    }
                }
            } else if (!(this.pkW.adM() || this.pkW.adO())) {
                if (C30309s.aVO()) {
                    C40635r aeX = C41747z.aeX();
                    C46627q drI = aeX.drI();
                    if (drI != null) {
                        z = aeX.mo64119mI(drI.field_orderFlag);
                    }
                    if (z <= false) {
                        C40635r aeX2 = C41747z.aeX();
                        aeX2.fni.mo10108hY("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + this.cgL.getTalkerUserName() + "' ");
                        C40633a c40633a = new C40633a();
                        c40633a.xId = C40639b.UPDATE;
                        aeX2.mo64099a(c40633a);
                    }
                } else {
                    C9638aw.m17190ZK();
                    C7617ak dsT = C18628c.m29083XR().dsT();
                    if (dsT != null && dsT.field_username.equals(this.cgL.getTalkerUserName()) && dsT.field_unReadCount > 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().apb("officialaccounts");
                    }
                }
            }
        }
        if (C1855t.m3956ny(this.cgL.getTalkerUserName())) {
            AppMethodBeat.m2505o(31218);
            return true;
        }
        C9638aw.m17190ZK();
        z = C18628c.m29083XR().apb(this.cgL.getTalkerUserName());
        AppMethodBeat.m2505o(31218);
        return z;
    }

    /* renamed from: a */
    public final void mo15832a(int i, C1207m c1207m) {
        AppMethodBeat.m2504i(31219);
        if (c1207m.getType() == 1357) {
            this.cgL.dismissDialog();
            if (i != 0) {
                Toast.makeText(C4996ah.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.dro), 0).show();
            }
        }
        AppMethodBeat.m2505o(31219);
    }

    public final long dDz() {
        return this.yDI == null ? -1 : this.yDI.field_bizChatLocalId;
    }

    public final void dDA() {
        AppMethodBeat.m2504i(31220);
        C9638aw.m17180RS().mo10310m(new C1561515(), 500);
        AppMethodBeat.m2505o(31220);
    }

    public final String ari(String str) {
        AppMethodBeat.m2504i(31221);
        if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (C7486a.m12942jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && this.pkW != null) {
                C16529b cJ = this.pkW.mo30481cJ(false);
                if (!(cJ == null || TextUtils.isEmpty(cJ.aen()) || !substring.contains(cJ.aen()))) {
                    AppMethodBeat.m2505o(31221);
                    return substring;
                }
            }
        }
        AppMethodBeat.m2505o(31221);
        return null;
    }

    /* renamed from: aH */
    public final void mo57004aH(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(31222);
        C41747z.aeT().mo60349aK(dDz());
        final LinkedList linkedList2 = new LinkedList();
        List afg = this.yDI.afg();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (afg != null && afg.contains(str)) {
                linkedList2.add(str);
            }
        }
        if (linkedList2.size() != 0) {
            C30379h.m48445a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.ds1, new Object[]{m81952aI(linkedList2)}), null, this.cgL.yTx.getMMResources().getString(C25738R.string.ds9), this.cgL.yTx.getMMResources().getString(C25738R.string.f9076or), true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(31196);
                    C23407kg c23407kg = new C23407kg();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < linkedList2.size()) {
                            C23406kf c23406kf = new C23406kf();
                            c23406kf.vNc = (String) linkedList2.get(i3);
                            c23407kg.vNd.add(c23406kf);
                            i2 = i3 + 1;
                        } else {
                            C44812c.m81950a(C44812c.this, c23407kg);
                            AppMethodBeat.m2505o(31196);
                            return;
                        }
                    }
                }
            }, new C156165());
            AppMethodBeat.m2505o(31222);
        } else if (linkedList.size() == 1) {
            C30379h.m48443a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.ds7), null, this.cgL.yTx.getMMResources().getString(C25738R.string.ds8), new C361402());
            AppMethodBeat.m2505o(31222);
        } else {
            C30379h.m48443a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.ds2), null, this.cgL.yTx.getMMResources().getString(C25738R.string.ds8), new C361413());
            AppMethodBeat.m2505o(31222);
        }
    }

    /* renamed from: aI */
    private String m81952aI(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(31223);
        if (linkedList.size() <= 0) {
            AppMethodBeat.m2505o(31223);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(this.yDI.mo73053mJ((String) linkedList.get(0)));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                stringBuilder.append(this.cgL.yTx.getContext().getString(C25738R.string.ajw)).append(this.yDI.mo73053mJ((String) linkedList.get(i2)));
                i = i2 + 1;
            } else {
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.m2505o(31223);
                return stringBuilder2;
            }
        }
    }

    private void dDB() {
        AppMethodBeat.m2504i(31224);
        if (this.mgP) {
            C41747z.aeZ();
            C25759h.m40926e(this.cgL.getTalkerUserName(), this.yDI.field_bizChatServId, (int) (System.currentTimeMillis() / 1000));
            AppMethodBeat.m2505o(31224);
            return;
        }
        AppMethodBeat.m2505o(31224);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(31225);
        boolean f = m81959f(keyEvent);
        AppMethodBeat.m2505o(31225);
        return f;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31226);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS /*12001*/:
                if (this.yNW != null) {
                    C25808a c25808a = this.yNW;
                    if (c25808a.cgL != null) {
                        if (i2 != -1) {
                            if (i2 == 0) {
                                Toast.makeText(c25808a.cgL.yTx.getContext(), C25738R.string.bgx, 0).show();
                                break;
                            }
                        }
                        Toast.makeText(c25808a.cgL.yTx.getContext(), C25738R.string.bgy, 0).show();
                        C18247ed c18247ed = new C18247ed();
                        c18247ed.cxE.f4320op = 0;
                        c18247ed.cxE.userName = c25808a.cgL.getTalkerUserName();
                        c18247ed.cxE.context = c25808a.cgL.yTx.getContext();
                        C4879a.xxA.mo10055m(c18247ed);
                        AppMethodBeat.m2505o(31226);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                    AppMethodBeat.m2505o(31226);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(31226);
    }

    public final void dxx() {
        boolean z = false;
        AppMethodBeat.m2504i(31227);
        this.yOa = this.cgL.yTx.getLongExtra("key_biz_chat_id", -1);
        this.mgP = this.cgL.yTx.getBooleanExtra("key_is_biz_chat", false).booleanValue();
        if (this.mgP) {
            this.yDI = C41747z.aeT().mo60349aK(this.yOa);
            this.yDI = C25754e.m40890a(this.yDI, this.yOa);
            this.yOd = C41747z.aeU().mo60340fv(dDz()).field_unReadCount;
        }
        if (this.mgP && C25754e.m40905rs(this.yDI.field_bizChatServId)) {
            z = true;
        }
        this.yNZ = z;
        if (this.mgP && !this.yNZ) {
            this.pmx = C41747z.aeV().mo60356cH(this.yDI.field_bizChatServId);
            this.pmx = C25754e.m40891a(this.pmx, this.yDI.field_bizChatServId);
        }
        if (this.yNZ) {
            this.yOh = C25754e.m40893c(this.yDI);
        }
        this.pkW = C17903f.m28104qX(this.cgL.getTalkerUserName());
        this.yOe = true;
        AppMethodBeat.m2505o(31227);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31229);
        if (C7486a.m12942jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && C7486a.m12942jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && !C17903f.m28103kq(this.cgL.getTalkerUserName())) {
            int intExtra = this.cgL.yTx.getIntExtra("specific_chat_from_scene", 0);
            if (this.fwz == null) {
                this.fwz = new bxk();
            }
            this.fwz.wXv = this.cgL.yTx.getIntExtra("Main_IndexInSessionList", 0);
            this.fwz.wXt = this.cgL.yTx.getIntExtra("Main_UnreadCount", 0);
            if (this.yNY != null) {
                this.fwz.wXu = this.yNY.getType();
                if (this.fwz.wXt > 0) {
                    this.fwz.wXs = ((int) (this.yNX - this.yNY.field_createTime)) / 1000;
                }
            }
            C41747z.afc().mo43732a(this.cgL.getTalkerUserName(), this.yNY, intExtra, this.fwz);
        }
        AppMethodBeat.m2505o(31229);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dxA() {
        boolean z;
        AppMethodBeat.m2504i(31230);
        this.yOf = true;
        C1831bh.m3767A("bizflag", ((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL());
        if (this.pkW == null || C25808a.m41064a(this.pkW)) {
            C4990ab.m7417i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", dDw());
            if (this.yNW != null) {
                this.yNW.mo43758a(1, this.pkW);
            }
        } else {
            this.cgL.yTx.setMMSubTitle(null);
        }
        C16527d c16527d = this.pkW;
        if (!(c16527d == null || c16527d == null)) {
            C16529b cJ = c16527d.mo30481cJ(false);
            if (cJ != null && cJ.adZ()) {
                z = true;
                if (z) {
                    C9638aw.m17180RS().mo10302aa(new C4430011());
                }
                if (!C7486a.m12942jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && this.pkW != null) {
                    cJ = this.pkW.mo30481cJ(false);
                    if (cJ != null && cJ.adL()) {
                        if (this.pkW.field_hadAlert == 0) {
                            String string = this.cgL.yTx.getContext().getResources().getString(C25738R.string.ak7, new Object[]{this.cgL.sRl.mo16707Oj()});
                            String string2 = this.cgL.yTx.getContext().getResources().getString(C25738R.string.ak8);
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("<sysmsg type=\"reportbizlocation\">");
                            stringBuffer.append("<reportbizlocation>");
                            stringBuffer.append("<text><![CDATA[").append(string).append("]]></text>");
                            stringBuffer.append("<link>");
                            stringBuffer.append("<scene>reportbizlocation</scene>");
                            stringBuffer.append("<text><![CDATA[").append(string2).append("]]></text>");
                            stringBuffer.append("</link>");
                            stringBuffer.append("</reportbizlocation>");
                            stringBuffer.append("</sysmsg>");
                            C7620bi c7620bi = new C7620bi();
                            c7620bi.mo14794ju(this.cgL.getTalkerUserName());
                            c7620bi.mo14781hO(2);
                            c7620bi.setType(10002);
                            c7620bi.mo14775eJ(C1829bf.aaa());
                            c7620bi.setContent(stringBuffer.toString());
                            C1829bf.m3752l(c7620bi);
                            this.pkW.field_hadAlert = 1;
                            C41747z.aeR().mo10103c(this.pkW, new String[0]);
                        } else {
                            C41747z.afc().mo43734rj(this.cgL.getTalkerUserName());
                        }
                    }
                    if (this.pkW.adJ() && !(this.cgL.sRl.dsf() && C32237a.adG())) {
                        C26417a.flu.mo20967ai(this.cgL.sRl.field_username, "");
                        C41730b.m73506pY(this.cgL.sRl.field_username);
                    }
                    if (this.pkW.field_status == 1) {
                        this.pkW.field_status = 0;
                        C41747z.aeR().mo43726e(this.pkW);
                    }
                } else if (!(this.cgL.yTx.getBooleanExtra("key_has_add_contact", false).booleanValue() || C7486a.m12942jh(this.cgL.sRl.field_type) || !this.cgL.sRl.dsf())) {
                    C5004al.m7441d(new C4430112());
                }
                dDA();
                AppMethodBeat.m2505o(31230);
            }
        }
        z = false;
        if (z) {
        }
        if (!C7486a.m12942jh(this.cgL.sRl.field_type)) {
        }
        C5004al.m7441d(new C4430112());
        dDA();
        AppMethodBeat.m2505o(31230);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31231);
        this.yOf = false;
        if (C7486a.m12942jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && this.pkW != null) {
            C41747z.afc().aeJ();
            if (this.pmG != null) {
                this.pmG.dismiss();
            }
        }
        AppMethodBeat.m2505o(31231);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31232);
        this.yOe = false;
        djt();
        AppMethodBeat.m2505o(31232);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31233);
        super.dDh();
        djt();
        AppMethodBeat.m2505o(31233);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31228);
        this.yNX = System.currentTimeMillis();
        C15612h c15612h = (C15612h) this.cgL.mo74857aF(C15612h.class);
        this.yNY = c15612h.getCount() > 0 ? c15612h.mo27798Ou(c15612h.getCount() - 1) : null;
        C30309s.aom(this.cgL.getTalkerUserName());
        this.cgL.yTx.getLongExtra("key_biz_chat_id", -1);
        if (this.mgP) {
            C4990ab.m7410d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
            C9638aw.m17180RS().mo10310m(new C156177(), 500);
        }
        if (this.cgL.sRl != null && this.cgL.sRl.dsf()) {
            C41747z.afd().mo52930qB(this.cgL.sRl.field_username);
        }
        this.yOa = this.cgL.yTx.getLongExtra("key_biz_chat_id", -1);
        if (C25808a.m41064a(this.pkW) && this.yNW == null) {
            C4990ab.m7417i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", dDw());
            this.yNW = new C25808a(this.cgL);
        }
        if (this.cgL.sRl.dsf()) {
            C25858d.chatType = 2;
        }
        if (this.mgP) {
            C41747z.aeT().mo60347a(this.yEn, Looper.getMainLooper());
        }
        if (this.cgL.sRl != null && this.cgL.sRl.dsf()) {
            C41747z.aeR().mo43722a(this.yOg, Looper.getMainLooper());
        }
        AppMethodBeat.m2505o(31228);
    }

    /* renamed from: g */
    static /* synthetic */ void m81960g(C44812c c44812c) {
        boolean z = true;
        AppMethodBeat.m2504i(31236);
        if (!c44812c.mgP || c44812c.yDI == null || C5046bo.isNullOrNil(c44812c.yDI.field_brandUserName)) {
            AppMethodBeat.m2505o(31236);
            return;
        }
        String cI = C41747z.aeV().mo60357cI(c44812c.yDI.field_brandUserName);
        C45143j cH = C41747z.aeV().mo60356cH(cI);
        String str = "MicroMsg.ChattingUI.BizComponent";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = c44812c.yDI.field_brandUserName;
        objArr[1] = cI;
        if (cH != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (C5046bo.isNullOrNil(cI) || cH == null || cH.afh() || C5046bo.isNullOrNil(cH.field_addMemberUrl)) {
            C41747z.aeZ();
            C25759h.m40920a(c44812c.yDI.field_brandUserName, (C25772n) c44812c);
        }
        AppMethodBeat.m2505o(31236);
    }
}

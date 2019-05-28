package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.PluginOpenIM;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16530c;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.p177mm.p612ui.chatting.AtSomeoneUI;
import com.tencent.p177mm.p612ui.chatting.BaseChattingUIFragment;
import com.tencent.p177mm.p612ui.chatting.C15686h;
import com.tencent.p177mm.p612ui.chatting.C23891w;
import com.tencent.p177mm.p612ui.chatting.C30562p;
import com.tencent.p177mm.p612ui.chatting.C30576v;
import com.tencent.p177mm.p612ui.chatting.C44327t;
import com.tencent.p177mm.p612ui.chatting.ChatFooterCustom;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23728ab;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23730ae;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30468n;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44296aa;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.chat.AppPanel;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44084m;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44084m.C149426;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C14939b;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C35867d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C35868e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.List;

@C15590a(dFp = C15614o.class)
/* renamed from: com.tencent.mm.ui.chatting.c.q */
public class C30482q extends C44291a implements C4931a, C4937b, C15614o {
    protected ChatFooter oor;
    private final C35868e vmZ = new C304871();
    private C30562p yPG;
    protected ChatFooterCustom yPH;
    private int yPI = 0;
    private C44327t yPJ;
    private C23891w yPK;
    private C15686h yPL;
    private AnimationSet yPM;
    private String yPN = null;
    private int yPO;
    private int yPP;
    private boolean yPQ = false;
    private boolean yPR = false;
    public boolean yPS = false;
    private long yPT = 0;

    /* renamed from: com.tencent.mm.ui.chatting.c.q$4 */
    class C53224 implements C14939b {
        C53224() {
        }

        public final String getTalkerUserName() {
            AppMethodBeat.m2504i(31410);
            String talkerUserName = C30482q.this.cgL.getTalkerUserName();
            AppMethodBeat.m2505o(31410);
            return talkerUserName;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$5 */
    class C156265 implements OnClickListener {
        C156265() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31411);
            dialogInterface.dismiss();
            C30482q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(31411);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$6 */
    class C156276 implements OnClickListener {
        C156276() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31412);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(31412);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$7 */
    class C156287 implements OnClickListener {
        C156287() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31413);
            dialogInterface.dismiss();
            C30482q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(31413);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$a */
    class C30481a implements TextWatcher {
        private boolean yPX;
        private List<String> yPY;

        private C30481a() {
            this.yPX = false;
            this.yPY = null;
        }

        /* synthetic */ C30481a(C30482q c30482q, byte b) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        /* renamed from: eA */
        private static boolean m48582eA(String str, int i) {
            AppMethodBeat.m2504i(31417);
            if (str == null || i < 0 || str.length() <= i) {
                AppMethodBeat.m2505o(31417);
                return false;
            } else if (i == 0) {
                AppMethodBeat.m2505o(31417);
                return true;
            } else {
                AppMethodBeat.m2505o(31417);
                return true;
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(31418);
            C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
            ((C23728ab) C30482q.this.cgL.mo74857aF(C23728ab.class)).mo39569OE(1);
            C36135d c36135d = (C36135d) C30482q.this.cgL.mo74857aF(C36135d.class);
            String valueOf = String.valueOf(charSequence);
            String substring = valueOf.substring(i, i + i3);
            String c;
            Intent intent;
            if (C30482q.this.cgL.dFw() && "@".equals(substring) && !valueOf.equals(C30482q.this.oor.getLastContent()) && !C30482q.this.oor.vnb) {
                C30482q.this.oor.setLastContent(valueOf);
                C30482q.this.oor.setInsertPos(i + 1);
                if (C30481a.m48582eA(valueOf, i)) {
                    c = C5046bo.m7536c(C37921n.m64074my(C30482q.this.cgL.getTalkerUserName()), ",");
                    intent = new Intent();
                    intent.setClass(C30482q.this.cgL.yTx.getContext(), AtSomeoneUI.class);
                    intent.putExtra("Block_list", C1853r.m3846Yz());
                    intent.putExtra("Chatroom_member_list", c);
                    intent.putExtra("Chat_User", C30482q.this.cgL.getTalkerUserName());
                    intent.putExtra("Add_address_titile", C30482q.this.cgL.yTx.getMMString(C25738R.string.dre));
                    C30482q.this.cgL.yTx.startActivityForResult(intent, 212);
                }
            } else if (c36135d.dDn() && "@".equals(substring) && !valueOf.equals(C30482q.this.oor.getLastContent()) && !C30482q.this.oor.vnb) {
                C30482q.this.oor.setLastContent(valueOf);
                C30482q.this.oor.setInsertPos(i + 1);
                if (C30481a.m48582eA(valueOf, i)) {
                    c = c36135d.dDk().field_userList;
                    intent = new Intent();
                    intent.setClass(C30482q.this.cgL.yTx.getContext(), BizChatAtSomeoneUI.class);
                    intent.putExtra("Block_list", C41747z.aeV().mo60357cI(C30482q.this.cgL.getTalkerUserName()));
                    intent.putExtra("Chatroom_member_list", c);
                    intent.putExtra("Chat_User", C30482q.this.cgL.getTalkerUserName());
                    intent.putExtra("Add_address_titile", C30482q.this.cgL.yTx.getMMString(C25738R.string.dre));
                    intent.putExtra("key_biz_chat_id", ((C36135d) C30482q.this.cgL.mo74857aF(C36135d.class)).dDz());
                    C30482q.this.cgL.yTx.startActivityForResult(intent, 212);
                }
            } else if (!valueOf.equals(C30482q.this.oor.getLastContent())) {
                C30482q.this.oor.setLastContent(valueOf);
            }
            ((C44296aa) C30482q.this.cgL.mo74857aF(C44296aa.class)).mo70173z(valueOf, i, substring);
            if (!c36135d.dDm()) {
                ChatFooter chatFooter = C30482q.this.oor;
                if (!(chatFooter.vmX == null || chatFooter.oik == null)) {
                    chatFooter.vmX.voJ = true;
                    C44084m c44084m = chatFooter.vmX;
                    if (!(C5046bo.isNullOrNil(valueOf) || valueOf.equals(c44084m.voI))) {
                        C1720g.m3539RS().mo10302aa(new C149426(valueOf));
                    }
                    c44084m.voI = valueOf;
                }
            }
            AppMethodBeat.m2505o(31418);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$3 */
    class C304833 implements C14939b {
        C304833() {
        }

        public final String getTalkerUserName() {
            AppMethodBeat.m2504i(31409);
            String talkerUserName = C30482q.this.cgL.getTalkerUserName();
            AppMethodBeat.m2505o(31409);
            return talkerUserName;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$2 */
    class C304842 implements OnClickListener {
        C304842() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31408);
            C30482q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(31408);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$9 */
    class C304859 implements OnClickListener {
        C304859() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31415);
            C30482q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(31415);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$10 */
    class C3048610 implements OnClickListener {
        C3048610() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31416);
            C30482q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(31416);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$1 */
    class C304871 implements C35868e {
        private Animation yPU;
        private Animation yPV;

        C304871() {
        }

        /* renamed from: oS */
        public final boolean mo48814oS(boolean z) {
            AppMethodBeat.m2504i(31407);
            if (this.yPU == null) {
                this.yPU = AnimationUtils.loadAnimation(C30482q.this.cgL.yTx.getContext(), C25738R.anim.f8375cg);
                this.yPV = AnimationUtils.loadAnimation(C30482q.this.cgL.yTx.getContext(), C25738R.anim.f8373ce);
            }
            if (z) {
                C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", C30482q.this.yPH);
                if (C30482q.this.yPH != null) {
                    C30482q.this.yPH.startAnimation(this.yPV);
                }
                C30482q.this.dEd();
                C30482q.this.oor.startAnimation(this.yPU);
                C30482q.this.oor.postInvalidateDelayed(this.yPU.getDuration());
            } else {
                C30482q.this.oor.startAnimation(this.yPV);
                C30482q.this.dEc();
                if (C30482q.this.yPH != null) {
                    C30482q.this.yPH.startAnimation(this.yPU);
                    C30482q.this.yPH.postInvalidateDelayed(this.yPU.getDuration());
                }
            }
            AppMethodBeat.m2505o(31407);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.q$8 */
    class C304888 implements OnClickListener {
        C304888() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31414);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(31414);
        }
    }

    public C30482q() {
        AppMethodBeat.m2504i(31419);
        AppMethodBeat.m2505o(31419);
    }

    public final ChatFooter dDX() {
        return this.oor;
    }

    public final ChatFooterCustom dDY() {
        return this.yPH;
    }

    private void dDZ() {
        AppMethodBeat.m2504i(31420);
        if (this.cgL.yTx.isCurrentActivity) {
            AppMethodBeat.m2505o(31420);
            return;
        }
        this.cgL.yTz.dCz();
        if (this.oor != null) {
            ChatFooter chatFooter = this.oor;
            View findViewById = chatFooter.findViewById(2131822409);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            chatFooter.setSwitchButtonMode(0);
            chatFooter.mHandler.removeMessages(1002);
            if (chatFooter.vmS != null) {
                chatFooter.vmS.setVisibility(8);
            }
            if (chatFooter.vmT != null) {
                chatFooter.vmT.setVisibility(8);
            }
            if (chatFooter.vmU != null) {
                chatFooter.vmU.setVisibility(8);
            }
            if (chatFooter.miF != null) {
                chatFooter.miF.setVisibility(8);
            }
            chatFooter.oik.setVisibility(8);
            if (chatFooter.miI != null) {
                chatFooter.miI.setVisibility(8);
            }
            if (chatFooter.miJ != null) {
                chatFooter.miJ.setVisibility(8);
            }
            if (chatFooter.miG != null) {
                chatFooter.miG.setVisibility(8);
            }
            if (chatFooter.viY != null) {
                chatFooter.viY.setVisibility(8);
                chatFooter.vjb = false;
                chatFooter.viY.destroy();
                if (chatFooter.oij != null) {
                    chatFooter.oij.setVisibility(0);
                }
            }
            if (chatFooter.miF != null) {
                chatFooter.miF.setVisibility(8);
            }
            if (chatFooter.sze != null) {
                chatFooter.sze.setVisibility(8);
            }
            if (chatFooter.szb != null) {
                chatFooter.szb.update();
            }
            if (chatFooter.vmN != null) {
                chatFooter.vmN.setVisibility(8);
            }
            if (chatFooter.vmQ != null) {
                chatFooter.vmQ.setVisibility(8);
            }
            chatFooter.vmM = (AppPanel) chatFooter.findViewById(2131822423);
            if (chatFooter.vmM != null) {
                chatFooter.setAppPanelVisible(8);
                AppPanel appPanel = chatFooter.vmM;
                if (appPanel.qgO != null) {
                    appPanel.qgO.setToScreen(0);
                }
            }
            if (chatFooter.eAk != null) {
                chatFooter.eAk.destroy();
                chatFooter.vmQ.removeView(chatFooter.eAk);
                chatFooter.eAk = null;
            }
            chatFooter.dkC();
            ChatFooter chatFooter2 = this.oor;
            if (!C5046bo.m7519ac(chatFooter2.oij.getText())) {
                chatFooter2.oij.setText("");
            }
            chatFooter2.mo63957oP(false);
            chatFooter2.dka();
            this.oor.vna.voc = null;
        }
        AppMethodBeat.m2505o(31420);
    }

    public final String dEa() {
        return this.yPN;
    }

    public final void dEb() {
        AppMethodBeat.m2504i(31421);
        try {
            if (this.oor.dky()) {
                this.oor.setBottomPanelVisibility(8);
            }
            AppMethodBeat.m2505o(31421);
        } catch (Exception e) {
            AppMethodBeat.m2505o(31421);
        }
    }

    public final void dEc() {
        AppMethodBeat.m2504i(31422);
        this.cgL.aqX();
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", this.yPH);
        if (this.yPH == null) {
            AppMethodBeat.m2505o(31422);
            return;
        }
        this.yPH.setVisibility(0);
        if (this.oor != null) {
            this.oor.setVisibility(8);
        }
        AppMethodBeat.m2505o(31422);
    }

    public final void dEd() {
        AppMethodBeat.m2504i(31423);
        if (this.oor == null) {
            AppMethodBeat.m2505o(31423);
            return;
        }
        this.oor.setVisibility(0);
        if (this.yPH != null) {
            this.yPH.setVisibility(8);
        }
        AppMethodBeat.m2505o(31423);
    }

    private void dEe() {
        AppMethodBeat.m2504i(31424);
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", C5046bo.dpG());
        if (this.oor != null) {
            this.oor.setVisibility(8);
        }
        if (this.yPH != null) {
            this.yPH.setVisibility(8);
        }
        this.oor.mo63957oP(false);
        this.cgL.aqX();
        AppMethodBeat.m2505o(31424);
    }

    public final void dEf() {
        AppMethodBeat.m2504i(31425);
        this.yPM = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.yPM.setInterpolator(new DecelerateInterpolator(1.5f));
        this.yPM.addAnimation(translateAnimation);
        this.yPM.addAnimation(alphaAnimation);
        this.yPM.setDuration(300);
        this.yPM.setFillBefore(true);
        if (this.oor != null) {
            this.oor.startAnimation(this.yPM);
        }
        AppMethodBeat.m2505o(31425);
    }

    public final void dEg() {
        AppMethodBeat.m2504i(31426);
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", Integer.valueOf(this.yPO));
        if (this.oor == null) {
            this.oor = (ChatFooter) this.cgL.findViewById(2131822391);
            this.oor.vnq = new C304833();
        }
        if (((C15613i) this.cgL.mo74857aF(C15613i.class)).dDN() || C5670b.aFF()) {
            if (!this.yPQ) {
                this.yPO = this.oor.getVisibility();
            }
            this.oor.mo63995u(0, -1, false);
            if (this.yPH == null) {
                this.yPP = -1;
            } else if (!this.yPQ) {
                this.yPP = this.yPH.getVisibility();
            }
            dEe();
            this.yPQ = true;
            AppMethodBeat.m2505o(31426);
            return;
        }
        this.yPQ = false;
        if (this.yPO == 8 && this.yPP == 8) {
            dEe();
            AppMethodBeat.m2505o(31426);
        } else if (this.yPO == 0) {
            dEd();
            AppMethodBeat.m2505o(31426);
        } else {
            dEc();
            AppMethodBeat.m2505o(31426);
        }
    }

    /* renamed from: ae */
    public final boolean mo27832ae(C7616ad c7616ad) {
        AppMethodBeat.m2504i(31427);
        boolean dET = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dET();
        boolean dES = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dES();
        boolean dDN = ((C15613i) this.cgL.mo74857aF(C15613i.class)).dDN();
        boolean dDW = ((C30468n) this.cgL.mo74857aF(C30468n.class)).dDW();
        if (dET || dES || dDN || dDW) {
            C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", dET + ", " + dES + ", " + dDN + ", " + dDW);
            dEe();
            AppMethodBeat.m2505o(31427);
            return false;
        } else if (c7616ad == null || !C1855t.m3909mV(c7616ad.field_username)) {
            if (c7616ad != null && c7616ad.dsf()) {
                C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
                if (c36135d.dDj() != null) {
                    C16529b cJ = c36135d.dDj().mo30481cJ(false);
                    if (cJ != null) {
                        if (cJ.fvc != null) {
                            cJ.fve = "1".equals(cJ.fvc.optString("IsHideInputToolbarInMsg"));
                        }
                        if (cJ.fve) {
                            C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + c7616ad.field_username + " is hide tool bar");
                            dEe();
                            AppMethodBeat.m2505o(31427);
                            return false;
                        }
                    }
                    if (!(C5046bo.isNullOrNil(c7616ad.field_username) || cJ == null)) {
                        int intExtra = this.cgL.yTx.getIntExtra("key_temp_session_show_type", 0);
                        switch (cJ.aeh()) {
                            case 2:
                                C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + c7616ad.field_username + " is show custom menu");
                                if (this.yPH == null) {
                                    C40729i.m70424a(this.cgL.yTx, 2131822392);
                                    this.yPH = (ChatFooterCustom) this.cgL.findViewById(2131822433);
                                    if (this.yPH != null) {
                                        this.yPH.mo64211u((ViewGroup) this.cgL.findViewById(2131822377));
                                    }
                                }
                                C16530c aeo = cJ.aeo();
                                if (aeo != null && aeo.type == 1) {
                                    this.oor.setSwitchButtonMode(1);
                                    this.oor.setOnFooterSwitchListener(((C36135d) this.cgL.mo74857aF(C36135d.class)).dDq());
                                    dEd();
                                    break;
                                }
                                this.oor.setSwitchButtonMode(0);
                                try {
                                    if (!C1855t.m3908mU(c7616ad.field_username)) {
                                        ChatFooterCustom chatFooterCustom = this.yPH;
                                        if (!(chatFooterCustom.yHx == null || chatFooterCustom.yHw == null)) {
                                            chatFooterCustom.yHx.setVisibility(0);
                                            chatFooterCustom.yHw.setVisibility(0);
                                        }
                                        if (chatFooterCustom.yHy != null) {
                                            chatFooterCustom.yHy.dBX();
                                        }
                                        this.yPH.setTalker(this.cgL.sRl);
                                        this.yPH.mo64201a(this.cgL.yTx, c36135d.dDj(), c7616ad.field_username);
                                        this.yPH.setOnFooterSwitchListener(this.vmZ);
                                        this.yPH.setOnProcessClickListener(((C36135d) this.cgL.mo74857aF(C36135d.class)).dDp());
                                        this.oor.setOnFooterSwitchListener(this.vmZ);
                                        if (!((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL() || intExtra != 1) {
                                            dEc();
                                            break;
                                        }
                                        dEd();
                                        break;
                                    }
                                    this.yPK = new C23891w(this.yPH);
                                    this.yPK.ctT();
                                    dEc();
                                    break;
                                } catch (Exception e) {
                                    if (aeo == null || aeo.fvL == null || aeo.fvL.size() == 0) {
                                        dEd();
                                    } else {
                                        this.vmZ.mo48814oS(true);
                                    }
                                    C4990ab.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", e, "", new Object[0]);
                                    break;
                                }
                                break;
                            default:
                                dEd();
                                String str = "MicroMsg.ChattingUI.FootComponent";
                                String str2 = "bizinfo name=%s, %b, %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = c7616ad.field_username;
                                if (cJ != null) {
                                    dDW = true;
                                } else {
                                    dDW = false;
                                }
                                objArr[1] = Boolean.valueOf(dDW);
                                objArr[2] = Integer.valueOf(cJ.aeh());
                                C4990ab.m7413e(str, str2, objArr);
                                break;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(31427);
            return true;
        } else {
            this.yPL = new C15686h(this.yPH);
            this.yPL.ctT();
            dEc();
            AppMethodBeat.m2505o(31427);
            return true;
        }
    }

    public final void dEh() {
        int i;
        AppMethodBeat.m2504i(31428);
        String talkerUserName = this.cgL.getTalkerUserName();
        if (C1855t.m3936ne(talkerUserName) || C7616ad.aou(talkerUserName)) {
            i = 1;
        } else if (C1855t.m3953nv(talkerUserName)) {
            i = 2;
        } else {
            i = this.cgL.yTx.getIntExtra("Chat_Mode", 0);
            C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yPI), Integer.valueOf(i));
            if (this.yPI != 0) {
                i = this.yPI;
            }
            String value = C26373g.m41964Nu().getValue("DefaultMsgType");
            if (this.yPI == 0 && value != null) {
                C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", value);
                i = C5046bo.getInt(C26373g.m41964Nu().getValue("DefaultMsgType"), 0);
            }
            if (i == 0 && C7486a.m12942jh(this.cgL.sRl.field_type)) {
                C9638aw.m17190ZK();
                i = ((Integer) C18628c.m29072Ry().get(18, Integer.valueOf(0))).intValue();
            }
            if (i == 0) {
                i = 1;
            }
            C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yPI), Integer.valueOf(i));
        }
        if (i == 2) {
            C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.cgL.yTx.getContext(), "android.permission.RECORD_AUDIO", 80, "", "")), C5046bo.dpG(), this.cgL.yTx.getContext());
            if (C35805b.m58707a(this.cgL.yTx.getContext(), "android.permission.RECORD_AUDIO", 80, "", "")) {
                this.oor.mo63907az(i, false);
            }
            AppMethodBeat.m2505o(31428);
            return;
        }
        this.oor.mo63907az(i, false);
        AppMethodBeat.m2505o(31428);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x051b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x051e  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void arm(String str) {
        boolean z;
        AppPanel appPanel;
        C7616ad aoO;
        int vi;
        ChatFooter chatFooter;
        boolean z2 = false;
        AppMethodBeat.m2504i(31429);
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", str);
        this.oor.dkk();
        this.oor.dkb();
        if (((C15613i) this.cgL.mo74857aF(C15613i.class)).dDN()) {
            C4990ab.m7420w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
            z = false;
        } else {
            boolean dET = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dET();
            z = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dES();
            if (dET || z) {
                C4990ab.m7420w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
                z = false;
            } else if (C7616ad.aow(this.cgL.getTalkerUserName()) || C7616ad.m13548mR(this.cgL.getTalkerUserName())) {
                C4990ab.m7420w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
                z = false;
            } else if (C1855t.m3923nI(this.cgL.getTalkerUserName())) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            this.oor.dkm();
        }
        if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm()) {
            C16527d qX = C17903f.m28104qX(this.cgL.getTalkerUserName());
            if (qX == null || qX.field_enterpriseFather == null) {
                z = false;
            } else {
                Cursor qQ = C41747z.aeR().mo43730qQ(qX.field_enterpriseFather);
                if (qQ == null || qQ.getCount() <= 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (qQ != null) {
                    qQ.close();
                }
            }
            if (z) {
                appPanel = this.oor.vmM;
                appPanel.vlP.vmG.value = true;
                appPanel.djQ();
            }
        }
        if (!this.cgL.dFx()) {
            this.oor.dks();
        }
        if (!(this.cgL.sRl == null || C7486a.m12942jh(this.cgL.sRl.field_type) || C1855t.m3896kH(this.cgL.getTalkerUserName()))) {
            this.oor.dkp();
        }
        if (C7616ad.m13548mR(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dkn();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.mo63904ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (C7616ad.aow(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dkn();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.mo63904ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (C7616ad.aou(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dkn();
            this.oor.dkj();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.mo63904ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (C1855t.m3946no(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.mo63904ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (C1855t.m3943nl(str)) {
            this.oor.vmM.djK();
            this.oor.mo63904ac(true, true);
            this.oor.vmM.djL();
            this.oor.vmM.djP();
        }
        C9638aw.m17190ZK();
        C7616ad aoO2 = C18628c.m29078XM().aoO(str);
        if (aoO2 != null && aoO2.dsf()) {
            if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm()) {
                this.oor.vmM.djK();
                this.oor.vmM.djN();
                this.oor.vmM.djL();
                this.oor.mo63904ac(true, true);
                this.oor.dkp();
                this.oor.dkq();
                this.oor.dkm();
                this.oor.vmM.djO();
                this.oor.dkl();
                this.oor.dkr();
                this.oor.mo63900AD();
            } else {
                this.oor.vmM.djK();
                this.oor.mo63904ac(true, true);
                this.oor.dkn();
                this.oor.vmM.djL();
            }
        }
        if (this.cgL.dFw()) {
            int i;
            if (C26373g.m41964Nu().getInt("MultitalkBlockCaller", 0) == 0) {
                i = 1;
            } else {
                z = false;
            }
            if (i != 0) {
                this.oor.mo63955oH(false);
                if (this.cgL.dFx() || this.cgL.dFv()) {
                    this.oor.mo63904ac(true, true);
                    this.oor.dkq();
                }
                C25985d.dlL();
                if (this.cgL.dFv()) {
                    this.oor.vmM.djL();
                }
                if (this.cgL.getTalkerUserName().equals(C1853r.m3846Yz())) {
                    this.oor.vmM.djL();
                    this.oor.mo63904ac(true, true);
                    this.oor.dkp();
                    this.oor.dkq();
                }
                this.oor.setAppPanelTip(null);
                if (C7616ad.aox(this.cgL.sRl.field_username) || C1855t.m3903mP(this.cgL.sRl.field_username)) {
                    C1720g.m3537RQ();
                    aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.cgL.sRl.field_username);
                    ((C32873b) C1720g.m3528K(C32873b.class)).mo44303aZ(aoO.field_openImAppid, aoO.field_descWordingId);
                    vi = ((C32873b) C1720g.m3528K(C32873b.class)).mo44311vi(aoO.field_openImAppid);
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", Integer.valueOf(vi), this.cgL.sRl.field_username, aoO.field_openImAppid, ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(this.cgL.sRl.field_openImAppid, "openim_function_tip", C32874a.TYPE_WORDING));
                    if ((vi & 1) == 0) {
                        this.oor.dkj();
                    }
                    if ((vi & 2) == 0) {
                        this.oor.dkl();
                    }
                    if ((vi & 4) == 0) {
                        appPanel = this.oor.vmM;
                        appPanel.vlP.vmn.value = false;
                        appPanel.djQ();
                    }
                    if ((vi & 8) == 0) {
                        this.oor.dkn();
                    }
                    if ((vi & 16) == 0) {
                        this.oor.vmM.djM();
                    }
                    if ((vi & 32) == 0) {
                        this.oor.vmM.djK();
                    }
                    if ((vi & 64) == 0) {
                        this.oor.vmM.djP();
                    }
                    if ((vi & 128) == 0) {
                        this.oor.dko();
                    }
                    if ((vi & 256) == 0 || (vi & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
                        this.oor.mo63904ac((vi & 256) != 0, (vi & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0);
                    }
                    if ((vi & 512) == 0) {
                        this.oor.dkp();
                        this.oor.dkq();
                    }
                    if ((vi & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                        this.oor.vmM.vma = true;
                    }
                    if (C1855t.m3903mP(this.cgL.sRl.field_username) && (vi & 256) == 0) {
                        this.oor.mo63955oH(true);
                    }
                    this.oor.setAppPanelTip(r5);
                }
                chatFooter = this.oor;
                C25985d.dlL();
                if (chatFooter.eAk != null) {
                    chatFooter.eAk.mo11696j(false, false);
                }
                chatFooter = this.oor;
                C25985d.dlL();
                if (C17950b.ahK()) {
                    z2 = true;
                }
                chatFooter.mo63956oI(z2);
                this.oor.vmM.djL();
                if (C7616ad.m13549mg(this.cgL.getTalkerUserName())) {
                    this.oor.dkb();
                    this.oor.dkj();
                    this.oor.vmM.djN();
                    this.oor.dks();
                    this.oor.dko();
                    this.oor.dkl();
                    this.oor.dkn();
                    this.oor.vmM.djK();
                    this.oor.dkm();
                    this.oor.dko();
                    this.oor.dkl();
                    this.oor.dkr();
                    this.oor.mo63900AD();
                    this.oor.vmM.djO();
                    this.oor.mo63904ac(true, true);
                    this.oor.mo63955oH(true);
                    this.oor.mo63956oI(true);
                    this.oor.dkp();
                    this.oor.dkq();
                    this.oor.vmM.djL();
                    this.oor.vmM.djK();
                    this.oor.vmM.djM();
                    this.oor.vmM.djP();
                }
                AppMethodBeat.m2505o(31429);
            }
        }
        this.oor.mo63955oH(true);
        this.oor.mo63904ac(true, true);
        this.oor.dkq();
        C25985d.dlL();
        if (this.cgL.dFv()) {
        }
        if (this.cgL.getTalkerUserName().equals(C1853r.m3846Yz())) {
        }
        this.oor.setAppPanelTip(null);
        C1720g.m3537RQ();
        aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.cgL.sRl.field_username);
        ((C32873b) C1720g.m3528K(C32873b.class)).mo44303aZ(aoO.field_openImAppid, aoO.field_descWordingId);
        vi = ((C32873b) C1720g.m3528K(C32873b.class)).mo44311vi(aoO.field_openImAppid);
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", Integer.valueOf(vi), this.cgL.sRl.field_username, aoO.field_openImAppid, ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(this.cgL.sRl.field_openImAppid, "openim_function_tip", C32874a.TYPE_WORDING));
        if ((vi & 1) == 0) {
        }
        if ((vi & 2) == 0) {
        }
        if ((vi & 4) == 0) {
        }
        if ((vi & 8) == 0) {
        }
        if ((vi & 16) == 0) {
        }
        if ((vi & 32) == 0) {
        }
        if ((vi & 64) == 0) {
        }
        if ((vi & 128) == 0) {
        }
        if ((vi & 256) != 0) {
        }
        if ((vi & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
        }
        this.oor.mo63904ac((vi & 256) != 0, (vi & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0);
        if ((vi & 512) == 0) {
        }
        if ((vi & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
        }
        this.oor.mo63955oH(true);
        this.oor.setAppPanelTip(r5);
        chatFooter = this.oor;
        C25985d.dlL();
        if (chatFooter.eAk != null) {
        }
        chatFooter = this.oor;
        C25985d.dlL();
        if (C17950b.ahK()) {
        }
        chatFooter.mo63956oI(z2);
        this.oor.vmM.djL();
        if (C7616ad.m13549mg(this.cgL.getTalkerUserName())) {
        }
        AppMethodBeat.m2505o(31429);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(31431);
        if (obj != null) {
            obj.equals("");
        }
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", obj, this.cgL.getTalkerUserName());
        if (obj.equals(this.cgL.getTalkerUserName())) {
            arm(this.cgL.getTalkerUserName());
            dEh();
        }
        AppMethodBeat.m2505o(31431);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(31432);
        if (str != null) {
            str.equals("");
        }
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", str, this.cgL.getTalkerUserName());
        if (C1855t.m3903mP(this.cgL.getTalkerUserName())) {
            arm(this.cgL.getTalkerUserName());
            dEh();
        }
        AppMethodBeat.m2505o(31432);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31433);
        super.onActivityResult(i, i2, intent);
        if (FaceManager.FACE_ACQUIRED_HACKER == i && -1 == i2) {
            this.oor.dkh();
        }
        if (i2 != -1) {
            if (i == 200 || i == 201 || i == 203) {
                this.oor.clearFocus();
            }
            AppMethodBeat.m2505o(31433);
            return;
        }
        if (!(i == 217 || this.yPH == null)) {
            this.yPH.mo64207r(i, intent);
        }
        switch (i) {
            case 202:
                if (intent != null) {
                    int intExtra = intent.getIntExtra("Chat_Mode", 1);
                    if (this.oor != null) {
                        this.oor.setMode(intExtra);
                        break;
                    }
                }
                C4990ab.m7412e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                AppMethodBeat.m2505o(31433);
                return;
                break;
        }
        AppMethodBeat.m2505o(31433);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        AppMethodBeat.m2504i(31434);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ChattingUI.FootComponent";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = C5046bo.dpG();
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(31434);
            return;
        }
        int i3;
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        C30562p c30562p = this.yPG;
                        if (!this.oor.vmM.vlP.vmD.value) {
                            i2 = 2;
                        }
                        c30562p.mo48966Om(i2);
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                }
                i3 = "android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0;
                if (iArr[0] != 0) {
                    C30379h.m48445a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(i3), this.cgL.yTx.getMMResources().getString(C25738R.string.dc8), this.cgL.yTx.getMMResources().getString(C25738R.string.ckr), this.cgL.yTx.getMMResources().getString(C25738R.string.abx), false, new C156265(), new C156276());
                }
                AppMethodBeat.m2505o(31434);
                return;
            case 19:
            case 21:
            case 22:
                if (iArr[0] != 0) {
                    i3 = "android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0;
                    if (iArr[0] != 0) {
                        C30379h.m48445a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(i3), this.cgL.yTx.getMMResources().getString(C25738R.string.dc8), this.cgL.yTx.getMMResources().getString(C25738R.string.ckr), this.cgL.yTx.getMMResources().getString(C25738R.string.abx), false, new C156287(), new C304888());
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                } else if (i == 19) {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.cbm();
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                } else if (i == 21) {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCl();
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                } else {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCj();
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                }
            case 20:
                if (iArr[0] == 0) {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCn();
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                }
                C30379h.m48445a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.dbs), this.cgL.yTx.getMMResources().getString(C25738R.string.dc8), this.cgL.yTx.getMMResources().getString(C25738R.string.ckr), this.cgL.yTx.getMMResources().getString(C25738R.string.abx), false, new C304859(), null);
                AppMethodBeat.m2505o(31434);
                return;
            case 81:
                if (iArr[0] == 0) {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCm();
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                }
                C30379h.m48445a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.dby), this.cgL.yTx.getMMResources().getString(C25738R.string.dc8), this.cgL.yTx.getMMResources().getString(C25738R.string.ckr), this.cgL.yTx.getMMResources().getString(C25738R.string.abx), false, new C3048610(), null);
                AppMethodBeat.m2505o(31434);
                return;
            case 82:
            case 83:
                if (iArr[0] != 0) {
                    C30379h.m48445a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.dc0), this.cgL.yTx.getMMResources().getString(C25738R.string.dc8), this.cgL.yTx.getMMResources().getString(C25738R.string.ckr), this.cgL.yTx.getMMResources().getString(C25738R.string.abx), false, new C304842(), null);
                    break;
                } else if (i == 82) {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.cbl();
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                } else {
                    C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.yPG, C5046bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCk();
                    }
                    AppMethodBeat.m2505o(31434);
                    return;
                }
        }
        AppMethodBeat.m2505o(31434);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31436);
        super.dDh();
        if (this.oor != null) {
            this.oor.setFooterEventListener(null);
            this.yPG = null;
            this.oor.setSmileyPanelCallback(null);
            this.oor.setSmileyPanelCallback2(null);
        }
        if (this.yPH != null) {
            this.yPH.ctm();
            this.yPH = null;
        }
        dDZ();
        if (this.yPH != null) {
            this.yPH.dBU();
        }
        C44089j.clearCache();
        if (this.oor != null) {
            ChatFooter chatFooter = this.oor;
            if (chatFooter.vmX != null) {
                chatFooter.vmX.voJ = false;
                chatFooter.vmX.hide();
            }
        }
        if (this.cgL.yTx.isCurrentActivity && this.oor != null) {
            this.oor.destroy();
        }
        C1720g.m3537RQ();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10117d(this);
        AppMethodBeat.m2505o(31436);
    }

    public final void dxy() {
        int i;
        AppMethodBeat.m2504i(31437);
        this.yPR = false;
        this.yPS = false;
        this.yPT = 0;
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
        if (aoZ != null) {
            this.yPI = aoZ.field_chatmode;
        }
        C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", Integer.valueOf(this.yPI));
        String talkerUserName = this.cgL.getTalkerUserName();
        if (this.oor == null) {
            this.oor = (ChatFooter) this.cgL.findViewById(2131822391);
            this.oor.vnq = new C53224();
        }
        this.oor.setCattingRootLayoutId(2131821521);
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", this.yPH);
        if (this.yPH != null) {
            this.yPH.ctm();
            this.yPH.setOnFooterSwitchListener(null);
            this.yPH.setOnProcessClickListener(null);
            this.oor.setOnFooterSwitchListener(null);
            this.yPH.dBU();
        }
        dEe();
        this.oor.dkk();
        boolean dET = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dET();
        boolean dES = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dES();
        boolean i2;
        if (dET || dES) {
            dEe();
        } else if (C1855t.m3934nc(talkerUserName)) {
            dEe();
            C40729i.m70424a(this.cgL.yTx, 2131822392);
            if (this.yPH == null) {
                i2 = 1;
            } else {
                i2 = false;
            }
            this.yPH = (ChatFooterCustom) this.cgL.findViewById(2131822433);
            if (i2 != 0) {
                this.yPH.mo64211u((ViewGroup) this.cgL.findViewById(2131822377));
            }
            this.yPJ = new C44327t(this.yPH);
            C44327t c44327t = this.yPJ;
            if (C5059g.cdf == 1) {
                i2 = 1;
            } else {
                i2 = false;
            }
            c44327t.yJS.findViewById(2131822434).setVisibility(8);
            c44327t.lfQ = (LinearLayout) c44327t.yJS.findViewById(2131822436);
            c44327t.yJS.findViewById(2131822437).setVisibility(8);
            c44327t.lfQ.setWeightSum(i2 != 0 ? 1.0f : 2.0f);
            c44327t.yJT = (FrameLayout) c44327t.lfQ.getChildAt(0);
            c44327t.yJT.setVisibility(0);
            c44327t.yJT.setOnClickListener(c44327t.yKc);
            ((TextView) c44327t.yJT.findViewById(2131822432)).setText(C25738R.string.aj8);
            c44327t.yJT.findViewById(2131822431).setVisibility(8);
            c44327t.yJT.getChildAt(2).setVisibility(8);
            int i3;
            if (i2 != 0) {
                for (i3 = 1; i3 < 6; i3++) {
                    c44327t.lfQ.getChildAt(i3).setVisibility(8);
                }
            } else {
                c44327t.yJU = (FrameLayout) c44327t.lfQ.getChildAt(1);
                c44327t.yJU.setVisibility(0);
                c44327t.yJU.setOnClickListener(c44327t.yKd);
                c44327t.yJV = (TextView) c44327t.yJU.findViewById(2131822432);
                c44327t.yJW = (ImageView) c44327t.yJU.findViewById(2131822431);
                c44327t.yJW.setVisibility(0);
                c44327t.dCr();
                C9638aw.m17190ZK();
                c44327t.yJY = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1))).intValue();
                if (c44327t.yJY >= 0) {
                    c44327t.dCt();
                } else {
                    c44327t.yJV.setText(C25738R.string.ajk);
                }
                c44327t.yJU.getChildAt(2).setVisibility(8);
                for (i3 = 2; i3 < 6; i3++) {
                    c44327t.lfQ.getChildAt(i3).setVisibility(8);
                }
                c44327t.yKb = C26373g.m41965Nv().getMailAppEnterUlAndroid();
                if (C5046bo.isNullOrNil(c44327t.yKb)) {
                    c44327t.yKb = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                }
                C9638aw.m17190ZK();
                c44327t.yKb = c44327t.yKb.replace("$uin$", new C1183p(C5046bo.m7567h((Integer) C18628c.m29072Ry().get(9, null))).toString());
                c44327t.pzJ = C26373g.m41965Nv().mo5300Nm();
                c44327t.yJZ = true;
            }
            dEc();
        } else {
            this.yPJ = null;
            if (C1855t.m3908mU(talkerUserName)) {
                dEe();
                C40729i.m70424a(this.cgL.yTx, 2131822392);
                if (this.yPH == null) {
                    i2 = 1;
                } else {
                    i2 = false;
                }
                this.yPH = (ChatFooterCustom) this.cgL.findViewById(2131822433);
                if (i2 != 0) {
                    this.yPH.mo64211u((ViewGroup) this.cgL.findViewById(2131822377));
                }
                this.yPK = new C23891w(this.yPH);
                this.yPK.ctT();
                dEc();
            } else {
                this.yPK = null;
                if (C1855t.m3909mV(talkerUserName)) {
                    dEe();
                    C40729i.m70424a(this.cgL.yTx, 2131822392);
                    if (this.yPH == null) {
                        i2 = 1;
                    } else {
                        i2 = false;
                    }
                    this.yPH = (ChatFooterCustom) this.cgL.findViewById(2131822433);
                    if (i2 != 0) {
                        this.yPH.mo64211u((ViewGroup) this.cgL.findViewById(2131822377));
                    }
                    this.yPL = new C15686h(this.yPH);
                    this.yPL.ctT();
                    dEc();
                } else {
                    this.yPL = null;
                    if (!(C1855t.m3935nd(talkerUserName) || C1855t.m3908mU(talkerUserName) || C1855t.m3934nc(talkerUserName) || C1855t.m3909mV(talkerUserName))) {
                        C1855t.m3873Zj();
                        if (!C1855t.m3918nD(talkerUserName)) {
                            dEd();
                            mo27832ae(this.cgL.sRl);
                            this.oor.setUserName(talkerUserName);
                            arm(talkerUserName);
                            C15613i c15613i = (C15613i) this.cgL.mo74857aF(C15613i.class);
                            C23733z c23733z = (C23733z) this.cgL.mo74857aF(C23733z.class);
                            if (c15613i.dDN()) {
                                if (c23733z.dEQ()) {
                                    c23733z.dEP();
                                    c15613i.dDO();
                                } else {
                                    c15613i.dDL();
                                }
                            }
                        }
                    }
                    dEe();
                }
            }
        }
        dDZ();
        this.yPG = new C30562p(this.cgL, this.oor, this.cgL.getTalkerUserName());
        this.yPG.yJj = this.cgL.yTx.getBooleanExtra("key_need_send_video", true).booleanValue();
        this.oor.setFooterEventListener(this.yPG);
        C30576v c30576v = new C30576v(this.cgL.yTx.getContext(), this.cgL.sRl, this.cgL.getTalkerUserName());
        this.oor.setSmileyPanelCallback(c30576v);
        this.oor.setSmileyPanelCallback2(c30576v);
        dEh();
        this.oor.dkd();
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", Boolean.valueOf(((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL()), Integer.valueOf(this.cgL.yTx.getIntExtra("key_temp_session_show_type", 0)));
        C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", Boolean.valueOf(r0.dEL()));
        if (((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL()) {
            if (i2 == 1) {
                this.vmZ.mo48814oS(true);
            } else {
                this.vmZ.mo48814oS(false);
            }
        }
        mo27832ae(this.cgL.sRl);
        C1720g.m3537RQ();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this);
        ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10116c(this);
        AppMethodBeat.m2505o(31437);
    }

    public final void dxz() {
    }

    public final void dxC() {
    }

    public final void setVoiceInputShowCallback(C35867d c35867d) {
        AppMethodBeat.m2504i(31430);
        this.oor.setVoiceInputShowCallback(c35867d);
        AppMethodBeat.m2505o(31430);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        AppMethodBeat.m2504i(31435);
        C4990ab.m7417i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4) {
            if (!this.cgL.caA) {
                C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
            } else if (this.cgL.yTx.isSupportNavigationSwipeBack() && this.cgL.yTx.getSwipeBackLayout().dkx()) {
                C4990ab.m7420w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
                i2 = 1;
                if (i2 != 0) {
                }
            } else {
                if (keyEvent.getAction() == 0) {
                    this.yPR = true;
                    this.yPT = System.currentTimeMillis();
                }
                if (keyEvent.getAction() == 1) {
                    C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", Boolean.valueOf(this.yPR), Long.valueOf(System.currentTimeMillis() - this.yPT));
                    boolean onKeyDown;
                    if (!this.yPR || System.currentTimeMillis() - this.yPT > 30000) {
                        i2 = 1;
                        if (i2 != 0) {
                            onKeyDown = super.onKeyDown(i, keyEvent);
                            AppMethodBeat.m2505o(31435);
                            return onKeyDown;
                        }
                        AppMethodBeat.m2505o(31435);
                        return true;
                    }
                    this.yPS = true;
                    C15613i c15613i = (C15613i) this.cgL.mo74857aF(C15613i.class);
                    C23733z c23733z = (C23733z) this.cgL.mo74857aF(C23733z.class);
                    if (c15613i.dDN()) {
                        if (c23733z.dEQ()) {
                            c23733z.dEP();
                            c15613i.dDO();
                        } else {
                            c15613i.dDL();
                        }
                        i2 = 1;
                    } else {
                        onKeyDown = false;
                    }
                    if (i2 == 0) {
                        if (this.oor == null || !this.oor.dky()) {
                            this.cgL.yTx.dBP();
                        } else {
                            this.oor.mo63995u(2, 23, false);
                        }
                    }
                }
                i2 = 1;
                if (i2 != 0) {
                }
            }
        } else if (keyEvent.getKeyCode() == 67 && !this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
        } else if (!this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
        }
        i2 = false;
        if (i2 != 0) {
        }
    }

    public final void dxA() {
        boolean booleanValue;
        AppMethodBeat.m2504i(31438);
        this.yPN = this.cgL.yTx.getStringExtra("smiley_product_id");
        if (this.oor.dkD()) {
            ((C23728ab) this.cgL.mo74857aF(C23728ab.class)).keepSignalling();
        }
        if (C1855t.m3934nc(this.cgL.getTalkerUserName()) && this.yPJ != null && this.yPJ.yJZ) {
            this.yPJ.dCs();
        }
        ChatFooter chatFooter = this.oor;
        BaseChattingUIFragment baseChattingUIFragment = this.cgL.yTx;
        chatFooter.vnp = baseChattingUIFragment;
        if (!chatFooter.vjb) {
            chatFooter.findViewById(2131822408).setVisibility(0);
        }
        chatFooter.mo63903a(baseChattingUIFragment.getContext(), baseChattingUIFragment.thisActivity());
        chatFooter.vnV = true;
        if (!(C5046bo.isNullOrNil(this.yPN) || this.oor == null)) {
            C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", this.yPN);
            this.oor.setDefaultSmileyByDetail(this.yPN);
            this.oor.dkh();
        }
        this.cgL.yTx.getContext().getIntent().putExtra("smiley_product_id", "");
        this.oor.setUserName(this.cgL.getTalkerUserName());
        chatFooter = this.oor;
        String dFu = this.cgL.dFu();
        String talkerUserName = this.cgL.getTalkerUserName();
        chatFooter.cEV = dFu;
        chatFooter.toUser = talkerUserName;
        if (this.cgL.yTx.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue()) {
            chatFooter = this.oor;
            chatFooter.dkf();
            if (chatFooter.vmS != null) {
                chatFooter.vmS.performClick();
                C4990ab.m7410d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
            }
        }
        if (mo27832ae(this.cgL.sRl)) {
            if (this.oor != null) {
                C9638aw.m17190ZK();
                booleanValue = ((Boolean) C18628c.m29072Ry().get(66832, Boolean.FALSE)).booleanValue();
                C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(booleanValue));
                this.oor.dkE();
                if (booleanValue) {
                    this.oor.dkt();
                    this.oor.dkd();
                }
                if (booleanValue) {
                    this.oor.dkl();
                }
                chatFooter = this.oor;
                if (chatFooter.vmM != null) {
                    chatFooter.vmM.djJ();
                }
            }
            ((C23730ae) this.cgL.mo74857aF(C23730ae.class)).dDS();
            if (this.oor != null) {
                this.oor.vmM.refresh();
                this.oor.addTextChangedListener(new C30481a(this, (byte) 0));
                C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
            }
        }
        boolean dET = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dET();
        boolean dES = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dES();
        booleanValue = ((C15613i) this.cgL.mo74857aF(C15613i.class)).dDN();
        if (dET || dES || booleanValue || this.cgL.sRl == null || this.cgL.sRl.dsf() || C1855t.m3920nF(this.cgL.getTalkerUserName()) || C5670b.aFF() || C1855t.m3909mV(this.cgL.getTalkerUserName())) {
            C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
            AppMethodBeat.m2505o(31438);
            return;
        }
        C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
        dEd();
        AppMethodBeat.m2505o(31438);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31439);
        if (this.oor != null) {
            ChatFooter chatFooter = this.oor;
            if (chatFooter.vnw != null) {
                chatFooter.oij.removeTextChangedListener(chatFooter.vnw);
                chatFooter.vnw = null;
            }
            C4990ab.m7416i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
            this.oor.onPause();
            if (C1720g.m3531RK()) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(18, Integer.valueOf(this.oor.getMode()));
                C4990ab.m7411d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", Integer.valueOf(this.yPI), Integer.valueOf(this.oor.getMode()));
                if (this.yPI != this.oor.getMode()) {
                    this.yPI = this.oor.getMode();
                    C9638aw.m17190ZK();
                    C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
                    if (aoZ != null && this.cgL.getTalkerUserName().equals(aoZ.field_username)) {
                        aoZ.mo14749hN(this.yPI);
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15767a(aoZ, this.cgL.getTalkerUserName());
                    }
                }
                this.oor.bvH();
                AppMethodBeat.m2505o(31439);
                return;
            }
            C4990ab.m7420w("MicroMsg.ChattingUI.FootComponent", "account not ready");
            AppMethodBeat.m2505o(31439);
            return;
        }
        AppMethodBeat.m2505o(31439);
    }
}

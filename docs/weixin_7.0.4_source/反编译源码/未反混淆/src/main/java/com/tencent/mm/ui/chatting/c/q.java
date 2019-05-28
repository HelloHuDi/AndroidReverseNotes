package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.d.b.c;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.h;
import com.tencent.mm.ui.chatting.p;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.w;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dFp = o.class)
public class q extends a implements com.tencent.mm.sdk.e.k.a, b, o {
    protected ChatFooter oor;
    private final e vmZ = new e() {
        private Animation yPU;
        private Animation yPV;

        public final boolean oS(boolean z) {
            AppMethodBeat.i(31407);
            if (this.yPU == null) {
                this.yPU = AnimationUtils.loadAnimation(q.this.cgL.yTx.getContext(), R.anim.cg);
                this.yPV = AnimationUtils.loadAnimation(q.this.cgL.yTx.getContext(), R.anim.ce);
            }
            if (z) {
                ab.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", q.this.yPH);
                if (q.this.yPH != null) {
                    q.this.yPH.startAnimation(this.yPV);
                }
                q.this.dEd();
                q.this.oor.startAnimation(this.yPU);
                q.this.oor.postInvalidateDelayed(this.yPU.getDuration());
            } else {
                q.this.oor.startAnimation(this.yPV);
                q.this.dEc();
                if (q.this.yPH != null) {
                    q.this.yPH.startAnimation(this.yPU);
                    q.this.yPH.postInvalidateDelayed(this.yPU.getDuration());
                }
            }
            AppMethodBeat.o(31407);
            return false;
        }
    };
    private p yPG;
    protected ChatFooterCustom yPH;
    private int yPI = 0;
    private t yPJ;
    private w yPK;
    private h yPL;
    private AnimationSet yPM;
    private String yPN = null;
    private int yPO;
    private int yPP;
    private boolean yPQ = false;
    private boolean yPR = false;
    public boolean yPS = false;
    private long yPT = 0;

    class a implements TextWatcher {
        private boolean yPX;
        private List<String> yPY;

        private a() {
            this.yPX = false;
            this.yPY = null;
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private static boolean eA(String str, int i) {
            AppMethodBeat.i(31417);
            if (str == null || i < 0 || str.length() <= i) {
                AppMethodBeat.o(31417);
                return false;
            } else if (i == 0) {
                AppMethodBeat.o(31417);
                return true;
            } else {
                AppMethodBeat.o(31417);
                return true;
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(31418);
            ab.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
            ((com.tencent.mm.ui.chatting.c.b.ab) q.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).OE(1);
            d dVar = (d) q.this.cgL.aF(d.class);
            String valueOf = String.valueOf(charSequence);
            String substring = valueOf.substring(i, i + i3);
            String c;
            Intent intent;
            if (q.this.cgL.dFw() && "@".equals(substring) && !valueOf.equals(q.this.oor.getLastContent()) && !q.this.oor.vnb) {
                q.this.oor.setLastContent(valueOf);
                q.this.oor.setInsertPos(i + 1);
                if (eA(valueOf, i)) {
                    c = bo.c(n.my(q.this.cgL.getTalkerUserName()), ",");
                    intent = new Intent();
                    intent.setClass(q.this.cgL.yTx.getContext(), AtSomeoneUI.class);
                    intent.putExtra("Block_list", r.Yz());
                    intent.putExtra("Chatroom_member_list", c);
                    intent.putExtra("Chat_User", q.this.cgL.getTalkerUserName());
                    intent.putExtra("Add_address_titile", q.this.cgL.yTx.getMMString(R.string.dre));
                    q.this.cgL.yTx.startActivityForResult(intent, 212);
                }
            } else if (dVar.dDn() && "@".equals(substring) && !valueOf.equals(q.this.oor.getLastContent()) && !q.this.oor.vnb) {
                q.this.oor.setLastContent(valueOf);
                q.this.oor.setInsertPos(i + 1);
                if (eA(valueOf, i)) {
                    c = dVar.dDk().field_userList;
                    intent = new Intent();
                    intent.setClass(q.this.cgL.yTx.getContext(), BizChatAtSomeoneUI.class);
                    intent.putExtra("Block_list", z.aeV().cI(q.this.cgL.getTalkerUserName()));
                    intent.putExtra("Chatroom_member_list", c);
                    intent.putExtra("Chat_User", q.this.cgL.getTalkerUserName());
                    intent.putExtra("Add_address_titile", q.this.cgL.yTx.getMMString(R.string.dre));
                    intent.putExtra("key_biz_chat_id", ((d) q.this.cgL.aF(d.class)).dDz());
                    q.this.cgL.yTx.startActivityForResult(intent, 212);
                }
            } else if (!valueOf.equals(q.this.oor.getLastContent())) {
                q.this.oor.setLastContent(valueOf);
            }
            ((aa) q.this.cgL.aF(aa.class)).z(valueOf, i, substring);
            if (!dVar.dDm()) {
                ChatFooter chatFooter = q.this.oor;
                if (!(chatFooter.vmX == null || chatFooter.oik == null)) {
                    chatFooter.vmX.voJ = true;
                    m mVar = chatFooter.vmX;
                    if (!(bo.isNullOrNil(valueOf) || valueOf.equals(mVar.voI))) {
                        g.RS().aa(new com.tencent.mm.pluginsdk.ui.chat.m.AnonymousClass6(valueOf));
                    }
                    mVar.voI = valueOf;
                }
            }
            AppMethodBeat.o(31418);
        }
    }

    public q() {
        AppMethodBeat.i(31419);
        AppMethodBeat.o(31419);
    }

    public final ChatFooter dDX() {
        return this.oor;
    }

    public final ChatFooterCustom dDY() {
        return this.yPH;
    }

    private void dDZ() {
        AppMethodBeat.i(31420);
        if (this.cgL.yTx.isCurrentActivity) {
            AppMethodBeat.o(31420);
            return;
        }
        this.cgL.yTz.dCz();
        if (this.oor != null) {
            ChatFooter chatFooter = this.oor;
            View findViewById = chatFooter.findViewById(R.id.amd);
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
            chatFooter.vmM = (AppPanel) chatFooter.findViewById(R.id.amr);
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
            if (!bo.ac(chatFooter2.oij.getText())) {
                chatFooter2.oij.setText("");
            }
            chatFooter2.oP(false);
            chatFooter2.dka();
            this.oor.vna.voc = null;
        }
        AppMethodBeat.o(31420);
    }

    public final String dEa() {
        return this.yPN;
    }

    public final void dEb() {
        AppMethodBeat.i(31421);
        try {
            if (this.oor.dky()) {
                this.oor.setBottomPanelVisibility(8);
            }
            AppMethodBeat.o(31421);
        } catch (Exception e) {
            AppMethodBeat.o(31421);
        }
    }

    public final void dEc() {
        AppMethodBeat.i(31422);
        this.cgL.aqX();
        ab.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", this.yPH);
        if (this.yPH == null) {
            AppMethodBeat.o(31422);
            return;
        }
        this.yPH.setVisibility(0);
        if (this.oor != null) {
            this.oor.setVisibility(8);
        }
        AppMethodBeat.o(31422);
    }

    public final void dEd() {
        AppMethodBeat.i(31423);
        if (this.oor == null) {
            AppMethodBeat.o(31423);
            return;
        }
        this.oor.setVisibility(0);
        if (this.yPH != null) {
            this.yPH.setVisibility(8);
        }
        AppMethodBeat.o(31423);
    }

    private void dEe() {
        AppMethodBeat.i(31424);
        ab.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", bo.dpG());
        if (this.oor != null) {
            this.oor.setVisibility(8);
        }
        if (this.yPH != null) {
            this.yPH.setVisibility(8);
        }
        this.oor.oP(false);
        this.cgL.aqX();
        AppMethodBeat.o(31424);
    }

    public final void dEf() {
        AppMethodBeat.i(31425);
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
        AppMethodBeat.o(31425);
    }

    public final void dEg() {
        AppMethodBeat.i(31426);
        ab.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", Integer.valueOf(this.yPO));
        if (this.oor == null) {
            this.oor = (ChatFooter) this.cgL.findViewById(R.id.alw);
            this.oor.vnq = new ChatFooter.b() {
                public final String getTalkerUserName() {
                    AppMethodBeat.i(31409);
                    String talkerUserName = q.this.cgL.getTalkerUserName();
                    AppMethodBeat.o(31409);
                    return talkerUserName;
                }
            };
        }
        if (((i) this.cgL.aF(i.class)).dDN() || com.tencent.mm.ui.widget.snackbar.b.aFF()) {
            if (!this.yPQ) {
                this.yPO = this.oor.getVisibility();
            }
            this.oor.u(0, -1, false);
            if (this.yPH == null) {
                this.yPP = -1;
            } else if (!this.yPQ) {
                this.yPP = this.yPH.getVisibility();
            }
            dEe();
            this.yPQ = true;
            AppMethodBeat.o(31426);
            return;
        }
        this.yPQ = false;
        if (this.yPO == 8 && this.yPP == 8) {
            dEe();
            AppMethodBeat.o(31426);
        } else if (this.yPO == 0) {
            dEd();
            AppMethodBeat.o(31426);
        } else {
            dEc();
            AppMethodBeat.o(31426);
        }
    }

    public final boolean ae(ad adVar) {
        AppMethodBeat.i(31427);
        boolean dET = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dET();
        boolean dES = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dES();
        boolean dDN = ((i) this.cgL.aF(i.class)).dDN();
        boolean dDW = ((com.tencent.mm.ui.chatting.c.b.n) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.n.class)).dDW();
        if (dET || dES || dDN || dDW) {
            ab.i("MicroMsg.ChattingUI.FootComponent", dET + ", " + dES + ", " + dDN + ", " + dDW);
            dEe();
            AppMethodBeat.o(31427);
            return false;
        } else if (adVar == null || !com.tencent.mm.model.t.mV(adVar.field_username)) {
            if (adVar != null && adVar.dsf()) {
                d dVar = (d) this.cgL.aF(d.class);
                if (dVar.dDj() != null) {
                    com.tencent.mm.aj.d.b cJ = dVar.dDj().cJ(false);
                    if (cJ != null) {
                        if (cJ.fvc != null) {
                            cJ.fve = "1".equals(cJ.fvc.optString("IsHideInputToolbarInMsg"));
                        }
                        if (cJ.fve) {
                            ab.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + adVar.field_username + " is hide tool bar");
                            dEe();
                            AppMethodBeat.o(31427);
                            return false;
                        }
                    }
                    if (!(bo.isNullOrNil(adVar.field_username) || cJ == null)) {
                        int intExtra = this.cgL.yTx.getIntExtra("key_temp_session_show_type", 0);
                        switch (cJ.aeh()) {
                            case 2:
                                ab.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + adVar.field_username + " is show custom menu");
                                if (this.yPH == null) {
                                    i.a(this.cgL.yTx, R.id.alx);
                                    this.yPH = (ChatFooterCustom) this.cgL.findViewById(R.id.an1);
                                    if (this.yPH != null) {
                                        this.yPH.u((ViewGroup) this.cgL.findViewById(R.id.ali));
                                    }
                                }
                                c aeo = cJ.aeo();
                                if (aeo != null && aeo.type == 1) {
                                    this.oor.setSwitchButtonMode(1);
                                    this.oor.setOnFooterSwitchListener(((d) this.cgL.aF(d.class)).dDq());
                                    dEd();
                                    break;
                                }
                                this.oor.setSwitchButtonMode(0);
                                try {
                                    if (!com.tencent.mm.model.t.mU(adVar.field_username)) {
                                        ChatFooterCustom chatFooterCustom = this.yPH;
                                        if (!(chatFooterCustom.yHx == null || chatFooterCustom.yHw == null)) {
                                            chatFooterCustom.yHx.setVisibility(0);
                                            chatFooterCustom.yHw.setVisibility(0);
                                        }
                                        if (chatFooterCustom.yHy != null) {
                                            chatFooterCustom.yHy.dBX();
                                        }
                                        this.yPH.setTalker(this.cgL.sRl);
                                        this.yPH.a(this.cgL.yTx, dVar.dDj(), adVar.field_username);
                                        this.yPH.setOnFooterSwitchListener(this.vmZ);
                                        this.yPH.setOnProcessClickListener(((d) this.cgL.aF(d.class)).dDp());
                                        this.oor.setOnFooterSwitchListener(this.vmZ);
                                        if (!((v) this.cgL.aF(v.class)).dEL() || intExtra != 1) {
                                            dEc();
                                            break;
                                        }
                                        dEd();
                                        break;
                                    }
                                    this.yPK = new w(this.yPH);
                                    this.yPK.ctT();
                                    dEc();
                                    break;
                                } catch (Exception e) {
                                    if (aeo == null || aeo.fvL == null || aeo.fvL.size() == 0) {
                                        dEd();
                                    } else {
                                        this.vmZ.oS(true);
                                    }
                                    ab.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", e, "", new Object[0]);
                                    break;
                                }
                                break;
                            default:
                                dEd();
                                String str = "MicroMsg.ChattingUI.FootComponent";
                                String str2 = "bizinfo name=%s, %b, %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = adVar.field_username;
                                if (cJ != null) {
                                    dDW = true;
                                } else {
                                    dDW = false;
                                }
                                objArr[1] = Boolean.valueOf(dDW);
                                objArr[2] = Integer.valueOf(cJ.aeh());
                                ab.e(str, str2, objArr);
                                break;
                        }
                    }
                }
            }
            AppMethodBeat.o(31427);
            return true;
        } else {
            this.yPL = new h(this.yPH);
            this.yPL.ctT();
            dEc();
            AppMethodBeat.o(31427);
            return true;
        }
    }

    public final void dEh() {
        int i;
        AppMethodBeat.i(31428);
        String talkerUserName = this.cgL.getTalkerUserName();
        if (com.tencent.mm.model.t.ne(talkerUserName) || ad.aou(talkerUserName)) {
            i = 1;
        } else if (com.tencent.mm.model.t.nv(talkerUserName)) {
            i = 2;
        } else {
            i = this.cgL.yTx.getIntExtra("Chat_Mode", 0);
            ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yPI), Integer.valueOf(i));
            if (this.yPI != 0) {
                i = this.yPI;
            }
            String value = com.tencent.mm.m.g.Nu().getValue("DefaultMsgType");
            if (this.yPI == 0 && value != null) {
                ab.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", value);
                i = bo.getInt(com.tencent.mm.m.g.Nu().getValue("DefaultMsgType"), 0);
            }
            if (i == 0 && com.tencent.mm.n.a.jh(this.cgL.sRl.field_type)) {
                aw.ZK();
                i = ((Integer) com.tencent.mm.model.c.Ry().get(18, Integer.valueOf(0))).intValue();
            }
            if (i == 0) {
                i = 1;
            }
            ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yPI), Integer.valueOf(i));
        }
        if (i == 2) {
            ab.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.cgL.yTx.getContext(), "android.permission.RECORD_AUDIO", 80, "", "")), bo.dpG(), this.cgL.yTx.getContext());
            if (com.tencent.mm.pluginsdk.permission.b.a(this.cgL.yTx.getContext(), "android.permission.RECORD_AUDIO", 80, "", "")) {
                this.oor.az(i, false);
            }
            AppMethodBeat.o(31428);
            return;
        }
        this.oor.az(i, false);
        AppMethodBeat.o(31428);
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
        ad aoO;
        int vi;
        ChatFooter chatFooter;
        boolean z2 = false;
        AppMethodBeat.i(31429);
        ab.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", str);
        this.oor.dkk();
        this.oor.dkb();
        if (((i) this.cgL.aF(i.class)).dDN()) {
            ab.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
            z = false;
        } else {
            boolean dET = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dET();
            z = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dES();
            if (dET || z) {
                ab.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
                z = false;
            } else if (ad.aow(this.cgL.getTalkerUserName()) || ad.mR(this.cgL.getTalkerUserName())) {
                ab.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
                z = false;
            } else if (com.tencent.mm.model.t.nI(this.cgL.getTalkerUserName())) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            this.oor.dkm();
        }
        if (((d) this.cgL.aF(d.class)).dDm()) {
            com.tencent.mm.aj.d qX = f.qX(this.cgL.getTalkerUserName());
            if (qX == null || qX.field_enterpriseFather == null) {
                z = false;
            } else {
                Cursor qQ = z.aeR().qQ(qX.field_enterpriseFather);
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
        if (!(this.cgL.sRl == null || com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) || com.tencent.mm.model.t.kH(this.cgL.getTalkerUserName()))) {
            this.oor.dkp();
        }
        if (ad.mR(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dkn();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (ad.aow(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dkn();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (ad.aou(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dkn();
            this.oor.dkj();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (com.tencent.mm.model.t.no(str)) {
            this.oor.vmM.djK();
            this.oor.vmM.djM();
            this.oor.vmM.djN();
            this.oor.dko();
            this.oor.vmM.djL();
            this.oor.ac(true, true);
            this.oor.dkp();
            this.oor.dkq();
            this.oor.vmM.djP();
        }
        if (com.tencent.mm.model.t.nl(str)) {
            this.oor.vmM.djK();
            this.oor.ac(true, true);
            this.oor.vmM.djL();
            this.oor.vmM.djP();
        }
        aw.ZK();
        ad aoO2 = com.tencent.mm.model.c.XM().aoO(str);
        if (aoO2 != null && aoO2.dsf()) {
            if (((d) this.cgL.aF(d.class)).dDm()) {
                this.oor.vmM.djK();
                this.oor.vmM.djN();
                this.oor.vmM.djL();
                this.oor.ac(true, true);
                this.oor.dkp();
                this.oor.dkq();
                this.oor.dkm();
                this.oor.vmM.djO();
                this.oor.dkl();
                this.oor.dkr();
                this.oor.AD();
            } else {
                this.oor.vmM.djK();
                this.oor.ac(true, true);
                this.oor.dkn();
                this.oor.vmM.djL();
            }
        }
        if (this.cgL.dFw()) {
            int i;
            if (com.tencent.mm.m.g.Nu().getInt("MultitalkBlockCaller", 0) == 0) {
                i = 1;
            } else {
                z = false;
            }
            if (i != 0) {
                this.oor.oH(false);
                if (this.cgL.dFx() || this.cgL.dFv()) {
                    this.oor.ac(true, true);
                    this.oor.dkq();
                }
                com.tencent.mm.bp.d.dlL();
                if (this.cgL.dFv()) {
                    this.oor.vmM.djL();
                }
                if (this.cgL.getTalkerUserName().equals(r.Yz())) {
                    this.oor.vmM.djL();
                    this.oor.ac(true, true);
                    this.oor.dkp();
                    this.oor.dkq();
                }
                this.oor.setAppPanelTip(null);
                if (ad.aox(this.cgL.sRl.field_username) || com.tencent.mm.model.t.mP(this.cgL.sRl.field_username)) {
                    g.RQ();
                    aoO = ((j) g.K(j.class)).XM().aoO(this.cgL.sRl.field_username);
                    ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).aZ(aoO.field_openImAppid, aoO.field_descWordingId);
                    vi = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).vi(aoO.field_openImAppid);
                    ab.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", Integer.valueOf(vi), this.cgL.sRl.field_username, aoO.field_openImAppid, ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).c(this.cgL.sRl.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.TYPE_WORDING));
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
                        this.oor.ac((vi & 256) != 0, (vi & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0);
                    }
                    if ((vi & 512) == 0) {
                        this.oor.dkp();
                        this.oor.dkq();
                    }
                    if ((vi & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                        this.oor.vmM.vma = true;
                    }
                    if (com.tencent.mm.model.t.mP(this.cgL.sRl.field_username) && (vi & 256) == 0) {
                        this.oor.oH(true);
                    }
                    this.oor.setAppPanelTip(r5);
                }
                chatFooter = this.oor;
                com.tencent.mm.bp.d.dlL();
                if (chatFooter.eAk != null) {
                    chatFooter.eAk.j(false, false);
                }
                chatFooter = this.oor;
                com.tencent.mm.bp.d.dlL();
                if (com.tencent.mm.au.b.ahK()) {
                    z2 = true;
                }
                chatFooter.oI(z2);
                this.oor.vmM.djL();
                if (ad.mg(this.cgL.getTalkerUserName())) {
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
                    this.oor.AD();
                    this.oor.vmM.djO();
                    this.oor.ac(true, true);
                    this.oor.oH(true);
                    this.oor.oI(true);
                    this.oor.dkp();
                    this.oor.dkq();
                    this.oor.vmM.djL();
                    this.oor.vmM.djK();
                    this.oor.vmM.djM();
                    this.oor.vmM.djP();
                }
                AppMethodBeat.o(31429);
            }
        }
        this.oor.oH(true);
        this.oor.ac(true, true);
        this.oor.dkq();
        com.tencent.mm.bp.d.dlL();
        if (this.cgL.dFv()) {
        }
        if (this.cgL.getTalkerUserName().equals(r.Yz())) {
        }
        this.oor.setAppPanelTip(null);
        g.RQ();
        aoO = ((j) g.K(j.class)).XM().aoO(this.cgL.sRl.field_username);
        ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).aZ(aoO.field_openImAppid, aoO.field_descWordingId);
        vi = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).vi(aoO.field_openImAppid);
        ab.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", Integer.valueOf(vi), this.cgL.sRl.field_username, aoO.field_openImAppid, ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).c(this.cgL.sRl.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.TYPE_WORDING));
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
        this.oor.ac((vi & 256) != 0, (vi & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0);
        if ((vi & 512) == 0) {
        }
        if ((vi & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
        }
        this.oor.oH(true);
        this.oor.setAppPanelTip(r5);
        chatFooter = this.oor;
        com.tencent.mm.bp.d.dlL();
        if (chatFooter.eAk != null) {
        }
        chatFooter = this.oor;
        com.tencent.mm.bp.d.dlL();
        if (com.tencent.mm.au.b.ahK()) {
        }
        chatFooter.oI(z2);
        this.oor.vmM.djL();
        if (ad.mg(this.cgL.getTalkerUserName())) {
        }
        AppMethodBeat.o(31429);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(31431);
        if (obj != null) {
            obj.equals("");
        }
        ab.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", obj, this.cgL.getTalkerUserName());
        if (obj.equals(this.cgL.getTalkerUserName())) {
            arm(this.cgL.getTalkerUserName());
            dEh();
        }
        AppMethodBeat.o(31431);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(31432);
        if (str != null) {
            str.equals("");
        }
        ab.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", str, this.cgL.getTalkerUserName());
        if (com.tencent.mm.model.t.mP(this.cgL.getTalkerUserName())) {
            arm(this.cgL.getTalkerUserName());
            dEh();
        }
        AppMethodBeat.o(31432);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31433);
        super.onActivityResult(i, i2, intent);
        if (FaceManager.FACE_ACQUIRED_HACKER == i && -1 == i2) {
            this.oor.dkh();
        }
        if (i2 != -1) {
            if (i == 200 || i == 201 || i == 203) {
                this.oor.clearFocus();
            }
            AppMethodBeat.o(31433);
            return;
        }
        if (!(i == 217 || this.yPH == null)) {
            this.yPH.r(i, intent);
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
                ab.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                AppMethodBeat.o(31433);
                return;
                break;
        }
        AppMethodBeat.o(31433);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        AppMethodBeat.i(31434);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ChattingUI.FootComponent";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bo.dpG();
            ab.w(str, str2, objArr);
            AppMethodBeat.o(31434);
            return;
        }
        int i3;
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        p pVar = this.yPG;
                        if (!this.oor.vmM.vlP.vmD.value) {
                            i2 = 2;
                        }
                        pVar.Om(i2);
                    }
                    AppMethodBeat.o(31434);
                    return;
                }
                i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(i3), this.cgL.yTx.getMMResources().getString(R.string.dc8), this.cgL.yTx.getMMResources().getString(R.string.ckr), this.cgL.yTx.getMMResources().getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(31411);
                            dialogInterface.dismiss();
                            q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(31411);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(31412);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(31412);
                        }
                    });
                }
                AppMethodBeat.o(31434);
                return;
            case 19:
            case 21:
            case 22:
                if (iArr[0] != 0) {
                    i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(i3), this.cgL.yTx.getMMResources().getString(R.string.dc8), this.cgL.yTx.getMMResources().getString(R.string.ckr), this.cgL.yTx.getMMResources().getString(R.string.abx), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(31413);
                                dialogInterface.dismiss();
                                q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(31413);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(31414);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(31414);
                            }
                        });
                    }
                    AppMethodBeat.o(31434);
                    return;
                } else if (i == 19) {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.cbm();
                    }
                    AppMethodBeat.o(31434);
                    return;
                } else if (i == 21) {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCl();
                    }
                    AppMethodBeat.o(31434);
                    return;
                } else {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCj();
                    }
                    AppMethodBeat.o(31434);
                    return;
                }
            case 20:
                if (iArr[0] == 0) {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCn();
                    }
                    AppMethodBeat.o(31434);
                    return;
                }
                com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.dbs), this.cgL.yTx.getMMResources().getString(R.string.dc8), this.cgL.yTx.getMMResources().getString(R.string.ckr), this.cgL.yTx.getMMResources().getString(R.string.abx), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31415);
                        q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        AppMethodBeat.o(31415);
                    }
                }, null);
                AppMethodBeat.o(31434);
                return;
            case 81:
                if (iArr[0] == 0) {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCm();
                    }
                    AppMethodBeat.o(31434);
                    return;
                }
                com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.dby), this.cgL.yTx.getMMResources().getString(R.string.dc8), this.cgL.yTx.getMMResources().getString(R.string.ckr), this.cgL.yTx.getMMResources().getString(R.string.abx), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31416);
                        q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        AppMethodBeat.o(31416);
                    }
                }, null);
                AppMethodBeat.o(31434);
                return;
            case 82:
            case 83:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.dc0), this.cgL.yTx.getMMResources().getString(R.string.dc8), this.cgL.yTx.getMMResources().getString(R.string.ckr), this.cgL.yTx.getMMResources().getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(31408);
                            q.this.cgL.yTx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(31408);
                        }
                    }, null);
                    break;
                } else if (i == 82) {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.cbl();
                    }
                    AppMethodBeat.o(31434);
                    return;
                } else {
                    ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.yPG, bo.dpG());
                    if (this.yPG != null) {
                        this.yPG.dCk();
                    }
                    AppMethodBeat.o(31434);
                    return;
                }
        }
        AppMethodBeat.o(31434);
    }

    public final void dDh() {
        AppMethodBeat.i(31436);
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
        com.tencent.mm.pluginsdk.ui.e.j.clearCache();
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
        g.RQ();
        ((j) g.K(j.class)).XM().b(this);
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().d(this);
        AppMethodBeat.o(31436);
    }

    public final void dxy() {
        int i;
        AppMethodBeat.i(31437);
        this.yPR = false;
        this.yPS = false;
        this.yPT = 0;
        aw.ZK();
        ak aoZ = com.tencent.mm.model.c.XR().aoZ(this.cgL.getTalkerUserName());
        if (aoZ != null) {
            this.yPI = aoZ.field_chatmode;
        }
        ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", Integer.valueOf(this.yPI));
        String talkerUserName = this.cgL.getTalkerUserName();
        if (this.oor == null) {
            this.oor = (ChatFooter) this.cgL.findViewById(R.id.alw);
            this.oor.vnq = new ChatFooter.b() {
                public final String getTalkerUserName() {
                    AppMethodBeat.i(31410);
                    String talkerUserName = q.this.cgL.getTalkerUserName();
                    AppMethodBeat.o(31410);
                    return talkerUserName;
                }
            };
        }
        this.oor.setCattingRootLayoutId(R.id.zd);
        ab.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", this.yPH);
        if (this.yPH != null) {
            this.yPH.ctm();
            this.yPH.setOnFooterSwitchListener(null);
            this.yPH.setOnProcessClickListener(null);
            this.oor.setOnFooterSwitchListener(null);
            this.yPH.dBU();
        }
        dEe();
        this.oor.dkk();
        boolean dET = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dET();
        boolean dES = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dES();
        boolean i2;
        if (dET || dES) {
            dEe();
        } else if (com.tencent.mm.model.t.nc(talkerUserName)) {
            dEe();
            i.a(this.cgL.yTx, R.id.alx);
            if (this.yPH == null) {
                i2 = 1;
            } else {
                i2 = false;
            }
            this.yPH = (ChatFooterCustom) this.cgL.findViewById(R.id.an1);
            if (i2 != 0) {
                this.yPH.u((ViewGroup) this.cgL.findViewById(R.id.ali));
            }
            this.yPJ = new t(this.yPH);
            t tVar = this.yPJ;
            if (com.tencent.mm.sdk.platformtools.g.cdf == 1) {
                i2 = 1;
            } else {
                i2 = false;
            }
            tVar.yJS.findViewById(R.id.an2).setVisibility(8);
            tVar.lfQ = (LinearLayout) tVar.yJS.findViewById(R.id.an4);
            tVar.yJS.findViewById(R.id.an5).setVisibility(8);
            tVar.lfQ.setWeightSum(i2 != 0 ? 1.0f : 2.0f);
            tVar.yJT = (FrameLayout) tVar.lfQ.getChildAt(0);
            tVar.yJT.setVisibility(0);
            tVar.yJT.setOnClickListener(tVar.yKc);
            ((TextView) tVar.yJT.findViewById(R.id.an0)).setText(R.string.aj8);
            tVar.yJT.findViewById(R.id.amz).setVisibility(8);
            tVar.yJT.getChildAt(2).setVisibility(8);
            int i3;
            if (i2 != 0) {
                for (i3 = 1; i3 < 6; i3++) {
                    tVar.lfQ.getChildAt(i3).setVisibility(8);
                }
            } else {
                tVar.yJU = (FrameLayout) tVar.lfQ.getChildAt(1);
                tVar.yJU.setVisibility(0);
                tVar.yJU.setOnClickListener(tVar.yKd);
                tVar.yJV = (TextView) tVar.yJU.findViewById(R.id.an0);
                tVar.yJW = (ImageView) tVar.yJU.findViewById(R.id.amz);
                tVar.yJW.setVisibility(0);
                tVar.dCr();
                aw.ZK();
                tVar.yJY = ((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1))).intValue();
                if (tVar.yJY >= 0) {
                    tVar.dCt();
                } else {
                    tVar.yJV.setText(R.string.ajk);
                }
                tVar.yJU.getChildAt(2).setVisibility(8);
                for (i3 = 2; i3 < 6; i3++) {
                    tVar.lfQ.getChildAt(i3).setVisibility(8);
                }
                tVar.yKb = com.tencent.mm.m.g.Nv().getMailAppEnterUlAndroid();
                if (bo.isNullOrNil(tVar.yKb)) {
                    tVar.yKb = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                }
                aw.ZK();
                tVar.yKb = tVar.yKb.replace("$uin$", new com.tencent.mm.a.p(bo.h((Integer) com.tencent.mm.model.c.Ry().get(9, null))).toString());
                tVar.pzJ = com.tencent.mm.m.g.Nv().Nm();
                tVar.yJZ = true;
            }
            dEc();
        } else {
            this.yPJ = null;
            if (com.tencent.mm.model.t.mU(talkerUserName)) {
                dEe();
                i.a(this.cgL.yTx, R.id.alx);
                if (this.yPH == null) {
                    i2 = 1;
                } else {
                    i2 = false;
                }
                this.yPH = (ChatFooterCustom) this.cgL.findViewById(R.id.an1);
                if (i2 != 0) {
                    this.yPH.u((ViewGroup) this.cgL.findViewById(R.id.ali));
                }
                this.yPK = new w(this.yPH);
                this.yPK.ctT();
                dEc();
            } else {
                this.yPK = null;
                if (com.tencent.mm.model.t.mV(talkerUserName)) {
                    dEe();
                    i.a(this.cgL.yTx, R.id.alx);
                    if (this.yPH == null) {
                        i2 = 1;
                    } else {
                        i2 = false;
                    }
                    this.yPH = (ChatFooterCustom) this.cgL.findViewById(R.id.an1);
                    if (i2 != 0) {
                        this.yPH.u((ViewGroup) this.cgL.findViewById(R.id.ali));
                    }
                    this.yPL = new h(this.yPH);
                    this.yPL.ctT();
                    dEc();
                } else {
                    this.yPL = null;
                    if (!(com.tencent.mm.model.t.nd(talkerUserName) || com.tencent.mm.model.t.mU(talkerUserName) || com.tencent.mm.model.t.nc(talkerUserName) || com.tencent.mm.model.t.mV(talkerUserName))) {
                        com.tencent.mm.model.t.Zj();
                        if (!com.tencent.mm.model.t.nD(talkerUserName)) {
                            dEd();
                            ae(this.cgL.sRl);
                            this.oor.setUserName(talkerUserName);
                            arm(talkerUserName);
                            i iVar = (i) this.cgL.aF(i.class);
                            com.tencent.mm.ui.chatting.c.b.z zVar = (com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class);
                            if (iVar.dDN()) {
                                if (zVar.dEQ()) {
                                    zVar.dEP();
                                    iVar.dDO();
                                } else {
                                    iVar.dDL();
                                }
                            }
                        }
                    }
                    dEe();
                }
            }
        }
        dDZ();
        this.yPG = new p(this.cgL, this.oor, this.cgL.getTalkerUserName());
        this.yPG.yJj = this.cgL.yTx.getBooleanExtra("key_need_send_video", true).booleanValue();
        this.oor.setFooterEventListener(this.yPG);
        com.tencent.mm.ui.chatting.v vVar = new com.tencent.mm.ui.chatting.v(this.cgL.yTx.getContext(), this.cgL.sRl, this.cgL.getTalkerUserName());
        this.oor.setSmileyPanelCallback(vVar);
        this.oor.setSmileyPanelCallback2(vVar);
        dEh();
        this.oor.dkd();
        ab.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", Boolean.valueOf(((v) this.cgL.aF(v.class)).dEL()), Integer.valueOf(this.cgL.yTx.getIntExtra("key_temp_session_show_type", 0)));
        ab.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", Boolean.valueOf(r0.dEL()));
        if (((v) this.cgL.aF(v.class)).dEL()) {
            if (i2 == 1) {
                this.vmZ.oS(true);
            } else {
                this.vmZ.oS(false);
            }
        }
        ae(this.cgL.sRl);
        g.RQ();
        ((j) g.K(j.class)).XM().a(this);
        ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().c(this);
        AppMethodBeat.o(31437);
    }

    public final void dxz() {
    }

    public final void dxC() {
    }

    public final void setVoiceInputShowCallback(ChatFooter.d dVar) {
        AppMethodBeat.i(31430);
        this.oor.setVoiceInputShowCallback(dVar);
        AppMethodBeat.o(31430);
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
        AppMethodBeat.i(31435);
        ab.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4) {
            if (!this.cgL.caA) {
                ab.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
            } else if (this.cgL.yTx.isSupportNavigationSwipeBack() && this.cgL.yTx.getSwipeBackLayout().dkx()) {
                ab.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
                i2 = 1;
                if (i2 != 0) {
                }
            } else {
                if (keyEvent.getAction() == 0) {
                    this.yPR = true;
                    this.yPT = System.currentTimeMillis();
                }
                if (keyEvent.getAction() == 1) {
                    ab.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", Boolean.valueOf(this.yPR), Long.valueOf(System.currentTimeMillis() - this.yPT));
                    boolean onKeyDown;
                    if (!this.yPR || System.currentTimeMillis() - this.yPT > 30000) {
                        i2 = 1;
                        if (i2 != 0) {
                            onKeyDown = super.onKeyDown(i, keyEvent);
                            AppMethodBeat.o(31435);
                            return onKeyDown;
                        }
                        AppMethodBeat.o(31435);
                        return true;
                    }
                    this.yPS = true;
                    i iVar = (i) this.cgL.aF(i.class);
                    com.tencent.mm.ui.chatting.c.b.z zVar = (com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class);
                    if (iVar.dDN()) {
                        if (zVar.dEQ()) {
                            zVar.dEP();
                            iVar.dDO();
                        } else {
                            iVar.dDL();
                        }
                        i2 = 1;
                    } else {
                        onKeyDown = false;
                    }
                    if (i2 == 0) {
                        if (this.oor == null || !this.oor.dky()) {
                            this.cgL.yTx.dBP();
                        } else {
                            this.oor.u(2, 23, false);
                        }
                    }
                }
                i2 = 1;
                if (i2 != 0) {
                }
            }
        } else if (keyEvent.getKeyCode() == 67 && !this.cgL.caA) {
            ab.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
        } else if (!this.cgL.caA) {
            ab.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
        }
        i2 = false;
        if (i2 != 0) {
        }
    }

    public final void dxA() {
        boolean booleanValue;
        AppMethodBeat.i(31438);
        this.yPN = this.cgL.yTx.getStringExtra("smiley_product_id");
        if (this.oor.dkD()) {
            ((com.tencent.mm.ui.chatting.c.b.ab) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.ab.class)).keepSignalling();
        }
        if (com.tencent.mm.model.t.nc(this.cgL.getTalkerUserName()) && this.yPJ != null && this.yPJ.yJZ) {
            this.yPJ.dCs();
        }
        ChatFooter chatFooter = this.oor;
        BaseChattingUIFragment baseChattingUIFragment = this.cgL.yTx;
        chatFooter.vnp = baseChattingUIFragment;
        if (!chatFooter.vjb) {
            chatFooter.findViewById(R.id.amc).setVisibility(0);
        }
        chatFooter.a(baseChattingUIFragment.getContext(), baseChattingUIFragment.thisActivity());
        chatFooter.vnV = true;
        if (!(bo.isNullOrNil(this.yPN) || this.oor == null)) {
            ab.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", this.yPN);
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
                ab.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
            }
        }
        if (ae(this.cgL.sRl)) {
            if (this.oor != null) {
                aw.ZK();
                booleanValue = ((Boolean) com.tencent.mm.model.c.Ry().get(66832, Boolean.FALSE)).booleanValue();
                ab.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(booleanValue));
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
            ((ae) this.cgL.aF(ae.class)).dDS();
            if (this.oor != null) {
                this.oor.vmM.refresh();
                this.oor.addTextChangedListener(new a(this, (byte) 0));
                ab.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
            }
        }
        boolean dET = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dET();
        boolean dES = ((com.tencent.mm.ui.chatting.c.b.z) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.z.class)).dES();
        booleanValue = ((i) this.cgL.aF(i.class)).dDN();
        if (dET || dES || booleanValue || this.cgL.sRl == null || this.cgL.sRl.dsf() || com.tencent.mm.model.t.nF(this.cgL.getTalkerUserName()) || com.tencent.mm.ui.widget.snackbar.b.aFF() || com.tencent.mm.model.t.mV(this.cgL.getTalkerUserName())) {
            ab.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
            AppMethodBeat.o(31438);
            return;
        }
        ab.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
        dEd();
        AppMethodBeat.o(31438);
    }

    public final void dxB() {
        AppMethodBeat.i(31439);
        if (this.oor != null) {
            ChatFooter chatFooter = this.oor;
            if (chatFooter.vnw != null) {
                chatFooter.oij.removeTextChangedListener(chatFooter.vnw);
                chatFooter.vnw = null;
            }
            ab.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
            this.oor.onPause();
            if (g.RK()) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(18, Integer.valueOf(this.oor.getMode()));
                ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", Integer.valueOf(this.yPI), Integer.valueOf(this.oor.getMode()));
                if (this.yPI != this.oor.getMode()) {
                    this.yPI = this.oor.getMode();
                    aw.ZK();
                    ak aoZ = com.tencent.mm.model.c.XR().aoZ(this.cgL.getTalkerUserName());
                    if (aoZ != null && this.cgL.getTalkerUserName().equals(aoZ.field_username)) {
                        aoZ.hN(this.yPI);
                        aw.ZK();
                        com.tencent.mm.model.c.XR().a(aoZ, this.cgL.getTalkerUserName());
                    }
                }
                this.oor.bvH();
                AppMethodBeat.o(31439);
                return;
            }
            ab.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
            AppMethodBeat.o(31439);
            return;
        }
        AppMethodBeat.o(31439);
    }
}

package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.d.a.b;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(dFp = d.class)
public class c extends a implements n, d {
    private bxk fwz = null;
    public boolean mgP = false;
    private com.tencent.mm.aj.d pkW;
    private com.tencent.mm.ui.widget.a.c pmG = null;
    public j pmx;
    public com.tencent.mm.aj.a.c yDI;
    private com.tencent.mm.aj.a.d.a yEn = new com.tencent.mm.aj.a.d.a() {
        public final void a(b bVar) {
            AppMethodBeat.i(31200);
            if (c.this.mgP && bVar != null && bVar.fxq == c.this.dDz()) {
                if (!c.this.cgL.caA) {
                    ab.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
                    AppMethodBeat.o(31200);
                    return;
                } else if (bVar.fxA != com.tencent.mm.aj.a.d.a.a.DELETE) {
                    ab.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
                    c.this.yDI = z.aeT().aK(c.this.dDz());
                    if (c.this.yNZ) {
                        c.this.yOh = e.c(c.this.yDI);
                        ((r) c.this.cgL.aF(r.class)).dEp();
                    } else {
                        j cH = z.aeV().cH(c.this.yDI.field_bizChatServId);
                        if (cH != null) {
                            c.this.pmx = cH;
                        }
                    }
                    ((r) c.this.cgL.aF(r.class)).dEm();
                    AppMethodBeat.o(31200);
                    return;
                } else if (c.this.yNZ) {
                    Toast.makeText(ah.getContext(), c.this.cgL.yTx.getMMResources().getString(R.string.dsd), 1).show();
                    c.this.cgL.yTx.dBP();
                }
            }
            AppMethodBeat.o(31200);
        }
    };
    protected final ChatFooter.e yGx = new ChatFooter.e() {
        public final boolean oS(boolean z) {
            AppMethodBeat.i(31199);
            if (c.this.pkW == null) {
                AppMethodBeat.o(31199);
                return false;
            }
            com.tencent.mm.aj.d.b cJ = c.this.pkW.cJ(false);
            if (cJ == null) {
                AppMethodBeat.o(31199);
                return false;
            }
            com.tencent.mm.aj.d.b.c aeo = cJ.aeo();
            if (aeo == null || aeo.fvL == null || aeo.fvL.isEmpty()) {
                AppMethodBeat.o(31199);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(((com.tencent.mm.aj.j) aeo.fvL.get(0)).value);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE;
                appBrandStatObject.cst = c.this.pkW.field_username;
                ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(c.this.cgL.yTx.getContext(), jSONObject.optString("userName"), null, 0, 0, jSONObject.optString("pagePath"), appBrandStatObject, c.this.pkW.field_appId);
                AppMethodBeat.o(31199);
                return true;
            } catch (JSONException e) {
                AppMethodBeat.o(31199);
                return false;
            }
        }
    };
    protected final a yHz = new a() {
        public final boolean dDC() {
            AppMethodBeat.i(31195);
            if (c.this.yOb == null) {
                i.a(c.this.cgL.yTx, R.id.alk);
                c.this.yOb = (RelativeLayout) c.this.cgL.findViewById(R.id.auy);
                c.this.yOc = (TextView) c.this.cgL.findViewById(R.id.auz);
                c.this.yOc.setText(R.string.aj9);
            }
            c.this.yOb.setVisibility(0);
            com.tencent.mm.ui.chatting.d.a.dFz().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31194);
                    if (!(c.this.yOb == null || c.this.yOb.getVisibility() == 8)) {
                        c.this.yOb.setVisibility(8);
                    }
                    if (c.this.cgL == null) {
                        ab.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
                        AppMethodBeat.o(31194);
                        return;
                    }
                    ((r) c.this.cgL.aF(r.class)).dEm();
                    c.this.cgL.aWv();
                    AppMethodBeat.o(31194);
                }
            }, 5000);
            AppMethodBeat.o(31195);
            return true;
        }
    };
    private com.tencent.mm.app.plugin.a.a yNW;
    private long yNX = 0;
    private bi yNY;
    public boolean yNZ = false;
    private long yOa = -1;
    private RelativeLayout yOb;
    private TextView yOc;
    private int yOd;
    private boolean yOe = false;
    private boolean yOf = false;
    private com.tencent.mm.aj.e.a yOg = new com.tencent.mm.aj.e.a() {
        public final void a(final com.tencent.mm.aj.e.a.b bVar) {
            AppMethodBeat.i(31202);
            if (bVar != null && bVar.fwk == com.tencent.mm.aj.e.a.a.UPDATE && bVar.fuO != null && bVar.fuO.equals(c.this.cgL.getTalkerUserName())) {
                aw.ZK();
                final ad aoO = com.tencent.mm.model.c.XM().aoO(bVar.fuO);
                if (aoO == null || ((int) aoO.ewQ) == 0) {
                    ab.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", bVar.fuO);
                    AppMethodBeat.o(31202);
                    return;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(31201);
                        if (c.this.yOe && bVar.fuO.equals(c.this.cgL.getTalkerUserName())) {
                            ab.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                            c.this.pkW = f.qX(bVar.fuO);
                            if (c.this.cgL != null && c.this.yOf) {
                                ((o) c.this.cgL.aF(o.class)).ae(aoO);
                            }
                        }
                        AppMethodBeat.o(31201);
                    }
                });
            }
            AppMethodBeat.o(31202);
        }
    };
    private boolean yOh = false;

    public interface a {
        boolean dDC();
    }

    public c() {
        AppMethodBeat.i(31208);
        AppMethodBeat.o(31208);
    }

    public final com.tencent.mm.aj.d dDj() {
        return this.pkW;
    }

    public final com.tencent.mm.aj.a.c dDk() {
        return this.yDI;
    }

    public final j dDl() {
        return this.pmx;
    }

    public final boolean dDm() {
        return this.mgP;
    }

    public final boolean dDn() {
        return this.yNZ;
    }

    public static boolean aU(Intent intent) {
        AppMethodBeat.i(31209);
        String stringExtra = intent.getStringExtra("Chat_User");
        boolean booleanExtra = intent.getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            ab.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
            AppMethodBeat.o(31209);
            return true;
        } else if (booleanExtra && intent.getLongExtra("key_biz_chat_id", -1) == -1) {
            ab.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
            AppMethodBeat.o(31209);
            return true;
        } else {
            AppMethodBeat.o(31209);
            return false;
        }
    }

    public final boolean dDo() {
        AppMethodBeat.i(31210);
        if (this.mgP) {
            if (this.yNZ) {
                int fB = e.fB(dDz());
                if (!bo.isNullOrNil(this.yDI.field_chatName)) {
                    ((r) this.cgL.aF(r.class)).M(this.cgL.yTx.getMMResources().getString(R.string.bwu, new Object[]{this.yDI.field_chatName, Integer.valueOf(fB)}));
                } else if (fB == 0) {
                    this.cgL.yTx.setMMTitle(this.cgL.yTx.getMMResources().getString(R.string.ao1));
                } else {
                    this.cgL.yTx.setMMTitle(this.cgL.yTx.getMMResources().getString(R.string.bwu, new Object[]{this.cgL.yTx.getMMResources().getString(R.string.ao1), Integer.valueOf(fB)}));
                }
            } else {
                this.cgL.yTx.setMMTitle(this.pmx.field_userName);
            }
            AppMethodBeat.o(31210);
            return true;
        }
        AppMethodBeat.o(31210);
        return false;
    }

    public final a dDp() {
        return this.yHz;
    }

    public final ChatFooter.e dDq() {
        return this.yGx;
    }

    public final String ru(String str) {
        AppMethodBeat.i(31211);
        j ro = this.yDI.ro(str);
        if (ro != null) {
            String str2 = ro.field_headImageUrl;
            AppMethodBeat.o(31211);
            return str2;
        }
        AppMethodBeat.o(31211);
        return null;
    }

    public final List<bi> dDr() {
        int i = 100;
        AppMethodBeat.i(31212);
        com.tencent.mm.aj.a.a fv = z.aeU().fv(dDz());
        if (fv.field_unReadCount <= 100) {
            i = fv.field_unReadCount;
        }
        aw.ZK();
        List o = com.tencent.mm.model.c.XP().o(this.cgL.sRl.field_username, dDz(), i);
        AppMethodBeat.o(31212);
        return o;
    }

    public final boolean dDs() {
        return this.yOh;
    }

    private void djt() {
        int currentTimeMillis;
        AppMethodBeat.i(31213);
        bh.A("bizflag", false);
        if (this.mgP) {
            dDB();
            z.afe();
            com.tencent.mm.aj.a.c cVar = this.yDI;
            if (com.tencent.mm.kernel.a.jP(g.RN().eIV)) {
                y.b(cVar.field_brandUserName, 8, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                ab.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", r2);
            }
        }
        if (this.yNX != 0) {
            currentTimeMillis = ((int) (System.currentTimeMillis() - this.yNX)) / 1000;
        } else {
            currentTimeMillis = 0;
        }
        if (aw.RK()) {
            if (this.mgP) {
                z.aeT().a(this.yEn);
            }
            if (this.cgL.sRl != null && this.cgL.sRl.dsf()) {
                z.aeR().a(this.yOg);
            }
            if (com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && !f.kq(this.cgL.getTalkerUserName())) {
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
                z.afc().a(this.cgL.getTalkerUserName(), this.fwz);
            }
        }
        if (com.tencent.mm.app.plugin.a.a.a(this.pkW) && this.yNW != null) {
            ab.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", dDw());
            this.yNW.a(2, this.pkW);
            this.cgL.yTx.setMMSubTitle(null);
        }
        if (com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && currentTimeMillis != 0) {
            int intExtra = this.cgL.yTx.getIntExtra("specific_chat_from_scene", 0);
            int sessionId = s.getSessionId();
            h.pYm.e(10638, this.cgL.getTalkerUserName(), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.cgL.yTx.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.cgL.yTx.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(intExtra), Integer.valueOf(sessionId));
        }
        if (this.yNW != null) {
            com.tencent.mm.app.plugin.a.a aVar = this.yNW;
            ab.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
            if (aVar.cgM != null) {
                com.tencent.mm.sdk.b.a.xxA.d(aVar.cgM);
                aVar.cgM = null;
                if (aVar.cgP != null) {
                    aVar.cgP.clear();
                }
            }
            aVar.cgQ = false;
            if (aVar.cgN != null) {
                com.tencent.mm.sdk.b.a.xxA.d(aVar.cgN);
                aVar.cgN = null;
            }
            this.yNW = null;
        }
        s.aom(null);
        this.yNX = 0;
        AppMethodBeat.o(31213);
    }

    public final void dDt() {
        AppMethodBeat.i(31214);
        if (this.pkW == null) {
            AppMethodBeat.o(31214);
            return;
        }
        String string;
        final boolean z = (com.tencent.mm.modelgeo.d.agA() || com.tencent.mm.modelgeo.d.agB()) ? false : true;
        if (this.pkW.field_hadAlert == 0 && z) {
            string = this.cgL.yTx.getMMResources().getString(R.string.ak5, new Object[]{this.cgL.sRl.Oj()});
        } else if (z) {
            string = this.cgL.yTx.getMMResources().getString(R.string.ak6);
        } else {
            string = this.cgL.yTx.getMMResources().getString(R.string.ak4, new Object[]{this.cgL.sRl.Oj()});
        }
        this.pmG = com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), string, this.cgL.yTx.getMMResources().getString(R.string.tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(31205);
                c.this.pkW.field_hadAlert = 1;
                com.tencent.mm.aj.d c = c.this.pkW;
                if (c != null) {
                    c.field_brandFlag |= 4;
                    f.g(c);
                }
                if (z) {
                    c.this.cgL.yTx.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    AppMethodBeat.o(31205);
                    return;
                }
                z.afc().rj(c.this.cgL.getTalkerUserName());
                AppMethodBeat.o(31205);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(31206);
                c.this.pkW.field_hadAlert = 1;
                com.tencent.mm.aj.d c = c.this.pkW;
                if (c != null) {
                    c.field_brandFlag &= -5;
                    f.g(c);
                }
                z.afc().rj(c.this.cgL.getTalkerUserName());
                AppMethodBeat.o(31206);
            }
        });
        AppMethodBeat.o(31214);
    }

    public final void dDu() {
        AppMethodBeat.i(31215);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", this.cgL.getTalkerUserName());
        intent.putExtra("key_start_biz_profile_setting_from_scene", 1);
        com.tencent.mm.bp.d.b(this.cgL.yTx.getContext(), Scopes.PROFILE, ".ui.newbizinfo.NewBizInfoSettingUI", intent);
        AppMethodBeat.o(31215);
    }

    public final int dDv() {
        return this.yOd;
    }

    private boolean f(KeyEvent keyEvent) {
        AppMethodBeat.i(31216);
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (this.pkW == null || this.pkW.cJ(false) == null || this.pkW.cJ(false).aeo() == null || this.pkW.cJ(false).aeo().fvL == null || this.pkW.cJ(false).aeo().fvL.isEmpty())) {
            ((o) this.cgL.aF(o.class)).dDX().dkc();
        }
        AppMethodBeat.o(31216);
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
        AppMethodBeat.i(31217);
        Intent intent = new Intent(this.cgL.yTx.getContext(), ChatroomInfoUI.class);
        int i = (this.cgL.dFw() || this.yNZ) ? true : 0;
        if (i != 0 && !this.mgP) {
            intent.putExtra("Chat_User", this.cgL.sRl.field_username);
            intent.putExtra("RoomInfo_Id", this.cgL.getTalkerUserName());
            intent.putExtra("Is_Chatroom", this.cgL.dFw());
            intent.putExtra("fromChatting", true);
            this.cgL.startActivity(intent);
            AppMethodBeat.o(31217);
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
            AppMethodBeat.o(31217);
            return true;
        } else if (t.nF(this.cgL.getTalkerUserName()) || ad.aou(this.cgL.getTalkerUserName()) || ad.aow(this.cgL.getTalkerUserName()) || t.nB(this.cgL.getTalkerUserName()) || ad.mR(this.cgL.getTalkerUserName()) || this.cgL.sRl.dsf()) {
            boolean z;
            intent = new Intent();
            com.tencent.mm.ui.contact.e.r(intent, this.cgL.getTalkerUserName());
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
            if (((v) this.cgL.aF(v.class)).dEL() && i.arl(this.cgL.getTalkerUserName())) {
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
                com.tencent.mm.plugin.sport.a.d.kT(2);
                com.tencent.mm.plugin.r.a.bVv();
                if (com.tencent.mm.ax.c.lQ(com.tencent.mm.ax.b.fKF)) {
                    com.tencent.mm.plugin.r.a.bVt();
                    com.tencent.mm.ax.d.lR(com.tencent.mm.ax.b.fKF);
                    intent.putExtra("key_from_wesport_right_newtips", true);
                }
            }
            intent.putExtra("KOpenArticleSceneFromScene", 0);
            com.tencent.mm.bp.d.b(this.cgL.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent, 213);
            AppMethodBeat.o(31217);
            return true;
        } else {
            AppMethodBeat.o(31217);
            return false;
        }
    }

    public final boolean dDy() {
        boolean z = false;
        AppMethodBeat.i(31218);
        if (this.cgL == null) {
            ab.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
            AppMethodBeat.o(31218);
            return false;
        }
        if (this.cgL.sRl.dsf() && this.pkW != null) {
            if (this.mgP) {
                z = z.aeU().fx(dDz());
                AppMethodBeat.o(31218);
                return z;
            } else if (this.pkW.adQ()) {
                if (!(this.pkW.cJ(false) == null || this.pkW.cJ(false).aer() == null || bo.isNullOrNil(this.pkW.adX()))) {
                    aw.ZK();
                    ak apn = com.tencent.mm.model.c.XR().apn(this.pkW.adX());
                    if (apn != null && apn.field_username.equals(this.cgL.getTalkerUserName()) && apn.field_unReadCount > 0) {
                        if (this.cgL.yTx.getIntExtra("chat_from_scene", 0) == 2) {
                            AppMethodBeat.o(31218);
                            return false;
                        }
                        aw.ZK();
                        com.tencent.mm.model.c.XR().apb(this.pkW.adX());
                    }
                }
            } else if (!(this.pkW.adM() || this.pkW.adO())) {
                if (s.aVO()) {
                    com.tencent.mm.storage.r aeX = z.aeX();
                    q drI = aeX.drI();
                    if (drI != null) {
                        z = aeX.mI(drI.field_orderFlag);
                    }
                    if (z <= false) {
                        com.tencent.mm.storage.r aeX2 = z.aeX();
                        aeX2.fni.hY("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + this.cgL.getTalkerUserName() + "' ");
                        com.tencent.mm.storage.r.a aVar = new com.tencent.mm.storage.r.a();
                        aVar.xId = com.tencent.mm.storage.r.b.UPDATE;
                        aeX2.a(aVar);
                    }
                } else {
                    aw.ZK();
                    ak dsT = com.tencent.mm.model.c.XR().dsT();
                    if (dsT != null && dsT.field_username.equals(this.cgL.getTalkerUserName()) && dsT.field_unReadCount > 0) {
                        aw.ZK();
                        com.tencent.mm.model.c.XR().apb("officialaccounts");
                    }
                }
            }
        }
        if (t.ny(this.cgL.getTalkerUserName())) {
            AppMethodBeat.o(31218);
            return true;
        }
        aw.ZK();
        z = com.tencent.mm.model.c.XR().apb(this.cgL.getTalkerUserName());
        AppMethodBeat.o(31218);
        return z;
    }

    public final void a(int i, m mVar) {
        AppMethodBeat.i(31219);
        if (mVar.getType() == 1357) {
            this.cgL.dismissDialog();
            if (i != 0) {
                Toast.makeText(ah.getContext(), this.cgL.yTx.getMMResources().getString(R.string.dro), 0).show();
            }
        }
        AppMethodBeat.o(31219);
    }

    public final long dDz() {
        return this.yDI == null ? -1 : this.yDI.field_bizChatLocalId;
    }

    public final void dDA() {
        AppMethodBeat.i(31220);
        aw.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31207);
                if (c.this.cgL == null) {
                    AppMethodBeat.o(31207);
                    return;
                }
                boolean isInEditMode = ((com.tencent.mm.ui.chatting.c.b.h) c.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).isInEditMode();
                if (c.this.mgP && !isInEditMode) {
                    e.d(c.this.yDI);
                }
                AppMethodBeat.o(31207);
            }
        }, 500);
        AppMethodBeat.o(31220);
    }

    public final String ari(String str) {
        AppMethodBeat.i(31221);
        if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && this.pkW != null) {
                com.tencent.mm.aj.d.b cJ = this.pkW.cJ(false);
                if (!(cJ == null || TextUtils.isEmpty(cJ.aen()) || !substring.contains(cJ.aen()))) {
                    AppMethodBeat.o(31221);
                    return substring;
                }
            }
        }
        AppMethodBeat.o(31221);
        return null;
    }

    public final void aH(LinkedList<String> linkedList) {
        AppMethodBeat.i(31222);
        z.aeT().aK(dDz());
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
            com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.ds1, new Object[]{aI(linkedList2)}), null, this.cgL.yTx.getMMResources().getString(R.string.ds9), this.cgL.yTx.getMMResources().getString(R.string.or), true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(31196);
                    kg kgVar = new kg();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < linkedList2.size()) {
                            kf kfVar = new kf();
                            kfVar.vNc = (String) linkedList2.get(i3);
                            kgVar.vNd.add(kfVar);
                            i2 = i3 + 1;
                        } else {
                            c.a(c.this, kgVar);
                            AppMethodBeat.o(31196);
                            return;
                        }
                    }
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(31222);
        } else if (linkedList.size() == 1) {
            com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.ds7), null, this.cgL.yTx.getMMResources().getString(R.string.ds8), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(31222);
        } else {
            com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.ds2), null, this.cgL.yTx.getMMResources().getString(R.string.ds8), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(31222);
        }
    }

    private String aI(LinkedList<String> linkedList) {
        AppMethodBeat.i(31223);
        if (linkedList.size() <= 0) {
            AppMethodBeat.o(31223);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(this.yDI.mJ((String) linkedList.get(0)));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                stringBuilder.append(this.cgL.yTx.getContext().getString(R.string.ajw)).append(this.yDI.mJ((String) linkedList.get(i2)));
                i = i2 + 1;
            } else {
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(31223);
                return stringBuilder2;
            }
        }
    }

    private void dDB() {
        AppMethodBeat.i(31224);
        if (this.mgP) {
            z.aeZ();
            com.tencent.mm.aj.a.h.e(this.cgL.getTalkerUserName(), this.yDI.field_bizChatServId, (int) (System.currentTimeMillis() / 1000));
            AppMethodBeat.o(31224);
            return;
        }
        AppMethodBeat.o(31224);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(31225);
        boolean f = f(keyEvent);
        AppMethodBeat.o(31225);
        return f;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31226);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS /*12001*/:
                if (this.yNW != null) {
                    com.tencent.mm.app.plugin.a.a aVar = this.yNW;
                    if (aVar.cgL != null) {
                        if (i2 != -1) {
                            if (i2 == 0) {
                                Toast.makeText(aVar.cgL.yTx.getContext(), R.string.bgx, 0).show();
                                break;
                            }
                        }
                        Toast.makeText(aVar.cgL.yTx.getContext(), R.string.bgy, 0).show();
                        ed edVar = new ed();
                        edVar.cxE.op = 0;
                        edVar.cxE.userName = aVar.cgL.getTalkerUserName();
                        edVar.cxE.context = aVar.cgL.yTx.getContext();
                        com.tencent.mm.sdk.b.a.xxA.m(edVar);
                        AppMethodBeat.o(31226);
                        return;
                    }
                    ab.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                    AppMethodBeat.o(31226);
                    return;
                }
                break;
        }
        AppMethodBeat.o(31226);
    }

    public final void dxx() {
        boolean z = false;
        AppMethodBeat.i(31227);
        this.yOa = this.cgL.yTx.getLongExtra("key_biz_chat_id", -1);
        this.mgP = this.cgL.yTx.getBooleanExtra("key_is_biz_chat", false).booleanValue();
        if (this.mgP) {
            this.yDI = z.aeT().aK(this.yOa);
            this.yDI = e.a(this.yDI, this.yOa);
            this.yOd = z.aeU().fv(dDz()).field_unReadCount;
        }
        if (this.mgP && e.rs(this.yDI.field_bizChatServId)) {
            z = true;
        }
        this.yNZ = z;
        if (this.mgP && !this.yNZ) {
            this.pmx = z.aeV().cH(this.yDI.field_bizChatServId);
            this.pmx = e.a(this.pmx, this.yDI.field_bizChatServId);
        }
        if (this.yNZ) {
            this.yOh = e.c(this.yDI);
        }
        this.pkW = f.qX(this.cgL.getTalkerUserName());
        this.yOe = true;
        AppMethodBeat.o(31227);
    }

    public final void dxz() {
        AppMethodBeat.i(31229);
        if (com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && !f.kq(this.cgL.getTalkerUserName())) {
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
            z.afc().a(this.cgL.getTalkerUserName(), this.yNY, intExtra, this.fwz);
        }
        AppMethodBeat.o(31229);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dxA() {
        boolean z;
        AppMethodBeat.i(31230);
        this.yOf = true;
        bh.A("bizflag", ((v) this.cgL.aF(v.class)).dEL());
        if (this.pkW == null || com.tencent.mm.app.plugin.a.a.a(this.pkW)) {
            ab.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", dDw());
            if (this.yNW != null) {
                this.yNW.a(1, this.pkW);
            }
        } else {
            this.cgL.yTx.setMMSubTitle(null);
        }
        com.tencent.mm.aj.d dVar = this.pkW;
        if (!(dVar == null || dVar == null)) {
            com.tencent.mm.aj.d.b cJ = dVar.cJ(false);
            if (cJ != null && cJ.adZ()) {
                z = true;
                if (z) {
                    aw.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31203);
                            pm pmVar = new pm();
                            if (c.this.pkW != null) {
                                pmVar.cLH.userName = c.this.pkW.field_username;
                                com.tencent.mm.sdk.b.a.xxA.m(pmVar);
                            }
                            AppMethodBeat.o(31203);
                        }
                    });
                }
                if (!com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && this.pkW != null) {
                    cJ = this.pkW.cJ(false);
                    if (cJ != null && cJ.adL()) {
                        if (this.pkW.field_hadAlert == 0) {
                            String string = this.cgL.yTx.getContext().getResources().getString(R.string.ak7, new Object[]{this.cgL.sRl.Oj()});
                            String string2 = this.cgL.yTx.getContext().getResources().getString(R.string.ak8);
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
                            bi biVar = new bi();
                            biVar.ju(this.cgL.getTalkerUserName());
                            biVar.hO(2);
                            biVar.setType(10002);
                            biVar.eJ(bf.aaa());
                            biVar.setContent(stringBuffer.toString());
                            bf.l(biVar);
                            this.pkW.field_hadAlert = 1;
                            z.aeR().c(this.pkW, new String[0]);
                        } else {
                            z.afc().rj(this.cgL.getTalkerUserName());
                        }
                    }
                    if (this.pkW.adJ() && !(this.cgL.sRl.dsf() && com.tencent.mm.aj.a.adG())) {
                        com.tencent.mm.model.ao.a.flu.ai(this.cgL.sRl.field_username, "");
                        com.tencent.mm.ah.b.pY(this.cgL.sRl.field_username);
                    }
                    if (this.pkW.field_status == 1) {
                        this.pkW.field_status = 0;
                        z.aeR().e(this.pkW);
                    }
                } else if (!(this.cgL.yTx.getBooleanExtra("key_has_add_contact", false).booleanValue() || com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) || !this.cgL.sRl.dsf())) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31204);
                            if (!com.tencent.mm.n.a.jh(c.this.cgL.sRl.field_type) && c.this.cgL.sRl.dsf()) {
                                c.this.cgL.yTx.setMMSubTitle((int) R.string.ak3);
                            }
                            AppMethodBeat.o(31204);
                        }
                    });
                }
                dDA();
                AppMethodBeat.o(31230);
            }
        }
        z = false;
        if (z) {
        }
        if (!com.tencent.mm.n.a.jh(this.cgL.sRl.field_type)) {
        }
        al.d(/* anonymous class already generated */);
        dDA();
        AppMethodBeat.o(31230);
    }

    public final void dxB() {
        AppMethodBeat.i(31231);
        this.yOf = false;
        if (com.tencent.mm.n.a.jh(this.cgL.sRl.field_type) && this.cgL.sRl.dsf() && this.pkW != null) {
            z.afc().aeJ();
            if (this.pmG != null) {
                this.pmG.dismiss();
            }
        }
        AppMethodBeat.o(31231);
    }

    public final void dxC() {
        AppMethodBeat.i(31232);
        this.yOe = false;
        djt();
        AppMethodBeat.o(31232);
    }

    public final void dDh() {
        AppMethodBeat.i(31233);
        super.dDh();
        djt();
        AppMethodBeat.o(31233);
    }

    public final void dxy() {
        AppMethodBeat.i(31228);
        this.yNX = System.currentTimeMillis();
        com.tencent.mm.ui.chatting.c.b.h hVar = (com.tencent.mm.ui.chatting.c.b.h) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class);
        this.yNY = hVar.getCount() > 0 ? hVar.Ou(hVar.getCount() - 1) : null;
        s.aom(this.cgL.getTalkerUserName());
        this.cgL.yTx.getLongExtra("key_biz_chat_id", -1);
        if (this.mgP) {
            ab.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
            aw.RS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31198);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!c.this.mgP || c.this.yDI == null || c.this.cgL.sRl == null) {
                        ab.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", c.this.yDI, c.this.cgL.sRl);
                    } else {
                        c.f(c.this);
                        z.afe();
                        com.tencent.mm.aj.a.c cVar = c.this.yDI;
                        if (com.tencent.mm.kernel.a.jP(g.RN().eIV)) {
                            y.b(cVar.field_brandUserName, 7, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                            ab.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", r3);
                        }
                        if (c.this.yNZ) {
                            if (c.this.yDI.afh()) {
                                z.aeZ();
                                com.tencent.mm.aj.a.h.aH(c.this.yDI.field_bizChatServId, c.this.cgL.sRl.field_username);
                            } else {
                                e.f(c.this.yDI);
                            }
                        }
                        c.g(c.this);
                    }
                    ab.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(31198);
                }
            }, 500);
        }
        if (this.cgL.sRl != null && this.cgL.sRl.dsf()) {
            z.afd().qB(this.cgL.sRl.field_username);
        }
        this.yOa = this.cgL.yTx.getLongExtra("key_biz_chat_id", -1);
        if (com.tencent.mm.app.plugin.a.a.a(this.pkW) && this.yNW == null) {
            ab.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", dDw());
            this.yNW = new com.tencent.mm.app.plugin.a.a(this.cgL);
        }
        if (this.cgL.sRl.dsf()) {
            com.tencent.mm.bf.d.chatType = 2;
        }
        if (this.mgP) {
            z.aeT().a(this.yEn, Looper.getMainLooper());
        }
        if (this.cgL.sRl != null && this.cgL.sRl.dsf()) {
            z.aeR().a(this.yOg, Looper.getMainLooper());
        }
        AppMethodBeat.o(31228);
    }

    static /* synthetic */ void g(c cVar) {
        boolean z = true;
        AppMethodBeat.i(31236);
        if (!cVar.mgP || cVar.yDI == null || bo.isNullOrNil(cVar.yDI.field_brandUserName)) {
            AppMethodBeat.o(31236);
            return;
        }
        String cI = z.aeV().cI(cVar.yDI.field_brandUserName);
        j cH = z.aeV().cH(cI);
        String str = "MicroMsg.ChattingUI.BizComponent";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = cVar.yDI.field_brandUserName;
        objArr[1] = cI;
        if (cH != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (bo.isNullOrNil(cI) || cH == null || cH.afh() || bo.isNullOrNil(cH.field_addMemberUrl)) {
            z.aeZ();
            com.tencent.mm.aj.a.h.a(cVar.yDI.field_brandUserName, (n) cVar);
        }
        AppMethodBeat.o(31236);
    }
}

package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d.a;
import com.tencent.mm.aj.a.d.a.b;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.u;
import com.tencent.mm.aj.a.x;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BizChatroomInfoUI extends MMPreference implements f, n {
    private static boolean eiu = false;
    private ProgressDialog ehJ = null;
    private com.tencent.mm.ui.base.preference.f ehK;
    private ContactListExpandPreference ehS;
    private CheckBoxPreference ehT;
    private CheckBoxPreference ehU;
    private CheckBoxPreference ehV;
    private SharedPreferences ehZ = null;
    private boolean eic = false;
    private int eie;
    private boolean eif;
    private d ein = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(30196);
            o.ahp().cm(i);
            AppMethodBeat.o(30196);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean eio = false;
    private SignaturePreference ekx;
    private int fromScene;
    private boolean isDeleteCancel = false;
    private long jMj;
    private String jMp;
    private j pmx = null;
    private boolean sjy;
    private c yDI = null;
    private a yEn = new a() {
        public final void a(b bVar) {
            AppMethodBeat.i(30199);
            if (!(bVar == null || bVar.fxB == null || bVar.fxq != BizChatroomInfoUI.this.jMj || bVar.fxA == a.a.DELETE)) {
                ab.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
                BizChatroomInfoUI.this.yDI = z.aeT().aK(BizChatroomInfoUI.this.jMj);
                BizChatroomInfoUI.h(BizChatroomInfoUI.this);
            }
            AppMethodBeat.o(30199);
        }
    };
    private String yFk;
    private boolean yFl = false;
    private boolean yFm;
    private int yFn;
    private j yFo = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizChatroomInfoUI() {
        AppMethodBeat.i(30211);
        AppMethodBeat.o(30211);
    }

    static /* synthetic */ void h(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.i(30241);
        bizChatroomInfoUI.onDataChanged();
        AppMethodBeat.o(30241);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30212);
        super.onCreate(bundle);
        z.aeT().a(this.yEn, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.jMp = getIntent().getStringExtra("Chat_User");
        this.jMj = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yDI = z.aeT().aK(this.jMj);
        this.yFk = this.yDI.field_chatName;
        this.yFl = e.rs(this.yDI.field_bizChatServId);
        if (!this.yFl) {
            this.pmx = z.aeV().cH(this.yDI.field_bizChatServId);
        }
        this.yFo = z.aeV().rD(this.jMp);
        initView();
        if (this.yDI == null || this.yDI.field_bizChatServId == null || this.jMp == null) {
            AppMethodBeat.o(30212);
        } else if (this.yDI.isGroup()) {
            z.aeZ();
            h.aH(this.yDI.field_bizChatServId, this.jMp);
            AppMethodBeat.o(30212);
        } else {
            z.aeZ();
            h.a(this.yDI.field_bizChatServId, this.jMp, (n) this);
            AppMethodBeat.o(30212);
        }
    }

    public void onResume() {
        AppMethodBeat.i(30213);
        JN();
        updateTitle();
        JL();
        caY();
        dAY();
        JJ();
        this.ehK.notifyDataSetChanged();
        super.onResume();
        if (!this.eio) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bo.isNullOrNil(stringExtra)) {
                final int aqQ = this.ehK.aqQ(stringExtra);
                setSelection(aqQ - 3);
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(30200);
                        View a = ((com.tencent.mm.ui.base.preference.a) BizChatroomInfoUI.this.ehK).a(aqQ, BizChatroomInfoUI.this.nDp);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.a(BizChatroomInfoUI.this.mController.ylL, a);
                        }
                        AppMethodBeat.o(30200);
                    }
                }, 10);
            }
            this.eio = true;
        }
        AppMethodBeat.o(30213);
    }

    public void onPause() {
        AppMethodBeat.i(30214);
        super.onPause();
        AppMethodBeat.o(30214);
    }

    public void onDestroy() {
        AppMethodBeat.i(30215);
        com.tencent.mm.ui.g.a.dismiss();
        com.tencent.mm.ui.g.a.dismiss();
        z.aeT().a(this.yEn);
        super.onDestroy();
        AppMethodBeat.o(30215);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(30216);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(30216);
            return;
        }
        switch (i) {
            case 1:
                boolean aqX;
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    ab.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                    String string = bundleExtra.getString("enterprise_members");
                    ab.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", string);
                    if (this.yFl) {
                        aqX = aqX(string);
                    } else {
                        acr acr = new acr();
                        c cVar = new c();
                        cVar.field_addMemberUrl = this.yFo != null ? this.yFo.field_addMemberUrl : null;
                        cVar.field_brandUserName = this.jMp;
                        if (e.a(cVar, string, this.pmx.field_userId, acr)) {
                            z.aeZ();
                            final com.tencent.mm.aj.a.n a = h.a(this.jMp, acr, (n) this);
                            getString(R.string.tz);
                            this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.db), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(30201);
                                    aw.Rg().c(a);
                                    AppMethodBeat.o(30201);
                                }
                            });
                            aqX = true;
                        } else {
                            aqX = false;
                        }
                    }
                } else {
                    aqX = false;
                }
                if (aqX) {
                    AppMethodBeat.o(30216);
                    return;
                }
                Toast.makeText(this, getString(R.string.drn), 0).show();
                AppMethodBeat.o(30216);
                return;
            default:
                AppMethodBeat.o(30216);
                return;
        }
    }

    private boolean aqX(String str) {
        AppMethodBeat.i(30217);
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                kg kgVar = new kg();
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("id");
                    j cH = z.aeV().cH(string);
                    if (cH == null) {
                        cH = new j();
                        cH.field_userId = string;
                        jVar = cH;
                    } else {
                        jVar = cH;
                    }
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_brandUserName = this.jMp;
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    jVar.field_addMemberUrl = this.yFo != null ? this.yFo.field_addMemberUrl : null;
                    if (!z.aeV().b(jVar)) {
                        z.aeV().a(jVar);
                    }
                    kf kfVar = new kf();
                    kfVar.vNc = jVar.field_userId;
                    kgVar.vNd.add(kfVar);
                }
                a(kgVar, null);
                AppMethodBeat.o(30217);
                return true;
            } catch (JSONException e) {
                ab.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.BizChatroomInfoUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(30217);
        return false;
    }

    private void a(kg kgVar, kg kgVar2) {
        AppMethodBeat.i(30218);
        ab.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = kgVar == null ? getString(R.string.drx) : getString(R.string.db);
        z.aeZ();
        final x a = h.a(this.yDI.field_brandUserName, this.yDI.field_bizChatServId, kgVar, kgVar2, this);
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, string, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(30202);
                aw.Rg().c(a);
                AppMethodBeat.o(30202);
            }
        });
        AppMethodBeat.o(30218);
    }

    public final int JC() {
        return R.xml.o;
    }

    private void Kb() {
        AppMethodBeat.i(30220);
        dAX();
        dAY();
        caY();
        JL();
        AppMethodBeat.o(30220);
    }

    private void dAX() {
        AppMethodBeat.i(30221);
        ab.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        this.ehS.a(this.ehK, this.ehS.mKey);
        this.ekx = (SignaturePreference) this.ehK.aqO("room_name");
        this.ehT = (CheckBoxPreference) this.ehK.aqO("room_notify_new_msg");
        this.ehV = (CheckBoxPreference) this.ehK.aqO("room_placed_to_the_top");
        this.ehU = (CheckBoxPreference) this.ehK.aqO("room_save_to_contact");
        this.ehS.oB(this.yFl);
        this.ehS.oC(this.eic);
        if (this.eic) {
            this.ehS.oD(true).oE(true);
        } else {
            this.ehS.oD(true).oE(false);
        }
        this.ehS.ajF(this.yDI.field_ownerUserId);
        this.ehS.djF();
        this.ehS.djz();
        if (!this.yFl) {
            this.ehK.ce("room_save_to_contact", true);
            this.ehK.ce("room_name", true);
            this.ehK.ce("room_del_quit", true);
        }
        AppMethodBeat.o(30221);
    }

    private void H(boolean z, int i) {
        AppMethodBeat.i(30223);
        this.yFn = this.yDI.field_bitFlag;
        this.yFk = this.yDI.field_chatName;
        if (this.yFl) {
            c cVar;
            if (z) {
                cVar = this.yDI;
                cVar.field_bitFlag |= i;
            } else {
                cVar = this.yDI;
                cVar.field_bitFlag &= i ^ -1;
            }
            ab.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", Integer.valueOf(this.yDI.field_bitFlag));
            z.aeT().b(this.yDI);
        } else {
            j jVar;
            if (z) {
                jVar = this.pmx;
                jVar.field_bitFlag |= i;
            } else {
                jVar = this.pmx;
                jVar.field_bitFlag &= i ^ -1;
            }
            z.aeV().b(this.pmx);
            this.yDI.field_bitFlag = this.pmx.field_bitFlag;
            z.aeT().b(this.yDI);
        }
        kd kdVar = new kd();
        kdVar.vMV = this.yDI.field_bizChatServId;
        kdVar.vMX = this.yDI.field_bitFlag;
        z.aeZ();
        h.a(this.yDI.field_brandUserName, kdVar, (n) this);
        AppMethodBeat.o(30223);
    }

    public final j Oa(int i) {
        AppMethodBeat.i(30224);
        if (this.ehS.getItem(i) instanceof j) {
            j jVar = (j) this.ehS.getItem(i);
            AppMethodBeat.o(30224);
            return jVar;
        }
        AppMethodBeat.o(30224);
        return null;
    }

    private void JJ() {
        AppMethodBeat.i(30225);
        if (this.ehS != null) {
            List fC;
            if (this.yFl) {
                fC = e.fC(this.jMj);
            } else {
                fC = new LinkedList();
                fC.add(this.yDI.field_bizChatServId);
            }
            if (fC != null) {
                this.eie = fC.size();
            } else {
                this.eie = 0;
            }
            if (this.eie <= 1) {
                this.ehS.oD(true).oE(false);
            } else {
                this.ehS.oD(true).oE(this.eic);
            }
            this.ehS.u(this.jMp, fC);
        }
        AppMethodBeat.o(30225);
    }

    private void dAY() {
        AppMethodBeat.i(30226);
        ab.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yFl) {
            this.sjy = this.yDI.lc(8);
            this.yFn = this.yDI.field_bitFlag;
        } else {
            this.sjy = this.pmx.lc(8);
            this.yFn = this.pmx.field_bitFlag;
        }
        if (this.sjy) {
            if (this.ehU != null) {
                this.ehZ.edit().putBoolean("room_save_to_contact", true).commit();
            }
        } else if (this.ehU != null) {
            this.ehZ.edit().putBoolean("room_save_to_contact", false).commit();
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(30226);
    }

    private void caY() {
        AppMethodBeat.i(30227);
        ab.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yFl) {
            this.yFm = this.yDI.lc(16);
            this.yFn = this.yDI.field_bitFlag;
        } else {
            this.yFm = this.pmx.lc(16);
            this.yFn = this.pmx.field_bitFlag;
        }
        if (this.ehV != null) {
            this.ehZ.edit().putBoolean("room_placed_to_the_top", this.yFm).commit();
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(30227);
    }

    private void JL() {
        AppMethodBeat.i(30228);
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yFl) {
            this.eif = this.yDI.lc(1);
            this.yFn = this.yDI.field_bitFlag;
        } else {
            this.eif = this.pmx.lc(1);
            this.yFn = this.pmx.field_bitFlag;
        }
        if (this.eif) {
            setTitleMuteIconVisibility(0);
            if (this.ehT != null) {
                this.ehZ.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.ehT != null) {
                this.ehZ.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(30228);
    }

    private void JN() {
        AppMethodBeat.i(30229);
        if (this.ekx != null) {
            if (JO()) {
                CharSequence charSequence = this.yDI.field_chatName;
                if (charSequence != null && charSequence.length() > 50) {
                    charSequence = charSequence.substring(0, 32);
                }
                ab.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", charSequence);
                SignaturePreference signaturePreference = this.ekx;
                if (charSequence == null || charSequence.length() <= 0) {
                    charSequence = getString(R.string.eal);
                }
                signaturePreference.setSummary((CharSequence) com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, charSequence));
                AppMethodBeat.o(30229);
                return;
            }
            this.ekx.setSummary((CharSequence) getString(R.string.dsn));
        }
        AppMethodBeat.o(30229);
    }

    private void updateTitle() {
        AppMethodBeat.i(30230);
        if (this.yFl) {
            this.eie = e.fB(this.jMj);
            if (this.eie != 0) {
                setMMTitle(getString(R.string.bwu, new Object[]{getString(R.string.dvi), Integer.valueOf(this.eie)}));
                AppMethodBeat.o(30230);
                return;
            }
        }
        setMMTitle(getString(R.string.dvi));
        AppMethodBeat.o(30230);
    }

    private boolean JO() {
        AppMethodBeat.i(30231);
        if (bo.isNullOrNil(this.yFl ? this.yDI.field_chatName : this.pmx.field_userName)) {
            AppMethodBeat.o(30231);
            return false;
        }
        AppMethodBeat.o(30231);
        return true;
    }

    public final void a(int i, m mVar) {
        AppMethodBeat.i(30232);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar.getType() == 1355) {
            uo afm = ((com.tencent.mm.aj.a.n) mVar).afm();
            un afn = ((com.tencent.mm.aj.a.n) mVar).afn();
            c rq = z.aeT().rq(afm.wcb.wku.vMV);
            Intent intent;
            if (rq == null) {
                Toast.makeText(ah.getContext(), getString(R.string.drn), 0).show();
                AppMethodBeat.o(30232);
                return;
            } else if (this.fromScene == 2) {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                intent.putExtra("Contact_User", afn.vNb);
                intent.putExtra("biz_chat_chat_id", rq.field_bizChatLocalId);
                com.tencent.mm.bp.d.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                AppMethodBeat.o(30232);
                return;
            } else {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", afn.vNb);
                intent.putExtra("key_biz_chat_id", rq.field_bizChatLocalId);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                intent.putExtra("key_is_biz_chat", true);
                intent.setClass(this, ChattingUI.class);
                startActivity(intent);
                AppMethodBeat.o(30232);
                return;
            }
        }
        if (mVar.getType() == 1356) {
            if (i != 0) {
                dAZ();
                AppMethodBeat.o(30232);
                return;
            }
        } else if (mVar.getType() == 1353 && i >= 0 && this.pmx != null) {
            this.pmx = z.aeV().cH(this.pmx.field_userId);
            onDataChanged();
        }
        AppMethodBeat.o(30232);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(30233);
        if (mVar == null) {
            ab.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.o(30233);
            return;
        }
        ab.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
        this.eie = e.fB(this.jMj);
        ab.d("MicroMsg.BizChatroomInfoUI", "now is " + this.eie);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
        if (jY != null) {
            jY.a(this, null, null);
            AppMethodBeat.o(30233);
        } else if (i == 0 && i2 == 0) {
            mVar.getType();
            AppMethodBeat.o(30233);
        } else {
            ab.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            dAZ();
            AppMethodBeat.o(30233);
        }
    }

    private void onDataChanged() {
        AppMethodBeat.i(30234);
        if (this.ehS != null) {
            JN();
            updateTitle();
            JL();
            JJ();
            dAY();
            caY();
            this.ehS.notifyChanged();
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(30234);
    }

    private void dAZ() {
        AppMethodBeat.i(30235);
        ab.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.yDI.field_chatName = this.yFk;
        this.yDI.field_bitFlag = this.yFn;
        this.eif = this.yDI.lc(1);
        this.sjy = this.yDI.lc(8);
        this.yFm = this.yDI.lc(16);
        z.aeT().b(this.yDI);
        if (this.yFm) {
            z.aeU().fz(this.yDI.field_bizChatLocalId);
        } else if (!this.yFm) {
            z.aeU().fA(this.yDI.field_bizChatLocalId);
        }
        this.ehZ.edit().putBoolean("room_placed_to_the_top", z.aeU().fy(this.yDI.field_bizChatLocalId)).commit();
        JN();
        JL();
        caY();
        dAY();
        Toast.makeText(this, getString(R.string.dro), 0).show();
        AppMethodBeat.o(30235);
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(30236);
        com.tencent.mm.ui.base.preference.a aVar = new com.tencent.mm.ui.base.preference.a(this, this.nDp, sharedPreferences);
        AppMethodBeat.o(30236);
        return aVar;
    }

    public final void initView() {
        AppMethodBeat.i(30219);
        this.ehK = this.yCw;
        String str = this.yDI.field_ownerUserId;
        this.eie = this.yDI.afg().size();
        if (bo.isNullOrNil(str)) {
            this.eic = false;
        } else {
            this.eic = str.equals(z.aeV().cI(this.jMp));
        }
        Kb();
        if (this.ehS != null) {
            this.nDp.setOnScrollListener(this.ein);
            this.ehS.a(this.ein);
            this.ehS.a(new ContactListExpandPreference.a() {
                public final void iA(int i) {
                    AppMethodBeat.i(30203);
                    BizChatroomInfoUI.a(BizChatroomInfoUI.this, i);
                    AppMethodBeat.o(30203);
                }

                public final void iB(int i) {
                    boolean z = true;
                    AppMethodBeat.i(30204);
                    j Oa = BizChatroomInfoUI.this.Oa(i);
                    if (Oa == null || bo.isNullOrNil(Oa.field_profileUrl)) {
                        String str = "MicroMsg.BizChatroomInfoUI";
                        String str2 = "onItemNormalClick userInfo == null:%s";
                        Object[] objArr = new Object[1];
                        if (Oa != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        ab.w(str, str2, objArr);
                        AppMethodBeat.o(30204);
                        return;
                    }
                    ab.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", Oa.field_profileUrl);
                    z.aeZ();
                    h.a(Oa.field_userId, Oa.field_brandUserName, BizChatroomInfoUI.this);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", Oa.field_profileUrl);
                    intent.putExtra("useJs", true);
                    com.tencent.mm.bp.d.b(BizChatroomInfoUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(30204);
                }

                public final void JT() {
                    AppMethodBeat.i(30205);
                    if (BizChatroomInfoUI.this.ehS != null) {
                        BizChatroomInfoUI.this.ehS.djD();
                    }
                    AppMethodBeat.o(30205);
                }

                public final void iC(int i) {
                    AppMethodBeat.i(30206);
                    BizChatroomInfoUI.c(BizChatroomInfoUI.this);
                    AppMethodBeat.o(30206);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30207);
                BizChatroomInfoUI.this.finish();
                AppMethodBeat.o(30207);
                return true;
            }
        });
        AppMethodBeat.o(30219);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        boolean z = true;
        AppMethodBeat.i(30222);
        String str = preference.mKey;
        if (str.equals("room_name")) {
            String str2 = "";
            if (JO()) {
                str2 = this.yDI.field_chatName;
            }
            com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(R.string.dti), str2, "", 32, new com.tencent.mm.ui.base.h.b() {
                public final boolean s(CharSequence charSequence) {
                    AppMethodBeat.i(30208);
                    boolean a = BizChatroomInfoUI.a(BizChatroomInfoUI.this, str2, charSequence);
                    AppMethodBeat.o(30208);
                    return a;
                }
            });
        } else if (str.equals("room_notify_new_msg")) {
            boolean z2;
            if (this.eif) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.eif = z2;
            H(this.eif, 1);
            JL();
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.yFm) {
                z = false;
            }
            this.yFm = z;
            H(this.yFm, 16);
            if (this.yFm) {
                z.aeU().fz(this.yDI.field_bizChatLocalId);
            } else {
                z.aeU().fA(this.yDI.field_bizChatLocalId);
            }
        } else if (str.equals("room_del_quit")) {
            ab.d("MicroMsg.BizChatroomInfoUI", " quit " + this.jMj);
            com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(R.string.b4z), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(30209);
                    BizChatroomInfoUI.d(BizChatroomInfoUI.this);
                    AppMethodBeat.o(30209);
                }
            }, null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.sjy) {
                z = false;
            }
            this.sjy = z;
            H(this.sjy, 8);
            dAY();
        }
        AppMethodBeat.o(30222);
        return false;
    }

    static /* synthetic */ void c(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.i(30238);
        Intent intent = new Intent();
        if (bizChatroomInfoUI.yFl) {
            if (bo.isNullOrNil(bizChatroomInfoUI.yDI.field_addMemberUrl)) {
                ab.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.string.a_o), 0).show();
                AppMethodBeat.o(30238);
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.yDI.field_addMemberUrl);
        } else if (bizChatroomInfoUI.pmx == null || bo.isNullOrNil(bizChatroomInfoUI.pmx.field_addMemberUrl)) {
            ab.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.string.a_o), 0).show();
            AppMethodBeat.o(30238);
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.pmx.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        com.tencent.mm.bp.d.b(bizChatroomInfoUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.o(30238);
    }

    static /* synthetic */ boolean a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String str2;
        AppMethodBeat.i(30239);
        if (charSequence == null) {
            str2 = "";
        } else {
            str2 = charSequence.toString().trim();
        }
        if (str2.equals(str)) {
            ab.d("MicroMsg.BizChatroomInfoUI", "same room name return");
            AppMethodBeat.o(30239);
            return true;
        } else if (str2.length() == 0) {
            com.tencent.mm.ui.base.h.bQ(bizChatroomInfoUI.mController.ylL, bizChatroomInfoUI.getString(R.string.drr));
            AppMethodBeat.o(30239);
            return false;
        } else {
            com.tencent.mm.sdk.b.a.xxA.m(new tv());
            bizChatroomInfoUI.yFk = bizChatroomInfoUI.yDI.field_chatName;
            bizChatroomInfoUI.yFn = bizChatroomInfoUI.yDI.field_bitFlag;
            bizChatroomInfoUI.yDI.field_chatName = str2;
            z.aeT().b(bizChatroomInfoUI.yDI);
            kd kdVar = new kd();
            kdVar.vMV = bizChatroomInfoUI.yDI.field_bizChatServId;
            kdVar.name = str2;
            kdVar.vMX = bizChatroomInfoUI.yFn;
            z.aeZ();
            h.a(bizChatroomInfoUI.yDI.field_brandUserName, kdVar, (n) bizChatroomInfoUI);
            bizChatroomInfoUI.JN();
            bizChatroomInfoUI.ehK.notifyDataSetChanged();
            AppMethodBeat.o(30239);
            return true;
        }
    }

    static /* synthetic */ void d(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.i(30240);
        ab.i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        z.aeZ();
        g.RO().eJo.a(new u(bizChatroomInfoUI.jMp, bizChatroomInfoUI.yDI.field_bizChatServId), 0);
        bizChatroomInfoUI.isDeleteCancel = false;
        bizChatroomInfoUI.getString(R.string.tz);
        final p b = com.tencent.mm.ui.base.h.b((Context) bizChatroomInfoUI, bizChatroomInfoUI.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(30210);
                BizChatroomInfoUI.this.isDeleteCancel = true;
                AppMethodBeat.o(30210);
            }
        });
        i.a(bizChatroomInfoUI.jMp, bizChatroomInfoUI.jMj, new bf.a() {
            public final boolean JU() {
                AppMethodBeat.i(30197);
                boolean f = BizChatroomInfoUI.this.isDeleteCancel;
                AppMethodBeat.o(30197);
                return f;
            }

            public final void JV() {
                AppMethodBeat.i(30198);
                if (b != null) {
                    z.aeU().fw(BizChatroomInfoUI.this.jMj);
                    z.aeT().fw(BizChatroomInfoUI.this.jMj);
                    b.dismiss();
                }
                AppMethodBeat.o(30198);
            }
        });
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.jMp);
        com.tencent.mm.bp.d.b(bizChatroomInfoUI.mController.ylL, "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
        AppMethodBeat.o(30240);
    }
}

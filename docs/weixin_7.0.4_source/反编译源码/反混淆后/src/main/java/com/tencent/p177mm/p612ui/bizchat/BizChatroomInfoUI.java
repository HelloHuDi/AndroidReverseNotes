package com.tencent.p177mm.p612ui.bizchat;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.preference.SignaturePreference;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C26428i;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C25772n;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C17900n;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C25759h;
import com.tencent.p177mm.p184aj.p185a.C25763x;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8923a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8924b;
import com.tencent.p177mm.p184aj.p185a.C41741u;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C26245tv;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.C41341a;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.p1347g.C40871a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C23406kf;
import com.tencent.p177mm.protocal.protobuf.C23407kg;
import com.tencent.p177mm.protocal.protobuf.C30231uo;
import com.tencent.p177mm.protocal.protobuf.C40579un;
import com.tencent.p177mm.protocal.protobuf.C44133kd;
import com.tencent.p177mm.protocal.protobuf.acr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.ui.bizchat.BizChatroomInfoUI */
public class BizChatroomInfoUI extends MMPreference implements C1202f, C25772n {
    private static boolean eiu = false;
    private ProgressDialog ehJ = null;
    private C15541f ehK;
    private ContactListExpandPreference ehS;
    private CheckBoxPreference ehT;
    private CheckBoxPreference ehU;
    private CheckBoxPreference ehV;
    private SharedPreferences ehZ = null;
    private boolean eic = false;
    private int eie;
    private boolean eif;
    private C14943d ein = new C14943d(new C52991());
    boolean eio = false;
    private SignaturePreference ekx;
    private int fromScene;
    private boolean isDeleteCancel = false;
    private long jMj;
    private String jMp;
    private C45143j pmx = null;
    private boolean sjy;
    private C45142c yDI = null;
    private C25753a yEn = new C73243();
    private String yFk;
    private boolean yFl = false;
    private boolean yFm;
    private int yFn;
    private C45143j yFo = null;

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatroomInfoUI$1 */
    class C52991 implements OnScrollListener {
        C52991() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(30196);
            C32291o.ahp().mo43773cm(i);
            AppMethodBeat.m2505o(30196);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatroomInfoUI$3 */
    class C73243 implements C25753a {
        C73243() {
        }

        /* renamed from: a */
        public final void mo15833a(C8924b c8924b) {
            AppMethodBeat.m2504i(30199);
            if (!(c8924b == null || c8924b.fxB == null || c8924b.fxq != BizChatroomInfoUI.this.jMj || c8924b.fxA == C8923a.DELETE)) {
                C4990ab.m7416i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
                BizChatroomInfoUI.this.yDI = C41747z.aeT().mo60349aK(BizChatroomInfoUI.this.jMj);
                BizChatroomInfoUI.m12461h(BizChatroomInfoUI.this);
            }
            AppMethodBeat.m2505o(30199);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatroomInfoUI$10 */
    class C732510 implements OnClickListener {
        C732510() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(30209);
            BizChatroomInfoUI.m12457d(BizChatroomInfoUI.this);
            AppMethodBeat.m2505o(30209);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatroomInfoUI$7 */
    class C73297 implements C30100a {
        C73297() {
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
            AppMethodBeat.m2504i(30203);
            BizChatroomInfoUI.m12453a(BizChatroomInfoUI.this, i);
            AppMethodBeat.m2505o(30203);
        }

        /* renamed from: iB */
        public final void mo14655iB(int i) {
            boolean z = true;
            AppMethodBeat.m2504i(30204);
            C45143j Oa = BizChatroomInfoUI.this.mo15831Oa(i);
            if (Oa == null || C5046bo.isNullOrNil(Oa.field_profileUrl)) {
                String str = "MicroMsg.BizChatroomInfoUI";
                String str2 = "onItemNormalClick userInfo == null:%s";
                Object[] objArr = new Object[1];
                if (Oa != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7421w(str, str2, objArr);
                AppMethodBeat.m2505o(30204);
                return;
            }
            C4990ab.m7417i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", Oa.field_profileUrl);
            C41747z.aeZ();
            C25759h.m40921a(Oa.field_userId, Oa.field_brandUserName, BizChatroomInfoUI.this);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Oa.field_profileUrl);
            intent.putExtra("useJs", true);
            C25985d.m41467b(BizChatroomInfoUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(30204);
        }

        /* renamed from: JT */
        public final void mo14653JT() {
            AppMethodBeat.m2504i(30205);
            if (BizChatroomInfoUI.this.ehS != null) {
                BizChatroomInfoUI.this.ehS.djD();
            }
            AppMethodBeat.m2505o(30205);
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
            AppMethodBeat.m2504i(30206);
            BizChatroomInfoUI.m12456c(BizChatroomInfoUI.this);
            AppMethodBeat.m2505o(30206);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatroomInfoUI$8 */
    class C73308 implements OnMenuItemClickListener {
        C73308() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30207);
            BizChatroomInfoUI.this.finish();
            AppMethodBeat.m2505o(30207);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatroomInfoUI$11 */
    class C733111 implements OnCancelListener {
        C733111() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(30210);
            BizChatroomInfoUI.this.isDeleteCancel = true;
            AppMethodBeat.m2505o(30210);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BizChatroomInfoUI() {
        AppMethodBeat.m2504i(30211);
        AppMethodBeat.m2505o(30211);
    }

    /* renamed from: h */
    static /* synthetic */ void m12461h(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.m2504i(30241);
        bizChatroomInfoUI.onDataChanged();
        AppMethodBeat.m2505o(30241);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30212);
        super.onCreate(bundle);
        C41747z.aeT().mo60347a(this.yEn, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.jMp = getIntent().getStringExtra("Chat_User");
        this.jMj = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yDI = C41747z.aeT().mo60349aK(this.jMj);
        this.yFk = this.yDI.field_chatName;
        this.yFl = C25754e.m40905rs(this.yDI.field_bizChatServId);
        if (!this.yFl) {
            this.pmx = C41747z.aeV().mo60356cH(this.yDI.field_bizChatServId);
        }
        this.yFo = C41747z.aeV().mo60359rD(this.jMp);
        initView();
        if (this.yDI == null || this.yDI.field_bizChatServId == null || this.jMp == null) {
            AppMethodBeat.m2505o(30212);
        } else if (this.yDI.isGroup()) {
            C41747z.aeZ();
            C25759h.m40925aH(this.yDI.field_bizChatServId, this.jMp);
            AppMethodBeat.m2505o(30212);
        } else {
            C41747z.aeZ();
            C25759h.m40921a(this.yDI.field_bizChatServId, this.jMp, (C25772n) this);
            AppMethodBeat.m2505o(30212);
        }
    }

    public void onResume() {
        AppMethodBeat.m2504i(30213);
        m12447JN();
        updateTitle();
        m12446JL();
        caY();
        dAY();
        m12445JJ();
        this.ehK.notifyDataSetChanged();
        super.onResume();
        if (!this.eio) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!C5046bo.isNullOrNil(stringExtra)) {
                final int aqQ = this.ehK.aqQ(stringExtra);
                setSelection(aqQ - 3);
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(30200);
                        View a = ((C41341a) BizChatroomInfoUI.this.ehK).mo65995a(aqQ, BizChatroomInfoUI.this.nDp);
                        if (a != null) {
                            C40871a.m70821a(BizChatroomInfoUI.this.mController.ylL, a);
                        }
                        AppMethodBeat.m2505o(30200);
                    }
                }, 10);
            }
            this.eio = true;
        }
        AppMethodBeat.m2505o(30213);
    }

    public void onPause() {
        AppMethodBeat.m2504i(30214);
        super.onPause();
        AppMethodBeat.m2505o(30214);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30215);
        C40871a.dismiss();
        C40871a.dismiss();
        C41747z.aeT().mo60346a(this.yEn);
        super.onDestroy();
        AppMethodBeat.m2505o(30215);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(30216);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(30216);
            return;
        }
        switch (i) {
            case 1:
                boolean aqX;
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    C4990ab.m7416i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                    String string = bundleExtra.getString("enterprise_members");
                    C4990ab.m7417i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", string);
                    if (this.yFl) {
                        aqX = aqX(string);
                    } else {
                        acr acr = new acr();
                        C45142c c45142c = new C45142c();
                        c45142c.field_addMemberUrl = this.yFo != null ? this.yFo.field_addMemberUrl : null;
                        c45142c.field_brandUserName = this.jMp;
                        if (C25754e.m40892a(c45142c, string, this.pmx.field_userId, acr)) {
                            C41747z.aeZ();
                            final C17900n a = C25759h.m40917a(this.jMp, acr, (C25772n) this);
                            getString(C25738R.string.f9238tz);
                            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f8728db), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(30201);
                                    C9638aw.m17182Rg().mo14547c(a);
                                    AppMethodBeat.m2505o(30201);
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
                    AppMethodBeat.m2505o(30216);
                    return;
                }
                Toast.makeText(this, getString(C25738R.string.drn), 0).show();
                AppMethodBeat.m2505o(30216);
                return;
            default:
                AppMethodBeat.m2505o(30216);
                return;
        }
    }

    private boolean aqX(String str) {
        AppMethodBeat.m2504i(30217);
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                C23407kg c23407kg = new C23407kg();
                for (int i = 0; i < jSONArray.length(); i++) {
                    C45143j c45143j;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("id");
                    C45143j cH = C41747z.aeV().mo60356cH(string);
                    if (cH == null) {
                        cH = new C45143j();
                        cH.field_userId = string;
                        c45143j = cH;
                    } else {
                        c45143j = cH;
                    }
                    c45143j.field_userName = jSONObject.getString("nick_name");
                    c45143j.field_brandUserName = this.jMp;
                    c45143j.field_headImageUrl = jSONObject.getString("head_img_url");
                    c45143j.field_profileUrl = jSONObject.getString("profile_url");
                    c45143j.field_UserVersion = jSONObject.getInt("ver");
                    c45143j.field_addMemberUrl = this.yFo != null ? this.yFo.field_addMemberUrl : null;
                    if (!C41747z.aeV().mo60354b(c45143j)) {
                        C41747z.aeV().mo60353a(c45143j);
                    }
                    C23406kf c23406kf = new C23406kf();
                    c23406kf.vNc = c45143j.field_userId;
                    c23407kg.vNd.add(c23406kf);
                }
                m12452a(c23407kg, null);
                AppMethodBeat.m2505o(30217);
                return true;
            } catch (JSONException e) {
                C4990ab.m7417i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.BizChatroomInfoUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(30217);
        return false;
    }

    /* renamed from: a */
    private void m12452a(C23407kg c23407kg, C23407kg c23407kg2) {
        AppMethodBeat.m2504i(30218);
        C4990ab.m7416i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = c23407kg == null ? getString(C25738R.string.drx) : getString(C25738R.string.f8728db);
        C41747z.aeZ();
        final C25763x a = C25759h.m40919a(this.yDI.field_brandUserName, this.yDI.field_bizChatServId, c23407kg, c23407kg2, this);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, string, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(30202);
                C9638aw.m17182Rg().mo14547c(a);
                AppMethodBeat.m2505o(30202);
            }
        });
        AppMethodBeat.m2505o(30218);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8474o;
    }

    /* renamed from: Kb */
    private void m12449Kb() {
        AppMethodBeat.m2504i(30220);
        dAX();
        dAY();
        caY();
        m12446JL();
        AppMethodBeat.m2505o(30220);
    }

    private void dAX() {
        AppMethodBeat.m2504i(30221);
        C4990ab.m7410d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        this.ehS.mo48357a(this.ehK, this.ehS.mKey);
        this.ekx = (SignaturePreference) this.ehK.aqO("room_name");
        this.ehT = (CheckBoxPreference) this.ehK.aqO("room_notify_new_msg");
        this.ehV = (CheckBoxPreference) this.ehK.aqO("room_placed_to_the_top");
        this.ehU = (CheckBoxPreference) this.ehK.aqO("room_save_to_contact");
        this.ehS.mo48366oB(this.yFl);
        this.ehS.mo48367oC(this.eic);
        if (this.eic) {
            this.ehS.mo48368oD(true).mo48369oE(true);
        } else {
            this.ehS.mo48368oD(true).mo48369oE(false);
        }
        this.ehS.ajF(this.yDI.field_ownerUserId);
        this.ehS.djF();
        this.ehS.djz();
        if (!this.yFl) {
            this.ehK.mo27715ce("room_save_to_contact", true);
            this.ehK.mo27715ce("room_name", true);
            this.ehK.mo27715ce("room_del_quit", true);
        }
        AppMethodBeat.m2505o(30221);
    }

    /* renamed from: H */
    private void m12444H(boolean z, int i) {
        AppMethodBeat.m2504i(30223);
        this.yFn = this.yDI.field_bitFlag;
        this.yFk = this.yDI.field_chatName;
        if (this.yFl) {
            C45142c c45142c;
            if (z) {
                c45142c = this.yDI;
                c45142c.field_bitFlag |= i;
            } else {
                c45142c = this.yDI;
                c45142c.field_bitFlag &= i ^ -1;
            }
            C4990ab.m7417i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", Integer.valueOf(this.yDI.field_bitFlag));
            C41747z.aeT().mo60350b(this.yDI);
        } else {
            C45143j c45143j;
            if (z) {
                c45143j = this.pmx;
                c45143j.field_bitFlag |= i;
            } else {
                c45143j = this.pmx;
                c45143j.field_bitFlag &= i ^ -1;
            }
            C41747z.aeV().mo60354b(this.pmx);
            this.yDI.field_bitFlag = this.pmx.field_bitFlag;
            C41747z.aeT().mo60350b(this.yDI);
        }
        C44133kd c44133kd = new C44133kd();
        c44133kd.vMV = this.yDI.field_bizChatServId;
        c44133kd.vMX = this.yDI.field_bitFlag;
        C41747z.aeZ();
        C25759h.m40918a(this.yDI.field_brandUserName, c44133kd, (C25772n) this);
        AppMethodBeat.m2505o(30223);
    }

    /* renamed from: Oa */
    public final C45143j mo15831Oa(int i) {
        AppMethodBeat.m2504i(30224);
        if (this.ehS.getItem(i) instanceof C45143j) {
            C45143j c45143j = (C45143j) this.ehS.getItem(i);
            AppMethodBeat.m2505o(30224);
            return c45143j;
        }
        AppMethodBeat.m2505o(30224);
        return null;
    }

    /* renamed from: JJ */
    private void m12445JJ() {
        AppMethodBeat.m2504i(30225);
        if (this.ehS != null) {
            List fC;
            if (this.yFl) {
                fC = C25754e.m40899fC(this.jMj);
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
                this.ehS.mo48368oD(true).mo48369oE(false);
            } else {
                this.ehS.mo48368oD(true).mo48369oE(this.eic);
            }
            this.ehS.mo48371u(this.jMp, fC);
        }
        AppMethodBeat.m2505o(30225);
    }

    private void dAY() {
        AppMethodBeat.m2504i(30226);
        C4990ab.m7410d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yFl) {
            this.sjy = this.yDI.mo73052lc(8);
            this.yFn = this.yDI.field_bitFlag;
        } else {
            this.sjy = this.pmx.mo73056lc(8);
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
        AppMethodBeat.m2505o(30226);
    }

    private void caY() {
        AppMethodBeat.m2504i(30227);
        C4990ab.m7410d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yFl) {
            this.yFm = this.yDI.mo73052lc(16);
            this.yFn = this.yDI.field_bitFlag;
        } else {
            this.yFm = this.pmx.mo73056lc(16);
            this.yFn = this.pmx.field_bitFlag;
        }
        if (this.ehV != null) {
            this.ehZ.edit().putBoolean("room_placed_to_the_top", this.yFm).commit();
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(30227);
    }

    /* renamed from: JL */
    private void m12446JL() {
        AppMethodBeat.m2504i(30228);
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yFl) {
            this.eif = this.yDI.mo73052lc(1);
            this.yFn = this.yDI.field_bitFlag;
        } else {
            this.eif = this.pmx.mo73056lc(1);
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
        AppMethodBeat.m2505o(30228);
    }

    /* renamed from: JN */
    private void m12447JN() {
        AppMethodBeat.m2504i(30229);
        if (this.ekx != null) {
            if (m12448JO()) {
                CharSequence charSequence = this.yDI.field_chatName;
                if (charSequence != null && charSequence.length() > 50) {
                    charSequence = charSequence.substring(0, 32);
                }
                C4990ab.m7417i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", charSequence);
                SignaturePreference signaturePreference = this.ekx;
                if (charSequence == null || charSequence.length() <= 0) {
                    charSequence = getString(C25738R.string.eal);
                }
                signaturePreference.setSummary((CharSequence) C44089j.m79292b((Context) this, charSequence));
                AppMethodBeat.m2505o(30229);
                return;
            }
            this.ekx.setSummary((CharSequence) getString(C25738R.string.dsn));
        }
        AppMethodBeat.m2505o(30229);
    }

    private void updateTitle() {
        AppMethodBeat.m2504i(30230);
        if (this.yFl) {
            this.eie = C25754e.m40898fB(this.jMj);
            if (this.eie != 0) {
                setMMTitle(getString(C25738R.string.bwu, new Object[]{getString(C25738R.string.dvi), Integer.valueOf(this.eie)}));
                AppMethodBeat.m2505o(30230);
                return;
            }
        }
        setMMTitle(getString(C25738R.string.dvi));
        AppMethodBeat.m2505o(30230);
    }

    /* renamed from: JO */
    private boolean m12448JO() {
        AppMethodBeat.m2504i(30231);
        if (C5046bo.isNullOrNil(this.yFl ? this.yDI.field_chatName : this.pmx.field_userName)) {
            AppMethodBeat.m2505o(30231);
            return false;
        }
        AppMethodBeat.m2505o(30231);
        return true;
    }

    /* renamed from: a */
    public final void mo15832a(int i, C1207m c1207m) {
        AppMethodBeat.m2504i(30232);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m.getType() == 1355) {
            C30231uo afm = ((C17900n) c1207m).afm();
            C40579un afn = ((C17900n) c1207m).afn();
            C45142c rq = C41747z.aeT().mo60352rq(afm.wcb.wku.vMV);
            Intent intent;
            if (rq == null) {
                Toast.makeText(C4996ah.getContext(), getString(C25738R.string.drn), 0).show();
                AppMethodBeat.m2505o(30232);
                return;
            } else if (this.fromScene == 2) {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                intent.putExtra("Contact_User", afn.vNb);
                intent.putExtra("biz_chat_chat_id", rq.field_bizChatLocalId);
                C25985d.m41473f(this, ".ui.bizchat.BizChatConversationUI", intent);
                AppMethodBeat.m2505o(30232);
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
                AppMethodBeat.m2505o(30232);
                return;
            }
        }
        if (c1207m.getType() == 1356) {
            if (i != 0) {
                dAZ();
                AppMethodBeat.m2505o(30232);
                return;
            }
        } else if (c1207m.getType() == 1353 && i >= 0 && this.pmx != null) {
            this.pmx = C41747z.aeV().mo60356cH(this.pmx.field_userId);
            onDataChanged();
        }
        AppMethodBeat.m2505o(30232);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(30233);
        if (c1207m == null) {
            C4990ab.m7413e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(30233);
            return;
        }
        C4990ab.m7417i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
        this.eie = C25754e.m40898fB(this.jMj);
        C4990ab.m7410d("MicroMsg.BizChatroomInfoUI", "now is " + this.eie);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        C42124a jY = C42124a.m74268jY(str);
        if (jY != null) {
            jY.mo67668a(this, null, null);
            AppMethodBeat.m2505o(30233);
        } else if (i == 0 && i2 == 0) {
            c1207m.getType();
            AppMethodBeat.m2505o(30233);
        } else {
            C4990ab.m7420w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            dAZ();
            AppMethodBeat.m2505o(30233);
        }
    }

    private void onDataChanged() {
        AppMethodBeat.m2504i(30234);
        if (this.ehS != null) {
            m12447JN();
            updateTitle();
            m12446JL();
            m12445JJ();
            dAY();
            caY();
            this.ehS.notifyChanged();
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(30234);
    }

    private void dAZ() {
        AppMethodBeat.m2504i(30235);
        C4990ab.m7416i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.yDI.field_chatName = this.yFk;
        this.yDI.field_bitFlag = this.yFn;
        this.eif = this.yDI.mo73052lc(1);
        this.sjy = this.yDI.mo73052lc(8);
        this.yFm = this.yDI.mo73052lc(16);
        C41747z.aeT().mo60350b(this.yDI);
        if (this.yFm) {
            C41747z.aeU().mo60344fz(this.yDI.field_bizChatLocalId);
        } else if (!this.yFm) {
            C41747z.aeU().mo60338fA(this.yDI.field_bizChatLocalId);
        }
        this.ehZ.edit().putBoolean("room_placed_to_the_top", C41747z.aeU().mo60343fy(this.yDI.field_bizChatLocalId)).commit();
        m12447JN();
        m12446JL();
        caY();
        dAY();
        Toast.makeText(this, getString(C25738R.string.dro), 0).show();
        AppMethodBeat.m2505o(30235);
    }

    /* renamed from: a */
    public final C40675h mo14627a(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(30236);
        C41341a c41341a = new C41341a(this, this.nDp, sharedPreferences);
        AppMethodBeat.m2505o(30236);
        return c41341a;
    }

    public final void initView() {
        AppMethodBeat.m2504i(30219);
        this.ehK = this.yCw;
        String str = this.yDI.field_ownerUserId;
        this.eie = this.yDI.afg().size();
        if (C5046bo.isNullOrNil(str)) {
            this.eic = false;
        } else {
            this.eic = str.equals(C41747z.aeV().mo60357cI(this.jMp));
        }
        m12449Kb();
        if (this.ehS != null) {
            this.nDp.setOnScrollListener(this.ein);
            this.ehS.mo48356a(this.ein);
            this.ehS.mo48354a(new C73297());
        }
        setBackBtn(new C73308());
        AppMethodBeat.m2505o(30219);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = true;
        AppMethodBeat.m2504i(30222);
        String str = preference.mKey;
        if (str.equals("room_name")) {
            String str2 = "";
            if (m12448JO()) {
                str2 = this.yDI.field_chatName;
            }
            C30379h.m48442a(this.mController.ylL, getString(C25738R.string.dti), str2, "", 32, new C30387b() {
                /* renamed from: s */
                public final boolean mo4760s(CharSequence charSequence) {
                    AppMethodBeat.m2504i(30208);
                    boolean a = BizChatroomInfoUI.m12454a(BizChatroomInfoUI.this, str2, charSequence);
                    AppMethodBeat.m2505o(30208);
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
            m12444H(this.eif, 1);
            m12446JL();
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.yFm) {
                z = false;
            }
            this.yFm = z;
            m12444H(this.yFm, 16);
            if (this.yFm) {
                C41747z.aeU().mo60344fz(this.yDI.field_bizChatLocalId);
            } else {
                C41747z.aeU().mo60338fA(this.yDI.field_bizChatLocalId);
            }
        } else if (str.equals("room_del_quit")) {
            C4990ab.m7410d("MicroMsg.BizChatroomInfoUI", " quit " + this.jMj);
            C30379h.m48440a(this.mController.ylL, getString(C25738R.string.b4z), "", new C732510(), null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.sjy) {
                z = false;
            }
            this.sjy = z;
            m12444H(this.sjy, 8);
            dAY();
        }
        AppMethodBeat.m2505o(30222);
        return false;
    }

    /* renamed from: c */
    static /* synthetic */ void m12456c(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.m2504i(30238);
        Intent intent = new Intent();
        if (bizChatroomInfoUI.yFl) {
            if (C5046bo.isNullOrNil(bizChatroomInfoUI.yDI.field_addMemberUrl)) {
                C4990ab.m7420w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(C25738R.string.a_o), 0).show();
                AppMethodBeat.m2505o(30238);
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.yDI.field_addMemberUrl);
        } else if (bizChatroomInfoUI.pmx == null || C5046bo.isNullOrNil(bizChatroomInfoUI.pmx.field_addMemberUrl)) {
            C4990ab.m7420w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(C25738R.string.a_o), 0).show();
            AppMethodBeat.m2505o(30238);
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.pmx.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        C25985d.m41468b(bizChatroomInfoUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.m2505o(30238);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m12454a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String str2;
        AppMethodBeat.m2504i(30239);
        if (charSequence == null) {
            str2 = "";
        } else {
            str2 = charSequence.toString().trim();
        }
        if (str2.equals(str)) {
            C4990ab.m7410d("MicroMsg.BizChatroomInfoUI", "same room name return");
            AppMethodBeat.m2505o(30239);
            return true;
        } else if (str2.length() == 0) {
            C30379h.m48465bQ(bizChatroomInfoUI.mController.ylL, bizChatroomInfoUI.getString(C25738R.string.drr));
            AppMethodBeat.m2505o(30239);
            return false;
        } else {
            C4879a.xxA.mo10055m(new C26245tv());
            bizChatroomInfoUI.yFk = bizChatroomInfoUI.yDI.field_chatName;
            bizChatroomInfoUI.yFn = bizChatroomInfoUI.yDI.field_bitFlag;
            bizChatroomInfoUI.yDI.field_chatName = str2;
            C41747z.aeT().mo60350b(bizChatroomInfoUI.yDI);
            C44133kd c44133kd = new C44133kd();
            c44133kd.vMV = bizChatroomInfoUI.yDI.field_bizChatServId;
            c44133kd.name = str2;
            c44133kd.vMX = bizChatroomInfoUI.yFn;
            C41747z.aeZ();
            C25759h.m40918a(bizChatroomInfoUI.yDI.field_brandUserName, c44133kd, (C25772n) bizChatroomInfoUI);
            bizChatroomInfoUI.m12447JN();
            bizChatroomInfoUI.ehK.notifyDataSetChanged();
            AppMethodBeat.m2505o(30239);
            return true;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m12457d(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.m2504i(30240);
        C4990ab.m7416i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        C41747z.aeZ();
        C1720g.m3535RO().eJo.mo14541a(new C41741u(bizChatroomInfoUI.jMp, bizChatroomInfoUI.yDI.field_bizChatServId), 0);
        bizChatroomInfoUI.isDeleteCancel = false;
        bizChatroomInfoUI.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b((Context) bizChatroomInfoUI, bizChatroomInfoUI.getString(C25738R.string.f9260un), true, new C733111());
        C26428i.m42083a(bizChatroomInfoUI.jMp, bizChatroomInfoUI.jMj, new C1827a() {
            /* renamed from: JU */
            public final boolean mo5405JU() {
                AppMethodBeat.m2504i(30197);
                boolean f = BizChatroomInfoUI.this.isDeleteCancel;
                AppMethodBeat.m2505o(30197);
                return f;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(30198);
                if (b != null) {
                    C41747z.aeU().mo60341fw(BizChatroomInfoUI.this.jMj);
                    C41747z.aeT().mo60351fw(BizChatroomInfoUI.this.jMj);
                    b.dismiss();
                }
                AppMethodBeat.m2505o(30198);
            }
        });
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.jMp);
        C25985d.m41467b(bizChatroomInfoUI.mController.ylL, "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
        AppMethodBeat.m2505o(30240);
    }
}

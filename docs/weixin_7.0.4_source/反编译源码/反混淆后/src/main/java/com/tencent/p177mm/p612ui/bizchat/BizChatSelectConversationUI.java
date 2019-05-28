package com.tencent.p177mm.p612ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C25772n;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C17900n;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C25759h;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.contact.C36253p;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.protocal.protobuf.acr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

@C5271a(19)
/* renamed from: com.tencent.mm.ui.bizchat.BizChatSelectConversationUI */
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements C25772n {
    private String jMp = null;
    private int scene = 0;
    private C44275p tipDialog = null;
    C45143j yEk;
    private TextView yFh;

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSelectConversationUI$6 */
    class C236506 implements OnCancelListener {
        C236506() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(30179);
            BizChatSelectConversationUI.this.finish();
            AppMethodBeat.m2505o(30179);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSelectConversationUI$1 */
    class C406821 implements OnClickListener {
        C406821() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30174);
            BizChatSelectConversationUI.m70267a(BizChatSelectConversationUI.this);
            AppMethodBeat.m2505o(30174);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(30180);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        aWh();
        String cI = C41747z.aeV().mo60357cI(this.jMp);
        this.yEk = C41747z.aeV().mo60356cH(cI);
        String str = "MicroMsg.BizChatSelectConversationUI";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.jMp;
        objArr[1] = cI;
        if (this.yEk == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (C5046bo.isNullOrNil(cI) || this.yEk == null || this.yEk.afh() || C5046bo.isNullOrNil(this.yEk.field_addMemberUrl)) {
            C41747z.aeZ();
            C25759h.m40920a(this.jMp, (C25772n) this);
            Context activity = getActivity();
            getString(C25738R.string.f9238tz);
            this.tipDialog = C30379h.m48458b(activity, getString(C25738R.string.f9260un), true, new C236506());
        }
        AppMethodBeat.m2505o(30180);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30181);
        super.onDestroy();
        AppMethodBeat.m2505o(30181);
    }

    private void aWh() {
        AppMethodBeat.m2504i(30182);
        if (C5046bo.isNullOrNil(this.jMp)) {
            this.jMp = getIntent().getStringExtra("enterprise_biz_name");
            if (C5046bo.isNullOrNil(this.jMp)) {
                C4990ab.m7412e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
        AppMethodBeat.m2505o(30182);
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(30183);
        aWh();
        C36109d c36109d = new C36109d(this, this.jMp);
        AppMethodBeat.m2505o(30183);
        return c36109d;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(30184);
        aWh();
        C36253p c36253p = new C36253p(this, this.jMp);
        AppMethodBeat.m2505o(30184);
        return c36253p;
    }

    /* renamed from: a */
    public final void mo7851a(ListView listView, int i) {
        AppMethodBeat.m2504i(30185);
        super.mo7851a(listView, i);
        if (this.yFh == null) {
            C406821 c406821 = new C406821();
            String string = getString(C25738R.string.e1s);
            View inflate = C5616v.m8409hu(this).inflate(2130969809, null);
            inflate.setOnClickListener(c406821);
            TextView textView = (TextView) inflate.findViewById(2131822953);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.yFh = textView;
        }
        this.yFh.setVisibility(i);
        AppMethodBeat.m2505o(30185);
    }

    public final void bMQ() {
        AppMethodBeat.m2504i(30186);
        super.bMQ();
        AppMethodBeat.m2505o(30186);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(30187);
        if (i < getContentLV().getHeaderViewsCount()) {
            C4990ab.m7417i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(30187);
        } else if (getContentLV().getAdapter().getItem(i) instanceof C30407a) {
            C30407a c30407a = (C30407a) getContentLV().getAdapter().getItem(i);
            if (c30407a == null) {
                AppMethodBeat.m2505o(30187);
                return;
            }
            String str = c30407a.username;
            long j = c30407a.jMj;
            if (str == null || j == -1) {
                C4990ab.m7417i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", str, Long.valueOf(j));
                AppMethodBeat.m2505o(30187);
                return;
            }
            m70268a(str, j, c30407a.gnx);
            AppMethodBeat.m2505o(30187);
        } else {
            C4990ab.m7420w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
            AppMethodBeat.m2505o(30187);
        }
    }

    /* renamed from: a */
    private void m70268a(String str, long j, CharSequence charSequence) {
        AppMethodBeat.m2504i(30188);
        C4990ab.m7417i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", str);
        if (this.scene != 2) {
            if (this.scene == 1) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
                String str2 = (String) hashMap.get("desc");
                m70266a((String) hashMap.get("title"), str2, (String) hashMap.get("img_url"), str, j);
            }
            AppMethodBeat.m2505o(30188);
        } else if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
            m70269q(str, String.valueOf(charSequence), j);
            AppMethodBeat.m2505o(30188);
        } else {
            m70270r(str, String.valueOf(charSequence), j);
            AppMethodBeat.m2505o(30188);
        }
    }

    /* renamed from: q */
    private void m70269q(final String str, String str2, final long j) {
        AppMethodBeat.m2504i(30189);
        C35844g.m58756a(this.mController, j, getString(C25738R.string.dr7), str2, getString(C25738R.string.f9221tf), new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(30175);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str);
                    intent.putExtra("key_biz_chat_id", j);
                    intent.putExtra("key_is_biz_chat", true);
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.m2505o(30175);
            }
        });
        AppMethodBeat.m2505o(30189);
    }

    /* renamed from: r */
    private void m70270r(final String str, String str2, final long j) {
        AppMethodBeat.m2504i(30190);
        C35844g.m58756a(this.mController, j, getString(C25738R.string.dr7), str2, getString(C25738R.string.f9221tf), new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(30176);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str);
                    intent.putExtra("key_biz_chat_id", j);
                    intent.putExtra("key_is_biz_chat", true);
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.m2505o(30176);
            }
        });
        AppMethodBeat.m2505o(30190);
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(30192);
        String mJ = C1854s.m3866mJ(this.jMp);
        AppMethodBeat.m2505o(30192);
        return mJ;
    }

    public final boolean aow() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(30193);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(30193);
            return;
        }
        switch (i) {
            case 1:
                boolean z;
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    C4990ab.m7416i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                    String string = bundleExtra.getString("enterprise_members");
                    acr acr = new acr();
                    C45142c c45142c = new C45142c();
                    c45142c.field_addMemberUrl = this.yEk != null ? this.yEk.field_addMemberUrl : null;
                    c45142c.field_brandUserName = this.jMp;
                    if (!C25754e.m40892a(c45142c, string, null, acr)) {
                        z = false;
                    } else if (c45142c.field_bizChatLocalId != -1) {
                        m70268a(this.jMp, c45142c.field_bizChatLocalId, c45142c.field_chatName);
                        z = true;
                    } else {
                        C41747z.aeZ();
                        final C17900n a = C25759h.m40917a(this.jMp, acr, (C25772n) this);
                        getString(C25738R.string.f9238tz);
                        this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.f8728db), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(30178);
                                C9638aw.m17182Rg().mo14547c(a);
                                AppMethodBeat.m2505o(30178);
                            }
                        });
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.m2505o(30193);
                    return;
                }
                Toast.makeText(this, getString(C25738R.string.drn), 0).show();
                AppMethodBeat.m2505o(30193);
                return;
            default:
                AppMethodBeat.m2505o(30193);
                return;
        }
    }

    /* renamed from: a */
    public final void mo15832a(int i, C1207m c1207m) {
        AppMethodBeat.m2504i(30194);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (c1207m.getType() == 1355) {
            C45142c rq = C41747z.aeT().mo60352rq(((C17900n) c1207m).afm().wcb.wku.vMV);
            if (rq == null) {
                Toast.makeText(C4996ah.getContext(), getString(C25738R.string.drn), 0).show();
                AppMethodBeat.m2505o(30194);
                return;
            }
            m70268a(this.jMp, rq.field_bizChatLocalId, rq.field_chatName);
        }
        AppMethodBeat.m2505o(30194);
    }

    /* renamed from: a */
    private C5653c m70266a(String str, String str2, String str3, final String str4, final long j) {
        AppMethodBeat.m2504i(30191);
        C5653c a = C35844g.m58765a(this.mController, str, str3, str2, true, getResources().getString(C25738R.string.f9221tf), new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(30177);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str4);
                    intent.putExtra("key_biz_chat_id", j);
                    intent.putExtra("key_is_biz_chat", true);
                    if (!C5046bo.isNullOrNil(str)) {
                        intent.putExtra("enterprise_share_append_text", str);
                    }
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.m2505o(30177);
            }
        });
        AppMethodBeat.m2505o(30191);
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ void m70267a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        AppMethodBeat.m2504i(30195);
        bizChatSelectConversationUI.yEk = C41747z.aeV().mo60356cH(C41747z.aeV().mo60357cI(bizChatSelectConversationUI.jMp));
        if (bizChatSelectConversationUI.yEk == null || C5046bo.isNullOrNil(bizChatSelectConversationUI.yEk.field_addMemberUrl)) {
            String str = "MicroMsg.BizChatSelectConversationUI";
            String str2 = "field_addMemberUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.yEk != null ? bizChatSelectConversationUI.yEk.field_addMemberUrl : null;
            C4990ab.m7417i(str, str2, objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(C25738R.string.a_o), 0).show();
            AppMethodBeat.m2505o(30195);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.yEk.field_addMemberUrl);
        C4990ab.m7417i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", bizChatSelectConversationUI.yEk.field_addMemberUrl);
        intent.putExtra("useJs", true);
        C25985d.m41468b(bizChatSelectConversationUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.m2505o(30195);
    }
}

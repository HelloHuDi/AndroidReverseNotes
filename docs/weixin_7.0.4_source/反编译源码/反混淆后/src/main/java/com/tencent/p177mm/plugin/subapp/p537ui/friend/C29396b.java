package com.tencent.p177mm.plugin.subapp.p537ui.friend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7568av;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.subapp.ui.friend.b */
public final class C29396b extends C46692p<C7568av> {
    private Context context;
    private OnClickListener stx = new C139082();
    private OnClickListener sty = new C293933();

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.b$2 */
    class C139082 implements OnClickListener {
        C139082() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25347);
            if (view.getTag() instanceof C14957b) {
                C4990ab.m7410d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
                final C14957b c14957b = (C14957b) view.getTag();
                if (c14957b == null || C5046bo.isNullOrNil(c14957b.username)) {
                    C4990ab.m7412e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
                    AppMethodBeat.m2505o(25347);
                    return;
                }
                final C7616ad a = C14957b.m23239a(C41789d.akO().apx(c14957b.username));
                C14916a c14916a = new C14916a(C29396b.this.context, new C14917a() {
                    /* renamed from: a */
                    public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.m2504i(25346);
                        if (z) {
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(c14957b.username);
                            if (((int) aoO.ewQ) == 0) {
                                aoO = a;
                                C9638aw.m17190ZK();
                                if (!C18628c.m29078XM().mo15702Z(aoO)) {
                                    C4990ab.m7412e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                                    AppMethodBeat.m2505o(25346);
                                    return;
                                }
                            }
                            C1855t.m3960q(aoO);
                            C41789d.akP().mo17076ep(c14957b.username, 1);
                            C30379h.m48465bQ(C29396b.this.context, C29396b.this.context.getString(C25738R.string.f8817fv));
                            C29396b.m46659a(C29396b.this, c14957b.username);
                        } else if (z2) {
                            C41789d.akP().mo17076ep(c14957b.username, 2);
                        } else {
                            C4990ab.m7412e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + c14957b.username);
                            AppMethodBeat.m2505o(25346);
                            return;
                        }
                        C29396b.this.notifyDataSetChanged();
                        AppMethodBeat.m2505o(25346);
                    }
                });
                C4990ab.m7410d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + c14957b.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(c14957b.qvb));
                c14916a.ajw(a.dus);
                c14916a.mo27242b(c14957b.username, linkedList, true);
            }
            AppMethodBeat.m2505o(25347);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.b$3 */
    class C293933 implements OnClickListener {
        C293933() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25349);
            if (view.getTag() instanceof C14957b) {
                C4990ab.m7410d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
                C14957b c14957b = (C14957b) view.getTag();
                final C7569ax apx = C41789d.akO().apx(c14957b.username);
                if (apx == null || apx.field_msgContent == null) {
                    C4990ab.m7412e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + c14957b.username);
                    AppMethodBeat.m2505o(25349);
                    return;
                }
                C5138d apF = C5138d.apF(apx.field_msgContent);
                C4990ab.m7410d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + c14957b.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
                if (apF.xZy == 1) {
                    C30379h.m48445a(C29396b.this.context, apF.xZz, null, C29396b.this.context.getString(C25738R.string.bw8), C29396b.this.context.getString(C25738R.string.f9076or), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(25348);
                            C39940a.m68402a(C29396b.this.context, apx, false);
                            AppMethodBeat.m2505o(25348);
                        }
                    }, null);
                    AppMethodBeat.m2505o(25349);
                    return;
                }
                C9638aw.m17190ZK();
                C7575bv RB = C18628c.m29079XN().mo15364RB(c14957b.username);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", c14957b.username);
                intent.putExtra("Contact_Nick", c14957b.nickname);
                if (RB != null) {
                    intent.putExtra("Contact_RemarkName", RB.field_conRemark);
                }
                if (!C5046bo.isNullOrNil(apF.chatroomName)) {
                    C9638aw.m17190ZK();
                    C7577u oa = C18628c.m29087XV().mo14885oa(apF.chatroomName);
                    if (oa != null) {
                        intent.putExtra("Contact_RoomNickname", oa.mo16807mJ(apF.svN));
                    }
                }
                intent.putExtra("Contact_Scene", apF.scene);
                intent.putExtra("Verify_ticket", apF.mGZ);
                intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                intent.putExtra("sayhi_with_sns_perm_set_label", true);
                intent.putExtra("sayhi_with_jump_to_profile", true);
                C25985d.m41467b(C29396b.this.context, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent);
            }
            AppMethodBeat.m2505o(25349);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.b$a */
    static class C29395a {
        public TextView gnf;
        public TextView pnE;
        public MaskLayout stF;
        public Button stG;
        public Button stH;
        public TextView stI;
        public TextView stJ;
        public TextView stK;

        C29395a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.b$1 */
    class C293971 implements Runnable {
        C293971() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25345);
            C29396b.m46658a(C29396b.this, C41789d.akP().baR());
            C29396b.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(25345);
        }
    }

    public C29396b(Context context) {
        super(context, new C7568av());
        AppMethodBeat.m2504i(25351);
        this.context = context;
        AppMethodBeat.m2505o(25351);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x018a  */
    /* JADX WARNING: Missing block: B:53:0x0374, code skipped:
            if ((((com.tencent.p177mm.storage.C7568av) getItem(r18 - 1)).field_lastModifiedTime + 259200000) >= r4) goto L_0x0376;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C29395a c29395a;
        AppMethodBeat.m2504i(25352);
        if (view == null) {
            view = C5616v.m8409hu(this.context).inflate(2130969576, null);
            C29395a c29395a2 = new C29395a();
            c29395a2.stF = (MaskLayout) view.findViewById(2131824087);
            c29395a2.pnE = (TextView) view.findViewById(2131824089);
            c29395a2.stK = (TextView) view.findViewById(2131824090);
            c29395a2.stG = (Button) view.findViewById(2131824092);
            c29395a2.stG.setOnClickListener(this.stx);
            c29395a2.stH = (Button) view.findViewById(2131824093);
            c29395a2.stH.setOnClickListener(this.sty);
            c29395a2.stI = (TextView) view.findViewById(2131824094);
            c29395a2.stJ = (TextView) view.findViewById(2131824095);
            c29395a2.gnf = (TextView) view.findViewById(2131824085);
            view.setTag(c29395a2);
            c29395a = c29395a2;
        } else {
            c29395a = (C29395a) view.getTag();
        }
        C7568av c7568av = (C7568av) getItem(i);
        C40460b.m69434b((ImageView) c29395a.stF.getContentView(), c7568av.field_talker);
        c29395a.pnE.setText(C44089j.m79293b(this.context, c7568av.field_displayName, c29395a.pnE.getTextSize()));
        C14957b b;
        long aaE;
        if (c7568av.field_fmsgSysRowId <= 0) {
            C4990ab.m7420w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
            C7569ax apw = C41789d.akO().apw(c7568av.field_talker);
            if (apw == null) {
                C4990ab.m7412e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + c7568av.field_talker);
                c29395a.stG.setVisibility(8);
                c29395a.stH.setVisibility(8);
                c29395a.stI.setVisibility(8);
                c29395a.stJ.setVisibility(8);
                c29395a.stK.setVisibility(8);
                AppMethodBeat.m2505o(25352);
            } else {
                b = C14957b.m23244b(this.context, apw);
                C4990ab.m7416i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + c7568av.field_talker);
                if (c7568av.field_state == 1) {
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(c7568av.field_talker);
                    if (!(aoO == null || ((int) aoO.ewQ) == 0 || C7486a.m12942jh(aoO.field_type))) {
                        C41789d.akP().mo17076ep(c7568av.field_talker, 0);
                    }
                }
                if (b != null) {
                    C4990ab.m7412e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + c7568av.field_talker);
                    c29395a.stG.setVisibility(8);
                    c29395a.stH.setVisibility(8);
                    c29395a.stI.setVisibility(8);
                    c29395a.stJ.setVisibility(8);
                    c29395a.stK.setVisibility(8);
                    AppMethodBeat.m2505o(25352);
                } else {
                    b.qvb = c7568av.field_addScene;
                    c29395a.stK.setText(C44089j.m79293b(this.context, b.fjz, c29395a.stK.getTextSize()));
                    switch (c7568av.field_state) {
                        case 0:
                            int i2;
                            if (c7568av.field_fmsgSysRowId <= 0) {
                                C4990ab.m7420w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                                C7569ax apx = C41789d.akO().apx(b.username);
                                i2 = apx == null ? 0 : apx.field_type;
                            } else {
                                i2 = c7568av.field_recvFmsgType;
                            }
                            if (i2 == 0 || i2 == 3) {
                                c29395a.stG.setVisibility(0);
                                c29395a.stG.setTag(b);
                                c29395a.stH.setVisibility(8);
                            } else {
                                c29395a.stH.setVisibility(0);
                                c29395a.stH.setTag(b);
                                c29395a.stG.setVisibility(8);
                            }
                            c29395a.stI.setVisibility(8);
                            c29395a.stJ.setVisibility(8);
                            break;
                        case 1:
                            c29395a.stJ.setVisibility(0);
                            c29395a.stG.setVisibility(8);
                            c29395a.stH.setVisibility(8);
                            c29395a.stI.setVisibility(8);
                            break;
                        case 2:
                            c29395a.stI.setVisibility(0);
                            c29395a.stG.setVisibility(8);
                            c29395a.stH.setVisibility(8);
                            c29395a.stJ.setVisibility(8);
                            break;
                        default:
                            c29395a.stG.setVisibility(8);
                            c29395a.stH.setVisibility(8);
                            c29395a.stI.setVisibility(8);
                            c29395a.stJ.setVisibility(8);
                            break;
                    }
                    view.findViewById(2131824086).setBackgroundResource(C25738R.drawable.a7q);
                    aaE = C1839cb.aaE();
                    if (i != 0 || c7568av.field_lastModifiedTime + 259200000 < aaE) {
                        if (i != 0) {
                        }
                        if (((C7568av) getItem(i)).field_lastModifiedTime + 259200000 < aaE) {
                            c29395a.gnf.setVisibility(0);
                            c29395a.gnf.setText(this.context.getString(C25738R.string.bwf));
                        }
                        c29395a.gnf.setVisibility(8);
                    } else {
                        c29395a.gnf.setVisibility(0);
                        c29395a.gnf.setText(this.context.getString(C25738R.string.bwg));
                    }
                    AppMethodBeat.m2505o(25352);
                }
            }
        } else {
            boolean z;
            Context context = this.context;
            aaE = c7568av.field_fmsgSysRowId;
            if (c7568av.field_fmsgIsSend % 2 == 0) {
                z = true;
            } else {
                z = false;
            }
            b = C14957b.m23236a(context, aaE, z, c7568av.field_talker, c7568av.field_fmsgContent, c7568av.field_fmsgType, c7568av.field_contentFromUsername, c7568av.field_contentNickname, c7568av.field_contentPhoneNumMD5, c7568av.field_contentFullPhoneNumMD5, c7568av.field_contentVerifyContent, c7568av.field_addScene);
            C4990ab.m7416i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + c7568av.field_fmsgSysRowId + ", talker = " + c7568av.field_talker);
            if (c7568av.field_state == 1) {
            }
            if (b != null) {
            }
        }
        return view;
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(25353);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setCursor(C41789d.akP().baR());
            notifyDataSetChanged();
            AppMethodBeat.m2505o(25353);
            return;
        }
        C5004al.m7441d(new C293971());
        AppMethodBeat.m2505o(25353);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(25354);
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(25354);
    }
}

package com.tencent.mm.plugin.subapp.ui.friend;

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
import com.tencent.mm.R;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import java.util.LinkedList;

public final class b extends p<av> {
    private Context context;
    private OnClickListener stx = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(25347);
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                ab.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
                final com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                if (bVar == null || bo.isNullOrNil(bVar.username)) {
                    ab.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
                    AppMethodBeat.o(25347);
                    return;
                }
                final ad a = com.tencent.mm.pluginsdk.ui.preference.b.a(d.akO().apx(bVar.username));
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(b.this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(25346);
                        if (z) {
                            aw.ZK();
                            ad aoO = c.XM().aoO(bVar.username);
                            if (((int) aoO.ewQ) == 0) {
                                aoO = a;
                                aw.ZK();
                                if (!c.XM().Z(aoO)) {
                                    ab.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                                    AppMethodBeat.o(25346);
                                    return;
                                }
                            }
                            t.q(aoO);
                            d.akP().ep(bVar.username, 1);
                            h.bQ(b.this.context, b.this.context.getString(R.string.fv));
                            b.a(b.this, bVar.username);
                        } else if (z2) {
                            d.akP().ep(bVar.username, 2);
                        } else {
                            ab.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + bVar.username);
                            AppMethodBeat.o(25346);
                            return;
                        }
                        b.this.notifyDataSetChanged();
                        AppMethodBeat.o(25346);
                    }
                });
                ab.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(bVar.qvb));
                aVar.ajw(a.dus);
                aVar.b(bVar.username, linkedList, true);
            }
            AppMethodBeat.o(25347);
        }
    };
    private OnClickListener sty = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(25349);
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                ab.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
                com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                final ax apx = d.akO().apx(bVar.username);
                if (apx == null || apx.field_msgContent == null) {
                    ab.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + bVar.username);
                    AppMethodBeat.o(25349);
                    return;
                }
                bi.d apF = bi.d.apF(apx.field_msgContent);
                ab.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
                if (apF.xZy == 1) {
                    h.a(b.this.context, apF.xZz, null, b.this.context.getString(R.string.bw8), b.this.context.getString(R.string.or), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(25348);
                            a.a(b.this.context, apx, false);
                            AppMethodBeat.o(25348);
                        }
                    }, null);
                    AppMethodBeat.o(25349);
                    return;
                }
                aw.ZK();
                bv RB = c.XN().RB(bVar.username);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", bVar.username);
                intent.putExtra("Contact_Nick", bVar.nickname);
                if (RB != null) {
                    intent.putExtra("Contact_RemarkName", RB.field_conRemark);
                }
                if (!bo.isNullOrNil(apF.chatroomName)) {
                    aw.ZK();
                    u oa = c.XV().oa(apF.chatroomName);
                    if (oa != null) {
                        intent.putExtra("Contact_RoomNickname", oa.mJ(apF.svN));
                    }
                }
                intent.putExtra("Contact_Scene", apF.scene);
                intent.putExtra("Verify_ticket", apF.mGZ);
                intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                intent.putExtra("sayhi_with_sns_perm_set_label", true);
                intent.putExtra("sayhi_with_jump_to_profile", true);
                com.tencent.mm.bp.d.b(b.this.context, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent);
            }
            AppMethodBeat.o(25349);
        }
    };

    static class a {
        public TextView gnf;
        public TextView pnE;
        public MaskLayout stF;
        public Button stG;
        public Button stH;
        public TextView stI;
        public TextView stJ;
        public TextView stK;

        a() {
        }
    }

    public b(Context context) {
        super(context, new av());
        AppMethodBeat.i(25351);
        this.context = context;
        AppMethodBeat.o(25351);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x018a  */
    /* JADX WARNING: Missing block: B:53:0x0374, code skipped:
            if ((((com.tencent.mm.storage.av) getItem(r18 - 1)).field_lastModifiedTime + 259200000) >= r4) goto L_0x0376;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(25352);
        if (view == null) {
            view = v.hu(this.context).inflate(R.layout.a08, null);
            a aVar2 = new a();
            aVar2.stF = (MaskLayout) view.findViewById(R.id.bur);
            aVar2.pnE = (TextView) view.findViewById(R.id.but);
            aVar2.stK = (TextView) view.findViewById(R.id.buu);
            aVar2.stG = (Button) view.findViewById(R.id.buw);
            aVar2.stG.setOnClickListener(this.stx);
            aVar2.stH = (Button) view.findViewById(R.id.bux);
            aVar2.stH.setOnClickListener(this.sty);
            aVar2.stI = (TextView) view.findViewById(R.id.buy);
            aVar2.stJ = (TextView) view.findViewById(R.id.buz);
            aVar2.gnf = (TextView) view.findViewById(R.id.bup);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        av avVar = (av) getItem(i);
        com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) aVar.stF.getContentView(), avVar.field_talker);
        aVar.pnE.setText(j.b(this.context, avVar.field_displayName, aVar.pnE.getTextSize()));
        com.tencent.mm.pluginsdk.ui.preference.b b;
        long aaE;
        if (avVar.field_fmsgSysRowId <= 0) {
            ab.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
            ax apw = d.akO().apw(avVar.field_talker);
            if (apw == null) {
                ab.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + avVar.field_talker);
                aVar.stG.setVisibility(8);
                aVar.stH.setVisibility(8);
                aVar.stI.setVisibility(8);
                aVar.stJ.setVisibility(8);
                aVar.stK.setVisibility(8);
                AppMethodBeat.o(25352);
            } else {
                b = com.tencent.mm.pluginsdk.ui.preference.b.b(this.context, apw);
                ab.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + avVar.field_talker);
                if (avVar.field_state == 1) {
                    aw.ZK();
                    ad aoO = c.XM().aoO(avVar.field_talker);
                    if (!(aoO == null || ((int) aoO.ewQ) == 0 || com.tencent.mm.n.a.jh(aoO.field_type))) {
                        d.akP().ep(avVar.field_talker, 0);
                    }
                }
                if (b != null) {
                    ab.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + avVar.field_talker);
                    aVar.stG.setVisibility(8);
                    aVar.stH.setVisibility(8);
                    aVar.stI.setVisibility(8);
                    aVar.stJ.setVisibility(8);
                    aVar.stK.setVisibility(8);
                    AppMethodBeat.o(25352);
                } else {
                    b.qvb = avVar.field_addScene;
                    aVar.stK.setText(j.b(this.context, b.fjz, aVar.stK.getTextSize()));
                    switch (avVar.field_state) {
                        case 0:
                            int i2;
                            if (avVar.field_fmsgSysRowId <= 0) {
                                ab.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                                ax apx = d.akO().apx(b.username);
                                i2 = apx == null ? 0 : apx.field_type;
                            } else {
                                i2 = avVar.field_recvFmsgType;
                            }
                            if (i2 == 0 || i2 == 3) {
                                aVar.stG.setVisibility(0);
                                aVar.stG.setTag(b);
                                aVar.stH.setVisibility(8);
                            } else {
                                aVar.stH.setVisibility(0);
                                aVar.stH.setTag(b);
                                aVar.stG.setVisibility(8);
                            }
                            aVar.stI.setVisibility(8);
                            aVar.stJ.setVisibility(8);
                            break;
                        case 1:
                            aVar.stJ.setVisibility(0);
                            aVar.stG.setVisibility(8);
                            aVar.stH.setVisibility(8);
                            aVar.stI.setVisibility(8);
                            break;
                        case 2:
                            aVar.stI.setVisibility(0);
                            aVar.stG.setVisibility(8);
                            aVar.stH.setVisibility(8);
                            aVar.stJ.setVisibility(8);
                            break;
                        default:
                            aVar.stG.setVisibility(8);
                            aVar.stH.setVisibility(8);
                            aVar.stI.setVisibility(8);
                            aVar.stJ.setVisibility(8);
                            break;
                    }
                    view.findViewById(R.id.buq).setBackgroundResource(R.drawable.a7q);
                    aaE = cb.aaE();
                    if (i != 0 || avVar.field_lastModifiedTime + 259200000 < aaE) {
                        if (i != 0) {
                        }
                        if (((av) getItem(i)).field_lastModifiedTime + 259200000 < aaE) {
                            aVar.gnf.setVisibility(0);
                            aVar.gnf.setText(this.context.getString(R.string.bwf));
                        }
                        aVar.gnf.setVisibility(8);
                    } else {
                        aVar.gnf.setVisibility(0);
                        aVar.gnf.setText(this.context.getString(R.string.bwg));
                    }
                    AppMethodBeat.o(25352);
                }
            }
        } else {
            boolean z;
            Context context = this.context;
            aaE = avVar.field_fmsgSysRowId;
            if (avVar.field_fmsgIsSend % 2 == 0) {
                z = true;
            } else {
                z = false;
            }
            b = com.tencent.mm.pluginsdk.ui.preference.b.a(context, aaE, z, avVar.field_talker, avVar.field_fmsgContent, avVar.field_fmsgType, avVar.field_contentFromUsername, avVar.field_contentNickname, avVar.field_contentPhoneNumMD5, avVar.field_contentFullPhoneNumMD5, avVar.field_contentVerifyContent, avVar.field_addScene);
            ab.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + avVar.field_fmsgSysRowId + ", talker = " + avVar.field_talker);
            if (avVar.field_state == 1) {
            }
            if (b != null) {
            }
        }
        return view;
    }

    public final void KC() {
        AppMethodBeat.i(25353);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setCursor(d.akP().baR());
            notifyDataSetChanged();
            AppMethodBeat.o(25353);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25345);
                b.a(b.this, d.akP().baR());
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(25345);
            }
        });
        AppMethodBeat.o(25353);
    }

    public final void KD() {
        AppMethodBeat.i(25354);
        bIf();
        KC();
        AppMethodBeat.o(25354);
    }
}

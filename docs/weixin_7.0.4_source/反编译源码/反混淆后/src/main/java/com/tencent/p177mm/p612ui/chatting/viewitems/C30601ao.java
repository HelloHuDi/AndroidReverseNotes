package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C36866d;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.plugin.subapp.p1039c.C13897a;
import com.tencent.p177mm.plugin.subapp.p1039c.C22335h;
import com.tencent.p177mm.plugin.subapp.p1039c.C43667k;
import com.tencent.p177mm.plugin.subapp.p1039c.C46291e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.coc;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ao */
public final class C30601ao extends C5378c {
    private C1202f fQS;
    private ProgressDialog qlZ;
    private C46650a yJI;

    public final boolean dHk() {
        return false;
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == -1879048189) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33390);
        if (view == null || view.getTag() == null) {
            view = new C44341v(layoutInflater, 2130969112);
            view.setTag(new C31501au().mo51426fj(view));
        }
        AppMethodBeat.m2505o(33390);
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHj() {
        return false;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
        C8910b c8910b;
        String ae;
        Object obj;
        String by;
        C6300p Rg;
        C1202f c306022;
        AppMethodBeat.m2504i(33391);
        C31501au c31501au = (C31501au) c5379a;
        this.yJI = c46650a;
        C8909j ma = C14877am.dhN().mo27204ma(c7620bi.field_msgId);
        String str2 = c7620bi.field_content;
        if (ma == null || str2 == null) {
            c8910b = null;
        } else {
            c8910b = C8910b.m16064me(str2);
        }
        boolean z = false;
        final C46291e abk = C46291e.abk(str2);
        if (!(abk == null || abk.ssY == 0)) {
            try {
                ae = C14835h.m23086ae(this.yJI.yTx.getContext(), abk.ssY);
                if (!(c8910b == null || c8910b.description == null)) {
                    int indexOf = c8910b.description.indexOf(124);
                    if (indexOf <= 0 || c8910b.description.length() <= indexOf + 1) {
                        c31501au.gnC.setText("");
                    } else {
                        c31501au.gnC.setText(c8910b.description.substring(indexOf + 1));
                    }
                }
                if (ae != null && ae.length() > 0) {
                    String[] split = ae.split(";");
                    c31501au.zic.setText(split[0]);
                    if (split.length > 1) {
                        c31501au.zid.setText(split[1]);
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", e, "", new Object[0]);
            }
            z = C42252ah.m74630mL(abk.ssY);
        }
        if (z) {
            c31501au.zig.setVisibility(0);
            c31501au.gnC.setTextColor(this.yJI.yTx.getMMResources().getColor(C25738R.color.a45));
            c31501au.zid.setTextColor(this.yJI.yTx.getMMResources().getColor(C25738R.color.a45));
            c31501au.zic.setTextColor(this.yJI.yTx.getMMResources().getColor(C25738R.color.a45));
        } else {
            c31501au.zig.setVisibility(8);
            c31501au.gnC.setTextColor(this.yJI.yTx.getMMResources().getColor(C25738R.color.a44));
            c31501au.zid.setTextColor(this.yJI.yTx.getMMResources().getColor(C25738R.color.a44));
            c31501au.zic.setTextColor(this.yJI.yTx.getMMResources().getColor(C25738R.color.a44));
        }
        final C7620bi c7620bi2 = c7620bi;
        final int i2 = i;
        c31501au.zie.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(33383);
                if (C42252ah.isNullOrNil(c7620bi2.field_imgPath)) {
                    C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
                    AppMethodBeat.m2505o(33383);
                    return;
                }
                ((C15611aj) C30601ao.this.yJI.mo74857aF(C15611aj.class)).dFm().mo58727b(i2, c7620bi2);
                AppMethodBeat.m2505o(33383);
            }
        });
        long j = c7620bi.field_msgId;
        C36866d dFm = ((C15611aj) this.yJI.mo74857aF(C15611aj.class)).dFm();
        if (dFm != null && dFm.isPlaying() && dFm.yGO == j) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            c31501au.zie.setBackgroundResource(C25738R.drawable.a4s);
        } else {
            c31501au.zie.setBackgroundResource(C25738R.drawable.a4t);
        }
        if (!(abk == null || C42252ah.isNullOrNil(abk.sta) || abk.stb <= 0 || !C42252ah.isNullOrNil(c7620bi.field_reserved) || c8910b == null)) {
            ae = C43667k.m78198ug(C1853r.m3846Yz());
            by = C22335h.m34031by(ae, false);
            c7620bi.mo14796jw(ae);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            ae = C4733l.m7094a(by, c7620bi.field_msgId, c8910b.sdkVer, c8910b.appId, abk.sta, abk.stb, c8910b.type, c8910b.fgs);
            if (ae != null) {
                Rg = C9638aw.m17182Rg();
                c7620bi2 = c7620bi;
                i2 = i;
                c306022 = new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(33384);
                        C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + c1207m.getType());
                        boolean z = false;
                        if (C26417a.flx != null) {
                            z = C26417a.flx.mo44188fl(c7620bi2.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((C43432e) c1207m).getMediaId().equals(ae)) {
                            C7620bi ar = C7620bi.m13569ar(c7620bi2);
                            ar.mo14795jv(c7620bi2.field_reserved);
                            ar.setMsgId(-1);
                            ((C15611aj) C30601ao.this.yJI.mo74857aF(C15611aj.class)).dFm().mo58727b(i2, ar);
                        }
                        C9638aw.m17182Rg().mo14546b(221, C30601ao.this.fQS);
                        C30601ao.this.fQS = null;
                        AppMethodBeat.m2505o(33384);
                    }
                };
                this.fQS = c306022;
                Rg.mo14539a(221, c306022);
                C1207m c43432e = new C43432e(ae);
                c43432e.ceC();
                C9638aw.m17182Rg().mo14541a(c43432e, 0);
            }
        }
        if (C42252ah.isNullOrNil(c7620bi.field_imgPath) && abk.ste > 0) {
            C9638aw.m17190ZK();
            C7620bi Q = C18628c.m29080XO().mo15241Q(c7620bi.field_talker, (long) abk.ste);
            if (!C42252ah.isNullOrNil(Q.field_imgPath)) {
                by = C43667k.m78198ug(C1853r.m3846Yz());
                if (C5730e.m8644y(C22335h.m34031by(Q.field_imgPath, false), C22335h.m34031by(by, false)) >= 0) {
                    c7620bi.mo14795jv(by);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                }
            }
        }
        if (C42252ah.isNullOrNil(c7620bi.field_imgPath) && abk != null && !C42252ah.isNullOrNil(abk.csD) && abk.fgo > 0 && this.fQS == null) {
            ae = C43667k.m78198ug(C1853r.m3846Yz());
            by = C22335h.m34031by(ae, false);
            c7620bi.mo14795jv(ae);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            final C30065b a = C4733l.m7092a(by, c7620bi.field_msgId, c8910b.sdkVer, c8910b.appId, c8910b.csD, c8910b.fgo);
            C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a.field_mediaSvrId);
            if (a.field_mediaSvrId != null) {
                Rg = C9638aw.m17182Rg();
                c306022 = new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(33385);
                        C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + c1207m.getType());
                        if (((C43432e) c1207m).getMediaId().equals(a.field_mediaSvrId)) {
                            C9638aw.m17182Rg().mo14546b(221, C30601ao.this.fQS);
                            C30601ao.this.fQS = null;
                        }
                        AppMethodBeat.m2505o(33385);
                    }
                };
                this.fQS = c306022;
                Rg.mo14539a(221, c306022);
                C9638aw.m17182Rg().mo14541a(new C43432e(a), 0);
            }
        }
        c7620bi2 = c7620bi;
        c31501au.zif.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.ui.chatting.viewitems.ao$4$1 */
            class C306001 implements DialogInterface.OnClickListener {

                /* renamed from: com.tencent.mm.ui.chatting.viewitems.ao$4$1$1 */
                class C305981 implements C1202f {
                    C305981() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(33386);
                        C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + c1207m.getType());
                        if (i == 0 && i2 == 0) {
                            C8910b me;
                            String str2 = c7620bi2.field_content;
                            if (str2 != null) {
                                me = C8910b.m16064me(str2);
                            } else {
                                me = null;
                            }
                            if (me != null) {
                                C30065b lZ = C14877am.aUq().mo48329lZ(c7620bi2.field_msgId);
                                if (lZ != null) {
                                    boolean deleteFile = C5730e.deleteFile(lZ.field_fileFullPath);
                                    boolean a = C14877am.aUq().mo16760a((C4925c) lZ, "msgInfoId");
                                    C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(a), Long.valueOf(lZ.field_msgInfoId), lZ.field_mediaSvrId, lZ.field_fileFullPath, C5046bo.dpG());
                                }
                            }
                            C1829bf.m3748fm(c7620bi2.field_msgId);
                            Toast.makeText(C30601ao.this.yJI.yTx.getContext(), C30601ao.this.yJI.yTx.getMMResources().getString(C25738R.string.alv), 0).show();
                        }
                        C9638aw.m17182Rg().mo14546b((int) ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, C30601ao.this.fQS);
                        C30601ao.this.fQS = null;
                        if (C30601ao.this.qlZ != null) {
                            C30601ao.this.qlZ.dismiss();
                        }
                        AppMethodBeat.m2505o(33386);
                    }
                }

                C306001() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(33388);
                    C9638aw.m17182Rg().mo14539a((int) ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, C30601ao.this.fQS = new C305981());
                    LinkedList linkedList = new LinkedList();
                    coc coc = new coc();
                    coc.vFI = abk.ssZ;
                    linkedList.add(coc);
                    final C1207m c13897a = new C13897a(linkedList, linkedList.size());
                    C9638aw.m17182Rg().mo14541a(c13897a, 0);
                    C30601ao c30601ao = C30601ao.this;
                    Context context = C30601ao.this.yJI.yTx.getContext();
                    C30601ao.this.yJI.yTx.getMMResources().getString(C25738R.string.f9238tz);
                    c30601ao.qlZ = C30379h.m48458b(context, C30601ao.this.yJI.yTx.getMMResources().getString(C25738R.string.alw), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(33387);
                            C9638aw.m17182Rg().mo14547c(c13897a);
                            C9638aw.m17182Rg().mo14546b((int) ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, C30601ao.this.fQS);
                            C30601ao.this.fQS = null;
                            if (C30601ao.this.qlZ != null) {
                                C30601ao.this.qlZ.dismiss();
                            }
                            AppMethodBeat.m2505o(33387);
                        }
                    });
                    AppMethodBeat.m2505o(33388);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(33389);
                C30379h.m48432a(C30601ao.this.yJI.yTx.getContext(), (int) C25738R.string.f32, (int) C25738R.string.f34, new C306001(), null);
                AppMethodBeat.m2505o(33389);
            }
        });
        c31501au.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            c31501au.jPL.setOnLongClickListener(mo11021c(this.yJI));
        }
        AppMethodBeat.m2505o(33391);
    }

    /* renamed from: a */
    public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33392);
        int i = ((C40814ay) view.getTag()).position;
        int aiL = C4733l.aiL(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
        C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
        if (me.fgo <= 0 || (me.fgo > 0 && aiL >= 100)) {
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
        }
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
        }
        AppMethodBeat.m2505o(33392);
        return true;
    }

    /* renamed from: a */
    public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33393);
        switch (menuItem.getItemId()) {
            case 111:
                Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                c46650a.startActivity(intent);
                AppMethodBeat.m2505o(33393);
                break;
            default:
                AppMethodBeat.m2505o(33393);
                break;
        }
        return false;
    }

    /* renamed from: b */
    public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
        return true;
    }
}

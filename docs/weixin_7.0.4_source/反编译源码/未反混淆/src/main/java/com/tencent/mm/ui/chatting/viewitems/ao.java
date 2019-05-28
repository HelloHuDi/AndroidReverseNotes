package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.subapp.c.e;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

public final class ao extends c {
    private f fQS;
    private ProgressDialog qlZ;
    private a yJI;

    public final boolean dHk() {
        return false;
    }

    public final boolean aH(int i, boolean z) {
        if (i == -1879048189) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33390);
        if (view == null || view.getTag() == null) {
            view = new v(layoutInflater, R.layout.nq);
            view.setTag(new au().fj(view));
        }
        AppMethodBeat.o(33390);
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHj() {
        return false;
    }

    public final void a(c.a aVar, int i, a aVar2, bi biVar, String str) {
        b bVar;
        String ae;
        Object obj;
        String by;
        p Rg;
        f anonymousClass2;
        AppMethodBeat.i(33391);
        au auVar = (au) aVar;
        this.yJI = aVar2;
        j ma = am.dhN().ma(biVar.field_msgId);
        String str2 = biVar.field_content;
        if (ma == null || str2 == null) {
            bVar = null;
        } else {
            bVar = b.me(str2);
        }
        boolean z = false;
        final e abk = e.abk(str2);
        if (!(abk == null || abk.ssY == 0)) {
            try {
                ae = h.ae(this.yJI.yTx.getContext(), abk.ssY);
                if (!(bVar == null || bVar.description == null)) {
                    int indexOf = bVar.description.indexOf(124);
                    if (indexOf <= 0 || bVar.description.length() <= indexOf + 1) {
                        auVar.gnC.setText("");
                    } else {
                        auVar.gnC.setText(bVar.description.substring(indexOf + 1));
                    }
                }
                if (ae != null && ae.length() > 0) {
                    String[] split = ae.split(";");
                    auVar.zic.setText(split[0]);
                    if (split.length > 1) {
                        auVar.zid.setText(split[1]);
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", e, "", new Object[0]);
            }
            z = ah.mL(abk.ssY);
        }
        if (z) {
            auVar.zig.setVisibility(0);
            auVar.gnC.setTextColor(this.yJI.yTx.getMMResources().getColor(R.color.a45));
            auVar.zid.setTextColor(this.yJI.yTx.getMMResources().getColor(R.color.a45));
            auVar.zic.setTextColor(this.yJI.yTx.getMMResources().getColor(R.color.a45));
        } else {
            auVar.zig.setVisibility(8);
            auVar.gnC.setTextColor(this.yJI.yTx.getMMResources().getColor(R.color.a44));
            auVar.zid.setTextColor(this.yJI.yTx.getMMResources().getColor(R.color.a44));
            auVar.zic.setTextColor(this.yJI.yTx.getMMResources().getColor(R.color.a44));
        }
        final bi biVar2 = biVar;
        final int i2 = i;
        auVar.zie.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33383);
                if (ah.isNullOrNil(biVar2.field_imgPath)) {
                    ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
                    AppMethodBeat.o(33383);
                    return;
                }
                ((aj) ao.this.yJI.aF(aj.class)).dFm().b(i2, biVar2);
                AppMethodBeat.o(33383);
            }
        });
        long j = biVar.field_msgId;
        d dFm = ((aj) this.yJI.aF(aj.class)).dFm();
        if (dFm != null && dFm.isPlaying() && dFm.yGO == j) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            auVar.zie.setBackgroundResource(R.drawable.a4s);
        } else {
            auVar.zie.setBackgroundResource(R.drawable.a4t);
        }
        if (!(abk == null || ah.isNullOrNil(abk.sta) || abk.stb <= 0 || !ah.isNullOrNil(biVar.field_reserved) || bVar == null)) {
            ae = k.ug(r.Yz());
            by = com.tencent.mm.plugin.subapp.c.h.by(ae, false);
            biVar.jw(ae);
            aw.ZK();
            c.XO().a(biVar.field_msgId, biVar);
            ae = l.a(by, biVar.field_msgId, bVar.sdkVer, bVar.appId, abk.sta, abk.stb, bVar.type, bVar.fgs);
            if (ae != null) {
                Rg = aw.Rg();
                biVar2 = biVar;
                i2 = i;
                anonymousClass2 = new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(33384);
                        ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + mVar.getType());
                        boolean z = false;
                        if (com.tencent.mm.model.ao.a.flx != null) {
                            z = com.tencent.mm.model.ao.a.flx.fl(biVar2.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((com.tencent.mm.plugin.record.b.e) mVar).getMediaId().equals(ae)) {
                            bi ar = bi.ar(biVar2);
                            ar.jv(biVar2.field_reserved);
                            ar.setMsgId(-1);
                            ((aj) ao.this.yJI.aF(aj.class)).dFm().b(i2, ar);
                        }
                        aw.Rg().b(221, ao.this.fQS);
                        ao.this.fQS = null;
                        AppMethodBeat.o(33384);
                    }
                };
                this.fQS = anonymousClass2;
                Rg.a(221, anonymousClass2);
                m eVar = new com.tencent.mm.plugin.record.b.e(ae);
                eVar.ceC();
                aw.Rg().a(eVar, 0);
            }
        }
        if (ah.isNullOrNil(biVar.field_imgPath) && abk.ste > 0) {
            aw.ZK();
            bi Q = c.XO().Q(biVar.field_talker, (long) abk.ste);
            if (!ah.isNullOrNil(Q.field_imgPath)) {
                by = k.ug(r.Yz());
                if (com.tencent.mm.vfs.e.y(com.tencent.mm.plugin.subapp.c.h.by(Q.field_imgPath, false), com.tencent.mm.plugin.subapp.c.h.by(by, false)) >= 0) {
                    biVar.jv(by);
                    aw.ZK();
                    c.XO().a(biVar.field_msgId, biVar);
                }
            }
        }
        if (ah.isNullOrNil(biVar.field_imgPath) && abk != null && !ah.isNullOrNil(abk.csD) && abk.fgo > 0 && this.fQS == null) {
            ae = k.ug(r.Yz());
            by = com.tencent.mm.plugin.subapp.c.h.by(ae, false);
            biVar.jv(ae);
            aw.ZK();
            c.XO().a(biVar.field_msgId, biVar);
            final com.tencent.mm.pluginsdk.model.app.b a = l.a(by, biVar.field_msgId, bVar.sdkVer, bVar.appId, bVar.csD, bVar.fgo);
            ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a.field_mediaSvrId);
            if (a.field_mediaSvrId != null) {
                Rg = aw.Rg();
                anonymousClass2 = new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(33385);
                        ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + mVar.getType());
                        if (((com.tencent.mm.plugin.record.b.e) mVar).getMediaId().equals(a.field_mediaSvrId)) {
                            aw.Rg().b(221, ao.this.fQS);
                            ao.this.fQS = null;
                        }
                        AppMethodBeat.o(33385);
                    }
                };
                this.fQS = anonymousClass2;
                Rg.a(221, anonymousClass2);
                aw.Rg().a(new com.tencent.mm.plugin.record.b.e(a), 0);
            }
        }
        biVar2 = biVar;
        auVar.zif.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33389);
                com.tencent.mm.ui.base.h.a(ao.this.yJI.yTx.getContext(), (int) R.string.f32, (int) R.string.f34, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(33388);
                        aw.Rg().a((int) ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, ao.this.fQS = new f() {
                            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                AppMethodBeat.i(33386);
                                ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + mVar.getType());
                                if (i == 0 && i2 == 0) {
                                    b me;
                                    String str2 = biVar2.field_content;
                                    if (str2 != null) {
                                        me = b.me(str2);
                                    } else {
                                        me = null;
                                    }
                                    if (me != null) {
                                        com.tencent.mm.pluginsdk.model.app.b lZ = am.aUq().lZ(biVar2.field_msgId);
                                        if (lZ != null) {
                                            boolean deleteFile = com.tencent.mm.vfs.e.deleteFile(lZ.field_fileFullPath);
                                            boolean a = am.aUq().a((com.tencent.mm.sdk.e.c) lZ, "msgInfoId");
                                            ab.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(a), Long.valueOf(lZ.field_msgInfoId), lZ.field_mediaSvrId, lZ.field_fileFullPath, bo.dpG());
                                        }
                                    }
                                    bf.fm(biVar2.field_msgId);
                                    Toast.makeText(ao.this.yJI.yTx.getContext(), ao.this.yJI.yTx.getMMResources().getString(R.string.alv), 0).show();
                                }
                                aw.Rg().b((int) ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, ao.this.fQS);
                                ao.this.fQS = null;
                                if (ao.this.qlZ != null) {
                                    ao.this.qlZ.dismiss();
                                }
                                AppMethodBeat.o(33386);
                            }
                        });
                        LinkedList linkedList = new LinkedList();
                        coc coc = new coc();
                        coc.vFI = abk.ssZ;
                        linkedList.add(coc);
                        final m aVar = new com.tencent.mm.plugin.subapp.c.a(linkedList, linkedList.size());
                        aw.Rg().a(aVar, 0);
                        ao aoVar = ao.this;
                        Context context = ao.this.yJI.yTx.getContext();
                        ao.this.yJI.yTx.getMMResources().getString(R.string.tz);
                        aoVar.qlZ = com.tencent.mm.ui.base.h.b(context, ao.this.yJI.yTx.getMMResources().getString(R.string.alw), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(33387);
                                aw.Rg().c(aVar);
                                aw.Rg().b((int) ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, ao.this.fQS);
                                ao.this.fQS = null;
                                if (ao.this.qlZ != null) {
                                    ao.this.qlZ.dismiss();
                                }
                                AppMethodBeat.o(33387);
                            }
                        });
                        AppMethodBeat.o(33388);
                    }
                }, null);
                AppMethodBeat.o(33389);
            }
        });
        auVar.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
        aw.ZK();
        if (c.isSDCardAvailable()) {
            auVar.jPL.setOnLongClickListener(c(this.yJI));
        }
        AppMethodBeat.o(33391);
    }

    public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33392);
        int i = ((ay) view.getTag()).position;
        int aiL = l.aiL(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
        b me = b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
        if (me.fgo <= 0 || (me.fgo > 0 && aiL >= 100)) {
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
        }
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
        }
        AppMethodBeat.o(33392);
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bi biVar) {
        AppMethodBeat.i(33393);
        switch (menuItem.getItemId()) {
            case 111:
                Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                aVar.startActivity(intent);
                AppMethodBeat.o(33393);
                break;
            default:
                AppMethodBeat.o(33393);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bi biVar) {
        return true;
    }
}

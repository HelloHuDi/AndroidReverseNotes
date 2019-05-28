package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;

public final class an {

    public static final class b extends c implements n {
        private int vjo = 3;
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 34) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33367);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nl);
                view.setTag(new c().d(view, false, this.yFW));
            }
            AppMethodBeat.o(33367);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, final bi biVar, String str) {
            AppMethodBeat.i(33368);
            this.yJI = aVar2;
            com.tencent.mm.ui.chatting.viewitems.c.a aVar3 = (c) aVar;
            aVar3.zhC.setFromVoice(false);
            aVar3.zhC.setFromGroup(aVar2.dFx());
            h hVar = (h) aVar2.aF(h.class);
            c.a(hVar, biVar.field_msgId);
            c.a(aVar3, biVar, i, aVar2, false, c(aVar2));
            ag agVar = (ag) aVar2.aF(ag.class);
            CharSequence charSequence = null;
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b bVar = com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform;
            if (an.c(biVar, aVar2)) {
                charSequence = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                if (!bo.isNullOrNil(charSequence)) {
                    bVar = com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.Transformed;
                }
            } else if (agVar.nj(biVar.field_msgId)) {
                charSequence = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                bVar = agVar.ni(biVar.field_msgId);
            }
            if (!bo.isNullOrNil(charSequence) || bVar != com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform) {
                if (aVar3.zgU == null) {
                    aVar3.zgU = (ChattingItemTranslate) aVar3.zgT.inflate();
                    aVar3.zgU.setMinimumWidth(aVar3.zhz - com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 5));
                    aVar3.zgU.init();
                }
                aVar3.zgU.a(charSequence, bVar);
                if (!bo.isNullOrNil(charSequence)) {
                    com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar4 = new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar2.dFx(), i);
                    aVar4.klY = 2;
                    aVar3.zgU.setTag(aVar4);
                    aVar3.zgU.setOnTouchListener(hVar.dCZ());
                    aVar3.zgU.setOnDoubleClickListener(new com.tencent.neattextview.textview.view.NeatTextView.b() {
                        public final boolean fi(View view) {
                            AppMethodBeat.i(33365);
                            c.f(ah.getContext(), charSequence);
                            an.bL(biVar);
                            AppMethodBeat.o(33365);
                            return true;
                        }
                    });
                    aVar3.zgU.setOnLongClickListener(c(aVar2));
                    aVar3.zgU.setVisibility(0);
                }
            } else if (aVar3.zgU != null) {
                aVar3.zgU.setVisibility(8);
            }
            if (c.dHm()) {
                if (aVar3.zhH != null) {
                    aVar3.zhH.setVisibility(8);
                }
                if (aVar3.zci != null) {
                    aVar3.zci.setVisibility(8);
                }
                if (biVar.field_status == 1 || biVar.field_status == 5) {
                    aVar3.zhI.setBackgroundResource(R.drawable.j5);
                    biVar.xZd = true;
                } else {
                    aVar3.zhI.setBackgroundResource(R.drawable.j4);
                    if (aVar3.zci != null && c.a(hVar, biVar.field_msgId)) {
                        if (biVar.xZd) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            aVar3.zhI.startAnimation(alphaAnimation);
                            biVar.xZd = false;
                        }
                        aVar3.zci.setVisibility(0);
                    }
                }
            } else if (aVar3.zhH != null) {
                aVar3.zhH.setVisibility(0);
                if (biVar.field_status >= 2) {
                    aVar3.zhH.setVisibility(8);
                }
            }
            a(i, aVar3, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33368);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33369);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar = (com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a) view.getTag();
                int i = aVar.position;
                if (aVar.klY == 1) {
                    int i2;
                    boolean z;
                    com.tencent.mm.modelvoice.n nVar = new com.tencent.mm.modelvoice.n(biVar.field_content);
                    if (!((nVar.time == 0 && biVar.field_isSend == 0) || (biVar.field_status == 1 && biVar.field_isSend == 1))) {
                        if (((aj) this.yJI.aF(aj.class)).dFo()) {
                            contextMenu.add(i, 120, 0, R.string.aj2);
                        } else {
                            contextMenu.add(i, d.MIC_AVROUND_BLUR, 0, R.string.aj1);
                        }
                    }
                    if (biVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                    }
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                    }
                    if (!biVar.drC() && biVar.drD() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                    }
                    ag agVar = (ag) this.yJI.aF(ag.class);
                    if (an.c(biVar, this.yJI)) {
                        if (bo.isNullOrNil(agVar.C(biVar.field_msgId, biVar.field_imgPath))) {
                            i2 = R.string.amq;
                        } else {
                            i2 = R.string.amo;
                        }
                    } else if (agVar.nj(biVar.field_msgId)) {
                        i2 = R.string.amm;
                    } else {
                        i2 = R.string.amq;
                    }
                    if (t.mZ(biVar.field_talker) && aa.don()) {
                        contextMenu.add(i, 121, 0, i2);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!((nVar.time == 0 && biVar.field_isSend == 0) || ((biVar.field_status == 1 && biVar.field_isSend == 1) || this.yJI.dFy()))) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am9));
                    }
                    if (!(z || !aa.don() || i2 == -1)) {
                        contextMenu.add(i, 121, 0, i2);
                    }
                    AppMethodBeat.o(33369);
                    return true;
                } else if (aVar.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(R.string.dr1));
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(R.string.dcq));
                    }
                    AppMethodBeat.o(33369);
                    return false;
                }
            }
            AppMethodBeat.o(33369);
            return true;
        }

        public final boolean a(final MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, final bi biVar) {
            AppMethodBeat.i(33370);
            final ag agVar = (ag) aVar.aF(ag.class);
            String C;
            switch (menuItem.getItemId()) {
                case 103:
                    ((aj) aVar.aF(aj.class)).bo(biVar);
                    break;
                case d.MIC_AVROUND_BLUR /*119*/:
                    ((aj) aVar.aF(aj.class)).qu(true);
                    AppMethodBeat.o(33370);
                    return true;
                case 120:
                    ((aj) aVar.aF(aj.class)).qu(false);
                    AppMethodBeat.o(33370);
                    return true;
                case 121:
                    an.e(aVar, biVar);
                    if (agVar.dFi()) {
                        com.tencent.mm.ui.base.h.a(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.f3h), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(33366);
                                agVar.dFj();
                                agVar.a(biVar, true, menuItem.getGroupId(), 0);
                                AppMethodBeat.o(33366);
                            }
                        });
                    } else {
                        agVar.a(biVar, true, menuItem.getGroupId(), 0);
                    }
                    com.tencent.mm.modelstat.b.fRa.G(biVar);
                    AppMethodBeat.o(33370);
                    return true;
                case 141:
                    ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
                    C = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                    if (!bo.isNullOrNil(C)) {
                        clipboardManager.setText(C);
                    }
                    an.e(8, biVar);
                    AppMethodBeat.o(33370);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    C = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                    if (biVar.dtr()) {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    aVar.startActivity(intent);
                    an.e(9, biVar);
                    AppMethodBeat.o(33370);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    C = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                    cl clVar = new cl();
                    e.b(clVar, C, 1);
                    clVar.cvA.fragment = aVar.yTx;
                    clVar.cvA.cvH = 43;
                    if (clVar.cvA.cvC != null) {
                        abl abl = clVar.cvA.cvC.wit;
                        if (abl != null) {
                            abl.alD(r.Yz());
                            abl.alE(biVar.field_talker);
                            com.tencent.mm.sdk.b.a.xxA.m(clVar);
                        }
                    } else {
                        ab.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                    }
                    an.e(10, biVar);
                    AppMethodBeat.o(33370);
                    return true;
            }
            AppMethodBeat.o(33370);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33371);
            ay ayVar = (ay) view.getTag();
            com.tencent.mm.modelstat.b.fRa.F(ayVar.cKd);
            an.a(aVar, ayVar);
            ((ag) aVar.aF(ag.class)).OF(2);
            AppMethodBeat.o(33371);
            return true;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33372);
            ((aj) aVar.aF(aj.class)).bo(biVar);
            AppMethodBeat.o(33372);
        }
    }

    public static final class c extends com.tencent.mm.ui.chatting.viewitems.c.a {
        TextView zbU;
        ImageView zci;
        TextView zfC;
        ViewStub zgT;
        ChattingItemTranslate zgU;
        TextView zhA;
        TextView zhB;
        AnimImageView zhC;
        FrameLayout zhD;
        FrameLayout zhE;
        ImageView zhF;
        AnimImageView zhG;
        ProgressBar zhH;
        TextView zhI;
        Animation zhJ;
        int zhz;

        public final com.tencent.mm.ui.chatting.viewitems.c.a d(View view, boolean z, boolean z2) {
            AppMethodBeat.i(33373);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.zhB = (TextView) view.findViewById(R.id.as_);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.zby = (ImageView) view.findViewById(R.id.asb);
            this.zfC = (TextView) view.findViewById(R.id.oe);
            this.zhD = (FrameLayout) view.findViewById(R.id.as9);
            this.zgT = (ViewStub) view.findViewById(R.id.ap4);
            this.zhA = (TextView) view.findViewById(R.id.as6);
            this.zhC = (AnimImageView) view.findViewById(R.id.asa);
            this.zhC.setType(1);
            if (z) {
                this.zhC.setFromVoice(true);
                this.zhC.setFromGroup(z2);
                this.zbU = (TextView) view.findViewById(R.id.anl);
                this.zhG = (AnimImageView) view.findViewById(R.id.as7);
                this.zhG.setFromVoice(true);
                this.zhG.setFromGroup(z2);
                this.zhG.setType(0);
            } else {
                this.zhE = (FrameLayout) view.findViewById(R.id.ath);
                this.zhF = (ImageView) view.findViewById(R.id.ati);
                this.zhH = (ProgressBar) view.findViewById(R.id.atg);
                this.pyf = (ProgressBar) view.findViewById(R.id.at6);
                this.zhI = (TextView) view.findViewById(R.id.atf);
                this.zhC.setFromVoice(false);
                this.zhC.setFromGroup(z2);
                this.zci = (ImageView) view.findViewById(R.id.at7);
            }
            AppMethodBeat.o(33373);
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0336  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x035d  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0140  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x015c  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0336  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0140  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x035d  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x015c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(c cVar, bi biVar, int i, com.tencent.mm.ui.chatting.d.a aVar, boolean z, OnLongClickListener onLongClickListener) {
            AppMethodBeat.i(33374);
            if (cVar == null) {
                AppMethodBeat.o(33374);
                return;
            }
            float f;
            com.tencent.mm.pluginsdk.ui.e dDJ;
            CharSequence arj;
            com.tencent.mm.ui.a.a dzk;
            TextView textView;
            int i2;
            com.tencent.mm.modelvoice.n nVar = new com.tencent.mm.modelvoice.n(biVar.field_content);
            float fY = q.fY(nVar.time);
            com.tencent.mm.ui.chatting.d dFm = ((aj) aVar.aF(aj.class)).dFm();
            if (dFm == null || biVar.field_msgId != dFm.yGO) {
                cVar.zhC.setVisibility(8);
                cVar.zhC.ceT();
            } else {
                cVar.zhC.setVisibility(0);
                cVar.zhC.dzr();
            }
            if (biVar.field_isSend == 0) {
                if (nVar.time == 0) {
                    a(cVar, 8, 0, true);
                    cVar.zhG.ceT();
                    cVar.zhG.setVisibility(8);
                    cVar.zby.setVisibility(8);
                    f = 0.0f;
                    cVar.zhz = com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr(0));
                    cVar.zhB.setWidth(cVar.zhz);
                    cVar.zfC.setText(aVar.yTx.getMMResources().getString(R.string.byu, new Object[]{Integer.valueOf(0)}));
                    cVar.zhC.setWidth(com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr(0)));
                } else if (nVar.time == -1) {
                    a(cVar, 8, 0, true);
                    cVar.zhG.ceT();
                    cVar.zhG.setVisibility(8);
                    cVar.zhz = 80;
                    cVar.zhB.setWidth(80);
                    cVar.zfC.setVisibility(8);
                    cVar.zhC.setWidth(com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr((int) fY)));
                    f = fY;
                } else {
                    a(cVar, 8, 0, true);
                    cVar.zhG.ceT();
                    cVar.zhG.setVisibility(8);
                    cVar.zfC.setVisibility(0);
                    cVar.zhz = com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr((int) fY));
                    cVar.zhB.setWidth(cVar.zhz);
                    cVar.zfC.setText(aVar.yTx.getMMResources().getString(R.string.byu, new Object[]{Integer.valueOf((int) fY)}));
                    cVar.zhC.setWidth(com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr((int) fY)));
                }
                if (1 == biVar.field_isSend) {
                    if (biVar.field_status == 1) {
                        a(cVar, 0, 8, false);
                        cVar.zhE.setVisibility(8);
                        cVar.dHs();
                        fY = f;
                    } else if (nVar.time == -1) {
                        a(cVar, 8, 0, false);
                        cVar.zhB.setWidth(80);
                        cVar.zhz = 80;
                        cVar.zfC.setVisibility(8);
                        cVar.zhE.setVisibility(8);
                        cVar.zhC.setWidth(com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr((int) f)));
                        cVar.dHs();
                        fY = f;
                    } else if (biVar.field_status == 7) {
                        a(cVar, 8, 8, false);
                        cVar.zfC.setVisibility(8);
                        cVar.zhE.setVisibility(0);
                        cVar.dHs();
                        if (cVar.zhF != null) {
                            cVar.zhJ = AnimationUtils.loadAnimation(cVar.mRR.getContext(), R.anim.e2);
                            cVar.zhF.startAnimation(cVar.zhJ);
                        }
                        fY = f;
                    } else {
                        a(cVar, 8, 0, false);
                        cVar.zhE.setVisibility(8);
                        cVar.zfC.setVisibility(0);
                        cVar.dHs();
                        if (nVar.time == 0) {
                            f = 0.0f;
                        }
                        cVar.zhz = com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr((int) f));
                        cVar.zhB.setWidth(cVar.zhz);
                        cVar.zfC.setText(aVar.yTx.getMMResources().getString(R.string.byu, new Object[]{Integer.valueOf((int) f)}));
                        cVar.zhC.setWidth(com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), yr((int) f)));
                    }
                    dDJ = ((com.tencent.mm.ui.chatting.c.b.c) aVar.aF(com.tencent.mm.ui.chatting.c.b.c.class)).dDJ();
                    if (dDJ != null) {
                        if (dDJ.vhc) {
                            cVar.zfC.setShadowLayer(2.0f, 1.2f, 1.2f, dDJ.vhd);
                        } else {
                            cVar.zfC.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        }
                        if (dDJ.vhe) {
                            cVar.zfC.setBackgroundResource(R.drawable.aco);
                        } else {
                            cVar.zfC.setBackgroundColor(0);
                        }
                    }
                    cVar.zhB.setTag(new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar.dFx(), i));
                    cVar.zhB.setOnClickListener(cVar.zbA.d(aVar));
                    cVar.zhB.setOnLongClickListener(onLongClickListener);
                    cVar.zhB.setOnTouchListener(((h) aVar.aF(h.class)).dCZ());
                    if ((biVar.dqI & 1) == 1) {
                        cVar.zhA.setVisibility(0);
                        if (biVar.field_isSend == 0) {
                            cVar.zhC.setBackgroundResource(R.drawable.i5);
                        } else {
                            cVar.zhI.setBackgroundResource(R.drawable.j7);
                            cVar.zhC.setBackgroundResource(R.drawable.j7);
                        }
                    } else {
                        cVar.zhA.setVisibility(8);
                        if (biVar.field_isSend == 0) {
                            cVar.zhC.setBackgroundResource(R.drawable.hz);
                        } else {
                            cVar.zhI.setBackgroundResource(R.drawable.j4);
                            cVar.zhC.setBackgroundResource(R.drawable.j4);
                        }
                    }
                    if (z) {
                        aVar.getTalkerUserName();
                    } else {
                        aVar.dFu();
                    }
                    arj = ((f) aVar.aF(f.class)).arj(aVar.getTalkerUserName());
                    dzk = com.tencent.mm.ui.a.a.a.yqY;
                    textView = cVar.zhB;
                    i2 = (int) fY;
                    if (arj != null) {
                        arj.toString();
                    }
                    dzk.ah(textView, i2);
                    cVar.zfC.setContentDescription(" ");
                    AppMethodBeat.o(33374);
                }
                fY = f;
                dDJ = ((com.tencent.mm.ui.chatting.c.b.c) aVar.aF(com.tencent.mm.ui.chatting.c.b.c.class)).dDJ();
                if (dDJ != null) {
                }
                cVar.zhB.setTag(new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar.dFx(), i));
                cVar.zhB.setOnClickListener(cVar.zbA.d(aVar));
                cVar.zhB.setOnLongClickListener(onLongClickListener);
                cVar.zhB.setOnTouchListener(((h) aVar.aF(h.class)).dCZ());
                if ((biVar.dqI & 1) == 1) {
                }
                if (z) {
                }
                arj = ((f) aVar.aF(f.class)).arj(aVar.getTalkerUserName());
                dzk = com.tencent.mm.ui.a.a.a.yqY;
                textView = cVar.zhB;
                i2 = (int) fY;
                if (arj != null) {
                }
                dzk.ah(textView, i2);
                cVar.zfC.setContentDescription(" ");
                AppMethodBeat.o(33374);
            }
            f = fY;
            if (1 == biVar.field_isSend) {
            }
            fY = f;
            dDJ = ((com.tencent.mm.ui.chatting.c.b.c) aVar.aF(com.tencent.mm.ui.chatting.c.b.c.class)).dDJ();
            if (dDJ != null) {
            }
            cVar.zhB.setTag(new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar.dFx(), i));
            cVar.zhB.setOnClickListener(cVar.zbA.d(aVar));
            cVar.zhB.setOnLongClickListener(onLongClickListener);
            cVar.zhB.setOnTouchListener(((h) aVar.aF(h.class)).dCZ());
            if ((biVar.dqI & 1) == 1) {
            }
            if (z) {
            }
            arj = ((f) aVar.aF(f.class)).arj(aVar.getTalkerUserName());
            dzk = com.tencent.mm.ui.a.a.a.yqY;
            textView = cVar.zhB;
            i2 = (int) fY;
            if (arj != null) {
            }
            dzk.ah(textView, i2);
            cVar.zfC.setContentDescription(" ");
            AppMethodBeat.o(33374);
        }

        static void f(Context context, CharSequence charSequence) {
            AppMethodBeat.i(33375);
            Intent intent = new Intent(context, TextPreviewUI.class);
            intent.putExtra("key_chat_text", charSequence);
            context.startActivity(intent);
            com.tencent.mm.ui.base.b.hL(context);
            AppMethodBeat.o(33375);
        }

        private void dHs() {
            AppMethodBeat.i(33376);
            if (this.zhJ != null) {
                this.zhJ.cancel();
                this.zhJ = null;
            }
            AppMethodBeat.o(33376);
        }

        private static void a(c cVar, int i, int i2, boolean z) {
            AppMethodBeat.i(33377);
            cVar.zby.setVisibility(i2);
            cVar.zfC.setVisibility(i2);
            cVar.zhD.setVisibility(i2);
            if (z) {
                cVar.zhG.setVisibility(i);
                cVar.zbU.setVisibility(i2);
                AppMethodBeat.o(33377);
                return;
            }
            cVar.zhI.setVisibility(i);
            AppMethodBeat.o(33377);
        }

        private static int yr(int i) {
            if (i <= 2) {
                return 80;
            }
            if (i < 10) {
                return ((i - 2) * 9) + 80;
            }
            if (i < 60) {
                return (((i / 10) + 7) * 9) + 80;
            }
            return 204;
        }
    }

    public static final class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private View.OnClickListener zhu;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 34) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33359);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mn);
                view.setTag(new c().d(view, true, this.yFW));
            }
            AppMethodBeat.o(33359);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33360);
            boolean dFx = aVar.dFx();
            AppMethodBeat.o(33360);
            return dFx;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, final bi biVar, String str) {
            AppMethodBeat.i(33361);
            this.yJI = aVar2;
            c cVar = (c) aVar;
            cVar.zhC.setFromVoice(true);
            cVar.zhC.setFromGroup(aVar2.dFx());
            h hVar = (h) aVar2.aF(h.class);
            c.a(hVar, biVar.field_msgId);
            c.a(cVar, biVar, i, aVar2, true, c(aVar2));
            CharSequence charSequence = null;
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b bVar = com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform;
            ag agVar = (ag) aVar2.aF(ag.class);
            if (an.c(biVar, aVar2)) {
                charSequence = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                if (!bo.isNullOrNil(charSequence)) {
                    bVar = com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.Transformed;
                }
            } else if (agVar.nj(biVar.field_msgId)) {
                charSequence = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                bVar = agVar.ni(biVar.field_msgId);
            }
            if (!bo.isNullOrNil(charSequence) || bVar != com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform) {
                if (cVar.zgU == null) {
                    cVar.zgU = (ChattingItemTranslate) cVar.zgT.inflate();
                    cVar.zgU.setMinimumWidth(cVar.zhz - com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 5));
                    cVar.zgU.init();
                }
                cVar.zgU.a(charSequence, bVar);
                com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar3 = new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar2.dFx(), i);
                aVar3.klY = 2;
                cVar.zgU.setTag(aVar3);
                ChattingItemTranslate chattingItemTranslate = cVar.zgU;
                if (this.zhu == null) {
                    this.zhu = new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(33358);
                            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar = (com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a) ((ChattingItemTranslate) view).getTag();
                            if (((ag) a.this.yJI.aF(ag.class)).ni(aVar.cKd.field_msgId) == com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.Transforming) {
                                ((ag) a.this.yJI.aF(ag.class)).a(aVar.cKd, true, aVar.position, 1);
                            }
                            AppMethodBeat.o(33358);
                        }
                    };
                }
                chattingItemTranslate.setOnClickListener(this.zhu);
                if (!bo.isNullOrNil(charSequence)) {
                    cVar.zgU.setOnTouchListener(hVar.dCZ());
                    cVar.zgU.setOnDoubleClickListener(new com.tencent.neattextview.textview.view.NeatTextView.b() {
                        public final boolean fi(View view) {
                            AppMethodBeat.i(33356);
                            c.f(ah.getContext(), charSequence);
                            an.bL(biVar);
                            AppMethodBeat.o(33356);
                            return true;
                        }
                    });
                    cVar.zgU.setOnLongClickListener(c(aVar2));
                    cVar.zgU.setVisibility(0);
                }
            } else if (cVar.zgU != null) {
                cVar.zgU.setVisibility(8);
            }
            com.tencent.mm.modelvoice.n nVar = new com.tencent.mm.modelvoice.n(biVar.field_content);
            if (nVar.time == 0) {
                cVar.zby.setVisibility(8);
            } else {
                int i2;
                com.tencent.mm.ui.chatting.d dFm = ((aj) aVar2.aF(aj.class)).dFm();
                Object obj = ((dFm == null || dFm.yGO != biVar.field_msgId) && !q.K(biVar)) ? null : 1;
                ImageView imageView = cVar.zby;
                if (obj != null) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
                i2 = (int) q.fY(nVar.time);
                if (obj == null) {
                    cVar.zhB.setContentDescription(String.format(aVar2.yTx.getContext().getString(R.string.f2d), new Object[]{Integer.valueOf(i2)}));
                } else {
                    CharSequence arj = ((f) aVar2.aF(f.class)).arj(aVar2.getTalkerUserName());
                    com.tencent.mm.ui.a.a dzk = com.tencent.mm.ui.a.a.a.yqY;
                    TextView textView = cVar.zhB;
                    if (arj != null) {
                        arj.toString();
                    }
                    dzk.ah(textView, i2);
                }
            }
            String str2 = biVar.dJv;
            if (str2 == null || str2.length() == 0) {
                cVar.zbU.setVisibility(8);
                AppMethodBeat.o(33361);
                return;
            }
            cVar.zbU.setVisibility(0);
            b(aVar2, (View) cVar.zbU, (Object) ay.arL(str2));
            AppMethodBeat.o(33361);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33362);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar = (com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a) view.getTag();
                int i = aVar.position;
                if (aVar.klY == 1) {
                    if (!((new com.tencent.mm.modelvoice.n(biVar.field_content).time == 0 && biVar.field_isSend == 0) || (biVar.field_status == 1 && biVar.field_isSend == 1))) {
                        int i2;
                        aw.ZK();
                        Boolean bool = (Boolean) com.tencent.mm.model.c.Ry().get(26, null);
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        if (bool.booleanValue()) {
                            contextMenu.add(i, 120, 0, R.string.aj2);
                        } else {
                            contextMenu.add(i, d.MIC_AVROUND_BLUR, 0, R.string.aj1);
                        }
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(biVar.field_talker);
                        Object obj = (t.nl(biVar.field_talker) || t.nI(biVar.field_talker) || aoO == null || aoO.dsf()) ? null : 1;
                        if (com.tencent.mm.bp.d.afj("favorite")) {
                            contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                        }
                        if (obj != null) {
                            if (z.aeR().lf(2) > 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (!(obj == null || this.yJI.dFy())) {
                                contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                            }
                        }
                        ag agVar = (ag) this.yJI.aF(ag.class);
                        Object obj2 = null;
                        if (an.c(biVar, this.yJI)) {
                            if (bo.isNullOrNil(agVar.C(biVar.field_msgId, biVar.field_imgPath))) {
                                i2 = R.string.amq;
                            } else {
                                i2 = R.string.amo;
                            }
                        } else if (agVar.nj(biVar.field_msgId)) {
                            i2 = R.string.amm;
                        } else {
                            i2 = R.string.amq;
                        }
                        if (t.mZ(biVar.field_talker) && aa.don() && i2 != -1) {
                            contextMenu.add(i, 121, 0, i2);
                            obj2 = 1;
                        }
                        if (!this.yJI.dFy()) {
                            contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am9));
                        }
                        if (obj2 == null && aa.don() && i2 != -1) {
                            contextMenu.add(i, 121, 0, i2);
                        }
                    }
                    AppMethodBeat.o(33362);
                    return true;
                } else if (aVar.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(R.string.dr1));
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(R.string.dcq));
                    }
                    AppMethodBeat.o(33362);
                    return false;
                }
            }
            AppMethodBeat.o(33362);
            return true;
        }

        public final boolean a(final MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, final bi biVar) {
            AppMethodBeat.i(33363);
            final ag agVar = (ag) aVar.aF(ag.class);
            String C;
            switch (menuItem.getItemId()) {
                case 100:
                    ((aj) aVar.aF(aj.class)).bn(biVar);
                    break;
                case 103:
                    ((aj) aVar.aF(aj.class)).bo(biVar);
                    break;
                case d.MIC_AVROUND_BLUR /*119*/:
                    ((aj) aVar.aF(aj.class)).qu(true);
                    AppMethodBeat.o(33363);
                    return true;
                case 120:
                    ((aj) aVar.aF(aj.class)).qu(false);
                    AppMethodBeat.o(33363);
                    return true;
                case 121:
                    an.e(aVar, biVar);
                    if (agVar.dFi()) {
                        com.tencent.mm.ui.base.h.a(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.f3h), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(33357);
                                q.M(biVar);
                                agVar.dFj();
                                agVar.a(biVar, true, menuItem.getGroupId(), 0);
                                AppMethodBeat.o(33357);
                            }
                        });
                    } else {
                        q.M(biVar);
                        agVar.a(biVar, true, menuItem.getGroupId(), 0);
                    }
                    com.tencent.mm.modelstat.b.fRa.G(biVar);
                    AppMethodBeat.o(33363);
                    return true;
                case 141:
                    ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
                    C = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                    if (!bo.isNullOrNil(C)) {
                        clipboardManager.setText(C);
                    }
                    an.e(8, biVar);
                    break;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    C = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                    if (biVar.dtr()) {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    aVar.startActivity(intent);
                    an.e(9, biVar);
                    break;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    C = agVar.C(biVar.field_msgId, biVar.field_imgPath);
                    cl clVar = new cl();
                    e.b(clVar, C, 1);
                    clVar.cvA.fragment = aVar.yTx;
                    clVar.cvA.cvH = 43;
                    if (clVar.cvA.cvC != null) {
                        abl abl = clVar.cvA.cvC.wit;
                        if (abl != null) {
                            abl.alD(biVar.field_talker);
                            abl.alE(r.Yz());
                            com.tencent.mm.sdk.b.a.xxA.m(clVar);
                        }
                    } else {
                        ab.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                    }
                    an.e(10, biVar);
                    break;
            }
            AppMethodBeat.o(33363);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33364);
            ay ayVar = (ay) view.getTag();
            com.tencent.mm.modelstat.b.fRa.F(ayVar.cKd);
            an.a(aVar, ayVar);
            ((ag) aVar.aF(ag.class)).OF(2);
            AppMethodBeat.o(33364);
            return true;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.d.a aVar, ay ayVar) {
        AppMethodBeat.i(33378);
        if (com.tencent.mm.r.a.bJ(aVar.yTx.getContext()) || com.tencent.mm.r.a.bH(aVar.yTx.getContext())) {
            ab.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
            AppMethodBeat.o(33378);
            return;
        }
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (!(ayVar == null || ayVar.cKd == null)) {
                com.tencent.mm.modelvoice.n nVar = new com.tencent.mm.modelvoice.n(ayVar.cKd.field_content);
                if (com.tencent.mm.platformtools.ah.isNullOrNil(ayVar.cKd.field_content) || nVar.time == 0) {
                    Toast.makeText(aVar.yTx.getContext(), R.string.akd, 0).show();
                    AppMethodBeat.o(33378);
                    return;
                }
                com.tencent.mm.ui.chatting.d dFm = ((aj) aVar.aF(aj.class)).dFm();
                if (!(aVar.aF(h.class) == null || dFm == null)) {
                    bi biVar = ayVar.cKd;
                    if (((aj) aVar.aF(aj.class)).dFm().yGO != biVar.field_msgId) {
                        int i;
                        ag agVar = (ag) aVar.aF(ag.class);
                        if (agVar.nm(biVar.field_msgId)) {
                            i = 7;
                        } else if (agVar.nj(biVar.field_msgId)) {
                            i = 6;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            ft ftVar = new ft();
                            ftVar.czK.czL = 1;
                            ftVar.czK.scene = i;
                            ftVar.czK.fileName = biVar.field_imgPath;
                            com.tencent.mm.sdk.b.a.xxA.m(ftVar);
                        }
                    }
                    int i2 = ayVar.position;
                    biVar = ayVar.cKd;
                    if (biVar == null || !biVar.drD()) {
                        AppMethodBeat.o(33378);
                        return;
                    }
                    nVar = new com.tencent.mm.modelvoice.n(biVar.field_content);
                    if ((nVar.time == 0 && biVar.field_isSend == 0) || (biVar.field_status == 1 && biVar.field_isSend == 1)) {
                        AppMethodBeat.o(33378);
                        return;
                    } else if (!(biVar.field_isSend == 0 && nVar.time == -1)) {
                        dFm.dBw();
                        aw.ZK();
                        Boolean bool = (Boolean) com.tencent.mm.model.c.Ry().get(4115, null);
                        if (bool == null || !bool.booleanValue()) {
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(4115, Boolean.TRUE);
                            dFm.dBC();
                            dFm.yGR = com.tencent.mm.ui.base.t.a(dFm.cgL.yTx.getActivity(), dFm.context.getString(R.string.an2), 4000);
                        }
                        if (dFm.mfO.isPlaying() && biVar.field_msgId == dFm.yGO) {
                            dFm.yGX = true;
                            dFm.dBB();
                            AppMethodBeat.o(33378);
                            return;
                        }
                        dFm.au(biVar);
                        if (biVar.field_isSend == 0 && !q.K(biVar)) {
                            dFm.Od(i2 + 1);
                        }
                        dFm.qn(true);
                    }
                }
            }
            AppMethodBeat.o(33378);
            return;
        }
        com.tencent.mm.ui.base.t.hO(aVar.yTx.getContext());
        AppMethodBeat.o(33378);
    }

    static /* synthetic */ boolean c(bi biVar, com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(33379);
        boolean nm = ((ag) aVar.aF(ag.class)).nm(biVar.field_msgId);
        AppMethodBeat.o(33379);
        return nm;
    }

    static /* synthetic */ void bL(bi biVar) {
        AppMethodBeat.i(33380);
        ft ftVar = new ft();
        ftVar.czK.czL = 3;
        ftVar.czK.scene = 1;
        ftVar.czK.fileName = biVar.field_imgPath;
        com.tencent.mm.sdk.b.a.xxA.m(ftVar);
        AppMethodBeat.o(33380);
    }
}

package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.neattextview.textview.view.NeatTextView.C5787b;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45324ft;
import com.tencent.p177mm.p612ui.base.AnimImageView;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.chatting.C36866d;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.TextPreviewUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36134c;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46640ag;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.chatting.viewitems.ChattingItemTranslate.C5370a;
import com.tencent.p177mm.p612ui.chatting.viewitems.ChattingItemTranslate.C5371b;
import com.tencent.p177mm.p612ui.p613a.C5216a;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.p597ui.C14945e;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.an */
public final class C23830an {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.an$b */
    public static final class C23827b extends C5378c implements C5365n {
        private int vjo = 3;
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 34) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33367);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969107);
                view.setTag(new C23831c().mo39632d(view, false, this.yFW));
            }
            AppMethodBeat.m2505o(33367);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, final C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33368);
            this.yJI = c46650a;
            C5379a c5379a2 = (C23831c) c5379a;
            c5379a2.zhC.setFromVoice(false);
            c5379a2.zhC.setFromGroup(c46650a.dFx());
            C15612h c15612h = (C15612h) c46650a.mo74857aF(C15612h.class);
            C5378c.m8136a(c15612h, c7620bi.field_msgId);
            C23831c.m36675a(c5379a2, c7620bi, i, c46650a, false, mo11021c(c46650a));
            C46640ag c46640ag = (C46640ag) c46650a.mo74857aF(C46640ag.class);
            CharSequence charSequence = null;
            C5371b c5371b = C5371b.NoTransform;
            if (C23830an.m36671c(c7620bi, c46650a)) {
                charSequence = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                if (!C5046bo.isNullOrNil(charSequence)) {
                    c5371b = C5371b.Transformed;
                }
            } else if (c46640ag.mo39558nj(c7620bi.field_msgId)) {
                charSequence = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                c5371b = c46640ag.mo39557ni(c7620bi.field_msgId);
            }
            if (!C5046bo.isNullOrNil(charSequence) || c5371b != C5371b.NoTransform) {
                if (c5379a2.zgU == null) {
                    c5379a2.zgU = (ChattingItemTranslate) c5379a2.zgT.inflate();
                    c5379a2.zgU.setMinimumWidth(c5379a2.zhz - C1338a.fromDPToPix(C4996ah.getContext(), 5));
                    c5379a2.zgU.init();
                }
                c5379a2.zgU.mo10995a(charSequence, c5371b);
                if (!C5046bo.isNullOrNil(charSequence)) {
                    C5370a c5370a = new C5370a(c7620bi, c46650a.dFx(), i);
                    c5370a.klY = 2;
                    c5379a2.zgU.setTag(c5370a);
                    c5379a2.zgU.setOnTouchListener(c15612h.dCZ());
                    c5379a2.zgU.setOnDoubleClickListener(new C5787b() {
                        /* renamed from: fi */
                        public final boolean mo11868fi(View view) {
                            AppMethodBeat.m2504i(33365);
                            C23831c.m36676f(C4996ah.getContext(), charSequence);
                            C23830an.m36670bL(c7620bi);
                            AppMethodBeat.m2505o(33365);
                            return true;
                        }
                    });
                    c5379a2.zgU.setOnLongClickListener(mo11021c(c46650a));
                    c5379a2.zgU.setVisibility(0);
                }
            } else if (c5379a2.zgU != null) {
                c5379a2.zgU.setVisibility(8);
            }
            if (C5378c.dHm()) {
                if (c5379a2.zhH != null) {
                    c5379a2.zhH.setVisibility(8);
                }
                if (c5379a2.zci != null) {
                    c5379a2.zci.setVisibility(8);
                }
                if (c7620bi.field_status == 1 || c7620bi.field_status == 5) {
                    c5379a2.zhI.setBackgroundResource(C25738R.drawable.f6590j5);
                    c7620bi.xZd = true;
                } else {
                    c5379a2.zhI.setBackgroundResource(C25738R.drawable.f6589j4);
                    if (c5379a2.zci != null && C5378c.m8136a(c15612h, c7620bi.field_msgId)) {
                        if (c7620bi.xZd) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            c5379a2.zhI.startAnimation(alphaAnimation);
                            c7620bi.xZd = false;
                        }
                        c5379a2.zci.setVisibility(0);
                    }
                }
            } else if (c5379a2.zhH != null) {
                c5379a2.zhH.setVisibility(0);
                if (c7620bi.field_status >= 2) {
                    c5379a2.zhH.setVisibility(8);
                }
            }
            mo11007a(i, c5379a2, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33368);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33369);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C5370a c5370a = (C5370a) view.getTag();
                int i = c5370a.position;
                if (c5370a.klY == 1) {
                    int i2;
                    boolean z;
                    C42230n c42230n = new C42230n(c7620bi.field_content);
                    if (!((c42230n.time == 0 && c7620bi.field_isSend == 0) || (c7620bi.field_status == 1 && c7620bi.field_isSend == 1))) {
                        if (((C15611aj) this.yJI.mo74857aF(C15611aj.class)).dFo()) {
                            contextMenu.add(i, 120, 0, C25738R.string.aj2);
                        } else {
                            contextMenu.add(i, C31128d.MIC_AVROUND_BLUR, 0, C25738R.string.aj1);
                        }
                    }
                    if (c7620bi.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                    }
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    if (!c7620bi.drC() && c7620bi.drD() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                    }
                    C46640ag c46640ag = (C46640ag) this.yJI.mo74857aF(C46640ag.class);
                    if (C23830an.m36671c(c7620bi, this.yJI)) {
                        if (C5046bo.isNullOrNil(c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath))) {
                            i2 = C25738R.string.amq;
                        } else {
                            i2 = C25738R.string.amo;
                        }
                    } else if (c46640ag.mo39558nj(c7620bi.field_msgId)) {
                        i2 = C25738R.string.amm;
                    } else {
                        i2 = C25738R.string.amq;
                    }
                    if (C1855t.m3913mZ(c7620bi.field_talker) && C4988aa.don()) {
                        contextMenu.add(i, 121, 0, i2);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!((c42230n.time == 0 && c7620bi.field_isSend == 0) || ((c7620bi.field_status == 1 && c7620bi.field_isSend == 1) || this.yJI.dFy()))) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am9));
                    }
                    if (!(z || !C4988aa.don() || i2 == -1)) {
                        contextMenu.add(i, 121, 0, i2);
                    }
                    AppMethodBeat.m2505o(33369);
                    return true;
                } else if (c5370a.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(C25738R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(C25738R.string.dr1));
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    AppMethodBeat.m2505o(33369);
                    return false;
                }
            }
            AppMethodBeat.m2505o(33369);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(final MenuItem menuItem, C46650a c46650a, final C7620bi c7620bi) {
            AppMethodBeat.m2504i(33370);
            final C46640ag c46640ag = (C46640ag) c46650a.mo74857aF(C46640ag.class);
            String C;
            switch (menuItem.getItemId()) {
                case 103:
                    ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27792bo(c7620bi);
                    break;
                case C31128d.MIC_AVROUND_BLUR /*119*/:
                    ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27796qu(true);
                    AppMethodBeat.m2505o(33370);
                    return true;
                case 120:
                    ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27796qu(false);
                    AppMethodBeat.m2505o(33370);
                    return true;
                case 121:
                    C23830an.m36673e(c46650a, c7620bi);
                    if (c46640ag.dFi()) {
                        C30379h.m48438a(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.f3h), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(33366);
                                c46640ag.dFj();
                                c46640ag.mo39553a(c7620bi, true, menuItem.getGroupId(), 0);
                                AppMethodBeat.m2505o(33366);
                            }
                        });
                    } else {
                        c46640ag.mo39553a(c7620bi, true, menuItem.getGroupId(), 0);
                    }
                    C45457b.fRa.mo73251G(c7620bi);
                    AppMethodBeat.m2505o(33370);
                    return true;
                case 141:
                    ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
                    C = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                    if (!C5046bo.isNullOrNil(C)) {
                        clipboardManager.setText(C);
                    }
                    C23830an.m36672e(8, c7620bi);
                    AppMethodBeat.m2505o(33370);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    C = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                    if (c7620bi.dtr()) {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    c46650a.startActivity(intent);
                    C23830an.m36672e(9, c7620bi);
                    AppMethodBeat.m2505o(33370);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    C = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                    C45316cl c45316cl = new C45316cl();
                    C40443e.m69375b(c45316cl, C, 1);
                    c45316cl.cvA.fragment = c46650a.yTx;
                    c45316cl.cvA.cvH = 43;
                    if (c45316cl.cvA.cvC != null) {
                        abl abl = c45316cl.cvA.cvC.wit;
                        if (abl != null) {
                            abl.alD(C1853r.m3846Yz());
                            abl.alE(c7620bi.field_talker);
                            C4879a.xxA.mo10055m(c45316cl);
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                    }
                    C23830an.m36672e(10, c7620bi);
                    AppMethodBeat.m2505o(33370);
                    return true;
            }
            AppMethodBeat.m2505o(33370);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33371);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C45457b.fRa.mo73250F(c40814ay.cKd);
            C23830an.m36669a(c46650a, c40814ay);
            ((C46640ag) c46650a.mo74857aF(C46640ag.class)).mo39551OF(2);
            AppMethodBeat.m2505o(33371);
            return true;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33372);
            ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27792bo(c7620bi);
            AppMethodBeat.m2505o(33372);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.an$c */
    public static final class C23831c extends C5379a {
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

        /* renamed from: d */
        public final C5379a mo39632d(View view, boolean z, boolean z2) {
            AppMethodBeat.m2504i(33373);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.zhB = (TextView) view.findViewById(2131822627);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.zby = (ImageView) view.findViewById(2131822629);
            this.zfC = (TextView) view.findViewById(2131821103);
            this.zhD = (FrameLayout) view.findViewById(2131822626);
            this.zgT = (ViewStub) view.findViewById(2131822510);
            this.zhA = (TextView) view.findViewById(2131822623);
            this.zhC = (AnimImageView) view.findViewById(2131822628);
            this.zhC.setType(1);
            if (z) {
                this.zhC.setFromVoice(true);
                this.zhC.setFromGroup(z2);
                this.zbU = (TextView) view.findViewById(2131822454);
                this.zhG = (AnimImageView) view.findViewById(2131822624);
                this.zhG.setFromVoice(true);
                this.zhG.setFromGroup(z2);
                this.zhG.setType(0);
            } else {
                this.zhE = (FrameLayout) view.findViewById(2131822672);
                this.zhF = (ImageView) view.findViewById(2131822673);
                this.zhH = (ProgressBar) view.findViewById(2131822671);
                this.pyf = (ProgressBar) view.findViewById(2131822660);
                this.zhI = (TextView) view.findViewById(2131822670);
                this.zhC.setFromVoice(false);
                this.zhC.setFromGroup(z2);
                this.zci = (ImageView) view.findViewById(2131822661);
            }
            AppMethodBeat.m2505o(33373);
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
        /* renamed from: a */
        public static void m36675a(C23831c c23831c, C7620bi c7620bi, int i, C46650a c46650a, boolean z, OnLongClickListener onLongClickListener) {
            AppMethodBeat.m2504i(33374);
            if (c23831c == null) {
                AppMethodBeat.m2505o(33374);
                return;
            }
            float f;
            C14945e dDJ;
            CharSequence arj;
            C5216a dzk;
            TextView textView;
            int i2;
            C42230n c42230n = new C42230n(c7620bi.field_content);
            float fY = C32850q.m53722fY(c42230n.time);
            C36866d dFm = ((C15611aj) c46650a.mo74857aF(C15611aj.class)).dFm();
            if (dFm == null || c7620bi.field_msgId != dFm.yGO) {
                c23831c.zhC.setVisibility(8);
                c23831c.zhC.ceT();
            } else {
                c23831c.zhC.setVisibility(0);
                c23831c.zhC.dzr();
            }
            if (c7620bi.field_isSend == 0) {
                if (c42230n.time == 0) {
                    C23831c.m36674a(c23831c, 8, 0, true);
                    c23831c.zhG.ceT();
                    c23831c.zhG.setVisibility(8);
                    c23831c.zby.setVisibility(8);
                    f = 0.0f;
                    c23831c.zhz = C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr(0));
                    c23831c.zhB.setWidth(c23831c.zhz);
                    c23831c.zfC.setText(c46650a.yTx.getMMResources().getString(C25738R.string.byu, new Object[]{Integer.valueOf(0)}));
                    c23831c.zhC.setWidth(C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr(0)));
                } else if (c42230n.time == -1) {
                    C23831c.m36674a(c23831c, 8, 0, true);
                    c23831c.zhG.ceT();
                    c23831c.zhG.setVisibility(8);
                    c23831c.zhz = 80;
                    c23831c.zhB.setWidth(80);
                    c23831c.zfC.setVisibility(8);
                    c23831c.zhC.setWidth(C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr((int) fY)));
                    f = fY;
                } else {
                    C23831c.m36674a(c23831c, 8, 0, true);
                    c23831c.zhG.ceT();
                    c23831c.zhG.setVisibility(8);
                    c23831c.zfC.setVisibility(0);
                    c23831c.zhz = C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr((int) fY));
                    c23831c.zhB.setWidth(c23831c.zhz);
                    c23831c.zfC.setText(c46650a.yTx.getMMResources().getString(C25738R.string.byu, new Object[]{Integer.valueOf((int) fY)}));
                    c23831c.zhC.setWidth(C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr((int) fY)));
                }
                if (1 == c7620bi.field_isSend) {
                    if (c7620bi.field_status == 1) {
                        C23831c.m36674a(c23831c, 0, 8, false);
                        c23831c.zhE.setVisibility(8);
                        c23831c.dHs();
                        fY = f;
                    } else if (c42230n.time == -1) {
                        C23831c.m36674a(c23831c, 8, 0, false);
                        c23831c.zhB.setWidth(80);
                        c23831c.zhz = 80;
                        c23831c.zfC.setVisibility(8);
                        c23831c.zhE.setVisibility(8);
                        c23831c.zhC.setWidth(C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr((int) f)));
                        c23831c.dHs();
                        fY = f;
                    } else if (c7620bi.field_status == 7) {
                        C23831c.m36674a(c23831c, 8, 8, false);
                        c23831c.zfC.setVisibility(8);
                        c23831c.zhE.setVisibility(0);
                        c23831c.dHs();
                        if (c23831c.zhF != null) {
                            c23831c.zhJ = AnimationUtils.loadAnimation(c23831c.mRR.getContext(), C25738R.anim.f8420e2);
                            c23831c.zhF.startAnimation(c23831c.zhJ);
                        }
                        fY = f;
                    } else {
                        C23831c.m36674a(c23831c, 8, 0, false);
                        c23831c.zhE.setVisibility(8);
                        c23831c.zfC.setVisibility(0);
                        c23831c.dHs();
                        if (c42230n.time == 0) {
                            f = 0.0f;
                        }
                        c23831c.zhz = C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr((int) f));
                        c23831c.zhB.setWidth(c23831c.zhz);
                        c23831c.zfC.setText(c46650a.yTx.getMMResources().getString(C25738R.string.byu, new Object[]{Integer.valueOf((int) f)}));
                        c23831c.zhC.setWidth(C1338a.fromDPToPix(c46650a.yTx.getContext(), C23831c.m36677yr((int) f)));
                    }
                    dDJ = ((C36134c) c46650a.mo74857aF(C36134c.class)).dDJ();
                    if (dDJ != null) {
                        if (dDJ.vhc) {
                            c23831c.zfC.setShadowLayer(2.0f, 1.2f, 1.2f, dDJ.vhd);
                        } else {
                            c23831c.zfC.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        }
                        if (dDJ.vhe) {
                            c23831c.zfC.setBackgroundResource(C25738R.drawable.aco);
                        } else {
                            c23831c.zfC.setBackgroundColor(0);
                        }
                    }
                    c23831c.zhB.setTag(new C5370a(c7620bi, c46650a.dFx(), i));
                    c23831c.zhB.setOnClickListener(c23831c.zbA.mo11022d(c46650a));
                    c23831c.zhB.setOnLongClickListener(onLongClickListener);
                    c23831c.zhB.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                    if ((c7620bi.dqI & 1) == 1) {
                        c23831c.zhA.setVisibility(0);
                        if (c7620bi.field_isSend == 0) {
                            c23831c.zhC.setBackgroundResource(C25738R.drawable.f6560i5);
                        } else {
                            c23831c.zhI.setBackgroundResource(C25738R.drawable.f6592j7);
                            c23831c.zhC.setBackgroundResource(C25738R.drawable.f6592j7);
                        }
                    } else {
                        c23831c.zhA.setVisibility(8);
                        if (c7620bi.field_isSend == 0) {
                            c23831c.zhC.setBackgroundResource(C25738R.drawable.f6554hz);
                        } else {
                            c23831c.zhI.setBackgroundResource(C25738R.drawable.f6589j4);
                            c23831c.zhC.setBackgroundResource(C25738R.drawable.f6589j4);
                        }
                    }
                    if (z) {
                        c46650a.getTalkerUserName();
                    } else {
                        c46650a.dFu();
                    }
                    arj = ((C7335f) c46650a.mo74857aF(C7335f.class)).arj(c46650a.getTalkerUserName());
                    dzk = C5215a.yqY;
                    textView = c23831c.zhB;
                    i2 = (int) fY;
                    if (arj != null) {
                        arj.toString();
                    }
                    dzk.mo10716ah(textView, i2);
                    c23831c.zfC.setContentDescription(" ");
                    AppMethodBeat.m2505o(33374);
                }
                fY = f;
                dDJ = ((C36134c) c46650a.mo74857aF(C36134c.class)).dDJ();
                if (dDJ != null) {
                }
                c23831c.zhB.setTag(new C5370a(c7620bi, c46650a.dFx(), i));
                c23831c.zhB.setOnClickListener(c23831c.zbA.mo11022d(c46650a));
                c23831c.zhB.setOnLongClickListener(onLongClickListener);
                c23831c.zhB.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                if ((c7620bi.dqI & 1) == 1) {
                }
                if (z) {
                }
                arj = ((C7335f) c46650a.mo74857aF(C7335f.class)).arj(c46650a.getTalkerUserName());
                dzk = C5215a.yqY;
                textView = c23831c.zhB;
                i2 = (int) fY;
                if (arj != null) {
                }
                dzk.mo10716ah(textView, i2);
                c23831c.zfC.setContentDescription(" ");
                AppMethodBeat.m2505o(33374);
            }
            f = fY;
            if (1 == c7620bi.field_isSend) {
            }
            fY = f;
            dDJ = ((C36134c) c46650a.mo74857aF(C36134c.class)).dDJ();
            if (dDJ != null) {
            }
            c23831c.zhB.setTag(new C5370a(c7620bi, c46650a.dFx(), i));
            c23831c.zhB.setOnClickListener(c23831c.zbA.mo11022d(c46650a));
            c23831c.zhB.setOnLongClickListener(onLongClickListener);
            c23831c.zhB.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            if ((c7620bi.dqI & 1) == 1) {
            }
            if (z) {
            }
            arj = ((C7335f) c46650a.mo74857aF(C7335f.class)).arj(c46650a.getTalkerUserName());
            dzk = C5215a.yqY;
            textView = c23831c.zhB;
            i2 = (int) fY;
            if (arj != null) {
            }
            dzk.mo10716ah(textView, i2);
            c23831c.zfC.setContentDescription(" ");
            AppMethodBeat.m2505o(33374);
        }

        /* renamed from: f */
        static void m36676f(Context context, CharSequence charSequence) {
            AppMethodBeat.m2504i(33375);
            Intent intent = new Intent(context, TextPreviewUI.class);
            intent.putExtra("key_chat_text", charSequence);
            context.startActivity(intent);
            C5274b.m8053hL(context);
            AppMethodBeat.m2505o(33375);
        }

        private void dHs() {
            AppMethodBeat.m2504i(33376);
            if (this.zhJ != null) {
                this.zhJ.cancel();
                this.zhJ = null;
            }
            AppMethodBeat.m2505o(33376);
        }

        /* renamed from: a */
        private static void m36674a(C23831c c23831c, int i, int i2, boolean z) {
            AppMethodBeat.m2504i(33377);
            c23831c.zby.setVisibility(i2);
            c23831c.zfC.setVisibility(i2);
            c23831c.zhD.setVisibility(i2);
            if (z) {
                c23831c.zhG.setVisibility(i);
                c23831c.zbU.setVisibility(i2);
                AppMethodBeat.m2505o(33377);
                return;
            }
            c23831c.zhI.setVisibility(i);
            AppMethodBeat.m2505o(33377);
        }

        /* renamed from: yr */
        private static int m36677yr(int i) {
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

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.an$a */
    public static final class C23832a extends C5378c {
        private C46650a yJI;
        private View.OnClickListener zhu;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.an$a$3 */
        class C238343 implements View.OnClickListener {
            C238343() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(33358);
                C5370a c5370a = (C5370a) ((ChattingItemTranslate) view).getTag();
                if (((C46640ag) C23832a.this.yJI.mo74857aF(C46640ag.class)).mo39557ni(c5370a.cKd.field_msgId) == C5371b.Transforming) {
                    ((C46640ag) C23832a.this.yJI.mo74857aF(C46640ag.class)).mo39553a(c5370a.cKd, true, c5370a.position, 1);
                }
                AppMethodBeat.m2505o(33358);
            }
        }

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 34) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33359);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969071);
                view.setTag(new C23831c().mo39632d(view, true, this.yFW));
            }
            AppMethodBeat.m2505o(33359);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            AppMethodBeat.m2504i(33360);
            boolean dFx = c46650a.dFx();
            AppMethodBeat.m2505o(33360);
            return dFx;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, final C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33361);
            this.yJI = c46650a;
            C23831c c23831c = (C23831c) c5379a;
            c23831c.zhC.setFromVoice(true);
            c23831c.zhC.setFromGroup(c46650a.dFx());
            C15612h c15612h = (C15612h) c46650a.mo74857aF(C15612h.class);
            C5378c.m8136a(c15612h, c7620bi.field_msgId);
            C23831c.m36675a(c23831c, c7620bi, i, c46650a, true, mo11021c(c46650a));
            CharSequence charSequence = null;
            C5371b c5371b = C5371b.NoTransform;
            C46640ag c46640ag = (C46640ag) c46650a.mo74857aF(C46640ag.class);
            if (C23830an.m36671c(c7620bi, c46650a)) {
                charSequence = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                if (!C5046bo.isNullOrNil(charSequence)) {
                    c5371b = C5371b.Transformed;
                }
            } else if (c46640ag.mo39558nj(c7620bi.field_msgId)) {
                charSequence = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                c5371b = c46640ag.mo39557ni(c7620bi.field_msgId);
            }
            if (!C5046bo.isNullOrNil(charSequence) || c5371b != C5371b.NoTransform) {
                if (c23831c.zgU == null) {
                    c23831c.zgU = (ChattingItemTranslate) c23831c.zgT.inflate();
                    c23831c.zgU.setMinimumWidth(c23831c.zhz - C1338a.fromDPToPix(C4996ah.getContext(), 5));
                    c23831c.zgU.init();
                }
                c23831c.zgU.mo10995a(charSequence, c5371b);
                C5370a c5370a = new C5370a(c7620bi, c46650a.dFx(), i);
                c5370a.klY = 2;
                c23831c.zgU.setTag(c5370a);
                ChattingItemTranslate chattingItemTranslate = c23831c.zgU;
                if (this.zhu == null) {
                    this.zhu = new C238343();
                }
                chattingItemTranslate.setOnClickListener(this.zhu);
                if (!C5046bo.isNullOrNil(charSequence)) {
                    c23831c.zgU.setOnTouchListener(c15612h.dCZ());
                    c23831c.zgU.setOnDoubleClickListener(new C5787b() {
                        /* renamed from: fi */
                        public final boolean mo11868fi(View view) {
                            AppMethodBeat.m2504i(33356);
                            C23831c.m36676f(C4996ah.getContext(), charSequence);
                            C23830an.m36670bL(c7620bi);
                            AppMethodBeat.m2505o(33356);
                            return true;
                        }
                    });
                    c23831c.zgU.setOnLongClickListener(mo11021c(c46650a));
                    c23831c.zgU.setVisibility(0);
                }
            } else if (c23831c.zgU != null) {
                c23831c.zgU.setVisibility(8);
            }
            C42230n c42230n = new C42230n(c7620bi.field_content);
            if (c42230n.time == 0) {
                c23831c.zby.setVisibility(8);
            } else {
                int i2;
                C36866d dFm = ((C15611aj) c46650a.mo74857aF(C15611aj.class)).dFm();
                Object obj = ((dFm == null || dFm.yGO != c7620bi.field_msgId) && !C32850q.m53704K(c7620bi)) ? null : 1;
                ImageView imageView = c23831c.zby;
                if (obj != null) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
                i2 = (int) C32850q.m53722fY(c42230n.time);
                if (obj == null) {
                    c23831c.zhB.setContentDescription(String.format(c46650a.yTx.getContext().getString(C25738R.string.f2d), new Object[]{Integer.valueOf(i2)}));
                } else {
                    CharSequence arj = ((C7335f) c46650a.mo74857aF(C7335f.class)).arj(c46650a.getTalkerUserName());
                    C5216a dzk = C5215a.yqY;
                    TextView textView = c23831c.zhB;
                    if (arj != null) {
                        arj.toString();
                    }
                    dzk.mo10716ah(textView, i2);
                }
            }
            String str2 = c7620bi.dJv;
            if (str2 == null || str2.length() == 0) {
                c23831c.zbU.setVisibility(8);
                AppMethodBeat.m2505o(33361);
                return;
            }
            c23831c.zbU.setVisibility(0);
            mo11018b(c46650a, (View) c23831c.zbU, (Object) C40814ay.arL(str2));
            AppMethodBeat.m2505o(33361);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33362);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C5370a c5370a = (C5370a) view.getTag();
                int i = c5370a.position;
                if (c5370a.klY == 1) {
                    if (!((new C42230n(c7620bi.field_content).time == 0 && c7620bi.field_isSend == 0) || (c7620bi.field_status == 1 && c7620bi.field_isSend == 1))) {
                        int i2;
                        C9638aw.m17190ZK();
                        Boolean bool = (Boolean) C18628c.m29072Ry().get(26, null);
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        if (bool.booleanValue()) {
                            contextMenu.add(i, 120, 0, C25738R.string.aj2);
                        } else {
                            contextMenu.add(i, C31128d.MIC_AVROUND_BLUR, 0, C25738R.string.aj1);
                        }
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(c7620bi.field_talker);
                        Object obj = (C1855t.m3943nl(c7620bi.field_talker) || C1855t.m3923nI(c7620bi.field_talker) || aoO == null || aoO.dsf()) ? null : 1;
                        if (C25985d.afj("favorite")) {
                            contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                        }
                        if (obj != null) {
                            if (C41747z.aeR().mo43728lf(2) > 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (!(obj == null || this.yJI.dFy())) {
                                contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                            }
                        }
                        C46640ag c46640ag = (C46640ag) this.yJI.mo74857aF(C46640ag.class);
                        Object obj2 = null;
                        if (C23830an.m36671c(c7620bi, this.yJI)) {
                            if (C5046bo.isNullOrNil(c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath))) {
                                i2 = C25738R.string.amq;
                            } else {
                                i2 = C25738R.string.amo;
                            }
                        } else if (c46640ag.mo39558nj(c7620bi.field_msgId)) {
                            i2 = C25738R.string.amm;
                        } else {
                            i2 = C25738R.string.amq;
                        }
                        if (C1855t.m3913mZ(c7620bi.field_talker) && C4988aa.don() && i2 != -1) {
                            contextMenu.add(i, 121, 0, i2);
                            obj2 = 1;
                        }
                        if (!this.yJI.dFy()) {
                            contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am9));
                        }
                        if (obj2 == null && C4988aa.don() && i2 != -1) {
                            contextMenu.add(i, 121, 0, i2);
                        }
                    }
                    AppMethodBeat.m2505o(33362);
                    return true;
                } else if (c5370a.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(C25738R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(C25738R.string.dr1));
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    AppMethodBeat.m2505o(33362);
                    return false;
                }
            }
            AppMethodBeat.m2505o(33362);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(final MenuItem menuItem, C46650a c46650a, final C7620bi c7620bi) {
            AppMethodBeat.m2504i(33363);
            final C46640ag c46640ag = (C46640ag) c46650a.mo74857aF(C46640ag.class);
            String C;
            switch (menuItem.getItemId()) {
                case 100:
                    ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27791bn(c7620bi);
                    break;
                case 103:
                    ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27792bo(c7620bi);
                    break;
                case C31128d.MIC_AVROUND_BLUR /*119*/:
                    ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27796qu(true);
                    AppMethodBeat.m2505o(33363);
                    return true;
                case 120:
                    ((C15611aj) c46650a.mo74857aF(C15611aj.class)).mo27796qu(false);
                    AppMethodBeat.m2505o(33363);
                    return true;
                case 121:
                    C23830an.m36673e(c46650a, c7620bi);
                    if (c46640ag.dFi()) {
                        C30379h.m48438a(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.f3h), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(33357);
                                C32850q.m53706M(c7620bi);
                                c46640ag.dFj();
                                c46640ag.mo39553a(c7620bi, true, menuItem.getGroupId(), 0);
                                AppMethodBeat.m2505o(33357);
                            }
                        });
                    } else {
                        C32850q.m53706M(c7620bi);
                        c46640ag.mo39553a(c7620bi, true, menuItem.getGroupId(), 0);
                    }
                    C45457b.fRa.mo73251G(c7620bi);
                    AppMethodBeat.m2505o(33363);
                    return true;
                case 141:
                    ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
                    C = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                    if (!C5046bo.isNullOrNil(C)) {
                        clipboardManager.setText(C);
                    }
                    C23830an.m36672e(8, c7620bi);
                    break;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    C = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                    if (c7620bi.dtr()) {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", C);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    c46650a.startActivity(intent);
                    C23830an.m36672e(9, c7620bi);
                    break;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    C = c46640ag.mo39550C(c7620bi.field_msgId, c7620bi.field_imgPath);
                    C45316cl c45316cl = new C45316cl();
                    C40443e.m69375b(c45316cl, C, 1);
                    c45316cl.cvA.fragment = c46650a.yTx;
                    c45316cl.cvA.cvH = 43;
                    if (c45316cl.cvA.cvC != null) {
                        abl abl = c45316cl.cvA.cvC.wit;
                        if (abl != null) {
                            abl.alD(c7620bi.field_talker);
                            abl.alE(C1853r.m3846Yz());
                            C4879a.xxA.mo10055m(c45316cl);
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                    }
                    C23830an.m36672e(10, c7620bi);
                    break;
            }
            AppMethodBeat.m2505o(33363);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33364);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C45457b.fRa.mo73250F(c40814ay.cKd);
            C23830an.m36669a(c46650a, c40814ay);
            ((C46640ag) c46650a.mo74857aF(C46640ag.class)).mo39551OF(2);
            AppMethodBeat.m2505o(33364);
            return true;
        }
    }

    /* renamed from: a */
    public static void m36669a(C46650a c46650a, C40814ay c40814ay) {
        AppMethodBeat.m2504i(33378);
        if (C35973a.m59179bJ(c46650a.yTx.getContext()) || C35973a.m59177bH(c46650a.yTx.getContext())) {
            C4990ab.m7410d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
            AppMethodBeat.m2505o(33378);
            return;
        }
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            if (!(c40814ay == null || c40814ay.cKd == null)) {
                C42230n c42230n = new C42230n(c40814ay.cKd.field_content);
                if (C42252ah.isNullOrNil(c40814ay.cKd.field_content) || c42230n.time == 0) {
                    Toast.makeText(c46650a.yTx.getContext(), C25738R.string.akd, 0).show();
                    AppMethodBeat.m2505o(33378);
                    return;
                }
                C36866d dFm = ((C15611aj) c46650a.mo74857aF(C15611aj.class)).dFm();
                if (!(c46650a.mo74857aF(C15612h.class) == null || dFm == null)) {
                    C7620bi c7620bi = c40814ay.cKd;
                    if (((C15611aj) c46650a.mo74857aF(C15611aj.class)).dFm().yGO != c7620bi.field_msgId) {
                        int i;
                        C46640ag c46640ag = (C46640ag) c46650a.mo74857aF(C46640ag.class);
                        if (c46640ag.mo39559nm(c7620bi.field_msgId)) {
                            i = 7;
                        } else if (c46640ag.mo39558nj(c7620bi.field_msgId)) {
                            i = 6;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            C45324ft c45324ft = new C45324ft();
                            c45324ft.czK.czL = 1;
                            c45324ft.czK.scene = i;
                            c45324ft.czK.fileName = c7620bi.field_imgPath;
                            C4879a.xxA.mo10055m(c45324ft);
                        }
                    }
                    int i2 = c40814ay.position;
                    c7620bi = c40814ay.cKd;
                    if (c7620bi == null || !c7620bi.drD()) {
                        AppMethodBeat.m2505o(33378);
                        return;
                    }
                    c42230n = new C42230n(c7620bi.field_content);
                    if ((c42230n.time == 0 && c7620bi.field_isSend == 0) || (c7620bi.field_status == 1 && c7620bi.field_isSend == 1)) {
                        AppMethodBeat.m2505o(33378);
                        return;
                    } else if (!(c7620bi.field_isSend == 0 && c42230n.time == -1)) {
                        dFm.dBw();
                        C9638aw.m17190ZK();
                        Boolean bool = (Boolean) C18628c.m29072Ry().get(4115, null);
                        if (bool == null || !bool.booleanValue()) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(4115, Boolean.TRUE);
                            dFm.dBC();
                            dFm.yGR = C23639t.m36486a(dFm.cgL.yTx.getActivity(), dFm.context.getString(C25738R.string.an2), 4000);
                        }
                        if (dFm.mfO.isPlaying() && c7620bi.field_msgId == dFm.yGO) {
                            dFm.yGX = true;
                            dFm.dBB();
                            AppMethodBeat.m2505o(33378);
                            return;
                        }
                        dFm.mo58726au(c7620bi);
                        if (c7620bi.field_isSend == 0 && !C32850q.m53704K(c7620bi)) {
                            dFm.mo58723Od(i2 + 1);
                        }
                        dFm.mo58735qn(true);
                    }
                }
            }
            AppMethodBeat.m2505o(33378);
            return;
        }
        C23639t.m36492hO(c46650a.yTx.getContext());
        AppMethodBeat.m2505o(33378);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m36671c(C7620bi c7620bi, C46650a c46650a) {
        AppMethodBeat.m2504i(33379);
        boolean nm = ((C46640ag) c46650a.mo74857aF(C46640ag.class)).mo39559nm(c7620bi.field_msgId);
        AppMethodBeat.m2505o(33379);
        return nm;
    }

    /* renamed from: bL */
    static /* synthetic */ void m36670bL(C7620bi c7620bi) {
        AppMethodBeat.m2504i(33380);
        C45324ft c45324ft = new C45324ft();
        c45324ft.czK.czL = 3;
        c45324ft.czK.scene = 1;
        c45324ft.czK.fileName = c7620bi.field_imgPath;
        C4879a.xxA.mo10055m(c45324ft);
        AppMethodBeat.m2505o(33380);
    }
}

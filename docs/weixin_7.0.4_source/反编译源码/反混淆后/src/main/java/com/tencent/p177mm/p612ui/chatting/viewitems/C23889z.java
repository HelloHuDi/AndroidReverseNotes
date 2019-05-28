package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1186bq.C18114a;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.view.C31128d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.z */
public final class C23889z {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.z$b */
    static class C23888b extends C5379a {
        TextView gGA;
        TextView zeH;
        TextView zfC;
        View zfD;
        ImageView zfE;
        ImageView zfF;
        TextView zfG;
        TextView zfH;

        C23888b() {
        }

        /* renamed from: fe */
        public final C5379a mo39649fe(View view) {
            AppMethodBeat.m2504i(33206);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zeH = (TextView) view.findViewById(2131822594);
            this.gGA = (TextView) view.findViewById(2131822593);
            this.zfC = (TextView) view.findViewById(2131821103);
            this.jPL = view.findViewById(2131822515);
            this.zfH = (TextView) view.findViewById(2131822602);
            this.zfD = view.findViewById(2131822603);
            this.zfE = (ImageView) view.findViewById(2131822604);
            this.zfF = (ImageView) view.findViewById(2131822606);
            this.zfG = (TextView) view.findViewById(2131822605);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            AppMethodBeat.m2505o(33206);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.z$a */
    public static class C23890a extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (i == 37 || i == 40) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33203);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969064);
                view.setTag(new C23888b().mo39649fe(view));
            }
            AppMethodBeat.m2505o(33203);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33204);
            this.yJI = c46650a;
            C23888b c23888b = (C23888b) c5379a;
            if (c7620bi.getType() == 37) {
                C9638aw.m17190ZK();
                C5138d Rm = C18628c.m29080XO().mo15259Rm(c7620bi.field_content);
                if (Rm == null || Rm.svN == null || Rm.svN.length() <= 0) {
                    C4990ab.m7412e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
                    AppMethodBeat.m2505o(33204);
                    return;
                }
                C41730b.m73489U(Rm.svN, Rm.xZh);
                if (C1855t.m3912mY(Rm.svN)) {
                    c23888b.zfE.setVisibility(8);
                    c23888b.zfF.setVisibility(8);
                    c23888b.zfG.setVisibility(0);
                    c23888b.zfD.setBackgroundColor(16777215);
                    c23888b.zfG.setText(c46650a.yTx.getMMResources().getString(C25738R.string.c11));
                } else {
                    c23888b.zfE.setVisibility(0);
                    c23888b.zfF.setVisibility(0);
                    c23888b.zfG.setVisibility(0);
                    c23888b.zfD.setBackgroundResource(C25738R.drawable.f6575in);
                    c23888b.zfG.setText(c46650a.yTx.getMMResources().getString(C25738R.string.c10));
                }
                switch (Rm.scene) {
                    case 13:
                        C18817a vT = C32923a.getAddrUploadStg().mo34089vT(Rm.svN);
                        if (vT != null && vT.apA() != null && !vT.apA().equals("")) {
                            c23888b.zfH.setVisibility(0);
                            c23888b.zfH.setText(c46650a.yTx.getMMResources().getString(C25738R.string.akq, new Object[]{vT.apA()}));
                            break;
                        }
                        c23888b.zfH.setVisibility(8);
                        break;
                        break;
                    case 18:
                        c23888b.zeH.setText(C25738R.string.al2);
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    case 29:
                        c23888b.zeH.setText(C25738R.string.al4);
                        break;
                    case 25:
                        c23888b.zeH.setText(C25738R.string.akx);
                        break;
                    case 30:
                        c23888b.zeH.setText(C25738R.string.dgm);
                        break;
                    default:
                        c23888b.zeH.setText(C25738R.string.aky);
                        break;
                }
                c23888b.gGA.setText(C44089j.m79293b(c46650a.yTx.getContext(), Rm.getDisplayName(), c23888b.gGA.getTextSize()));
                C5378c.m8146v(c23888b.zbv, Rm.svN);
                c23888b.zfC.setVisibility(0);
                if (Rm.content == null || Rm.content.trim().equals("")) {
                    c23888b.zfC.setText(c46650a.yTx.getMMResources().getString(C25738R.string.al3));
                } else {
                    c23888b.zfC.setText(Rm.content);
                }
            } else if (c7620bi.getType() == 40) {
                C9638aw.m17190ZK();
                C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
                if (Rn == null || Rn.svN == null || Rn.svN.length() <= 0) {
                    C4990ab.m7412e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
                    AppMethodBeat.m2505o(33204);
                    return;
                }
                C41730b.m73489U(Rn.svN, Rn.xZh);
                if (C1855t.m3912mY(Rn.svN)) {
                    c23888b.zfE.setVisibility(8);
                    c23888b.zfF.setVisibility(8);
                    c23888b.zfG.setVisibility(0);
                    c23888b.zfD.setBackgroundColor(16777215);
                    c23888b.zfG.setText(c46650a.yTx.getMMResources().getString(C25738R.string.c11));
                } else {
                    c23888b.zfE.setVisibility(0);
                    c23888b.zfF.setVisibility(0);
                    c23888b.zfG.setVisibility(0);
                    c23888b.zfD.setBackgroundResource(C25738R.drawable.f6575in);
                    c23888b.zfG.setText(c46650a.yTx.getMMResources().getString(C25738R.string.c10));
                }
                switch (Rn.scene) {
                    case 4:
                        c23888b.zeH.setText(C25738R.string.akk);
                        c23888b.zfC.setText(C25738R.string.akl);
                        CharSequence dtZ = Rn.dtZ();
                        if (dtZ == null) {
                            dtZ = Rn.getDisplayName();
                        }
                        c23888b.gGA.setText(C44089j.m79293b(c46650a.yTx.getContext(), dtZ, c23888b.gGA.getTextSize()));
                        break;
                    case 10:
                    case 11:
                        c23888b.zeH.setText(C25738R.string.akp);
                        String wf = C38033l.m64351wf(Rn.xZi);
                        if (C42252ah.isNullOrNil(wf)) {
                            wf = C38033l.m64351wf(Rn.xZj);
                        }
                        c23888b.zfC.setText(c46650a.yTx.getMMResources().getString(C25738R.string.akq, new Object[]{wf}));
                        c23888b.gGA.setText(C44089j.m79293b(c46650a.yTx.getContext(), Rn.getDisplayName(), c23888b.gGA.getTextSize()));
                        break;
                    case 31:
                        c23888b.zeH.setText(C25738R.string.al0);
                        c23888b.zfC.setText(C25738R.string.al1);
                        c23888b.gGA.setText(C44089j.m79293b(c46650a.yTx.getContext(), Rn.getDisplayName(), c23888b.gGA.getTextSize()));
                        break;
                    case 32:
                        c23888b.zeH.setText(C25738R.string.akw);
                        c23888b.zfC.setText(C25738R.string.akv);
                        c23888b.gGA.setText(C44089j.m79293b(c46650a.yTx.getContext(), Rn.getDisplayName(), c23888b.gGA.getTextSize()));
                        break;
                    default:
                        C4990ab.m7411d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", Integer.valueOf(Rn.scene));
                        c23888b.zeH.setText(C25738R.string.akt);
                        c23888b.zfC.setText(C25738R.string.aku);
                        c23888b.gGA.setText(C44089j.m79293b(c46650a.yTx.getContext(), Rn.getDisplayName(), c23888b.gGA.getTextSize()));
                        break;
                }
                C5378c.m8146v(c23888b.zbv, Rn.svN);
            } else {
                C4990ab.m7420w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + c7620bi.getType());
            }
            c23888b.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c23888b.jPL.setOnClickListener(mo11022d(c46650a));
            c23888b.jPL.setOnLongClickListener(mo11021c(c46650a));
            c23888b.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            AppMethodBeat.m2505o(33204);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33205);
            String str;
            if (c7620bi.getType() == 37) {
                str = c7620bi.field_content;
                C4990ab.m7420w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
                if (str != null && str.length() > 0) {
                    C9638aw.m17190ZK();
                    C5138d Rm = C18628c.m29080XO().mo15259Rm(str);
                    if (Rm != null) {
                        Assert.assertTrue(Rm.svN.length() > 0);
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(Rm.svN);
                        Intent intent = new Intent();
                        if (aoO == null || ((int) aoO.ewQ) <= 0 || !C7486a.m12942jh(aoO.field_type)) {
                            intent.putExtra("Verify_ticket", Rm.mGZ);
                            intent.putExtra("User_Verify", true);
                            intent.putExtra("Contact_User", Rm.svN);
                            intent.putExtra("Contact_Alias", Rm.dFl);
                            intent.putExtra("Contact_Nick", Rm.nickname);
                            intent.putExtra("Contact_QuanPin", Rm.gwG);
                            intent.putExtra("Contact_PyInitial", Rm.gwF);
                            intent.putExtra("Contact_Sex", Rm.dtS);
                            intent.putExtra("Contact_Signature", Rm.signature);
                            intent.putExtra("Contact_Scene", Rm.scene);
                            intent.putExtra("Contact_FMessageCard", true);
                            intent.putExtra("Contact_City", Rm.getCity());
                            intent.putExtra("Contact_Province", Rm.getProvince());
                            intent.putExtra("Contact_Mobile_MD5", Rm.xZi);
                            intent.putExtra("Contact_full_Mobile_MD5", Rm.xZj);
                            intent.putExtra("Contact_KSnsIFlag", Rm.xZv);
                            intent.putExtra("Contact_KSnsBgUrl", Rm.xZw);
                        } else {
                            intent.putExtra("Contact_User", aoO.field_username);
                            C36249e.m59677a(intent, aoO.field_username);
                        }
                        str = Rm.content;
                        if (C42252ah.nullAsNil(str).length() <= 0) {
                            switch (Rm.scene) {
                                case 18:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                case 29:
                                    str = this.yJI.yTx.getMMResources().getString(C25738R.string.al3);
                                    break;
                                default:
                                    str = this.yJI.yTx.getMMResources().getString(C25738R.string.akz);
                                    break;
                            }
                        }
                        intent.putExtra("Contact_Content", str);
                        intent.putExtra("Contact_verify_Scene", Rm.scene);
                        intent.putExtra("Contact_Uin", Rm.pnz);
                        intent.putExtra("Contact_QQNick", Rm.gwH);
                        intent.putExtra("Contact_Mobile_MD5", Rm.xZi);
                        intent.putExtra("User_From_Fmessage", true);
                        intent.putExtra("Contact_from_msgType", 37);
                        intent.putExtra("Contact_KSnsIFlag", Rm.xZv);
                        intent.putExtra("Contact_KSnsBgUrl", Rm.xZw);
                        C25985d.m41467b(this.yJI.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        C18114a.m28535Lu(Rm.scene);
                    }
                }
            } else if (c7620bi.getType() == 40) {
                str = c7620bi.field_content;
                C9638aw.m17190ZK();
                C5135a Rn = C18628c.m29080XO().mo15260Rn(str);
                if (Rn != null && Rn.svN.length() > 0) {
                    C18114a.m28535Lu(Rn.scene);
                    C9638aw.m17190ZK();
                    C7616ad aoO2 = C18628c.m29078XM().aoO(Rn.svN);
                    if (aoO2 != null && ((int) aoO2.ewQ) > 0 && C7486a.m12942jh(aoO2.field_type)) {
                        C36249e.m59673a(this.yJI.yTx.getContext(), aoO2, Rn);
                    } else if (Rn.pnz > 0 || (C42252ah.isNullOrNil(Rn.xZi) && C42252ah.isNullOrNil(Rn.xZj))) {
                        C36249e.m59675a(this.yJI.yTx.getContext(), Rn);
                    } else {
                        C18817a vW = C32923a.getAddrUploadStg().mo34092vW(Rn.xZi);
                        if (vW == null || vW.mo34067Aq() == null || vW.mo34067Aq().length() <= 0) {
                            vW = C32923a.getAddrUploadStg().mo34092vW(Rn.xZj);
                            if (vW == null || vW.mo34067Aq() == null || vW.mo34067Aq().length() <= 0) {
                                if (aoO2 == null || ((int) aoO2.ewQ) <= 0) {
                                    C36249e.m59675a(this.yJI.yTx.getContext(), Rn);
                                } else {
                                    C36249e.m59673a(this.yJI.yTx.getContext(), aoO2, Rn);
                                }
                                C4990ab.m7412e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + Rn.xZi + " fullMD5:" + Rn.xZj);
                            }
                        }
                        if (vW.getUsername() == null || vW.getUsername().length() <= 0) {
                            vW.username = Rn.svN;
                            vW.bJt = 128;
                            if (C32923a.getAddrUploadStg().mo34084a(vW.mo34067Aq(), vW) == -1) {
                                C4990ab.m7412e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                            }
                        }
                        C36249e.m59675a(this.yJI.yTx.getContext(), Rn);
                    }
                }
            }
            AppMethodBeat.m2505o(33205);
            return true;
        }
    }
}

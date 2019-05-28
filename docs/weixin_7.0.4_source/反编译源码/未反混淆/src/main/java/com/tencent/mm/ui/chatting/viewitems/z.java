package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class z {

    static class b extends com.tencent.mm.ui.chatting.viewitems.c.a {
        TextView gGA;
        TextView zeH;
        TextView zfC;
        View zfD;
        ImageView zfE;
        ImageView zfF;
        TextView zfG;
        TextView zfH;

        b() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a fe(View view) {
            AppMethodBeat.i(33206);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zeH = (TextView) view.findViewById(R.id.ard);
            this.gGA = (TextView) view.findViewById(R.id.arc);
            this.zfC = (TextView) view.findViewById(R.id.oe);
            this.jPL = view.findViewById(R.id.ap9);
            this.zfH = (TextView) view.findViewById(R.id.arl);
            this.zfD = view.findViewById(R.id.arm);
            this.zfE = (ImageView) view.findViewById(R.id.arn);
            this.zfF = (ImageView) view.findViewById(R.id.arp);
            this.zfG = (TextView) view.findViewById(R.id.aro);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            AppMethodBeat.o(33206);
            return this;
        }
    }

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (i == 37 || i == 40) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33203);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mh);
                view.setTag(new b().fe(view));
            }
            AppMethodBeat.o(33203);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33204);
            this.yJI = aVar2;
            b bVar = (b) aVar;
            if (biVar.getType() == 37) {
                aw.ZK();
                d Rm = c.XO().Rm(biVar.field_content);
                if (Rm == null || Rm.svN == null || Rm.svN.length() <= 0) {
                    ab.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
                    AppMethodBeat.o(33204);
                    return;
                }
                com.tencent.mm.ah.b.U(Rm.svN, Rm.xZh);
                if (t.mY(Rm.svN)) {
                    bVar.zfE.setVisibility(8);
                    bVar.zfF.setVisibility(8);
                    bVar.zfG.setVisibility(0);
                    bVar.zfD.setBackgroundColor(16777215);
                    bVar.zfG.setText(aVar2.yTx.getMMResources().getString(R.string.c11));
                } else {
                    bVar.zfE.setVisibility(0);
                    bVar.zfF.setVisibility(0);
                    bVar.zfG.setVisibility(0);
                    bVar.zfD.setBackgroundResource(R.drawable.in);
                    bVar.zfG.setText(aVar2.yTx.getMMResources().getString(R.string.c10));
                }
                switch (Rm.scene) {
                    case 13:
                        com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(Rm.svN);
                        if (vT != null && vT.apA() != null && !vT.apA().equals("")) {
                            bVar.zfH.setVisibility(0);
                            bVar.zfH.setText(aVar2.yTx.getMMResources().getString(R.string.akq, new Object[]{vT.apA()}));
                            break;
                        }
                        bVar.zfH.setVisibility(8);
                        break;
                        break;
                    case 18:
                        bVar.zeH.setText(R.string.al2);
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    case 29:
                        bVar.zeH.setText(R.string.al4);
                        break;
                    case 25:
                        bVar.zeH.setText(R.string.akx);
                        break;
                    case 30:
                        bVar.zeH.setText(R.string.dgm);
                        break;
                    default:
                        bVar.zeH.setText(R.string.aky);
                        break;
                }
                bVar.gGA.setText(j.b(aVar2.yTx.getContext(), Rm.getDisplayName(), bVar.gGA.getTextSize()));
                c.v(bVar.zbv, Rm.svN);
                bVar.zfC.setVisibility(0);
                if (Rm.content == null || Rm.content.trim().equals("")) {
                    bVar.zfC.setText(aVar2.yTx.getMMResources().getString(R.string.al3));
                } else {
                    bVar.zfC.setText(Rm.content);
                }
            } else if (biVar.getType() == 40) {
                aw.ZK();
                com.tencent.mm.storage.bi.a Rn = c.XO().Rn(biVar.field_content);
                if (Rn == null || Rn.svN == null || Rn.svN.length() <= 0) {
                    ab.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
                    AppMethodBeat.o(33204);
                    return;
                }
                com.tencent.mm.ah.b.U(Rn.svN, Rn.xZh);
                if (t.mY(Rn.svN)) {
                    bVar.zfE.setVisibility(8);
                    bVar.zfF.setVisibility(8);
                    bVar.zfG.setVisibility(0);
                    bVar.zfD.setBackgroundColor(16777215);
                    bVar.zfG.setText(aVar2.yTx.getMMResources().getString(R.string.c11));
                } else {
                    bVar.zfE.setVisibility(0);
                    bVar.zfF.setVisibility(0);
                    bVar.zfG.setVisibility(0);
                    bVar.zfD.setBackgroundResource(R.drawable.in);
                    bVar.zfG.setText(aVar2.yTx.getMMResources().getString(R.string.c10));
                }
                switch (Rn.scene) {
                    case 4:
                        bVar.zeH.setText(R.string.akk);
                        bVar.zfC.setText(R.string.akl);
                        CharSequence dtZ = Rn.dtZ();
                        if (dtZ == null) {
                            dtZ = Rn.getDisplayName();
                        }
                        bVar.gGA.setText(j.b(aVar2.yTx.getContext(), dtZ, bVar.gGA.getTextSize()));
                        break;
                    case 10:
                    case 11:
                        bVar.zeH.setText(R.string.akp);
                        String wf = l.wf(Rn.xZi);
                        if (ah.isNullOrNil(wf)) {
                            wf = l.wf(Rn.xZj);
                        }
                        bVar.zfC.setText(aVar2.yTx.getMMResources().getString(R.string.akq, new Object[]{wf}));
                        bVar.gGA.setText(j.b(aVar2.yTx.getContext(), Rn.getDisplayName(), bVar.gGA.getTextSize()));
                        break;
                    case 31:
                        bVar.zeH.setText(R.string.al0);
                        bVar.zfC.setText(R.string.al1);
                        bVar.gGA.setText(j.b(aVar2.yTx.getContext(), Rn.getDisplayName(), bVar.gGA.getTextSize()));
                        break;
                    case 32:
                        bVar.zeH.setText(R.string.akw);
                        bVar.zfC.setText(R.string.akv);
                        bVar.gGA.setText(j.b(aVar2.yTx.getContext(), Rn.getDisplayName(), bVar.gGA.getTextSize()));
                        break;
                    default:
                        ab.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", Integer.valueOf(Rn.scene));
                        bVar.zeH.setText(R.string.akt);
                        bVar.zfC.setText(R.string.aku);
                        bVar.gGA.setText(j.b(aVar2.yTx.getContext(), Rn.getDisplayName(), bVar.gGA.getTextSize()));
                        break;
                }
                c.v(bVar.zbv, Rn.svN);
            } else {
                ab.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + biVar.getType());
            }
            bVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            bVar.jPL.setOnClickListener(d(aVar2));
            bVar.jPL.setOnLongClickListener(c(aVar2));
            bVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            AppMethodBeat.o(33204);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33205);
            String str;
            if (biVar.getType() == 37) {
                str = biVar.field_content;
                ab.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
                if (str != null && str.length() > 0) {
                    aw.ZK();
                    d Rm = c.XO().Rm(str);
                    if (Rm != null) {
                        Assert.assertTrue(Rm.svN.length() > 0);
                        aw.ZK();
                        ad aoO = c.XM().aoO(Rm.svN);
                        Intent intent = new Intent();
                        if (aoO == null || ((int) aoO.ewQ) <= 0 || !com.tencent.mm.n.a.jh(aoO.field_type)) {
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
                            e.a(intent, aoO.field_username);
                        }
                        str = Rm.content;
                        if (ah.nullAsNil(str).length() <= 0) {
                            switch (Rm.scene) {
                                case 18:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                case 29:
                                    str = this.yJI.yTx.getMMResources().getString(R.string.al3);
                                    break;
                                default:
                                    str = this.yJI.yTx.getMMResources().getString(R.string.akz);
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
                        com.tencent.mm.bp.d.b(this.yJI.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        com.tencent.mm.bq.a.Lu(Rm.scene);
                    }
                }
            } else if (biVar.getType() == 40) {
                str = biVar.field_content;
                aw.ZK();
                com.tencent.mm.storage.bi.a Rn = c.XO().Rn(str);
                if (Rn != null && Rn.svN.length() > 0) {
                    com.tencent.mm.bq.a.Lu(Rn.scene);
                    aw.ZK();
                    ad aoO2 = c.XM().aoO(Rn.svN);
                    if (aoO2 != null && ((int) aoO2.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO2.field_type)) {
                        e.a(this.yJI.yTx.getContext(), aoO2, Rn);
                    } else if (Rn.pnz > 0 || (ah.isNullOrNil(Rn.xZi) && ah.isNullOrNil(Rn.xZj))) {
                        e.a(this.yJI.yTx.getContext(), Rn);
                    } else {
                        com.tencent.mm.plugin.account.friend.a.a vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(Rn.xZi);
                        if (vW == null || vW.Aq() == null || vW.Aq().length() <= 0) {
                            vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(Rn.xZj);
                            if (vW == null || vW.Aq() == null || vW.Aq().length() <= 0) {
                                if (aoO2 == null || ((int) aoO2.ewQ) <= 0) {
                                    e.a(this.yJI.yTx.getContext(), Rn);
                                } else {
                                    e.a(this.yJI.yTx.getContext(), aoO2, Rn);
                                }
                                ab.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + Rn.xZi + " fullMD5:" + Rn.xZj);
                            }
                        }
                        if (vW.getUsername() == null || vW.getUsername().length() <= 0) {
                            vW.username = Rn.svN;
                            vW.bJt = 128;
                            if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(vW.Aq(), vW) == -1) {
                                ab.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                            }
                        }
                        e.a(this.yJI.yTx.getContext(), Rn);
                    }
                }
            }
            AppMethodBeat.o(33205);
            return true;
        }
    }
}

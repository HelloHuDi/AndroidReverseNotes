package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Iterator;

public final class y {

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected d zfw;
        private c zfx;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 47) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33190);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mf);
                view.setTag(new e().z(view, true));
            }
            AppMethodBeat.o(33190);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33191);
            if (biVar == null) {
                ab.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", str);
                AppMethodBeat.o(33191);
                return;
            }
            this.yJI = aVar2;
            EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
            e eVar = (e) aVar;
            if (Jd == null) {
                boolean z;
                String str2 = "MicroMsg.emoji.ChattingItemEmojiFrom";
                String str3 = "filling: db emoji %s, %s, msgId %s";
                Object[] objArr = new Object[3];
                objArr[0] = biVar.field_imgPath;
                if (Jd == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Long.valueOf(biVar.field_msgId);
                ab.i(str2, str3, objArr);
            }
            if (Jd != null) {
                Jd.talker = biVar.field_talker;
                ap aps = ap.aps(biVar.field_content);
                eVar.zdM.a(Jd, biVar.field_msgId, aps);
                if (Jd.xy() && !aps.fWX) {
                    aw.ZK();
                    bi jf = com.tencent.mm.model.c.XO().jf(biVar.field_msgId);
                    aps.fWX = true;
                    biVar.setContent(aps.dsX());
                    if (jf.getType() != Downloads.MIN_WAIT_FOR_NETWORK) {
                        aw.ZK();
                        com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
                    } else {
                        ab.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
                    }
                }
                if (com.tencent.mm.plugin.emoji.h.b.y(Jd)) {
                    eVar.zfA.setVisibility(0);
                    View view = eVar.zfA;
                    if (this.zfx == null) {
                        this.zfx = new c(this.yJI);
                    }
                    view.setOnClickListener(this.zfx);
                } else {
                    eVar.zfA.setVisibility(8);
                }
            }
            String str4 = "";
            if (Jd == null || !Jd.xy()) {
                if (Jd != null) {
                    str4 = bo.bc(((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(Jd.Aq()), "");
                }
            } else if (Jd.field_name.startsWith("jsb_j")) {
                str4 = this.yJI.yTx.getContext().getString(R.string.b_f);
            } else if (Jd.field_name.startsWith("jsb_s")) {
                str4 = this.yJI.yTx.getContext().getString(R.string.b_g);
            } else if (Jd.field_name.startsWith("jsb_b")) {
                str4 = this.yJI.yTx.getContext().getString(R.string.b_e);
            } else if (Jd.field_name.startsWith("dice")) {
                str4 = Jd.field_name.replace("dice_", "").replace(".png", "");
            }
            eVar.zdM.setContentDescription(this.yJI.yTx.getContext().getString(R.string.bc5) + str4);
            eVar.zdM.setTag(new ay(biVar, aVar2.dFx(), i, str, 0));
            RTChattingEmojiView rTChattingEmojiView = eVar.zdM;
            if (this.zfw == null) {
                this.zfw = new d(aVar2);
            }
            rTChattingEmojiView.setOnClickListener(this.zfw);
            eVar.zdM.setOnLongClickListener(c(aVar2));
            eVar.zdM.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            AppMethodBeat.o(33191);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33192);
            boolean dFx = aVar.dFx();
            AppMethodBeat.o(33192);
            return dFx;
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33193);
            if (biVar.dtx()) {
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    int i = ((ay) view.getTag()).position;
                    EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
                    if (Jd == null) {
                        ab.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", biVar.field_imgPath);
                        AppMethodBeat.o(33193);
                        return true;
                    }
                    boolean duP = Jd.duP();
                    if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS() || Jd.duT())) {
                        if (duP) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.string.amj));
                        } else {
                            ab.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (Jd.field_catalog == EmojiInfo.yaB || bo.isNullOrNil(Jd.field_groupId) || (!bo.isNullOrNil(Jd.field_groupId) && ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ji(Jd.field_groupId))) {
                        if (duP) {
                            contextMenu.add(i, 113, 0, R.string.dr1);
                        } else {
                            ab.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bjR()) {
                        contextMenu.add(i, com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX, 0, view.getContext().getString(R.string.am_));
                    }
                    if (!(!com.tencent.mm.plugin.emoji.h.b.JY(Jd.field_groupId) || Jd.xy() || Jd.duT())) {
                        contextMenu.add(i, 128, 0, R.string.aml);
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am5));
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(12789, Integer.valueOf(0), Jd.Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", Jd.field_activityid);
                }
            }
            AppMethodBeat.o(33193);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33194);
            boolean a = ((m) aVar.aF(m.class)).a(menuItem, aVar, biVar);
            AppMethodBeat.o(33194);
            return a;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class b extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected d zfw;
        private c zfx;
        protected s.m zfy;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 47) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33195);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.ne);
                view.setTag(new e().z(view, false));
            }
            AppMethodBeat.o(33195);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33196);
            this.yJI = aVar2;
            aVar = (e) aVar;
            EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
            if (Jd != null) {
                ap aps = ap.aps(biVar.field_content);
                Jd.talker = biVar.field_talker;
                aVar.zdM.a(Jd, biVar.field_msgId, aps);
                if (aVar.zfz != null) {
                    if (aps.xXK) {
                        aVar.zfz.setVisibility(0);
                        TextView textView = (TextView) aVar.mRR.findViewById(R.id.at_).findViewById(R.id.atb);
                        textView.setText(Html.fromHtml(aVar2.yTx.getMMResources().getString(R.string.b9o)));
                        ImageView imageView = (ImageView) aVar.mRR.findViewById(R.id.at_).findViewById(R.id.atc);
                        TextView textView2 = textView;
                        textView2.setTag(new ay(biVar, false, i, aVar2.dFu(), false, "", "", "", "", Jd.field_groupId, "", true, false));
                        textView.setOnClickListener(i(aVar2));
                        if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bjN()) {
                            imageView.setVisibility(0);
                            ImageView imageView2 = imageView;
                            imageView2.setTag(new ay(biVar, aVar2.dFx(), i, aVar2.dFu(), 0));
                            if (this.zfy == null) {
                                this.zfy = new s.m(aVar2);
                            }
                            imageView.setOnClickListener(this.zfy);
                        } else {
                            imageView.setVisibility(8);
                        }
                    } else {
                        aVar.zfz.setVisibility(8);
                    }
                }
                if (Jd.xy() && !aps.fWX) {
                    aps.fWX = true;
                    biVar.setContent(aps.dsX());
                    aw.ZK();
                    biVar.setStatus(com.tencent.mm.model.c.XO().jf(biVar.field_msgId).field_status);
                    aw.ZK();
                    com.tencent.mm.model.c.XO().ab(biVar);
                }
                if (c.dHm()) {
                    aVar.pyf.setVisibility(8);
                    if (biVar.field_status == 2) {
                        if (c.a((h) aVar2.aF(h.class), biVar.field_msgId)) {
                            if (aVar.zci != null) {
                                aVar.zci.setVisibility(0);
                            }
                        }
                    }
                    if (aVar.zci != null) {
                        aVar.zci.setVisibility(8);
                    }
                } else {
                    if (aVar.zci != null) {
                        aVar.zci.setVisibility(8);
                    }
                    if (aVar.pyf != null) {
                        aVar.pyf.setVisibility(0);
                        if (biVar.field_status >= 2) {
                            aVar.pyf.setVisibility(8);
                        }
                    }
                }
                if (com.tencent.mm.plugin.emoji.h.b.y(Jd)) {
                    aVar.zfA.setVisibility(0);
                    View view = aVar.zfA;
                    if (this.zfx == null) {
                        this.zfx = new c(this.yJI);
                    }
                    view.setOnClickListener(this.zfx);
                } else {
                    aVar.zfA.setVisibility(8);
                }
            }
            String str2 = "";
            if (Jd == null || !Jd.xy()) {
                if (Jd != null) {
                    str2 = bo.bc(((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(Jd.Aq()), "");
                }
            } else if (Jd.field_name.startsWith("jsb_j")) {
                str2 = this.yJI.yTx.getContext().getString(R.string.b_f);
            } else if (Jd.field_name.startsWith("jsb_s")) {
                str2 = this.yJI.yTx.getContext().getString(R.string.b_g);
            } else if (Jd.field_name.startsWith("jsb_b")) {
                str2 = this.yJI.yTx.getContext().getString(R.string.b_e);
            } else if (Jd.field_name.startsWith("dice")) {
                str2 = Jd.field_name.replace("dice_", "").replace(".png", "");
            }
            aVar.zdM.setContentDescription(this.yJI.yTx.getContext().getString(R.string.bc5) + str2);
            aVar.zdM.setTag(new ay(biVar, aVar2.dFx(), i, aVar2.dFu(), 0));
            RTChattingEmojiView rTChattingEmojiView = aVar.zdM;
            if (this.zfw == null) {
                this.zfw = new d(aVar2);
            }
            rTChattingEmojiView.setOnClickListener(this.zfw);
            aVar.zdM.setOnLongClickListener(c(aVar2));
            aVar.zdM.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33196);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33197);
            if (biVar.dtx()) {
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    int i = ((ay) view.getTag()).position;
                    EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
                    if (Jd == null) {
                        ab.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", biVar.field_imgPath);
                        AppMethodBeat.o(33197);
                        return true;
                    }
                    boolean duP = Jd.duP();
                    if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS() || Jd.duT())) {
                        if (duP) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.string.amj));
                        } else {
                            ab.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (Jd.field_catalog == EmojiInfo.yaB || bo.isNullOrNil(Jd.field_groupId) || (!bo.isNullOrNil(Jd.field_groupId) && ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ji(Jd.field_groupId))) {
                        if (duP) {
                            contextMenu.add(i, 113, 0, R.string.dr1);
                        } else {
                            ab.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bjR()) {
                        contextMenu.add(i, com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX, 0, view.getContext().getString(R.string.am_));
                    }
                    if (!(!com.tencent.mm.plugin.emoji.h.b.JY(Jd.field_groupId) || Jd.xy() || Jd.duT())) {
                        contextMenu.add(i, 128, 0, R.string.aml);
                    }
                    if (!biVar.drC() && biVar.dtx() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am5));
                    }
                    if (biVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(12789, Integer.valueOf(0), Jd.Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", "", Jd.field_activityid);
                }
            }
            AppMethodBeat.o(33197);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33198);
            boolean a = ((m) aVar.aF(m.class)).a(menuItem, aVar, biVar);
            AppMethodBeat.o(33198);
            return a;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33199);
            biVar.dtJ();
            aw.ZK();
            com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
            ((m) aVar.aF(m.class)).bh(biVar);
            AppMethodBeat.o(33199);
        }
    }

    public static class c implements OnClickListener {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public c(com.tencent.mm.ui.chatting.d.a aVar) {
            this.yJI = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(33200);
            ab.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_PANEL_FROM_TIPS_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            EmojiCaptureReporter.bmw();
            cz czVar = new cz();
            czVar.cwc.type = 2;
            com.tencent.mm.sdk.b.a.xxA.m(czVar);
            com.tencent.mm.sdk.b.a.xxA.m(new ny());
            if (!czVar.cwd.cwe) {
                cab bjU = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYq.bjU();
                if (bjU != null) {
                    Iterator it = bjU.wZl.iterator();
                    while (it.hasNext()) {
                        cac cac = (cac) it.next();
                        if (cac.ProductID.equals(String.valueOf("capture"))) {
                            cac.vKj = 0;
                            break;
                        }
                    }
                }
                ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYq.b(bjU);
                com.tencent.mm.by.a.dmE();
                com.tencent.mm.by.a.b bVar = com.tencent.mm.by.a.xum;
                com.tencent.mm.by.a.b.alW("capture");
            }
            ((o) this.yJI.aF(o.class)).dDX().dkh();
            com.tencent.mm.ui.chatting.d.a aVar = this.yJI;
            ab.i("MicroMsg.ChattingContext", "[scrollToLast]");
            aVar.yTy.dCx();
            AppMethodBeat.o(33200);
        }
    }

    public static class d extends com.tencent.mm.ui.chatting.s.e {
        public d(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33201);
            ay ayVar = (ay) view.getTag();
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(ayVar.cKd.field_imgPath);
                if (Jd == null || Jd.xy()) {
                    AppMethodBeat.o(33201);
                    return;
                }
                String oy;
                Intent intent = new Intent();
                intent.putExtra("custom_smiley_preview_md5", ayVar.cKd.field_imgPath);
                intent.putExtra("custom_to_talker_name", ayVar.cKd.field_talker);
                if (!(Jd.field_catalog == EmojiGroupInfo.yat || Jd.field_catalog == EmojiGroupInfo.yas || Jd.field_catalog == EmojiGroupInfo.yar)) {
                    intent.putExtra("custom_smiley_preview_productid", Jd.field_groupId);
                }
                intent.putExtra("msg_id", ayVar.cKd.field_msgSvrId);
                intent.putExtra("msg_content", ayVar.cKd.field_content);
                String str = ayVar.cKd.field_talker;
                if (t.kH(str)) {
                    oy = bf.oy(ayVar.cKd.field_content);
                    intent.putExtra("room_id", this.yJI.getTalkerUserName());
                } else {
                    oy = str;
                }
                intent.putExtra("msg_sender", oy);
                com.tencent.mm.bp.d.b(this.yJI.yTx.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", intent, (int) FaceManager.FACE_ACQUIRED_HACKER);
                com.tencent.mm.plugin.report.service.h.pYm.e(11592, Integer.valueOf(0));
            }
            AppMethodBeat.o(33201);
        }
    }

    static class e extends com.tencent.mm.ui.chatting.viewitems.c.a {
        ProgressBar pyf;
        ImageView zci;
        RTChattingEmojiView zdM;
        ImageView zdN;
        View zfA;
        ImageView zfB;
        ViewStub zfz;

        e() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            AppMethodBeat.i(33202);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zdM = (RTChattingEmojiView) view.findViewById(R.id.aqy);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.zfA = view.findViewById(R.id.arj);
            this.zfB = (ImageView) view.findViewById(R.id.ark);
            this.zfB.setImageDrawable(ah.f(view.getContext(), R.raw.emoticonstore_capture_icon, -1));
            if (z) {
                this.qkY = (TextView) view.findViewById(R.id.od);
            } else {
                this.pyf = (ProgressBar) view.findViewById(R.id.at6);
                this.qkY = (TextView) view.findViewById(R.id.od);
                this.zby = (ImageView) view.findViewById(R.id.asb);
                this.zci = (ImageView) view.findViewById(R.id.at7);
            }
            if (this.zdN != null) {
                ((ViewGroup) this.zdN.getParent()).setBackgroundDrawable(null);
            }
            this.zfz = (ViewStub) view.findViewById(R.id.ata);
            AppMethodBeat.o(33202);
            return this;
        }
    }
}

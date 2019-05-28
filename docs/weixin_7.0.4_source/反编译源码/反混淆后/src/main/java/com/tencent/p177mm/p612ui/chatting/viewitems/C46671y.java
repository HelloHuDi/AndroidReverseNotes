package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p207by.C45274a.C1336b;
import com.tencent.p177mm.p230g.p231a.C45317cz;
import com.tencent.p177mm.p230g.p231a.C45348ny;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.C44318s.C44322m;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44298m;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.RTChattingEmojiView;
import com.tencent.p177mm.protocal.protobuf.cab;
import com.tencent.p177mm.protocal.protobuf.cac;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.y */
public final class C46671y {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.y$a */
    public static class C23886a extends C5378c {
        private C46650a yJI;
        protected C40829d zfw;
        private C30627c zfx;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 47) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33190);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969062);
                view.setTag(new C44355e().mo70228z(view, true));
            }
            AppMethodBeat.m2505o(33190);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33191);
            if (c7620bi == null) {
                C4990ab.m7413e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", str);
                AppMethodBeat.m2505o(33191);
                return;
            }
            this.yJI = c46650a;
            EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
            C44355e c44355e = (C44355e) c5379a;
            if (Jd == null) {
                boolean z;
                String str2 = "MicroMsg.emoji.ChattingItemEmojiFrom";
                String str3 = "filling: db emoji %s, %s, msgId %s";
                Object[] objArr = new Object[3];
                objArr[0] = c7620bi.field_imgPath;
                if (Jd == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Long.valueOf(c7620bi.field_msgId);
                C4990ab.m7417i(str2, str3, objArr);
            }
            if (Jd != null) {
                Jd.talker = c7620bi.field_talker;
                C44218ap aps = C44218ap.aps(c7620bi.field_content);
                c44355e.zdM.mo64024a(Jd, c7620bi.field_msgId, aps);
                if (Jd.mo48552xy() && !aps.fWX) {
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf(c7620bi.field_msgId);
                    aps.fWX = true;
                    c7620bi.setContent(aps.dsX());
                    if (jf.getType() != Downloads.MIN_WAIT_FOR_NETWORK) {
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                    } else {
                        C4990ab.m7416i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
                    }
                }
                if (C2933b.m5227y(Jd)) {
                    c44355e.zfA.setVisibility(0);
                    View view = c44355e.zfA;
                    if (this.zfx == null) {
                        this.zfx = new C30627c(this.yJI);
                    }
                    view.setOnClickListener(this.zfx);
                } else {
                    c44355e.zfA.setVisibility(8);
                }
            }
            String str4 = "";
            if (Jd == null || !Jd.mo48552xy()) {
                if (Jd != null) {
                    str4 = C5046bo.m7532bc(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(Jd.mo20410Aq()), "");
                }
            } else if (Jd.field_name.startsWith("jsb_j")) {
                str4 = this.yJI.yTx.getContext().getString(C25738R.string.b_f);
            } else if (Jd.field_name.startsWith("jsb_s")) {
                str4 = this.yJI.yTx.getContext().getString(C25738R.string.b_g);
            } else if (Jd.field_name.startsWith("jsb_b")) {
                str4 = this.yJI.yTx.getContext().getString(C25738R.string.b_e);
            } else if (Jd.field_name.startsWith("dice")) {
                str4 = Jd.field_name.replace("dice_", "").replace(".png", "");
            }
            c44355e.zdM.setContentDescription(this.yJI.yTx.getContext().getString(C25738R.string.bc5) + str4);
            c44355e.zdM.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, str, 0));
            RTChattingEmojiView rTChattingEmojiView = c44355e.zdM;
            if (this.zfw == null) {
                this.zfw = new C40829d(c46650a);
            }
            rTChattingEmojiView.setOnClickListener(this.zfw);
            c44355e.zdM.setOnLongClickListener(mo11021c(c46650a));
            c44355e.zdM.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            AppMethodBeat.m2505o(33191);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            AppMethodBeat.m2504i(33192);
            boolean dFx = c46650a.dFx();
            AppMethodBeat.m2505o(33192);
            return dFx;
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33193);
            if (c7620bi.dtx()) {
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    int i = ((C40814ay) view.getTag()).position;
                    EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
                    if (Jd == null) {
                        C4990ab.m7421w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", c7620bi.field_imgPath);
                        AppMethodBeat.m2505o(33193);
                        return true;
                    }
                    boolean duP = Jd.duP();
                    if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS() || Jd.duT())) {
                        if (duP) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(C25738R.string.amj));
                        } else {
                            C4990ab.m7416i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (Jd.field_catalog == EmojiInfo.yaB || C5046bo.isNullOrNil(Jd.field_groupId) || (!C5046bo.isNullOrNil(Jd.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(Jd.field_groupId))) {
                        if (duP) {
                            contextMenu.add(i, 113, 0, C25738R.string.dr1);
                        } else {
                            C4990ab.m7416i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjR()) {
                        contextMenu.add(i, C44697b.CTRL_INDEX, 0, view.getContext().getString(C25738R.string.am_));
                    }
                    if (!(!C2933b.m5220JY(Jd.field_groupId) || Jd.mo48552xy() || Jd.duT())) {
                        contextMenu.add(i, 128, 0, C25738R.string.aml);
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am5));
                    }
                    C7060h.pYm.mo8381e(12789, Integer.valueOf(0), Jd.mo20410Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", Jd.field_activityid);
                }
            }
            AppMethodBeat.m2505o(33193);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33194);
            boolean a = ((C44298m) c46650a.mo74857aF(C44298m.class)).mo48876a(menuItem, c46650a, c7620bi);
            AppMethodBeat.m2505o(33194);
            return a;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.y$b */
    public static class C23887b extends C5378c implements C5365n {
        private C46650a yJI;
        protected C40829d zfw;
        private C30627c zfx;
        protected C44322m zfy;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 47) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33195);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969099);
                view.setTag(new C44355e().mo70228z(view, false));
            }
            AppMethodBeat.m2505o(33195);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33196);
            this.yJI = c46650a;
            c5379a = (C44355e) c5379a;
            EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
            if (Jd != null) {
                C44218ap aps = C44218ap.aps(c7620bi.field_content);
                Jd.talker = c7620bi.field_talker;
                c5379a.zdM.mo64024a(Jd, c7620bi.field_msgId, aps);
                if (c5379a.zfz != null) {
                    if (aps.xXK) {
                        c5379a.zfz.setVisibility(0);
                        TextView textView = (TextView) c5379a.mRR.findViewById(2131822664).findViewById(2131822666);
                        textView.setText(Html.fromHtml(c46650a.yTx.getMMResources().getString(C25738R.string.b9o)));
                        ImageView imageView = (ImageView) c5379a.mRR.findViewById(2131822664).findViewById(2131822667);
                        TextView textView2 = textView;
                        textView2.setTag(new C40814ay(c7620bi, false, i, c46650a.dFu(), false, "", "", "", "", Jd.field_groupId, "", true, false));
                        textView.setOnClickListener(mo11030i(c46650a));
                        if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjN()) {
                            imageView.setVisibility(0);
                            ImageView imageView2 = imageView;
                            imageView2.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, c46650a.dFu(), 0));
                            if (this.zfy == null) {
                                this.zfy = new C44322m(c46650a);
                            }
                            imageView.setOnClickListener(this.zfy);
                        } else {
                            imageView.setVisibility(8);
                        }
                    } else {
                        c5379a.zfz.setVisibility(8);
                    }
                }
                if (Jd.mo48552xy() && !aps.fWX) {
                    aps.fWX = true;
                    c7620bi.setContent(aps.dsX());
                    C9638aw.m17190ZK();
                    c7620bi.setStatus(C18628c.m29080XO().mo15340jf(c7620bi.field_msgId).field_status);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15294ab(c7620bi);
                }
                if (C5378c.dHm()) {
                    c5379a.pyf.setVisibility(8);
                    if (c7620bi.field_status == 2) {
                        if (C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                            if (c5379a.zci != null) {
                                c5379a.zci.setVisibility(0);
                            }
                        }
                    }
                    if (c5379a.zci != null) {
                        c5379a.zci.setVisibility(8);
                    }
                } else {
                    if (c5379a.zci != null) {
                        c5379a.zci.setVisibility(8);
                    }
                    if (c5379a.pyf != null) {
                        c5379a.pyf.setVisibility(0);
                        if (c7620bi.field_status >= 2) {
                            c5379a.pyf.setVisibility(8);
                        }
                    }
                }
                if (C2933b.m5227y(Jd)) {
                    c5379a.zfA.setVisibility(0);
                    View view = c5379a.zfA;
                    if (this.zfx == null) {
                        this.zfx = new C30627c(this.yJI);
                    }
                    view.setOnClickListener(this.zfx);
                } else {
                    c5379a.zfA.setVisibility(8);
                }
            }
            String str2 = "";
            if (Jd == null || !Jd.mo48552xy()) {
                if (Jd != null) {
                    str2 = C5046bo.m7532bc(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(Jd.mo20410Aq()), "");
                }
            } else if (Jd.field_name.startsWith("jsb_j")) {
                str2 = this.yJI.yTx.getContext().getString(C25738R.string.b_f);
            } else if (Jd.field_name.startsWith("jsb_s")) {
                str2 = this.yJI.yTx.getContext().getString(C25738R.string.b_g);
            } else if (Jd.field_name.startsWith("jsb_b")) {
                str2 = this.yJI.yTx.getContext().getString(C25738R.string.b_e);
            } else if (Jd.field_name.startsWith("dice")) {
                str2 = Jd.field_name.replace("dice_", "").replace(".png", "");
            }
            c5379a.zdM.setContentDescription(this.yJI.yTx.getContext().getString(C25738R.string.bc5) + str2);
            c5379a.zdM.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, c46650a.dFu(), 0));
            RTChattingEmojiView rTChattingEmojiView = c5379a.zdM;
            if (this.zfw == null) {
                this.zfw = new C40829d(c46650a);
            }
            rTChattingEmojiView.setOnClickListener(this.zfw);
            c5379a.zdM.setOnLongClickListener(mo11021c(c46650a));
            c5379a.zdM.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33196);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33197);
            if (c7620bi.dtx()) {
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    int i = ((C40814ay) view.getTag()).position;
                    EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
                    if (Jd == null) {
                        C4990ab.m7421w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", c7620bi.field_imgPath);
                        AppMethodBeat.m2505o(33197);
                        return true;
                    }
                    boolean duP = Jd.duP();
                    if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS() || Jd.duT())) {
                        if (duP) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(C25738R.string.amj));
                        } else {
                            C4990ab.m7416i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (Jd.field_catalog == EmojiInfo.yaB || C5046bo.isNullOrNil(Jd.field_groupId) || (!C5046bo.isNullOrNil(Jd.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(Jd.field_groupId))) {
                        if (duP) {
                            contextMenu.add(i, 113, 0, C25738R.string.dr1);
                        } else {
                            C4990ab.m7416i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjR()) {
                        contextMenu.add(i, C44697b.CTRL_INDEX, 0, view.getContext().getString(C25738R.string.am_));
                    }
                    if (!(!C2933b.m5220JY(Jd.field_groupId) || Jd.mo48552xy() || Jd.duT())) {
                        contextMenu.add(i, 128, 0, C25738R.string.aml);
                    }
                    if (!c7620bi.drC() && c7620bi.dtx() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am5));
                    }
                    if (c7620bi.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                    }
                    C7060h.pYm.mo8381e(12789, Integer.valueOf(0), Jd.mo20410Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", "", Jd.field_activityid);
                }
            }
            AppMethodBeat.m2505o(33197);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33198);
            boolean a = ((C44298m) c46650a.mo74857aF(C44298m.class)).mo48876a(menuItem, c46650a, c7620bi);
            AppMethodBeat.m2505o(33198);
            return a;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33199);
            c7620bi.dtJ();
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            ((C44298m) c46650a.mo74857aF(C44298m.class)).mo48877bh(c7620bi);
            AppMethodBeat.m2505o(33199);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.y$c */
    public static class C30627c implements OnClickListener {
        private C46650a yJI;

        public C30627c(C46650a c46650a) {
            this.yJI = c46650a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33200);
            C4990ab.m7416i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_PANEL_FROM_TIPS_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            EmojiCaptureReporter.bmw();
            C45317cz c45317cz = new C45317cz();
            c45317cz.cwc.type = 2;
            C4879a.xxA.mo10055m(c45317cz);
            C4879a.xxA.mo10055m(new C45348ny());
            if (!c45317cz.cwd.cwe) {
                cab bjU = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYq.bjU();
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
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYq.mo64091b(bjU);
                C45274a.dmE();
                C1336b c1336b = C45274a.xum;
                C1336b.alW("capture");
            }
            ((C15614o) this.yJI.mo74857aF(C15614o.class)).dDX().dkh();
            C46650a c46650a = this.yJI;
            C4990ab.m7416i("MicroMsg.ChattingContext", "[scrollToLast]");
            c46650a.yTy.dCx();
            AppMethodBeat.m2505o(33200);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.y$d */
    public static class C40829d extends C23812e {
        public C40829d(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33201);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c40814ay.cKd.field_imgPath);
                if (Jd == null || Jd.mo48552xy()) {
                    AppMethodBeat.m2505o(33201);
                    return;
                }
                String oy;
                Intent intent = new Intent();
                intent.putExtra("custom_smiley_preview_md5", c40814ay.cKd.field_imgPath);
                intent.putExtra("custom_to_talker_name", c40814ay.cKd.field_talker);
                if (!(Jd.field_catalog == EmojiGroupInfo.yat || Jd.field_catalog == EmojiGroupInfo.yas || Jd.field_catalog == EmojiGroupInfo.yar)) {
                    intent.putExtra("custom_smiley_preview_productid", Jd.field_groupId);
                }
                intent.putExtra("msg_id", c40814ay.cKd.field_msgSvrId);
                intent.putExtra("msg_content", c40814ay.cKd.field_content);
                String str = c40814ay.cKd.field_talker;
                if (C1855t.m3896kH(str)) {
                    oy = C1829bf.m3762oy(c40814ay.cKd.field_content);
                    intent.putExtra("room_id", this.yJI.getTalkerUserName());
                } else {
                    oy = str;
                }
                intent.putExtra("msg_sender", oy);
                C25985d.m41468b(this.yJI.yTx.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", intent, (int) FaceManager.FACE_ACQUIRED_HACKER);
                C7060h.pYm.mo8381e(11592, Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(33201);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.y$e */
    static class C44355e extends C5379a {
        ProgressBar pyf;
        ImageView zci;
        RTChattingEmojiView zdM;
        ImageView zdN;
        View zfA;
        ImageView zfB;
        ViewStub zfz;

        C44355e() {
        }

        /* renamed from: z */
        public final C5379a mo70228z(View view, boolean z) {
            AppMethodBeat.m2504i(33202);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zdM = (RTChattingEmojiView) view.findViewById(2131822578);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.zfA = view.findViewById(2131822600);
            this.zfB = (ImageView) view.findViewById(2131822601);
            this.zfB.setImageDrawable(C5225ah.m7962f(view.getContext(), C1318a.emoticonstore_capture_icon, -1));
            if (z) {
                this.qkY = (TextView) view.findViewById(2131821102);
            } else {
                this.pyf = (ProgressBar) view.findViewById(2131822660);
                this.qkY = (TextView) view.findViewById(2131821102);
                this.zby = (ImageView) view.findViewById(2131822629);
                this.zci = (ImageView) view.findViewById(2131822661);
            }
            if (this.zdN != null) {
                ((ViewGroup) this.zdN.getParent()).setBackgroundDrawable(null);
            }
            this.zfz = (ViewStub) view.findViewById(2131822665);
            AppMethodBeat.m2505o(33202);
            return this;
        }
    }
}

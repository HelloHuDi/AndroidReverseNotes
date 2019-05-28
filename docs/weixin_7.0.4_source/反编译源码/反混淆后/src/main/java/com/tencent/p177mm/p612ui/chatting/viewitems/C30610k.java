package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44298m;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.RTChattingEmojiView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.k */
public final class C30610k {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.k$b */
    public static final class C23853b extends C5379a {
        public static Map<String, WeakReference<C23853b>> zdR = new HashMap();
        ProgressBar pyf;
        ImageView zci;
        RTChattingEmojiView zdM;
        ImageView zdN;
        ProgressBar zdO;
        ImageView zdP;
        TextView zdQ;

        static {
            AppMethodBeat.m2504i(32939);
            AppMethodBeat.m2505o(32939);
        }

        /* renamed from: z */
        public final C5379a mo39643z(View view, boolean z) {
            AppMethodBeat.m2504i(32937);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zdM = (RTChattingEmojiView) view.findViewById(2131822578);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.zdO = (ProgressBar) view.findViewById(2131822579);
            this.zdP = (ImageView) view.findViewById(2131822581);
            this.zdQ = (TextView) view.findViewById(2131822580);
            if (!z) {
                this.pyf = (ProgressBar) view.findViewById(2131822660);
                this.zby = (ImageView) view.findViewById(2131822629);
                this.zci = (ImageView) view.findViewById(2131822661);
            }
            if (this.zdN != null) {
                ((ViewGroup) this.zdN.getParent()).setBackgroundDrawable(null);
            }
            this.qkY = (TextView) view.findViewById(2131821102);
            AppMethodBeat.m2505o(32937);
            return this;
        }

        /* renamed from: n */
        public static void m36723n(String str, int i, int i2) {
            AppMethodBeat.m2504i(32938);
            if (zdR.containsKey(str)) {
                C23853b c23853b = (C23853b) ((WeakReference) zdR.get(str)).get();
                if (c23853b != null) {
                    switch (i2) {
                        case 0:
                            c23853b.zdO.setVisibility(0);
                            c23853b.zdQ.setVisibility(8);
                            c23853b.zdP.setVisibility(8);
                            c23853b.zdO.setProgress(0);
                            break;
                        case 1:
                            c23853b.zdO.setVisibility(8);
                            c23853b.zdQ.setVisibility(8);
                            c23853b.zdP.setVisibility(8);
                            AppMethodBeat.m2505o(32938);
                            return;
                        case 2:
                            c23853b.zdO.setVisibility(8);
                            c23853b.zdQ.setVisibility(8);
                            c23853b.zdP.setVisibility(0);
                            c23853b.zdO.setProgress(i);
                            c23853b.zdP.setImageResource(C25738R.drawable.emoji_download_failed_btn);
                            AppMethodBeat.m2505o(32938);
                            return;
                    }
                }
                AppMethodBeat.m2505o(32938);
                return;
            }
            C4990ab.m7416i("AppMsgEmojiItemHolder", "no contain attchid:%s");
            AppMethodBeat.m2505o(32938);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.k$c */
    public static class C23854c extends C5378c {
        private C46650a yJI;
        protected C24968a zdS;

        /* renamed from: j */
        private C24968a m36725j(C46650a c46650a) {
            AppMethodBeat.m2504i(32940);
            if (this.zdS == null) {
                this.zdS = new C24968a(c46650a);
            }
            C24968a c24968a = this.zdS;
            AppMethodBeat.m2505o(32940);
            return c24968a;
        }

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 1048625) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32941);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969051);
                view.setTag(new C23853b().mo39643z(view, true));
            }
            AppMethodBeat.m2505o(32941);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            EmojiInfo emojiInfo;
            AppMethodBeat.m2504i(32942);
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57030bg(c7620bi);
            C23853b c23853b = (C23853b) c5379a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X == null || X.fgq == null) {
                emojiInfo = null;
            } else {
                emojiInfo = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(X.fgq);
            }
            if (emojiInfo == null || !emojiInfo.duP()) {
                Bitmap v;
                String I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                Bitmap sB = C32291o.ahp().mo43776sB(I);
                if (sB == null || sB.isRecycled()) {
                    sB = C5056d.decodeFile(I, null);
                    C32291o.ahp().mo43775j(I, sB);
                }
                if (emojiInfo == null) {
                    c23853b.zdP.setVisibility(0);
                    c23853b.zdO.setVisibility(8);
                    c23853b.zdQ.setText(C42252ah.m74622ga(X == null ? 0 : (long) X.fgo));
                    c23853b.zdQ.setVisibility(0);
                    c23853b.zdP.setImageResource(C25738R.drawable.emoji_download_btn);
                } else {
                    c23853b.zdO.setVisibility(0);
                    c23853b.zdQ.setVisibility(8);
                    c23853b.zdP.setVisibility(8);
                    c23853b.zdO.setProgress(0);
                    c23853b.zdQ.setVisibility(8);
                }
                if (!(X == null || C5046bo.isNullOrNil(X.fgq))) {
                    C23853b.zdR.put(X.fgq, new WeakReference(c23853b));
                }
                if (sB == null || sB.isRecycled()) {
                    v = C5056d.m7668v(this.yJI.yTx.getMMResources().getDrawable(C25738R.drawable.aay));
                } else {
                    v = sB;
                }
                c23853b.zdM.setImageBitmap(v);
            } else {
                emojiInfo.talker = c7620bi.field_talker;
                c23853b.zdM.mo64023a(emojiInfo, c7620bi.field_msgId);
                c23853b.zdP.setVisibility(8);
                c23853b.zdO.setVisibility(8);
                c23853b.zdQ.setVisibility(8);
                c23853b.zdP.setVisibility(8);
                if (!(X == null || C5046bo.isNullOrNil(X.fgq))) {
                    C23853b.zdR.remove(X.fgq);
                }
                C5378c.m8123a(c7620bi, emojiInfo);
            }
            c23853b.zdM.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, str, 0));
            c23853b.zdM.setOnClickListener(m36725j(c46650a));
            c23853b.zdM.setOnLongClickListener(mo11021c(c46650a));
            c23853b.zdM.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c23853b.zdP.setOnClickListener(m36725j(c46650a));
            c23853b.zdP.setOnLongClickListener(mo11021c(c46650a));
            c23853b.zdP.setTag(c23853b.zdM.getTag());
            AppMethodBeat.m2505o(32942);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            AppMethodBeat.m2504i(32943);
            boolean dFx = c46650a.dFx();
            AppMethodBeat.m2505o(32943);
            return dFx;
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            C8910b c8910b;
            AppMethodBeat.m2504i(32944);
            int i = ((C40814ay) view.getTag()).position;
            C44218ap aps = C44218ap.aps(c7620bi.field_content);
            C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
            if (X == null) {
                X = new C8910b();
                X.fgq = aps.cvZ;
                c8910b = X;
            } else {
                c8910b = X;
            }
            if (!(C42252ah.isNullOrNil(c8910b.fgq) || c8910b.fgq.equals("-1"))) {
                EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq);
                if (Jd != null) {
                    if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS())) {
                        contextMenu.add(i, 104, 0, view.getContext().getString(C25738R.string.amj));
                    }
                    if (Jd != null) {
                        C7060h.pYm.mo8381e(12789, Integer.valueOf(0), Jd.mo20410Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", Jd.field_activityid);
                    }
                    boolean duP = Jd.duP();
                    if (Jd.field_catalog == EmojiInfo.yaB || C5046bo.isNullOrNil(Jd.field_groupId) || (!C5046bo.isNullOrNil(Jd.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(Jd.field_groupId))) {
                        if (duP) {
                            contextMenu.add(i, 113, 0, C25738R.string.dr1);
                        } else {
                            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjR()) {
                        contextMenu.add(i, C44697b.CTRL_INDEX, 0, view.getContext().getString(C25738R.string.am_));
                    }
                }
            }
            if (C1831bh.m3770o(c7620bi)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am5));
            }
            AppMethodBeat.m2505o(32944);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32945);
            boolean a = ((C44298m) c46650a.mo74857aF(C44298m.class)).mo48876a(menuItem, c46650a, c7620bi);
            AppMethodBeat.m2505o(32945);
            return a;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.k$d */
    public static class C23855d extends C5378c implements C5365n {
        private C46650a yJI;
        protected C24968a zdS;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 1048625) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32946);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969088);
                view.setTag(new C23853b().mo39643z(view, false));
            }
            AppMethodBeat.m2505o(32946);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32947);
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57030bg(c7620bi);
            c5379a = (C23853b) c5379a;
            C8910b c8910b = null;
            if (c7620bi != null) {
                EmojiInfo emojiInfo;
                RTChattingEmojiView rTChattingEmojiView;
                String str2 = c7620bi.field_content;
                C44218ap aps = C44218ap.aps(c7620bi.field_content);
                EmojiInfo emojiInfo2 = null;
                if (!aps.fWX) {
                    if (str2 != null) {
                        c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
                    }
                    if (c8910b != null) {
                        emojiInfo2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq);
                    }
                }
                if (aps.cvZ == null || aps.cvZ.equals("-1") || emojiInfo2 != null) {
                    emojiInfo = emojiInfo2;
                } else {
                    emojiInfo = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(aps.cvZ);
                }
                if (emojiInfo == null || !emojiInfo.duP()) {
                    long j;
                    str2 = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                    Bitmap sB = C32291o.ahp().mo43776sB(str2);
                    if (sB == null || sB.isRecycled()) {
                        sB = C5056d.decodeFile(str2, null);
                        C32291o.ahp().mo43775j(str2, sB);
                    }
                    c5379a.pyf.setVisibility(8);
                    c5379a.zdP.setVisibility(0);
                    c5379a.zdO.setVisibility(8);
                    TextView textView = c5379a.zdQ;
                    if (c8910b == null) {
                        j = 0;
                    } else {
                        j = (long) c8910b.fgo;
                    }
                    textView.setText(C42252ah.m74622ga(j));
                    c5379a.zdQ.setVisibility(0);
                    c5379a.zdP.setImageResource(C25738R.drawable.emoji_download_btn);
                    if (sB == null || sB.isRecycled()) {
                        sB = C5056d.m7668v(this.yJI.yTx.getMMResources().getDrawable(C25738R.drawable.aay));
                    }
                    c5379a.zdM.setImageBitmap(sB);
                    if (!(c8910b == null || C5046bo.isNullOrNil(c8910b.fgq))) {
                        C23853b.zdR.put(c8910b.fgq, new WeakReference(c5379a));
                    }
                } else {
                    int i2;
                    emojiInfo.talker = c7620bi.field_talker;
                    c5379a.zdM.mo64023a(emojiInfo, c7620bi.field_msgId);
                    rTChattingEmojiView = c5379a.zdM;
                    if (rTChattingEmojiView.vpQ != null) {
                        rTChattingEmojiView.vpQ.resume();
                    }
                    Object obj = c7620bi.field_status != 1 ? 1 : null;
                    ProgressBar progressBar = c5379a.pyf;
                    if (obj != null) {
                        i2 = 8;
                    } else {
                        i2 = 0;
                    }
                    progressBar.setVisibility(i2);
                    C5378c.m8123a(c7620bi, emojiInfo);
                }
                if (C5378c.dHm()) {
                    if (c7620bi != null && c7620bi.field_status == 2 && C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                        if (c5379a.zci != null) {
                            c5379a.zci.setVisibility(0);
                        }
                    } else if (c5379a.zci != null) {
                        c5379a.zci.setVisibility(8);
                    }
                }
                c5379a.zdM.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, c46650a.dFu(), 0));
                rTChattingEmojiView = c5379a.zdM;
                if (this.zdS == null) {
                    this.zdS = new C24968a(c46650a);
                }
                rTChattingEmojiView.setOnClickListener(this.zdS);
                c5379a.zdM.setOnLongClickListener(mo11021c(c46650a));
                c5379a.zdM.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            }
            AppMethodBeat.m2505o(32947);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32948);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C8910b c8910b;
                int i = ((C40814ay) view.getTag()).position;
                C44218ap aps = C44218ap.aps(c7620bi.field_content);
                C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
                if (X == null) {
                    X = new C8910b();
                    X.fgq = aps.cvZ;
                    c8910b = X;
                } else {
                    c8910b = X;
                }
                if (!(C42252ah.isNullOrNil(c8910b.fgq) || c8910b.fgq.equals("-1"))) {
                    EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq);
                    if (Jd != null) {
                        if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS())) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(C25738R.string.amj));
                        }
                        C7060h.pYm.mo8381e(12789, Integer.valueOf(0), Jd.mo20410Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", Jd.field_activityid);
                        boolean duP = Jd.duP();
                        if (Jd.field_catalog == EmojiInfo.yaB || C5046bo.isNullOrNil(Jd.field_groupId) || (!C5046bo.isNullOrNil(Jd.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(Jd.field_groupId))) {
                            if (duP) {
                                contextMenu.add(i, 113, 0, C25738R.string.dr1);
                            } else {
                                C4990ab.m7416i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                            }
                        }
                        if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjR()) {
                            contextMenu.add(i, C44697b.CTRL_INDEX, 0, view.getContext().getString(C25738R.string.am_));
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", c8910b.fgq);
                    }
                }
                if (c7620bi.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                }
                if (!c7620bi.drC() && c7620bi.dty() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am5));
                }
            }
            AppMethodBeat.m2505o(32948);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32949);
            boolean a = ((C44298m) c46650a.mo74857aF(C44298m.class)).mo48876a(menuItem, c46650a, c7620bi);
            AppMethodBeat.m2505o(32949);
            return a;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32950);
            if (c7620bi.bAA()) {
                C4733l.m7097al(c7620bi);
                C1829bf.m3748fm(c7620bi.field_msgId);
                c46650a.mo74882qp(true);
                AppMethodBeat.m2505o(32950);
                return;
            }
            AppMethodBeat.m2505o(32950);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.k$a */
    public static class C24968a extends C23812e {
        C24968a(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32936);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                String talkerUserName;
                C7620bi c7620bi2 = c40814ay.cKd;
                if (C1855t.m3896kH(c7620bi2.field_talker)) {
                    talkerUserName = this.yJI.getTalkerUserName();
                } else {
                    talkerUserName = null;
                }
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35617a(this.yJI.yTx.getContext(), c7620bi2, talkerUserName);
                C7060h.pYm.mo8381e(11592, Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(32936);
        }
    }
}

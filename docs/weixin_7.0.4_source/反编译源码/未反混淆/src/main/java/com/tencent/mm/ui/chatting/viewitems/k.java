package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class k {

    public static final class b extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public static Map<String, WeakReference<b>> zdR = new HashMap();
        ProgressBar pyf;
        ImageView zci;
        RTChattingEmojiView zdM;
        ImageView zdN;
        ProgressBar zdO;
        ImageView zdP;
        TextView zdQ;

        static {
            AppMethodBeat.i(32939);
            AppMethodBeat.o(32939);
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            AppMethodBeat.i(32937);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zdM = (RTChattingEmojiView) view.findViewById(R.id.aqy);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.zdO = (ProgressBar) view.findViewById(R.id.aqz);
            this.zdP = (ImageView) view.findViewById(R.id.ar1);
            this.zdQ = (TextView) view.findViewById(R.id.ar0);
            if (!z) {
                this.pyf = (ProgressBar) view.findViewById(R.id.at6);
                this.zby = (ImageView) view.findViewById(R.id.asb);
                this.zci = (ImageView) view.findViewById(R.id.at7);
            }
            if (this.zdN != null) {
                ((ViewGroup) this.zdN.getParent()).setBackgroundDrawable(null);
            }
            this.qkY = (TextView) view.findViewById(R.id.od);
            AppMethodBeat.o(32937);
            return this;
        }

        public static void n(String str, int i, int i2) {
            AppMethodBeat.i(32938);
            if (zdR.containsKey(str)) {
                b bVar = (b) ((WeakReference) zdR.get(str)).get();
                if (bVar != null) {
                    switch (i2) {
                        case 0:
                            bVar.zdO.setVisibility(0);
                            bVar.zdQ.setVisibility(8);
                            bVar.zdP.setVisibility(8);
                            bVar.zdO.setProgress(0);
                            break;
                        case 1:
                            bVar.zdO.setVisibility(8);
                            bVar.zdQ.setVisibility(8);
                            bVar.zdP.setVisibility(8);
                            AppMethodBeat.o(32938);
                            return;
                        case 2:
                            bVar.zdO.setVisibility(8);
                            bVar.zdQ.setVisibility(8);
                            bVar.zdP.setVisibility(0);
                            bVar.zdO.setProgress(i);
                            bVar.zdP.setImageResource(R.drawable.emoji_download_failed_btn);
                            AppMethodBeat.o(32938);
                            return;
                    }
                }
                AppMethodBeat.o(32938);
                return;
            }
            ab.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
            AppMethodBeat.o(32938);
        }
    }

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected a zdS;

        private a j(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(32940);
            if (this.zdS == null) {
                this.zdS = new a(aVar);
            }
            a aVar2 = this.zdS;
            AppMethodBeat.o(32940);
            return aVar2;
        }

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 1048625) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32941);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m5);
                view.setTag(new b().z(view, true));
            }
            AppMethodBeat.o(32941);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            EmojiInfo emojiInfo;
            AppMethodBeat.i(32942);
            this.yJI = aVar2;
            ((j) aVar2.aF(j.class)).bg(biVar);
            b bVar = (b) aVar;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X == null || X.fgq == null) {
                emojiInfo = null;
            } else {
                emojiInfo = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(X.fgq);
            }
            if (emojiInfo == null || !emojiInfo.duP()) {
                Bitmap v;
                String I = o.ahl().I(biVar.field_imgPath, true);
                Bitmap sB = o.ahp().sB(I);
                if (sB == null || sB.isRecycled()) {
                    sB = com.tencent.mm.sdk.platformtools.d.decodeFile(I, null);
                    o.ahp().j(I, sB);
                }
                if (emojiInfo == null) {
                    bVar.zdP.setVisibility(0);
                    bVar.zdO.setVisibility(8);
                    bVar.zdQ.setText(ah.ga(X == null ? 0 : (long) X.fgo));
                    bVar.zdQ.setVisibility(0);
                    bVar.zdP.setImageResource(R.drawable.emoji_download_btn);
                } else {
                    bVar.zdO.setVisibility(0);
                    bVar.zdQ.setVisibility(8);
                    bVar.zdP.setVisibility(8);
                    bVar.zdO.setProgress(0);
                    bVar.zdQ.setVisibility(8);
                }
                if (!(X == null || bo.isNullOrNil(X.fgq))) {
                    b.zdR.put(X.fgq, new WeakReference(bVar));
                }
                if (sB == null || sB.isRecycled()) {
                    v = com.tencent.mm.sdk.platformtools.d.v(this.yJI.yTx.getMMResources().getDrawable(R.drawable.aay));
                } else {
                    v = sB;
                }
                bVar.zdM.setImageBitmap(v);
            } else {
                emojiInfo.talker = biVar.field_talker;
                bVar.zdM.a(emojiInfo, biVar.field_msgId);
                bVar.zdP.setVisibility(8);
                bVar.zdO.setVisibility(8);
                bVar.zdQ.setVisibility(8);
                bVar.zdP.setVisibility(8);
                if (!(X == null || bo.isNullOrNil(X.fgq))) {
                    b.zdR.remove(X.fgq);
                }
                c.a(biVar, emojiInfo);
            }
            bVar.zdM.setTag(new ay(biVar, aVar2.dFx(), i, str, 0));
            bVar.zdM.setOnClickListener(j(aVar2));
            bVar.zdM.setOnLongClickListener(c(aVar2));
            bVar.zdM.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            bVar.zdP.setOnClickListener(j(aVar2));
            bVar.zdP.setOnLongClickListener(c(aVar2));
            bVar.zdP.setTag(bVar.zdM.getTag());
            AppMethodBeat.o(32942);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(32943);
            boolean dFx = aVar.dFx();
            AppMethodBeat.o(32943);
            return dFx;
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            com.tencent.mm.af.j.b bVar;
            AppMethodBeat.i(32944);
            int i = ((ay) view.getTag()).position;
            ap aps = ap.aps(biVar.field_content);
            com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(biVar.field_content, biVar.field_reserved);
            if (X == null) {
                X = new com.tencent.mm.af.j.b();
                X.fgq = aps.cvZ;
                bVar = X;
            } else {
                bVar = X;
            }
            if (!(ah.isNullOrNil(bVar.fgq) || bVar.fgq.equals("-1"))) {
                EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(bVar.fgq);
                if (Jd != null) {
                    if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS())) {
                        contextMenu.add(i, 104, 0, view.getContext().getString(R.string.amj));
                    }
                    if (Jd != null) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(12789, Integer.valueOf(0), Jd.Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", Jd.field_activityid);
                    }
                    boolean duP = Jd.duP();
                    if (Jd.field_catalog == EmojiInfo.yaB || bo.isNullOrNil(Jd.field_groupId) || (!bo.isNullOrNil(Jd.field_groupId) && ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ji(Jd.field_groupId))) {
                        if (duP) {
                            contextMenu.add(i, 113, 0, R.string.dr1);
                        } else {
                            ab.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bjR()) {
                        contextMenu.add(i, com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX, 0, view.getContext().getString(R.string.am_));
                    }
                }
            }
            if (bh.o(biVar)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am5));
            }
            AppMethodBeat.o(32944);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32945);
            boolean a = ((m) aVar.aF(m.class)).a(menuItem, aVar, biVar);
            AppMethodBeat.o(32945);
            return a;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class d extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected a zdS;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 1048625) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32946);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n4);
                view.setTag(new b().z(view, false));
            }
            AppMethodBeat.o(32946);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(32947);
            this.yJI = aVar2;
            ((j) aVar2.aF(j.class)).bg(biVar);
            aVar = (b) aVar;
            com.tencent.mm.af.j.b bVar = null;
            if (biVar != null) {
                EmojiInfo emojiInfo;
                RTChattingEmojiView rTChattingEmojiView;
                String str2 = biVar.field_content;
                ap aps = ap.aps(biVar.field_content);
                EmojiInfo emojiInfo2 = null;
                if (!aps.fWX) {
                    if (str2 != null) {
                        bVar = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
                    }
                    if (bVar != null) {
                        emojiInfo2 = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(bVar.fgq);
                    }
                }
                if (aps.cvZ == null || aps.cvZ.equals("-1") || emojiInfo2 != null) {
                    emojiInfo = emojiInfo2;
                } else {
                    emojiInfo = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(aps.cvZ);
                }
                if (emojiInfo == null || !emojiInfo.duP()) {
                    long j;
                    str2 = o.ahl().I(biVar.field_imgPath, true);
                    Bitmap sB = o.ahp().sB(str2);
                    if (sB == null || sB.isRecycled()) {
                        sB = com.tencent.mm.sdk.platformtools.d.decodeFile(str2, null);
                        o.ahp().j(str2, sB);
                    }
                    aVar.pyf.setVisibility(8);
                    aVar.zdP.setVisibility(0);
                    aVar.zdO.setVisibility(8);
                    TextView textView = aVar.zdQ;
                    if (bVar == null) {
                        j = 0;
                    } else {
                        j = (long) bVar.fgo;
                    }
                    textView.setText(ah.ga(j));
                    aVar.zdQ.setVisibility(0);
                    aVar.zdP.setImageResource(R.drawable.emoji_download_btn);
                    if (sB == null || sB.isRecycled()) {
                        sB = com.tencent.mm.sdk.platformtools.d.v(this.yJI.yTx.getMMResources().getDrawable(R.drawable.aay));
                    }
                    aVar.zdM.setImageBitmap(sB);
                    if (!(bVar == null || bo.isNullOrNil(bVar.fgq))) {
                        b.zdR.put(bVar.fgq, new WeakReference(aVar));
                    }
                } else {
                    int i2;
                    emojiInfo.talker = biVar.field_talker;
                    aVar.zdM.a(emojiInfo, biVar.field_msgId);
                    rTChattingEmojiView = aVar.zdM;
                    if (rTChattingEmojiView.vpQ != null) {
                        rTChattingEmojiView.vpQ.resume();
                    }
                    Object obj = biVar.field_status != 1 ? 1 : null;
                    ProgressBar progressBar = aVar.pyf;
                    if (obj != null) {
                        i2 = 8;
                    } else {
                        i2 = 0;
                    }
                    progressBar.setVisibility(i2);
                    c.a(biVar, emojiInfo);
                }
                if (c.dHm()) {
                    if (biVar != null && biVar.field_status == 2 && c.a((h) aVar2.aF(h.class), biVar.field_msgId)) {
                        if (aVar.zci != null) {
                            aVar.zci.setVisibility(0);
                        }
                    } else if (aVar.zci != null) {
                        aVar.zci.setVisibility(8);
                    }
                }
                aVar.zdM.setTag(new ay(biVar, aVar2.dFx(), i, aVar2.dFu(), 0));
                rTChattingEmojiView = aVar.zdM;
                if (this.zdS == null) {
                    this.zdS = new a(aVar2);
                }
                rTChattingEmojiView.setOnClickListener(this.zdS);
                aVar.zdM.setOnLongClickListener(c(aVar2));
                aVar.zdM.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            }
            AppMethodBeat.o(32947);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32948);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.af.j.b bVar;
                int i = ((ay) view.getTag()).position;
                ap aps = ap.aps(biVar.field_content);
                com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(biVar.field_content, biVar.field_reserved);
                if (X == null) {
                    X = new com.tencent.mm.af.j.b();
                    X.fgq = aps.cvZ;
                    bVar = X;
                } else {
                    bVar = X;
                }
                if (!(ah.isNullOrNil(bVar.fgq) || bVar.fgq.equals("-1"))) {
                    EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(bVar.fgq);
                    if (Jd != null) {
                        if (!(Jd.field_catalog == EmojiInfo.yaB || Jd.duS())) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.string.amj));
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.e(12789, Integer.valueOf(0), Jd.Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", Jd.field_activityid);
                        boolean duP = Jd.duP();
                        if (Jd.field_catalog == EmojiInfo.yaB || bo.isNullOrNil(Jd.field_groupId) || (!bo.isNullOrNil(Jd.field_groupId) && ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ji(Jd.field_groupId))) {
                            if (duP) {
                                contextMenu.add(i, 113, 0, R.string.dr1);
                            } else {
                                ab.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                            }
                        }
                        if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bjR()) {
                            contextMenu.add(i, com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX, 0, view.getContext().getString(R.string.am_));
                        }
                    } else {
                        ab.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", bVar.fgq);
                    }
                }
                if (biVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                }
                if (!biVar.drC() && biVar.dty() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am5));
                }
            }
            AppMethodBeat.o(32948);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32949);
            boolean a = ((m) aVar.aF(m.class)).a(menuItem, aVar, biVar);
            AppMethodBeat.o(32949);
            return a;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32950);
            if (biVar.bAA()) {
                l.al(biVar);
                bf.fm(biVar.field_msgId);
                aVar.qp(true);
                AppMethodBeat.o(32950);
                return;
            }
            AppMethodBeat.o(32950);
        }
    }

    public static class a extends e {
        a(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32936);
            ay ayVar = (ay) view.getTag();
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                String talkerUserName;
                bi biVar2 = ayVar.cKd;
                if (t.kH(biVar2.field_talker)) {
                    talkerUserName = this.yJI.getTalkerUserName();
                } else {
                    talkerUserName = null;
                }
                ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.yJI.yTx.getContext(), biVar2, talkerUserName);
                com.tencent.mm.plugin.report.service.h.pYm.e(11592, Integer.valueOf(0));
            }
            AppMethodBeat.o(32936);
        }
    }
}

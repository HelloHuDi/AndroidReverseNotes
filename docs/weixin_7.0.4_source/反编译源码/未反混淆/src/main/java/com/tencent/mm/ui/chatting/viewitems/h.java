package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class h {

    static final class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        View gbS;
        ImageView zci;
        MMTextView zdy;

        a() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            AppMethodBeat.i(32902);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.zdy = (MMTextView) view.findViewById(R.id.oe);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.gbS = view.findViewById(R.id.aa);
            if (!z) {
                this.zci = (ImageView) view.findViewById(R.id.at7);
                this.zby = (ImageView) view.findViewById(R.id.asb);
                this.pyf = (ProgressBar) view.findViewById(R.id.at6);
            }
            AppMethodBeat.o(32902);
            return this;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 503316529) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32903);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.ml);
                view.setTag(new a().z(view, true));
            }
            AppMethodBeat.o(32903);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(32904);
            boolean dFx = aVar.dFx();
            AppMethodBeat.o(32904);
            return dFx;
        }

        private static String arD(String str) {
            String decode;
            AppMethodBeat.i(32905);
            try {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                if (me != null) {
                    decode = URLDecoder.decode(me.content, "UTF-8");
                    AppMethodBeat.o(32905);
                    return decode;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", e.getMessage());
            }
            decode = "";
            AppMethodBeat.o(32905);
            return decode;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            String trim;
            MMTextView mMTextView;
            int type;
            AppMethodBeat.i(32906);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            String talkerUserName = aVar2.getTalkerUserName();
            d dVar = (d) aVar2.aF(d.class);
            if (aVar2.dFx() && !dVar.dDm()) {
                int ox = bf.ox(str2);
                if (ox != -1) {
                    trim = str2.substring(0, ox).trim();
                    if (trim == null || trim.length() <= 0) {
                        trim = talkerUserName;
                    }
                    str2 = str2.substring(ox + 1).trim();
                    talkerUserName = arD(str2);
                    a((com.tencent.mm.ui.chatting.viewitems.c.a) aVar3, aVar2, biVar, trim);
                    a((com.tencent.mm.ui.chatting.viewitems.c.a) aVar3, aVar2, trim, biVar);
                    aVar3.zdy.setText(talkerUserName);
                    mMTextView = aVar3.zdy;
                    type = biVar.getType();
                    str2 = aVar2.getTalkerUserName();
                    if (type != 301989937) {
                        j.a(mMTextView, str2);
                    }
                    mMTextView.getText();
                    aVar3.zdy.setTag(ay.b(biVar, aVar2.dFx(), i));
                    aVar3.zdy.setOnLongClickListener(c(aVar2));
                    aVar3.zdy.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCY());
                    AppMethodBeat.o(32906);
                }
            }
            trim = talkerUserName;
            talkerUserName = arD(str2);
            a((com.tencent.mm.ui.chatting.viewitems.c.a) aVar3, aVar2, biVar, trim);
            a((com.tencent.mm.ui.chatting.viewitems.c.a) aVar3, aVar2, trim, biVar);
            aVar3.zdy.setText(talkerUserName);
            mMTextView = aVar3.zdy;
            type = biVar.getType();
            str2 = aVar2.getTalkerUserName();
            if (type != 301989937) {
            }
            mMTextView.getText();
            aVar3.zdy.setTag(ay.b(biVar, aVar2.dFx(), i));
            aVar3.zdy.setOnLongClickListener(c(aVar2));
            aVar3.zdy.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCY());
            AppMethodBeat.o(32906);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32907);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, view.getContext().getString(R.string.am7));
            AppMethodBeat.o(32907);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class c extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 503316529) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32908);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nj);
                view.setTag(new a().z(view, false));
            }
            AppMethodBeat.o(32908);
            return view;
        }

        private static String arD(String str) {
            String decode;
            AppMethodBeat.i(32909);
            try {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                if (me != null) {
                    decode = URLDecoder.decode(me.content, "UTF-8");
                    AppMethodBeat.o(32909);
                    return decode;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", e.getMessage());
            }
            decode = "";
            AppMethodBeat.o(32909);
            return decode;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(32910);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            if (c.dHm()) {
                if (aVar3.pyf != null) {
                    aVar3.pyf.setVisibility(8);
                }
                if (biVar.field_status == 1 || biVar.field_status == 5) {
                    if (aVar3.zci != null) {
                        aVar3.zci.setVisibility(8);
                    }
                    aVar3.zdy.setBackgroundResource(R.drawable.j5);
                    biVar.xZd = true;
                } else {
                    aVar3.zdy.setBackgroundResource(R.drawable.j4);
                    if (aVar3.zci != null) {
                        if (c.a((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class), biVar.field_msgId)) {
                            if (biVar.xZd) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                aVar3.zdy.startAnimation(alphaAnimation);
                                biVar.xZd = false;
                            }
                            aVar3.zci.setVisibility(0);
                        } else {
                            aVar3.zci.setVisibility(8);
                        }
                    }
                }
            } else if (aVar3.pyf != null) {
                aVar3.pyf.setVisibility(biVar.field_status >= 2 ? 8 : 0);
            }
            String arD = arD(biVar.field_content);
            if (bo.isNullOrNil(arD)) {
                ab.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
            }
            aVar3.zdy.setMinWidth(0);
            aVar3.zdy.setText(arD);
            MMTextView mMTextView = aVar3.zdy;
            int type = biVar.getType();
            String talkerUserName = aVar2.getTalkerUserName();
            if (type != 301989937) {
                j.a(mMTextView, talkerUserName);
            }
            mMTextView.getText();
            aVar3.zdy.setTag(ay.b(biVar, aVar2.dFx(), i));
            aVar3.zdy.setOnLongClickListener(c(aVar2));
            aVar3.zdy.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCY());
            a(i, (com.tencent.mm.ui.chatting.viewitems.c.a) aVar3, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(32910);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32911);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, view.getContext().getString(R.string.am7));
            AppMethodBeat.o(32911);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32912);
            if (biVar.bAA()) {
                l.al(biVar);
                bf.fm(biVar.field_msgId);
                aVar.qp(true);
                AppMethodBeat.o(32912);
                return;
            }
            AppMethodBeat.o(32912);
        }
    }
}

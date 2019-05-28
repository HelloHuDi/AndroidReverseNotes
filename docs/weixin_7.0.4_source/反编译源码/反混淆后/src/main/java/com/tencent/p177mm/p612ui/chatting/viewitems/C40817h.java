package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.widget.MMTextView;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.net.URLDecoder;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.h */
public final class C40817h {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.h$a */
    static final class C5421a extends C5379a {
        View gbS;
        ImageView zci;
        MMTextView zdy;

        C5421a() {
        }

        /* renamed from: z */
        public final C5379a mo11060z(View view, boolean z) {
            AppMethodBeat.m2504i(32902);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.zdy = (MMTextView) view.findViewById(2131821103);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.gbS = view.findViewById(2131820581);
            if (!z) {
                this.zci = (ImageView) view.findViewById(2131822661);
                this.zby = (ImageView) view.findViewById(2131822629);
                this.pyf = (ProgressBar) view.findViewById(2131822660);
            }
            AppMethodBeat.m2505o(32902);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.h$b */
    public static class C36220b extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 503316529) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32903);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969069);
                view.setTag(new C5421a().mo11060z(view, true));
            }
            AppMethodBeat.m2505o(32903);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            AppMethodBeat.m2504i(32904);
            boolean dFx = c46650a.dFx();
            AppMethodBeat.m2505o(32904);
            return dFx;
        }

        private static String arD(String str) {
            String decode;
            AppMethodBeat.m2504i(32905);
            try {
                C8910b me = C8910b.m16064me(str);
                if (me != null) {
                    decode = URLDecoder.decode(me.content, "UTF-8");
                    AppMethodBeat.m2505o(32905);
                    return decode;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", e.getMessage());
            }
            decode = "";
            AppMethodBeat.m2505o(32905);
            return decode;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            String trim;
            MMTextView mMTextView;
            int type;
            AppMethodBeat.m2504i(32906);
            this.yJI = c46650a;
            C5421a c5421a = (C5421a) c5379a;
            String str2 = c7620bi.field_content;
            String talkerUserName = c46650a.getTalkerUserName();
            C36135d c36135d = (C36135d) c46650a.mo74857aF(C36135d.class);
            if (c46650a.dFx() && !c36135d.dDm()) {
                int ox = C1829bf.m3761ox(str2);
                if (ox != -1) {
                    trim = str2.substring(0, ox).trim();
                    if (trim == null || trim.length() <= 0) {
                        trim = talkerUserName;
                    }
                    str2 = str2.substring(ox + 1).trim();
                    talkerUserName = C36220b.arD(str2);
                    mo11011a((C5379a) c5421a, c46650a, c7620bi, trim);
                    mo11012a((C5379a) c5421a, c46650a, trim, c7620bi);
                    c5421a.zdy.setText(talkerUserName);
                    mMTextView = c5421a.zdy;
                    type = c7620bi.getType();
                    str2 = c46650a.getTalkerUserName();
                    if (type != 301989937) {
                        C44089j.m79289a(mMTextView, str2);
                    }
                    mMTextView.getText();
                    c5421a.zdy.setTag(C40814ay.m70730b(c7620bi, c46650a.dFx(), i));
                    c5421a.zdy.setOnLongClickListener(mo11021c(c46650a));
                    c5421a.zdy.setOnDoubleClickLitsener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCY());
                    AppMethodBeat.m2505o(32906);
                }
            }
            trim = talkerUserName;
            talkerUserName = C36220b.arD(str2);
            mo11011a((C5379a) c5421a, c46650a, c7620bi, trim);
            mo11012a((C5379a) c5421a, c46650a, trim, c7620bi);
            c5421a.zdy.setText(talkerUserName);
            mMTextView = c5421a.zdy;
            type = c7620bi.getType();
            str2 = c46650a.getTalkerUserName();
            if (type != 301989937) {
            }
            mMTextView.getText();
            c5421a.zdy.setTag(C40814ay.m70730b(c7620bi, c46650a.dFx(), i));
            c5421a.zdy.setOnLongClickListener(mo11021c(c46650a));
            c5421a.zdy.setOnDoubleClickLitsener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCY());
            AppMethodBeat.m2505o(32906);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32907);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, view.getContext().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32907);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.h$c */
    public static class C40816c extends C5378c implements C5365n {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 503316529) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32908);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969105);
                view.setTag(new C5421a().mo11060z(view, false));
            }
            AppMethodBeat.m2505o(32908);
            return view;
        }

        private static String arD(String str) {
            String decode;
            AppMethodBeat.m2504i(32909);
            try {
                C8910b me = C8910b.m16064me(str);
                if (me != null) {
                    decode = URLDecoder.decode(me.content, "UTF-8");
                    AppMethodBeat.m2505o(32909);
                    return decode;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", e.getMessage());
            }
            decode = "";
            AppMethodBeat.m2505o(32909);
            return decode;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32910);
            this.yJI = c46650a;
            C5421a c5421a = (C5421a) c5379a;
            if (C5378c.dHm()) {
                if (c5421a.pyf != null) {
                    c5421a.pyf.setVisibility(8);
                }
                if (c7620bi.field_status == 1 || c7620bi.field_status == 5) {
                    if (c5421a.zci != null) {
                        c5421a.zci.setVisibility(8);
                    }
                    c5421a.zdy.setBackgroundResource(C25738R.drawable.f6590j5);
                    c7620bi.xZd = true;
                } else {
                    c5421a.zdy.setBackgroundResource(C25738R.drawable.f6589j4);
                    if (c5421a.zci != null) {
                        if (C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                            if (c7620bi.xZd) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                c5421a.zdy.startAnimation(alphaAnimation);
                                c7620bi.xZd = false;
                            }
                            c5421a.zci.setVisibility(0);
                        } else {
                            c5421a.zci.setVisibility(8);
                        }
                    }
                }
            } else if (c5421a.pyf != null) {
                c5421a.pyf.setVisibility(c7620bi.field_status >= 2 ? 8 : 0);
            }
            String arD = C40816c.arD(c7620bi.field_content);
            if (C5046bo.isNullOrNil(arD)) {
                C4990ab.m7413e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
            }
            c5421a.zdy.setMinWidth(0);
            c5421a.zdy.setText(arD);
            MMTextView mMTextView = c5421a.zdy;
            int type = c7620bi.getType();
            String talkerUserName = c46650a.getTalkerUserName();
            if (type != 301989937) {
                C44089j.m79289a(mMTextView, talkerUserName);
            }
            mMTextView.getText();
            c5421a.zdy.setTag(C40814ay.m70730b(c7620bi, c46650a.dFx(), i));
            c5421a.zdy.setOnLongClickListener(mo11021c(c46650a));
            c5421a.zdy.setOnDoubleClickLitsener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCY());
            mo11007a(i, (C5379a) c5421a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(32910);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32911);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, view.getContext().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32911);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32912);
            if (c7620bi.bAA()) {
                C4733l.m7097al(c7620bi);
                C1829bf.m3748fm(c7620bi.field_msgId);
                c46650a.mo74882qp(true);
                AppMethodBeat.m2505o(32912);
                return;
            }
            AppMethodBeat.m2505o(32912);
        }
    }
}

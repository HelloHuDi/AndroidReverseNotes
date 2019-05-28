package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.j */
public final class C23850j {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.j$b */
    protected static class C15746b extends C5379a {
        TextView iPD;
        View jOR;
        ImageView kPq;
        View zdF;
        TextView zdG;
        View zdH;
        TextView zdI;
        ImageView zdJ;
        TextView zdK;
        TextView zdL;

        protected C15746b() {
        }

        /* renamed from: eV */
        public final C15746b mo27961eV(View view) {
            AppMethodBeat.m2504i(32932);
            super.mo11031eP(view);
            this.jOR = view.findViewById(2131822572);
            this.zdF = view.findViewById(2131821686);
            this.kPq = (ImageView) view.findViewById(2131821433);
            this.iPD = (TextView) view.findViewById(2131821434);
            this.zdG = (TextView) view.findViewById(2131822573);
            this.zdH = view.findViewById(2131822574);
            this.zdI = (TextView) view.findViewById(2131822576);
            this.zdJ = (ImageView) view.findViewById(2131822575);
            this.zdK = (TextView) view.findViewById(2131822577);
            this.zdL = (TextView) view.findViewById(2131820695);
            this.moo = (CheckBox) this.mRR.findViewById(2131820580);
            this.iVh = this.mRR.findViewById(2131820586);
            AppMethodBeat.m2505o(32932);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.j$c */
    public static class C23851c extends C5378c implements OnClickListener {
        C23851c() {
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 671088689) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32933);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969050);
                view.setTag(new C15746b().mo27961eV(view));
            }
            AppMethodBeat.m2505o(32933);
            return view;
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(32935);
            C23852a c23852a = (C23852a) view.getTag();
            if (c23852a == null) {
                AppMethodBeat.m2505o(32935);
            } else if (c23852a.state != 1) {
                ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(view.getContext(), null, null);
                AppMethodBeat.m2505o(32935);
            } else if (C46494g.m87757u(view.getContext(), c23852a.appId)) {
                ((C38855d) C1720g.m3528K(C38855d.class)).mo61729ak(view.getContext(), c23852a.appId);
                AppMethodBeat.m2505o(32935);
            } else {
                ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(view.getContext(), new Intent().putExtra("appId", c23852a.appId), null);
                AppMethodBeat.m2505o(32935);
            }
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return false;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32934);
            String str2 = c7620bi.field_content;
            C8910b c8910b = null;
            if (str2 != null) {
                c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
            }
            if (c8910b == null) {
                AppMethodBeat.m2505o(32934);
                return;
            }
            C15746b c15746b = (C15746b) c5379a;
            C23852a c23852a = (C23852a) c8910b.mo20333X(C23852a.class);
            if (c15746b.iVh != null) {
                c15746b.iVh.setVisibility(8);
            }
            if (c15746b.moo != null) {
                c15746b.moo.setVisibility(8);
            }
            if (c23852a.state == 1) {
                CharSequence format;
                c15746b.zdF.setVisibility(0);
                c15746b.zdH.setVisibility(8);
                c15746b.iPD.setText(c23852a.appName);
                TextView textView = c15746b.zdG;
                long j = (long) c23852a.zdE;
                if (j >= 1073741824) {
                    format = String.format("%.1fGB", new Object[]{Float.valueOf(((((float) j) / 1024.0f) / 1024.0f) / 1024.0f)});
                } else if (j >= 1048576) {
                    format = String.format("%.1fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                } else {
                    format = String.format("%.2fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                }
                textView.setText(format);
                C32291o.ahp().mo43765a(c23852a.iconUrl, c15746b.kPq);
                if (C46494g.m87757u(c46650a.yTx.getContext(), c23852a.appId)) {
                    c15746b.zdL.setText(C25738R.string.b7l);
                } else {
                    c15746b.zdL.setText(C25738R.string.b7j);
                }
            } else {
                c15746b.zdF.setVisibility(8);
                c15746b.zdH.setVisibility(0);
                c15746b.zdI.setText(c46650a.dDw());
                C40460b.m69434b(c15746b.zdJ, c46650a.getTalkerUserName());
                c15746b.zdK.setText(c46650a.yTx.getContext().getResources().getString(C25738R.string.b7x, new Object[]{c23852a.appName}));
                c15746b.zdL.setText(C25738R.string.b7o);
            }
            c15746b.jOR.setTag(c23852a);
            c15746b.jOR.setOnClickListener(this);
            AppMethodBeat.m2505o(32934);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.j$a */
    public static class C23852a extends C37435f {
        public String appId;
        public String appName;
        public String iconUrl;
        public int state;
        public int zdE;

        /* renamed from: Xz */
        public final C37435f mo20330Xz() {
            AppMethodBeat.m2504i(32929);
            C23852a c23852a = new C23852a();
            AppMethodBeat.m2505o(32929);
            return c23852a;
        }

        /* renamed from: a */
        public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
        }

        /* renamed from: a */
        public final void mo20332a(Map<String, String> map, C8910b c8910b) {
            AppMethodBeat.m2504i(32930);
            if (c8910b.type == 671088689) {
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgDownloader", "values: %s", map.toString());
                this.state = C5046bo.getInt(C23852a.m36719w(map, "state"), 0);
                this.appId = C23852a.m36719w(map, "appid");
                this.appName = C23852a.m36719w(map, "appname");
                this.zdE = C5046bo.getInt(C23852a.m36719w(map, "appsize"), 0);
                this.iconUrl = C23852a.m36719w(map, "iconurl");
            }
            AppMethodBeat.m2505o(32930);
        }

        /* renamed from: w */
        private static String m36719w(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(32931);
            String nullAsNil = C5046bo.nullAsNil((String) map.get(".msg.appmsg.downloaderapp.".concat(String.valueOf(str))));
            AppMethodBeat.m2505o(32931);
            return nullAsNil;
        }
    }
}

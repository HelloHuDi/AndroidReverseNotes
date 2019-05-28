package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class j {

    protected static class b extends com.tencent.mm.ui.chatting.viewitems.c.a {
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

        protected b() {
        }

        public final b eV(View view) {
            AppMethodBeat.i(32932);
            super.eP(view);
            this.jOR = view.findViewById(R.id.aqs);
            this.zdF = view.findViewById(R.id.a3u);
            this.kPq = (ImageView) view.findViewById(R.id.xb);
            this.iPD = (TextView) view.findViewById(R.id.xc);
            this.zdG = (TextView) view.findViewById(R.id.aqt);
            this.zdH = view.findViewById(R.id.aqu);
            this.zdI = (TextView) view.findViewById(R.id.aqw);
            this.zdJ = (ImageView) view.findViewById(R.id.aqv);
            this.zdK = (TextView) view.findViewById(R.id.aqx);
            this.zdL = (TextView) view.findViewById(R.id.dd);
            this.moo = (CheckBox) this.mRR.findViewById(R.id.a_);
            this.iVh = this.mRR.findViewById(R.id.af);
            AppMethodBeat.o(32932);
            return this;
        }
    }

    public static class c extends c implements OnClickListener {
        c() {
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 671088689) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32933);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m4);
                view.setTag(new b().eV(view));
            }
            AppMethodBeat.o(32933);
            return view;
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(32935);
            a aVar = (a) view.getTag();
            if (aVar == null) {
                AppMethodBeat.o(32935);
            } else if (aVar.state != 1) {
                ((d) g.K(d.class)).a(view.getContext(), null, null);
                AppMethodBeat.o(32935);
            } else if (com.tencent.mm.pluginsdk.model.app.g.u(view.getContext(), aVar.appId)) {
                ((d) g.K(d.class)).ak(view.getContext(), aVar.appId);
                AppMethodBeat.o(32935);
            } else {
                ((d) g.K(d.class)).a(view.getContext(), new Intent().putExtra("appId", aVar.appId), null);
                AppMethodBeat.o(32935);
            }
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(32934);
            String str2 = biVar.field_content;
            com.tencent.mm.af.j.b bVar = null;
            if (str2 != null) {
                bVar = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            }
            if (bVar == null) {
                AppMethodBeat.o(32934);
                return;
            }
            b bVar2 = (b) aVar;
            a aVar3 = (a) bVar.X(a.class);
            if (bVar2.iVh != null) {
                bVar2.iVh.setVisibility(8);
            }
            if (bVar2.moo != null) {
                bVar2.moo.setVisibility(8);
            }
            if (aVar3.state == 1) {
                CharSequence format;
                bVar2.zdF.setVisibility(0);
                bVar2.zdH.setVisibility(8);
                bVar2.iPD.setText(aVar3.appName);
                TextView textView = bVar2.zdG;
                long j = (long) aVar3.zdE;
                if (j >= 1073741824) {
                    format = String.format("%.1fGB", new Object[]{Float.valueOf(((((float) j) / 1024.0f) / 1024.0f) / 1024.0f)});
                } else if (j >= 1048576) {
                    format = String.format("%.1fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                } else {
                    format = String.format("%.2fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                }
                textView.setText(format);
                o.ahp().a(aVar3.iconUrl, bVar2.kPq);
                if (com.tencent.mm.pluginsdk.model.app.g.u(aVar2.yTx.getContext(), aVar3.appId)) {
                    bVar2.zdL.setText(R.string.b7l);
                } else {
                    bVar2.zdL.setText(R.string.b7j);
                }
            } else {
                bVar2.zdF.setVisibility(8);
                bVar2.zdH.setVisibility(0);
                bVar2.zdI.setText(aVar2.dDw());
                com.tencent.mm.pluginsdk.ui.a.b.b(bVar2.zdJ, aVar2.getTalkerUserName());
                bVar2.zdK.setText(aVar2.yTx.getContext().getResources().getString(R.string.b7x, new Object[]{aVar3.appName}));
                bVar2.zdL.setText(R.string.b7o);
            }
            bVar2.jOR.setTag(aVar3);
            bVar2.jOR.setOnClickListener(this);
            AppMethodBeat.o(32934);
        }
    }

    public static class a extends f {
        public String appId;
        public String appName;
        public String iconUrl;
        public int state;
        public int zdE;

        public final f Xz() {
            AppMethodBeat.i(32929);
            a aVar = new a();
            AppMethodBeat.o(32929);
            return aVar;
        }

        public final void a(StringBuilder stringBuilder, com.tencent.mm.af.j.b bVar, String str, com.tencent.mm.i.d dVar, int i, int i2) {
        }

        public final void a(Map<String, String> map, com.tencent.mm.af.j.b bVar) {
            AppMethodBeat.i(32930);
            if (bVar.type == 671088689) {
                ab.i("MicroMsg.ChattingItemAppMsgDownloader", "values: %s", map.toString());
                this.state = bo.getInt(w(map, "state"), 0);
                this.appId = w(map, "appid");
                this.appName = w(map, "appname");
                this.zdE = bo.getInt(w(map, "appsize"), 0);
                this.iconUrl = w(map, "iconurl");
            }
            AppMethodBeat.o(32930);
        }

        private static String w(Map<String, String> map, String str) {
            AppMethodBeat.i(32931);
            String nullAsNil = bo.nullAsNil((String) map.get(".msg.appmsg.downloaderapp.".concat(String.valueOf(str))));
            AppMethodBeat.o(32931);
            return nullAsNil;
        }
    }
}

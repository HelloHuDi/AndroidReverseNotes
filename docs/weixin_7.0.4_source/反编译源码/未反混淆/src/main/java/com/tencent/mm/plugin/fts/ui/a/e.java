package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;

public final class e extends k {
    public int count;
    private a mKh = new a();
    b mKi = new b();
    public String talker;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(61978);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a19, viewGroup, false);
            b bVar = e.this.mKi;
            bVar.kxr = (TextView) inflate.findViewById(R.id.aw4);
            bVar.contentView = inflate.findViewById(R.id.qj);
            bVar.mKk = inflate.findViewById(R.id.it);
            bVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            inflate.setTag(bVar);
            AppMethodBeat.o(61978);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61979);
            b bVar = (b) aVar;
            m.b(e.this.mKQ, bVar.kxr);
            bVar.contentView.setBackgroundResource(R.drawable.a_r);
            com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, e.this.talker);
            if (e.this.position == 0) {
                bVar.mKk.setVisibility(8);
                AppMethodBeat.o(61979);
                return;
            }
            bVar.mKk.setVisibility(0);
            AppMethodBeat.o(61979);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView kxr;
        public View mKk;

        public b() {
            super();
        }
    }

    public e(int i) {
        super(i);
        AppMethodBeat.i(61980);
        AppMethodBeat.o(61980);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(61981);
        this.mKQ = context.getString(R.string.e0y, new Object[]{TextUtils.ellipsize(d.LC(this.talker), c.mHz, 500.0f, TruncateAt.MIDDLE)});
        AppMethodBeat.o(61981);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKh;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.a bBi() {
        return this.mKi;
    }
}

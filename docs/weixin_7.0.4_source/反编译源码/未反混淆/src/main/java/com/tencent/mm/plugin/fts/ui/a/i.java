package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bo;

public final class i extends com.tencent.mm.plugin.fts.a.d.a.a {
    public String mEp;
    public boolean mKF;
    public CharSequence mKG;
    private b mKH = new b();
    private a mKI = new a();

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(61995);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1b, viewGroup, false);
            a aVar = new a();
            aVar.mJS = (TextView) inflate.findViewById(R.id.n0);
            aVar.iqT = (ImageView) inflate.findViewById(R.id.rq);
            aVar.mKk = inflate.findViewById(R.id.it);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(61995);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61996);
            a aVar3 = (a) aVar;
            i iVar = (i) aVar2;
            m.p(aVar3.contentView, i.this.mFk);
            aVar3.mJS.setText(iVar.mKG);
            aVar3.iqT.setImageResource(R.raw.fts_more_button_icon);
            if (i.this.position == 0 || !i.this.mKF) {
                aVar3.mKk.setVisibility(8);
                AppMethodBeat.o(61996);
                return;
            }
            aVar3.mKk.setVisibility(0);
            AppMethodBeat.o(61996);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(61997);
            Intent intent = new Intent();
            intent.putExtra("key_talker_query", i.this.mDz.mEb[0]);
            intent.putExtra("key_query", i.this.mDz.mEb[1]);
            intent.putExtra("Search_Scene", i.this.mFa);
            if (bo.isNullOrNil(i.this.mEp)) {
                d.c(context, ".ui.FTSTalkerMessageUI", intent);
            } else {
                intent.putExtra("key_conv", i.this.mEp);
                intent.putExtra("detail_type", 1);
                d.c(context, ".ui.FTSConvTalkerMessageUI", intent);
            }
            AppMethodBeat.o(61997);
            return true;
        }
    }

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;
        public View mKk;

        public a() {
            super();
        }
    }

    public i(int i) {
        super(19, i);
        AppMethodBeat.i(61998);
        AppMethodBeat.o(61998);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(61999);
        CharSequence ellipsize = TextUtils.ellipsize(this.mDz.mEb[0], c.mHz, 200.0f, TruncateAt.MIDDLE);
        CharSequence ellipsize2 = TextUtils.ellipsize(this.mDz.mEb[1], c.mHz, 400.0f, TruncateAt.MIDDLE);
        if (bo.isNullOrNil(this.mEp)) {
            this.mKG = TextUtils.concat(new CharSequence[]{context.getString(R.string.e0z), f.j(ellipsize, ellipsize.length()), context.getString(R.string.e10), f.j(ellipsize2, ellipsize2.length()), context.getString(R.string.e11)});
            AppMethodBeat.o(61999);
            return;
        }
        this.mKG = TextUtils.concat(new CharSequence[]{context.getString(R.string.e12), f.j(ellipsize, ellipsize.length()), context.getString(R.string.e10), f.j(ellipsize2, ellipsize2.length()), context.getString(R.string.e11)});
        AppMethodBeat.o(61999);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKH;
    }
}

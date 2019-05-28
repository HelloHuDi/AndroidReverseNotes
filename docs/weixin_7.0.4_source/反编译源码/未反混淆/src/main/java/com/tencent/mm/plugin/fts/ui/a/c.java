package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.m;

public final class c extends n {
    public boolean mJY;
    private b mJZ = new b();
    a mKa = new a();
    public int resId;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public TextView mKb;
        public ImageView mKc;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(61972);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a17, viewGroup, false);
            a aVar = c.this.mKa;
            aVar.mKb = (TextView) inflate.findViewById(R.id.by2);
            aVar.mKc = (ImageView) inflate.findViewById(R.id.by3);
            inflate.setTag(aVar);
            AppMethodBeat.o(61972);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61973);
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            Resources resources = context.getResources();
            if (c.this.mJY) {
                m.b(resources.getString(R.string.e0s, new Object[]{resources.getString(cVar.resId)}), aVar3.mKb);
                aVar3.mKc.setRotation(0.0f);
                AppMethodBeat.o(61973);
                return;
            }
            m.b(resources.getString(R.string.e0t), aVar3.mKb);
            aVar3.mKc.setRotation(180.0f);
            AppMethodBeat.o(61973);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public c(int i) {
        super(i);
        AppMethodBeat.i(61974);
        AppMethodBeat.o(61974);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mJZ;
    }
}

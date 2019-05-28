package com.tencent.mm.ui.contact.a;

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

public final class j extends a {
    public boolean mJY;
    public int resId;
    com.tencent.mm.ui.contact.a.a.a zqg = new a();
    private b zqi = new b();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView mKb;
        public ImageView mKc;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(105300);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ar5, viewGroup, false);
            a aVar = (a) j.this.zqg;
            aVar.mKb = (TextView) inflate.findViewById(R.id.by2);
            aVar.mKc = (ImageView) inflate.findViewById(R.id.by3);
            inflate.setTag(aVar);
            AppMethodBeat.o(105300);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105301);
            a aVar3 = (a) aVar;
            j jVar = (j) aVar2;
            Resources resources = context.getResources();
            if (j.this.mJY) {
                m.b(resources.getString(R.string.e0s, new Object[]{resources.getString(jVar.resId)}), aVar3.mKb);
                aVar3.mKc.setRotation(0.0f);
                AppMethodBeat.o(105301);
                return;
            }
            m.b(resources.getString(R.string.e0t), aVar3.mKb);
            aVar3.mKc.setRotation(180.0f);
            AppMethodBeat.o(105301);
        }

        public final boolean aov() {
            return false;
        }
    }

    public j(int i) {
        super(1, i);
        AppMethodBeat.i(105302);
        AppMethodBeat.o(105302);
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zqi;
    }
}

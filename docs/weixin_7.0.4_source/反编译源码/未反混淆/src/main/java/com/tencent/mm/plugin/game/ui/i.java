package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class i extends BaseAdapter {
    int Rt;
    private Context mContext;
    int mXC;
    private aa ngk;

    class a {
        public ImageView gvq;
        public TextView ngm;
        public TextView ngn;
        public TextView ngo;
        public TextView ngp;
        GameDetailRankLikeView ngq;

        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }
    }

    public i(Context context) {
        this.mContext = context;
    }

    public final void a(aa aaVar) {
        AppMethodBeat.i(111812);
        this.ngk = aaVar;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(111811);
                i.this.notifyDataSetChanged();
                AppMethodBeat.o(111811);
            }
        });
        AppMethodBeat.o(111812);
    }

    public final int getCount() {
        AppMethodBeat.i(111813);
        if (this.ngk == null) {
            AppMethodBeat.o(111813);
            return 0;
        }
        int size = this.ngk.mXO.size();
        AppMethodBeat.o(111813);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(111814);
        Object obj = this.ngk.mXO.get(i);
        AppMethodBeat.o(111814);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(111815);
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.Rt, viewGroup, false);
            aVar = new a(this, (byte) 0);
            aVar.ngm = (TextView) inflate.findViewById(R.id.c4n);
            aVar.gvq = (ImageView) inflate.findViewById(R.id.c4o);
            aVar.ngn = (TextView) inflate.findViewById(R.id.c4p);
            aVar.ngo = (TextView) inflate.findViewById(R.id.c4q);
            aVar.ngp = (TextView) inflate.findViewById(R.id.c4r);
            aVar.ngq = (GameDetailRankLikeView) inflate.findViewById(R.id.c4s);
            aVar.ngq.setSourceScene(this.mXC);
            o((ViewGroup) inflate);
            inflate.setTag(aVar);
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.model.aa.a aVar2 = (com.tencent.mm.plugin.game.model.aa.a) getItem(i);
        aVar.ngm.setText(aVar2.mXP);
        b.a(aVar.gvq, aVar2.cIS, 0.5f, false);
        ad aoO = ((j) g.K(j.class)).XM().aoO(aVar2.cIS);
        if (aoO != null) {
            aVar.ngn.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, aoO.Oj(), aVar.ngn.getTextSize())));
        } else {
            aVar.ngn.setText("");
        }
        if (bo.isNullOrNil(aVar2.tag)) {
            aVar.ngo.setVisibility(8);
        } else {
            aVar.ngo.setVisibility(0);
            aVar.ngo.setText(aVar2.tag);
        }
        if (bo.isNullOrNil(aVar2.mXS)) {
            aVar.ngp.setText(aVar2.mEA);
            GameDetailRankLikeView gameDetailRankLikeView = aVar.ngq;
            aa aaVar = this.ngk;
            gameDetailRankLikeView.ngr = aaVar;
            gameDetailRankLikeView.mAppId = aaVar.mAppId;
            gameDetailRankLikeView.ngs = (com.tencent.mm.plugin.game.model.aa.a) aaVar.mXO.get(i);
            gameDetailRankLikeView.resetState();
            aVar.ngq.setVisibility(0);
        } else {
            aVar.ngp.setText(aVar2.mXS);
            aVar.ngq.setVisibility(8);
        }
        AppMethodBeat.o(111815);
        return view;
    }

    private void o(ViewGroup viewGroup) {
        AppMethodBeat.i(111816);
        viewGroup.setClipChildren(false);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                o((ViewGroup) childAt);
            }
        }
        AppMethodBeat.o(111816);
    }
}

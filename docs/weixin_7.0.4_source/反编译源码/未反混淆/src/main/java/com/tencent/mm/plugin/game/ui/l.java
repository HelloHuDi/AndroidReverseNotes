package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.ui.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class l extends m {
    public final /* bridge */ /* synthetic */ void Oj(String str) {
        AppMethodBeat.i(112015);
        super.Oj(str);
        AppMethodBeat.o(112015);
    }

    public final /* bridge */ /* synthetic */ void Ok(String str) {
        AppMethodBeat.i(112016);
        super.Ok(str);
        AppMethodBeat.o(112016);
    }

    public final /* bridge */ /* synthetic */ void Ol(String str) {
        AppMethodBeat.i(112017);
        super.Ol(str);
        AppMethodBeat.o(112017);
    }

    public final /* bridge */ /* synthetic */ void U(View view, int i) {
        AppMethodBeat.i(112019);
        super.U(view, i);
        AppMethodBeat.o(112019);
    }

    public final /* bridge */ /* synthetic */ void Y(LinkedList linkedList) {
        AppMethodBeat.i(112026);
        super.Y(linkedList);
        AppMethodBeat.o(112026);
    }

    public final /* bridge */ /* synthetic */ void Z(LinkedList linkedList) {
        AppMethodBeat.i(112025);
        super.Z(linkedList);
        AppMethodBeat.o(112025);
    }

    public final /* bridge */ /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(112020);
        super.a(aVar);
        AppMethodBeat.o(112020);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        AppMethodBeat.i(112018);
        super.clear();
        AppMethodBeat.o(112018);
    }

    public final /* bridge */ /* synthetic */ void e(SparseArray sparseArray) {
        AppMethodBeat.i(112021);
        super.e(sparseArray);
        AppMethodBeat.o(112021);
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        AppMethodBeat.i(112024);
        int itemViewType = super.getItemViewType(i);
        AppMethodBeat.o(112024);
        return itemViewType;
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(112022);
        View view2 = super.getView(i, view, viewGroup);
        AppMethodBeat.o(112022);
        return view2;
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        AppMethodBeat.i(112023);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(112023);
        return viewTypeCount;
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        AppMethodBeat.i(112027);
        super.refresh();
        AppMethodBeat.o(112027);
    }

    public final /* bridge */ /* synthetic */ void setSourceScene(int i) {
        AppMethodBeat.i(112029);
        super.setSourceScene(i);
        AppMethodBeat.o(112029);
    }

    public final /* bridge */ /* synthetic */ void wG(int i) {
        AppMethodBeat.i(112028);
        super.wG(i);
        AppMethodBeat.o(112028);
    }

    public l(Context context) {
        super(context);
        this.nkj = R.layout.a4p;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, b bVar, int i) {
        AppMethodBeat.i(112013);
        bVar.nku.setText(cVar.position);
        bVar.nku.setVisibility(this.nkl ? 0 : 8);
        Bitmap Oi = Oi(cVar.field_appId);
        if (Oi == null || Oi.isRecycled()) {
            bVar.nkv.setImageResource(R.drawable.af7);
        } else {
            bVar.nkv.setImageBitmap(Oi);
        }
        bVar.njw.setText(cVar.field_appName);
        if (bo.isNullOrNil(cVar.mVj)) {
            bVar.nkx.setVisibility(8);
        } else {
            bVar.nkx.setVisibility(0);
            bVar.nkx.setText(cVar.mVj);
        }
        if (bo.isNullOrNil(cVar.mVk)) {
            bVar.nky.setVisibility(8);
        } else {
            bVar.nky.setVisibility(0);
            bVar.nky.setText(cVar.mVk);
        }
        if (bo.ek(cVar.mVu)) {
            if (!bo.isNullOrNil(cVar.mVx)) {
                bVar.nkw.setVisibility(0);
                bVar.nkw.setText(cVar.mVx);
                try {
                    bVar.nkw.setBackgroundDrawable(e.dI(Color.parseColor(cVar.mVy), com.tencent.mm.bz.a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    ab.e("MicroMsg.GameLibraryListAdapter", e.getMessage());
                } catch (Exception e2) {
                    ab.e("MicroMsg.GameLibraryListAdapter", e2.getMessage());
                }
            }
            bVar.nkw.setVisibility(8);
        } else {
            bVar.nkw.setVisibility(0);
            bVar.nkw.setText((CharSequence) cVar.mVu.get(0));
        }
        bVar.nkA.setTextSize(this.ngM);
        bVar.nkz.setOnClickListener(this.nhC);
        bVar.nkA.setOnClickListener(this.nhC);
        bVar.nkz.setTag(cVar);
        bVar.nkA.setTag(cVar);
        this.ngR.a(bVar.nkA, bVar.nkz, cVar, (k) this.nko.get(cVar.field_appId));
        bVar.nkB.setData(cVar.mVs);
        bVar.nkC.removeAllViews();
        View view = (View) this.nkp.get(i);
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            bVar.nkC.addView(view);
        }
        AppMethodBeat.o(112013);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, b bVar) {
        AppMethodBeat.i(112014);
        bVar.nkD.removeAllViews();
        if (!bo.isNullOrNil(cVar.mVn)) {
            View inflate = View.inflate(this.mContext, R.layout.a47, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.c6i);
            com.tencent.mm.at.a.a ahp = o.ahp();
            String str = cVar.mVn;
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePG = true;
            ahp.a(str, imageView, aVar.ahG());
            bVar.nkD.addView(inflate, new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(this.mContext, 100)));
        }
        AppMethodBeat.o(112014);
    }
}

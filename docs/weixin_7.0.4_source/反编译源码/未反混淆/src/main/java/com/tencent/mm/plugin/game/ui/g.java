package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.ui.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class g extends m {
    public final /* bridge */ /* synthetic */ void Oj(String str) {
        AppMethodBeat.i(111761);
        super.Oj(str);
        AppMethodBeat.o(111761);
    }

    public final /* bridge */ /* synthetic */ void Ok(String str) {
        AppMethodBeat.i(111762);
        super.Ok(str);
        AppMethodBeat.o(111762);
    }

    public final /* bridge */ /* synthetic */ void Ol(String str) {
        AppMethodBeat.i(111763);
        super.Ol(str);
        AppMethodBeat.o(111763);
    }

    public final /* bridge */ /* synthetic */ void U(View view, int i) {
        AppMethodBeat.i(111765);
        super.U(view, i);
        AppMethodBeat.o(111765);
    }

    public final /* bridge */ /* synthetic */ void Y(LinkedList linkedList) {
        AppMethodBeat.i(111772);
        super.Y(linkedList);
        AppMethodBeat.o(111772);
    }

    public final /* bridge */ /* synthetic */ void Z(LinkedList linkedList) {
        AppMethodBeat.i(111771);
        super.Z(linkedList);
        AppMethodBeat.o(111771);
    }

    public final /* bridge */ /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(111766);
        super.a(aVar);
        AppMethodBeat.o(111766);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        AppMethodBeat.i(111764);
        super.clear();
        AppMethodBeat.o(111764);
    }

    public final /* bridge */ /* synthetic */ void e(SparseArray sparseArray) {
        AppMethodBeat.i(111767);
        super.e(sparseArray);
        AppMethodBeat.o(111767);
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        AppMethodBeat.i(111770);
        int itemViewType = super.getItemViewType(i);
        AppMethodBeat.o(111770);
        return itemViewType;
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(111768);
        View view2 = super.getView(i, view, viewGroup);
        AppMethodBeat.o(111768);
        return view2;
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        AppMethodBeat.i(111769);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(111769);
        return viewTypeCount;
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        AppMethodBeat.i(111773);
        super.refresh();
        AppMethodBeat.o(111773);
    }

    public final /* bridge */ /* synthetic */ void setSourceScene(int i) {
        AppMethodBeat.i(111775);
        super.setSourceScene(i);
        AppMethodBeat.o(111775);
    }

    public final /* bridge */ /* synthetic */ void wG(int i) {
        AppMethodBeat.i(111774);
        super.wG(i);
        AppMethodBeat.o(111774);
    }

    public g(Context context) {
        super(context);
        this.nkj = R.layout.a34;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, b bVar, int i) {
        AppMethodBeat.i(111760);
        bVar.nku.setText(cVar.position);
        Bitmap Oi = Oi(cVar.field_appId);
        if (Oi == null || Oi.isRecycled()) {
            bVar.nkv.setImageResource(R.drawable.af7);
        } else {
            bVar.nkv.setImageBitmap(Oi);
        }
        bVar.njw.setText(cVar.field_appName);
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
                    ab.e("MicroMsg.GameCenterListAdapter", e.getMessage());
                } catch (Exception e2) {
                    ab.e("MicroMsg.GameCenterListAdapter", e2.getMessage());
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
        AppMethodBeat.o(111760);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, b bVar) {
    }
}

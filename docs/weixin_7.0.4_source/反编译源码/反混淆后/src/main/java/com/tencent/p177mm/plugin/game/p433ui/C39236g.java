package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.p433ui.C43205m.C21032a;
import com.tencent.p177mm.plugin.game.p433ui.C43205m.C28265b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.g */
public final class C39236g extends C43205m {
    /* renamed from: Oj */
    public final /* bridge */ /* synthetic */ void mo62131Oj(String str) {
        AppMethodBeat.m2504i(111761);
        super.mo62131Oj(str);
        AppMethodBeat.m2505o(111761);
    }

    /* renamed from: Ok */
    public final /* bridge */ /* synthetic */ void mo62132Ok(String str) {
        AppMethodBeat.m2504i(111762);
        super.mo62132Ok(str);
        AppMethodBeat.m2505o(111762);
    }

    /* renamed from: Ol */
    public final /* bridge */ /* synthetic */ void mo62133Ol(String str) {
        AppMethodBeat.m2504i(111763);
        super.mo62133Ol(str);
        AppMethodBeat.m2505o(111763);
    }

    /* renamed from: U */
    public final /* bridge */ /* synthetic */ void mo62134U(View view, int i) {
        AppMethodBeat.m2504i(111765);
        super.mo62134U(view, i);
        AppMethodBeat.m2505o(111765);
    }

    /* renamed from: Y */
    public final /* bridge */ /* synthetic */ void mo24020Y(LinkedList linkedList) {
        AppMethodBeat.m2504i(111772);
        super.mo24020Y(linkedList);
        AppMethodBeat.m2505o(111772);
    }

    /* renamed from: Z */
    public final /* bridge */ /* synthetic */ void mo24021Z(LinkedList linkedList) {
        AppMethodBeat.m2504i(111771);
        super.mo24021Z(linkedList);
        AppMethodBeat.m2505o(111771);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo62137a(C21032a c21032a) {
        AppMethodBeat.m2504i(111766);
        super.mo62137a(c21032a);
        AppMethodBeat.m2505o(111766);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        AppMethodBeat.m2504i(111764);
        super.clear();
        AppMethodBeat.m2505o(111764);
    }

    /* renamed from: e */
    public final /* bridge */ /* synthetic */ void mo62138e(SparseArray sparseArray) {
        AppMethodBeat.m2504i(111767);
        super.mo62138e(sparseArray);
        AppMethodBeat.m2505o(111767);
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        AppMethodBeat.m2504i(111770);
        int itemViewType = super.getItemViewType(i);
        AppMethodBeat.m2505o(111770);
        return itemViewType;
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(111768);
        View view2 = super.getView(i, view, viewGroup);
        AppMethodBeat.m2505o(111768);
        return view2;
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        AppMethodBeat.m2504i(111769);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.m2505o(111769);
        return viewTypeCount;
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        AppMethodBeat.m2504i(111773);
        super.refresh();
        AppMethodBeat.m2505o(111773);
    }

    public final /* bridge */ /* synthetic */ void setSourceScene(int i) {
        AppMethodBeat.m2504i(111775);
        super.setSourceScene(i);
        AppMethodBeat.m2505o(111775);
    }

    /* renamed from: wG */
    public final /* bridge */ /* synthetic */ void mo62144wG(int i) {
        AppMethodBeat.m2504i(111774);
        super.mo62144wG(i);
        AppMethodBeat.m2505o(111774);
    }

    public C39236g(Context context) {
        super(context);
        this.nkj = 2130969683;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo62136a(C20992c c20992c, C28265b c28265b, int i) {
        AppMethodBeat.m2504i(111760);
        c28265b.nku.setText(c20992c.position);
        Bitmap Oi = mo24019Oi(c20992c.field_appId);
        if (Oi == null || Oi.isRecycled()) {
            c28265b.nkv.setImageResource(C25738R.drawable.af7);
        } else {
            c28265b.nkv.setImageBitmap(Oi);
        }
        c28265b.njw.setText(c20992c.field_appName);
        if (C5046bo.isNullOrNil(c20992c.mVk)) {
            c28265b.nky.setVisibility(8);
        } else {
            c28265b.nky.setVisibility(0);
            c28265b.nky.setText(c20992c.mVk);
        }
        if (C5046bo.m7548ek(c20992c.mVu)) {
            if (!C5046bo.isNullOrNil(c20992c.mVx)) {
                c28265b.nkw.setVisibility(0);
                c28265b.nkw.setText(c20992c.mVx);
                try {
                    c28265b.nkw.setBackgroundDrawable(C20993e.m32269dI(Color.parseColor(c20992c.mVy), C1338a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    C4990ab.m7412e("MicroMsg.GameCenterListAdapter", e.getMessage());
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.GameCenterListAdapter", e2.getMessage());
                }
            }
            c28265b.nkw.setVisibility(8);
        } else {
            c28265b.nkw.setVisibility(0);
            c28265b.nkw.setText((CharSequence) c20992c.mVu.get(0));
        }
        c28265b.nkA.setTextSize(this.ngM);
        c28265b.nkz.setOnClickListener(this.nhC);
        c28265b.nkA.setOnClickListener(this.nhC);
        c28265b.nkz.setTag(c20992c);
        c28265b.nkA.setTag(c20992c);
        this.ngR.mo73915a(c28265b.nkA, c28265b.nkz, c20992c, (C21003k) this.nko.get(c20992c.field_appId));
        c28265b.nkB.setData(c20992c.mVs);
        AppMethodBeat.m2505o(111760);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo62135a(C20992c c20992c, C28265b c28265b) {
    }
}

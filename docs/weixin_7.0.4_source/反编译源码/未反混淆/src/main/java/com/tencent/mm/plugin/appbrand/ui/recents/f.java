package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class f extends a implements a {
    private final List<a> iNE;
    private final List<Class<? extends a>> iNF = new LinkedList();
    private boolean iNG;
    private final a iNH;
    ViewGroup ius;

    class a {
        final int iNI;
        final int iNJ;
        private final int iNK;
        final int iNL;
        final int iNM;
        final int iNN;

        /* synthetic */ a(f fVar, Context context, byte b) {
            this(context);
        }

        private a(Context context) {
            AppMethodBeat.i(133416);
            this.iNI = e.c(context, 1.0f);
            this.iNJ = com.tencent.mm.bz.a.fromDPToPix(context, 20);
            this.iNK = 0;
            this.iNL = com.tencent.mm.bz.a.fromDPToPix(context, 12);
            this.iNM = com.tencent.mm.bz.a.i(context, R.color.fq);
            this.iNN = 2;
            AppMethodBeat.o(133416);
        }
    }

    public final void eH(boolean z) {
    }

    public f(Activity activity, ViewGroup viewGroup, boolean z, boolean z2) {
        AppMethodBeat.i(133417);
        if (activity == null || viewGroup == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected parameters");
            AppMethodBeat.o(133417);
            throw illegalStateException;
        }
        this.iNH = new a(this, activity, (byte) 0);
        this.iNG = z2;
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        this.ius = linearLayout;
        this.iNE = a(activity, this.ius, z);
        a(this.iNE, this.ius);
        aP(this.iNE);
        AppMethodBeat.o(133417);
    }

    /* Access modifiers changed, original: protected */
    public List<a> a(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.i(133418);
        List arrayList = new ArrayList(2);
        a(arrayList, b(activity, viewGroup, z));
        a(arrayList, c(activity, viewGroup));
        a(arrayList, b(activity, viewGroup));
        a(arrayList, a(activity, viewGroup));
        AppMethodBeat.o(133418);
        return arrayList;
    }

    protected static void a(List<a> list, a aVar) {
        AppMethodBeat.i(133419);
        if (aVar != null) {
            list.add(aVar);
        }
        AppMethodBeat.o(133419);
    }

    /* Access modifiers changed, original: protected */
    public a a(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(133420);
        j jVar = new j(activity, viewGroup);
        jVar.iLV = this;
        AppMethodBeat.o(133420);
        return jVar;
    }

    /* Access modifiers changed, original: protected */
    public a b(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(133421);
        t.axH();
        b bVar = new b(activity, viewGroup);
        bVar.iLV = this;
        AppMethodBeat.o(133421);
        return bVar;
    }

    /* Access modifiers changed, original: protected */
    public a c(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(133422);
        i iVar = new i(activity, viewGroup);
        iVar.iLV = this;
        AppMethodBeat.o(133422);
        return iVar;
    }

    /* Access modifiers changed, original: protected */
    public a b(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.i(133423);
        if (z) {
            c cVar = new c(activity, viewGroup);
            cVar.iLV = this;
            AppMethodBeat.o(133423);
            return cVar;
        }
        AppMethodBeat.o(133423);
        return null;
    }

    private void a(List<a> list, ViewGroup viewGroup) {
        AppMethodBeat.i(133424);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(133424);
        } else if (viewGroup == null) {
            AppMethodBeat.o(133424);
        } else {
            for (int i = 0; i < list.size(); i++) {
                a aVar = (a) list.get(i);
                viewGroup.addView(aVar.aNi());
                if (i != list.size() - 1) {
                    if (i != 0) {
                        list.get(i - 1);
                    }
                    a aVar2 = (a) list.get(i + 1);
                    if (this.iNF.contains(aVar.getClass()) || this.iNF.contains(aVar2.getClass())) {
                        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
                        linearLayout.setOrientation(1);
                        j(linearLayout);
                        viewGroup.addView(linearLayout, -1, -2);
                    } else if (this.iNG) {
                        int dimensionPixelOffset = viewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.tc);
                        int dimensionPixelOffset2 = viewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.t3);
                        LinearLayout linearLayout2 = new LinearLayout(viewGroup.getContext());
                        linearLayout2.setOrientation(0);
                        viewGroup.addView(linearLayout2, -1, -2);
                        Context context = viewGroup.getContext();
                        View view = new View(context);
                        view.setBackgroundColor(-1);
                        LayoutParams layoutParams = new LayoutParams(dimensionPixelOffset2, dimensionPixelOffset);
                        layoutParams.gravity = 3;
                        linearLayout2.addView(view, layoutParams);
                        view = new View(context);
                        view.setBackgroundColor(viewGroup.getResources().getColor(R.color.fz));
                        layoutParams = new LayoutParams(0, dimensionPixelOffset, 1.0f);
                        layoutParams.gravity = 17;
                        linearLayout2.addView(view, layoutParams);
                        view = new View(context);
                        view.setBackgroundColor(-1);
                        LayoutParams layoutParams2 = new LayoutParams(dimensionPixelOffset2, dimensionPixelOffset);
                        layoutParams2.gravity = 5;
                        linearLayout2.addView(view, layoutParams2);
                    } else {
                        View view2 = new View(viewGroup.getContext());
                        view2.setBackgroundColor(-1);
                        LayoutParams layoutParams3 = new LayoutParams(this.iNH.iNJ, this.iNH.iNI);
                        layoutParams3.gravity = 3;
                        viewGroup.addView(view2, layoutParams3);
                    }
                }
            }
            Context context2 = viewGroup.getContext();
            ColorDrawable colorDrawable = new ColorDrawable(this.iNH.iNM);
            ImageView imageView = new ImageView(context2);
            if (this.iNG) {
                imageView.setBackgroundColor(0);
            } else {
                imageView.setImageDrawable(colorDrawable);
                imageView.setBackgroundColor(-1);
            }
            viewGroup.addView(imageView, 0, new LayoutParams(-1, this.iNH.iNN));
            j(viewGroup);
            AppMethodBeat.o(133424);
        }
    }

    private static void aP(List<a> list) {
        AppMethodBeat.i(133425);
        if (list == null) {
            AppMethodBeat.o(133425);
            return;
        }
        for (a eG : list) {
            eG.eG(false);
        }
        AppMethodBeat.o(133425);
    }

    private void j(ViewGroup viewGroup) {
        AppMethodBeat.i(133426);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        Context context = frameLayout.getContext();
        ColorDrawable colorDrawable = new ColorDrawable(this.iNH.iNM);
        ImageView imageView = new ImageView(context);
        if (this.iNG) {
            imageView.setBackgroundColor(0);
        } else {
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
        }
        frameLayout.addView(imageView, -1, this.iNH.iNN);
        frameLayout.addView(new View(context), -1, this.iNH.iNL);
        imageView = new ImageView(context);
        if (this.iNG) {
            imageView.setBackgroundColor(0);
        } else {
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
        }
        frameLayout.addView(imageView, -1, this.iNH.iNN);
        frameLayout.setId(R.id.s);
        viewGroup.addView(frameLayout, -1, -2);
        AppMethodBeat.o(133426);
    }

    public final void aNh() {
        AppMethodBeat.i(133427);
        for (a aNh : this.iNE) {
            aNh.aNh();
        }
        AppMethodBeat.o(133427);
    }

    public final void onDetached() {
        AppMethodBeat.i(133428);
        for (a onDetached : this.iNE) {
            onDetached.onDetached();
        }
        this.iNE.clear();
        AppMethodBeat.o(133428);
    }

    public final void onResume() {
        AppMethodBeat.i(133429);
        for (a onResume : this.iNE) {
            onResume.onResume();
        }
        AppMethodBeat.o(133429);
    }

    public final View aNi() {
        return this.ius;
    }

    public final void pS(int i) {
        AppMethodBeat.i(133430);
        for (a pS : this.iNE) {
            pS.pS(i);
        }
        AppMethodBeat.o(133430);
    }

    public final void pT(int i) {
        AppMethodBeat.i(133431);
        aNs();
        AppMethodBeat.o(133431);
    }

    private void aNs() {
        int i = 0;
        AppMethodBeat.i(133432);
        int i2 = 0;
        for (a aNj : this.iNE) {
            int i3;
            if (aNj.aNj()) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i2 = i3;
        }
        for (a aNj2 : this.iNE) {
            if (aNj2.aNj()) {
                if (i == 0) {
                    aNj2.pT(R.drawable.c_);
                } else if (i == this.iNE.size() - 1 || i == i2 - 1) {
                    aNj2.pT(R.drawable.c8);
                } else {
                    aNj2.pT(R.drawable.c9);
                }
                i++;
            }
        }
        AppMethodBeat.o(133432);
    }

    public final void a(a aVar, View view, boolean z) {
        AppMethodBeat.i(133433);
        if (this.ius == null) {
            AppMethodBeat.o(133433);
            return;
        }
        a aVar2;
        View childAt;
        int i;
        ab.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", aVar, view, Boolean.valueOf(z));
        if (!(this.ius == null || this.iNE == null)) {
            for (int i2 = 0; i2 < this.iNE.size() - 1; i2++) {
                aVar2 = (a) this.iNE.get(i2);
                if (aVar2 != null) {
                    if (aVar2.aNj()) {
                        int i3 = i2 + 1;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= this.iNE.size()) {
                                i3 = 0;
                                break;
                            }
                            a aVar3 = (a) this.iNE.get(i4);
                            if (aVar3 != null && aVar3.aNj()) {
                                i3 = 1;
                                break;
                            }
                            i3 = i4 + 1;
                        }
                        if (i3 != 0) {
                            childAt = this.ius.getChildAt(this.ius.indexOfChild(aVar2.aNi()) + 1);
                            if (childAt != null) {
                                childAt.setVisibility(0);
                            }
                        }
                    } else {
                        childAt = this.ius.getChildAt(this.ius.indexOfChild(aVar2.aNi()) + 1);
                        if (childAt != null) {
                            childAt.setVisibility(8);
                        }
                    }
                }
            }
        }
        for (a aVar22 : this.iNE) {
            childAt = aVar22.aNi();
            if (childAt != null && childAt.getVisibility() == 0) {
                ab.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", aVar);
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            this.ius.setVisibility(0);
        } else {
            this.ius.setVisibility(8);
        }
        if (this.iNG) {
            aNs();
        }
        AppMethodBeat.o(133433);
    }
}

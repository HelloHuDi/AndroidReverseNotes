package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26783t;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C27336a.C27335a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.f */
public class C33565f extends C27336a implements C27335a {
    private final List<C27336a> iNE;
    private final List<Class<? extends C27336a>> iNF = new LinkedList();
    private boolean iNG;
    private final C33564a iNH;
    ViewGroup ius;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.f$a */
    class C33564a {
        final int iNI;
        final int iNJ;
        private final int iNK;
        final int iNL;
        final int iNM;
        final int iNN;

        /* synthetic */ C33564a(C33565f c33565f, Context context, byte b) {
            this(context);
        }

        private C33564a(Context context) {
            AppMethodBeat.m2504i(133416);
            this.iNI = C42677e.m75581c(context, 1.0f);
            this.iNJ = C1338a.fromDPToPix(context, 20);
            this.iNK = 0;
            this.iNL = C1338a.fromDPToPix(context, 12);
            this.iNM = C1338a.m2872i(context, C25738R.color.f11750fq);
            this.iNN = 2;
            AppMethodBeat.m2505o(133416);
        }
    }

    /* renamed from: eH */
    public final void mo6421eH(boolean z) {
    }

    public C33565f(Activity activity, ViewGroup viewGroup, boolean z, boolean z2) {
        AppMethodBeat.m2504i(133417);
        if (activity == null || viewGroup == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected parameters");
            AppMethodBeat.m2505o(133417);
            throw illegalStateException;
        }
        this.iNH = new C33564a(this, activity, (byte) 0);
        this.iNG = z2;
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        this.ius = linearLayout;
        this.iNE = mo54049a(activity, this.ius, z);
        m54797a(this.iNE, this.ius);
        C33565f.m54799aP(this.iNE);
        AppMethodBeat.m2505o(133417);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public List<C27336a> mo54049a(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.m2504i(133418);
        List arrayList = new ArrayList(2);
        C33565f.m54798a(arrayList, mo54051b(activity, viewGroup, z));
        C33565f.m54798a(arrayList, mo54052c(activity, viewGroup));
        C33565f.m54798a(arrayList, mo54050b(activity, viewGroup));
        C33565f.m54798a(arrayList, mo54048a(activity, viewGroup));
        AppMethodBeat.m2505o(133418);
        return arrayList;
    }

    /* renamed from: a */
    protected static void m54798a(List<C27336a> list, C27336a c27336a) {
        AppMethodBeat.m2504i(133419);
        if (c27336a != null) {
            list.add(c27336a);
        }
        AppMethodBeat.m2505o(133419);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C27336a mo54048a(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133420);
        C2502j c2502j = new C2502j(activity, viewGroup);
        c2502j.iLV = this;
        AppMethodBeat.m2505o(133420);
        return c2502j;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public C27336a mo54050b(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133421);
        C26783t.axH();
        C10912b c10912b = new C10912b(activity, viewGroup);
        c10912b.iLV = this;
        AppMethodBeat.m2505o(133421);
        return c10912b;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public C27336a mo54052c(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133422);
        C2495i c2495i = new C2495i(activity, viewGroup);
        c2495i.iLV = this;
        AppMethodBeat.m2505o(133422);
        return c2495i;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public C27336a mo54051b(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.m2504i(133423);
        if (z) {
            C2487c c2487c = new C2487c(activity, viewGroup);
            c2487c.iLV = this;
            AppMethodBeat.m2505o(133423);
            return c2487c;
        }
        AppMethodBeat.m2505o(133423);
        return null;
    }

    /* renamed from: a */
    private void m54797a(List<C27336a> list, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133424);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(133424);
        } else if (viewGroup == null) {
            AppMethodBeat.m2505o(133424);
        } else {
            for (int i = 0; i < list.size(); i++) {
                C27336a c27336a = (C27336a) list.get(i);
                viewGroup.addView(c27336a.aNi());
                if (i != list.size() - 1) {
                    if (i != 0) {
                        list.get(i - 1);
                    }
                    C27336a c27336a2 = (C27336a) list.get(i + 1);
                    if (this.iNF.contains(c27336a.getClass()) || this.iNF.contains(c27336a2.getClass())) {
                        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
                        linearLayout.setOrientation(1);
                        m54800j(linearLayout);
                        viewGroup.addView(linearLayout, -1, -2);
                    } else if (this.iNG) {
                        int dimensionPixelOffset = viewGroup.getContext().getResources().getDimensionPixelOffset(C25738R.dimen.f10177tc);
                        int dimensionPixelOffset2 = viewGroup.getContext().getResources().getDimensionPixelOffset(C25738R.dimen.f10172t3);
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
                        view.setBackgroundColor(viewGroup.getResources().getColor(C25738R.color.f11754fz));
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
            m54800j(viewGroup);
            AppMethodBeat.m2505o(133424);
        }
    }

    /* renamed from: aP */
    private static void m54799aP(List<C27336a> list) {
        AppMethodBeat.m2504i(133425);
        if (list == null) {
            AppMethodBeat.m2505o(133425);
            return;
        }
        for (C27336a eG : list) {
            eG.mo45020eG(false);
        }
        AppMethodBeat.m2505o(133425);
    }

    /* renamed from: j */
    private void m54800j(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133426);
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
        frameLayout.setId(2131820562);
        viewGroup.addView(frameLayout, -1, -2);
        AppMethodBeat.m2505o(133426);
    }

    public final void aNh() {
        AppMethodBeat.m2504i(133427);
        for (C27336a aNh : this.iNE) {
            aNh.aNh();
        }
        AppMethodBeat.m2505o(133427);
    }

    public final void onDetached() {
        AppMethodBeat.m2504i(133428);
        for (C27336a onDetached : this.iNE) {
            onDetached.onDetached();
        }
        this.iNE.clear();
        AppMethodBeat.m2505o(133428);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(133429);
        for (C27336a onResume : this.iNE) {
            onResume.onResume();
        }
        AppMethodBeat.m2505o(133429);
    }

    public final View aNi() {
        return this.ius;
    }

    /* renamed from: pS */
    public final void mo6437pS(int i) {
        AppMethodBeat.m2504i(133430);
        for (C27336a pS : this.iNE) {
            pS.mo6437pS(i);
        }
        AppMethodBeat.m2505o(133430);
    }

    /* renamed from: pT */
    public final void mo6438pT(int i) {
        AppMethodBeat.m2504i(133431);
        aNs();
        AppMethodBeat.m2505o(133431);
    }

    private void aNs() {
        int i = 0;
        AppMethodBeat.m2504i(133432);
        int i2 = 0;
        for (C27336a aNj : this.iNE) {
            int i3;
            if (aNj.aNj()) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i2 = i3;
        }
        for (C27336a aNj2 : this.iNE) {
            if (aNj2.aNj()) {
                if (i == 0) {
                    aNj2.mo6438pT(C25738R.drawable.f6379c_);
                } else if (i == this.iNE.size() - 1 || i == i2 - 1) {
                    aNj2.mo6438pT(C25738R.drawable.f6377c8);
                } else {
                    aNj2.mo6438pT(C25738R.drawable.f6378c9);
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(133432);
    }

    /* renamed from: a */
    public final void mo45018a(C27336a c27336a, View view, boolean z) {
        AppMethodBeat.m2504i(133433);
        if (this.ius == null) {
            AppMethodBeat.m2505o(133433);
            return;
        }
        C27336a c27336a2;
        View childAt;
        int i;
        C4990ab.m7417i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", c27336a, view, Boolean.valueOf(z));
        if (!(this.ius == null || this.iNE == null)) {
            for (int i2 = 0; i2 < this.iNE.size() - 1; i2++) {
                c27336a2 = (C27336a) this.iNE.get(i2);
                if (c27336a2 != null) {
                    if (c27336a2.aNj()) {
                        int i3 = i2 + 1;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= this.iNE.size()) {
                                i3 = 0;
                                break;
                            }
                            C27336a c27336a3 = (C27336a) this.iNE.get(i4);
                            if (c27336a3 != null && c27336a3.aNj()) {
                                i3 = 1;
                                break;
                            }
                            i3 = i4 + 1;
                        }
                        if (i3 != 0) {
                            childAt = this.ius.getChildAt(this.ius.indexOfChild(c27336a2.aNi()) + 1);
                            if (childAt != null) {
                                childAt.setVisibility(0);
                            }
                        }
                    } else {
                        childAt = this.ius.getChildAt(this.ius.indexOfChild(c27336a2.aNi()) + 1);
                        if (childAt != null) {
                            childAt.setVisibility(8);
                        }
                    }
                }
            }
        }
        for (C27336a c27336a22 : this.iNE) {
            childAt = c27336a22.aNi();
            if (childAt != null && childAt.getVisibility() == 0) {
                C4990ab.m7417i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", c27336a);
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
        AppMethodBeat.m2505o(133433);
    }
}

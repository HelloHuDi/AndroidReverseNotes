package com.tencent.p177mm.plugin.sns.p520ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p520ui.C43611v;
import com.tencent.p177mm.plugin.sns.p520ui.C43611v.C22145a;
import com.tencent.p177mm.plugin.sns.p520ui.previewimageview.C13702c.C4087a;
import com.tencent.p177mm.plugin.sns.p520ui.previewimageview.DynamicGridView.C13701f;
import com.tencent.p177mm.plugin.sns.p520ui.previewimageview.DynamicGridView.C22137e;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.e */
public final class C4088e implements C43611v {
    private Context context;
    private boolean rKR;
    C13702c rKS;
    DynamicGridView rKT;
    C22145a rKU;
    float rKV;
    View rKW;
    ImageView rKX;
    private View rKY;
    private View rKZ;
    private int rLa;
    private Rect rLb;
    TextView rjj;
    private ImageView ruT;

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.e$2 */
    class C40892 implements OnItemLongClickListener {
        C40892() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.e$8 */
    class C40918 implements AnimatorListener {
        C40918() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40328);
            C4088e.m6413b(C4088e.this);
            AppMethodBeat.m2505o(40328);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40329);
            C4088e.this.rKW.setVisibility(4);
            C4088e.this.rKW.setTranslationY(0.0f);
            AppMethodBeat.m2505o(40329);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(40330);
            C4088e.this.rKW.setVisibility(4);
            C4088e.this.rKW.setTranslationY(0.0f);
            AppMethodBeat.m2505o(40330);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.e$3 */
    class C40933 implements OnItemClickListener {
        C40933() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(40323);
            if (C4088e.this.rKU != null) {
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(40323);
                    return;
                }
                int intValue = ((Integer) view.getTag()).intValue();
                C4990ab.m7416i("DynamicGrid", "click ".concat(String.valueOf(intValue)));
                if (intValue == BaseClientBuilder.API_PRIORITY_OTHER) {
                    AppMethodBeat.m2505o(40323);
                    return;
                }
                C4088e.this.rKU.mo37706DO(intValue);
            }
            AppMethodBeat.m2505o(40323);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.e$7 */
    class C40947 implements OnClickListener {
        C40947() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40327);
            C4088e.m6411a(C4088e.this);
            AppMethodBeat.m2505o(40327);
        }
    }

    public C4088e(final View view, View view2, View view3, Context context, final List<String> list, final DynamicGridView dynamicGridView, C22145a c22145a, C4087a c4087a, boolean z) {
        AppMethodBeat.m2504i(40331);
        this.rKR = z;
        this.context = context;
        this.rKU = c22145a;
        this.rKW = view2;
        this.rKY = view3;
        this.rKT = dynamicGridView;
        this.rKX = (ImageView) view2.findViewById(2131827943);
        this.rjj = (TextView) view2.findViewById(2131827745);
        this.rKZ = view;
        dynamicGridView.setWobbleInEditMode(false);
        C13373af.cnu();
        this.rLa = ((C13478s.getScreenWidth() - (context.getResources().getDimensionPixelSize(C25738R.dimen.a9l) * 4)) - (context.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8) * 2)) / 3;
        dynamicGridView.setColumnWidth(this.rLa + (context.getResources().getDimensionPixelSize(C25738R.dimen.a9l) * 2));
        dynamicGridView.setNumColumns(3);
        dynamicGridView.setOverScrollMode(2);
        dynamicGridView.setStretchMode(0);
        dynamicGridView.setClipChildren(false);
        dynamicGridView.setClipToPadding(false);
        dynamicGridView.setSelector(new ColorDrawable(0));
        this.rKS = new C13702c(context, list, z, c4087a);
        cvb();
        dynamicGridView.setAdapter(this.rKS);
        dynamicGridView.setOnDragListener(new C22137e() {
            /* renamed from: Ev */
            public final void mo8958Ev(int i) {
                AppMethodBeat.m2504i(40318);
                C4990ab.m7416i("DynamicGrid", "drag started at position ".concat(String.valueOf(i)));
                if (VERSION.SDK_INT >= 21) {
                    C4088e.this.rKV = dynamicGridView.getElevation();
                    dynamicGridView.setElevation(100.0f);
                } else {
                    dynamicGridView.bringToFront();
                }
                C4088e c4088e = C4088e.this;
                c4088e.rKW.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c4088e.rKW, "translationY", new float[]{(float) c4088e.rKW.getHeight(), 0.0f});
                ofFloat.setDuration(200);
                ofFloat.start();
                C4088e.m6411a(C4088e.this);
                AppMethodBeat.m2505o(40318);
            }

            /* renamed from: Ew */
            public final void mo8959Ew(int i) {
                AppMethodBeat.m2504i(40319);
                C4990ab.m7416i("DynamicGrid", "drag to del ".concat(String.valueOf(i)));
                C13702c c13702c = C4088e.this.rKS;
                Object item = c13702c.getItem(i);
                c13702c.mItems.remove(item);
                c13702c.rKJ.remove(item);
                c13702c.notifyDataSetChanged();
                if (c13702c.rKO != null) {
                    c13702c.rKO.removeItem(i - c13702c.rKK);
                }
                AppMethodBeat.m2505o(40319);
            }

            /* renamed from: l */
            public final void mo8961l(Rect rect) {
                AppMethodBeat.m2504i(40320);
                if (mo8962m(rect)) {
                    C4088e c4088e = C4088e.this;
                    c4088e.rKW.setBackgroundColor(Color.parseColor("#ce3c39"));
                    c4088e.rKX.setImageResource(C1318a.sns_img_highlight_delete);
                    c4088e.rjj.setText("松手即可删除");
                    AppMethodBeat.m2505o(40320);
                    return;
                }
                C4088e.m6413b(C4088e.this);
                AppMethodBeat.m2505o(40320);
            }

            public final void cvc() {
                AppMethodBeat.m2504i(40321);
                C4088e c4088e = C4088e.this;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c4088e.rKW, "translationY", new float[]{0.0f, (float) c4088e.rKW.getHeight()});
                ofFloat.setDuration(200);
                ofFloat.addListener(new C40918());
                ofFloat.start();
                C4088e.this.rKS.cuZ();
                AppMethodBeat.m2505o(40321);
            }

            /* renamed from: m */
            public final boolean mo8962m(Rect rect) {
                AppMethodBeat.m2504i(40322);
                boolean a = C4088e.m6412a(C4088e.this, rect);
                AppMethodBeat.m2505o(40322);
                return a;
            }
        });
        dynamicGridView.setOnItemLongClickListener(new C40892());
        dynamicGridView.setOnItemClickListener(new C40933());
        dynamicGridView.setOnDropListener(new C13701f() {
            public final void cvd() {
                AppMethodBeat.m2504i(40324);
                DynamicGridView dynamicGridView = dynamicGridView;
                dynamicGridView.lBk = false;
                dynamicGridView.requestDisallowInterceptTouchEvent(false);
                if (DynamicGridView.cvj() && dynamicGridView.rLz) {
                    dynamicGridView.mo69216lo(true);
                }
                if (VERSION.SDK_INT >= 21) {
                    dynamicGridView.setElevation(C4088e.this.rKV);
                    AppMethodBeat.m2505o(40324);
                    return;
                }
                view.bringToFront();
                AppMethodBeat.m2505o(40324);
            }
        });
        dynamicGridView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(40325);
                dynamicGridView.getViewTreeObserver().removeOnPreDrawListener(this);
                C4088e.this.mo8951Eu(list.size());
                AppMethodBeat.m2505o(40325);
                return true;
            }
        });
        C13373af.cnu();
        if (C13478s.getScreenWidth() == 0) {
            new C7306ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(40326);
                    C4088e.this.mo8951Eu(list.size());
                    C4088e.this.rKS.notifyDataSetChanged();
                    AppMethodBeat.m2505o(40326);
                }
            }, 50);
        }
        AppMethodBeat.m2505o(40331);
    }

    /* renamed from: Eu */
    public final void mo8951Eu(int i) {
        int i2 = 3;
        AppMethodBeat.m2504i(40332);
        C13373af.cnu();
        this.rLa = ((C13478s.getScreenWidth() - (this.context.getResources().getDimensionPixelSize(C25738R.dimen.a9l) * 4)) - (this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8) * 2)) / 3;
        this.rKT.setColumnWidth(this.rLa + (this.context.getResources().getDimensionPixelSize(C25738R.dimen.a9l) * 2));
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rKT.getLayoutParams();
        Object[] objArr = new Object[1];
        C13373af.cnu();
        objArr[0] = Integer.valueOf(C13478s.getScreenWidth());
        C4990ab.m7417i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", objArr);
        int i3 = (i + 3) / 3;
        if (i3 <= 3) {
            i2 = i3;
        }
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (this.rKZ.getHeight() - this.rLa) - (this.context.getResources().getDimensionPixelSize(C25738R.dimen.a9l) * 2), marginLayoutParams.rightMargin, (int) (((float) (4 - i2)) * (C5056d.anS().density * 32.0f)));
        this.rKT.setLayoutParams(marginLayoutParams);
        AppMethodBeat.m2505o(40332);
    }

    private void cvb() {
        AppMethodBeat.m2504i(40333);
        if (!C4996ah.doB().getBoolean("key_show_tips", true) || this.rKS.cva() <= 1) {
            this.rKY.setVisibility(8);
            AppMethodBeat.m2505o(40333);
            return;
        }
        this.rKY.setVisibility(0);
        this.ruT = (ImageView) this.rKY.findViewById(2131827937);
        this.ruT.setOnClickListener(new C40947());
        AppMethodBeat.m2505o(40333);
    }

    public final void setIsShowAddImage(boolean z) {
        this.rKR = z;
    }

    public final void setImageClick(C22145a c22145a) {
        this.rKU = c22145a;
    }

    public final View getView() {
        return this.rKT;
    }

    public final void setList$22875ea3(List<String> list) {
        AppMethodBeat.m2504i(40334);
        if (this.rKS != null) {
            this.rKS.mo25899dy(list);
            cvb();
        }
        AppMethodBeat.m2505o(40334);
    }

    public final void clean() {
        AppMethodBeat.m2504i(40335);
        if (this.rKT != null && this.rKT.getAdapter() == null) {
            ((C13702c) this.rKT.getAdapter()).rmk = true;
        }
        AppMethodBeat.m2505o(40335);
    }

    /* renamed from: a */
    static /* synthetic */ void m6411a(C4088e c4088e) {
        AppMethodBeat.m2504i(40336);
        c4088e.rKY.setVisibility(8);
        C4996ah.doB().edit().putBoolean("key_show_tips", false).commit();
        AppMethodBeat.m2505o(40336);
    }

    /* renamed from: b */
    static /* synthetic */ void m6413b(C4088e c4088e) {
        AppMethodBeat.m2504i(40337);
        c4088e.rKW.setBackgroundColor(Color.parseColor("#e64340"));
        c4088e.rKX.setImageResource(C1318a.sns_img_delete);
        c4088e.rjj.setText("拖动到此处删除");
        AppMethodBeat.m2505o(40337);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m6412a(C4088e c4088e, Rect rect) {
        AppMethodBeat.m2504i(40338);
        if (rect == null) {
            AppMethodBeat.m2505o(40338);
            return false;
        }
        if (c4088e.rLb == null) {
            c4088e.rLb = new Rect(c4088e.rKW.getLeft(), c4088e.rKW.getTop(), c4088e.rKW.getRight(), c4088e.rKW.getBottom());
        }
        C4990ab.m7410d("DynamicGrid", "del area " + c4088e.rLb + ", test rect " + rect);
        boolean intersects = c4088e.rLb.intersects(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.m2505o(40338);
        return intersects;
    }
}

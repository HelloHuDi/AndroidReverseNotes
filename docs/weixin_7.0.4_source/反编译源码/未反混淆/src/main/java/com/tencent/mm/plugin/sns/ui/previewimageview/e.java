package com.tencent.mm.plugin.sns.ui.previewimageview;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.f;
import com.tencent.mm.plugin.sns.ui.v;
import com.tencent.mm.plugin.sns.ui.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;
import java.util.List;

public final class e implements v {
    private Context context;
    private boolean rKR;
    c rKS;
    DynamicGridView rKT;
    a rKU;
    float rKV;
    View rKW;
    ImageView rKX;
    private View rKY;
    private View rKZ;
    private int rLa;
    private Rect rLb;
    TextView rjj;
    private ImageView ruT;

    public e(final View view, View view2, View view3, Context context, final List<String> list, final DynamicGridView dynamicGridView, a aVar, c.a aVar2, boolean z) {
        AppMethodBeat.i(40331);
        this.rKR = z;
        this.context = context;
        this.rKU = aVar;
        this.rKW = view2;
        this.rKY = view3;
        this.rKT = dynamicGridView;
        this.rKX = (ImageView) view2.findViewById(R.id.eo0);
        this.rjj = (TextView) view2.findViewById(R.id.ein);
        this.rKZ = view;
        dynamicGridView.setWobbleInEditMode(false);
        af.cnu();
        this.rLa = ((s.getScreenWidth() - (context.getResources().getDimensionPixelSize(R.dimen.a9l) * 4)) - (context.getResources().getDimensionPixelSize(R.dimen.l8) * 2)) / 3;
        dynamicGridView.setColumnWidth(this.rLa + (context.getResources().getDimensionPixelSize(R.dimen.a9l) * 2));
        dynamicGridView.setNumColumns(3);
        dynamicGridView.setOverScrollMode(2);
        dynamicGridView.setStretchMode(0);
        dynamicGridView.setClipChildren(false);
        dynamicGridView.setClipToPadding(false);
        dynamicGridView.setSelector(new ColorDrawable(0));
        this.rKS = new c(context, list, z, aVar2);
        cvb();
        dynamicGridView.setAdapter(this.rKS);
        dynamicGridView.setOnDragListener(new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e() {
            public final void Ev(int i) {
                AppMethodBeat.i(40318);
                ab.i("DynamicGrid", "drag started at position ".concat(String.valueOf(i)));
                if (VERSION.SDK_INT >= 21) {
                    e.this.rKV = dynamicGridView.getElevation();
                    dynamicGridView.setElevation(100.0f);
                } else {
                    dynamicGridView.bringToFront();
                }
                e eVar = e.this;
                eVar.rKW.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.rKW, "translationY", new float[]{(float) eVar.rKW.getHeight(), 0.0f});
                ofFloat.setDuration(200);
                ofFloat.start();
                e.a(e.this);
                AppMethodBeat.o(40318);
            }

            public final void Ew(int i) {
                AppMethodBeat.i(40319);
                ab.i("DynamicGrid", "drag to del ".concat(String.valueOf(i)));
                c cVar = e.this.rKS;
                Object item = cVar.getItem(i);
                cVar.mItems.remove(item);
                cVar.rKJ.remove(item);
                cVar.notifyDataSetChanged();
                if (cVar.rKO != null) {
                    cVar.rKO.removeItem(i - cVar.rKK);
                }
                AppMethodBeat.o(40319);
            }

            public final void l(Rect rect) {
                AppMethodBeat.i(40320);
                if (m(rect)) {
                    e eVar = e.this;
                    eVar.rKW.setBackgroundColor(Color.parseColor("#ce3c39"));
                    eVar.rKX.setImageResource(R.raw.sns_img_highlight_delete);
                    eVar.rjj.setText("松手即可删除");
                    AppMethodBeat.o(40320);
                    return;
                }
                e.b(e.this);
                AppMethodBeat.o(40320);
            }

            public final void cvc() {
                AppMethodBeat.i(40321);
                e eVar = e.this;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.rKW, "translationY", new float[]{0.0f, (float) eVar.rKW.getHeight()});
                ofFloat.setDuration(200);
                ofFloat.addListener(new AnimatorListener() {
                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(40328);
                        e.b(e.this);
                        AppMethodBeat.o(40328);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(40329);
                        e.this.rKW.setVisibility(4);
                        e.this.rKW.setTranslationY(0.0f);
                        AppMethodBeat.o(40329);
                    }

                    public final void onAnimationCancel(Animator animator) {
                        AppMethodBeat.i(40330);
                        e.this.rKW.setVisibility(4);
                        e.this.rKW.setTranslationY(0.0f);
                        AppMethodBeat.o(40330);
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ofFloat.start();
                e.this.rKS.cuZ();
                AppMethodBeat.o(40321);
            }

            public final boolean m(Rect rect) {
                AppMethodBeat.i(40322);
                boolean a = e.a(e.this, rect);
                AppMethodBeat.o(40322);
                return a;
            }
        });
        dynamicGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                return true;
            }
        });
        dynamicGridView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(40323);
                if (e.this.rKU != null) {
                    if (view.getTag() == null) {
                        AppMethodBeat.o(40323);
                        return;
                    }
                    int intValue = ((Integer) view.getTag()).intValue();
                    ab.i("DynamicGrid", "click ".concat(String.valueOf(intValue)));
                    if (intValue == BaseClientBuilder.API_PRIORITY_OTHER) {
                        AppMethodBeat.o(40323);
                        return;
                    }
                    e.this.rKU.DO(intValue);
                }
                AppMethodBeat.o(40323);
            }
        });
        dynamicGridView.setOnDropListener(new f() {
            public final void cvd() {
                AppMethodBeat.i(40324);
                DynamicGridView dynamicGridView = dynamicGridView;
                dynamicGridView.lBk = false;
                dynamicGridView.requestDisallowInterceptTouchEvent(false);
                if (DynamicGridView.cvj() && dynamicGridView.rLz) {
                    dynamicGridView.lo(true);
                }
                if (VERSION.SDK_INT >= 21) {
                    dynamicGridView.setElevation(e.this.rKV);
                    AppMethodBeat.o(40324);
                    return;
                }
                view.bringToFront();
                AppMethodBeat.o(40324);
            }
        });
        dynamicGridView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(40325);
                dynamicGridView.getViewTreeObserver().removeOnPreDrawListener(this);
                e.this.Eu(list.size());
                AppMethodBeat.o(40325);
                return true;
            }
        });
        af.cnu();
        if (s.getScreenWidth() == 0) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(40326);
                    e.this.Eu(list.size());
                    e.this.rKS.notifyDataSetChanged();
                    AppMethodBeat.o(40326);
                }
            }, 50);
        }
        AppMethodBeat.o(40331);
    }

    public final void Eu(int i) {
        int i2 = 3;
        AppMethodBeat.i(40332);
        af.cnu();
        this.rLa = ((s.getScreenWidth() - (this.context.getResources().getDimensionPixelSize(R.dimen.a9l) * 4)) - (this.context.getResources().getDimensionPixelSize(R.dimen.l8) * 2)) / 3;
        this.rKT.setColumnWidth(this.rLa + (this.context.getResources().getDimensionPixelSize(R.dimen.a9l) * 2));
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rKT.getLayoutParams();
        Object[] objArr = new Object[1];
        af.cnu();
        objArr[0] = Integer.valueOf(s.getScreenWidth());
        ab.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", objArr);
        int i3 = (i + 3) / 3;
        if (i3 <= 3) {
            i2 = i3;
        }
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (this.rKZ.getHeight() - this.rLa) - (this.context.getResources().getDimensionPixelSize(R.dimen.a9l) * 2), marginLayoutParams.rightMargin, (int) (((float) (4 - i2)) * (d.anS().density * 32.0f)));
        this.rKT.setLayoutParams(marginLayoutParams);
        AppMethodBeat.o(40332);
    }

    private void cvb() {
        AppMethodBeat.i(40333);
        if (!ah.doB().getBoolean("key_show_tips", true) || this.rKS.cva() <= 1) {
            this.rKY.setVisibility(8);
            AppMethodBeat.o(40333);
            return;
        }
        this.rKY.setVisibility(0);
        this.ruT = (ImageView) this.rKY.findViewById(R.id.enu);
        this.ruT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40327);
                e.a(e.this);
                AppMethodBeat.o(40327);
            }
        });
        AppMethodBeat.o(40333);
    }

    public final void setIsShowAddImage(boolean z) {
        this.rKR = z;
    }

    public final void setImageClick(a aVar) {
        this.rKU = aVar;
    }

    public final View getView() {
        return this.rKT;
    }

    public final void setList$22875ea3(List<String> list) {
        AppMethodBeat.i(40334);
        if (this.rKS != null) {
            this.rKS.dy(list);
            cvb();
        }
        AppMethodBeat.o(40334);
    }

    public final void clean() {
        AppMethodBeat.i(40335);
        if (this.rKT != null && this.rKT.getAdapter() == null) {
            ((c) this.rKT.getAdapter()).rmk = true;
        }
        AppMethodBeat.o(40335);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(40336);
        eVar.rKY.setVisibility(8);
        ah.doB().edit().putBoolean("key_show_tips", false).commit();
        AppMethodBeat.o(40336);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(40337);
        eVar.rKW.setBackgroundColor(Color.parseColor("#e64340"));
        eVar.rKX.setImageResource(R.raw.sns_img_delete);
        eVar.rjj.setText("拖动到此处删除");
        AppMethodBeat.o(40337);
    }

    static /* synthetic */ boolean a(e eVar, Rect rect) {
        AppMethodBeat.i(40338);
        if (rect == null) {
            AppMethodBeat.o(40338);
            return false;
        }
        if (eVar.rLb == null) {
            eVar.rLb = new Rect(eVar.rKW.getLeft(), eVar.rKW.getTop(), eVar.rKW.getRight(), eVar.rKW.getBottom());
        }
        ab.d("DynamicGrid", "del area " + eVar.rLb + ", test rect " + rect);
        boolean intersects = eVar.rLb.intersects(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(40338);
        return intersects;
    }
}

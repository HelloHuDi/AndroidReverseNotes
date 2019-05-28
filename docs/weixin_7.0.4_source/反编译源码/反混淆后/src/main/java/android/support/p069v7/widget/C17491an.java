package android.support.p069v7.widget;

import android.graphics.PointF;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C37139r.C37138a;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;

/* renamed from: android.support.v7.widget.an */
public class C17491an extends C25379aw {
    private C17487am amf;
    private C17487am amg;

    /* renamed from: a */
    public int[] mo9101a(C17480i c17480i, View view) {
        int[] iArr = new int[2];
        if (c17480i.mo1776iG()) {
            iArr[0] = C17491an.m27280a(c17480i, view, m27283c(c17480i));
        } else {
            iArr[0] = 0;
        }
        if (c17480i.mo1777iH()) {
            iArr[1] = C17491an.m27280a(c17480i, view, m27282b(c17480i));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* renamed from: a */
    public View mo31910a(C17480i c17480i) {
        if (c17480i.mo1777iH()) {
            return C17491an.m27281a(c17480i, m27282b(c17480i));
        }
        if (c17480i.mo1776iG()) {
            return C17491an.m27281a(c17480i, m27283c(c17480i));
        }
        return null;
    }

    /* renamed from: a */
    public int mo31909a(C17480i c17480i, int i, int i2) {
        Object obj = null;
        int itemCount = c17480i.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (c17480i.mo1777iH()) {
            view = C17491an.m27284c(c17480i, m27282b(c17480i));
        } else if (c17480i.mo1776iG()) {
            view = C17491an.m27284c(c17480i, m27283c(c17480i));
        }
        if (view == null) {
            return -1;
        }
        int bt = C17480i.m27148bt(view);
        if (bt == -1) {
            return -1;
        }
        Object obj2;
        if (c17480i.mo1776iG()) {
            obj2 = i > 0 ? 1 : null;
        } else if (i2 > 0) {
            int obj22 = 1;
        } else {
            obj22 = null;
        }
        if (c17480i instanceof C37140b) {
            PointF bX = ((C37140b) c17480i).mo1761bX(itemCount - 1);
            if (bX != null && (bX.x < 0.0f || bX.y < 0.0f)) {
                obj = 1;
            }
        }
        if (obj == null) {
            return obj22 != null ? bt + 1 : bt;
        } else {
            if (obj22 != null) {
                return bt - 1;
            }
            return bt;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: f */
    public final C41189ah mo31911f(C17480i c17480i) {
        if (c17480i instanceof C37140b) {
            return new C41189ah(this.aiB.getContext()) {
                /* Access modifiers changed, original: protected|final */
                /* renamed from: a */
                public final void mo9234a(View view, C37138a c37138a) {
                    int[] a = C17491an.this.mo9101a(C17491an.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = mo65816ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        c37138a.mo59203a(i, i2, ca, this.f16584Sf);
                    }
                }

                /* Access modifiers changed, original: protected|final */
                /* renamed from: c */
                public final float mo9235c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }

                /* Access modifiers changed, original: protected|final */
                /* renamed from: cb */
                public final int mo30874cb(int i) {
                    return Math.min(100, super.mo30874cb(i));
                }
            };
        }
        return null;
    }

    /* renamed from: a */
    private static int m27280a(C17480i c17480i, View view, C17487am c17487am) {
        int je;
        int bj = (c17487am.mo31897bj(view) / 2) + c17487am.mo31893bf(view);
        if (c17480i.getClipToPadding()) {
            je = c17487am.mo31905je() + (c17487am.mo31907jg() / 2);
        } else {
            je = c17487am.getEnd() / 2;
        }
        return bj - je;
    }

    /* renamed from: a */
    private static View m27281a(C17480i c17480i, C17487am c17487am) {
        View view = null;
        int childCount = c17480i.getChildCount();
        if (childCount != 0) {
            int je;
            if (c17480i.getClipToPadding()) {
                je = c17487am.mo31905je() + (c17487am.mo31907jg() / 2);
            } else {
                je = c17487am.getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = c17480i.getChildAt(i2);
                int abs = Math.abs((c17487am.mo31893bf(childAt) + (c17487am.mo31897bj(childAt) / 2)) - je);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
        }
        return view;
    }

    /* renamed from: c */
    private static View m27284c(C17480i c17480i, C17487am c17487am) {
        View view = null;
        int childCount = c17480i.getChildCount();
        if (childCount != 0) {
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = c17480i.getChildAt(i2);
                int bf = c17487am.mo31893bf(childAt);
                if (bf >= i) {
                    bf = i;
                    childAt = view;
                }
                i2++;
                i = bf;
                view = childAt;
            }
        }
        return view;
    }

    /* renamed from: b */
    private C17487am m27282b(C17480i c17480i) {
        if (this.amf == null || this.amf.amP != c17480i) {
            this.amf = C17487am.m27242e(c17480i);
        }
        return this.amf;
    }

    /* renamed from: c */
    private C17487am m27283c(C17480i c17480i) {
        if (this.amg == null || this.amg.amP != c17480i) {
            this.amg = C17487am.m27241d(c17480i);
        }
        return this.amg;
    }
}

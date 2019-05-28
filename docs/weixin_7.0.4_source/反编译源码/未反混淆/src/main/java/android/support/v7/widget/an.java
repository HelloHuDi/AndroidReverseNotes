package android.support.v7.widget;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;

public class an extends aw {
    private am amf;
    private am amg;

    public int[] a(i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.iG()) {
            iArr[0] = a(iVar, view, c(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.iH()) {
            iArr[1] = a(iVar, view, b(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View a(i iVar) {
        if (iVar.iH()) {
            return a(iVar, b(iVar));
        }
        if (iVar.iG()) {
            return a(iVar, c(iVar));
        }
        return null;
    }

    public int a(i iVar, int i, int i2) {
        Object obj = null;
        int itemCount = iVar.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (iVar.iH()) {
            view = c(iVar, b(iVar));
        } else if (iVar.iG()) {
            view = c(iVar, c(iVar));
        }
        if (view == null) {
            return -1;
        }
        int bt = i.bt(view);
        if (bt == -1) {
            return -1;
        }
        Object obj2;
        if (iVar.iG()) {
            obj2 = i > 0 ? 1 : null;
        } else if (i2 > 0) {
            int obj22 = 1;
        } else {
            obj22 = null;
        }
        if (iVar instanceof b) {
            PointF bX = ((b) iVar).bX(itemCount - 1);
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
    public final ah f(i iVar) {
        if (iVar instanceof b) {
            return new ah(this.aiB.getContext()) {
                /* Access modifiers changed, original: protected|final */
                public final void a(View view, a aVar) {
                    int[] a = an.this.a(an.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        aVar.a(i, i2, ca, this.Sf);
                    }
                }

                /* Access modifiers changed, original: protected|final */
                public final float c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }

                /* Access modifiers changed, original: protected|final */
                public final int cb(int i) {
                    return Math.min(100, super.cb(i));
                }
            };
        }
        return null;
    }

    private static int a(i iVar, View view, am amVar) {
        int je;
        int bj = (amVar.bj(view) / 2) + amVar.bf(view);
        if (iVar.getClipToPadding()) {
            je = amVar.je() + (amVar.jg() / 2);
        } else {
            je = amVar.getEnd() / 2;
        }
        return bj - je;
    }

    private static View a(i iVar, am amVar) {
        View view = null;
        int childCount = iVar.getChildCount();
        if (childCount != 0) {
            int je;
            if (iVar.getClipToPadding()) {
                je = amVar.je() + (amVar.jg() / 2);
            } else {
                je = amVar.getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = iVar.getChildAt(i2);
                int abs = Math.abs((amVar.bf(childAt) + (amVar.bj(childAt) / 2)) - je);
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

    private static View c(i iVar, am amVar) {
        View view = null;
        int childCount = iVar.getChildCount();
        if (childCount != 0) {
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = iVar.getChildAt(i2);
                int bf = amVar.bf(childAt);
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

    private am b(i iVar) {
        if (this.amf == null || this.amf.amP != iVar) {
            this.amf = am.e(iVar);
        }
        return this.amf;
    }

    private am c(i iVar) {
        if (this.amg == null || this.amg.amP != iVar) {
            this.amg = am.d(iVar);
        }
        return this.amg;
    }
}

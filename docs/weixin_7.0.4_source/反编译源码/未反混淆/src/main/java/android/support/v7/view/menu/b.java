package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.o.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import java.util.ArrayList;

public abstract class b implements o {
    protected Context aak;
    protected LayoutInflater aal;
    private int aam = R.layout.l;
    private int aan = R.layout.k;
    public p aao;
    public a lL;
    public h lo;
    protected Context mContext;
    public int mId;
    protected LayoutInflater mInflater;

    public abstract void a(j jVar, p.a aVar);

    public b(Context context) {
        this.aak = context;
        this.aal = LayoutInflater.from(context);
    }

    public void a(Context context, h hVar) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.lo = hVar;
    }

    public p f(ViewGroup viewGroup) {
        if (this.aao == null) {
            this.aao = (p) this.aal.inflate(this.aam, viewGroup, false);
            this.aao.a(this.lo);
            n(true);
        }
        return this.aao;
    }

    public void n(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.aao;
        if (viewGroup != null) {
            int i;
            if (this.lo != null) {
                this.lo.gC();
                ArrayList gB = this.lo.gB();
                int size = gB.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    j jVar = (j) gB.get(i2);
                    if (e(jVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        j itemData = childAt instanceof p.a ? ((p.a) childAt).getItemData() : null;
                        View a = a(jVar, childAt, viewGroup);
                        if (jVar != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.aao).addView(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!b(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean b(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public final void a(a aVar) {
        this.lL = aVar;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        p.a aVar;
        if (view instanceof p.a) {
            aVar = (p.a) view;
        } else {
            aVar = (p.a) this.aal.inflate(this.aan, viewGroup, false);
        }
        a(jVar, aVar);
        return (View) aVar;
    }

    public boolean e(j jVar) {
        return true;
    }

    public void a(h hVar, boolean z) {
        if (this.lL != null) {
            this.lL.a(hVar, z);
        }
    }

    public boolean a(u uVar) {
        if (this.lL != null) {
            return this.lL.d(uVar);
        }
        return false;
    }

    public boolean bt() {
        return false;
    }

    public final boolean b(j jVar) {
        return false;
    }

    public final boolean c(j jVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }
}

package android.support.p069v7.view.menu;

import android.content.Context;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.b */
public abstract class C6232b implements C0628o {
    protected Context aak;
    protected LayoutInflater aal;
    private int aam = 2130968587;
    private int aan = 2130968586;
    public C0630p aao;
    /* renamed from: lL */
    public C0627a f1906lL;
    /* renamed from: lo */
    public C6236h f1907lo;
    protected Context mContext;
    public int mId;
    protected LayoutInflater mInflater;

    /* renamed from: a */
    public abstract void mo14101a(C6239j c6239j, C0629a c0629a);

    public C6232b(Context context) {
        this.aak = context;
        this.aal = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void mo1598a(Context context, C6236h c6236h) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.f1907lo = c6236h;
    }

    /* renamed from: f */
    public C0630p mo14104f(ViewGroup viewGroup) {
        if (this.aao == null) {
            this.aao = (C0630p) this.aal.inflate(this.aam, viewGroup, false);
            this.aao.mo1612a(this.f1907lo);
            mo1606n(true);
        }
        return this.aao;
    }

    /* renamed from: n */
    public void mo1606n(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.aao;
        if (viewGroup != null) {
            int i;
            if (this.f1907lo != null) {
                this.f1907lo.mo14139gC();
                ArrayList gB = this.f1907lo.mo14138gB();
                int size = gB.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    C6239j c6239j = (C6239j) gB.get(i2);
                    if (mo14103e(c6239j)) {
                        View childAt = viewGroup.getChildAt(i);
                        C6239j itemData = childAt instanceof C0629a ? ((C0629a) childAt).getItemData() : null;
                        View a = mo14100a(c6239j, childAt, viewGroup);
                        if (c6239j != itemData) {
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
                if (!mo14102b(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo14102b(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* renamed from: a */
    public final void mo1600a(C0627a c0627a) {
        this.f1906lL = c0627a;
    }

    /* renamed from: a */
    public View mo14100a(C6239j c6239j, View view, ViewGroup viewGroup) {
        C0629a c0629a;
        if (view instanceof C0629a) {
            c0629a = (C0629a) view;
        } else {
            c0629a = (C0629a) this.aal.inflate(this.aan, viewGroup, false);
        }
        mo14101a(c6239j, c0629a);
        return (View) c0629a;
    }

    /* renamed from: e */
    public boolean mo14103e(C6239j c6239j) {
        return true;
    }

    /* renamed from: a */
    public void mo1599a(C6236h c6236h, boolean z) {
        if (this.f1906lL != null) {
            this.f1906lL.mo1596a(c6236h, z);
        }
    }

    /* renamed from: a */
    public boolean mo1601a(C7459u c7459u) {
        if (this.f1906lL != null) {
            return this.f1906lL.mo1597d(c7459u);
        }
        return false;
    }

    /* renamed from: bt */
    public boolean mo1603bt() {
        return false;
    }

    /* renamed from: b */
    public final boolean mo1602b(C6239j c6239j) {
        return false;
    }

    /* renamed from: c */
    public final boolean mo1604c(C6239j c6239j) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }
}

package com.tencent.p177mm.plugin.appbrand.widget.recyclerview;

import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.a */
final class C19925a extends C41523a<C41531v> {
    private static LayoutParams jow = new LayoutParams(-1, -2);
    /* renamed from: Yq */
    C41523a f4365Yq;
    private List<View> joA = new LinkedList();
    C19928b joB;
    C27431c joC;
    C41525c joD = new C199271();
    private ViewGroup jox;
    private ViewGroup joy;
    List<View> joz = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.a$a */
    static class C19924a extends C41531v {
        C19924a(View view) {
            super(view);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.a$1 */
    class C199271 extends C41525c {
        C199271() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(77456);
            C19925a.this.aop.notifyChanged();
            AppMethodBeat.m2505o(77456);
        }

        /* renamed from: av */
        public final void mo35178av(int i, int i2) {
            AppMethodBeat.m2504i(77457);
            C19925a.this.mo66308ar((C19925a.this.joz.isEmpty() ? 0 : 1) + i, i2);
            AppMethodBeat.m2505o(77457);
        }

        /* renamed from: d */
        public final void mo18475d(int i, int i2, Object obj) {
            AppMethodBeat.m2504i(77458);
            C19925a.this.mo66315c((C19925a.this.joz.isEmpty() ? 0 : 1) + i, i2, obj);
            AppMethodBeat.m2505o(77458);
        }

        /* renamed from: aw */
        public final void mo18473aw(int i, int i2) {
            AppMethodBeat.m2504i(77459);
            C19925a.this.mo66310at((C19925a.this.joz.isEmpty() ? 0 : 1) + i, i2);
            AppMethodBeat.m2505o(77459);
        }

        /* renamed from: ax */
        public final void mo6644ax(int i, int i2) {
            AppMethodBeat.m2504i(77460);
            C19925a.this.mo66311au((C19925a.this.joz.isEmpty() ? 0 : 1) + i, i2);
            AppMethodBeat.m2505o(77460);
        }

        /* renamed from: ay */
        public final void mo18474ay(int i, int i2) {
            int i3 = 0;
            AppMethodBeat.m2504i(77461);
            C19925a c19925a = C19925a.this;
            int i4 = (c19925a.joz.isEmpty() ? 0 : 1) + i;
            if (!C19925a.this.joz.isEmpty()) {
                i3 = 1;
            }
            c19925a.mo66309as(i4, i3 + i2);
            AppMethodBeat.m2505o(77461);
        }
    }

    static {
        AppMethodBeat.m2504i(77477);
        AppMethodBeat.m2505o(77477);
    }

    C19925a() {
        AppMethodBeat.m2504i(77466);
        AppMethodBeat.m2505o(77466);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(77467);
        if (!this.joz.isEmpty() && i == 0) {
            AppMethodBeat.m2505o(77467);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else if (this.joA.isEmpty() || i != getItemCount() - 1) {
            int itemViewType = this.f4365Yq.getItemViewType(i - (this.joz.isEmpty() ? 0 : 1));
            AppMethodBeat.m2505o(77467);
            return itemViewType;
        } else {
            AppMethodBeat.m2505o(77467);
            return 2147483646;
        }
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(77468);
        long hashCode;
        if (getItemViewType(i) == BaseClientBuilder.API_PRIORITY_OTHER) {
            hashCode = (long) "MRecyclerHeaderView".hashCode();
            AppMethodBeat.m2505o(77468);
            return hashCode;
        } else if (getItemViewType(i) == 2147483646) {
            hashCode = (long) "MRecyclerFooterView".hashCode();
            AppMethodBeat.m2505o(77468);
            return hashCode;
        } else if (this.f4365Yq.aoq) {
            hashCode = this.f4365Yq.getItemId(i - (this.joz.isEmpty() ? 0 : 1));
            AppMethodBeat.m2505o(77468);
            return hashCode;
        } else {
            hashCode = (long) i;
            AppMethodBeat.m2505o(77468);
            return hashCode;
        }
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(77469);
        int itemCount = this.f4365Yq.getItemCount();
        if (!this.joz.isEmpty()) {
            itemCount++;
        }
        if (!this.joA.isEmpty()) {
            itemCount++;
        }
        AppMethodBeat.m2505o(77469);
        return itemCount;
    }

    /* renamed from: a */
    public final void mo4977a(final C41531v c41531v, int i) {
        AppMethodBeat.m2504i(77470);
        if (!this.joz.isEmpty() && i == 0) {
            AppMethodBeat.m2505o(77470);
        } else if (this.joA.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.joz.isEmpty() ? 0 : 1);
            this.f4365Yq.mo4977a(c41531v, i2);
            if (this.joB != null) {
                c41531v.apJ.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(77462);
                        if (C19925a.this.joB != null) {
                            C19925a.this.joB.mo35179J(c41531v.apJ, i2);
                        }
                        AppMethodBeat.m2505o(77462);
                    }
                });
            }
            if (this.joC != null) {
                c41531v.apJ.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.m2504i(77463);
                        if (C19925a.this.joC != null) {
                            boolean K = C19925a.this.joC.mo45203K(c41531v.apJ, i2);
                            AppMethodBeat.m2505o(77463);
                            return K;
                        }
                        AppMethodBeat.m2505o(77463);
                        return false;
                    }
                });
            }
            AppMethodBeat.m2505o(77470);
        } else {
            AppMethodBeat.m2505o(77470);
        }
    }

    /* renamed from: a */
    public final void mo27742a(final C41531v c41531v, int i, List<Object> list) {
        AppMethodBeat.m2504i(77471);
        if (!this.joz.isEmpty() && i == 0) {
            AppMethodBeat.m2505o(77471);
        } else if (this.joA.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.joz.isEmpty() ? 0 : 1);
            this.f4365Yq.mo27742a(c41531v, i2, list);
            if (this.joB != null) {
                c41531v.apJ.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(77464);
                        if (C19925a.this.joB != null) {
                            C19925a.this.joB.mo35179J(c41531v.apJ, i2);
                        }
                        AppMethodBeat.m2505o(77464);
                    }
                });
            }
            if (this.joC != null) {
                c41531v.apJ.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.m2504i(77465);
                        if (C19925a.this.joC != null) {
                            boolean K = C19925a.this.joC.mo45203K(c41531v.apJ, i2);
                            AppMethodBeat.m2505o(77465);
                            return K;
                        }
                        AppMethodBeat.m2505o(77465);
                        return false;
                    }
                });
            }
            AppMethodBeat.m2505o(77471);
        } else {
            AppMethodBeat.m2505o(77471);
        }
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(77472);
        ViewGroup viewGroup2;
        C41531v c19924a;
        if (i == 2147483646) {
            if (this.jox != null) {
                this.jox.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(2130970908, viewGroup, false);
            this.jox = viewGroup2;
            for (View addView : this.joA) {
                viewGroup2.addView(addView, jow);
            }
            c19924a = new C19924a(viewGroup2);
            AppMethodBeat.m2505o(77472);
            return c19924a;
        } else if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            if (this.joy != null) {
                this.joy.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(2130970908, viewGroup, false);
            this.joy = viewGroup2;
            for (View addView2 : this.joz) {
                viewGroup2.addView(addView2, jow);
            }
            c19924a = new C19924a(viewGroup2);
            AppMethodBeat.m2505o(77472);
            return c19924a;
        } else {
            C41531v a = this.f4365Yq.mo4976a(viewGroup, i);
            AppMethodBeat.m2505o(77472);
            return a;
        }
    }

    public final int getFooterViewCount() {
        AppMethodBeat.m2504i(77473);
        int size = this.joA.size();
        AppMethodBeat.m2505o(77473);
        return size;
    }

    public final void addFooterView(View view) {
        AppMethodBeat.m2504i(77474);
        this.joA.add(view);
        mo66308ar(getItemCount() - 1, 1);
        AppMethodBeat.m2505o(77474);
    }

    /* renamed from: b */
    public final void mo35174b(int i, View view) {
        AppMethodBeat.m2504i(77475);
        this.joA.add(i, view);
        mo66308ar(getItemCount() - 1, 1);
        AppMethodBeat.m2505o(77475);
    }

    /* renamed from: cW */
    public final void mo35175cW(View view) {
        AppMethodBeat.m2504i(77476);
        this.joA.remove(view);
        mo66308ar(getItemCount() - 1, 1);
        AppMethodBeat.m2505o(77476);
    }
}

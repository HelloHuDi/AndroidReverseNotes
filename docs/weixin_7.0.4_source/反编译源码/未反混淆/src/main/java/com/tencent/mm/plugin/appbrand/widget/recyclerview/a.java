package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a<v> {
    private static LayoutParams jow = new LayoutParams(-1, -2);
    android.support.v7.widget.RecyclerView.a Yq;
    private List<View> joA = new LinkedList();
    b joB;
    c joC;
    c joD = new c() {
        public final void onChanged() {
            AppMethodBeat.i(77456);
            a.this.aop.notifyChanged();
            AppMethodBeat.o(77456);
        }

        public final void av(int i, int i2) {
            AppMethodBeat.i(77457);
            a.this.ar((a.this.joz.isEmpty() ? 0 : 1) + i, i2);
            AppMethodBeat.o(77457);
        }

        public final void d(int i, int i2, Object obj) {
            AppMethodBeat.i(77458);
            a.this.c((a.this.joz.isEmpty() ? 0 : 1) + i, i2, obj);
            AppMethodBeat.o(77458);
        }

        public final void aw(int i, int i2) {
            AppMethodBeat.i(77459);
            a.this.at((a.this.joz.isEmpty() ? 0 : 1) + i, i2);
            AppMethodBeat.o(77459);
        }

        public final void ax(int i, int i2) {
            AppMethodBeat.i(77460);
            a.this.au((a.this.joz.isEmpty() ? 0 : 1) + i, i2);
            AppMethodBeat.o(77460);
        }

        public final void ay(int i, int i2) {
            int i3 = 0;
            AppMethodBeat.i(77461);
            a aVar = a.this;
            int i4 = (aVar.joz.isEmpty() ? 0 : 1) + i;
            if (!a.this.joz.isEmpty()) {
                i3 = 1;
            }
            aVar.as(i4, i3 + i2);
            AppMethodBeat.o(77461);
        }
    };
    private ViewGroup jox;
    private ViewGroup joy;
    List<View> joz = new LinkedList();

    static class a extends v {
        a(View view) {
            super(view);
        }
    }

    static {
        AppMethodBeat.i(77477);
        AppMethodBeat.o(77477);
    }

    a() {
        AppMethodBeat.i(77466);
        AppMethodBeat.o(77466);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(77467);
        if (!this.joz.isEmpty() && i == 0) {
            AppMethodBeat.o(77467);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else if (this.joA.isEmpty() || i != getItemCount() - 1) {
            int itemViewType = this.Yq.getItemViewType(i - (this.joz.isEmpty() ? 0 : 1));
            AppMethodBeat.o(77467);
            return itemViewType;
        } else {
            AppMethodBeat.o(77467);
            return 2147483646;
        }
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(77468);
        long hashCode;
        if (getItemViewType(i) == BaseClientBuilder.API_PRIORITY_OTHER) {
            hashCode = (long) "MRecyclerHeaderView".hashCode();
            AppMethodBeat.o(77468);
            return hashCode;
        } else if (getItemViewType(i) == 2147483646) {
            hashCode = (long) "MRecyclerFooterView".hashCode();
            AppMethodBeat.o(77468);
            return hashCode;
        } else if (this.Yq.aoq) {
            hashCode = this.Yq.getItemId(i - (this.joz.isEmpty() ? 0 : 1));
            AppMethodBeat.o(77468);
            return hashCode;
        } else {
            hashCode = (long) i;
            AppMethodBeat.o(77468);
            return hashCode;
        }
    }

    public final int getItemCount() {
        AppMethodBeat.i(77469);
        int itemCount = this.Yq.getItemCount();
        if (!this.joz.isEmpty()) {
            itemCount++;
        }
        if (!this.joA.isEmpty()) {
            itemCount++;
        }
        AppMethodBeat.o(77469);
        return itemCount;
    }

    public final void a(final v vVar, int i) {
        AppMethodBeat.i(77470);
        if (!this.joz.isEmpty() && i == 0) {
            AppMethodBeat.o(77470);
        } else if (this.joA.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.joz.isEmpty() ? 0 : 1);
            this.Yq.a(vVar, i2);
            if (this.joB != null) {
                vVar.apJ.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(77462);
                        if (a.this.joB != null) {
                            a.this.joB.J(vVar.apJ, i2);
                        }
                        AppMethodBeat.o(77462);
                    }
                });
            }
            if (this.joC != null) {
                vVar.apJ.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(77463);
                        if (a.this.joC != null) {
                            boolean K = a.this.joC.K(vVar.apJ, i2);
                            AppMethodBeat.o(77463);
                            return K;
                        }
                        AppMethodBeat.o(77463);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(77470);
        } else {
            AppMethodBeat.o(77470);
        }
    }

    public final void a(final v vVar, int i, List<Object> list) {
        AppMethodBeat.i(77471);
        if (!this.joz.isEmpty() && i == 0) {
            AppMethodBeat.o(77471);
        } else if (this.joA.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.joz.isEmpty() ? 0 : 1);
            this.Yq.a(vVar, i2, list);
            if (this.joB != null) {
                vVar.apJ.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(77464);
                        if (a.this.joB != null) {
                            a.this.joB.J(vVar.apJ, i2);
                        }
                        AppMethodBeat.o(77464);
                    }
                });
            }
            if (this.joC != null) {
                vVar.apJ.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(77465);
                        if (a.this.joC != null) {
                            boolean K = a.this.joC.K(vVar.apJ, i2);
                            AppMethodBeat.o(77465);
                            return K;
                        }
                        AppMethodBeat.o(77465);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(77471);
        } else {
            AppMethodBeat.o(77471);
        }
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(77472);
        ViewGroup viewGroup2;
        v aVar;
        if (i == 2147483646) {
            if (this.jox != null) {
                this.jox.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.az8, viewGroup, false);
            this.jox = viewGroup2;
            for (View addView : this.joA) {
                viewGroup2.addView(addView, jow);
            }
            aVar = new a(viewGroup2);
            AppMethodBeat.o(77472);
            return aVar;
        } else if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            if (this.joy != null) {
                this.joy.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.az8, viewGroup, false);
            this.joy = viewGroup2;
            for (View addView2 : this.joz) {
                viewGroup2.addView(addView2, jow);
            }
            aVar = new a(viewGroup2);
            AppMethodBeat.o(77472);
            return aVar;
        } else {
            v a = this.Yq.a(viewGroup, i);
            AppMethodBeat.o(77472);
            return a;
        }
    }

    public final int getFooterViewCount() {
        AppMethodBeat.i(77473);
        int size = this.joA.size();
        AppMethodBeat.o(77473);
        return size;
    }

    public final void addFooterView(View view) {
        AppMethodBeat.i(77474);
        this.joA.add(view);
        ar(getItemCount() - 1, 1);
        AppMethodBeat.o(77474);
    }

    public final void b(int i, View view) {
        AppMethodBeat.i(77475);
        this.joA.add(i, view);
        ar(getItemCount() - 1, 1);
        AppMethodBeat.o(77475);
    }

    public final void cW(View view) {
        AppMethodBeat.i(77476);
        this.joA.remove(view);
        ar(getItemCount() - 1, 1);
        AppMethodBeat.o(77476);
    }
}

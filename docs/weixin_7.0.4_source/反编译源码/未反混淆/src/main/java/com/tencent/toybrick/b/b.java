package com.tencent.toybrick.b;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.c;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ai;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.e.b.AnonymousClass1;
import com.tencent.toybrick.e.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends android.support.v7.widget.RecyclerView.a<com.tencent.toybrick.f.a> implements OnClickListener {
    public ArrayList<g> AFO;
    public LinkedList<g> AFP;
    public HashMap<g, Integer> AFQ;
    private SparseArray<g> AFR;
    private com.tencent.toybrick.e.b AFS;
    public com.tencent.toybrick.d.a.a AFT;
    private Context mContext;

    class a extends c {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void av(int i, int i2) {
            AppMethodBeat.i(113181);
            super.av(i, i2);
            ai.d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", Integer.valueOf(i), Integer.valueOf(i2));
            g Sg = b.this.Sg(i);
            if (!(Sg == null || Sg.AGD == null)) {
                com.tencent.toybrick.e.c.execute(new d(Sg, Sg.AGD, new com.tencent.toybrick.e.c.b<g>() {
                    public final /* synthetic */ void d(Object obj, boolean z) {
                        AppMethodBeat.i(113180);
                        f fVar = (g) obj;
                        if (fVar.isVisible != z) {
                            if (fVar.isVisible != z) {
                                com.tencent.toybrick.ui.BaseToyUI.a aVar;
                                fVar.isVisible = z;
                                if (z) {
                                    aVar = com.tencent.toybrick.ui.BaseToyUI.a.INSERT;
                                } else {
                                    aVar = com.tencent.toybrick.ui.BaseToyUI.a.REMOVE;
                                }
                                fVar.mMainHandler.removeCallbacks(fVar.AGB);
                                Handler handler = fVar.mMainHandler;
                                com.tencent.toybrick.c.f.AnonymousClass1 anonymousClass1 = new com.tencent.toybrick.c.f.AnonymousClass1(aVar);
                                fVar.AGB = anonymousClass1;
                                handler.post(anonymousClass1);
                            }
                            if (z) {
                                b.a(b.this, (g) fVar);
                                AppMethodBeat.o(113180);
                                return;
                            }
                            b.a(b.this, fVar);
                        }
                        AppMethodBeat.o(113180);
                    }
                }));
            }
            AppMethodBeat.o(113181);
        }
    }

    public b(Context context, com.tencent.toybrick.d.a.a aVar) {
        byte b = (byte) 0;
        AppMethodBeat.i(113182);
        a((c) new a(this, (byte) 0));
        this.mContext = context;
        this.AFT = aVar;
        LinkedList linkedList = aVar.AGQ;
        Iterator it = linkedList.iterator();
        while (true) {
            byte b2 = b;
            if (it.hasNext()) {
                ((g) it.next()).btQ = b2;
                b = b2 + 1;
            } else {
                this.AFP = linkedList;
                this.AFR = new SparseArray();
                this.AFQ = new HashMap();
                this.AFO = new ArrayList();
                this.AFS = new com.tencent.toybrick.e.b(this);
                com.tencent.toybrick.e.b bVar = this.AFS;
                bVar.mMainHandler.removeCallbacks(bVar.AGY);
                Handler handler = bVar.mMainHandler;
                AnonymousClass1 anonymousClass1 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(113228);
                        com.tencent.toybrick.b.b bVar = (com.tencent.toybrick.b.b) b.this.AGX.get();
                        if (bVar != null) {
                            a.dSz().execute(new b(bVar.AFT.AGR, bVar.AFP, bVar.AFO));
                        }
                        AppMethodBeat.o(113228);
                    }
                };
                bVar.AGY = anonymousClass1;
                handler.post(anonymousClass1);
                AppMethodBeat.o(113182);
                return;
            }
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(113183);
        g Sg = Sg(i);
        int layoutResource = Sg.getLayoutResource();
        this.AFR.put(layoutResource, Sg);
        AppMethodBeat.o(113183);
        return layoutResource;
    }

    private com.tencent.toybrick.f.a Sf(int i) {
        AppMethodBeat.i(113184);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            View inflate = LayoutInflater.from(this.mContext).inflate(i, null);
            inflate.setLayoutParams(new LayoutParams(-1, -2));
            inflate.setOnClickListener(this);
            com.tencent.toybrick.f.a fy = ((g) this.AFR.get(i)).fy(inflate);
            ai.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ((g) this.AFR.get(i)).AGC);
            AppMethodBeat.o(113184);
            return fy;
        } catch (Throwable th) {
            Throwable th2 = th;
            ai.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ((g) this.AFR.get(i)).AGC);
            AppMethodBeat.o(113184);
        }
    }

    public final int getItemCount() {
        AppMethodBeat.i(113185);
        int size = this.AFO.size();
        AppMethodBeat.o(113185);
        return size;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(113186);
        Sg(((com.tencent.toybrick.f.a) view.getTag()).kj());
        AppMethodBeat.o(113186);
    }

    public final g Sg(int i) {
        AppMethodBeat.i(113187);
        if (this.AFO.size() > i) {
            g gVar = (g) this.AFO.get(i);
            AppMethodBeat.o(113187);
            return gVar;
        }
        AppMethodBeat.o(113187);
        return null;
    }
}

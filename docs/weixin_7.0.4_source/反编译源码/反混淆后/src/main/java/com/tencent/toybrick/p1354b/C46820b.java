package com.tencent.toybrick.p1354b;

import android.content.Context;
import android.os.Handler;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.toybrick.p1427ui.BaseToyUI.C31116a;
import com.tencent.toybrick.p1578f.C41100a;
import com.tencent.toybrick.p680c.C44559f;
import com.tencent.toybrick.p680c.C44559f.C59681;
import com.tencent.toybrick.p680c.C44830g;
import com.tencent.toybrick.p681d.C5969a.C5970a;
import com.tencent.toybrick.p682e.C36557b;
import com.tencent.toybrick.p682e.C36557b.C365581;
import com.tencent.toybrick.p682e.C41097c;
import com.tencent.toybrick.p682e.C41097c.C41098b;
import com.tencent.toybrick.p682e.C41097c.C41099d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.toybrick.b.b */
public final class C46820b extends C41523a<C41100a> implements OnClickListener {
    public ArrayList<C44830g> AFO;
    public LinkedList<C44830g> AFP;
    public HashMap<C44830g, Integer> AFQ;
    private SparseArray<C44830g> AFR;
    private C36557b AFS;
    public C5970a AFT;
    private Context mContext;

    /* renamed from: com.tencent.toybrick.b.b$a */
    class C24439a extends C41525c {

        /* renamed from: com.tencent.toybrick.b.b$a$1 */
        class C244401 implements C41098b<C44830g> {
            C244401() {
            }

            /* renamed from: d */
            public final /* synthetic */ void mo40854d(Object obj, boolean z) {
                AppMethodBeat.m2504i(113180);
                C44559f c44559f = (C44830g) obj;
                if (c44559f.isVisible != z) {
                    if (c44559f.isVisible != z) {
                        C31116a c31116a;
                        c44559f.isVisible = z;
                        if (z) {
                            c31116a = C31116a.INSERT;
                        } else {
                            c31116a = C31116a.REMOVE;
                        }
                        c44559f.mMainHandler.removeCallbacks(c44559f.AGB);
                        Handler handler = c44559f.mMainHandler;
                        C59681 c59681 = new C59681(c31116a);
                        c44559f.AGB = c59681;
                        handler.post(c59681);
                    }
                    if (z) {
                        C46820b.m89045a(C46820b.this, (C44830g) c44559f);
                        AppMethodBeat.m2505o(113180);
                        return;
                    }
                    C46820b.m89044a(C46820b.this, c44559f);
                }
                AppMethodBeat.m2505o(113180);
            }
        }

        private C24439a() {
        }

        /* synthetic */ C24439a(C46820b c46820b, byte b) {
            this();
        }

        /* renamed from: av */
        public final void mo35178av(int i, int i2) {
            AppMethodBeat.m2504i(113181);
            super.mo35178av(i, i2);
            C5227ai.m7971d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", Integer.valueOf(i), Integer.valueOf(i2));
            C44830g Sg = C46820b.this.mo75668Sg(i);
            if (!(Sg == null || Sg.AGD == null)) {
                C41097c.execute(new C41099d(Sg, Sg.AGD, new C244401()));
            }
            AppMethodBeat.m2505o(113181);
        }
    }

    public C46820b(Context context, C5970a c5970a) {
        byte b = (byte) 0;
        AppMethodBeat.m2504i(113182);
        mo66307a((C41525c) new C24439a(this, (byte) 0));
        this.mContext = context;
        this.AFT = c5970a;
        LinkedList linkedList = c5970a.AGQ;
        Iterator it = linkedList.iterator();
        while (true) {
            byte b2 = b;
            if (it.hasNext()) {
                ((C44830g) it.next()).btQ = b2;
                b = b2 + 1;
            } else {
                this.AFP = linkedList;
                this.AFR = new SparseArray();
                this.AFQ = new HashMap();
                this.AFO = new ArrayList();
                this.AFS = new C36557b(this);
                C36557b c36557b = this.AFS;
                c36557b.mMainHandler.removeCallbacks(c36557b.AGY);
                Handler handler = c36557b.mMainHandler;
                C365581 c365581 = new C365581();
                c36557b.AGY = c365581;
                handler.post(c365581);
                AppMethodBeat.m2505o(113182);
                return;
            }
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(113183);
        C44830g Sg = mo75668Sg(i);
        int layoutResource = Sg.getLayoutResource();
        this.AFR.put(layoutResource, Sg);
        AppMethodBeat.m2505o(113183);
        return layoutResource;
    }

    /* renamed from: Sf */
    private C41100a m89043Sf(int i) {
        AppMethodBeat.m2504i(113184);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            View inflate = LayoutInflater.from(this.mContext).inflate(i, null);
            inflate.setLayoutParams(new LayoutParams(-1, -2));
            inflate.setOnClickListener(this);
            C41100a fy = ((C44830g) this.AFR.get(i)).mo29718fy(inflate);
            C5227ai.m7971d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ((C44830g) this.AFR.get(i)).AGC);
            AppMethodBeat.m2505o(113184);
            return fy;
        } catch (Throwable th) {
            Throwable th2 = th;
            C5227ai.m7971d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ((C44830g) this.AFR.get(i)).AGC);
            AppMethodBeat.m2505o(113184);
        }
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(113185);
        int size = this.AFO.size();
        AppMethodBeat.m2505o(113185);
        return size;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(113186);
        mo75668Sg(((C41100a) view.getTag()).mo66454kj());
        AppMethodBeat.m2505o(113186);
    }

    /* renamed from: Sg */
    public final C44830g mo75668Sg(int i) {
        AppMethodBeat.m2504i(113187);
        if (this.AFO.size() > i) {
            C44830g c44830g = (C44830g) this.AFO.get(i);
            AppMethodBeat.m2505o(113187);
            return c44830g;
        }
        AppMethodBeat.m2505o(113187);
        return null;
    }
}

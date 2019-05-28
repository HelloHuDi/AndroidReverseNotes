package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.C20998j.C20997a;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.widget.TextProgressBar;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.game.ui.m */
abstract class C43205m extends C12190a<C20992c> {
    protected Context mContext;
    protected int mXC = 0;
    private C21032a nfm;
    protected int ngM = 14;
    private C20997a ngQ = new C343193();
    protected C46016d ngR;
    private OnClickListener nhB = new C122055();
    protected View.OnClickListener nhC = new C343204();
    protected int nkj;
    protected boolean nkk = true;
    protected boolean nkl = false;
    protected boolean nkm = false;
    protected int nkn;
    protected ConcurrentHashMap<String, C21003k> nko;
    protected SparseArray<View> nkp;

    /* renamed from: com.tencent.mm.plugin.game.ui.m$5 */
    class C122055 implements OnClickListener {
        C122055() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(112062);
            C43205m.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(112062);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.m$a */
    public interface C21032a {
        /* renamed from: wF */
        void mo36366wF(int i);
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.m$b */
    protected static class C28265b {
        public ViewGroup nfd;
        public TextView njw;
        public TextProgressBar nkA;
        public GameListSocialView nkB;
        public ViewGroup nkC;
        public LinearLayout nkD;
        public TextView nku;
        public ImageView nkv;
        public TextView nkw;
        public TextView nkx;
        public TextView nky;
        public Button nkz;

        protected C28265b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.m$3 */
    class C343193 implements C20997a {
        C343193() {
        }

        /* renamed from: f */
        public final void mo36316f(int i, String str, boolean z) {
            AppMethodBeat.m2504i(112060);
            if (!z || C43205m.this.nko == null || str == null) {
                AppMethodBeat.m2505o(112060);
                return;
            }
            try {
                for (C21003k c21003k : C43205m.this.nko.values()) {
                    if (!(c21003k == null || c21003k.mVZ == null)) {
                        if (c21003k.mVZ.field_appId.equals(str) || c21003k.mVZ.field_packageName.equals(str)) {
                            c21003k.mo36321ei(C43205m.this.mContext);
                            c21003k.biT();
                        }
                    }
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < C43205m.this.mYj.size()) {
                        C20992c c20992c = (C20992c) C43205m.this.mYj.get(i3);
                        if (c20992c.type != 0 || (!(c20992c.field_appId.equals(str) || c20992c.field_packageName.equals(str)) || C43205m.this.nfm == null)) {
                            i2 = i3 + 1;
                        } else {
                            C43205m.this.nfm.mo36366wF(i3);
                            AppMethodBeat.m2505o(112060);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(112060);
                    return;
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.GameListAdapter", e.getMessage());
                AppMethodBeat.m2505o(112060);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.m$4 */
    class C343204 implements View.OnClickListener {
        C343204() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112061);
            if (view.getTag() instanceof C20992c) {
                C20992c c20992c = (C20992c) view.getTag();
                if (C43205m.this.nko.containsKey(c20992c.field_appId)) {
                    C21003k c21003k = (C21003k) C43205m.this.nko.get(c20992c.field_appId);
                    c21003k.mo36321ei(C43205m.this.mContext);
                    C43205m.this.ngR.nek = c20992c.mVB;
                    C43205m.this.ngR.mXC = C43205m.this.mXC;
                    C43205m.this.ngR.mo73916a(c20992c, c21003k);
                    AppMethodBeat.m2505o(112061);
                    return;
                }
                C4990ab.m7412e("MicroMsg.GameListAdapter", "No DownloadInfo found");
                AppMethodBeat.m2505o(112061);
                return;
            }
            C4990ab.m7412e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
            AppMethodBeat.m2505o(112061);
        }
    }

    /* renamed from: a */
    public abstract void mo62135a(C20992c c20992c, C28265b c28265b);

    /* renamed from: a */
    public abstract void mo62136a(C20992c c20992c, C28265b c28265b, int i);

    public C43205m(Context context) {
        super(context);
        this.mContext = context;
        this.nko = new ConcurrentHashMap();
        C20998j.m32284a(this.ngQ);
        this.nkp = new SparseArray();
        this.ngR = new C46016d(context);
        this.ngR.neA = this.nhB;
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    /* renamed from: wG */
    public void mo62144wG(int i) {
        this.nkn = i;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    /* renamed from: Y */
    public void mo24020Y(final LinkedList<C20992c> linkedList) {
        if (linkedList != null) {
            C1720g.m3539RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.game.ui.m$1$1 */
                class C343171 implements Runnable {
                    C343171() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(112056);
                        super.mo24020Y(linkedList);
                        C4990ab.m7417i("MicroMsg.GameListAdapter", "add size: %d", Integer.valueOf(linkedList.size()));
                        AppMethodBeat.m2505o(112056);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(112057);
                    C43205m.m76820a(C43205m.this, linkedList);
                    C5004al.m7441d(new C343171());
                    AppMethodBeat.m2505o(112057);
                }
            });
        }
    }

    /* renamed from: Z */
    public void mo24021Z(final LinkedList<C20992c> linkedList) {
        if (linkedList != null) {
            C7305d.post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.game.ui.m$2$1 */
                class C343181 implements Runnable {
                    C343181() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(112058);
                        super.mo24021Z(linkedList);
                        C4990ab.m7417i("MicroMsg.GameListAdapter", "set size: %d", Integer.valueOf(linkedList.size()));
                        AppMethodBeat.m2505o(112058);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(112059);
                    C43205m.m76820a(C43205m.this, linkedList);
                    C5004al.m7441d(new C343181());
                    AppMethodBeat.m2505o(112059);
                }
            }, "game_get_download_info");
        }
    }

    public int getItemViewType(int i) {
        return ((C20992c) getItem(i)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C28265b c28265b;
        C20992c c20992c = (C20992c) getItem(i);
        if (view == null) {
            int i2;
            Context context = this.mContext;
            switch (c20992c.type) {
                case 0:
                    i2 = this.nkj;
                    break;
                case 1:
                    i2 = 2130969649;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            C28265b c28265b2 = new C28265b();
            c28265b2.nfd = (ViewGroup) view.findViewById(2131824316);
            c28265b2.nku = (TextView) view.findViewById(2131824295);
            c28265b2.nkv = (ImageView) view.findViewById(2131821535);
            c28265b2.njw = (TextView) view.findViewById(2131821537);
            c28265b2.nkw = (TextView) view.findViewById(2131824400);
            c28265b2.nkx = (TextView) view.findViewById(2131824409);
            c28265b2.nky = (TextView) view.findViewById(2131824318);
            c28265b2.nkz = (Button) view.findViewById(2131824401);
            c28265b2.nkA = (TextProgressBar) view.findViewById(2131824402);
            c28265b2.nkD = (LinearLayout) view.findViewById(2131824290);
            c28265b2.nkB = (GameListSocialView) view.findViewById(2131824403);
            c28265b2.nkC = (ViewGroup) view.findViewById(2131824554);
            view.setTag(c28265b2);
            c28265b = c28265b2;
        } else {
            c28265b = (C28265b) view.getTag();
        }
        switch (c20992c.type) {
            case 0:
                mo62136a(c20992c, c28265b, i);
                if (this.nkn == 2 && !c20992c.mVC) {
                    C34276a.m56205a(this.mContext, 10, 1004, c20992c.position, c20992c.field_appId, this.mXC, c20992c.mVB);
                    c20992c.mVC = true;
                    break;
                }
            case 1:
                mo62135a(c20992c, c28265b);
                break;
        }
        return view;
    }

    /* renamed from: e */
    public void mo62138e(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.nkp = sparseArray;
        } else {
            this.nkp = new SparseArray();
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo62137a(C21032a c21032a) {
        this.nfm = c21032a;
    }

    /* renamed from: U */
    public void mo62134U(View view, int i) {
        C28265b c28265b = (C28265b) view.getTag();
        C20992c c20992c = (C20992c) this.mYj.get(i);
        if (c28265b != null) {
            this.ngR.mo73915a(c28265b.nkA, c28265b.nkz, c20992c, (C21003k) this.nko.get(c20992c.field_appId));
            return;
        }
        C4990ab.m7413e("MicroMsg.GameListAdapter", "holder should not be null, %d", Integer.valueOf(i));
    }

    public void clear() {
        super.clear();
        C20998j.m32288b(this.ngQ);
    }

    /* renamed from: Ok */
    public void mo62132Ok(String str) {
        if (!C5046bo.isNullOrNil(str) && this.nko.containsKey(str)) {
            C21003k c21003k = (C21003k) this.nko.get(str);
            if (c21003k != null) {
                c21003k.biT();
            }
        }
    }

    /* renamed from: Oj */
    public void mo62131Oj(String str) {
        if (!C5046bo.isNullOrNil(str) && this.nko.containsKey(str)) {
            C21003k c21003k = (C21003k) this.nko.get(str);
            if (c21003k != null) {
                c21003k.bEj();
            }
        }
    }

    /* renamed from: Ol */
    public void mo62133Ol(String str) {
        C20992c c20992c;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mYj.size()) {
                c20992c = null;
                break;
            } else if (((C20992c) this.mYj.get(i2)).field_appId.equals(str)) {
                c20992c = (C20992c) this.mYj.get(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (c20992c != null) {
            if (this.nko.containsKey(c20992c.field_appId)) {
                this.ngR.mo73916a(c20992c, (C21003k) this.nko.get(c20992c.field_appId));
                return;
            }
            C4990ab.m7412e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        }
    }
}

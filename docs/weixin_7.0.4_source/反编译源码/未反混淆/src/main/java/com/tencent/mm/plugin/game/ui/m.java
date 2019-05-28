package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m extends a<c> {
    protected Context mContext;
    protected int mXC = 0;
    private a nfm;
    protected int ngM = 14;
    private com.tencent.mm.plugin.game.model.j.a ngQ = new com.tencent.mm.plugin.game.model.j.a() {
        public final void f(int i, String str, boolean z) {
            AppMethodBeat.i(112060);
            if (!z || m.this.nko == null || str == null) {
                AppMethodBeat.o(112060);
                return;
            }
            try {
                for (k kVar : m.this.nko.values()) {
                    if (!(kVar == null || kVar.mVZ == null)) {
                        if (kVar.mVZ.field_appId.equals(str) || kVar.mVZ.field_packageName.equals(str)) {
                            kVar.ei(m.this.mContext);
                            kVar.biT();
                        }
                    }
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < m.this.mYj.size()) {
                        c cVar = (c) m.this.mYj.get(i3);
                        if (cVar.type != 0 || (!(cVar.field_appId.equals(str) || cVar.field_packageName.equals(str)) || m.this.nfm == null)) {
                            i2 = i3 + 1;
                        } else {
                            m.this.nfm.wF(i3);
                            AppMethodBeat.o(112060);
                            return;
                        }
                    }
                    AppMethodBeat.o(112060);
                    return;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.GameListAdapter", e.getMessage());
                AppMethodBeat.o(112060);
            }
        }
    };
    protected d ngR;
    private OnClickListener nhB = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(112062);
            m.this.notifyDataSetChanged();
            AppMethodBeat.o(112062);
        }
    };
    protected View.OnClickListener nhC = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(112061);
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                if (m.this.nko.containsKey(cVar.field_appId)) {
                    k kVar = (k) m.this.nko.get(cVar.field_appId);
                    kVar.ei(m.this.mContext);
                    m.this.ngR.nek = cVar.mVB;
                    m.this.ngR.mXC = m.this.mXC;
                    m.this.ngR.a(cVar, kVar);
                    AppMethodBeat.o(112061);
                    return;
                }
                ab.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
                AppMethodBeat.o(112061);
                return;
            }
            ab.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
            AppMethodBeat.o(112061);
        }
    };
    protected int nkj;
    protected boolean nkk = true;
    protected boolean nkl = false;
    protected boolean nkm = false;
    protected int nkn;
    protected ConcurrentHashMap<String, k> nko;
    protected SparseArray<View> nkp;

    public interface a {
        void wF(int i);
    }

    protected static class b {
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

        protected b() {
        }
    }

    public abstract void a(c cVar, b bVar);

    public abstract void a(c cVar, b bVar, int i);

    public m(Context context) {
        super(context);
        this.mContext = context;
        this.nko = new ConcurrentHashMap();
        j.a(this.ngQ);
        this.nkp = new SparseArray();
        this.ngR = new d(context);
        this.ngR.neA = this.nhB;
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    public void wG(int i) {
        this.nkn = i;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void Y(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(112057);
                    m.a(m.this, linkedList);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112056);
                            super.Y(linkedList);
                            ab.i("MicroMsg.GameListAdapter", "add size: %d", Integer.valueOf(linkedList.size()));
                            AppMethodBeat.o(112056);
                        }
                    });
                    AppMethodBeat.o(112057);
                }
            });
        }
    }

    public void Z(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(112059);
                    m.a(m.this, linkedList);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112058);
                            super.Z(linkedList);
                            ab.i("MicroMsg.GameListAdapter", "set size: %d", Integer.valueOf(linkedList.size()));
                            AppMethodBeat.o(112058);
                        }
                    });
                    AppMethodBeat.o(112059);
                }
            }, "game_get_download_info");
        }
    }

    public int getItemViewType(int i) {
        return ((c) getItem(i)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar = (c) getItem(i);
        if (view == null) {
            int i2;
            Context context = this.mContext;
            switch (cVar.type) {
                case 0:
                    i2 = this.nkj;
                    break;
                case 1:
                    i2 = R.layout.a27;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            b bVar2 = new b();
            bVar2.nfd = (ViewGroup) view.findViewById(R.id.c0y);
            bVar2.nku = (TextView) view.findViewById(R.id.c0d);
            bVar2.nkv = (ImageView) view.findViewById(R.id.zr);
            bVar2.njw = (TextView) view.findViewById(R.id.zt);
            bVar2.nkw = (TextView) view.findViewById(R.id.c38);
            bVar2.nkx = (TextView) view.findViewById(R.id.c3g);
            bVar2.nky = (TextView) view.findViewById(R.id.c10);
            bVar2.nkz = (Button) view.findViewById(R.id.c39);
            bVar2.nkA = (TextProgressBar) view.findViewById(R.id.c3_);
            bVar2.nkD = (LinearLayout) view.findViewById(R.id.c09);
            bVar2.nkB = (GameListSocialView) view.findViewById(R.id.c3a);
            bVar2.nkC = (ViewGroup) view.findViewById(R.id.c7d);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (cVar.type) {
            case 0:
                a(cVar, bVar, i);
                if (this.nkn == 2 && !cVar.mVC) {
                    com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1004, cVar.position, cVar.field_appId, this.mXC, cVar.mVB);
                    cVar.mVC = true;
                    break;
                }
            case 1:
                a(cVar, bVar);
                break;
        }
        return view;
    }

    public void e(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.nkp = sparseArray;
        } else {
            this.nkp = new SparseArray();
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.nfm = aVar;
    }

    public void U(View view, int i) {
        b bVar = (b) view.getTag();
        c cVar = (c) this.mYj.get(i);
        if (bVar != null) {
            this.ngR.a(bVar.nkA, bVar.nkz, cVar, (k) this.nko.get(cVar.field_appId));
            return;
        }
        ab.e("MicroMsg.GameListAdapter", "holder should not be null, %d", Integer.valueOf(i));
    }

    public void clear() {
        super.clear();
        j.b(this.ngQ);
    }

    public void Ok(String str) {
        if (!bo.isNullOrNil(str) && this.nko.containsKey(str)) {
            k kVar = (k) this.nko.get(str);
            if (kVar != null) {
                kVar.biT();
            }
        }
    }

    public void Oj(String str) {
        if (!bo.isNullOrNil(str) && this.nko.containsKey(str)) {
            k kVar = (k) this.nko.get(str);
            if (kVar != null) {
                kVar.bEj();
            }
        }
    }

    public void Ol(String str) {
        c cVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mYj.size()) {
                cVar = null;
                break;
            } else if (((c) this.mYj.get(i2)).field_appId.equals(str)) {
                cVar = (c) this.mYj.get(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (cVar != null) {
            if (this.nko.containsKey(cVar.field_appId)) {
                this.ngR.a(cVar, (k) this.nko.get(cVar.field_appId));
                return;
            }
            ab.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        }
    }
}

package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.m.AnonymousClass5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class m extends com.tencent.mm.pluginsdk.ui.b.b implements com.tencent.mm.modelvideo.t.a {
    ViewGroup mContainer;
    Map<String, Long> zwD = new HashMap();
    Map<Long, b> zwE = new HashMap();

    static final class b {
        ProgressBar gHA;
        long zwG;
        boolean zwH;
        View zwI;
        com.tencent.mm.plugin.sight.decode.a.a zwJ;
        ImageView zwK;
        TextView zwL;
        ImageButton zwM;

        private b() {
            this.zwG = 0;
            this.zwH = false;
            this.zwI = null;
            this.zwJ = null;
            this.zwK = null;
            this.zwL = null;
            this.gHA = null;
            this.zwM = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class c implements Runnable {
        WeakReference<m> zwF;
        List<s> zwO;
        List<s> zwP;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        private static int a(String str, m mVar, List<s> list, int i, int i2, int i3) {
            AppMethodBeat.i(34692);
            for (s sVar : list) {
                mVar.zwD.put(sVar.getFileName(), Long.valueOf(sVar.fVs));
                if (mVar.zwE.containsKey(Long.valueOf(sVar.fVs))) {
                    ab.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", str, Long.valueOf(sVar.fVs), sVar.getFileName());
                } else {
                    View view;
                    b bVar;
                    View inflate;
                    if (i < i2) {
                        ab.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(mVar.mContainer.getChildAt(i).hashCode()), Long.valueOf(sVar.fVs));
                        view = inflate;
                        i = r3;
                    } else {
                        inflate = LayoutInflater.from(mVar.mContainer.getContext()).inflate(R.layout.act, mVar.mContainer, false);
                        mVar.mContainer.addView(inflate);
                        ab.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(inflate.hashCode()), Long.valueOf(sVar.fVs));
                        view = inflate;
                    }
                    b bVar2 = (b) view.getTag();
                    if (bVar2 == null) {
                        bVar = new b();
                    } else {
                        bVar = bVar2;
                    }
                    if (bVar.zwG != sVar.fVs) {
                        ab.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", Long.valueOf(bVar.zwG), Long.valueOf(sVar.fVs), Integer.valueOf(i3));
                        bVar.zwG = sVar.fVs;
                        bVar.zwI = view;
                        bVar.zwJ = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.id.d7w);
                        bVar.zwK = (ImageView) view.findViewById(R.id.d7x);
                        bVar.gHA = (ProgressBar) view.findViewById(R.id.vm);
                        bVar.zwM = (ImageButton) view.findViewById(R.id.axh);
                        bVar.zwL = (TextView) view.findViewById(R.id.by7);
                        bVar.zwJ.setDrawableWidth(view.getResources().getDimensionPixelSize(R.dimen.lw));
                        bVar.zwI.setTag(bVar);
                        bVar.zwM.setTag(Long.valueOf(bVar.zwG));
                        bVar.zwI.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(34690);
                                b bVar = (b) view.getTag();
                                ab.i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", Long.valueOf(bVar.zwG), Boolean.valueOf(bVar.zwH));
                                if (bVar.zwH) {
                                    u.fV(bVar.zwG);
                                }
                                AppMethodBeat.o(34690);
                            }
                        });
                        bVar.zwM.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(34691);
                                ab.i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", Long.valueOf(((Long) view.getTag()).longValue()));
                                g.RS().aa(new AnonymousClass5(r0));
                                AppMethodBeat.o(34691);
                            }
                        });
                    } else {
                        ab.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", Long.valueOf(bVar.zwG), Integer.valueOf(i3));
                    }
                    o.all();
                    String uh = t.uh(sVar.getFileName());
                    o.all();
                    bVar.zwJ.setThumbBmp(com.tencent.mm.at.o.ahl().a(t.ui(sVar.getFileName()), com.tencent.mm.bz.a.getDensity(view.getContext()), view.getContext()));
                    if (i3 > 3) {
                        bVar.zwJ.clear();
                        bVar.zwK.setVisibility(0);
                    } else {
                        bVar.zwJ.bf(uh, false);
                        bVar.zwK.setVisibility(8);
                    }
                    a(bVar, sVar);
                    mVar.zwE.put(Long.valueOf(sVar.fVs), bVar);
                }
            }
            AppMethodBeat.o(34692);
            return i;
        }

        public static void a(b bVar, s sVar) {
            boolean z = true;
            AppMethodBeat.i(34693);
            ab.v("MicroMsg.MassSightBanner", "info status %d", Integer.valueOf(sVar.status));
            if (sVar.status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX || sVar.status == 197 || sVar.status == 196) {
                bVar.gHA.setVisibility(4);
                bVar.zwL.setVisibility(0);
                bVar.zwM.setEnabled(true);
                bVar.zwH = true;
                AppMethodBeat.o(34693);
                return;
            }
            float f = ((float) sVar.fVG) / ((float) sVar.frO);
            bVar.gHA.setVisibility(0);
            bVar.zwL.setVisibility(4);
            bVar.gHA.setProgress((int) (((float) bVar.gHA.getMax()) * f));
            ImageButton imageButton = bVar.zwM;
            if (Float.compare(0.99f, f) <= 0) {
                z = false;
            }
            imageButton.setEnabled(z);
            bVar.zwH = false;
            AppMethodBeat.o(34693);
        }

        public final void run() {
            AppMethodBeat.i(34694);
            m mVar = (m) this.zwF.get();
            if (mVar == null) {
                ab.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
                AppMethodBeat.o(34694);
                return;
            }
            int childCount = mVar.mContainer.getChildCount();
            mVar.zwE.clear();
            HashSet hashSet = new HashSet();
            for (s sVar : this.zwO) {
                hashSet.add(Long.valueOf(sVar.fVs));
            }
            for (s sVar2 : this.zwP) {
                hashSet.add(Long.valueOf(sVar2.fVs));
            }
            int size = hashSet.size();
            int a = a("update fail", mVar, this.zwP, a("update unfinish", mVar, this.zwO, 0, childCount, size), childCount, size);
            for (int i = a; i < childCount; i++) {
                mVar.mContainer.removeViewAt(a);
            }
            AppMethodBeat.o(34694);
        }
    }

    static final class a implements Runnable {
        WeakReference<m> zwF;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(34689);
            List alB = o.all().alB();
            List alC = o.all().alC();
            m mVar = (m) this.zwF.get();
            if (mVar == null) {
                ab.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
                AppMethodBeat.o(34689);
                return;
            }
            ab.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", Integer.valueOf(mVar.mContainer.getChildCount()), Integer.valueOf(alB.size()), Integer.valueOf(alC.size()));
            if (mVar.mContainer.getChildCount() == 0 && alB.isEmpty() && alC.isEmpty()) {
                AppMethodBeat.o(34689);
                return;
            }
            c cVar = new c();
            cVar.zwF = new WeakReference(this.zwF.get());
            cVar.zwO = alB;
            cVar.zwP = alC;
            al.d(cVar);
            AppMethodBeat.o(34689);
        }
    }

    public m(Context context) {
        super(context);
        AppMethodBeat.i(34695);
        o.all().a(this, Looper.getMainLooper());
        this.mContainer = (ViewGroup) this.view;
        AppMethodBeat.o(34695);
    }

    public final int getLayoutId() {
        return R.layout.acs;
    }

    public final void destroy() {
        AppMethodBeat.i(34696);
        o.all().a(this);
        AppMethodBeat.o(34696);
    }

    private void aMk() {
        AppMethodBeat.i(34697);
        ab.i("MicroMsg.MassSightBanner", "call update status");
        a aVar = new a();
        aVar.zwF = new WeakReference(this);
        aw.RS().aa(aVar);
        AppMethodBeat.o(34697);
    }

    public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
        AppMethodBeat.i(34698);
        String str = aVar.fileName;
        Long l = (Long) this.zwD.get(str);
        if (l == null) {
            ab.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", str);
            if (bo.bc(str, "").startsWith("DELETE_")) {
                aMk();
            }
            AppMethodBeat.o(34698);
            return;
        }
        b bVar = (b) this.zwE.get(l);
        if (bVar == null) {
            ab.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", l);
            AppMethodBeat.o(34698);
            return;
        }
        s ut = u.ut(str);
        if (ut == null) {
            ab.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", str, l);
            AppMethodBeat.o(34698);
        } else if (ut.status == 199) {
            ab.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", str, l);
            aMk();
            AppMethodBeat.o(34698);
        } else {
            c.a(bVar, ut);
            AppMethodBeat.o(34698);
        }
    }
}

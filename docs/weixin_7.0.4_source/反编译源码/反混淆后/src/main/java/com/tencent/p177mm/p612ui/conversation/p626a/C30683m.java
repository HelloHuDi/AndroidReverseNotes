package com.tencent.p177mm.p612ui.conversation.p626a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C18709m.C187125;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.conversation.a.m */
public final class C30683m extends C14933b implements C9721a {
    ViewGroup mContainer;
    Map<String, Long> zwD = new HashMap();
    Map<Long, C30684b> zwE = new HashMap();

    /* renamed from: com.tencent.mm.ui.conversation.a.m$b */
    static final class C30684b {
        ProgressBar gHA;
        long zwG;
        boolean zwH;
        View zwI;
        C34915a zwJ;
        ImageView zwK;
        TextView zwL;
        ImageButton zwM;

        /* renamed from: com.tencent.mm.ui.conversation.a.m$b$2 */
        class C306852 implements OnClickListener {
            C306852() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(34691);
                C4990ab.m7417i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", Long.valueOf(((Long) view.getTag()).longValue()));
                C1720g.m3539RS().mo10302aa(new C187125(r0));
                AppMethodBeat.m2505o(34691);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.a.m$b$1 */
        class C306861 implements OnClickListener {
            C306861() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(34690);
                C30684b c30684b = (C30684b) view.getTag();
                C4990ab.m7417i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", Long.valueOf(c30684b.zwG), Boolean.valueOf(c30684b.zwH));
                if (c30684b.zwH) {
                    C26494u.m42254fV(c30684b.zwG);
                }
                AppMethodBeat.m2505o(34690);
            }
        }

        private C30684b() {
            this.zwG = 0;
            this.zwH = false;
            this.zwI = null;
            this.zwJ = null;
            this.zwK = null;
            this.zwL = null;
            this.gHA = null;
            this.zwM = null;
        }

        /* synthetic */ C30684b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.m$c */
    static final class C30687c implements Runnable {
        WeakReference<C30683m> zwF;
        List<C26493s> zwO;
        List<C26493s> zwP;

        private C30687c() {
        }

        /* synthetic */ C30687c(byte b) {
            this();
        }

        /* renamed from: a */
        private static int m48931a(String str, C30683m c30683m, List<C26493s> list, int i, int i2, int i3) {
            AppMethodBeat.m2504i(34692);
            for (C26493s c26493s : list) {
                c30683m.zwD.put(c26493s.getFileName(), Long.valueOf(c26493s.fVs));
                if (c30683m.zwE.containsKey(Long.valueOf(c26493s.fVs))) {
                    C4990ab.m7411d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", str, Long.valueOf(c26493s.fVs), c26493s.getFileName());
                } else {
                    View view;
                    C30684b c30684b;
                    View inflate;
                    if (i < i2) {
                        C4990ab.m7411d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(c30683m.mContainer.getChildAt(i).hashCode()), Long.valueOf(c26493s.fVs));
                        view = inflate;
                        i = r3;
                    } else {
                        inflate = LayoutInflater.from(c30683m.mContainer.getContext()).inflate(2130970079, c30683m.mContainer, false);
                        c30683m.mContainer.addView(inflate);
                        C4990ab.m7411d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(inflate.hashCode()), Long.valueOf(c26493s.fVs));
                        view = inflate;
                    }
                    C30684b c30684b2 = (C30684b) view.getTag();
                    if (c30684b2 == null) {
                        c30684b = new C30684b();
                    } else {
                        c30684b = c30684b2;
                    }
                    if (c30684b.zwG != c26493s.fVs) {
                        C4990ab.m7411d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", Long.valueOf(c30684b.zwG), Long.valueOf(c26493s.fVs), Integer.valueOf(i3));
                        c30684b.zwG = c26493s.fVs;
                        c30684b.zwI = view;
                        c30684b.zwJ = (C34915a) view.findViewById(2131825941);
                        c30684b.zwK = (ImageView) view.findViewById(2131825942);
                        c30684b.gHA = (ProgressBar) view.findViewById(2131821370);
                        c30684b.zwM = (ImageButton) view.findViewById(2131822819);
                        c30684b.zwL = (TextView) view.findViewById(2131824214);
                        c30684b.zwJ.setDrawableWidth(view.getResources().getDimensionPixelSize(C25738R.dimen.f9972lw));
                        c30684b.zwI.setTag(c30684b);
                        c30684b.zwM.setTag(Long.valueOf(c30684b.zwG));
                        c30684b.zwI.setOnClickListener(new C306861());
                        c30684b.zwM.setOnClickListener(new C306852());
                    } else {
                        C4990ab.m7411d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", Long.valueOf(c30684b.zwG), Integer.valueOf(i3));
                    }
                    C37961o.all();
                    String uh = C9720t.m17303uh(c26493s.getFileName());
                    C37961o.all();
                    c30684b.zwJ.setThumbBmp(C32291o.ahl().mo73085a(C9720t.m17304ui(c26493s.getFileName()), C1338a.getDensity(view.getContext()), view.getContext()));
                    if (i3 > 3) {
                        c30684b.zwJ.clear();
                        c30684b.zwK.setVisibility(0);
                    } else {
                        c30684b.zwJ.mo8509bf(uh, false);
                        c30684b.zwK.setVisibility(8);
                    }
                    C30687c.m48932a(c30684b, c26493s);
                    c30683m.zwE.put(Long.valueOf(c26493s.fVs), c30684b);
                }
            }
            AppMethodBeat.m2505o(34692);
            return i;
        }

        /* renamed from: a */
        public static void m48932a(C30684b c30684b, C26493s c26493s) {
            boolean z = true;
            AppMethodBeat.m2504i(34693);
            C4990ab.m7419v("MicroMsg.MassSightBanner", "info status %d", Integer.valueOf(c26493s.status));
            if (c26493s.status == C27011o.CTRL_INDEX || c26493s.status == 197 || c26493s.status == 196) {
                c30684b.gHA.setVisibility(4);
                c30684b.zwL.setVisibility(0);
                c30684b.zwM.setEnabled(true);
                c30684b.zwH = true;
                AppMethodBeat.m2505o(34693);
                return;
            }
            float f = ((float) c26493s.fVG) / ((float) c26493s.frO);
            c30684b.gHA.setVisibility(0);
            c30684b.zwL.setVisibility(4);
            c30684b.gHA.setProgress((int) (((float) c30684b.gHA.getMax()) * f));
            ImageButton imageButton = c30684b.zwM;
            if (Float.compare(0.99f, f) <= 0) {
                z = false;
            }
            imageButton.setEnabled(z);
            c30684b.zwH = false;
            AppMethodBeat.m2505o(34693);
        }

        public final void run() {
            AppMethodBeat.m2504i(34694);
            C30683m c30683m = (C30683m) this.zwF.get();
            if (c30683m == null) {
                C4990ab.m7420w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
                AppMethodBeat.m2505o(34694);
                return;
            }
            int childCount = c30683m.mContainer.getChildCount();
            c30683m.zwE.clear();
            HashSet hashSet = new HashSet();
            for (C26493s c26493s : this.zwO) {
                hashSet.add(Long.valueOf(c26493s.fVs));
            }
            for (C26493s c26493s2 : this.zwP) {
                hashSet.add(Long.valueOf(c26493s2.fVs));
            }
            int size = hashSet.size();
            int a = C30687c.m48931a("update fail", c30683m, this.zwP, C30687c.m48931a("update unfinish", c30683m, this.zwO, 0, childCount, size), childCount, size);
            for (int i = a; i < childCount; i++) {
                c30683m.mContainer.removeViewAt(a);
            }
            AppMethodBeat.m2505o(34694);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.m$a */
    static final class C30688a implements Runnable {
        WeakReference<C30683m> zwF;

        private C30688a() {
        }

        /* synthetic */ C30688a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(34689);
            List alB = C37961o.all().alB();
            List alC = C37961o.all().alC();
            C30683m c30683m = (C30683m) this.zwF.get();
            if (c30683m == null) {
                C4990ab.m7420w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
                AppMethodBeat.m2505o(34689);
                return;
            }
            C4990ab.m7417i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", Integer.valueOf(c30683m.mContainer.getChildCount()), Integer.valueOf(alB.size()), Integer.valueOf(alC.size()));
            if (c30683m.mContainer.getChildCount() == 0 && alB.isEmpty() && alC.isEmpty()) {
                AppMethodBeat.m2505o(34689);
                return;
            }
            C30687c c30687c = new C30687c();
            c30687c.zwF = new WeakReference(this.zwF.get());
            c30687c.zwO = alB;
            c30687c.zwP = alC;
            C5004al.m7441d(c30687c);
            AppMethodBeat.m2505o(34689);
        }
    }

    public C30683m(Context context) {
        super(context);
        AppMethodBeat.m2504i(34695);
        C37961o.all().mo21053a(this, Looper.getMainLooper());
        this.mContainer = (ViewGroup) this.view;
        AppMethodBeat.m2505o(34695);
    }

    public final int getLayoutId() {
        return 2130970078;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(34696);
        C37961o.all().mo21052a(this);
        AppMethodBeat.m2505o(34696);
    }

    private void aMk() {
        AppMethodBeat.m2504i(34697);
        C4990ab.m7416i("MicroMsg.MassSightBanner", "call update status");
        C30688a c30688a = new C30688a();
        c30688a.zwF = new WeakReference(this);
        C9638aw.m17180RS().mo10302aa(c30688a);
        AppMethodBeat.m2505o(34697);
    }

    /* renamed from: a */
    public final void mo11381a(C9718a c9718a) {
        AppMethodBeat.m2504i(34698);
        String str = c9718a.fileName;
        Long l = (Long) this.zwD.get(str);
        if (l == null) {
            C4990ab.m7411d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", str);
            if (C5046bo.m7532bc(str, "").startsWith("DELETE_")) {
                aMk();
            }
            AppMethodBeat.m2505o(34698);
            return;
        }
        C30684b c30684b = (C30684b) this.zwE.get(l);
        if (c30684b == null) {
            C4990ab.m7411d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", l);
            AppMethodBeat.m2505o(34698);
            return;
        }
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null) {
            C4990ab.m7421w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", str, l);
            AppMethodBeat.m2505o(34698);
        } else if (ut.status == 199) {
            C4990ab.m7417i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", str, l);
            aMk();
            AppMethodBeat.m2505o(34698);
        } else {
            C30687c.m48932a(c30684b, ut);
            AppMethodBeat.m2505o(34698);
        }
    }
}

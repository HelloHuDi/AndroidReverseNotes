package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9059f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.g */
public final class C45934g extends C20714a {
    private final int moM;
    private Set<ImageView> moO;
    private OnClickListener moP = new C118861();

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.g$1 */
    class C118861 implements OnClickListener {
        C118861() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74628);
            if (C1445f.m3070Mn()) {
                if (view.getTag() instanceof C27966g) {
                    C27966g c27966g = (C27966g) view.getTag();
                    abl abl = c27966g.field_favProto.wit;
                    aar c = C39037b.m66378c(c27966g);
                    if (c == null) {
                        C4990ab.m7420w("MicroMsg.FavBaseListItem", "data item is null");
                        AppMethodBeat.m2505o(74628);
                        return;
                    } else if (C39037b.m66390e(c)) {
                        C4990ab.m7416i("MicroMsg.FavBaseListItem", "same song, do release");
                        C37494a.aic();
                        C45934g.m85266a(C45934g.this, null);
                        AppMethodBeat.m2505o(74628);
                        return;
                    } else {
                        String w;
                        C5728b c5728b = new C5728b(C39037b.m66379c(c));
                        if (c5728b.exists()) {
                            w = C5736j.m8649w(c5728b.dMD());
                        } else if (c.cvq == null) {
                            w = "";
                        } else {
                            String w2;
                            c5728b = new C5728b(C39037b.bue() + C1178g.m2591x(c.cvq.getBytes()));
                            if (c5728b.exists()) {
                                w2 = C5736j.m8649w(c5728b.dMD());
                            } else {
                                w2 = "";
                            }
                            w = w2;
                        }
                        C37494a.m63280b(C9059f.m16431a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, C39037b.bul(), w, "", abl.appId));
                        C45934g.m85266a(C45934g.this, (ImageView) view);
                    }
                }
                AppMethodBeat.m2505o(74628);
                return;
            }
            C23639t.m36492hO(C45934g.this.mhy.context);
            AppMethodBeat.m2505o(74628);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.g$a */
    public static class C34160a extends C3084b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
        ImageView moR;
    }

    public C45934g(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74629);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9852hw);
        this.moO = new HashSet();
        AppMethodBeat.m2505o(74629);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        AppMethodBeat.m2504i(74630);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c34160a = new C34160a();
            view = mo36015a(View.inflate(context, 2130969506, null), c34160a, c27966g);
            c34160a.iqT = (ImageView) view.findViewById(2131821479);
            c34160a.gnB = (TextView) view.findViewById(2131820619);
            c34160a.gnC = (TextView) view.findViewById(2131820602);
            c34160a.moR = (ImageView) view.findViewById(2131821480);
            c34160a.moL = (TextView) view.findViewById(2131820615);
            c34160a.moL.setVisibility(8);
            c34160a.moR.setOnClickListener(this.moP);
            c34160a.moR.setVisibility(0);
            this.moO.add(c34160a.moR);
            c3084b = c34160a;
        } else {
            c3084b = (C34160a) view.getTag();
        }
        mo36016a(c3084b, c27966g);
        aar c = C39037b.m66378c(c27966g);
        c3084b.gnB.setText(c.title);
        c3084b.gnC.setText(c.desc);
        c3084b.gnC.setVisibility(0);
        this.mhy.mo73786a(c3084b.iqT, c, c27966g, (int) C1318a.app_attach_file_icon_music, this.moM, this.moM);
        c3084b.moR.setTag(c27966g);
        if (C39037b.m66390e(c)) {
            c3084b.moR.setImageResource(C25738R.drawable.f6930vq);
        } else {
            c3084b.moR.setImageResource(C25738R.drawable.f6932vs);
        }
        AppMethodBeat.m2505o(74630);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74631);
        C34160a c34160a = (C34160a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c34160a.mgf, abh);
        AppMethodBeat.m2505o(74631);
    }
}

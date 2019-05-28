package com.tencent.p177mm.plugin.gallery.p427ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C39158a;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView */
public class ImageFolderMgrView extends LinearLayout implements OnItemClickListener, C39158a {
    boolean aej = false;
    FrameLayout mQA;
    private View mQB;
    private ListView mQC;
    private C43147b mQD;
    boolean mQE = false;
    private C43145a mQz = null;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView$1 */
    class C209141 implements AnimationListener {
        C209141() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(21472);
            ImageFolderMgrView.this.mQA.setVisibility(8);
            ImageFolderMgrView.this.aej = false;
            ImageFolderMgrView.this.mQE = false;
            AppMethodBeat.m2505o(21472);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView$2 */
    class C209152 implements AnimationListener {
        C209152() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(21473);
            ImageFolderMgrView.this.aej = true;
            ImageFolderMgrView.this.mQE = false;
            AppMethodBeat.m2505o(21473);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView$3 */
    class C391723 implements OnClickListener {
        C391723() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21474);
            ImageFolderMgrView.m85416c(ImageFolderMgrView.this);
            AppMethodBeat.m2505o(21474);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView$a */
    public interface C43145a {
        /* renamed from: b */
        void mo7517b(AlbumItem albumItem);
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView$4 */
    class C459814 implements Runnable {
        C459814() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21475);
            ImageFolderMgrView.this.mQD.notifyDataSetChanged();
            AppMethodBeat.m2505o(21475);
        }

        public final String toString() {
            AppMethodBeat.m2504i(21476);
            String str = super.toString() + "|onQueryAlbumFinished";
            AppMethodBeat.m2505o(21476);
            return str;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m85416c(ImageFolderMgrView imageFolderMgrView) {
        AppMethodBeat.m2504i(21484);
        imageFolderMgrView.m85418hE(false);
        AppMethodBeat.m2505o(21484);
    }

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(21477);
        setOrientation(1);
        this.mQA = new FrameLayout(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.mQA.setVisibility(8);
        addView(this.mQA, layoutParams);
        this.mQB = new View(getContext());
        this.mQB.setBackgroundColor(-872415232);
        this.mQB.setOnClickListener(new C391723());
        this.mQA.addView(this.mQB, new FrameLayout.LayoutParams(-1, -1));
        this.mQC = new ListView(getContext());
        this.mQC.setCacheColorHint(0);
        this.mQC.setBackgroundResource(C25738R.color.f12200vs);
        this.mQC.setSelector(C25738R.drawable.f6900uv);
        this.mQC.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
        this.mQC.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, (dimensionPixelSize * 2) / 3);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
        layoutParams2.gravity = 80;
        this.mQA.addView(this.mQC, layoutParams2);
        this.mQD = new C43147b(getContext(), C34237e.bBZ().mOu);
        this.mQC.setAdapter(this.mQD);
        AppMethodBeat.m2505o(21477);
    }

    public final void bCE() {
        AppMethodBeat.m2504i(21478);
        m85418hE(!this.aej);
        AppMethodBeat.m2505o(21478);
    }

    /* renamed from: hE */
    private void m85418hE(boolean z) {
        AppMethodBeat.m2504i(21479);
        if (this.aej == z) {
            C4990ab.m7411d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.aej));
            AppMethodBeat.m2505o(21479);
        } else if (this.mQE) {
            C4990ab.m7411d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
            AppMethodBeat.m2505o(21479);
        } else if (this.aej) {
            bCF();
            AppMethodBeat.m2505o(21479);
        } else {
            bCG();
            AppMethodBeat.m2505o(21479);
        }
    }

    private void bCF() {
        AppMethodBeat.m2504i(21480);
        this.mQE = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8373ce);
        loadAnimation.setAnimationListener(new C209141());
        this.mQC.startAnimation(loadAnimation);
        this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8333b6));
        AppMethodBeat.m2505o(21480);
    }

    private void bCG() {
        AppMethodBeat.m2504i(21481);
        this.mQE = true;
        this.mQA.setVisibility(0);
        this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8332b5));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8375cg);
        loadAnimation.setAnimationListener(new C209152());
        this.mQC.startAnimation(loadAnimation);
        AppMethodBeat.m2505o(21481);
    }

    public void setListener(C43145a c43145a) {
        this.mQz = c43145a;
    }

    /* renamed from: V */
    public final void mo62060V(LinkedList<AlbumItem> linkedList) {
        AppMethodBeat.m2504i(21482);
        C43147b c43147b = this.mQD;
        c43147b.mQe = linkedList;
        if (!(c43147b.mQe == null || c43147b.mQe.isEmpty() || ((AlbumItem) c43147b.mQe.get(0)).oqq == null)) {
            AlbumItem albumItem;
            AlbumItem albumItem2 = null;
            Iterator it = c43147b.mQe.iterator();
            while (true) {
                albumItem = albumItem2;
                if (!it.hasNext()) {
                    break;
                }
                albumItem2 = (AlbumItem) it.next();
                if (albumItem != null) {
                    if (albumItem.oqq.mOl >= albumItem2.oqq.mOl) {
                        albumItem2 = albumItem;
                    }
                }
            }
            if (albumItem != null) {
                c43147b.mQf.oqq = albumItem.oqq;
            }
        }
        C34237e.bCa().mo36236d(new C459814());
        AppMethodBeat.m2505o(21482);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(21483);
        AlbumItem ww = this.mQD.mo68666ww(i);
        if (ww == null) {
            C4990ab.m7410d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(21483);
            return;
        }
        if (this.mQz != null) {
            this.mQz.mo7517b(ww);
        }
        this.mQD.mQg = C5046bo.m7532bc(ww.mOh, "");
        this.mQC.setSelection(0);
        this.mQD.notifyDataSetChanged();
        this.mQB.performClick();
        AppMethodBeat.m2505o(21483);
    }
}

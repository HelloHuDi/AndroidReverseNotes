package com.tencent.mm.plugin.gallery.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView extends LinearLayout implements OnItemClickListener, com.tencent.mm.plugin.gallery.model.i.a {
    boolean aej = false;
    FrameLayout mQA;
    private View mQB;
    private ListView mQC;
    private b mQD;
    boolean mQE = false;
    private a mQz = null;

    public interface a {
        void b(AlbumItem albumItem);
    }

    static /* synthetic */ void c(ImageFolderMgrView imageFolderMgrView) {
        AppMethodBeat.i(21484);
        imageFolderMgrView.hE(false);
        AppMethodBeat.o(21484);
    }

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(21477);
        setOrientation(1);
        this.mQA = new FrameLayout(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.mQA.setVisibility(8);
        addView(this.mQA, layoutParams);
        this.mQB = new View(getContext());
        this.mQB.setBackgroundColor(-872415232);
        this.mQB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21474);
                ImageFolderMgrView.c(ImageFolderMgrView.this);
                AppMethodBeat.o(21474);
            }
        });
        this.mQA.addView(this.mQB, new FrameLayout.LayoutParams(-1, -1));
        this.mQC = new ListView(getContext());
        this.mQC.setCacheColorHint(0);
        this.mQC.setBackgroundResource(R.color.vs);
        this.mQC.setSelector(R.drawable.uv);
        this.mQC.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.m4);
        this.mQC.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, (dimensionPixelSize * 2) / 3);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.fd);
        layoutParams2.gravity = 80;
        this.mQA.addView(this.mQC, layoutParams2);
        this.mQD = new b(getContext(), e.bBZ().mOu);
        this.mQC.setAdapter(this.mQD);
        AppMethodBeat.o(21477);
    }

    public final void bCE() {
        AppMethodBeat.i(21478);
        hE(!this.aej);
        AppMethodBeat.o(21478);
    }

    private void hE(boolean z) {
        AppMethodBeat.i(21479);
        if (this.aej == z) {
            ab.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.aej));
            AppMethodBeat.o(21479);
        } else if (this.mQE) {
            ab.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
            AppMethodBeat.o(21479);
        } else if (this.aej) {
            bCF();
            AppMethodBeat.o(21479);
        } else {
            bCG();
            AppMethodBeat.o(21479);
        }
    }

    private void bCF() {
        AppMethodBeat.i(21480);
        this.mQE = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ce);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(21472);
                ImageFolderMgrView.this.mQA.setVisibility(8);
                ImageFolderMgrView.this.aej = false;
                ImageFolderMgrView.this.mQE = false;
                AppMethodBeat.o(21472);
            }
        });
        this.mQC.startAnimation(loadAnimation);
        this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.b6));
        AppMethodBeat.o(21480);
    }

    private void bCG() {
        AppMethodBeat.i(21481);
        this.mQE = true;
        this.mQA.setVisibility(0);
        this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.b5));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.cg);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(21473);
                ImageFolderMgrView.this.aej = true;
                ImageFolderMgrView.this.mQE = false;
                AppMethodBeat.o(21473);
            }
        });
        this.mQC.startAnimation(loadAnimation);
        AppMethodBeat.o(21481);
    }

    public void setListener(a aVar) {
        this.mQz = aVar;
    }

    public final void V(LinkedList<AlbumItem> linkedList) {
        AppMethodBeat.i(21482);
        b bVar = this.mQD;
        bVar.mQe = linkedList;
        if (!(bVar.mQe == null || bVar.mQe.isEmpty() || ((AlbumItem) bVar.mQe.get(0)).oqq == null)) {
            AlbumItem albumItem;
            AlbumItem albumItem2 = null;
            Iterator it = bVar.mQe.iterator();
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
                bVar.mQf.oqq = albumItem.oqq;
            }
        }
        e.bCa().d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21475);
                ImageFolderMgrView.this.mQD.notifyDataSetChanged();
                AppMethodBeat.o(21475);
            }

            public final String toString() {
                AppMethodBeat.i(21476);
                String str = super.toString() + "|onQueryAlbumFinished";
                AppMethodBeat.o(21476);
                return str;
            }
        });
        AppMethodBeat.o(21482);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(21483);
        AlbumItem ww = this.mQD.ww(i);
        if (ww == null) {
            ab.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(i)));
            AppMethodBeat.o(21483);
            return;
        }
        if (this.mQz != null) {
            this.mQz.b(ww);
        }
        this.mQD.mQg = bo.bc(ww.mOh, "");
        this.mQC.setSelection(0);
        this.mQD.notifyDataSetChanged();
        this.mQB.performClick();
        AppMethodBeat.o(21483);
    }
}

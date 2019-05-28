package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class f extends android.support.v7.widget.RecyclerView.a<a> implements OnClickListener {
    private Context mContext;
    private ArrayList<String> mQW;
    private boolean mQm;
    c mRC;
    private int mRD;
    ArrayList<String> mRE = new ArrayList();
    b mRF;
    private int mRG = -1;
    private int mRH = -1;
    private int mRI;
    private int mRJ;
    private Drawable mRK;
    android.support.v7.widget.a.a mRL = new android.support.v7.widget.a.a(new android.support.v7.widget.a.a.a() {
        int cPK = -1;

        public final boolean a(v vVar, v vVar2) {
            AppMethodBeat.i(21572);
            int kj = vVar.kj();
            int kj2 = vVar2.kj();
            f.this.as(kj, kj2);
            if (f.this.mRF != null) {
                f.this.mRF.ek(kj, kj2);
            }
            f.this.mRH = kj2;
            AppMethodBeat.o(21572);
            return false;
        }

        public final void f(final v vVar, final int i) {
            AppMethodBeat.i(21573);
            super.f(vVar, i);
            if (vVar != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(f.this.mContext, R.anim.br);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(21570);
                        if (i == 2) {
                            f.this.mRG = f.this.mRH = vVar.kj();
                            AnonymousClass1.this.cPK = f.this.mRJ;
                            ab.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", Integer.valueOf(AnonymousClass1.this.cPK));
                        }
                        AppMethodBeat.o(21570);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) vVar).mRR.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(21573);
        }

        public final void a(RecyclerView recyclerView, v vVar) {
            AppMethodBeat.i(21574);
            if (vVar != null) {
                super.a(recyclerView, vVar);
                Animation loadAnimation = AnimationUtils.loadAnimation(f.this.mContext, R.anim.bq);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(21571);
                        com.tencent.mm.plugin.gallery.a.a.swap(f.this.mRE, f.this.mRG, f.this.mRH);
                        if (f.this.mRF != null) {
                            if (AnonymousClass1.this.cPK > f.this.mRG && AnonymousClass1.this.cPK <= f.this.mRH) {
                                f.this.mRF.X(f.this.mRG, f.this.mRH, AnonymousClass1.this.cPK - 1);
                                AppMethodBeat.o(21571);
                                return;
                            } else if (AnonymousClass1.this.cPK < f.this.mRG && AnonymousClass1.this.cPK >= f.this.mRH) {
                                f.this.mRF.X(f.this.mRG, f.this.mRH, AnonymousClass1.this.cPK + 1);
                                AppMethodBeat.o(21571);
                                return;
                            } else if (f.this.mRG == AnonymousClass1.this.cPK) {
                                f.this.mRF.X(f.this.mRG, f.this.mRH, f.this.mRH);
                                AppMethodBeat.o(21571);
                                return;
                            } else {
                                f.this.mRF.X(f.this.mRG, f.this.mRH, AnonymousClass1.this.cPK);
                            }
                        }
                        AppMethodBeat.o(21571);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) vVar).mRR.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(21574);
        }

        public final float lC() {
            return 0.295858f;
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, v vVar, float f, float f2, int i, boolean z) {
            AppMethodBeat.i(21575);
            super.a(canvas, recyclerView, vVar, f / 1.3f, f2 / 1.3f, i, z);
            AppMethodBeat.o(21575);
        }

        public final boolean lB() {
            return false;
        }
    });

    public static class a extends v {
        public ImageView mOW;
        public ImageView mOX;
        public RelativeLayout mOY;
        public TextView mOZ;
        public ImageView mPb;
        public ImageView mPc;
        public ImageView mPd;
        public ImageView mRQ;
        public View mRR;
        public int mRS;

        public a(View view) {
            super(view);
            AppMethodBeat.i(21577);
            this.mRR = view;
            this.mPc = (ImageView) view.findViewById(R.id.dns);
            this.mPd = (ImageView) view.findViewById(R.id.dnt);
            this.mRQ = (ImageView) view.findViewById(R.id.ape);
            this.mOW = (ImageView) view.findViewById(R.id.dnv);
            this.mOX = (ImageView) view.findViewById(R.id.akx);
            this.mOY = (RelativeLayout) view.findViewById(R.id.cik);
            this.mOZ = (TextView) view.findViewById(R.id.dnr);
            this.mPb = (ImageView) view.findViewById(R.id.dnu);
            this.mPb.setBackgroundResource(R.color.rr);
            this.mPb.setVisibility(8);
            AppMethodBeat.o(21577);
        }
    }

    public interface b {
        void X(int i, int i2, int i3);

        void ek(int i, int i2);

        void wC(int i);
    }

    public final /* synthetic */ void a(v vVar, int i, List list) {
        AppMethodBeat.i(21587);
        a aVar = (a) vVar;
        if (list.isEmpty()) {
            a(aVar, i);
            AppMethodBeat.o(21587);
            return;
        }
        MediaItem a = a(i, aVar);
        if (a == null) {
            AppMethodBeat.o(21587);
            return;
        }
        c(aVar.mOW, a.fPT, i);
        AppMethodBeat.o(21587);
    }

    public final void el(int i, int i2) {
        this.mRJ = i;
        this.mRI = i2;
    }

    public f(Context context, ArrayList<String> arrayList, int i, boolean z) {
        AppMethodBeat.i(21578);
        this.mContext = context;
        this.mQW = arrayList;
        this.mRE.addAll(arrayList);
        this.mRD = i;
        this.mQm = z;
        this.mRK = context.getResources().getDrawable(R.drawable.lp);
        AppMethodBeat.o(21578);
    }

    public final void addItem(String str) {
        AppMethodBeat.i(21579);
        this.mRE.add(str);
        AppMethodBeat.o(21579);
    }

    public final int indexOf(String str) {
        AppMethodBeat.i(21580);
        int indexOf = this.mRE.indexOf(str);
        AppMethodBeat.o(21580);
        return indexOf;
    }

    public final void remove(int i) {
        AppMethodBeat.i(21581);
        this.mRE.remove(i);
        AppMethodBeat.o(21581);
    }

    private void a(final a aVar, int i) {
        AppMethodBeat.i(21582);
        MediaItem a = a(i, aVar);
        if (a == null) {
            ab.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
            AppMethodBeat.o(21582);
            return;
        }
        LayoutParams layoutParams = aVar.mRR.getLayoutParams();
        int i2 = this.mRD;
        layoutParams.width = i2;
        layoutParams.height = i2;
        c(aVar.mOW, a.fPT, i);
        aVar.mRR.setOnClickListener(this);
        if (this.mQm) {
            aVar.mRR.setTag(Integer.valueOf(aVar.mRS));
        } else {
            aVar.mRR.setTag(a.fPT);
        }
        if (a.getType() == 2) {
            aVar.mOY.setVisibility(0);
            int round = Math.round(((float) ((long) ((VideoMediaItem) a).fPW)) / 1000.0f);
            aVar.mOZ.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        } else {
            aVar.mOY.setVisibility(8);
        }
        String Wy = a.Wy();
        String str = a.fPT;
        if (bo.isNullOrNil(Wy) && bo.isNullOrNil(str)) {
            ab.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(i)));
            AppMethodBeat.o(21582);
            return;
        }
        h.a(aVar.mOX, a.getType(), Wy, str, a.mOk, this.mRD, new com.tencent.mm.plugin.gallery.ui.h.a() {
            public final void bCx() {
                AppMethodBeat.i(21576);
                ab.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", Integer.valueOf(aVar.mOX.getWidth()), Integer.valueOf(aVar.mOX.getHeight()));
                AppMethodBeat.o(21576);
            }
        });
        if ((e.bBZ().hOZ == 3 || e.bBZ().hOZ == 11) && a != null && a.mMimeType.equalsIgnoreCase("image/gif")) {
            aVar.mPc.setVisibility(0);
        } else {
            aVar.mPc.setVisibility(8);
        }
        if (a.mMimeType.equalsIgnoreCase("edit")) {
            aVar.mPd.setVisibility(0);
        } else {
            aVar.mPd.setVisibility(8);
        }
        aVar.mRQ.setVisibility(8);
        AppMethodBeat.o(21582);
    }

    private void c(ImageView imageView, String str, int i) {
        int i2;
        AppMethodBeat.i(21583);
        if (this.mQW.contains(str)) {
            imageView.setBackground(null);
            imageView.setImageDrawable(this.mRK);
            i2 = 0;
        } else {
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(null);
            i2 = 1;
        }
        imageView.setVisibility(0);
        if (!bo.isNullOrNil(this.mRC.getItem(this.mRI)) && this.mRC.getItem(this.mRI).equals(str)) {
            imageView.setVisibility(0);
            if (i2 != 0 && i == this.mRJ) {
                imageView.setImageDrawable(this.mRK);
                AppMethodBeat.o(21583);
                return;
            }
        } else if (!(bo.isNullOrNil(this.mRC.getItem(this.mRI)) || this.mRC.getItem(this.mRI).equals(str))) {
            if (i != this.mRJ && i2 == 0) {
                imageView.setVisibility(8);
                AppMethodBeat.o(21583);
                return;
            } else if (i == this.mRJ && i2 == 0) {
                imageView.setImageDrawable(this.mRK);
            }
        }
        AppMethodBeat.o(21583);
    }

    public final int getItemCount() {
        AppMethodBeat.i(21584);
        int size = this.mRE.size();
        AppMethodBeat.o(21584);
        return size;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(21585);
        if (this.mRF != null) {
            if (this.mQm) {
                this.mRF.wC(((Integer) view.getTag()).intValue());
                AppMethodBeat.o(21585);
                return;
            }
            this.mRF.wC(this.mRE.indexOf(view.getTag()));
        }
        AppMethodBeat.o(21585);
    }

    private MediaItem a(int i, a aVar) {
        AppMethodBeat.i(21586);
        if (i < 0 || i >= this.mRE.size()) {
            ab.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mRE.size()));
            AppMethodBeat.o(21586);
            return null;
        }
        MediaItem mediaItem;
        String str = (String) this.mRE.get(i);
        MediaItem a;
        int indexOf;
        Iterator it;
        if (this.mQm) {
            if (this.mRC.mOH != null) {
                a = MediaItem.a(0, 0, str, str, "");
                indexOf = this.mRC.mOH.indexOf(a);
                if (indexOf >= 0) {
                    aVar.mRS = indexOf;
                    mediaItem = (MediaItem) this.mRC.mOH.get(indexOf);
                } else {
                    it = e.bCe().iterator();
                    while (it.hasNext()) {
                        mediaItem = (MediaItem) it.next();
                        if (mediaItem.equals(a)) {
                            ab.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", mediaItem.fPT);
                            break;
                        }
                    }
                    mediaItem = null;
                }
            } else {
                mediaItem = null;
            }
        } else if (e.bCb() != null) {
            a = MediaItem.a(0, 0, str, str, "");
            indexOf = e.bCb().indexOf(a);
            if (indexOf >= 0) {
                mediaItem = (MediaItem) e.bCb().get(indexOf);
            } else {
                it = e.bCe().iterator();
                while (it.hasNext()) {
                    mediaItem = (MediaItem) it.next();
                    if (mediaItem.equals(a)) {
                        ab.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", mediaItem.fPT);
                        break;
                    }
                }
                mediaItem = null;
            }
        } else {
            mediaItem = MediaItem.a(1, 0, str, str, "");
        }
        AppMethodBeat.o(21586);
        return mediaItem;
    }
}

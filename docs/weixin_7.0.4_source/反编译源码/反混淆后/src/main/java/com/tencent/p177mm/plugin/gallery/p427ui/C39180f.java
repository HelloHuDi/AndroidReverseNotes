package com.tencent.p177mm.plugin.gallery.p427ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.p076a.C8452a;
import android.support.p069v7.widget.p076a.C8452a.C8457a;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.p177mm.plugin.gallery.p1267a.C20902a;
import com.tencent.p177mm.plugin.gallery.p427ui.C20921h.C12100a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.gallery.ui.f */
public final class C39180f extends C41523a<C34255a> implements OnClickListener {
    private Context mContext;
    private ArrayList<String> mQW;
    private boolean mQm;
    C44743c mRC;
    private int mRD;
    ArrayList<String> mRE = new ArrayList();
    C34256b mRF;
    private int mRG = -1;
    private int mRH = -1;
    private int mRI;
    private int mRJ;
    private Drawable mRK;
    C8452a mRL = new C8452a(new C32141());

    /* renamed from: com.tencent.mm.plugin.gallery.ui.f$1 */
    class C32141 extends C8457a {
        int cPK = -1;

        /* renamed from: com.tencent.mm.plugin.gallery.ui.f$1$2 */
        class C32162 implements AnimationListener {
            C32162() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(21571);
                C20902a.swap(C39180f.this.mRE, C39180f.this.mRG, C39180f.this.mRH);
                if (C39180f.this.mRF != null) {
                    if (C32141.this.cPK > C39180f.this.mRG && C32141.this.cPK <= C39180f.this.mRH) {
                        C39180f.this.mRF.mo7520X(C39180f.this.mRG, C39180f.this.mRH, C32141.this.cPK - 1);
                        AppMethodBeat.m2505o(21571);
                        return;
                    } else if (C32141.this.cPK < C39180f.this.mRG && C32141.this.cPK >= C39180f.this.mRH) {
                        C39180f.this.mRF.mo7520X(C39180f.this.mRG, C39180f.this.mRH, C32141.this.cPK + 1);
                        AppMethodBeat.m2505o(21571);
                        return;
                    } else if (C39180f.this.mRG == C32141.this.cPK) {
                        C39180f.this.mRF.mo7520X(C39180f.this.mRG, C39180f.this.mRH, C39180f.this.mRH);
                        AppMethodBeat.m2505o(21571);
                        return;
                    } else {
                        C39180f.this.mRF.mo7520X(C39180f.this.mRG, C39180f.this.mRH, C32141.this.cPK);
                    }
                }
                AppMethodBeat.m2505o(21571);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        }

        C32141() {
        }

        /* renamed from: a */
        public final boolean mo7526a(C41531v c41531v, C41531v c41531v2) {
            AppMethodBeat.m2504i(21572);
            int kj = c41531v.mo66454kj();
            int kj2 = c41531v2.mo66454kj();
            C39180f.this.mo66309as(kj, kj2);
            if (C39180f.this.mRF != null) {
                C39180f.this.mRF.mo7521ek(kj, kj2);
            }
            C39180f.this.mRH = kj2;
            AppMethodBeat.m2505o(21572);
            return false;
        }

        /* renamed from: f */
        public final void mo7527f(final C41531v c41531v, final int i) {
            AppMethodBeat.m2504i(21573);
            super.mo7527f(c41531v, i);
            if (c41531v != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(C39180f.this.mContext, C25738R.anim.f8350br);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(21570);
                        if (i == 2) {
                            C39180f.this.mRG = C39180f.this.mRH = c41531v.mo66454kj();
                            C32141.this.cPK = C39180f.this.mRJ;
                            C4990ab.m7417i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", Integer.valueOf(C32141.this.cPK));
                        }
                        AppMethodBeat.m2505o(21570);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((C34255a) c41531v).mRR.startAnimation(loadAnimation);
            }
            AppMethodBeat.m2505o(21573);
        }

        /* renamed from: a */
        public final void mo7525a(RecyclerView recyclerView, C41531v c41531v) {
            AppMethodBeat.m2504i(21574);
            if (c41531v != null) {
                super.mo7525a(recyclerView, c41531v);
                Animation loadAnimation = AnimationUtils.loadAnimation(C39180f.this.mContext, C25738R.anim.f8349bq);
                loadAnimation.setAnimationListener(new C32162());
                ((C34255a) c41531v).mRR.startAnimation(loadAnimation);
            }
            AppMethodBeat.m2505o(21574);
        }

        /* renamed from: lC */
        public final float mo7529lC() {
            return 0.295858f;
        }

        /* renamed from: a */
        public final void mo7524a(Canvas canvas, RecyclerView recyclerView, C41531v c41531v, float f, float f2, int i, boolean z) {
            AppMethodBeat.m2504i(21575);
            super.mo7524a(canvas, recyclerView, c41531v, f / 1.3f, f2 / 1.3f, i, z);
            AppMethodBeat.m2505o(21575);
        }

        /* renamed from: lB */
        public final boolean mo7528lB() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.f$a */
    public static class C34255a extends C41531v {
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

        public C34255a(View view) {
            super(view);
            AppMethodBeat.m2504i(21577);
            this.mRR = view;
            this.mPc = (ImageView) view.findViewById(2131826566);
            this.mPd = (ImageView) view.findViewById(2131826567);
            this.mRQ = (ImageView) view.findViewById(2131822521);
            this.mOW = (ImageView) view.findViewById(2131826569);
            this.mOX = (ImageView) view.findViewById(2131822355);
            this.mOY = (RelativeLayout) view.findViewById(2131825005);
            this.mOZ = (TextView) view.findViewById(2131826565);
            this.mPb = (ImageView) view.findViewById(2131826568);
            this.mPb.setBackgroundResource(C25738R.color.f12084rr);
            this.mPb.setVisibility(8);
            AppMethodBeat.m2505o(21577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.f$b */
    public interface C34256b {
        /* renamed from: X */
        void mo7520X(int i, int i2, int i3);

        /* renamed from: ek */
        void mo7521ek(int i, int i2);

        /* renamed from: wC */
        void mo7522wC(int i);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27742a(C41531v c41531v, int i, List list) {
        AppMethodBeat.m2504i(21587);
        C34255a c34255a = (C34255a) c41531v;
        if (list.isEmpty()) {
            m66760a(c34255a, i);
            AppMethodBeat.m2505o(21587);
            return;
        }
        MediaItem a = m66758a(i, c34255a);
        if (a == null) {
            AppMethodBeat.m2505o(21587);
            return;
        }
        m66764c(c34255a.mOW, a.fPT, i);
        AppMethodBeat.m2505o(21587);
    }

    /* renamed from: el */
    public final void mo62083el(int i, int i2) {
        this.mRJ = i;
        this.mRI = i2;
    }

    public C39180f(Context context, ArrayList<String> arrayList, int i, boolean z) {
        AppMethodBeat.m2504i(21578);
        this.mContext = context;
        this.mQW = arrayList;
        this.mRE.addAll(arrayList);
        this.mRD = i;
        this.mQm = z;
        this.mRK = context.getResources().getDrawable(C25738R.drawable.f6664lp);
        AppMethodBeat.m2505o(21578);
    }

    public final void addItem(String str) {
        AppMethodBeat.m2504i(21579);
        this.mRE.add(str);
        AppMethodBeat.m2505o(21579);
    }

    public final int indexOf(String str) {
        AppMethodBeat.m2504i(21580);
        int indexOf = this.mRE.indexOf(str);
        AppMethodBeat.m2505o(21580);
        return indexOf;
    }

    public final void remove(int i) {
        AppMethodBeat.m2504i(21581);
        this.mRE.remove(i);
        AppMethodBeat.m2505o(21581);
    }

    /* renamed from: a */
    private void m66760a(final C34255a c34255a, int i) {
        AppMethodBeat.m2504i(21582);
        MediaItem a = m66758a(i, c34255a);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
            AppMethodBeat.m2505o(21582);
            return;
        }
        LayoutParams layoutParams = c34255a.mRR.getLayoutParams();
        int i2 = this.mRD;
        layoutParams.width = i2;
        layoutParams.height = i2;
        m66764c(c34255a.mOW, a.fPT, i);
        c34255a.mRR.setOnClickListener(this);
        if (this.mQm) {
            c34255a.mRR.setTag(Integer.valueOf(c34255a.mRS));
        } else {
            c34255a.mRR.setTag(a.fPT);
        }
        if (a.getType() == 2) {
            c34255a.mOY.setVisibility(0);
            int round = Math.round(((float) ((long) ((VideoMediaItem) a).fPW)) / 1000.0f);
            c34255a.mOZ.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        } else {
            c34255a.mOY.setVisibility(8);
        }
        String Wy = a.mo7504Wy();
        String str = a.fPT;
        if (C5046bo.isNullOrNil(Wy) && C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(21582);
            return;
        }
        C20921h.m32169a(c34255a.mOX, a.getType(), Wy, str, a.mOk, this.mRD, new C12100a() {
            public final void bCx() {
                AppMethodBeat.m2504i(21576);
                C4990ab.m7417i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", Integer.valueOf(c34255a.mOX.getWidth()), Integer.valueOf(c34255a.mOX.getHeight()));
                AppMethodBeat.m2505o(21576);
            }
        });
        if ((C34237e.bBZ().hOZ == 3 || C34237e.bBZ().hOZ == 11) && a != null && a.mMimeType.equalsIgnoreCase("image/gif")) {
            c34255a.mPc.setVisibility(0);
        } else {
            c34255a.mPc.setVisibility(8);
        }
        if (a.mMimeType.equalsIgnoreCase("edit")) {
            c34255a.mPd.setVisibility(0);
        } else {
            c34255a.mPd.setVisibility(8);
        }
        c34255a.mRQ.setVisibility(8);
        AppMethodBeat.m2505o(21582);
    }

    /* renamed from: c */
    private void m66764c(ImageView imageView, String str, int i) {
        int i2;
        AppMethodBeat.m2504i(21583);
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
        if (!C5046bo.isNullOrNil(this.mRC.getItem(this.mRI)) && this.mRC.getItem(this.mRI).equals(str)) {
            imageView.setVisibility(0);
            if (i2 != 0 && i == this.mRJ) {
                imageView.setImageDrawable(this.mRK);
                AppMethodBeat.m2505o(21583);
                return;
            }
        } else if (!(C5046bo.isNullOrNil(this.mRC.getItem(this.mRI)) || this.mRC.getItem(this.mRI).equals(str))) {
            if (i != this.mRJ && i2 == 0) {
                imageView.setVisibility(8);
                AppMethodBeat.m2505o(21583);
                return;
            } else if (i == this.mRJ && i2 == 0) {
                imageView.setImageDrawable(this.mRK);
            }
        }
        AppMethodBeat.m2505o(21583);
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(21584);
        int size = this.mRE.size();
        AppMethodBeat.m2505o(21584);
        return size;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(21585);
        if (this.mRF != null) {
            if (this.mQm) {
                this.mRF.mo7522wC(((Integer) view.getTag()).intValue());
                AppMethodBeat.m2505o(21585);
                return;
            }
            this.mRF.mo7522wC(this.mRE.indexOf(view.getTag()));
        }
        AppMethodBeat.m2505o(21585);
    }

    /* renamed from: a */
    private MediaItem m66758a(int i, C34255a c34255a) {
        AppMethodBeat.m2504i(21586);
        if (i < 0 || i >= this.mRE.size()) {
            C4990ab.m7421w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mRE.size()));
            AppMethodBeat.m2505o(21586);
            return null;
        }
        MediaItem mediaItem;
        String str = (String) this.mRE.get(i);
        MediaItem a;
        int indexOf;
        Iterator it;
        if (this.mQm) {
            if (this.mRC.mOH != null) {
                a = MediaItem.m5515a(0, 0, str, str, "");
                indexOf = this.mRC.mOH.indexOf(a);
                if (indexOf >= 0) {
                    c34255a.mRS = indexOf;
                    mediaItem = (MediaItem) this.mRC.mOH.get(indexOf);
                } else {
                    it = C34237e.bCe().iterator();
                    while (it.hasNext()) {
                        mediaItem = (MediaItem) it.next();
                        if (mediaItem.equals(a)) {
                            C4990ab.m7417i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", mediaItem.fPT);
                            break;
                        }
                    }
                    mediaItem = null;
                }
            } else {
                mediaItem = null;
            }
        } else if (C34237e.bCb() != null) {
            a = MediaItem.m5515a(0, 0, str, str, "");
            indexOf = C34237e.bCb().indexOf(a);
            if (indexOf >= 0) {
                mediaItem = (MediaItem) C34237e.bCb().get(indexOf);
            } else {
                it = C34237e.bCe().iterator();
                while (it.hasNext()) {
                    mediaItem = (MediaItem) it.next();
                    if (mediaItem.equals(a)) {
                        C4990ab.m7417i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", mediaItem.fPT);
                        break;
                    }
                }
                mediaItem = null;
            }
        } else {
            mediaItem = MediaItem.m5515a(1, 0, str, str, "");
        }
        AppMethodBeat.m2505o(21586);
        return mediaItem;
    }
}

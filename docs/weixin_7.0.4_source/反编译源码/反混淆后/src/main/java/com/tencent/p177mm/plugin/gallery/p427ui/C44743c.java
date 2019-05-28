package com.tencent.p177mm.plugin.gallery.p427ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C44277u;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.base.WxImageView;
import com.tencent.p177mm.p612ui.p627e.p1346b.C44371a;
import com.tencent.p177mm.plugin.gallery.model.C20911m;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.gallery.ui.c */
public final class C44743c extends C44277u {
    private Bitmap cdX = null;
    Context mContext;
    ArrayList<MediaItem> mOH = new ArrayList();
    ArrayList<String> mQl = new ArrayList();
    boolean mQm;
    private HashSet<String> mQn = new HashSet();
    int mQo = -1;
    View mQp = null;
    boolean mQq = false;
    private HashMap<String, WeakReference<C20920b>> mQr = new HashMap();
    public C43150e mQs = new C43150e(this);
    public C43148d mQt = new C43148d(this);

    /* renamed from: com.tencent.mm.plugin.gallery.ui.c$a */
    class C20919a implements OnClickListener {
        private String filePath;

        public C20919a(String str) {
            this.filePath = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21458);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            C15429k.m23713a(C44743c.this.mContext, intent, new File(this.filePath), "video/*");
            try {
                C44743c.this.mContext.startActivity(intent);
                AppMethodBeat.m2505o(21458);
            } catch (Exception e) {
                AppMethodBeat.m2505o(21458);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.c$b */
    static class C20920b {
        boolean mQv = false;
        MultiTouchImageView mQw;
        TextView mQx;
        TextView mQy;
        ImageView moY;

        C20920b() {
        }
    }

    public C44743c(Context context) {
        AppMethodBeat.m2504i(21459);
        this.mContext = context;
        AppMethodBeat.m2505o(21459);
    }

    /* renamed from: E */
    public final void mo71813E(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(21460);
        this.mQl.clear();
        this.mQl = new ArrayList();
        this.mQl.addAll(arrayList);
        reset();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(21460);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(21461);
        Object instantiateItem;
        if (this.mQm) {
            instantiateItem = super.instantiateItem(viewGroup, i);
            AppMethodBeat.m2505o(21461);
            return instantiateItem;
        }
        C4990ab.m7417i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", Integer.valueOf(i), Integer.valueOf(this.mQo));
        if (i == this.mQo && this.mQq) {
            C4990ab.m7410d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
            this.yyK.put(this.mQp, Integer.valueOf(this.mQo));
            this.yyL.put(this.mQo, this.mQp);
            this.mQo = -1;
            this.mQq = false;
            View view = this.mQp;
            AppMethodBeat.m2505o(21461);
            return view;
        }
        instantiateItem = super.instantiateItem(viewGroup, i);
        AppMethodBeat.m2505o(21461);
        return instantiateItem;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        AppMethodBeat.m2504i(21462);
        if (this.mQm) {
            super.destroyItem(viewGroup, i, obj);
            AppMethodBeat.m2505o(21462);
        } else if (obj == null) {
            C4990ab.m7413e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", Integer.valueOf(i));
            AppMethodBeat.m2505o(21462);
        } else {
            if (this.mQp != null) {
                C4990ab.m7417i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", Integer.valueOf(i), Integer.valueOf(obj.hashCode()), Integer.valueOf(this.mQp.hashCode()));
            }
            if (obj == this.mQp && this.mQq) {
                C4990ab.m7410d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
                AppMethodBeat.m2505o(21462);
                return;
            }
            super.destroyItem(viewGroup, i, obj);
            viewGroup.removeView((View) obj);
            AppMethodBeat.m2505o(21462);
        }
    }

    public final int getCount() {
        AppMethodBeat.m2504i(21463);
        int size;
        if (this.mQm) {
            size = this.mOH.size();
            AppMethodBeat.m2505o(21463);
            return size;
        }
        size = this.mQl.size();
        AppMethodBeat.m2505o(21463);
        return size;
    }

    /* renamed from: wx */
    public final MultiTouchImageView mo64332wx(int i) {
        AppMethodBeat.m2504i(21464);
        View Fp = super.mo70155Fp(i);
        if (Fp == null) {
            C4990ab.m7413e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(21464);
            return null;
        } else if (Fp == null || Fp.getVisibility() == 8) {
            AppMethodBeat.m2505o(21464);
            return null;
        } else {
            Fp = Fp.findViewById(2131820629);
            if (Fp == null) {
                AppMethodBeat.m2505o(21464);
                return null;
            }
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) Fp;
            AppMethodBeat.m2505o(21464);
            return multiTouchImageView;
        }
    }

    /* renamed from: wy */
    public final WxImageView mo64333wy(int i) {
        return null;
    }

    public final String getItem(int i) {
        AppMethodBeat.m2504i(21465);
        String str;
        if (this.mQm) {
            if (i < 0 || i >= this.mOH.size()) {
                C4990ab.m7421w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", Integer.valueOf(i), Integer.valueOf(this.mOH.size()));
                str = "";
                AppMethodBeat.m2505o(21465);
                return str;
            }
            str = ((MediaItem) this.mOH.get(i)).fPT;
            AppMethodBeat.m2505o(21465);
            return str;
        } else if (i < 0 || i >= this.mQl.size()) {
            C4990ab.m7421w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mQl.size()));
            str = "";
            AppMethodBeat.m2505o(21465);
            return str;
        } else {
            str = (String) this.mQl.get(i);
            AppMethodBeat.m2505o(21465);
            return str;
        }
    }

    /* renamed from: wz */
    public final MediaItem mo71817wz(int i) {
        MediaItem mediaItem = null;
        AppMethodBeat.m2504i(21466);
        if (this.mQm) {
            if (i < 0 || i >= this.mOH.size()) {
                C4990ab.m7421w("MicroMsg.ImageAdapter", "error position %d mediaitems size", Integer.valueOf(i), Integer.valueOf(this.mOH.size()));
                AppMethodBeat.m2505o(21466);
                return null;
            }
            mediaItem = (MediaItem) this.mOH.get(i);
            AppMethodBeat.m2505o(21466);
            return mediaItem;
        } else if (i < 0 || i >= this.mQl.size()) {
            C4990ab.m7421w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mQl.size()));
            AppMethodBeat.m2505o(21466);
            return null;
        } else {
            String str = (String) this.mQl.get(i);
            if (C34237e.bCb() != null) {
                int indexOf = C34237e.bCb().indexOf(MediaItem.m5515a(0, 0, str, str, ""));
                if (indexOf >= 0) {
                    mediaItem = (MediaItem) C34237e.bCb().get(indexOf);
                }
            }
            AppMethodBeat.m2505o(21466);
            return mediaItem;
        }
    }

    /* renamed from: a */
    public final void mo71814a(MultiTouchImageView multiTouchImageView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(21467);
        this.mQn.remove(str);
        if (multiTouchImageView != null) {
            C20920b c20920b = (C20920b) multiTouchImageView.getTag();
            if (bitmap != null) {
                C44743c.m81542a(multiTouchImageView, bitmap);
                if (!(c20920b == null || !c20920b.mQv || c20920b.mQy == null)) {
                    c20920b.mQy.setVisibility(8);
                    AppMethodBeat.m2505o(21467);
                    return;
                }
            } else if (!(c20920b == null || !c20920b.mQv || c20920b.mQy == null)) {
                c20920b.mQy.setText(str);
                c20920b.mQy.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(21467);
    }

    @TargetApi(11)
    /* renamed from: a */
    private static void m81542a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        AppMethodBeat.m2504i(21468);
        multiTouchImageView.setMaxZoomLimit(4.5f);
        multiTouchImageView.setEnableHorLongBmpMode(false);
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            C46616n.m88171w(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.mo71980bW(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.requestLayout();
        AppMethodBeat.m2505o(21468);
    }

    public final void release() {
        AppMethodBeat.m2504i(21469);
        detach();
        this.mQr.clear();
        this.mQn.clear();
        AppMethodBeat.m2505o(21469);
    }

    public final void detach() {
        AppMethodBeat.m2504i(21470);
        super.detach();
        this.mQt.detach();
        AppMethodBeat.m2505o(21470);
    }

    /* renamed from: c */
    public final /* synthetic */ Object mo64318c(int i, View view) {
        Object view2;
        C20920b c20920b;
        String str;
        String str2;
        MediaItem mediaItem;
        AppMethodBeat.m2504i(21471);
        long yz = C5046bo.m7588yz();
        if (view2 == null) {
            view2 = View.inflate(this.mContext, 2130969857, null);
            C20920b c20920b2 = new C20920b();
            c20920b2.mQw = (MultiTouchImageView) view2.findViewById(2131820629);
            c20920b2.moY = (ImageView) view2.findViewById(2131825005);
            c20920b2.mQx = (TextView) view2.findViewById(2131825006);
            c20920b2.mQy = (TextView) view2.findViewById(2131825007);
            view2.setTag(c20920b2);
            c20920b = c20920b2;
        } else {
            c20920b = (C20920b) view2.getTag();
        }
        String str3;
        if (this.mQm) {
            MediaItem mediaItem2 = (MediaItem) this.mOH.get(i);
            str3 = mediaItem2.fPT;
            str = mediaItem2.lZg;
            str2 = str3;
            mediaItem = mediaItem2;
        } else {
            str3 = (String) this.mQl.get(i);
            if (C34237e.bCb() != null) {
                int indexOf = C34237e.bCb().indexOf(MediaItem.m5515a(0, 0, str3, str3, ""));
                if (indexOf >= 0) {
                    str2 = str3;
                    mediaItem = (MediaItem) C34237e.bCb().get(indexOf);
                    str = null;
                }
            }
            str2 = str3;
            mediaItem = null;
            str = null;
        }
        if (mediaItem == null || mediaItem.getType() != 2) {
            if (C34237e.bBZ().hOZ == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                c20920b.mQx.setText(this.mContext.getString(C25738R.string.c37, new Object[]{C5046bo.m7565ga(new File(str2).length())}));
                c20920b.mQx.setVisibility(0);
                c20920b.mQv = false;
            } else {
                c20920b.mQx.setVisibility(8);
                c20920b.mQv = true;
            }
            c20920b.moY.setVisibility(8);
            c20920b.moY.setOnClickListener(null);
            c20920b.mQy.setVisibility(8);
        } else {
            c20920b.mQx.setVisibility(8);
            c20920b.mQv = false;
            c20920b.moY.setVisibility(0);
            c20920b.mQy.setVisibility(8);
            c20920b.moY.setOnClickListener(new C20919a(str2));
            if (C34237e.bBZ().hOZ == 4 || C34237e.bBZ().hOZ == 14) {
                C20911m c20911m = new C20911m(mediaItem.fPT, i, (VideoMediaItem) mediaItem, null);
                if (C7305d.xDG.mo10150ao(c20911m)) {
                    C4990ab.m7411d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", Integer.valueOf(16842794));
                } else {
                    C7305d.post(c20911m, "video_analysis");
                }
            }
        }
        MultiTouchImageView multiTouchImageView;
        if (C34237e.bBZ().hOZ != 3 || (!(mediaItem == null && C5063r.amo(str2)) && (mediaItem == null || !mediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            Bitmap bitmap;
            C34237e.bCa().bCp();
            if (this.mQt.mQK.mo4405aj(str2)) {
                bitmap = (Bitmap) this.mQt.mQK.mo4404ai(str2);
                if (!bitmap.isRecycled()) {
                    C44743c.m81542a(c20920b.mQw, bitmap);
                }
            }
            bitmap = C34237e.bBY().mo68657Nz(C5046bo.isNullOrNil(str) ? str2 : str);
            if (bitmap == null) {
                MultiTouchImageView multiTouchImageView2 = c20920b.mQw;
                if (this.cdX == null || this.cdX.isRecycled()) {
                    this.cdX = BitmapFactory.decodeResource(this.mContext.getResources(), C25738R.drawable.beo);
                }
                C44743c.m81542a(multiTouchImageView2, this.cdX);
            } else {
                C44743c.m81542a(c20920b.mQw, bitmap);
            }
            if (!this.mQn.contains(str2)) {
                this.mQn.add(str2);
                c20920b.mQw.setTag(c20920b);
                C43148d c43148d = this.mQt;
                multiTouchImageView = c20920b.mQw;
                if (!c43148d.mQM.contains(str2)) {
                    int hashCode = multiTouchImageView.hashCode();
                    c43148d.mo68671wA(hashCode);
                    c43148d.mQH.put(str2, Integer.valueOf(hashCode));
                    c43148d.mQI.put(hashCode, str2);
                    c43148d.mQG.put(hashCode, new WeakReference(multiTouchImageView));
                    c43148d.mQM.add(str2);
                    c43148d.mo68667Dp();
                }
            }
        } else {
            c20920b.mQw.setGifPath(str2);
            multiTouchImageView = c20920b.mQw;
            if (multiTouchImageView.yzp && multiTouchImageView.yzq != null) {
                ((C44371a) multiTouchImageView.yzq).stop();
                ((C44371a) multiTouchImageView.yzq).start();
            }
            c20920b.mQw.setMaxZoomLimit(1.0f);
            c20920b.mQw.setEnableHorLongBmpMode(false);
            if (VERSION.SDK_INT == 20) {
                c20920b.mQw.setLayerType(1, null);
            } else {
                C46616n.m88171w(c20920b.mQw, c20920b.mQw.getWidth(), c20920b.mQw.getHeight());
            }
            c20920b.mQw.requestLayout();
            c20920b.mQw.dAp();
        }
        C4990ab.m7419v("MicroMsg.ImageAdapter", "test getview: %d position:%d", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i));
        AppMethodBeat.m2505o(21471);
        return view2;
    }
}

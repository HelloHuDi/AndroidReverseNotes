package com.tencent.mm.plugin.gallery.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c extends u {
    private Bitmap cdX = null;
    Context mContext;
    ArrayList<MediaItem> mOH = new ArrayList();
    ArrayList<String> mQl = new ArrayList();
    boolean mQm;
    private HashSet<String> mQn = new HashSet();
    int mQo = -1;
    View mQp = null;
    boolean mQq = false;
    private HashMap<String, WeakReference<b>> mQr = new HashMap();
    public e mQs = new e(this);
    public d mQt = new d(this);

    class a implements OnClickListener {
        private String filePath;

        public a(String str) {
            this.filePath = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(21458);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            k.a(c.this.mContext, intent, new File(this.filePath), "video/*");
            try {
                c.this.mContext.startActivity(intent);
                AppMethodBeat.o(21458);
            } catch (Exception e) {
                AppMethodBeat.o(21458);
            }
        }
    }

    static class b {
        boolean mQv = false;
        MultiTouchImageView mQw;
        TextView mQx;
        TextView mQy;
        ImageView moY;

        b() {
        }
    }

    public c(Context context) {
        AppMethodBeat.i(21459);
        this.mContext = context;
        AppMethodBeat.o(21459);
    }

    public final void E(ArrayList<String> arrayList) {
        AppMethodBeat.i(21460);
        this.mQl.clear();
        this.mQl = new ArrayList();
        this.mQl.addAll(arrayList);
        reset();
        notifyDataSetChanged();
        AppMethodBeat.o(21460);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(21461);
        Object instantiateItem;
        if (this.mQm) {
            instantiateItem = super.instantiateItem(viewGroup, i);
            AppMethodBeat.o(21461);
            return instantiateItem;
        }
        ab.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", Integer.valueOf(i), Integer.valueOf(this.mQo));
        if (i == this.mQo && this.mQq) {
            ab.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
            this.yyK.put(this.mQp, Integer.valueOf(this.mQo));
            this.yyL.put(this.mQo, this.mQp);
            this.mQo = -1;
            this.mQq = false;
            View view = this.mQp;
            AppMethodBeat.o(21461);
            return view;
        }
        instantiateItem = super.instantiateItem(viewGroup, i);
        AppMethodBeat.o(21461);
        return instantiateItem;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        AppMethodBeat.i(21462);
        if (this.mQm) {
            super.destroyItem(viewGroup, i, obj);
            AppMethodBeat.o(21462);
        } else if (obj == null) {
            ab.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", Integer.valueOf(i));
            AppMethodBeat.o(21462);
        } else {
            if (this.mQp != null) {
                ab.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", Integer.valueOf(i), Integer.valueOf(obj.hashCode()), Integer.valueOf(this.mQp.hashCode()));
            }
            if (obj == this.mQp && this.mQq) {
                ab.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
                AppMethodBeat.o(21462);
                return;
            }
            super.destroyItem(viewGroup, i, obj);
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(21462);
        }
    }

    public final int getCount() {
        AppMethodBeat.i(21463);
        int size;
        if (this.mQm) {
            size = this.mOH.size();
            AppMethodBeat.o(21463);
            return size;
        }
        size = this.mQl.size();
        AppMethodBeat.o(21463);
        return size;
    }

    public final MultiTouchImageView wx(int i) {
        AppMethodBeat.i(21464);
        View Fp = super.Fp(i);
        if (Fp == null) {
            ab.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i));
            AppMethodBeat.o(21464);
            return null;
        } else if (Fp == null || Fp.getVisibility() == 8) {
            AppMethodBeat.o(21464);
            return null;
        } else {
            Fp = Fp.findViewById(R.id.bl);
            if (Fp == null) {
                AppMethodBeat.o(21464);
                return null;
            }
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) Fp;
            AppMethodBeat.o(21464);
            return multiTouchImageView;
        }
    }

    public final WxImageView wy(int i) {
        return null;
    }

    public final String getItem(int i) {
        AppMethodBeat.i(21465);
        String str;
        if (this.mQm) {
            if (i < 0 || i >= this.mOH.size()) {
                ab.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", Integer.valueOf(i), Integer.valueOf(this.mOH.size()));
                str = "";
                AppMethodBeat.o(21465);
                return str;
            }
            str = ((MediaItem) this.mOH.get(i)).fPT;
            AppMethodBeat.o(21465);
            return str;
        } else if (i < 0 || i >= this.mQl.size()) {
            ab.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mQl.size()));
            str = "";
            AppMethodBeat.o(21465);
            return str;
        } else {
            str = (String) this.mQl.get(i);
            AppMethodBeat.o(21465);
            return str;
        }
    }

    public final MediaItem wz(int i) {
        MediaItem mediaItem = null;
        AppMethodBeat.i(21466);
        if (this.mQm) {
            if (i < 0 || i >= this.mOH.size()) {
                ab.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", Integer.valueOf(i), Integer.valueOf(this.mOH.size()));
                AppMethodBeat.o(21466);
                return null;
            }
            mediaItem = (MediaItem) this.mOH.get(i);
            AppMethodBeat.o(21466);
            return mediaItem;
        } else if (i < 0 || i >= this.mQl.size()) {
            ab.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mQl.size()));
            AppMethodBeat.o(21466);
            return null;
        } else {
            String str = (String) this.mQl.get(i);
            if (e.bCb() != null) {
                int indexOf = e.bCb().indexOf(MediaItem.a(0, 0, str, str, ""));
                if (indexOf >= 0) {
                    mediaItem = (MediaItem) e.bCb().get(indexOf);
                }
            }
            AppMethodBeat.o(21466);
            return mediaItem;
        }
    }

    public final void a(MultiTouchImageView multiTouchImageView, String str, Bitmap bitmap) {
        AppMethodBeat.i(21467);
        this.mQn.remove(str);
        if (multiTouchImageView != null) {
            b bVar = (b) multiTouchImageView.getTag();
            if (bitmap != null) {
                a(multiTouchImageView, bitmap);
                if (!(bVar == null || !bVar.mQv || bVar.mQy == null)) {
                    bVar.mQy.setVisibility(8);
                    AppMethodBeat.o(21467);
                    return;
                }
            } else if (!(bVar == null || !bVar.mQv || bVar.mQy == null)) {
                bVar.mQy.setText(str);
                bVar.mQy.setVisibility(0);
            }
        }
        AppMethodBeat.o(21467);
    }

    @TargetApi(11)
    private static void a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        AppMethodBeat.i(21468);
        multiTouchImageView.setMaxZoomLimit(4.5f);
        multiTouchImageView.setEnableHorLongBmpMode(false);
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            n.w(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.bW(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.requestLayout();
        AppMethodBeat.o(21468);
    }

    public final void release() {
        AppMethodBeat.i(21469);
        detach();
        this.mQr.clear();
        this.mQn.clear();
        AppMethodBeat.o(21469);
    }

    public final void detach() {
        AppMethodBeat.i(21470);
        super.detach();
        this.mQt.detach();
        AppMethodBeat.o(21470);
    }

    public final /* synthetic */ Object c(int i, View view) {
        Object view2;
        b bVar;
        String str;
        String str2;
        MediaItem mediaItem;
        AppMethodBeat.i(21471);
        long yz = bo.yz();
        if (view2 == null) {
            view2 = View.inflate(this.mContext, R.layout.a7t, null);
            b bVar2 = new b();
            bVar2.mQw = (MultiTouchImageView) view2.findViewById(R.id.bl);
            bVar2.moY = (ImageView) view2.findViewById(R.id.cik);
            bVar2.mQx = (TextView) view2.findViewById(R.id.cil);
            bVar2.mQy = (TextView) view2.findViewById(R.id.cim);
            view2.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view2.getTag();
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
            if (e.bCb() != null) {
                int indexOf = e.bCb().indexOf(MediaItem.a(0, 0, str3, str3, ""));
                if (indexOf >= 0) {
                    str2 = str3;
                    mediaItem = (MediaItem) e.bCb().get(indexOf);
                    str = null;
                }
            }
            str2 = str3;
            mediaItem = null;
            str = null;
        }
        if (mediaItem == null || mediaItem.getType() != 2) {
            if (e.bBZ().hOZ == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                bVar.mQx.setText(this.mContext.getString(R.string.c37, new Object[]{bo.ga(new File(str2).length())}));
                bVar.mQx.setVisibility(0);
                bVar.mQv = false;
            } else {
                bVar.mQx.setVisibility(8);
                bVar.mQv = true;
            }
            bVar.moY.setVisibility(8);
            bVar.moY.setOnClickListener(null);
            bVar.mQy.setVisibility(8);
        } else {
            bVar.mQx.setVisibility(8);
            bVar.mQv = false;
            bVar.moY.setVisibility(0);
            bVar.mQy.setVisibility(8);
            bVar.moY.setOnClickListener(new a(str2));
            if (e.bBZ().hOZ == 4 || e.bBZ().hOZ == 14) {
                m mVar = new m(mediaItem.fPT, i, (VideoMediaItem) mediaItem, null);
                if (d.xDG.ao(mVar)) {
                    ab.d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", Integer.valueOf(16842794));
                } else {
                    d.post(mVar, "video_analysis");
                }
            }
        }
        MultiTouchImageView multiTouchImageView;
        if (e.bBZ().hOZ != 3 || (!(mediaItem == null && r.amo(str2)) && (mediaItem == null || !mediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            Bitmap bitmap;
            e.bCa().bCp();
            if (this.mQt.mQK.aj(str2)) {
                bitmap = (Bitmap) this.mQt.mQK.ai(str2);
                if (!bitmap.isRecycled()) {
                    a(bVar.mQw, bitmap);
                }
            }
            bitmap = e.bBY().Nz(bo.isNullOrNil(str) ? str2 : str);
            if (bitmap == null) {
                MultiTouchImageView multiTouchImageView2 = bVar.mQw;
                if (this.cdX == null || this.cdX.isRecycled()) {
                    this.cdX = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.beo);
                }
                a(multiTouchImageView2, this.cdX);
            } else {
                a(bVar.mQw, bitmap);
            }
            if (!this.mQn.contains(str2)) {
                this.mQn.add(str2);
                bVar.mQw.setTag(bVar);
                d dVar = this.mQt;
                multiTouchImageView = bVar.mQw;
                if (!dVar.mQM.contains(str2)) {
                    int hashCode = multiTouchImageView.hashCode();
                    dVar.wA(hashCode);
                    dVar.mQH.put(str2, Integer.valueOf(hashCode));
                    dVar.mQI.put(hashCode, str2);
                    dVar.mQG.put(hashCode, new WeakReference(multiTouchImageView));
                    dVar.mQM.add(str2);
                    dVar.Dp();
                }
            }
        } else {
            bVar.mQw.setGifPath(str2);
            multiTouchImageView = bVar.mQw;
            if (multiTouchImageView.yzp && multiTouchImageView.yzq != null) {
                ((com.tencent.mm.ui.e.b.a) multiTouchImageView.yzq).stop();
                ((com.tencent.mm.ui.e.b.a) multiTouchImageView.yzq).start();
            }
            bVar.mQw.setMaxZoomLimit(1.0f);
            bVar.mQw.setEnableHorLongBmpMode(false);
            if (VERSION.SDK_INT == 20) {
                bVar.mQw.setLayerType(1, null);
            } else {
                n.w(bVar.mQw, bVar.mQw.getWidth(), bVar.mQw.getHeight());
            }
            bVar.mQw.requestLayout();
            bVar.mQw.dAp();
        }
        ab.v("MicroMsg.ImageAdapter", "test getview: %d position:%d", Long.valueOf(bo.az(yz)), Integer.valueOf(i));
        AppMethodBeat.o(21471);
        return view2;
    }
}

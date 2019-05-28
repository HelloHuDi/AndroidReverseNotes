package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.ttpic.baseutils.FileUtils;

public class GetHdHeadImageGalleryView extends MMGestureGallery {
    private String qln;
    private String username;
    private o vht;
    private Bitmap vhu;
    private Bitmap vhv;
    private a vhw;

    class c implements f {
        private c() {
        }

        /* synthetic */ c(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final void bcX() {
            AppMethodBeat.i(79685);
            if (GetHdHeadImageGalleryView.this.vht != null) {
                GetHdHeadImageGalleryView.this.vht.dismiss();
            }
            AppMethodBeat.o(79685);
        }
    }

    class b implements com.tencent.mm.ui.tools.MMGestureGallery.c {
        private b() {
        }

        /* synthetic */ b(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final void bvE() {
            AppMethodBeat.i(79684);
            if (!(GetHdHeadImageGalleryView.this.qln == null || GetHdHeadImageGalleryView.this.username == null)) {
                h.a(GetHdHeadImageGalleryView.this.getContext(), null, GetHdHeadImageGalleryView.this.getContext().getResources().getStringArray(R.array.m), "", new com.tencent.mm.ui.base.h.c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(79683);
                        switch (i) {
                            case 0:
                                String str = e.euR + "hdImg_" + g.x(GetHdHeadImageGalleryView.this.username.getBytes()) + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
                                com.tencent.mm.vfs.e.deleteFile(str);
                                com.tencent.mm.vfs.e.y(GetHdHeadImageGalleryView.this.qln, str);
                                com.tencent.mm.sdk.f.a.a(str, GetHdHeadImageGalleryView.this.getContext());
                                Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(R.string.c9o, new Object[]{e.euR}), 1).show();
                                break;
                        }
                        AppMethodBeat.o(79683);
                    }
                });
            }
            AppMethodBeat.o(79684);
        }
    }

    class a extends BaseAdapter {

        class a {
            ImageView cDh;
            ProgressBar rte;
            View vhy;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(79681);
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.o(79681);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(79682);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(GetHdHeadImageGalleryView.this.getContext(), R.layout.b1p, null);
                aVar2.rte = (ProgressBar) view.findViewById(R.id.f1a);
                aVar2.cDh = (ImageView) view.findViewById(R.id.f19);
                aVar2.vhy = view.findViewById(R.id.f1_);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            if (GetHdHeadImageGalleryView.this.vhv != null) {
                aVar.rte.setVisibility(8);
                aVar.cDh.setVisibility(8);
                aVar.vhy.setVisibility(8);
                MultiTouchImageView multiTouchImageView = new MultiTouchImageView(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.vhv.getWidth(), GetHdHeadImageGalleryView.this.vhv.getHeight());
                multiTouchImageView.setLayoutParams(new LayoutParams(-1, -1));
                multiTouchImageView.setImageBitmap(GetHdHeadImageGalleryView.this.vhv);
                multiTouchImageView.setMaxZoomLimit(2.0f);
                multiTouchImageView.setMaxZoomDoubleTab(true);
                AppMethodBeat.o(79682);
                return multiTouchImageView;
            }
            aVar.rte.setVisibility(0);
            aVar.vhy.setVisibility(0);
            if (GetHdHeadImageGalleryView.this.vhu != null) {
                aVar.cDh.setVisibility(0);
                aVar.cDh.setImageBitmap(GetHdHeadImageGalleryView.this.vhu);
            } else {
                aVar.cDh.setVisibility(8);
            }
            AppMethodBeat.o(79682);
            return view;
        }
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(79686);
        init();
        AppMethodBeat.o(79686);
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(79687);
        init();
        AppMethodBeat.o(79687);
    }

    private void init() {
        AppMethodBeat.i(79688);
        this.vhw = new a(this, (byte) 0);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter(this.vhw);
        setSelection(0);
        setSingleClickOverListener(new c(this, (byte) 0));
        setLongClickOverListener(new b(this, (byte) 0));
        AppMethodBeat.o(79688);
    }

    public void setParentWindow(o oVar) {
        this.vht = oVar;
    }

    public void setHdHeadImagePath(String str) {
        this.qln = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setThumbImage(Bitmap bitmap) {
        AppMethodBeat.i(79689);
        this.vhu = bitmap;
        this.vhw.notifyDataSetChanged();
        AppMethodBeat.o(79689);
    }

    public void setHdHeadImage(Bitmap bitmap) {
        AppMethodBeat.i(79690);
        this.vhv = bitmap;
        this.vhw.notifyDataSetChanged();
        AppMethodBeat.o(79690);
    }
}

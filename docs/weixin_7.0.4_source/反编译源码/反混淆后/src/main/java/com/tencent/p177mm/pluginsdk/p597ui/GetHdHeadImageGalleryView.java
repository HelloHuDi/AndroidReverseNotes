package com.tencent.p177mm.pluginsdk.p597ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30744c;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;

/* renamed from: com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView */
public class GetHdHeadImageGalleryView extends MMGestureGallery {
    private String qln;
    private String username;
    private C46633o vht;
    private Bitmap vhu;
    private Bitmap vhv;
    private C35812a vhw;

    /* renamed from: com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView$c */
    class C30095c implements C30745f {
        private C30095c() {
        }

        /* synthetic */ C30095c(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final void bcX() {
            AppMethodBeat.m2504i(79685);
            if (GetHdHeadImageGalleryView.this.vht != null) {
                GetHdHeadImageGalleryView.this.vht.dismiss();
            }
            AppMethodBeat.m2505o(79685);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView$b */
    class C35810b implements C30744c {

        /* renamed from: com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView$b$1 */
        class C358111 implements C30391c {
            C358111() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(79683);
                switch (i) {
                    case 0:
                        String str = C6457e.euR + "hdImg_" + C1178g.m2591x(GetHdHeadImageGalleryView.this.username.getBytes()) + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
                        C5730e.deleteFile(str);
                        C5730e.m8644y(GetHdHeadImageGalleryView.this.qln, str);
                        C40612a.m70043a(str, GetHdHeadImageGalleryView.this.getContext());
                        Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(C25738R.string.c9o, new Object[]{C6457e.euR}), 1).show();
                        break;
                }
                AppMethodBeat.m2505o(79683);
            }
        }

        private C35810b() {
        }

        /* synthetic */ C35810b(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final void bvE() {
            AppMethodBeat.m2504i(79684);
            if (!(GetHdHeadImageGalleryView.this.qln == null || GetHdHeadImageGalleryView.this.username == null)) {
                C30379h.m48422a(GetHdHeadImageGalleryView.this.getContext(), null, GetHdHeadImageGalleryView.this.getContext().getResources().getStringArray(C25738R.array.f12613m), "", new C358111());
            }
            AppMethodBeat.m2505o(79684);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView$a */
    class C35812a extends BaseAdapter {

        /* renamed from: com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView$a$a */
        class C35813a {
            ImageView cDh;
            ProgressBar rte;
            View vhy;

            C35813a() {
            }
        }

        private C35812a() {
        }

        /* synthetic */ C35812a(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(79681);
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.m2505o(79681);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C35813a c35813a;
            AppMethodBeat.m2504i(79682);
            if (view == null) {
                C35813a c35813a2 = new C35813a();
                view = View.inflate(GetHdHeadImageGalleryView.this.getContext(), 2130971002, null);
                c35813a2.rte = (ProgressBar) view.findViewById(2131828435);
                c35813a2.cDh = (ImageView) view.findViewById(2131828433);
                c35813a2.vhy = view.findViewById(2131828434);
                view.setTag(c35813a2);
                c35813a = c35813a2;
            } else {
                c35813a = (C35813a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            if (GetHdHeadImageGalleryView.this.vhv != null) {
                c35813a.rte.setVisibility(8);
                c35813a.cDh.setVisibility(8);
                c35813a.vhy.setVisibility(8);
                MultiTouchImageView multiTouchImageView = new MultiTouchImageView(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.vhv.getWidth(), GetHdHeadImageGalleryView.this.vhv.getHeight());
                multiTouchImageView.setLayoutParams(new LayoutParams(-1, -1));
                multiTouchImageView.setImageBitmap(GetHdHeadImageGalleryView.this.vhv);
                multiTouchImageView.setMaxZoomLimit(2.0f);
                multiTouchImageView.setMaxZoomDoubleTab(true);
                AppMethodBeat.m2505o(79682);
                return multiTouchImageView;
            }
            c35813a.rte.setVisibility(0);
            c35813a.vhy.setVisibility(0);
            if (GetHdHeadImageGalleryView.this.vhu != null) {
                c35813a.cDh.setVisibility(0);
                c35813a.cDh.setImageBitmap(GetHdHeadImageGalleryView.this.vhu);
            } else {
                c35813a.cDh.setVisibility(8);
            }
            AppMethodBeat.m2505o(79682);
            return view;
        }
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(79686);
        init();
        AppMethodBeat.m2505o(79686);
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(79687);
        init();
        AppMethodBeat.m2505o(79687);
    }

    private void init() {
        AppMethodBeat.m2504i(79688);
        this.vhw = new C35812a(this, (byte) 0);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter(this.vhw);
        setSelection(0);
        setSingleClickOverListener(new C30095c(this, (byte) 0));
        setLongClickOverListener(new C35810b(this, (byte) 0));
        AppMethodBeat.m2505o(79688);
    }

    public void setParentWindow(C46633o c46633o) {
        this.vht = c46633o;
    }

    public void setHdHeadImagePath(String str) {
        this.qln = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setThumbImage(Bitmap bitmap) {
        AppMethodBeat.m2504i(79689);
        this.vhu = bitmap;
        this.vhw.notifyDataSetChanged();
        AppMethodBeat.m2505o(79689);
    }

    public void setHdHeadImage(Bitmap bitmap) {
        AppMethodBeat.m2504i(79690);
        this.vhv = bitmap;
        this.vhw.notifyDataSetChanged();
        AppMethodBeat.m2505o(79690);
    }
}

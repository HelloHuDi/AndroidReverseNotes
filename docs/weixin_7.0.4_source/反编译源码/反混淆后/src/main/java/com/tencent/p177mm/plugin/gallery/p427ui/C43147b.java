package com.tencent.p177mm.plugin.gallery.p427ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.ui.b */
public final class C43147b extends BaseAdapter {
    private Context mContext;
    private int mOu;
    LinkedList<AlbumItem> mQe;
    AlbumItem mQf;
    String mQg = "";
    private int mQh = 0;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.b$a */
    static class C43146a {
        public TextView gnC;
        public ImageView mOX;
        public TextView mQi;
        public ImageView mQj;
        public ImageView moY;

        private C43146a() {
        }

        /* synthetic */ C43146a(byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(21451);
        AlbumItem ww = mo68666ww(i);
        AppMethodBeat.m2505o(21451);
        return ww;
    }

    public C43147b(Context context, int i) {
        AppMethodBeat.m2504i(21447);
        this.mContext = context;
        this.mQe = new LinkedList();
        this.mOu = i;
        this.mQf = new AlbumItem("", 0);
        this.mQf.oqq = new ImageMediaItem();
        this.mQh = context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
        AppMethodBeat.m2505o(21447);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(21448);
        int size = this.mQe.size() + 1;
        AppMethodBeat.m2505o(21448);
        return size;
    }

    /* renamed from: ww */
    public final AlbumItem mo68666ww(int i) {
        AppMethodBeat.m2504i(21449);
        AlbumItem albumItem;
        if (i == 0) {
            albumItem = this.mQf;
            AppMethodBeat.m2505o(21449);
            return albumItem;
        }
        albumItem = (AlbumItem) this.mQe.get(i - 1);
        AppMethodBeat.m2505o(21449);
        return albumItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C43146a c43146a;
        AppMethodBeat.m2504i(21450);
        C4990ab.m7416i("MicroMsg.GalleryAdapter", "duanyi test getview:".concat(String.valueOf(i)));
        AlbumItem ww = mo68666ww(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130970556, viewGroup, false);
            C43146a c43146a2 = new C43146a();
            c43146a2.mOX = (ImageView) view.findViewById(2131827239);
            c43146a2.gnC = (TextView) view.findViewById(2131827240);
            c43146a2.moY = (ImageView) view.findViewById(2131825005);
            c43146a2.mQi = (TextView) view.findViewById(2131827241);
            c43146a2.mQj = (ImageView) view.findViewById(2131827242);
            view.setTag(c43146a2);
            c43146a = c43146a2;
        } else {
            c43146a = (C43146a) view.getTag();
        }
        if (this.mQg.equals(ww.mOh)) {
            c43146a.mQj.setVisibility(0);
        } else {
            c43146a.mQj.setVisibility(4);
        }
        if (i == 0) {
            c43146a.mOX.setImageResource(C25738R.drawable.beo);
            if (ww.oqq != null) {
                C20921h.m32168a(c43146a.mOX, ww.oqq.getType(), ww.mo7500Wy(), ww.oqq.fPT, ww.aQI());
            }
            if (C34237e.bBZ().mOu == 1) {
                c43146a.gnC.setText(C25738R.string.c33);
            } else if (C34237e.bBZ().mOu == 3) {
                c43146a.gnC.setText(C25738R.string.c34);
            } else {
                c43146a.gnC.setText(C25738R.string.c35);
            }
            c43146a.mOX.setVisibility(0);
            c43146a.gnC.setVisibility(0);
            c43146a.mQi.setVisibility(8);
            AppMethodBeat.m2505o(21450);
        } else {
            c43146a.mOX.setVisibility(0);
            c43146a.gnC.setVisibility(0);
            c43146a.gnC.setText(ww.mOh);
            c43146a.mQi.setVisibility(0);
            c43146a.mQi.setText(this.mContext.getString(C25738R.string.c3d, new Object[]{Integer.valueOf(ww.cyR)}));
            if (!(c43146a.moY == null || ww.oqq == null)) {
                c43146a.moY.setVisibility(ww.oqq.getType() == 2 ? 0 : 8);
            }
            String Wy = ww.mo7500Wy();
            if (!C5046bo.isNullOrNil(Wy) && ww.oqq != null) {
                C20921h.m32168a(c43146a.mOX, ww.oqq.getType(), Wy, ww.oqq.fPT, ww.aQI());
            } else if (ww.oqq == null || ww.oqq.getType() != 2) {
                C4990ab.m7412e("MicroMsg.GalleryAdapter", "get folder failed");
                c43146a.mOX.setVisibility(8);
                c43146a.gnC.setVisibility(8);
            } else {
                C20921h.m32168a(c43146a.mOX, ww.oqq.getType(), null, ww.oqq.fPT, ww.aQI());
            }
            AppMethodBeat.m2505o(21450);
        }
        return view;
    }
}

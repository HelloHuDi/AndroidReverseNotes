package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b extends BaseAdapter {
    private Context mContext;
    private int mOu;
    LinkedList<AlbumItem> mQe;
    AlbumItem mQf;
    String mQg = "";
    private int mQh = 0;

    static class a {
        public TextView gnC;
        public ImageView mOX;
        public TextView mQi;
        public ImageView mQj;
        public ImageView moY;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(21451);
        AlbumItem ww = ww(i);
        AppMethodBeat.o(21451);
        return ww;
    }

    public b(Context context, int i) {
        AppMethodBeat.i(21447);
        this.mContext = context;
        this.mQe = new LinkedList();
        this.mOu = i;
        this.mQf = new AlbumItem("", 0);
        this.mQf.oqq = new ImageMediaItem();
        this.mQh = context.getResources().getDimensionPixelSize(R.dimen.nc);
        AppMethodBeat.o(21447);
    }

    public final int getCount() {
        AppMethodBeat.i(21448);
        int size = this.mQe.size() + 1;
        AppMethodBeat.o(21448);
        return size;
    }

    public final AlbumItem ww(int i) {
        AppMethodBeat.i(21449);
        AlbumItem albumItem;
        if (i == 0) {
            albumItem = this.mQf;
            AppMethodBeat.o(21449);
            return albumItem;
        }
        albumItem = (AlbumItem) this.mQe.get(i - 1);
        AppMethodBeat.o(21449);
        return albumItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(21450);
        ab.i("MicroMsg.GalleryAdapter", "duanyi test getview:".concat(String.valueOf(i)));
        AlbumItem ww = ww(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.apo, viewGroup, false);
            a aVar2 = new a();
            aVar2.mOX = (ImageView) view.findViewById(R.id.e5z);
            aVar2.gnC = (TextView) view.findViewById(R.id.e60);
            aVar2.moY = (ImageView) view.findViewById(R.id.cik);
            aVar2.mQi = (TextView) view.findViewById(R.id.e61);
            aVar2.mQj = (ImageView) view.findViewById(R.id.e62);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.mQg.equals(ww.mOh)) {
            aVar.mQj.setVisibility(0);
        } else {
            aVar.mQj.setVisibility(4);
        }
        if (i == 0) {
            aVar.mOX.setImageResource(R.drawable.beo);
            if (ww.oqq != null) {
                h.a(aVar.mOX, ww.oqq.getType(), ww.Wy(), ww.oqq.fPT, ww.aQI());
            }
            if (e.bBZ().mOu == 1) {
                aVar.gnC.setText(R.string.c33);
            } else if (e.bBZ().mOu == 3) {
                aVar.gnC.setText(R.string.c34);
            } else {
                aVar.gnC.setText(R.string.c35);
            }
            aVar.mOX.setVisibility(0);
            aVar.gnC.setVisibility(0);
            aVar.mQi.setVisibility(8);
            AppMethodBeat.o(21450);
        } else {
            aVar.mOX.setVisibility(0);
            aVar.gnC.setVisibility(0);
            aVar.gnC.setText(ww.mOh);
            aVar.mQi.setVisibility(0);
            aVar.mQi.setText(this.mContext.getString(R.string.c3d, new Object[]{Integer.valueOf(ww.cyR)}));
            if (!(aVar.moY == null || ww.oqq == null)) {
                aVar.moY.setVisibility(ww.oqq.getType() == 2 ? 0 : 8);
            }
            String Wy = ww.Wy();
            if (!bo.isNullOrNil(Wy) && ww.oqq != null) {
                h.a(aVar.mOX, ww.oqq.getType(), Wy, ww.oqq.fPT, ww.aQI());
            } else if (ww.oqq == null || ww.oqq.getType() != 2) {
                ab.e("MicroMsg.GalleryAdapter", "get folder failed");
                aVar.mOX.setVisibility(8);
                aVar.gnC.setVisibility(8);
            } else {
                h.a(aVar.mOX, ww.oqq.getType(), null, ww.oqq.fPT, ww.aQI());
            }
            AppMethodBeat.o(21450);
        }
        return view;
    }
}

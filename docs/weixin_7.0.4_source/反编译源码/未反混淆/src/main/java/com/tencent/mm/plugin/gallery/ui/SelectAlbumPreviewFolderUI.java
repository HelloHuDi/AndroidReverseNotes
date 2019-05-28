package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(19)
public class SelectAlbumPreviewFolderUI extends MMActivity implements com.tencent.mm.plugin.gallery.model.i.a {
    ArrayList<AlbumItem> mRT = new ArrayList(10);
    private a mRU;
    private RecyclerView mRV;
    AlbumItem mRW;
    private String mRX;

    class a extends android.support.v7.widget.RecyclerView.a<b> implements OnClickListener {
        Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        public final int getItemCount() {
            AppMethodBeat.i(21592);
            int size = SelectAlbumPreviewFolderUI.this.mRT.size() + 1;
            AppMethodBeat.o(21592);
            return size;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(21593);
            Intent intent = new Intent(SelectAlbumPreviewFolderUI.this, AlbumPreviewUI.class);
            intent.putExtra("select_folder_name", (AlbumItem) view.getTag());
            intent.setFlags(67108864);
            SelectAlbumPreviewFolderUI.this.setResult(-1, intent);
            SelectAlbumPreviewFolderUI.this.finish();
            AppMethodBeat.o(21593);
        }
    }

    class b extends v {
        public TextView gnC = ((TextView) this.mRR.findViewById(R.id.e60));
        public ImageView mOX = ((ImageView) this.mRR.findViewById(R.id.e5z));
        public TextView mQi = ((TextView) this.mRR.findViewById(R.id.e61));
        public ImageView mQj = ((ImageView) this.mRR.findViewById(R.id.e62));
        public View mRR;
        public ImageView moY = ((ImageView) this.mRR.findViewById(R.id.cik));

        public b(View view) {
            super(view);
            AppMethodBeat.i(21596);
            this.mRR = view;
            AppMethodBeat.o(21596);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectAlbumPreviewFolderUI() {
        AppMethodBeat.i(21597);
        AppMethodBeat.o(21597);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21598);
        super.onCreate(bundle);
        e.bBZ().b(this);
        e.bBZ().a(this);
        e.bBZ().bCu();
        this.mRV = (RecyclerView) findViewById(R.id.e7y);
        this.mRU = new a(this);
        this.mRV.setLayoutManager(new LinearLayoutManager());
        this.mRV.setAdapter(this.mRU);
        this.mRX = getIntent().getStringExtra("select_folder_name");
        this.mRW = new AlbumItem("", 0);
        this.mRW.oqq = new ImageMediaItem();
        setMMTitle(bo.nullAsNil(getString(R.string.q7)));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21590);
                SelectAlbumPreviewFolderUI.this.finish();
                AppMethodBeat.o(21590);
                return false;
            }
        });
        AppMethodBeat.o(21598);
    }

    public void onDestroy() {
        AppMethodBeat.i(21599);
        super.onDestroy();
        e.bBZ().b(this);
        AppMethodBeat.o(21599);
    }

    public final int getLayoutId() {
        return R.layout.aqo;
    }

    public void onBackPressed() {
        AppMethodBeat.i(21600);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(21600);
    }

    public final void V(final LinkedList<AlbumItem> linkedList) {
        AppMethodBeat.i(21601);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21591);
                SelectAlbumPreviewFolderUI.this.mRT.addAll(linkedList);
                SelectAlbumPreviewFolderUI.this.mRU.aop.notifyChanged();
                AppMethodBeat.o(21591);
            }
        });
        AppMethodBeat.o(21601);
    }

    static /* synthetic */ String d(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        AppMethodBeat.i(21602);
        String string;
        if (e.bBZ().mOu == 1) {
            string = selectAlbumPreviewFolderUI.getString(R.string.c33);
            AppMethodBeat.o(21602);
            return string;
        } else if (e.bBZ().mOu == 3) {
            string = selectAlbumPreviewFolderUI.getString(R.string.c34);
            AppMethodBeat.o(21602);
            return string;
        } else {
            string = selectAlbumPreviewFolderUI.getString(R.string.c35);
            AppMethodBeat.o(21602);
            return string;
        }
    }
}

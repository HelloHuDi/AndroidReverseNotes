package com.tencent.p177mm.plugin.gallery.p427ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C39158a;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.LinkedList;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI */
public class SelectAlbumPreviewFolderUI extends MMActivity implements C39158a {
    ArrayList<AlbumItem> mRT = new ArrayList(10);
    private C3213a mRU;
    private RecyclerView mRV;
    AlbumItem mRW;
    private String mRX;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI$a */
    class C3213a extends C41523a<C28171b> implements OnClickListener {
        Context mContext;

        public C3213a(Context context) {
            this.mContext = context;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(21592);
            int size = SelectAlbumPreviewFolderUI.this.mRT.size() + 1;
            AppMethodBeat.m2505o(21592);
            return size;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21593);
            Intent intent = new Intent(SelectAlbumPreviewFolderUI.this, AlbumPreviewUI.class);
            intent.putExtra("select_folder_name", (AlbumItem) view.getTag());
            intent.setFlags(67108864);
            SelectAlbumPreviewFolderUI.this.setResult(-1, intent);
            SelectAlbumPreviewFolderUI.this.finish();
            AppMethodBeat.m2505o(21593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI$b */
    class C28171b extends C41531v {
        public TextView gnC = ((TextView) this.mRR.findViewById(2131827240));
        public ImageView mOX = ((ImageView) this.mRR.findViewById(2131827239));
        public TextView mQi = ((TextView) this.mRR.findViewById(2131827241));
        public ImageView mQj = ((ImageView) this.mRR.findViewById(2131827242));
        public View mRR;
        public ImageView moY = ((ImageView) this.mRR.findViewById(2131825005));

        public C28171b(View view) {
            super(view);
            AppMethodBeat.m2504i(21596);
            this.mRR = view;
            AppMethodBeat.m2505o(21596);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI$1 */
    class C342531 implements OnMenuItemClickListener {
        C342531() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21590);
            SelectAlbumPreviewFolderUI.this.finish();
            AppMethodBeat.m2505o(21590);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SelectAlbumPreviewFolderUI() {
        AppMethodBeat.m2504i(21597);
        AppMethodBeat.m2505o(21597);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21598);
        super.onCreate(bundle);
        C34237e.bBZ().mo73862b(this);
        C34237e.bBZ().mo73861a(this);
        C34237e.bBZ().bCu();
        this.mRV = (RecyclerView) findViewById(2131827312);
        this.mRU = new C3213a(this);
        this.mRV.setLayoutManager(new LinearLayoutManager());
        this.mRV.setAdapter(this.mRU);
        this.mRX = getIntent().getStringExtra("select_folder_name");
        this.mRW = new AlbumItem("", 0);
        this.mRW.oqq = new ImageMediaItem();
        setMMTitle(C5046bo.nullAsNil(getString(C25738R.string.f9123q7)));
        setBackBtn(new C342531());
        AppMethodBeat.m2505o(21598);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21599);
        super.onDestroy();
        C34237e.bBZ().mo73862b(this);
        AppMethodBeat.m2505o(21599);
    }

    public final int getLayoutId() {
        return 2130970593;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(21600);
        super.onBackPressed();
        finish();
        AppMethodBeat.m2505o(21600);
    }

    /* renamed from: V */
    public final void mo62060V(final LinkedList<AlbumItem> linkedList) {
        AppMethodBeat.m2504i(21601);
        new C7306ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(21591);
                SelectAlbumPreviewFolderUI.this.mRT.addAll(linkedList);
                SelectAlbumPreviewFolderUI.this.mRU.aop.notifyChanged();
                AppMethodBeat.m2505o(21591);
            }
        });
        AppMethodBeat.m2505o(21601);
    }

    /* renamed from: d */
    static /* synthetic */ String m71913d(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        AppMethodBeat.m2504i(21602);
        String string;
        if (C34237e.bBZ().mOu == 1) {
            string = selectAlbumPreviewFolderUI.getString(C25738R.string.c33);
            AppMethodBeat.m2505o(21602);
            return string;
        } else if (C34237e.bBZ().mOu == 3) {
            string = selectAlbumPreviewFolderUI.getString(C25738R.string.c34);
            AppMethodBeat.m2505o(21602);
            return string;
        } else {
            string = selectAlbumPreviewFolderUI.getString(C25738R.string.c35);
            AppMethodBeat.m2505o(21602);
            return string;
        }
    }
}

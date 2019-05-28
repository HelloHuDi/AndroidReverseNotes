package com.tencent.mm.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.List;

public class MoreShareAppUI extends MMActivity {
    private DragSortListView lar;
    private List<f> yqo;
    private a zGm;

    static class a extends ArrayAdapter<f> {
        private List<f> kSg;
        private Context mContext;

        static class a {
            TextView gnB;
            ImageView iqT;
            MMSwitchBtn ixT;
            View kSh;
            ImageView kSi;

            public a(View view) {
                AppMethodBeat.i(34886);
                this.kSi = (ImageView) view.findViewById(R.id.dcc);
                this.iqT = (ImageView) view.findViewById(R.id.bi9);
                this.gnB = (TextView) view.findViewById(R.id.bi8);
                this.ixT = (MMSwitchBtn) view.findViewById(R.id.dcd);
                this.kSh = view.findViewById(R.id.nc);
                AppMethodBeat.o(34886);
            }
        }

        public a(Context context, List<f> list) {
            super(context, R.layout.aha, list);
            this.mContext = context;
            this.kSg = list;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(34887);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.aha, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.gnB.setText(((f) getItem(i)).field_appName);
            view.setVisibility(0);
            AppMethodBeat.o(34887);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ah_;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34888);
        super.onCreate(bundle);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34885);
                MoreShareAppUI.this.finish();
                AppMethodBeat.o(34885);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.b_z), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        this.zGm = new a(this, this.yqo);
        this.lar.setAdapter(this.zGm);
        AppMethodBeat.o(34888);
    }

    public final void initView() {
        AppMethodBeat.i(34889);
        setMMTitle((int) R.string.ab4);
        this.lar = (DragSortListView) findViewById(R.id.a46);
        this.lar.setDropListener(new h() {
            public final void dm(int i, int i2) {
                AppMethodBeat.i(34884);
                f fVar = (f) MoreShareAppUI.this.zGm.getItem(i);
                MoreShareAppUI.this.zGm.kSg.remove(i);
                MoreShareAppUI.this.zGm.notifyDataSetChanged();
                MoreShareAppUI.this.zGm.insert(fVar, i2);
                AppMethodBeat.o(34884);
            }
        });
        AppMethodBeat.o(34889);
    }
}

package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI extends MMActivity {
    private DragSortListView lar;
    private long wPF;
    private a yqn;
    private List<f> yqo;

    static class a extends ArrayAdapter<f> {
        List<f> kSg;
        private c lyr;
        private Context mContext;
        private long wPF;

        static class a {
            TextView gnB;
            ImageView iqT;
            MMSwitchBtn ixT;
            View kSh;
            ImageView kSi;

            public a(View view) {
                AppMethodBeat.i(29901);
                this.kSi = (ImageView) view.findViewById(R.id.dcc);
                this.iqT = (ImageView) view.findViewById(R.id.bi9);
                this.gnB = (TextView) view.findViewById(R.id.bi8);
                this.ixT = (MMSwitchBtn) view.findViewById(R.id.dcd);
                this.kSh = view.findViewById(R.id.nc);
                AppMethodBeat.o(29901);
            }
        }

        public a(Context context, List<f> list, long j) {
            super(context, R.layout.ax9, list);
            AppMethodBeat.i(29902);
            this.wPF = j;
            this.mContext = context;
            this.kSg = list;
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePT = R.drawable.ajl;
            this.lyr = aVar.ahG();
            AppMethodBeat.o(29902);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z = true;
            AppMethodBeat.i(29903);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.ax9, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            final f fVar = (f) getItem(i);
            aVar.gnB.setText(fVar.field_appName);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bz.a.getDensity(this.mContext));
            if (b == null || b.isRecycled()) {
                o.ahp().a(fVar.field_appIconUrl, aVar.iqT, this.lyr);
            } else {
                aVar.iqT.setImageBitmap(b);
            }
            MMSwitchBtn mMSwitchBtn = aVar.ixT;
            if ((fVar.field_appInfoFlag & 16384) != 0) {
                z = false;
            }
            mMSwitchBtn.setCheck(z);
            aVar.ixT.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
                public final void di(boolean z) {
                    AppMethodBeat.i(29900);
                    f fVar;
                    if (z) {
                        fVar = fVar;
                        fVar.field_appInfoFlag &= -16385;
                    } else {
                        fVar = fVar;
                        fVar.field_appInfoFlag |= 16384;
                    }
                    am.bYJ().a(fVar, new String[0]);
                    AppMethodBeat.o(29900);
                }
            });
            view.setVisibility(0);
            AppMethodBeat.o(29903);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return R.layout.ax8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29904);
        super.onCreate(bundle);
        this.wPF = getIntent().getLongExtra("KFlag", -1);
        initView();
        this.yqo = g.b((Context) this, this.wPF, true);
        final List mb = am.dhO().mb(this.wPF);
        if (mb != null && mb.size() > 0) {
            Collections.sort(this.yqo, new Comparator<f>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(29899);
                    f fVar = (f) obj2;
                    int indexOf = mb.indexOf(fVar.field_appId) - mb.indexOf(((f) obj).field_appId);
                    AppMethodBeat.o(29899);
                    return indexOf;
                }
            });
        }
        this.yqn = new a(this, this.yqo, this.wPF);
        this.lar.setAdapter(this.yqn);
        AppMethodBeat.o(29904);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.i(29905);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29897);
                Sort3rdAppUI.this.finish();
                AppMethodBeat.o(29897);
                return true;
            }
        });
        setMMTitle(getString(R.string.cd));
        this.lar = (DragSortListView) findViewById(R.id.a46);
        this.lar.setDropListener(new h() {
            public final void dm(int i, int i2) {
                AppMethodBeat.i(29898);
                f fVar = (f) Sort3rdAppUI.this.yqn.getItem(i);
                Sort3rdAppUI.this.yqn.remove(fVar);
                Sort3rdAppUI.this.yqn.insert(fVar, i2);
                AppMethodBeat.o(29898);
            }
        });
        AppMethodBeat.o(29905);
    }

    public void onDestroy() {
        AppMethodBeat.i(29906);
        super.onDestroy();
        AppMethodBeat.o(29906);
    }

    public void onPause() {
        AppMethodBeat.i(29907);
        super.onPause();
        if (this.yqn != null) {
            List list = this.yqn.kSg;
            com.tencent.mm.pluginsdk.model.app.o dhO = am.dhO();
            long j = this.wPF;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from AppSort");
            stringBuilder.append(" where flag = ").append(j).append(" ");
            dhO.bSd.hY("AppSort", stringBuilder.toString());
            if (list != null && list.size() > 0) {
                aw.ZK();
                j = com.tencent.mm.model.c.Ru().iV(Thread.currentThread().getId());
                com.tencent.mm.pluginsdk.model.app.o dhO2 = am.dhO();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    n nVar = new n();
                    nVar.field_flag = this.wPF;
                    nVar.field_appId = ((f) list.get(i2)).field_appId;
                    nVar.field_sortId = i2;
                    dhO2.a(nVar);
                    i = i2 + 1;
                }
                aw.ZK();
                com.tencent.mm.model.c.Ru().mB(j);
            }
        }
        AppMethodBeat.o(29907);
    }
}

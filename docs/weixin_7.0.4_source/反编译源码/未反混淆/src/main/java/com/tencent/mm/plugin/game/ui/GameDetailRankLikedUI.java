package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.d.bq;
import com.tencent.mm.plugin.game.d.dl;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog iMU;
    private a ngA;
    private ListView ngz;

    static class a extends BaseAdapter {
        private Context mContext;
        List<dl> ngC = new LinkedList();

        static class a {
            public ImageView gvq;
            public TextView ngD;
            public TextView ngn;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(111829);
            dl wH = wH(i);
            AppMethodBeat.o(111829);
            return wH;
        }

        public a(Context context) {
            AppMethodBeat.i(111825);
            this.mContext = context;
            AppMethodBeat.o(111825);
        }

        public final int getCount() {
            AppMethodBeat.i(111826);
            int size = this.ngC.size();
            AppMethodBeat.o(111826);
            return size;
        }

        private dl wH(int i) {
            AppMethodBeat.i(111827);
            dl dlVar = (dl) this.ngC.get(i);
            AppMethodBeat.o(111827);
            return dlVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(111828);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.a3i, viewGroup, false);
                aVar = new a();
                aVar.gvq = (ImageView) view.findViewById(R.id.c4w);
                aVar.ngn = (TextView) view.findViewById(R.id.c4x);
                aVar.ngD = (TextView) view.findViewById(R.id.c4y);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            dl wH = wH(i);
            b.a(aVar.gvq, wH.ndG, 0.5f, false);
            ad aoO = ((j) g.K(j.class)).XM().aoO(wH.ndG);
            if (aoO != null) {
                aVar.ngn.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, aoO.Oj(), aVar.ngn.getTextSize())));
            } else {
                aVar.ngn.setText("");
            }
            aVar.ngD.setText(wH.ndH);
            AppMethodBeat.o(111828);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(111832);
        AppMethodBeat.o(111832);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111830);
        super.onCreate(bundle);
        initView();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.o(111830);
            return;
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bp();
        aVar.fsK = new bq();
        aVar.uri = "/cgi-bin/mmgame-bin/getuplist";
        aVar.fsI = 1331;
        com.tencent.mm.ai.b acD = aVar.acD();
        ((bp) acD.fsG.fsP).mZr = stringExtra;
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(111824);
                if (i == 0 && i2 == 0) {
                    bq bqVar = (bq) bVar.fsH.fsP;
                    a a = GameDetailRankLikedUI.this.ngA;
                    LinkedList linkedList = bqVar.ncy;
                    if (linkedList != null) {
                        a.ngC.clear();
                        a.ngC.addAll(linkedList);
                        a.notifyDataSetChanged();
                    }
                    GameDetailRankLikedUI.this.iMU.dismiss();
                    AppMethodBeat.o(111824);
                } else {
                    ab.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                    GameDetailRankLikedUI.this.finish();
                    AppMethodBeat.o(111824);
                }
                return 0;
            }
        });
        AppMethodBeat.o(111830);
    }

    public final int getLayoutId() {
        return R.layout.a3h;
    }

    public final void initView() {
        AppMethodBeat.i(111831);
        setMMTitle((int) R.string.c54);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111823);
                GameDetailRankLikedUI.this.finish();
                AppMethodBeat.o(111823);
                return true;
            }
        });
        this.ngz = (ListView) findViewById(R.id.c4v);
        this.ngA = new a(this);
        this.ngz.setAdapter(this.ngA);
        this.iMU = c.ej(this.mController.ylL);
        this.iMU.show();
        AppMethodBeat.o(111831);
    }
}

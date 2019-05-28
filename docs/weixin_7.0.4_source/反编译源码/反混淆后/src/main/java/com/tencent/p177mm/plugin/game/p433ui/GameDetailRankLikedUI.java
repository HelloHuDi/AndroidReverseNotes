package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C20949bp;
import com.tencent.p177mm.plugin.game.p731d.C28186bq;
import com.tencent.p177mm.plugin.game.p731d.C45997dl;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI */
public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog iMU;
    private C21015a ngA;
    private ListView ngz;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI$1 */
    class C210131 implements OnMenuItemClickListener {
        C210131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111823);
            GameDetailRankLikedUI.this.finish();
            AppMethodBeat.m2505o(111823);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI$2 */
    class C210142 implements C1224a {
        C210142() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(111824);
            if (i == 0 && i2 == 0) {
                C28186bq c28186bq = (C28186bq) c7472b.fsH.fsP;
                C21015a a = GameDetailRankLikedUI.this.ngA;
                LinkedList linkedList = c28186bq.ncy;
                if (linkedList != null) {
                    a.ngC.clear();
                    a.ngC.addAll(linkedList);
                    a.notifyDataSetChanged();
                }
                GameDetailRankLikedUI.this.iMU.dismiss();
                AppMethodBeat.m2505o(111824);
            } else {
                C4990ab.m7413e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                GameDetailRankLikedUI.this.finish();
                AppMethodBeat.m2505o(111824);
            }
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI$a */
    static class C21015a extends BaseAdapter {
        private Context mContext;
        List<C45997dl> ngC = new LinkedList();

        /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI$a$a */
        static class C21016a {
            public ImageView gvq;
            public TextView ngD;
            public TextView ngn;

            private C21016a() {
            }

            /* synthetic */ C21016a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(111829);
            C45997dl wH = m32319wH(i);
            AppMethodBeat.m2505o(111829);
            return wH;
        }

        public C21015a(Context context) {
            AppMethodBeat.m2504i(111825);
            this.mContext = context;
            AppMethodBeat.m2505o(111825);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(111826);
            int size = this.ngC.size();
            AppMethodBeat.m2505o(111826);
            return size;
        }

        /* renamed from: wH */
        private C45997dl m32319wH(int i) {
            AppMethodBeat.m2504i(111827);
            C45997dl c45997dl = (C45997dl) this.ngC.get(i);
            AppMethodBeat.m2505o(111827);
            return c45997dl;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C21016a c21016a;
            AppMethodBeat.m2504i(111828);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(2130969698, viewGroup, false);
                c21016a = new C21016a();
                c21016a.gvq = (ImageView) view.findViewById(2131824462);
                c21016a.ngn = (TextView) view.findViewById(2131824463);
                c21016a.ngD = (TextView) view.findViewById(2131824464);
                view.setTag(c21016a);
            } else {
                c21016a = (C21016a) view.getTag();
            }
            C45997dl wH = m32319wH(i);
            C40460b.m69433a(c21016a.gvq, wH.ndG, 0.5f, false);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(wH.ndG);
            if (aoO != null) {
                c21016a.ngn.setText(new SpannableString(C44089j.m79293b(this.mContext, aoO.mo16707Oj(), c21016a.ngn.getTextSize())));
            } else {
                c21016a.ngn.setText("");
            }
            c21016a.ngD.setText(wH.ndH);
            AppMethodBeat.m2505o(111828);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(111832);
        AppMethodBeat.m2505o(111832);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111830);
        super.onCreate(bundle);
        initView();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (C5046bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.m2505o(111830);
            return;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C20949bp();
        c1196a.fsK = new C28186bq();
        c1196a.uri = "/cgi-bin/mmgame-bin/getuplist";
        c1196a.fsI = 1331;
        C7472b acD = c1196a.acD();
        ((C20949bp) acD.fsG.fsP).mZr = stringExtra;
        C1226w.m2654a(acD, new C210142());
        AppMethodBeat.m2505o(111830);
    }

    public final int getLayoutId() {
        return 2130969697;
    }

    public final void initView() {
        AppMethodBeat.m2504i(111831);
        setMMTitle((int) C25738R.string.c54);
        setBackBtn(new C210131());
        this.ngz = (ListView) findViewById(2131824461);
        this.ngA = new C21015a(this);
        this.ngz.setAdapter(this.ngA);
        this.iMU = C46001c.m85459ej(this.mController.ylL);
        this.iMU.show();
        AppMethodBeat.m2505o(111831);
    }
}

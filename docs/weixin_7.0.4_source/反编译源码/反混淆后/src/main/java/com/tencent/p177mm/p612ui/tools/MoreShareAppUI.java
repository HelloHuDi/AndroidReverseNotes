package com.tencent.p177mm.p612ui.tools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C16018h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import java.util.List;

/* renamed from: com.tencent.mm.ui.tools.MoreShareAppUI */
public class MoreShareAppUI extends MMActivity {
    private DragSortListView lar;
    private List<C40439f> yqo;
    private C15928a zGm;

    /* renamed from: com.tencent.mm.ui.tools.MoreShareAppUI$3 */
    class C159253 implements OnMenuItemClickListener {
        C159253() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MoreShareAppUI$1 */
    class C159261 implements C16018h {
        C159261() {
        }

        /* renamed from: dm */
        public final void mo17752dm(int i, int i2) {
            AppMethodBeat.m2504i(34884);
            C40439f c40439f = (C40439f) MoreShareAppUI.this.zGm.getItem(i);
            MoreShareAppUI.this.zGm.kSg.remove(i);
            MoreShareAppUI.this.zGm.notifyDataSetChanged();
            MoreShareAppUI.this.zGm.insert(c40439f, i2);
            AppMethodBeat.m2505o(34884);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MoreShareAppUI$2 */
    class C159272 implements OnMenuItemClickListener {
        C159272() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34885);
            MoreShareAppUI.this.finish();
            AppMethodBeat.m2505o(34885);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MoreShareAppUI$a */
    static class C15928a extends ArrayAdapter<C40439f> {
        private List<C40439f> kSg;
        private Context mContext;

        /* renamed from: com.tencent.mm.ui.tools.MoreShareAppUI$a$a */
        static class C15929a {
            TextView gnB;
            ImageView iqT;
            MMSwitchBtn ixT;
            View kSh;
            ImageView kSi;

            public C15929a(View view) {
                AppMethodBeat.m2504i(34886);
                this.kSi = (ImageView) view.findViewById(2131826143);
                this.iqT = (ImageView) view.findViewById(2131823624);
                this.gnB = (TextView) view.findViewById(2131823623);
                this.ixT = (MMSwitchBtn) view.findViewById(2131826144);
                this.kSh = view.findViewById(2131821064);
                AppMethodBeat.m2505o(34886);
            }
        }

        public C15928a(Context context, List<C40439f> list) {
            super(context, 2130970245, list);
            this.mContext = context;
            this.kSg = list;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C15929a c15929a;
            AppMethodBeat.m2504i(34887);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970245, null);
                C15929a c15929a2 = new C15929a(view);
                view.setTag(c15929a2);
                c15929a = c15929a2;
            } else {
                c15929a = (C15929a) view.getTag();
            }
            c15929a.gnB.setText(((C40439f) getItem(i)).field_appName);
            view.setVisibility(0);
            AppMethodBeat.m2505o(34887);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970244;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34888);
        super.onCreate(bundle);
        initView();
        setBackBtn(new C159272());
        addTextOptionMenu(0, getString(C25738R.string.b_z), new C159253());
        this.zGm = new C15928a(this, this.yqo);
        this.lar.setAdapter(this.zGm);
        AppMethodBeat.m2505o(34888);
    }

    public final void initView() {
        AppMethodBeat.m2504i(34889);
        setMMTitle((int) C25738R.string.ab4);
        this.lar = (DragSortListView) findViewById(2131821698);
        this.lar.setDropListener(new C159261());
        AppMethodBeat.m2505o(34889);
    }
}

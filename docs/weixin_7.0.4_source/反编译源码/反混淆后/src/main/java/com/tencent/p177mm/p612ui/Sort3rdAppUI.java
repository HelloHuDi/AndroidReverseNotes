package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C16018h;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C35797n;
import com.tencent.p177mm.pluginsdk.model.app.C35798o;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.Sort3rdAppUI */
public class Sort3rdAppUI extends MMActivity {
    private DragSortListView lar;
    private long wPF;
    private C7923a yqn;
    private List<C40439f> yqo;

    /* renamed from: com.tencent.mm.ui.Sort3rdAppUI$1 */
    class C52101 implements OnMenuItemClickListener {
        C52101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(29897);
            Sort3rdAppUI.this.finish();
            AppMethodBeat.m2505o(29897);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.Sort3rdAppUI$a */
    static class C7923a extends ArrayAdapter<C40439f> {
        List<C40439f> kSg;
        private C25814c lyr;
        private Context mContext;
        private long wPF;

        /* renamed from: com.tencent.mm.ui.Sort3rdAppUI$a$a */
        static class C7925a {
            TextView gnB;
            ImageView iqT;
            MMSwitchBtn ixT;
            View kSh;
            ImageView kSi;

            public C7925a(View view) {
                AppMethodBeat.m2504i(29901);
                this.kSi = (ImageView) view.findViewById(2131826143);
                this.iqT = (ImageView) view.findViewById(2131823624);
                this.gnB = (TextView) view.findViewById(2131823623);
                this.ixT = (MMSwitchBtn) view.findViewById(2131826144);
                this.kSh = view.findViewById(2131821064);
                AppMethodBeat.m2505o(29901);
            }
        }

        public C7923a(Context context, List<C40439f> list, long j) {
            super(context, 2130970835, list);
            AppMethodBeat.m2504i(29902);
            this.wPF = j;
            this.mContext = context;
            this.kSg = list;
            C17927a c17927a = new C17927a();
            c17927a.ePT = C25738R.drawable.ajl;
            this.lyr = c17927a.ahG();
            AppMethodBeat.m2505o(29902);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C7925a c7925a;
            boolean z = true;
            AppMethodBeat.m2504i(29903);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970835, null);
                C7925a c7925a2 = new C7925a(view);
                view.setTag(c7925a2);
                c7925a = c7925a2;
            } else {
                c7925a = (C7925a) view.getTag();
            }
            final C40439f c40439f = (C40439f) getItem(i);
            c7925a.gnB.setText(c40439f.field_appName);
            Bitmap b = C46494g.m87732b(c40439f.field_appId, 1, C1338a.getDensity(this.mContext));
            if (b == null || b.isRecycled()) {
                C32291o.ahp().mo43766a(c40439f.field_appIconUrl, c7925a.iqT, this.lyr);
            } else {
                c7925a.iqT.setImageBitmap(b);
            }
            MMSwitchBtn mMSwitchBtn = c7925a.ixT;
            if ((c40439f.field_appInfoFlag & 16384) != 0) {
                z = false;
            }
            mMSwitchBtn.setCheck(z);
            c7925a.ixT.setSwitchListener(new C30795a() {
                /* renamed from: di */
                public final void mo6646di(boolean z) {
                    AppMethodBeat.m2504i(29900);
                    C40439f c40439f;
                    if (z) {
                        c40439f = c40439f;
                        c40439f.field_appInfoFlag &= -16385;
                    } else {
                        c40439f = c40439f;
                        c40439f.field_appInfoFlag |= 16384;
                    }
                    C14877am.bYJ().mo56566a(c40439f, new String[0]);
                    AppMethodBeat.m2505o(29900);
                }
            });
            view.setVisibility(0);
            AppMethodBeat.m2505o(29903);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.ui.Sort3rdAppUI$2 */
    class C79262 implements C16018h {
        C79262() {
        }

        /* renamed from: dm */
        public final void mo17752dm(int i, int i2) {
            AppMethodBeat.m2504i(29898);
            C40439f c40439f = (C40439f) Sort3rdAppUI.this.yqn.getItem(i);
            Sort3rdAppUI.this.yqn.remove(c40439f);
            Sort3rdAppUI.this.yqn.insert(c40439f, i2);
            AppMethodBeat.m2505o(29898);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return 2130970834;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29904);
        super.onCreate(bundle);
        this.wPF = getIntent().getLongExtra("KFlag", -1);
        initView();
        this.yqo = C46494g.m87735b((Context) this, this.wPF, true);
        final List mb = C14877am.dhO().mo56576mb(this.wPF);
        if (mb != null && mb.size() > 0) {
            Collections.sort(this.yqo, new Comparator<C40439f>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.m2504i(29899);
                    C40439f c40439f = (C40439f) obj2;
                    int indexOf = mb.indexOf(c40439f.field_appId) - mb.indexOf(((C40439f) obj).field_appId);
                    AppMethodBeat.m2505o(29899);
                    return indexOf;
                }
            });
        }
        this.yqn = new C7923a(this, this.yqo, this.wPF);
        this.lar.setAdapter(this.yqn);
        AppMethodBeat.m2505o(29904);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.m2504i(29905);
        setBackBtn(new C52101());
        setMMTitle(getString(C25738R.string.f8697cd));
        this.lar = (DragSortListView) findViewById(2131821698);
        this.lar.setDropListener(new C79262());
        AppMethodBeat.m2505o(29905);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(29906);
        super.onDestroy();
        AppMethodBeat.m2505o(29906);
    }

    public void onPause() {
        AppMethodBeat.m2504i(29907);
        super.onPause();
        if (this.yqn != null) {
            List list = this.yqn.kSg;
            C35798o dhO = C14877am.dhO();
            long j = this.wPF;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from AppSort");
            stringBuilder.append(" where flag = ").append(j).append(" ");
            dhO.bSd.mo10108hY("AppSort", stringBuilder.toString());
            if (list != null && list.size() > 0) {
                C9638aw.m17190ZK();
                j = C18628c.m29069Ru().mo15639iV(Thread.currentThread().getId());
                C35798o dhO2 = C14877am.dhO();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    C35797n c35797n = new C35797n();
                    c35797n.field_flag = this.wPF;
                    c35797n.field_appId = ((C40439f) list.get(i2)).field_appId;
                    c35797n.field_sortId = i2;
                    dhO2.mo56575a(c35797n);
                    i = i2 + 1;
                }
                C9638aw.m17190ZK();
                C18628c.m29069Ru().mo15640mB(j);
            }
        }
        AppMethodBeat.m2505o(29907);
    }
}

package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.p069v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C39262h;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C46038g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI */
public class IPCallMsgUI extends MMActivity {
    private View kmT;
    private boolean kmU = true;
    private ListView nDp;
    private C21116a nDq;
    private View nDr;
    private C4931a nDs = new C122697();

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$4 */
    class C122684 implements OnItemClickListener {
        C122684() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22189);
            C46038g c46038g = (C46038g) IPCallMsgUI.this.nDq.getItem(i);
            if (!C5046bo.isNullOrNil(c46038g.field_descUrl)) {
                int i2 = c46038g.field_msgType;
                C7060h.pYm.mo8381e(13780, Integer.valueOf(i2));
                Intent intent = new Intent();
                intent.putExtra("rawUrl", c46038g.field_descUrl);
                intent.putExtra("showShare", false);
                C25985d.m41467b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(22189);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$7 */
    class C122697 implements C4931a {

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$7$1 */
        class C122701 implements Runnable {
            C122701() {
            }

            public final void run() {
                AppMethodBeat.m2504i(22192);
                synchronized (IPCallMsgUI.this.nDq) {
                    try {
                        C4990ab.m7418v("MicroMsg.IPCallMsgUI", "comment notify");
                        IPCallMsgUI.this.nDq.mo5248a(null, null);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(22192);
                    }
                }
            }
        }

        C122697() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(22193);
            new C7306ak(Looper.getMainLooper()).post(new C122701());
            AppMethodBeat.m2505o(22193);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$5 */
    class C211145 implements OnScrollListener {
        C211145() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(22190);
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                C21116a b = IPCallMsgUI.this.nDq;
                if (!b.bdn()) {
                    b.kmW += 10;
                    if (b.kmW > b.enb) {
                        b.kmW = b.enb;
                    }
                } else if (IPCallMsgUI.this.kmT.getParent() != null) {
                    IPCallMsgUI.this.nDp.removeFooterView(IPCallMsgUI.this.kmT);
                }
                IPCallMsgUI.this.nDq.mo5248a(null, null);
                AppMethodBeat.m2505o(22190);
                return;
            }
            AppMethodBeat.m2505o(22190);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$6 */
    class C211156 implements OnMenuItemClickListener {
        C211156() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22191);
            IPCallMsgUI.this.finish();
            AppMethodBeat.m2505o(22191);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$a */
    class C21116a extends C46692p<C46038g> {
        int enb = this.kmW;
        protected C23600g jJO;
        protected C15521c jJP;
        protected C23597d jJR = new C211171();
        int kmW = 10;
        private Set<MMSlideDelView> nDv = new HashSet();

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$a$1 */
        class C211171 implements C23597d {
            C211171() {
            }

            /* renamed from: a */
            public final void mo25718a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.m2504i(22194);
                if (z) {
                    nDv.add(mMSlideDelView);
                    AppMethodBeat.m2505o(22194);
                    return;
                }
                nDv.remove(mMSlideDelView);
                AppMethodBeat.m2505o(22194);
            }

            public final boolean bIo() {
                AppMethodBeat.m2504i(22195);
                if (nDv.size() > 0) {
                    AppMethodBeat.m2505o(22195);
                    return true;
                }
                AppMethodBeat.m2505o(22195);
                return false;
            }

            public final void bIp() {
                AppMethodBeat.m2504i(22196);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzZ();
                    }
                }
                nDv.clear();
                AppMethodBeat.m2505o(22196);
            }

            public final void bIq() {
                AppMethodBeat.m2504i(22197);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzY();
                    }
                }
                nDv.clear();
                AppMethodBeat.m2505o(22197);
            }
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$a$a */
        class C21118a {
            TextView gKl;
            TextView gne;
            TextView timeTv;

            C21118a() {
            }
        }

        public C21116a(Context context, C46038g c46038g) {
            super(context, c46038g);
            AppMethodBeat.m2504i(22198);
            AppMethodBeat.m2505o(22198);
        }

        public final long getItemId(int i) {
            AppMethodBeat.m2504i(22199);
            long j = ((C46038g) getItem(i)).xDa;
            AppMethodBeat.m2505o(22199);
            return j;
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(22200);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(22200);
        }

        public final void setPerformItemClickListener(C23600g c23600g) {
            this.jJO = c23600g;
        }

        public final void setGetViewPositionCallback(C15521c c15521c) {
            this.jJP = c15521c;
        }

        /* renamed from: a */
        public final synchronized void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(22201);
            super.mo5248a(str, c4935m);
            AppMethodBeat.m2505o(22201);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(22202);
            this.enb = C21088i.bHz().getCount();
            setCursor(C21088i.bHz().mo62158xm(this.kmW));
            notifyDataSetChanged();
            AppMethodBeat.m2505o(22202);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C21118a c21118a;
            CharSequence charSequence;
            Object obj;
            AppMethodBeat.m2504i(22203);
            C46038g c46038g = (C46038g) getItem(i);
            if (view == null || !(view.getTag() instanceof C21118a)) {
                view = C5616v.m8409hu(this.context).inflate(2130969898, null);
                c21118a = new C21118a();
                c21118a.gne = (TextView) view.findViewById(2131821314);
                c21118a.gKl = (TextView) view.findViewById(2131825163);
                c21118a.timeTv = (TextView) view.findViewById(2131825164);
                view.setTag(c21118a);
            } else {
                c21118a = (C21118a) view.getTag();
            }
            c21118a.gne.setText(c46038g.field_title);
            c21118a.gKl.setText(c46038g.field_content);
            TextView textView = c21118a.timeTv;
            AppCompatActivity appCompatActivity = IPCallMsgUI.this.mController.ylL;
            long j = c46038g.field_pushTime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            String str = (String) DateFormat.format(appCompatActivity.getString(C25738R.string.bww), j);
            if (str.indexOf("-") > 0) {
                String str2 = str.split("-")[0];
                str = str.split("-")[1];
                charSequence = (str + " " + C34382c.m56380aJ(appCompatActivity, str2) + " ") + " " + ((String) C34382c.m56383i(appCompatActivity, j));
            } else {
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis <= 0 || timeInMillis > 86400000) {
                        charSequence = str + " " + ((String) C34382c.m56383i(appCompatActivity, j));
                    } else {
                        charSequence = appCompatActivity.getString(C25738R.string.byb) + " " + ((String) C34382c.m56383i(appCompatActivity, j));
                    }
                } else {
                    charSequence = ((String) C34382c.m56383i(appCompatActivity, j));
                }
            }
            textView.setText(charSequence);
            if (c46038g.field_isRead == (short) 1) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                c21118a.gne.setTextColor(IPCallMsgUI.this.getResources().getColor(C25738R.color.f12104sk));
            } else {
                c21118a.gne.setTextColor(IPCallMsgUI.this.getResources().getColor(C25738R.color.f12105sl));
            }
            AppMethodBeat.m2505o(22203);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$2 */
    class C211192 implements C23600g {
        C211192() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(22187);
            IPCallMsgUI.this.nDp.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(22187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$1 */
    class C211201 implements C15521c {
        C211201() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(22186);
            int positionForView = IPCallMsgUI.this.nDp.getPositionForView(view);
            AppMethodBeat.m2505o(22186);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI$3 */
    class C211213 implements C30723a {
        C211213() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(22188);
            if (IPCallMsgUI.this.nDq.getCount() == 0) {
                IPCallMsgUI.this.nDp.setVisibility(8);
                IPCallMsgUI.this.nDr.setVisibility(0);
                AppMethodBeat.m2505o(22188);
                return;
            }
            IPCallMsgUI.this.nDp.setVisibility(0);
            IPCallMsgUI.this.nDr.setVisibility(8);
            AppMethodBeat.m2505o(22188);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallMsgUI() {
        AppMethodBeat.m2504i(22205);
        AppMethodBeat.m2505o(22205);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969899;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22206);
        super.onCreate(bundle);
        C21088i.bHz().mo10116c(this.nDs);
        initView();
        AppMethodBeat.m2505o(22206);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22207);
        C4990ab.m7410d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        C21088i.bHz().mo10117d(this.nDs);
        this.nDq.bIf();
        C39262h bHz = C21088i.bHz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", Short.valueOf((short) 1));
        bHz.bSd.update(bHz.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
        AppMethodBeat.m2505o(22207);
    }

    public final void initView() {
        AppMethodBeat.m2504i(22208);
        setMMTitle((int) C25738R.string.ciu);
        this.nDr = findViewById(2131825166);
        this.nDp = (ListView) findViewById(2131825165);
        this.kmT = C5616v.m8409hu(this).inflate(2130970112, null);
        this.nDp.addFooterView(this.kmT);
        this.nDq = new C21116a(this, new C46038g());
        this.nDq.setGetViewPositionCallback(new C211201());
        this.nDq.setPerformItemClickListener(new C211192());
        this.nDq.mo74992a((C30723a) new C211213());
        this.nDp.setAdapter(this.nDq);
        this.nDp.setOnItemClickListener(new C122684());
        this.nDp.setOnScrollListener(new C211145());
        if (this.nDq.getCount() == 0) {
            this.nDp.setVisibility(8);
            this.nDr.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.nDp.setVisibility(0);
            this.nDr.setVisibility(8);
            enableOptionMenu(true);
        }
        if (this.nDq.bdn()) {
            this.nDp.removeFooterView(this.kmT);
        }
        setBackBtn(new C211156());
        if (this.nDq.bdn()) {
            this.nDp.removeFooterView(this.kmT);
        }
        AppMethodBeat.m2505o(22208);
    }
}

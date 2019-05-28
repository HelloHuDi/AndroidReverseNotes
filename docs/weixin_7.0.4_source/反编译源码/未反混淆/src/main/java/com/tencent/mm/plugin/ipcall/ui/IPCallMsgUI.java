package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class IPCallMsgUI extends MMActivity {
    private View kmT;
    private boolean kmU = true;
    private ListView nDp;
    private a nDq;
    private View nDr;
    private com.tencent.mm.sdk.e.k.a nDs = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(22193);
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22192);
                    synchronized (IPCallMsgUI.this.nDq) {
                        try {
                            ab.v("MicroMsg.IPCallMsgUI", "comment notify");
                            IPCallMsgUI.this.nDq.a(null, null);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(22192);
                        }
                    }
                }
            });
            AppMethodBeat.o(22193);
        }
    };

    class a extends p<g> {
        int enb = this.kmW;
        protected MMSlideDelView.g jJO;
        protected c jJP;
        protected d jJR = new d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.i(22194);
                if (z) {
                    nDv.add(mMSlideDelView);
                    AppMethodBeat.o(22194);
                    return;
                }
                nDv.remove(mMSlideDelView);
                AppMethodBeat.o(22194);
            }

            public final boolean bIo() {
                AppMethodBeat.i(22195);
                if (nDv.size() > 0) {
                    AppMethodBeat.o(22195);
                    return true;
                }
                AppMethodBeat.o(22195);
                return false;
            }

            public final void bIp() {
                AppMethodBeat.i(22196);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzZ();
                    }
                }
                nDv.clear();
                AppMethodBeat.o(22196);
            }

            public final void bIq() {
                AppMethodBeat.i(22197);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzY();
                    }
                }
                nDv.clear();
                AppMethodBeat.o(22197);
            }
        };
        int kmW = 10;
        private Set<MMSlideDelView> nDv = new HashSet();

        class a {
            TextView gKl;
            TextView gne;
            TextView timeTv;

            a() {
            }
        }

        public a(Context context, g gVar) {
            super(context, gVar);
            AppMethodBeat.i(22198);
            AppMethodBeat.o(22198);
        }

        public final long getItemId(int i) {
            AppMethodBeat.i(22199);
            long j = ((g) getItem(i)).xDa;
            AppMethodBeat.o(22199);
            return j;
        }

        public final void KD() {
            AppMethodBeat.i(22200);
            bIf();
            KC();
            AppMethodBeat.o(22200);
        }

        public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
            this.jJO = gVar;
        }

        public final void setGetViewPositionCallback(c cVar) {
            this.jJP = cVar;
        }

        public final synchronized void a(String str, m mVar) {
            AppMethodBeat.i(22201);
            super.a(str, mVar);
            AppMethodBeat.o(22201);
        }

        public final void KC() {
            AppMethodBeat.i(22202);
            this.enb = i.bHz().getCount();
            setCursor(i.bHz().xm(this.kmW));
            notifyDataSetChanged();
            AppMethodBeat.o(22202);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            Object obj;
            AppMethodBeat.i(22203);
            g gVar = (g) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = v.hu(this.context).inflate(R.layout.a8x, null);
                aVar = new a();
                aVar.gne = (TextView) view.findViewById(R.id.u4);
                aVar.gKl = (TextView) view.findViewById(R.id.cmu);
                aVar.timeTv = (TextView) view.findViewById(R.id.cmv);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.gne.setText(gVar.field_title);
            aVar.gKl.setText(gVar.field_content);
            TextView textView = aVar.timeTv;
            AppCompatActivity appCompatActivity = IPCallMsgUI.this.mController.ylL;
            long j = gVar.field_pushTime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            String str = (String) DateFormat.format(appCompatActivity.getString(R.string.bww), j);
            if (str.indexOf("-") > 0) {
                String str2 = str.split("-")[0];
                str = str.split("-")[1];
                charSequence = (str + " " + com.tencent.mm.plugin.ipcall.b.c.aJ(appCompatActivity, str2) + " ") + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.i(appCompatActivity, j));
            } else {
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis <= 0 || timeInMillis > 86400000) {
                        charSequence = str + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.i(appCompatActivity, j));
                    } else {
                        charSequence = appCompatActivity.getString(R.string.byb) + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.i(appCompatActivity, j));
                    }
                } else {
                    charSequence = ((String) com.tencent.mm.plugin.ipcall.b.c.i(appCompatActivity, j));
                }
            }
            textView.setText(charSequence);
            if (gVar.field_isRead == (short) 1) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                aVar.gne.setTextColor(IPCallMsgUI.this.getResources().getColor(R.color.sk));
            } else {
                aVar.gne.setTextColor(IPCallMsgUI.this.getResources().getColor(R.color.sl));
            }
            AppMethodBeat.o(22203);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallMsgUI() {
        AppMethodBeat.i(22205);
        AppMethodBeat.o(22205);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.a8y;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22206);
        super.onCreate(bundle);
        i.bHz().c(this.nDs);
        initView();
        AppMethodBeat.o(22206);
    }

    public void onDestroy() {
        AppMethodBeat.i(22207);
        ab.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        i.bHz().d(this.nDs);
        this.nDq.bIf();
        h bHz = i.bHz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", Short.valueOf((short) 1));
        bHz.bSd.update(bHz.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
        AppMethodBeat.o(22207);
    }

    public final void initView() {
        AppMethodBeat.i(22208);
        setMMTitle((int) R.string.ciu);
        this.nDr = findViewById(R.id.cmx);
        this.nDp = (ListView) findViewById(R.id.cmw);
        this.kmT = v.hu(this).inflate(R.layout.adp, null);
        this.nDp.addFooterView(this.kmT);
        this.nDq = new a(this, new g());
        this.nDq.setGetViewPositionCallback(new c() {
            public final int cZ(View view) {
                AppMethodBeat.i(22186);
                int positionForView = IPCallMsgUI.this.nDp.getPositionForView(view);
                AppMethodBeat.o(22186);
                return positionForView;
            }
        });
        this.nDq.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(22187);
                IPCallMsgUI.this.nDp.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(22187);
            }
        });
        this.nDq.a((com.tencent.mm.ui.p.a) new com.tencent.mm.ui.p.a() {
            public final void apt() {
                AppMethodBeat.i(22188);
                if (IPCallMsgUI.this.nDq.getCount() == 0) {
                    IPCallMsgUI.this.nDp.setVisibility(8);
                    IPCallMsgUI.this.nDr.setVisibility(0);
                    AppMethodBeat.o(22188);
                    return;
                }
                IPCallMsgUI.this.nDp.setVisibility(0);
                IPCallMsgUI.this.nDr.setVisibility(8);
                AppMethodBeat.o(22188);
            }
        });
        this.nDp.setAdapter(this.nDq);
        this.nDp.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22189);
                g gVar = (g) IPCallMsgUI.this.nDq.getItem(i);
                if (!bo.isNullOrNil(gVar.field_descUrl)) {
                    int i2 = gVar.field_msgType;
                    com.tencent.mm.plugin.report.service.h.pYm.e(13780, Integer.valueOf(i2));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", gVar.field_descUrl);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bp.d.b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(22189);
            }
        });
        this.nDp.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(22190);
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    a b = IPCallMsgUI.this.nDq;
                    if (!b.bdn()) {
                        b.kmW += 10;
                        if (b.kmW > b.enb) {
                            b.kmW = b.enb;
                        }
                    } else if (IPCallMsgUI.this.kmT.getParent() != null) {
                        IPCallMsgUI.this.nDp.removeFooterView(IPCallMsgUI.this.kmT);
                    }
                    IPCallMsgUI.this.nDq.a(null, null);
                    AppMethodBeat.o(22190);
                    return;
                }
                AppMethodBeat.o(22190);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
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
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22191);
                IPCallMsgUI.this.finish();
                AppMethodBeat.o(22191);
                return true;
            }
        });
        if (this.nDq.bdn()) {
            this.nDp.removeFooterView(this.kmT);
        }
        AppMethodBeat.o(22208);
    }
}

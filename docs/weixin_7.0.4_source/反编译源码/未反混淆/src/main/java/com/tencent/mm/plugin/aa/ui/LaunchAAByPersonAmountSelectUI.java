package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String cuP;
    private ak fbD = new ak(Looper.getMainLooper());
    private com.tencent.mm.plugin.aa.a.c.c goe = ((com.tencent.mm.plugin.aa.a.c.c) Z(com.tencent.mm.plugin.aa.a.c.c.class));
    private ListView gof;
    private TextView gog;
    private TextView goh;
    private View goi;
    private TextView goj;
    private boolean gok = false;
    private Map<String, String> gol = new HashMap();
    private a gom = null;
    private double gon;
    private long goo = -1;
    private int goq = -1;
    private boolean gor;
    private boolean gos = false;
    private Runnable got = new Runnable() {
        public final void run() {
            AppMethodBeat.i(40786);
            LaunchAAByPersonAmountSelectUI.a(LaunchAAByPersonAmountSelectUI.this);
            LaunchAAByPersonAmountSelectUI.b(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.o(40786);
        }
    };

    class a extends BaseAdapter {
        List<b> dataList;

        class a {
            ImageView eks;
            c goA;
            TextView goa;
            WalletFormView gob;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(40803);
            b mQ = mQ(i);
            AppMethodBeat.o(40803);
            return mQ;
        }

        public a(List<String> list, Map<String, Double> map) {
            AppMethodBeat.i(40799);
            this.dataList = null;
            this.dataList = new ArrayList();
            for (String str : list) {
                b bVar = new b(LaunchAAByPersonAmountSelectUI.this, (byte) 0);
                bVar.username = str;
                if (map == null || !map.containsKey(str)) {
                    bVar.goB = "";
                } else {
                    bVar.goB = LaunchAAByPersonAmountSelectUI.this.getString(R.string.ao, new Object[]{map.get(str)});
                }
                this.dataList.add(bVar);
            }
            AppMethodBeat.o(40799);
        }

        public final int getCount() {
            AppMethodBeat.i(40800);
            int size = this.dataList.size();
            AppMethodBeat.o(40800);
            return size;
        }

        private b mQ(int i) {
            AppMethodBeat.i(40801);
            b bVar = (b) this.dataList.get(i);
            AppMethodBeat.o(40801);
            return bVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(40802);
            b mQ = mQ(i);
            if (!(mQ == null || bo.isNullOrNil(mQ.username))) {
                if (view == null) {
                    view = v.hu(LaunchAAByPersonAmountSelectUI.this).inflate(R.layout.a9f, viewGroup, false);
                    final a aVar = new a(this, (byte) 0);
                    aVar.eks = (ImageView) view.findViewById(R.id.bke);
                    aVar.goa = (TextView) view.findViewById(R.id.a0b);
                    aVar.gob = (WalletFormView) view.findViewById(R.id.co0);
                    aVar.goA = new c(mQ.username);
                    aVar.gob.a(aVar.goA);
                    aVar.eks.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(40797);
                            aVar.gob.f(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(40797);
                            return false;
                        }
                    });
                    aVar.goa.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(40798);
                            aVar.gob.f(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(40798);
                            return false;
                        }
                    });
                    view.setTag(aVar);
                    LaunchAAByPersonAmountSelectUI.this.a(aVar.gob, 2, false, true);
                }
                a aVar2 = (a) view.getTag();
                if (!bo.isNullOrNil(mQ.username)) {
                    aVar2.goA.username = mQ.username;
                    com.tencent.mm.pluginsdk.ui.a.b.b(aVar2.eks, mQ.username);
                    aVar2.goa.setText(j.b(LaunchAAByPersonAmountSelectUI.this.mController.ylL, ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(mQ.username, LaunchAAByPersonAmountSelectUI.this.cuP), aVar2.goa.getTextSize()));
                }
                if (!(mQ.goB == null || aVar2.gob.getText() == null || mQ.goB.equals(aVar2.gob.getText().toLowerCase()))) {
                    WalletFormView walletFormView = aVar2.gob;
                    c cVar = aVar2.goA;
                    if (walletFormView.Aih != null) {
                        walletFormView.Aih.removeTextChangedListener(cVar);
                    }
                    aVar2.gob.setText(mQ.goB);
                    aVar2.gob.a(aVar2.goA);
                }
            }
            AppMethodBeat.o(40802);
            return view;
        }
    }

    class b {
        String goB;
        String username;

        private b() {
            this.username = null;
            this.goB = null;
        }

        /* synthetic */ b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, byte b) {
            this();
        }
    }

    protected class c implements TextWatcher {
        String username;

        public c(String str) {
            this.username = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(40804);
            try {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                int lastIndexOf = obj.lastIndexOf(".");
                if (lastIndexOf != indexOf && lastIndexOf > 0 && length > lastIndexOf) {
                    editable.delete(lastIndexOf, length);
                }
            } catch (Exception e) {
            }
            if (bo.ac(editable) || bo.getDouble(editable.toString(), 0.0d) <= 0.0d) {
                LaunchAAByPersonAmountSelectUI.this.gol.remove(this.username);
            } else {
                LaunchAAByPersonAmountSelectUI.this.gol.put(this.username, editable.toString());
            }
            LaunchAAByPersonAmountSelectUI.this.fbD.removeCallbacks(LaunchAAByPersonAmountSelectUI.this.got);
            LaunchAAByPersonAmountSelectUI.this.fbD.postDelayed(LaunchAAByPersonAmountSelectUI.this.got, 50);
            AppMethodBeat.o(40804);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LaunchAAByPersonAmountSelectUI() {
        AppMethodBeat.i(40805);
        AppMethodBeat.o(40805);
    }

    static /* synthetic */ void a(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(40810);
        launchAAByPersonAmountSelectUI.aoC();
        AppMethodBeat.o(40810);
    }

    static /* synthetic */ void b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(40811);
        launchAAByPersonAmountSelectUI.aoD();
        AppMethodBeat.o(40811);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40806);
        super.onCreate(bundle);
        setMMTitle((int) R.string.clp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40789);
                if (LaunchAAByPersonAmountSelectUI.this.gol == null || LaunchAAByPersonAmountSelectUI.this.gol.size() <= 0) {
                    LaunchAAByPersonAmountSelectUI.this.finish();
                } else {
                    h.a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(R.string.bu), null, LaunchAAByPersonAmountSelectUI.this.getString(R.string.by), LaunchAAByPersonAmountSelectUI.this.getString(R.string.bx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(40787);
                            LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.o(40787);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(40788);
                            LaunchAAByPersonAmountSelectUI.this.finish();
                            AppMethodBeat.o(40788);
                        }
                    });
                }
                AppMethodBeat.o(40789);
                return true;
            }
        });
        a((int) d.MIC_PTU_MEISHI, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40790);
                if (LaunchAAByPersonAmountSelectUI.this.goq <= 0 || LaunchAAByPersonAmountSelectUI.this.gol == null || LaunchAAByPersonAmountSelectUI.this.gol.size() <= LaunchAAByPersonAmountSelectUI.this.goq) {
                    LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(3), Integer.valueOf(4));
                    AppMethodBeat.o(40790);
                } else {
                    h.b(LaunchAAByPersonAmountSelectUI.this.mController.ylL, LaunchAAByPersonAmountSelectUI.this.getString(R.string.clt, new Object[]{Integer.valueOf(LaunchAAByPersonAmountSelectUI.this.goq)}), "", true);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13722, Integer.valueOf(8));
                    AppMethodBeat.o(40790);
                }
                return true;
            }
        }, com.tencent.mm.ui.q.b.GREEN);
        this.gof = (ListView) findViewById(R.id.co2);
        this.gog = (TextView) findViewById(R.id.co4);
        this.goh = (TextView) findViewById(R.id.co5);
        this.goh.setText(getString(R.string.clo, new Object[]{Float.valueOf(0.0f)}));
        this.goi = findViewById(R.id.co3);
        this.goj = (TextView) findViewById(R.id.co6);
        this.gnR = this.gof;
        this.goi.setVisibility(8);
        this.gog.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(40792);
                if (LaunchAAByPersonAmountSelectUI.this.gok) {
                    if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                        LaunchAAByPersonAmountSelectUI.this.gog.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(R.color.hz));
                    } else if (LaunchAAByPersonAmountSelectUI.this.gok) {
                        LaunchAAByPersonAmountSelectUI.this.gog.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(R.color.hy));
                    } else {
                        LaunchAAByPersonAmountSelectUI.this.gog.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(R.color.hx));
                    }
                    AppMethodBeat.o(40792);
                    return false;
                }
                AppMethodBeat.o(40792);
                return true;
            }
        });
        this.gog.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40795);
                if (LaunchAAByPersonAmountSelectUI.this.gol != null && LaunchAAByPersonAmountSelectUI.this.gol.size() > 0) {
                    try {
                        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(LaunchAAByPersonAmountSelectUI.this);
                        aVar.PZ(R.string.ap);
                        aVar.Qc(R.string.s6).a(new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(40793);
                                LaunchAAByPersonAmountSelectUI.m(LaunchAAByPersonAmountSelectUI.this);
                                AppMethodBeat.o(40793);
                            }
                        });
                        aVar.Qd(R.string.or).b(new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(40794);
                                com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(3), Integer.valueOf(10));
                                AppMethodBeat.o(40794);
                            }
                        });
                        aVar.aMb().show();
                    } catch (Exception e) {
                        ab.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
                    }
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(3), Integer.valueOf(8));
                AppMethodBeat.o(40795);
            }
        });
        this.gok = true;
        this.gof.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(40796);
                if (i == 1) {
                    LaunchAAByPersonAmountSelectUI.this.aoB();
                }
                AppMethodBeat.o(40796);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.cuP = getIntent().getStringExtra("chatroom");
        this.goo = getIntent().getLongExtra("maxPerAmount", -1);
        this.goq = getIntent().getIntExtra("maxUserNumber", -1);
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("oldAmountData");
        ab.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", this.cuP, Long.valueOf(this.goo), stringArrayListExtra);
        this.gol = new HashMap();
        final HashMap hashMap = new HashMap();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = ((String) it.next()).split(",");
                        if (split != null && split.length == 2) {
                            hashMap.put(split[0], Double.valueOf(bo.getDouble(split[1], 0.0d)));
                            this.gol.put(split[0], getString(R.string.ao, new Object[]{Double.valueOf(r4)}));
                        }
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", e.getMessage());
            }
        }
        this.goe.aG(com.tencent.mm.plugin.aa.a.c.c.a.class);
        this.goe.a(com.tencent.mm.plugin.aa.a.c.c.a.class, (com.tencent.mm.vending.app.a.b) new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.aa.a.c.c.a>() {
            public final /* synthetic */ void bj(Object obj) {
                AppMethodBeat.i(40791);
                com.tencent.mm.plugin.aa.a.c.c.a aVar = (com.tencent.mm.plugin.aa.a.c.c.a) obj;
                String str = "MicroMsg.LaunchAAByPersonAmountSelectUI";
                String str2 = "get selectMembers: %s, list.size: %s";
                Object[] objArr = new Object[2];
                objArr[0] = aVar;
                objArr[1] = aVar != null ? Integer.valueOf(aVar.ewK.size()) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                ab.i(str, str2, objArr);
                LaunchAAByPersonAmountSelectUI.this.gof.addFooterView(v.hu(LaunchAAByPersonAmountSelectUI.this).inflate(R.layout.b, null), null, false);
                LaunchAAByPersonAmountSelectUI.this.gof.addHeaderView(v.hu(LaunchAAByPersonAmountSelectUI.this).inflate(R.layout.h, null), null, false);
                if (!(aVar == null || aVar.ewK == null || aVar.ewK.size() <= 0)) {
                    LaunchAAByPersonAmountSelectUI.this.gom = new a(aVar.ewK, hashMap);
                    LaunchAAByPersonAmountSelectUI.this.gof.setAdapter(LaunchAAByPersonAmountSelectUI.this.gom);
                }
                LaunchAAByPersonAmountSelectUI.this.goi.setVisibility(0);
                LaunchAAByPersonAmountSelectUI.this.fbD.post(LaunchAAByPersonAmountSelectUI.this.got);
                AppMethodBeat.o(40791);
            }
        });
        AppMethodBeat.o(40806);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void aoC() {
        AppMethodBeat.i(40807);
        try {
            String string;
            this.gon = 0.0d;
            this.gor = false;
            if (this.gol != null) {
                for (String string2 : this.gol.values()) {
                    double d = bo.getDouble(string2, 0.0d);
                    this.gon += d;
                    if (this.goo > 0 && d * 100.0d > ((double) this.goo)) {
                        this.gor = true;
                    }
                }
                if (this.gom != null) {
                    a aVar = this.gom;
                    Map map = this.gol;
                    for (b bVar : aVar.dataList) {
                        bVar.goB = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (b bVar2 : aVar.dataList) {
                            if (map.containsKey(bVar2.username)) {
                                bVar2.goB = (String) map.get(bVar2.username);
                            }
                        }
                    }
                }
            }
            this.goh.setText(getString(R.string.clo, new Object[]{Double.valueOf(this.gon)}));
            if (this.gol == null || this.gol.size() <= 0) {
                updateOptionMenuText(d.MIC_PTU_MEISHI, getString(R.string.s6));
            } else {
                updateOptionMenuText(d.MIC_PTU_MEISHI, getString(R.string.ax, new Object[]{Integer.valueOf(this.gol.size())}));
            }
            if (this.gor) {
                com.tencent.mm.plugin.report.service.h.pYm.e(13722, Integer.valueOf(7));
                enableOptionMenu(d.MIC_PTU_MEISHI, false);
                string2 = getString(R.string.cm1, new Object[]{Float.valueOf(((float) this.goo) / 100.0f)});
                if (!bo.isNullOrNil(string2)) {
                    this.goj.setText(string2);
                    if (!this.goj.isShown()) {
                        this.goj.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bh));
                        this.goj.setVisibility(0);
                    }
                }
                AppMethodBeat.o(40807);
                return;
            }
            enableOptionMenu(d.MIC_PTU_MEISHI, true);
            if (this.goj.isShown()) {
                this.goj.setText("");
                this.goj.startAnimation(AnimationUtils.loadAnimation(this, R.anim.c1));
                this.goj.setVisibility(8);
            }
            AppMethodBeat.o(40807);
        } catch (Exception e) {
            ab.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", e.getMessage());
            AppMethodBeat.o(40807);
        }
    }

    private void aoD() {
        AppMethodBeat.i(40808);
        if (this.gon > 0.0d) {
            this.gok = true;
            this.gog.setTextColor(getResources().getColor(R.color.hy));
            AppMethodBeat.o(40808);
            return;
        }
        this.gok = false;
        this.gog.setTextColor(getResources().getColor(R.color.hx));
        AppMethodBeat.o(40808);
    }

    public final int getLayoutId() {
        return R.layout.a9g;
    }

    public void onDestroy() {
        AppMethodBeat.i(40809);
        super.onDestroy();
        if (this.gol != null) {
            this.gol.clear();
        }
        AppMethodBeat.o(40809);
    }

    static /* synthetic */ void d(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(40812);
        launchAAByPersonAmountSelectUI.aoC();
        launchAAByPersonAmountSelectUI.aoD();
        if (!launchAAByPersonAmountSelectUI.gor) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAByPersonAmountSelectUI.gol.keySet()) {
                arrayList.add(str + "," + ((String) launchAAByPersonAmountSelectUI.gol.get(str)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
        AppMethodBeat.o(40812);
    }

    static /* synthetic */ void m(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.i(40813);
        try {
            launchAAByPersonAmountSelectUI.gog.setTextColor(launchAAByPersonAmountSelectUI.getResources().getColor(R.color.hx));
            launchAAByPersonAmountSelectUI.gok = false;
            launchAAByPersonAmountSelectUI.gon = 0.0d;
            launchAAByPersonAmountSelectUI.goh.setText(launchAAByPersonAmountSelectUI.getString(R.string.clo, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.gon)}));
            launchAAByPersonAmountSelectUI.gol.clear();
            launchAAByPersonAmountSelectUI.aoC();
            launchAAByPersonAmountSelectUI.aoD();
            if (launchAAByPersonAmountSelectUI.gom != null) {
                a aVar = launchAAByPersonAmountSelectUI.gom;
                for (b bVar : aVar.dataList) {
                    bVar.goB = "";
                }
                aVar.notifyDataSetChanged();
            }
        } catch (Exception e) {
            ab.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", e.getMessage());
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(3), Integer.valueOf(9));
        AppMethodBeat.o(40813);
    }
}

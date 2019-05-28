package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailAddrListUI extends MMActivity {
    private TextView gya = null;
    private p puD = null;
    private com.tencent.mm.ui.base.p pyj = null;
    private TextView pyk = null;
    private ListView pyl;
    private a pym;
    private List<o> pyn;
    private com.tencent.mm.plugin.qqmail.b.p.a pyo = new com.tencent.mm.plugin.qqmail.b.p.a() {
        public final void onComplete() {
            AppMethodBeat.i(68311);
            if (MailAddrListUI.this.pyj != null) {
                MailAddrListUI.this.pyj.dismiss();
            }
            MailAddrListUI.this.pyn = MailAddrListUI.this.puD.Vi(null);
            if (MailAddrListUI.this.pyn.size() == 0) {
                MailAddrListUI.this.gya.setText(R.string.e_t);
                MailAddrListUI.this.gya.setVisibility(0);
            }
            String[] stringArrayExtra = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
            for (String Vj : stringArrayExtra == null ? new String[]{""} : stringArrayExtra) {
                o Vj2 = p.Vj(Vj);
                if (Vj2 != null) {
                    int i;
                    for (o oVar : MailAddrListUI.this.pyn) {
                        if (oVar.nJq.equalsIgnoreCase(Vj2.nJq)) {
                            MailAddrListUI.this.pym.c(oVar);
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        MailAddrListUI.this.pym.c(Vj2);
                    }
                }
            }
            MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(R.string.dcx) + (MailAddrListUI.this.pym.cdf() > 0 ? "(" + MailAddrListUI.this.pym.cdf() + ")" : ""));
            MailAddrListUI.this.pym.notifyDataSetChanged();
            AppMethodBeat.o(68311);
        }
    };

    class a extends BaseAdapter {
        private final Context context;
        boolean pyq = false;
        boolean pyr = false;
        Map<String, o> pys = new HashMap();

        class a {
            CheckBox gnD;
            TextView gxi;
            TextView pyt;
            TextView pyu;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(68326);
            o Bu = Bu(i);
            AppMethodBeat.o(68326);
            return Bu;
        }

        public a(Context context) {
            AppMethodBeat.i(68318);
            this.context = context;
            AppMethodBeat.o(68318);
        }

        public final void c(o oVar) {
            AppMethodBeat.i(68319);
            this.pys.put(oVar.nJq, oVar);
            AppMethodBeat.o(68319);
        }

        public final int cdf() {
            AppMethodBeat.i(68320);
            int size = this.pys.size();
            AppMethodBeat.o(68320);
            return size;
        }

        private int Bt(int i) {
            if (this.pyr) {
                return i;
            }
            if (i == 0) {
                return 0;
            }
            return i - 1;
        }

        public final int getCount() {
            AppMethodBeat.i(68321);
            int size = MailAddrListUI.this.pyn.size();
            if (size == 0) {
                if (this.pyq) {
                    AppMethodBeat.o(68321);
                    return 1;
                }
                AppMethodBeat.o(68321);
                return 0;
            } else if (this.pyr) {
                AppMethodBeat.o(68321);
                return size;
            } else {
                size++;
                AppMethodBeat.o(68321);
                return size;
            }
        }

        private TextView getTitleTextView() {
            AppMethodBeat.i(68322);
            TextView textView = new TextView(this.context);
            textView.setBackgroundResource(R.drawable.a_r);
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            textView.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(R.dimen.kr));
            int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(R.dimen.l5);
            int dimensionPixelSize2 = MailAddrListUI.this.getResources().getDimensionPixelSize(R.dimen.nc);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            AppMethodBeat.o(68322);
            return textView;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            AppMethodBeat.i(68323);
            if (i == 0) {
                if (this.pyq) {
                    TextView titleTextView = getTitleTextView();
                    titleTextView.setText(R.string.dd6);
                    int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(R.dimen.l5);
                    titleTextView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    titleTextView.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(R.dimen.dt));
                    titleTextView.setGravity(17);
                    AppMethodBeat.o(68323);
                    return titleTextView;
                } else if (!this.pyr) {
                    view = getTitleTextView();
                    view.setText(R.string.dd5);
                    AppMethodBeat.o(68323);
                    return view;
                }
            }
            if (view == null || view.getTag() == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, R.layout.am4, null);
                aVar2.pyt = (TextView) view.findViewById(R.id.dr2);
                aVar2.gxi = (TextView) view.findViewById(R.id.dr4);
                aVar2.pyu = (TextView) view.findViewById(R.id.dr5);
                aVar2.gnD = (CheckBox) view.findViewById(R.id.dr6);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            o Bu = Bu(i);
            if (this.pyr || i <= 10) {
                aVar.pyt.setVisibility(8);
            } else {
                o Bu2 = Bu(i - 1);
                if (i == 11) {
                    Bu2 = null;
                }
                String d = d(Bu);
                String d2 = d(Bu2);
                if (d == null) {
                    aVar.pyt.setVisibility(8);
                } else if (d.equals(d2)) {
                    aVar.pyt.setVisibility(8);
                } else {
                    aVar.pyt.setText(d.toUpperCase());
                    aVar.pyt.setVisibility(0);
                }
            }
            aVar.gxi.setText(Bu.name);
            aVar.pyu.setText(Bu.nJq);
            CheckBox checkBox = aVar.gnD;
            if (this.pys.get(Bu.nJq) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            AppMethodBeat.o(68323);
            return view;
        }

        private static String d(o oVar) {
            AppMethodBeat.i(68324);
            if (oVar == null) {
                AppMethodBeat.o(68324);
                return null;
            }
            String Vd = com.tencent.mm.plugin.qqmail.b.a.Vd(oVar.puh);
            char charAt = Vd.length() > 1 ? Vd.charAt(0) : '~';
            String valueOf;
            switch (charAt) {
                case '{':
                    charAt = Vd.charAt(1);
                    if (bo.A(charAt)) {
                        valueOf = String.valueOf(charAt);
                        AppMethodBeat.o(68324);
                        return valueOf;
                    }
                    valueOf = "~";
                    AppMethodBeat.o(68324);
                    return valueOf;
                case '~':
                    valueOf = "~";
                    AppMethodBeat.o(68324);
                    return valueOf;
                default:
                    if (bo.z(charAt)) {
                        valueOf = String.valueOf(charAt);
                        AppMethodBeat.o(68324);
                        return valueOf;
                    }
                    valueOf = "~";
                    AppMethodBeat.o(68324);
                    return valueOf;
            }
        }

        public final o Bu(int i) {
            AppMethodBeat.i(68325);
            o oVar = (o) MailAddrListUI.this.pyn.get(Bt(i));
            AppMethodBeat.o(68325);
            return oVar;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            if (i == 0) {
                return this.pyr;
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MailAddrListUI() {
        AppMethodBeat.i(68327);
        AppMethodBeat.o(68327);
    }

    public final int getLayoutId() {
        return R.layout.am3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68328);
        super.onCreate(bundle);
        setMMTitle((int) R.string.dcx);
        this.pyn = new ArrayList();
        this.puD = ac.ccC().puD;
        initView();
        this.puD.a(this.pyo);
        this.puD.ccq();
        AppMethodBeat.o(68328);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.i(68329);
        this.pyl = (ListView) findViewById(R.id.dr0);
        this.gya = (TextView) findViewById(R.id.cj4);
        this.pyk = (TextView) findViewById(R.id.dr1);
        this.pym = new a(this);
        com.tencent.mm.ui.tools.o oVar = new com.tencent.mm.ui.tools.o((byte) 0);
        oVar.zHa = new b() {
            public final void apq() {
            }

            public final void apr() {
            }

            public final boolean vN(String str) {
                return false;
            }

            public final void vO(String str) {
                AppMethodBeat.i(68312);
                String bc = bo.bc(str, "");
                MailAddrListUI.this.pyn = MailAddrListUI.this.puD.Vi(bc.toLowerCase().trim());
                if (bc.length() > 0) {
                    MailAddrListUI.this.pym.pyr = true;
                } else {
                    MailAddrListUI.this.pym.pyr = false;
                }
                MailAddrListUI.this.pym.pyq = false;
                if (MailAddrListUI.this.pyn.size() == 0) {
                    MailAddrListUI.this.enableOptionMenu(false);
                    MailAddrListUI.this.pyk.setVisibility(0);
                } else {
                    MailAddrListUI.this.enableOptionMenu(true);
                    MailAddrListUI.this.pyk.setVisibility(8);
                }
                MailAddrListUI.this.pym.notifyDataSetChanged();
                AppMethodBeat.o(68312);
            }

            public final void apo() {
            }

            public final void app() {
            }
        };
        a(oVar);
        this.pyl.setAdapter(this.pym);
        this.pyl.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(68313);
                a e = MailAddrListUI.this.pym;
                o Bu = e.Bu(i - MailAddrListUI.this.pyl.getHeaderViewsCount());
                String str = Bu.nJq;
                if (e.pys.containsKey(str)) {
                    e.pys.remove(str);
                } else {
                    e.pys.put(str, Bu);
                }
                e.notifyDataSetChanged();
                MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(R.string.dcx) + (MailAddrListUI.this.pym.cdf() > 0 ? "(" + MailAddrListUI.this.pym.cdf() + ")" : ""));
                AppMethodBeat.o(68313);
            }
        });
        this.pyl.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(68314);
                if (1 == i) {
                    MailAddrListUI.this.aqX();
                }
                AppMethodBeat.o(68314);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.pyn = this.puD.Vi(null);
        this.pym.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68315);
                MailAddrListUI.this.setResult(0);
                MailAddrListUI.this.finish();
                AppMethodBeat.o(68315);
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68316);
                c.a(MailAddrListUI.this.pyl);
                AppMethodBeat.o(68316);
            }
        };
        addTextOptionMenu(0, getString(R.string.dcw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68317);
                a e = MailAddrListUI.this.pym;
                ArrayList arrayList = new ArrayList();
                for (String str : e.pys.keySet()) {
                    arrayList.add(e.pys.get(str));
                }
                ComposeUI.cH(arrayList);
                MailAddrListUI.this.setResult(-1);
                MailAddrListUI.this.finish();
                AppMethodBeat.o(68317);
                return true;
            }
        });
        if (this.pyn.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        enableOptionMenu(z);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.pyj = h.b(context, getString(R.string.dcv), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(68329);
    }

    public void onPause() {
        AppMethodBeat.i(68330);
        super.onPause();
        AppMethodBeat.o(68330);
    }

    public void onResume() {
        AppMethodBeat.i(68331);
        super.onResume();
        this.pym.notifyDataSetChanged();
        AppMethodBeat.o(68331);
    }

    public void onDestroy() {
        AppMethodBeat.i(68332);
        super.onDestroy();
        this.puD.b(this.pyo);
        AppMethodBeat.o(68332);
    }
}

package com.tencent.mm.plugin.scanner.history.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.p;

public class ScannerHistoryUI extends MMActivity {
    private View Ek;
    private LinearLayout knA;
    private View knB;
    private TextView knC;
    private ListView mListView;
    private a pZf;

    class a extends p<com.tencent.mm.plugin.scanner.history.a.a> {
        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(80811);
            com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) obj;
            if (aVar == null) {
                aVar = new com.tencent.mm.plugin.scanner.history.a.a();
            }
            aVar.d(cursor);
            AppMethodBeat.o(80811);
            return aVar;
        }

        public a() {
            super(ScannerHistoryUI.this, new com.tencent.mm.plugin.scanner.history.a.a());
            AppMethodBeat.i(80807);
            pN(true);
            AppMethodBeat.o(80807);
        }

        public final void KC() {
            AppMethodBeat.i(80808);
            setCursor(e.cgy().cgC().baR());
            notifyDataSetChanged();
            AppMethodBeat.o(80808);
        }

        public final void KD() {
            AppMethodBeat.i(80809);
            bIf();
            KC();
            AppMethodBeat.o(80809);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(80810);
            com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) getItem(i);
            if (view == null) {
                view = View.inflate(ScannerHistoryUI.this.mController.ylL, R.layout.apa, null);
                b bVar2 = new b(ScannerHistoryUI.this, (byte) 0);
                bVar2.iNr = (ImageView) view.findViewById(R.id.be7);
                bVar2.kne = (TextView) view.findViewById(R.id.bgm);
                bVar2.knf = (TextView) view.findViewById(R.id.bue);
                bVar2.kng = (TextView) view.findViewById(R.id.de5);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.plugin.scanner.util.o.a cV = j.cV(aVar.field_xmlContent, aVar.field_funcType);
            bVar.kne.setText(cV.field_title);
            bVar.knf.setText(h.c(ScannerHistoryUI.this, aVar.field_ScanTime, true));
            bVar.kng.setText(cV.field_subtitle);
            int dimensionPixelSize = ScannerHistoryUI.this.getResources().getDimensionPixelSize(R.dimen.a7s);
            bVar.iNr.setImageResource(R.drawable.beo);
            ab.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + i + " logo_url :  " + cV.field_thumburl);
            if (TextUtils.isEmpty(cV.field_thumburl)) {
                bVar.iNr.setImageResource(R.drawable.beo);
            } else {
                String format;
                com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePK = com.tencent.mm.compatible.util.e.eSn;
                o.ahq();
                aVar2.ePY = null;
                e cgy = e.cgy();
                String str = cV.field_thumburl;
                if (g.RK()) {
                    format = String.format("%s/scanbook_%s", new Object[]{cgy.eJM + "image/scan/img", com.tencent.mm.a.g.x(str.getBytes())});
                } else {
                    format = "";
                }
                aVar2.ePJ = format;
                aVar2.ePH = true;
                aVar2.eQf = false;
                aVar2.ePF = true;
                aVar2.ePO = dimensionPixelSize;
                aVar2.ePN = dimensionPixelSize;
                aVar2.ePT = R.drawable.beo;
                o.ahp().a(cV.field_thumburl, bVar.iNr, aVar2.ahG());
            }
            AppMethodBeat.o(80810);
            return view;
        }
    }

    class b {
        ImageView iNr;
        TextView kne;
        TextView knf;
        TextView kng;

        private b() {
        }

        /* synthetic */ b(ScannerHistoryUI scannerHistoryUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(ScannerHistoryUI scannerHistoryUI) {
        AppMethodBeat.i(80820);
        scannerHistoryUI.bbB();
        AppMethodBeat.o(80820);
    }

    public final int getLayoutId() {
        return R.layout.apd;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80812);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(80812);
    }

    public void onResume() {
        AppMethodBeat.i(80813);
        super.onResume();
        AppMethodBeat.o(80813);
    }

    public void onDestroy() {
        AppMethodBeat.i(80814);
        super.onDestroy();
        AppMethodBeat.o(80814);
    }

    public final void initView() {
        AppMethodBeat.i(80815);
        setMMTitle((int) R.string.dxt);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(80800);
                ScannerHistoryUI.this.finish();
                AppMethodBeat.o(80800);
                return true;
            }
        });
        this.mListView = (ListView) findViewById(R.id.e55);
        this.knA = (LinearLayout) View.inflate(getBaseContext(), R.layout.apc, null);
        this.mListView.addHeaderView(this.knA);
        this.pZf = new a();
        this.mListView.setAdapter(this.pZf);
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(80801);
                if (i == 0) {
                    ab.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
                    AppMethodBeat.o(80801);
                    return;
                }
                if (i > 0) {
                    i--;
                }
                ScannerHistoryUI.a(ScannerHistoryUI.this, i);
                AppMethodBeat.o(80801);
            }
        });
        this.mListView.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(80802);
                if (i == 0) {
                    ab.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
                    AppMethodBeat.o(80802);
                } else {
                    if (i > 0) {
                        i--;
                    }
                    if (i >= ScannerHistoryUI.this.pZf.getCount()) {
                        AppMethodBeat.o(80802);
                    } else {
                        ScannerHistoryUI.b(ScannerHistoryUI.this, i);
                        AppMethodBeat.o(80802);
                    }
                }
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.acz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(80803);
                ScannerHistoryUI.b(ScannerHistoryUI.this);
                AppMethodBeat.o(80803);
                return true;
            }
        });
        this.Ek = findViewById(R.id.a_b);
        this.knB = View.inflate(this, R.layout.apb, null);
        if (this.knA != null) {
            this.knA.addView(this.knB);
        }
        this.knC = (TextView) this.knB.findViewById(R.id.e54);
        this.knC.setText(R.string.cbz);
        bbB();
        AppMethodBeat.o(80815);
    }

    private void bbB() {
        AppMethodBeat.i(80816);
        if (e.cgy().cgC().getCount() > 0) {
            this.mListView.setVisibility(0);
            this.Ek.setVisibility(8);
            this.knB.setVisibility(0);
            enableOptionMenu(true);
        } else {
            this.mListView.setVisibility(8);
            this.Ek.setVisibility(0);
            this.knB.setVisibility(8);
            enableOptionMenu(false);
        }
        this.pZf.notifyDataSetChanged();
        AppMethodBeat.o(80816);
    }

    static /* synthetic */ void a(ScannerHistoryUI scannerHistoryUI, int i) {
        AppMethodBeat.i(80817);
        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) scannerHistoryUI.pZf.getItem(i);
        if (aVar != null) {
            Intent intent = new Intent();
            intent.setClass(scannerHistoryUI, ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", aVar.field_xmlContent);
            intent.putExtra("key_Product_funcType", aVar.field_funcType);
            intent.putExtra("key_Qrcode_Url", aVar.field_qrcodeUrl);
            intent.putExtra("key_need_add_to_history", false);
            scannerHistoryUI.startActivity(intent);
            com.tencent.mm.plugin.report.service.h.pYm.e(12684, Integer.valueOf(0), Integer.valueOf(1));
        }
        AppMethodBeat.o(80817);
    }

    static /* synthetic */ void b(ScannerHistoryUI scannerHistoryUI, final int i) {
        AppMethodBeat.i(80818);
        com.tencent.mm.ui.base.h.a((Context) scannerHistoryUI, scannerHistoryUI.getResources().getString(R.string.ag7), null, scannerHistoryUI.getResources().getString(R.string.p4), new c() {
            public final void iE(int i) {
                AppMethodBeat.i(80804);
                switch (i) {
                    case 0:
                        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) ScannerHistoryUI.this.pZf.getItem(i);
                        if (aVar != null) {
                            e.cgy().cgC().a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
                            ScannerHistoryUI.c(ScannerHistoryUI.this);
                            ScannerHistoryUI.this.pZf.a(null, null);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(80804);
            }
        });
        AppMethodBeat.o(80818);
    }

    static /* synthetic */ void b(ScannerHistoryUI scannerHistoryUI) {
        AppMethodBeat.i(80819);
        com.tencent.mm.ui.base.h.a((Context) scannerHistoryUI, true, scannerHistoryUI.getString(R.string.dxs), "", scannerHistoryUI.getString(R.string.s6), scannerHistoryUI.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(80805);
                dialogInterface.dismiss();
                e.cgy().cgC().bSd.hY("ScanHistoryItem", "delete from ScanHistoryItem");
                ScannerHistoryUI.c(ScannerHistoryUI.this);
                ScannerHistoryUI.this.pZf.a(null, null);
                AppMethodBeat.o(80805);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(80806);
                dialogInterface.dismiss();
                AppMethodBeat.o(80806);
            }
        });
        AppMethodBeat.o(80819);
    }
}

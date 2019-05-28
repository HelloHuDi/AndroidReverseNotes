package com.tencent.p177mm.plugin.scanner.history.p1291ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.history.p503a.C3755a;
import com.tencent.p177mm.plugin.scanner.p504ui.ProductUI;
import com.tencent.p177mm.plugin.scanner.p740a.C43486j;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI */
public class ScannerHistoryUI extends MMActivity {
    /* renamed from: Ek */
    private View f13700Ek;
    private LinearLayout knA;
    private View knB;
    private TextView knC;
    private ListView mListView;
    private C28894a pZf;

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$3 */
    class C216853 implements OnItemLongClickListener {
        C216853() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(80802);
            if (i == 0) {
                C4990ab.m7416i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
                AppMethodBeat.m2505o(80802);
            } else {
                if (i > 0) {
                    i--;
                }
                if (i >= ScannerHistoryUI.this.pZf.getCount()) {
                    AppMethodBeat.m2505o(80802);
                } else {
                    ScannerHistoryUI.m45920b(ScannerHistoryUI.this, i);
                    AppMethodBeat.m2505o(80802);
                }
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$4 */
    class C216864 implements OnMenuItemClickListener {
        C216864() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(80803);
            ScannerHistoryUI.m45919b(ScannerHistoryUI.this);
            AppMethodBeat.m2505o(80803);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$7 */
    class C216887 implements OnClickListener {
        C216887() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80806);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(80806);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$a */
    class C28894a extends C46692p<C3755a> {
        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(80811);
            C3755a c3755a = (C3755a) obj;
            if (c3755a == null) {
                c3755a = new C3755a();
            }
            c3755a.mo8995d(cursor);
            AppMethodBeat.m2505o(80811);
            return c3755a;
        }

        public C28894a() {
            super(ScannerHistoryUI.this, new C3755a());
            AppMethodBeat.m2504i(80807);
            mo74996pN(true);
            AppMethodBeat.m2505o(80807);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(80808);
            setCursor(C43488e.cgy().cgC().baR());
            notifyDataSetChanged();
            AppMethodBeat.m2505o(80808);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(80809);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(80809);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C28895b c28895b;
            AppMethodBeat.m2504i(80810);
            C3755a c3755a = (C3755a) getItem(i);
            if (view == null) {
                view = View.inflate(ScannerHistoryUI.this.mController.ylL, 2130970542, null);
                C28895b c28895b2 = new C28895b(ScannerHistoryUI.this, (byte) 0);
                c28895b2.iNr = (ImageView) view.findViewById(2131823474);
                c28895b2.kne = (TextView) view.findViewById(2131823564);
                c28895b2.knf = (TextView) view.findViewById(2131824074);
                c28895b2.kng = (TextView) view.findViewById(2131826209);
                view.setTag(c28895b2);
                c28895b = c28895b2;
            } else {
                c28895b = (C28895b) view.getTag();
            }
            C13185a cV = C43486j.m77691cV(c3755a.field_xmlContent, c3755a.field_funcType);
            c28895b.kne.setText(cV.field_title);
            c28895b.knf.setText(C14835h.m23089c(ScannerHistoryUI.this, c3755a.field_ScanTime, true));
            c28895b.kng.setText(cV.field_subtitle);
            int dimensionPixelSize = ScannerHistoryUI.this.getResources().getDimensionPixelSize(C25738R.dimen.a7s);
            c28895b.iNr.setImageResource(C25738R.drawable.beo);
            C4990ab.m7410d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + i + " logo_url :  " + cV.field_thumburl);
            if (TextUtils.isEmpty(cV.field_thumburl)) {
                c28895b.iNr.setImageResource(C25738R.drawable.beo);
            } else {
                String format;
                C17927a c17927a = new C17927a();
                c17927a.ePK = C6457e.eSn;
                C32291o.ahq();
                c17927a.ePY = null;
                C43488e cgy = C43488e.cgy();
                String str = cV.field_thumburl;
                if (C1720g.m3531RK()) {
                    format = String.format("%s/scanbook_%s", new Object[]{cgy.eJM + "image/scan/img", C1178g.m2591x(str.getBytes())});
                } else {
                    format = "";
                }
                c17927a.ePJ = format;
                c17927a.ePH = true;
                c17927a.eQf = false;
                c17927a.ePF = true;
                c17927a.ePO = dimensionPixelSize;
                c17927a.ePN = dimensionPixelSize;
                c17927a.ePT = C25738R.drawable.beo;
                C32291o.ahp().mo43766a(cV.field_thumburl, c28895b.iNr, c17927a.ahG());
            }
            AppMethodBeat.m2505o(80810);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$b */
    class C28895b {
        ImageView iNr;
        TextView kne;
        TextView knf;
        TextView kng;

        private C28895b() {
        }

        /* synthetic */ C28895b(ScannerHistoryUI scannerHistoryUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$6 */
    class C288966 implements OnClickListener {
        C288966() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(80805);
            dialogInterface.dismiss();
            C43488e.cgy().cgC().bSd.mo10108hY("ScanHistoryItem", "delete from ScanHistoryItem");
            ScannerHistoryUI.m45921c(ScannerHistoryUI.this);
            ScannerHistoryUI.this.pZf.mo5248a(null, null);
            AppMethodBeat.m2505o(80805);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$1 */
    class C288971 implements OnMenuItemClickListener {
        C288971() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(80800);
            ScannerHistoryUI.this.finish();
            AppMethodBeat.m2505o(80800);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI$2 */
    class C288982 implements OnItemClickListener {
        C288982() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(80801);
            if (i == 0) {
                C4990ab.m7418v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
                AppMethodBeat.m2505o(80801);
                return;
            }
            if (i > 0) {
                i--;
            }
            ScannerHistoryUI.m45918a(ScannerHistoryUI.this, i);
            AppMethodBeat.m2505o(80801);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m45921c(ScannerHistoryUI scannerHistoryUI) {
        AppMethodBeat.m2504i(80820);
        scannerHistoryUI.bbB();
        AppMethodBeat.m2505o(80820);
    }

    public final int getLayoutId() {
        return 2130970545;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(80812);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(80812);
    }

    public void onResume() {
        AppMethodBeat.m2504i(80813);
        super.onResume();
        AppMethodBeat.m2505o(80813);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(80814);
        super.onDestroy();
        AppMethodBeat.m2505o(80814);
    }

    public final void initView() {
        AppMethodBeat.m2504i(80815);
        setMMTitle((int) C25738R.string.dxt);
        setBackBtn(new C288971());
        this.mListView = (ListView) findViewById(2131827208);
        this.knA = (LinearLayout) View.inflate(getBaseContext(), 2130970544, null);
        this.mListView.addHeaderView(this.knA);
        this.pZf = new C28894a();
        this.mListView.setAdapter(this.pZf);
        this.mListView.setOnItemClickListener(new C288982());
        this.mListView.setOnItemLongClickListener(new C216853());
        addTextOptionMenu(0, getString(C25738R.string.acz), new C216864());
        this.f13700Ek = findViewById(2131821926);
        this.knB = View.inflate(this, 2130970543, null);
        if (this.knA != null) {
            this.knA.addView(this.knB);
        }
        this.knC = (TextView) this.knB.findViewById(2131827207);
        this.knC.setText(C25738R.string.cbz);
        bbB();
        AppMethodBeat.m2505o(80815);
    }

    private void bbB() {
        AppMethodBeat.m2504i(80816);
        if (C43488e.cgy().cgC().getCount() > 0) {
            this.mListView.setVisibility(0);
            this.f13700Ek.setVisibility(8);
            this.knB.setVisibility(0);
            enableOptionMenu(true);
        } else {
            this.mListView.setVisibility(8);
            this.f13700Ek.setVisibility(0);
            this.knB.setVisibility(8);
            enableOptionMenu(false);
        }
        this.pZf.notifyDataSetChanged();
        AppMethodBeat.m2505o(80816);
    }

    /* renamed from: a */
    static /* synthetic */ void m45918a(ScannerHistoryUI scannerHistoryUI, int i) {
        AppMethodBeat.m2504i(80817);
        C3755a c3755a = (C3755a) scannerHistoryUI.pZf.getItem(i);
        if (c3755a != null) {
            Intent intent = new Intent();
            intent.setClass(scannerHistoryUI, ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", c3755a.field_xmlContent);
            intent.putExtra("key_Product_funcType", c3755a.field_funcType);
            intent.putExtra("key_Qrcode_Url", c3755a.field_qrcodeUrl);
            intent.putExtra("key_need_add_to_history", false);
            scannerHistoryUI.startActivity(intent);
            C7060h.pYm.mo8381e(12684, Integer.valueOf(0), Integer.valueOf(1));
        }
        AppMethodBeat.m2505o(80817);
    }

    /* renamed from: b */
    static /* synthetic */ void m45920b(ScannerHistoryUI scannerHistoryUI, final int i) {
        AppMethodBeat.m2504i(80818);
        C30379h.m48422a((Context) scannerHistoryUI, scannerHistoryUI.getResources().getString(C25738R.string.ag7), null, scannerHistoryUI.getResources().getString(C25738R.string.f9088p4), new C30391c() {
            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(80804);
                switch (i) {
                    case 0:
                        C3755a c3755a = (C3755a) ScannerHistoryUI.this.pZf.getItem(i);
                        if (c3755a != null) {
                            C43488e.cgy().cgC().mo16760a((C4925c) c3755a, new String[0]);
                            ScannerHistoryUI.m45921c(ScannerHistoryUI.this);
                            ScannerHistoryUI.this.pZf.mo5248a(null, null);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(80804);
            }
        });
        AppMethodBeat.m2505o(80818);
    }

    /* renamed from: b */
    static /* synthetic */ void m45919b(ScannerHistoryUI scannerHistoryUI) {
        AppMethodBeat.m2504i(80819);
        C30379h.m48453a((Context) scannerHistoryUI, true, scannerHistoryUI.getString(C25738R.string.dxs), "", scannerHistoryUI.getString(C25738R.string.f9187s6), scannerHistoryUI.getString(C25738R.string.f9076or), new C288966(), new C216887());
        AppMethodBeat.m2505o(80819);
    }
}

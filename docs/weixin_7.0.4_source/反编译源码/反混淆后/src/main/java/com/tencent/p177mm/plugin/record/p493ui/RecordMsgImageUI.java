package com.tencent.p177mm.plugin.record.p493ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30744c;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.record.p492b.C43434l;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI */
public class RecordMsgImageUI extends MMActivity implements C43427d {
    private long cvx = -1;
    private List<aar> elG = new LinkedList();
    private C46696j icA;
    private MMGestureGallery kkn;
    private C5279d lcJ = new C348019();
    private Runnable mhD = new C347992();
    private Map<String, C18346nr> mim = new HashMap();
    private C4884c mip = new C348003();
    private C43434l pKH;
    private C3704a pKO;
    private String pKP = null;
    private int selection = 0;

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$4 */
    class C37004 implements C30745f {
        C37004() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(24298);
            RecordMsgImageUI.this.finish();
            AppMethodBeat.m2505o(24298);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$5 */
    class C37015 implements C30744c {
        C37015() {
        }

        public final void bvE() {
            AppMethodBeat.m2504i(24299);
            C32800b y = C37922v.m64076Zp().mo60676y("basescanui@datacenter", true);
            y.mo53356j("key_basescanui_screen_x", Integer.valueOf(RecordMsgImageUI.this.kkn.getXDown()));
            y.mo53356j("key_basescanui_screen_y", Integer.valueOf(RecordMsgImageUI.this.kkn.getYDown()));
            RecordMsgImageUI.m67653e(RecordMsgImageUI.this);
            AppMethodBeat.m2505o(24299);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$6 */
    class C37026 implements OnMenuItemClickListener {
        C37026() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24300);
            RecordMsgImageUI.this.finish();
            AppMethodBeat.m2505o(24300);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$a */
    static class C3704a extends BaseAdapter {
        long cvx;
        List<aar> elG;
        C43434l pKH;

        private C3704a() {
            AppMethodBeat.m2504i(24307);
            this.elG = new LinkedList();
            this.cvx = -1;
            AppMethodBeat.m2505o(24307);
        }

        /* synthetic */ C3704a(byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(24311);
            aar BI = mo8323BI(i);
            AppMethodBeat.m2505o(24311);
            return BI;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(24308);
            int size = this.elG.size();
            AppMethodBeat.m2505o(24308);
            return size;
        }

        /* renamed from: BI */
        public final aar mo8323BI(int i) {
            AppMethodBeat.m2504i(24309);
            aar aar = (aar) this.elG.get(i);
            AppMethodBeat.m2505o(24309);
            return aar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(24310);
            C43434l c43434l = this.pKH;
            aar BI = mo8323BI(i);
            long j = this.cvx;
            Bitmap a = c43434l.mo68990a(BI, j, false);
            if (a == null) {
                C4990ab.m7411d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(c43434l.mo68992a(BI, j)));
                C43436n.m77557b(BI, j, r0);
            }
            if (a == null) {
                C4990ab.m7420w("MicroMsg.ShowImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), 2130970678, null);
                }
                ((ImageView) view.findViewById(2131822184)).setImageResource(C1318a.download_image_icon);
                view.setLayoutParams(new LayoutParams(-1, -1));
                AppMethodBeat.m2505o(24310);
            } else {
                Context context = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context, a.getWidth(), a.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.mo71980bW(a.getWidth(), a.getHeight());
                }
                C46616n.m88171w(view, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                view.setMaxZoomDoubleTab(true);
                AppMethodBeat.m2505o(24310);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$8 */
    class C130158 implements OnCancelListener {
        C130158() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(24302);
            RecordMsgImageUI.this.icA = null;
            AppMethodBeat.m2505o(24302);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$1 */
    class C347981 implements OnItemSelectedListener {
        C347981() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(24294);
            if (C43436n.m77560d(RecordMsgImageUI.this.pKO.mo8323BI(i), RecordMsgImageUI.this.cvx)) {
                RecordMsgImageUI.this.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(RecordMsgImageUI.this.elG.size())}));
                RecordMsgImageUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(24294);
                return;
            }
            RecordMsgImageUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(24294);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$2 */
    class C347992 implements Runnable {
        C347992() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24295);
            RecordMsgImageUI.this.pKO.notifyDataSetChanged();
            AppMethodBeat.m2505o(24295);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$3 */
    class C348003 extends C4884c<C18346nr> {
        C348003() {
            AppMethodBeat.m2504i(24296);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(24296);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24297);
            C18346nr c18346nr = (C18346nr) c4883b;
            RecordMsgImageUI.this.mim.put(c18346nr.cJX.filePath, c18346nr);
            if (RecordMsgImageUI.this.icA != null && RecordMsgImageUI.this.icA.rBk.isShowing()) {
                RecordMsgImageUI.m67653e(RecordMsgImageUI.this);
            }
            AppMethodBeat.m2505o(24297);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgImageUI$9 */
    class C348019 implements C5279d {
        C348019() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(24303);
            switch (menuItem.getItemId()) {
                case 0:
                    RecordMsgImageUI.m67655g(RecordMsgImageUI.this);
                    AppMethodBeat.m2505o(24303);
                    return;
                case 1:
                    RecordMsgImageUI recordMsgImageUI = RecordMsgImageUI.this;
                    C45316cl c45316cl = new C45316cl();
                    C40443e.m69368a(c45316cl, recordMsgImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), recordMsgImageUI.ceS());
                    c45316cl.cvA.cvH = 10;
                    c45316cl.cvA.activity = recordMsgImageUI;
                    C4879a.xxA.mo10055m(c45316cl);
                    AppMethodBeat.m2505o(24303);
                    return;
                case 2:
                    RecordMsgImageUI.m67656h(RecordMsgImageUI.this);
                    AppMethodBeat.m2505o(24303);
                    return;
                case 3:
                    String i2 = RecordMsgImageUI.m67657i(RecordMsgImageUI.this);
                    if (!C5046bo.isNullOrNil(i2)) {
                        C18346nr c18346nr = (C18346nr) RecordMsgImageUI.this.mim.get(i2);
                        if (c18346nr != null) {
                            C26102cf c26102cf = new C26102cf();
                            c26102cf.cvm.activity = RecordMsgImageUI.this;
                            c26102cf.cvm.ctB = c18346nr.cJX.result;
                            c26102cf.cvm.cvn = c18346nr.cJX.cvn;
                            c26102cf.cvm.cvp = 8;
                            RecordMsgImageUI.m67649a(RecordMsgImageUI.this, c26102cf);
                            c26102cf.cvm.cvo = c18346nr.cJX.cvo;
                            if (RecordMsgImageUI.this.getIntent() != null) {
                                c26102cf.cvm.cvs = RecordMsgImageUI.this.getIntent().getBundleExtra("_stat_obj");
                            }
                            C4879a.xxA.mo10055m(c26102cf);
                            break;
                        }
                    }
                    AppMethodBeat.m2505o(24303);
                    return;
                    break;
            }
            AppMethodBeat.m2505o(24303);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RecordMsgImageUI() {
        AppMethodBeat.m2504i(24312);
        AppMethodBeat.m2505o(24312);
    }

    /* renamed from: i */
    static /* synthetic */ String m67657i(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.m2504i(24322);
        String ceS = recordMsgImageUI.ceS();
        AppMethodBeat.m2505o(24322);
        return ceS;
    }

    public final int getLayoutId() {
        return 2130970677;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24313);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.pKH = new C43434l();
        this.cvx = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        C44099c VI = C43436n.m77547VI(getIntent().getStringExtra("record_xml"));
        if (VI == null) {
            C4990ab.m7420w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            AppMethodBeat.m2505o(24313);
            return;
        }
        Iterator it = VI.fjr.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.dataType == 2) {
                this.elG.add(aar);
                if (aar.mnd.equals(stringExtra)) {
                    this.selection = this.elG.size() - 1;
                }
            }
        }
        if (this.elG.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            AppMethodBeat.m2505o(24313);
            return;
        }
        this.kkn = (MMGestureGallery) findViewById(2131822081);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.pKO = new C3704a();
        this.pKO.elG = this.elG;
        this.pKO.cvx = this.cvx;
        this.pKO.pKH = this.pKH;
        this.kkn.setAdapter(this.pKO);
        this.kkn.setSelection(this.selection);
        this.kkn.setOnItemSelectedListener(new C347981());
        this.kkn.setSingleClickOverListener(new C37004());
        this.kkn.setLongClickOverListener(new C37015());
        fullScreenNoTitleBar(true);
        setBackBtn(new C37026());
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37080a((C43427d) this);
        C4879a.xxA.mo10052c(this.mip);
        AppMethodBeat.m2505o(24313);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24314);
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37083b((C43427d) this);
        this.pKH.destory();
        C4879a.xxA.mo10053d(this.mip);
        super.onDestroy();
        AppMethodBeat.m2505o(24314);
    }

    /* Access modifiers changed, original: final */
    public final String ceS() {
        AppMethodBeat.m2504i(24315);
        int selectedItemPosition = this.kkn.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            C4990ab.m7420w("MicroMsg.ShowImageUI", "error position");
            AppMethodBeat.m2505o(24315);
            return null;
        }
        C4990ab.m7411d("MicroMsg.ShowImageUI", "cur pos %d path %s", Integer.valueOf(selectedItemPosition), C43436n.m77558c(this.pKO.mo8323BI(selectedItemPosition), this.cvx));
        AppMethodBeat.m2505o(24315);
        return C43436n.m77558c(this.pKO.mo8323BI(selectedItemPosition), this.cvx);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(24316);
        C5222ae.m7946h(C5222ae.m7934a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.m2505o(24316);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(24317);
        if (1001 == i && -1 == i2) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (C5046bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.m2505o(24317);
                return;
            }
            final ArrayList P = C5046bo.m7508P(stringExtra.split(","));
            if (C5046bo.m7548ek(P)) {
                C4990ab.m7420w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                AppMethodBeat.m2505o(24317);
                return;
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            final C1301310 c1301310 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24304);
                    b.dismiss();
                    AppMethodBeat.m2505o(24304);
                }
            };
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24305);
                    for (String str : P) {
                        C12519g.bOk().mo46457a(RecordMsgImageUI.this.mController.ylL, str, RecordMsgImageUI.this.pKP, 0, "", "");
                        C12519g.bOk().mo46461eZ(stringExtra2, str);
                    }
                    C5004al.m7441d(c1301310);
                    AppMethodBeat.m2505o(24305);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(24306);
                    String str = super.toString() + "|onActivityResult";
                    AppMethodBeat.m2505o(24306);
                    return str;
                }
            });
            AppMethodBeat.m2505o(24317);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(24317);
    }

    /* renamed from: a */
    public final void mo25051a(int i, C34792i c34792i) {
        AppMethodBeat.m2504i(24318);
        for (aar aar : this.elG) {
            if (aar.mnd.equals(c34792i.field_dataId)) {
                C5004al.m7441d(this.mhD);
                AppMethodBeat.m2505o(24318);
                return;
            }
        }
        AppMethodBeat.m2505o(24318);
    }

    /* renamed from: e */
    static /* synthetic */ void m67653e(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.m2504i(24319);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList2.add(recordMsgImageUI.getString(C25738R.string.dr8));
        arrayList.add(Integer.valueOf(1));
        arrayList2.add(recordMsgImageUI.getString(C25738R.string.dcq));
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(recordMsgImageUI.getString(C25738R.string.dwz));
        String ceS = recordMsgImageUI.ceS();
        C18346nr c18346nr = (C18346nr) recordMsgImageUI.mim.get(ceS);
        if (c18346nr == null) {
            C45347np c45347np = new C45347np();
            c45347np.cJU.filePath = ceS;
            C4879a.xxA.mo10055m(c45347np);
        } else if (!C5046bo.isNullOrNil(c18346nr.cJX.result)) {
            arrayList.add(Integer.valueOf(3));
            if (C13119a.m21149BR(c18346nr.cJX.cvn)) {
                arrayList2.add(recordMsgImageUI.getString(C25738R.string.diy));
            } else if (C13119a.m21150ba(c18346nr.cJX.cvn, c18346nr.cJX.result)) {
                arrayList2.add(recordMsgImageUI.getString(C25738R.string.diz));
            } else if (C13119a.m21148BQ(c18346nr.cJX.cvn)) {
                arrayList2.add(recordMsgImageUI.getString(C25738R.string.dix));
            } else {
                arrayList2.add(recordMsgImageUI.getString(C25738R.string.diy));
            }
        }
        if (!recordMsgImageUI.isFinishing()) {
            if (recordMsgImageUI.icA == null) {
                recordMsgImageUI.icA = new C46696j(recordMsgImageUI.mController.ylL);
            }
            recordMsgImageUI.icA.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(24301);
                    c44273l.setHeaderTitle((CharSequence) "");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            c44273l.mo70068e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.m2505o(24301);
                            return;
                        }
                    }
                }
            };
            recordMsgImageUI.icA.rBm = recordMsgImageUI.lcJ;
            recordMsgImageUI.icA.mo75012e(new C130158());
            C30379h.m48455a(recordMsgImageUI.mController.ylL, recordMsgImageUI.icA.cuu());
        }
        AppMethodBeat.m2505o(24319);
    }

    /* renamed from: g */
    static /* synthetic */ void m67655g(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.m2504i(24320);
        recordMsgImageUI.pKP = recordMsgImageUI.ceS();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.pKP);
        C25985d.m41466b((Context) recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, 1001);
        AppMethodBeat.m2505o(24320);
    }

    /* renamed from: h */
    static /* synthetic */ void m67656h(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.m2504i(24321);
        C14987n.m23321j(recordMsgImageUI.ceS(), recordMsgImageUI.mController.ylL);
        AppMethodBeat.m2505o(24321);
    }
}

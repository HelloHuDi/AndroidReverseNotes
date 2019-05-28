package com.tencent.mm.plugin.record.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI extends MMActivity implements d {
    private long cvx = -1;
    private List<aar> elG = new LinkedList();
    private j icA;
    private MMGestureGallery kkn;
    private n.d lcJ = new n.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(24303);
            switch (menuItem.getItemId()) {
                case 0:
                    RecordMsgImageUI.g(RecordMsgImageUI.this);
                    AppMethodBeat.o(24303);
                    return;
                case 1:
                    RecordMsgImageUI recordMsgImageUI = RecordMsgImageUI.this;
                    cl clVar = new cl();
                    e.a(clVar, recordMsgImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), recordMsgImageUI.ceS());
                    clVar.cvA.cvH = 10;
                    clVar.cvA.activity = recordMsgImageUI;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                    AppMethodBeat.o(24303);
                    return;
                case 2:
                    RecordMsgImageUI.h(RecordMsgImageUI.this);
                    AppMethodBeat.o(24303);
                    return;
                case 3:
                    String i2 = RecordMsgImageUI.i(RecordMsgImageUI.this);
                    if (!bo.isNullOrNil(i2)) {
                        nr nrVar = (nr) RecordMsgImageUI.this.mim.get(i2);
                        if (nrVar != null) {
                            cf cfVar = new cf();
                            cfVar.cvm.activity = RecordMsgImageUI.this;
                            cfVar.cvm.ctB = nrVar.cJX.result;
                            cfVar.cvm.cvn = nrVar.cJX.cvn;
                            cfVar.cvm.cvp = 8;
                            RecordMsgImageUI.a(RecordMsgImageUI.this, cfVar);
                            cfVar.cvm.cvo = nrVar.cJX.cvo;
                            if (RecordMsgImageUI.this.getIntent() != null) {
                                cfVar.cvm.cvs = RecordMsgImageUI.this.getIntent().getBundleExtra("_stat_obj");
                            }
                            com.tencent.mm.sdk.b.a.xxA.m(cfVar);
                            break;
                        }
                    }
                    AppMethodBeat.o(24303);
                    return;
                    break;
            }
            AppMethodBeat.o(24303);
        }
    };
    private Runnable mhD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(24295);
            RecordMsgImageUI.this.pKO.notifyDataSetChanged();
            AppMethodBeat.o(24295);
        }
    };
    private Map<String, nr> mim = new HashMap();
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(24296);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(24296);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(24297);
            nr nrVar = (nr) bVar;
            RecordMsgImageUI.this.mim.put(nrVar.cJX.filePath, nrVar);
            if (RecordMsgImageUI.this.icA != null && RecordMsgImageUI.this.icA.rBk.isShowing()) {
                RecordMsgImageUI.e(RecordMsgImageUI.this);
            }
            AppMethodBeat.o(24297);
            return true;
        }
    };
    private l pKH;
    private a pKO;
    private String pKP = null;
    private int selection = 0;

    static class a extends BaseAdapter {
        long cvx;
        List<aar> elG;
        l pKH;

        private a() {
            AppMethodBeat.i(24307);
            this.elG = new LinkedList();
            this.cvx = -1;
            AppMethodBeat.o(24307);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(24311);
            aar BI = BI(i);
            AppMethodBeat.o(24311);
            return BI;
        }

        public final int getCount() {
            AppMethodBeat.i(24308);
            int size = this.elG.size();
            AppMethodBeat.o(24308);
            return size;
        }

        public final aar BI(int i) {
            AppMethodBeat.i(24309);
            aar aar = (aar) this.elG.get(i);
            AppMethodBeat.o(24309);
            return aar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(24310);
            l lVar = this.pKH;
            aar BI = BI(i);
            long j = this.cvx;
            Bitmap a = lVar.a(BI, j, false);
            if (a == null) {
                ab.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(lVar.a(BI, j)));
                com.tencent.mm.plugin.record.b.n.b(BI, j, r0);
            }
            if (a == null) {
                ab.w("MicroMsg.ShowImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), R.layout.asz, null);
                }
                ((ImageView) view.findViewById(R.id.aga)).setImageResource(R.raw.download_image_icon);
                view.setLayoutParams(new LayoutParams(-1, -1));
                AppMethodBeat.o(24310);
            } else {
                Context context = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context, a.getWidth(), a.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.bW(a.getWidth(), a.getHeight());
                }
                com.tencent.mm.sdk.platformtools.n.w(view, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                view.setMaxZoomDoubleTab(true);
                AppMethodBeat.o(24310);
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RecordMsgImageUI() {
        AppMethodBeat.i(24312);
        AppMethodBeat.o(24312);
    }

    static /* synthetic */ String i(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(24322);
        String ceS = recordMsgImageUI.ceS();
        AppMethodBeat.o(24322);
        return ceS;
    }

    public final int getLayoutId() {
        return R.layout.asy;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24313);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.pKH = new l();
        this.cvx = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c VI = com.tencent.mm.plugin.record.b.n.VI(getIntent().getStringExtra("record_xml"));
        if (VI == null) {
            ab.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            AppMethodBeat.o(24313);
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
            ab.w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            AppMethodBeat.o(24313);
            return;
        }
        this.kkn = (MMGestureGallery) findViewById(R.id.adi);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.pKO = new a();
        this.pKO.elG = this.elG;
        this.pKO.cvx = this.cvx;
        this.pKO.pKH = this.pKH;
        this.kkn.setAdapter(this.pKO);
        this.kkn.setSelection(this.selection);
        this.kkn.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24294);
                if (com.tencent.mm.plugin.record.b.n.d(RecordMsgImageUI.this.pKO.BI(i), RecordMsgImageUI.this.cvx)) {
                    RecordMsgImageUI.this.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(RecordMsgImageUI.this.elG.size())}));
                    RecordMsgImageUI.this.enableOptionMenu(true);
                    AppMethodBeat.o(24294);
                    return;
                }
                RecordMsgImageUI.this.enableOptionMenu(false);
                AppMethodBeat.o(24294);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.kkn.setSingleClickOverListener(new f() {
            public final void bcX() {
                AppMethodBeat.i(24298);
                RecordMsgImageUI.this.finish();
                AppMethodBeat.o(24298);
            }
        });
        this.kkn.setLongClickOverListener(new MMGestureGallery.c() {
            public final void bvE() {
                AppMethodBeat.i(24299);
                v.b y = v.Zp().y("basescanui@datacenter", true);
                y.j("key_basescanui_screen_x", Integer.valueOf(RecordMsgImageUI.this.kkn.getXDown()));
                y.j("key_basescanui_screen_y", Integer.valueOf(RecordMsgImageUI.this.kkn.getYDown()));
                RecordMsgImageUI.e(RecordMsgImageUI.this);
                AppMethodBeat.o(24299);
            }
        });
        fullScreenNoTitleBar(true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24300);
                RecordMsgImageUI.this.finish();
                AppMethodBeat.o(24300);
                return true;
            }
        });
        ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((d) this);
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
        AppMethodBeat.o(24313);
    }

    public void onDestroy() {
        AppMethodBeat.i(24314);
        ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((d) this);
        this.pKH.destory();
        com.tencent.mm.sdk.b.a.xxA.d(this.mip);
        super.onDestroy();
        AppMethodBeat.o(24314);
    }

    /* Access modifiers changed, original: final */
    public final String ceS() {
        AppMethodBeat.i(24315);
        int selectedItemPosition = this.kkn.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            ab.w("MicroMsg.ShowImageUI", "error position");
            AppMethodBeat.o(24315);
            return null;
        }
        ab.d("MicroMsg.ShowImageUI", "cur pos %d path %s", Integer.valueOf(selectedItemPosition), com.tencent.mm.plugin.record.b.n.c(this.pKO.BI(selectedItemPosition), this.cvx));
        AppMethodBeat.o(24315);
        return com.tencent.mm.plugin.record.b.n.c(this.pKO.BI(selectedItemPosition), this.cvx);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(24316);
        ae.h(ae.a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.o(24316);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(24317);
        if (1001 == i && -1 == i2) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(24317);
                return;
            }
            final ArrayList P = bo.P(stringExtra.split(","));
            if (bo.ek(P)) {
                ab.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                AppMethodBeat.o(24317);
                return;
            }
            final p b = h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            final AnonymousClass10 anonymousClass10 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24304);
                    b.dismiss();
                    AppMethodBeat.o(24304);
                }
            };
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24305);
                    for (String str : P) {
                        com.tencent.mm.plugin.messenger.a.g.bOk().a(RecordMsgImageUI.this.mController.ylL, str, RecordMsgImageUI.this.pKP, 0, "", "");
                        com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str);
                    }
                    al.d(anonymousClass10);
                    AppMethodBeat.o(24305);
                }

                public final String toString() {
                    AppMethodBeat.i(24306);
                    String str = super.toString() + "|onActivityResult";
                    AppMethodBeat.o(24306);
                    return str;
                }
            });
            AppMethodBeat.o(24317);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(24317);
    }

    public final void a(int i, i iVar) {
        AppMethodBeat.i(24318);
        for (aar aar : this.elG) {
            if (aar.mnd.equals(iVar.field_dataId)) {
                al.d(this.mhD);
                AppMethodBeat.o(24318);
                return;
            }
        }
        AppMethodBeat.o(24318);
    }

    static /* synthetic */ void e(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(24319);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList2.add(recordMsgImageUI.getString(R.string.dr8));
        arrayList.add(Integer.valueOf(1));
        arrayList2.add(recordMsgImageUI.getString(R.string.dcq));
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(recordMsgImageUI.getString(R.string.dwz));
        String ceS = recordMsgImageUI.ceS();
        nr nrVar = (nr) recordMsgImageUI.mim.get(ceS);
        if (nrVar == null) {
            np npVar = new np();
            npVar.cJU.filePath = ceS;
            com.tencent.mm.sdk.b.a.xxA.m(npVar);
        } else if (!bo.isNullOrNil(nrVar.cJX.result)) {
            arrayList.add(Integer.valueOf(3));
            if (com.tencent.mm.plugin.scanner.a.BR(nrVar.cJX.cvn)) {
                arrayList2.add(recordMsgImageUI.getString(R.string.diy));
            } else if (com.tencent.mm.plugin.scanner.a.ba(nrVar.cJX.cvn, nrVar.cJX.result)) {
                arrayList2.add(recordMsgImageUI.getString(R.string.diz));
            } else if (com.tencent.mm.plugin.scanner.a.BQ(nrVar.cJX.cvn)) {
                arrayList2.add(recordMsgImageUI.getString(R.string.dix));
            } else {
                arrayList2.add(recordMsgImageUI.getString(R.string.diy));
            }
        }
        if (!recordMsgImageUI.isFinishing()) {
            if (recordMsgImageUI.icA == null) {
                recordMsgImageUI.icA = new j(recordMsgImageUI.mController.ylL);
            }
            recordMsgImageUI.icA.rBl = new n.c() {
                public final void a(com.tencent.mm.ui.base.l lVar) {
                    AppMethodBeat.i(24301);
                    lVar.setHeaderTitle((CharSequence) "");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            lVar.e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.o(24301);
                            return;
                        }
                    }
                }
            };
            recordMsgImageUI.icA.rBm = recordMsgImageUI.lcJ;
            recordMsgImageUI.icA.e(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(24302);
                    RecordMsgImageUI.this.icA = null;
                    AppMethodBeat.o(24302);
                }
            });
            h.a(recordMsgImageUI.mController.ylL, recordMsgImageUI.icA.cuu());
        }
        AppMethodBeat.o(24319);
    }

    static /* synthetic */ void g(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(24320);
        recordMsgImageUI.pKP = recordMsgImageUI.ceS();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.pKP);
        com.tencent.mm.bp.d.b((Context) recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, 1001);
        AppMethodBeat.o(24320);
    }

    static /* synthetic */ void h(RecordMsgImageUI recordMsgImageUI) {
        AppMethodBeat.i(24321);
        com.tencent.mm.pluginsdk.ui.tools.n.j(recordMsgImageUI.ceS(), recordMsgImageUI.mController.ylL);
        AppMethodBeat.o(24321);
    }
}

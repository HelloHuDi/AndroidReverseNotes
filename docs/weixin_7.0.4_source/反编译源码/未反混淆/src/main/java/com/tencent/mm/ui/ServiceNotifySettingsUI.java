package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI extends MMActivity implements f {
    private DataSetObserver PL;
    private ListView mListView;
    private int mMode;
    private String mSceneId;
    private MMSwitchBtn omp;
    private p sfa;
    private a ypX;

    static class a extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;
        private int mMode;
        private OnClickListener mOnClickListener;
        private String mSceneId;
        LinkedList<a> yqd = new LinkedList();
        LinkedList<a> yqe = new LinkedList();
        private c yqf;

        static class a {
            String title;
            String url;
            String username;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        static class b {
            ImageView eks;
            TextView gne;
            TextView yqj;

            private b() {
            }

            /* synthetic */ b(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(29861);
            a Nv = Nv(i);
            AppMethodBeat.o(29861);
            return Nv;
        }

        public a(Context context, LayoutInflater layoutInflater, final int i, String str) {
            AppMethodBeat.i(29857);
            this.mContext = context;
            this.mMode = i;
            this.mSceneId = str;
            this.mLayoutInflater = layoutInflater;
            this.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(29856);
                    final String str = (String) view.getTag();
                    if (TextUtils.isEmpty(str)) {
                        AppMethodBeat.o(29856);
                        return;
                    }
                    int i;
                    int i2;
                    Context context = view.getContext();
                    if (i == 1) {
                        i = R.string.d_v;
                    } else {
                        i = R.string.d_z;
                    }
                    if (i == 1) {
                        i2 = R.string.d_w;
                    } else {
                        i2 = R.string.s6;
                    }
                    h.a(context, i, 0, i2, (int) R.string.abx, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29855);
                            int i2 = 0;
                            while (i2 < a.this.yqd.size()) {
                                a aVar = (a) a.this.yqd.get(i2);
                                if (aVar == null || !str.equals(aVar.username)) {
                                    i2++;
                                } else {
                                    a.this.yqe.add(a.this.yqd.remove(i2));
                                    a.this.notifyDataSetChanged();
                                    WxaAttributes zb = ((d) g.K(d.class)).zb(str);
                                    String str = zb == null ? "" : zb.field_appId;
                                    if (i == 1) {
                                        ab.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(4), str, a.this.mSceneId);
                                        com.tencent.mm.plugin.report.service.h.pYm.e(13798, Integer.valueOf(4), str, Integer.valueOf(0), a.this.mSceneId, Long.valueOf(bo.anT()));
                                        AppMethodBeat.o(29855);
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.h.pYm.e(13796, Integer.valueOf(12), str, "", Integer.valueOf(0), Long.valueOf(bo.anT()));
                                    AppMethodBeat.o(29855);
                                    return;
                                }
                            }
                            AppMethodBeat.o(29855);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, (int) R.color.r8);
                    AppMethodBeat.o(29856);
                }
            };
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.eQf = true;
            aVar.ePW = com.tencent.mm.modelappbrand.a.a.abQ();
            this.yqf = aVar.ahG();
            AppMethodBeat.o(29857);
        }

        public final int getCount() {
            AppMethodBeat.i(29858);
            int size = this.yqd.size();
            AppMethodBeat.o(29858);
            return size;
        }

        private a Nv(int i) {
            AppMethodBeat.i(29859);
            a aVar = (a) this.yqd.get(i);
            AppMethodBeat.o(29859);
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(29860);
            a Nv = Nv(i);
            if (view == null) {
                view = this.mLayoutInflater.inflate(R.layout.arc, viewGroup, false);
                b bVar2 = new b();
                bVar2.eks = (ImageView) view.findViewById(R.id.e93);
                bVar2.gne = (TextView) view.findViewById(R.id.u4);
                bVar2.yqj = (TextView) view.findViewById(R.id.e94);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            o.ahp().a(Nv.url, bVar.eks, this.yqf);
            bVar.gne.setText(Nv.title);
            if (this.mMode == 1) {
                bVar.yqj.setText(this.mContext.getString(R.string.d_s));
            } else {
                bVar.yqj.setText(this.mContext.getString(R.string.d_t));
            }
            bVar.yqj.setTag(Nv.username);
            bVar.yqj.setOnClickListener(this.mOnClickListener);
            AppMethodBeat.o(29860);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return R.layout.ard;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29862);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.mSceneId = intent.getStringExtra("scene_id");
        intent.putExtra("scene_id", this.mSceneId);
        String stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            setMMTitle((int) R.string.da1);
        } else {
            setMMTitle(stringExtra);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29850);
                ServiceNotifySettingsUI.this.finish();
                AppMethodBeat.o(29850);
                return false;
            }
        });
        this.omp = (MMSwitchBtn) findViewById(R.id.js);
        this.mListView = (ListView) findViewById(R.id.a46);
        ((TextView) findViewById(R.id.e96)).setText(this.mMode == 1 ? R.string.d_k : R.string.d_h);
        ((TextView) findViewById(R.id.e95)).setText(this.mMode == 1 ? R.string.d_l : R.string.d_n);
        this.ypX = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
        this.mListView.setAdapter(this.ypX);
        getString(R.string.tz);
        this.sfa = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(29851);
                ServiceNotifySettingsUI.this.finish();
                AppMethodBeat.o(29851);
            }
        });
        this.PL = new DataSetObserver() {
            public final void onChanged() {
                AppMethodBeat.i(29852);
                ServiceNotifySettingsUI.this.findViewById(R.id.e96).setVisibility(ServiceNotifySettingsUI.this.ypX.isEmpty() ? 4 : 0);
                AppMethodBeat.o(29852);
            }
        };
        this.ypX.registerDataSetObserver(this.PL);
        int i = 3;
        if (this.mMode == 1) {
            i = 12;
        }
        aw.Rg().a(1145, (f) this);
        aw.Rg().a(new com.tencent.mm.modelappbrand.p(i), 0);
        this.omp.setCheck(dzb());
        AppMethodBeat.o(29862);
    }

    public void onDestroy() {
        int i;
        int i2 = 3;
        AppMethodBeat.i(29863);
        aw.Rg().b(1145, (f) this);
        final boolean dzb = dzb();
        final boolean z = this.omp.zMU != dzb;
        final LinkedList linkedList = new LinkedList();
        if (z) {
            int i3;
            boolean z2;
            cfx cfx = new cfx();
            if (this.omp.zMU) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            cfx.xeW = i3;
            if (this.mMode == 1) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            cfx.jCt = i3;
            linkedList.add(cfx);
            if (dzb) {
                z2 = false;
            } else {
                z2 = true;
            }
            com.tencent.mm.storage.ac.a aVar = com.tencent.mm.storage.ac.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
            if (this.mMode == 1) {
                aVar = com.tencent.mm.storage.ac.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
            }
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(aVar, Boolean.valueOf(z2));
            com.tencent.mm.sdk.b.a.xxA.m(new nx());
            if (this.mMode == 1) {
                if (cfx.xeW == 1) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                ab.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(i3), this.mSceneId);
                com.tencent.mm.plugin.report.service.h.pYm.e(13798, Integer.valueOf(i3), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bo.anT()));
            } else {
                i3 = cfx.xeW == 1 ? 11 : 10;
                com.tencent.mm.plugin.report.service.h.pYm.e(13796, Integer.valueOf(i3), "", "", Integer.valueOf(0), Long.valueOf(bo.anT()));
            }
        }
        if (this.mMode == 1) {
            i = 2;
        } else {
            i = 1;
        }
        LinkedList linkedList2 = this.ypX.yqe;
        if (!(linkedList2 == null || linkedList2.isEmpty())) {
            if (this.mMode != 1) {
                i2 = 1;
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                cfx cfx2 = new cfx();
                cfx2.xeX = aVar2.username;
                cfx2.jCt = i2;
                cfx2.xeW = 1;
                linkedList.add(cfx2);
                tz tzVar = new tz();
                tzVar.cQf.csl = aVar2.username;
                tzVar.cQf.action = 2;
                tzVar.cQf.cQh = i;
                com.tencent.mm.sdk.b.a.xxA.m(tzVar);
            }
        }
        if (!linkedList.isEmpty()) {
            aw.Rg().a(1176, new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(29853);
                    aw.Rg().b(1176, (f) this);
                    ab.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        AppMethodBeat.o(29853);
                        return;
                    }
                    t.makeText(ServiceNotifySettingsUI.this, R.string.da0, 0).show();
                    if (z) {
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(dzb));
                        com.tencent.mm.sdk.b.a.xxA.m(new nx());
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        cfx cfx = (cfx) it.next();
                        tz tzVar = new tz();
                        tzVar.cQf.csl = cfx.xeX;
                        tzVar.cQf.action = 1;
                        tzVar.cQf.cQh = i;
                        com.tencent.mm.sdk.b.a.xxA.m(tzVar);
                    }
                    AppMethodBeat.o(29853);
                }
            });
            aw.Rg().a(new com.tencent.mm.modelappbrand.o(linkedList), 0);
        }
        this.ypX.unregisterDataSetObserver(this.PL);
        super.onDestroy();
        AppMethodBeat.o(29863);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(29864);
        if (this.sfa != null) {
            this.sfa.dismiss();
        }
        ab.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            final anz abG = ((com.tencent.mm.modelappbrand.p) mVar).abG();
            if (this.mMode == 1) {
                this.omp.setCheck(abG.wsw);
            } else {
                this.omp.setCheck(abG.vKO);
            }
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29854);
                    if (ServiceNotifySettingsUI.this.mMode == 1) {
                        ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, abG.wsx);
                        AppMethodBeat.o(29854);
                        return;
                    }
                    ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, abG.vKP);
                    AppMethodBeat.o(29854);
                }
            });
            AppMethodBeat.o(29864);
            return;
        }
        t.makeText(this, R.string.d_q, 0).show();
        AppMethodBeat.o(29864);
    }

    private boolean dzb() {
        AppMethodBeat.i(29865);
        com.tencent.mm.storage.ac.a aVar = com.tencent.mm.storage.ac.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        if (this.mMode == 1) {
            aVar = com.tencent.mm.storage.ac.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        }
        aw.ZK();
        boolean z = com.tencent.mm.model.c.Ry().getBoolean(aVar, true);
        AppMethodBeat.o(29865);
        return z;
    }

    static /* synthetic */ void a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        AppMethodBeat.i(29866);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bxi bxi = (bxi) it.next();
            a aVar = new a();
            aVar.username = bxi.username;
            aVar.title = bxi.nickname;
            aVar.url = bxi.wrK;
            linkedList2.add(aVar);
        }
        a aVar2 = serviceNotifySettingsUI.ypX;
        aVar2.yqd.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.yqd.addAll(linkedList2);
        }
        serviceNotifySettingsUI.ypX.notifyDataSetChanged();
        AppMethodBeat.o(29866);
    }
}

package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C32812p;
import com.tencent.p177mm.modelappbrand.C6676o;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C37775nx;
import com.tencent.p177mm.p230g.p231a.C45374tz;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.anz;
import com.tencent.p177mm.protocal.protobuf.bxi;
import com.tencent.p177mm.protocal.protobuf.cfx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI */
public class ServiceNotifySettingsUI extends MMActivity implements C1202f {
    /* renamed from: PL */
    private DataSetObserver f4421PL;
    private ListView mListView;
    private int mMode;
    private String mSceneId;
    private MMSwitchBtn omp;
    private C44275p sfa;
    private C23565a ypX;

    /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$a */
    static class C23565a extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;
        private int mMode;
        private OnClickListener mOnClickListener;
        private String mSceneId;
        LinkedList<C15479a> yqd = new LinkedList();
        LinkedList<C15479a> yqe = new LinkedList();
        private C25814c yqf;

        /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$a$a */
        static class C15479a {
            String title;
            String url;
            String username;

            private C15479a() {
            }

            /* synthetic */ C15479a(byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$a$b */
        static class C23566b {
            ImageView eks;
            TextView gne;
            TextView yqj;

            private C23566b() {
            }

            /* synthetic */ C23566b(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(29861);
            C15479a Nv = m36396Nv(i);
            AppMethodBeat.m2505o(29861);
            return Nv;
        }

        public C23565a(Context context, LayoutInflater layoutInflater, final int i, String str) {
            AppMethodBeat.m2504i(29857);
            this.mContext = context;
            this.mMode = i;
            this.mSceneId = str;
            this.mLayoutInflater = layoutInflater;
            this.mOnClickListener = new OnClickListener() {

                /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$a$1$2 */
                class C235642 implements DialogInterface.OnClickListener {
                    C235642() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(29856);
                    final String str = (String) view.getTag();
                    if (TextUtils.isEmpty(str)) {
                        AppMethodBeat.m2505o(29856);
                        return;
                    }
                    int i;
                    int i2;
                    Context context = view.getContext();
                    if (i == 1) {
                        i = C25738R.string.d_v;
                    } else {
                        i = C25738R.string.d_z;
                    }
                    if (i == 1) {
                        i2 = C25738R.string.d_w;
                    } else {
                        i2 = C25738R.string.f9187s6;
                    }
                    C30379h.m48430a(context, i, 0, i2, (int) C25738R.string.abx, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(29855);
                            int i2 = 0;
                            while (i2 < C23565a.this.yqd.size()) {
                                C15479a c15479a = (C15479a) C23565a.this.yqd.get(i2);
                                if (c15479a == null || !str.equals(c15479a.username)) {
                                    i2++;
                                } else {
                                    C23565a.this.yqe.add(C23565a.this.yqd.remove(i2));
                                    C23565a.this.notifyDataSetChanged();
                                    WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(str);
                                    String str = zb == null ? "" : zb.field_appId;
                                    if (i == 1) {
                                        C4990ab.m7411d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(4), str, C23565a.this.mSceneId);
                                        C7060h.pYm.mo8381e(13798, Integer.valueOf(4), str, Integer.valueOf(0), C23565a.this.mSceneId, Long.valueOf(C5046bo.anT()));
                                        AppMethodBeat.m2505o(29855);
                                        return;
                                    }
                                    C7060h.pYm.mo8381e(13796, Integer.valueOf(12), str, "", Integer.valueOf(0), Long.valueOf(C5046bo.anT()));
                                    AppMethodBeat.m2505o(29855);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(29855);
                        }
                    }, new C235642(), (int) C25738R.color.f12069r8);
                    AppMethodBeat.m2505o(29856);
                }
            };
            C17927a c17927a = new C17927a();
            c17927a.eQf = true;
            c17927a.ePW = C32804a.abQ();
            this.yqf = c17927a.ahG();
            AppMethodBeat.m2505o(29857);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(29858);
            int size = this.yqd.size();
            AppMethodBeat.m2505o(29858);
            return size;
        }

        /* renamed from: Nv */
        private C15479a m36396Nv(int i) {
            AppMethodBeat.m2504i(29859);
            C15479a c15479a = (C15479a) this.yqd.get(i);
            AppMethodBeat.m2505o(29859);
            return c15479a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C23566b c23566b;
            AppMethodBeat.m2504i(29860);
            C15479a Nv = m36396Nv(i);
            if (view == null) {
                view = this.mLayoutInflater.inflate(2130970618, viewGroup, false);
                C23566b c23566b2 = new C23566b();
                c23566b2.eks = (ImageView) view.findViewById(2131827354);
                c23566b2.gne = (TextView) view.findViewById(2131821314);
                c23566b2.yqj = (TextView) view.findViewById(2131827355);
                view.setTag(c23566b2);
                c23566b = c23566b2;
            } else {
                c23566b = (C23566b) view.getTag();
            }
            C32291o.ahp().mo43766a(Nv.url, c23566b.eks, this.yqf);
            c23566b.gne.setText(Nv.title);
            if (this.mMode == 1) {
                c23566b.yqj.setText(this.mContext.getString(C25738R.string.d_s));
            } else {
                c23566b.yqj.setText(this.mContext.getString(C25738R.string.d_t));
            }
            c23566b.yqj.setTag(Nv.username);
            c23566b.yqj.setOnClickListener(this.mOnClickListener);
            AppMethodBeat.m2505o(29860);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$2 */
    class C235692 implements OnCancelListener {
        C235692() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(29851);
            ServiceNotifySettingsUI.this.finish();
            AppMethodBeat.m2505o(29851);
        }
    }

    /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$1 */
    class C235711 implements OnMenuItemClickListener {
        C235711() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(29850);
            ServiceNotifySettingsUI.this.finish();
            AppMethodBeat.m2505o(29850);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.ServiceNotifySettingsUI$3 */
    class C235723 extends DataSetObserver {
        C235723() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(29852);
            ServiceNotifySettingsUI.this.findViewById(2131827357).setVisibility(ServiceNotifySettingsUI.this.ypX.isEmpty() ? 4 : 0);
            AppMethodBeat.m2505o(29852);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return 2130970619;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29862);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.mSceneId = intent.getStringExtra("scene_id");
        intent.putExtra("scene_id", this.mSceneId);
        String stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            setMMTitle((int) C25738R.string.da1);
        } else {
            setMMTitle(stringExtra);
        }
        setBackBtn(new C235711());
        this.omp = (MMSwitchBtn) findViewById(2131820932);
        this.mListView = (ListView) findViewById(2131821698);
        ((TextView) findViewById(2131827357)).setText(this.mMode == 1 ? C25738R.string.d_k : C25738R.string.d_h);
        ((TextView) findViewById(2131827356)).setText(this.mMode == 1 ? C25738R.string.d_l : C25738R.string.d_n);
        this.ypX = new C23565a(this, getLayoutInflater(), this.mMode, this.mSceneId);
        this.mListView.setAdapter(this.ypX);
        getString(C25738R.string.f9238tz);
        this.sfa = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C235692());
        this.f4421PL = new C235723();
        this.ypX.registerDataSetObserver(this.f4421PL);
        int i = 3;
        if (this.mMode == 1) {
            i = 12;
        }
        C9638aw.m17182Rg().mo14539a(1145, (C1202f) this);
        C9638aw.m17182Rg().mo14541a(new C32812p(i), 0);
        this.omp.setCheck(dzb());
        AppMethodBeat.m2505o(29862);
    }

    public void onDestroy() {
        int i;
        int i2 = 3;
        AppMethodBeat.m2504i(29863);
        C9638aw.m17182Rg().mo14546b(1145, (C1202f) this);
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
            C5127a c5127a = C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
            if (this.mMode == 1) {
                c5127a = C5127a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(c5127a, Boolean.valueOf(z2));
            C4879a.xxA.mo10055m(new C37775nx());
            if (this.mMode == 1) {
                if (cfx.xeW == 1) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                C4990ab.m7411d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(i3), this.mSceneId);
                C7060h.pYm.mo8381e(13798, Integer.valueOf(i3), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(C5046bo.anT()));
            } else {
                i3 = cfx.xeW == 1 ? 11 : 10;
                C7060h.pYm.mo8381e(13796, Integer.valueOf(i3), "", "", Integer.valueOf(0), Long.valueOf(C5046bo.anT()));
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
                C15479a c15479a = (C15479a) it.next();
                cfx cfx2 = new cfx();
                cfx2.xeX = c15479a.username;
                cfx2.jCt = i2;
                cfx2.xeW = 1;
                linkedList.add(cfx2);
                C45374tz c45374tz = new C45374tz();
                c45374tz.cQf.csl = c15479a.username;
                c45374tz.cQf.action = 2;
                c45374tz.cQf.cQh = i;
                C4879a.xxA.mo10055m(c45374tz);
            }
        }
        if (!linkedList.isEmpty()) {
            C9638aw.m17182Rg().mo14539a(1176, new C1202f() {
                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(29853);
                    C9638aw.m17182Rg().mo14546b(1176, (C1202f) this);
                    C4990ab.m7417i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        AppMethodBeat.m2505o(29853);
                        return;
                    }
                    C23639t.makeText(ServiceNotifySettingsUI.this, C25738R.string.da0, 0).show();
                    if (z) {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(dzb));
                        C4879a.xxA.mo10055m(new C37775nx());
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        cfx cfx = (cfx) it.next();
                        C45374tz c45374tz = new C45374tz();
                        c45374tz.cQf.csl = cfx.xeX;
                        c45374tz.cQf.action = 1;
                        c45374tz.cQf.cQh = i;
                        C4879a.xxA.mo10055m(c45374tz);
                    }
                    AppMethodBeat.m2505o(29853);
                }
            });
            C9638aw.m17182Rg().mo14541a(new C6676o(linkedList), 0);
        }
        this.ypX.unregisterDataSetObserver(this.f4421PL);
        super.onDestroy();
        AppMethodBeat.m2505o(29863);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(29864);
        if (this.sfa != null) {
            this.sfa.dismiss();
        }
        C4990ab.m7417i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            final anz abG = ((C32812p) c1207m).abG();
            if (this.mMode == 1) {
                this.omp.setCheck(abG.wsw);
            } else {
                this.omp.setCheck(abG.vKO);
            }
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(29854);
                    if (ServiceNotifySettingsUI.this.mMode == 1) {
                        ServiceNotifySettingsUI.m36401a(ServiceNotifySettingsUI.this, abG.wsx);
                        AppMethodBeat.m2505o(29854);
                        return;
                    }
                    ServiceNotifySettingsUI.m36401a(ServiceNotifySettingsUI.this, abG.vKP);
                    AppMethodBeat.m2505o(29854);
                }
            });
            AppMethodBeat.m2505o(29864);
            return;
        }
        C23639t.makeText(this, C25738R.string.d_q, 0).show();
        AppMethodBeat.m2505o(29864);
    }

    private boolean dzb() {
        AppMethodBeat.m2504i(29865);
        C5127a c5127a = C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        if (this.mMode == 1) {
            c5127a = C5127a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        }
        C9638aw.m17190ZK();
        boolean z = C18628c.m29072Ry().getBoolean(c5127a, true);
        AppMethodBeat.m2505o(29865);
        return z;
    }

    /* renamed from: a */
    static /* synthetic */ void m36401a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        AppMethodBeat.m2504i(29866);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bxi bxi = (bxi) it.next();
            C15479a c15479a = new C15479a();
            c15479a.username = bxi.username;
            c15479a.title = bxi.nickname;
            c15479a.url = bxi.wrK;
            linkedList2.add(c15479a);
        }
        C23565a c23565a = serviceNotifySettingsUI.ypX;
        c23565a.yqd.clear();
        if (!linkedList2.isEmpty()) {
            c23565a.yqd.addAll(linkedList2);
        }
        serviceNotifySettingsUI.ypX.notifyDataSetChanged();
        AppMethodBeat.m2505o(29866);
    }
}

package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C17895o;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p707ba.C25854m;
import com.tencent.p177mm.p707ba.C32329j;
import com.tencent.p177mm.p707ba.C37504a;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.p707ba.C9067n;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI */
public class SettingsSelectBgUI extends MMActivity implements C1202f {
    private boolean qmZ;
    private C13234a qoQ;
    private GridView qoR;
    private C32329j qoS;
    private List<C32329j> qoT = new ArrayList();
    private C7564ap qoU = new C7564ap(new C348851(), true);
    private String username;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI$a */
    class C13234a extends C46692p<C25854m> {
        private Context context;
        private int itemWidth;

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(127479);
            C25854m c25854m = (C25854m) obj;
            if (c25854m == null) {
                c25854m = new C25854m();
            }
            c25854m.mo43842d(cursor);
            AppMethodBeat.m2505o(127479);
            return c25854m;
        }

        public C13234a(Context context, int i) {
            super(context, new C25854m());
            AppMethodBeat.m2504i(127474);
            this.context = context;
            this.itemWidth = i;
            AppMethodBeat.m2505o(127474);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(127475);
            int count = getCursor().getCount() + 2;
            AppMethodBeat.m2505o(127475);
            return count;
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(127476);
            mo6869KC();
            AppMethodBeat.m2505o(127476);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(127477);
            setCursor(C41787r.aix().ait());
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(127477);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C13243b c13243b;
            AppMethodBeat.m2504i(127478);
            if (view == null) {
                view = View.inflate(this.context, 2130970643, null);
                view.setLayoutParams(new LayoutParams(this.itemWidth, this.itemWidth));
                C13243b c13243b2 = new C13243b();
                c13243b2.qqB = (LinearLayout) view.findViewById(2131827419);
                c13243b2.qqC = (LinearLayout) view.findViewById(2131827422);
                c13243b2.qqD = (LinearLayout) view.findViewById(2131827423);
                c13243b2.qqE = (LinearLayout) view.findViewById(2131827424);
                c13243b2.qqF = (LinearLayout) view.findViewById(2131827425);
                view.setTag(c13243b2);
                c13243b = c13243b2;
            } else {
                c13243b = (C13243b) view.getTag();
            }
            int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(12311, null), -2);
            C37504a sU = C41787r.aiy().mo73165sU(SettingsSelectBgUI.this.username);
            if (i == 0) {
                if (!(SettingsSelectBgUI.this.qmZ && a == -2) && (!(!SettingsSelectBgUI.this.qmZ && a == -2 && sU == null) && (sU == null || sU.fLV != -2))) {
                    c13243b.mo25296WA("downloaded");
                } else {
                    c13243b.mo25296WA("using");
                }
                ((ImageView) view.findViewById(2131827418)).setImageBitmap(C5056d.m7616a(BitmapFactory.decodeResource(this.context.getResources(), C25738R.drawable.ace), true, 10.0f));
                AppMethodBeat.m2505o(127478);
            } else if (i == 1) {
                if (!(SettingsSelectBgUI.this.qmZ && a == 0) && (!(!SettingsSelectBgUI.this.qmZ && a == 0 && sU == null) && (sU == null || sU.fLV != 0))) {
                    c13243b.mo25296WA("downloaded");
                } else {
                    c13243b.mo25296WA("using");
                }
                ((ImageView) view.findViewById(2131827418)).setImageBitmap(C5056d.m7616a(BitmapFactory.decodeResource(this.context.getResources(), C25738R.drawable.acd), true, 10.0f));
                AppMethodBeat.m2505o(127478);
            } else {
                Bitmap aml;
                C25854m c25854m = (C25854m) getItem(i - 2);
                C41787r.aix();
                if (C1720g.m3536RP().isSDCardAvailable()) {
                    aml = C5056d.aml(C9067n.aiu() + C9067n.m16440cw(c25854m.f13661id, c25854m.cBc));
                } else {
                    aml = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), C25738R.drawable.aka);
                }
                if (aml == null) {
                    AppMethodBeat.m2505o(127478);
                } else {
                    ((ImageView) view.findViewById(2131827418)).setImageBitmap(C5056d.m7616a(aml, true, 10.0f));
                    switch (c25854m.status) {
                        case 1:
                            if (!SettingsSelectBgUI.this.qmZ && sU != null && sU.fLV != c25854m.f13661id) {
                                c13243b.mo25296WA("downloaded");
                                break;
                            }
                            c13243b.mo25296WA("using");
                            break;
                            break;
                        case 2:
                            if (!SettingsSelectBgUI.this.qmZ && sU != null && sU.fLV == c25854m.f13661id) {
                                c13243b.mo25296WA("using");
                                break;
                            }
                            c13243b.mo25296WA("downloaded");
                            break;
                            break;
                        case 3:
                            c13243b.mo25296WA("downloading");
                            break;
                        case 4:
                            c13243b.mo25296WA("canceling");
                            break;
                        case 5:
                            c13243b.mo25296WA("undownloaded");
                            break;
                    }
                    AppMethodBeat.m2505o(127478);
                }
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI$1 */
    class C348851 implements C5015a {
        C348851() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(127470);
            if (SettingsSelectBgUI.this.findViewById(2131827417).getWidth() <= 0) {
                AppMethodBeat.m2505o(127470);
                return true;
            }
            SettingsSelectBgUI.m86365a(SettingsSelectBgUI.this);
            AppMethodBeat.m2505o(127470);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI$2 */
    class C348862 implements OnMenuItemClickListener {
        C348862() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127471);
            SettingsSelectBgUI.this.finish();
            AppMethodBeat.m2505o(127471);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI$3 */
    class C348873 implements OnItemClickListener {
        C348873() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(127473);
            if (i == 0) {
                SettingsSelectBgUI.m86366a(SettingsSelectBgUI.this, -2);
                SettingsSelectBgUI.this.qoQ.mo6869KC();
                if (!SettingsSelectBgUI.this.qmZ) {
                    SettingsSelectBgUI.this.setResult(-1);
                    SettingsSelectBgUI.this.finish();
                }
                AppMethodBeat.m2505o(127473);
            } else if (i == 1) {
                SettingsSelectBgUI.m86366a(SettingsSelectBgUI.this, 0);
                SettingsSelectBgUI.this.qoQ.mo6869KC();
                if (!SettingsSelectBgUI.this.qmZ) {
                    SettingsSelectBgUI.this.setResult(-1);
                    SettingsSelectBgUI.this.finish();
                }
                AppMethodBeat.m2505o(127473);
            } else if (C1720g.m3536RP().isSDCardAvailable()) {
                C25854m c25854m = (C25854m) adapterView.getItemAtPosition(i - 2);
                if (c25854m == null) {
                    C4990ab.m7412e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = ".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(127473);
                    return;
                }
                C9067n aix;
                switch (c25854m.status) {
                    case 1:
                    case 2:
                        SettingsSelectBgUI.m86366a(SettingsSelectBgUI.this, c25854m.f13661id);
                        if (SettingsSelectBgUI.this.qmZ) {
                            c25854m.status = 1;
                            aix = C41787r.aix();
                            aix.mo20545lS(c25854m.cBc);
                            c25854m.status = 1;
                            aix.mo20540b(c25854m);
                        } else {
                            SettingsSelectBgUI.this.qoQ.mo6869KC();
                        }
                        if (!SettingsSelectBgUI.this.qmZ) {
                            SettingsSelectBgUI.this.setResult(-1);
                            SettingsSelectBgUI.this.finish();
                            break;
                        }
                        break;
                    case 3:
                        if (SettingsSelectBgUI.this.qoS != null && SettingsSelectBgUI.this.qoS.fMn == c25854m.f13661id) {
                            C1720g.m3540Rg().mo14547c(SettingsSelectBgUI.this.qoS);
                            C41787r.aix().mo20544cz(SettingsSelectBgUI.this.qoS.fMn, 1);
                            SettingsSelectBgUI.m86367a(SettingsSelectBgUI.this, SettingsSelectBgUI.this.qoT);
                        }
                        SettingsSelectBgUI.m86374h(c25854m.f13661id, SettingsSelectBgUI.this.qoT);
                        aix = C41787r.aix();
                        c25854m.status = 4;
                        aix.mo20540b(c25854m);
                        final int i2 = c25854m.f13661id;
                        new C7306ak() {
                            public final void handleMessage(Message message) {
                                AppMethodBeat.m2504i(127472);
                                aix.mo20544cz(i2, 1);
                                AppMethodBeat.m2505o(127472);
                            }
                        }.sendEmptyMessageDelayed(0, 1000);
                        AppMethodBeat.m2505o(127473);
                        return;
                    case 4:
                        C41787r.aix().mo20544cz(c25854m.f13661id, 1);
                        AppMethodBeat.m2505o(127473);
                        return;
                    case 5:
                        if (SettingsSelectBgUI.this.qoS == null) {
                            SettingsSelectBgUI.this.qoS = new C32329j(c25854m.f13661id, 1);
                            C1720g.m3540Rg().mo14541a(SettingsSelectBgUI.this.qoS, 0);
                            AppMethodBeat.m2505o(127473);
                            return;
                        }
                        SettingsSelectBgUI.this.qoT.add(new C32329j(c25854m.f13661id, 1));
                        AppMethodBeat.m2505o(127473);
                        return;
                }
                AppMethodBeat.m2505o(127473);
            } else {
                Toast.makeText(SettingsSelectBgUI.this, C25738R.string.eab, 1).show();
                AppMethodBeat.m2505o(127473);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsSelectBgUI() {
        AppMethodBeat.m2504i(127480);
        AppMethodBeat.m2505o(127480);
    }

    public final int getLayoutId() {
        return 2130970642;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127481);
        super.onCreate(bundle);
        initView();
        C1720g.m3540Rg().mo14539a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        C1720g.m3540Rg().mo14539a(160, (C1202f) this);
        if (C1720g.m3536RP().isSDCardAvailable()) {
            C1720g.m3540Rg().mo14541a(new C45181k(1), 0);
        }
        AppMethodBeat.m2505o(127481);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127482);
        super.onDestroy();
        if (this.qoS != null) {
            C1720g.m3540Rg().mo14547c(this.qoS);
            C41787r.aix().mo20544cz(this.qoS.fMn, 1);
        }
        List<C32329j> list = this.qoT;
        for (C32329j c32329j : list) {
            C41787r.aix().mo20544cz(c32329j.fMn, 1);
        }
        list.clear();
        C1720g.m3540Rg().mo14546b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        C1720g.m3540Rg().mo14546b(160, (C1202f) this);
        this.qoQ.bIf();
        C41787r.aix().mo10117d(this.qoQ);
        AppMethodBeat.m2505o(127482);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127483);
        setMMTitle((int) C25738R.string.e6b);
        setBackBtn(new C348862());
        this.qmZ = getIntent().getBooleanExtra("isApplyToAll", true);
        this.username = getIntent().getStringExtra("username");
        this.qoU.mo16770ae(20, 20);
        AppMethodBeat.m2505o(127483);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127484);
        if ((c1207m instanceof C17895o) && ((C17895o) c1207m).acR() == 1) {
            int type = c1207m.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX || type == 160) {
                if (type == 160) {
                    m86370cZ(this.qoT);
                }
                if (i == 0 && i2 == 0) {
                    AppMethodBeat.m2505o(127484);
                    return;
                } else {
                    AppMethodBeat.m2505o(127484);
                    return;
                }
            }
            AppMethodBeat.m2505o(127484);
            return;
        }
        C4990ab.m7410d("MicroMsg.SettingsSelectBgUI", "another scene");
        AppMethodBeat.m2505o(127484);
    }

    /* renamed from: cZ */
    private void m86370cZ(List<C32329j> list) {
        AppMethodBeat.m2504i(127485);
        if (list.size() > 0) {
            this.qoS = (C32329j) list.remove(0);
            C1720g.m3540Rg().mo14541a(this.qoS, 0);
            AppMethodBeat.m2505o(127485);
            return;
        }
        this.qoS = null;
        AppMethodBeat.m2505o(127485);
    }

    /* renamed from: a */
    static /* synthetic */ void m86365a(SettingsSelectBgUI settingsSelectBgUI) {
        AppMethodBeat.m2504i(127486);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) settingsSelectBgUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        settingsSelectBgUI.qoQ = new C13234a(settingsSelectBgUI, ((displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels) - 60) / 3);
        settingsSelectBgUI.qoR = (GridView) settingsSelectBgUI.findViewById(2131827417);
        C41787r.aix().mo10116c(settingsSelectBgUI.qoQ);
        settingsSelectBgUI.qoR.setAdapter(settingsSelectBgUI.qoQ);
        settingsSelectBgUI.qoR.setOnItemClickListener(new C348873());
        AppMethodBeat.m2505o(127486);
    }

    /* renamed from: h */
    static /* synthetic */ void m86374h(int i, List list) {
        AppMethodBeat.m2504i(127489);
        for (C32329j c32329j : list) {
            if (c32329j.fMn == i) {
                C41787r.aix().mo20544cz(c32329j.fMn, 1);
                list.remove(c32329j);
                AppMethodBeat.m2505o(127489);
                return;
            }
        }
        AppMethodBeat.m2505o(127489);
    }
}

package com.tencent.p177mm.plugin.welab.p584ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.welab.C29974a;
import com.tencent.p177mm.plugin.welab.C40361d;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.plugin.welab.p1563e.C46450b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@C18524i
/* renamed from: com.tencent.mm.plugin.welab.ui.WelabMainUI */
public class WelabMainUI extends MMActivity {
    private Comparator<C23169a> uMA = new C79113();
    private OnClickListener uMB = new C79124();
    private boolean uMi = false;
    private LinearLayout uMt;
    private LinearLayout uMu;
    private LinearLayout uMv;
    private LinearLayout uMw;
    private View uMx;
    private View uMy;
    private List<String> uMz;

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabMainUI$1 */
    class C79091 implements OnClickListener {
        C79091() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(80615);
            Intent intent = new Intent();
            intent.putExtra("title", view.getResources().getString(C25738R.string.g0x));
            intent.putExtra("rawUrl", WelabMainUI.this.mController.ylL.getString(C25738R.string.g0s, new Object[]{C4988aa.dor(), Integer.valueOf(C7243d.vxo)}));
            intent.putExtra("showShare", false);
            C25985d.m41467b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(80615);
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabMainUI$2 */
    class C79102 implements OnMenuItemClickListener {
        C79102() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(80616);
            WelabMainUI.this.aqX();
            WelabMainUI.this.finish();
            AppMethodBeat.m2505o(80616);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabMainUI$3 */
    class C79113 implements Comparator<C23169a> {
        C79113() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(80617);
            C23169a c23169a = (C23169a) obj;
            C23169a c23169a2 = (C23169a) obj2;
            if (c23169a == c23169a2) {
                AppMethodBeat.m2505o(80617);
                return 0;
            }
            if (c23169a != null) {
                if (c23169a2 == null) {
                    AppMethodBeat.m2505o(80617);
                    return 1;
                } else if (c23169a.field_Pos == c23169a2.field_Pos) {
                    int ank = C5046bo.ank(c23169a.field_expId);
                    int ank2 = C5046bo.ank(c23169a2.field_expId);
                    if (ank == ank2) {
                        AppMethodBeat.m2505o(80617);
                        return 0;
                    } else if (ank2 > ank) {
                        AppMethodBeat.m2505o(80617);
                        return 1;
                    } else {
                        AppMethodBeat.m2505o(80617);
                        return -1;
                    }
                } else if (c23169a.field_Pos > c23169a2.field_Pos) {
                    AppMethodBeat.m2505o(80617);
                    return 1;
                }
            }
            AppMethodBeat.m2505o(80617);
            return -1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabMainUI$4 */
    class C79124 implements OnClickListener {
        C79124() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(80618);
            Object tag = view.getTag();
            if (tag instanceof C23169a) {
                C23169a c23169a = (C23169a) tag;
                Intent intent = new Intent();
                intent.putExtra("para_appid", c23169a.field_LabsAppId);
                intent.putExtra("para_from_with_red_point", C46450b.ddC().mo74669e(c23169a) ? 1 : 0);
                intent.setClass(WelabMainUI.this, WelabAppInfoUI.class);
                WelabMainUI.this.startActivity(intent);
                C46450b ddC = C46450b.ddC();
                String str = c23169a.field_LabsAppId;
                ddC.uLV.put(str, Integer.valueOf(1));
                ddC.tag += "&" + str + "=1";
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WELAB_REDPOINT_STRING, ddC.tag);
                C46450b.ddD();
                C4990ab.m7416i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(c23169a)));
            }
            AppMethodBeat.m2505o(80618);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WelabMainUI() {
        AppMethodBeat.m2504i(80619);
        AppMethodBeat.m2505o(80619);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(80620);
        super.onCreate(bundle);
        mo17426pO(true);
        dyb();
        if (getIntent() != null) {
            if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
                z = true;
            }
            this.uMi = z;
            this.uMz = getIntent().getStringArrayListExtra("key_exclude_apps");
        }
        initView();
        C46450b.ddC();
        C4996ah.doB().edit().putBoolean("key_has_enter_welab", true).commit();
        C46450b.ddD();
        C40361d.m69201t("", 1, this.uMi);
        AppMethodBeat.m2505o(80620);
    }

    public final int getLayoutId() {
        return 2130971226;
    }

    public final void initView() {
        AppMethodBeat.m2504i(80621);
        setMMTitle((int) C25738R.string.g0u);
        mo17446xE(getResources().getColor(C25738R.color.a68));
        mo17373Nc(getResources().getColor(C25738R.color.f11677d4));
        this.uMt = (LinearLayout) findViewById(2131829209);
        this.uMv = (LinearLayout) findViewById(2131829210);
        this.uMu = (LinearLayout) findViewById(2131829211);
        this.uMw = (LinearLayout) findViewById(2131829212);
        this.uMx = findViewById(2131829213);
        this.uMy = findViewById(2131829208);
        this.uMx.setOnClickListener(new C79091());
        setBackBtn(new C79102());
        AppMethodBeat.m2505o(80621);
    }

    public void onResume() {
        AppMethodBeat.m2504i(80622);
        super.onResume();
        this.uMv.removeAllViews();
        this.uMw.removeAllViews();
        List<C23169a> ddk = C29974a.ddj().ddk();
        if (ddk == null || ddk.isEmpty()) {
            this.uMt.setVisibility(8);
        } else {
            C23169a c23169a;
            Iterator it = ddk.iterator();
            while (it.hasNext()) {
                c23169a = (C23169a) it.next();
                if (!C5046bo.isNullOrNil(c23169a.field_LabsAppId) && this.uMz.contains(c23169a.field_LabsAppId)) {
                    it.remove();
                }
            }
            if (ddk.isEmpty()) {
                this.uMt.setVisibility(8);
            } else {
                this.uMt.setVisibility(0);
                Collections.sort(ddk, this.uMA);
                for (C23169a c23169a2 : ddk) {
                    m14062a(c23169a2, this.uMv);
                }
                C4990ab.m7410d("MicroMsg.WelabMainUI", "get online app count " + this.uMv.getChildCount());
            }
        }
        ddB();
        if (this.uMt.getVisibility() == 0 || this.uMu.getVisibility() == 0) {
            this.uMy.setVisibility(8);
            AppMethodBeat.m2505o(80622);
            return;
        }
        this.uMy.setVisibility(0);
        AppMethodBeat.m2505o(80622);
    }

    public void onPause() {
        AppMethodBeat.m2504i(80623);
        super.onPause();
        AppMethodBeat.m2505o(80623);
    }

    private void ddB() {
        C23169a c23169a;
        AppMethodBeat.m2504i(80624);
        List<C23169a> dds = C29974a.ddj().uLQ.dds();
        Iterator it = dds.iterator();
        while (it.hasNext()) {
            c23169a = (C23169a) it.next();
            if ((System.currentTimeMillis() / 1000) - c23169a.field_endtime >= 2592000 || "labs1de6f3".equals(c23169a.field_LabsAppId)) {
                it.remove();
                C29974a.uLP.uLQ.mo16760a((C4925c) c23169a, new String[0]);
            } else if (c23169a.isExpired() && c23169a.field_Switch != 3) {
                c23169a.field_Switch = 3;
                C29974a.uLP.uLQ.mo10103c(c23169a, new String[0]);
            } else if (c23169a.field_Switch != 3) {
                it.remove();
            }
        }
        C4990ab.m7417i("WelabMgr", "stopped lab %s", dds.toString());
        if (dds.isEmpty()) {
            this.uMu.setVisibility(8);
            AppMethodBeat.m2505o(80624);
            return;
        }
        this.uMu.setVisibility(0);
        Collections.sort(dds, this.uMA);
        for (C23169a c23169a2 : dds) {
            m14062a(c23169a2, this.uMw);
        }
        C4990ab.m7410d("MicroMsg.WelabMainUI", "get online app count " + this.uMw.getChildCount());
        AppMethodBeat.m2505o(80624);
    }

    /* renamed from: a */
    private void m14062a(C23169a c23169a, LinearLayout linearLayout) {
        AppMethodBeat.m2504i(80625);
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(2130971224, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(2131829201);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(2131829200);
        TextView textView = (TextView) linearLayout2.findViewById(2131820678);
        TextView textView2 = (TextView) linearLayout2.findViewById(2131821841);
        if (C46450b.ddC().mo74669e(c23169a)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        C25815a.ahv().mo43766a(c23169a.agR("field_ThumbUrl"), imageView2, C29974a.ddj().udB);
        C29974a.ddj();
        textView.setText(C29974a.m47421a(c23169a));
        textView2.setText(c23169a.agR("field_Desc"));
        linearLayout2.setTag(c23169a);
        linearLayout2.setOnClickListener(this.uMB);
        linearLayout.addView(linearLayout2);
        AppMethodBeat.m2505o(80625);
    }
}

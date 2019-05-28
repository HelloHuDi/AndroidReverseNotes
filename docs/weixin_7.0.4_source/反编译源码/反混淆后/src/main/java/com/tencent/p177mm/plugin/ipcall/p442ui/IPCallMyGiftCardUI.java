package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34370d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.aqk;
import com.tencent.p177mm.protocal.protobuf.crv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI */
public class IPCallMyGiftCardUI extends MMActivity implements C1202f {
    /* renamed from: Ek */
    private View f2911Ek;
    private ProgressDialog gqo;
    private ListView mListView;
    private C12272a nDx;
    private C34370d nDy;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI$3 */
    class C122713 implements OnCancelListener {
        C122713() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22211);
            try {
                if (IPCallMyGiftCardUI.this.nDy != null) {
                    C9638aw.m17182Rg().mo14547c(IPCallMyGiftCardUI.this.nDy);
                }
                IPCallMyGiftCardUI.this.finish();
                AppMethodBeat.m2505o(22211);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", e.getMessage());
                AppMethodBeat.m2505o(22211);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI$a */
    static class C12272a extends BaseAdapter {
        private IPCallMyGiftCardUI nDA = null;
        aqk nDB = null;
        List<crv> ngC = null;

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI$a$a */
        class C12273a {
            TextView nDC;
            TextView nDD;
            TextView nDE;
            CdnImageView nDF;
            ImageView nDG;

            private C12273a() {
            }

            /* synthetic */ C12273a(C12272a c12272a, byte b) {
                this();
            }
        }

        public C12272a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
            AppMethodBeat.m2504i(22212);
            Assert.assertTrue(true);
            this.nDA = iPCallMyGiftCardUI;
            AppMethodBeat.m2505o(22212);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(22213);
            if (this.ngC == null) {
                AppMethodBeat.m2505o(22213);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.m2505o(22213);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(22214);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.m2505o(22214);
                return obj;
            }
            AppMethodBeat.m2505o(22214);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C12273a c12273a;
            AppMethodBeat.m2504i(22215);
            if (view == null) {
                view = ((LayoutInflater) this.nDA.getSystemService("layout_inflater")).inflate(2130969900, viewGroup, false);
                c12273a = new C12273a(this, (byte) 0);
                c12273a.nDC = (TextView) view.findViewById(2131825044);
                c12273a.nDD = (TextView) view.findViewById(2131825045);
                c12273a.nDE = (TextView) view.findViewById(2131825046);
                c12273a.nDF = (CdnImageView) view.findViewById(2131821043);
                c12273a.nDG = (ImageView) view.findViewById(2131825167);
                view.setTag(c12273a);
            } else {
                c12273a = (C12273a) view.getTag();
            }
            crv crv = (crv) getItem(i);
            if (crv == null) {
                AppMethodBeat.m2505o(22215);
            } else {
                if (C5046bo.isNullOrNil(crv.xpv)) {
                    c12273a.nDC.setVisibility(0);
                    c12273a.nDD.setVisibility(0);
                    c12273a.nDE.setVisibility(8);
                    c12273a.nDC.setText(crv.wOs);
                    c12273a.nDD.setText(crv.xpu);
                } else {
                    c12273a.nDC.setVisibility(8);
                    c12273a.nDD.setVisibility(8);
                    c12273a.nDE.setVisibility(0);
                    c12273a.nDE.setText(crv.xpv);
                }
                C40460b.m69433a(c12273a.nDG, "", 0.5f, false);
                if (C5046bo.isNullOrNil(crv.mZW)) {
                    c12273a.nDG.setVisibility(0);
                    c12273a.nDF.setVisibility(4);
                } else {
                    c12273a.nDF.setVisibility(0);
                    c12273a.nDF.setUrl(crv.mZW);
                    c12273a.nDG.setVisibility(4);
                }
                AppMethodBeat.m2505o(22215);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI$2 */
    class C122742 implements OnMenuItemClickListener {
        C122742() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22210);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", IPCallMyGiftCardUI.this.getString(C25738R.string.cgo));
            intent.putExtra("showShare", false);
            C25985d.m41467b(IPCallMyGiftCardUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(22210);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI$1 */
    class C122751 implements OnMenuItemClickListener {
        C122751() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22209);
            IPCallMyGiftCardUI.this.finish();
            AppMethodBeat.m2505o(22209);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22216);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_PTU_YOUJIALI, (C1202f) this);
        setMMTitle((int) C25738R.string.cix);
        setBackBtn(new C122751());
        addTextOptionMenu(0, this.mController.ylL.getString(C25738R.string.civ), new C122742());
        this.f2911Ek = findViewById(2131825169);
        this.mListView = (ListView) findViewById(2131825168);
        this.nDx = new C12272a(this);
        this.mListView.setAdapter(this.nDx);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b(context, getString(C25738R.string.ch0), true, new C122713());
        this.nDy = new C34370d();
        C9638aw.m17182Rg().mo14541a(this.nDy, 0);
        AppMethodBeat.m2505o(22216);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22217);
        super.onResume();
        AppMethodBeat.m2505o(22217);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22218);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_PTU_YOUJIALI, (C1202f) this);
        AppMethodBeat.m2505o(22218);
    }

    public final int getLayoutId() {
        return 2130969901;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22219);
        C4990ab.m7417i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i2), str);
        if (c1207m instanceof C34370d) {
            if (i == 0 && i2 == 0) {
                aqk aqk = ((C34370d) c1207m).nym;
                if (this.gqo != null && this.gqo.isShowing()) {
                    this.gqo.dismiss();
                }
                this.nDx.ngC = aqk.wuj;
                this.nDx.nDB = aqk;
                this.nDx.notifyDataSetChanged();
                if (aqk.wuj.size() == 0) {
                    this.f2911Ek.setVisibility(0);
                }
                AppMethodBeat.m2505o(22219);
                return;
            }
            if (this.gqo != null && this.gqo.isShowing()) {
                this.gqo.dismiss();
            }
            this.f2911Ek.setVisibility(0);
            Toast.makeText(this.mController.ylL, getString(C25738R.string.cgx), 0).show();
        }
        AppMethodBeat.m2505o(22219);
    }
}

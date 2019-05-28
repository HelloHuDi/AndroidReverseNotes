package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.cj.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;
import java.util.Map;

@i
public class BrandServiceIndexUI extends MMActivity implements a {
    private int fmr = 251658241;
    private TextView jLE = null;
    private BrandServiceSortView jLF;
    private boolean jLG = false;
    private boolean jLH = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.hl;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13919);
        super.onCreate(bundle);
        this.fmr = getIntent().getIntExtra("intent_service_type", 251658241);
        this.jLH = s.hr(getIntent().getIntExtra("list_attr", 0), 16384);
        initView();
        z.aeR().c(this);
        AppMethodBeat.o(13919);
    }

    public void onResume() {
        AppMethodBeat.i(13920);
        if (this.jLG) {
            this.jLG = false;
            this.jLF.refresh();
        }
        super.onResume();
        c.aNX();
        enableOptionMenu(1, true);
        AppMethodBeat.o(13920);
    }

    public void onPause() {
        AppMethodBeat.i(13921);
        g.RQ();
        g.RP().Ry().set(233474, Long.valueOf(System.currentTimeMillis()));
        g.RQ();
        g.RP().Ry().set(233473, Long.valueOf(System.currentTimeMillis()));
        g.RQ();
        g.RP().Ry().set(233476, Long.valueOf(System.currentTimeMillis()));
        super.onPause();
        AppMethodBeat.o(13921);
    }

    public void onDestroy() {
        AppMethodBeat.i(13922);
        if (g.RK()) {
            this.jLF.release();
            z.aeR().d(this);
        }
        super.onDestroy();
        AppMethodBeat.o(13922);
    }

    public final void initView() {
        AppMethodBeat.i(13923);
        setMMTitle((int) R.string.ef);
        this.jLF = (BrandServiceSortView) findViewById(R.id.a9i);
        this.jLF.setShowFooterView(true);
        this.jLF.setReturnResult(this.jLH);
        this.jLE = (TextView) findViewById(R.id.a9h);
        this.jLE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        this.jLE.setVisibility(8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13915);
                BrandServiceIndexUI.this.finish();
                AppMethodBeat.o(13915);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.ewn, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13916);
                ab.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
                Intent intent = new Intent(BrandServiceIndexUI.this, BrandServiceLocalSearchUI.class);
                intent.putExtra("is_return_result", BrandServiceIndexUI.this.jLH);
                intent.addFlags(67108864);
                BrandServiceIndexUI.this.startActivityForResult(intent, 1);
                AppMethodBeat.o(13916);
                return true;
            }
        });
        addIconOptionMenu(1, R.string.fs, R.raw.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13918);
                if (aa.HU(0)) {
                    ((m) g.K(m.class)).a(ah.getContext(), new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(13917);
                            Intent cVd = aa.cVd();
                            cVd.putExtra("KRightBtn", true);
                            cVd.putExtra("ftsneedkeyboard", true);
                            cVd.putExtra("key_load_js_without_delay", true);
                            cVd.putExtra("ftsType", 1);
                            cVd.putExtra("ftsbizscene", 6);
                            Map d = aa.d(6, true, 0);
                            String HP = aa.HP(bo.ank((String) d.get("scene")));
                            d.put("sessionId", HP);
                            d.put("subSessionId", HP);
                            cVd.putExtra("sessionId", HP);
                            cVd.putExtra("rawUrl", aa.E(d));
                            d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd);
                            AppMethodBeat.o(13917);
                        }
                    });
                } else {
                    ab.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
                }
                BrandServiceIndexUI.this.enableOptionMenu(1, false);
                AppMethodBeat.o(13918);
                return true;
            }
        });
        AppMethodBeat.o(13923);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13924);
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && this.jLH) {
            setResult(-1, intent);
            finish();
        }
        AppMethodBeat.o(13924);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(13925);
        ab.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", str);
        this.jLG = true;
        AppMethodBeat.o(13925);
    }
}

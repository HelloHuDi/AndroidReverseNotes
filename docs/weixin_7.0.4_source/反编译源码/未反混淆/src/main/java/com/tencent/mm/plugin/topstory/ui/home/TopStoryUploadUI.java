package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q.b;

public class TopStoryUploadUI extends MMActivity implements f {
    public static c sCQ;
    private String appVersion;
    private String businessType;
    private String csB;
    private String desc;
    private String extInfo;
    private TextView nDX;
    private long rCN = 0;
    private String sCR;
    private String sCS;
    private ImageView sCT;
    private TextView sCU;
    private TextView sCV;
    private TextView sCW;
    private SnsEditText sCX;
    private TextView sCY;
    private boolean sCZ = false;
    private String thumbUrl;
    protected p tipDialog = null;
    private String title;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(1695);
        topStoryUploadUI.exit();
        AppMethodBeat.o(1695);
    }

    static /* synthetic */ void b(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(1696);
        topStoryUploadUI.cFK();
        AppMethodBeat.o(1696);
    }

    static /* synthetic */ void i(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(1698);
        topStoryUploadUI.cFI();
        AppMethodBeat.o(1698);
    }

    static {
        AppMethodBeat.i(1699);
        a aVar = new a();
        aVar.ePH = true;
        aVar.ePG = true;
        aVar.eQf = false;
        aVar.ePT = R.color.rn;
        sCQ = aVar.ahG();
        AppMethodBeat.o(1699);
    }

    public final int getLayoutId() {
        return R.layout.b0m;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1685);
        ab.i("micromsg.topstory.TopStoryUploadUI", "onCreate");
        super.onCreate(bundle);
        setMMTitle((int) R.string.gah);
        a(0, getString(R.string.tf), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(1683);
                if (TopStoryUploadUI.this.isFinishing()) {
                    AppMethodBeat.o(1683);
                    return false;
                } else if (System.currentTimeMillis() - TopStoryUploadUI.this.rCN < 500) {
                    AppMethodBeat.o(1683);
                    return false;
                } else {
                    h.pYm.e(17080, Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.this.csB);
                    TopStoryUploadUI.this.rCN = System.currentTimeMillis();
                    String obj = TopStoryUploadUI.this.sCX.getText().toString();
                    if (obj.length() > 200) {
                        com.tencent.mm.ui.base.h.b(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(R.string.eqg), "", true);
                        AppMethodBeat.o(1683);
                        return true;
                    } else if (TopStoryUploadUI.bBL()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String cFJ = TopStoryUploadUI.cFJ();
                        com.tencent.mm.pluginsdk.model.app.f bT = g.bT(TopStoryUploadUI.this.csB, true);
                        TopStoryUploadUI.this.a(currentTimeMillis, TopStoryUploadUI.this.extInfo, obj, cFJ, bT, TopStoryUploadUI.this.appVersion);
                        AppMethodBeat.o(1683);
                        return true;
                    } else {
                        com.tencent.mm.ui.base.h.b(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(R.string.bx9), "", true);
                        e.pXa.a(1032, 1, 1, false);
                        AppMethodBeat.o(1683);
                        return true;
                    }
                }
            }
        }, b.YELLOW);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(1680);
                TopStoryUploadUI.a(TopStoryUploadUI.this);
                AppMethodBeat.o(1680);
                return true;
            }
        });
        com.tencent.mm.kernel.g.Rg().a(2534, (f) this);
        this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
        this.csB = getIntent().getStringExtra("KEY_APPID");
        this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
        this.title = getIntent().getStringExtra("KEY_TITLE");
        this.desc = getIntent().getStringExtra("KEY_DESC");
        this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
        this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
        this.sCR = getIntent().getStringExtra("KEY_MEDIANAME");
        this.sCS = getIntent().getStringExtra("KEY_MEDIAHEADURL");
        this.sCT = (ImageView) findViewById(R.id.eyu);
        this.sCU = (TextView) findViewById(R.id.eyv);
        this.sCV = (TextView) findViewById(R.id.c63);
        this.sCX = (SnsEditText) findViewById(R.id.ewo);
        this.sCY = (TextView) findViewById(R.id.eyy);
        this.nDX = (TextView) findViewById(R.id.eyx);
        this.sCW = (TextView) findViewById(R.id.eyw);
        this.sCU.setText(this.title);
        this.sCV.setText(this.sCR);
        o.ahp().a(this.thumbUrl, this.sCT, sCQ, new com.tencent.mm.at.a.c.g() {
            public final void sH(String str) {
            }

            public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                AppMethodBeat.i(1681);
                if (bVar == null || bVar.bitmap == null || bVar.bitmap.isRecycled()) {
                    ab.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
                    AppMethodBeat.o(1681);
                } else if (bo.isNullOrNil(str)) {
                    ab.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
                    AppMethodBeat.o(1681);
                } else if (view instanceof ImageView) {
                    if (bVar.bitmap.getWidth() < bVar.bitmap.getHeight()) {
                        ((ImageView) view).setScaleType(ScaleType.FIT_CENTER);
                    } else {
                        ((ImageView) view).setScaleType(ScaleType.CENTER_CROP);
                    }
                    AppMethodBeat.o(1681);
                } else {
                    ab.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
                    AppMethodBeat.o(1681);
                }
                return null;
            }

            public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
            }
        });
        this.sCY.setText(String.format("<a href='%s'>%s</a>", new Object[]{"https://search.weixin.qq.com/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect", getString(R.string.gaf)}));
        j.h(this.sCY, 1);
        cFK();
        this.sCX.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(1682);
                TopStoryUploadUI.b(TopStoryUploadUI.this);
                TopStoryUploadUI.c(TopStoryUploadUI.this);
                AppMethodBeat.o(1682);
            }
        });
        h.pYm.e(17080, Integer.valueOf(6), Integer.valueOf(1), this.csB);
        AppMethodBeat.o(1685);
    }

    protected static boolean bBL() {
        AppMethodBeat.i(1686);
        if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.RM().Rn()).SG()) {
            int acS = com.tencent.mm.kernel.g.Rg().acS();
            if (acS == 4 || acS == 6) {
                AppMethodBeat.o(1686);
                return true;
            }
            AppMethodBeat.o(1686);
            return false;
        }
        Object obj;
        if (at.isConnected(ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.o(1686);
            return true;
        }
        AppMethodBeat.o(1686);
        return false;
    }

    private void exit() {
        AppMethodBeat.i(1687);
        h.pYm.e(17080, Integer.valueOf(3), Integer.valueOf(2), this.csB);
        if (this.sCX.getText().toString().length() > 0) {
            com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.gad, 0, (int) R.string.up, (int) R.string.s2, true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(1684);
                    TopStoryUploadUI.i(TopStoryUploadUI.this);
                    AppMethodBeat.o(1684);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, (int) R.color.hi);
            AppMethodBeat.o(1687);
            return;
        }
        cFI();
        AppMethodBeat.o(1687);
    }

    private void cFI() {
        AppMethodBeat.i(1688);
        i.c(this.businessType, "", this.csB, 0, "");
        finish();
        this.sCZ = true;
        AppMethodBeat.o(1688);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(1689);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        boolean z = i == 0 && i2 == 0;
        if (z) {
            if (mVar instanceof com.tencent.mm.plugin.topstory.a.c.g) {
                BaseResponse baseResponse = ((tj) ((com.tencent.mm.plugin.topstory.a.c.g) mVar).ehh.fsH.fsP).BaseResponse;
                if (baseResponse.Ret == 0) {
                    cFI();
                    AppMethodBeat.o(1689);
                    return;
                } else if (baseResponse.ErrMsg == null || bo.isNullOrNil(baseResponse.ErrMsg.wVI)) {
                    com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.gag), getString(R.string.gae), true);
                } else {
                    com.tencent.mm.ui.base.h.b((Context) this, baseResponse.ErrMsg.wVI, getString(R.string.gae), true);
                }
            }
        } else if (bo.isNullOrNil(str)) {
            com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.ex8), getString(R.string.gae), true);
        } else {
            com.tencent.mm.ui.base.h.b((Context) this, str, getString(R.string.gae), true);
        }
        e.pXa.a(1032, 2, 1, false);
        AppMethodBeat.o(1689);
    }

    public static String cFJ() {
        AppMethodBeat.i(1690);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.RN();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.a.p.getString(com.tencent.mm.kernel.a.QF())).append("_").append(System.currentTimeMillis()).toString();
        AppMethodBeat.o(1690);
        return stringBuilder2;
    }

    public final int a(long j, String str, String str2, String str3, com.tencent.mm.pluginsdk.model.app.f fVar, String str4) {
        AppMethodBeat.i(1691);
        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.plugin.topstory.a.c.g(j, str, str2, str3, fVar, str4), 0);
        getString(R.string.tz);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.gai), false, null);
        AppMethodBeat.o(1691);
        return 0;
    }

    public void onDestroy() {
        AppMethodBeat.i(1692);
        ab.i("micromsg.topstory.TopStoryUploadUI", "onDestroy");
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.kernel.g.Rg().b(2534, (f) this);
        if (!this.sCZ) {
            h.pYm.e(17080, Integer.valueOf(3), Integer.valueOf(2), this.csB);
        }
        AppMethodBeat.o(1692);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(1693);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            exit();
            AppMethodBeat.o(1693);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(1693);
        return dispatchKeyEvent;
    }

    private void cFK() {
        AppMethodBeat.i(1694);
        int length = this.sCX.getText().toString().length();
        if (length < 180) {
            this.nDX.setVisibility(8);
            this.sCW.setVisibility(8);
            AppMethodBeat.o(1694);
            return;
        }
        int color;
        this.nDX.setVisibility(0);
        this.sCW.setVisibility(0);
        if (length <= 200) {
            color = getResources().getColor(R.color.a3k);
        } else {
            color = getResources().getColor(R.color.xy);
        }
        this.nDX.setText(String.valueOf(length));
        this.nDX.setTextColor(color);
        AppMethodBeat.o(1694);
    }

    static /* synthetic */ void c(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.i(1697);
        if (topStoryUploadUI.sCX.getText().toString().length() <= 200) {
            topStoryUploadUI.enableOptionMenu(0, true);
            AppMethodBeat.o(1697);
            return;
        }
        topStoryUploadUI.enableOptionMenu(0, false);
        AppMethodBeat.o(1697);
    }
}

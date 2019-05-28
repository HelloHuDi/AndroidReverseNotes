package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SettingsTrustFriendUI extends MMActivity implements f {
    private static int qpn = 5;
    private View jyC;
    private p lRg;
    private GridView mPe;
    private TextView nml;
    private boolean qnu;
    private List<String> qpl;
    private a qpm;

    class a extends BaseAdapter {

        class a {
            TextView jAJ;
            ImageView qgZ;
            ImageView qpr;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(SettingsTrustFriendUI settingsTrustFriendUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(127544);
            int size = SettingsTrustFriendUI.this.qpl.size();
            if (!SettingsTrustFriendUI.this.qnu) {
                size = size == 0 ? 1 : (size <= 0 || size >= SettingsTrustFriendUI.qpn) ? size >= SettingsTrustFriendUI.qpn ? size + 1 : 0 : size + 2;
            }
            AppMethodBeat.o(127544);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(127545);
            if (getItemViewType(i) == 0) {
                Object obj = SettingsTrustFriendUI.this.qpl.get(i);
                AppMethodBeat.o(127545);
                return obj;
            }
            AppMethodBeat.o(127545);
            return null;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(127546);
            int size = SettingsTrustFriendUI.this.qpl.size();
            if (SettingsTrustFriendUI.this.qnu || i < size) {
                AppMethodBeat.o(127546);
                return 0;
            } else if (size == 0) {
                AppMethodBeat.o(127546);
                return 1;
            } else if (size >= SettingsTrustFriendUI.qpn) {
                AppMethodBeat.o(127546);
                return 2;
            } else if (i == size) {
                AppMethodBeat.o(127546);
                return 1;
            } else if (i == size + 1) {
                AppMethodBeat.o(127546);
                return 2;
            } else {
                AppMethodBeat.o(127546);
                return -1;
            }
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(127547);
            if (view == null) {
                view = SettingsTrustFriendUI.this.getLayoutInflater().inflate(R.layout.as5, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.eam);
                ImageView imageView2 = (ImageView) view.findViewById(R.id.ean);
                TextView textView = (TextView) view.findViewById(R.id.eao);
                a aVar2 = new a(this, (byte) 0);
                aVar2.qgZ = imageView;
                aVar2.qpr = imageView2;
                aVar2.jAJ = textView;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                String str = (String) SettingsTrustFriendUI.this.qpl.get(i);
                ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                aVar.qgZ.setScaleType(ScaleType.FIT_XY);
                b.b(aVar.qgZ, str);
                aVar.jAJ.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SettingsTrustFriendUI.this, aoO.Oj(), aVar.jAJ.getTextSize()));
                if (SettingsTrustFriendUI.this.qnu) {
                    aVar.qpr.setVisibility(0);
                } else {
                    aVar.qpr.setVisibility(8);
                }
            } else {
                aVar.jAJ.setVisibility(4);
                aVar.qpr.setVisibility(8);
                aVar.qgZ.setScaleType(ScaleType.FIT_XY);
                if (getItemViewType(i) == 1) {
                    aVar.qgZ.setImageResource(R.drawable.e4);
                } else if (getItemViewType(i) == 2) {
                    aVar.qgZ.setImageResource(R.drawable.e5);
                }
            }
            AppMethodBeat.o(127547);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void g(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.i(127557);
        settingsTrustFriendUI.cjh();
        AppMethodBeat.o(127557);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127548);
        super.onCreate(bundle);
        String str = (String) g.RP().Ry().get(352277, null);
        if (!bo.isNullOrNil(str)) {
            this.qpl = bo.P(str.split(","));
        }
        if (this.qpl == null) {
            this.qpl = new ArrayList();
        }
        this.mController.contentView.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(127532);
                SettingsTrustFriendUI.a(SettingsTrustFriendUI.this);
                AppMethodBeat.o(127532);
            }
        });
        initView();
        AppMethodBeat.o(127548);
    }

    public final int getLayoutId() {
        return R.layout.as4;
    }

    public void onStart() {
        AppMethodBeat.i(127549);
        super.onStart();
        g.Rg().a(869, (f) this);
        g.Rg().a(583, (f) this);
        AppMethodBeat.o(127549);
    }

    public void onStop() {
        AppMethodBeat.i(127550);
        super.onStop();
        g.Rg().b(869, (f) this);
        g.Rg().b(583, (f) this);
        AppMethodBeat.o(127550);
    }

    public final void initView() {
        AppMethodBeat.i(127551);
        setMMTitle((int) R.string.ec0);
        this.mPe = (GridView) findViewById(R.id.eal);
        this.qpm = new a(this, (byte) 0);
        this.mPe.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ly));
        this.mPe.setNumColumns(-1);
        this.mPe.setStretchMode(1);
        this.mPe.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.a2u) * 2);
        this.mPe.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.a2v));
        this.mPe.setAdapter(this.qpm);
        ((ViewGroup) this.mPe.getParent()).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127537);
                if (SettingsTrustFriendUI.this.qnu) {
                    SettingsTrustFriendUI.this.qnu = false;
                    SettingsTrustFriendUI.this.qpm.notifyDataSetChanged();
                }
                AppMethodBeat.o(127537);
            }
        });
        this.mPe.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(127538);
                if (SettingsTrustFriendUI.this.qnu && motionEvent.getAction() == 1 && SettingsTrustFriendUI.this.mPe.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) == -1) {
                    SettingsTrustFriendUI.this.qnu = false;
                    SettingsTrustFriendUI.this.qpm.notifyDataSetChanged();
                    AppMethodBeat.o(127538);
                    return true;
                }
                AppMethodBeat.o(127538);
                return false;
            }
        });
        this.mPe.setHorizontalScrollBarEnabled(false);
        this.mPe.setVerticalScrollBarEnabled(false);
        this.mPe.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(127539);
                if (SettingsTrustFriendUI.this.qpm.getItemViewType(i) == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("list_type", 12);
                    intent.putExtra("titile", SettingsTrustFriendUI.this.getString(R.string.eu));
                    intent.putExtra("scene", 2);
                    intent.putExtra("max_limit_num", SettingsTrustFriendUI.qpn);
                    intent.putExtra("stay_in_wechat", true);
                    intent.putExtra("already_select_contact", bo.c(SettingsTrustFriendUI.this.qpl, ","));
                    intent.putExtra("block_contact", r.Yz());
                    intent.putExtra("list_attr", s.hs(s.znK, 256));
                    intent.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(R.string.ec2, new Object[]{Integer.valueOf(SettingsTrustFriendUI.qpn)}));
                    d.b(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", intent, 1);
                    AppMethodBeat.o(127539);
                    return;
                }
                if (SettingsTrustFriendUI.this.qpm.getItemViewType(i) == 2) {
                    if (!SettingsTrustFriendUI.this.qnu) {
                        SettingsTrustFriendUI.this.qnu = true;
                    }
                    AppMethodBeat.o(127539);
                }
                if (SettingsTrustFriendUI.this.qpm.getItemViewType(i) == 0 && SettingsTrustFriendUI.this.qnu) {
                    SettingsTrustFriendUI.this.qpl.remove(SettingsTrustFriendUI.this.qpm.getItem(i));
                    if (SettingsTrustFriendUI.this.qpl.size() == 0) {
                        SettingsTrustFriendUI.this.qnu = false;
                    }
                }
                AppMethodBeat.o(127539);
                SettingsTrustFriendUI.this.qpm.notifyDataSetChanged();
                AppMethodBeat.o(127539);
            }
        });
        this.nml = (TextView) findViewById(R.id.eaj);
        String stringExtra = getIntent().getStringExtra(e.j.ygc);
        if (bo.isNullOrNil(stringExtra)) {
            this.nml.setText(getResources().getString(R.string.ec4, new Object[]{Integer.valueOf(3)}));
        } else {
            this.nml.setText(stringExtra);
        }
        this.jyC = findViewById(R.id.eah);
        this.jyC.setVisibility(8);
        ((TextView) this.jyC.findViewById(R.id.eai)).setText(getString(R.string.ec3, new Object[]{Integer.valueOf(3)}));
        this.jyC.findViewById(R.id.au3).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127540);
                SettingsTrustFriendUI.this.jyC.setVisibility(8);
                AppMethodBeat.o(127540);
            }
        });
        findViewById(R.id.eak).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127541);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
                d.b(SettingsTrustFriendUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(127541);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127542);
                SettingsTrustFriendUI.g(SettingsTrustFriendUI.this);
                AppMethodBeat.o(127542);
                return true;
            }
        });
        a(1, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127543);
                SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
                AppMethodBeat.o(127543);
                return true;
            }
        }, q.b.GREEN);
        showOptionMenu(true);
        AppMethodBeat.o(127551);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127552);
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bo.isNullOrNil(stringExtra)) {
                this.qpl.clear();
                this.qpl.addAll(bo.P(stringExtra.split(",")));
                this.qpm.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(127552);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127553);
        ab.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.lRg != null) {
            this.lRg.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 869) {
                int i3;
                apd apd = (apd) ((com.tencent.mm.ai.b) mVar.ftl).fsH.fsP;
                qpn = apd.wte;
                LinkedList<ciu> linkedList = apd.vET;
                if (linkedList.size() != this.qpl.size()) {
                    i3 = 1;
                    break;
                } else if (linkedList.size() == 0) {
                    i3 = 0;
                } else {
                    for (ciu ciu : linkedList) {
                        if (!this.qpl.contains(ciu.jBB)) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.qpl.clear();
                    for (ciu ciu2 : linkedList) {
                        this.qpl.add(ciu2.jBB);
                    }
                    this.qpm.notifyDataSetChanged();
                }
                if (this.qpl.size() > 0 && this.qpl.size() < 3) {
                    this.jyC.setVisibility(0);
                }
                g.RP().Ry().set(352277, bo.c(this.qpl, ","));
                AppMethodBeat.o(127553);
                return;
            } else if (mVar.getType() == 583) {
                g.RP().Ry().set(352277, bo.c(this.qpl, ","));
                finish();
                AppMethodBeat.o(127553);
                return;
            }
        } else if (!bo.isNullOrNil(str)) {
            h.bQ(this, str);
        }
        AppMethodBeat.o(127553);
    }

    private void cjh() {
        List P;
        AppMethodBeat.i(127554);
        String str = (String) g.RP().Ry().get(352277, null);
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str)) {
            Object P2 = arrayList;
        } else {
            P2 = bo.P(str.split(","));
        }
        if (this.qpl.size() == P2.size() && this.qpl.containsAll(P2)) {
            finish();
            AppMethodBeat.o(127554);
            return;
        }
        h.a((Context) this, getString(R.string.dwy), getString(R.string.tz), getString(R.string.tc), getString(R.string.s3), true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(127534);
                SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
                AppMethodBeat.o(127534);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(127535);
                SettingsTrustFriendUI.this.finish();
                AppMethodBeat.o(127535);
            }
        });
        AppMethodBeat.o(127554);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127555);
        if (i == 4) {
            cjh();
            AppMethodBeat.o(127555);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(127555);
        return onKeyUp;
    }

    static /* synthetic */ void a(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.i(127556);
        final m eVar = new com.tencent.mm.plugin.setting.model.e();
        g.Rg().a(eVar, 0);
        settingsTrustFriendUI.getString(R.string.pl);
        settingsTrustFriendUI.lRg = h.b((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127536);
                g.Rg().c(eVar);
                AppMethodBeat.o(127536);
            }
        });
        AppMethodBeat.o(127556);
    }

    static /* synthetic */ void h(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.i(127558);
        if (settingsTrustFriendUI.qpl.size() <= 0 || settingsTrustFriendUI.qpl.size() >= 3) {
            final m bVar = new com.tencent.mm.plugin.setting.model.b(settingsTrustFriendUI.qpl);
            g.Rg().a(bVar, 0);
            if (settingsTrustFriendUI.lRg != null) {
                settingsTrustFriendUI.lRg.dismiss();
            }
            settingsTrustFriendUI.getString(R.string.pl);
            settingsTrustFriendUI.lRg = h.b((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(R.string.th), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(127533);
                    g.Rg().c(bVar);
                    AppMethodBeat.o(127533);
                }
            });
            AppMethodBeat.o(127558);
            return;
        }
        h.b((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(R.string.ec3, new Object[]{Integer.valueOf(3)}), settingsTrustFriendUI.getString(R.string.tz), true);
        AppMethodBeat.o(127558);
    }
}

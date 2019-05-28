package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SettingsManageAuthUI extends MMActivity implements f {
    private ListView mListView;
    private View mtk;
    private ProgressDialog nEK;
    private byte[] qjF;
    private a qns;
    private List<cmb> qnt = new ArrayList();
    private boolean qnu;

    class a extends BaseAdapter {
        List<cmb> qnw;

        class a {
            Button gzI;
            TextView iPD;
            TextView qnA;
            TextView qnB;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(SettingsManageAuthUI settingsManageAuthUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(127257);
            cmb Cm = Cm(i);
            AppMethodBeat.o(127257);
            return Cm;
        }

        public final int getCount() {
            AppMethodBeat.i(127254);
            if (this.qnw == null || this.qnw.isEmpty()) {
                AppMethodBeat.o(127254);
                return 0;
            }
            int size = this.qnw.size();
            AppMethodBeat.o(127254);
            return size;
        }

        public final cmb Cm(int i) {
            AppMethodBeat.i(127255);
            if (i < 0 || i >= getCount()) {
                AppMethodBeat.o(127255);
                return null;
            }
            cmb cmb = (cmb) this.qnw.get(i);
            AppMethodBeat.o(127255);
            return cmb;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(127256);
            if (view == null) {
                view = SettingsManageAuthUI.this.getLayoutInflater().inflate(R.layout.arq, null);
                a aVar2 = new a(this, (byte) 0);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.iPD = (TextView) view.findViewById(R.id.e9w);
            aVar.qnA = (TextView) view.findViewById(R.id.e9x);
            aVar.qnB = (TextView) view.findViewById(R.id.e9y);
            aVar.gzI = (Button) view.findViewById(R.id.e9z);
            aVar.gzI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(127253);
                    if (a.this.Cm(i) != null) {
                        final m cVar = new c(a.this.Cm(i).csB, 1);
                        if (SettingsManageAuthUI.this.nEK != null) {
                            SettingsManageAuthUI.this.nEK.dismiss();
                        }
                        g.Rg().a(cVar, 0);
                        SettingsManageAuthUI.this.nEK = h.b(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(R.string.th), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(127252);
                                g.Rg().c(cVar);
                                AppMethodBeat.o(127252);
                            }
                        });
                    }
                    AppMethodBeat.o(127253);
                }
            });
            if (SettingsManageAuthUI.this.qnu) {
                aVar.gzI.setVisibility(0);
            } else {
                aVar.gzI.setVisibility(8);
            }
            if (Cm(i) != null) {
                aVar.iPD.setText(Cm(i).fhH);
                aVar.qnA.setText(Cm(i).xjO);
                aVar.qnB.setText(SettingsManageAuthUI.cX(Cm(i).xjN));
            }
            AppMethodBeat.o(127256);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsManageAuthUI() {
        AppMethodBeat.i(127258);
        AppMethodBeat.o(127258);
    }

    static /* synthetic */ void bh(byte[] bArr) {
        AppMethodBeat.i(127266);
        bg(bArr);
        AppMethodBeat.o(127266);
    }

    static /* synthetic */ void e(SettingsManageAuthUI settingsManageAuthUI) {
        AppMethodBeat.i(127267);
        settingsManageAuthUI.ciQ();
        AppMethodBeat.o(127267);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127259);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127259);
    }

    public final void initView() {
        AppMethodBeat.i(127260);
        this.mListView = (ListView) findViewById(R.id.e_6);
        this.mtk = findViewById(R.id.e_7);
        this.qns = new a(this, (byte) 0);
        this.mListView.setAdapter(this.qns);
        this.mListView.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(127246);
                if (i + i2 == i3) {
                    ab.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
                    if (SettingsManageAuthUI.this.qjF != null) {
                        SettingsManageAuthUI.bh(SettingsManageAuthUI.this.qjF);
                        SettingsManageAuthUI.this.qjF = null;
                    }
                }
                AppMethodBeat.o(127246);
            }
        });
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(127247);
                if (!SettingsManageAuthUI.this.qnu) {
                    cmb Cm = SettingsManageAuthUI.this.qns.Cm(i);
                    if (Cm != null) {
                        Intent intent = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
                        UserAuthItemParcelable[] userAuthItemParcelableArr = (UserAuthItemParcelable[]) UserAuthItemParcelable.CREATOR.newArray(Cm.xjN.size());
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= Cm.xjN.size()) {
                                break;
                            }
                            cmc cmc = (cmc) Cm.xjN.get(i3);
                            UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
                            userAuthItemParcelable.scope = cmc.scope;
                            userAuthItemParcelable.qkh = cmc.qkh;
                            userAuthItemParcelable.state = cmc.state;
                            userAuthItemParcelable.qki = cmc.qki;
                            userAuthItemParcelableArr[i3] = userAuthItemParcelable;
                            i2 = i3 + 1;
                        }
                        intent.putExtra("app_id", Cm.csB);
                        intent.putExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, Cm.fhH);
                        intent.putExtra("modify_scene", 1);
                        intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                        SettingsManageAuthUI.this.startActivity(intent);
                    }
                }
                AppMethodBeat.o(127247);
            }
        });
        ciQ();
        setMMTitle((int) R.string.e5p);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127248);
                SettingsManageAuthUI.this.finish();
                AppMethodBeat.o(127248);
                return true;
            }
        });
        AppMethodBeat.o(127260);
    }

    public void onResume() {
        AppMethodBeat.i(127262);
        super.onResume();
        g.Rg().a(1146, (f) this);
        g.Rg().a(1127, (f) this);
        bg(null);
        AppMethodBeat.o(127262);
    }

    public void onPause() {
        AppMethodBeat.i(127263);
        super.onPause();
        g.Rg().b(1146, (f) this);
        g.Rg().b(1127, (f) this);
        AppMethodBeat.o(127263);
    }

    public final int getLayoutId() {
        return R.layout.art;
    }

    private static void bg(byte[] bArr) {
        AppMethodBeat.i(127264);
        g.Rg().a(new com.tencent.mm.plugin.setting.model.f(bArr), 0);
        AppMethodBeat.o(127264);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127265);
        ab.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.nEK != null) {
            this.nEK.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.bQ(this, str);
        } else if (mVar.getType() == 1146) {
            byte[] bArr;
            int i3;
            Collection collection;
            com.tencent.mm.plugin.setting.model.f fVar = (com.tencent.mm.plugin.setting.model.f) mVar;
            if (fVar.qjE == null || fVar.qjE.wtv != 1) {
                bArr = null;
            } else {
                bArr = fVar.qjE.wtt.toByteArray();
            }
            this.qjF = bArr;
            if (((com.tencent.mm.plugin.setting.model.f) mVar).qjF != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qnt.clear();
            }
            List list = this.qnt;
            com.tencent.mm.plugin.setting.model.f fVar2 = (com.tencent.mm.plugin.setting.model.f) mVar;
            if (fVar2.qjE != null) {
                collection = fVar2.qjE.wtu;
            } else {
                collection = Collections.emptyList();
            }
            list.addAll(collection);
            this.qns.qnw = this.qnt;
            this.qns.notifyDataSetChanged();
            ciQ();
            AppMethodBeat.o(127265);
            return;
        } else if (mVar.getType() == 1127) {
            String str2 = ((c) mVar).appId;
            if (!bo.isNullOrNil(str2)) {
                if (!this.qnt.isEmpty()) {
                    Iterator it = this.qnt.iterator();
                    while (it.hasNext()) {
                        if (((cmb) it.next()).csB.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qns.notifyDataSetChanged();
            }
            AppMethodBeat.o(127265);
            return;
        }
        AppMethodBeat.o(127265);
    }

    private void ciQ() {
        AppMethodBeat.i(127261);
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(800, R.raw.actionbar_search_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127249);
                SettingsManageAuthUI.this.startActivity(new Intent(SettingsManageAuthUI.this, SettingsSearchAuthUI.class));
                b.hK(SettingsManageAuthUI.this);
                AppMethodBeat.o(127249);
                return true;
            }
        });
        if (this.qnt.isEmpty()) {
            this.mtk.setVisibility(0);
            AppMethodBeat.o(127261);
            return;
        }
        this.mtk.setVisibility(8);
        if (this.qnu) {
            addTextOptionMenu(700, getString(R.string.qt), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(127250);
                    if (menuItem.getItemId() == 700) {
                        SettingsManageAuthUI.this.qnu = false;
                        SettingsManageAuthUI.this.qns.notifyDataSetChanged();
                        SettingsManageAuthUI.e(SettingsManageAuthUI.this);
                    }
                    AppMethodBeat.o(127250);
                    return true;
                }
            });
            AppMethodBeat.o(127261);
            return;
        }
        addTextOptionMenu(700, getString(R.string.rh), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127251);
                if (menuItem.getItemId() == 700) {
                    SettingsManageAuthUI.this.qnu = true;
                    SettingsManageAuthUI.this.qns.notifyDataSetChanged();
                    SettingsManageAuthUI.e(SettingsManageAuthUI.this);
                }
                AppMethodBeat.o(127251);
                return true;
            }
        });
        AppMethodBeat.o(127261);
    }

    static /* synthetic */ String cX(List list) {
        AppMethodBeat.i(127268);
        StringBuilder stringBuilder = new StringBuilder();
        for (cmc cmc : list) {
            stringBuilder.append(cmc.qkh);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(127268);
        return stringBuilder2;
    }
}

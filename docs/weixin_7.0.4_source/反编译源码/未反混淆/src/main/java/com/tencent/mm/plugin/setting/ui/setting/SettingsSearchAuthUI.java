package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
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
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.model.i;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SettingsSearchAuthUI extends MMActivity implements f {
    private ListView mListView;
    private ProgressDialog nEK;
    private byte[] qjF;
    private boolean qnu;
    private com.tencent.mm.plugin.fts.ui.widget.a qoG;
    private View qoH;
    private TextView qoI;
    private TextView qoJ;
    private List<cmb> qoK = new ArrayList();
    private a qoL;

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

        /* synthetic */ a(SettingsSearchAuthUI settingsSearchAuthUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(127455);
            cmb Cm = Cm(i);
            AppMethodBeat.o(127455);
            return Cm;
        }

        public final int getCount() {
            AppMethodBeat.i(127452);
            if (this.qnw == null || this.qnw.isEmpty()) {
                AppMethodBeat.o(127452);
                return 0;
            }
            int size = this.qnw.size();
            AppMethodBeat.o(127452);
            return size;
        }

        public final cmb Cm(int i) {
            AppMethodBeat.i(127453);
            if (i < 0 || i >= getCount()) {
                AppMethodBeat.o(127453);
                return null;
            }
            cmb cmb = (cmb) this.qnw.get(i);
            AppMethodBeat.o(127453);
            return cmb;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(127454);
            if (view == null) {
                view = SettingsSearchAuthUI.this.getLayoutInflater().inflate(R.layout.arq, null);
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
                    AppMethodBeat.i(127451);
                    if (a.this.Cm(i) != null) {
                        final m cVar = new c(a.this.Cm(i).csB, 2);
                        if (SettingsSearchAuthUI.this.nEK != null) {
                            SettingsSearchAuthUI.this.nEK.dismiss();
                        }
                        g.Rg().a(cVar, 0);
                        SettingsSearchAuthUI.this.nEK = h.b(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(R.string.th), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(127450);
                                g.Rg().c(cVar);
                                AppMethodBeat.o(127450);
                            }
                        });
                    }
                    AppMethodBeat.o(127451);
                }
            });
            if (SettingsSearchAuthUI.this.qnu) {
                aVar.gzI.setVisibility(0);
            } else {
                aVar.gzI.setVisibility(8);
            }
            if (Cm(i) != null) {
                aVar.iPD.setText(Cm(i).fhH);
                aVar.qnA.setText(Cm(i).xjO);
                aVar.qnB.setText(SettingsSearchAuthUI.cY(Cm(i).xjN));
            }
            AppMethodBeat.o(127454);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsSearchAuthUI() {
        AppMethodBeat.i(127456);
        AppMethodBeat.o(127456);
    }

    static /* synthetic */ void e(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.i(127466);
        settingsSearchAuthUI.ciQ();
        AppMethodBeat.o(127466);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127457);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127457);
    }

    public final void initView() {
        AppMethodBeat.i(127458);
        this.qoG = new com.tencent.mm.plugin.fts.ui.widget.a(this);
        this.mListView = (ListView) findViewById(R.id.e_6);
        this.qoL = new a(this, (byte) 0);
        this.mListView.setAdapter(this.qoL);
        this.qoH = findViewById(R.id.e_p);
        this.qoI = (TextView) findViewById(R.id.e_q);
        this.qoJ = (TextView) findViewById(R.id.e_r);
        ciQ();
        getSupportActionBar().setCustomView(this.qoG);
        this.qoG.setSearchViewListener(new com.tencent.mm.plugin.fts.ui.widget.a.a() {
            public final void onClickBackBtn(View view) {
                AppMethodBeat.i(127438);
                ab.i("MicroMsg.SettingsSearchAuthUI", "click search back");
                SettingsSearchAuthUI.this.finish();
                AppMethodBeat.o(127438);
            }
        });
        this.qoG.getFtsEditText().setFtsEditTextListener(new com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a() {
            public final void bAR() {
            }

            public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
                AppMethodBeat.i(127439);
                ab.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", str);
                if (bo.isNullOrNil(str)) {
                    SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
                    AppMethodBeat.o(127439);
                    return;
                }
                SettingsSearchAuthUI.a(SettingsSearchAuthUI.this);
                String string = SettingsSearchAuthUI.this.getString(R.string.te);
                k kVar = new k(string + " " + str.trim());
                kVar.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(R.color.hi)), string.length(), kVar.length(), 33);
                SettingsSearchAuthUI.this.qoI.setText(kVar);
                AppMethodBeat.o(127439);
            }

            public final void hz(boolean z) {
                AppMethodBeat.i(127440);
                ab.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", Boolean.valueOf(z));
                if (z) {
                    SettingsSearchAuthUI.this.showVKB();
                    AppMethodBeat.o(127440);
                    return;
                }
                SettingsSearchAuthUI.this.aqX();
                AppMethodBeat.o(127440);
            }

            public final void onClickClearTextBtn(View view) {
                AppMethodBeat.i(127441);
                ab.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
                SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
                AppMethodBeat.o(127441);
            }

            public final boolean aMo() {
                AppMethodBeat.i(127442);
                ab.i("MicroMsg.SettingsSearchAuthUI", "search key down");
                Editable text = SettingsSearchAuthUI.this.qoG.getFtsEditText().getEditText().getText();
                SettingsSearchAuthUI.this.qoI.setVisibility(8);
                SettingsSearchAuthUI.this.qoG.getFtsEditText().getEditText().clearFocus();
                SettingsSearchAuthUI.this.aqX();
                SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
                if (!bo.ac(text)) {
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, text.toString().trim());
                }
                AppMethodBeat.o(127442);
                return true;
            }
        });
        this.qoI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127443);
                Editable text = SettingsSearchAuthUI.this.qoG.getFtsEditText().getEditText().getText();
                if (!bo.ac(text)) {
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, text.toString().trim());
                }
                AppMethodBeat.o(127443);
            }
        });
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(127444);
                if (!SettingsSearchAuthUI.this.qnu) {
                    cmb Cm = SettingsSearchAuthUI.this.qoL.Cm(i);
                    if (Cm != null) {
                        Intent intent = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
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
                        intent.putExtra("modify_scene", 2);
                        intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                        SettingsSearchAuthUI.this.startActivity(intent);
                    }
                }
                AppMethodBeat.o(127444);
            }
        });
        this.mListView.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(127445);
                if (i + i2 == i3) {
                    ab.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
                    if (SettingsSearchAuthUI.this.qjF != null) {
                        SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.qjF);
                        SettingsSearchAuthUI.this.qjF = null;
                    }
                }
                AppMethodBeat.o(127445);
            }
        });
        AppMethodBeat.o(127458);
    }

    public void onResume() {
        AppMethodBeat.i(127459);
        super.onResume();
        g.Rg().a(1169, (f) this);
        g.Rg().a(1127, (f) this);
        AppMethodBeat.o(127459);
    }

    public void onPause() {
        AppMethodBeat.i(127460);
        super.onPause();
        g.Rg().b(1169, (f) this);
        g.Rg().b(1127, (f) this);
        AppMethodBeat.o(127460);
    }

    public void finish() {
        AppMethodBeat.i(127462);
        super.finish();
        overridePendingTransition(R.anim.c9, R.anim.s);
        AppMethodBeat.o(127462);
    }

    public final int getLayoutId() {
        return R.layout.arz;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127463);
        ab.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.nEK != null) {
            this.nEK.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.bQ(this, str);
        } else if (mVar.getType() == 1169) {
            byte[] bArr;
            int i3;
            Collection collection;
            i iVar = (i) mVar;
            if (iVar.qjI == null || iVar.qjI.wtv != 1) {
                bArr = null;
            } else {
                bArr = iVar.qjI.wtt.toByteArray();
            }
            this.qjF = bArr;
            if (((i) mVar).qjF != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qoK.clear();
            }
            List list = this.qoK;
            i iVar2 = (i) mVar;
            if (iVar2.qjI != null) {
                collection = iVar2.qjI.wtu;
            } else {
                collection = Collections.emptyList();
            }
            list.addAll(collection);
            if (this.qoK.isEmpty()) {
                this.qoH.setVisibility(0);
                this.qoI.setVisibility(8);
                this.qoJ.setVisibility(0);
                this.mListView.setVisibility(8);
                this.qoK.clear();
                ciQ();
                AppMethodBeat.o(127463);
                return;
            }
            this.qoL.qnw = this.qoK;
            this.qoL.notifyDataSetChanged();
            this.qoH.setVisibility(8);
            this.mListView.setVisibility(0);
            ciQ();
            AppMethodBeat.o(127463);
            return;
        } else if (mVar.getType() == 1127) {
            String str2 = ((c) mVar).appId;
            if (!bo.isNullOrNil(str2)) {
                if (!this.qoK.isEmpty()) {
                    Iterator it = this.qoK.iterator();
                    while (it.hasNext()) {
                        if (((cmb) it.next()).csB.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qoL.notifyDataSetChanged();
            }
            AppMethodBeat.o(127463);
            return;
        }
        AppMethodBeat.o(127463);
    }

    private void ciQ() {
        AppMethodBeat.i(127461);
        this.mController.removeAllOptionMenu();
        if (!this.qoK.isEmpty()) {
            if (this.qnu) {
                addTextOptionMenu(700, getString(R.string.qt), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(127446);
                        if (menuItem.getItemId() == 700) {
                            SettingsSearchAuthUI.this.qnu = false;
                            SettingsSearchAuthUI.this.qoL.notifyDataSetChanged();
                            SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
                        }
                        AppMethodBeat.o(127446);
                        return true;
                    }
                });
                AppMethodBeat.o(127461);
                return;
            }
            addTextOptionMenu(700, getString(R.string.rh), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(127447);
                    if (menuItem.getItemId() == 700) {
                        SettingsSearchAuthUI.this.qnu = true;
                        SettingsSearchAuthUI.this.qoL.notifyDataSetChanged();
                        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
                    }
                    AppMethodBeat.o(127447);
                    return true;
                }
            });
        }
        AppMethodBeat.o(127461);
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.i(127464);
        settingsSearchAuthUI.qoH.setVisibility(0);
        settingsSearchAuthUI.qoI.setVisibility(0);
        settingsSearchAuthUI.qoJ.setVisibility(8);
        settingsSearchAuthUI.mListView.setVisibility(8);
        settingsSearchAuthUI.qoK.clear();
        settingsSearchAuthUI.ciQ();
        AppMethodBeat.o(127464);
    }

    static /* synthetic */ void c(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.i(127465);
        settingsSearchAuthUI.qoH.setVisibility(8);
        settingsSearchAuthUI.qoI.setText("");
        settingsSearchAuthUI.qoK.clear();
        settingsSearchAuthUI.mListView.setVisibility(8);
        settingsSearchAuthUI.ciQ();
        AppMethodBeat.o(127465);
    }

    static /* synthetic */ String cY(List list) {
        AppMethodBeat.i(127469);
        StringBuilder stringBuilder = new StringBuilder();
        for (cmc cmc : list) {
            stringBuilder.append(cmc.qkh);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(127469);
        return stringBuilder2;
    }
}
